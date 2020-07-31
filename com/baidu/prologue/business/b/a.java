package com.baidu.prologue.business.b;

import android.content.Context;
import android.util.Log;
import com.baidu.prologue.business.c.b;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import com.baidu.prologue.business.data.f;
import com.baidu.prologue.service.network.Als;
/* loaded from: classes8.dex */
public class a<T extends com.baidu.prologue.business.c.b> {
    private T bFH = null;
    e bFI;
    private d bFJ;
    private com.baidu.prologue.business.data.b bFK;
    Context mContext;

    public a(Context context, e eVar) {
        this.bFI = null;
        this.bFI = eVar;
        this.mContext = context;
        this.bFK = new com.baidu.prologue.business.data.b(this.bFI);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.bFH = t;
        t.gM(this.bFI.bFk).cZ(this.bFI.isFullScreen()).ef(this.bFI.bFm).gL(String.valueOf(this.bFI.bFl)).da(this.bFI.bFs).gN(this.bFI.bFj);
    }

    public T PK() {
        return this.bFH;
    }

    public void a(d dVar) {
        this.bFJ = dVar;
    }

    public void pZ() {
        this.bFJ.pZ();
        gK(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.bFK != null && this.bFJ != null && this.bFJ.Pq() != null) {
            this.bFK.Pt();
            this.bFJ.onAdShow();
            this.bFJ.Pq().addView(PK().getRootView());
            com.baidu.prologue.business.data.d.e(this.bFI);
            f.h(this.bFI);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.bFI.bFr);
        }
    }

    public void gJ(String str) {
        if (this.bFI.PE()) {
            this.bFK.a(Als.Area.IMAGE, str);
        } else {
            this.bFK.a(Als.Area.VIDEO, str);
        }
        this.bFJ.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.bFI.action);
        gK(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void Pr() {
        this.bFJ.Pr();
        gK(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void gK(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.bFK.h(str, this.bFH.PO());
        } else {
            this.bFK.h(str, this.bFH.PN());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bEI.get());
    }

    public void PL() {
        this.bFJ.Ps();
    }
}
