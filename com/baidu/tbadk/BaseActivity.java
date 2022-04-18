package com.baidu.tbadk;

import android.animation.Animator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.BuoyComponent;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.ConfigChangeMessage;
import com.baidu.tbadk.core.message.KeyBoardSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.GuidPageView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import com.repackage.aj4;
import com.repackage.au4;
import com.repackage.bd5;
import com.repackage.cr4;
import com.repackage.dj4;
import com.repackage.eq8;
import com.repackage.er4;
import com.repackage.g45;
import com.repackage.h45;
import com.repackage.h55;
import com.repackage.ir4;
import com.repackage.ng;
import com.repackage.o55;
import com.repackage.oi;
import com.repackage.p55;
import com.repackage.p75;
import com.repackage.pg;
import com.repackage.qd5;
import com.repackage.qm4;
import com.repackage.rg;
import com.repackage.s75;
import com.repackage.sm4;
import com.repackage.t75;
import com.repackage.u75;
import com.repackage.v75;
import com.repackage.vm4;
import com.repackage.vt4;
import com.repackage.w75;
import com.repackage.xo;
import com.repackage.xt4;
import com.repackage.y75;
import com.repackage.yc5;
import com.repackage.z75;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class BaseActivity<T> extends BdBaseActivity<T> implements TbPageContextSupport, v75, IVideoNeedPreload, aj4, Object, s75 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    public static final int SHOW_SOFT_KEYBOARD_DELAY = 150;
    public static int flog = 1;
    public static Class<? extends TbPageContext> mClazz4GetPageContext;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Animatable> animatableList;
    public List<WeakReference<View>> animationList;
    public CustomToast customToast;
    public List<Dialog> dialogList;
    public boolean isAddSwipeBackLayout;
    public boolean isForceInterceptStimeStat;
    public boolean isInterceptStimeStat;
    public long lastResumeTime;
    public final Animator.AnimatorListener loadViewAnimListener;
    public View loadingRootView;
    public g45 loadingView;
    public int mAboveKeyboardHeight;
    public BuoyComponent mBuoyTaskComponent;
    public ir4 mClickableTextToast;
    public PermissionJudgePolicy mCurrentPermissionJudgePolicy;
    public final GuidPageView mGuidPage;
    public boolean mIsHasScreenShotListener;
    public boolean mIsLogin;
    public au4 mKeyboardAdjust;
    public int mLastOrientation;
    public int mLastScreenHeight;
    public int mLastScreenWidth;
    public boolean mLayoutHasInit;
    public qm4 mLayoutInflateFactory;
    public sm4 mLayoutMode;
    public er4 mListMenu;
    public int mMaxHeight;
    public vm4 mPermissionCallback;
    public int mPreHeight;
    public ContinuousAnimationView mProgressBar;
    public h45 mRefreshView;
    public final Handler mSafeHandler;
    public yc5 mScreenShotListenManager;
    public int mSkinType;
    public SwipeBackLayout mSwipeBackLayout;
    public p75 mTbPageExtra;
    public TbPageTag mTbPageTag;
    public boolean mUseStyleImmersiveSticky;
    public xt4 mWaitingDialog;
    public BaseActivity<T>.NetRefreshListener netRefreshListener;
    public final CustomMessageListener nightResourcesChangeListener;
    public TbPageContext<T> pageContext;
    public y75 pageStayDurationItem;
    public List<PopupWindow> popupWindowList;
    public ng resourcesWrapper;
    public Runnable setNoTranslucentRunnable;
    public final CustomMessageListener skinTypeChangeListener;

    /* loaded from: classes2.dex */
    public class DelayRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View mView;
        public final /* synthetic */ BaseActivity this$0;

        public DelayRunnable(BaseActivity baseActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseActivity;
            this.mView = null;
            this.mView = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.this$0.isFinishing()) {
                return;
            }
            this.this$0.ShowSoftKeyPad((InputMethodManager) this.this$0.getSystemService("input_method"), this.mView);
        }
    }

    /* loaded from: classes2.dex */
    public abstract class LoadDataCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity this$0;

        public LoadDataCallBack(BaseActivity baseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseActivity;
        }

        public abstract void callback(Object... objArr);

        public void onProgressUpdate(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class NetRefreshListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity this$0;

        public NetRefreshListener(BaseActivity baseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.this$0.onNetRefreshButtonClicked();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(79739768, "Lcom/baidu/tbadk/BaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(79739768, "Lcom/baidu/tbadk/BaseActivity;");
                return;
            }
        }
        mClazz4GetPageContext = MainAPKActivityPageContext.class;
    }

    public BaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mWaitingDialog = null;
        this.mListMenu = null;
        this.mSafeHandler = new Handler();
        this.mSkinType = 3;
        this.mGuidPage = null;
        this.mLastScreenWidth = 0;
        this.mLastScreenHeight = 0;
        this.mLastOrientation = 1;
        this.mIsHasScreenShotListener = false;
        this.isInterceptStimeStat = false;
        this.isForceInterceptStimeStat = false;
        this.mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
        this.mIsLogin = false;
        this.mKeyboardAdjust = null;
        this.isAddSwipeBackLayout = true;
        this.mLayoutHasInit = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mAboveKeyboardHeight = 0;
        this.mCurrentPermissionJudgePolicy = null;
        this.loadViewAnimListener = new Animator.AnimatorListener(this) { // from class: com.baidu.tbadk.BaseActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    this.this$0.mProgressBar.setSpeed(1.0f);
                    this.this$0.mProgressBar.setMinAndMaxFrame(45, 105);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                }
            }
        };
        this.setNoTranslucentRunnable = new Runnable(this) { // from class: com.baidu.tbadk.BaseActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.isFinishing()) {
                    return;
                }
                bd5.a(this.this$0);
            }
        };
        this.nightResourcesChangeListener = new CustomMessageListener(this, 2005017) { // from class: com.baidu.tbadk.BaseActivity.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005017 || this.this$0.mLayoutMode == null) {
                    return;
                }
                this.this$0.mLayoutMode.l(null);
                this.this$0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        };
        this.skinTypeChangeListener = new CustomMessageListener(this, 2001304) { // from class: com.baidu.tbadk.BaseActivity.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    this.this$0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    boolean z = true;
                    if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        z = false;
                    }
                    UtilHelper.changeStatusBarIconAndTextColor(z, this.this$0);
                }
            }
        };
    }

    private void adjustResizeForSoftInputOnDestory() {
        au4 au4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (au4Var = this.mKeyboardAdjust) == null) {
            return;
        }
        au4Var.i();
        this.mKeyboardAdjust = null;
    }

    private String getCurrentExtraPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            String currentPageKey = getCurrentPageKey();
            return TextUtils.isEmpty(currentPageKey) ? getClass().getSimpleName() : currentPageKey;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            try {
                return findViewById(16908290);
            } catch (Exception unused) {
                return null;
            }
        }
        return (View) invokeV.objValue;
    }

    private void hideClickableTextToast() {
        ir4 ir4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (ir4Var = this.mClickableTextToast) == null) {
            return;
        }
        ir4Var.e();
    }

    public static void setmClazz4GetPageContext(Class<? extends TbPageContext> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, cls) == null) {
            mClazz4GetPageContext = cls;
        }
    }

    private void startScreenShotListen() {
        yc5 yc5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || !PermissionUtil.isAgreePrivacyPolicy() || this.mIsHasScreenShotListener || (yc5Var = this.mScreenShotListenManager) == null) {
            return;
        }
        yc5Var.i(new yc5.b(this) { // from class: com.baidu.tbadk.BaseActivity.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseActivity this$0;

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

            @Override // com.repackage.yc5.b
            public void onShot(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    if (this.this$0.getCurrentPageKey() != "a001" && this.this$0.getCurrentPageKey() != "a005" && this.this$0.getCurrentPageKey() != "a006") {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 4));
                    }
                    this.this$0.onScreenShot(str);
                }
            }
        });
        this.mScreenShotListenManager.j();
        this.mIsHasScreenShotListener = true;
    }

    private void stopScreenShotListen() {
        yc5 yc5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.mIsHasScreenShotListener && (yc5Var = this.mScreenShotListenManager) != null) {
            yc5Var.k();
            this.mIsHasScreenShotListener = false;
        }
    }

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, inputMethodManager, view2) == null) {
            try {
                inputMethodManager.hideSoftInputFromWindow(view2.getWindowToken(), 2);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void ShowSoftKeyPad(InputMethodManager inputMethodManager, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputMethodManager, view2) == null) || view2 == null || inputMethodManager == null) {
            return;
        }
        try {
            inputMethodManager.showSoftInput(view2, 0);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public void ShowSoftKeyPadDelay(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view2, i) == null) {
            new Handler().postDelayed(new DelayRunnable(this, view2), i);
        }
    }

    public void addGlobalLayoutListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.tbadk.BaseActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity this$0;

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

                private void raiseOnKeyboardVisibilityChanged(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(65537, this, i) == null) {
                        View rootView = this.this$0.getRootView();
                        if (rootView instanceof ViewGroup) {
                            boolean z = false;
                            View childAt = ((ViewGroup) rootView).getChildAt(0);
                            if (childAt == null) {
                                return;
                            }
                            Rect rect = new Rect();
                            childAt.getWindowVisibleDisplayFrame(rect);
                            int i2 = rect.bottom - rect.top;
                            if (i2 != this.this$0.mAboveKeyboardHeight) {
                                int i3 = (i * 2) / 3;
                                boolean z2 = i2 < i3;
                                if (this.this$0.mAboveKeyboardHeight != 0 && this.this$0.mAboveKeyboardHeight < i3) {
                                    z = true;
                                }
                                if (z2 != z) {
                                    this.this$0.onKeyboardVisibilityChanged(z2);
                                    if ((TbSingleton.getInstance().isShowBackLabel || TbSingleton.getInstance().isShowVoiceFloat()) && this.this$0 == TbadkCoreApplication.getInst().getCurrentActivity()) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new KeyBoardSwitchMessage(Boolean.valueOf(z)));
                                    }
                                }
                                this.this$0.mAboveKeyboardHeight = i2;
                            }
                        }
                    }
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            View rootView = this.this$0.getRootView();
                            int height = rootView != null ? rootView.getHeight() : 0;
                            int height2 = this.this$0.getWindow().getDecorView().getRootView().getHeight();
                            if (!this.this$0.mLayoutHasInit) {
                                this.this$0.mLayoutHasInit = true;
                                this.this$0.mMaxHeight = height;
                            } else {
                                this.this$0.mMaxHeight = this.this$0.mMaxHeight < height ? height : this.this$0.mMaxHeight;
                            }
                            if (this.this$0.mLayoutHasInit && this.this$0.mMaxHeight > height && height != this.this$0.mPreHeight) {
                                int i = this.this$0.mMaxHeight - height;
                                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i) && i < (height2 * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i) {
                                    TbadkCoreApplication.getInst().setKeyboardHeight(i);
                                    this.this$0.onKeyboardHeightChanged(i);
                                }
                            }
                            raiseOnKeyboardVisibilityChanged(height2);
                            this.this$0.mPreHeight = height;
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public void adjustResizeForSoftInput() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = au4.c(getPageContext().getPageActivity());
        }
    }

    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || i == this.mSkinType) {
            return;
        }
        this.mSkinType = i;
        try {
            onChangeSkinType(i);
        } catch (OutOfMemoryError unused) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void changeSwipeSkinType(int i) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.forceChangeSkinType(i);
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, responsedMessage)) == null) ? (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true : invokeL.booleanValue;
    }

    public boolean checkUpIsLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) : invokeV.booleanValue;
    }

    public void clearAnimatable() {
        List<Animatable> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (list = this.animatableList) == null) {
            return;
        }
        try {
            synchronized (list) {
                for (int i = 0; i < this.animatableList.size(); i++) {
                    Animatable animatable = this.animatableList.get(i);
                    if (animatable != null && animatable.isRunning()) {
                        animatable.stop();
                    }
                    this.animatableList.clear();
                }
            }
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
    }

    public void clearAnimation() {
        List<WeakReference<View>> list;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (list = this.animationList) == null) {
            return;
        }
        synchronized (list) {
            for (int i = 0; i < this.animationList.size(); i++) {
                try {
                    WeakReference<View> weakReference = this.animationList.get(i);
                    if (weakReference != null && (view2 = weakReference.get()) != null) {
                        view2.clearAnimation();
                    }
                }
            }
            this.animationList.clear();
        }
    }

    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            finish();
        }
    }

    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
        }
    }

    public void closeLoadingDialog() {
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (xt4Var = this.mWaitingDialog) == null) {
            return;
        }
        try {
            if (xt4Var.c()) {
                this.mWaitingDialog.h(false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mWaitingDialog = null;
    }

    public er4 createListMenu(String[] strArr, er4.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, strArr, cVar)) == null) {
            er4 er4Var = this.mListMenu;
            return er4Var != null ? er4Var : newListMenu(strArr, cVar);
        }
        return (er4) invokeLL.objValue;
    }

    public void destroyWaitingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mWaitingDialog = null;
        }
    }

    public void disableSwipeJustOnce() {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && TbadkCoreApplication.IS_SUPPORT_SWIPEBACK && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.disableSwipeJustOnce();
        }
    }

    public void dismissAllDialog() {
        List<Dialog> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (list = this.dialogList) == null) {
            return;
        }
        for (Dialog dialog : list) {
            rg.b(dialog, getPageContext());
        }
        this.dialogList.clear();
    }

    public void dismissAllPopupWindow() {
        List<PopupWindow> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (list = this.popupWindowList) == null) {
            return;
        }
        for (PopupWindow popupWindow : list) {
            rg.d(popupWindow, getPageContext().getPageActivity());
        }
        this.popupWindowList.clear();
    }

    public void dismissDialog(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dialog) == null) {
            List<Dialog> list = this.dialogList;
            if (list != null) {
                list.remove(dialog);
            }
            rg.b(dialog, getPageContext());
        }
    }

    public void dismissDialogInteface(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, dialogInterface) == null) && (dialogInterface instanceof Dialog)) {
            dismissDialog((Dialog) dialogInterface);
        }
    }

    public void dismissPopupWindow(PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, popupWindow) == null) {
            rg.d(popupWindow, getPageContext().getPageActivity());
            List<PopupWindow> list = this.popupWindowList;
            if (list != null) {
                list.remove(popupWindow);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            dj4.a(motionEvent, getPageId(), getMissionTid());
            eq8.getInstance().behaviorRecordEvent(motionEvent, this);
            try {
                if (this.mProgressBar == null || !this.mProgressBar.isShown()) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            oi.w(getApplicationContext(), getWindow().getDecorView());
            dismissAllDialog();
            dismissAllPopupWindow();
            super.finish();
            closeAnimation();
        }
    }

    public void fullScreen(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || getWindow() == null) {
            return;
        }
        if (z) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags |= 1024;
            getWindow().setAttributes(attributes);
            getWindow().addFlags(512);
            return;
        }
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.flags &= -1025;
        getWindow().setAttributes(attributes2);
        getWindow().clearFlags(512);
    }

    @Override // com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.v75
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                return intent.getStringArrayListExtra("obj_source");
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    public qm4 getLayoutInflate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mLayoutInflateFactory : (qm4) invokeV.objValue;
    }

    public sm4 getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mLayoutMode : (sm4) invokeV.objValue;
    }

    public er4 getListMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mListMenu : (er4) invokeV.objValue;
    }

    public xt4 getLoadingDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mWaitingDialog : (xt4) invokeV.objValue;
    }

    public g45 getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.loadingView : (g45) invokeV.objValue;
    }

    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    public View.OnClickListener getNetRefreshListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.netRefreshListener == null) {
                this.netRefreshListener = new NetRefreshListener();
            }
            return this.netRefreshListener;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.repackage.v75
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
            String currentPageKey = getCurrentPageKey();
            if (ListUtils.isEmpty(arrayList2)) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                arrayList.addAll(arrayList2);
            }
            if (getPageStayFilter() == null || getPageStayFilter().c()) {
                if (!StringUtils.isNull(currentPageKey)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(currentPageKey);
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            BdUniqueId uniqueId = getUniqueId();
            if (uniqueId != null) {
                return uniqueId.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public y75 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.pageStayDurationItem == null) {
                y75 y75Var = new y75();
                this.pageStayDurationItem = y75Var;
                y75Var.x(getCurrentPageSourceKeyList());
                this.pageStayDurationItem.s(getCurrentPageKey());
            }
            return this.pageStayDurationItem;
        }
        return (y75) invokeV.objValue;
    }

    @Override // com.repackage.v75
    public w75 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return null;
        }
        return (w75) invokeV.objValue;
    }

    public String getPreExtraPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            p75 tbPageExtra = getTbPageExtra();
            return tbPageExtra != null ? tbPageExtra.e() : "";
        }
        return (String) invokeV.objValue;
    }

    public final TbPageTag getPrePageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? u75.m(getIntent()) : (TbPageTag) invokeV.objValue;
    }

    public h45 getRefreshView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h45(getPageContext().getContext(), getNetRefreshListener());
            }
            return this.mRefreshView;
        }
        return (h45) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                return super.getResources();
            }
            if (this.resourcesWrapper == null) {
                this.resourcesWrapper = new ng(super.getResources());
            }
            return this.resourcesWrapper;
        }
        return (Resources) invokeV.objValue;
    }

    public Handler getSafeHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mSafeHandler : (Handler) invokeV.objValue;
    }

    public p75 getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.mTbPageExtra == null) {
                this.mTbPageExtra = new p75(getUniqueId(), getCurrentExtraPageKey(), "", getIntent());
            }
            return this.mTbPageExtra;
        }
        return (p75) invokeV.objValue;
    }

    @Override // com.repackage.s75
    public final t75 getTbPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? new t75(getUniqueId(), getTbPageTag(), getIntent()) : (t75) invokeV.objValue;
    }

    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.mTbPageTag == null) {
                TbPageTag tbPageTag = new TbPageTag();
                this.mTbPageTag = tbPageTag;
                tbPageTag.locatePage = getCurrentPageKey();
            }
            return this.mTbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public boolean grantWindowPermission(vm4 vm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, vm4Var)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!Settings.canDrawOverlays(getBaseContext())) {
                    this.mPermissionCallback = vm4Var;
                    if (!vt4.k().h("key_is_window_permission_dialog_shown", false)) {
                        cr4 cr4Var = new cr4(this);
                        cr4Var.setCanceledOnTouchOutside(false);
                        cr4Var.setTitle(R.string.obfuscated_res_0x7f0f0faf);
                        cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0fb9);
                        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0964, new cr4.e(this) { // from class: com.baidu.tbadk.BaseActivity.8
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ BaseActivity this$0;

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

                            @Override // com.repackage.cr4.e
                            public void onClick(cr4 cr4Var2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cr4Var2) == null) {
                                    cr4Var2.dismiss();
                                    try {
                                        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                                        intent.setData(Uri.parse("package:" + this.this$0.getPackageName()));
                                        this.this$0.startActivityForResult(intent, 12016);
                                    } catch (Exception unused) {
                                        this.this$0.showToast(R.string.obfuscated_res_0x7f0f0fba);
                                        if (this.this$0.mPermissionCallback != null) {
                                            this.this$0.mPermissionCallback.onPermissionResult(false);
                                        }
                                    }
                                }
                            }
                        }).setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new cr4.e(this) { // from class: com.baidu.tbadk.BaseActivity.7
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ BaseActivity this$0;

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

                            @Override // com.repackage.cr4.e
                            public void onClick(cr4 cr4Var2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cr4Var2) == null) {
                                    cr4Var2.dismiss();
                                    if (this.this$0.mPermissionCallback != null) {
                                        this.this$0.mPermissionCallback.onPermissionResult(false);
                                    }
                                }
                            }
                        }).create(getPageContext());
                        cr4Var.show();
                        vt4.k().u("key_is_window_permission_dialog_shown", true);
                    } else {
                        vm4 vm4Var2 = this.mPermissionCallback;
                        if (vm4Var2 != null) {
                            vm4Var2.onPermissionResult(false);
                        }
                    }
                    return false;
                } else if (vm4Var != null) {
                    vm4Var.onPermissionResult(true);
                }
            } else if (vm4Var != null) {
                vm4Var.onPermissionResult(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void hideFloatingWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            KuangFloatingWindowController.getInstance().hideFloatingView();
        }
    }

    public void hideListMenu() {
        er4 er4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || (er4Var = this.mListMenu) == null) {
            return;
        }
        er4Var.e();
    }

    public void hideLoadingView(View view2) {
        g45 g45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, view2) == null) || (g45Var = this.loadingView) == null) {
            return;
        }
        g45Var.dettachView(view2);
    }

    public void hideNetRefreshView(View view2) {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, view2) == null) || (h45Var = this.mRefreshView) == null) {
            return;
        }
        h45Var.dettachView(view2);
    }

    public void hideProgressBar() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (continuousAnimationView = this.mProgressBar) == null) {
            return;
        }
        continuousAnimationView.setVisibility(8);
        this.mProgressBar.cancelAnimation();
    }

    public boolean isForceInterceptStimeStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.isForceInterceptStimeStat : invokeV.booleanValue;
    }

    public boolean isLoadingViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            g45 g45Var = this.loadingView;
            if (g45Var == null) {
                return false;
            }
            return g45Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mIsLogin : invokeV.booleanValue;
    }

    public boolean isNetRefreshViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            h45 h45Var = this.mRefreshView;
            if (h45Var == null) {
                return false;
            }
            return h45Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isProgressBarShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ContinuousAnimationView continuousAnimationView = this.mProgressBar;
            return continuousAnimationView != null && continuousAnimationView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isSwipeBackEnabled() {
        InterceptResult invokeV;
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK || (swipeBackLayout = this.mSwipeBackLayout) == null) {
                return false;
            }
            return swipeBackLayout.isSwipeBackEnabled();
        }
        return invokeV.booleanValue;
    }

    public boolean isUseStyleImmersiveSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mUseStyleImmersiveSticky : invokeV.booleanValue;
    }

    public er4 newListMenu(String[] strArr, er4.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048642, this, strArr, cVar)) == null) {
            er4 er4Var = new er4(getPageContext().getPageActivity());
            this.mListMenu = er4Var;
            er4Var.l(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cda));
            this.mListMenu.j(strArr, cVar);
            this.mListMenu.c(getPageContext());
            return this.mListMenu;
        }
        return (er4) invokeLL.objValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        vm4 vm4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048643, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (!qd5.c(i, i2, intent) && (vm4Var = this.mPermissionCallback) != null && Build.VERSION.SDK_INT >= 23 && i == 12016) {
                vm4Var.onPermissionResult(Settings.canDrawOverlays(getBaseContext()));
                this.mPermissionCallback = null;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            super.onAttachedToWindow();
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            g45 g45Var = this.loadingView;
            if (g45Var != null) {
                g45Var.onChangeSkinType();
            }
            h45 h45Var = this.mRefreshView;
            if (h45Var != null) {
                h45Var.onChangeSkinType();
            }
            SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
            if (swipeBackLayout != null) {
                swipeBackLayout.onChangeSkinType(i);
            }
            au4 au4Var = this.mKeyboardAdjust;
            if (au4Var != null) {
                au4Var.j(i);
            }
            if (this.mUseStyleImmersiveSticky) {
                this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
            }
            er4 er4Var = this.mListMenu;
            if (er4Var != null) {
                er4Var.b(getPageContext());
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration == null) {
                return;
            }
            int i = configuration.orientation;
            if (i == this.mLastOrientation) {
                if (configuration.screenWidthDp != this.mLastScreenWidth || configuration.screenHeightDp != this.mLastScreenHeight) {
                    this.mLastScreenWidth = configuration.screenWidthDp;
                    this.mLastScreenHeight = configuration.screenHeightDp;
                    oi.a = false;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921414, getUniqueId()));
                }
            } else {
                this.mLastOrientation = i;
            }
            if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                MessageManager.getInstance().dispatchResponsedMessage(new ConfigChangeMessage(Boolean.valueOf(KuangFloatingWindowController.currentStatus)));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, bundle) == null) {
            if (this.isAddSwipeBackLayout) {
                SwipeBackLayout swipeBackLayout = new SwipeBackLayout(getPageContext().getPageActivity());
                this.mSwipeBackLayout = swipeBackLayout;
                swipeBackLayout.attachToActivity(getPageContext().getPageActivity());
                this.mSwipeBackLayout.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (!TbadkCoreApplication.IS_SUPPORT_SWIPEBACK) {
                    this.mSwipeBackLayout.setSwipeBackEnabled(false);
                }
            }
            if (TbadkCoreApplication.getInst().isExitAppCloseWebSocket()) {
                TbadkCoreApplication.getInst().setExitAppCloseWebSocket(false);
                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
                BdSocketLinkService.startService(false, "app start");
            }
            MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
            this.customToast = CustomToast.newInstance();
            super.onCreate(bundle);
            this.mLayoutMode = new sm4();
            qm4 qm4Var = new qm4();
            this.mLayoutInflateFactory = qm4Var;
            qm4Var.a(this.mLayoutMode);
            getLayoutInflater().setFactory(this.mLayoutInflateFactory);
            if (this.mUseStyleImmersiveSticky) {
                this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
            }
            if (getGpuSwitch()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            TbadkCoreApplication.setIsAppRunning(true);
            TiebaStaticHelper.setCurrentActivity(getClass().getName());
            registerListener(this.nightResourcesChangeListener);
            registerListener(this.skinTypeChangeListener);
            enterExitAnimation();
            this.mIsLogin = TbadkCoreApplication.isLogin();
            this.mScreenShotListenManager = new yc5(this);
            SpeedStats.getInstance().onBaseActivityCreate(this);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            closeLoadingDialog();
            GuidPageView guidPageView = this.mGuidPage;
            if (guidPageView != null) {
                guidPageView.b();
            }
            sm4 sm4Var = this.mLayoutMode;
            if (sm4Var != null) {
                sm4Var.c();
            }
            View view2 = this.loadingRootView;
            if (view2 != null) {
                hideLoadingView(view2);
            }
            adjustResizeForSoftInputOnDestory();
            hideClickableTextToast();
            hideListMenu();
            clearAnimatable();
            clearAnimation();
            unRegisterResponsedEventListener();
            this.pageStayDurationItem = null;
            this.mTbPageTag = null;
            this.mTbPageExtra = null;
            this.mPermissionCallback = null;
            super.onDestroy();
            this.mSafeHandler.removeCallbacksAndMessages(null);
            pg.a().removeCallbacks(this.setNoTranslucentRunnable);
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048649, this, i, keyEvent)) == null) {
            if (i == 82) {
                try {
                    if (keyEvent.isLongPress()) {
                        return true;
                    }
                } catch (IllegalStateException unused) {
                    if (i == 4) {
                        finish();
                        return true;
                    }
                    return false;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048650, this, i, keyEvent)) == null) {
            try {
                return super.onKeyUp(i, keyEvent);
            } catch (IllegalStateException unused) {
                if (i == 4) {
                    finish();
                    return true;
                }
                return true;
            }
        }
        return invokeIL.booleanValue;
    }

    public void onKeyboardHeightChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
        }
    }

    @Override // com.repackage.aj4
    public boolean onMissionCompleted(CompleteTaskToastData completeTaskToastData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, completeTaskToastData)) == null) {
            hideClickableTextToast();
            this.mClickableTextToast = dj4.i(completeTaskToastData);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            eq8.getInstance().onPause(this);
            super.onPause();
            if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                hideFloatingWindow();
            }
            if (this.lastResumeTime != 0 && !this.isInterceptStimeStat && !this.isForceInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                y75 pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                z75.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
            this.customToast.onPause();
            stopScreenShotListen();
            TbadkCoreApplication.getInst().DelResumeNum();
            TbadkCoreApplication.getInst().setCurrentActivity(null);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
            if (this.isAddSwipeBackLayout) {
                pg.a().removeCallbacks(this.setNoTranslucentRunnable);
                pg.a().postDelayed(this.setNoTranslucentRunnable, 1000L);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.repackage.e9
    public void onPreLoad(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, xoVar) == null) {
            super.onPreLoad(xoVar);
            PreLoadImageHelper.load(xoVar, getUniqueId());
            PreLoadVideoHelper.load(xoVar, getUniqueId(), this);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        PermissionJudgePolicy permissionJudgePolicy2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048657, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (iArr == null || iArr.length <= 0 || strArr == null || strArr.length <= 0) {
                return;
            }
            boolean z = false;
            if (iArr[0] != 0 && (permissionJudgePolicy2 = this.mCurrentPermissionJudgePolicy) != null) {
                permissionJudgePolicy2.checkPermissionForbidden(this, strArr[0]);
            }
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z = true;
                    break;
                } else if (iArr[i2] != 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z || (permissionJudgePolicy = this.mCurrentPermissionJudgePolicy) == null) {
                return;
            }
            permissionJudgePolicy.onPermissionsGranted();
        }
    }

    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            super.onRestart();
            flog = 0;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            MenuKeyUtils.hideSoftMenuKey(getWindow());
            super.onResume();
            eq8.getInstance().onResume(this);
            if (this.isInterceptStimeStat) {
                setInterceptStimeStat(false);
            } else {
                this.lastResumeTime = System.currentTimeMillis();
            }
            this.customToast.onResume();
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            TbadkCoreApplication.getInst().AddResumeNum();
            TiebaStaticHelper.setCurrentActivity(getClass().getName());
            TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (this.mIsLogin != isLogin) {
                this.mIsLogin = isLogin;
                onUserChanged(isLogin);
            }
            if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, this));
            }
            TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
            setCurrentActivityTid();
            startScreenShotListen();
            TbSingleton.getInstance().getClass();
            if (!"BaseActivity".equals(TbSingleton.getInstance().isSwitchActivity)) {
                TbSingleton tbSingleton = TbSingleton.getInstance();
                TbSingleton.getInstance().getClass();
                tbSingleton.isSwitchActivity = "BaseActivity";
                flog = 0;
            }
            if (this == TbadkCoreApplication.getInst().getCurrentActivity() && TbSingleton.getInstance().isShowBackLabel && KuangFloatingWindowController.getInstance().init() && flog == 0) {
                showFloatingWindow();
            }
            if (this.isAddSwipeBackLayout) {
                pg.a().removeCallbacks(this.setNoTranslucentRunnable);
                bd5.b(this);
            }
        }
    }

    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            super.onStart();
            flog = 0;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            super.onStop();
            if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                flog = 1;
            }
            onResourceRecycle();
        }
    }

    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
        }
    }

    public void publishEvent(h55 h55Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048665, this, h55Var) == null) || h55Var == null) {
            return;
        }
        if (h55Var.getTag() == 0) {
            h55Var.setTag(getUniqueId());
        }
        o55.i(h55Var);
    }

    public void quitDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            UtilHelper.quitDialog(getPageContext().getPageActivity());
        }
    }

    public void registerResponsedEventListener(Class<? extends h55> cls, p55 p55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048667, this, cls, p55Var) == null) {
            o55.f().m(cls, p55Var, getUniqueId());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
        }
    }

    public void setActivityBgTransparent() {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.setBgTransparent();
    }

    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            dj4.h(getPageId(), getMissionTid());
        }
    }

    public void setCurrentPermissionJudgePolicy(PermissionJudgePolicy permissionJudgePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, permissionJudgePolicy) == null) {
            this.mCurrentPermissionJudgePolicy = permissionJudgePolicy;
        }
    }

    public void setExcludeHeight(int i) {
        au4 au4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048672, this, i) == null) || (au4Var = this.mKeyboardAdjust) == null) {
            return;
        }
        au4Var.m(i);
    }

    public void setForceInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            this.isForceInterceptStimeStat = z;
        }
    }

    public void setInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.isInterceptStimeStat = z;
        }
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z) == null) {
            this.isAddSwipeBackLayout = z;
        }
    }

    public void setLayoutInflate(qm4 qm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, qm4Var) == null) {
            this.mLayoutInflateFactory = qm4Var;
        }
    }

    public void setLayoutMode(sm4 sm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, sm4Var) == null) {
            this.mLayoutMode = sm4Var;
        }
    }

    public void setNetRefreshLayoutMarginTop(boolean z) {
        h45 h45Var;
        int a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048678, this, z) == null) && (h45Var = this.mRefreshView) != null && h45Var.isViewAttached() && this.mRefreshView.b() != null && (this.mRefreshView.b().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            if (z) {
                a = BdListViewHelper.b(BdListViewHelper.HeadType.DEFAULT, false);
            } else {
                a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            }
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.b().getLayoutParams()).topMargin = a;
        }
    }

    @Deprecated
    public void setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(boolean z) {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048679, this, z) == null) && (h45Var = this.mRefreshView) != null && h45Var.isViewAttached() && this.mRefreshView.b() != null && (this.mRefreshView.b().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.b().getLayoutParams()).topMargin = BdListViewHelper.b(BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            setNetRefreshViewEmotionMarginTop(oi.f(getApplicationContext(), R.dimen.obfuscated_res_0x7f07029c));
        }
    }

    public void setNetRefreshViewEmotionMarginTop(int i) {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048681, this, i) == null) && (h45Var = this.mRefreshView) != null && h45Var.isViewAttached()) {
            this.mRefreshView.k(i);
        }
    }

    public void setNetRefreshViewTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h45(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.k(i);
        }
    }

    public void setSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i) == null) {
            this.mSkinType = i;
        }
    }

    public void setSwipeBackEnabled(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048684, this, z) == null) && TbadkCoreApplication.IS_SUPPORT_SWIPEBACK && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setSwipeBackEnabled(z);
        }
    }

    public void setSwipeBackIsSupportNight(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048685, this, z) == null) || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.setIsSupportNight(z);
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z) == null) {
            this.mUseStyleImmersiveSticky = z;
        }
    }

    public boolean showDialog(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, dialog)) == null) {
            if (rg.j(dialog, getPageContext())) {
                if (this.dialogList == null) {
                    this.dialogList = new LinkedList();
                }
                this.dialogList.add(dialog);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void showFloatingWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            grantWindowPermission(new vm4(this) { // from class: com.baidu.tbadk.BaseActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity this$0;

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

                @Override // com.repackage.vm4
                public void onPermissionResult(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) && z) {
                        TbadkCoreApplication.getInst().setCurrentActivity(this.this$0.getPageContext().getPageActivity());
                        if (KuangFloatingWindowController.getInstance().init()) {
                            TbSingleton.getInstance().isShowBackLabel = true;
                            KuangFloatingWindowController.getInstance().showFloatingView();
                        }
                    }
                }
            });
        }
    }

    public void showListMenu() {
        er4 er4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048689, this) == null) || (er4Var = this.mListMenu) == null) {
            return;
        }
        er4Var.m();
    }

    public void showLoadingDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, str) == null) {
            showLoadingDialog(str, (DialogInterface.OnCancelListener) null);
        }
    }

    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, view2) == null) {
            showLoadingView(view2, false);
        }
    }

    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048699, this, view2, str, z) == null) {
            showNetRefreshView(view2, null, str, null, z, getNetRefreshListener());
        }
    }

    public void showNetRefreshViewNoClick(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048701, this, view2, str, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h45(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.m(str);
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.e();
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048702, this, popupWindow, view2)) == null) {
            if (rg.k(popupWindow, view2)) {
                if (this.popupWindowList == null) {
                    this.popupWindowList = new LinkedList();
                }
                this.popupWindowList.add(popupWindow);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view2, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048704, this, new Object[]{popupWindow, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (rg.m(popupWindow, view2, i, i2, i3)) {
                if (this.popupWindowList == null) {
                    this.popupWindowList = new LinkedList();
                }
                this.popupWindowList.add(popupWindow);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            try {
                showProgressBarWithOffset(0, 0);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void showProgressBarWithOffset(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048707, this, i, i2) == null) {
            showProgressBar(false, i, i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, str) == null) {
            String name = getClass().getName();
            String str2 = getApplicationContext().getPackageName() + ".chat";
            if (!name.startsWith(getApplicationContext().getPackageName() + ".im") && !name.startsWith(str2)) {
                oi.N(getPageContext().getContext(), str);
            } else {
                this.customToast.showToast(str, 2000);
            }
        }
    }

    public void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048714, this, str, defaultIcon, i) == null) {
            BdToast.g(getPageContext().getContext(), str, defaultIcon, i).q();
        }
    }

    public void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048715, this, str, defaultIcon) == null) {
            BdToast.f(getPageContext().getContext(), str, defaultIcon).q();
        }
    }

    public void showToastWithIcon(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048716, this, str, i) == null) {
            BdToast.i(getPageContext().getContext(), str, i, false).q();
        }
    }

    public void showToastWithIconDuration(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048717, this, str, i, i2) == null) {
            BdToast.h(getPageContext().getContext(), str, i, i2, false).q();
        }
    }

    public void skipToLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
        }
    }

    public void skipToRegisterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            ViewHelper.skipToRegisterActivity(getPageContext().getPageActivity());
        }
    }

    public void startAnimatable(Animatable animatable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048720, this, animatable) == null) || animatable == null || isFinishing()) {
            return;
        }
        if (this.animatableList == null) {
            this.animatableList = new ArrayList();
        }
        synchronized (this.animatableList) {
            this.animatableList.add(animatable);
        }
        try {
            animatable.start();
        } catch (Throwable unused) {
        }
    }

    public void startAnimation(View view2, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048721, this, view2, animation, animationListener) == null) || animation == null || isFinishing()) {
            return;
        }
        WeakReference<View> weakReference = new WeakReference<>(view2);
        animation.setAnimationListener(new Animation.AnimationListener(this, animationListener, weakReference) { // from class: com.baidu.tbadk.BaseActivity.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseActivity this$0;
            public final /* synthetic */ Animation.AnimationListener val$listener;
            public final /* synthetic */ WeakReference val$reference;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, animationListener, weakReference};
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
                this.val$listener = animationListener;
                this.val$reference = weakReference;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation2) == null) {
                    Animation.AnimationListener animationListener2 = this.val$listener;
                    if (animationListener2 != null) {
                        animationListener2.onAnimationEnd(animation2);
                    }
                    synchronized (this.this$0.animationList) {
                        this.this$0.animationList.remove(this.val$reference);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                Animation.AnimationListener animationListener2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation2) == null) || (animationListener2 = this.val$listener) == null) {
                    return;
                }
                animationListener2.onAnimationRepeat(animation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                Animation.AnimationListener animationListener2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation2) == null) || (animationListener2 = this.val$listener) == null) {
                    return;
                }
                animationListener2.onAnimationStart(animation2);
            }
        });
        if (this.animationList == null) {
            this.animationList = new ArrayList();
        }
        synchronized (this.animationList) {
            this.animationList.add(weakReference);
        }
        try {
            view2.startAnimation(animation);
        } catch (Throwable unused) {
        }
    }

    public void unRegisterResponsedEventListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            o55.f().n(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.BdBaseActivity, com.repackage.c9
    public TbPageContext<T> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            try {
                if (this.pageContext == null && mClazz4GetPageContext != null) {
                    this.pageContext = mClazz4GetPageContext.getConstructor(BaseActivity.class).newInstance(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.pageContext;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048691, this, str, onCancelListener) == null) {
            showLoadingDialog(str, onCancelListener, true);
        }
    }

    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048696, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.loadingRootView = view2;
            if (this.loadingView == null) {
                if (i < 0) {
                    this.loadingView = new g45(getPageContext().getContext());
                } else {
                    g45 g45Var = new g45(getPageContext().getContext(), i);
                    this.loadingView = g45Var;
                    g45Var.i();
                }
                this.loadingView.onChangeSkinType();
            }
            this.loadingView.attachView(view2, z);
        }
    }

    public void showNetRefreshView(View view2, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048698, this, new Object[]{view2, str, str2, str3, Boolean.valueOf(z), onClickListener}) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h45(getPageContext().getContext(), onClickListener);
            }
            this.mRefreshView.n(str);
            this.mRefreshView.m(str2);
            this.mRefreshView.g(str3);
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.p();
        }
    }

    public void showLoadingDialog(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048693, this, str, z) == null) {
            showLoadingDialog(str, null, true);
        }
    }

    public void showProgressBar(boolean z, int i, int i2) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048706, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (this.mProgressBar == null) {
                try {
                    this.mProgressBar = new ContinuousAnimationView(getPageContext().getPageActivity());
                    FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
                    int f = oi.f(getPageContext().getPageActivity(), R.dimen.tbds200);
                    frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(f, f, 17));
                    this.mProgressBar.setRepeatMode(1);
                    this.mProgressBar.addAnimatorListener(this.loadViewAnimListener);
                } catch (Throwable unused) {
                    return;
                }
            }
            if (z && (continuousAnimationView = this.mProgressBar) != null) {
                continuousAnimationView.bringToFront();
            }
            ContinuousAnimationView continuousAnimationView2 = this.mProgressBar;
            if (continuousAnimationView2 != null) {
                continuousAnimationView2.setPadding(oi.d(getPageContext().getPageActivity(), i), oi.d(getPageContext().getPageActivity(), i2), 0, 0);
                this.mProgressBar.setVisibility(0);
                this.mProgressBar.setSpeed(1.3f);
                this.mProgressBar.setMinAndMaxProgress(0.0f, 1.0f);
                this.mProgressBar.playAnimation();
            }
        }
    }

    public void ShowSoftKeyPadDelay(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            ShowSoftKeyPadDelay(view2, 150);
        }
    }

    public void adjustResizeForSoftInput(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = au4.d(getPageContext().getPageActivity(), i, z);
        }
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048692, this, str, onCancelListener, z) == null) && !isFinishing() && rg.f(getPageContext())) {
            if (str == null) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0037);
            }
            xt4 xt4Var = new xt4((TbPageContext<?>) getPageContext());
            this.mWaitingDialog = xt4Var;
            xt4Var.j(str);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(z);
            this.mWaitingDialog.h(true);
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048703, this, popupWindow, view2, i, i2)) == null) {
            if (rg.l(popupWindow, view2, i, i2)) {
                if (this.popupWindowList == null) {
                    this.popupWindowList = new LinkedList();
                }
                this.popupWindowList.add(popupWindow);
                return true;
            }
            return false;
        }
        return invokeLLII.booleanValue;
    }

    public void showNetRefreshViewNoClick(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048700, this, view2, str) == null) {
            showNetRefreshViewNoClick(view2, str, false);
        }
    }

    public void adjustResizeForSoftInput(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = au4.e(getPageContext().getPageActivity(), z);
        }
    }

    public void showToast(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048712, this, str, i) == null) {
            this.customToast.showToast(str, 2000, i);
        }
    }

    public void showToast(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048709, this, i, i2) == null) {
            this.customToast.showToast(i, 2000, i2);
        }
    }

    public void showLoadingView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048695, this, view2, z) == null) {
            showLoadingView(view2, z, -1);
        }
    }

    public void showNetRefreshView(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048697, this, view2, str) == null) {
            showNetRefreshView(view2, str, false);
        }
    }

    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048708, this, i) == null) {
            oi.M(getPageContext().getContext(), i);
        }
    }

    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048713, this, str, z) == null) {
            if (z) {
                showToast(str);
            } else {
                oi.N(getPageContext().getContext(), str);
            }
        }
    }

    public void showToast(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048710, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                showToast(i);
            } else {
                oi.M(getPageContext().getContext(), i);
            }
        }
    }
}
