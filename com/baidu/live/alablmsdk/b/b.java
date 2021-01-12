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
    private int axA;
    private int axB;
    private a axC;
    public com.baidu.live.alablmsdk.module.a axx;
    private List<Integer> axy;
    private List<com.baidu.live.alablmsdk.a.a.a> axz = new ArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i);
    }

    public b(a aVar) {
        this.axC = aVar;
    }

    public void a(com.baidu.live.alablmsdk.module.a aVar) {
        this.axx = aVar;
    }

    public void w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap != null && hashMap.containsKey("blm_rtc_stream_leaved_listen_seconds_key") && (obj = hashMap.get("blm_rtc_stream_leaved_listen_seconds_key")) != null) {
            this.axy = (List) obj;
            Collections.sort(this.axy);
            Collections.reverse(this.axy);
            xT();
            xU();
        }
    }

    public void xT() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.axy)) {
            for (int i = 0; i < this.axy.size(); i++) {
                com.baidu.live.alablmsdk.a.a.a aVar = new com.baidu.live.alablmsdk.a.a.a();
                aVar.time = this.axy.get(i).intValue();
                aVar.awH = false;
                this.axz.add(aVar);
            }
        }
    }

    private void xU() {
        this.axA = com.baidu.live.alablmsdk.a.a.t(this.axy);
        if (this.axA <= 0) {
            this.axB = 120;
        } else {
            this.axB = this.axA;
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" handleCountDownTime maxCountDownTime " + this.axB, "");
    }

    private List<com.baidu.live.alablmsdk.a.a.a> xV() {
        if (this.axz == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.axz.size()) {
                return arrayList;
            }
            com.baidu.live.alablmsdk.a.a.a aVar = this.axz.get(i2);
            if (aVar != null) {
                arrayList.add(aVar.clone());
            }
            i = i2 + 1;
        }
    }

    public void xW() {
        com.baidu.live.alablmsdk.a.b.a.ai(" current leave count down start", "");
        if (this.axx != null) {
            if (this.axx.axU != null) {
                com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                aVar.axT = this.axx.axT;
                if (this.axx.axU != null && this.axx.axU.ayc != null && TextUtils.isEmpty(this.axx.axU.ayc.order)) {
                    aVar.order = this.axx.axU.ayc.order;
                    com.baidu.live.alablmsdk.a.b.a.d(" current leave count down start , add order " + aVar.order);
                }
                if (this.axx.axU.ayd == null) {
                    com.baidu.live.alablmsdk.a.b.a.ew(" CurrentUserStateInfo mStreamLeaveCountDown null ");
                    this.axx.axU.ayd = new com.baidu.live.alablmsdk.a.a.b(aVar.axT, 2, this.axB, 1L, aVar, false, xV(), this);
                }
                this.axx.axU.ayd.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ai(" current leave count down start error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" current leave count down start error, mCurrentChatInfo null ", "");
    }

    public void xX() {
        com.baidu.live.alablmsdk.a.b.a.ai(" current leave count down stop", "");
        if (this.axx != null) {
            if (this.axx.axU != null) {
                if (this.axx.axU.ayd != null) {
                    this.axx.axU.ayd.cancelTimer();
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ai(" current leave count down stop error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" current leave count down stop error, mCurrentChatInfo null ", "");
    }

    public void as(long j) {
        com.baidu.live.alablmsdk.a.b.a.ai("other stream leave count down start , imUk=" + j, "");
        if (this.axx != null && j != 0) {
            d ay = this.axx.ay(j);
            if (ay != null) {
                if (ay.ayd == null) {
                    com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                    aVar.axT = j;
                    if (ay.ayc != null && !TextUtils.isEmpty(ay.ayc.order)) {
                        aVar.order = ay.ayc.order;
                        com.baidu.live.alablmsdk.a.b.a.d("other stream leave count down start , add order " + aVar.order);
                    }
                    ay.ayd = new com.baidu.live.alablmsdk.a.a.b(j, 2, this.axB, 1L, aVar, false, xV(), this);
                }
                ay.ayd.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ai(" other leave count down start error , no count down start", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void at(long j) {
        com.baidu.live.alablmsdk.a.b.a.ai("leave count down stop, imUk=" + j, "");
        if (this.axx != null) {
            d ay = this.axx.ay(j);
            if (ay != null && ay.ayd != null) {
                ay.ayd.cancelTimer();
                return;
            } else {
                com.baidu.live.alablmsdk.a.b.a.ai(" other leave count down start error , no count down start", "");
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void xY() {
        com.baidu.live.alablmsdk.a.b.a.ew("stop other stream leave count down");
        if (this.axx != null) {
            this.axx.yk();
        } else {
            com.baidu.live.alablmsdk.a.b.a.ai(" other leave count down start error, mCurrentChatInfo null ", "");
        }
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, long j, Object obj) {
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, Object obj, long j) {
        com.baidu.live.alablmsdk.module.rtc.a aVar;
        com.baidu.live.alablmsdk.a.b.a.ew(" onNodeCallback callback , time=" + j);
        if (this.axC != null) {
            if (!(obj instanceof com.baidu.live.alablmsdk.module.rtc.a)) {
                aVar = null;
            } else {
                aVar = (com.baidu.live.alablmsdk.module.rtc.a) obj;
            }
            com.baidu.live.alablmsdk.a.b.a.ew(" onNodeCallback callback leavedForSeconds , time=" + j);
            this.axC.a(aVar, (int) j);
        }
    }

    public void release() {
        this.axC = null;
        if (this.axx != null) {
            this.axx.yj();
            this.axx.yk();
        }
    }
}
