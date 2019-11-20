package com.baidu.live.view.web;

import android.content.Context;
import com.baidu.live.tbadk.scheme.SchemeCallback;
/* loaded from: classes6.dex */
public class f {
    private SchemeCallback atB;
    private e atC;
    private g atD;
    private Context context;
    private boolean isHost = false;
    private long userId;
    private String userName;

    public a[] wP() {
        r0[0].a(this.atD);
        com.baidu.live.view.web.a.c cVar = new com.baidu.live.view.web.a.c();
        cVar.setHost(this.isHost);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g();
        gVar.setUserId(this.userId);
        gVar.setUserName(this.userName);
        a[] aVarArr = {new com.baidu.live.view.web.a.h(this.context, this.atB), cVar, new com.baidu.live.view.web.a.f(), new com.baidu.live.view.web.a.e(this.atB), gVar, new com.baidu.live.view.web.a.d(this.atB), new com.baidu.live.view.web.a.b(), new com.baidu.live.view.web.a.a(this.atC)};
        return aVarArr;
    }

    public f az(Context context) {
        this.context = context;
        return this;
    }

    public f a(SchemeCallback schemeCallback) {
        this.atB = schemeCallback;
        return this;
    }

    public f a(e eVar) {
        this.atC = eVar;
        return this;
    }

    public f I(long j) {
        this.userId = j;
        return this;
    }

    public f de(String str) {
        this.userName = str;
        return this;
    }

    public f aV(boolean z) {
        this.isHost = z;
        return this;
    }

    public f b(g gVar) {
        this.atD = gVar;
        return this;
    }
}
