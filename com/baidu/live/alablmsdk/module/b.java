package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    private static b ayn;
    public List<a> ayo = new ArrayList();

    private b() {
    }

    public static b yz() {
        if (ayn == null) {
            synchronized (b.class) {
                if (ayn == null) {
                    ayn = new b();
                }
            }
        }
        return ayn;
    }

    public void b(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.roomId)) {
            synchronized (this.ayo) {
                com.baidu.live.alablmsdk.a.b.a.d(" chat info list size =  " + this.ayo.size());
                com.baidu.live.alablmsdk.a.b.a.eA("hat info list size " + this.ayo.size());
                if (!contains(aVar.roomId)) {
                    this.ayo.add(aVar);
                    com.baidu.live.alablmsdk.a.b.a.d(" chat info list add 之后， size =  " + this.ayo.size());
                    com.baidu.live.alablmsdk.a.b.a.eA(" chat info list added size " + this.ayo.size());
                }
            }
        }
    }

    public a eO(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.ayo) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.ayo)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.ayo.size()) {
                        aVar = null;
                        break;
                    }
                    aVar = this.ayo.get(i2);
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
        synchronized (this.ayo) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.ayo)) {
                int i = 0;
                while (true) {
                    if (i >= this.ayo.size()) {
                        z = false;
                        break;
                    }
                    a aVar = this.ayo.get(i);
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
        synchronized (this.ayo) {
            a eO = eO(str);
            if (eO != null) {
                eO.a(bLMSignalState);
            }
        }
    }

    public void a(String str, BLMRtcState bLMRtcState) {
        synchronized (this.ayo) {
            a eO = eO(str);
            if (eO != null) {
                eO.a(bLMRtcState);
            }
        }
    }

    public void a(String str, long j, BLMSignalState bLMSignalState) {
        synchronized (this.ayo) {
            a eO = eO(str);
            if (eO != null) {
                eO.a(j, bLMSignalState);
            }
        }
    }

    public void clearAll() {
        com.baidu.live.alablmsdk.a.b.a.ag(" BLMChatInfoManager clearAll", "");
        if (this.ayo != null) {
            synchronized (this.ayo) {
                for (int i = 0; i < this.ayo.size(); i++) {
                    a aVar = this.ayo.get(i);
                    if (aVar != null) {
                        aVar.yx();
                        aVar.yy();
                    }
                }
                this.ayo.clear();
                com.baidu.live.alablmsdk.a.b.a.ag(" mChatInfoList clear ", "");
            }
        }
    }
}
