package com.baidu.prologue.business.b;

import android.content.Context;
import android.util.Log;
import com.baidu.prologue.business.c.b;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import com.baidu.prologue.business.data.f;
import com.baidu.prologue.service.network.Als;
/* loaded from: classes14.dex */
public class a<T extends com.baidu.prologue.business.c.b> {
    private T cmZ = null;
    e cna;
    private d cnb;
    private com.baidu.prologue.business.data.b cnc;
    Context mContext;

    public a(Context context, e eVar) {
        this.cna = null;
        this.cna = eVar;
        this.mContext = context;
        this.cnc = new com.baidu.prologue.business.data.b(this.cna);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.cmZ = t;
        t.kj(this.cna.cmC).ea(this.cna.isFullScreen()).ht(this.cna.cmE).ki(String.valueOf(this.cna.cmD)).eb(this.cna.cmK).kk(this.cna.cmB);
    }

    public T afd() {
        return this.cmZ;
    }

    public void a(d dVar) {
        this.cnb = dVar;
    }

    public void rF() {
        this.cnb.rF();
        kh(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.cnc != null && this.cnb != null && this.cnb.aeK() != null) {
            this.cnc.aeN();
            this.cnb.onAdShow();
            this.cnb.aeK().addView(afd().getRootView());
            com.baidu.prologue.business.data.d.e(this.cna);
            f.h(this.cna);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.cna.cmJ);
        }
    }

    public void kg(String str) {
        if (this.cna.aeY()) {
            this.cnc.a(Als.Area.IMAGE, str);
        } else {
            this.cnc.a(Als.Area.VIDEO, str);
        }
        this.cnb.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.cna.action);
        kh(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void aeL() {
        this.cnb.aeL();
        kh(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void kh(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.cnc.i(str, this.cmZ.afg());
        } else {
            this.cnc.i(str, this.cmZ.aff());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.clZ.get());
    }

    public void afe() {
        this.cnb.aeM();
    }
}
