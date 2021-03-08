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
import com.baidu.live.data.ab;
import com.baidu.live.data.v;
import com.baidu.live.liveroom.middleware.d;
import com.baidu.live.liveroom.middleware.i;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.e;
import com.baidu.live.u.f;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a implements com.baidu.live.liveroom.middleware.b, d, i {
    protected Activity activity;
    protected com.baidu.live.liveroom.a.c btl;
    protected com.baidu.live.liveroom.g.a btm;
    protected e bto;
    protected f btp;
    protected ViewGroup rootView;
    protected Handler mHandler = new Handler();
    private CustomMessageListener btq = new CustomMessageListener(2913146) { // from class: com.baidu.live.liveroom.f.a.1
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
    private CustomMessageListener btr = new CustomMessageListener(2913167) { // from class: com.baidu.live.liveroom.f.a.2
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

    public abstract boolean Nb();

    public abstract View a(Context context, ab abVar, boolean z);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void b(v vVar);

    public abstract void e(boolean z, int i);

    @Override // com.baidu.live.liveroom.middleware.d
    public abstract void f(List<com.baidu.live.im.data.b> list, boolean z);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void k(ab abVar);

    public abstract void l(int i, int i2, int i3);

    public abstract void m(ab abVar);

    public abstract void n(ab abVar);

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
        MessageManager.getInstance().registerListener(this.btq);
        MessageManager.getInstance().registerListener(this.btr);
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.btl = cVar;
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
        this.btm = aVar;
    }

    public void cH(boolean z) {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Na() {
        if (this.btl != null) {
            this.btl.cC(true);
        }
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public final void q(Activity activity) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.btq);
        MessageManager.getInstance().unRegisterListener(this.btr);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void cw(int i) {
    }

    public void a(e eVar, f fVar) {
        this.bto = eVar;
        this.btp = fVar;
    }

    public f Nc() {
        return this.btp;
    }
}
