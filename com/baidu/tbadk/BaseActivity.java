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
import c.a.e.e.p.l;
import c.a.e.l.e.q;
import c.a.q0.a.p;
import c.a.q0.a.s;
import c.a.q0.d1.g0;
import c.a.q0.d1.j0;
import c.a.q0.g0.g;
import c.a.q0.g0.h;
import c.a.q0.j0.i;
import c.a.q0.o0.a;
import c.a.q0.s.c;
import c.a.q0.s.f0.d;
import c.a.q0.s.s.a;
import c.a.q0.s.s.b;
import c.a.q0.s.s.e;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class BaseActivity<T> extends BdBaseActivity<T> implements TbPageContextSupport, a, IVideoNeedPreload, p, Object, c.a.q0.n0.a {
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
    public g loadingView;
    public int mAboveKeyboardHeight;
    public e mClickableTextToast;
    public PermissionJudgePolicy mCurrentPermissionJudgePolicy;
    public final GuidPageView mGuidPage;
    public boolean mIsHasScreenShotListener;
    public boolean mIsLogin;
    public d mKeyboardAdjust;
    public int mLastOrientation;
    public int mLastScreenHeight;
    public int mLastScreenWidth;
    public boolean mLayoutHasInit;
    public c.a.q0.s.a mLayoutInflateFactory;
    public c mLayoutMode;
    public b mListMenu;
    public int mMaxHeight;
    public c.a.q0.s.e mPermissionCallback;
    public int mPreHeight;
    public ContinuousAnimationView mProgressBar;
    public h mRefreshView;
    public final Handler mSafeHandler;
    public g0 mScreenShotListenManager;
    public int mSkinType;
    public SwipeBackLayout mSwipeBackLayout;
    public c.a.q0.m0.c mTbPageExtra;
    public TbPageTag mTbPageTag;
    public boolean mUseStyleImmersiveSticky;
    public c.a.q0.s.f0.a mWaitingDialog;
    public BaseActivity<T>.NetRefreshListener netRefreshListener;
    public final CustomMessageListener nightResourcesChangeListener;
    public TbPageContext<T> pageContext;
    public c.a.q0.o0.d pageStayDurationItem;
    public List<PopupWindow> popupWindowList;
    public c.a.e.e.m.c resourcesWrapper;
    public Runnable setNoTranslucentRunnable;
    public final CustomMessageListener skinTypeChangeListener;

    /* loaded from: classes6.dex */
    public class DelayRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View mView;
        public final /* synthetic */ BaseActivity this$0;

        public DelayRunnable(BaseActivity baseActivity, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseActivity;
            this.mView = null;
            this.mView = view;
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

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                j0.a(this.this$0);
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (dVar = this.mKeyboardAdjust) == null) {
            return;
        }
        dVar.i();
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
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (eVar = this.mClickableTextToast) == null) {
            return;
        }
        eVar.e();
    }

    public static void setmClazz4GetPageContext(Class<? extends TbPageContext> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, cls) == null) {
            mClazz4GetPageContext = cls;
        }
    }

    private void startScreenShotListen() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || !PermissionUtil.isAgreePrivacyPolicy() || this.mIsHasScreenShotListener || (g0Var = this.mScreenShotListenManager) == null) {
            return;
        }
        g0Var.i(new g0.b(this) { // from class: com.baidu.tbadk.BaseActivity.9
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

            @Override // c.a.q0.d1.g0.b
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
        g0 g0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.mIsHasScreenShotListener && (g0Var = this.mScreenShotListenManager) != null) {
            g0Var.k();
            this.mIsHasScreenShotListener = false;
        }
    }

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, inputMethodManager, view) == null) {
            try {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void ShowSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputMethodManager, view) == null) || view == null || inputMethodManager == null) {
            return;
        }
        try {
            inputMethodManager.showSoftInput(view, 0);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public void ShowSoftKeyPadDelay(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
            new Handler().postDelayed(new DelayRunnable(this, view), i2);
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

                private void raiseOnKeyboardVisibilityChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(65537, this, i2) == null) {
                        View rootView = this.this$0.getRootView();
                        if (rootView instanceof ViewGroup) {
                            boolean z = false;
                            View childAt = ((ViewGroup) rootView).getChildAt(0);
                            if (childAt == null) {
                                return;
                            }
                            Rect rect = new Rect();
                            childAt.getWindowVisibleDisplayFrame(rect);
                            int i3 = rect.bottom - rect.top;
                            if (i3 != this.this$0.mAboveKeyboardHeight) {
                                int i4 = (i2 * 2) / 3;
                                boolean z2 = i3 < i4;
                                if (this.this$0.mAboveKeyboardHeight != 0 && this.this$0.mAboveKeyboardHeight < i4) {
                                    z = true;
                                }
                                if (z2 != z) {
                                    this.this$0.onKeyboardVisibilityChanged(z2);
                                    if (TbSingleton.getInstance().isShowBackLabel && this.this$0 == TbadkCoreApplication.getInst().getCurrentActivity()) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new KeyBoardSwitchMessage(Boolean.valueOf(z)));
                                    }
                                }
                                this.this$0.mAboveKeyboardHeight = i3;
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
                                int i2 = this.this$0.mMaxHeight - height;
                                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (height2 * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                                    TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                                    this.this$0.onKeyboardHeightChanged(i2);
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
            this.mKeyboardAdjust = d.c(getPageContext().getPageActivity());
        }
    }

    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        try {
            onChangeSkinType(i2);
        } catch (OutOfMemoryError unused) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void changeSwipeSkinType(int i2) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.forceChangeSkinType(i2);
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
                for (int i2 = 0; i2 < this.animatableList.size(); i2++) {
                    Animatable animatable = this.animatableList.get(i2);
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
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (list = this.animationList) == null) {
            return;
        }
        synchronized (list) {
            for (int i2 = 0; i2 < this.animationList.size(); i2++) {
                try {
                    WeakReference<View> weakReference = this.animationList.get(i2);
                    if (weakReference != null && (view = weakReference.get()) != null) {
                        view.clearAnimation();
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
        c.a.q0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (aVar = this.mWaitingDialog) == null) {
            return;
        }
        try {
            if (aVar.c()) {
                this.mWaitingDialog.h(false);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        this.mWaitingDialog = null;
    }

    public b createListMenu(String[] strArr, b.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, strArr, cVar)) == null) {
            b bVar = this.mListMenu;
            return bVar != null ? bVar : newListMenu(strArr, cVar);
        }
        return (b) invokeLL.objValue;
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
            c.a.e.e.m.g.b(dialog, getPageContext());
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
            c.a.e.e.m.g.d(popupWindow, getPageContext().getPageActivity());
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
            c.a.e.e.m.g.b(dialog, getPageContext());
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
            c.a.e.e.m.g.d(popupWindow, getPageContext().getPageActivity());
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
            s.a(motionEvent, getPageId(), getMissionTid());
            c.a.r0.p3.a.getInstance().behaviorRecordEvent(motionEvent, this);
            try {
                if (this.mProgressBar == null || !this.mProgressBar.isShown()) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
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
            l.x(getApplicationContext(), getWindow().getDecorView());
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

    @Override // c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.q0.o0.a
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

    public c.a.q0.s.a getLayoutInflate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mLayoutInflateFactory : (c.a.q0.s.a) invokeV.objValue;
    }

    public c getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mLayoutMode : (c) invokeV.objValue;
    }

    public b getListMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mListMenu : (b) invokeV.objValue;
    }

    public c.a.q0.s.f0.a getLoadingDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mWaitingDialog : (c.a.q0.s.f0.a) invokeV.objValue;
    }

    public g getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.loadingView : (g) invokeV.objValue;
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

    @Override // c.a.q0.o0.a
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
            if (getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) {
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

    public c.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.pageStayDurationItem == null) {
                c.a.q0.o0.d dVar = new c.a.q0.o0.d();
                this.pageStayDurationItem = dVar;
                dVar.x(getCurrentPageSourceKeyList());
                this.pageStayDurationItem.s(getCurrentPageKey());
            }
            return this.pageStayDurationItem;
        }
        return (c.a.q0.o0.d) invokeV.objValue;
    }

    @Override // c.a.q0.o0.a
    public c.a.q0.o0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return null;
        }
        return (c.a.q0.o0.b) invokeV.objValue;
    }

    public String getPreExtraPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            c.a.q0.m0.c tbPageExtra = getTbPageExtra();
            return tbPageExtra != null ? tbPageExtra.d() : "";
        }
        return (String) invokeV.objValue;
    }

    public final TbPageTag getPrePageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? c.a.q0.n0.c.m(getIntent()) : (TbPageTag) invokeV.objValue;
    }

    public h getRefreshView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            }
            return this.mRefreshView;
        }
        return (h) invokeV.objValue;
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
                this.resourcesWrapper = new c.a.e.e.m.c(super.getResources());
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

    public c.a.q0.m0.c getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.mTbPageExtra == null) {
                this.mTbPageExtra = new c.a.q0.m0.c(getUniqueId(), getCurrentExtraPageKey(), getIntent());
            }
            return this.mTbPageExtra;
        }
        return (c.a.q0.m0.c) invokeV.objValue;
    }

    @Override // c.a.q0.n0.a
    public final c.a.q0.n0.b getTbPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? new c.a.q0.n0.b(getUniqueId(), getTbPageTag(), getIntent()) : (c.a.q0.n0.b) invokeV.objValue;
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

    public boolean grantWindowPermission(c.a.q0.s.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, eVar)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!Settings.canDrawOverlays(getBaseContext())) {
                    this.mPermissionCallback = eVar;
                    if (!c.a.q0.s.d0.b.j().g("key_is_window_permission_dialog_shown", false)) {
                        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this);
                        aVar.setCanceledOnTouchOutside(false);
                        aVar.setTitle(R.string.request_permission_default_title);
                        aVar.setMessageId(R.string.request_window_permission_default_text);
                        aVar.setPositiveButton(R.string.isopen, new a.e(this) { // from class: com.baidu.tbadk.BaseActivity.8
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

                            @Override // c.a.q0.s.s.a.e
                            public void onClick(c.a.q0.s.s.a aVar2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                                    aVar2.dismiss();
                                    try {
                                        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                                        intent.setData(Uri.parse("package:" + this.this$0.getPackageName()));
                                        this.this$0.startActivityForResult(intent, 12016);
                                    } catch (Exception unused) {
                                        this.this$0.showToast(R.string.request_window_permission_default_text_by_yourself);
                                        if (this.this$0.mPermissionCallback != null) {
                                            this.this$0.mPermissionCallback.onPermissionResult(false);
                                        }
                                    }
                                }
                            }
                        }).setNegativeButton(R.string.cancel, new a.e(this) { // from class: com.baidu.tbadk.BaseActivity.7
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

                            @Override // c.a.q0.s.s.a.e
                            public void onClick(c.a.q0.s.s.a aVar2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                                    aVar2.dismiss();
                                    if (this.this$0.mPermissionCallback != null) {
                                        this.this$0.mPermissionCallback.onPermissionResult(false);
                                    }
                                }
                            }
                        }).create(getPageContext());
                        aVar.show();
                        c.a.q0.s.d0.b.j().t("key_is_window_permission_dialog_shown", true);
                    } else {
                        c.a.q0.s.e eVar2 = this.mPermissionCallback;
                        if (eVar2 != null) {
                            eVar2.onPermissionResult(false);
                        }
                    }
                    return false;
                } else if (eVar != null) {
                    eVar.onPermissionResult(true);
                }
            } else if (eVar != null) {
                eVar.onPermissionResult(true);
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
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || (bVar = this.mListMenu) == null) {
            return;
        }
        bVar.e();
    }

    public void hideLoadingView(View view) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, view) == null) || (gVar = this.loadingView) == null) {
            return;
        }
        gVar.dettachView(view);
    }

    public void hideNetRefreshView(View view) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, view) == null) || (hVar = this.mRefreshView) == null) {
            return;
        }
        hVar.dettachView(view);
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
            g gVar = this.loadingView;
            if (gVar == null) {
                return false;
            }
            return gVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mIsLogin : invokeV.booleanValue;
    }

    public boolean isProgressBarShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            ContinuousAnimationView continuousAnimationView = this.mProgressBar;
            return continuousAnimationView != null && continuousAnimationView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isSwipeBackEnabled() {
        InterceptResult invokeV;
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mUseStyleImmersiveSticky : invokeV.booleanValue;
    }

    public b newListMenu(String[] strArr, b.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048641, this, strArr, cVar)) == null) {
            b bVar = new b(getPageContext().getPageActivity());
            this.mListMenu = bVar;
            bVar.l(TbadkCoreApplication.getInst().getResources().getString(R.string.operation));
            this.mListMenu.j(strArr, cVar);
            this.mListMenu.c(getPageContext());
            return this.mListMenu;
        }
        return (b) invokeLL.objValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048642, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            c.a.q0.s.e eVar = this.mPermissionCallback;
            if (eVar != null && Build.VERSION.SDK_INT >= 23 && i2 == 12016) {
                eVar.onPermissionResult(Settings.canDrawOverlays(getBaseContext()));
                this.mPermissionCallback = null;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            super.onAttachedToWindow();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            g gVar = this.loadingView;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
            if (swipeBackLayout != null) {
                swipeBackLayout.onChangeSkinType(i2);
            }
            d dVar = this.mKeyboardAdjust;
            if (dVar != null) {
                dVar.j(i2);
            }
            if (this.mUseStyleImmersiveSticky) {
                this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
            }
            b bVar = this.mListMenu;
            if (bVar != null) {
                bVar.b(getPageContext());
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration == null) {
                return;
            }
            int i2 = configuration.orientation;
            if (i2 == this.mLastOrientation) {
                if (configuration.screenWidthDp != this.mLastScreenWidth || configuration.screenHeightDp != this.mLastScreenHeight) {
                    this.mLastScreenWidth = configuration.screenWidthDp;
                    this.mLastScreenHeight = configuration.screenHeightDp;
                    l.f2570a = false;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921414, getUniqueId()));
                }
            } else {
                this.mLastOrientation = i2;
            }
            if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                MessageManager.getInstance().dispatchResponsedMessage(new ConfigChangeMessage(Boolean.valueOf(KuangFloatingWindowController.currentStatus)));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, bundle) == null) {
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
            this.mLayoutMode = new c();
            c.a.q0.s.a aVar = new c.a.q0.s.a();
            this.mLayoutInflateFactory = aVar;
            aVar.a(this.mLayoutMode);
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
            this.mScreenShotListenManager = new g0(this);
            SpeedStats.getInstance().onBaseActivityCreate(this);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            closeLoadingDialog();
            GuidPageView guidPageView = this.mGuidPage;
            if (guidPageView != null) {
                guidPageView.recycleBitmap();
            }
            c cVar = this.mLayoutMode;
            if (cVar != null) {
                cVar.c();
            }
            View view = this.loadingRootView;
            if (view != null) {
                hideLoadingView(view);
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
            c.a.e.e.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048648, this, i2, keyEvent)) == null) {
            if (i2 == 82) {
                try {
                    if (keyEvent.isLongPress()) {
                        return true;
                    }
                } catch (IllegalStateException unused) {
                    if (i2 == 4) {
                        finish();
                        return true;
                    }
                    return false;
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048649, this, i2, keyEvent)) == null) {
            try {
                return super.onKeyUp(i2, keyEvent);
            } catch (IllegalStateException unused) {
                if (i2 == 4) {
                    finish();
                    return true;
                }
                return true;
            }
        }
        return invokeIL.booleanValue;
    }

    public void onKeyboardHeightChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
        }
    }

    @Override // c.a.q0.a.p
    public boolean onMissionCompleted(CompleteTaskToastData completeTaskToastData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, completeTaskToastData)) == null) {
            hideClickableTextToast();
            this.mClickableTextToast = s.i(completeTaskToastData);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            c.a.r0.p3.a.getInstance().onPause(this);
            super.onPause();
            if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                hideFloatingWindow();
            }
            if (this.lastResumeTime != 0 && !this.isInterceptStimeStat && !this.isForceInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                c.a.q0.o0.d pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                c.a.q0.o0.e.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
            this.customToast.onPause();
            stopScreenShotListen();
            TbadkCoreApplication.getInst().DelResumeNum();
            TbadkCoreApplication.getInst().setCurrentActivity(null);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
            if (this.isAddSwipeBackLayout) {
                c.a.e.e.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
                c.a.e.e.m.e.a().postDelayed(this.setNoTranslucentRunnable, 1000L);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, c.a.e.a.i
    public void onPreLoad(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, qVar) == null) {
            super.onPreLoad(qVar);
            PreLoadImageHelper.load(qVar, getUniqueId());
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        PermissionJudgePolicy permissionJudgePolicy2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048656, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (iArr == null || iArr.length <= 0 || strArr == null || strArr.length <= 0) {
                return;
            }
            boolean z = false;
            if (iArr[0] != 0 && (permissionJudgePolicy2 = this.mCurrentPermissionJudgePolicy) != null) {
                permissionJudgePolicy2.checkPermissionForbidden(this, strArr[0]);
            }
            int i3 = 0;
            while (true) {
                if (i3 >= strArr.length) {
                    z = true;
                    break;
                } else if (iArr[i3] != 0) {
                    break;
                } else {
                    i3++;
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
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            super.onRestart();
            flog = 0;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            MenuKeyUtils.hideSoftMenuKey(getWindow());
            super.onResume();
            c.a.r0.p3.a.getInstance().onResume(this);
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
                c.a.e.e.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
                j0.b(this);
            }
        }
    }

    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            super.onStart();
            flog = 0;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            super.onStop();
            if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                flog = 1;
            }
            onResourceRecycle();
        }
    }

    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048663, this, z) == null) {
        }
    }

    public void publishEvent(c.a.q0.j0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.getTag() == 0) {
            aVar.setTag(getUniqueId());
        }
        c.a.q0.j0.h.i(aVar);
    }

    public void quitDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            UtilHelper.quitDialog(getPageContext().getPageActivity());
        }
    }

    public void registerResponsedEventListener(Class<? extends c.a.q0.j0.a> cls, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048666, this, cls, iVar) == null) {
            c.a.q0.j0.h.f().m(cls, iVar, getUniqueId());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
        }
    }

    public void setActivityBgTransparent() {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.setBgTransparent();
    }

    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            s.h(getPageId(), getMissionTid());
        }
    }

    public void setCurrentPermissionJudgePolicy(PermissionJudgePolicy permissionJudgePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, permissionJudgePolicy) == null) {
            this.mCurrentPermissionJudgePolicy = permissionJudgePolicy;
        }
    }

    public void setExcludeHeight(int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048671, this, i2) == null) || (dVar = this.mKeyboardAdjust) == null) {
            return;
        }
        dVar.m(i2);
    }

    public void setForceInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            this.isForceInterceptStimeStat = z;
        }
    }

    public void setInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            this.isInterceptStimeStat = z;
        }
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.isAddSwipeBackLayout = z;
        }
    }

    public void setLayoutInflate(c.a.q0.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, aVar) == null) {
            this.mLayoutInflateFactory = aVar;
        }
    }

    public void setLayoutMode(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, cVar) == null) {
            this.mLayoutMode = cVar;
        }
    }

    public void setNetRefreshLayoutMarginTop(boolean z) {
        h hVar;
        int a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048677, this, z) == null) && (hVar = this.mRefreshView) != null && hVar.isViewAttached() && this.mRefreshView.b() != null && (this.mRefreshView.b().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            if (z) {
                a2 = BdListViewHelper.b(BdListViewHelper.HeadType.DEFAULT, false);
            } else {
                a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            }
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.b().getLayoutParams()).topMargin = a2;
        }
    }

    @Deprecated
    public void setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(boolean z) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048678, this, z) == null) && (hVar = this.mRefreshView) != null && hVar.isViewAttached() && this.mRefreshView.b() != null && (this.mRefreshView.b().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.b().getLayoutParams()).topMargin = BdListViewHelper.b(BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            setNetRefreshViewEmotionMarginTop(l.g(getApplicationContext(), R.dimen.ds300));
        }
    }

    public void setNetRefreshViewEmotionMarginTop(int i2) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048680, this, i2) == null) && (hVar = this.mRefreshView) != null && hVar.isViewAttached()) {
            this.mRefreshView.j(i2);
        }
    }

    public void setNetRefreshViewTopMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048681, this, i2) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.j(i2);
        }
    }

    public void setSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i2) == null) {
            this.mSkinType = i2;
        }
    }

    public void setSwipeBackEnabled(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048683, this, z) == null) && TbadkCoreApplication.IS_SUPPORT_SWIPEBACK && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setSwipeBackEnabled(z);
        }
    }

    public void setSwipeBackIsSupportNight(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048684, this, z) == null) || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.setIsSupportNight(z);
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z) == null) {
            this.mUseStyleImmersiveSticky = z;
        }
    }

    public boolean showDialog(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, dialog)) == null) {
            if (c.a.e.e.m.g.j(dialog, getPageContext())) {
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
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            grantWindowPermission(new c.a.q0.s.e(this) { // from class: com.baidu.tbadk.BaseActivity.10
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

                @Override // c.a.q0.s.e
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
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || (bVar = this.mListMenu) == null) {
            return;
        }
        bVar.m();
    }

    public void showLoadingDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, str) == null) {
            showLoadingDialog(str, (DialogInterface.OnCancelListener) null);
        }
    }

    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, view) == null) {
            showLoadingView(view, false);
        }
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048698, this, view, str, z) == null) {
            showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
        }
    }

    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048700, this, view, str, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.l(str);
            this.mRefreshView.attachView(view, z);
            this.mRefreshView.e();
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048701, this, popupWindow, view)) == null) {
            if (c.a.e.e.m.g.k(popupWindow, view)) {
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

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048703, this, new Object[]{popupWindow, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (c.a.e.e.m.g.m(popupWindow, view, i2, i3, i4)) {
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
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            try {
                showProgressBarWithOffset(0, 0);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void showProgressBarWithOffset(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048706, this, i2, i3) == null) {
            showProgressBar(false, i2, i3);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, str) == null) {
            String name = getClass().getName();
            String str2 = getApplicationContext().getPackageName() + ".chat";
            if (!name.startsWith(getApplicationContext().getPackageName() + ".im") && !name.startsWith(str2)) {
                l.M(getPageContext().getContext(), str);
            } else {
                this.customToast.showToast(str, 2000);
            }
        }
    }

    public void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048713, this, str, defaultIcon, i2) == null) {
            BdToast.g(getPageContext().getContext(), str, defaultIcon, i2).q();
        }
    }

    public void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048714, this, str, defaultIcon) == null) {
            BdToast.f(getPageContext().getContext(), str, defaultIcon).q();
        }
    }

    public void showToastWithIcon(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048715, this, str, i2) == null) {
            BdToast.i(getPageContext().getContext(), str, i2, false).q();
        }
    }

    public void showToastWithIconDuration(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048716, this, str, i2, i3) == null) {
            BdToast.h(getPageContext().getContext(), str, i2, i3, false).q();
        }
    }

    public void skipToLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
        }
    }

    public void skipToRegisterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            ViewHelper.skipToRegisterActivity(getPageContext().getPageActivity());
        }
    }

    public void startAnimatable(Animatable animatable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048719, this, animatable) == null) || animatable == null || isFinishing()) {
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

    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048720, this, view, animation, animationListener) == null) || animation == null || isFinishing()) {
            return;
        }
        WeakReference<View> weakReference = new WeakReference<>(view);
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            view.startAnimation(animation);
        } catch (Throwable unused) {
        }
    }

    public void unRegisterResponsedEventListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            c.a.q0.j0.h.f().n(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.BdBaseActivity, c.a.e.a.g
    public TbPageContext<T> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            try {
                if (this.pageContext == null && mClazz4GetPageContext != null) {
                    this.pageContext = mClazz4GetPageContext.getConstructor(BaseActivity.class).newInstance(this);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this.pageContext;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048690, this, str, onCancelListener) == null) {
            showLoadingDialog(str, onCancelListener, true);
        }
    }

    public void showLoadingView(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048695, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.loadingRootView = view;
            if (this.loadingView == null) {
                if (i2 < 0) {
                    this.loadingView = new g(getPageContext().getContext());
                } else {
                    g gVar = new g(getPageContext().getContext(), i2);
                    this.loadingView = gVar;
                    gVar.h();
                }
                this.loadingView.onChangeSkinType();
            }
            this.loadingView.attachView(view, z);
        }
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048697, this, new Object[]{view, str, str2, str3, Boolean.valueOf(z), onClickListener}) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getContext(), onClickListener);
            }
            this.mRefreshView.m(str);
            this.mRefreshView.l(str2);
            this.mRefreshView.g(str3);
            this.mRefreshView.attachView(view, z);
            this.mRefreshView.o();
        }
    }

    public void showLoadingDialog(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048692, this, str, z) == null) {
            showLoadingDialog(str, null, true);
        }
    }

    public void showProgressBar(boolean z, int i2, int i3) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048705, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (this.mProgressBar == null) {
                try {
                    this.mProgressBar = new ContinuousAnimationView(getPageContext().getPageActivity());
                    FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
                    int g2 = l.g(getPageContext().getPageActivity(), R.dimen.tbds200);
                    frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(g2, g2, 17));
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
                continuousAnimationView2.setPadding(l.e(getPageContext().getPageActivity(), i2), l.e(getPageContext().getPageActivity(), i3), 0, 0);
                this.mProgressBar.setVisibility(0);
                this.mProgressBar.setSpeed(1.3f);
                this.mProgressBar.setMinAndMaxProgress(0.0f, 1.0f);
                this.mProgressBar.playAnimation();
            }
        }
    }

    public void ShowSoftKeyPadDelay(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            ShowSoftKeyPadDelay(view, 150);
        }
    }

    public void adjustResizeForSoftInput(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = d.d(getPageContext().getPageActivity(), i2, z);
        }
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048691, this, str, onCancelListener, z) == null) && !isFinishing() && c.a.e.e.m.g.f(getPageContext())) {
            if (str == null) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.Waiting);
            }
            c.a.q0.s.f0.a aVar = new c.a.q0.s.f0.a((TbPageContext<?>) getPageContext());
            this.mWaitingDialog = aVar;
            aVar.j(str);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(z);
            this.mWaitingDialog.h(true);
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048702, this, popupWindow, view, i2, i3)) == null) {
            if (c.a.e.e.m.g.l(popupWindow, view, i2, i3)) {
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

    public void showNetRefreshViewNoClick(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048699, this, view, str) == null) {
            showNetRefreshViewNoClick(view, str, false);
        }
    }

    public void adjustResizeForSoftInput(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = d.e(getPageContext().getPageActivity(), z);
        }
    }

    public void showToast(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048711, this, str, i2) == null) {
            this.customToast.showToast(str, 2000, i2);
        }
    }

    public void showToast(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048708, this, i2, i3) == null) {
            this.customToast.showToast(i2, 2000, i3);
        }
    }

    public void showLoadingView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048694, this, view, z) == null) {
            showLoadingView(view, z, -1);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048696, this, view, str) == null) {
            showNetRefreshView(view, str, false);
        }
    }

    public void showToast(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i2) == null) {
            l.L(getPageContext().getContext(), i2);
        }
    }

    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048712, this, str, z) == null) {
            if (z) {
                showToast(str);
            } else {
                l.M(getPageContext().getContext(), str);
            }
        }
    }

    public void showToast(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048709, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                showToast(i2);
            } else {
                l.L(getPageContext().getContext(), i2);
            }
        }
    }
}
