package com.baidu.tbadk.core.util.videoPreload;

import android.text.TextUtils;
import com.baidu.tbadk.switchs.VideoPreLoadSwitch;
import d.b.b.e.p.j;
import d.b.h0.r.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PreLoadVideoSwitchManager {
    public static final int DEFAULT_PRE_LOAD_SIZE = 512000;
    public static final int MAX_PRE_LOAD_NUM = 3;
    public static final int MAX_SEARCH_RANGE_NUM = 10;
    public static PreLoadVideoSwitchManager sInstance;
    public int mMaxNum = 3;
    public boolean isWifi = true;
    public int mSize = 0;

    public PreLoadVideoSwitchManager() {
        VideoPreLoadLog.log("PreLoadVideoSwitchManager init ");
        try {
            parseJson(b.i().o("video_sync_switch_json", ""));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static PreLoadVideoSwitchManager getInstance() {
        if (sInstance == null) {
            synchronized (PreLoadVideoSwitchManager.class) {
                if (sInstance == null) {
                    sInstance = new PreLoadVideoSwitchManager();
                }
            }
        }
        return sInstance;
    }

    private void parseJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        this.mMaxNum = jSONObject.optInt("num", 3);
        this.isWifi = jSONObject.optInt("is_wifi", 1) == 1;
        this.mSize = jSONObject.optInt("size", 512000);
        VideoPreLoadLog.log("PreLoadVideoSwitchManager parseJson:   num: " + this.mMaxNum + " size: " + this.mSize + " isWifi " + this.isWifi);
    }

    public int getMaxPreLoadNum() {
        return this.mMaxNum;
    }

    public int getSize() {
        int i = this.mSize;
        if (i == 0) {
            return 512000;
        }
        return i;
    }

    public boolean isOpen() {
        if (VideoPreLoadSwitch.isOn()) {
            return !this.isWifi || j.H();
        }
        VideoPreLoadLog.log("PreLoadVideoSwitchManager isOpen switch close ");
        return false;
    }

    public void setSyncSwitchJson(String str) {
        VideoPreLoadLog.log("PreLoadVideoSwitchManager setSyncSwitchJson: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            parseJson(str);
            b.i().w("video_sync_switch_json", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
