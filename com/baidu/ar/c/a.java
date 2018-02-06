package com.baidu.ar.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.b.a;
import com.baidu.ar.b.d;
import com.baidu.ar.bean.BrowserBean;
import com.baidu.ar.bean.c;
import com.baidu.ar.bean.f;
import com.baidu.ar.bean.g;
import com.baidu.ar.external.app.IARCallback;
import com.baidu.ar.slam.SlamStateMachine;
import com.baidu.ar.track.TrackStateMachine;
import com.baidu.baiduarsdk.ArBridge;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements ArBridge.MessageHandler {
    private Context a;
    private int b;
    private IARCallback d;
    private b g;
    private boolean c = true;
    private boolean f = false;
    private Map<String, Integer> e = new Hashtable();

    public a(Context context, com.baidu.ar.arspeech.a aVar) {
        this.b = 0;
        this.a = context;
        this.b = com.baidu.ar.external.a.a.a.a().b();
        this.g = new b(context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.ar.bean.a aVar, final HashMap<String, Object> hashMap) {
        if (aVar.b() > 1) {
            this.e.put(aVar.a(), Integer.valueOf(aVar.b()));
        }
        a(1002, hashMap);
        com.baidu.ar.b.a.a().a(new a.InterfaceC0037a() { // from class: com.baidu.ar.c.a.1
            @Override // com.baidu.ar.b.a.InterfaceC0037a
            public void a(Exception exc) {
                a.this.a(1010, hashMap);
            }

            @Override // com.baidu.ar.b.a.InterfaceC0037a
            public void a(boolean z) {
            }
        }, aVar.a(), aVar.c(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.c.a.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.e.size() <= 0) {
                    a.this.a(1009, hashMap);
                    return;
                }
                int b = a.b(a.this.e, aVar.a());
                if (b <= 1) {
                    a.this.a(1009, hashMap);
                    return;
                }
                a.this.a(aVar, hashMap);
                int i = b - 1;
                a.this.e.put(aVar.a(), Integer.valueOf(i));
                aVar.a(i);
            }
        }, aVar.b());
    }

    private void a(c cVar) {
        com.baidu.ar.h.a.a().a("phone_call");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + cVar.a()));
        if (intent.resolveActivity(this.a.getPackageManager()) != null) {
            this.a.startActivity(intent);
        }
    }

    private void a(f fVar) {
        long[] jArr = null;
        com.baidu.ar.h.a.a().a("vibrate");
        switch (fVar.a()) {
            case 0:
                com.baidu.ar.b.c.a(this.a).a(fVar.b());
                return;
            case 1:
                String[] split = fVar.c() != null ? fVar.c().split(Constants.ACCEPT_TIME_SEPARATOR_SP) : null;
                if (split != null && split.length > 0) {
                    int length = split.length;
                    jArr = new long[length];
                    for (int i = 0; i < length; i++) {
                        jArr[i] = Long.parseLong(split[i]);
                    }
                }
                com.baidu.ar.b.c.a(this.a).a(jArr);
                return;
            default:
                return;
        }
    }

    private void a(g gVar, final HashMap<String, Object> hashMap) {
        a(ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_RES, hashMap);
        d.a().a(new d.a() { // from class: com.baidu.ar.c.a.10
        }, gVar.a(), gVar.c(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.c.a.11
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                a.this.a(ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_FINISH, hashMap);
            }
        }, gVar.b(), gVar.d());
    }

    private void a(HashMap<String, Object> hashMap) {
        BrowserBean browserBean = new BrowserBean();
        browserBean.a(((Integer) hashMap.get("type")).intValue());
        browserBean.a((String) hashMap.get("url"));
        if (browserBean.b() == BrowserBean.OPENTYPE.DEFAULT_TYPE.ordinal()) {
            if (this.d != null) {
                this.d.executeCommand(this.a, browserBean.a());
            }
        } else if (browserBean.b() != BrowserBean.OPENTYPE.SHOUBAI_O2O_TYPE.ordinal() || this.d == null) {
        } else {
            this.d.executeCommandWithO2O(this.a, browserBean.a());
        }
    }

    private void a(HashMap<String, Object> hashMap, int i) {
        com.baidu.ar.bean.a aVar = new com.baidu.ar.bean.a();
        aVar.b((String) hashMap.get("url"));
        aVar.a(((Float) hashMap.get("delay")).floatValue());
        aVar.a((String) hashMap.get("id"));
        aVar.a(((Integer) hashMap.get("loop")).intValue());
        switch (i) {
            case 1001:
                a(aVar, hashMap);
                return;
            case 1002:
            case 1004:
            case 1006:
            default:
                return;
            case 1003:
                b(aVar, hashMap);
                return;
            case 1005:
                c(aVar, hashMap);
                return;
            case 1007:
                d(aVar, hashMap);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static void b(int i) {
        switch (i) {
            case -90:
                ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_LANDSCAPE_LEFT, null);
                return;
            case 0:
                ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_PORTRAIT, null);
                return;
            case 90:
                ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_LANDSCAPE_RIGHT, null);
                return;
            default:
                return;
        }
    }

    private void b(com.baidu.ar.bean.a aVar, final HashMap<String, Object> hashMap) {
        a(1004, hashMap);
        com.baidu.ar.b.a.a().a(new a.InterfaceC0037a() { // from class: com.baidu.ar.c.a.6
            @Override // com.baidu.ar.b.a.InterfaceC0037a
            public void a(Exception exc) {
                a.this.a(1010, hashMap);
            }

            @Override // com.baidu.ar.b.a.InterfaceC0037a
            public void a(boolean z) {
            }
        }, aVar.a());
    }

    private void b(g gVar, final HashMap<String, Object> hashMap) {
        a(1024, hashMap);
        d.a().a(new d.a() { // from class: com.baidu.ar.c.a.12
        }, gVar.a());
    }

    private void b(HashMap<String, Object> hashMap) {
        c cVar = new c();
        cVar.a((String) hashMap.get("number"));
        a(cVar);
    }

    private void b(HashMap<String, Object> hashMap, int i) {
        g gVar = new g();
        gVar.b((String) hashMap.get("url"));
        gVar.a((String) hashMap.get("id"));
        gVar.a(((Integer) hashMap.get("texture_id")).intValue());
        gVar.b(((Integer) hashMap.get("loop")).intValue());
        switch (i) {
            case 1021:
                a(gVar, hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_RES /* 1022 */:
            case 1024:
            case ArBridge.MessageType.MSG_TYPE_VIDEO_RESUME_RES /* 1026 */:
            default:
                return;
            case ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE /* 1023 */:
                b(gVar, hashMap);
                return;
            case 1025:
                c(gVar, hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_VIDEO_STOP /* 1027 */:
                d(gVar, hashMap);
                return;
        }
    }

    private void c() {
        ArBridge.getInstance().setVideoUpdateCallback(new ArBridge.VideoUpdateCallback() { // from class: com.baidu.ar.c.a.4
            @Override // com.baidu.baiduarsdk.ArBridge.VideoUpdateCallback
            public void onUpdateVideoFrame(String str, int i, String str2) {
                SurfaceTexture c = d.a().c(str);
                if (c != null) {
                    try {
                        if (d.a().b(str) != i) {
                            d.a().a(str, i);
                        }
                        c.updateTexImage();
                    } catch (RuntimeException e) {
                        d.a().a(str, i);
                    }
                }
            }
        });
    }

    private void c(final com.baidu.ar.bean.a aVar, final HashMap<String, Object> hashMap) {
        a(1006, hashMap);
        com.baidu.ar.b.a.a().b(new a.InterfaceC0037a() { // from class: com.baidu.ar.c.a.7
            @Override // com.baidu.ar.b.a.InterfaceC0037a
            public void a(Exception exc) {
                a.this.a(1010, hashMap);
            }

            @Override // com.baidu.ar.b.a.InterfaceC0037a
            public void a(boolean z) {
            }
        }, aVar.a(), aVar.c(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.c.a.8
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.e.size() <= 0) {
                    a.this.a(1009, hashMap);
                    return;
                }
                int b = a.b(a.this.e, aVar.a());
                if (b <= 1) {
                    a.this.a(1009, hashMap);
                    return;
                }
                a.this.a(aVar, hashMap);
                int i = b - 1;
                a.this.e.put(aVar.a(), Integer.valueOf(i));
                aVar.a(i);
            }
        }, aVar.b());
    }

    private void c(g gVar, final HashMap<String, Object> hashMap) {
        a(ArBridge.MessageType.MSG_TYPE_VIDEO_RESUME_RES, hashMap);
        d.a().c(new d.a() { // from class: com.baidu.ar.c.a.2
        }, gVar.a());
    }

    private void c(HashMap<String, Object> hashMap) {
        f fVar = new f();
        fVar.a(((Integer) hashMap.get("type")).intValue());
        fVar.b(((Integer) hashMap.get("interval")).intValue());
        fVar.a((String) hashMap.get("pattern"));
        a(fVar);
    }

    private void d(com.baidu.ar.bean.a aVar, final HashMap<String, Object> hashMap) {
        a(1008, hashMap);
        com.baidu.ar.b.a.a().b(new a.InterfaceC0037a() { // from class: com.baidu.ar.c.a.9
            @Override // com.baidu.ar.b.a.InterfaceC0037a
            public void a(Exception exc) {
                a.this.a(1010, hashMap);
            }

            @Override // com.baidu.ar.b.a.InterfaceC0037a
            public void a(boolean z) {
            }
        }, aVar.a());
    }

    private void d(g gVar, final HashMap<String, Object> hashMap) {
        a(ArBridge.MessageType.MSG_TYPE_VIDEO_STOP_RES, hashMap);
        d.a().b(new d.a() { // from class: com.baidu.ar.c.a.3
        }, gVar.a());
    }

    private void d(HashMap<String, Object> hashMap) {
    }

    private void e(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            String str = (String) hashMap.get("id");
            String str2 = (String) hashMap.get("type");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            com.baidu.ar.h.a.a().a(str2, str);
        }
    }

    public void a() {
        a(1001);
        a(1003);
        a(1005);
        a(1007);
        a(1021);
        a(ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE);
        a(1025);
        a(ArBridge.MessageType.MSG_TYPE_VIDEO_STOP);
        a(ArBridge.MessageType.MSG_TYPE_OPEN_URL);
        a(ArBridge.MessageType.MSG_TYPE_PHONE_CALL);
        a(ArBridge.MessageType.MSG_TYPE_VIBERATOR);
        a(ArBridge.MessageType.MSG_TYPE_SHARE);
        a(9);
        a(201);
        a(202);
        a(301);
        a(303);
        a(ArBridge.MessageType.MSG_TYPE_STATISTICS);
        a(ArBridge.MessageType.MSG_TYPE_LUA_SDK_BRIDGE);
        a(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE);
        a(2001);
        c();
        this.f = true;
    }

    public void a(int i) {
        ArBridge.getInstance().registerMessageHandler(i, this);
    }

    public void a(int i, HashMap<String, Object> hashMap) {
        ArBridge.getInstance().sendMessage(i, hashMap);
    }

    public void a(IARCallback iARCallback) {
        this.d = iARCallback;
    }

    public void b() {
        if (this.f) {
            ArBridge.getInstance().removeMessageHandeler(this);
            this.f = false;
        }
        if (this.e != null) {
            this.e.clear();
        }
        this.d = null;
    }

    @Override // com.baidu.baiduarsdk.ArBridge.MessageHandler
    public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 9:
                com.baidu.ar.h.a.a().a("loading_3d_model_success");
                if (this.b != 0) {
                    if (this.b == 5) {
                        SlamStateMachine.a().a(SlamStateMachine.EVENT.LOAD_MODEL_FINISH);
                        return;
                    }
                    return;
                }
                int i3 = 0;
                Bundle bundle = new Bundle();
                if (hashMap != null && hashMap.containsKey("show_immediately")) {
                    i3 = ((Integer) hashMap.get("show_immediately")).intValue();
                }
                bundle.putInt("show_immediately", i3);
                TrackStateMachine.a().a(TrackStateMachine.EVENT.LOAD_MODEL_FINISH, bundle);
                return;
            case 201:
                if (this.b == 0) {
                    TrackStateMachine.a().a(TrackStateMachine.EVENT.MODEL_APPEAR);
                    return;
                } else if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.MODEL_APPEAR);
                    return;
                } else {
                    return;
                }
            case 202:
                if (this.b == 0) {
                    TrackStateMachine.a().a(TrackStateMachine.EVENT.MODEL_DISAPPEAR);
                    return;
                } else if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.MODEL_DISAPPEAR);
                    return;
                } else {
                    return;
                }
            case 301:
                if (hashMap == null || !hashMap.containsKey("type")) {
                    return;
                }
                int intValue = ((Integer) hashMap.get("type")).intValue();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("type", intValue);
                if (this.b == 0) {
                    ArBridge.getInstance().setImuType(intValue);
                    TrackStateMachine.a().a(TrackStateMachine.EVENT.TRACK_IMU_OPEN, bundle2);
                    return;
                } else if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_IMU_OPEN, bundle2);
                    return;
                } else {
                    return;
                }
            case 303:
                if (this.b == 0) {
                    TrackStateMachine.a().a(TrackStateMachine.EVENT.TRACK_IMU_CLOSE);
                    return;
                } else if (this.b == 5) {
                    SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_IMU_CLOSE);
                    return;
                } else {
                    return;
                }
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
            case ArBridge.MessageType.MSG_TYPE_OPEN_URL /* 1301 */:
                a(hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_PHONE_CALL /* 1401 */:
                b(hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_VIBERATOR /* 1501 */:
                c(hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_SHARE /* 1601 */:
                d(hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_STATISTICS /* 1801 */:
                e(hashMap);
                return;
            case ArBridge.MessageType.MSG_TYPE_LUA_SDK_BRIDGE /* 1901 */:
                if (this.g != null) {
                    this.g.a(hashMap);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
