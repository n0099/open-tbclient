package com.baidu.live.aj;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements c {
    private static volatile b bIB;
    private c bIC;

    public static b UH() {
        if (bIB == null) {
            bIB = new b();
        }
        return bIB;
    }

    private b() {
    }

    @Override // com.baidu.live.aj.c
    public boolean UI() {
        if (this.bIC != null) {
            return this.bIC.UI();
        }
        return false;
    }

    @Override // com.baidu.live.aj.c
    public boolean iI(String str) {
        if (this.bIC != null) {
            return this.bIC.iI(str);
        }
        return false;
    }

    @Override // com.baidu.live.aj.c
    public boolean iJ(String str) {
        if (this.bIC != null) {
            return this.bIC.iJ(str);
        }
        return false;
    }

    @Override // com.baidu.live.aj.c
    public boolean iK(String str) {
        if (this.bIC != null) {
            return this.bIC.iK(str);
        }
        return false;
    }

    @Override // com.baidu.live.aj.c
    public AlaWheatInfoData iL(String str) {
        if (this.bIC != null) {
            return this.bIC.iL(str);
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public AlaWheatInfoData UJ() {
        if (this.bIC != null) {
            return this.bIC.UJ();
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public void F(String str, boolean z) {
        if (this.bIC != null) {
            this.bIC.F(str, z);
        }
    }

    @Override // com.baidu.live.aj.c
    public boolean iM(String str) {
        if (this.bIC != null) {
            return this.bIC.iM(str);
        }
        return false;
    }

    public void a(c cVar) {
        this.bIC = cVar;
    }

    @Override // com.baidu.live.aj.c
    public void a(a aVar) {
        if (this.bIC != null) {
            this.bIC.a(aVar);
        }
    }

    @Override // com.baidu.live.aj.c
    public List<AlaWheatInfoData> UK() {
        if (this.bIC != null) {
            return this.bIC.UK();
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public List<AlaWheatInfoData> UL() {
        if (this.bIC != null) {
            return this.bIC.UL();
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public String UM() {
        if (this.bIC != null) {
            return this.bIC.UM();
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public String UN() {
        if (this.bIC != null) {
            return this.bIC.UN();
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public String getCustomRoomId() {
        if (this.bIC != null) {
            return this.bIC.getCustomRoomId();
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public w UO() {
        if (this.bIC != null) {
            return this.bIC.UO();
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public String UP() {
        if (this.bIC != null) {
            return this.bIC.UP();
        }
        return null;
    }

    @Override // com.baidu.live.aj.c
    public void muteOrUnmuteAudio(boolean z) {
        if (this.bIC != null) {
            this.bIC.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.live.aj.c
    public void UQ() {
        if (this.bIC != null) {
            this.bIC.UQ();
        }
    }

    @Override // com.baidu.live.aj.c
    public void UR() {
        if (this.bIC != null) {
            this.bIC.UR();
        }
    }
}
