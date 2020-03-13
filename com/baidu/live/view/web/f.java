package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.i;
import com.baidu.live.view.web.a.j;
/* loaded from: classes3.dex */
public class f {
    private g aGA;
    private SchemeCallback aGy;
    private e aGz;
    private Activity context;
    private boolean isHost = false;
    private long userId;
    private String userName;

    public a[] BC() {
        r0[0].a(this.aGA);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g(this.context);
        gVar.setHost(this.isHost);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h();
        hVar.z(this.context);
        hVar.setUserId(this.userId);
        hVar.setUserName(this.userName);
        a[] aVarArr = {new i(this.context, this.aGy), dVar, gVar, new com.baidu.live.view.web.a.f(this.aGy), hVar, new com.baidu.live.view.web.a.e(this.aGy), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.aGz), new com.baidu.live.view.web.a.b(this.aGy), new j(this.aGy)};
        return aVarArr;
    }

    public f y(Activity activity) {
        this.context = activity;
        return this;
    }

    public f a(SchemeCallback schemeCallback) {
        this.aGy = schemeCallback;
        return this;
    }

    public f a(e eVar) {
        this.aGz = eVar;
        return this;
    }

    public f R(long j) {
        this.userId = j;
        return this;
    }

    public f ep(String str) {
        this.userName = str;
        return this;
    }

    public f bz(boolean z) {
        this.isHost = z;
        return this;
    }

    public f b(g gVar) {
        this.aGA = gVar;
        return this;
    }
}
