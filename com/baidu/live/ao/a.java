package com.baidu.live.ao;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import java.util.List;
/* loaded from: classes11.dex */
public class a implements b {
    private static volatile a bWB;
    private b bWC;

    public static a Yj() {
        if (bWB == null) {
            bWB = new a();
        }
        return bWB;
    }

    private a() {
    }

    @Override // com.baidu.live.ao.b
    public boolean isApplying() {
        if (this.bWC != null) {
            return this.bWC.isApplying();
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean iH(String str) {
        if (this.bWC != null) {
            return this.bWC.iH(str);
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean Yk() {
        if (this.bWC != null) {
            return this.bWC.Yk();
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean iI(String str) {
        if (this.bWC != null) {
            return this.bWC.iI(str);
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean iJ(String str) {
        if (this.bWC != null) {
            return this.bWC.iJ(str);
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public AlaWheatInfoData iK(String str) {
        if (this.bWC != null) {
            return this.bWC.iK(str);
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public AlaWheatInfoData Yl() {
        if (this.bWC != null) {
            return this.bWC.Yl();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public void G(String str, boolean z) {
        if (this.bWC != null) {
            this.bWC.G(str, z);
        }
    }

    @Override // com.baidu.live.ao.b
    public boolean iL(String str) {
        if (this.bWC != null) {
            return this.bWC.iL(str);
        }
        return false;
    }

    public void a(b bVar) {
        this.bWC = bVar;
    }

    @Override // com.baidu.live.ao.b
    public List<AlaWheatInfoData> Ym() {
        if (this.bWC != null) {
            return this.bWC.Ym();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public List<AlaWheatInfoData> Yn() {
        if (this.bWC != null) {
            return this.bWC.Yn();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public String Yo() {
        if (this.bWC != null) {
            return this.bWC.Yo();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public String Yp() {
        if (this.bWC != null) {
            return this.bWC.Yp();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public String getCustomRoomId() {
        if (this.bWC != null) {
            return this.bWC.getCustomRoomId();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public ab Yq() {
        if (this.bWC != null) {
            return this.bWC.Yq();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public String Yr() {
        if (this.bWC != null) {
            return this.bWC.Yr();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public void muteOrUnmuteAudio(boolean z) {
        if (this.bWC != null) {
            this.bWC.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.live.ao.b
    public void Ys() {
        if (this.bWC != null) {
            this.bWC.Ys();
        }
    }

    @Override // com.baidu.live.ao.b
    public void Yt() {
        if (this.bWC != null) {
            this.bWC.Yt();
        }
    }
}
