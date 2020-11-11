package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.switchs.VideoPreLoadSwitch;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static d eQK;
    private int eQL = 3;
    private boolean isWifi = true;
    private int mSize = 0;

    public static d brZ() {
        if (eQK == null) {
            synchronized (d.class) {
                if (eQK == null) {
                    eQK = new d();
                }
            }
        }
        return eQK;
    }

    private d() {
        e.log("PreLoadVideoSwitchManager init ");
        try {
            parseJson(com.baidu.tbadk.core.sharedPref.b.bqh().getString("video_sync_switch_json", ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isOpen() {
        if (VideoPreLoadSwitch.isOn()) {
            return !this.isWifi || j.isWifiNet();
        }
        e.log("PreLoadVideoSwitchManager isOpen switch close ");
        return false;
    }

    public int bsa() {
        return this.eQL;
    }

    public int getSize() {
        if (this.mSize == 0) {
            return 512000;
        }
        return this.mSize;
    }

    public void Cn(String str) {
        e.log("PreLoadVideoSwitchManager setSyncSwitchJson: " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                parseJson(str);
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("video_sync_switch_json", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJson(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            this.eQL = jSONObject.optInt("num", 3);
            this.isWifi = jSONObject.optInt("is_wifi", 1) == 1;
            this.mSize = jSONObject.optInt("size", 512000);
            e.log("PreLoadVideoSwitchManager parseJson:   num: " + this.eQL + " size: " + this.mSize + " isWifi " + this.isWifi);
        }
    }
}
