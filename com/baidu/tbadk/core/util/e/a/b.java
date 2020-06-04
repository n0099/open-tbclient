package com.baidu.tbadk.core.util.e.a;

import android.content.res.ColorStateList;
import android.support.annotation.ColorRes;
import android.widget.TextView;
/* loaded from: classes.dex */
public class b {
    private ColorStateList dQf;
    private int dQh;
    private int dQi;
    private int dQj;
    private int dQk;
    private int dQl;
    private int dQg = 1;
    private boolean dQm = false;
    private boolean dQn = false;
    private boolean dQo = false;
    private boolean dQp = false;

    public static b aVx() {
        return new b();
    }

    public b lk(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dQl = color;
        if (!this.dQm) {
            this.dQh = color;
        }
        if (!this.dQn) {
            this.dQj = color;
        }
        if (!this.dQo) {
            this.dQk = color;
        }
        if (!this.dQp) {
            this.dQi = color;
        }
        return this;
    }

    public b ll(@ColorRes int i) {
        this.dQj = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.dQn = true;
        return this;
    }

    public b lm(int i) {
        this.dQg = i;
        return this;
    }

    public void a(TextView textView) {
        if (textView != null) {
            aVy();
            if (2 == this.dQg) {
                textView.setHintTextColor(this.dQf);
            } else {
                textView.setTextColor(this.dQf);
            }
        }
    }

    public ColorStateList aVy() {
        this.dQf = aVz();
        return this.dQf;
    }

    private ColorStateList aVz() {
        int[] iArr = new int[5];
        iArr[0] = this.dQm ? this.dQh : this.dQl;
        iArr[1] = this.dQn ? this.dQj : this.dQl;
        iArr[2] = this.dQo ? this.dQk : this.dQl;
        iArr[3] = this.dQp ? this.dQi : this.dQl;
        iArr[4] = this.dQl;
        return h(iArr);
    }

    private ColorStateList h(int[] iArr) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, new int[0]}, iArr);
    }
}
