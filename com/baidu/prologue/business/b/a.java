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
    private T cgs = null;
    e cgt;
    private d cgu;
    private com.baidu.prologue.business.data.b cgv;
    Context mContext;

    public a(Context context, e eVar) {
        this.cgt = null;
        this.cgt = eVar;
        this.mContext = context;
        this.cgv = new com.baidu.prologue.business.data.b(this.cgt);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.cgs = t;
        t.jC(this.cgt.cfV).dK(this.cgt.isFullScreen()).gV(this.cgt.cfX).jB(String.valueOf(this.cgt.cfW)).dL(this.cgt.cgd).jD(this.cgt.cfU);
    }

    public T abV() {
        return this.cgs;
    }

    public void a(d dVar) {
        this.cgu = dVar;
    }

    public void rD() {
        this.cgu.rD();
        jA(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.cgv != null && this.cgu != null && this.cgu.abC() != null) {
            this.cgv.abF();
            this.cgu.onAdShow();
            this.cgu.abC().addView(abV().getRootView());
            com.baidu.prologue.business.data.d.e(this.cgt);
            f.h(this.cgt);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.cgt.cgc);
        }
    }

    public void jz(String str) {
        if (this.cgt.abQ()) {
            this.cgv.a(Als.Area.IMAGE, str);
        } else {
            this.cgv.a(Als.Area.VIDEO, str);
        }
        this.cgu.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.cgt.action);
        jA(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void abD() {
        this.cgu.abD();
        jA(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void jA(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.cgv.i(str, this.cgs.abY());
        } else {
            this.cgv.i(str, this.cgs.abX());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.cft.get());
    }

    public void abW() {
        this.cgu.abE();
    }
}
