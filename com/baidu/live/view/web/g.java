package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.j;
import com.baidu.live.view.web.a.k;
import com.baidu.live.view.web.a.l;
/* loaded from: classes4.dex */
public class g {
    private SchemeCallback bFj;
    private f bFk;
    private AlaLastLiveroomInfo bFl;
    private h bFm;
    private BaseActivity baseActivity;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] Tx() {
        r0[0].a(this.bFm);
        com.baidu.live.view.web.a.e eVar = new com.baidu.live.view.web.a.e();
        eVar.setHost(this.isHost);
        eVar.b(this.bFl);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i(this.context);
        iVar.setHost(this.isHost);
        j jVar = new j();
        jVar.y(this.context);
        jVar.setUserId(this.userId);
        jVar.setUserName(this.userName);
        jVar.setLiveId(this.liveId);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h(this.bFj);
        hVar.b(this.baseActivity);
        a[] aVarArr = {new k(this.context, this.bFj), eVar, iVar, new com.baidu.live.view.web.a.g(this.bFj), jVar, new com.baidu.live.view.web.a.f(this.bFj), new com.baidu.live.view.web.a.d(), new com.baidu.live.view.web.a.a(this.bFk), new com.baidu.live.view.web.a.b(this.bFj), new l(this.bFj), hVar, new com.baidu.live.view.web.a.c()};
        return aVarArr;
    }

    public g x(Activity activity) {
        this.context = activity;
        return this;
    }

    public g a(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        return this;
    }

    public g a(SchemeCallback schemeCallback) {
        this.bFj = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.bFk = fVar;
        return this;
    }

    public g aE(long j) {
        this.userId = j;
        return this;
    }

    public g iu(String str) {
        this.userName = str;
        return this;
    }

    public g cU(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bFm = hVar;
        return this;
    }

    public g aF(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bFl = alaLastLiveroomInfo;
        return this;
    }
}
