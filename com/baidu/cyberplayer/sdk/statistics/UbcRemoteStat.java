package com.baidu.cyberplayer.sdk.statistics;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcRemoteStat implements ComponentCallbacks2 {
    public static final String BINDER_DIED = "died";
    public static final String BIND_FAILED = "bindFail";
    public static final String BIND_SERVICE = "bind";
    public static final String CONNECTED = "conn";
    public static final String DISCONNECTED = "disc";
    public static final String LINK_DEATH_FAILED = "link2deathFail";
    public static volatile UbcRemoteStat sInstance;
    public volatile JSONObject mExtJson = new JSONObject();
    public volatile JSONObject mBinderJson = new JSONObject();
    public volatile JSONObject mDiedJson = new JSONObject();
    public volatile int mTrimMemValue = -1;
    public volatile long mLowMemTime = -1;
    public volatile long mMainProcTag = -1;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public static UbcRemoteStat getInstance() {
        if (sInstance == null) {
            synchronized (UbcRemoteStat.class) {
                if (sInstance == null) {
                    sInstance = new UbcRemoteStat();
                }
            }
        }
        return sInstance;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mLowMemTime = System.currentTimeMillis();
    }

    private void clearJson(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            keys.next();
            keys.remove();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.mTrimMemValue = i;
    }

    public void setMainProcTag(long j) {
        this.mMainProcTag = j;
    }

    public void updateUbcStat(String str, long j) {
        if (str != null && !str.isEmpty()) {
            try {
                this.mBinderJson.put(str, j);
                if (str.equals(BINDER_DIED)) {
                    this.mDiedJson.put("time", j);
                    this.mDiedJson.put("lowMem", this.mLowMemTime);
                    this.mDiedJson.put("trimMem", this.mTrimMemValue);
                    this.mBinderJson.put(BINDER_DIED, this.mDiedJson);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void uploadUbcStat() {
        if (this.mBinderJson.length() > 0 && CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_MEDIA_PROCESS_UBC, true)) {
            try {
                this.mBinderJson.put("MPId", this.mMainProcTag);
                this.mExtJson.put("ext", this.mBinderJson);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcSessionUploader.getInstance().upload(UbcSessionUploader.UBC_SUBP_ID, this.mExtJson.toString());
            this.mLowMemTime = -1L;
            this.mTrimMemValue = -1;
            clearJson(this.mDiedJson);
            clearJson(this.mBinderJson);
            clearJson(this.mExtJson);
        }
    }
}
