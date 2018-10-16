package com.baidu.baiduarsdk.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.Log;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.baiduarsdk.a.a.c;
import com.baidu.baiduarsdk.a.a.d;
import com.baidu.baiduarsdk.a.e;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a implements ArBridge.d {
    private Context a;
    private ArBridge.e b = new ArBridge.e() { // from class: com.baidu.baiduarsdk.b.a.1
        @Override // com.baidu.baiduarsdk.ArBridge.e
        public void a(String str, int i, String str2, String str3) {
            SurfaceTexture c = e.a().c(str);
            if (c != null) {
                try {
                    if (e.a().b(str) != i) {
                        e.a().a(str, i);
                    }
                    c.updateTexImage();
                } catch (RuntimeException e) {
                    e.a().a(str, i);
                }
            }
        }
    };

    public a(Context context) {
        this.a = context.getApplicationContext();
        c();
    }

    private void a(c cVar) {
        a(StatisticConstants.PHONE_CALL);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WebView.SCHEME_TEL + cVar.a()));
        if (intent.resolveActivity(this.a.getPackageManager()) != null) {
            this.a.startActivity(intent);
        }
    }

    private void a(d dVar) {
        long[] jArr = null;
        a(StatisticConstants.VIBRATE);
        switch (dVar.a()) {
            case 0:
                com.baidu.baiduarsdk.a.d.a(this.a).a(dVar.b());
                return;
            case 1:
                String[] split = dVar.c() != null ? dVar.c().split(",") : null;
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
                com.baidu.baiduarsdk.a.d.a(this.a).a(jArr);
                return;
            default:
                return;
        }
    }

    private void a(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("type", str);
        a(1801, 0, hashMap);
    }

    private void a(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        d dVar = new d();
        if (hashMap.get("type") != null) {
            dVar.a(MsgParamsUtil.obj2Int(hashMap.get("type"), 0));
        }
        if (hashMap.get(AiAppsBluetoothConstants.KEY_INTERVAL) != null) {
            dVar.b(MsgParamsUtil.obj2Int(hashMap.get(AiAppsBluetoothConstants.KEY_INTERVAL), 0));
        }
        if (hashMap.get("pattern") != null) {
            dVar.a(MsgParamsUtil.obj2String(hashMap.get("pattern"), null));
        }
        a(dVar);
    }

    private void a(HashMap<String, Object> hashMap, int i) {
        if (hashMap == null) {
            return;
        }
        com.baidu.baiduarsdk.a.a.a aVar = new com.baidu.baiduarsdk.a.a.a();
        if (hashMap.get("url") != null) {
            aVar.b(MsgParamsUtil.obj2String(hashMap.get("url"), null));
        }
        if (hashMap.get("delay") != null) {
            aVar.a(((Float) hashMap.get("delay")).floatValue());
        }
        if (hashMap.get("id") != null) {
            aVar.a(MsgParamsUtil.obj2String(hashMap.get("id"), null));
        }
        if (hashMap.get("loop") != null) {
            int intValue = ((Integer) hashMap.get("loop")).intValue();
            aVar.a(intValue);
            if (intValue <= 0) {
                aVar.a(true);
            }
        }
        if (hashMap.get(BaiduRimConstants.ACTION_TARGET) != null) {
            aVar.c(MsgParamsUtil.obj2String(hashMap.get(BaiduRimConstants.ACTION_TARGET), null));
        }
        if (hashMap.get("from_time") != null) {
            aVar.a(MsgParamsUtil.obj2Int(hashMap.get("from_time"), 0));
        }
        switch (i) {
            case 1001:
                com.baidu.baiduarsdk.a.a.a().a(aVar, hashMap);
                return;
            case 1002:
            case 1004:
            case 1006:
            default:
                return;
            case 1003:
                com.baidu.baiduarsdk.a.a.a().b(aVar, hashMap);
                return;
            case 1005:
                com.baidu.baiduarsdk.a.a.a().c(aVar, hashMap);
                return;
            case 1007:
                com.baidu.baiduarsdk.a.a.a().d(aVar, hashMap);
                return;
        }
    }

    private void b(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        c cVar = new c();
        Object obj = hashMap.get("number");
        if (obj != null) {
            cVar.a((String) obj);
        }
        a(cVar);
    }

    private void b(HashMap<String, Object> hashMap, int i) {
        if (hashMap == null) {
            return;
        }
        com.baidu.baiduarsdk.a.a.e eVar = new com.baidu.baiduarsdk.a.a.e();
        if (hashMap.get("url") != null) {
            eVar.b(MsgParamsUtil.obj2String(hashMap.get("url"), null));
        }
        if (hashMap.get("id") != null) {
            eVar.a(MsgParamsUtil.obj2String(hashMap.get("id"), null));
        }
        if (hashMap.get("texture_id") != null) {
            eVar.a(MsgParamsUtil.obj2Int(hashMap.get("texture_id"), -1));
        }
        if (hashMap.get("loop") != null) {
            int obj2Int = MsgParamsUtil.obj2Int(hashMap.get("loop"), 0);
            eVar.b(MsgParamsUtil.obj2Int(hashMap.get("loop"), 0));
            if (obj2Int <= 0) {
                eVar.a(true);
            }
        }
        if (hashMap.get(BaiduRimConstants.ACTION_TARGET) != null) {
            eVar.c(MsgParamsUtil.obj2String(hashMap.get(BaiduRimConstants.ACTION_TARGET), null));
        }
        if (hashMap.get("from_time") != null) {
            eVar.a(MsgParamsUtil.obj2Int(hashMap.get("from_time"), 0));
            Log.e("VideoTest", "bean fromTime: " + eVar.f());
        }
        switch (i) {
            case 1021:
                e.a().a(eVar, hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_RES /* 1022 */:
            case 1024:
            case ArBridge.MessageType.MSG_TYPE_VIDEO_RESUME_RES /* 1026 */:
            default:
                return;
            case ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE /* 1023 */:
                e.a().b(eVar, hashMap);
                return;
            case 1025:
                e.a().c(eVar, hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_VIDEO_STOP /* 1027 */:
                e.a().d(eVar, hashMap);
                return;
        }
    }

    private void c() {
        ArBridge.getInstance().setVideoUpdateCallback(this.b);
    }

    public void a() {
        this.b = null;
    }

    @Override // com.baidu.baiduarsdk.ArBridge.d
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 0:
                if (i2 == -2) {
                    e.a().b();
                    com.baidu.baiduarsdk.a.a.a().b();
                    return;
                }
                return;
            case 1001:
            case 1003:
            case 1005:
            case 1007:
                a(hashMap, i);
                return;
            case 1021:
            case ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE /* 1023 */:
            case 1025:
            case ArBridge.MessageType.MSG_TYPE_VIDEO_STOP /* 1027 */:
                b(hashMap, i);
                return;
            case 1401:
                b(hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_VIBERATOR /* 1501 */:
                a(hashMap);
                return;
            default:
                return;
        }
    }

    public void b() {
        ArBridge.getInstance().registerMessageHandler(0, this);
        ArBridge.getInstance().initDataStore(this.a.getSharedPreferences("baiduar_lua_data_store", 0));
    }
}
