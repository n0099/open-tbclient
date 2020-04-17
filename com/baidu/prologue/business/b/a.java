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
    private d brN;
    private T bsP = null;
    e bsQ;
    private com.baidu.prologue.business.data.b bsR;
    Context mContext;

    public a(Context context, e eVar) {
        this.bsQ = null;
        this.bsQ = eVar;
        this.mContext = context;
        this.bsR = new com.baidu.prologue.business.data.b(this.bsQ);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.bsP = t;
        t.fU(this.bsQ.bss).cG(this.bsQ.isFullScreen()).dM(this.bsQ.bsu).fT(String.valueOf(this.bsQ.bst)).cH(this.bsQ.bsA).fV(this.bsQ.bsr);
    }

    public T Md() {
        return this.bsP;
    }

    public void a(d dVar) {
        this.brN = dVar;
    }

    public void pB() {
        this.brN.pB();
        fS(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        this.bsR.LM();
        this.brN.onAdShow();
        this.brN.LJ().addView(Md().getRootView());
        com.baidu.prologue.business.data.d.e(this.bsQ);
        f.h(this.bsQ);
        Log.d("SplashAdBasePresenter", "onadshow currate: " + this.bsQ.bsz);
    }

    public void fR(String str) {
        if (this.bsQ.LX()) {
            this.bsR.a(Als.Area.IMAGE, str);
        } else {
            this.bsR.a(Als.Area.VIDEO, str);
        }
        this.brN.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.bsQ.action);
        fS(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void LK() {
        this.brN.LK();
        fS(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void fS(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.bsR.i(str, this.bsP.Mh());
        } else {
            this.bsR.i(str, this.bsP.Mg());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.brQ.get());
    }

    public void Me() {
        this.brN.LL();
    }
}
