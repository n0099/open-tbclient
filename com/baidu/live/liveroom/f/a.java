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
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.liveroom.middleware.d;
import com.baidu.live.liveroom.middleware.i;
import com.baidu.live.s.e;
import com.baidu.live.s.f;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a implements com.baidu.live.liveroom.middleware.b, d, i {
    protected Activity activity;
    protected com.baidu.live.liveroom.a.c bnG;
    protected com.baidu.live.liveroom.g.a bnH;
    protected e bnI;
    protected f bnJ;
    protected ViewGroup rootView;
    protected Handler mHandler = new Handler();
    private CustomMessageListener bnK = new CustomMessageListener(2913146) { // from class: com.baidu.live.liveroom.f.a.1
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
    private CustomMessageListener bnL = new CustomMessageListener(2913167) { // from class: com.baidu.live.liveroom.f.a.2
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

    public abstract boolean NW();

    public abstract View a(Context context, w wVar, boolean z);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void b(q qVar);

    @Override // com.baidu.live.liveroom.middleware.d
    public abstract void f(List<com.baidu.live.im.data.a> list, boolean z);

    public abstract void f(boolean z, int i);

    @Override // com.baidu.live.liveroom.middleware.c
    public abstract void j(w wVar);

    public abstract void l(int i, int i2, int i3);

    public abstract void l(w wVar);

    public abstract void m(w wVar);

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
        MessageManager.getInstance().registerListener(this.bnK);
        MessageManager.getInstance().registerListener(this.bnL);
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.bnG = cVar;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void p(ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }

    public void b(com.baidu.live.liveroom.g.a aVar) {
        this.bnH = aVar;
    }

    public void cj(boolean z) {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public final void s(Activity activity) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void ch(boolean z) {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.bnK);
        MessageManager.getInstance().unRegisterListener(this.bnL);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void dM(int i) {
    }

    public void a(e eVar, f fVar) {
        this.bnI = eVar;
        this.bnJ = fVar;
    }

    public f NX() {
        return this.bnJ;
    }
}
