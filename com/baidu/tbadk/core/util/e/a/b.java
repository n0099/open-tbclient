package com.baidu.tbadk.core.util.e.a;

import android.content.res.ColorStateList;
import android.support.annotation.ColorRes;
import android.widget.TextView;
/* loaded from: classes.dex */
public class b {
    private ColorStateList dWX;
    private int dWZ;
    private int dXa;
    private int dXb;
    private int dXc;
    private int dXd;
    private int dWY = 1;
    private boolean dXe = false;
    private boolean dXf = false;
    private boolean dXg = false;
    private boolean dXh = false;

    public static b aXr() {
        return new b();
    }

    public b lB(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dXd = color;
        if (!this.dXe) {
            this.dWZ = color;
        }
        if (!this.dXf) {
            this.dXb = color;
        }
        if (!this.dXg) {
            this.dXc = color;
        }
        if (!this.dXh) {
            this.dXa = color;
        }
        return this;
    }

    public b lC(@ColorRes int i) {
        this.dXb = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dXf = true;
        return this;
    }

    public b lD(int i) {
        this.dWY = i;
        return this;
    }

    public void a(TextView textView) {
        if (textView != null) {
            aXs();
            if (2 == this.dWY) {
                textView.setHintTextColor(this.dWX);
            } else {
                textView.setTextColor(this.dWX);
            }
        }
    }

    public ColorStateList aXs() {
        this.dWX = aXt();
        return this.dWX;
    }

    private ColorStateList aXt() {
        int[] iArr = new int[5];
        iArr[0] = this.dXe ? this.dWZ : this.dXd;
        iArr[1] = this.dXf ? this.dXb : this.dXd;
        iArr[2] = this.dXg ? this.dXc : this.dXd;
        iArr[3] = this.dXh ? this.dXa : this.dXd;
        iArr[4] = this.dXd;
        return h(iArr);
    }

    private ColorStateList h(int[] iArr) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, new int[0]}, iArr);
    }
}
