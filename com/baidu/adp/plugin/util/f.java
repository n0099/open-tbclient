package com.baidu.adp.plugin.util;

import com.baidu.ar.util.SystemInfoUtil;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Jn;
    int Jo;
    int Jp;
    int Jq;
    int Jr;
    int Js;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Jn = i;
        this.Jo = i2;
        this.Jp = i3;
        this.Jq = i4;
        this.Jr = i5;
        this.Js = i6;
    }

    public String toString() {
        return this.Jn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jo + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Jp + " " + this.Jq + SystemInfoUtil.COLON + this.Jr + SystemInfoUtil.COLON + this.Js;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Jn - fVar.Jn > 0) {
            return 1;
        }
        if (this.Jn - fVar.Jn < 0) {
            return -1;
        }
        if (this.Jo - fVar.Jo <= 0) {
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
                            return this.Js - fVar.Js < 0 ? -1 : 0;
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
