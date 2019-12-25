package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.h;
import com.baidu.live.view.web.a.i;
import com.baidu.live.view.web.a.j;
/* loaded from: classes2.dex */
public class f {
    private SchemeCallback aBx;
    private e aBy;
    private g aBz;
    private Activity context;
    private boolean isHost = false;
    private long userId;
    private String userName;

    public a[] yO() {
        r0[0].a(this.aBz);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        h hVar = new h();
        hVar.setUserId(this.userId);
        hVar.setUserName(this.userName);
        a[] aVarArr = {new i(this.context, this.aBx), dVar, new com.baidu.live.view.web.a.g(this.context), new com.baidu.live.view.web.a.f(this.aBx), hVar, new com.baidu.live.view.web.a.e(this.aBx), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.aBy), new com.baidu.live.view.web.a.b(this.aBx), new j(this.aBx)};
        return aVarArr;
    }

    public f x(Activity activity) {
        this.context = activity;
        return this;
    }

    public f a(SchemeCallback schemeCallback) {
        this.aBx = schemeCallback;
        return this;
    }

    public f a(e eVar) {
        this.aBy = eVar;
        return this;
    }

    public f K(long j) {
        this.userId = j;
        return this;
    }

    public f dY(String str) {
        this.userName = str;
        return this;
    }

    public f bm(boolean z) {
        this.isHost = z;
        return this;
    }

    public f b(g gVar) {
        this.aBz = gVar;
        return this;
    }
}
