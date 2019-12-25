package com.baidu.live.tbadk.core;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.IScrollable;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.NetMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.newwidget.imageview.IRefresh;
import com.baidu.live.adp.widget.listview.IPreLoadListView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaStaticHelper;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.tbadk.loading.NetRefreshView;
import com.baidu.live.tbadk.pagestayduration.IPageStayDuration;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationFilter;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationItem;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationStat;
import com.baidu.megapp.ma.MAFragment;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BaseFragment extends MAFragment implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, IScrollable, IPageStayDuration {
    private static final int PRELOAD_DELAY = 100;
    private CustomToast customToast;
    private boolean isPrimary;
    private long lastResumeTime;
    private LoadingView loadingView;
    protected NetRefreshView mRefreshView;
    private String mTag;
    private NetRefreshListener netRefreshListener;
    private PageStayDurationItem pageStayDurationItem;
    private BdUniqueId mId = null;
    protected int mSkinType = 3;
    protected boolean mIsLogin = false;
    public final Handler mHandler = new Handler();
    private boolean mIsScroll = false;
    private boolean isLazyLoaded = false;
    private boolean isPrepared = false;
    private final Runnable preLoadRunnable = new Runnable() { // from class: com.baidu.live.tbadk.core.BaseFragment.1
        @Override // java.lang.Runnable
        public void run() {
            BaseFragment.this.onPreLoad(BaseFragment.this.onGetPreLoadListView());
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        if (this.mId == null) {
            this.mId = BdUniqueId.gen();
        }
        this.customToast = CustomToast.newInstance();
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

    public Context getBaseFragmentActivity() {
        return getTargetActivity();
    }

    public TbPageContext<BaseFragmentActivity> getPageContext() {
        Context targetActivity = getTargetActivity();
        if (targetActivity == null) {
            return null;
        }
        return (TbPageContext) IScrollableHelper.getBbPageContext(targetActivity);
    }

    public void showToast(String str) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str2 = getActivity().getApplicationContext().getPackageName() + ".chat";
            if (name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") || name.startsWith(str2)) {
                this.customToast.showToast(str, 2000);
            } else {
                BdUtilHelper.showToast(getActivity(), str);
            }
        }
    }

    public void showToast(int i) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str = getActivity().getApplicationContext().getPackageName() + ".chat";
            if (name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") || name.startsWith(str)) {
                this.customToast.showToast(i, 2000);
            } else {
                BdUtilHelper.showToast(getActivity(), i);
            }
        }
    }

    public void showToast(String str, boolean z) {
        if (z) {
            this.customToast.showToast(str, 2000);
        } else {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getApp(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            this.customToast.showToast(i, 2000);
        } else {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getApp(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (this.customToast != null) {
            this.customToast.onResume();
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

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (getPageContext() != null && getPageContext().getContext() != null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new NetRefreshView(getPageContext().getContext(), onClickListener);
            }
            this.mRefreshView.setTitle(str);
            this.mRefreshView.setSubText(str2);
            this.mRefreshView.setButtonText(str3);
            this.mRefreshView.attachView(view, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds300));
    }

    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new NetRefreshView(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.setSubText(str);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.hideRefreshButton();
    }

    public void setNetRefreshViewTopMargin(int i) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new NetRefreshView(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.setLayoutMargin(i);
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new NetRefreshListener();
        }
        return this.netRefreshListener;
    }

    protected void setNetRefreshViewEmotionMarginTop(int i) {
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.setLayoutMargin(i);
        }
    }

    public void hideNetRefreshView(View view) {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(view);
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

    public IPreLoadListView onGetPreLoadListView() {
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
        if (i != this.mSkinType) {
            this.mSkinType = i;
            onChangeSkinType(this.mSkinType);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.customToast.onPause();
        super.onPause();
        if (isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            PageStayDurationItem pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            PageStayDurationStat.getInstance().stat(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            this.lastResumeTime = System.currentTimeMillis();
        }
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
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
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.loadingView != null) {
            this.loadingView.setSkinType(i);
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

    protected void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    protected void showLoadingView(View view, boolean z, int i) {
        if (!isLoadingViewAttached() && getActivity() != null) {
            if (this.loadingView == null) {
                if (i < 0) {
                    this.loadingView = new LoadingView(getActivity());
                } else {
                    this.loadingView = new LoadingView(getActivity(), i);
                }
                this.loadingView.onChangeSkinType();
            }
            this.loadingView.attachView(view, z);
        }
    }

    protected boolean isLoadingViewAttached() {
        if (this.loadingView == null) {
            return false;
        }
        return this.loadingView.isViewAttached();
    }

    protected void hideLoadingView(View view) {
        if (this.loadingView != null) {
            this.loadingView.dettachView(view);
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

    public void registerListener(NetMessageListener netMessageListener) {
        if (netMessageListener != null && netMessageListener.getTag() == null) {
            netMessageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(netMessageListener);
    }

    public void registerListener(int i, NetMessageListener netMessageListener) {
        if (netMessageListener != null && netMessageListener.getTag() == null) {
            netMessageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i, netMessageListener);
    }

    public void registerListener(MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        if (messageListener != null) {
            messageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void registerListener(int i, MessageListener<?> messageListener, BdUniqueId bdUniqueId) {
        if (messageListener != null) {
            messageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    public void registerListener(NetMessageListener netMessageListener, BdUniqueId bdUniqueId) {
        if (netMessageListener != null) {
            netMessageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(netMessageListener);
    }

    public void registerListener(int i, NetMessageListener netMessageListener, BdUniqueId bdUniqueId) {
        if (netMessageListener != null) {
            netMessageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(i, netMessageListener);
    }

    @Override // com.baidu.live.adp.base.IScrollable
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
            PageStayDurationItem pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.setStayDurationTime(currentTimeMillis);
            PageStayDurationStat.getInstance().stat(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            this.lastResumeTime = System.currentTimeMillis();
        }
        refreshImage(getView());
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsLogin != isLogin) {
            this.mIsLogin = isLogin;
            onUserChanged(this.mIsLogin);
        }
    }

    protected void onUserChanged(boolean z) {
    }

    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public void refreshImage(View view) {
        if (view != null) {
            if (view instanceof IRefresh) {
                ((IRefresh) view).refresh();
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

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        return null;
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        if (getActivity() instanceof IPageStayDuration) {
            IPageStayDuration iPageStayDuration = (IPageStayDuration) getActivity();
            ArrayList arrayList = (ArrayList) iPageStayDuration.getCurrentPageSourceKeyList();
            if (!StringUtils.isNull(iPageStayDuration.getCurrentPageKey())) {
                if (ListUtils.isEmpty(arrayList)) {
                    arrayList = new ArrayList();
                }
                arrayList.add(iPageStayDuration.getCurrentPageKey());
                return arrayList;
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (ListUtils.isEmpty(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.live.tbadk.pagestayduration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new PageStayDurationItem();
        }
        this.pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
        this.pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.live.adp.base.IScrollable
    public boolean isScroll() {
        return this.mIsScroll;
    }

    @Override // com.baidu.live.adp.base.IScrollable
    public void setIsScroll(boolean z) {
        this.mIsScroll = z;
    }

    @Override // com.baidu.live.adp.base.IScrollable
    public void onPreLoad(IPreLoadListView iPreLoadListView) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class NetRefreshListener implements View.OnClickListener {
        private NetRefreshListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseFragment.this.onNetRefreshButtonClicked();
        }
    }

    protected void onNetRefreshButtonClicked() {
    }

    public void hidenSoftKeyPad(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
