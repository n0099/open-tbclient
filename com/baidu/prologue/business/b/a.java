package com.baidu.prologue.business.b;

import android.content.Context;
import android.util.Log;
import com.baidu.prologue.business.c.b;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import com.baidu.prologue.business.data.f;
import com.baidu.prologue.service.network.Als;
/* loaded from: classes10.dex */
public class a<T extends com.baidu.prologue.business.c.b> {
    private T bNl = null;
    e bNm;
    private d bNn;
    private com.baidu.prologue.business.data.b bNo;
    Context mContext;

    public a(Context context, e eVar) {
        this.bNm = null;
        this.bNm = eVar;
        this.mContext = context;
        this.bNo = new com.baidu.prologue.business.data.b(this.bNm);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.bNl = t;
        t.iA(this.bNm.bMO).dg(this.bNm.isFullScreen()).gk(this.bNm.bMQ).iz(String.valueOf(this.bNm.bMP)).dh(this.bNm.bMW).iB(this.bNm.bMN);
    }

    public T Wo() {
        return this.bNl;
    }

    public void a(d dVar) {
        this.bNn = dVar;
    }

    public void rD() {
        this.bNn.rD();
        iy(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.bNo != null && this.bNn != null && this.bNn.VV() != null) {
            this.bNo.VY();
            this.bNn.onAdShow();
            this.bNn.VV().addView(Wo().getRootView());
            com.baidu.prologue.business.data.d.e(this.bNm);
            f.h(this.bNm);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.bNm.bMV);
        }
    }

    public void ix(String str) {
        if (this.bNm.Wj()) {
            this.bNo.a(Als.Area.IMAGE, str);
        } else {
            this.bNo.a(Als.Area.VIDEO, str);
        }
        this.bNn.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.bNm.action);
        iy(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void VW() {
        this.bNn.VW();
        iy(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void iy(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.bNo.g(str, this.bNl.Ws());
        } else {
            this.bNo.g(str, this.bNl.Wr());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bMm.get());
    }

    public void Wp() {
        this.bNn.VX();
    }
}
