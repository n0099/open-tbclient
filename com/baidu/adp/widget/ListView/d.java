package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
public class d {
    public int startX;
    public int startY;
    public int wr;
    public int ws;

    public d(int i, int i2, int i3, int i4) {
        this.startX = i;
        this.startY = i2;
        this.wr = i3;
        this.ws = i4;
    }

    public int l(float f) {
        return (int) (this.startY + (f / 2.5f));
    }
}
