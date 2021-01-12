package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private static b axW;
    public List<a> axX = new ArrayList();

    private b() {
    }

    public static b yl() {
        if (axW == null) {
            synchronized (b.class) {
                if (axW == null) {
                    axW = new b();
                }
            }
        }
        return axW;
    }

    public void c(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.roomId)) {
            synchronized (this.axX) {
                com.baidu.live.alablmsdk.a.b.a.d(" chat info list size =  " + this.axX.size());
                com.baidu.live.alablmsdk.a.b.a.ew("hat info list size " + this.axX.size());
                if (!contains(aVar.roomId)) {
                    this.axX.add(aVar);
                    com.baidu.live.alablmsdk.a.b.a.d(" chat info list add 之后， size =  " + this.axX.size());
                    com.baidu.live.alablmsdk.a.b.a.ew(" chat info list added size " + this.axX.size());
                }
            }
        }
    }

    public a eC(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.axX) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.axX)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.axX.size()) {
                        aVar = null;
                        break;
                    }
                    aVar = this.axX.get(i2);
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
        synchronized (this.axX) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.axX)) {
                int i = 0;
                while (true) {
                    if (i >= this.axX.size()) {
                        z = false;
                        break;
                    }
                    a aVar = this.axX.get(i);
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
        synchronized (this.axX) {
            a eC = eC(str);
            if (eC != null) {
                eC.a(bLMSignalState);
            }
        }
    }

    public void a(String str, BLMRtcState bLMRtcState) {
        synchronized (this.axX) {
            a eC = eC(str);
            if (eC != null) {
                eC.a(bLMRtcState);
            }
        }
    }

    public void a(String str, long j, BLMSignalState bLMSignalState) {
        synchronized (this.axX) {
            a eC = eC(str);
            if (eC != null) {
                eC.a(j, bLMSignalState);
            }
        }
    }

    public void clearAll() {
        com.baidu.live.alablmsdk.a.b.a.ai(" BLMChatInfoManager clearAll method", "");
        if (this.axX != null) {
            synchronized (this.axX) {
                for (int i = 0; i < this.axX.size(); i++) {
                    a aVar = this.axX.get(i);
                    if (aVar != null) {
                        aVar.yj();
                        aVar.yk();
                    }
                }
                this.axX.clear();
                com.baidu.live.alablmsdk.a.b.a.ai(" mChatInfoList clear ", "");
            }
        }
    }
}
