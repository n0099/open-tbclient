package com.baidu.tbadk.core;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.BuoyComponent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g9;
import com.repackage.gd5;
import com.repackage.ik4;
import com.repackage.j55;
import com.repackage.jg;
import com.repackage.k55;
import com.repackage.k65;
import com.repackage.li4;
import com.repackage.n55;
import com.repackage.n85;
import com.repackage.o85;
import com.repackage.p85;
import com.repackage.pi;
import com.repackage.r65;
import com.repackage.rn;
import com.repackage.s65;
import com.repackage.v85;
import com.repackage.vk;
import com.repackage.w85;
import com.repackage.y85;
import com.repackage.z85;
import com.repackage.za;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class BaseFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener, AbsListView.OnScrollListener, v85, g9, IVideoNeedPreload, n85 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PRELOAD_DELAY = 100;
    public static final String TAB_CODE = "tab_code";
    public transient /* synthetic */ FieldHolder $fh;
    public CustomToast customToast;
    public boolean isInterceptStimeStat;
    public boolean isLazyLoaded;
    public boolean isPrepared;
    public boolean isPrimary;
    public long lastResumeTime;
    public j55 loadingView;
    public final CustomMessageListener mActivityMissionDataInitCompletedListener;
    public BuoyComponent mBuoyTaskComponent;
    public View mFragmentRootView;
    public final Handler mHandler;
    public BdUniqueId mId;
    public boolean mIsLogin;
    public boolean mIsScroll;
    public n55 mLocationView;
    public ContinuousAnimationView mProgressBar;
    public k55 mRefreshView;
    public int mSkinType;
    public String mTag;
    public String mTbPageExtraPageTabName;
    public TbPageTag mTbPageTag;
    public int mUsedThemeId;
    public boolean needLogStayDuration;
    public c netRefreshListener;
    public y85 pageStayDurationItem;
    public final Runnable preLoadRunnable;
    public String tabCode;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseFragment baseFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragment, Integer.valueOf(i)};
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
            this.a = baseFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isResumed()) {
                this.a.startBrowseTimeMission();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragment a;

        public b(BaseFragment baseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BaseFragment baseFragment = this.a;
                baseFragment.onPreLoad(baseFragment.onGetPreLoadListView());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragment a;

        public c(BaseFragment baseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onNetRefreshButtonClicked();
            }
        }

        public /* synthetic */ c(BaseFragment baseFragment, a aVar) {
            this(baseFragment);
        }
    }

    public BaseFragment() {
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
        this.mId = null;
        this.mSkinType = 3;
        this.mUsedThemeId = 0;
        this.mIsLogin = false;
        this.needLogStayDuration = true;
        this.mHandler = new Handler();
        this.mIsScroll = false;
        this.isLazyLoaded = false;
        this.isPrepared = false;
        this.isInterceptStimeStat = false;
        this.mActivityMissionDataInitCompletedListener = new a(this, 2921391);
        this.preLoadRunnable = new b(this);
    }

    private void lazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && getUserVisibleHint() && this.isPrepared && !this.isLazyLoaded) {
            onLazyLoad();
            this.isLazyLoaded = true;
        }
    }

    private void pauseBrowseTimeMission() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !TextUtils.isEmpty(this.tabCode) && li4.w().y(this.tabCode.hashCode())) {
            li4.w().E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBrowseTimeMission() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || TextUtils.isEmpty(this.tabCode)) {
            return;
        }
        li4.w().N(this.tabCode.hashCode());
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

    public void bindFragmentExtraToView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            unbindFragmentExtraFormView(this.mFragmentRootView);
            if (view2 != null) {
                this.mFragmentRootView = view2;
                view2.setTag(R.id.obfuscated_res_0x7f091f36, this);
            }
        }
    }

    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i == this.mSkinType && this.mUsedThemeId == TbadkCoreApplication.getInst().getUsedThemeId()) {
                return;
            }
            this.mSkinType = i;
            this.mUsedThemeId = TbadkCoreApplication.getInst().getUsedThemeId();
            onChangeSkinType(this.mSkinType);
        }
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, responsedMessage)) == null) ? (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true : invokeL.booleanValue;
    }

    public boolean checkUpIsLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ViewHelper.checkUpIsLogin(getFragmentActivity()) : invokeV.booleanValue;
    }

    public BaseFragmentActivity getBaseFragmentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (BaseFragmentActivity) getTargetActivity() : (BaseFragmentActivity) invokeV.objValue;
    }

    public String getBaseTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTag : (String) invokeV.objValue;
    }

    @Override // com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.v85
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getActivity() instanceof v85) {
                v85 v85Var = (v85) getActivity();
                ArrayList arrayList = (ArrayList) v85Var.getCurrentPageSourceKeyList();
                if (!StringUtils.isNull(v85Var.getCurrentPageKey()) && (v85Var.getPageStayFilter() == null || v85Var.getPageStayFilter().c())) {
                    if (ListUtils.isEmpty(arrayList)) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(v85Var.getCurrentPageKey());
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public FragmentActivity getFragmentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? super.getActivity() : (FragmentActivity) invokeV.objValue;
    }

    public j55 getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.loadingView : (j55) invokeV.objValue;
    }

    public View.OnClickListener getNetRefreshListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.netRefreshListener == null) {
                this.netRefreshListener = new c(this, null);
            }
            return this.netRefreshListener;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.repackage.v85
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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

    public TbPageContext<BaseFragmentActivity> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity == null) {
                return null;
            }
            return baseFragmentActivity.getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public y85 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.pageStayDurationItem == null) {
                this.pageStayDurationItem = new y85();
            }
            this.pageStayDurationItem.s(getCurrentPageKey());
            this.pageStayDurationItem.x(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.A(getTbPageExtra());
            return this.pageStayDurationItem;
        }
        return (y85) invokeV.objValue;
    }

    @Override // com.repackage.v85
    public w85 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (w85) invokeV.objValue;
    }

    public Context getTargetActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? getActivity() : (Context) invokeV.objValue;
    }

    @Override // com.repackage.n85
    public o85 getTbFragmentExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new o85(this) : (o85) invokeV.objValue;
    }

    public p85 getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            return new p85(getUniqueId(), getCurrentPageKey(), this.mTbPageExtraPageTabName, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
        }
        return (p85) invokeV.objValue;
    }

    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.mTbPageTag == null) {
                TbPageTag tbPageTag = new TbPageTag();
                this.mTbPageTag = tbPageTag;
                tbPageTag.locatePage = getCurrentPageKey();
            }
            return this.mTbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.repackage.g9
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mId : (BdUniqueId) invokeV.objValue;
    }

    public void hideLoadingView(View view2) {
        j55 j55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, view2) == null) || (j55Var = this.loadingView) == null) {
            return;
        }
        j55Var.dettachView(view2);
    }

    public void hideNetRefreshView(View view2) {
        k55 k55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, view2) == null) || (k55Var = this.mRefreshView) == null) {
            return;
        }
        k55Var.dettachView(view2);
    }

    public void hideProgressBar() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (continuousAnimationView = this.mProgressBar) == null) {
            return;
        }
        continuousAnimationView.setVisibility(8);
        this.mProgressBar.cancelAnimation();
    }

    public boolean isLoadingViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            j55 j55Var = this.loadingView;
            if (j55Var == null) {
                return false;
            }
            return j55Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isNetRefreshViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            k55 k55Var = this.mRefreshView;
            return k55Var != null && k55Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isPrimary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.isPrimary : invokeV.booleanValue;
    }

    @Override // com.repackage.g9
    public boolean isScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mIsScroll : invokeV.booleanValue;
    }

    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? !isHidden() : invokeV.booleanValue;
    }

    public void normalLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && getUserVisibleHint() && this.isPrepared && !gd5.a()) {
            onLoad();
        }
    }

    public void notifyColourHeaderData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.isPrepared = true;
            registerListener(this.mActivityMissionDataInitCompletedListener);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            j55 j55Var = this.loadingView;
            if (j55Var != null) {
                j55Var.r(i);
                this.loadingView.onChangeSkinType();
            }
            k55 k55Var = this.mRefreshView;
            if (k55Var != null) {
                k55Var.onChangeSkinType();
            }
            n55 n55Var = this.mLocationView;
            if (n55Var != null) {
                n55Var.onChangeSkinType();
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, dialogInterface, i) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            if (this.mId == null) {
                this.mId = BdUniqueId.gen();
            }
            this.customToast = CustomToast.newInstance();
            super.onCreate(bundle);
            this.mIsLogin = TbadkCoreApplication.isLogin();
            if (getArguments() != null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.tabCode = bundle.getString("tab_code");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            bindFragmentExtraToView(onCreateView);
            return onCreateView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDestroy();
            jg.h().e(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            MessageManager.getInstance().unRegisterListener(this.mActivityMissionDataInitCompletedListener);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onDestroyView();
            j55 j55Var = this.loadingView;
            if (j55Var != null) {
                j55Var.n();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onDetach();
            unbindFragmentExtraFormView(this.mFragmentRootView);
            MessageManager.getInstance().unRegisterListener(this.mId);
            MessageManager.getInstance().removeMessage(this.mId);
            unRegisterResponsedEventListener();
        }
    }

    public rn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (rn) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z) {
                onResume();
            } else {
                onPause();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.isLazyLoaded = true;
        }
    }

    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.customToast.onPause();
            super.onPause();
            if (this.needLogStayDuration && isPrimary() && this.lastResumeTime != 0 && !this.isInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                y85 pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                z85.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                this.lastResumeTime = System.currentTimeMillis();
            }
            jg.h().e(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            pauseBrowseTimeMission();
            taskStop();
        }
    }

    @Override // com.repackage.g9
    public void onPreLoad(rn rnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, rnVar) == null) {
            PreLoadImageHelper.load(rnVar, getUniqueId());
            PreLoadVideoHelper.load(rnVar, getUniqueId(), this);
        }
    }

    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.isPrimary) {
                if (this.isInterceptStimeStat) {
                    setInterceptStimeStat(false);
                } else {
                    this.lastResumeTime = System.currentTimeMillis();
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            } else if (this.needLogStayDuration && this.lastResumeTime != 0 && !this.isInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                y85 pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                z85.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                this.lastResumeTime = System.currentTimeMillis();
            }
            if (this.isPrimary) {
                startBrowseTimeMission();
            } else {
                pauseBrowseTimeMission();
            }
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (this.mIsLogin != isLogin) {
                this.mIsLogin = isLogin;
                onUserChanged(isLogin);
            }
            if (taskAttachParentView() != null) {
                if (isPrimary()) {
                    taskResume();
                } else {
                    taskPause();
                }
            }
        }
    }

    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            CustomToast customToast = this.customToast;
            if (customToast != null) {
                customToast.onResume();
            }
            super.onResume();
            if (isShow()) {
                changeSkinType(TbadkCoreApplication.getInst().getSkinType());
                TiebaStaticHelper.setCurrentActivity(getClass().getName());
                if (this.isPrimary) {
                    onPrimary();
                }
                onResumeLoadResource();
                if (TextUtils.isEmpty(taskActionId())) {
                    return;
                }
                taskStart();
            }
        }
    }

    public void onResumeLoadResource() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && (getView() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                refreshImage(viewGroup.getChildAt(i));
            }
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            this.mHandler.postDelayed(this.preLoadRunnable, 100L);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048630, this, absListView, i, i2, i3) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, absListView, i) == null) {
        }
    }

    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, view2, bundle) == null) {
            bindFragmentExtraToView(view2);
            super.onViewCreated(view2, bundle);
        }
    }

    public void publishEvent(k65 k65Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, k65Var) == null) || k65Var == null) {
            return;
        }
        if (k65Var.getTag() == 0) {
            k65Var.setTag(getUniqueId());
        }
        r65.i(k65Var);
    }

    public void refreshImage(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2 instanceof vk) {
            ((vk) view2).refresh();
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                refreshImage(viewGroup.getChildAt(i));
            }
        }
    }

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void registerResponsedEventListener(Class<? extends k65> cls, s65 s65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048644, this, cls, s65Var) == null) {
            r65.f().m(cls, s65Var, getUniqueId());
        }
    }

    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048645, this, message) == null) || message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    public void setBaseTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.mTag = str;
        }
    }

    public void setInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.isInterceptStimeStat = z;
        }
    }

    @Override // com.repackage.g9
    public void setIsScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.mIsScroll = z;
        }
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            setNetRefreshViewEmotionMarginTop(pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07029b));
        }
    }

    public void setNetRefreshViewEmotionMarginTop(int i) {
        k55 k55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048651, this, i) == null) && (k55Var = this.mRefreshView) != null && k55Var.isViewAttached()) {
            this.mRefreshView.k(i);
        }
    }

    public void setNetRefreshViewTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new k55(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.k(i);
        }
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            this.isPrimary = z;
            if (isResumed()) {
                onPrimary();
            }
            if (TextUtils.equals(getClass().getName(), TbPageExtraHelper.FLUTTER_FRAGMENT_CLASS_NAME) || this.isPrimary || getCurrentPageKey() == null || TextUtils.equals(TbPageExtraHelper.getPrePageKey(), getCurrentPageKey())) {
                return;
            }
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
        }
    }

    public void setTbPageExtraPageTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.mTbPageExtraPageTabName = str;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048655, this, z) == null) && isAdded() && !isHidden()) {
            super.setUserVisibleHint(z);
            lazyLoad();
            normalLoad();
        }
    }

    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, view2) == null) {
            showLoadingView(view2, false);
        }
    }

    public void showLocationView(View view2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048660, this, view2, onClickListener) == null) || getPageContext() == null || getPageContext().getContext() == null) {
            return;
        }
        if (this.mLocationView == null) {
            this.mLocationView = new n55(getPageContext().getContext());
        }
        this.mLocationView.attachView(view2);
        this.mLocationView.b(onClickListener);
    }

    public void showNetRefreshView(View view2, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048661, this, new Object[]{view2, str, str2, str3, Boolean.valueOf(z), onClickListener}) == null) || getPageContext() == null || getPageContext().getContext() == null) {
            return;
        }
        if (this.mRefreshView == null) {
            this.mRefreshView = new k55(getPageContext().getContext(), onClickListener);
        }
        this.mRefreshView.n(str);
        this.mRefreshView.m(str2);
        this.mRefreshView.g(str3);
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.mRefreshView.attachView(view2, z);
        this.mRefreshView.p();
    }

    public void showNetRefreshViewNoClick(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048663, this, view2, str, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new k55(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.m(str);
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.e();
        }
    }

    public void showNetRefreshViewNoClickWithTitle(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048664, this, view2, str, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new k55(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.e();
            this.mRefreshView.o(str);
        }
    }

    public void showNoDataNoRefreshView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048665, this, view2, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new k55(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.e();
            this.mRefreshView.i(R.drawable.new_pic_emotion_05);
            this.mRefreshView.o(getString(R.string.obfuscated_res_0x7f0f0c32));
        }
    }

    public void showNoDataRefreshView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048666, this, view2, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new k55(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.p();
            this.mRefreshView.i(R.drawable.new_pic_emotion_03);
            this.mRefreshView.o(getString(R.string.obfuscated_res_0x7f0f0c44));
        }
    }

    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            try {
                showProgressBarWithOffset(0, 0);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void showProgressBarWithOffset(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048670, this, i, i2) == null) {
            showProgressBar(false, i, i2);
        }
    }

    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048673, this, str) == null) || getActivity() == null) {
            return;
        }
        String name = getClass().getName();
        String str2 = getActivity().getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") && !name.startsWith(str2)) {
            pi.O(getActivity(), str);
        } else {
            this.customToast.showToast(str, 2000);
        }
    }

    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void taskPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            ik4.f().h(this.mBuoyTaskComponent);
        }
    }

    public void taskResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            ik4.f().k(this.mBuoyTaskComponent);
        }
    }

    public void taskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            this.mBuoyTaskComponent = ik4.f().m(getActivity(), taskAttachParentView(), taskActionId());
        }
    }

    public void taskStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            ik4.f().n(this.mBuoyTaskComponent);
        }
    }

    public void unRegisterResponsedEventListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            r65.f().n(getUniqueId());
        }
    }

    public void unbindFragmentExtraFormView(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048682, this, view2) == null) || view2 == null) {
            return;
        }
        view2.setTag(R.id.obfuscated_res_0x7f091f36, null);
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void showLoadingView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048657, this, view2, z) == null) {
            showLoadingView(view2, z, -1);
        }
    }

    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            showLoadingView(view2, z, i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void showProgressBar(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048668, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            showProgressBar(z, false, i, i2);
        }
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048636, this, i, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i, messageListener);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048646, this, netMessage) == null) || netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void showLoadingView(View view2, boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) || isLoadingViewAttached() || getActivity() == null) {
            return;
        }
        if (this.loadingView == null) {
            if (i < 0) {
                this.loadingView = new j55(getActivity());
            } else {
                j55 j55Var = new j55(getActivity(), i);
                this.loadingView = j55Var;
                j55Var.i();
            }
            this.loadingView.r(i2);
            this.loadingView.onChangeSkinType();
        }
        this.loadingView.attachView(view2, z);
    }

    public void showProgressBar(boolean z, boolean z2, int i, int i2) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048669, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (this.mProgressBar == null) {
                try {
                    ContinuousAnimationView continuousAnimationView2 = new ContinuousAnimationView(getPageContext().getPageActivity());
                    this.mProgressBar = continuousAnimationView2;
                    continuousAnimationView2.setAnimation(R.raw.lottie_pull_refresh);
                    FrameLayout frameLayout = (FrameLayout) getFragmentActivity().findViewById(16908290);
                    int f = pi.f(getPageContext().getPageActivity(), z2 ? R.dimen.tbds160 : R.dimen.tbds80);
                    frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(f, f, 17));
                } catch (Throwable unused) {
                    return;
                }
            }
            if (z && (continuousAnimationView = this.mProgressBar) != null) {
                continuousAnimationView.bringToFront();
            }
            ContinuousAnimationView continuousAnimationView3 = this.mProgressBar;
            if (continuousAnimationView3 != null) {
                continuousAnimationView3.setPadding(pi.d(getPageContext().getPageActivity(), i), pi.d(getPageContext().getPageActivity(), i2), 0, 0);
                this.mProgressBar.setVisibility(0);
                this.mProgressBar.playAnimation();
            }
        }
    }

    public void registerListener(za zaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, zaVar) == null) {
            if (zaVar != null && zaVar.getTag() == null) {
                zaVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(zaVar);
        }
    }

    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048671, this, i) == null) || getActivity() == null) {
            return;
        }
        String name = getClass().getName();
        String str = getActivity().getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") && !name.startsWith(str)) {
            pi.N(getActivity(), i);
        } else {
            this.customToast.showToast(i, 2000);
        }
    }

    public void registerListener(int i, za zaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048638, this, i, zaVar) == null) {
            if (zaVar != null && zaVar.getTag() == null) {
                zaVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i, zaVar);
        }
    }

    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048662, this, view2, str, z) == null) {
            showNetRefreshView(view2, null, str, null, z, getNetRefreshListener());
        }
    }

    public void registerListener(MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, messageListener, bdUniqueId) == null) {
            if (messageListener != null) {
                messageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void registerListener(int i, MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048637, this, i, messageListener, bdUniqueId) == null) {
            if (messageListener != null) {
                messageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(i, messageListener);
        }
    }

    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048674, this, str, z) == null) {
            if (z) {
                this.customToast.showToast(str, 2000);
            } else {
                pi.O(TbadkCoreApplication.getInst().getApp(), str);
            }
        }
    }

    public void registerListener(za zaVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, zaVar, bdUniqueId) == null) {
            if (zaVar != null) {
                zaVar.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(zaVar);
        }
    }

    public void showToast(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048672, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.customToast.showToast(i, 2000);
            } else {
                pi.N(TbadkCoreApplication.getInst().getApp(), i);
            }
        }
    }

    public void registerListener(int i, za zaVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048639, this, i, zaVar, bdUniqueId) == null) {
            if (zaVar != null) {
                zaVar.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(i, zaVar);
        }
    }
}
