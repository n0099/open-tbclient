package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.j;
import com.baidu.live.view.web.a.k;
/* loaded from: classes4.dex */
public class g {
    private BaseActivity baseActivity;
    private f bdL;
    private SchemeCallback bpB;
    private AlaLastLiveroomInfo bpC;
    private h bpD;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] KV() {
        r0[0].a(this.bpD);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        dVar.b(this.bpC);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h(this.context);
        hVar.setHost(this.isHost);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i();
        iVar.w(this.context);
        iVar.setUserId(this.userId);
        iVar.setUserName(this.userName);
        iVar.setLiveId(this.liveId);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g(this.bpB);
        gVar.b(this.baseActivity);
        a[] aVarArr = {new j(this.context, this.bpB), dVar, hVar, new com.baidu.live.view.web.a.f(this.bpB), iVar, new com.baidu.live.view.web.a.e(this.bpB), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.bdL), new com.baidu.live.view.web.a.b(this.bpB), new k(this.bpB), gVar};
        return aVarArr;
    }

    public g v(Activity activity) {
        this.context = activity;
        return this;
    }

    public g a(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        return this;
    }

    public g a(SchemeCallback schemeCallback) {
        this.bpB = schemeCallback;
        return this;
    }

    public g b(f fVar) {
        this.bdL = fVar;
        return this;
    }

    public g aB(long j) {
        this.userId = j;
        return this;
    }

    public g gb(String str) {
        this.userName = str;
        return this;
    }

    public g cD(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bpD = hVar;
        return this;
    }

    public g aC(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bpC = alaLastLiveroomInfo;
        return this;
    }
}
