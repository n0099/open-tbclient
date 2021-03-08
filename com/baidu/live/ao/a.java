package com.baidu.live.ao;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements b {
    private static volatile a bYb;
    private b bYc;

    public static a Ym() {
        if (bYb == null) {
            bYb = new a();
        }
        return bYb;
    }

    private a() {
    }

    @Override // com.baidu.live.ao.b
    public boolean isApplying() {
        if (this.bYc != null) {
            return this.bYc.isApplying();
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean iN(String str) {
        if (this.bYc != null) {
            return this.bYc.iN(str);
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean Yn() {
        if (this.bYc != null) {
            return this.bYc.Yn();
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean iO(String str) {
        if (this.bYc != null) {
            return this.bYc.iO(str);
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public boolean iP(String str) {
        if (this.bYc != null) {
            return this.bYc.iP(str);
        }
        return false;
    }

    @Override // com.baidu.live.ao.b
    public AlaWheatInfoData iQ(String str) {
        if (this.bYc != null) {
            return this.bYc.iQ(str);
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public AlaWheatInfoData Yo() {
        if (this.bYc != null) {
            return this.bYc.Yo();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public void G(String str, boolean z) {
        if (this.bYc != null) {
            this.bYc.G(str, z);
        }
    }

    @Override // com.baidu.live.ao.b
    public boolean iR(String str) {
        if (this.bYc != null) {
            return this.bYc.iR(str);
        }
        return false;
    }

    public void a(b bVar) {
        this.bYc = bVar;
    }

    @Override // com.baidu.live.ao.b
    public List<AlaWheatInfoData> Yp() {
        if (this.bYc != null) {
            return this.bYc.Yp();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public List<AlaWheatInfoData> Yq() {
        if (this.bYc != null) {
            return this.bYc.Yq();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public String Yr() {
        if (this.bYc != null) {
            return this.bYc.Yr();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public String Ys() {
        if (this.bYc != null) {
            return this.bYc.Ys();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public String getCustomRoomId() {
        if (this.bYc != null) {
            return this.bYc.getCustomRoomId();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public ab Yt() {
        if (this.bYc != null) {
            return this.bYc.Yt();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public String Yu() {
        if (this.bYc != null) {
            return this.bYc.Yu();
        }
        return null;
    }

    @Override // com.baidu.live.ao.b
    public void muteOrUnmuteAudio(boolean z) {
        if (this.bYc != null) {
            this.bYc.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.live.ao.b
    public void Yv() {
        if (this.bYc != null) {
            this.bYc.Yv();
        }
    }

    @Override // com.baidu.live.ao.b
    public void Yw() {
        if (this.bYc != null) {
            this.bYc.Yw();
        }
    }
}
