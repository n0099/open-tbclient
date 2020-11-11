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
    private T cie = null;
    e cif;
    private d cig;
    private com.baidu.prologue.business.data.b cih;
    Context mContext;

    public a(Context context, e eVar) {
        this.cif = null;
        this.cif = eVar;
        this.mContext = context;
        this.cih = new com.baidu.prologue.business.data.b(this.cif);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.cie = t;
        t.jI(this.cif.chG).dI(this.cif.isFullScreen()).gZ(this.cif.chI).jH(String.valueOf(this.cif.chH)).dJ(this.cif.chO).jJ(this.cif.chF);
    }

    public T acE() {
        return this.cie;
    }

    public void a(d dVar) {
        this.cig = dVar;
    }

    public void rD() {
        this.cig.rD();
        jG(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.cih != null && this.cig != null && this.cig.acl() != null) {
            this.cih.aco();
            this.cig.onAdShow();
            this.cig.acl().addView(acE().getRootView());
            com.baidu.prologue.business.data.d.e(this.cif);
            f.h(this.cif);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.cif.chN);
        }
    }

    public void jF(String str) {
        if (this.cif.acz()) {
            this.cih.a(Als.Area.IMAGE, str);
        } else {
            this.cih.a(Als.Area.VIDEO, str);
        }
        this.cig.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.cif.action);
        jG(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void acm() {
        this.cig.acm();
        jG(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void jG(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.cih.i(str, this.cie.acH());
        } else {
            this.cih.i(str, this.cie.acG());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.che.get());
    }

    public void acF() {
        this.cig.acn();
    }
}
