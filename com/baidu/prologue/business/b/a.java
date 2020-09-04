package com.baidu.prologue.business.b;

import android.content.Context;
import android.util.Log;
import com.baidu.prologue.business.c.b;
import com.baidu.prologue.business.d;
import com.baidu.prologue.business.data.e;
import com.baidu.prologue.business.data.f;
import com.baidu.prologue.service.network.Als;
/* loaded from: classes9.dex */
public class a<T extends com.baidu.prologue.business.c.b> {
    private T bLl = null;
    e bLm;
    private d bLn;
    private com.baidu.prologue.business.data.b bLo;
    Context mContext;

    public a(Context context, e eVar) {
        this.bLm = null;
        this.bLm = eVar;
        this.mContext = context;
        this.bLo = new com.baidu.prologue.business.data.b(this.bLm);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.bLl = t;
        t.ih(this.bLm.bKO).di(this.bLm.isFullScreen()).gb(this.bLm.bKQ).ig(String.valueOf(this.bLm.bKP)).dj(this.bLm.bKW).ii(this.bLm.bKN);
    }

    public T VF() {
        return this.bLl;
    }

    public void a(d dVar) {
        this.bLn = dVar;
    }

    public void ry() {
        this.bLn.ry();
        m31if(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.bLo != null && this.bLn != null && this.bLn.Vm() != null) {
            this.bLo.Vp();
            this.bLn.onAdShow();
            this.bLn.Vm().addView(VF().getRootView());
            com.baidu.prologue.business.data.d.e(this.bLm);
            f.h(this.bLm);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.bLm.bKV);
        }
    }

    public void ie(String str) {
        if (this.bLm.VA()) {
            this.bLo.a(Als.Area.IMAGE, str);
        } else {
            this.bLo.a(Als.Area.VIDEO, str);
        }
        this.bLn.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.bLm.action);
        m31if(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void Vn() {
        this.bLn.Vn();
        m31if(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    /* renamed from: if  reason: not valid java name */
    protected void m31if(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.bLo.g(str, this.bLl.VJ());
        } else {
            this.bLo.g(str, this.bLl.VI());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bKm.get());
    }

    public void VG() {
        this.bLn.Vo();
    }
}
