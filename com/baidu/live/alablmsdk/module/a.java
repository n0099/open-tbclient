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
    public long azK;
    public d azL;
    public String roomId;
    public String token = "";
    public String rtcAppId = "";
    public List<d> azM = new CopyOnWriteArrayList();

    public UserPermission AZ() {
        return (this.azL == null || this.azL.azS == null || this.azL.azS.azP == null) ? UserPermission.UNKNOWN : this.azL.azS.azP;
    }

    public boolean Ba() {
        if (this.azL != null) {
            return this.azL.Bm();
        }
        return false;
    }

    public String Bb() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.azM) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azM)) {
                for (int i = 0; i < this.azM.size(); i++) {
                    d dVar = this.azM.get(i);
                    if (dVar != null && dVar.azS != null) {
                        sb.append(" other").append(i).append(ETAG.EQUAL).append(dVar.azS.azK);
                    }
                }
            }
        }
        return "roomId=" + this.roomId + " , token=" + this.token + " , rtcAppId=" + this.rtcAppId + " , imUk=" + this.azK + " othersImUk(对方的)=" + sb.toString();
    }

    public static boolean b(a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.roomId) || TextUtils.isEmpty(aVar.token) || TextUtils.isEmpty(aVar.rtcAppId) || aVar.azK == 0) ? false : true;
    }

    public boolean Z(long j) {
        return (j == 0 || this.azL == null || this.azL.azS == null || this.azL.azS.azK != j) ? false : true;
    }

    public void a(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.azS != null) {
            c cVar = dVar.azS;
            if (cVar.azK != 0 && cVar.azK != 0) {
                synchronized (this.azM) {
                    d ab = ab(cVar.azK);
                    if (ab == null) {
                        this.azM.add(dVar);
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
        com.baidu.live.alablmsdk.module.a.b fJ;
        if (j != 0 && !TextUtils.isEmpty(str) && (ac = ac(j)) != null && (fJ = com.baidu.live.alablmsdk.module.a.b.fJ(str)) != null && fJ.azK != 0 && fJ.azK == ac.azK) {
            ac.order = fJ.order;
        }
    }

    public void aa(long j) {
        com.baidu.live.alablmsdk.a.b.ag(" remote other user state info , imUk=" + j, "");
        if (j != 0 && j != 0) {
            synchronized (this.azM) {
                d ab = ab(j);
                if (ab != null) {
                    ab.release();
                    this.azM.remove(ab);
                }
            }
        }
    }

    public void t(List<c> list) {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.ag(" remove other list : before  , list size=" + list.size(), "");
            synchronized (this.azM) {
                for (int i = 0; i < this.azM.size(); i++) {
                    try {
                        d dVar = this.azM.get(i);
                        if (dVar != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= list.size()) {
                                    break;
                                }
                                c cVar = list.get(i2);
                                if (cVar == null || cVar.azK == 0 || dVar.Bk() != cVar.azK) {
                                    i2++;
                                } else {
                                    dVar.release();
                                    this.azM.remove(dVar);
                                    com.baidu.live.alablmsdk.a.b.ag(" remove other user ", "");
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                com.baidu.live.alablmsdk.a.b.ag(" remove other list : after , list size=" + list.size(), "");
            }
        }
    }

    public boolean Bc() {
        boolean z;
        synchronized (this.azM) {
            z = com.baidu.live.alablmsdk.a.a.isEmpty(this.azM);
        }
        return z;
    }

    public d ab(long j) {
        synchronized (this.azM) {
            if (j != 0 && j != 0) {
                if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azM)) {
                    int size = this.azM.size();
                    for (int i = 0; i < size; i++) {
                        d dVar = this.azM.get(i);
                        if (dVar != null && dVar.azS != null && dVar.azS.azK == j) {
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
        return ab.azS;
    }

    public c Bd() {
        if (this.azL == null || this.azL.azS == null) {
            return null;
        }
        return this.azL.azS;
    }

    public boolean ad(long j) {
        boolean z;
        synchronized (this.azM) {
            z = ab(j) != null;
        }
        return z;
    }

    public void a(BLMSignalState bLMSignalState) {
        if (this.azL != null) {
            this.azL.b(bLMSignalState);
        }
    }

    public void a(BLMRtcState bLMRtcState) {
        if (this.azL != null) {
            this.azL.b(bLMRtcState);
        }
    }

    public void a(long j, BLMSignalState bLMSignalState) {
        d ab = ab(j);
        if (ab != null) {
            ab.b(bLMSignalState);
        }
    }

    public void Be() {
        if (this.azL != null && this.azL.azT != null) {
            this.azL.azT.cancelTimer();
        }
    }

    public void Bf() {
        synchronized (this.azM) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azM)) {
                for (int i = 0; i < this.azM.size(); i++) {
                    d dVar = this.azM.get(i);
                    if (dVar != null && dVar.azT != null) {
                        dVar.azT.cancelTimer();
                    }
                }
            }
        }
    }
}
