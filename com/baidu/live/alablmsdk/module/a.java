package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    public long aCG;
    public d aCH;
    public String roomId;
    public String token = "";
    public String rtcAppId = "";
    public List<d> aCI = new CopyOnWriteArrayList();

    public UserPermission BY() {
        return (this.aCH == null || this.aCH.aCP == null || this.aCH.aCP.aCL == null) ? UserPermission.UNKNOWN : this.aCH.aCP.aCL;
    }

    public boolean BZ() {
        if (this.aCH != null) {
            return this.aCH.Cl();
        }
        return false;
    }

    public String Ca() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.aCI) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCI)) {
                for (int i = 0; i < this.aCI.size(); i++) {
                    d dVar = this.aCI.get(i);
                    if (dVar != null && dVar.aCP != null) {
                        sb.append(" other").append(i).append("=").append(dVar.aCP.aCG);
                    }
                }
            }
        }
        return "roomId=" + this.roomId + " , token=" + this.token + " , rtcAppId=" + this.rtcAppId + " , imUk=" + this.aCG + " othersImUk(对方的)=" + sb.toString();
    }

    public static boolean b(a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.roomId) || TextUtils.isEmpty(aVar.token) || TextUtils.isEmpty(aVar.rtcAppId) || aVar.aCG == 0) ? false : true;
    }

    public boolean aw(long j) {
        return (j == 0 || this.aCH == null || this.aCH.aCP == null || this.aCH.aCP.aCG != j) ? false : true;
    }

    public BLMSignalState Cb() {
        return this.aCH != null ? this.aCH.Cb() : BLMSignalState.DEFAULT;
    }

    public void a(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.aCP != null) {
            c cVar = dVar.aCP;
            if (cVar.aCG != 0 && cVar.aCG != 0) {
                synchronized (this.aCI) {
                    d ay = ay(cVar.aCG);
                    if (ay == null) {
                        this.aCI.add(dVar);
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
        com.baidu.live.alablmsdk.module.a.b fP;
        if (j != 0 && !TextUtils.isEmpty(str) && (az = az(j)) != null && (fP = com.baidu.live.alablmsdk.module.a.b.fP(str)) != null && fP.aCG != 0 && fP.aCG == az.aCG) {
            az.order = fP.order;
        }
    }

    public void ax(long j) {
        com.baidu.live.alablmsdk.a.b.a.aj(" remote other user state info , imUk=" + j, "");
        if (j != 0 && j != 0) {
            synchronized (this.aCI) {
                d ay = ay(j);
                if (ay != null) {
                    ay.release();
                    this.aCI.remove(ay);
                }
            }
        }
    }

    public void u(List<c> list) {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.a.aj(" remove other list : before  , list size=" + list.size(), "");
            synchronized (this.aCI) {
                for (int i = 0; i < this.aCI.size(); i++) {
                    try {
                        d dVar = this.aCI.get(i);
                        if (dVar != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= list.size()) {
                                    break;
                                }
                                c cVar = list.get(i2);
                                if (cVar == null || cVar.aCG == 0 || dVar.Cj() != cVar.aCG) {
                                    i2++;
                                } else {
                                    dVar.release();
                                    this.aCI.remove(dVar);
                                    com.baidu.live.alablmsdk.a.b.a.aj(" remove other user ", "");
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.aj(" remove other list : after , list size=" + list.size(), "");
            }
        }
    }

    public boolean Cc() {
        boolean z;
        synchronized (this.aCI) {
            z = com.baidu.live.alablmsdk.a.a.isEmpty(this.aCI);
        }
        return z;
    }

    public d ay(long j) {
        synchronized (this.aCI) {
            if (j != 0 && j != 0) {
                if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCI)) {
                    int size = this.aCI.size();
                    for (int i = 0; i < size; i++) {
                        d dVar = this.aCI.get(i);
                        if (dVar != null && dVar.aCP != null && dVar.aCP.aCG == j) {
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
        return ay.aCP;
    }

    public c Cd() {
        if (this.aCH == null || this.aCH.aCP == null) {
            return null;
        }
        return this.aCH.aCP;
    }

    public boolean aA(long j) {
        boolean z;
        synchronized (this.aCI) {
            z = ay(j) != null;
        }
        return z;
    }

    public void a(BLMSignalState bLMSignalState) {
        if (this.aCH != null) {
            this.aCH.b(bLMSignalState);
        }
    }

    public void a(BLMRtcState bLMRtcState) {
        if (this.aCH != null) {
            this.aCH.b(bLMRtcState);
        }
    }

    public void a(long j, BLMSignalState bLMSignalState) {
        d ay = ay(j);
        if (ay != null) {
            ay.b(bLMSignalState);
        }
    }

    public void Ce() {
        if (this.aCH != null && this.aCH.aCQ != null) {
            this.aCH.aCQ.cancelTimer();
        }
    }

    public void Cf() {
        synchronized (this.aCI) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCI)) {
                for (int i = 0; i < this.aCI.size(); i++) {
                    d dVar = this.aCI.get(i);
                    if (dVar != null && dVar.aCQ != null) {
                        dVar.aCQ.cancelTimer();
                    }
                }
            }
        }
    }
}
