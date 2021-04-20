package com.baidu.mobads.container.config;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.mobads.container.util.cache.LruDiskCache;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AppConfigImp {
    public static final String KEY_APPSID = "appsid";
    public static final String KEY_CHANNELID = "channelId";
    public static final String KEY_HTTPS = "https";
    public static final String KEY_LP_MULTIPROCESS = "lpMultiProcess";
    public static final String KEY_P_VERSION = "p_ver";
    public static final String KEY_VIDEOCACHE = "videoCacheSize";
    public static volatile AppConfigImp sInstance;
    public JSONObject mAppConObj;
    public Context mAppCxt;
    public String mAppsid;
    public String mChannelId;
    public ICommonModuleObj mCommonObj;
    public boolean mLpSupportMultiProcess;
    public String mProxyVersion;
    public boolean mSupportHttps = true;
    public int mVideoCacheSize;

    public static AppConfigImp getInstance() {
        if (sInstance == null) {
            synchronized (AppConfigImp.class) {
                if (sInstance == null) {
                    sInstance = new AppConfigImp();
                }
            }
        }
        return sInstance;
    }

    public Context getAppContext() {
        return this.mAppCxt;
    }

    public String getAppsid() {
        return this.mAppsid;
    }

    public String getChannelId() {
        return this.mChannelId;
    }

    public ICommonModuleObj getModuleObj() {
        return this.mCommonObj;
    }

    public String getProxyVersion() {
        return this.mProxyVersion;
    }

    public void initSDK(JSONObject jSONObject) {
        this.mAppConObj = jSONObject;
        String str = (String) ConvertUtils.optObjectFromJson(jSONObject, "p_ver");
        if (!TextUtils.isEmpty(str)) {
            this.mProxyVersion = str;
        }
        String str2 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, "https");
        if (!TextUtils.isEmpty(str2)) {
            this.mSupportHttps = Boolean.parseBoolean(str2);
        }
        String str3 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, KEY_VIDEOCACHE);
        if (!TextUtils.isEmpty(str3)) {
            int parseInt = Integer.parseInt(str3);
            this.mVideoCacheSize = parseInt;
            if (parseInt < 15 || parseInt > 100) {
                this.mVideoCacheSize = 50;
            }
            LruDiskCache.open(SdcardUtils.getStoragePath(this.mAppCxt) + MaterialLoader.IMAGE_CACHE_PATH, this.mVideoCacheSize * 1000 * 1000);
        }
        String str4 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, "appsid");
        if (!TextUtils.isEmpty(str4)) {
            this.mAppsid = str4;
            DeviceUtils.getInstance().setAppId(this.mAppsid);
        }
        String str5 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, KEY_CHANNELID);
        if (!TextUtils.isEmpty(str5)) {
            this.mChannelId = str5;
        }
        String str6 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, KEY_LP_MULTIPROCESS);
        if (TextUtils.isEmpty(str6)) {
            return;
        }
        this.mLpSupportMultiProcess = Boolean.parseBoolean(str6);
    }

    public boolean isLpMultiProcess() {
        return this.mLpSupportMultiProcess;
    }

    public boolean isSupportHttps() {
        return this.mSupportHttps;
    }

    public void setAppContext(Context context) {
        this.mAppCxt = context.getApplicationContext();
    }

    public void setAppsid(String str) {
        this.mAppsid = str;
    }

    public void setModuleObj(ICommonModuleObj iCommonModuleObj) {
        this.mCommonObj = iCommonModuleObj;
    }
}
