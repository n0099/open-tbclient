package com.baidu.live.ap;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements c {
    private static volatile b bRD;
    private c bRE;

    public static b YX() {
        if (bRD == null) {
            bRD = new b();
        }
        return bRD;
    }

    private b() {
    }

    @Override // com.baidu.live.ap.c
    public boolean isApplying() {
        if (this.bRE != null) {
            return this.bRE.isApplying();
        }
        return false;
    }

    @Override // com.baidu.live.ap.c
    public boolean jt(String str) {
        if (this.bRE != null) {
            return this.bRE.jt(str);
        }
        return false;
    }

    @Override // com.baidu.live.ap.c
    public boolean ju(String str) {
        if (this.bRE != null) {
            return this.bRE.ju(str);
        }
        return false;
    }

    @Override // com.baidu.live.ap.c
    public boolean jv(String str) {
        if (this.bRE != null) {
            return this.bRE.jv(str);
        }
        return false;
    }

    @Override // com.baidu.live.ap.c
    public AlaWheatInfoData jw(String str) {
        if (this.bRE != null) {
            return this.bRE.jw(str);
        }
        return null;
    }

    @Override // com.baidu.live.ap.c
    public AlaWheatInfoData YY() {
        if (this.bRE != null) {
            return this.bRE.YY();
        }
        return null;
    }

    @Override // com.baidu.live.ap.c
    public void G(String str, boolean z) {
        if (this.bRE != null) {
            this.bRE.G(str, z);
        }
    }

    @Override // com.baidu.live.ap.c
    public boolean jx(String str) {
        if (this.bRE != null) {
            return this.bRE.jx(str);
        }
        return false;
    }

    public void a(c cVar) {
        this.bRE = cVar;
    }

    @Override // com.baidu.live.ap.c
    public void a(a aVar) {
        if (this.bRE != null) {
            this.bRE.a(aVar);
        }
    }

    @Override // com.baidu.live.ap.c
    public List<AlaWheatInfoData> YZ() {
        if (this.bRE != null) {
            return this.bRE.YZ();
        }
        return null;
    }

    @Override // com.baidu.live.ap.c
    public List<AlaWheatInfoData> Za() {
        if (this.bRE != null) {
            return this.bRE.Za();
        }
        return null;
    }

    @Override // com.baidu.live.ap.c
    public String Zb() {
        if (this.bRE != null) {
            return this.bRE.Zb();
        }
        return null;
    }

    @Override // com.baidu.live.ap.c
    public String Zc() {
        if (this.bRE != null) {
            return this.bRE.Zc();
        }
        return null;
    }

    @Override // com.baidu.live.ap.c
    public String getCustomRoomId() {
        if (this.bRE != null) {
            return this.bRE.getCustomRoomId();
        }
        return null;
    }

    @Override // com.baidu.live.ap.c
    public w Zd() {
        if (this.bRE != null) {
            return this.bRE.Zd();
        }
        return null;
    }

    @Override // com.baidu.live.ap.c
    public String Ze() {
        if (this.bRE != null) {
            return this.bRE.Ze();
        }
        return null;
    }

    @Override // com.baidu.live.ap.c
    public void muteOrUnmuteAudio(boolean z) {
        if (this.bRE != null) {
            this.bRE.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.live.ap.c
    public void Zf() {
        if (this.bRE != null) {
            this.bRE.Zf();
        }
    }

    @Override // com.baidu.live.ap.c
    public void Zg() {
        if (this.bRE != null) {
            this.bRE.Zg();
        }
    }
}
