package com.baidu.tbadk.core;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c.a.d.f.p.n;
import c.a.d.n.e.q;
import c.a.s0.a.p;
import c.a.s0.a.s;
import c.a.s0.e1.i0;
import c.a.s0.e1.l0;
import c.a.s0.s.s.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseFragmentActivity;
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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.IPermissionPolicy;
import com.baidu.tbadk.KuangFloatingWindowController;
import com.baidu.tbadk.MainAPKFragmentActivityPageContext;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.ConfigChangeMessage;
import com.baidu.tbadk.core.message.KeyBoardSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.VirtualBarAssist;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
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
/* loaded from: classes11.dex */
public abstract class BaseFragmentActivity extends BdBaseFragmentActivity<BaseFragmentActivity> implements TbPageContextSupport, c.a.s0.q0.a, p, Object, c.a.s0.p0.a, IVideoNeedPreload, IPermissionPolicy {
    public static /* synthetic */ Interceptable $ic = null;
    public static int flog = 1;
    public static Class<? extends TbPageContext<BaseFragmentActivity>> mClazz4GetPageContext;
    public transient /* synthetic */ FieldHolder $fh;
    public final int SHOW_SOFT_KEYBOARD_DELAY;
    public List<Animatable> animatableList;
    public List<WeakReference<View>> animationList;
    public List<Dialog> dialogList;
    public String fromPageName;
    public boolean isAddSwipeBackLayout;
    public boolean isForceInterceptStimeStat;
    public boolean isInterceptStimeStat;
    public boolean isResumed;
    public c.a.s0.s.a0.b keyboardHeightProvider;
    public Runnable keyboardHeightRunnable;
    public long lastResumeTime;
    public View loadingRootView;
    public c.a.s0.g0.g loadingView;
    public int mAboveKeyboardHeight;
    public ViewGroup mActivityRootView;
    public BuoyComponent mBuoyTaskComponent;
    public c.a.s0.s.s.f mClickableTextToast;
    public String mCurAccountId;
    public PermissionJudgePolicy mCurrentPermissionJudgePolicy;
    public DialogInterface.OnCancelListener mDialogListener;
    public boolean mHideStatusImmersiveStyle;
    public boolean mIsHasScreenShotListener;
    public boolean mIsLogin;
    public c.a.s0.s.i0.d mKeyboardAdjust;
    public int mLastOrientation;
    public int mLastScreenHeight;
    public int mLastScreenWidth;
    public boolean mLayoutHasInit;
    public c.a.s0.s.c mLayoutMode;
    public int mMaxHeight;
    public c.a.s0.o0.c mPageExtra;
    public c.a.s0.s.e mPermissionCallback;
    public int mPreHeight;
    public ProgressBar mProgressBar;
    public c.a.s0.g0.h mRefreshView;
    public i0 mScreenShotListenManager;
    public int mSkinType;
    public SwipeBackLayout mSwipeBackLayout;
    public TbPageTag mTbPageTag;
    public boolean mUseStyleImmersiveSticky;
    public VirtualBarAssist mVirtualBarAssist;
    public c.a.s0.s.i0.a mWaitingDialog;
    public m netRefreshListener;
    public final CustomMessageListener nightResourcesChangeListener;
    public TbPageContext<BaseFragmentActivity> pageContext;
    public c.a.s0.q0.d pageStayDurationItem;
    public List<PopupWindow> popupWindowList;
    public c.a.d.f.m.c resourcesWrapper;
    public Runnable setNoTranslucentRunnable;
    public final CustomMessageListener skinTypeChangeListener;

    /* loaded from: classes11.dex */
    public class a implements i0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        public a(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // c.a.s0.e1.i0.b
        public void onShot(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.getCurrentPageKey() != "a001" && this.a.getCurrentPageKey() != "a005" && this.a.getCurrentPageKey() != "a006") {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 4));
                }
                this.a.onScreenShot(str);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements c.a.s0.s.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        public b(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // c.a.s0.s.e
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                TbadkCoreApplication.getInst().setCurrentActivity(this.a.getPageContext().getPageActivity());
                if (KuangFloatingWindowController.getInstance().init()) {
                    TbSingleton.getInstance().isShowBackLabel = true;
                    KuangFloatingWindowController.getInstance().showFloatingView();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseFragmentActivity f41514e;

        public c(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41514e = baseFragmentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f41514e.keyboardHeightProvider == null) {
                    this.f41514e.keyboardHeightProvider = new c.a.s0.s.a0.b(this.f41514e);
                }
                this.f41514e.keyboardHeightProvider.h();
                if (this.f41514e.isResumed) {
                    this.f41514e.keyboardHeightProvider.g(this.f41514e);
                } else {
                    this.f41514e.keyboardHeightProvider.g(null);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseFragmentActivity f41515e;

        public d(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41515e = baseFragmentActivity;
        }

        public final void a(int i2) {
            int height;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                View findViewById = this.f41515e.findViewById(16908290);
                if (findViewById instanceof ViewGroup) {
                    boolean z = false;
                    View childAt = ((ViewGroup) findViewById).getChildAt(0);
                    if (childAt == null || (height = childAt.getHeight()) == this.f41515e.mAboveKeyboardHeight) {
                        return;
                    }
                    int i3 = (i2 * 2) / 3;
                    boolean z2 = height < i3;
                    if (this.f41515e.mAboveKeyboardHeight != 0 && this.f41515e.mAboveKeyboardHeight < i3) {
                        z = true;
                    }
                    if (z2 != z) {
                        this.f41515e.onKeyboardVisibilityChanged(z2);
                        if ((TbSingleton.getInstance().isShowBackLabel || TbSingleton.getInstance().isShowVoiceFloat()) && this.f41515e == TbadkCoreApplication.getInst().getCurrentActivity()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new KeyBoardSwitchMessage(Boolean.valueOf(z)));
                        }
                    }
                    this.f41515e.mAboveKeyboardHeight = height;
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    View findViewById = this.f41515e.findViewById(16908290);
                    int height = findViewById != null ? findViewById.getHeight() : 0;
                    int height2 = this.f41515e.getWindow().getDecorView().getRootView().getHeight();
                    if (!this.f41515e.mLayoutHasInit) {
                        this.f41515e.mLayoutHasInit = true;
                        this.f41515e.mMaxHeight = height;
                    } else {
                        this.f41515e.mMaxHeight = this.f41515e.mMaxHeight < height ? height : this.f41515e.mMaxHeight;
                    }
                    if (this.f41515e.mLayoutHasInit && this.f41515e.mMaxHeight > height && height != this.f41515e.mPreHeight) {
                        int i2 = this.f41515e.mMaxHeight - height;
                        if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (height2 * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                            TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                            this.f41515e.onKeyboardHeightChanged(i2);
                        }
                    }
                    a(height2);
                    this.f41515e.mPreHeight = height;
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseFragmentActivity f41516e;

        public e(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41516e = baseFragmentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41516e.isFinishing()) {
                return;
            }
            l0.a(this.f41516e);
        }
    }

    /* loaded from: classes11.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseFragmentActivity f41517e;

        public f(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41517e = baseFragmentActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f41517e.mWaitingDialog = null;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation.AnimationListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WeakReference f41518b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaseFragmentActivity f41519c;

        public g(BaseFragmentActivity baseFragmentActivity, Animation.AnimationListener animationListener, WeakReference weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity, animationListener, weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41519c = baseFragmentActivity;
            this.a = animationListener;
            this.f41518b = weakReference;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Animation.AnimationListener animationListener = this.a;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                }
                synchronized (this.f41519c.animationList) {
                    this.f41519c.animationList.remove(this.f41518b);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) || (animationListener = this.a) == null) {
                return;
            }
            animationListener.onAnimationRepeat(animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (animationListener = this.a) == null) {
                return;
            }
            animationListener.onAnimationStart(animation);
        }
    }

    /* loaded from: classes11.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(BaseFragmentActivity baseFragmentActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005017 || this.a.mLayoutMode == null) {
                return;
            }
            this.a.mLayoutMode.l(null);
            if (this.a.mKeyboardAdjust != null) {
                this.a.mKeyboardAdjust.j(TbadkCoreApplication.getInst().getSkinType());
            }
            this.a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(BaseFragmentActivity baseFragmentActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (this.a.shouldChangeStatusBarIconAndTextColor()) {
                    boolean z = true;
                    if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        z = false;
                    }
                    UtilHelper.changeStatusBarIconAndTextColor(z, this.a);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseFragmentActivity f41520e;

        public j(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41520e = baseFragmentActivity;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f41520e.mPermissionCallback != null) {
                    this.f41520e.mPermissionCallback.onPermissionResult(false);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseFragmentActivity f41521e;

        public k(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41521e = baseFragmentActivity;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                try {
                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    intent.setData(Uri.parse("package:" + this.f41521e.getPackageName()));
                    this.f41521e.startActivityForResult(intent, 12016);
                } catch (Exception unused) {
                    this.f41521e.showToast(R.string.request_window_permission_default_text_by_yourself);
                    if (this.f41521e.mPermissionCallback != null) {
                        this.f41521e.mPermissionCallback.onPermissionResult(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View f41522e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseFragmentActivity f41523f;

        public l(BaseFragmentActivity baseFragmentActivity, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41523f = baseFragmentActivity;
            this.f41522e = null;
            this.f41522e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41523f.isFinishing()) {
                return;
            }
            this.f41523f.ShowSoftKeyPad((InputMethodManager) this.f41523f.getSystemService("input_method"), this.f41522e);
        }
    }

    /* loaded from: classes11.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseFragmentActivity f41524e;

        public m(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41524e = baseFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f41524e.onNetRefreshButtonClicked();
            }
        }

        public /* synthetic */ m(BaseFragmentActivity baseFragmentActivity, c cVar) {
            this(baseFragmentActivity);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(658138110, "Lcom/baidu/tbadk/core/BaseFragmentActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(658138110, "Lcom/baidu/tbadk/core/BaseFragmentActivity;");
                return;
            }
        }
        mClazz4GetPageContext = MainAPKFragmentActivityPageContext.class;
    }

    public BaseFragmentActivity() {
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
        this.mDialogListener = null;
        this.mSkinType = 3;
        this.mIsLogin = false;
        this.mCurAccountId = TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount();
        this.SHOW_SOFT_KEYBOARD_DELAY = 150;
        this.isAddSwipeBackLayout = true;
        this.mUseStyleImmersiveSticky = UtilHelper.canUseStyleImmersiveSticky();
        this.mHideStatusImmersiveStyle = false;
        this.mKeyboardAdjust = null;
        this.mLayoutHasInit = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mAboveKeyboardHeight = 0;
        this.mCurrentPermissionJudgePolicy = null;
        this.mLastScreenWidth = 0;
        this.mLastScreenHeight = 0;
        this.mLastOrientation = 1;
        this.mIsHasScreenShotListener = false;
        this.isInterceptStimeStat = false;
        this.isForceInterceptStimeStat = false;
        this.keyboardHeightRunnable = new c(this);
        this.setNoTranslucentRunnable = new e(this);
        this.nightResourcesChangeListener = new h(this, 2005017);
        this.skinTypeChangeListener = new i(this, 2001304);
    }

    private String getCurrentExtraPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            String currentPageKey = getCurrentPageKey();
            return TextUtils.isEmpty(currentPageKey) ? getClass().getSimpleName() : currentPageKey;
        }
        return (String) invokeV.objValue;
    }

    private void hideClickableTextToast() {
        c.a.s0.s.s.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (fVar = this.mClickableTextToast) == null) {
            return;
        }
        fVar.e();
    }

    public static void setClazz4GetPageContext(Class<? extends TbPageContext<BaseFragmentActivity>> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, cls) == null) {
            mClazz4GetPageContext = cls;
        }
    }

    private void startScreenShotListen() {
        i0 i0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || this.mIsHasScreenShotListener || (i0Var = this.mScreenShotListenManager) == null) {
            return;
        }
        i0Var.i(new a(this));
        this.mScreenShotListenManager.j();
        this.mIsHasScreenShotListener = true;
    }

    private void stopScreenShotListen() {
        i0 i0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && this.mIsHasScreenShotListener && (i0Var = this.mScreenShotListenManager) != null) {
            i0Var.k();
            this.mIsHasScreenShotListener = false;
        }
    }

    public void DeinitWaitingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mWaitingDialog = null;
        }
    }

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputMethodManager, view) == null) {
            try {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void ShowSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputMethodManager, view) == null) || view == null || inputMethodManager == null) {
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
        if (interceptable == null || interceptable.invokeLI(1048580, this, view, i2) == null) {
            new Handler().postDelayed(new l(this, view), i2);
        }
    }

    public void addGlobalLayoutListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
        }
    }

    public void addNoAdjustSoftInputHeightListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.keyboardHeightRunnable, 1000L);
        }
    }

    public void adjustResizeBottomVirtualBar() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.mVirtualBarAssist == null) {
            this.mVirtualBarAssist = VirtualBarAssist.assistActivity(getActivity());
        }
    }

    public void adjustResizeForSoftInput() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = c.a.s0.s.i0.d.c(getPageContext().getPageActivity());
        }
    }

    public void adjustResizeForSoftInputOnDestory() {
        c.a.s0.s.i0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (dVar = this.mKeyboardAdjust) == null) {
            return;
        }
        dVar.i();
        this.mKeyboardAdjust = null;
    }

    public void adjustResizeForSoftInputOnSkinTypeChanged(int i2) {
        c.a.s0.s.i0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (dVar = this.mKeyboardAdjust) == null) {
            return;
        }
        dVar.j(i2);
    }

    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 == this.mSkinType) {
            return;
        }
        this.mSkinType = i2;
        try {
            if (this.mSwipeBackLayout != null) {
                this.mSwipeBackLayout.onChangeSkinType(i2);
            }
            if (this.loadingView != null) {
                this.loadingView.onChangeSkinType();
            }
            if (this.mUseStyleImmersiveSticky) {
                this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
            }
            onChangeSkinType(this.mSkinType);
        } catch (OutOfMemoryError unused) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, responsedMessage)) == null) ? (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true : invokeL.booleanValue;
    }

    public boolean checkUpIsLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) : invokeV.booleanValue;
    }

    public void clearAnimatable() {
        List<Animatable> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (list = this.animatableList) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (list = this.animationList) == null) {
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

    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
        }
    }

    public void closeLoadingDialog() {
        c.a.s0.s.i0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (aVar = this.mWaitingDialog) == null) {
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
            c.a.d.f.m.g.b(dialog, getPageContext());
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
            c.a.d.f.m.g.d(popupWindow, getPageContext().getPageActivity());
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
            c.a.d.f.m.g.b(dialog, getPageContext());
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
            c.a.d.f.m.g.d(popupWindow, getPageContext().getPageActivity());
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
            c.a.t0.b4.a.getInstance().behaviorRecordEvent(motionEvent, this);
            return super.dispatchTouchEvent(motionEvent);
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
            n.w(getApplicationContext(), getWindow().getDecorView());
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

    public ViewGroup getActivityRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mActivityRootView : (ViewGroup) invokeV.objValue;
    }

    @Override // c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.q0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    public c.a.s0.s.c getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mLayoutMode : (c.a.s0.s.c) invokeV.objValue;
    }

    public c.a.s0.s.i0.a getLoadingDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mWaitingDialog : (c.a.s0.s.i0.a) invokeV.objValue;
    }

    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    public View.OnClickListener getNetRefreshListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.netRefreshListener == null) {
                this.netRefreshListener = new m(this, null);
            }
            return this.netRefreshListener;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // c.a.s0.q0.a
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
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
                Fragment visibleFragment = getVisibleFragment();
                if (visibleFragment instanceof c.a.s0.q0.a) {
                    String currentPageKey2 = ((c.a.s0.q0.a) visibleFragment).getCurrentPageKey();
                    if (!StringUtils.isNull(currentPageKey2)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(currentPageKey2);
                    }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            BdUniqueId uniqueId = getUniqueId();
            if (uniqueId != null) {
                return uniqueId.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public c.a.s0.q0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.pageStayDurationItem == null) {
                c.a.s0.q0.d dVar = new c.a.s0.q0.d();
                this.pageStayDurationItem = dVar;
                dVar.s(getCurrentPageKey());
            }
            this.pageStayDurationItem.x(getCurrentPageSourceKeyList());
            return this.pageStayDurationItem;
        }
        return (c.a.s0.q0.d) invokeV.objValue;
    }

    @Override // c.a.s0.q0.a
    public c.a.s0.q0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return null;
        }
        return (c.a.s0.q0.b) invokeV.objValue;
    }

    public String getPreExtraPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            c.a.s0.o0.c tbPageExtra = getTbPageExtra();
            return tbPageExtra != null ? tbPageExtra.e() : "";
        }
        return (String) invokeV.objValue;
    }

    public final TbPageTag getPrePageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? c.a.s0.p0.c.m(getIntent()) : (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                return super.getResources();
            }
            if (this.resourcesWrapper == null) {
                this.resourcesWrapper = new c.a.d.f.m.c(super.getResources());
            }
            return this.resourcesWrapper;
        }
        return (Resources) invokeV.objValue;
    }

    public int getSkinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? TbadkCoreApplication.getInst().getSkinType() : invokeV.intValue;
    }

    public c.a.s0.o0.c getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.mPageExtra == null) {
                this.mPageExtra = new c.a.s0.o0.c(getUniqueId(), getCurrentExtraPageKey(), "", getIntent());
            }
            return this.mPageExtra;
        }
        return (c.a.s0.o0.c) invokeV.objValue;
    }

    @Override // c.a.s0.p0.a
    public final c.a.s0.p0.b getTbPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? new c.a.s0.p0.b(getUniqueId(), getTbPageTag(), getIntent()) : (c.a.s0.p0.b) invokeV.objValue;
    }

    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.mTbPageTag == null) {
                TbPageTag tbPageTag = new TbPageTag();
                this.mTbPageTag = tbPageTag;
                tbPageTag.locatePage = getCurrentPageKey();
            }
            return this.mTbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public Fragment getVisibleFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            List<Fragment> fragments = supportFragmentManager != null ? supportFragmentManager.getFragments() : null;
            if (ListUtils.isEmpty(fragments)) {
                return null;
            }
            for (Fragment fragment : fragments) {
                if ((fragment instanceof BaseFragment) && ((BaseFragment) fragment).isPrimary()) {
                    return fragment;
                }
            }
            return null;
        }
        return (Fragment) invokeV.objValue;
    }

    public boolean grantWindowPermission(c.a.s0.s.e eVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048627, this, eVar, z)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!Settings.canDrawOverlays(getBaseContext())) {
                    this.mPermissionCallback = eVar;
                    boolean g2 = c.a.s0.s.g0.b.j().g("key_is_window_permission_dialog_shown", false);
                    if (z) {
                        g2 = false;
                    }
                    if (!g2) {
                        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this);
                        aVar.setCanceledOnTouchOutside(false);
                        aVar.setTitle(R.string.request_permission_default_title);
                        aVar.setMessageId(R.string.request_window_permission_default_text);
                        aVar.setPositiveButton(R.string.isopen, new k(this)).setNegativeButton(R.string.cancel, new j(this)).create(getPageContext());
                        aVar.show();
                        c.a.s0.s.g0.b.j().t("key_is_window_permission_dialog_shown", true);
                    } else {
                        c.a.s0.s.e eVar2 = this.mPermissionCallback;
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
        return invokeLZ.booleanValue;
    }

    public void hideFloatingWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            KuangFloatingWindowController.getInstance().hideFloatingView();
        }
    }

    public void hideLoadingView(View view) {
        c.a.s0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, view) == null) || (gVar = this.loadingView) == null) {
            return;
        }
        gVar.dettachView(view);
    }

    public void hideNetRefreshView(View view) {
        c.a.s0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, view) == null) || (hVar = this.mRefreshView) == null) {
            return;
        }
        hVar.dettachView(view);
    }

    public void hideProgressBar() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || (progressBar = this.mProgressBar) == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    public boolean isForceInterceptStimeStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.isForceInterceptStimeStat : invokeV.booleanValue;
    }

    public boolean isLoadingViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            c.a.s0.g0.g gVar = this.loadingView;
            if (gVar == null) {
                return false;
            }
            return gVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isProgressBarShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            ProgressBar progressBar = this.mProgressBar;
            return progressBar != null && progressBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isSwipeBackEnabled() {
        InterceptResult invokeV;
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mUseStyleImmersiveSticky : invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        c.a.s0.s.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048637, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (!c.a.s0.f1.a.c(i2, i3, intent) && (eVar = this.mPermissionCallback) != null && Build.VERSION.SDK_INT >= 23 && i2 == 12016) {
                eVar.onPermissionResult(Settings.canDrawOverlays(getBaseContext()));
                this.mPermissionCallback = null;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            super.onAttachedToWindow();
        }
    }

    public abstract void onChangeSkinType(int i2);

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration == null) {
                return;
            }
            int i2 = configuration.orientation;
            if (i2 == this.mLastOrientation) {
                if (configuration.screenWidthDp != this.mLastScreenWidth || configuration.screenHeightDp != this.mLastScreenHeight) {
                    this.mLastScreenWidth = configuration.screenWidthDp;
                    this.mLastScreenHeight = configuration.screenHeightDp;
                    n.a = false;
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

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, bundle) == null) {
            boolean z = false;
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
                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", false);
                BdSocketLinkService.startService(false, "app start");
            }
            if (this.mUseStyleImmersiveSticky) {
                this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity(), this.mHideStatusImmersiveStyle);
                UtilHelper.changeStatusBarIconAndTextColor((TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true, this);
            }
            MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
            super.onCreate(bundle);
            if (getGpuSwitch()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            TbadkCoreApplication.setIsAppRunning(true);
            TiebaStaticHelper.setCurrentActivity(getClass().getName());
            this.mLayoutMode = new c.a.s0.s.c();
            registerListener(this.nightResourcesChangeListener);
            registerListener(this.skinTypeChangeListener);
            enterExitAnimation();
            this.keyboardHeightProvider = new c.a.s0.s.a0.b(this);
            this.mIsLogin = TbadkCoreApplication.isLogin();
            this.mScreenShotListenManager = new i0(this);
            SpeedStats.getInstance().onBaseActivityCreate(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048642, this, str, context, attributeSet)) == null) {
            if (this.mLayoutMode == null) {
                this.mLayoutMode = new c.a.s0.s.c();
            }
            this.mLayoutMode.i(str, context, attributeSet);
            return super.onCreateView(str, context, attributeSet);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            c.a.s0.s.c cVar = this.mLayoutMode;
            if (cVar != null) {
                cVar.c();
            }
            View view = this.loadingRootView;
            if (view != null) {
                hideLoadingView(view);
            }
            VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
            if (virtualBarAssist != null) {
                virtualBarAssist.onDestroy();
            }
            c.a.s0.s.a0.b bVar = this.keyboardHeightProvider;
            if (bVar != null) {
                bVar.c();
                c.a.d.f.m.e.a().removeCallbacks(this.keyboardHeightRunnable);
            }
            adjustResizeForSoftInputOnDestory();
            hideClickableTextToast();
            this.pageStayDurationItem = null;
            this.mTbPageTag = null;
            clearAnimatable();
            clearAnimation();
            this.mPermissionCallback = null;
            this.mPageExtra = null;
            unRegisterResponsedEventListener();
            super.onDestroy();
            c.a.d.f.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048644, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048645, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
        }
    }

    public void onKeyboardHeightChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048647, this, i2, i3) == null) {
            if (i3 == 1 && i2 > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                onKeyboardHeightChanged(i2);
            }
            onKeyboardVisibilityChanged(i2 > 0);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
        }
    }

    @Override // c.a.s0.a.p
    public boolean onMissionCompleted(CompleteTaskToastData completeTaskToastData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, completeTaskToastData)) == null) {
            hideClickableTextToast();
            this.mClickableTextToast = s.i(completeTaskToastData);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            c.a.t0.b4.a.getInstance().onPause(this);
            super.onPause();
            if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                hideFloatingWindow();
            }
            if (this.lastResumeTime != 0 && !this.isInterceptStimeStat && !this.isForceInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                c.a.s0.q0.d pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                c.a.s0.q0.e.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
            stopScreenShotListen();
            TbadkCoreApplication.getInst().DelResumeNum();
            TbadkCoreApplication.getInst().setCurrentActivity(null);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
            VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
            if (virtualBarAssist != null) {
                virtualBarAssist.onPause();
            }
            if (this.isAddSwipeBackLayout) {
                c.a.d.f.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
                c.a.d.f.m.e.a().postDelayed(this.setNoTranslucentRunnable, 1000L);
            }
            this.isResumed = false;
            c.a.s0.s.a0.b bVar = this.keyboardHeightProvider;
            if (bVar != null) {
                bVar.g(null);
            }
            taskStop();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, c.a.d.a.i
    public void onPreLoad(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId());
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048653, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (iArr == null || iArr.length <= 0 || strArr == null || strArr.length <= 0) {
                return;
            }
            boolean z = false;
            if (iArr[0] != 0) {
                PermissionJudgePolicy permissionJudgePolicy2 = this.mCurrentPermissionJudgePolicy;
                if (permissionJudgePolicy2 != null) {
                    permissionJudgePolicy2.checkPermissionForbidden(this, strArr[0]);
                    return;
                }
                return;
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

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            super.onRestart();
            flog = 0;
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            MenuKeyUtils.hideSoftMenuKey(getWindow());
            super.onResume();
            c.a.t0.b4.a.getInstance().onResume(this);
            if (this.isInterceptStimeStat) {
                setInterceptStimeStat(false);
            } else {
                this.lastResumeTime = System.currentTimeMillis();
            }
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            TbadkCoreApplication.getInst().AddResumeNum();
            TiebaStaticHelper.setCurrentActivity(getClass().getName());
            TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
            boolean isLogin = TbadkCoreApplication.isLogin();
            String currentAccount = TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount();
            if (this.mIsLogin != isLogin || !StringHelper.equals(currentAccount, this.mCurAccountId)) {
                this.mCurAccountId = currentAccount;
                this.mIsLogin = isLogin;
                onUserChanged(isLogin);
            }
            if (TbadkCoreApplication.getInst().canSendForegroundMessage()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, this));
            }
            TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
            setCurrentActivityTid();
            startScreenShotListen();
            VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
            if (virtualBarAssist != null) {
                virtualBarAssist.onResume();
            }
            TbSingleton.getInstance().getClass();
            if (!"BaseFragmentActivity".equals(TbSingleton.getInstance().isSwitchActivity)) {
                TbSingleton tbSingleton = TbSingleton.getInstance();
                TbSingleton.getInstance().getClass();
                tbSingleton.isSwitchActivity = "BaseFragmentActivity";
                flog = 0;
            }
            if (this == TbadkCoreApplication.getInst().getCurrentActivity() && TbSingleton.getInstance().isShowBackLabel && KuangFloatingWindowController.getInstance().init() && flog == 0) {
                showFloatingWindow();
            }
            if (this.isAddSwipeBackLayout) {
                c.a.d.f.m.e.a().removeCallbacks(this.setNoTranslucentRunnable);
                l0.b(this);
            }
            this.isResumed = true;
            c.a.s0.s.a0.b bVar = this.keyboardHeightProvider;
            if (bVar != null) {
                bVar.g(this);
            }
            if (TextUtils.isEmpty(taskActionId())) {
                return;
            }
            taskStart();
        }
    }

    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, str) == null) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            super.onStart();
            flog = 0;
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            super.onStop();
            if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                flog = 1;
            }
        }
    }

    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
        }
    }

    public void publishEvent(c.a.s0.k0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048660, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.getTag() == 0) {
            aVar.setTag(getUniqueId());
        }
        c.a.s0.k0.h.i(aVar);
    }

    public void registerResponsedEventListener(Class<? extends c.a.s0.k0.a> cls, c.a.s0.k0.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048661, this, cls, iVar) == null) {
            c.a.s0.k0.h.f().m(cls, iVar, getUniqueId());
        }
    }

    public void setActivityBgTransparent() {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048662, this) == null) || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.setBgTransparent();
    }

    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            s.h(getPageId(), getMissionTid());
        }
    }

    @Override // com.baidu.tbadk.IPermissionPolicy
    public void setCurrentPermissionJudgePolicy(PermissionJudgePolicy permissionJudgePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, permissionJudgePolicy) == null) {
            this.mCurrentPermissionJudgePolicy = permissionJudgePolicy;
        }
    }

    public void setForceInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z) == null) {
            this.isForceInterceptStimeStat = z;
        }
    }

    public void setHideStatusImmersiveStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
            this.mHideStatusImmersiveStyle = z;
        }
    }

    public void setInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z) == null) {
            this.isInterceptStimeStat = z;
        }
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z) == null) {
            this.isAddSwipeBackLayout = z;
        }
    }

    public void setLayoutMode(c.a.s0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, cVar) == null) {
            this.mLayoutMode = cVar;
        }
    }

    public void setNetRefreshViewEmotionMarginTop(int i2) {
        c.a.s0.g0.h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048670, this, i2) == null) && (hVar = this.mRefreshView) != null && hVar.isViewAttached()) {
            this.mRefreshView.k(i2);
        }
    }

    public void setSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i2) == null) {
            this.mSkinType = i2;
        }
    }

    public void setSwipeBackEnabled(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048672, this, z) == null) && TbadkCoreApplication.IS_SUPPORT_SWIPEBACK && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setSwipeBackEnabled(z);
        }
    }

    public void setSwipeBackIsSupportNight(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048673, this, z) == null) || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.setIsSupportNight(z);
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.mUseStyleImmersiveSticky = z;
        }
    }

    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean showDialog(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, dialog)) == null) {
            if (c.a.d.f.m.g.j(dialog, getPageContext())) {
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
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            grantWindowPermission(new b(this), false);
        }
    }

    public void showLoadingDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, str) == null) {
            if (this.mDialogListener == null) {
                this.mDialogListener = new f(this);
            }
            if (!isFinishing() && c.a.d.f.m.g.f(getPageContext())) {
                c.a.s0.s.i0.a aVar = new c.a.s0.s.i0.a(getPageContext());
                this.mWaitingDialog = aVar;
                if (str != null) {
                    aVar.j(str);
                } else {
                    aVar.i(R.string.Waiting);
                }
                this.mWaitingDialog.d(false);
                this.mWaitingDialog.f(false);
                this.mWaitingDialog.e(this.mDialogListener);
                this.mWaitingDialog.h(true);
            }
        }
    }

    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, view) == null) {
            showLoadingView(view, false);
        }
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048684, this, view, str, z) == null) {
            showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048685, this, popupWindow, view)) == null) {
            if (c.a.d.f.m.g.k(popupWindow, view)) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048687, this, new Object[]{popupWindow, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (c.a.d.f.m.g.m(popupWindow, view, i2, i3, i4)) {
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
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            try {
                showProgressBarWithOffset(0, 0);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void showProgressBarWithOffset(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048689, this, i2, i3) == null) {
            if (this.mProgressBar == null) {
                try {
                    this.mProgressBar = new ProgressBar(getPageContext().getPageActivity());
                    ((FrameLayout) findViewById(16908290)).addView(this.mProgressBar, new FrameLayout.LayoutParams(-2, -2, 17));
                } catch (Throwable unused) {
                    return;
                }
            }
            this.mProgressBar.setPadding(n.d(getPageContext().getContext(), i2), n.d(getPageContext().getContext(), i3), 0, 0);
            this.mProgressBar.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, str) == null) {
            n.M(getPageContext().getContext(), str);
        }
    }

    public void showToastWithDefauIcDuration(String str, BdToast.DefaultIcon defaultIcon, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048694, this, str, defaultIcon, i2) == null) {
            BdToast.g(getPageContext().getContext(), str, defaultIcon, i2).q();
        }
    }

    public void showToastWithDefaultIcon(String str, BdToast.DefaultIcon defaultIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048695, this, str, defaultIcon) == null) {
            BdToast.f(getPageContext().getContext(), str, defaultIcon).q();
        }
    }

    public void showToastWithIcon(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048696, this, str, i2) == null) {
            BdToast.i(getPageContext().getContext(), str, i2, false).q();
        }
    }

    public void showToastWithIconDuration(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048697, this, str, i2, i3) == null) {
            BdToast.h(getPageContext().getContext(), str, i2, i3, false).q();
        }
    }

    public void startAnimatable(Animatable animatable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048698, this, animatable) == null) || animatable == null || isFinishing()) {
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
        if (!(interceptable == null || interceptable.invokeLLL(1048699, this, view, animation, animationListener) == null) || animation == null || isFinishing()) {
            return;
        }
        WeakReference<View> weakReference = new WeakReference<>(view);
        animation.setAnimationListener(new g(this, animationListener, weakReference));
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

    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void taskPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            c.a.s0.a.e0.c.f().h(this.mBuoyTaskComponent);
        }
    }

    public void taskResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            c.a.s0.a.e0.c.f().k(this.mBuoyTaskComponent);
        }
    }

    public void taskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            this.mBuoyTaskComponent = c.a.s0.a.e0.c.f().m(getActivity(), taskAttachParentView(), taskActionId());
        }
    }

    public void taskStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            c.a.s0.a.e0.c.f().n(this.mBuoyTaskComponent);
        }
    }

    public void unRegisterResponsedEventListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            c.a.s0.k0.h.f().n(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, c.a.d.a.g
    public TbPageContext<BaseFragmentActivity> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            try {
                if (this.pageContext == null && mClazz4GetPageContext != null) {
                    this.pageContext = mClazz4GetPageContext.getConstructor(BaseFragmentActivity.class).newInstance(this);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this.pageContext;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void showLoadingView(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.loadingRootView = view;
            if (this.loadingView == null) {
                if (i2 < 0) {
                    this.loadingView = new c.a.s0.g0.g(getPageContext().getPageActivity());
                } else {
                    c.a.s0.g0.g gVar = new c.a.s0.g0.g(getPageContext().getPageActivity(), i2);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{view, str, str2, str3, Boolean.valueOf(z), onClickListener}) == null) || getPageContext() == null || getPageContext().getContext() == null) {
            return;
        }
        if (this.mRefreshView == null) {
            this.mRefreshView = new c.a.s0.g0.h(getPageContext().getContext(), onClickListener);
        }
        this.mRefreshView.n(str);
        this.mRefreshView.m(str2);
        this.mRefreshView.g(str3);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.p();
    }

    public void showToast(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i2) == null) {
            n.L(getPageContext().getContext(), i2);
        }
    }

    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048693, this, str, z) == null) {
            if (z) {
                showToast(str);
            } else {
                n.M(getPageContext().getContext(), str);
            }
        }
    }

    public void ShowSoftKeyPadDelay(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            ShowSoftKeyPadDelay(view, 150);
        }
    }

    public void adjustResizeForSoftInput(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = c.a.s0.s.i0.d.d(getPageContext().getPageActivity(), i2, z);
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048686, this, popupWindow, view, i2, i3)) == null) {
            if (c.a.d.f.m.g.l(popupWindow, view, i2, i3)) {
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

    public void showToast(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048691, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                showToast(i2);
            } else {
                n.L(getPageContext().getContext(), i2);
            }
        }
    }

    private void adjustResizeForSoftInput(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65553, this, z) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = c.a.s0.s.i0.d.e(getPageContext().getPageActivity(), z);
        }
    }

    public void showLoadingView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048681, this, view, z) == null) {
            showLoadingView(view, z, -1);
        }
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048679, this, str, onCancelListener) == null) {
            c.a.s0.s.i0.a aVar = new c.a.s0.s.i0.a(getPageContext());
            this.mWaitingDialog = aVar;
            if (str != null) {
                aVar.j(str);
            } else {
                aVar.i(R.string.Waiting);
            }
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(true);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.h(true);
        }
    }
}
