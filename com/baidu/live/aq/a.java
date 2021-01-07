package com.baidu.live.aq;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import java.util.List;
/* loaded from: classes11.dex */
public class a implements b {
    private static volatile a bXl;
    private b bXm;

    public static a aan() {
        if (bXl == null) {
            bXl = new a();
        }
        return bXl;
    }

    private a() {
    }

    @Override // com.baidu.live.aq.b
    public boolean isApplying() {
        if (this.bXm != null) {
            return this.bXm.isApplying();
        }
        return false;
    }

    @Override // com.baidu.live.aq.b
    public boolean jm(String str) {
        if (this.bXm != null) {
            return this.bXm.jm(str);
        }
        return false;
    }

    @Override // com.baidu.live.aq.b
    public boolean jn(String str) {
        if (this.bXm != null) {
            return this.bXm.jn(str);
        }
        return false;
    }

    @Override // com.baidu.live.aq.b
    public boolean jo(String str) {
        if (this.bXm != null) {
            return this.bXm.jo(str);
        }
        return false;
    }

    @Override // com.baidu.live.aq.b
    public AlaWheatInfoData jp(String str) {
        if (this.bXm != null) {
            return this.bXm.jp(str);
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public AlaWheatInfoData aao() {
        if (this.bXm != null) {
            return this.bXm.aao();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public void G(String str, boolean z) {
        if (this.bXm != null) {
            this.bXm.G(str, z);
        }
    }

    @Override // com.baidu.live.aq.b
    public boolean jq(String str) {
        if (this.bXm != null) {
            return this.bXm.jq(str);
        }
        return false;
    }

    public void a(b bVar) {
        this.bXm = bVar;
    }

    @Override // com.baidu.live.aq.b
    public List<AlaWheatInfoData> aap() {
        if (this.bXm != null) {
            return this.bXm.aap();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public List<AlaWheatInfoData> aaq() {
        if (this.bXm != null) {
            return this.bXm.aaq();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public String aar() {
        if (this.bXm != null) {
            return this.bXm.aar();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public String aas() {
        if (this.bXm != null) {
            return this.bXm.aas();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public String getCustomRoomId() {
        if (this.bXm != null) {
            return this.bXm.getCustomRoomId();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public x aat() {
        if (this.bXm != null) {
            return this.bXm.aat();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public String aau() {
        if (this.bXm != null) {
            return this.bXm.aau();
        }
        return null;
    }

    @Override // com.baidu.live.aq.b
    public void muteOrUnmuteAudio(boolean z) {
        if (this.bXm != null) {
            this.bXm.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.live.aq.b
    public void aav() {
        if (this.bXm != null) {
            this.bXm.aav();
        }
    }

    @Override // com.baidu.live.aq.b
    public void aaw() {
        if (this.bXm != null) {
            this.bXm.aaw();
        }
    }
}
