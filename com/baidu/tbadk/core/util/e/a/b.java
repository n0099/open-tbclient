package com.baidu.tbadk.core.util.e.a;

import android.content.res.ColorStateList;
import android.support.annotation.ColorRes;
import android.widget.TextView;
/* loaded from: classes.dex */
public class b {
    private ColorStateList dBU;
    private int dBW;
    private int dBX;
    private int dBY;
    private int dBZ;
    private int dCa;
    private int dBV = 1;
    private boolean dCb = false;
    private boolean dCc = false;
    private boolean dCd = false;
    private boolean dCe = false;

    public static b aPv() {
        return new b();
    }

    public b kG(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCa = color;
        if (!this.dCb) {
            this.dBW = color;
        }
        if (!this.dCc) {
            this.dBY = color;
        }
        if (!this.dCd) {
            this.dBZ = color;
        }
        if (!this.dCe) {
            this.dBX = color;
        }
        return this;
    }

    public b kH(@ColorRes int i) {
        this.dBY = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dCc = true;
        return this;
    }

    public b kI(int i) {
        this.dBV = i;
        return this;
    }

    public void a(TextView textView) {
        if (textView != null) {
            aPw();
            if (2 == this.dBV) {
                textView.setHintTextColor(this.dBU);
            } else {
                textView.setTextColor(this.dBU);
            }
        }
    }

    public ColorStateList aPw() {
        this.dBU = aPx();
        return this.dBU;
    }

    private ColorStateList aPx() {
        int[] iArr = new int[5];
        iArr[0] = this.dCb ? this.dBW : this.dCa;
        iArr[1] = this.dCc ? this.dBY : this.dCa;
        iArr[2] = this.dCd ? this.dBZ : this.dCa;
        iArr[3] = this.dCe ? this.dBX : this.dCa;
        iArr[4] = this.dCa;
        return h(iArr);
    }

    private ColorStateList h(int[] iArr) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, new int[0]}, iArr);
    }
}
