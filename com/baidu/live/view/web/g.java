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
/* loaded from: classes11.dex */
public class g {
    private f bWQ;
    private AlaLastLiveroomInfo bWR;
    private h bWS;
    private BaseActivity baseActivity;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private SchemeCallback schemeCallback;
    private long userId;
    private String userName;

    public a[] aae() {
        r0[0].a(this.bWS);
        com.baidu.live.view.web.a.i iVar = new com.baidu.live.view.web.a.i();
        iVar.setHost(this.isHost);
        iVar.b(this.bWR);
        p pVar = new p(this.context);
        pVar.setHost(this.isHost);
        t tVar = new t();
        tVar.setActivityContext(this.context);
        tVar.setUserId(this.userId);
        tVar.setUserName(this.userName);
        tVar.setLiveId(this.liveId);
        o oVar = new o(this.schemeCallback);
        oVar.b(this.baseActivity);
        com.baidu.live.view.web.a.a aVar = new com.baidu.live.view.web.a.a();
        aVar.setHost(this.isHost);
        aVar.b(this.bWR);
        com.baidu.live.view.web.a.b bVar = new com.baidu.live.view.web.a.b(this.context);
        bVar.setHost(this.isHost);
        a[] aVarArr = {new w(this.context, this.schemeCallback), iVar, pVar, new n(this.schemeCallback), tVar, new k(this.schemeCallback), new com.baidu.live.view.web.a.g(), new com.baidu.live.view.web.a.c(this.bWQ), new com.baidu.live.view.web.a.d(this.schemeCallback), new x(this.schemeCallback), oVar, new com.baidu.live.view.web.a.f(), new r(), aVar, bVar, new s(this.context, this.schemeCallback), new q(), new l(), new com.baidu.live.view.web.a.h(), new v(this.schemeCallback), new m(), new com.baidu.live.view.web.a.e(), new u(this.schemeCallback), new j(this.schemeCallback)};
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
        this.schemeCallback = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.bWQ = fVar;
        return this;
    }

    public g bA(long j) {
        this.userId = j;
        return this;
    }

    public g jj(String str) {
        this.userName = str;
        return this;
    }

    public g dD(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bWS = hVar;
        return this;
    }

    public g bB(long j) {
        this.liveId = j;
        return this;
    }

    public g a(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.bWR = alaLastLiveroomInfo;
        return this;
    }
}
