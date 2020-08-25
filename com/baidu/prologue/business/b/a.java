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
    private T bLh = null;
    e bLi;
    private d bLj;
    private com.baidu.prologue.business.data.b bLk;
    Context mContext;

    public a(Context context, e eVar) {
        this.bLi = null;
        this.bLi = eVar;
        this.mContext = context;
        this.bLk = new com.baidu.prologue.business.data.b(this.bLi);
        com.baidu.prologue.business.data.c.b(eVar);
    }

    public void a(T t) {
        this.bLh = t;
        t.ig(this.bLi.bKK).dh(this.bLi.isFullScreen()).gb(this.bLi.bKM).m31if(String.valueOf(this.bLi.bKL)).di(this.bLi.bKS).ih(this.bLi.bKJ);
    }

    public T VF() {
        return this.bLh;
    }

    public void a(d dVar) {
        this.bLj = dVar;
    }

    public void ry() {
        this.bLj.ry();
        ie(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
    }

    public void onAdShow() {
        if (this.bLk != null && this.bLj != null && this.bLj.Vm() != null) {
            this.bLk.Vp();
            this.bLj.onAdShow();
            this.bLj.Vm().addView(VF().getRootView());
            com.baidu.prologue.business.data.d.e(this.bLi);
            f.h(this.bLi);
            Log.d("SplashAdBasePresenter", "onadshow currate: " + this.bLi.bKR);
        }
    }

    public void id(String str) {
        if (this.bLi.VA()) {
            this.bLk.a(Als.Area.IMAGE, str);
        } else {
            this.bLk.a(Als.Area.VIDEO, str);
        }
        this.bLj.onAdClick();
        com.baidu.prologue.c.d.invoke(this.mContext, this.bLi.action);
        ie(Als.CloseType.CLICK_AD_AREA.value);
    }

    public void Vn() {
        this.bLj.Vn();
        ie(Als.CloseType.CLICK_SKIP_BUTTON.value);
    }

    protected void ie(String str) {
        if (Als.CloseType.COUNTDOWN_TIME_FINISH.value.equals(str)) {
            this.bLk.g(str, this.bLh.VJ());
        } else {
            this.bLk.g(str, this.bLh.VI());
        }
        com.baidu.prologue.business.a.a(com.baidu.prologue.a.b.a.bKi.get());
    }

    public void VG() {
        this.bLj.Vo();
    }
}
