package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
public class d {
    public int Hi;
    public int Hj;
    public int startX;
    public int startY;

    public d(int i, int i2, int i3, int i4) {
        this.startX = i;
        this.startY = i2;
        this.Hi = i3;
        this.Hj = i4;
    }

    public int l(float f) {
        return (int) (this.startY + (f / 2.5f));
    }
}
