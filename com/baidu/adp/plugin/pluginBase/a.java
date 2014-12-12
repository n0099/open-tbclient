package com.baidu.adp.plugin.pluginBase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class a extends c implements DialogInterface.OnClickListener, Handler.Callback, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, l {
    private final int PRELOAD_DELAY = 100;
    private BdUniqueId mId = null;
    private boolean mIsScroll = false;
    public final Handler mHandler = new Handler(this);
    private final Runnable preLoadRunnable = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mId = BdUniqueId.gen();
        com.baidu.adp.base.a.ah().g(getActivity());
    }

    @Override // com.baidu.adp.plugin.pluginBase.c
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
        com.baidu.adp.lib.util.l.showToast(getApplicationContext(), str);
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

    @Override // com.baidu.adp.base.l
    public BdUniqueId getUniqueId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().removeMessage(this.mId);
        com.baidu.adp.lib.f.d.ee().d(this.mId);
        com.baidu.adp.base.a.ah().h(getActivity());
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onPause() {
        super.onPause();
        com.baidu.adp.lib.f.d.ee().e(this.mId);
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onResume() {
        super.onResume();
        onResumeLoadResource();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.c
    public void onStop() {
        super.onStop();
        BdListView onGetPreLoadListView = onGetPreLoadListView();
        if (onGetPreLoadListView != null) {
            onGetPreLoadListView.jI();
        }
    }

    @Override // com.baidu.adp.base.l
    public boolean isScroll() {
        return this.mIsScroll;
    }

    @Override // com.baidu.adp.base.l
    public void setIsScroll(boolean z) {
        this.mIsScroll = z;
    }

    @Override // com.baidu.adp.base.l
    public void onPreLoad(BdListView bdListView) {
    }

    public BdListView onGetPreLoadListView() {
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
            if (view instanceof com.baidu.adp.newwidget.a.i) {
                ((com.baidu.adp.newwidget.a.i) view).refresh();
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
