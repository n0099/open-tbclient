package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private static b aCs;
    public List<a> aCt = new ArrayList();

    private b() {
    }

    public static b CP() {
        if (aCs == null) {
            synchronized (b.class) {
                if (aCs == null) {
                    aCs = new b();
                }
            }
        }
        return aCs;
    }

    public void c(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.roomId)) {
            synchronized (this.aCt) {
                com.baidu.live.alablmsdk.a.b.a.d(" chat info list size =  " + this.aCt.size());
                com.baidu.live.alablmsdk.a.b.a.fY("hat info list size " + this.aCt.size());
                if (!contains(aVar.roomId)) {
                    this.aCt.add(aVar);
                    com.baidu.live.alablmsdk.a.b.a.d(" chat info list add 之后， size =  " + this.aCt.size());
                    com.baidu.live.alablmsdk.a.b.a.fY(" chat info list added size " + this.aCt.size());
                }
            }
        }
    }

    public a gd(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.aCt) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCt)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aCt.size()) {
                        aVar = null;
                        break;
                    }
                    aVar = this.aCt.get(i2);
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
        synchronized (this.aCt) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCt)) {
                int i = 0;
                while (true) {
                    if (i >= this.aCt.size()) {
                        z = false;
                        break;
                    }
                    a aVar = this.aCt.get(i);
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
        synchronized (this.aCt) {
            a gd = gd(str);
            if (gd != null) {
                gd.a(bLMSignalState);
            }
        }
    }

    public void a(String str, BLMRtcState bLMRtcState) {
        synchronized (this.aCt) {
            a gd = gd(str);
            if (gd != null) {
                gd.a(bLMRtcState);
            }
        }
    }

    public void a(String str, long j, BLMSignalState bLMSignalState) {
        synchronized (this.aCt) {
            a gd = gd(str);
            if (gd != null) {
                gd.a(j, bLMSignalState);
            }
        }
    }

    public void clearAll() {
        com.baidu.live.alablmsdk.a.b.a.ak(" BLMChatInfoManager clearAll method", "");
        if (this.aCt != null) {
            synchronized (this.aCt) {
                for (int i = 0; i < this.aCt.size(); i++) {
                    a aVar = this.aCt.get(i);
                    if (aVar != null) {
                        aVar.CN();
                        aVar.CO();
                    }
                }
                this.aCt.clear();
                com.baidu.live.alablmsdk.a.b.a.ak(" mChatInfoList clear ", "");
            }
        }
    }
}
