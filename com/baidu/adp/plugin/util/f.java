package com.baidu.adp.plugin.util;

import com.baidu.ar.util.SystemInfoUtil;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Jo;
    int Jp;
    int Jq;
    int Jr;
    int Js;
    int Jt;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Jo = i;
        this.Jp = i2;
        this.Jq = i3;
        this.Jr = i4;
        this.Js = i5;
        this.Jt = i6;
    }

    public String toString() {
        return this.Jo + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jp + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jq + " " + this.Jr + SystemInfoUtil.COLON + this.Js + SystemInfoUtil.COLON + this.Jt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Jo - fVar.Jo > 0) {
            return 1;
        }
        if (this.Jo - fVar.Jo < 0) {
            return -1;
        }
        if (this.Jp - fVar.Jp <= 0) {
            if (this.Jp - fVar.Jp < 0) {
                return -1;
            }
            if (this.Jq - fVar.Jq <= 0) {
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
                            return this.Jt - fVar.Jt < 0 ? -1 : 0;
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
