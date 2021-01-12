package com.baidu.live.aq;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements b {
    private static volatile a bSz;
    private b bSA;

    public static a Wu() {
        if (bSz == null) {
            bSz = new a();
        }
        return bSz;
    }

    private a() {
    }

    @Override // com.baidu.live.aq.b
    public boolean isApplying() {
        if (this.bSA != null) {
            return this.bSA.isApplying();
        }
        return false;
    }

    @Override // com.baidu.live.aq.b
    public boolean ib(String str) {
        if (this.bSA != null) {
            return this.bSA.ib(str);
        }
        return false;
    }

    @Override // com.baidu.live.aq.b
    public boolean ic(String str) {
        if (this.bSA != null) {
            return this.bSA.ic(str);
        }
        return false;
    }

    @Override // com.baidu.live.aq.b
    public boolean id(String str) {
        if (this.bSA != null) {
            return this.bSA.id(str);
        }
        return false;
    }

    @Override // com.baidu.live.aq.b
    public AlaWheatInfoData ie(String str) {
        if (this.bSA != null) {
            return this.bSA.ie(str);
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public AlaWheatInfoData Wv() {
        if (this.bSA != null) {
            return this.bSA.Wv();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public void G(String str, boolean z) {
        if (this.bSA != null) {
            this.bSA.G(str, z);
        }
    }

    @Override // com.baidu.live.aq.b
    /* renamed from: if  reason: not valid java name */
    public boolean mo18if(String str) {
        if (this.bSA != null) {
            return this.bSA.mo18if(str);
        }
        return false;
    }

    public void a(b bVar) {
        this.bSA = bVar;
    }

    @Override // com.baidu.live.aq.b
    public List<AlaWheatInfoData> Ww() {
        if (this.bSA != null) {
            return this.bSA.Ww();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public List<AlaWheatInfoData> Wx() {
        if (this.bSA != null) {
            return this.bSA.Wx();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public String Wy() {
        if (this.bSA != null) {
            return this.bSA.Wy();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public String Wz() {
        if (this.bSA != null) {
            return this.bSA.Wz();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public String getCustomRoomId() {
        if (this.bSA != null) {
            return this.bSA.getCustomRoomId();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public x WA() {
        if (this.bSA != null) {
            return this.bSA.WA();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public String WB() {
        if (this.bSA != null) {
            return this.bSA.WB();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public void muteOrUnmuteAudio(boolean z) {
        if (this.bSA != null) {
            this.bSA.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.live.aq.b
    public void WC() {
        if (this.bSA != null) {
            this.bSA.WC();
        }
    }

    @Override // com.baidu.live.aq.b
    public void WD() {
        if (this.bSA != null) {
            this.bSA.WD();
        }
    }
}
