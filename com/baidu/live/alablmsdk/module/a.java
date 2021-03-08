package com.baidu.live.alablmsdk.module;

import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    public long azK;
    public d azL;
    public String roomId;
    public String token = "";
    public String rtcAppId = "";
    public List<d> azM = new CopyOnWriteArrayList();

    public UserPermission yt() {
        return (this.azL == null || this.azL.azT == null || this.azL.azT.azP == null) ? UserPermission.UNKNOWN : this.azL.azT.azP;
    }

    public boolean yu() {
        if (this.azL != null) {
            return this.azL.yH();
        }
        return false;
    }

    public String yv() {
        StringBuilder sb = new StringBuilder();
        sb.append("roomId=").append(this.roomId).append(" , token=").append(this.token).append(" , rtcAppId=").append(this.rtcAppId).append(" , imUk=").append(this.azK).append(" othersImUk(对方的)=");
        synchronized (this.azM) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azM)) {
                for (int i = 0; i < this.azM.size(); i++) {
                    d dVar = this.azM.get(i);
                    if (dVar != null && dVar.azT != null) {
                        sb.append(" other").append(i).append("=").append(dVar.azT.azK);
                    }
                }
            }
        }
        return sb.toString();
    }

    public boolean aA(long j) {
        return (j == 0 || this.azL == null || this.azL.azT == null || this.azL.azT.azK != j) ? false : true;
    }

    public BLMSignalState yw() {
        return this.azL != null ? this.azL.yw() : BLMSignalState.DEFAULT;
    }

    public List<c> yx() {
        c cVar;
        c clone;
        if (com.baidu.live.alablmsdk.a.a.isEmpty(this.azM)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.azM.size()) {
                return arrayList;
            }
            d dVar = this.azM.get(i2);
            if (dVar != null && (cVar = dVar.azT) != null && (clone = cVar.clone()) != null) {
                arrayList.add(clone);
            }
            i = i2 + 1;
        }
    }

    public void a(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.azT != null) {
            c cVar = dVar.azT;
            if (cVar.azK != 0 && cVar.azK != 0) {
                synchronized (this.azM) {
                    d aC = aC(cVar.azK);
                    if (aC == null) {
                        this.azM.add(dVar);
                    } else {
                        aC.b(dVar, bLMStateType);
                        aC.a(dVar);
                    }
                }
            }
        }
    }

    public void h(c cVar) {
        c aD;
        if (cVar != null && cVar.azK != 0 && (aD = aD(cVar.azK)) != null) {
            aD.order = cVar.order;
        }
    }

    public void aB(long j) {
        com.baidu.live.alablmsdk.a.b.a.ag(" remote other user state info , imUk=" + j, "");
        if (j != 0 && j != 0) {
            synchronized (this.azM) {
                d aC = aC(j);
                if (aC != null) {
                    aC.release();
                    this.azM.remove(aC);
                }
            }
        }
    }

    public void u(List<c> list) {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.a.ag(" remove other list : before  , list size=" + list.size(), "");
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
                                if (cVar == null || cVar.azK == 0 || dVar.yF() != cVar.azK) {
                                    i2++;
                                } else {
                                    dVar.release();
                                    this.azM.remove(dVar);
                                    com.baidu.live.alablmsdk.a.b.a.ag(" remove other user ", "");
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.ag(" remove other list : after , list size=" + list.size(), "");
            }
        }
    }

    public boolean yy() {
        boolean z;
        synchronized (this.azM) {
            z = com.baidu.live.alablmsdk.a.a.isEmpty(this.azM);
        }
        return z;
    }

    public d aC(long j) {
        synchronized (this.azM) {
            if (j != 0 && j != 0) {
                if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azM)) {
                    int size = this.azM.size();
                    for (int i = 0; i < size; i++) {
                        d dVar = this.azM.get(i);
                        if (dVar != null && dVar.azT != null && dVar.azT.azK == j) {
                            return dVar;
                        }
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public c aD(long j) {
        d aC;
        if (j == 0 || (aC = aC(j)) == null) {
            return null;
        }
        return aC.azT;
    }

    public c yz() {
        if (this.azL == null || this.azL.azT == null) {
            return null;
        }
        return this.azL.azT;
    }

    public boolean aE(long j) {
        boolean z;
        synchronized (this.azM) {
            z = aC(j) != null;
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
        d aC = aC(j);
        if (aC != null) {
            aC.b(bLMSignalState);
        }
    }

    public void yA() {
        if (this.azL != null && this.azL.azU != null) {
            this.azL.azU.cancelTimer();
        }
    }

    public void yB() {
        synchronized (this.azM) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azM)) {
                for (int i = 0; i < this.azM.size(); i++) {
                    d dVar = this.azM.get(i);
                    if (dVar != null && dVar.azU != null) {
                        dVar.azU.cancelTimer();
                    }
                }
            }
        }
    }
}
