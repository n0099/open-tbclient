package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.utils.SoftInputUtil;
import com.baidu.spswitch.utils.UIUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class PopupEmotionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANCHOR_Y_OFFSET_DP = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup mContainerView;
    public Context mCtx;
    public LinkedList<DelayedTask> mDelayedTaskQueue;
    public Animation mEnterAnimation;
    public Animation mExitAnimation;
    public boolean mIsPostRunning;
    public boolean mIsShowing;
    public ShowParam mLastShowParam;
    public Handler mMainHandler;
    public PopupEmotionView mPopupEmotionView;
    public IShowListener mShowListener;
    public int mXpos;
    public int mYpos;

    /* loaded from: classes2.dex */
    public static class DelayedTask {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TASK_TYPE_DISMISS = 2;
        public static final int TASK_TYPE_DISMISS_WITHOUT_ANIM = 3;
        public static final int TASK_TYPE_SHOW = 0;
        public static final int TASK_TYPE_SHOW_WITHOUT_ANIM = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public Object extra;
        public int taskType;

        public DelayedTask(int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.taskType = i;
            this.extra = obj;
        }
    }

    /* loaded from: classes2.dex */
    public interface IShowListener {
        void show(int i, String str, int i2, int i3);
    }

    /* loaded from: classes2.dex */
    public static class ShowParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int anchorWidth;
        public int anchorXpos;
        public int anchorYpos;
        public boolean enableShowAnim;
        public Bitmap exprBitmap;
        public int exprCol;
        public String exprName;
        public int exprRow;
        public int sectionType;

        public ShowParam() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.enableShowAnim = true;
        }

        public static boolean validate(ShowParam showParam) {
            InterceptResult invokeL;
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, showParam)) == null) ? (showParam == null || TextUtils.isEmpty(showParam.exprName) || (bitmap = showParam.exprBitmap) == null || bitmap.isRecycled() || showParam.anchorWidth <= 0) ? false : true : invokeL.booleanValue;
        }

        public boolean isDuplicate(ShowParam showParam) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, showParam)) == null) ? showParam != null && TextUtils.equals(showParam.exprName, this.exprName) && showParam.anchorXpos == this.anchorXpos && showParam.anchorYpos == this.anchorYpos : invokeL.booleanValue;
        }
    }

    public PopupEmotionManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mDelayedTaskQueue = new LinkedList<>();
        this.mCtx = context;
        this.mContainerView = SoftInputUtil.getContentView();
    }

    private void calculatePos(ShowParam showParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, showParam) == null) {
            this.mPopupEmotionView.measure(0, 0);
            this.mXpos = (showParam.anchorXpos - (this.mPopupEmotionView.getMeasuredWidth() / 2)) + (showParam.anchorWidth / 2);
            this.mYpos = ((showParam.anchorYpos + ((int) UIUtils.dp2px(this.mCtx, 2.0f))) - this.mPopupEmotionView.getMeasuredHeight()) - UIUtils.getStatusBarHeightEx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mIsPostRunning = true;
            this.mMainHandler.post(new Runnable(this) { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PopupEmotionManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.this$0.mPopupEmotionView != null && this.this$0.mPopupEmotionView.getParent() != null && (this.this$0.mPopupEmotionView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) this.this$0.mPopupEmotionView.getParent()).removeView(this.this$0.mPopupEmotionView);
                        }
                        this.this$0.mIsShowing = false;
                        this.this$0.mIsPostRunning = false;
                        this.this$0.mLastShowParam = null;
                        this.this$0.runDelayedTaskIfNecessary();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runDelayedTaskIfNecessary() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.mDelayedTaskQueue.isEmpty() || this.mDelayedTaskQueue.peek() == null) {
            return;
        }
        DelayedTask poll = this.mDelayedTaskQueue.poll();
        int i = poll.taskType;
        if (i == 0) {
            show((ShowParam) poll.extra);
        } else if (i == 1) {
            show((ShowParam) poll.extra);
        } else if (i == 2) {
            dismiss();
        } else if (i == 3) {
            dismissWithoutAnim();
        }
    }

    public void dismiss() {
        PopupEmotionView popupEmotionView;
        Animation animation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupEmotionView = this.mPopupEmotionView) == null || (animation = this.mExitAnimation) == null) {
            return;
        }
        if (this.mIsPostRunning) {
            this.mDelayedTaskQueue.add(new DelayedTask(2, null));
            return;
        }
        popupEmotionView.setAnimation(animation);
        this.mExitAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PopupEmotionManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation2) == null) {
                    this.this$0.dismissInternal();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation2) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation2) == null) {
                }
            }
        });
        this.mPopupEmotionView.startAnimation(this.mExitAnimation);
        this.mIsPostRunning = true;
    }

    public void dismissWithoutAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mIsPostRunning) {
                this.mDelayedTaskQueue.add(new DelayedTask(3, null));
            } else {
                dismissInternal();
            }
        }
    }

    public boolean isPostRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsPostRunning : invokeV.booleanValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsShowing : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mDelayedTaskQueue.clear();
            this.mIsPostRunning = false;
            this.mIsShowing = false;
            this.mLastShowParam = null;
            PopupEmotionView popupEmotionView = this.mPopupEmotionView;
            if (popupEmotionView == null || popupEmotionView.getParent() == null || !(this.mPopupEmotionView.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) this.mPopupEmotionView.getParent()).removeView(this.mPopupEmotionView);
        }
    }

    public void setShowListener(IShowListener iShowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iShowListener) == null) {
            this.mShowListener = iShowListener;
        }
    }

    public void show(ShowParam showParam) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, showParam) == null) || this.mContainerView == null || !ShowParam.validate(showParam) || showParam.isDuplicate(this.mLastShowParam)) {
            return;
        }
        if (this.mIsPostRunning) {
            this.mDelayedTaskQueue.add(new DelayedTask(0, showParam));
        } else if (this.mIsShowing) {
            showParam.enableShowAnim = false;
            this.mDelayedTaskQueue.add(new DelayedTask(0, showParam));
            dismissWithoutAnim();
        } else {
            this.mLastShowParam = showParam;
            if (this.mPopupEmotionView == null) {
                this.mPopupEmotionView = new PopupEmotionView(this.mCtx);
                this.mEnterAnimation = AnimationUtils.loadAnimation(this.mCtx, R.anim.obfuscated_res_0x7f010062);
                this.mExitAnimation = AnimationUtils.loadAnimation(this.mCtx, R.anim.obfuscated_res_0x7f010065);
            }
            this.mPopupEmotionView.configView(showParam.exprName, showParam.exprBitmap);
            calculatePos(showParam);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.mXpos;
            layoutParams.topMargin = this.mYpos;
            this.mContainerView.addView(this.mPopupEmotionView, layoutParams);
            if (showParam.enableShowAnim) {
                this.mPopupEmotionView.setAnimation(this.mEnterAnimation);
                this.mEnterAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PopupEmotionManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                            this.this$0.mIsPostRunning = false;
                            this.this$0.mIsShowing = true;
                            this.this$0.mMainHandler.post(new Runnable(this) { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$1.this$0.runDelayedTaskIfNecessary();
                                    }
                                }
                            });
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                            this.this$0.mPopupEmotionView.setVisibility(0);
                        }
                    }
                });
                this.mPopupEmotionView.startAnimation(this.mEnterAnimation);
                this.mIsPostRunning = true;
            } else {
                this.mIsPostRunning = false;
                this.mIsShowing = true;
                this.mMainHandler.post(new Runnable(this) { // from class: com.baidu.spswitch.emotion.view.PopupEmotionManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PopupEmotionManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.runDelayedTaskIfNecessary();
                        }
                    }
                });
            }
            IShowListener iShowListener = this.mShowListener;
            if (iShowListener != null) {
                iShowListener.show(showParam.sectionType, showParam.exprName, showParam.exprRow, showParam.exprCol);
            }
        }
    }
}
