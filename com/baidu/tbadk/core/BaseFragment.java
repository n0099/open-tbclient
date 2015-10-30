package com.baidu.tbadk.core;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.megapp.ma.MAFragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public abstract class BaseFragment extends MAFragment implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private com.baidu.tbadk.core.util.g customToast;
    private boolean isPrimary;
    private com.baidu.tbadk.e.f loadingView;
    private String mTag;
    private BdUniqueId mId = null;
    protected int mSkinType = 3;
    protected boolean mIsLogin = false;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.mId = BdUniqueId.gen();
        this.customToast = com.baidu.tbadk.core.util.g.tx();
        super.onCreate(bundle);
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
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
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst().getApp(), str);
        }
    }

    public void showToast(int i, boolean z) {
        if (z) {
            this.customToast.showToast(i, 2000);
        } else {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst().getApp(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (this.customToast != null) {
            this.customToast.onResume();
        }
        super.onResume();
        if (isShow()) {
            changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            ax.dp(getClass().getName());
            if (this.isPrimary) {
                onPrimary();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (isAdded() && !isHidden()) {
            super.setUserVisibleHint(z);
        }
    }

    public void changeSkinType(int i) {
        if (i != this.mSkinType || TbadkCoreApplication.m411getInst().isUsedThemeChanged()) {
            this.mSkinType = i;
            onChangeSkinType(this.mSkinType);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.customToast.onPause();
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().removeMessage(this.mId);
    }

    public void onChangeSkinType(int i) {
        if (this.loadingView != null) {
            this.loadingView.sZ();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoadingView(View view, boolean z, int i) {
        if (this.loadingView == null) {
            if (i < 0) {
                this.loadingView = new com.baidu.tbadk.e.f(getActivity());
            } else {
                this.loadingView = new com.baidu.tbadk.e.f(getActivity(), i);
            }
            this.loadingView.sZ();
        }
        this.loadingView.b(view, z);
    }

    protected boolean isLoadingViewAttached() {
        if (this.loadingView == null) {
            return false;
        }
        return this.loadingView.Cn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideLoadingView(View view) {
        if (this.loadingView != null) {
            this.loadingView.u(view);
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
}
