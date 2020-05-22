package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.j;
import com.baidu.live.view.web.a.k;
/* loaded from: classes3.dex */
public class g {
    private BaseActivity baseActivity;
    private SchemeCallback bkf;
    private f bkg;
    private h bkh;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] JF() {
        r0[0].a(this.bkh);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h(this.context);
        hVar.setHost(this.isHost);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i();
        iVar.v(this.context);
        iVar.setUserId(this.userId);
        iVar.setUserName(this.userName);
        iVar.setLiveId(this.liveId);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g(this.bkf);
        gVar.b(this.baseActivity);
        a[] aVarArr = {new j(this.context, this.bkf), dVar, hVar, new com.baidu.live.view.web.a.f(this.bkf), iVar, new com.baidu.live.view.web.a.e(this.bkf), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.bkg), new com.baidu.live.view.web.a.b(this.bkf), new k(this.bkf), gVar};
        return aVarArr;
    }

    public g u(Activity activity) {
        this.context = activity;
        return this;
    }

    public g a(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        return this;
    }

    public g a(SchemeCallback schemeCallback) {
        this.bkf = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.bkg = fVar;
        return this;
    }

    public g aB(long j) {
        this.userId = j;
        return this;
    }

    public g fU(String str) {
        this.userName = str;
        return this;
    }

    public g cv(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bkh = hVar;
        return this;
    }

    public g aC(long j) {
        this.liveId = j;
        return this;
    }
}
