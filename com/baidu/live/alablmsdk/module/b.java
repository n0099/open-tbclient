package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private static b aBy;
    public List<a> aBz = new ArrayList();

    private b() {
    }

    public static b BP() {
        if (aBy == null) {
            synchronized (b.class) {
                if (aBy == null) {
                    aBy = new b();
                }
            }
        }
        return aBy;
    }

    public void c(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.roomId)) {
            synchronized (this.aBz) {
                com.baidu.live.alablmsdk.a.b.d(" chat info list size =  " + this.aBz.size());
                com.baidu.live.alablmsdk.a.b.fJ("hat info list size " + this.aBz.size());
                if (!contains(aVar.roomId)) {
                    this.aBz.add(aVar);
                    com.baidu.live.alablmsdk.a.b.d(" chat info list add 之后， size =  " + this.aBz.size());
                    com.baidu.live.alablmsdk.a.b.fJ(" chat info list added size " + this.aBz.size());
                }
            }
        }
    }

    public a fN(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.aBz) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBz)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aBz.size()) {
                        aVar = null;
                        break;
                    }
                    aVar = this.aBz.get(i2);
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
        synchronized (this.aBz) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBz)) {
                int i = 0;
                while (true) {
                    if (i >= this.aBz.size()) {
                        z = false;
                        break;
                    }
                    a aVar = this.aBz.get(i);
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
        synchronized (this.aBz) {
            a fN = fN(str);
            if (fN != null) {
                fN.a(bLMSignalState);
            }
        }
    }

    public void a(String str, BLMRtcState bLMRtcState) {
        synchronized (this.aBz) {
            a fN = fN(str);
            if (fN != null) {
                fN.a(bLMRtcState);
            }
        }
    }

    public void a(String str, long j, BLMSignalState bLMSignalState) {
        synchronized (this.aBz) {
            a fN = fN(str);
            if (fN != null) {
                fN.a(j, bLMSignalState);
            }
        }
    }

    public void clearAll() {
        com.baidu.live.alablmsdk.a.b.ah(" BLMChatInfoManager clearAll method", "");
        if (this.aBz != null) {
            synchronized (this.aBz) {
                for (int i = 0; i < this.aBz.size(); i++) {
                    a aVar = this.aBz.get(i);
                    if (aVar != null) {
                        aVar.BN();
                        aVar.BO();
                    }
                }
                this.aBz.clear();
                com.baidu.live.alablmsdk.a.b.ah(" mChatInfoList clear ", "");
            }
        }
    }
}
