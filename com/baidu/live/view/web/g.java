package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.j;
import com.baidu.live.view.web.a.k;
/* loaded from: classes3.dex */
public class g {
    private BaseActivity baseActivity;
    private f bdt;
    private SchemeCallback bpg;
    private AlaLastLiveroomInfo bph;
    private h bpi;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] KO() {
        r0[0].a(this.bpi);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        dVar.b(this.bph);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h(this.context);
        hVar.setHost(this.isHost);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i();
        iVar.v(this.context);
        iVar.setUserId(this.userId);
        iVar.setUserName(this.userName);
        iVar.setLiveId(this.liveId);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g(this.bpg);
        gVar.b(this.baseActivity);
        a[] aVarArr = {new j(this.context, this.bpg), dVar, hVar, new com.baidu.live.view.web.a.f(this.bpg), iVar, new com.baidu.live.view.web.a.e(this.bpg), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.bdt), new com.baidu.live.view.web.a.b(this.bpg), new k(this.bpg), gVar};
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
        this.bpg = schemeCallback;
        return this;
    }

    public g b(f fVar) {
        this.bdt = fVar;
        return this;
    }

    public g aB(long j) {
        this.userId = j;
        return this;
    }

    public g gc(String str) {
        this.userName = str;
        return this;
    }

    public g cB(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bpi = hVar;
        return this;
    }

    public g aC(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bph = alaLastLiveroomInfo;
        return this;
    }
}
