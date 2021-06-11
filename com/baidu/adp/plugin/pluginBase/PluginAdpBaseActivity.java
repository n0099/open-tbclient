package com.baidu.adp.plugin.pluginBase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.NetMessage;
import d.a.c.a.b;
import d.a.c.a.g;
import d.a.c.a.i;
import d.a.c.e.l.d;
import d.a.c.e.p.l;
import d.a.c.k.e.q;
/* loaded from: classes.dex */
public abstract class PluginAdpBaseActivity extends PluginBaseActivity implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener, i, Handler.Callback, g {
    public static final int PRELOAD_DELAY = 100;
    public BdUniqueId mId = null;
    public boolean mIsScroll = false;
    public final Handler mHandler = new Handler(this);
    public final Runnable preLoadRunnable = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PluginAdpBaseActivity pluginAdpBaseActivity = PluginAdpBaseActivity.this;
            pluginAdpBaseActivity.onPreLoad(pluginAdpBaseActivity.onGetPreLoadListView());
        }
    }

    private void refreshImage(View view) {
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

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.a.c.a.i
    public BdUniqueId getUniqueId() {
        return this.mId;
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.a.c.a.i
    public boolean isScroll() {
        return this.mIsScroll;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mId = BdUniqueId.gen();
        b.f().n(getActivity());
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().removeMessage(this.mId);
        d.h().b(this.mId);
        b.f().l(getActivity());
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    public q onGetPreLoadListView() {
        return null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
        return true;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onPause() {
        super.onPause();
        d.h().e(this.mId);
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.a.c.a.i
    public void onPreLoad(q qVar) {
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        onResumeLoadResource();
    }

    public void onResumeLoadResource() {
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        int childCount = frameLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            refreshImage(frameLayout.getChildAt(i2));
        }
        this.mHandler.removeCallbacks(this.preLoadRunnable);
        this.mHandler.postDelayed(this.preLoadRunnable, 100L);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onStop() {
        super.onStop();
        q onGetPreLoadListView = onGetPreLoadListView();
        if (onGetPreLoadListView != null) {
            onGetPreLoadListView.cancelRefresh();
        }
    }

    public void registerListener(d.a.c.c.g.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void releaseResouce() {
    }

    public void sendMessage(com.baidu.adp.framework.message.Message<?> message) {
        if (message == null) {
            return;
        }
        if (message.getTag() == null) {
            message.setTag(this.mId);
        }
        MessageManager.getInstance().sendMessage(message);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void setContentView(int i2) {
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                super.setContentView(i2);
                return;
            } catch (OutOfMemoryError e2) {
                if (i3 != 2) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                } else {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                if (i3 != 2) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                } else {
                    throw e3;
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity, d.a.c.a.i
    public void setIsScroll(boolean z) {
        this.mIsScroll = z;
    }

    public void showToast(String str) {
        l.M(getApplicationContext(), str);
    }

    public void registerListener(int i2, d.a.c.c.g.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i2, aVar);
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

    public void registerListener(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void registerListener(int i2, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i2, messageListener);
    }
}
