package com.baidu.live.liveroom.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.h;
import com.baidu.live.data.m;
import com.baidu.live.liveroom.middleware.d;
import com.baidu.live.liveroom.middleware.i;
import com.baidu.live.o.e;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a implements com.baidu.live.liveroom.middleware.b, d, i {
    protected Activity activity;
    protected com.baidu.live.liveroom.a.b awf;
    protected com.baidu.live.liveroom.g.a awg;
    protected com.baidu.live.o.d awh;
    protected e awi;
    protected ViewGroup rootView;
    protected Handler mHandler = new Handler();
    private CustomMessageListener awj = new CustomMessageListener(2913146) { // from class: com.baidu.live.liveroom.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (!ListUtils.isEmpty(list)) {
                    a.this.f(list, false);
                }
            }
        }
    };
    private CustomMessageListener awk = new CustomMessageListener(2913167) { // from class: com.baidu.live.liveroom.f.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (!ListUtils.isEmpty(list)) {
                    a.this.f(list, true);
                }
            }
        }
    };

    public abstract View a(Context context, m mVar, boolean z);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void b(h hVar);

    public abstract void d(boolean z, int i);

    @Override // com.baidu.live.liveroom.middleware.d
    public abstract void f(List<com.baidu.live.im.data.a> list, boolean z);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void i(m mVar);

    public abstract void j(int i, int i2, int i3);

    public abstract void k(m mVar);

    public abstract void l(m mVar);

    @Override // com.baidu.live.liveroom.middleware.i
    public abstract void onActivityResult(int i, int i2, Intent intent);

    @Override // com.baidu.live.liveroom.middleware.i
    public abstract void onPause();

    @Override // com.baidu.live.liveroom.middleware.i
    public abstract void onResume();

    public abstract void onStart();

    @Override // com.baidu.live.liveroom.middleware.i
    public abstract void onStop();

    public abstract boolean yJ();

    public void init() {
        MessageManager.getInstance().registerListener(this.awj);
        MessageManager.getInstance().registerListener(this.awk);
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.awf = bVar;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void g(ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }

    public void b(com.baidu.live.liveroom.g.a aVar) {
        this.awg = aVar;
    }

    public void bf(boolean z) {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public final void u(Activity activity) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void be(boolean z) {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.awj);
        MessageManager.getInstance().unRegisterListener(this.awk);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void bk(int i) {
    }

    public void a(com.baidu.live.o.d dVar, e eVar) {
        this.awh = dVar;
        this.awi = eVar;
    }
}
