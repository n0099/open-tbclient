package com.baidu.tbadk.core;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
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
import com.baidu.tieba.at5;
import com.baidu.tieba.bu4;
import com.baidu.tieba.co;
import com.baidu.tieba.co5;
import com.baidu.tieba.do5;
import com.baidu.tieba.gl;
import com.baidu.tieba.go5;
import com.baidu.tieba.gt5;
import com.baidu.tieba.ht5;
import com.baidu.tieba.jt5;
import com.baidu.tieba.kb;
import com.baidu.tieba.kt5;
import com.baidu.tieba.lu6;
import com.baidu.tieba.pq5;
import com.baidu.tieba.q15;
import com.baidu.tieba.q9;
import com.baidu.tieba.sg;
import com.baidu.tieba.vx5;
import com.baidu.tieba.wq5;
import com.baidu.tieba.xq5;
import com.baidu.tieba.yi;
import com.baidu.tieba.ys5;
import com.baidu.tieba.yv4;
import com.baidu.tieba.zs5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener, AbsListView.OnScrollListener, gt5, q9, IVideoNeedPreload, ys5 {
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
    public co5 loadingView;
    public final CustomMessageListener mActivityMissionDataInitCompletedListener;
    public BuoyComponent mBuoyTaskComponent;
    public View mFragmentRootView;
    public final Handler mHandler;
    public BdUniqueId mId;
    public boolean mIsLogin;
    public boolean mIsScroll;
    public go5 mLocationView;
    public ContinuousAnimationView mProgressBar;
    public do5 mRefreshView;
    public int mSkinType;
    public String mTag;
    public String mTbPageExtraPageTabName;
    public TbPageTag mTbPageTag;
    public int mUsedThemeId;
    public boolean needLogStayDuration;
    public c netRefreshListener;
    public jt5 pageStayDurationItem;
    public final Runnable preLoadRunnable;
    public String tabCode;

    @Override // com.baidu.tieba.gt5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gt5
    public ht5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (ht5) invokeV.objValue;
    }

    public void notifyColourHeaderData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    public void onActivityFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048612, this, dialogInterface, i) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
        }
    }

    public co onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return null;
        }
        return (co) invokeV.objValue;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048623, this, i, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
        }
    }

    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
        }
    }

    public void onResourceRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048635, this, absListView, i, i2, i3) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048636, this, absListView, i) == null) {
        }
    }

    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
        }
    }

    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    @Override // com.baidu.tieba.gt5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getActivity() instanceof gt5) {
                gt5 gt5Var = (gt5) getActivity();
                ArrayList arrayList = (ArrayList) gt5Var.getCurrentPageSourceKeyList();
                if (!StringUtils.isNull(gt5Var.getCurrentPageKey()) && (gt5Var.getPageStayFilter() == null || gt5Var.getPageStayFilter().c())) {
                    if (ListUtils.isEmpty(arrayList)) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(gt5Var.getCurrentPageKey());
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gt5
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            CustomToast customToast = this.customToast;
            if (customToast != null) {
                customToast.onResume();
            }
            super.onResume();
            if (!isShow()) {
                return;
            }
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            TiebaStaticHelper.setCurrentActivity(getClass().getName());
            if (this.isPrimary) {
                onPrimary();
            }
            onResumeLoadResource();
            if (!TextUtils.isEmpty(taskActionId())) {
                taskStart();
            }
        }
    }

    public void bindFragmentExtraToView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            unbindFragmentExtraFormView(this.mFragmentRootView);
            if (view2 != null) {
                this.mFragmentRootView = view2;
                view2.setTag(R.id.tag_tb_fragment_extra, this);
            }
        }
    }

    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i != this.mSkinType || this.mUsedThemeId != TbadkCoreApplication.getInst().getUsedThemeId()) {
                this.mSkinType = i;
                this.mUsedThemeId = TbadkCoreApplication.getInst().getUsedThemeId();
                onChangeSkinType(this.mSkinType);
            }
        }
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, responsedMessage)) == null) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String getStringSafely(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            return TbadkCoreApplication.getInst().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public void hideLoadingView(View view2) {
        co5 co5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, view2) == null) && (co5Var = this.loadingView) != null) {
            co5Var.dettachView(view2);
        }
    }

    public void hideNetRefreshView(View view2) {
        do5 do5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, view2) == null) && (do5Var = this.mRefreshView) != null) {
            do5Var.dettachView(view2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.isPrepared = true;
            registerListener(this.mActivityMissionDataInitCompletedListener);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            co5 co5Var = this.loadingView;
            if (co5Var != null) {
                co5Var.s(i);
                this.loadingView.onChangeSkinType();
            }
            do5 do5Var = this.mRefreshView;
            if (do5Var != null) {
                do5Var.onChangeSkinType();
            }
            go5 go5Var = this.mLocationView;
            if (go5Var != null) {
                go5Var.onChangeSkinType();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z) {
                onResume();
            } else {
                onPause();
            }
        }
    }

    @Override // com.baidu.tieba.q9
    public void onPreLoad(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, coVar) == null) {
            PreLoadImageHelper.load(coVar, getUniqueId());
            PreLoadVideoHelper.load(coVar, getUniqueId(), this);
        }
    }

    public void publishEvent(pq5 pq5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, pq5Var) != null) || pq5Var == null) {
            return;
        }
        if (pq5Var.getTag() == 0) {
            pq5Var.setTag(getUniqueId());
        }
        wq5.i(pq5Var);
    }

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048650, this, message) != null) || message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    public void setBaseTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            this.mTag = str;
        }
    }

    public void setInterceptStimeStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            this.isInterceptStimeStat = z;
        }
    }

    @Override // com.baidu.tieba.q9
    public void setIsScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.mIsScroll = z;
        }
    }

    public void setNetRefreshViewEmotionMarginTop(int i) {
        do5 do5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048656, this, i) == null) && (do5Var = this.mRefreshView) != null && do5Var.isViewAttached()) {
            this.mRefreshView.k(i);
        }
    }

    public void setNetRefreshViewTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new do5(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.k(i);
        }
    }

    public void setTbPageExtraPageTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, str) == null) {
            this.mTbPageExtraPageTabName = str;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048660, this, z) == null) && isAdded() && !isHidden()) {
            super.setUserVisibleHint(z);
            lazyLoad();
            normalLoad();
        }
    }

    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, view2) == null) {
            showLoadingView(view2, false);
        }
    }

    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i) == null) {
            showToastTip(i, false);
        }
    }

    public void unbindFragmentExtraFormView(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048688, this, view2) == null) && view2 != null) {
            view2.setTag(R.id.tag_tb_fragment_extra, null);
        }
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
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !TextUtils.isEmpty(this.tabCode) && bu4.w().y(this.tabCode.hashCode())) {
            bu4.w().E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBrowseTimeMission() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && !TextUtils.isEmpty(this.tabCode)) {
            bu4.w().O(this.tabCode.hashCode());
        }
    }

    public boolean checkUpIsLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ViewHelper.checkUpIsLogin(getFragmentActivity());
        }
        return invokeV.booleanValue;
    }

    public BaseFragmentActivity getBaseFragmentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (BaseFragmentActivity) getTargetActivity();
        }
        return (BaseFragmentActivity) invokeV.objValue;
    }

    public String getBaseTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mTag;
        }
        return (String) invokeV.objValue;
    }

    public FragmentActivity getFragmentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return super.getActivity();
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public co5 getLoadingView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.loadingView;
        }
        return (co5) invokeV.objValue;
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

    public Context getTargetActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return getActivity();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ys5
    public zs5 getTbFragmentExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return new zs5(this);
        }
        return (zs5) invokeV.objValue;
    }

    public at5 getTbPageExtra() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            String currentPageKey = getCurrentPageKey();
            if (baseFragmentActivity == null) {
                intent = null;
            } else {
                intent = baseFragmentActivity.getIntent();
            }
            return new at5(getUniqueId(), currentPageKey, this.mTbPageExtraPageTabName, intent);
        }
        return (at5) invokeV.objValue;
    }

    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.mTbPageTag == null) {
                TbPageTag tbPageTag = new TbPageTag();
                this.mTbPageTag = tbPageTag;
                tbPageTag.locatePage = getCurrentPageKey();
            }
            return this.mTbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q9
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mId;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void hideProgressBar() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (continuousAnimationView = this.mProgressBar) != null) {
            continuousAnimationView.setVisibility(8);
            this.mProgressBar.cancelAnimation();
        }
    }

    public boolean isLoadingViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            co5 co5Var = this.loadingView;
            if (co5Var == null) {
                return false;
            }
            return co5Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public boolean isNetRefreshViewAttached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            do5 do5Var = this.mRefreshView;
            if (do5Var != null && do5Var.isViewAttached()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isPrimary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.isPrimary;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q9
    public boolean isScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mIsScroll;
        }
        return invokeV.booleanValue;
    }

    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (isHidden()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void normalLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && getUserVisibleHint() && this.isPrepared && !vx5.a()) {
            onLoad();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDestroy();
            sg.h().e(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            MessageManager.getInstance().unRegisterListener(this.mActivityMissionDataInitCompletedListener);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onDestroyView();
            co5 co5Var = this.loadingView;
            if (co5Var != null) {
                co5Var.n();
            }
            q15.c().d(getUniqueId());
            BdUniqueId uniqueId = getUniqueId();
            if (uniqueId != null) {
                lu6.a(uniqueId);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onDetach();
            unbindFragmentExtraFormView(this.mFragmentRootView);
            MessageManager.getInstance().unRegisterListener(this.mId);
            MessageManager.getInstance().removeMessage(this.mId);
            unRegisterResponsedEventListener();
        }
    }

    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.isLazyLoaded = true;
        }
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            setNetRefreshViewEmotionMarginTop(yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703b7));
        }
    }

    public void showProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            try {
                showProgressBarWithOffset(0, 0);
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    public void taskPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            yv4.f().h(this.mBuoyTaskComponent);
        }
    }

    public void taskResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            yv4.f().k(this.mBuoyTaskComponent);
        }
    }

    public void taskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            this.mBuoyTaskComponent = yv4.f().m(getActivity(), taskAttachParentView(), taskActionId());
        }
    }

    public void taskStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            yv4.f().n(this.mBuoyTaskComponent);
        }
    }

    public void unRegisterResponsedEventListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            wq5.f().o(getUniqueId());
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

    @NonNull
    public String getStringSafely(@StringRes int i, @Nullable Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, view2, bundle) == null) {
            bindFragmentExtraToView(view2);
            super.onViewCreated(view2, bundle);
        }
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048641, this, i, messageListener) == null) {
            if (messageListener != null && messageListener.getTag() == null) {
                messageListener.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i, messageListener);
        }
    }

    public void registerResponsedEventListener(Class<? extends pq5> cls, xq5 xq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048649, this, cls, xq5Var) == null) {
            wq5.f().m(cls, xq5Var, getUniqueId());
        }
    }

    public void showLoadingView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048662, this, view2, z) == null) {
            showLoadingView(view2, z, -1);
        }
    }

    public void showProgressBarWithOffset(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048675, this, i, i2) == null) {
            showProgressBar(false, i, i2);
        }
    }

    public void showToast(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048679, this, str, z) == null) {
            if (z) {
                this.customToast.showToast(str, 2000);
            } else {
                yi.R(TbadkCoreApplication.getInst().getApp(), str);
            }
        }
    }

    public jt5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.pageStayDurationItem == null) {
                this.pageStayDurationItem = new jt5();
            }
            this.pageStayDurationItem.s(getCurrentPageKey());
            this.pageStayDurationItem.x(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.A(getTbPageExtra());
            return this.pageStayDurationItem;
        }
        return (jt5) invokeV.objValue;
    }

    public void onResumeLoadResource() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048634, this) != null) || !(getView() instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(viewGroup.getChildAt(i));
        }
        this.mHandler.removeCallbacks(this.preLoadRunnable);
        this.mHandler.postDelayed(this.preLoadRunnable, 100L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
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

    public void refreshImage(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048640, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2 instanceof gl) {
            ((gl) view2).refresh();
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                refreshImage(viewGroup.getChildAt(i));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048615, this, layoutInflater, viewGroup, bundle)) == null) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            bindFragmentExtraToView(onCreateView);
            return onCreateView;
        }
        return (View) invokeLLL.objValue;
    }

    public void registerListener(int i, MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048642, this, i, messageListener, bdUniqueId) == null) {
            if (messageListener != null) {
                messageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(i, messageListener);
        }
    }

    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048667, this, view2, str, z) == null) {
            showNetRefreshView(view2, null, str, null, z, getNetRefreshListener());
        }
    }

    public void showProgressBar(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            showProgressBar(z, false, i, i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.customToast.onPause();
            super.onPause();
            if (this.needLogStayDuration && isPrimary() && this.lastResumeTime != 0 && !this.isInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                jt5 pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                kt5.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
                this.lastResumeTime = System.currentTimeMillis();
            }
            sg.h().e(this.mId);
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            pauseBrowseTimeMission();
            taskStop();
        }
    }

    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (this.isPrimary) {
                if (this.isInterceptStimeStat) {
                    setInterceptStimeStat(false);
                } else {
                    this.lastResumeTime = System.currentTimeMillis();
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            } else if (this.needLogStayDuration && this.lastResumeTime != 0 && !this.isInterceptStimeStat) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                jt5 pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.y(currentTimeMillis);
                kt5.b().k(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
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

    public void registerListener(int i, kb kbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i, kbVar) == null) {
            if (kbVar != null && kbVar.getTag() == null) {
                kbVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(i, kbVar);
        }
    }

    public void registerListener(int i, kb kbVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048644, this, i, kbVar, bdUniqueId) == null) {
            if (kbVar != null) {
                kbVar.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(i, kbVar);
        }
    }

    public void registerListener(MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, messageListener, bdUniqueId) == null) {
            if (messageListener != null) {
                messageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(messageListener);
        }
    }

    public void registerListener(kb kbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, kbVar) == null) {
            if (kbVar != null && kbVar.getTag() == null) {
                kbVar.setTag(this.mId);
            }
            MessageManager.getInstance().registerListener(kbVar);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048651, this, netMessage) != null) || netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void registerListener(kb kbVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048648, this, kbVar, bdUniqueId) == null) {
            if (kbVar != null) {
                kbVar.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(kbVar);
        }
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.isPrimary = z;
            if (isResumed()) {
                onPrimary();
            }
            if (!TextUtils.equals(getClass().getName(), TbPageExtraHelper.FLUTTER_FRAGMENT_CLASS_NAME) && !this.isPrimary && getCurrentPageKey() != null && !TextUtils.equals(TbPageExtraHelper.getPrePageKey(), getCurrentPageKey())) {
                TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            }
        }
    }

    public void showLoadingView(View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            showLoadingView(view2, z, i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void showNetRefreshViewNoClick(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048668, this, view2, str, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new do5(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.m(str);
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.e();
        }
    }

    public void showNetRefreshViewNoClickWithTitle(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048669, this, view2, str, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new do5(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.e();
            this.mRefreshView.o(str);
        }
    }

    public void showLoadingView(View view2, boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048664, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) != null) || isLoadingViewAttached() || getActivity() == null) {
            return;
        }
        if (this.loadingView == null) {
            if (i < 0) {
                this.loadingView = new co5(getActivity());
            } else {
                co5 co5Var = new co5(getActivity(), i);
                this.loadingView = co5Var;
                co5Var.i();
            }
            this.loadingView.s(i2);
            this.loadingView.onChangeSkinType();
        }
        this.loadingView.attachView(view2, z);
    }

    public void showLocationView(View view2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048665, this, view2, onClickListener) == null) && getPageContext() != null && getPageContext().getContext() != null) {
            if (this.mLocationView == null) {
                this.mLocationView = new go5(getPageContext().getContext());
            }
            this.mLocationView.attachView(view2);
            this.mLocationView.b(onClickListener);
        }
    }

    public void showNoDataNoRefreshView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048670, this, view2, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new do5(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.e();
            this.mRefreshView.i(R.drawable.new_pic_emotion_10);
            this.mRefreshView.o(getString(R.string.new_text_no_search_result));
        }
    }

    public void showNoDataRefreshView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048671, this, view2, z) == null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new do5(getPageContext().getContext(), getNetRefreshListener());
            }
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.p();
            this.mRefreshView.i(R.drawable.new_pic_emotion_03);
            this.mRefreshView.o(getString(R.string.no_data_common_txt));
        }
    }

    public void showToast(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.customToast.showToast(i, 2000);
            } else {
                yi.Q(TbadkCoreApplication.getInst().getApp(), i);
            }
        }
    }

    public void showNetRefreshView(View view2, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048666, this, new Object[]{view2, str, str2, str3, Boolean.valueOf(z), onClickListener}) == null) && getPageContext() != null && getPageContext().getContext() != null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new do5(getPageContext().getContext(), onClickListener);
            }
            this.mRefreshView.n(str);
            this.mRefreshView.m(str2);
            this.mRefreshView.g(str3);
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(view2, z);
            this.mRefreshView.p();
        }
    }

    public void showProgressBar(boolean z, boolean z2, int i, int i2) {
        int i3;
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048674, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (this.mProgressBar == null) {
                try {
                    ContinuousAnimationView continuousAnimationView2 = new ContinuousAnimationView(getPageContext().getPageActivity());
                    this.mProgressBar = continuousAnimationView2;
                    continuousAnimationView2.setAnimation(R.raw.lottie_pull_refresh);
                    FrameLayout frameLayout = (FrameLayout) getFragmentActivity().findViewById(16908290);
                    Activity pageActivity = getPageContext().getPageActivity();
                    if (z2) {
                        i3 = R.dimen.tbds160;
                    } else {
                        i3 = R.dimen.tbds80;
                    }
                    int g = yi.g(pageActivity, i3);
                    frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(g, g, 17));
                } catch (Throwable unused) {
                    return;
                }
            }
            if (z && (continuousAnimationView = this.mProgressBar) != null) {
                continuousAnimationView.bringToFront();
            }
            ContinuousAnimationView continuousAnimationView3 = this.mProgressBar;
            if (continuousAnimationView3 != null) {
                continuousAnimationView3.setPadding(yi.d(getPageContext().getPageActivity(), i), yi.d(getPageContext().getPageActivity(), i2), 0, 0);
                this.mProgressBar.setVisibility(0);
                this.mProgressBar.playAnimation();
            }
        }
    }

    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048678, this, str) != null) || getActivity() == null) {
            return;
        }
        String name = getClass().getName();
        String str2 = getActivity().getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") && !name.startsWith(str2)) {
            yi.R(getActivity(), str);
        } else {
            this.customToast.showToast(str, 2000);
        }
    }

    public void showToastTip(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048680, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || getActivity() == null) {
            return;
        }
        String name = getClass().getName();
        String str = getActivity().getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") && !name.startsWith(str)) {
            if (z) {
                yi.T(getActivity(), i);
                return;
            } else {
                yi.Q(getActivity(), i);
                return;
            }
        }
        this.customToast.showToast(i, 2000);
    }
}
