package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class UbcSessionUploader {
    @Keep
    public static final int PLAY_SESSION_STAGE_TYPE_UBC_LIVE = -1002;
    @Keep
    public static final int PLAY_SESSION_STAGE_TYPE_UBC_VOD = -1001;

    /* renamed from: a  reason: collision with root package name */
    public static UbcSessionUploader f4996a;

    /* renamed from: b  reason: collision with root package name */
    public Object f4997b = null;

    /* renamed from: c  reason: collision with root package name */
    public Method f4998c = null;

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
                this.f4997b = cls2.getDeclaredMethod("getService", Class.forName("com.baidu.pyramid.runtime.service.ServiceReference")).invoke(null, declaredField.get(null));
                this.f4998c = cls.getDeclaredMethod("onEvent", String.class, String.class);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Keep
    public static synchronized UbcSessionUploader getInstance() {
        UbcSessionUploader ubcSessionUploader;
        synchronized (UbcSessionUploader.class) {
            if (f4996a == null) {
                f4996a = new UbcSessionUploader();
            }
            ubcSessionUploader = f4996a;
        }
        return ubcSessionUploader;
    }

    @Keep
    public void upload(String str, String str2, int i2) {
        if (!com.baidu.cyberplayer.sdk.c.a().d() || this.f4998c == null || this.f4997b == null) {
            return;
        }
        try {
            this.f4998c.invoke(this.f4997b, i2 == -1001 ? "2360" : "2368", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
