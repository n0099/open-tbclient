package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.LinkUserStatus;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private static b aBi;
    public List<a> aBj = new ArrayList();

    private b() {
    }

    public static b BE() {
        if (aBi == null) {
            synchronized (b.class) {
                if (aBi == null) {
                    aBi = new b();
                }
            }
        }
        return aBi;
    }

    public void b(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.roomId)) {
            synchronized (this.aBj) {
                com.baidu.live.alablmsdk.a.c.d(" chat info list size =  " + this.aBj.size());
                com.baidu.live.alablmsdk.a.c.fJ("hat info list size " + this.aBj.size());
                if (!contains(aVar.roomId)) {
                    this.aBj.add(aVar);
                    com.baidu.live.alablmsdk.a.c.d(" chat info list add 之后， size =  " + this.aBj.size());
                    com.baidu.live.alablmsdk.a.c.fJ(" chat info list added size " + this.aBj.size());
                }
            }
        }
    }

    public a fL(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.aBj) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBj)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aBj.size()) {
                        aVar = null;
                        break;
                    }
                    aVar = this.aBj.get(i2);
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
        synchronized (this.aBj) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBj)) {
                int i = 0;
                while (true) {
                    if (i >= this.aBj.size()) {
                        z = false;
                        break;
                    }
                    a aVar = this.aBj.get(i);
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

    public void a(String str, LinkUserStatus linkUserStatus) {
        synchronized (this.aBj) {
            a fL = fL(str);
            if (fL != null) {
                fL.a(linkUserStatus);
            }
        }
    }

    public void clearAll() {
        com.baidu.live.alablmsdk.a.c.d(" BLMChatInfoManager  clearAll method");
        com.baidu.live.alablmsdk.a.c.fJ(" BLMChatInfoManager clearAll method");
        if (this.aBj != null) {
            synchronized (this.aBj) {
                this.aBj.clear();
                com.baidu.live.alablmsdk.a.c.d(" mChatInfoList.clear() ");
                com.baidu.live.alablmsdk.a.c.fJ(" mChatInfoList clear ");
            }
        }
    }
}
