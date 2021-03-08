package com.baidu.clientupdate.appinfo;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class AppInfo implements Serializable {
    public String mApkMd5;
    public String mChangelog;
    public String mDownurl;
    public String mIconUrl;
    public String mPackageName;
    public String mPatchDownUrl;
    public String mPatchSize;
    public String mProdline;
    public String mSign;
    public String mSignMd5;
    public String mSize;
    public String mSname;
    public String mUpdateTime;
    public String mVercode;
    public String mVername;

    public String toString() {
        return "sname: " + this.mSname + " vcode: " + this.mVercode + " vname: " + this.mVername + " downurl: " + this.mDownurl + " changelog: " + this.mChangelog + " size: " + this.mSize + " packageName: " + this.mPackageName + " signmd5: " + this.mSignMd5 + " apkmd5: " + this.mApkMd5 + " patch_downUrl: " + this.mPatchDownUrl + " patch_size: " + this.mPatchSize + " iconurl: " + this.mIconUrl;
    }
}
