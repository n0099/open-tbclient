package com.baidu.live.alablmsdk.d.b;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class f {
    String aBY;
    String aBZ;
    private com.baidu.live.alablmsdk.c.b.e aCa;
    String mToken;

    public void a(com.baidu.live.alablmsdk.c.b.e eVar) {
        this.aCa = eVar;
    }

    public void eD(String str) {
        this.mToken = str;
    }

    public void setAppId(String str) {
        this.aBY = str;
    }

    public void fg(String str) {
        this.aBZ = str;
    }

    public void b(com.baidu.live.alablmsdk.c.b.a aVar) {
        com.baidu.live.alablmsdk.a.b.a.d("token-manager genTokenAsync: mCurAppId=" + this.aBY + " , mCurImUk=" + this.aBZ);
        if (this.aCa != null) {
            if (zo() && zp()) {
                this.aCa.a(this.aBY, this.aBZ, aVar);
            } else if (aVar != null) {
                aVar.ai("", "token-manager check appId|imUk error, appId=" + this.aBY + " , imUk=" + this.aBZ);
            }
        }
    }

    public String getToken() {
        return this.mToken;
    }

    public void zn() {
        this.aBY = null;
        this.aBZ = null;
        this.mToken = null;
    }

    private boolean zo() {
        return !TextUtils.isEmpty(this.aBY);
    }

    private boolean zp() {
        return !TextUtils.isEmpty(this.aBZ);
    }
}
