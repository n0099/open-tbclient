package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberGlobalSetting;
import com.baidu.cyberplayer.sdk.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class UbcSessionUploader {
    public static final String SERVICE_MANAGER_CALSS_NAME = "com.baidu.pyramid.runtime.service.ServiceManager";
    public static final String SERVICE_REFERENCE_CLASS_NAME = "com.baidu.pyramid.runtime.service.ServiceReference";
    public static final String TAG = "UbcSessionUploader";
    public static final String UBC_BAIDUURLEXP_ID = "5790";
    public static final String UBC_BAIDUURL_ID = "5793";
    public static final String UBC_CYBERDOWN_ID = "5960";
    public static final String UBC_DEADLINK_ID = "5927";
    public static final String UBC_DOWNLOAD_ID = "5785";
    public static final String UBC_FLOWSTAT_ID = "5792";
    public static final String UBC_GRAYRELEASE_ID = "5786";
    public static final String UBC_INIT_ID = "5787";
    public static final String UBC_MANAGER_CLASS_NAME = "com.baidu.ubc.UBCManager";
    public static final String UBC_NOSTART_ID = "5789";
    public static final String UBC_NOTBAIDUURL_ID = "5791";
    public static final String UBC_SUBP_ID = "5248";
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
    public static UbcSessionUploader ubcInstance;
    public Object mUbcManager = null;
    public Method mOnEvent = null;

    public UbcSessionUploader() {
        initUbcSDK();
    }

    @Keep
    public static synchronized UbcSessionUploader getInstance() {
        UbcSessionUploader ubcSessionUploader;
        synchronized (UbcSessionUploader.class) {
            if (ubcInstance == null) {
                ubcInstance = new UbcSessionUploader();
            }
            ubcSessionUploader = ubcInstance;
        }
        return ubcSessionUploader;
    }

    private void initUbcSDK() {
        try {
            Class<?> cls = Class.forName(UBC_MANAGER_CLASS_NAME);
            Class<?> cls2 = Class.forName(SERVICE_MANAGER_CALSS_NAME);
            Field declaredField = cls.getDeclaredField("SERVICE_REFERENCE");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                this.mUbcManager = cls2.getDeclaredMethod("getService", Class.forName(SERVICE_REFERENCE_CLASS_NAME)).invoke(null, declaredField.get(null));
                this.mOnEvent = cls.getDeclaredMethod("onEvent", String.class, String.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Keep
    public void upload(String str, String str2) {
        Method method;
        Object obj;
        if (CyberGlobalSetting.getInstance().isUbcUploadEnable() && (method = this.mOnEvent) != null && (obj = this.mUbcManager) != null) {
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
        if (CyberGlobalSetting.getInstance().isUbcUploadEnable() && this.mOnEvent != null && this.mUbcManager != null) {
            switch (i) {
                case -1012:
                    str3 = UBC_CYBERDOWN_ID;
                    break;
                case -1011:
                    str3 = UBC_DEADLINK_ID;
                    break;
                case -1010:
                    str3 = UBC_INIT_ID;
                    break;
                case -1009:
                    str3 = UBC_BAIDUURL_ID;
                    break;
                case -1008:
                    str3 = UBC_FLOWSTAT_ID;
                    break;
                case -1007:
                    str3 = UBC_NOTBAIDUURL_ID;
                    break;
                case -1006:
                    str3 = UBC_BAIDUURLEXP_ID;
                    break;
                case -1005:
                    str3 = UBC_NOSTART_ID;
                    break;
                case -1004:
                    str3 = UBC_GRAYRELEASE_ID;
                    break;
                case -1003:
                    str3 = UBC_DOWNLOAD_ID;
                    break;
                default:
                    return;
            }
            try {
                this.mOnEvent.invoke(this.mUbcManager, str3, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
