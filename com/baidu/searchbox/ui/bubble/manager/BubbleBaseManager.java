package com.baidu.searchbox.ui.bubble.manager;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ui.bubble.BubbleHistory;
import com.baidu.searchbox.ui.bubble.BubbleLocationManager;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.views.BubbleBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public abstract class BubbleBaseManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BubbleBaseManager";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAutoDismiss;
    public int mAutoDismissInterval;
    public BubbleHandler mBubbleHandler;
    public boolean mEnableAnchorClk;
    public boolean mEnableAnimation;
    public boolean mEnableBgClk;
    public boolean mEnableClkDismiss;
    public boolean mIsShowing;
    public BubbleLocationManager mLocation;
    public ObjectAnimator mObjectAnimator;
    public BubbleManager.OnAnchorClickListener mOnAnchorClickListener;
    public BubbleManager.OnBubbleEventListener mOnBubbleEventListener;
    public BubbleBaseView mViews;

    /* loaded from: classes7.dex */
    public static class BubbleHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public static final int MSG_DISMISS = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<BubbleBaseManager> mBubbleManager;

        public BubbleHandler(BubbleBaseManager bubbleBaseManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleBaseManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBubbleManager = new WeakReference<>(bubbleBaseManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BubbleBaseManager bubbleBaseManager;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0 && (bubbleBaseManager = this.mBubbleManager.get()) != null) {
                bubbleBaseManager.dismissBubble();
            }
        }
    }

    public BubbleBaseManager(BubbleBaseView bubbleBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleBaseView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAutoDismiss = true;
        this.mAutoDismissInterval = 7000;
        this.mEnableClkDismiss = true;
        this.mLocation = new BubbleLocationManager();
        this.mViews = bubbleBaseView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animation(View view, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            ObjectAnimator objectAnimator = this.mObjectAnimator;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.mObjectAnimator.cancel();
            }
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, f2, f3), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, f4, f5)).setDuration(180L);
            this.mObjectAnimator = duration;
            duration.start();
        }
    }

    private void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            BubbleHistory.getInstance().trackBubbleOpHistory("——>show");
            initViewIfNeed();
            if (this.mEnableBgClk) {
                this.mViews.safeAddBGView();
            }
            if (this.mEnableAnchorClk) {
                this.mViews.safeAddAnchorView();
                this.mViews.resetAnchorParams();
            }
            this.mViews.safeAddBubbleView();
            if (!this.mEnableClkDismiss) {
                this.mViews.initLinkBubble();
            }
            onShow();
            this.mViews.postAnchorView(new Runnable(this) { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BubbleBaseManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                        BubbleBaseManager bubbleBaseManager = this.this$0;
                        BubblePosition detectShowPosition = bubbleBaseManager.mLocation.detectShowPosition(bubbleBaseManager.mViews);
                        if (detectShowPosition == BubblePosition.INVALID) {
                            this.this$0.mViews.removemBubbleView();
                            BubbleHistory.getInstance().trackBubbleOpHistory("——>show: remove bubble view end");
                            BubbleBaseManager bubbleBaseManager2 = this.this$0;
                            if (bubbleBaseManager2.mEnableBgClk) {
                                bubbleBaseManager2.mViews.removeBGView();
                                BubbleHistory.getInstance().trackBubbleOpHistory("——>show: remove bg view end");
                            }
                            BubbleBaseManager bubbleBaseManager3 = this.this$0;
                            if (bubbleBaseManager3.mEnableAnchorClk) {
                                bubbleBaseManager3.mViews.removeAnchorView();
                                BubbleHistory.getInstance().trackBubbleOpHistory("——>show: remove anchorlayer view end");
                                return;
                            }
                            return;
                        }
                        this.this$0.mViews.showArrowView(detectShowPosition);
                        this.this$0.showBubbleView(detectShowPosition);
                    }
                }
            });
        }
    }

    public void dismissBubble() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mIsShowing) {
            UiThreadUtil.getMainHandler().post(new Runnable(this) { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BubbleBaseManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                        this.this$0.realDismissBubble();
                    }
                }
            });
        }
    }

    public void enableAnchorClk(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mEnableAnchorClk = z;
        }
    }

    public void enableAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mEnableAnimation = z;
        }
    }

    public void enableBgClk(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mEnableBgClk = z;
        }
    }

    public void enableClkDismiss(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mEnableClkDismiss = z;
        }
    }

    public BubbleLocationManager getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLocation : (BubbleLocationManager) invokeV.objValue;
    }

    public BubbleManager.OnBubbleEventListener getOnBubbleEventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOnBubbleEventListener : (BubbleManager.OnBubbleEventListener) invokeV.objValue;
    }

    public abstract BubbleBaseView getViews();

    public void initViewIfNeed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.mViews.initViewIfNeed()) {
            this.mBubbleHandler = new BubbleHandler(this);
            this.mViews.setBubbleClick(new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BubbleBaseManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.onClickCore(view);
                    }
                }
            });
            this.mViews.setBGClick(new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BubbleBaseManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.onClickCore(view);
                    }
                }
            });
            this.mViews.setAnchorClick(new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BubbleBaseManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.onClickCore(view);
                        BubbleManager.OnAnchorClickListener onAnchorClickListener = this.this$0.mOnAnchorClickListener;
                        if (onAnchorClickListener != null) {
                            onAnchorClickListener.onAnchorClick();
                        }
                    }
                }
            });
        }
    }

    public boolean isDismissed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !this.mIsShowing : invokeV.booleanValue;
    }

    public void onClickCore(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            BubbleManager.OnBubbleEventListener onBubbleEventListener = this.mOnBubbleEventListener;
            if (onBubbleEventListener != null) {
                onBubbleEventListener.onBubbleClick();
            }
            if (this.mEnableClkDismiss) {
                dismissBubble();
            }
        }
    }

    public abstract void onShow();

    public void realDismissBubble() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.mIsShowing) {
            ObjectAnimator objectAnimator = this.mObjectAnimator;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.mObjectAnimator.cancel();
            }
            if (this.mEnableBgClk) {
                this.mViews.removeBGView();
                BubbleHistory.getInstance().trackBubbleOpHistory("——>dismiss BgView end");
            }
            if (this.mEnableAnchorClk) {
                this.mViews.removeAnchorView();
                BubbleHistory.getInstance().trackBubbleOpHistory("——>dismiss anchorLayer end");
            }
            this.mViews.removemBubbleView();
            BubbleHistory.getInstance().trackBubbleOpHistory("——>dismiss BubbleView end");
            this.mIsShowing = false;
            BubbleHandler bubbleHandler = this.mBubbleHandler;
            if (bubbleHandler != null) {
                bubbleHandler.removeMessages(0);
            }
            BubbleManager.OnBubbleEventListener onBubbleEventListener = this.mOnBubbleEventListener;
            if (onBubbleEventListener != null) {
                onBubbleEventListener.onBubbleDismiss();
            }
            resetAll();
        }
    }

    public void resetAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            BubbleBaseView bubbleBaseView = this.mViews;
            if (bubbleBaseView != null) {
                bubbleBaseView.resetAll();
                this.mViews = null;
            }
            this.mOnBubbleEventListener = null;
            this.mBubbleHandler = null;
            this.mObjectAnimator = null;
        }
    }

    public void setAutoDismiss(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mAutoDismiss = z;
        }
    }

    public void setAutoDismissInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 <= 0) {
                this.mAutoDismissInterval = 7000;
            } else {
                this.mAutoDismissInterval = i2;
            }
        }
    }

    public void setOffsetOfArrow(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.mLocation.mOffsetOfArrow = f2;
        }
    }

    public void setOnAnchorEventListener(BubbleManager.OnAnchorClickListener onAnchorClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onAnchorClickListener) == null) {
            this.mOnAnchorClickListener = onAnchorClickListener;
        }
    }

    public void setOnBubbleEventListener(BubbleManager.OnBubbleEventListener onBubbleEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onBubbleEventListener) == null) {
            this.mOnBubbleEventListener = onBubbleEventListener;
        }
    }

    public void showBubble() {
        BubbleBaseView bubbleBaseView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (bubbleBaseView = this.mViews) == null || bubbleBaseView.mAnchorView == null || TextUtils.isEmpty(bubbleBaseView.getAnchorViewName()) || !this.mViews.isValidate() || !isDismissed()) {
            return;
        }
        show();
    }

    public void showBubbleView(BubblePosition bubblePosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bubblePosition) == null) {
            this.mViews.postAnchorView(new Runnable(this, bubblePosition) { // from class: com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BubbleBaseManager this$0;
                public final /* synthetic */ BubblePosition val$position;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bubblePosition};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$position = bubblePosition;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BubbleBaseManager bubbleBaseManager = this.this$0;
                        int[] showPosition = bubbleBaseManager.mLocation.getShowPosition(this.val$position, bubbleBaseManager.mViews);
                        this.this$0.mViews.showBubbleOnLocation(showPosition);
                        BubbleBaseManager bubbleBaseManager2 = this.this$0;
                        if (bubbleBaseManager2.mEnableAnimation) {
                            int dp2px = DeviceUtil.ScreenInfo.dp2px(null, bubbleBaseManager2.mLocation.mBetweenPadding + 11.0f);
                            BubblePosition bubblePosition2 = this.val$position;
                            if (bubblePosition2 != BubblePosition.UP && bubblePosition2 != BubblePosition.DOWN) {
                                if (bubblePosition2 == BubblePosition.RIGHT || bubblePosition2 == BubblePosition.LEFT) {
                                    int i2 = this.val$position == BubblePosition.LEFT ? showPosition[0] + dp2px : showPosition[0] - dp2px;
                                    BubbleBaseManager bubbleBaseManager3 = this.this$0;
                                    bubbleBaseManager3.animation(bubbleBaseManager3.mViews.mBubbleView, i2, showPosition[0], showPosition[1], showPosition[1]);
                                }
                            } else {
                                int i3 = this.val$position == BubblePosition.UP ? showPosition[1] + dp2px : showPosition[1] - dp2px;
                                BubbleBaseManager bubbleBaseManager4 = this.this$0;
                                bubbleBaseManager4.animation(bubbleBaseManager4.mViews.mBubbleView, showPosition[0], showPosition[0], i3, showPosition[1]);
                            }
                        }
                        BubbleBaseManager bubbleBaseManager5 = this.this$0;
                        if (bubbleBaseManager5.mEnableAnchorClk) {
                            bubbleBaseManager5.mViews.showAnchorLayer();
                        }
                        BubbleBaseManager bubbleBaseManager6 = this.this$0;
                        bubbleBaseManager6.mIsShowing = true;
                        if (bubbleBaseManager6.mAutoDismiss) {
                            bubbleBaseManager6.mBubbleHandler.sendEmptyMessageDelayed(0, bubbleBaseManager6.mAutoDismissInterval);
                        }
                        BubbleManager.OnBubbleEventListener onBubbleEventListener = this.this$0.mOnBubbleEventListener;
                        if (onBubbleEventListener != null) {
                            onBubbleEventListener.onBubbleShow();
                        }
                    }
                }
            });
        }
    }
}
