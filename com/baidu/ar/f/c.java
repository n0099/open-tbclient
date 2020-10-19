package com.baidu.ar.f;

import android.content.Context;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.f.a;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class c implements com.baidu.ar.lua.c {
    private Context mContext;
    private a.InterfaceC0083a vs;

    public c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static void c(float f, float f2, float f3, float f4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 10000);
        hashMap.put("max_acc", Float.valueOf(f4));
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    @Override // com.baidu.ar.lua.c
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (i != 1901 || hashMap == null) {
            return;
        }
        switch (com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1)) {
            case 10001:
                b.p(this.mContext).b(this.vs);
                return;
            case 10002:
                b.p(this.mContext).stop();
                return;
            case 10003:
            default:
                return;
            case 10004:
                b.p(this.mContext).U(true);
                return;
        }
    }

    public void b(com.baidu.ar.lua.b bVar) {
        this.vs = new a.InterfaceC0083a() { // from class: com.baidu.ar.f.c.1
            @Override // com.baidu.ar.f.a.InterfaceC0083a
            public void b(float f, float f2, float f3, float f4) {
                com.baidu.ar.g.b.aP("acc  x " + f + " , y : " + f2 + " , z " + f3);
                StatisticApi.onEvent(StatisticConstants.MODEL_PHONE_SHAKE);
                c.c(f, f2, f3, f4);
            }

            @Override // com.baidu.ar.f.a.InterfaceC0083a
            public void destroy() {
            }
        };
        bVar.c(this);
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        return Arrays.asList(Integer.valueOf((int) ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE));
    }

    public void release() {
        b.p(this.mContext).destroy();
        this.vs = null;
        this.mContext = null;
    }

    public void reset() {
        if (this.mContext != null) {
            try {
                b.p(this.mContext).stop();
            } catch (Throwable th) {
            }
        }
    }
}
