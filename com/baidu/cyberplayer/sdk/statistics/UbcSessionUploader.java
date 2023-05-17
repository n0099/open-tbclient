package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class UbcSessionUploader {
    @Keep
    public static final int PLAY_SESSION_STAGE_TYPE_UBC_LIVE = -1002;
    @Keep
    public static final int PLAY_SESSION_STAGE_TYPE_UBC_VOD = -1001;
    public static UbcSessionUploader a;
    public Object b = null;
    public Method c = null;

    public UbcSessionUploader() {
        a();
    }

    private void a() {
        try {
            Class<?> cls = Class.forName("com.baidu.ubc.UBCManager");
            Class<?> cls2 = Class.forName("com.baidu.pyramid.runtime.service.ServiceManager");
            Field declaredField = cls.getDeclaredField("SERVICE_REFERENCE");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                this.b = cls2.getDeclaredMethod("getService", Class.forName("com.baidu.pyramid.runtime.service.ServiceReference")).invoke(null, declaredField.get(null));
                this.c = cls.getDeclaredMethod("onEvent", String.class, String.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Keep
    public static synchronized UbcSessionUploader getInstance() {
        UbcSessionUploader ubcSessionUploader;
        synchronized (UbcSessionUploader.class) {
            if (a == null) {
                a = new UbcSessionUploader();
            }
            ubcSessionUploader = a;
        }
        return ubcSessionUploader;
    }

    @Keep
    public void upload(String str, String str2, int i) {
        if (!com.baidu.cyberplayer.sdk.c.a().d() || this.c == null || this.b == null) {
            return;
        }
        try {
            this.c.invoke(this.b, i == -1001 ? "2360" : "2368", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
