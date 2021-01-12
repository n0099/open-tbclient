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
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.liveroom.middleware.d;
import com.baidu.live.liveroom.middleware.i;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.v.e;
import com.baidu.live.v.f;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a implements com.baidu.live.liveroom.middleware.b, d, i {
    protected Activity activity;
    protected com.baidu.live.liveroom.a.c bok;
    protected com.baidu.live.liveroom.g.a bol;
    protected e bom;
    protected f bon;
    protected ViewGroup rootView;
    protected Handler mHandler = new Handler();
    private CustomMessageListener boo = new CustomMessageListener(2913146) { // from class: com.baidu.live.liveroom.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (!ListUtils.isEmpty(list)) {
                    a.this.f(list, false);
                }
            }
        }
    };
    private CustomMessageListener bop = new CustomMessageListener(2913167) { // from class: com.baidu.live.liveroom.f.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (!ListUtils.isEmpty(list)) {
                    a.this.f(list, true);
                }
            }
        }
    };

    public abstract boolean LA();

    public abstract View a(Context context, x xVar, boolean z);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void b(r rVar);

    public abstract void e(boolean z, int i);

    @Override // com.baidu.live.liveroom.middleware.d
    public abstract void f(List<com.baidu.live.im.data.b> list, boolean z);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void k(x xVar);

    public abstract void l(int i, int i2, int i3);

    public abstract void m(x xVar);

    public abstract void n(x xVar);

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
        MessageManager.getInstance().registerListener(this.boo);
        MessageManager.getInstance().registerListener(this.bop);
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.bok = cVar;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void o(ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }

    public void b(com.baidu.live.liveroom.g.a aVar) {
        this.bol = aVar;
    }

    public void cy(boolean z) {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Lz() {
        if (this.bok != null) {
            this.bok.ct(true);
        }
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public final void q(Activity activity) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void cw(boolean z) {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.boo);
        MessageManager.getInstance().unRegisterListener(this.bop);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void cs(int i) {
    }

    public void a(e eVar, f fVar) {
        this.bom = eVar;
        this.bon = fVar;
    }

    public f LB() {
        return this.bon;
    }
}
