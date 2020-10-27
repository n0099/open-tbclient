package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.LinkUserStatus;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private static b aBn;
    public List<a> aBo = new ArrayList();

    private b() {
    }

    public static b BE() {
        if (aBn == null) {
            synchronized (b.class) {
                if (aBn == null) {
                    aBn = new b();
                }
            }
        }
        return aBn;
    }

    public void b(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.roomId)) {
            synchronized (this.aBo) {
                com.baidu.live.alablmsdk.a.c.d(" chat info list size =  " + this.aBo.size());
                com.baidu.live.alablmsdk.a.c.fJ("hat info list size " + this.aBo.size());
                if (!contains(aVar.roomId)) {
                    this.aBo.add(aVar);
                    com.baidu.live.alablmsdk.a.c.d(" chat info list add 之后， size =  " + this.aBo.size());
                    com.baidu.live.alablmsdk.a.c.fJ(" chat info list added size " + this.aBo.size());
                }
            }
        }
    }

    public a fL(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.aBo) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBo)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aBo.size()) {
                        aVar = null;
                        break;
                    }
                    aVar = this.aBo.get(i2);
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
        synchronized (this.aBo) {
            if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBo)) {
                int i = 0;
                while (true) {
                    if (i >= this.aBo.size()) {
                        z = false;
                        break;
                    }
                    a aVar = this.aBo.get(i);
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
        synchronized (this.aBo) {
            a fL = fL(str);
            if (fL != null) {
                fL.a(linkUserStatus);
            }
        }
    }

    public void clearAll() {
        com.baidu.live.alablmsdk.a.c.d(" BLMChatInfoManager  clearAll method");
        com.baidu.live.alablmsdk.a.c.fJ(" BLMChatInfoManager clearAll method");
        if (this.aBo != null) {
            synchronized (this.aBo) {
                this.aBo.clear();
                com.baidu.live.alablmsdk.a.c.d(" mChatInfoList.clear() ");
                com.baidu.live.alablmsdk.a.c.fJ(" mChatInfoList clear ");
            }
        }
    }
}
