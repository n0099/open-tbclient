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
    private d bEi;
    private T bFk = null;
    e bFl;
    private com.baidu.prologue.business.data.b bFm;
    Context mContext;

    public a(Context context, e eVar) {
        this.bFl = null;
        this.bFl = eVar;
        this.mContext = context;
        this.bFm = new com.baidu.prologue.business.data.b(this.bFl);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.bFk = t;
        t.gO(this.bFl.bEN).cX(this.bFl.isFullScreen()).ef(this.bFl.bEP).gN(String.valueOf(this.bFl.bEO)).cY(this.bFl.bEV).gP(this.bFl.bEM);
    }

    public T Pv() {
        return this.bFk;
    }

    public void a(d dVar) {
        this.bEi = dVar;
    }

    public void pY() {
        this.bEi.pY();
        gM(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.bFm != null && this.bEi != null && this.bEi.Pb() != null) {
            this.bFm.Pe();
            this.bEi.onAdShow();
            this.bEi.Pb().addView(Pv().getRootView());
            com.baidu.prologue.business.data.d.e(this.bFl);
            f.h(this.bFl);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.bFl.bEU);
        }
    }

    public void gL(String str) {
        if (this.bFl.Pp()) {
            this.bFm.a(Als.Area.IMAGE, str);
        } else {
            this.bFm.a(Als.Area.VIDEO, str);
        }
        this.bEi.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.bFl.action);
        gM(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void Pc() {
        this.bEi.Pc();
        gM(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void gM(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.bFm.h(str, this.bFk.Pz());
        } else {
            this.bFm.h(str, this.bFk.Py());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bEl.get());
    }

    public void Pw() {
        this.bEi.Pd();
    }
}
