package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    private static b aCJ;
    public List<a> aCK = new ArrayList();

    private b() {
    }

    public static b Cg() {
        if (aCJ == null) {
            synchronized (b.class) {
                if (aCJ == null) {
                    aCJ = new b();
                }
            }
        }
        return aCJ;
    }

    public void c(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.roomId)) {
            synchronized (this.aCK) {
                com.baidu.live.alablmsdk.a.b.a.d(" chat info list size =  " + this.aCK.size());
                com.baidu.live.alablmsdk.a.b.a.fI("hat info list size " + this.aCK.size());
                if (!contains(aVar.roomId)) {
                    this.aCK.add(aVar);
                    com.baidu.live.alablmsdk.a.b.a.d(" chat info list add 之后， size =  " + this.aCK.size());
                    com.baidu.live.alablmsdk.a.b.a.fI(" chat info list added size " + this.aCK.size());
                }
            }
        }
    }

    public a fN(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.aCK) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCK)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aCK.size()) {
                        aVar = null;
                        break;
                    }
                    aVar = this.aCK.get(i2);
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
        synchronized (this.aCK) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCK)) {
                int i = 0;
                while (true) {
                    if (i >= this.aCK.size()) {
                        z = false;
                        break;
                    }
                    a aVar = this.aCK.get(i);
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
        synchronized (this.aCK) {
            a fN = fN(str);
            if (fN != null) {
                fN.a(bLMSignalState);
            }
        }
    }

    public void a(String str, BLMRtcState bLMRtcState) {
        synchronized (this.aCK) {
            a fN = fN(str);
            if (fN != null) {
                fN.a(bLMRtcState);
            }
        }
    }

    public void a(String str, long j, BLMSignalState bLMSignalState) {
        synchronized (this.aCK) {
            a fN = fN(str);
            if (fN != null) {
                fN.a(j, bLMSignalState);
            }
        }
    }

    public void clearAll() {
        com.baidu.live.alablmsdk.a.b.a.aj(" BLMChatInfoManager clearAll method", "");
        if (this.aCK != null) {
            synchronized (this.aCK) {
                for (int i = 0; i < this.aCK.size(); i++) {
                    a aVar = this.aCK.get(i);
                    if (aVar != null) {
                        aVar.Ce();
                        aVar.Cf();
                    }
                }
                this.aCK.clear();
                com.baidu.live.alablmsdk.a.b.a.aj(" mChatInfoList clear ", "");
            }
        }
    }
}
