package com.baidu.prologue.business.b;

import android.content.Context;
import android.util.Log;
import com.baidu.prologue.business.c.b;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import com.baidu.prologue.business.data.f;
import com.baidu.prologue.service.network.Als;
/* loaded from: classes6.dex */
public class a<T extends com.baidu.prologue.business.c.b> {
    private T cuf = null;
    e cug;
    private d cuh;
    private com.baidu.prologue.business.data.b cui;
    Context mContext;

    public a(Context context, e eVar) {
        this.cug = null;
        this.cug = eVar;
        this.mContext = context;
        this.cui = new com.baidu.prologue.business.data.b(this.cug);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.cuf = t;
        t.kd(this.cug.ctI).ej(this.cug.isFullScreen()).hs(this.cug.ctK).kc(String.valueOf(this.cug.ctJ)).ek(this.cug.ctQ).ke(this.cug.ctH);
    }

    public T aha() {
        return this.cuf;
    }

    public void a(d dVar) {
        this.cuh = dVar;
    }

    public void rg() {
        this.cuh.rg();
        kb(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.cui != null && this.cuh != null && this.cuh.agH() != null) {
            this.cui.agK();
            this.cuh.onAdShow();
            this.cuh.agH().addView(aha().getRootView());
            com.baidu.prologue.business.data.d.e(this.cug);
            f.h(this.cug);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.cug.ctP);
        }
    }

    public void onAdClick(String str) {
        if (this.cug.agV()) {
            this.cui.a(Als.Area.IMAGE, str);
        } else {
            this.cui.a(Als.Area.VIDEO, str);
        }
        this.cuh.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.cug.action);
        kb(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void agI() {
        this.cuh.agI();
        kb(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void kb(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.cui.i(str, this.cuf.ahd());
        } else {
            this.cui.i(str, this.cuf.ahc());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.ctd.get());
    }

    public void ahb() {
        this.cuh.agJ();
    }
}
