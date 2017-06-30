package com.baidu.tbadk.core;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.megapp.ma.MAFragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseFragment extends MAFragment implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, com.baidu.adp.base.j, com.baidu.tbadk.pageStayDuration.a {
    private static final int PRELOAD_DELAY = 100;
    private com.baidu.tbadk.core.util.e customToast;
    private boolean isPrimary;
    private long lastResumeTime;
    private com.baidu.tbadk.i.f loadingView;
    private com.baidu.tbadk.i.h mRefreshView;
    private String mTag;
    private a netRefreshListener;
    private com.baidu.tbadk.pageStayDuration.d pageStayDurationItem;
    private BdUniqueId mId = null;
    protected int mSkinType = 3;
    protected int mUsedThemeId = 0;
    protected boolean mIsLogin = false;
    public final Handler mHandler = new Handler();
    private boolean mIsScroll = false;
    private boolean isLazyLoaded = false;
    private boolean isPrepared = false;
    private final Runnable preLoadRunnable = new d(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.mId = BdUniqueId.gen();
        this.customToast = com.baidu.tbadk.core.util.e.uq();
        super.onCreate(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.isPrepared = true;
    }

    public String getBaseTag() {
        return this.mTag;
    }

    public void setBaseTag(String str) {
        this.mTag = str;
    }

    public FragmentActivity getFragmentActivity() {
        return super.getActivity();
    }

    public BaseFragmentActivity getBaseFragmentActivity() {
        return (BaseFragmentActivity) getTargetActivity();
    }

    public TbPageContext<BaseFragmentActivity> getPageContext() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity == null) {
            return null;
        }
        return baseFragmentActivity.getPageContext();
    }

    public void showToast(String str) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str2 = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str2)) {
                this.customToast.showToast(str, 2000);
            } else {
                com.baidu.adp.lib.util.k.showToast(getActivity(), str);
            }
        }
    }

    public void showToast(int i) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str)) {
                this.customToast.showToast(i, 2000);
            } else {
                com.baidu.adp.lib.util.k.showToast(getActivity(), i);
            }
        }
    }

    public void showToast(String str, boolean z) {
        if (z) {
            this.customToast.showToast(str, 2000);
        } else {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m9getInst().getApp(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            this.customToast.showToast(i, 2000);
        } else {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m9getInst().getApp(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (this.customToast != null) {
            this.customToast.onResume();
        }
        super.onResume();
        if (isShow()) {
            changeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            bc.dT(getClass().getName());
            if (this.isPrimary) {
                onPrimary();
            }
            onResumeLoadResource();
        }
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (getPageContext() != null && getPageContext().getContext() != null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.i.h(getPageContext().getContext(), onClickListener);
            }
            this.mRefreshView.setTitle(str);
            this.mRefreshView.gk(str2);
            this.mRefreshView.gl(str3);
            this.mRefreshView.c(view, z);
            this.mRefreshView.Ev();
        }
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds300));
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
    }

    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.i.h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.gk(str);
        this.mRefreshView.c(view, z);
        this.mRefreshView.Ew();
    }

    public void setNetRefreshViewTopMargin(int i) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.i.h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.eU(i);
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new a(this, null);
        }
        return this.netRefreshListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNetRefreshViewEmotionMarginTop(int i) {
        if (this.mRefreshView != null && this.mRefreshView.Eo()) {
            this.mRefreshView.eU(i);
        }
    }

    public void hideNetRefreshView(View view) {
        if (this.mRefreshView != null) {
            this.mRefreshView.I(view);
        }
    }

    public void onResumeLoadResource() {
        if (getView() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                refreshImage(viewGroup.getChildAt(i));
            }
            this.mHandler.removeCallbacks(this.preLoadRunnable);
            this.mHandler.postDelayed(this.preLoadRunnable, 100L);
        }
    }

    public com.baidu.adp.widget.ListView.w onGetPreLoadListView() {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (isAdded() && !isHidden()) {
            super.setUserVisibleHint(z);
            lazyLoad();
        }
    }

    private void lazyLoad() {
        if (getUserVisibleHint() && this.isPrepared && !this.isLazyLoaded) {
            onLazyLoad();
            this.isLazyLoaded = true;
        }
    }

    public void onLazyLoad() {
    }

    public void changeSkinType(int i) {
        if (i != this.mSkinType || this.mUsedThemeId != TbadkCoreApplication.m9getInst().getUsedThemeId()) {
            this.mSkinType = i;
            this.mUsedThemeId = TbadkCoreApplication.m9getInst().getUsedThemeId();
            onChangeSkinType(this.mSkinType);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.customToast.onPause();
        super.onPause();
        if (isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.Q(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Fw().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            this.lastResumeTime = System.currentTimeMillis();
        }
        com.baidu.adp.lib.f.c.fL().e(this.mId);
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.f.c.fL().e(this.mId);
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.loadingView != null) {
            this.loadingView.release();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().removeMessage(this.mId);
    }

    public void onChangeSkinType(int i) {
        if (this.loadingView != null) {
            this.loadingView.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void onResourceRecycle() {
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            onResume();
        } else {
            onPause();
        }
    }

    protected void showLoadingView(View view) {
        showLoadingView(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    protected void showLoadingView(View view, boolean z, int i) {
        if (!isLoadingViewAttached()) {
            if (this.loadingView == null) {
                if (i < 0) {
                    this.loadingView = new com.baidu.tbadk.i.f(getActivity());
                } else {
                    this.loadingView = new com.baidu.tbadk.i.f(getActivity(), i);
                }
                this.loadingView.onChangeSkinType();
            }
            this.loadingView.c(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLoadingViewAttached() {
        if (this.loadingView == null) {
            return false;
        }
        return this.loadingView.Eo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideLoadingView(View view) {
        if (this.loadingView != null) {
            this.loadingView.I(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isShow() {
        return !isHidden();
    }

    public void sendMessage(Message<?> message) {
        if (message != null) {
            if (message.getTag() == null) {
                message.setTag(this.mId);
            }
            MessageManager.getInstance().sendMessage(message);
        }
    }

    public void sendMessage(NetMessage netMessage) {
        if (netMessage != null) {
            if (netMessage.getTag() == null) {
                netMessage.setTag(this.mId);
            }
            MessageManager.getInstance().sendMessage(netMessage);
        }
    }

    public void registerListener(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    public void registerListener(com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i, aVar);
    }

    @Override // com.baidu.adp.base.j
    public BdUniqueId getUniqueId() {
        return this.mId;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (isResumed()) {
            onPrimary();
        }
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    public void onPrimary() {
        if (this.isPrimary) {
            this.lastResumeTime = System.currentTimeMillis();
        } else if (this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.Q(currentTimeMillis);
            com.baidu.tbadk.pageStayDuration.e.Fw().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            this.lastResumeTime = System.currentTimeMillis();
        }
        refreshImage(getView());
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsLogin != isLogin) {
            this.mIsLogin = isLogin;
            onUserChanged(this.mIsLogin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUserChanged(boolean z) {
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public void refreshImage(View view) {
        if (view != null) {
            if (view instanceof com.baidu.adp.b.a.i) {
                ((com.baidu.adp.b.a.i) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(viewGroup.getChildAt(i));
                }
            }
        }
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        if (getActivity() instanceof com.baidu.tbadk.pageStayDuration.a) {
            com.baidu.tbadk.pageStayDuration.a aVar = (com.baidu.tbadk.pageStayDuration.a) getActivity();
            ArrayList arrayList = (ArrayList) aVar.getCurrentPageSourceKeyList();
            if (!StringUtils.isNull(aVar.getCurrentPageKey())) {
                if (com.baidu.tbadk.core.util.z.t(arrayList)) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar.getCurrentPageKey());
                return arrayList;
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (com.baidu.tbadk.core.util.z.t(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().Fq()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return null;
    }

    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.pageStayDuration.d();
        }
        this.pageStayDurationItem.go(getCurrentPageKey());
        this.pageStayDurationItem.C(getCurrentPageSourceKeyList());
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.adp.base.j
    public boolean isScroll() {
        return this.mIsScroll;
    }

    @Override // com.baidu.adp.base.j
    public void setIsScroll(boolean z) {
        this.mIsScroll = z;
    }

    @Override // com.baidu.adp.base.j
    public void onPreLoad(com.baidu.adp.widget.ListView.w wVar) {
        com.baidu.tbadk.core.util.ai.a(wVar, getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(BaseFragment baseFragment, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseFragment.this.onNetRefreshButtonClicked();
        }
    }

    protected void onNetRefreshButtonClicked() {
    }

    public void HidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
