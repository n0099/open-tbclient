package com.baidu.minivideo.arface.bean;
/* loaded from: classes3.dex */
public class a {
    public boolean brc = true;
    public boolean brd = true;
    public boolean bre = true;
    public boolean brf = true;

    public void cI(boolean z) {
        this.brc = z;
    }

    public void cJ(boolean z) {
        this.brd = z;
    }

    public void cK(boolean z) {
        this.bre = z;
    }

    public void cL(boolean z) {
        this.brf = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bre == this.bre && ((a) obj).brf == this.brf && ((a) obj).brd == this.brd);
    }
}
