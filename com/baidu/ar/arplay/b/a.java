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
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.d.a;
import com.baidu.ar.arplay.d.b;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a implements ARPMessage.MessageHandler {
    private ARPDataInteraction.c fO = new ARPDataInteraction.c() { // from class: com.baidu.ar.arplay.b.a.1
        @Override // com.baidu.ar.arplay.core.engine.ARPDataInteraction.c
        public void a(String str, int i, String str2, String str3) {
            SurfaceTexture E = e.aL().E(str);
            if (E != null) {
                try {
                    if (e.aL().D(str) != i) {
                        e.aL().a(str, i);
                    }
                    E.updateTexImage();
                } catch (RuntimeException e) {
                    e.aL().a(str, i);
                }
            }
        }
    };
    private Context mContext;

    public a(Context context) {
        this.mContext = context.getApplicationContext();
        d.e(this.mContext);
        bi();
    }

    private void I(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("type", str);
        handleMessage(ARPMessageType.MSG_TYPE_STATISTICS, 0, hashMap);
    }

    private void a(c cVar) {
        I("phone_call");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + cVar.getNumber()));
        if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
            this.mContext.startActivity(intent);
        }
    }

    private void a(com.baidu.ar.arplay.a.a.d dVar) {
        long[] jArr = null;
        I("vibrate");
        switch (dVar.getType()) {
            case 0:
                com.baidu.ar.arplay.a.d.d(this.mContext).c(dVar.getInterval());
                return;
            case 1:
                String[] split = dVar.getPattern() != null ? dVar.getPattern().split(",") : null;
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
                com.baidu.ar.arplay.a.d.d(this.mContext).a(jArr);
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
            aVar.F(com.baidu.ar.arplay.c.c.a(hashMap.get("target"), (String) null));
        }
        if (hashMap.get("from_time") != null) {
            aVar.d(com.baidu.ar.arplay.c.c.a(hashMap.get("from_time"), 0));
        }
        switch (i) {
            case 1001:
                com.baidu.ar.arplay.a.a.aA().a(aVar, hashMap);
                return;
            case 1003:
                com.baidu.ar.arplay.a.a.aA().b(aVar, hashMap);
                return;
            case 1005:
                com.baidu.ar.arplay.a.a.aA().c(aVar, hashMap);
                return;
            case 1007:
                com.baidu.ar.arplay.a.a.aA().d(aVar, hashMap);
                return;
            case 1012:
                com.baidu.ar.arplay.a.a.aA().e(aVar, hashMap);
                return;
            default:
                return;
        }
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
            int a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("loop"), 0);
            eVar.i(com.baidu.ar.arplay.c.c.a(hashMap.get("loop"), 0));
            if (a2 <= 0) {
                eVar.g(true);
            }
        }
        if (hashMap.get("target") != null) {
            eVar.F(com.baidu.ar.arplay.c.c.a(hashMap.get("target"), (String) null));
        }
        if (hashMap.get("from_time") != null) {
            eVar.d(com.baidu.ar.arplay.c.c.a(hashMap.get("from_time"), 0));
            Log.e("VideoTest", "bean fromTime: " + eVar.aO());
        }
        switch (i) {
            case 1021:
                e.aL().a(eVar, hashMap);
                return;
            case 1022:
            case 1024:
            case ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES /* 1026 */:
            default:
                return;
            case 1023:
                e.aL().b(eVar, hashMap);
                return;
            case 1025:
                e.aL().c(eVar, hashMap);
                return;
            case ARPMessageType.MSG_TYPE_VIDEO_STOP /* 1027 */:
                e.aL().d(eVar, hashMap);
                return;
        }
    }

    private void bi() {
        ARPEngine.getInstance().setVideoUpdateCallback(this.fO);
    }

    private void e(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get(LuaMessageHelper.KEY_EVENT_NAME), "");
        a.C0077a c0077a = new a.C0077a();
        if ("load_webview".equals(a2)) {
            c0077a.dM = com.baidu.ar.arplay.c.c.a(hashMap.get("texture_id"), 0);
            c0077a.width = com.baidu.ar.arplay.c.c.a(hashMap.get("width"), 0);
            c0077a.height = com.baidu.ar.arplay.c.c.a(hashMap.get("height"), 0);
            c0077a.url = com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null);
            c0077a.gd = com.baidu.ar.arplay.c.c.a(hashMap.get("is_remote"), 0) == 1;
            b.bm().c(c0077a);
        } else if ("update_webview_js".equals(a2)) {
            c0077a.dM = com.baidu.ar.arplay.c.c.a(hashMap.get("texture_id"), 0);
            c0077a.ge = com.baidu.ar.arplay.c.c.a(hashMap.get("js_code"), (String) null);
            b.bm().e(c0077a);
        } else if ("load_native_webview".equals(a2)) {
            c0077a.url = com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null);
            c0077a.gd = com.baidu.ar.arplay.c.c.a(hashMap.get("is_remote"), 0) == 1;
            b.bm().d(c0077a);
        }
    }

    private void f(HashMap<String, Object> hashMap) {
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

    private void g(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        c cVar = new c();
        Object obj = hashMap.get("number");
        if (obj != null) {
            cVar.G((String) obj);
        }
        a(cVar);
    }

    public void bh() {
        ARPMessage.getInstance().registerMessageHandler(0, this);
        ARPEngine.getInstance().initDataStore(this.mContext.getSharedPreferences("baiduar_lua_data_store", 0));
    }

    @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 0:
                if (i2 == -2) {
                    e.aL().aB();
                    com.baidu.ar.arplay.a.a.aA().aB();
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
                g(hashMap);
                return;
            case 1501:
                f(hashMap);
                return;
            case ARPMessageType.MSG_TYPE_LUA_SDK_BRIDGE /* 1901 */:
                e(hashMap);
                return;
            default:
                return;
        }
    }
}
