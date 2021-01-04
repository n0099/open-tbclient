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
/* loaded from: classes11.dex */
public abstract class a implements com.baidu.live.liveroom.middleware.b, d, i {
    protected Activity activity;
    protected com.baidu.live.liveroom.a.c bsW;
    protected com.baidu.live.liveroom.g.a bsX;
    protected e bsY;
    protected f bsZ;
    protected ViewGroup rootView;
    protected Handler mHandler = new Handler();
    private CustomMessageListener bta = new CustomMessageListener(2913146) { // from class: com.baidu.live.liveroom.f.a.1
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
    private CustomMessageListener btb = new CustomMessageListener(2913167) { // from class: com.baidu.live.liveroom.f.a.2
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

    public abstract boolean Pv();

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
        MessageManager.getInstance().registerListener(this.bta);
        MessageManager.getInstance().registerListener(this.btb);
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.bsW = cVar;
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
        this.bsX = aVar;
    }

    public void cC(boolean z) {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Pu() {
        if (this.bsW != null) {
            this.bsW.cx(true);
        }
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public final void q(Activity activity) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void cA(boolean z) {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        MessageManager.getInstance().unRegisterListener(this.bta);
        MessageManager.getInstance().unRegisterListener(this.btb);
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void dY(int i) {
    }

    public void a(e eVar, f fVar) {
        this.bsY = eVar;
        this.bsZ = fVar;
    }

    public f Pw() {
        return this.bsZ;
    }
}
