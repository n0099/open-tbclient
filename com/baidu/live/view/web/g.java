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
import com.baidu.live.view.web.a.p;
import com.baidu.live.view.web.a.q;
import com.baidu.live.view.web.a.r;
import com.baidu.live.view.web.a.s;
import com.baidu.live.view.web.a.t;
import com.baidu.live.view.web.a.u;
import com.baidu.live.view.web.a.v;
import com.baidu.live.view.web.a.w;
import com.baidu.live.view.web.a.x;
import com.baidu.live.view.web.a.y;
/* loaded from: classes10.dex */
public class g {
    private h bXA;
    private f bXy;
    private AlaLastLiveroomInfo bXz;
    private BaseActivity baseActivity;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private SchemeCallback schemeCallback;
    private long userId;
    private String userName;

    public a[] Yb() {
        r0[0].a(this.bXA);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i();
        iVar.setHost(this.isHost);
        iVar.b(this.bXz);
        q qVar = new q(this.context);
        qVar.setHost(this.isHost);
        u uVar = new u();
        uVar.setActivityContext(this.context);
        uVar.setUserId(this.userId);
        uVar.setUserName(this.userName);
        uVar.setLiveId(this.liveId);
        p pVar = new p(this.schemeCallback);
        pVar.b(this.baseActivity);
        com.baidu.live.view.web.a.a aVar = new com.baidu.live.view.web.a.a();
        aVar.setHost(this.isHost);
        aVar.b(this.bXz);
        com.baidu.live.view.web.a.b bVar = new com.baidu.live.view.web.a.b(this.context);
        bVar.setHost(this.isHost);
        a[] aVarArr = {new x(this.context, this.schemeCallback), iVar, qVar, new o(this.schemeCallback), uVar, new k(this.schemeCallback), new com.baidu.live.view.web.a.g(), new com.baidu.live.view.web.a.c(this.bXy), new com.baidu.live.view.web.a.d(this.schemeCallback), new y(this.schemeCallback), pVar, new com.baidu.live.view.web.a.f(), new s(), aVar, bVar, new t(this.context, this.schemeCallback), new r(), new m(), new com.baidu.live.view.web.a.h(), new w(this.schemeCallback), new n(), new com.baidu.live.view.web.a.e(), new v(this.schemeCallback), new j(this.schemeCallback), new l()};
        return aVarArr;
    }

    public g t(Activity activity) {
        this.context = activity;
        return this;
    }

    public g a(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        return this;
    }

    public g a(SchemeCallback schemeCallback) {
        this.schemeCallback = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.bXy = fVar;
        return this;
    }

    public g bE(long j) {
        this.userId = j;
        return this;
    }

    public g iE(String str) {
        this.userName = str;
        return this;
    }

    public g dH(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bXA = hVar;
        return this;
    }

    public g bF(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bXz = alaLastLiveroomInfo;
        return this;
    }
}
