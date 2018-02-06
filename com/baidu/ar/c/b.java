package com.baidu.ar.c;

import android.content.Context;
import android.util.Log;
import com.baidu.ar.i;
import com.baidu.ar.util.Constants;
import com.baidu.baiduarsdk.ArBridge;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private static i.a c = new i.a() { // from class: com.baidu.ar.c.b.1
        @Override // com.baidu.ar.i.a
        public void a() {
        }

        @Override // com.baidu.ar.i.a
        public void a(float f, float f2, float f3, float f4) {
            com.baidu.ar.util.b.d("acc  x " + f + " , y : " + f2 + " , z " + f3);
            b.a(f, f2, f3, f4);
        }
    };
    private Context a;
    private com.baidu.ar.arspeech.a b;

    public b(Context context, com.baidu.ar.arspeech.a aVar) {
        this.a = context;
        this.b = aVar;
    }

    public static void a(float f, float f2, float f3, float f4) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", 10000);
        hashMap.put(Constants.MSG_SDK_LUA_BRIDGE_MAX_ACC, Float.valueOf(f4));
        b(hashMap);
    }

    public static void b(HashMap hashMap) {
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    public void a(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            int intValue = ((Integer) hashMap.get("id")).intValue();
            Log.e("lua  ", " ArBridge.LuaSdkBridgeMessageType = " + intValue);
            switch (intValue) {
                case 2001:
                    if (this.b != null) {
                        this.b.a();
                        return;
                    }
                    return;
                case 2002:
                    if (this.b != null) {
                        this.b.b();
                        return;
                    }
                    return;
                case 10001:
                    com.baidu.ar.b.b.a(this.a).a(c);
                    return;
                case 10002:
                    com.baidu.ar.b.b.a(this.a).a();
                    return;
                case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                    com.baidu.ar.b.b.a(this.a).a(true);
                    return;
                default:
                    return;
            }
        }
    }
}
