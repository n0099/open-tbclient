package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int Te;
    int Tf;
    int Tg;
    int Th;
    int Ti;
    int Tj;

    public final void d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.Te = i;
        this.Tf = i2;
        this.Tg = i3;
        this.Th = i4;
        this.Ti = i5;
        this.Tj = i6;
    }

    public String toString() {
        return this.Te + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tf + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.Tg + " " + this.Th + ":" + this.Ti + ":" + this.Tj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.Te - fVar.Te > 0) {
            return 1;
        }
        if (this.Te - fVar.Te < 0) {
            return -1;
        }
        if (this.Tf - fVar.Tf <= 0) {
            if (this.Tf - fVar.Tf < 0) {
                return -1;
            }
            if (this.Tg - fVar.Tg <= 0) {
                if (this.Tg - fVar.Tg < 0) {
                    return -1;
                }
                if (this.Th - fVar.Th <= 0) {
                    if (this.Th - fVar.Th < 0) {
                        return -1;
                    }
                    if (this.Ti - fVar.Ti <= 0) {
                        if (this.Ti - fVar.Ti < 0) {
                            return -1;
                        }
                        if (this.Tj - fVar.Tj <= 0) {
                            return this.Tj - fVar.Tj < 0 ? -1 : 0;
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
