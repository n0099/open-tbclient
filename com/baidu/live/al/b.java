package com.baidu.live.al;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements c {
    private static volatile b bOh;
    private c bOi;

    public static b Xh() {
        if (bOh == null) {
            bOh = new b();
        }
        return bOh;
    }

    private b() {
    }

    @Override // com.baidu.live.al.c
    public boolean isApplying() {
        if (this.bOi != null) {
            return this.bOi.isApplying();
        }
        return false;
    }

    @Override // com.baidu.live.al.c
    public boolean iV(String str) {
        if (this.bOi != null) {
            return this.bOi.iV(str);
        }
        return false;
    }

    @Override // com.baidu.live.al.c
    public boolean iW(String str) {
        if (this.bOi != null) {
            return this.bOi.iW(str);
        }
        return false;
    }

    @Override // com.baidu.live.al.c
    public boolean iX(String str) {
        if (this.bOi != null) {
            return this.bOi.iX(str);
        }
        return false;
    }

    @Override // com.baidu.live.al.c
    public AlaWheatInfoData iY(String str) {
        if (this.bOi != null) {
            return this.bOi.iY(str);
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public AlaWheatInfoData Xi() {
        if (this.bOi != null) {
            return this.bOi.Xi();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public void F(String str, boolean z) {
        if (this.bOi != null) {
            this.bOi.F(str, z);
        }
    }

    @Override // com.baidu.live.al.c
    public boolean iZ(String str) {
        if (this.bOi != null) {
            return this.bOi.iZ(str);
        }
        return false;
    }

    public void a(c cVar) {
        this.bOi = cVar;
    }

    @Override // com.baidu.live.al.c
    public void a(a aVar) {
        if (this.bOi != null) {
            this.bOi.a(aVar);
        }
    }

    @Override // com.baidu.live.al.c
    public List<AlaWheatInfoData> Xj() {
        if (this.bOi != null) {
            return this.bOi.Xj();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public List<AlaWheatInfoData> Xk() {
        if (this.bOi != null) {
            return this.bOi.Xk();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public String Xl() {
        if (this.bOi != null) {
            return this.bOi.Xl();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public String Xm() {
        if (this.bOi != null) {
            return this.bOi.Xm();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public String getCustomRoomId() {
        if (this.bOi != null) {
            return this.bOi.getCustomRoomId();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public w Xn() {
        if (this.bOi != null) {
            return this.bOi.Xn();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public String Xo() {
        if (this.bOi != null) {
            return this.bOi.Xo();
        }
        return null;
    }

    @Override // com.baidu.live.al.c
    public void muteOrUnmuteAudio(boolean z) {
        if (this.bOi != null) {
            this.bOi.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.live.al.c
    public void Xp() {
        if (this.bOi != null) {
            this.bOi.Xp();
        }
    }

    @Override // com.baidu.live.al.c
    public void Xq() {
        if (this.bOi != null) {
            this.bOi.Xq();
        }
    }
}
