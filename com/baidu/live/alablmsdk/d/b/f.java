package com.baidu.live.alablmsdk.d.b;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class f {
    private com.baidu.live.alablmsdk.c.b.e aAA;
    String aAy;
    String aAz;
    String mToken;

    public void a(com.baidu.live.alablmsdk.c.b.e eVar) {
        this.aAA = eVar;
    }

    public void ew(String str) {
        this.mToken = str;
    }

    public void setAppId(String str) {
        this.aAy = str;
    }

    public void fa(String str) {
        this.aAz = str;
    }

    public void b(com.baidu.live.alablmsdk.c.b.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.d("token-manager genTokenAsync: mCurAppId=" + this.aAy + " , mCurImUk=" + this.aAz);
        if (this.aAA != null) {
            if (zl() && zm()) {
                this.aAA.a(this.aAy, this.aAz, aVar);
            } else if (aVar != null) {
                aVar.ai("", "token-manager check appId|imUk error, appId=" + this.aAy + " , imUk=" + this.aAz);
            }
        }
    }

    public String getToken() {
        return this.mToken;
    }

    public void zk() {
        this.aAy = null;
        this.aAz = null;
        this.mToken = null;
    }

    private boolean zl() {
        return !TextUtils.isEmpty(this.aAy);
    }

    private boolean zm() {
        return !TextUtils.isEmpty(this.aAz);
    }
}
