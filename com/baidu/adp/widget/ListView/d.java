package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
public class d {
    public int startX;
    public int startY;
    public int wo;
    public int wp;

    public d(int i, int i2, int i3, int i4) {
        this.startX = i;
        this.startY = i2;
        this.wo = i3;
        this.wp = i4;
    }

    public int l(float f) {
        return (int) (this.startY + (f / 2.5f));
    }
}
