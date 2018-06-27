package com.baidu.adp.plugin.util;

import com.baidu.ar.util.SystemInfoUtil;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Jq;
    int Jr;
    int Js;
    int Jt;
    int Ju;
    int Jv;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Jq = i;
        this.Jr = i2;
        this.Js = i3;
        this.Jt = i4;
        this.Ju = i5;
        this.Jv = i6;
    }

    public String toString() {
        return this.Jq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jr + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Js + " " + this.Jt + SystemInfoUtil.COLON + this.Ju + SystemInfoUtil.COLON + this.Jv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Jq - fVar.Jq > 0) {
            return 1;
        }
        if (this.Jq - fVar.Jq < 0) {
            return -1;
        }
        if (this.Jr - fVar.Jr <= 0) {
            if (this.Jr - fVar.Jr < 0) {
                return -1;
            }
            if (this.Js - fVar.Js <= 0) {
                if (this.Js - fVar.Js < 0) {
                    return -1;
                }
                if (this.Jt - fVar.Jt <= 0) {
                    if (this.Jt - fVar.Jt < 0) {
                        return -1;
                    }
                    if (this.Ju - fVar.Ju <= 0) {
                        if (this.Ju - fVar.Ju < 0) {
                            return -1;
                        }
                        if (this.Jv - fVar.Jv <= 0) {
                            return this.Jv - fVar.Jv < 0 ? -1 : 0;
                        }
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }
}
