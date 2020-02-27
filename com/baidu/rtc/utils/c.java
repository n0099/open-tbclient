package com.baidu.rtc.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.ala.helper.AlaLiveBaseInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public String mCuid;
    public String mNetWork;
    public String mStreamType;
    public String mSubAppType = "RTCSdk";
    public String mUid;
    public static final String mOSModel = Build.MODEL;
    public static final String mOSVer = Build.VERSION.RELEASE;
    public static String mAppVer = null;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("appVer", mAppVer == null ? "" : mAppVer);
            jSONObject.putOpt("deviceId", this.mCuid == null ? "" : this.mCuid);
            jSONObject.putOpt("network", this.mNetWork == null ? "" : this.mNetWork);
            jSONObject.putOpt("osType", AlaLiveBaseInfo.mOSType == 0 ? "" : AlaLiveBaseInfo.mOSType);
            jSONObject.putOpt("osVer", mOSVer == null ? "" : mOSVer);
            jSONObject.putOpt("streamType", this.mStreamType == null ? "" : this.mStreamType);
            jSONObject.putOpt("uid", this.mUid == null ? "" : this.mUid);
            jSONObject.putOpt("model", mOSModel == null ? "" : mOSModel);
            if (this.mSubAppType != null && this.mSubAppType.length() > 0) {
                jSONObject.put("subApp", this.mSubAppType);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getAppVersion(Context context) {
        if (mAppVer != null) {
            return mAppVer;
        }
        try {
            mAppVer = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return mAppVer;
    }
}
