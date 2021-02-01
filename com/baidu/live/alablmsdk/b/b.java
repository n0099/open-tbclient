package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.a.a.b;
import com.baidu.live.alablmsdk.module.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class b implements b.a {
    public com.baidu.live.alablmsdk.module.a axK;
    private List<Integer> axL;
    private List<com.baidu.live.alablmsdk.a.a.a> axM = new ArrayList();
    private int axN;
    private int axO;
    private a axP;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.live.alablmsdk.module.rtc.c cVar, int i);
    }

    public b(a aVar) {
        this.axP = aVar;
    }

    public void a(com.baidu.live.alablmsdk.module.a aVar) {
        this.axK = aVar;
    }

    public void x(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap != null && hashMap.containsKey("blm_rtc_stream_leaved_listen_seconds_key") && (obj = hashMap.get("blm_rtc_stream_leaved_listen_seconds_key")) != null) {
            this.axL = (List) obj;
            Collections.sort(this.axL);
            Collections.reverse(this.axL);
            xV();
            xW();
        }
    }

    public void xV() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.axL)) {
            for (int i = 0; i < this.axL.size(); i++) {
                com.baidu.live.alablmsdk.a.a.a aVar = new com.baidu.live.alablmsdk.a.a.a();
                aVar.time = this.axL.get(i).intValue();
                aVar.aww = false;
                this.axM.add(aVar);
            }
        }
    }

    private void xW() {
        this.axN = com.baidu.live.alablmsdk.a.a.t(this.axL);
        if (this.axN <= 0) {
            this.axO = 120;
        } else {
            this.axO = this.axN;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" handleCountDownTime maxCountDownTime " + this.axO, "");
    }

    private List<com.baidu.live.alablmsdk.a.a.a> xX() {
        if (this.axM == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.axM.size()) {
                return arrayList;
            }
            com.baidu.live.alablmsdk.a.a.a aVar = this.axM.get(i2);
            if (aVar != null) {
                arrayList.add(aVar.clone());
            }
            i = i2 + 1;
        }
    }

    public void xY() {
        com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down start", "");
        if (this.axK != null) {
            if (this.axK.ayl != null) {
                com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar.ayk = this.axK.ayk;
                if (this.axK.ayl != null && this.axK.ayl.ayt != null && TextUtils.isEmpty(this.axK.ayl.ayt.order)) {
                    cVar.order = this.axK.ayl.ayt.order;
                    com.baidu.live.alablmsdk.a.b.a.d(" current leave count down start , add order " + cVar.order);
                }
                if (this.axK.ayl.ayu == null) {
                    com.baidu.live.alablmsdk.a.b.a.eA(" CurrentUserStateInfo mStreamLeaveCountDown null ");
                    this.axK.ayl.ayu = new com.baidu.live.alablmsdk.a.a.b(cVar.ayk, 2, this.axO, 1L, cVar, false, xX(), this);
                }
                this.axK.ayl.ayu.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down start error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down start error, mCurrentChatInfo null ", "");
    }

    public void xZ() {
        com.baidu.live.alablmsdk.a.b.a.ag(" current leave count down stop", "");
        if (this.axK != null) {
            if (this.axK.ayl != null) {
                if (this.axK.ayl.ayu != null) {
                    this.axK.ayl.ayu.cancelTimer();
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
        if (this.axK != null && j != 0) {
            d aC = this.axK.aC(j);
            if (aC != null) {
                if (aC.ayu == null) {
                    com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                    cVar.ayk = j;
                    if (aC.ayt != null && !TextUtils.isEmpty(aC.ayt.order)) {
                        cVar.order = aC.ayt.order;
                        com.baidu.live.alablmsdk.a.b.a.d("other stream leave count down start , add order " + cVar.order);
                    }
                    aC.ayu = new com.baidu.live.alablmsdk.a.a.b(j, 2, this.axO, 1L, cVar, false, xX(), this);
                }
                aC.ayu.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag(" other leave count down start error , no count down start", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void at(long j) {
        com.baidu.live.alablmsdk.a.b.a.ag("leave count down stop, imUk=" + j, "");
        if (this.axK != null) {
            d aC = this.axK.aC(j);
            if (aC != null && aC.ayu != null) {
                aC.ayu.cancelTimer();
                return;
            } else {
                com.baidu.live.alablmsdk.a.b.a.ag(" other leave count down start error , no count down start", "");
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void ya() {
        com.baidu.live.alablmsdk.a.b.a.eA("stop other stream leave count down");
        if (this.axK != null) {
            this.axK.yy();
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
        com.baidu.live.alablmsdk.a.b.a.eA(" onNodeCallback callback , time=" + j);
        if (this.axP != null) {
            if (!(obj instanceof com.baidu.live.alablmsdk.module.rtc.c)) {
                cVar = null;
            } else {
                cVar = (com.baidu.live.alablmsdk.module.rtc.c) obj;
            }
            com.baidu.live.alablmsdk.a.b.a.eA(" onNodeCallback callback leavedForSeconds , time=" + j);
            this.axP.a(cVar, (int) j);
        }
    }

    public void release() {
        this.axP = null;
        if (this.axK != null) {
            this.axK.yx();
            this.axK.yy();
        }
    }
}
