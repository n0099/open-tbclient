package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.i;
import com.baidu.live.view.web.a.j;
/* loaded from: classes3.dex */
public class f {
    private SchemeCallback aGM;
    private e aGN;
    private g aGO;
    private Activity context;
    private boolean isHost = false;
    private long userId;
    private String userName;

    public a[] BJ() {
        r0[0].a(this.aGO);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g(this.context);
        gVar.setHost(this.isHost);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h();
        hVar.z(this.context);
        hVar.setUserId(this.userId);
        hVar.setUserName(this.userName);
        a[] aVarArr = {new i(this.context, this.aGM), dVar, gVar, new com.baidu.live.view.web.a.f(this.aGM), hVar, new com.baidu.live.view.web.a.e(this.aGM), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.aGN), new com.baidu.live.view.web.a.b(this.aGM), new j(this.aGM)};
        return aVarArr;
    }

    public f y(Activity activity) {
        this.context = activity;
        return this;
    }

    public f a(SchemeCallback schemeCallback) {
        this.aGM = schemeCallback;
        return this;
    }

    public f a(e eVar) {
        this.aGN = eVar;
        return this;
    }

    public f R(long j) {
        this.userId = j;
        return this;
    }

    public f eo(String str) {
        this.userName = str;
        return this;
    }

    public f bA(boolean z) {
        this.isHost = z;
        return this;
    }

    public f b(g gVar) {
        this.aGO = gVar;
        return this;
    }
}
