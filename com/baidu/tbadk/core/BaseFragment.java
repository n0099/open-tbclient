package com.baidu.tbadk.core;

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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.p;
import com.baidu.megapp.ma.MAFragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseFragment extends MAFragment implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, com.baidu.adp.base.h, com.baidu.tbadk.core.util.e.c, com.baidu.tbadk.o.a {
    private static final int PRELOAD_DELAY = 100;
    private com.baidu.tbadk.core.util.e customToast;
    private boolean isPrimary;
    protected long lastResumeTime;
    private com.baidu.tbadk.m.g loadingView;
    protected com.baidu.tbadk.m.h mRefreshView;
    private String mTag;
    private a netRefreshListener;
    private com.baidu.tbadk.o.d pageStayDurationItem;
    private BdUniqueId mId = null;
    protected int mSkinType = 3;
    protected int mUsedThemeId = 0;
    protected boolean mIsLogin = false;
    public final Handler mHandler = new Handler();
    private boolean mIsScroll = false;
    private boolean isLazyLoaded = false;
    private boolean isPrepared = false;
    private final Runnable preLoadRunnable = new Runnable() { // from class: com.baidu.tbadk.core.BaseFragment.1
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
        this.customToast = com.baidu.tbadk.core.util.e.agU();
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
            String str2 = getActivity().getApplicationContext().getPackageName() + ".chat";
            if (name.startsWith(getActivity().getApplicationContext().getPackageName() + ".im") || name.startsWith(str2)) {
                this.customToast.showToast(str, 2000);
            } else {
                l.showToast(getActivity(), str);
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
                l.showToast(getActivity(), i);
            }
        }
    }

    public void showToast(String str, boolean z) {
        if (z) {
            this.customToast.showToast(str, 2000);
        } else {
            l.showToast(TbadkCoreApplication.getInst().getApp(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            this.customToast.showToast(i, 2000);
        } else {
            l.showToast(TbadkCoreApplication.getInst().getApp(), i);
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
            ay.nT(getClass().getName());
            if (this.isPrimary) {
                onPrimary();
            }
            onResumeLoadResource();
        }
    }

    public void showNetRefreshView(View view, String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        if (getPageContext() != null && getPageContext().getContext() != null) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), onClickListener);
            }
            this.mRefreshView.setTitle(str);
            this.mRefreshView.qw(str2);
            this.mRefreshView.setButtonText(str3);
            this.mRefreshView.attachView(view, z);
            this.mRefreshView.asB();
        }
    }

    public void setNetRefreshViewEmotionDefMarginTop() {
        setNetRefreshViewEmotionMarginTop(l.g(TbadkCoreApplication.getInst(), R.dimen.ds300));
    }

    public void showNetRefreshView(View view, String str, boolean z) {
        showNetRefreshView(view, null, str, null, z, getNetRefreshListener());
    }

    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.qw(str);
        this.mRefreshView.attachView(view, z);
        this.mRefreshView.asH();
    }

    public void setNetRefreshViewTopMargin(int i) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), getNetRefreshListener());
        }
        this.mRefreshView.kE(i);
    }

    public View.OnClickListener getNetRefreshListener() {
        if (this.netRefreshListener == null) {
            this.netRefreshListener = new a();
        }
        return this.netRefreshListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNetRefreshViewEmotionMarginTop(int i) {
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.kE(i);
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

    public p onGetPreLoadListView() {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (isAdded() && !isHidden()) {
            super.setUserVisibleHint(z);
            lazyLoad();
            normalLoad();
        }
    }

    private void lazyLoad() {
        if (getUserVisibleHint() && this.isPrepared && !this.isLazyLoaded) {
            onLazyLoad();
            this.isLazyLoaded = true;
        }
    }

    public void onLazyLoad() {
        this.isLazyLoaded = true;
    }

    public void normalLoad() {
        if (getUserVisibleHint() && this.isPrepared && !com.baidu.tbadk.util.i.isFastDoubleClick()) {
            onLoad();
        }
    }

    public void onLoad() {
    }

    public void changeSkinType(int i) {
        if (i != this.mSkinType || this.mUsedThemeId != TbadkCoreApplication.getInst().getUsedThemeId()) {
            this.mSkinType = i;
            this.mUsedThemeId = TbadkCoreApplication.getInst().getUsedThemeId();
            onChangeSkinType(this.mSkinType);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.customToast.onPause();
        super.onPause();
        if (isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.bh(currentTimeMillis);
            com.baidu.tbadk.o.e.atQ().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            this.lastResumeTime = System.currentTimeMillis();
        }
        com.baidu.adp.lib.f.c.iv().e(this.mId);
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.f.c.iv().e(this.mId);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoadingView(View view) {
        showLoadingView(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoadingView(View view, boolean z) {
        showLoadingView(view, z, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoadingView(View view, boolean z, int i) {
        if (!isLoadingViewAttached() && getActivity() != null) {
            if (this.loadingView == null) {
                if (i < 0) {
                    this.loadingView = new com.baidu.tbadk.m.g(getActivity());
                } else {
                    this.loadingView = new com.baidu.tbadk.m.g(getActivity(), i);
                }
                this.loadingView.onChangeSkinType();
            }
            this.loadingView.attachView(view, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLoadingViewAttached() {
        if (this.loadingView == null) {
            return false;
        }
        return this.loadingView.isViewAttached();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideLoadingView(View view) {
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

    public void registerListener(com.baidu.adp.framework.listener.a aVar, BdUniqueId bdUniqueId) {
        if (aVar != null) {
            aVar.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar, BdUniqueId bdUniqueId) {
        if (aVar != null) {
            aVar.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(i, aVar);
    }

    @Override // com.baidu.adp.base.h
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
            com.baidu.tbadk.o.d pageStayDurationItem = getPageStayDurationItem();
            pageStayDurationItem.bh(currentTimeMillis);
            com.baidu.tbadk.o.e.atQ().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            this.lastResumeTime = System.currentTimeMillis();
        }
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
            if (view instanceof com.baidu.adp.newwidget.ImageView.h) {
                ((com.baidu.adp.newwidget.ImageView.h) view).refresh();
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

    @Override // com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        if (getActivity() instanceof com.baidu.tbadk.o.a) {
            com.baidu.tbadk.o.a aVar = (com.baidu.tbadk.o.a) getActivity();
            ArrayList arrayList = (ArrayList) aVar.getCurrentPageSourceKeyList();
            if (!StringUtils.isNull(aVar.getCurrentPageKey())) {
                if (aVar.getPageStayFilter() == null || aVar.getPageStayFilter().atL()) {
                    if (v.aa(arrayList)) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar.getCurrentPageKey());
                    return arrayList;
                }
                return arrayList;
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.baidu.tbadk.o.a
    public List<String> getNextPageSourceKeyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
        String currentPageKey = getCurrentPageKey();
        if (v.aa(arrayList2)) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            arrayList = arrayList3;
        }
        if ((getPageStayFilter() == null || getPageStayFilter().atL()) && !StringUtils.isNull(currentPageKey)) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(currentPageKey);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return null;
    }

    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        if (this.pageStayDurationItem == null) {
            this.pageStayDurationItem = new com.baidu.tbadk.o.d();
        }
        this.pageStayDurationItem.qC(getCurrentPageKey());
        this.pageStayDurationItem.ao(getCurrentPageSourceKeyList());
        return this.pageStayDurationItem;
    }

    @Override // com.baidu.adp.base.h
    public boolean isScroll() {
        return this.mIsScroll;
    }

    @Override // com.baidu.adp.base.h
    public void setIsScroll(boolean z) {
        this.mIsScroll = z;
    }

    @Override // com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        ad.a(pVar, getUniqueId());
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private a() {
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

    @Override // com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return false;
    }
}
