package com.baidu.swan.pms.b.d;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
/* loaded from: classes2.dex */
public abstract class c {
    protected int bna;
    protected String mFrom = LivenessStat.TYPE_STRING_DEFAULT;

    public abstract int Si();

    public c jv(String str) {
        this.mFrom = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }
}
