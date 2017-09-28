package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int EQ;
    int ER;
    int ES;
    int ET;
    int EU;
    int EV;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.EQ = i;
        this.ER = i2;
        this.ES = i3;
        this.ET = i4;
        this.EU = i5;
        this.EV = i6;
    }

    public String toString() {
        return this.EQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ER + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ES + " " + this.ET + ":" + this.EU + ":" + this.EV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.EQ - fVar.EQ > 0) {
            return 1;
        }
        if (this.EQ - fVar.EQ < 0) {
            return -1;
        }
        if (this.ER - fVar.ER <= 0) {
            if (this.ER - fVar.ER < 0) {
                return -1;
            }
            if (this.ES - fVar.ES <= 0) {
                if (this.ES - fVar.ES < 0) {
                    return -1;
                }
                if (this.ET - fVar.ET <= 0) {
                    if (this.ET - fVar.ET < 0) {
                        return -1;
                    }
                    if (this.EU - fVar.EU <= 0) {
                        if (this.EU - fVar.EU < 0) {
                            return -1;
                        }
                        if (this.EV - fVar.EV <= 0) {
                            return this.EV - fVar.EV < 0 ? -1 : 0;
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
