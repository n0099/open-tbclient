package com.baidu.prologue.business.b;

import android.content.Context;
import android.util.Log;
import com.baidu.prologue.business.c.b;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import com.baidu.prologue.business.data.f;
import com.baidu.prologue.service.network.Als;
/* loaded from: classes19.dex */
public class a<T extends com.baidu.prologue.business.c.b> {
    private T bTU = null;
    e bTV;
    private d bTW;
    private com.baidu.prologue.business.data.b bTX;
    Context mContext;

    public a(Context context, e eVar) {
        this.bTV = null;
        this.bTV = eVar;
        this.mContext = context;
        this.bTX = new com.baidu.prologue.business.data.b(this.bTV);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.bTU = t;
        t.jc(this.bTV.bTx).dn(this.bTV.isFullScreen()).gE(this.bTV.bTz).jb(String.valueOf(this.bTV.bTy)).m31do(this.bTV.bTF).jd(this.bTV.bTw);
    }

    public T Yl() {
        return this.bTU;
    }

    public void a(d dVar) {
        this.bTW = dVar;
    }

    public void rD() {
        this.bTW.rD();
        ja(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.bTX != null && this.bTW != null && this.bTW.XS() != null) {
            this.bTX.XV();
            this.bTW.onAdShow();
            this.bTW.XS().addView(Yl().getRootView());
            com.baidu.prologue.business.data.d.e(this.bTV);
            f.h(this.bTV);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.bTV.bTE);
        }
    }

    public void iZ(String str) {
        if (this.bTV.Yg()) {
            this.bTX.a(Als.Area.IMAGE, str);
        } else {
            this.bTX.a(Als.Area.VIDEO, str);
        }
        this.bTW.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.bTV.action);
        ja(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void XT() {
        this.bTW.XT();
        ja(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void ja(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.bTX.g(str, this.bTU.Yp());
        } else {
            this.bTX.g(str, this.bTU.Yo());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bSV.get());
    }

    public void Ym() {
        this.bTW.XU();
    }
}
