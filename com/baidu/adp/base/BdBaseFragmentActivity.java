package com.baidu.adp.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import d.b.c.a.b;
import d.b.c.a.f;
import d.b.c.a.g;
import d.b.c.a.h;
import d.b.c.a.i;
import d.b.c.e.l.d;
import d.b.c.e.p.l;
import d.b.c.j.e.q;
/* loaded from: classes.dex */
public abstract class BdBaseFragmentActivity<T> extends FragmentActivity implements View.OnClickListener, View.OnLongClickListener, g<T>, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener, i {
    public static final int PRELOAD_DELAY = 100;
    public BdUniqueId mId = null;
    public boolean mIsScroll = false;
    public final Handler mHandler = new Handler();
    public final Runnable preLoadRunnable = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BdBaseFragmentActivity bdBaseFragmentActivity = BdBaseFragmentActivity.this;
            bdBaseFragmentActivity.onPreLoad(bdBaseFragmentActivity.onGetPreLoadListView());
        }
    }

    private void refreshImage(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof d.b.c.f.a.i) {
            ((d.b.c.f.a.i) view).refresh();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                refreshImage(viewGroup.getChildAt(i));
            }
        }
    }

    public Activity getActivity() {
        return this;
    }

    @Override // d.b.c.a.g
    public abstract /* synthetic */ f<T> getPageContext();

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources b2 = h.a().b();
        return (b2 == null || !BdBaseApplication.getInst().getIsPluginResourcOpen()) ? super.getResources() : b2;
    }

    @Override // d.b.c.a.i
    public BdUniqueId getUniqueId() {
        return this.mId;
    }

    public void initUniqueId() {
        if (this.mId == null) {
            this.mId = BdUniqueId.gen();
        }
    }

    @Override // d.b.c.a.i
    public boolean isScroll() {
        return this.mIsScroll;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        d.b.c.a.a.b(this);
        super.onCreate(bundle);
        if (this.mId == null) {
            this.mId = BdUniqueId.gen();
        }
        b.f().n(getPageContext().getPageActivity());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().removeMessage(this.mId);
        d.h().b(this.mId);
        this.mHandler.removeCallbacks(this.preLoadRunnable);
        b.f().l(getPageContext().getPageActivity());
    }

    public q onGetPreLoadListView() {
        return null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return true;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        d.h().e(this.mId);
        this.mHandler.removeCallbacks(this.preLoadRunnable);
    }

    @Override // d.b.c.a.i
    public void onPreLoad(q qVar) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        onResumeLoadResource();
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        q onGetPreLoadListView = onGetPreLoadListView();
        if (onGetPreLoadListView != null) {
            onGetPreLoadListView.cancelRefresh();
        }
    }

    public void registerListener(MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(messageListener);
    }

    public void releaseResouce() {
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

    @Override // android.app.Activity
    public void setContentView(int i) {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                super.setContentView(i);
                return;
            } catch (OutOfMemoryError e2) {
                if (i2 != 2) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                } else {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                if (i2 != 2) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                } else {
                    throw e3;
                }
            }
        }
    }

    @Override // d.b.c.a.i
    public void setIsScroll(boolean z) {
        this.mIsScroll = z;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (d.b.c.a.a.d(this) && d.b.c.a.a.a(i)) {
            return;
        }
        super.setRequestedOrientation(i);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    public void showToast(String str) {
        l.L(getApplicationContext(), str);
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        if (messageListener != null && messageListener.getTag() == null) {
            messageListener.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i, messageListener);
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

    public void registerListener(d.b.c.c.g.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(aVar);
    }

    public void registerListener(int i, d.b.c.c.g.a aVar) {
        if (aVar != null && aVar.getTag() == null) {
            aVar.setTag(this.mId);
        }
        MessageManager.getInstance().registerListener(i, aVar);
    }
}
