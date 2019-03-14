package com.baidu.adp.plugin.util;

import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int MC;
    int MD;
    int ME;
    int MF;
    int MG;
    int MH;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.MC = i;
        this.MD = i2;
        this.ME = i3;
        this.MF = i4;
        this.MG = i5;
        this.MH = i6;
    }

    public String toString() {
        return this.MC + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.MD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ME + " " + this.MF + Config.TRACE_TODAY_VISIT_SPLIT + this.MG + Config.TRACE_TODAY_VISIT_SPLIT + this.MH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.MC - fVar.MC > 0) {
            return 1;
        }
        if (this.MC - fVar.MC < 0) {
            return -1;
        }
        if (this.MD - fVar.MD <= 0) {
            if (this.MD - fVar.MD < 0) {
                return -1;
            }
            if (this.ME - fVar.ME <= 0) {
                if (this.ME - fVar.ME < 0) {
                    return -1;
                }
                if (this.MF - fVar.MF <= 0) {
                    if (this.MF - fVar.MF < 0) {
                        return -1;
                    }
                    if (this.MG - fVar.MG <= 0) {
                        if (this.MG - fVar.MG < 0) {
                            return -1;
                        }
                        if (this.MH - fVar.MH <= 0) {
                            return this.MH - fVar.MH < 0 ? -1 : 0;
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
