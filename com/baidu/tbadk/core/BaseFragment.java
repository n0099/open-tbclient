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
import c.a.d.a.i;
import c.a.d.f.p.l;
import c.a.d.m.e.q;
import c.a.q0.d1.o;
import c.a.q0.g0.g;
import c.a.q0.g0.h;
import c.a.q0.p0.d;
import c.a.q0.p0.e;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class BaseFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener, AbsListView.OnScrollListener, c.a.q0.p0.a, i, IVideoNeedPreload, c.a.q0.n0.a {
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
    public g loadingView;
    public final CustomMessageListener mActivityMissionDataInitCompletedListener;
    public View mFragmentRootView;
    public final Handler mHandler;
    public BdUniqueId mId;
    public boolean mIsLogin;
    public boolean mIsScroll;
    public c.a.q0.h0.a mLocationView;
    public ContinuousAnimationView mProgressBar;
    public h mRefreshView;
    public int mSkinType;
    public String mTag;
    public TbPageTag mTbPageTag;
    public int mUsedThemeId;
    public boolean needLogStayDuration;
    public c netRefreshListener;
    public d pageStayDurationItem;
    public final Runnable preLoadRunnable;
    public String tabCode;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseFragment baseFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragment, Integer.valueOf(i2)};
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

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseFragment f40867e;

        public b(BaseFragment baseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40867e = baseFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BaseFragment baseFragment = this.f40867e;
                baseFragment.onPreLoad(baseFragment.onGetPreLoadListView());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseFragment f40868e;

        public c(BaseFragment baseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40868e = baseFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40868e.onNetRefreshButtonClicked();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !TextUtils.isEmpty(this.tabCode) && c.a.q0.a.d.y().A(this.tabCode.hashCode())) {
            c.a.q0.a.d.y().G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBrowseTimeMission() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || TextUtils.isEmpty(this.tabCode)) {
            return;
        }
        c.a.q0.a.d.y().P(this.tabCode.hashCode());
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

    public void bindFragmentExtraToView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            unbindFragmentExtraFormView(this.mFragmentRootView);
            if (view != null) {
                this.mFragmentRootView = view;
                view.setTag(R.id.tag_tb_fragment_extra, this);
            }
        }
    }

    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == this.mSkinType && this.mUsedThemeId == TbadkCoreApplication.getInst().getUsedThemeId()) {
                return;
            }
            this.mSkinType = i2;
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

    @Override // c.a.q0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.q0.p0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getActivity() instanceof c.a.q0.p0.a) {
                c.a.q0.p0.a aVar = (c.a.q0.p0.a) getActivity();
                ArrayList arrayList = (ArrayList) aVar.getCurrentPageSourceKeyList();
                if (!StringUtils.isNull(aVar.getCurrentPageKey()) && (aVar.getPageStayFilter() == null || aVar.getPageStayFilter().isCurrentPageCanBeAddToSourceTrace())) {
                    if (ListUtils.isEmpty(arrayList)) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar.getCurrentPageKey());
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

    public g getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.loadingView : (g) invokeV.objValue;
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

    @Override // c.a.q0.p0.a
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

    public d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.pageStayDurationItem == null) {
                this.pageStayDurationItem = new d();
            }
            this.pageStayDurationItem.s(getCurrentPageKey());
            this.pageStayDurationItem.x(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.A(getTbPageExtra());
            return this.pageStayDurationItem;
        }
        return (d) invokeV.objValue;
    }

    @Override // c.a.q0.p0.a
    public c.a.q0.p0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (c.a.q0.p0.b) invokeV.objValue;
    }

    public Context getTargetActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? getActivity() : (Context) invokeV.objValue;
    }

    @Override // c.a.q0.n0.a
    public c.a.q0.n0.b getTbFragmentExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new c.a.q0.n0.b(this) : (c.a.q0.n0.b) invokeV.objValue;
    }

    public c.a.q0.n0.c getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            return new c.a.q0.n0.c(getUniqueId(), getCurrentPageKey(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
        }
        return (c.a.q0.n0.c) invokeV.objValue;
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

    @Override // c.a.d.a.i
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mId : (BdUniqueId) invokeV.objValue;
    }

    public void hideLoadingView(View view) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, view) == null) || (gVar = this.loadingView) == null) {
            return;
        }
        gVar.dettachView(view);
    }

    public void hideNetRefreshView(View view) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, view) == null) || (hVar = this.mRefreshView) == null) {
            return;
        }
        hVar.dettachView(view);
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
            g gVar = this.loadingView;
            if (gVar == null) {
                return false;
            }
            return gVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isNetRefreshViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            h hVar = this.mRefreshView;
            return hVar != null && hVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isPrimary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.isPrimary : invokeV.booleanValue;
    }

    @Override // c.a.d.a.i
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
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && getUserVisibleHint() && this.isPrepared && !o.a()) {
            onLoad();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.isPrepared = true;
            registerListener(this.mActivityMissionDataInitCompletedListener);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            g gVar = this.loadingView;
            if (gVar != null) {
                gVar.p(i2);
                this.loadingView.onChangeSkinType();
            }
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            c.a.q0.h0.a aVar = this.mLocationView;
            if (aVar != null) {
                aVar.onChangeSkinType();
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, dialogInterface, i2) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, layoutInflater, viewGroup, bundle)) == null) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            bindFragmentExtraToView(onCreateView);
            return onCreateView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onDestroy();
            c.a.d.f.l.d.h().e(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            MessageManager.getInstance().unRegisterListener(this.mActivityMissionDataInitCompletedListener);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDestroyView();
            g gVar = this.loadingView;
            if (gVar != null) {
                gVar.m();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onDetach();
            unbindFragmentExtraFormView(this.mFragmentRootView);
            MessageManager.getInstance().unRegisterListener(this.mId);
            MessageManager.getInstance().removeMessage(this.mId);
            unRegisterResponsedEventListener();
        }
    }

    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return null;
        }
        return (q) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z) {
                onResume();
            } else {
                onPause();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.isLazyLoaded = true;
        }
    }

    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.customToast.onPause();
            super.onPause();
            if (this.needLogStayDuration && isPrimary() && this.lastResumeTime != 0 && !this.isInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                d pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                e.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                this.lastResumeTime = System.currentTimeMillis();
            }
            c.a.d.f.l.d.h().e(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            pauseBrowseTimeMission();
        }
    }

    @Override // c.a.d.a.i
    public void onPreLoad(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId());
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (this.isPrimary) {
                if (this.isInterceptStimeStat) {
                    setInterceptStimeStat(false);
                } else {
                    this.lastResumeTime = System.currentTimeMillis();
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            } else if (this.needLogStayDuration && this.lastResumeTime != 0 && !this.isInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                d pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                e.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
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
        }
    }

    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
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
            }
        }
    }

    public void onResumeLoadResource() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (getView() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                refreshImage(viewGroup.getChildAt(i2));
            }
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            this.mHandler.postDelayed(this.preLoadRunnable, 100L);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048629, this, absListView, i2, i3, i4) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048630, this, absListView, i2) == null) {
        }
    }

    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, view, bundle) == null) {
            bindFragmentExtraToView(view);
            super.onViewCreated(view, bundle);
        }
    }

    public void publishEvent(c.a.q0.k0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.getTag() == 0) {
            aVar.setTag(getUniqueId());
        }
        c.a.q0.k0.h.i(aVar);
    }

    public void refreshImage(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, view) == null) || view == null) {
            return;
        }
        if (view instanceof c.a.d.g.a.h) {
            ((c.a.d.g.a.h) view).refresh();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                refreshImage(viewGroup.getChildAt(i2));
            }
        }
    }

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void registerResponsedEventListener(Class<? extends c.a.q0.k0.a> cls, c.a.q0.k0.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, cls, iVar) == null) {
            c.a.q0.k0.h.f().m(cls, iVar, getUniqueId());
        }
    }

    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, message) == null) || message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    public void setBaseTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.mTag = str;
        }
    }

    public void setInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.isInterceptStimeStat = z;
        }
    }

    @Override // c.a.d.a.i
    public void setIsScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.mIsScroll = z;
        }
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            setNetRefreshViewEmotionMarginTop(l.f(TbadkCoreApplication.getInst(), R.dimen.ds300));
        }
    }

    public void setNetRefreshViewEmotionMarginTop(int i2) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048650, this, i2) == null) && (hVar = this.mRefreshView) != null && hVar.isViewAttached()) {
            this.mRefreshView.j(i2);
        }
    }

    public void setNetRefreshViewTopMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.j(i2);
        }
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.isPrimary = z;
            if (isResumed()) {
                onPrimary();
            }
            if (TextUtils.equals(getClass().getName(), "com.baidu.tieba.flutter.view.TbFlutterFragment") || this.isPrimary || getCurrentPageKey() == null || TextUtils.equals(TbPageExtraHelper.m(), getCurrentPageKey())) {
                return;
            }
            TbPageExtraHelper.v(getCurrentPageKey());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && isAdded() && !isHidden()) {
            super.setUserVisibleHint(z);
            lazyLoad();
            normalLoad();
        }
    }

    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, view) == null) {
            showLoadingView(view, false);
        }
    }

    public void showLocationView(View view, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048658, this, view, onClickListener) == null) || getPageContext() == null || getPageContext().getContext() == null) {
            return;
        }
        if (this.mLocationView == null) {
            this.mLocationView = new c.a.q0.h0.a(getPageContext().getContext());
        }
        this.mLocationView.attachView(view);
        this.mLocationView.b(onClickListener);
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{view, str, str2, str3, Boolean.valueOf(z), onClickListener}) == null) || getPageContext() == null || getPageContext().getContext() == null) {
            return;
        }
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), onClickListener);
        }
        this.mRefreshView.m(str);
        this.mRefreshView.l(str2);
        this.mRefreshView.g(str3);
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.o();
    }

    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048661, this, view, str, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.l(str);
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(view, z);
            this.mRefreshView.e();
        }
    }

    public void showNetRefreshViewNoClickWithTitle(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048662, this, view, str, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.attachView(view, z);
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.e();
            this.mRefreshView.n(str);
        }
    }

    public void showNoDataNoRefreshView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048663, this, view, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.attachView(view, z);
            this.mRefreshView.e();
            this.mRefreshView.i(R.drawable.new_pic_emotion_05);
            this.mRefreshView.n(getString(R.string.new_text_no_search_result));
        }
    }

    public void showNoDataRefreshView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048664, this, view, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.attachView(view, z);
            this.mRefreshView.o();
            this.mRefreshView.i(R.drawable.new_pic_emotion_03);
            this.mRefreshView.n(getString(R.string.no_data_common_txt));
        }
    }

    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            try {
                showProgressBarWithOffset(0, 0);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void showProgressBarWithOffset(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048668, this, i2, i3) == null) {
            showProgressBar(false, i2, i3);
        }
    }

    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048671, this, str) == null) || getActivity() == null) {
            return;
        }
        String name = getClass().getName();
        String str2 = getActivity().getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") && !name.startsWith(str2)) {
            l.M(getActivity(), str);
        } else {
            this.customToast.showToast(str, 2000);
        }
    }

    public void unRegisterResponsedEventListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            c.a.q0.k0.h.f().n(getUniqueId());
        }
    }

    public void unbindFragmentExtraFormView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048674, this, view) == null) || view == null) {
            return;
        }
        view.setTag(R.id.tag_tb_fragment_extra, null);
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void showLoadingView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048655, this, view, z) == null) {
            showLoadingView(view, z, -1);
        }
    }

    public void showLoadingView(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            showLoadingView(view, z, i2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void showProgressBar(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048666, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            showProgressBar(z, false, i2, i3);
        }
    }

    public void registerListener(int i2, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048637, this, i2, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i2, messageListener);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048645, this, netMessage) == null) || netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void showLoadingView(View view, boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048657, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || isLoadingViewAttached() || getActivity() == null) {
            return;
        }
        if (this.loadingView == null) {
            if (i2 < 0) {
                this.loadingView = new g(getActivity());
            } else {
                g gVar = new g(getActivity(), i2);
                this.loadingView = gVar;
                gVar.h();
            }
            this.loadingView.p(i3);
            this.loadingView.onChangeSkinType();
        }
        this.loadingView.attachView(view, z);
    }

    public void showProgressBar(boolean z, boolean z2, int i2, int i3) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048667, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (this.mProgressBar == null) {
                try {
                    ContinuousAnimationView continuousAnimationView2 = new ContinuousAnimationView(getPageContext().getPageActivity());
                    this.mProgressBar = continuousAnimationView2;
                    continuousAnimationView2.setAnimation(R.raw.lottie_pull_refresh);
                    FrameLayout frameLayout = (FrameLayout) getFragmentActivity().findViewById(16908290);
                    int f2 = l.f(getPageContext().getPageActivity(), z2 ? R.dimen.tbds160 : R.dimen.tbds80);
                    frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(f2, f2, 17));
                } catch (Throwable unused) {
                    return;
                }
            }
            if (z && (continuousAnimationView = this.mProgressBar) != null) {
                continuousAnimationView.bringToFront();
            }
            ContinuousAnimationView continuousAnimationView3 = this.mProgressBar;
            if (continuousAnimationView3 != null) {
                continuousAnimationView3.setPadding(l.d(getPageContext().getPageActivity(), i2), l.d(getPageContext().getPageActivity(), i3), 0, 0);
                this.mProgressBar.setVisibility(0);
                this.mProgressBar.playAnimation();
            }
        }
    }

    public void registerListener(c.a.d.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, aVar) == null) {
            if (aVar != null && aVar.getTag() == null) {
                aVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public void showToast(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048669, this, i2) == null) || getActivity() == null) {
            return;
        }
        String name = getClass().getName();
        String str = getActivity().getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") && !name.startsWith(str)) {
            l.L(getActivity(), i2);
        } else {
            this.customToast.showToast(i2, 2000);
        }
    }

    public void registerListener(int i2, c.a.d.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048635, this, i2, aVar) == null) {
            if (aVar != null && aVar.getTag() == null) {
                aVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i2, aVar);
        }
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048660, this, view, str, z) == null) {
            showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
        }
    }

    public void registerListener(MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, messageListener, bdUniqueId) == null) {
            if (messageListener != null) {
                messageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void registerListener(int i2, MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048638, this, i2, messageListener, bdUniqueId) == null) {
            if (messageListener != null) {
                messageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(i2, messageListener);
        }
    }

    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048672, this, str, z) == null) {
            if (z) {
                this.customToast.showToast(str, 2000);
            } else {
                l.M(TbadkCoreApplication.getInst().getApp(), str);
            }
        }
    }

    public void registerListener(c.a.d.c.g.a aVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, aVar, bdUniqueId) == null) {
            if (aVar != null) {
                aVar.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public void showToast(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048670, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.customToast.showToast(i2, 2000);
            } else {
                l.L(TbadkCoreApplication.getInst().getApp(), i2);
            }
        }
    }

    public void registerListener(int i2, c.a.d.c.g.a aVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048636, this, i2, aVar, bdUniqueId) == null) {
            if (aVar != null) {
                aVar.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(i2, aVar);
        }
    }
}
