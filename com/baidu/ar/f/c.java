package com.baidu.ar.f;

import android.content.Context;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.f.a;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c implements com.baidu.ar.lua.c {
    public Context mContext;
    public a.InterfaceC0059a wg;

    public c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static void c(float f, float f2, float f3, float f4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 10000);
        hashMap.put("max_acc", Float.valueOf(f4));
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    @Override // com.baidu.ar.lua.c
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (i != 1901 || hashMap == null) {
            return;
        }
        int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
        if (a == 10001) {
            b.q(this.mContext).b(this.wg);
        } else if (a == 10002) {
            b.q(this.mContext).stop();
        } else if (a != 10004) {
        } else {
            b.q(this.mContext).S(true);
        }
    }

    public void b(com.baidu.ar.lua.b bVar) {
        this.wg = new a.InterfaceC0059a() { // from class: com.baidu.ar.f.c.1
            @Override // com.baidu.ar.f.a.InterfaceC0059a
            public void b(float f, float f2, float f3, float f4) {
                com.baidu.ar.h.b.aS("acc  x " + f + " , y : " + f2 + " , z " + f3);
                StatisticApi.onEvent(StatisticConstants.MODEL_PHONE_SHAKE);
                c.c(f, f2, f3, f4);
            }

            @Override // com.baidu.ar.f.a.InterfaceC0059a
            public void destroy() {
            }
        };
        bVar.c(this);
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        return Arrays.asList(1901);
    }

    public void release() {
        b.q(this.mContext).destroy();
        this.wg = null;
        this.mContext = null;
    }

    public void reset() {
        Context context = this.mContext;
        if (context != null) {
            try {
                b.q(context).stop();
            } catch (Throwable unused) {
            }
        }
    }
}
