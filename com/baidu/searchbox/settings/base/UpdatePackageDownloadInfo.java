package com.baidu.searchbox.settings.base;
/* loaded from: classes4.dex */
public class UpdatePackageDownloadInfo {
    public static final String JSON_KEY_FULL_URL = "full_url";
    public static final String JSON_KEY_PATCH_MD5 = "patch_md5";
    public static final String JSON_KEY_PATCH_URL = "patch_url";
    public static final String JSON_KEY_URI_STRING = "uri_string";
    public String mFullUrl;
    public String mPatchMd5;
    public String mPatchUrl;
    public String mUriString;

    public UpdatePackageDownloadInfo(String str, String str2, String str3, String str4) {
        this.mUriString = str;
        this.mFullUrl = str2;
        this.mPatchUrl = str3;
        this.mPatchMd5 = str4;
    }

    public String getFullUrl() {
        return this.mFullUrl;
    }

    public String getPatchMd5() {
        return this.mPatchMd5;
    }

    public String getPatchUrl() {
        return this.mPatchUrl;
    }

    public String getUriString() {
        return this.mUriString;
    }
}
