package com.baidu.minivideo.arface.bean;
/* loaded from: classes11.dex */
public class a {
    public boolean bFD = true;
    public boolean bFE = true;
    public boolean bFF = true;
    public boolean bFG = true;

    public void cZ(boolean z) {
        this.bFD = z;
    }

    public void da(boolean z) {
        this.bFE = z;
    }

    public void db(boolean z) {
        this.bFF = z;
    }

    public void dc(boolean z) {
        this.bFG = z;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) || ((obj instanceof a) && ((a) obj).bFF == this.bFF && ((a) obj).bFG == this.bFG && ((a) obj).bFE == this.bFE);
    }
}
