package com.baidu.live.view.web;

import android.app.Activity;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.view.web.a.j;
/* loaded from: classes3.dex */
public class g {
    private SchemeCallback bcF;
    private f bcG;
    private h bcH;
    private Activity context;
    private boolean isHost = false;
    private long liveId;
    private long userId;
    private String userName;

    public a[] HM() {
        r0[0].a(this.bcH);
        com.baidu.live.view.web.a.d dVar = new com.baidu.live.view.web.a.d();
        dVar.setHost(this.isHost);
        com.baidu.live.view.web.a.g gVar = new com.baidu.live.view.web.a.g(this.context);
        gVar.setHost(this.isHost);
        com.baidu.live.view.web.a.h hVar = new com.baidu.live.view.web.a.h();
        hVar.v(this.context);
        hVar.setUserId(this.userId);
        hVar.setUserName(this.userName);
        hVar.setLiveId(this.liveId);
        a[] aVarArr = {new com.baidu.live.view.web.a.i(this.context, this.bcF), dVar, gVar, new com.baidu.live.view.web.a.f(this.bcF), hVar, new com.baidu.live.view.web.a.e(this.bcF), new com.baidu.live.view.web.a.c(), new com.baidu.live.view.web.a.a(this.bcG), new com.baidu.live.view.web.a.b(this.bcF), new j(this.bcF)};
        return aVarArr;
    }

    public g u(Activity activity) {
        this.context = activity;
        return this;
    }

    public g a(SchemeCallback schemeCallback) {
        this.bcF = schemeCallback;
        return this;
    }

    public g a(f fVar) {
        this.bcG = fVar;
        return this;
    }

    public g aw(long j) {
        this.userId = j;
        return this;
    }

    public g fi(String str) {
        this.userName = str;
        return this;
    }

    public g cj(boolean z) {
        this.isHost = z;
        return this;
    }

    public g b(h hVar) {
        this.bcH = hVar;
        return this;
    }

    public g ax(long j) {
        this.liveId = j;
        return this;
    }
}
