package com.baidu.tbadk.core.util.e.a;

import android.content.res.ColorStateList;
import android.support.annotation.ColorRes;
import android.widget.TextView;
/* loaded from: classes.dex */
public class b {
    private ColorStateList dBY;
    private int dCa;
    private int dCb;
    private int dCc;
    private int dCd;
    private int dCe;
    private int dBZ = 1;
    private boolean dCf = false;
    private boolean dCg = false;
    private boolean dCh = false;
    private boolean dCi = false;

    public static b aPs() {
        return new b();
    }

    public b kG(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCe = color;
        if (!this.dCf) {
            this.dCa = color;
        }
        if (!this.dCg) {
            this.dCc = color;
        }
        if (!this.dCh) {
            this.dCd = color;
        }
        if (!this.dCi) {
            this.dCb = color;
        }
        return this;
    }

    public b kH(@ColorRes int i) {
        this.dCc = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCg = true;
        return this;
    }

    public b kI(int i) {
        this.dBZ = i;
        return this;
    }

    public void a(TextView textView) {
        if (textView != null) {
            aPt();
            if (2 == this.dBZ) {
                textView.setHintTextColor(this.dBY);
            } else {
                textView.setTextColor(this.dBY);
            }
        }
    }

    public ColorStateList aPt() {
        this.dBY = aPu();
        return this.dBY;
    }

    private ColorStateList aPu() {
        int[] iArr = new int[5];
        iArr[0] = this.dCf ? this.dCa : this.dCe;
        iArr[1] = this.dCg ? this.dCc : this.dCe;
        iArr[2] = this.dCh ? this.dCd : this.dCe;
        iArr[3] = this.dCi ? this.dCb : this.dCe;
        iArr[4] = this.dCe;
        return h(iArr);
    }

    private ColorStateList h(int[] iArr) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, new int[0]}, iArr);
    }
}
