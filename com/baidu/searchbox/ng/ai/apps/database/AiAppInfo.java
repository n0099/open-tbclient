package com.baidu.searchbox.ng.ai.apps.database;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public final class AiAppInfo {
    public static final String DEVELOP = "0";
    public static final String ONLINE = "1";
    public static final String TRIAL = "2";
    public static final String TRIAL_EXPERIENCE = "3";
    private String appID;
    private Bitmap appLogoBitmap;
    private String appLogoUrl;
    private String appSource;
    private String appTitle;
    public String appType;

    public AiAppInfo(String str) {
        this.appID = str;
    }

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public String getAppTitle() {
        return this.appTitle;
    }

    public void setAppTitle(String str) {
        this.appTitle = str;
    }

    public Bitmap getAppLogoBitmap() {
        return this.appLogoBitmap;
    }

    public void setAppLogoBitmap(Bitmap bitmap) {
        this.appLogoBitmap = bitmap;
    }

    public String getAppSource() {
        return this.appSource;
    }

    public void setAppSource(String str) {
        this.appSource = str;
    }

    public String getAppType() {
        return this.appType;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public String getAppLogoUrl() {
        return this.appLogoUrl;
    }

    public void setAppLogoUrl(String str) {
        this.appLogoUrl = str;
    }
}
