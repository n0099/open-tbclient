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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.c.a.i;
import d.a.c.j.e.q;
import d.a.m0.d0.g;
import d.a.m0.d0.h;
import d.a.m0.i0.c;
import d.a.m0.k0.d;
import d.a.m0.k0.e;
import d.a.m0.z0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class BaseFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener, AbsListView.OnScrollListener, d.a.m0.k0.a, i, IVideoNeedPreload, d.a.m0.i0.a {
    public static final int PRELOAD_DELAY = 100;
    public CustomToast customToast;
    public boolean isPrimary;
    public long lastResumeTime;
    public g loadingView;
    public View mFragmentRootView;
    public ContinuousAnimationView mProgressBar;
    public h mRefreshView;
    public String mTag;
    public TbPageTag mTbPageTag;
    public b netRefreshListener;
    public d pageStayDurationItem;
    public BdUniqueId mId = null;
    public int mSkinType = 3;
    public int mUsedThemeId = 0;
    public boolean mIsLogin = false;
    public boolean needLogStayDuration = true;
    public final Handler mHandler = new Handler();
    public boolean mIsScroll = false;
    public boolean isLazyLoaded = false;
    public boolean isPrepared = false;
    public final Runnable preLoadRunnable = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseFragment baseFragment = BaseFragment.this;
            baseFragment.onPreLoad(baseFragment.onGetPreLoadListView());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseFragment.this.onNetRefreshButtonClicked();
        }

        public /* synthetic */ b(BaseFragment baseFragment, a aVar) {
            this();
        }
    }

    private void lazyLoad() {
        if (getUserVisibleHint() && this.isPrepared && !this.isLazyLoaded) {
            onLazyLoad();
            this.isLazyLoaded = true;
        }
    }

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void bindFragmentExtraToView(View view) {
        unbindFragmentExtraFormView(this.mFragmentRootView);
        if (view != null) {
            this.mFragmentRootView = view;
            view.setTag(R.id.tag_tb_fragment_extra, this);
        }
    }

    public void changeSkinType(int i2) {
        if (i2 == this.mSkinType && this.mUsedThemeId == TbadkCoreApplication.getInst().getUsedThemeId()) {
            return;
        }
        this.mSkinType = i2;
        this.mUsedThemeId = TbadkCoreApplication.getInst().getUsedThemeId();
        onChangeSkinType(this.mSkinType);
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public boolean checkUpIsLogin() {
        return ViewHelper.checkUpIsLogin(getFragmentActivity());
    }

    public BaseFragmentActivity getBaseFragmentActivity() {
        return (BaseFragmentActivity) getTargetActivity();
    }

    public String getBaseTag() {
        return this.mTag;
    }

    @Override // d.a.m0.k0.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // d.a.m0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        if (getActivity() instanceof d.a.m0.k0.a) {
            d.a.m0.k0.a aVar = (d.a.m0.k0.a) getActivity();
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

    public FragmentActivity getFragmentActivity() {
        return super.getActivity();
    }

    public g getLoadingView() {
        return this.loadingView;
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new b(this, null);
        }
        return this.netRefreshListener;
    }

    @Override // d.a.m0.k0.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
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

    public TbPageContext<BaseFragmentActivity> getPageContext() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity == null) {
            return null;
        }
        return baseFragmentActivity.getPageContext();
    }

    public d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new d();
        }
        this.pageStayDurationItem.p(getCurrentPageKey());
        this.pageStayDurationItem.u(getCurrentPageSourceKeyList());
        this.pageStayDurationItem.x(getTbPageExtra());
        return this.pageStayDurationItem;
    }

    @Override // d.a.m0.k0.a
    public d.a.m0.k0.b getPageStayFilter() {
        return null;
    }

    public Context getTargetActivity() {
        return getActivity();
    }

    @Override // d.a.m0.i0.a
    public d.a.m0.i0.b getTbFragmentExtra() {
        return new d.a.m0.i0.b(this);
    }

    public c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new c(getUniqueId(), getCurrentPageKey(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public TbPageTag getTbPageTag() {
        if (this.mTbPageTag == null) {
            TbPageTag tbPageTag = new TbPageTag();
            this.mTbPageTag = tbPageTag;
            tbPageTag.locatePage = getCurrentPageKey();
        }
        return this.mTbPageTag;
    }

    @Override // d.a.c.a.i
    public BdUniqueId getUniqueId() {
        return this.mId;
    }

    public void hideLoadingView(View view) {
        g gVar = this.loadingView;
        if (gVar != null) {
            gVar.dettachView(view);
        }
    }

    public void hideNetRefreshView(View view) {
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(view);
        }
    }

    public void hideProgressBar() {
        ContinuousAnimationView continuousAnimationView = this.mProgressBar;
        if (continuousAnimationView != null) {
            continuousAnimationView.setVisibility(8);
            this.mProgressBar.cancelAnimation();
        }
    }

    public boolean isLoadingViewAttached() {
        g gVar = this.loadingView;
        if (gVar == null) {
            return false;
        }
        return gVar.isViewAttached();
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    @Override // d.a.c.a.i
    public boolean isScroll() {
        return this.mIsScroll;
    }

    public boolean isShow() {
        return !isHidden();
    }

    public void normalLoad() {
        if (getUserVisibleHint() && this.isPrepared && !l.a()) {
            onLoad();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.isPrepared = true;
    }

    public void onChangeSkinType(int i2) {
        g gVar = this.loadingView;
        if (gVar != null) {
            gVar.p(i2);
            this.loadingView.onChangeSkinType();
        }
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        if (this.mId == null) {
            this.mId = BdUniqueId.gen();
        }
        this.customToast = CustomToast.newInstance();
        super.onCreate(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        bindFragmentExtraToView(onCreateView);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.c.e.l.d.h().e(this.mId);
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        g gVar = this.loadingView;
        if (gVar != null) {
            gVar.m();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        unbindFragmentExtraFormView(this.mFragmentRootView);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().removeMessage(this.mId);
        unRegisterResponsedEventListener();
    }

    public q onGetPreLoadListView() {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            onResume();
        } else {
            onPause();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
        return false;
    }

    public void onLazyLoad() {
        this.isLazyLoaded = true;
    }

    public void onLoad() {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    public void onNetRefreshButtonClicked() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.customToast.onPause();
        super.onPause();
        if (this.needLogStayDuration && isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.v(currentTimeMillis);
            e.b().i(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            this.lastResumeTime = System.currentTimeMillis();
        }
        d.a.c.e.l.d.h().e(this.mId);
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    @Override // d.a.c.a.i
    public void onPreLoad(q qVar) {
        PreLoadImageHelper.load(qVar, getUniqueId());
        PreLoadVideoHelper.load(qVar, getUniqueId(), this);
    }

    public void onPrimary() {
        if (this.isPrimary) {
            this.lastResumeTime = System.currentTimeMillis();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        } else if (this.needLogStayDuration && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.v(currentTimeMillis);
            e.b().i(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            this.lastResumeTime = System.currentTimeMillis();
        }
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsLogin != isLogin) {
            this.mIsLogin = isLogin;
            onUserChanged(isLogin);
        }
    }

    public void onResourceRecycle() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
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

    public void onResumeLoadResource() {
        if (getView() instanceof ViewGroup) {
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
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    public void onUserChanged(boolean z) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        bindFragmentExtraToView(view);
        super.onViewCreated(view, bundle);
    }

    public void publishEvent(d.a.m0.f0.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.getTag() == 0) {
            aVar.setTag(getUniqueId());
        }
        d.a.m0.f0.h.i(aVar);
    }

    public void refreshImage(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof d.a.c.f.a.i) {
            ((d.a.c.f.a.i) view).refresh();
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
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void registerResponsedEventListener(Class<? extends d.a.m0.f0.a> cls, d.a.m0.f0.i iVar) {
        d.a.m0.f0.h.f().m(cls, iVar, getUniqueId());
    }

    public void sendMessage(Message<?> message) {
        if (message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    public void setBaseTag(String str) {
        this.mTag = str;
    }

    @Override // d.a.c.a.i
    public void setIsScroll(boolean z) {
        this.mIsScroll = z;
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds300));
    }

    public void setNetRefreshViewEmotionMarginTop(int i2) {
        h hVar = this.mRefreshView;
        if (hVar == null || !hVar.isViewAttached()) {
            return;
        }
        this.mRefreshView.j(i2);
    }

    public void setNetRefreshViewTopMargin(int i2) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.j(i2);
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (isResumed()) {
            onPrimary();
        }
        if (TextUtils.equals(getClass().getName(), "com.baidu.tieba.flutter.view.TbFlutterFragment") || this.isPrimary || getCurrentPageKey() == null || TextUtils.equals(TbPageExtraHelper.m(), getCurrentPageKey())) {
            return;
        }
        TbPageExtraHelper.u(getCurrentPageKey());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (!isAdded() || isHidden()) {
            return;
        }
        super.setUserVisibleHint(z);
        lazyLoad();
        normalLoad();
    }

    public void showLoadingView(View view) {
        showLoadingView(view, false);
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (getPageContext() == null || getPageContext().getContext() == null) {
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
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.l(str);
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.e();
    }

    public void showNetRefreshViewNoClickWithTitle(View view, String str, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.mRefreshView.e();
        this.mRefreshView.n(str);
    }

    public void showNoDataNoRefreshView(View view, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.e();
        this.mRefreshView.i(R.drawable.new_pic_emotion_05);
        this.mRefreshView.n(getString(R.string.new_text_no_search_result));
    }

    public void showNoDataRefreshView(View view, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.o();
        this.mRefreshView.i(R.drawable.new_pic_emotion_03);
        this.mRefreshView.n(getString(R.string.no_data_common_txt));
    }

    public void showProgressBar() {
        try {
            showProgressBarWithOffset(0, 0);
        } catch (OutOfMemoryError unused) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void showProgressBarWithOffset(int i2, int i3) {
        showProgressBar(false, i2, i3);
    }

    public void showToast(String str) {
        if (getActivity() == null) {
            return;
        }
        String name = getClass().getName();
        String str2 = getActivity().getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") && !name.startsWith(str2)) {
            d.a.c.e.p.l.M(getActivity(), str);
        } else {
            this.customToast.showToast(str, 2000);
        }
    }

    public void unRegisterResponsedEventListener() {
        d.a.m0.f0.h.f().n(getUniqueId());
    }

    public void unbindFragmentExtraFormView(View view) {
        if (view != null) {
            view.setTag(R.id.tag_tb_fragment_extra, null);
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        return false;
    }

    public void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    public void showLoadingView(View view, boolean z, int i2) {
        showLoadingView(view, z, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public void showProgressBar(boolean z, int i2, int i3) {
        showProgressBar(z, false, i2, i3);
    }

    public void registerListener(int i2, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i2, messageListener);
    }

    public void sendMessage(NetMessage netMessage) {
        if (netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void showLoadingView(View view, boolean z, int i2, int i3) {
        if (isLoadingViewAttached() || getActivity() == null) {
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
        if (this.mProgressBar == null) {
            try {
                ContinuousAnimationView continuousAnimationView2 = new ContinuousAnimationView(getPageContext().getPageActivity());
                this.mProgressBar = continuousAnimationView2;
                continuousAnimationView2.setAnimation(R.raw.lottie_pull_refresh);
                FrameLayout frameLayout = (FrameLayout) getFragmentActivity().findViewById(16908290);
                int g2 = d.a.c.e.p.l.g(getPageContext().getPageActivity(), z2 ? R.dimen.tbds160 : R.dimen.tbds80);
                frameLayout.addView(this.mProgressBar, frameLayout.getChildCount(), new FrameLayout.LayoutParams(g2, g2, 17));
            } catch (Throwable unused) {
                return;
            }
        }
        if (z && (continuousAnimationView = this.mProgressBar) != null) {
            continuousAnimationView.bringToFront();
        }
        ContinuousAnimationView continuousAnimationView3 = this.mProgressBar;
        if (continuousAnimationView3 != null) {
            continuousAnimationView3.setPadding(d.a.c.e.p.l.e(getPageContext().getPageActivity(), i2), d.a.c.e.p.l.e(getPageContext().getPageActivity(), i3), 0, 0);
            this.mProgressBar.setVisibility(0);
            this.mProgressBar.playAnimation();
        }
    }

    public void registerListener(d.a.c.c.g.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void showToast(int i2) {
        if (getActivity() == null) {
            return;
        }
        String name = getClass().getName();
        String str = getActivity().getApplicationContext().getPackageName() + ".chat";
        if (!name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") && !name.startsWith(str)) {
            d.a.c.e.p.l.L(getActivity(), i2);
        } else {
            this.customToast.showToast(i2, 2000);
        }
    }

    public void registerListener(int i2, d.a.c.c.g.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i2, aVar);
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
    }

    public void registerListener(MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        if (messageListener != null) {
            messageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void registerListener(int i2, MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        if (messageListener != null) {
            messageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(i2, messageListener);
    }

    public void showToast(String str, boolean z) {
        if (z) {
            this.customToast.showToast(str, 2000);
        } else {
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst().getApp(), str);
        }
    }

    public void registerListener(d.a.c.c.g.a aVar, BdUniqueId bdUniqueId) {
        if (aVar != null) {
            aVar.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void showToast(int i2, boolean z) {
        if (z) {
            this.customToast.showToast(i2, 2000);
        } else {
            d.a.c.e.p.l.L(TbadkCoreApplication.getInst().getApp(), i2);
        }
    }

    public void registerListener(int i2, d.a.c.c.g.a aVar, BdUniqueId bdUniqueId) {
        if (aVar != null) {
            aVar.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(i2, aVar);
    }
}
