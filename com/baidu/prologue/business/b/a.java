package com.baidu.prologue.business.b;

import android.content.Context;
import android.util.Log;
import com.baidu.prologue.business.c.b;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import com.baidu.prologue.business.data.f;
import com.baidu.prologue.service.network.Als;
/* loaded from: classes5.dex */
public class a<T extends com.baidu.prologue.business.c.b> {
    private T cpo = null;
    e cpp;
    private d cpq;
    private com.baidu.prologue.business.data.b cpr;
    Context mContext;

    public a(Context context, e eVar) {
        this.cpp = null;
        this.cpp = eVar;
        this.mContext = context;
        this.cpr = new com.baidu.prologue.business.data.b(this.cpp);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.cpo = t;
        t.iS(this.cpp.coR).ef(this.cpp.isFullScreen()).fL(this.cpp.coT).iR(String.valueOf(this.cpp.coS)).eg(this.cpp.coZ).iT(this.cpp.coQ);
    }

    public T adg() {
        return this.cpo;
    }

    public void a(d dVar) {
        this.cpq = dVar;
    }

    public void rg() {
        this.cpq.rg();
        iQ(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.cpr != null && this.cpq != null && this.cpq.acN() != null) {
            this.cpr.acQ();
            this.cpq.onAdShow();
            this.cpq.acN().addView(adg().getRootView());
            com.baidu.prologue.business.data.d.e(this.cpp);
            f.h(this.cpp);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.cpp.coY);
        }
    }

    public void onAdClick(String str) {
        if (this.cpp.adb()) {
            this.cpr.a(Als.Area.IMAGE, str);
        } else {
            this.cpr.a(Als.Area.VIDEO, str);
        }
        this.cpq.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.cpp.action);
        iQ(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void acO() {
        this.cpq.acO();
        iQ(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void iQ(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.cpr.i(str, this.cpo.adj());
        } else {
            this.cpr.i(str, this.cpo.adi());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cop.get());
    }

    public void adh() {
        this.cpq.acP();
    }
}
