package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.sdk.internal.RemoteDexLoader;
import com.baidu.mobads.sdk.internal.XAdURIUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BDAdConfig {
    public Context mAppContext;
    public String mAppName;
    public String mAppsid;
    public String mChannelId;
    public JSONObject mConfigObj;
    public boolean mHttps;
    public boolean mLpMultiProcess;
    public int mVideoCacheCapacityMb;

    /* loaded from: classes2.dex */
    public static class Builder {
        public String mAppName;
        public String mAppsid;
        public String mChannelId;
        public boolean mHttps;
        public boolean mLpSupportMultiProcess;
        public int mVideoCacheCapacityMb;

        public BDAdConfig build(Context context) {
            return new BDAdConfig(context, this);
        }

        public Builder setAppName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder setAppsid(String str) {
            this.mAppsid = str;
            return this;
        }

        public Builder setChannelId(String str) {
            this.mChannelId = str;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.mHttps = z;
            return this;
        }

        public Builder setLpMultiProcess(boolean z) {
            this.mLpSupportMultiProcess = z;
            return this;
        }

        public Builder setVideoCacheCapacityMb(int i) {
            this.mVideoCacheCapacityMb = i;
            return this;
        }
    }

    public void init() {
        JSONObject jSONObject = new JSONObject();
        this.mConfigObj = jSONObject;
        try {
            jSONObject.put("https", "" + this.mHttps);
            this.mConfigObj.put("appName", this.mAppName);
            JSONObject jSONObject2 = this.mConfigObj;
            jSONObject2.put(AppConfigImp.KEY_VIDEOCACHE, "" + this.mVideoCacheCapacityMb);
            this.mConfigObj.put("appsid", this.mAppsid);
            this.mConfigObj.put(AppConfigImp.KEY_CHANNELID, this.mChannelId);
            JSONObject jSONObject3 = this.mConfigObj;
            jSONObject3.put(AppConfigImp.KEY_LP_MULTIPROCESS, "" + this.mLpMultiProcess);
            XAdURIUtils.getInstance().setLpMultiProcess(this.mLpMultiProcess);
            XAdURIUtils.getInstance().setHttps(this.mHttps);
            RemoteDexLoader.getInstance().initRemoteDex(this.mAppContext);
            RemoteDexLoader.getInstance().getContainerFactory().initConfig(this.mConfigObj);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public BDAdConfig(Context context, Builder builder) {
        this.mHttps = builder.mHttps;
        this.mAppContext = context;
        this.mVideoCacheCapacityMb = builder.mVideoCacheCapacityMb;
        this.mAppName = builder.mAppName;
        this.mAppsid = builder.mAppsid;
        this.mChannelId = builder.mChannelId;
        this.mLpMultiProcess = builder.mLpSupportMultiProcess;
    }
}
