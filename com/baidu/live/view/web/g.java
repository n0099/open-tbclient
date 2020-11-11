package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.j;
import com.baidu.live.view.web.a.k;
import com.baidu.live.view.web.a.l;
import com.baidu.live.view.web.a.m;
/* loaded from: classes4.dex */
public class g {
    private SchemeCallback bNO;
    private f bNP;
    private AlaLastLiveroomInfo bNQ;
    private h bNR;
    private BaseActivity baseActivity;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] WX() {
        r0[0].a(this.bNR);
        com.baidu.live.view.web.a.e eVar = new com.baidu.live.view.web.a.e();
        eVar.setHost(this.isHost);
        eVar.b(this.bNQ);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i(this.context);
        iVar.setHost(this.isHost);
        k kVar = new k();
        kVar.setActivityContext(this.context);
        kVar.setUserId(this.userId);
        kVar.setUserName(this.userName);
        kVar.setLiveId(this.liveId);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h(this.bNO);
        hVar.b(this.baseActivity);
        a[] aVarArr = {new l(this.context, this.bNO), eVar, iVar, new com.baidu.live.view.web.a.g(this.bNO), kVar, new com.baidu.live.view.web.a.f(this.bNO), new com.baidu.live.view.web.a.d(), new com.baidu.live.view.web.a.a(this.bNP), new com.baidu.live.view.web.a.b(this.bNO), new m(this.bNO), hVar, new com.baidu.live.view.web.a.c(), new j()};
        return aVarArr;
    }

    public g y(Activity activity) {
        this.context = activity;
        return this;
    }

    public g a(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        return this;
    }

    public g a(SchemeCallback schemeCallback) {
        this.bNO = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.bNP = fVar;
        return this;
    }

    public g bc(long j) {
        this.userId = j;
        return this;
    }

    public g iS(String str) {
        this.userName = str;
        return this;
    }

    public g dk(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bNR = hVar;
        return this;
    }

    public g bd(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bNQ = alaLastLiveroomInfo;
        return this;
    }
}
