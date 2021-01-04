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
    public com.baidu.live.alablmsdk.module.a aCk;
    private List<Integer> aCl;
    private List<com.baidu.live.alablmsdk.a.a.a> aCm = new ArrayList();
    private int aCn;
    private int aCo;
    private a aCp;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i);
    }

    public b(a aVar) {
        this.aCp = aVar;
    }

    public void a(com.baidu.live.alablmsdk.module.a aVar) {
        this.aCk = aVar;
    }

    public void w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap != null && hashMap.containsKey("blm_rtc_stream_leaved_listen_seconds_key") && (obj = hashMap.get("blm_rtc_stream_leaved_listen_seconds_key")) != null) {
            this.aCl = (List) obj;
            Collections.sort(this.aCl);
            Collections.reverse(this.aCl);
            BO();
            BP();
        }
    }

    public void BO() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCl)) {
            for (int i = 0; i < this.aCl.size(); i++) {
                com.baidu.live.alablmsdk.a.a.a aVar = new com.baidu.live.alablmsdk.a.a.a();
                aVar.time = this.aCl.get(i).intValue();
                aVar.aBu = false;
                this.aCm.add(aVar);
            }
        }
    }

    private void BP() {
        this.aCn = com.baidu.live.alablmsdk.a.a.t(this.aCl);
        if (this.aCn <= 0) {
            this.aCo = 120;
        } else {
            this.aCo = this.aCn;
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" handleCountDownTime maxCountDownTime " + this.aCo, "");
    }

    private List<com.baidu.live.alablmsdk.a.a.a> BQ() {
        if (this.aCm == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aCm.size()) {
                return arrayList;
            }
            com.baidu.live.alablmsdk.a.a.a aVar = this.aCm.get(i2);
            if (aVar != null) {
                arrayList.add(aVar.clone());
            }
            i = i2 + 1;
        }
    }

    public void BR() {
        com.baidu.live.alablmsdk.a.b.a.aj(" current leave count down start", "");
        if (this.aCk != null) {
            if (this.aCk.aCH != null) {
                com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                aVar.aCG = this.aCk.aCG;
                if (this.aCk.aCH != null && this.aCk.aCH.aCP != null && TextUtils.isEmpty(this.aCk.aCH.aCP.order)) {
                    aVar.order = this.aCk.aCH.aCP.order;
                    com.baidu.live.alablmsdk.a.b.a.d(" current leave count down start , add order " + aVar.order);
                }
                if (this.aCk.aCH.aCQ == null) {
                    com.baidu.live.alablmsdk.a.b.a.fI(" CurrentUserStateInfo mStreamLeaveCountDown null ");
                    this.aCk.aCH.aCQ = new com.baidu.live.alablmsdk.a.a.b(aVar.aCG, 2, this.aCo, 1L, aVar, false, BQ(), this);
                }
                this.aCk.aCH.aCQ.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.aj(" current leave count down start error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" current leave count down start error, mCurrentChatInfo null ", "");
    }

    public void BS() {
        com.baidu.live.alablmsdk.a.b.a.aj(" current leave count down stop", "");
        if (this.aCk != null) {
            if (this.aCk.aCH != null) {
                if (this.aCk.aCH.aCQ != null) {
                    this.aCk.aCH.aCQ.cancelTimer();
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.aj(" current leave count down stop error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" current leave count down stop error, mCurrentChatInfo null ", "");
    }

    public void as(long j) {
        com.baidu.live.alablmsdk.a.b.a.aj("other stream leave count down start , imUk=" + j, "");
        if (this.aCk != null && j != 0) {
            d ay = this.aCk.ay(j);
            if (ay != null) {
                if (ay.aCQ == null) {
                    com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                    aVar.aCG = j;
                    if (ay.aCP != null && !TextUtils.isEmpty(ay.aCP.order)) {
                        aVar.order = ay.aCP.order;
                        com.baidu.live.alablmsdk.a.b.a.d("other stream leave count down start , add order " + aVar.order);
                    }
                    ay.aCQ = new com.baidu.live.alablmsdk.a.a.b(j, 2, this.aCo, 1L, aVar, false, BQ(), this);
                }
                ay.aCQ.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.aj(" other leave count down start error , no count down start", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void at(long j) {
        com.baidu.live.alablmsdk.a.b.a.aj("leave count down stop, imUk=" + j, "");
        if (this.aCk != null) {
            d ay = this.aCk.ay(j);
            if (ay != null && ay.aCQ != null) {
                ay.aCQ.cancelTimer();
                return;
            } else {
                com.baidu.live.alablmsdk.a.b.a.aj(" other leave count down start error , no count down start", "");
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void BT() {
        com.baidu.live.alablmsdk.a.b.a.fI("stop other stream leave count down");
        if (this.aCk != null) {
            this.aCk.Cf();
        } else {
            com.baidu.live.alablmsdk.a.b.a.aj(" other leave count down start error, mCurrentChatInfo null ", "");
        }
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, long j, Object obj) {
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, Object obj, long j) {
        com.baidu.live.alablmsdk.module.rtc.a aVar;
        com.baidu.live.alablmsdk.a.b.a.fI(" onNodeCallback callback , time=" + j);
        if (this.aCp != null) {
            if (!(obj instanceof com.baidu.live.alablmsdk.module.rtc.a)) {
                aVar = null;
            } else {
                aVar = (com.baidu.live.alablmsdk.module.rtc.a) obj;
            }
            com.baidu.live.alablmsdk.a.b.a.fI(" onNodeCallback callback leavedForSeconds , time=" + j);
            this.aCp.a(aVar, (int) j);
        }
    }

    public void release() {
        this.aCp = null;
        if (this.aCk != null) {
            this.aCk.Ce();
            this.aCk.Cf();
        }
    }
}
