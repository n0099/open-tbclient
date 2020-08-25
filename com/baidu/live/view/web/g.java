package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.j;
import com.baidu.live.view.web.a.k;
/* loaded from: classes7.dex */
public class g {
    private BaseActivity baseActivity;
    private SchemeCallback bvq;
    private f bvr;
    private AlaLastLiveroomInfo bvs;
    private h bvt;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] QV() {
        r0[0].a(this.bvt);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        dVar.b(this.bvs);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h(this.context);
        hVar.setHost(this.isHost);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i();
        iVar.w(this.context);
        iVar.setUserId(this.userId);
        iVar.setUserName(this.userName);
        iVar.setLiveId(this.liveId);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g(this.bvq);
        gVar.b(this.baseActivity);
        a[] aVarArr = {new j(this.context, this.bvq), dVar, hVar, new com.baidu.live.view.web.a.f(this.bvq), iVar, new com.baidu.live.view.web.a.e(this.bvq), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.bvr), new com.baidu.live.view.web.a.b(this.bvq), new k(this.bvq), gVar};
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
        this.bvq = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.bvr = fVar;
        return this;
    }

    public g aC(long j) {
        this.userId = j;
        return this;
    }

    public g hw(String str) {
        this.userName = str;
        return this;
    }

    public g cL(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bvt = hVar;
        return this;
    }

    public g aD(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bvs = alaLastLiveroomInfo;
        return this;
    }
}
