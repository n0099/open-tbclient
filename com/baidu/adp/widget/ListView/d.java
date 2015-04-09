package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
public class d {
    public int Hs;
    public int Ht;
    public int startX;
    public int startY;

    public d(int i, int i2, int i3, int i4) {
        this.startX = i;
        this.startY = i2;
        this.Hs = i3;
        this.Ht = i4;
    }

    public int l(float f) {
        return (int) (this.startY + (f / 2.5f));
    }
}
