package com.baidu.live.al;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements c {
    private static volatile b bMx;
    private c bMy;

    public static b Wy() {
        if (bMx == null) {
            bMx = new b();
        }
        return bMx;
    }

    private b() {
    }

    @Override // com.baidu.live.al.c
    public boolean isApplying() {
        if (this.bMy != null) {
            return this.bMy.isApplying();
        }
        return false;
    }

    @Override // com.baidu.live.al.c
    public boolean iP(String str) {
        if (this.bMy != null) {
            return this.bMy.iP(str);
        }
        return false;
    }

    @Override // com.baidu.live.al.c
    public boolean iQ(String str) {
        if (this.bMy != null) {
            return this.bMy.iQ(str);
        }
        return false;
    }

    @Override // com.baidu.live.al.c
    public boolean iR(String str) {
        if (this.bMy != null) {
            return this.bMy.iR(str);
        }
        return false;
    }

    @Override // com.baidu.live.al.c
    public AlaWheatInfoData iS(String str) {
        if (this.bMy != null) {
            return this.bMy.iS(str);
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public AlaWheatInfoData Wz() {
        if (this.bMy != null) {
            return this.bMy.Wz();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public void F(String str, boolean z) {
        if (this.bMy != null) {
            this.bMy.F(str, z);
        }
    }

    @Override // com.baidu.live.al.c
    public boolean iT(String str) {
        if (this.bMy != null) {
            return this.bMy.iT(str);
        }
        return false;
    }

    public void a(c cVar) {
        this.bMy = cVar;
    }

    @Override // com.baidu.live.al.c
    public void a(a aVar) {
        if (this.bMy != null) {
            this.bMy.a(aVar);
        }
    }

    @Override // com.baidu.live.al.c
    public List<AlaWheatInfoData> WA() {
        if (this.bMy != null) {
            return this.bMy.WA();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public List<AlaWheatInfoData> WB() {
        if (this.bMy != null) {
            return this.bMy.WB();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public String WC() {
        if (this.bMy != null) {
            return this.bMy.WC();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public String WD() {
        if (this.bMy != null) {
            return this.bMy.WD();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public String getCustomRoomId() {
        if (this.bMy != null) {
            return this.bMy.getCustomRoomId();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public w WE() {
        if (this.bMy != null) {
            return this.bMy.WE();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public String WF() {
        if (this.bMy != null) {
            return this.bMy.WF();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public void muteOrUnmuteAudio(boolean z) {
        if (this.bMy != null) {
            this.bMy.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.live.al.c
    public void WG() {
        if (this.bMy != null) {
            this.bMy.WG();
        }
    }

    @Override // com.baidu.live.al.c
    public void WH() {
        if (this.bMy != null) {
            this.bMy.WH();
        }
    }
}
