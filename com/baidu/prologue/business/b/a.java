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
    private T bAw = null;
    e bAx;
    private com.baidu.prologue.business.data.b bAy;
    private d bzu;
    Context mContext;

    public a(Context context, e eVar) {
        this.bAx = null;
        this.bAx = eVar;
        this.mContext = context;
        this.bAy = new com.baidu.prologue.business.data.b(this.bAx);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.bAw = t;
        t.gG(this.bAx.bzZ).cS(this.bAx.isFullScreen()).dS(this.bAx.bAb).gF(String.valueOf(this.bAx.bAa)).cT(this.bAx.bAh).gH(this.bAx.bzY);
    }

    public T Op() {
        return this.bAw;
    }

    public void a(d dVar) {
        this.bzu = dVar;
    }

    public void pH() {
        this.bzu.pH();
        gE(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        this.bAy.NY();
        this.bzu.onAdShow();
        this.bzu.NV().addView(Op().getRootView());
        com.baidu.prologue.business.data.d.e(this.bAx);
        f.h(this.bAx);
        Log.d("SplashAdBasePresenter", "onadshow currate: " + this.bAx.bAg);
    }

    public void gD(String str) {
        if (this.bAx.Oj()) {
            this.bAy.a(Als.Area.IMAGE, str);
        } else {
            this.bAy.a(Als.Area.VIDEO, str);
        }
        this.bzu.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.bAx.action);
        gE(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void NW() {
        this.bzu.NW();
        gE(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void gE(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.bAy.h(str, this.bAw.Ot());
        } else {
            this.bAy.h(str, this.bAw.Os());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bzx.get());
    }

    public void Oq() {
        this.bzu.NX();
    }
}
