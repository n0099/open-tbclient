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
    private SchemeCallback byG;
    private f byH;
    private AlaLastLiveroomInfo byI;
    private h byJ;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] RE() {
        r0[0].a(this.byJ);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        dVar.b(this.byI);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h(this.context);
        hVar.setHost(this.isHost);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i();
        iVar.x(this.context);
        iVar.setUserId(this.userId);
        iVar.setUserName(this.userName);
        iVar.setLiveId(this.liveId);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g(this.byG);
        gVar.b(this.baseActivity);
        a[] aVarArr = {new j(this.context, this.byG), dVar, hVar, new com.baidu.live.view.web.a.f(this.byG), iVar, new com.baidu.live.view.web.a.e(this.byG), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.byH), new com.baidu.live.view.web.a.b(this.byG), new k(this.byG), gVar};
        return aVarArr;
    }

    public g w(Activity activity) {
        this.context = activity;
        return this;
    }

    public g a(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        return this;
    }

    public g a(SchemeCallback schemeCallback) {
        this.byG = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.byH = fVar;
        return this;
    }

    public g aC(long j) {
        this.userId = j;
        return this;
    }

    public g hT(String str) {
        this.userName = str;
        return this;
    }

    public g cN(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.byJ = hVar;
        return this;
    }

    public g aD(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.byI = alaLastLiveroomInfo;
        return this;
    }
}
