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
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.liveroom.middleware.d;
import com.baidu.live.liveroom.middleware.i;
import com.baidu.live.o.e;
import com.baidu.live.o.f;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a implements com.baidu.live.liveroom.middleware.b, d, i {
    protected com.baidu.live.liveroom.a.b aWi;
    protected com.baidu.live.liveroom.g.a aWj;
    protected e aWk;
    protected f aWl;
    protected Activity activity;
    protected ViewGroup rootView;
    protected Handler mHandler = new Handler();
    private CustomMessageListener aWm = new CustomMessageListener(2913146) { // from class: com.baidu.live.liveroom.f.a.1
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
    private CustomMessageListener aWn = new CustomMessageListener(2913167) { // from class: com.baidu.live.liveroom.f.a.2
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

    public abstract boolean Ff();

    public abstract View a(Context context, q qVar, boolean z);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void b(k kVar);

    @Override // com.baidu.live.liveroom.middleware.d
    public abstract void f(List<com.baidu.live.im.data.a> list, boolean z);

    public abstract void f(boolean z, int i);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void i(q qVar);

    public abstract void k(q qVar);

    public abstract void l(int i, int i2, int i3);

    public abstract void l(q qVar);

    @Override // com.baidu.live.liveroom.middleware.i
    public abstract void onActivityResult(int i, int i2, Intent intent);

    @Override // com.baidu.live.liveroom.middleware.i
    public abstract void onPause();

    @Override // com.baidu.live.liveroom.middleware.i
    public abstract void onResume();

    public abstract void onStart();

    @Override // com.baidu.live.liveroom.middleware.i
    public abstract void onStop();

    public void init() {
        MessageManager.getInstance().registerListener(this.aWm);
        MessageManager.getInstance().registerListener(this.aWn);
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.aWi = bVar;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void l(ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }

    public void b(com.baidu.live.liveroom.g.a aVar) {
        this.aWj = aVar;
    }

    public void bS(boolean z) {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public final void q(Activity activity) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void bR(boolean z) {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.aWm);
        MessageManager.getInstance().unRegisterListener(this.aWn);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void bG(int i) {
    }

    public void a(e eVar, f fVar) {
        this.aWk = eVar;
        this.aWl = fVar;
    }
}
