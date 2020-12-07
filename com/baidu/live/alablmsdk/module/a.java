package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class a {
    public long aCp;
    public d aCq;
    public String roomId;
    public String token = "";
    public String rtcAppId = "";
    public List<d> aCr = new CopyOnWriteArrayList();

    public UserPermission CH() {
        return (this.aCq == null || this.aCq.aCy == null || this.aCq.aCy.aCu == null) ? UserPermission.UNKNOWN : this.aCq.aCy.aCu;
    }

    public boolean CI() {
        if (this.aCq != null) {
            return this.aCq.CU();
        }
        return false;
    }

    public String CJ() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.aCr) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCr)) {
                for (int i = 0; i < this.aCr.size(); i++) {
                    d dVar = this.aCr.get(i);
                    if (dVar != null && dVar.aCy != null) {
                        sb.append(" other").append(i).append("=").append(dVar.aCy.aCp);
                    }
                }
            }
        }
        return "roomId=" + this.roomId + " , token=" + this.token + " , rtcAppId=" + this.rtcAppId + " , imUk=" + this.aCp + " othersImUk(对方的)=" + sb.toString();
    }

    public static boolean b(a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.roomId) || TextUtils.isEmpty(aVar.token) || TextUtils.isEmpty(aVar.rtcAppId) || aVar.aCp == 0) ? false : true;
    }

    public boolean ax(long j) {
        return (j == 0 || this.aCq == null || this.aCq.aCy == null || this.aCq.aCy.aCp != j) ? false : true;
    }

    public BLMSignalState CK() {
        return this.aCq != null ? this.aCq.CK() : BLMSignalState.DEFAULT;
    }

    public void a(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.aCy != null) {
            c cVar = dVar.aCy;
            if (cVar.aCp != 0 && cVar.aCp != 0) {
                synchronized (this.aCr) {
                    d az = az(cVar.aCp);
                    if (az == null) {
                        this.aCr.add(dVar);
                    } else {
                        az.b(dVar, bLMStateType);
                        az.a(dVar);
                    }
                }
            }
        }
    }

    public void e(long j, String str) {
        c aA;
        com.baidu.live.alablmsdk.module.a.b gf;
        if (j != 0 && !TextUtils.isEmpty(str) && (aA = aA(j)) != null && (gf = com.baidu.live.alablmsdk.module.a.b.gf(str)) != null && gf.aCp != 0 && gf.aCp == aA.aCp) {
            aA.order = gf.order;
        }
    }

    public void ay(long j) {
        com.baidu.live.alablmsdk.a.b.a.ak(" remote other user state info , imUk=" + j, "");
        if (j != 0 && j != 0) {
            synchronized (this.aCr) {
                d az = az(j);
                if (az != null) {
                    az.release();
                    this.aCr.remove(az);
                }
            }
        }
    }

    public void u(List<c> list) {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            com.baidu.live.alablmsdk.a.b.a.ak(" remove other list : before  , list size=" + list.size(), "");
            synchronized (this.aCr) {
                for (int i = 0; i < this.aCr.size(); i++) {
                    try {
                        d dVar = this.aCr.get(i);
                        if (dVar != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= list.size()) {
                                    break;
                                }
                                c cVar = list.get(i2);
                                if (cVar == null || cVar.aCp == 0 || dVar.CS() != cVar.aCp) {
                                    i2++;
                                } else {
                                    dVar.release();
                                    this.aCr.remove(dVar);
                                    com.baidu.live.alablmsdk.a.b.a.ak(" remove other user ", "");
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.ak(" remove other list : after , list size=" + list.size(), "");
            }
        }
    }

    public boolean CL() {
        boolean z;
        synchronized (this.aCr) {
            z = com.baidu.live.alablmsdk.a.a.isEmpty(this.aCr);
        }
        return z;
    }

    public d az(long j) {
        synchronized (this.aCr) {
            if (j != 0 && j != 0) {
                if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCr)) {
                    int size = this.aCr.size();
                    for (int i = 0; i < size; i++) {
                        d dVar = this.aCr.get(i);
                        if (dVar != null && dVar.aCy != null && dVar.aCy.aCp == j) {
                            return dVar;
                        }
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public c aA(long j) {
        d az;
        if (j == 0 || (az = az(j)) == null) {
            return null;
        }
        return az.aCy;
    }

    public c CM() {
        if (this.aCq == null || this.aCq.aCy == null) {
            return null;
        }
        return this.aCq.aCy;
    }

    public boolean aB(long j) {
        boolean z;
        synchronized (this.aCr) {
            z = az(j) != null;
        }
        return z;
    }

    public void a(BLMSignalState bLMSignalState) {
        if (this.aCq != null) {
            this.aCq.b(bLMSignalState);
        }
    }

    public void a(BLMRtcState bLMRtcState) {
        if (this.aCq != null) {
            this.aCq.b(bLMRtcState);
        }
    }

    public void a(long j, BLMSignalState bLMSignalState) {
        d az = az(j);
        if (az != null) {
            az.b(bLMSignalState);
        }
    }

    public void CN() {
        if (this.aCq != null && this.aCq.aCz != null) {
            this.aCq.aCz.cancelTimer();
        }
    }

    public void CO() {
        synchronized (this.aCr) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCr)) {
                for (int i = 0; i < this.aCr.size(); i++) {
                    d dVar = this.aCr.get(i);
                    if (dVar != null && dVar.aCz != null) {
                        dVar.aCz.cancelTimer();
                    }
                }
            }
        }
    }
}
