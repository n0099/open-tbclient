package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.i;
import com.baidu.live.view.web.a.j;
/* loaded from: classes2.dex */
public class f {
    private SchemeCallback aCp;
    private e aCq;
    private g aCr;
    private Activity context;
    private boolean isHost = false;
    private long userId;
    private String userName;

    public a[] zk() {
        r0[0].a(this.aCr);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g(this.context);
        gVar.setHost(this.isHost);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h();
        hVar.y(this.context);
        hVar.setUserId(this.userId);
        hVar.setUserName(this.userName);
        a[] aVarArr = {new i(this.context, this.aCp), dVar, gVar, new com.baidu.live.view.web.a.f(this.aCp), hVar, new com.baidu.live.view.web.a.e(this.aCp), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.aCq), new com.baidu.live.view.web.a.b(this.aCp), new j(this.aCp)};
        return aVarArr;
    }

    public f x(Activity activity) {
        this.context = activity;
        return this;
    }

    public f a(SchemeCallback schemeCallback) {
        this.aCp = schemeCallback;
        return this;
    }

    public f a(e eVar) {
        this.aCq = eVar;
        return this;
    }

    public f N(long j) {
        this.userId = j;
        return this;
    }

    public f ea(String str) {
        this.userName = str;
        return this;
    }

    public f br(boolean z) {
        this.isHost = z;
        return this;
    }

    public f b(g gVar) {
        this.aCr = gVar;
        return this;
    }
}
