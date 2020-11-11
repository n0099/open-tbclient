package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class a {
    public long aBv;
    public d aBw;
    public String roomId;
    public String token = "";
    public String rtcAppId = "";
    public List<d> aBx = new CopyOnWriteArrayList();

    public UserPermission BI() {
        return (this.aBw == null || this.aBw.aBD == null || this.aBw.aBD.aBA == null) ? UserPermission.UNKNOWN : this.aBw.aBD.aBA;
    }

    public boolean BJ() {
        if (this.aBw != null) {
            return this.aBw.BV();
        }
        return false;
    }

    public String BK() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.aBx) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBx)) {
                for (int i = 0; i < this.aBx.size(); i++) {
                    d dVar = this.aBx.get(i);
                    if (dVar != null && dVar.aBD != null) {
                        sb.append(" other").append(i).append(ETAG.EQUAL).append(dVar.aBD.aBv);
                    }
                }
            }
        }
        return "roomId=" + this.roomId + " , token=" + this.token + " , rtcAppId=" + this.rtcAppId + " , imUk=" + this.aBv + " othersImUk(对方的)=" + sb.toString();
    }

    public static boolean b(a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.roomId) || TextUtils.isEmpty(aVar.token) || TextUtils.isEmpty(aVar.rtcAppId) || aVar.aBv == 0) ? false : true;
    }

    public boolean Z(long j) {
        return (j == 0 || this.aBw == null || this.aBw.aBD == null || this.aBw.aBD.aBv != j) ? false : true;
    }

    public void a(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.aBD != null) {
            c cVar = dVar.aBD;
            if (cVar.aBv != 0 && cVar.aBv != 0) {
                synchronized (this.aBx) {
                    d ab = ab(cVar.aBv);
                    if (ab == null) {
                        this.aBx.add(dVar);
                    } else {
                        ab.b(dVar, bLMStateType);
                        ab.a(dVar);
                    }
                }
            }
        }
    }

    public void c(long j, String str) {
        c ac;
        com.baidu.live.alablmsdk.module.a.b fP;
        if (j != 0 && !TextUtils.isEmpty(str) && (ac = ac(j)) != null && (fP = com.baidu.live.alablmsdk.module.a.b.fP(str)) != null && fP.aBv != 0 && fP.aBv == ac.aBv) {
            ac.order = fP.order;
        }
    }

    public void aa(long j) {
        com.baidu.live.alablmsdk.a.b.ah(" remote other user state info , imUk=" + j, "");
        if (j != 0 && j != 0) {
            synchronized (this.aBx) {
                d ab = ab(j);
                if (ab != null) {
                    ab.release();
                    this.aBx.remove(ab);
                }
            }
        }
    }

    public void t(List<c> list) {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.ah(" remove other list : before  , list size=" + list.size(), "");
            synchronized (this.aBx) {
                for (int i = 0; i < this.aBx.size(); i++) {
                    try {
                        d dVar = this.aBx.get(i);
                        if (dVar != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= list.size()) {
                                    break;
                                }
                                c cVar = list.get(i2);
                                if (cVar == null || cVar.aBv == 0 || dVar.BT() != cVar.aBv) {
                                    i2++;
                                } else {
                                    dVar.release();
                                    this.aBx.remove(dVar);
                                    com.baidu.live.alablmsdk.a.b.ah(" remove other user ", "");
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                com.baidu.live.alablmsdk.a.b.ah(" remove other list : after , list size=" + list.size(), "");
            }
        }
    }

    public boolean BL() {
        boolean z;
        synchronized (this.aBx) {
            z = com.baidu.live.alablmsdk.a.a.isEmpty(this.aBx);
        }
        return z;
    }

    public d ab(long j) {
        synchronized (this.aBx) {
            if (j != 0 && j != 0) {
                if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBx)) {
                    int size = this.aBx.size();
                    for (int i = 0; i < size; i++) {
                        d dVar = this.aBx.get(i);
                        if (dVar != null && dVar.aBD != null && dVar.aBD.aBv == j) {
                            return dVar;
                        }
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public c ac(long j) {
        d ab;
        if (j == 0 || (ab = ab(j)) == null) {
            return null;
        }
        return ab.aBD;
    }

    public c BM() {
        if (this.aBw == null || this.aBw.aBD == null) {
            return null;
        }
        return this.aBw.aBD;
    }

    public boolean ad(long j) {
        boolean z;
        synchronized (this.aBx) {
            z = ab(j) != null;
        }
        return z;
    }

    public void a(BLMSignalState bLMSignalState) {
        if (this.aBw != null) {
            this.aBw.b(bLMSignalState);
        }
    }

    public void a(BLMRtcState bLMRtcState) {
        if (this.aBw != null) {
            this.aBw.b(bLMRtcState);
        }
    }

    public void a(long j, BLMSignalState bLMSignalState) {
        d ab = ab(j);
        if (ab != null) {
            ab.b(bLMSignalState);
        }
    }

    public void BN() {
        if (this.aBw != null && this.aBw.aBE != null) {
            this.aBw.aBE.cancelTimer();
        }
    }

    public void BO() {
        synchronized (this.aBx) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBx)) {
                for (int i = 0; i < this.aBx.size(); i++) {
                    d dVar = this.aBx.get(i);
                    if (dVar != null && dVar.aBE != null) {
                        dVar.aBE.cancelTimer();
                    }
                }
            }
        }
    }
}
