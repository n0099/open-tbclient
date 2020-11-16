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
    private SchemeCallback bMe;
    private f bMf;
    private AlaLastLiveroomInfo bMg;
    private h bMh;
    private BaseActivity baseActivity;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] Wo() {
        r0[0].a(this.bMh);
        com.baidu.live.view.web.a.e eVar = new com.baidu.live.view.web.a.e();
        eVar.setHost(this.isHost);
        eVar.b(this.bMg);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i(this.context);
        iVar.setHost(this.isHost);
        k kVar = new k();
        kVar.setActivityContext(this.context);
        kVar.setUserId(this.userId);
        kVar.setUserName(this.userName);
        kVar.setLiveId(this.liveId);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h(this.bMe);
        hVar.b(this.baseActivity);
        a[] aVarArr = {new l(this.context, this.bMe), eVar, iVar, new com.baidu.live.view.web.a.g(this.bMe), kVar, new com.baidu.live.view.web.a.f(this.bMe), new com.baidu.live.view.web.a.d(), new com.baidu.live.view.web.a.a(this.bMf), new com.baidu.live.view.web.a.b(this.bMe), new m(this.bMe), hVar, new com.baidu.live.view.web.a.c(), new j()};
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
        this.bMe = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.bMf = fVar;
        return this;
    }

    public g bc(long j) {
        this.userId = j;
        return this;
    }

    public g iM(String str) {
        this.userName = str;
        return this;
    }

    public g dm(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bMh = hVar;
        return this;
    }

    public g bd(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bMg = alaLastLiveroomInfo;
        return this;
    }
}
