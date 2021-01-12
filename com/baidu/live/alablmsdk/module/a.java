package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    public long axT;
    public d axU;
    public String roomId;
    public String token = "";
    public String rtcAppId = "";
    public List<d> axV = new CopyOnWriteArrayList();

    public UserPermission yd() {
        return (this.axU == null || this.axU.ayc == null || this.axU.ayc.axY == null) ? UserPermission.UNKNOWN : this.axU.ayc.axY;
    }

    public boolean ye() {
        if (this.axU != null) {
            return this.axU.yq();
        }
        return false;
    }

    public String yf() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.axV) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.axV)) {
                for (int i = 0; i < this.axV.size(); i++) {
                    d dVar = this.axV.get(i);
                    if (dVar != null && dVar.ayc != null) {
                        sb.append(" other").append(i).append("=").append(dVar.ayc.axT);
                    }
                }
            }
        }
        return "roomId=" + this.roomId + " , token=" + this.token + " , rtcAppId=" + this.rtcAppId + " , imUk=" + this.axT + " othersImUk(对方的)=" + sb.toString();
    }

    public static boolean b(a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.roomId) || TextUtils.isEmpty(aVar.token) || TextUtils.isEmpty(aVar.rtcAppId) || aVar.axT == 0) ? false : true;
    }

    public boolean aw(long j) {
        return (j == 0 || this.axU == null || this.axU.ayc == null || this.axU.ayc.axT != j) ? false : true;
    }

    public BLMSignalState yg() {
        return this.axU != null ? this.axU.yg() : BLMSignalState.DEFAULT;
    }

    public void a(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.ayc != null) {
            c cVar = dVar.ayc;
            if (cVar.axT != 0 && cVar.axT != 0) {
                synchronized (this.axV) {
                    d ay = ay(cVar.axT);
                    if (ay == null) {
                        this.axV.add(dVar);
                    } else {
                        ay.b(dVar, bLMStateType);
                        ay.a(dVar);
                    }
                }
            }
        }
    }

    public void e(long j, String str) {
        c az;
        com.baidu.live.alablmsdk.module.a.b eE;
        if (j != 0 && !TextUtils.isEmpty(str) && (az = az(j)) != null && (eE = com.baidu.live.alablmsdk.module.a.b.eE(str)) != null && eE.axT != 0 && eE.axT == az.axT) {
            az.order = eE.order;
        }
    }

    public void ax(long j) {
        com.baidu.live.alablmsdk.a.b.a.ai(" remote other user state info , imUk=" + j, "");
        if (j != 0 && j != 0) {
            synchronized (this.axV) {
                d ay = ay(j);
                if (ay != null) {
                    ay.release();
                    this.axV.remove(ay);
                }
            }
        }
    }

    public void u(List<c> list) {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.a.ai(" remove other list : before  , list size=" + list.size(), "");
            synchronized (this.axV) {
                for (int i = 0; i < this.axV.size(); i++) {
                    try {
                        d dVar = this.axV.get(i);
                        if (dVar != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= list.size()) {
                                    break;
                                }
                                c cVar = list.get(i2);
                                if (cVar == null || cVar.axT == 0 || dVar.yo() != cVar.axT) {
                                    i2++;
                                } else {
                                    dVar.release();
                                    this.axV.remove(dVar);
                                    com.baidu.live.alablmsdk.a.b.a.ai(" remove other user ", "");
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.ai(" remove other list : after , list size=" + list.size(), "");
            }
        }
    }

    public boolean yh() {
        boolean z;
        synchronized (this.axV) {
            z = com.baidu.live.alablmsdk.a.a.isEmpty(this.axV);
        }
        return z;
    }

    public d ay(long j) {
        synchronized (this.axV) {
            if (j != 0 && j != 0) {
                if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.axV)) {
                    int size = this.axV.size();
                    for (int i = 0; i < size; i++) {
                        d dVar = this.axV.get(i);
                        if (dVar != null && dVar.ayc != null && dVar.ayc.axT == j) {
                            return dVar;
                        }
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public c az(long j) {
        d ay;
        if (j == 0 || (ay = ay(j)) == null) {
            return null;
        }
        return ay.ayc;
    }

    public c yi() {
        if (this.axU == null || this.axU.ayc == null) {
            return null;
        }
        return this.axU.ayc;
    }

    public boolean aA(long j) {
        boolean z;
        synchronized (this.axV) {
            z = ay(j) != null;
        }
        return z;
    }

    public void a(BLMSignalState bLMSignalState) {
        if (this.axU != null) {
            this.axU.b(bLMSignalState);
        }
    }

    public void a(BLMRtcState bLMRtcState) {
        if (this.axU != null) {
            this.axU.b(bLMRtcState);
        }
    }

    public void a(long j, BLMSignalState bLMSignalState) {
        d ay = ay(j);
        if (ay != null) {
            ay.b(bLMSignalState);
        }
    }

    public void yj() {
        if (this.axU != null && this.axU.ayd != null) {
            this.axU.ayd.cancelTimer();
        }
    }

    public void yk() {
        synchronized (this.axV) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.axV)) {
                for (int i = 0; i < this.axV.size(); i++) {
                    d dVar = this.axV.get(i);
                    if (dVar != null && dVar.ayd != null) {
                        dVar.ayd.cancelTimer();
                    }
                }
            }
        }
    }
}
