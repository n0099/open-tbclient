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
    private d brR;
    private T bsT = null;
    e bsU;
    private com.baidu.prologue.business.data.b bsV;
    Context mContext;

    public a(Context context, e eVar) {
        this.bsU = null;
        this.bsU = eVar;
        this.mContext = context;
        this.bsV = new com.baidu.prologue.business.data.b(this.bsU);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.bsT = t;
        t.fU(this.bsU.bsw).cG(this.bsU.isFullScreen()).dM(this.bsU.bsy).fT(String.valueOf(this.bsU.bsx)).cH(this.bsU.bsE).fV(this.bsU.bsv);
    }

    public T Mc() {
        return this.bsT;
    }

    public void a(d dVar) {
        this.brR = dVar;
    }

    public void pB() {
        this.brR.pB();
        fS(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        this.bsV.LL();
        this.brR.onAdShow();
        this.brR.LI().addView(Mc().getRootView());
        com.baidu.prologue.business.data.d.e(this.bsU);
        f.h(this.bsU);
        Log.d("SplashAdBasePresenter", "onadshow currate: " + this.bsU.bsD);
    }

    public void fR(String str) {
        if (this.bsU.LW()) {
            this.bsV.a(Als.Area.IMAGE, str);
        } else {
            this.bsV.a(Als.Area.VIDEO, str);
        }
        this.brR.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.bsU.action);
        fS(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void LJ() {
        this.brR.LJ();
        fS(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void fS(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.bsV.i(str, this.bsT.Mg());
        } else {
            this.bsV.i(str, this.bsT.Mf());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.brU.get());
    }

    public void Md() {
        this.brR.LK();
    }
}
