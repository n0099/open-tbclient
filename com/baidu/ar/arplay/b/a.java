package com.baidu.ar.arplay.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.Log;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.a.a.c;
import com.baidu.ar.arplay.a.e;
import com.baidu.ar.arplay.c.d;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.d.a;
import com.baidu.ar.arplay.d.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a implements ARPMessage.MessageHandler {
    private ARPEngine.i ga = new ARPEngine.i() { // from class: com.baidu.ar.arplay.b.a.1
        @Override // com.baidu.ar.arplay.core.engine.ARPEngine.i
        public void a(String str, int i, String str2, String str3) {
            SurfaceTexture A = e.ay().A(str);
            if (A != null) {
                try {
                    if (e.ay().z(str) != i) {
                        e.ay().a(str, i);
                    }
                    A.updateTexImage();
                } catch (RuntimeException e) {
                    e.ay().a(str, i);
                }
            }
        }
    };
    private Context mContext;

    public a(Context context) {
        this.mContext = context.getApplicationContext();
        d.d(this.mContext);
        aP();
    }

    private void F(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("type", str);
        handleMessage(ARPMessageType.MSG_TYPE_STATISTICS, 0, hashMap);
    }

    private void a(c cVar) {
        F("phone_call");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + cVar.getNumber()));
        if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
            this.mContext.startActivity(intent);
        }
    }

    private void a(com.baidu.ar.arplay.a.a.d dVar) {
        long[] jArr = null;
        F("vibrate");
        switch (dVar.getType()) {
            case 0:
                com.baidu.ar.arplay.a.d.c(this.mContext).c(dVar.getInterval());
                return;
            case 1:
                String[] split = dVar.getPattern() != null ? dVar.getPattern().split(Constants.ACCEPT_TIME_SEPARATOR_SP) : null;
                if (split != null && split.length > 0) {
                    int length = split.length;
                    jArr = new long[length];
                    for (int i = 0; i < length; i++) {
                        try {
                            jArr[i] = Long.parseLong(split[i]);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
                com.baidu.ar.arplay.a.d.c(this.mContext).a(jArr);
                return;
            default:
                return;
        }
    }

    private void a(HashMap<String, Object> hashMap, int i) {
        if (hashMap == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.a aVar = new com.baidu.ar.arplay.a.a.a();
        if (hashMap.get("url") != null) {
            aVar.setUrl(com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null));
        }
        if (hashMap.get("delay") != null) {
            aVar.setDelay(((Float) hashMap.get("delay")).floatValue());
        }
        if (hashMap.get("id") != null) {
            aVar.setId(com.baidu.ar.arplay.c.c.a(hashMap.get("id"), (String) null));
        }
        if (hashMap.get("loop") != null) {
            int intValue = ((Integer) hashMap.get("loop")).intValue();
            aVar.i(intValue);
            if (intValue <= 0) {
                aVar.g(true);
            }
        }
        if (hashMap.get("target") != null) {
            aVar.B(com.baidu.ar.arplay.c.c.a(hashMap.get("target"), (String) null));
        }
        if (hashMap.get("from_time") != null) {
            aVar.d(com.baidu.ar.arplay.c.c.a(hashMap.get("from_time"), 0));
        }
        switch (i) {
            case 1001:
                com.baidu.ar.arplay.a.a.an().a(aVar, hashMap);
                return;
            case 1003:
                com.baidu.ar.arplay.a.a.an().b(aVar, hashMap);
                return;
            case 1005:
                com.baidu.ar.arplay.a.a.an().c(aVar, hashMap);
                return;
            case 1007:
                com.baidu.ar.arplay.a.a.an().d(aVar, hashMap);
                return;
            case 1012:
                com.baidu.ar.arplay.a.a.an().e(aVar, hashMap);
                return;
            default:
                return;
        }
    }

    private void aP() {
        ARPEngine.getInstance().setVideoUpdateCallback(this.ga);
    }

    private void b(HashMap<String, Object> hashMap, int i) {
        if (hashMap == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.e eVar = new com.baidu.ar.arplay.a.a.e();
        if (hashMap.get("url") != null) {
            eVar.setUrl(com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null));
        }
        if (hashMap.get("id") != null) {
            eVar.setId(com.baidu.ar.arplay.c.c.a(hashMap.get("id"), (String) null));
        }
        if (hashMap.get("texture_id") != null) {
            eVar.k(com.baidu.ar.arplay.c.c.a(hashMap.get("texture_id"), -1));
        }
        if (hashMap.get("loop") != null) {
            int a = com.baidu.ar.arplay.c.c.a(hashMap.get("loop"), 0);
            eVar.i(com.baidu.ar.arplay.c.c.a(hashMap.get("loop"), 0));
            if (a <= 0) {
                eVar.g(true);
            }
        }
        if (hashMap.get("target") != null) {
            eVar.B(com.baidu.ar.arplay.c.c.a(hashMap.get("target"), (String) null));
        }
        if (hashMap.get("from_time") != null) {
            eVar.d(com.baidu.ar.arplay.c.c.a(hashMap.get("from_time"), 0));
            Log.e("VideoTest", "bean fromTime: " + eVar.aB());
        }
        switch (i) {
            case 1021:
                e.ay().a(eVar, hashMap);
                return;
            case 1022:
            case 1024:
            case ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES /* 1026 */:
            default:
                return;
            case 1023:
                e.ay().b(eVar, hashMap);
                return;
            case 1025:
                e.ay().c(eVar, hashMap);
                return;
            case ARPMessageType.MSG_TYPE_VIDEO_STOP /* 1027 */:
                e.ay().d(eVar, hashMap);
                return;
        }
    }

    private void f(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String a = com.baidu.ar.arplay.c.c.a(hashMap.get(LuaMessageHelper.KEY_EVENT_NAME), "");
        a.C0074a c0074a = new a.C0074a();
        if ("load_webview".equals(a)) {
            c0074a.dL = com.baidu.ar.arplay.c.c.a(hashMap.get("texture_id"), 0);
            c0074a.width = com.baidu.ar.arplay.c.c.a(hashMap.get("width"), 0);
            c0074a.height = com.baidu.ar.arplay.c.c.a(hashMap.get("height"), 0);
            c0074a.url = com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null);
            c0074a.gp = com.baidu.ar.arplay.c.c.a(hashMap.get("is_remote"), 0) == 1;
            b.aT().c(c0074a);
        } else if ("update_webview_js".equals(a)) {
            c0074a.dL = com.baidu.ar.arplay.c.c.a(hashMap.get("texture_id"), 0);
            c0074a.gq = com.baidu.ar.arplay.c.c.a(hashMap.get("js_code"), (String) null);
            b.aT().e(c0074a);
        } else if ("load_native_webview".equals(a)) {
            c0074a.url = com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null);
            c0074a.gp = com.baidu.ar.arplay.c.c.a(hashMap.get("is_remote"), 0) == 1;
            b.aT().d(c0074a);
        }
    }

    private void g(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.d dVar = new com.baidu.ar.arplay.a.a.d();
        if (hashMap.get("type") != null) {
            dVar.setType(com.baidu.ar.arplay.c.c.a(hashMap.get("type"), 0));
        }
        if (hashMap.get("interval") != null) {
            dVar.j(com.baidu.ar.arplay.c.c.a(hashMap.get("interval"), 0));
        }
        if (hashMap.get("pattern") != null) {
            dVar.setPattern(com.baidu.ar.arplay.c.c.a(hashMap.get("pattern"), (String) null));
        }
        a(dVar);
    }

    private void h(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        c cVar = new c();
        Object obj = hashMap.get("number");
        if (obj != null) {
            cVar.C((String) obj);
        }
        a(cVar);
    }

    public void aO() {
        ARPMessage.getInstance().registerMessageHandler(0, this);
        ARPEngine.getInstance().initDataStore(this.mContext.getSharedPreferences("baiduar_lua_data_store", 0));
    }

    @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 0:
                if (i2 == -2) {
                    e.ay().ao();
                    com.baidu.ar.arplay.a.a.an().ao();
                    return;
                }
                return;
            case 8:
                ARPEngine.getInstance().onCaseLoadCompleted(hashMap);
                return;
            case 9:
                ARPEngine.getInstance().onCaseUnloadCompleted();
                return;
            case 13:
                ARPEngine.getInstance().onTempleLoadCompleted(hashMap);
                return;
            case 1001:
            case 1003:
            case 1005:
            case 1007:
            case 1012:
                a(hashMap, i);
                return;
            case 1021:
            case 1023:
            case 1025:
            case ARPMessageType.MSG_TYPE_VIDEO_STOP /* 1027 */:
                b(hashMap, i);
                return;
            case 1401:
                h(hashMap);
                return;
            case 1501:
                g(hashMap);
                return;
            case ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE /* 1901 */:
                f(hashMap);
                return;
            default:
                return;
        }
    }
}
