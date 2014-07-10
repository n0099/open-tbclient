package com.baidu.adp.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class BdBaseFragmentActivity extends FragmentActivity implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, j {
    private final int a = 100;
    private int b = 0;
    private boolean c = false;
    private Handler d = new Handler();
    private Runnable e = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = com.baidu.adp.framework.d.a().b();
        a.a().a(this);
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

    public void a(String str) {
        com.baidu.adp.lib.util.j.a(getApplicationContext(), str);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    public void a(Message<?> message) {
        if (message != null) {
            if (message.getTag() == 0) {
                message.setTag(this.b);
            }
            MessageManager.getInstance().sendMessage(message);
        }
    }

    public void a(NetMessage netMessage) {
        if (netMessage != null) {
            if (netMessage.getTag() == 0) {
                netMessage.setTag(this.b);
            }
            MessageManager.getInstance().sendMessage(netMessage);
        }
    }

    public void a(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == 0) {
            messageListener.setTag(this.b);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void a(int i, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == 0) {
            messageListener.setTag(this.b);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    @Override // com.baidu.adp.base.j
    public int getUniqueId() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.b);
        MessageManager.getInstance().removeMessage(this.b);
        com.baidu.adp.lib.resourceLoader.d.a().a(this.b);
        this.d.removeCallbacks(this.e);
        a.a().b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.adp.lib.resourceLoader.d.a().b(this.b);
        this.d.removeCallbacks(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        BdListView h_ = h_();
        if (h_ != null) {
            h_.c();
        }
    }

    @Override // com.baidu.adp.base.j
    public boolean isScroll() {
        return this.c;
    }

    @Override // com.baidu.adp.base.j
    public void setIsScroll(boolean z) {
        this.c = z;
    }

    @Override // com.baidu.adp.base.j
    public void onPreLoad(BdListView bdListView) {
    }

    public BdListView h_() {
        return null;
    }

    public void b() {
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        int childCount = frameLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            a(frameLayout.getChildAt(i));
        }
        this.d.removeCallbacks(this.e);
        this.d.postDelayed(this.e, 100L);
    }

    private void a(View view) {
        if (view != null) {
            if (view instanceof com.baidu.adp.newwidget.a.h) {
                ((com.baidu.adp.newwidget.a.h) view).b();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
