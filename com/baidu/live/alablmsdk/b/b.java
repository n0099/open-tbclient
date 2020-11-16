package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.a.a.b;
import com.baidu.live.alablmsdk.module.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements b.a {
    public com.baidu.live.alablmsdk.module.a azp;
    private List<Integer> azq;
    private List<com.baidu.live.alablmsdk.a.a.a> azr = new ArrayList();
    private int azs;
    private int azt;
    private a azu;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i);
    }

    public b(a aVar) {
        this.azu = aVar;
    }

    public void a(com.baidu.live.alablmsdk.module.a aVar) {
        this.azp = aVar;
    }

    public void w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap != null && hashMap.containsKey("blm_rtc_stream_leaved_listen_seconds_key") && (obj = hashMap.get("blm_rtc_stream_leaved_listen_seconds_key")) != null) {
            this.azq = (List) obj;
            Collections.sort(this.azq);
            Collections.reverse(this.azq);
            AP();
            AQ();
        }
    }

    public void AP() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azq)) {
            for (int i = 0; i < this.azq.size(); i++) {
                com.baidu.live.alablmsdk.a.a.a aVar = new com.baidu.live.alablmsdk.a.a.a();
                aVar.time = this.azq.get(i).intValue();
                aVar.ayN = false;
                this.azr.add(aVar);
            }
        }
    }

    private void AQ() {
        this.azs = com.baidu.live.alablmsdk.a.a.s(this.azq);
        if (this.azs <= 0) {
            this.azt = 120;
        } else {
            this.azt = this.azs;
        }
        com.baidu.live.alablmsdk.a.b.ag(" handleCountDownTime maxCountDownTime " + this.azt, "");
    }

    private List<com.baidu.live.alablmsdk.a.a.a> AR() {
        if (this.azr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.azr.size()) {
                return arrayList;
            }
            com.baidu.live.alablmsdk.a.a.a aVar = this.azr.get(i2);
            if (aVar != null) {
                arrayList.add(aVar.clone());
            }
            i = i2 + 1;
        }
    }

    public void AS() {
        com.baidu.live.alablmsdk.a.b.ag(" current leave count down start", "");
        if (this.azp != null) {
            if (this.azp.azL != null) {
                com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                aVar.azK = this.azp.azK;
                if (this.azp.azL != null && this.azp.azL.azS != null && TextUtils.isEmpty(this.azp.azL.azS.order)) {
                    aVar.order = this.azp.azL.azS.order;
                    com.baidu.live.alablmsdk.a.b.d(" current leave count down start , add order " + aVar.order);
                }
                if (this.azp.azL.azT == null) {
                    com.baidu.live.alablmsdk.a.b.fD(" CurrentUserStateInfo mStreamLeaveCountDown null ");
                    this.azp.azL.azT = new com.baidu.live.alablmsdk.a.a.b(aVar.azK, 2, this.azt, 1L, aVar, false, AR(), this);
                }
                this.azp.azL.azT.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.ag(" current leave count down start error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.ag(" current leave count down start error, mCurrentChatInfo null ", "");
    }

    public void AT() {
        com.baidu.live.alablmsdk.a.b.ag(" current leave count down stop", "");
        if (this.azp != null) {
            if (this.azp.azL != null) {
                if (this.azp.azL.azT != null) {
                    this.azp.azL.azT.cancelTimer();
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.ag(" current leave count down stop error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.ag(" current leave count down stop error, mCurrentChatInfo null ", "");
    }

    public void V(long j) {
        com.baidu.live.alablmsdk.a.b.ag("other stream leave count down start , imUk=" + j, "");
        if (this.azp != null && j != 0) {
            d ab = this.azp.ab(j);
            if (ab != null) {
                if (ab.azT == null) {
                    com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                    aVar.azK = j;
                    if (ab.azS != null && !TextUtils.isEmpty(ab.azS.order)) {
                        aVar.order = ab.azS.order;
                        com.baidu.live.alablmsdk.a.b.d("other stream leave count down start , add order " + aVar.order);
                    }
                    ab.azT = new com.baidu.live.alablmsdk.a.a.b(j, 2, this.azt, 1L, aVar, false, AR(), this);
                }
                ab.azT.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.ag(" other leave count down start error , no count down start", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.ag(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void W(long j) {
        com.baidu.live.alablmsdk.a.b.ag("leave count down stop, imUk=" + j, "");
        if (this.azp != null) {
            d ab = this.azp.ab(j);
            if (ab != null && ab.azT != null) {
                ab.azT.cancelTimer();
                return;
            } else {
                com.baidu.live.alablmsdk.a.b.ag(" other leave count down start error , no count down start", "");
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.ag(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void AU() {
        com.baidu.live.alablmsdk.a.b.fD("stop other stream leave count down");
        if (this.azp != null) {
            this.azp.Bf();
        } else {
            com.baidu.live.alablmsdk.a.b.ag(" other leave count down start error, mCurrentChatInfo null ", "");
        }
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, long j, Object obj) {
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, Object obj, long j) {
        com.baidu.live.alablmsdk.module.rtc.a aVar;
        com.baidu.live.alablmsdk.a.b.fD(" onNodeCallback callback , time=" + j);
        if (this.azu != null) {
            if (!(obj instanceof com.baidu.live.alablmsdk.module.rtc.a)) {
                aVar = null;
            } else {
                aVar = (com.baidu.live.alablmsdk.module.rtc.a) obj;
            }
            com.baidu.live.alablmsdk.a.b.fD(" onNodeCallback callback leavedForSeconds , time=" + j);
            this.azu.a(aVar, (int) j);
        }
    }

    public void release() {
        this.azu = null;
        if (this.azp != null) {
            this.azp.Be();
            this.azp.Bf();
        }
    }
}
