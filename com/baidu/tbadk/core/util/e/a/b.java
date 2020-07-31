package com.baidu.tbadk.core.util.e.a;

import android.content.res.ColorStateList;
import android.support.annotation.ColorRes;
import android.widget.TextView;
/* loaded from: classes.dex */
public class b {
    private ColorStateList eds;
    private int edu;
    private int edv;
    private int edw;
    private int edx;
    private int selectedColor;
    private int edt = 1;
    private boolean edy = false;
    private boolean edz = false;
    private boolean edA = false;
    private boolean edB = false;

    public static b bbs() {
        return new b();
    }

    public b lV(@ColorRes int i) {
        int color = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.edx = color;
        if (!this.edy) {
            this.edu = color;
        }
        if (!this.edz) {
            this.edw = color;
        }
        if (!this.edA) {
            this.selectedColor = color;
        }
        if (!this.edB) {
            this.edv = color;
        }
        return this;
    }

    public b lW(@ColorRes int i) {
        this.edw = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.edz = true;
        return this;
    }

    public b lX(int i) {
        this.edt = i;
        return this;
    }

    public void c(TextView textView) {
        if (textView != null) {
            bbt();
            if (2 == this.edt) {
                textView.setHintTextColor(this.eds);
            } else {
                textView.setTextColor(this.eds);
            }
        }
    }

    public ColorStateList bbt() {
        this.eds = bbu();
        return this.eds;
    }

    private ColorStateList bbu() {
        int[] iArr = new int[5];
        iArr[0] = this.edy ? this.edu : this.edx;
        iArr[1] = this.edz ? this.edw : this.edx;
        iArr[2] = this.edA ? this.selectedColor : this.edx;
        iArr[3] = this.edB ? this.edv : this.edx;
        iArr[4] = this.edx;
        return h(iArr);
    }

    private ColorStateList h(int[] iArr) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, new int[0]}, iArr);
    }
}
