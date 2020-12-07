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
    public com.baidu.live.alablmsdk.module.a aBT;
    private List<Integer> aBU;
    private List<com.baidu.live.alablmsdk.a.a.a> aBV = new ArrayList();
    private int aBW;
    private int aBX;
    private a aBY;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i);
    }

    public b(a aVar) {
        this.aBY = aVar;
    }

    public void a(com.baidu.live.alablmsdk.module.a aVar) {
        this.aBT = aVar;
    }

    public void w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap != null && hashMap.containsKey("blm_rtc_stream_leaved_listen_seconds_key") && (obj = hashMap.get("blm_rtc_stream_leaved_listen_seconds_key")) != null) {
            this.aBU = (List) obj;
            Collections.sort(this.aBU);
            Collections.reverse(this.aBU);
            Cx();
            Cy();
        }
    }

    public void Cx() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBU)) {
            for (int i = 0; i < this.aBU.size(); i++) {
                com.baidu.live.alablmsdk.a.a.a aVar = new com.baidu.live.alablmsdk.a.a.a();
                aVar.time = this.aBU.get(i).intValue();
                aVar.aBd = false;
                this.aBV.add(aVar);
            }
        }
    }

    private void Cy() {
        this.aBW = com.baidu.live.alablmsdk.a.a.t(this.aBU);
        if (this.aBW <= 0) {
            this.aBX = 120;
        } else {
            this.aBX = this.aBW;
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" handleCountDownTime maxCountDownTime " + this.aBX, "");
    }

    private List<com.baidu.live.alablmsdk.a.a.a> Cz() {
        if (this.aBV == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aBV.size()) {
                return arrayList;
            }
            com.baidu.live.alablmsdk.a.a.a aVar = this.aBV.get(i2);
            if (aVar != null) {
                arrayList.add(aVar.clone());
            }
            i = i2 + 1;
        }
    }

    public void CA() {
        com.baidu.live.alablmsdk.a.b.a.ak(" current leave count down start", "");
        if (this.aBT != null) {
            if (this.aBT.aCq != null) {
                com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                aVar.aCp = this.aBT.aCp;
                if (this.aBT.aCq != null && this.aBT.aCq.aCy != null && TextUtils.isEmpty(this.aBT.aCq.aCy.order)) {
                    aVar.order = this.aBT.aCq.aCy.order;
                    com.baidu.live.alablmsdk.a.b.a.d(" current leave count down start , add order " + aVar.order);
                }
                if (this.aBT.aCq.aCz == null) {
                    com.baidu.live.alablmsdk.a.b.a.fY(" CurrentUserStateInfo mStreamLeaveCountDown null ");
                    this.aBT.aCq.aCz = new com.baidu.live.alablmsdk.a.a.b(aVar.aCp, 2, this.aBX, 1L, aVar, false, Cz(), this);
                }
                this.aBT.aCq.aCz.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ak(" current leave count down start error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" current leave count down start error, mCurrentChatInfo null ", "");
    }

    public void CB() {
        com.baidu.live.alablmsdk.a.b.a.ak(" current leave count down stop", "");
        if (this.aBT != null) {
            if (this.aBT.aCq != null) {
                if (this.aBT.aCq.aCz != null) {
                    this.aBT.aCq.aCz.cancelTimer();
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ak(" current leave count down stop error , user state info null", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" current leave count down stop error, mCurrentChatInfo null ", "");
    }

    public void at(long j) {
        com.baidu.live.alablmsdk.a.b.a.ak("other stream leave count down start , imUk=" + j, "");
        if (this.aBT != null && j != 0) {
            d az = this.aBT.az(j);
            if (az != null) {
                if (az.aCz == null) {
                    com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                    aVar.aCp = j;
                    if (az.aCy != null && !TextUtils.isEmpty(az.aCy.order)) {
                        aVar.order = az.aCy.order;
                        com.baidu.live.alablmsdk.a.b.a.d("other stream leave count down start , add order " + aVar.order);
                    }
                    az.aCz = new com.baidu.live.alablmsdk.a.a.b(j, 2, this.aBX, 1L, aVar, false, Cz(), this);
                }
                az.aCz.startTimer();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ak(" other leave count down start error , no count down start", "");
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void au(long j) {
        com.baidu.live.alablmsdk.a.b.a.ak("leave count down stop, imUk=" + j, "");
        if (this.aBT != null) {
            d az = this.aBT.az(j);
            if (az != null && az.aCz != null) {
                az.aCz.cancelTimer();
                return;
            } else {
                com.baidu.live.alablmsdk.a.b.a.ak(" other leave count down start error , no count down start", "");
                return;
            }
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" other leave count down start error, mCurrentChatInfo null ", "");
    }

    public void CC() {
        com.baidu.live.alablmsdk.a.b.a.fY("stop other stream leave count down");
        if (this.aBT != null) {
            this.aBT.CO();
        } else {
            com.baidu.live.alablmsdk.a.b.a.ak(" other leave count down start error, mCurrentChatInfo null ", "");
        }
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, long j, Object obj) {
    }

    @Override // com.baidu.live.alablmsdk.a.a.b.a
    public void a(int i, Object obj, long j) {
        com.baidu.live.alablmsdk.module.rtc.a aVar;
        com.baidu.live.alablmsdk.a.b.a.fY(" onNodeCallback callback , time=" + j);
        if (this.aBY != null) {
            if (!(obj instanceof com.baidu.live.alablmsdk.module.rtc.a)) {
                aVar = null;
            } else {
                aVar = (com.baidu.live.alablmsdk.module.rtc.a) obj;
            }
            com.baidu.live.alablmsdk.a.b.a.fY(" onNodeCallback callback leavedForSeconds , time=" + j);
            this.aBY.a(aVar, (int) j);
        }
    }

    public void release() {
        this.aBY = null;
        if (this.aBT != null) {
            this.aBT.CN();
            this.aBT.CO();
        }
    }
}
