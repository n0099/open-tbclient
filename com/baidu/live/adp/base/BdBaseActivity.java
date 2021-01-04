package com.baidu.live.adp.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.NetMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.newwidget.imageview.IRefresh;
import com.baidu.live.adp.widget.listview.IPreLoadListView;
import com.baidu.searchbox.live.base.LiveBaseActivity;
/* loaded from: classes11.dex */
public abstract class BdBaseActivity<T> extends LiveBaseActivity implements DialogInterface.OnClickListener, Handler.Callback, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, BdPageContextSupport<T>, IScrollable {
    private static final int PRELOAD_DELAY = 100;
    private BdUniqueId mId = null;
    private boolean mIsScroll = false;
    public final Handler mHandler = new Handler(this);
    private final Runnable preLoadRunnable = new Runnable() { // from class: com.baidu.live.adp.base.BdBaseActivity.1
        @Override // java.lang.Runnable
        public void run() {
            BdBaseActivity.this.onPreLoad(BdBaseActivity.this.onGetPreLoadListView());
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mId = BdUniqueId.gen();
        BdActivityStack.getInst().pushActivity(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                super.setContentView(i);
                return;
            } catch (OutOfMemoryError e) {
                if (i2 == 2) {
                    throw e;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            } catch (RuntimeException e2) {
                if (i2 == 2) {
                    throw e2;
                }
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return true;
    }

    public void showToast(String str) {
        BdUtilHelper.showToast(getActivity(), str);
    }

    public void releaseResouce() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
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

    @Override // com.baidu.live.adp.base.IScrollable
    public BdUniqueId getUniqueId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().removeMessage(this.mId);
        BdActivityStack.getInst().popActivity(getPageContext().getPageActivity());
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onResumeLoadResource();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        IPreLoadListView onGetPreLoadListView = onGetPreLoadListView();
        if (onGetPreLoadListView != null) {
            onGetPreLoadListView.cancelRefresh();
        }
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

    public IPreLoadListView onGetPreLoadListView() {
        return null;
    }

    public void onResumeLoadResource() {
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        int childCount = frameLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(frameLayout.getChildAt(i));
        }
        this.mHandler.removeCallbacks(this.preLoadRunnable);
        this.mHandler.postDelayed(this.preLoadRunnable, 100L);
    }

    private void refreshImage(View view) {
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

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        return false;
    }
}
