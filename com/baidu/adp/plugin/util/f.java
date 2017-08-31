package com.baidu.adp.plugin.util;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    int EO;
    int EP;
    int EQ;
    int ER;
    int ES;
    int ET;

    public final void set(int i, int i2, int i3, int i4, int i5, int i6) {
        this.EO = i;
        this.EP = i2;
        this.EQ = i3;
        this.ER = i4;
        this.ES = i5;
        this.ET = i6;
    }

    public String toString() {
        return this.EO + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.EP + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.EQ + " " + this.ER + ":" + this.ES + ":" + this.ET;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (this.EO - fVar.EO > 0) {
            return 1;
        }
        if (this.EO - fVar.EO < 0) {
            return -1;
        }
        if (this.EP - fVar.EP <= 0) {
            if (this.EP - fVar.EP < 0) {
                return -1;
            }
            if (this.EQ - fVar.EQ <= 0) {
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
                            return this.ET - fVar.ET < 0 ? -1 : 0;
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
