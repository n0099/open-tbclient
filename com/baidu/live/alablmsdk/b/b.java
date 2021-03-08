package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.a.a.b;
import com.baidu.live.alablmsdk.module.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements b.a {
    public com.baidu.live.alablmsdk.module.a azk;
    private List<Integer> azl;
    private List<com.baidu.live.alablmsdk.a.a.a> azm = new ArrayList();
    private int azn;
    private int azo;
    private a azp;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.live.alablmsdk.module.rtc.c cVar, int i);
    }

    public b(a aVar) {
        this.azp = aVar;
    }

    public void a(com.baidu.live.alablmsdk.module.a aVar) {
        this.azk = aVar;
    }

    public void x(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap != null && hashMap.containsKey("blm_rtc_stream_leaved_listen_seconds_key") && (obj = hashMap.get("blm_rtc_stream_leaved_listen_seconds_key")) != null) {
            this.azl = (List) obj;
            Collections.sort(this.azl);
            Collections.reverse(this.azl);
            xY();
            xZ();
        }
    }

    public void xY() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azl)) {
            for (int i = 0; i < this.azl.size(); i++) {
                com.baidu.live.alablmsdk.a.a.a aVar = new com.baidu.live.alablmsdk.a.a.a();
                aVar.time = this.azl.get(i).intValue();
                aVar.axW = false;
                this.azm.add(aVar);
            }
        }
    }

    private void xZ() {
        this.azn = com.baidu.live.alablmsdk.a.a.t(this.azl);
        if (this.azn <= 0) {
            this.azo = 120;
        } else {
            this.azo = this.azn;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" handleCountDownTime maxCountDownTime " + this.azo, "");
    }

    private List<com.baidu.live.alablmsdk.a.a.a> ya() {
        if (this.azm == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.azm.size()) {
                return arrayList;
            }
            com.baidu.live.alablmsdk.a.a.a aVar = this.azm.get(i2);
            if (aVar != null) {
                arrayList.add(aVar.clone());
            }
            i = i2 + 1;
        }
    }

    public void yb() {
        com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down start", "");
        if (this.azk != null) {
            if (this.azk.azL != null) {
                com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar.azK = this.azk.azK;
                if (this.azk.azL != null && this.azk.azL.azT != null && TextUtils.isEmpty(this.azk.azL.azT.order)) {
                    cVar.order = this.azk.azL.azT.order;
                    com.baidu.live.alablmsdk.a.b.a.d(" current leave count down start , add order " + cVar.order);
                }
                if (this.azk.azL.azU == null) {
                    com.baidu.live.alablmsdk.a.b.a.eG(" CurrentUserStateInfo mStreamLeaveCountDown null ");
                    this.azk.azL.azU = new com.baidu.live.alablmsdk.a.a.b(cVar.azK, 2, this.azo, 1L, cVar, false, ya(), this);
                }
                this.azk.azL.azU.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down start error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down start error, mCurrentChatInfo null ", "");
    }

    public void yc() {
        com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down stop", "");
        if (this.azk != null) {
            if (this.azk.azL != null) {
                if (this.azk.azL.azU != null) {
                    this.azk.azL.azU.cancelTimer();
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down stop error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down stop error, mCurrentChatInfo null ", "");
    }

    public void as(long j) {
        com.baidu.live.alablmsdk.a.b.a.ag("other stream leave count down start , imUk=" + j, "");
        if (this.azk != null && j != 0) {
            d aC = this.azk.aC(j);
            if (aC != null) {
                if (aC.azU == null) {
                    com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                    cVar.azK = j;
                    if (aC.azT != null && !TextUtils.isEmpty(aC.azT.order)) {
                        cVar.order = aC.azT.order;
                        com.baidu.live.alablmsdk.a.b.a.d("other stream leave count down start , add order " + cVar.order);
                    }
                    aC.azU = new com.baidu.live.alablmsdk.a.a.b(j, 2, this.azo, 1L, cVar, false, ya(), this);
                }
                aC.azU.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag(" other leave count down start error , no count down start", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void at(long j) {
        com.baidu.live.alablmsdk.a.b.a.ag("leave count down stop, imUk=" + j, "");
        if (this.azk != null) {
            d aC = this.azk.aC(j);
            if (aC != null && aC.azU != null) {
                aC.azU.cancelTimer();
                return;
            } else {
                com.baidu.live.alablmsdk.a.b.a.ag(" other leave count down start error , no count down start", "");
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void yd() {
        com.baidu.live.alablmsdk.a.b.a.eG("stop other stream leave count down");
        if (this.azk != null) {
            this.azk.yB();
        } else {
            com.baidu.live.alablmsdk.a.b.a.ag(" other leave count down start error, mCurrentChatInfo null ", "");
        }
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, long j, Object obj) {
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, Object obj, long j) {
        com.baidu.live.alablmsdk.module.rtc.c cVar;
        com.baidu.live.alablmsdk.a.b.a.eG(" onNodeCallback callback , time=" + j);
        if (this.azp != null) {
            if (!(obj instanceof com.baidu.live.alablmsdk.module.rtc.c)) {
                cVar = null;
            } else {
                cVar = (com.baidu.live.alablmsdk.module.rtc.c) obj;
            }
            com.baidu.live.alablmsdk.a.b.a.eG(" onNodeCallback callback leavedForSeconds , time=" + j);
            this.azp.a(cVar, (int) j);
        }
    }

    public void release() {
        this.azp = null;
        if (this.azk != null) {
            this.azk.yA();
            this.azk.yB();
        }
    }
}
