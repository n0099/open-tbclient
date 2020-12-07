package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.j;
import com.baidu.live.view.web.a.k;
import com.baidu.live.view.web.a.l;
import com.baidu.live.view.web.a.m;
import com.baidu.live.view.web.a.n;
import com.baidu.live.view.web.a.o;
/* loaded from: classes4.dex */
public class g {
    private SchemeCallback bRj;
    private f bRk;
    private AlaLastLiveroomInfo bRl;
    private h bRm;
    private BaseActivity baseActivity;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] YO() {
        r0[0].a(this.bRm);
        com.baidu.live.view.web.a.e eVar = new com.baidu.live.view.web.a.e();
        eVar.setHost(this.isHost);
        eVar.b(this.bRl);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i(this.context);
        iVar.setHost(this.isHost);
        m mVar = new m();
        mVar.setActivityContext(this.context);
        mVar.setUserId(this.userId);
        mVar.setUserName(this.userName);
        mVar.setLiveId(this.liveId);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h(this.bRj);
        hVar.b(this.baseActivity);
        a[] aVarArr = {new n(this.context, this.bRj), eVar, iVar, new com.baidu.live.view.web.a.g(this.bRj), mVar, new com.baidu.live.view.web.a.f(this.bRj), new com.baidu.live.view.web.a.d(), new com.baidu.live.view.web.a.a(this.bRk), new com.baidu.live.view.web.a.b(this.bRj), new o(this.bRj), hVar, new com.baidu.live.view.web.a.c(), new k(), new l(this.context, this.bRj), new j()};
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
        this.bRj = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.bRk = fVar;
        return this;
    }

    public g bA(long j) {
        this.userId = j;
        return this;
    }

    public g jq(String str) {
        this.userName = str;
        return this;
    }

    public g dA(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bRm = hVar;
        return this;
    }

    public g bB(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bRl = alaLastLiveroomInfo;
        return this;
    }
}
