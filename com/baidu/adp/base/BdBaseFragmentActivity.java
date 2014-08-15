package com.baidu.adp.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class BdBaseFragmentActivity extends FragmentActivity implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, i {
    private final int b = 100;
    private BdUniqueId c = null;
    private boolean d = false;
    protected final Handler a = new Handler();
    private final Runnable e = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = BdUniqueId.gen();
        a.a().a(this);
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

    public void a(String str) {
        j.a(getApplicationContext(), str);
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
            if (message.getTag() == null) {
                message.setTag(this.c);
            }
            MessageManager.getInstance().sendMessage(message);
        }
    }

    public void a(NetMessage netMessage) {
        if (netMessage != null) {
            if (netMessage.getTag() == null) {
                netMessage.setTag(this.c);
            }
            MessageManager.getInstance().sendMessage(netMessage);
        }
    }

    public void a(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.c);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void a(int i, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.c);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
    }

    @Override // com.baidu.adp.base.i
    public BdUniqueId getUniqueId() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.c);
        MessageManager.getInstance().removeMessage(this.c);
        com.baidu.adp.lib.resourceLoader.d.a().a(this.c);
        this.a.removeCallbacks(this.e);
        a.a().b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.adp.lib.resourceLoader.d.a().b(this.c);
        this.a.removeCallbacks(this.e);
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
        BdListView p_ = p_();
        if (p_ != null) {
            p_.c();
        }
    }

    @Override // com.baidu.adp.base.i
    public boolean isScroll() {
        return this.d;
    }

    @Override // com.baidu.adp.base.i
    public void setIsScroll(boolean z) {
        this.d = z;
    }

    @Override // com.baidu.adp.base.i
    public void onPreLoad(BdListView bdListView) {
    }

    public BdListView p_() {
        return null;
    }

    public void b() {
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        int childCount = frameLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            a(frameLayout.getChildAt(i));
        }
        this.a.removeCallbacks(this.e);
        this.a.postDelayed(this.e, 100L);
    }

    private void a(View view) {
        if (view != null) {
            if (view instanceof com.baidu.adp.newwidget.a.i) {
                ((com.baidu.adp.newwidget.a.i) view).b();
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
