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
import com.baidu.live.data.n;
import com.baidu.live.data.u;
import com.baidu.live.liveroom.middleware.d;
import com.baidu.live.liveroom.middleware.i;
import com.baidu.live.q.e;
import com.baidu.live.q.f;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a implements com.baidu.live.liveroom.middleware.b, d, i {
    protected Activity activity;
    protected com.baidu.live.liveroom.a.c bhb;
    protected com.baidu.live.liveroom.g.a bhc;
    protected e bhd;
    protected f bhe;
    protected ViewGroup rootView;
    protected Handler mHandler = new Handler();
    private CustomMessageListener bhf = new CustomMessageListener(2913146) { // from class: com.baidu.live.liveroom.f.a.1
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
    private CustomMessageListener bhg = new CustomMessageListener(2913167) { // from class: com.baidu.live.liveroom.f.a.2
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

    public abstract boolean LX();

    public abstract View a(Context context, u uVar, boolean z);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void b(n nVar);

    @Override // com.baidu.live.liveroom.middleware.d
    public abstract void f(List<com.baidu.live.im.data.a> list, boolean z);

    public abstract void f(boolean z, int i);

    public abstract void l(int i, int i2, int i3);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void l(u uVar);

    public abstract void n(u uVar);

    public abstract void o(u uVar);

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
        MessageManager.getInstance().registerListener(this.bhf);
        MessageManager.getInstance().registerListener(this.bhg);
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.bhb = cVar;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void p(ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }

    public void b(com.baidu.live.liveroom.g.a aVar) {
        this.bhc = aVar;
    }

    public void cd(boolean z) {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public final void r(Activity activity) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void cb(boolean z) {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.bhf);
        MessageManager.getInstance().unRegisterListener(this.bhg);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void dH(int i) {
    }

    public void a(e eVar, f fVar) {
        this.bhd = eVar;
        this.bhe = fVar;
    }

    public f LY() {
        return this.bhe;
    }
}
