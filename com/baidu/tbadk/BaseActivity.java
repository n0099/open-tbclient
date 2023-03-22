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
import com.baidu.tbadk.core.log.ActivityLog;
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
import com.baidu.tbadk.core.util.dimen.TbDimenAdaptActivityLifecycle;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.GuidPageView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.b05;
import com.baidu.tieba.ck5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.dk5;
import com.baidu.tieba.dv4;
import com.baidu.tieba.edgefloat.EdgeFloatLifecycle;
import com.baidu.tieba.ek5;
import com.baidu.tieba.ew4;
import com.baidu.tieba.f05;
import com.baidu.tieba.fk5;
import com.baidu.tieba.fv4;
import com.baidu.tieba.gk5;
import com.baidu.tieba.hg;
import com.baidu.tieba.hi;
import com.baidu.tieba.ik5;
import com.baidu.tieba.iv4;
import com.baidu.tieba.jg;
import com.baidu.tieba.jh9;
import com.baidu.tieba.jk5;
import com.baidu.tieba.kf5;
import com.baidu.tieba.kn;
import com.baidu.tieba.kq4;
import com.baidu.tieba.lf5;
import com.baidu.tieba.lg;
import com.baidu.tieba.m35;
import com.baidu.tieba.nq4;
import com.baidu.tieba.oh5;
import com.baidu.tieba.p35;
import com.baidu.tieba.s35;
import com.baidu.tieba.tf5;
import com.baidu.tieba.tq5;
import com.baidu.tieba.ty5;
import com.baidu.tieba.up5;
import com.baidu.tieba.vh5;
import com.baidu.tieba.w05;
import com.baidu.tieba.w58;
import com.baidu.tieba.wh5;
import com.baidu.tieba.xp5;
import com.baidu.tieba.zj5;
import com.baidu.tieba.zz4;
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
/* loaded from: classes3.dex */
public class BaseActivity<T> extends BdBaseActivity<T> implements TbPageContextSupport, fk5, IVideoNeedPreload, kq4, Object, ck5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SHOW_SOFT_KEYBOARD_DELAY = 150;
    public static final String TAG = "BaseActivity";
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
    public kf5 loadingView;
    public int mAboveKeyboardHeight;
    public BuoyComponent mBuoyTaskComponent;
    public f05 mClickableTextToast;
    public PermissionJudgePolicy mCurrentPermissionJudgePolicy;
    public final GuidPageView mGuidPage;
    public boolean mIsHasScreenShotListener;
    public boolean mIsLogin;
    public s35 mKeyboardAdjust;
    public int mLastOrientation;
    public int mLastScreenHeight;
    public int mLastScreenWidth;
    public boolean mLayoutHasInit;
    public dv4 mLayoutInflateFactory;
    public fv4 mLayoutMode;
    public b05 mListMenu;
    public int mMaxHeight;
    public iv4 mPermissionCallback;
    public int mPreHeight;
    public ContinuousAnimationView mProgressBar;
    public lf5 mRefreshView;
    public final Handler mSafeHandler;
    public up5 mScreenShotListenManager;
    public int mSkinType;
    public SwipeBackLayout mSwipeBackLayout;
    public zj5 mTbPageExtra;
    public TbPageTag mTbPageTag;
    public boolean mUseStyleImmersiveSticky;
    public p35 mWaitingDialog;
    public BaseActivity<T>.NetRefreshListener netRefreshListener;
    public final CustomMessageListener nightResourcesChangeListener;
    public TbPageContext<T> pageContext;
    public ik5 pageStayDurationItem;
    public List<PopupWindow> popupWindowList;
    public hg resourcesWrapper;
    public Runnable setNoTranslucentRunnable;
    public final CustomMessageListener skinTypeChangeListener;

    @Override // com.baidu.tieba.fk5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.fk5
    public gk5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return null;
        }
        return (gk5) invokeV.objValue;
    }

    public void onKeyboardHeightChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i) == null) {
        }
    }

    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
        }
    }

    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
        }
    }

    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
        }
    }

    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
        }
    }

    public void setSchemaParams(Intent intent, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048688, this, intent, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.this$0.isFinishing()) {
                this.this$0.ShowSoftKeyPad((InputMethodManager) this.this$0.getSystemService("input_method"), this.mView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public abstract class LoadDataCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivity this$0;

        public abstract void callback(Object... objArr);

        public void onProgressUpdate(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }

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
    }

    /* loaded from: classes3.dex */
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

    private void adjustResizeForSoftInputOnDestory() {
        s35 s35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && (s35Var = this.mKeyboardAdjust) != null) {
            s35Var.i();
            this.mKeyboardAdjust = null;
        }
    }

    private String getCurrentExtraPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            String currentPageKey = getCurrentPageKey();
            if (TextUtils.isEmpty(currentPageKey)) {
                return getClass().getSimpleName();
            }
            return currentPageKey;
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
        f05 f05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && (f05Var = this.mClickableTextToast) != null) {
            f05Var.e();
        }
    }

    private void startScreenShotListen() {
        up5 up5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && PermissionUtil.isAgreePrivacyPolicy() && !this.mIsHasScreenShotListener && (up5Var = this.mScreenShotListenManager) != null) {
            up5Var.m(new up5.b(this) { // from class: com.baidu.tbadk.BaseActivity.9
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

                @Override // com.baidu.tieba.up5.b
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
            this.mScreenShotListenManager.n();
            this.mIsHasScreenShotListener = true;
        }
    }

    private void stopScreenShotListen() {
        up5 up5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.mIsHasScreenShotListener && (up5Var = this.mScreenShotListenManager) != null) {
            up5Var.o();
            this.mIsHasScreenShotListener = false;
        }
    }

    public void adjustResizeForSoftInput() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = s35.c(getPageContext().getPageActivity());
        }
    }

    public boolean checkUpIsLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return ViewHelper.checkUpIsLogin(getPageContext().getPageActivity());
        }
        return invokeV.booleanValue;
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
        p35 p35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (p35Var = this.mWaitingDialog) != null) {
            try {
                if (p35Var.c()) {
                    this.mWaitingDialog.h(false);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.mWaitingDialog = null;
        }
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
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (list = this.dialogList) != null) {
            for (Dialog dialog : list) {
                lg.b(dialog, getPageContext());
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

    @Override // com.baidu.tieba.fk5
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

    public PermissionJudgePolicy getCurrentPermissionJudgePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return TbadkCoreApplication.getInst().isGpuOpen();
        }
        return invokeV.booleanValue;
    }

    public dv4 getLayoutInflate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mLayoutInflateFactory;
        }
        return (dv4) invokeV.objValue;
    }

    public fv4 getLayoutMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mLayoutMode;
        }
        return (fv4) invokeV.objValue;
    }

    public b05 getListMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mListMenu;
        }
        return (b05) invokeV.objValue;
    }

    public p35 getLoadingDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mWaitingDialog;
        }
        return (p35) invokeV.objValue;
    }

    public kf5 getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.loadingView;
        }
        return (kf5) invokeV.objValue;
    }

    public View.OnClickListener getNetRefreshListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.netRefreshListener == null) {
                this.netRefreshListener = new NetRefreshListener();
            }
            return this.netRefreshListener;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public int getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            BdUniqueId uniqueId = getUniqueId();
            if (uniqueId != null) {
                return uniqueId.getId();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public ik5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.pageStayDurationItem == null) {
                ik5 ik5Var = new ik5();
                this.pageStayDurationItem = ik5Var;
                ik5Var.x(getCurrentPageSourceKeyList());
                this.pageStayDurationItem.s(getCurrentPageKey());
            }
            return this.pageStayDurationItem;
        }
        return (ik5) invokeV.objValue;
    }

    public String getPreExtraPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            zj5 tbPageExtra = getTbPageExtra();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return ek5.m(getIntent());
        }
        return (TbPageTag) invokeV.objValue;
    }

    public lf5 getRefreshView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new lf5(getPageContext().getContext(), getNetRefreshListener());
            }
            return this.mRefreshView;
        }
        return (lf5) invokeV.objValue;
    }

    public Handler getSafeHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.mSafeHandler;
        }
        return (Handler) invokeV.objValue;
    }

    public zj5 getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.mTbPageExtra == null) {
                this.mTbPageExtra = new zj5(getUniqueId(), getCurrentExtraPageKey(), "", getIntent());
            }
            return this.mTbPageExtra;
        }
        return (zj5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ck5
    public final dk5 getTbPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return new dk5(getUniqueId(), getTbPageTag(), getIntent());
        }
        return (dk5) invokeV.objValue;
    }

    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            KuangFloatingWindowController.getInstance().hideFloatingView();
        }
    }

    public void hideListMenu() {
        b05 b05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (b05Var = this.mListMenu) != null) {
            b05Var.e();
        }
    }

    public void hideProgressBar() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (continuousAnimationView = this.mProgressBar) != null) {
            continuousAnimationView.setVisibility(8);
            this.mProgressBar.cancelAnimation();
        }
    }

    public boolean isForceInterceptStimeStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.isForceInterceptStimeStat;
        }
        return invokeV.booleanValue;
    }

    public boolean isLoadingViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            kf5 kf5Var = this.loadingView;
            if (kf5Var == null) {
                return false;
            }
            return kf5Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.mIsLogin;
        }
        return invokeV.booleanValue;
    }

    public boolean isNetRefreshViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            lf5 lf5Var = this.mRefreshView;
            if (lf5Var == null) {
                return false;
            }
            return lf5Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isProgressBarShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            ContinuousAnimationView continuousAnimationView = this.mProgressBar;
            if (continuousAnimationView != null && continuousAnimationView.getVisibility() == 0) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.mUseStyleImmersiveSticky;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.onAttachedToWindow();
            ty5.K().Q();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            super.onBackPressed();
            EdgeFloatLifecycle.c().d();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            super.onRestart();
            flog = 0;
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("BaseActivity", "onStart:" + this);
            super.onStart();
            flog = 0;
        }
    }

    public void quitDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            UtilHelper.quitDialog(getPageContext().getPageActivity());
        }
    }

    public void setActivityBgTransparent() {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048673, this) == null) && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setBgTransparent();
        }
    }

    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            nq4.h(getPageId(), getMissionTid());
        }
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            setNetRefreshViewEmotionMarginTop(hi.g(getApplicationContext(), R.dimen.obfuscated_res_0x7f07029a));
        }
    }

    public void showFloatingWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            grantWindowPermission(new iv4(this) { // from class: com.baidu.tbadk.BaseActivity.10
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

                @Override // com.baidu.tieba.iv4
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
        b05 b05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && (b05Var = this.mListMenu) != null) {
            b05Var.m();
        }
    }

    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            try {
                showProgressBarWithOffset(0, 0);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void skipToLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            ViewHelper.skipToLoginActivity(getPageContext().getPageActivity());
        }
    }

    public void skipToRegisterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            ViewHelper.skipToRegisterActivity(getPageContext().getPageActivity());
        }
    }

    public void unRegisterResponsedEventListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            vh5.f().o(getUniqueId());
        }
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
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                }
            }

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
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    this.this$0.mProgressBar.setSpeed(1.0f);
                    this.this$0.mProgressBar.setMinAndMaxFrame(45, 105);
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
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.this$0.isFinishing()) {
                    xp5.a(this.this$0);
                }
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005017 && this.this$0.mLayoutMode != null) {
                    this.this$0.mLayoutMode.m(null);
                    this.this$0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
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
                boolean z;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer)) {
                    return;
                }
                this.this$0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    z = true;
                } else {
                    z = false;
                }
                UtilHelper.changeStatusBarIconAndTextColor(z, this.this$0);
                ty5.K().R(TbadkCoreApplication.getInst().getSkinType());
                EdgeFloatLifecycle.c().e(TbadkCoreApplication.getInst().getSkinType());
            }
        };
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                Resources resources = super.getResources();
                if (resources != null && ((!TbDimenManager.getInstance().needAdapt(resources.getDisplayMetrics()) || !TbDimenAdaptActivityLifecycle.isActivityNeedAdapte(this)) && !"SchemaRouteActivity".equalsIgnoreCase(getClass().getSimpleName()))) {
                    TbDimenManager tbDimenManager = TbDimenManager.getInstance();
                    tbDimenManager.setDensity(resources.getDisplayMetrics(), tbDimenManager.getDefaultDensity(), tbDimenManager.getDefaultDensityDpi());
                }
                return resources;
            }
            if (this.resourcesWrapper == null) {
                this.resourcesWrapper = new hg(super.getResources());
            }
            return this.resourcesWrapper;
        }
        return (Resources) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("BaseActivity", "onDestroy:" + this);
            closeLoadingDialog();
            GuidPageView guidPageView = this.mGuidPage;
            if (guidPageView != null) {
                guidPageView.b();
            }
            fv4 fv4Var = this.mLayoutMode;
            if (fv4Var != null) {
                fv4Var.c();
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
            jg.a().removeCallbacks(this.setNoTranslucentRunnable);
            tf5.e().b();
            ew4.c().d(getUniqueId());
        }
    }

    public static void setmClazz4GetPageContext(Class<? extends TbPageContext> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, cls) == null) {
            mClazz4GetPageContext = cls;
        }
    }

    public void ShowSoftKeyPadDelay(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            ShowSoftKeyPadDelay(view2, 150);
        }
    }

    public void adjustResizeForSoftInput(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = s35.e(getPageContext().getPageActivity(), z);
        }
    }

    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && i != this.mSkinType) {
            this.mSkinType = i;
            try {
                onChangeSkinType(i);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void changeSwipeSkinType(int i) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.forceChangeSkinType(i);
        }
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, responsedMessage)) == null) {
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
            lg.b(dialog, getPageContext());
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
            lg.d(popupWindow, getPageContext().getPageActivity());
            List<PopupWindow> list = this.popupWindowList;
            if (list != null) {
                list.remove(popupWindow);
            }
        }
    }

    public void hideLoadingView(View view2) {
        kf5 kf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, view2) == null) && (kf5Var = this.loadingView) != null) {
            kf5Var.dettachView(view2);
        }
    }

    public void hideNetRefreshView(View view2) {
        lf5 lf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, view2) == null) && (lf5Var = this.mRefreshView) != null) {
            lf5Var.dettachView(view2);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            EdgeFloatLifecycle.c().f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    @Override // com.baidu.tieba.kq4
    public boolean onMissionCompleted(CompleteTaskToastData completeTaskToastData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, completeTaskToastData)) == null) {
            hideClickableTextToast();
            this.mClickableTextToast = nq4.i(completeTaskToastData);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.baidu.tieba.f9
    public void onPreLoad(kn knVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, knVar) == null) {
            super.onPreLoad(knVar);
            PreLoadImageHelper.load(knVar, getUniqueId());
            PreLoadVideoHelper.load(knVar, getUniqueId(), this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                EdgeFloatLifecycle.c().g(z);
            }
        }
    }

    public void publishEvent(oh5 oh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048669, this, oh5Var) != null) || oh5Var == null) {
            return;
        }
        if (oh5Var.getTag() == 0) {
            oh5Var.setTag(getUniqueId());
        }
        vh5.i(oh5Var);
    }

    public void setCurrentPermissionJudgePolicy(PermissionJudgePolicy permissionJudgePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, permissionJudgePolicy) == null) {
            this.mCurrentPermissionJudgePolicy = permissionJudgePolicy;
        }
    }

    public void setExcludeHeight(int i) {
        s35 s35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048676, this, i) == null) && (s35Var = this.mKeyboardAdjust) != null) {
            s35Var.m(i);
        }
    }

    public void setForceInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z) == null) {
            this.isForceInterceptStimeStat = z;
        }
    }

    public void setInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z) == null) {
            this.isInterceptStimeStat = z;
        }
    }

    public void setIsAddSwipeBackLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.isAddSwipeBackLayout = z;
        }
    }

    public void setLayoutInflate(dv4 dv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, dv4Var) == null) {
            this.mLayoutInflateFactory = dv4Var;
        }
    }

    public void setLayoutMode(fv4 fv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, fv4Var) == null) {
            this.mLayoutMode = fv4Var;
        }
    }

    public void setNetRefreshViewEmotionMarginTop(int i) {
        lf5 lf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048685, this, i) == null) && (lf5Var = this.mRefreshView) != null && lf5Var.isViewAttached()) {
            this.mRefreshView.k(i);
        }
    }

    public void setNetRefreshViewPicResId(int i) {
        lf5 lf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048686, this, i) != null) || (lf5Var = this.mRefreshView) == null) {
            return;
        }
        lf5Var.h(i);
    }

    public void setNetRefreshViewTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new lf5(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.k(i);
        }
    }

    public void setSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i) == null) {
            this.mSkinType = i;
        }
    }

    public void setSwipeBackEnabled(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048690, this, z) == null) && TbadkCoreApplication.IS_SUPPORT_SWIPEBACK && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setSwipeBackEnabled(z);
        }
    }

    public void setSwipeBackIsSupportNight(boolean z) {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048691, this, z) == null) && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setIsSupportNight(z);
        }
    }

    public void setUseStyleImmersiveSticky(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z) == null) {
            this.mUseStyleImmersiveSticky = z;
        }
    }

    public boolean showDialog(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, dialog)) == null) {
            if (lg.j(dialog, getPageContext())) {
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

    public void showLoadingDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, str) == null) {
            showLoadingDialog(str, (DialogInterface.OnCancelListener) null);
        }
    }

    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, view2) == null) {
            showLoadingView(view2, false);
        }
    }

    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i) == null) {
            hi.P(getPageContext().getContext(), i);
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
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputMethodManager, view2) == null) && view2 != null && inputMethodManager != null) {
            try {
                inputMethodManager.showSoftInput(view2, 0);
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    public void ShowSoftKeyPadDelay(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view2, i) == null) {
            new Handler().postDelayed(new DelayRunnable(this, view2), i);
        }
    }

    public b05 createListMenu(String[] strArr, b05.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, strArr, cVar)) == null) {
            b05 b05Var = this.mListMenu;
            if (b05Var != null) {
                return b05Var;
            }
            return newListMenu(strArr, cVar);
        }
        return (b05) invokeLL.objValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048652, this, i, keyEvent)) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048653, this, i, keyEvent)) == null) {
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

    public void registerResponsedEventListener(Class<? extends oh5> cls, wh5 wh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048671, this, cls, wh5Var) == null) {
            vh5.f().m(cls, wh5Var, getUniqueId());
        }
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048697, this, str, onCancelListener) == null) {
            showLoadingDialog(str, onCancelListener, true);
        }
    }

    public void showLoadingView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048701, this, view2, z) == null) {
            showLoadingView(view2, z, -1);
        }
    }

    public void showNetRefreshView(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048703, this, view2, str) == null) {
            showNetRefreshView(view2, str, false);
        }
    }

    public void showNetRefreshViewNoClick(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048706, this, view2, str) == null) {
            showNetRefreshViewNoClick(view2, str, false);
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048708, this, popupWindow, view2)) == null) {
            if (lg.k(popupWindow, view2)) {
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

    public void showProgressBarWithOffset(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048713, this, i, i2) == null) {
            showProgressBar(false, i, i2);
        }
    }

    public void showToast(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048715, this, i, i2) == null) {
            this.customToast.showToast(i, 2000, i2);
        }
    }

    public void showToastWithDefaultIcon(String str, BdToast.ToastIcon toastIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048720, this, str, toastIcon) == null) {
            BdToast b = BdToast.b(getPageContext().getContext(), str);
            b.g(toastIcon);
            b.k();
        }
    }

    public void addGlobalLayoutListener() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getWindow() != null && getWindow().getDecorView() != null && getWindow().getDecorView().getViewTreeObserver() != null) {
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
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeI(65537, this, i) != null) {
                        return;
                    }
                    View rootView = this.this$0.getRootView();
                    if (!(rootView instanceof ViewGroup)) {
                        return;
                    }
                    boolean z2 = false;
                    View childAt = ((ViewGroup) rootView).getChildAt(0);
                    if (childAt == null) {
                        return;
                    }
                    Rect rect = new Rect();
                    childAt.getWindowVisibleDisplayFrame(rect);
                    int i2 = rect.bottom - rect.top;
                    if (i2 != this.this$0.mAboveKeyboardHeight) {
                        int i3 = (i * 2) / 3;
                        if (i2 < i3) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (this.this$0.mAboveKeyboardHeight != 0 && this.this$0.mAboveKeyboardHeight < i3) {
                            z2 = true;
                        }
                        if (z != z2) {
                            this.this$0.onKeyboardVisibilityChanged(z);
                            if ((TbSingleton.getInstance().isShowBackLabel || TbSingleton.getInstance().isShowVoiceFloat()) && this.this$0 == TbadkCoreApplication.getInst().getCurrentActivity()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new KeyBoardSwitchMessage(Boolean.valueOf(z2)));
                            }
                        }
                        this.this$0.mAboveKeyboardHeight = i2;
                    }
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    int i;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int i2 = 0;
                        try {
                            View rootView = this.this$0.getRootView();
                            if (rootView != null) {
                                i2 = rootView.getHeight();
                            }
                            int height = this.this$0.getWindow().getDecorView().getRootView().getHeight();
                            if (this.this$0.mLayoutHasInit) {
                                BaseActivity baseActivity = this.this$0;
                                if (this.this$0.mMaxHeight >= i2) {
                                    i = this.this$0.mMaxHeight;
                                } else {
                                    i = i2;
                                }
                                baseActivity.mMaxHeight = i;
                            } else {
                                this.this$0.mLayoutHasInit = true;
                                this.this$0.mMaxHeight = i2;
                            }
                            if (this.this$0.mLayoutHasInit && this.this$0.mMaxHeight > i2 && i2 != this.this$0.mPreHeight) {
                                int i3 = this.this$0.mMaxHeight - i2;
                                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i3) && i3 < (height * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i3) {
                                    TbadkCoreApplication.getInst().setKeyboardHeight(i3);
                                    this.this$0.onKeyboardHeightChanged(i3);
                                }
                            }
                            raiseOnKeyboardVisibilityChanged(height);
                            this.this$0.mPreHeight = i2;
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public void clearAnimatable() {
        List<Animatable> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (list = this.animatableList) != null) {
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
    }

    public void clearAnimation() {
        List<WeakReference<View>> list;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (list = this.animationList) != null) {
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
    }

    public void dismissAllPopupWindow() {
        List<PopupWindow> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (list = this.popupWindowList) != null) {
            for (PopupWindow popupWindow : list) {
                lg.d(popupWindow, getPageContext().getPageActivity());
            }
            this.popupWindowList.clear();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("BaseActivity", "finish:" + this);
            hi.z(getApplicationContext(), getWindow().getDecorView());
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            Intent intent = super.getIntent();
            if (intent == null) {
                return null;
            }
            String stringExtra = intent.getStringExtra("key_schema_params");
            if (stringExtra != null) {
                try {
                    setSchemaParams(intent, new JSONObject(stringExtra));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                intent.removeExtra("key_schema_params");
            }
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.base.BdBaseActivity, com.baidu.tieba.b9
    public TbPageContext<T> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
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

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("BaseActivity", "onStop:" + this);
            super.onStop();
            if (this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                flog = 1;
            }
            onResourceRecycle();
        }
    }

    public void adjustResizeForSoftInput(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.mUseStyleImmersiveSticky) {
            adjustResizeForSoftInputOnDestory();
            this.mKeyboardAdjust = s35.d(getPageContext().getPageActivity(), i, z);
        }
    }

    public b05 newListMenu(String[] strArr, b05.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048644, this, strArr, cVar)) == null) {
            b05 b05Var = new b05(getPageContext().getPageActivity());
            this.mListMenu = b05Var;
            b05Var.l(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0deb));
            this.mListMenu.j(strArr, cVar);
            this.mListMenu.c(getPageContext());
            return this.mListMenu;
        }
        return (b05) invokeLL.objValue;
    }

    public void showToast(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048716, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                showToast(i);
            } else {
                hi.P(getPageContext().getContext(), i);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            w05.k(false);
            nq4.a(motionEvent, getPageId(), getMissionTid());
            jh9.getInstance().behaviorRecordEvent(motionEvent, this);
            ty5.K().H();
            EdgeFloatLifecycle.c().b(motionEvent);
            try {
                if (this.mProgressBar != null && this.mProgressBar.isShown()) {
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
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

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            kf5 kf5Var = this.loadingView;
            if (kf5Var != null) {
                kf5Var.onChangeSkinType();
            }
            lf5 lf5Var = this.mRefreshView;
            if (lf5Var != null) {
                lf5Var.onChangeSkinType();
            }
            SwipeBackLayout swipeBackLayout = this.mSwipeBackLayout;
            if (swipeBackLayout != null) {
                swipeBackLayout.onChangeSkinType(i);
            }
            s35 s35Var = this.mKeyboardAdjust;
            if (s35Var != null) {
                s35Var.j(i);
            }
            if (this.mUseStyleImmersiveSticky) {
                this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
            }
            b05 b05Var = this.mListMenu;
            if (b05Var != null) {
                b05Var.b(getPageContext());
            }
        }
    }

    public void setNetRefreshLayoutMarginTop(boolean z) {
        lf5 lf5Var;
        int a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048682, this, z) == null) && (lf5Var = this.mRefreshView) != null && lf5Var.isViewAttached() && this.mRefreshView.b() != null && (this.mRefreshView.b().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            if (z) {
                a = BdListViewHelper.b(BdListViewHelper.HeadType.DEFAULT, false);
            } else {
                a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            }
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.b().getLayoutParams()).topMargin = a;
        }
    }

    @Override // com.baidu.tieba.fk5
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
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
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean grantWindowPermission(iv4 iv4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, iv4Var)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getBaseContext())) {
                    if (iv4Var != null) {
                        iv4Var.onPermissionResult(true);
                    }
                } else {
                    this.mPermissionCallback = iv4Var;
                    if (!m35.m().i("key_is_window_permission_dialog_shown", false)) {
                        zz4 zz4Var = new zz4(this);
                        zz4Var.setCanceledOnTouchOutside(false);
                        zz4Var.setTitle(R.string.request_permission_default_title);
                        zz4Var.setMessageId(R.string.request_window_permission_default_text);
                        zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0a46, new zz4.e(this) { // from class: com.baidu.tbadk.BaseActivity.8
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

                            @Override // com.baidu.tieba.zz4.e
                            public void onClick(zz4 zz4Var2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, zz4Var2) == null) {
                                    zz4Var2.dismiss();
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
                        }).setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new zz4.e(this) { // from class: com.baidu.tbadk.BaseActivity.7
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

                            @Override // com.baidu.tieba.zz4.e
                            public void onClick(zz4 zz4Var2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, zz4Var2) == null) {
                                    zz4Var2.dismiss();
                                    if (this.this$0.mPermissionCallback != null) {
                                        this.this$0.mPermissionCallback.onPermissionResult(false);
                                    }
                                }
                            }
                        }).create(getPageContext());
                        zz4Var.show();
                        m35.m().w("key_is_window_permission_dialog_shown", true);
                    } else {
                        iv4 iv4Var2 = this.mPermissionCallback;
                        if (iv4Var2 != null) {
                            iv4Var2.onPermissionResult(false);
                        }
                    }
                    return false;
                }
            } else if (iv4Var != null) {
                iv4Var.onPermissionResult(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (configuration == null) {
                return;
            }
            int i = configuration.orientation;
            if (i == this.mLastOrientation) {
                if (configuration.screenWidthDp != this.mLastScreenWidth || configuration.screenHeightDp != this.mLastScreenHeight) {
                    this.mLastScreenWidth = configuration.screenWidthDp;
                    this.mLastScreenHeight = configuration.screenHeightDp;
                    hi.a = false;
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

    @Override // com.baidu.adp.base.BdBaseActivity
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            String name = getClass().getName();
            String str2 = getApplicationContext().getPackageName() + ".chat";
            if (!name.startsWith(getApplicationContext().getPackageName() + ".im") && !name.startsWith(str2)) {
                hi.Q(getPageContext().getContext(), str);
            } else {
                this.customToast.showToast(str, 2000);
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        iv4 iv4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048645, this, i, i2, intent) == null) {
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("BaseActivity", "onActivityResult:" + this + " requestCode:" + i + " resultCode:" + i2);
            super.onActivityResult(i, i2, intent);
            if (!tq5.c(i, i2, intent) && (iv4Var = this.mPermissionCallback) != null && Build.VERSION.SDK_INT >= 23 && i == 12016) {
                iv4Var.onPermissionResult(Settings.canDrawOverlays(getBaseContext()));
                this.mPermissionCallback = null;
            }
        }
    }

    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048698, this, str, onCancelListener, z) != null) || isFinishing() || !lg.f(getPageContext())) {
            return;
        }
        if (str == null) {
            str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f003a);
        }
        p35 p35Var = new p35((TbPageContext<?>) getPageContext());
        this.mWaitingDialog = p35Var;
        p35Var.j(str);
        this.mWaitingDialog.e(onCancelListener);
        this.mWaitingDialog.d(false);
        this.mWaitingDialog.f(z);
        this.mWaitingDialog.h(true);
    }

    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048702, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.loadingRootView = view2;
            if (this.loadingView == null) {
                if (i < 0) {
                    this.loadingView = new kf5(getPageContext().getContext());
                } else {
                    kf5 kf5Var = new kf5(getPageContext().getContext(), i);
                    this.loadingView = kf5Var;
                    kf5Var.i();
                }
                this.loadingView.onChangeSkinType();
            }
            this.loadingView.attachView(view2, z);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, bundle) == null) {
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("BaseActivity", "onCreate:" + this);
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
            this.mLayoutMode = new fv4();
            dv4 dv4Var = new dv4();
            this.mLayoutInflateFactory = dv4Var;
            dv4Var.a(this.mLayoutMode);
            getLayoutInflater().setFactory(this.mLayoutInflateFactory);
            if (this.mUseStyleImmersiveSticky) {
                this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
            }
            if (getGpuSwitch()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            TiebaStaticHelper.setCurrentActivity(getClass().getName());
            registerListener(this.nightResourcesChangeListener);
            registerListener(this.skinTypeChangeListener);
            enterExitAnimation();
            this.mIsLogin = TbadkCoreApplication.isLogin();
            this.mScreenShotListenManager = new up5(this);
            SpeedStats.getInstance().onBaseActivityCreate(this);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("BaseActivity", "onPause:" + this);
            jh9.getInstance().onPause(this);
            super.onPause();
            if (TbSingleton.getInstance().isShowBackLabel && this == TbadkCoreApplication.getInst().getCurrentActivity()) {
                hideFloatingWindow();
            }
            if (this.lastResumeTime != 0 && !this.isInterceptStimeStat && !this.isForceInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                ik5 pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                jk5.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
            this.customToast.onPause();
            stopScreenShotListen();
            TbadkCoreApplication.getInst().DelResumeNum();
            TbadkCoreApplication.getInst().setCurrentActivity(null);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, this));
            if (this.isAddSwipeBackLayout) {
                jg.a().removeCallbacks(this.setNoTranslucentRunnable);
                jg.a().postDelayed(this.setNoTranslucentRunnable, 1000L);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        PermissionJudgePolicy permissionJudgePolicy2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048660, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (iArr != null && iArr.length > 0 && strArr != null && strArr.length > 0) {
                boolean z = false;
                if (iArr[0] != 0 && (permissionJudgePolicy2 = this.mCurrentPermissionJudgePolicy) != null) {
                    permissionJudgePolicy2.checkPermissionForbidden(this, strArr[0]);
                }
                int i2 = 0;
                while (true) {
                    if (i2 < strArr.length) {
                        if (iArr[i2] != 0) {
                            break;
                        }
                        i2++;
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

    public void showNetRefreshViewNoClick(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048707, this, view2, str, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new lf5(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.m(str);
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.e();
        }
    }

    public void startAnimation(View view2, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048724, this, view2, animation, animationListener) != null) || animation == null || isFinishing()) {
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
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation2) == null) && (animationListener2 = this.val$listener) != null) {
                    animationListener2.onAnimationRepeat(animation2);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                Animation.AnimationListener animationListener2;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation2) == null) && (animationListener2 = this.val$listener) != null) {
                    animationListener2.onAnimationStart(animation2);
                }
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

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("BaseActivity", "onResume:" + this);
            MenuKeyUtils.hideSoftMenuKey(getWindow());
            super.onResume();
            jh9.getInstance().onResume(this);
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
                jg.a().removeCallbacks(this.setNoTranslucentRunnable);
                xp5.b(this);
            }
            ty5.K().c0(this);
            EdgeFloatLifecycle.c().j(this);
        }
    }

    @Deprecated
    public void setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(boolean z) {
        lf5 lf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048683, this, z) == null) && (lf5Var = this.mRefreshView) != null && lf5Var.isViewAttached() && this.mRefreshView.b() != null && (this.mRefreshView.b().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mRefreshView.b().getLayoutParams()).topMargin = BdListViewHelper.b(BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void startAnimatable(Animatable animatable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048723, this, animatable) != null) || animatable == null || isFinishing()) {
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

    public void showLoadingDialog(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048699, this, str, z) == null) {
            showLoadingDialog(str, null, true);
        }
    }

    public void showToast(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048718, this, str, i) == null) {
            this.customToast.showToast(str, 2000, i);
        }
    }

    public void showNetRefreshView(View view2, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048704, this, new Object[]{view2, str, str2, str3, Boolean.valueOf(z), onClickListener}) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new lf5(getPageContext().getContext(), onClickListener);
            }
            this.mRefreshView.n(str);
            this.mRefreshView.m(str2);
            this.mRefreshView.g(str3);
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.p();
        }
    }

    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048705, this, view2, str, z) == null) {
            showNetRefreshView(view2, null, str, null, z, getNetRefreshListener());
        }
    }

    public boolean showPopupWindowAsDropDown(PopupWindow popupWindow, View view2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048709, this, popupWindow, view2, i, i2)) == null) {
            if (lg.l(popupWindow, view2, i, i2)) {
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

    public boolean showPopupWindowAtLocation(PopupWindow popupWindow, View view2, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048710, this, new Object[]{popupWindow, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (lg.m(popupWindow, view2, i, i2, i3)) {
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

    public void showProgressBar(boolean z, int i, int i2) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048712, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (this.mProgressBar == null) {
                try {
                    this.mProgressBar = new ContinuousAnimationView(getPageContext().getPageActivity());
                    FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
                    int g = hi.g(getPageContext().getPageActivity(), R.dimen.tbds200);
                    frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(g, g, 17));
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
                continuousAnimationView2.setPadding(hi.d(getPageContext().getPageActivity(), i), hi.d(getPageContext().getPageActivity(), i2), 0, 0);
                this.mProgressBar.setVisibility(0);
                this.mProgressBar.setSpeed(1.3f);
                this.mProgressBar.setMinAndMaxProgress(0.0f, 1.0f);
                this.mProgressBar.playAnimation();
            }
        }
    }

    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048719, this, str, z) == null) {
            if (z) {
                showToast(str);
            } else {
                hi.Q(getPageContext().getContext(), str);
            }
        }
    }
}
