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
    private T ccr = null;
    e cct;
    private d ccu;
    private com.baidu.prologue.business.data.b ccv;
    Context mContext;

    public a(Context context, e eVar) {
        this.cct = null;
        this.cct = eVar;
        this.mContext = context;
        this.ccv = new com.baidu.prologue.business.data.b(this.cct);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.ccr = t;
        t.jv(this.cct.cbU).dB(this.cct.isFullScreen()).gP(this.cct.cbW).ju(String.valueOf(this.cct.cbV)).dC(this.cct.ccc).jw(this.cct.cbT);
    }

    public T aaf() {
        return this.ccr;
    }

    public void a(d dVar) {
        this.ccu = dVar;
    }

    public void rD() {
        this.ccu.rD();
        jt(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.ccv != null && this.ccu != null && this.ccu.ZM() != null) {
            this.ccv.ZP();
            this.ccu.onAdShow();
            this.ccu.ZM().addView(aaf().getRootView());
            com.baidu.prologue.business.data.d.e(this.cct);
            f.h(this.cct);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.cct.ccb);
        }
    }

    public void js(String str) {
        if (this.cct.aaa()) {
            this.ccv.a(Als.Area.IMAGE, str);
        } else {
            this.ccv.a(Als.Area.VIDEO, str);
        }
        this.ccu.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.cct.action);
        jt(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void ZN() {
        this.ccu.ZN();
        jt(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void jt(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.ccv.i(str, this.ccr.aai());
        } else {
            this.ccv.i(str, this.ccr.aah());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cbs.get());
    }

    public void aag() {
        this.ccu.ZO();
    }
}
