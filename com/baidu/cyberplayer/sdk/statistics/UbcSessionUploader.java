package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class UbcSessionUploader {
    @Keep
    public static final int UBC_TYPE_BAIDU_URL = -1009;
    @Keep
    public static final int UBC_TYPE_BAIDU_URL_EXP = -1006;
    @Keep
    public static final int UBC_TYPE_CYBER_DOWN_INIT = -1012;
    @Keep
    public static final int UBC_TYPE_DOWNLOAD = -1003;
    @Keep
    public static final int UBC_TYPE_FLOW_STAT = -1008;
    @Keep
    public static final int UBC_TYPE_GRAY_RELEASE = -1004;
    @Keep
    public static final int UBC_TYPE_INIT = -1010;
    @Keep
    public static final int UBC_TYPE_NOT_BAIDU_URL = -1007;
    @Keep
    public static final int UBC_TYPE_NO_START = -1005;
    @Keep
    public static final int UBC_TYPE_VIDEO_DEAD_LINK = -1011;
    public static UbcSessionUploader a;
    public Object b = null;
    public Method c = null;

    public UbcSessionUploader() {
        a();
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
    public void upload(String str, String str2) {
        Method method;
        Object obj;
        if (com.baidu.cyberplayer.sdk.e.a().e() && (method = this.c) != null && (obj = this.b) != null) {
            try {
                method.invoke(obj, str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Keep
    public void upload(String str, String str2, int i) {
        String str3;
        if (com.baidu.cyberplayer.sdk.e.a().e() && this.c != null && this.b != null) {
            switch (i) {
                case -1012:
                    str3 = "5960";
                    break;
                case -1011:
                    str3 = "5927";
                    break;
                case -1010:
                    str3 = "5787";
                    break;
                case -1009:
                    str3 = "5793";
                    break;
                case -1008:
                    str3 = "5792";
                    break;
                case -1007:
                    str3 = "5791";
                    break;
                case -1006:
                    str3 = "5790";
                    break;
                case -1005:
                    str3 = "5789";
                    break;
                case -1004:
                    str3 = "5786";
                    break;
                case -1003:
                    str3 = "5785";
                    break;
                default:
                    return;
            }
            try {
                this.c.invoke(this.b, str3, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
