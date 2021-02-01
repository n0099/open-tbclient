package com.baidu.live.alablmsdk.module;

import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    public long ayk;
    public d ayl;
    public String roomId;
    public String token = "";
    public String rtcAppId = "";
    public List<d> aym = new CopyOnWriteArrayList();

    public UserPermission yq() {
        return (this.ayl == null || this.ayl.ayt == null || this.ayl.ayt.ayp == null) ? UserPermission.UNKNOWN : this.ayl.ayt.ayp;
    }

    public boolean yr() {
        if (this.ayl != null) {
            return this.ayl.yE();
        }
        return false;
    }

    public String ys() {
        StringBuilder sb = new StringBuilder();
        sb.append("roomId=").append(this.roomId).append(" , token=").append(this.token).append(" , rtcAppId=").append(this.rtcAppId).append(" , imUk=").append(this.ayk).append(" othersImUk(对方的)=");
        synchronized (this.aym) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aym)) {
                for (int i = 0; i < this.aym.size(); i++) {
                    d dVar = this.aym.get(i);
                    if (dVar != null && dVar.ayt != null) {
                        sb.append(" other").append(i).append("=").append(dVar.ayt.ayk);
                    }
                }
            }
        }
        return sb.toString();
    }

    public boolean aA(long j) {
        return (j == 0 || this.ayl == null || this.ayl.ayt == null || this.ayl.ayt.ayk != j) ? false : true;
    }

    public BLMSignalState yt() {
        return this.ayl != null ? this.ayl.yt() : BLMSignalState.DEFAULT;
    }

    public List<c> yu() {
        c cVar;
        c clone;
        if (com.baidu.live.alablmsdk.a.a.isEmpty(this.aym)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aym.size()) {
                return arrayList;
            }
            d dVar = this.aym.get(i2);
            if (dVar != null && (cVar = dVar.ayt) != null && (clone = cVar.clone()) != null) {
                arrayList.add(clone);
            }
            i = i2 + 1;
        }
    }

    public void a(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.ayt != null) {
            c cVar = dVar.ayt;
            if (cVar.ayk != 0 && cVar.ayk != 0) {
                synchronized (this.aym) {
                    d aC = aC(cVar.ayk);
                    if (aC == null) {
                        this.aym.add(dVar);
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
        if (cVar != null && cVar.ayk != 0 && (aD = aD(cVar.ayk)) != null) {
            aD.order = cVar.order;
        }
    }

    public void aB(long j) {
        com.baidu.live.alablmsdk.a.b.a.ag(" remote other user state info , imUk=" + j, "");
        if (j != 0 && j != 0) {
            synchronized (this.aym) {
                d aC = aC(j);
                if (aC != null) {
                    aC.release();
                    this.aym.remove(aC);
                }
            }
        }
    }

    public void u(List<c> list) {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.a.ag(" remove other list : before  , list size=" + list.size(), "");
            synchronized (this.aym) {
                for (int i = 0; i < this.aym.size(); i++) {
                    try {
                        d dVar = this.aym.get(i);
                        if (dVar != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= list.size()) {
                                    break;
                                }
                                c cVar = list.get(i2);
                                if (cVar == null || cVar.ayk == 0 || dVar.yC() != cVar.ayk) {
                                    i2++;
                                } else {
                                    dVar.release();
                                    this.aym.remove(dVar);
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

    public boolean yv() {
        boolean z;
        synchronized (this.aym) {
            z = com.baidu.live.alablmsdk.a.a.isEmpty(this.aym);
        }
        return z;
    }

    public d aC(long j) {
        synchronized (this.aym) {
            if (j != 0 && j != 0) {
                if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aym)) {
                    int size = this.aym.size();
                    for (int i = 0; i < size; i++) {
                        d dVar = this.aym.get(i);
                        if (dVar != null && dVar.ayt != null && dVar.ayt.ayk == j) {
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
        return aC.ayt;
    }

    public c yw() {
        if (this.ayl == null || this.ayl.ayt == null) {
            return null;
        }
        return this.ayl.ayt;
    }

    public boolean aE(long j) {
        boolean z;
        synchronized (this.aym) {
            z = aC(j) != null;
        }
        return z;
    }

    public void a(BLMSignalState bLMSignalState) {
        if (this.ayl != null) {
            this.ayl.b(bLMSignalState);
        }
    }

    public void a(BLMRtcState bLMRtcState) {
        if (this.ayl != null) {
            this.ayl.b(bLMRtcState);
        }
    }

    public void a(long j, BLMSignalState bLMSignalState) {
        d aC = aC(j);
        if (aC != null) {
            aC.b(bLMSignalState);
        }
    }

    public void yx() {
        if (this.ayl != null && this.ayl.ayu != null) {
            this.ayl.ayu.cancelTimer();
        }
    }

    public void yy() {
        synchronized (this.aym) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aym)) {
                for (int i = 0; i < this.aym.size(); i++) {
                    d dVar = this.aym.get(i);
                    if (dVar != null && dVar.ayu != null) {
                        dVar.ayu.cancelTimer();
                    }
                }
            }
        }
    }
}
