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
    public com.baidu.live.alablmsdk.module.a aBa;
    private List<Integer> aBb;
    private List<com.baidu.live.alablmsdk.a.a.a> aBc = new ArrayList();
    private int aBd;
    private int aBe;
    private a aBf;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i);
    }

    public b(a aVar) {
        this.aBf = aVar;
    }

    public void a(com.baidu.live.alablmsdk.module.a aVar) {
        this.aBa = aVar;
    }

    public void w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap != null && hashMap.containsKey("blm_rtc_stream_leaved_listen_seconds_key") && (obj = hashMap.get("blm_rtc_stream_leaved_listen_seconds_key")) != null) {
            this.aBb = (List) obj;
            Collections.sort(this.aBb);
            Collections.reverse(this.aBb);
            By();
            Bz();
        }
    }

    public void By() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBb)) {
            for (int i = 0; i < this.aBb.size(); i++) {
                com.baidu.live.alablmsdk.a.a.a aVar = new com.baidu.live.alablmsdk.a.a.a();
                aVar.time = this.aBb.get(i).intValue();
                aVar.aAy = false;
                this.aBc.add(aVar);
            }
        }
    }

    private void Bz() {
        this.aBd = com.baidu.live.alablmsdk.a.a.s(this.aBb);
        if (this.aBd <= 0) {
            this.aBe = 120;
        } else {
            this.aBe = this.aBd;
        }
        com.baidu.live.alablmsdk.a.b.ah(" handleCountDownTime maxCountDownTime " + this.aBe, "");
    }

    private List<com.baidu.live.alablmsdk.a.a.a> BA() {
        if (this.aBc == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aBc.size()) {
                return arrayList;
            }
            com.baidu.live.alablmsdk.a.a.a aVar = this.aBc.get(i2);
            if (aVar != null) {
                arrayList.add(aVar.clone());
            }
            i = i2 + 1;
        }
    }

    public void BB() {
        com.baidu.live.alablmsdk.a.b.ah(" current leave count down start", "");
        if (this.aBa != null) {
            if (this.aBa.aBw != null) {
                com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                aVar.aBv = this.aBa.aBv;
                if (this.aBa.aBw != null && this.aBa.aBw.aBD != null && TextUtils.isEmpty(this.aBa.aBw.aBD.order)) {
                    aVar.order = this.aBa.aBw.aBD.order;
                    com.baidu.live.alablmsdk.a.b.d(" current leave count down start , add order " + aVar.order);
                }
                if (this.aBa.aBw.aBE == null) {
                    com.baidu.live.alablmsdk.a.b.fJ(" CurrentUserStateInfo mStreamLeaveCountDown null ");
                    this.aBa.aBw.aBE = new com.baidu.live.alablmsdk.a.a.b(aVar.aBv, 2, this.aBe, 1L, aVar, false, BA(), this);
                }
                this.aBa.aBw.aBE.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.ah(" current leave count down start error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.ah(" current leave count down start error, mCurrentChatInfo null ", "");
    }

    public void BC() {
        com.baidu.live.alablmsdk.a.b.ah(" current leave count down stop", "");
        if (this.aBa != null) {
            if (this.aBa.aBw != null) {
                if (this.aBa.aBw.aBE != null) {
                    this.aBa.aBw.aBE.cancelTimer();
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.ah(" current leave count down stop error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.ah(" current leave count down stop error, mCurrentChatInfo null ", "");
    }

    public void V(long j) {
        com.baidu.live.alablmsdk.a.b.ah("other stream leave count down start , imUk=" + j, "");
        if (this.aBa != null && j != 0) {
            d ab = this.aBa.ab(j);
            if (ab != null) {
                if (ab.aBE == null) {
                    com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                    aVar.aBv = j;
                    if (ab.aBD != null && !TextUtils.isEmpty(ab.aBD.order)) {
                        aVar.order = ab.aBD.order;
                        com.baidu.live.alablmsdk.a.b.d("other stream leave count down start , add order " + aVar.order);
                    }
                    ab.aBE = new com.baidu.live.alablmsdk.a.a.b(j, 2, this.aBe, 1L, aVar, false, BA(), this);
                }
                ab.aBE.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.ah(" other leave count down start error , no count down start", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.ah(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void W(long j) {
        com.baidu.live.alablmsdk.a.b.ah("leave count down stop, imUk=" + j, "");
        if (this.aBa != null) {
            d ab = this.aBa.ab(j);
            if (ab != null && ab.aBE != null) {
                ab.aBE.cancelTimer();
                return;
            } else {
                com.baidu.live.alablmsdk.a.b.ah(" other leave count down start error , no count down start", "");
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.ah(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void BD() {
        com.baidu.live.alablmsdk.a.b.fJ("stop other stream leave count down");
        if (this.aBa != null) {
            this.aBa.BO();
        } else {
            com.baidu.live.alablmsdk.a.b.ah(" other leave count down start error, mCurrentChatInfo null ", "");
        }
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, long j, Object obj) {
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, Object obj, long j) {
        com.baidu.live.alablmsdk.module.rtc.a aVar;
        com.baidu.live.alablmsdk.a.b.fJ(" onNodeCallback callback , time=" + j);
        if (this.aBf != null) {
            if (!(obj instanceof com.baidu.live.alablmsdk.module.rtc.a)) {
                aVar = null;
            } else {
                aVar = (com.baidu.live.alablmsdk.module.rtc.a) obj;
            }
            com.baidu.live.alablmsdk.a.b.fJ(" onNodeCallback callback leavedForSeconds , time=" + j);
            this.aBf.a(aVar, (int) j);
        }
    }

    public void release() {
        this.aBf = null;
        if (this.aBa != null) {
            this.aBa.BN();
            this.aBa.BO();
        }
    }
}
