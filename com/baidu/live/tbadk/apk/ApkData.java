package com.baidu.live.tbadk.apk;
/* loaded from: classes3.dex */
public class ApkData {
    public static final long APK_OVERTIME_IVERVAL = 604800000;
    public String apkClipBoardScheme;
    public String apkDeeplinkScheme;
    public String apkOldDeeplinkScheme;
    public String apkPackageName;
    public String apkPath;
    public ApkStatusCallback apkStatusCallBack;
    public String apkUrl;
    public long overTimeIntervalMs = 604800000;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public ApkData m21clone() {
        ApkData apkData = new ApkData();
        apkData.apkUrl = this.apkUrl;
        apkData.apkPackageName = this.apkPackageName;
        apkData.apkPath = this.apkPath;
        apkData.apkDeeplinkScheme = this.apkDeeplinkScheme;
        apkData.apkOldDeeplinkScheme = this.apkOldDeeplinkScheme;
        apkData.apkClipBoardScheme = this.apkClipBoardScheme;
        apkData.overTimeIntervalMs = this.overTimeIntervalMs;
        return apkData;
    }
}
