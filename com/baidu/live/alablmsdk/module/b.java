package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private static b azN;
    public List<a> azO = new ArrayList();

    private b() {
    }

    public static b Bg() {
        if (azN == null) {
            synchronized (b.class) {
                if (azN == null) {
                    azN = new b();
                }
            }
        }
        return azN;
    }

    public void c(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.roomId)) {
            synchronized (this.azO) {
                com.baidu.live.alablmsdk.a.b.d(" chat info list size =  " + this.azO.size());
                com.baidu.live.alablmsdk.a.b.fD("hat info list size " + this.azO.size());
                if (!contains(aVar.roomId)) {
                    this.azO.add(aVar);
                    com.baidu.live.alablmsdk.a.b.d(" chat info list add 之后， size =  " + this.azO.size());
                    com.baidu.live.alablmsdk.a.b.fD(" chat info list added size " + this.azO.size());
                }
            }
        }
    }

    public a fH(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.azO) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azO)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.azO.size()) {
                        aVar = null;
                        break;
                    }
                    aVar = this.azO.get(i2);
                    if (aVar != null && !TextUtils.isEmpty(aVar.roomId) && str.equals(aVar.roomId)) {
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                aVar = null;
            }
        }
        return aVar;
    }

    public boolean contains(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.azO) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azO)) {
                int i = 0;
                while (true) {
                    if (i >= this.azO.size()) {
                        z = false;
                        break;
                    }
                    a aVar = this.azO.get(i);
                    if (aVar == null || TextUtils.isEmpty(aVar.roomId) || !str.equals(aVar.roomId)) {
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public void a(String str, BLMSignalState bLMSignalState) {
        synchronized (this.azO) {
            a fH = fH(str);
            if (fH != null) {
                fH.a(bLMSignalState);
            }
        }
    }

    public void a(String str, BLMRtcState bLMRtcState) {
        synchronized (this.azO) {
            a fH = fH(str);
            if (fH != null) {
                fH.a(bLMRtcState);
            }
        }
    }

    public void a(String str, long j, BLMSignalState bLMSignalState) {
        synchronized (this.azO) {
            a fH = fH(str);
            if (fH != null) {
                fH.a(j, bLMSignalState);
            }
        }
    }

    public void clearAll() {
        com.baidu.live.alablmsdk.a.b.ag(" BLMChatInfoManager clearAll method", "");
        if (this.azO != null) {
            synchronized (this.azO) {
                for (int i = 0; i < this.azO.size(); i++) {
                    a aVar = this.azO.get(i);
                    if (aVar != null) {
                        aVar.Be();
                        aVar.Bf();
                    }
                }
                this.azO.clear();
                com.baidu.live.alablmsdk.a.b.ag(" mChatInfoList clear ", "");
            }
        }
    }
}
