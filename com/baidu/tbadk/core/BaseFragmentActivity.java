package com.baidu.tbadk.core;

import android.app.Activity;
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
import com.baidu.tbadk.core.log.ActivityLog;
import com.baidu.tbadk.core.message.ConfigChangeMessage;
import com.baidu.tbadk.core.message.KeyBoardSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.VirtualBarAssist;
import com.baidu.tbadk.core.util.dimen.TbDimenAdaptActivityLifecycle;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.a76;
import com.baidu.tieba.aaa;
import com.baidu.tieba.ah;
import com.baidu.tieba.as5;
import com.baidu.tieba.b95;
import com.baidu.tieba.bo;
import com.baidu.tieba.bs5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cs5;
import com.baidu.tieba.d65;
import com.baidu.tieba.dn5;
import com.baidu.tieba.ds5;
import com.baidu.tieba.edgefloat.EdgeFloatLifecycle;
import com.baidu.tieba.en5;
import com.baidu.tieba.ew8;
import com.baidu.tieba.fs5;
import com.baidu.tieba.fw4;
import com.baidu.tieba.g55;
import com.baidu.tieba.gs5;
import com.baidu.tieba.h05;
import com.baidu.tieba.i15;
import com.baidu.tieba.k05;
import com.baidu.tieba.lp5;
import com.baidu.tieba.m55;
import com.baidu.tieba.mn5;
import com.baidu.tieba.qx5;
import com.baidu.tieba.r95;
import com.baidu.tieba.ry5;
import com.baidu.tieba.sp5;
import com.baidu.tieba.tp5;
import com.baidu.tieba.tx5;
import com.baidu.tieba.u95;
import com.baidu.tieba.uu4;
import com.baidu.tieba.wg;
import com.baidu.tieba.wr5;
import com.baidu.tieba.x95;
import com.baidu.tieba.xi;
import com.baidu.tieba.xu4;
import com.baidu.tieba.yg;
import com.baidu.tieba.zr5;
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
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class BaseFragmentActivity extends BdBaseFragmentActivity<BaseFragmentActivity> implements TbPageContextSupport, cs5, uu4, Object, zr5, IVideoNeedPreload, IPermissionPolicy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BaseFragmentActivity";
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
    public b95 keyboardHeightProvider;
    public Runnable keyboardHeightRunnable;
    public long lastResumeTime;
    public View loadingRootView;
    public dn5 loadingView;
    public int mAboveKeyboardHeight;
    public ViewGroup mActivityRootView;
    public BuoyComponent mBuoyTaskComponent;
    public m55 mClickableTextToast;
    public String mCurAccountId;
    public PermissionJudgePolicy mCurrentPermissionJudgePolicy;
    public DialogInterface.OnCancelListener mDialogListener;
    public boolean mHideStatusImmersiveStyle;
    public boolean mIsHasScreenShotListener;
    public boolean mIsLogin;
    public x95 mKeyboardAdjust;
    public int mLastOrientation;
    public int mLastScreenHeight;
    public int mLastScreenWidth;
    public boolean mLayoutHasInit;
    public h05 mLayoutMode;
    public int mMaxHeight;
    public wr5 mPageExtra;
    public k05 mPermissionCallback;
    public int mPreHeight;
    public ProgressBar mProgressBar;
    public en5 mRefreshView;
    public qx5 mScreenShotListenManager;
    public int mSkinType;
    public SwipeBackLayout mSwipeBackLayout;
    public TbPageTag mTbPageTag;
    public boolean mUseStyleImmersiveSticky;
    public VirtualBarAssist mVirtualBarAssist;
    public u95 mWaitingDialog;
    public m netRefreshListener;
    public final CustomMessageListener nightResourcesChangeListener;
    public TbPageContext<BaseFragmentActivity> pageContext;
    public fs5 pageStayDurationItem;
    public List<PopupWindow> popupWindowList;
    public wg resourcesWrapper;
    public Runnable setNoTranslucentRunnable;
    public final CustomMessageListener skinTypeChangeListener;

    @Override // com.baidu.tieba.cs5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.cs5
    public ds5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return null;
        }
        return (ds5) invokeV.objValue;
    }

    public abstract void onChangeSkinType(int i2);

    public void onKeyboardHeightChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
        }
    }

    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
        }
    }

    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
        }
    }

    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048663, this, z) == null) {
        }
    }

    public void setSchemaParams(Intent intent, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048676, this, intent, jSONObject) == null) {
        }
    }

    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a implements qx5.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // com.baidu.tieba.qx5.b
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

    /* loaded from: classes4.dex */
    public class b implements k05 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // com.baidu.tieba.k05
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

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        public c(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = this.a.getActivity()) != null && !activity.isFinishing()) {
                if (this.a.keyboardHeightProvider == null) {
                    this.a.keyboardHeightProvider = new b95(this.a);
                }
                this.a.keyboardHeightProvider.h();
                BaseFragmentActivity baseFragmentActivity = this.a;
                if (baseFragmentActivity.isResumed) {
                    baseFragmentActivity.keyboardHeightProvider.g(this.a);
                } else {
                    baseFragmentActivity.keyboardHeightProvider.g(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        public d(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        public final void a(int i) {
            int height;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                View findViewById = this.a.findViewById(16908290);
                if (!(findViewById instanceof ViewGroup)) {
                    return;
                }
                boolean z2 = false;
                View childAt = ((ViewGroup) findViewById).getChildAt(0);
                if (childAt != null && (height = childAt.getHeight()) != this.a.mAboveKeyboardHeight) {
                    int i2 = (i * 2) / 3;
                    if (height < i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.a.mAboveKeyboardHeight != 0 && this.a.mAboveKeyboardHeight < i2) {
                        z2 = true;
                    }
                    if (z != z2) {
                        this.a.onKeyboardVisibilityChanged(z);
                        if ((TbSingleton.getInstance().isShowBackLabel || TbSingleton.getInstance().isShowVoiceFloat()) && this.a == TbadkCoreApplication.getInst().getCurrentActivity()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new KeyBoardSwitchMessage(Boolean.valueOf(z2)));
                        }
                    }
                    this.a.mAboveKeyboardHeight = height;
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = 0;
                try {
                    View findViewById = this.a.findViewById(16908290);
                    if (findViewById != null) {
                        i2 = findViewById.getHeight();
                    }
                    int height = this.a.getWindow().getDecorView().getRootView().getHeight();
                    if (this.a.mLayoutHasInit) {
                        BaseFragmentActivity baseFragmentActivity = this.a;
                        if (this.a.mMaxHeight >= i2) {
                            i = this.a.mMaxHeight;
                        } else {
                            i = i2;
                        }
                        baseFragmentActivity.mMaxHeight = i;
                    } else {
                        this.a.mLayoutHasInit = true;
                        this.a.mMaxHeight = i2;
                    }
                    if (this.a.mLayoutHasInit && this.a.mMaxHeight > i2 && i2 != this.a.mPreHeight) {
                        int i3 = this.a.mMaxHeight - i2;
                        if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i3) && i3 < (height * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i3) {
                            TbadkCoreApplication.getInst().setKeyboardHeight(i3);
                            this.a.onKeyboardHeightChanged(i3);
                        }
                    }
                    a(height);
                    this.a.mPreHeight = i2;
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        public e(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.isFinishing()) {
                tx5.a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        public f(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.mWaitingDialog = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation.AnimationListener a;
        public final /* synthetic */ WeakReference b;
        public final /* synthetic */ BaseFragmentActivity c;

        public g(BaseFragmentActivity baseFragmentActivity, Animation.AnimationListener animationListener, WeakReference weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity, animationListener, weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = baseFragmentActivity;
            this.a = animationListener;
            this.b = weakReference;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Animation.AnimationListener animationListener = this.a;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                }
                synchronized (this.c.animationList) {
                    this.c.animationList.remove(this.b);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) && (animationListener = this.a) != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) && (animationListener = this.a) != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(BaseFragmentActivity baseFragmentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017 && this.a.mLayoutMode != null) {
                this.a.mLayoutMode.m(null);
                if (this.a.mKeyboardAdjust != null) {
                    this.a.mKeyboardAdjust.l(TbadkCoreApplication.getInst().getSkinType());
                }
                this.a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(BaseFragmentActivity baseFragmentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (!this.a.shouldChangeStatusBarIconAndTextColor()) {
                return;
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            UtilHelper.changeStatusBarIconAndTextColor(z, this.a);
            a76.K().R(TbadkCoreApplication.getInst().getSkinType());
            EdgeFloatLifecycle.c().e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes4.dex */
    public class j implements g55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        public j(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // com.baidu.tieba.g55.e
        public void onClick(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                g55Var.dismiss();
                if (this.a.mPermissionCallback != null) {
                    this.a.mPermissionCallback.onPermissionResult(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements g55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        public k(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // com.baidu.tieba.g55.e
        public void onClick(g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g55Var) == null) {
                g55Var.dismiss();
                try {
                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    intent.setData(Uri.parse("package:" + this.a.getPackageName()));
                    this.a.startActivityForResult(intent, 12016);
                } catch (Exception unused) {
                    this.a.showToast(R.string.request_window_permission_default_text_by_yourself);
                    if (this.a.mPermissionCallback != null) {
                        this.a.mPermissionCallback.onPermissionResult(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public final /* synthetic */ BaseFragmentActivity b;

        public l(BaseFragmentActivity baseFragmentActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = baseFragmentActivity;
            this.a = null;
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.b.isFinishing()) {
                this.b.ShowSoftKeyPad((InputMethodManager) this.b.getSystemService("input_method"), this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragmentActivity a;

        public m(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragmentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onNetRefreshButtonClicked();
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

    private String getCurrentExtraPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            String currentPageKey = getCurrentPageKey();
            if (TextUtils.isEmpty(currentPageKey)) {
                return getClass().getSimpleName();
            }
            return currentPageKey;
        }
        return (String) invokeV.objValue;
    }

    private void hideClickableTextToast() {
        m55 m55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && (m55Var = this.mClickableTextToast) != null) {
            m55Var.e();
        }
    }

    private void startScreenShotListen() {
        qx5 qx5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && !this.mIsHasScreenShotListener && (qx5Var = this.mScreenShotListenManager) != null) {
            qx5Var.m(new a(this));
            this.mScreenShotListenManager.n();
            this.mIsHasScreenShotListener = true;
        }
    }

    private void stopScreenShotListen() {
        qx5 qx5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.mIsHasScreenShotListener && (qx5Var = this.mScreenShotListenManager) != null) {
            qx5Var.o();
            this.mIsHasScreenShotListener = false;
        }
    }

    public void DeinitWaitingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mWaitingDialog = null;
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
            yg.a().postDelayed(this.keyboardHeightRunnable, 1000L);
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
            this.mKeyboardAdjust = x95.d(getPageContext().getPageActivity());
        }
    }

    public void adjustResizeForSoftInputOnDestory() {
        x95 x95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (x95Var = this.mKeyboardAdjust) != null) {
            x95Var.k();
            this.mKeyboardAdjust = null;
        }
    }

    public boolean checkUpIsLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
        }
    }

    public void closeLoadingDialog() {
        u95 u95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (u95Var = this.mWaitingDialog) != null) {
            try {
                if (u95Var.c()) {
                    this.mWaitingDialog.h(false);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
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
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (list = this.dialogList) != null) {
            for (Dialog dialog : list) {
                ah.b(dialog, getPageContext());
            }
            this.dialogList.clear();
        }
    }

    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    public ViewGroup getActivityRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mActivityRootView;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cs5
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

    public PermissionJudgePolicy getCurrentPermissionJudgePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            return this.mCurrentPermissionJudgePolicy;
        }
        return (PermissionJudgePolicy) invokeV.objValue;
    }

    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    public h05 getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mLayoutMode;
        }
        return (h05) invokeV.objValue;
    }

    public u95 getLoadingDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mWaitingDialog;
        }
        return (u95) invokeV.objValue;
    }

    public dn5 getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.loadingView;
        }
        return (dn5) invokeV.objValue;
    }

    public View.OnClickListener getNetRefreshListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.netRefreshListener == null) {
                this.netRefreshListener = new m(this, null);
            }
            return this.netRefreshListener;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public int getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            BdUniqueId uniqueId = getUniqueId();
            if (uniqueId != null) {
                return uniqueId.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public fs5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.pageStayDurationItem == null) {
                fs5 fs5Var = new fs5();
                this.pageStayDurationItem = fs5Var;
                fs5Var.s(getCurrentPageKey());
            }
            this.pageStayDurationItem.x(getCurrentPageSourceKeyList());
            return this.pageStayDurationItem;
        }
        return (fs5) invokeV.objValue;
    }

    public String getPreExtraPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            wr5 tbPageExtra = getTbPageExtra();
            if (tbPageExtra != null) {
                return tbPageExtra.e();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final TbPageTag getPrePageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return bs5.m(getIntent());
        }
        return (TbPageTag) invokeV.objValue;
    }

    public int getSkinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return TbadkCoreApplication.getInst().getSkinType();
        }
        return invokeV.intValue;
    }

    public wr5 getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.mPageExtra == null) {
                this.mPageExtra = new wr5(getUniqueId(), getCurrentExtraPageKey(), "", getIntent());
            }
            return this.mPageExtra;
        }
        return (wr5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zr5
    public final as5 getTbPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return new as5(getUniqueId(), getTbPageTag(), getIntent());
        }
        return (as5) invokeV.objValue;
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

    public void hideFloatingWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            KuangFloatingWindowController.getInstance().hideFloatingView();
        }
    }

    public void hideProgressBar() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (progressBar = this.mProgressBar) != null) {
            progressBar.setVisibility(8);
        }
    }

    public boolean isForceInterceptStimeStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.isForceInterceptStimeStat;
        }
        return invokeV.booleanValue;
    }

    public boolean isLoadingViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            dn5 dn5Var = this.loadingView;
            if (dn5Var == null) {
                return false;
            }
            return dn5Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isProgressBarShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            ProgressBar progressBar = this.mProgressBar;
            if (progressBar != null && progressBar.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSwipeBackEnabled() {
        InterceptResult invokeV;
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (TbadkCoreApplication.IS_SUPPORT_SWIPEBACK && (swipeBackLayout = this.mSwipeBackLayout) != null) {
                return swipeBackLayout.isSwipeBackEnabled();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isUseStyleImmersiveSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.mUseStyleImmersiveSticky;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            super.onAttachedToWindow();
            a76.K().Q();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            super.onBackPressed();
            EdgeFloatLifecycle.c().d();
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            ew8 activityLog = ActivityLog.getInstance();
            activityLog.c(TAG, "onStart:" + this);
            super.onStart();
            flog = 0;
        }
    }

    public void setActivityBgTransparent() {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048667, this) == null) && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setBgTransparent();
        }
    }

    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            xu4.h(getPageId(), getMissionTid());
        }
    }

    public void showFloatingWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            grantWindowPermission(new b(this), false);
        }
    }

    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            try {
                showProgressBarWithOffset(0, 0);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void taskPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            fw4.f().h(this.mBuoyTaskComponent);
        }
    }

    public void taskResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            fw4.f().k(this.mBuoyTaskComponent);
        }
    }

    public void taskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            this.mBuoyTaskComponent = fw4.f().m(getActivity(), taskAttachParentView(), taskActionId());
        }
    }

    public void taskStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            fw4.f().n(this.mBuoyTaskComponent);
        }
    }

    public void unRegisterResponsedEventListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            sp5.f().o(getUniqueId());
        }
    }

    public BaseFragmentActivity() {
        String currentAccount;
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
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            currentAccount = "";
        } else {
            currentAccount = TbadkCoreApplication.getCurrentAccount();
        }
        this.mCurAccountId = currentAccount;
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

    @Override // com.baidu.tieba.cs5
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
            String currentPageKey = getCurrentPageKey();
            if (!ListUtils.isEmpty(arrayList2)) {
                arrayList = new ArrayList();
                arrayList.addAll(arrayList2);
            } else {
                arrayList = null;
            }
            if (getPageStayFilter() != null && !getPageStayFilter().c()) {
                return arrayList;
            }
            if (!StringUtils.isNull(currentPageKey)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(currentPageKey);
            }
            Fragment visibleFragment = getVisibleFragment();
            if (visibleFragment instanceof cs5) {
                String currentPageKey2 = ((cs5) visibleFragment).getCurrentPageKey();
                if (!StringUtils.isNull(currentPageKey2)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(currentPageKey2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            ew8 activityLog = ActivityLog.getInstance();
            activityLog.c(TAG, "onDestroy:" + this);
            h05 h05Var = this.mLayoutMode;
            if (h05Var != null) {
                h05Var.c();
            }
            View view2 = this.loadingRootView;
            if (view2 != null) {
                hideLoadingView(view2);
            }
            VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
            if (virtualBarAssist != null) {
                virtualBarAssist.onDestroy();
            }
            b95 b95Var = this.keyboardHeightProvider;
            if (b95Var != null) {
                b95Var.c();
                yg.a().removeCallbacks(this.keyboardHeightRunnable);
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
            yg.a().removeCallbacks(this.setNoTranslucentRunnable);
            mn5.e().b();
            i15.c().d(getUniqueId());
        }
    }

    private void adjustResizeForSoftInput(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65552, this, z) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = x95.f(getPageContext().getPageActivity(), z);
        }
    }

    public static void setClazz4GetPageContext(Class<? extends TbPageContext<BaseFragmentActivity>> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, cls) == null) {
            mClazz4GetPageContext = cls;
        }
    }

    public void ShowSoftKeyPadDelay(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            ShowSoftKeyPadDelay(view2, 150);
        }
    }

    public void adjustResizeForSoftInputOnSkinTypeChanged(int i2) {
        x95 x95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (x95Var = this.mKeyboardAdjust) != null) {
            x95Var.l(i2);
        }
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, responsedMessage)) == null) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void dismissDialog(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dialog) == null) {
            List<Dialog> list = this.dialogList;
            if (list != null) {
                list.remove(dialog);
            }
            ah.b(dialog, getPageContext());
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
            ah.d(popupWindow, getPageContext().getPageActivity());
            List<PopupWindow> list = this.popupWindowList;
            if (list != null) {
                list.remove(popupWindow);
            }
        }
    }

    public void hideLoadingView(View view2) {
        dn5 dn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, view2) == null) && (dn5Var = this.loadingView) != null) {
            dn5Var.dettachView(view2);
        }
    }

    public void hideNetRefreshView(View view2) {
        en5 en5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, view2) == null) && (en5Var = this.mRefreshView) != null) {
            en5Var.dettachView(view2);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            EdgeFloatLifecycle.c().f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    @Override // com.baidu.tieba.uu4
    public boolean onMissionCompleted(CompleteTaskToastData completeTaskToastData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, completeTaskToastData)) == null) {
            hideClickableTextToast();
            this.mClickableTextToast = xu4.i(completeTaskToastData);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.tieba.q9
    public void onPreLoad(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, boVar) == null) {
            PreLoadImageHelper.load(boVar, getUniqueId());
            PreLoadVideoHelper.load(boVar, getUniqueId(), this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                EdgeFloatLifecycle.c().h(z);
            }
        }
    }

    public void publishEvent(lp5 lp5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048665, this, lp5Var) != null) || lp5Var == null) {
            return;
        }
        if (lp5Var.getTag() == 0) {
            lp5Var.setTag(getUniqueId());
        }
        sp5.i(lp5Var);
    }

    @Override // com.baidu.tbadk.IPermissionPolicy
    public void setCurrentPermissionJudgePolicy(PermissionJudgePolicy permissionJudgePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, permissionJudgePolicy) == null) {
            this.mCurrentPermissionJudgePolicy = permissionJudgePolicy;
        }
    }

    public void setForceInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z) == null) {
            this.isForceInterceptStimeStat = z;
        }
    }

    public void setHideStatusImmersiveStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048671, this, z) == null) {
            this.mHideStatusImmersiveStyle = z;
        }
    }

    public void setInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            this.isInterceptStimeStat = z;
        }
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            this.isAddSwipeBackLayout = z;
        }
    }

    public void setLayoutMode(h05 h05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, h05Var) == null) {
            this.mLayoutMode = h05Var;
        }
    }

    public void setNetRefreshViewEmotionMarginTop(int i2) {
        en5 en5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048675, this, i2) == null) && (en5Var = this.mRefreshView) != null && en5Var.isViewAttached()) {
            this.mRefreshView.k(i2);
        }
    }

    public void setSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i2) == null) {
            this.mSkinType = i2;
        }
    }

    public void setSwipeBackEnabled(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048678, this, z) == null) && TbadkCoreApplication.IS_SUPPORT_SWIPEBACK && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setSwipeBackEnabled(z);
        }
    }

    public void setSwipeBackIsSupportNight(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048679, this, z) == null) && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setIsSupportNight(z);
        }
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z) == null) {
            this.mUseStyleImmersiveSticky = z;
        }
    }

    public boolean showDialog(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, dialog)) == null) {
            if (ah.j(dialog, getPageContext())) {
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

    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, view2) == null) {
            showLoadingView(view2, false);
        }
    }

    public void showToast(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i2) == null) {
            xi.P(getPageContext().getContext(), i2);
        }
    }

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputMethodManager, view2) == null) {
            try {
                inputMethodManager.hideSoftInputFromWindow(view2.getWindowToken(), 2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void ShowSoftKeyPad(InputMethodManager inputMethodManager, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputMethodManager, view2) == null) && view2 != null && inputMethodManager != null) {
            try {
                inputMethodManager.showSoftInput(view2, 0);
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    public void ShowSoftKeyPadDelay(View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, view2, i2) == null) {
            new Handler().postDelayed(new l(this, view2), i2);
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

    public void onKeyboardHeightChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048651, this, i2, i3) == null) {
            boolean z = true;
            if (i3 == 1 && i2 > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                onKeyboardHeightChanged(i2);
            }
            if (i2 <= 0) {
                z = false;
            }
            onKeyboardVisibilityChanged(z);
        }
    }

    public void registerResponsedEventListener(Class<? extends lp5> cls, tp5 tp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048666, this, cls, tp5Var) == null) {
            sp5.f().m(cls, tp5Var, getUniqueId());
        }
    }

    public void showLoadingView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048687, this, view2, z) == null) {
            showLoadingView(view2, z, -1);
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048691, this, popupWindow, view2)) == null) {
            if (ah.k(popupWindow, view2)) {
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

    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048699, this, str, z) == null) {
            if (z) {
                showToast(str);
            } else {
                xi.Q(getPageContext().getContext(), str);
            }
        }
    }

    public void showToastWithDefaultIcon(String str, BdToast.ToastIcon toastIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048700, this, str, toastIcon) == null) {
            BdToast b2 = BdToast.b(getPageContext().getContext(), str);
            b2.g(toastIcon);
            b2.q();
        }
    }

    public void showToastWithIcon(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048701, this, str, i2) == null) {
            BdToast b2 = BdToast.b(getPageContext().getContext(), str);
            b2.f(i2);
            b2.q();
        }
    }

    public void adjustResizeForSoftInput(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = x95.e(getPageContext().getPageActivity(), i2, z);
        }
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048685, this, str, onCancelListener) == null) {
            u95 u95Var = new u95(getPageContext());
            this.mWaitingDialog = u95Var;
            if (str != null) {
                u95Var.j(str);
            } else {
                u95Var.i(R.string.obfuscated_res_0x7f0f003a);
            }
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(true);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.h(true);
        }
    }

    public void showToast(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048697, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                showToast(i2);
            } else {
                xi.P(getPageContext().getContext(), i2);
            }
        }
    }

    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && i2 != this.mSkinType) {
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
                if (this.mKeyboardAdjust != null) {
                    this.mKeyboardAdjust.l(i2);
                }
                if (this.mRefreshView != null) {
                    this.mRefreshView.onChangeSkinType();
                }
                onChangeSkinType(this.mSkinType);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void fullScreen(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048604, this, z) != null) || getWindow() == null) {
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

    public void showLoadingDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            if (this.mDialogListener == null) {
                this.mDialogListener = new f(this);
            }
            if (isFinishing() || !ah.f(getPageContext())) {
                return;
            }
            u95 u95Var = new u95(getPageContext());
            this.mWaitingDialog = u95Var;
            if (str != null) {
                u95Var.j(str);
            } else {
                u95Var.i(R.string.obfuscated_res_0x7f0f003a);
            }
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(false);
            this.mWaitingDialog.e(this.mDialogListener);
            this.mWaitingDialog.h(true);
        }
    }

    public void clearAnimatable() {
        List<Animatable> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (list = this.animatableList) != null) {
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
    }

    public void clearAnimation() {
        List<WeakReference<View>> list;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (list = this.animationList) != null) {
            synchronized (list) {
                for (int i2 = 0; i2 < this.animationList.size(); i2++) {
                    try {
                        WeakReference<View> weakReference = this.animationList.get(i2);
                        if (weakReference != null && (view2 = weakReference.get()) != null) {
                            view2.clearAnimation();
                        }
                    }
                }
                this.animationList.clear();
            }
        }
    }

    public void dismissAllPopupWindow() {
        List<PopupWindow> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (list = this.popupWindowList) != null) {
            for (PopupWindow popupWindow : list) {
                ah.d(popupWindow, getPageContext().getPageActivity());
            }
            this.popupWindowList.clear();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ew8 activityLog = ActivityLog.getInstance();
            activityLog.c(TAG, "finish:" + this);
            xi.z(getApplicationContext(), getWindow().getDecorView());
            dismissAllDialog();
            dismissAllPopupWindow();
            super.finish();
            closeAnimation();
        }
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            Intent intent = super.getIntent();
            if (intent == null) {
                return null;
            }
            String stringExtra = intent.getStringExtra("key_schema_params");
            if (stringExtra != null) {
                try {
                    setSchemaParams(intent, new JSONObject(stringExtra));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                intent.removeExtra("key_schema_params");
            }
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m9
    public TbPageContext<BaseFragmentActivity> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
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

    public Fragment getVisibleFragment() {
        InterceptResult invokeV;
        List<Fragment> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                list = supportFragmentManager.getFragments();
            } else {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            for (Fragment fragment : list) {
                if ((fragment instanceof BaseFragment) && ((BaseFragment) fragment).isPrimary()) {
                    return fragment;
                }
            }
            return null;
        }
        return (Fragment) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            ew8 activityLog = ActivityLog.getInstance();
            activityLog.c(TAG, "onStop:" + this);
            super.onStop();
            if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                flog = 1;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            d65.l(false);
            xu4.a(motionEvent, getPageId(), getMissionTid());
            aaa.getInstance().behaviorRecordEvent(motionEvent, this);
            a76.K().H();
            EdgeFloatLifecycle.c().b(motionEvent);
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void startAnimatable(Animatable animatable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048702, this, animatable) != null) || animatable == null || isFinishing()) {
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

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                Resources resources = super.getResources();
                if (resources != null && TbDimenManager.getInstance().needAdapt(resources.getDisplayMetrics()) && TbDimenAdaptActivityLifecycle.isActivityNeedAdapte(this)) {
                    TbDimenManager.getInstance().adaptThisDimen(resources.getDisplayMetrics());
                }
                return resources;
            }
            if (this.resourcesWrapper == null) {
                this.resourcesWrapper = new wg(super.getResources());
            }
            return this.resourcesWrapper;
        }
        return (Resources) invokeV.objValue;
    }

    public boolean grantWindowPermission(k05 k05Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048630, this, k05Var, z)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getBaseContext())) {
                    if (k05Var != null) {
                        k05Var.onPermissionResult(true);
                    }
                } else {
                    this.mPermissionCallback = k05Var;
                    boolean l2 = r95.p().l("key_is_window_permission_dialog_shown", false);
                    if (z) {
                        l2 = false;
                    }
                    if (!l2) {
                        g55 g55Var = new g55(this);
                        g55Var.setCanceledOnTouchOutside(false);
                        g55Var.setTitle(R.string.request_permission_default_title);
                        g55Var.setMessageId(R.string.request_window_permission_default_text);
                        g55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b11, new k(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f03cc, new j(this)).create(getPageContext());
                        g55Var.show();
                        r95.p().A("key_is_window_permission_dialog_shown", true);
                    } else {
                        k05 k05Var2 = this.mPermissionCallback;
                        if (k05Var2 != null) {
                            k05Var2.onPermissionResult(false);
                        }
                    }
                    return false;
                }
            } else if (k05Var != null) {
                k05Var.onPermissionResult(true);
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        k05 k05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048640, this, i2, i3, intent) == null) {
            ew8 activityLog = ActivityLog.getInstance();
            activityLog.c(TAG, "onActivityResult:" + this + " requestCode:" + i2 + " resultCode:" + i3);
            super.onActivityResult(i2, i3, intent);
            if (!ry5.c(i2, i3, intent) && (k05Var = this.mPermissionCallback) != null && Build.VERSION.SDK_INT >= 23 && i2 == 12016) {
                k05Var.onPermissionResult(Settings.canDrawOverlays(getBaseContext()));
                this.mPermissionCallback = null;
            }
        }
    }

    public void showLoadingView(View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048688, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.loadingRootView = view2;
            if (this.loadingView == null) {
                if (i2 < 0) {
                    this.loadingView = new dn5(getPageContext().getPageActivity());
                } else {
                    dn5 dn5Var = new dn5(getPageContext().getPageActivity(), i2);
                    this.loadingView = dn5Var;
                    dn5Var.i();
                }
                this.loadingView.onChangeSkinType();
            }
            this.loadingView.attachView(view2, z);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration == null) {
                return;
            }
            int i2 = configuration.orientation;
            if (i2 == this.mLastOrientation) {
                if (configuration.screenWidthDp != this.mLastScreenWidth || configuration.screenHeightDp != this.mLastScreenHeight) {
                    this.mLastScreenWidth = configuration.screenWidthDp;
                    this.mLastScreenHeight = configuration.screenHeightDp;
                    xi.a = false;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921414, getUniqueId()));
                }
            } else {
                this.mLastOrientation = i2;
            }
            if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                MessageManager.getInstance().dispatchResponsedMessage(new ConfigChangeMessage(Boolean.valueOf(KuangFloatingWindowController.currentStatus)));
            }
            EdgeFloatLifecycle.c().g(xi.m(this, UtilHelper.isFoldScreen()), xi.k(this, UtilHelper.isFoldScreen()));
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bundle) == null) {
            ew8 activityLog = ActivityLog.getInstance();
            activityLog.c(TAG, "onCreate:" + this);
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
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    z = true;
                }
                UtilHelper.changeStatusBarIconAndTextColor(z, this);
            }
            MenuKeyUtils.hideSmartBarMenu(getPageContext().getPageActivity());
            super.onCreate(bundle);
            if (getGpuSwitch()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            TiebaStaticHelper.setCurrentActivity(getClass().getName());
            this.mLayoutMode = new h05();
            registerListener(this.nightResourcesChangeListener);
            registerListener(this.skinTypeChangeListener);
            enterExitAnimation();
            this.keyboardHeightProvider = new b95(this);
            this.mIsLogin = TbadkCoreApplication.isLogin();
            this.mScreenShotListenManager = new qx5(this);
            getLifecycle().addObserver(TbImageMemoryCache.u());
            SpeedStats.getInstance().onBaseActivityCreate(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048646, this, str, context, attributeSet)) == null) {
            if (this.mLayoutMode == null) {
                this.mLayoutMode = new h05();
            }
            this.mLayoutMode.j(str, context, attributeSet);
            return super.onCreateView(str, context, attributeSet);
        }
        return (View) invokeLLL.objValue;
    }

    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048690, this, view2, str, z) == null) {
            showNetRefreshView(view2, null, str, null, z, getNetRefreshListener());
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            ew8 activityLog = ActivityLog.getInstance();
            activityLog.c(TAG, "onPause:" + this);
            aaa.getInstance().onPause(this);
            super.onPause();
            if (PermissionUtil.isAgreePrivacyPolicy() && TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                hideFloatingWindow();
            }
            if (this.lastResumeTime != 0 && !this.isInterceptStimeStat && !this.isForceInterceptStimeStat && PermissionUtil.isAgreePrivacyPolicy()) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                fs5 pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                gs5.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
            stopScreenShotListen();
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                TbadkCoreApplication.getInst().DelResumeNum();
            }
            TbadkCoreApplication.getInst().setCurrentActivity(null);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
            VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
            if (virtualBarAssist != null) {
                virtualBarAssist.onPause();
            }
            if (this.isAddSwipeBackLayout) {
                yg.a().removeCallbacks(this.setNoTranslucentRunnable);
                yg.a().postDelayed(this.setNoTranslucentRunnable, 1000L);
            }
            this.isResumed = false;
            b95 b95Var = this.keyboardHeightProvider;
            if (b95Var != null) {
                b95Var.g(null);
            }
            taskStop();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048657, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (iArr != null && iArr.length > 0 && strArr != null && strArr.length > 0) {
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
                    if (i3 < strArr.length) {
                        if (iArr[i3] != 0) {
                            break;
                        }
                        i3++;
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z && (permissionJudgePolicy = this.mCurrentPermissionJudgePolicy) != null) {
                    permissionJudgePolicy.onPermissionsGranted();
                }
            }
        }
    }

    public void startAnimation(View view2, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048703, this, view2, animation, animationListener) != null) || animation == null || isFinishing()) {
            return;
        }
        WeakReference<View> weakReference = new WeakReference<>(view2);
        animation.setAnimationListener(new g(this, animationListener, weakReference));
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

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        String currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            ew8 activityLog = ActivityLog.getInstance();
            activityLog.c(TAG, "onResume:" + this);
            MenuKeyUtils.hideSoftMenuKey(getWindow());
            super.onResume();
            aaa.getInstance().onResume(this);
            if (this.isInterceptStimeStat) {
                setInterceptStimeStat(false);
            } else {
                this.lastResumeTime = System.currentTimeMillis();
            }
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                TbadkCoreApplication.getInst().AddResumeNum();
            }
            TiebaStaticHelper.setCurrentActivity(getClass().getName());
            TbadkCoreApplication.getInst().setCurrentActivity(getPageContext().getPageActivity());
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                currentAccount = "";
            } else {
                currentAccount = TbadkCoreApplication.getCurrentAccount();
            }
            if (this.mIsLogin != isLogin || !StringHelper.equals(currentAccount, this.mCurAccountId)) {
                this.mCurAccountId = currentAccount;
                this.mIsLogin = isLogin;
                onUserChanged(isLogin);
            }
            if (PermissionUtil.isAgreePrivacyPolicy() && TbadkCoreApplication.getInst().canSendForegroundMessage()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, this));
            }
            startScreenShotListen();
            VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
            if (virtualBarAssist != null) {
                virtualBarAssist.onResume();
            }
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
                setCurrentActivityTid();
                TbSingleton.getInstance().getClass();
                if (!TAG.equals(TbSingleton.getInstance().isSwitchActivity)) {
                    TbSingleton tbSingleton = TbSingleton.getInstance();
                    TbSingleton.getInstance().getClass();
                    tbSingleton.isSwitchActivity = TAG;
                    flog = 0;
                }
                if (this == TbadkCoreApplication.getInst().getCurrentActivity() && TbSingleton.getInstance().isShowBackLabel && KuangFloatingWindowController.getInstance().init() && flog == 0) {
                    showFloatingWindow();
                }
            }
            if (this.isAddSwipeBackLayout) {
                yg.a().removeCallbacks(this.setNoTranslucentRunnable);
                tx5.b(this);
            }
            this.isResumed = true;
            b95 b95Var = this.keyboardHeightProvider;
            if (b95Var != null) {
                b95Var.g(this);
            }
            if (!TextUtils.isEmpty(taskActionId())) {
                taskStart();
            }
            a76.K().c0(this);
            EdgeFloatLifecycle.c().k(this);
        }
    }

    public void showNetRefreshView(View view2, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048689, this, new Object[]{view2, str, str2, str3, Boolean.valueOf(z), onClickListener}) == null) && getPageContext() != null && getPageContext().getContext() != null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new en5(getPageContext().getContext(), onClickListener);
            }
            this.mRefreshView.n(str);
            this.mRefreshView.m(str2);
            this.mRefreshView.g(str3);
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.p();
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048692, this, popupWindow, view2, i2, i3)) == null) {
            if (ah.l(popupWindow, view2, i2, i3)) {
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

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view2, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048693, this, new Object[]{popupWindow, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (ah.m(popupWindow, view2, i2, i3, i4)) {
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

    public void showProgressBarWithOffset(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048695, this, i2, i3) == null) {
            if (this.mProgressBar == null) {
                try {
                    this.mProgressBar = new ProgressBar(getPageContext().getPageActivity());
                    ((FrameLayout) findViewById(16908290)).addView(this.mProgressBar, new FrameLayout.LayoutParams(-2, -2, 17));
                } catch (Throwable unused) {
                    return;
                }
            }
            this.mProgressBar.setPadding(xi.d(getPageContext().getContext(), i2), xi.d(getPageContext().getContext(), i3), 0, 0);
            this.mProgressBar.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, str) == null) {
            xi.Q(getPageContext().getContext(), str);
        }
    }
}
