package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.switchs.VideoPreLoadSwitch;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static d enS;
    private int enT = 3;
    private boolean isWifi = true;
    private int mSize = 0;

    public static d bkb() {
        if (enS == null) {
            synchronized (d.class) {
                if (enS == null) {
                    enS = new d();
                }
            }
        }
        return enS;
    }

    private d() {
        e.log("PreLoadVideoSwitchManager init ");
        try {
            parseJson(com.baidu.tbadk.core.sharedPref.b.bik().getString("video_sync_switch_json", ""));
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

    public int bkc() {
        return this.enT;
    }

    public int getSize() {
        if (this.mSize == 0) {
            return 512000;
        }
        return this.mSize;
    }

    public void Ax(String str) {
        e.log("PreLoadVideoSwitchManager setSyncSwitchJson: " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                parseJson(str);
                com.baidu.tbadk.core.sharedPref.b.bik().putString("video_sync_switch_json", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJson(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            this.enT = jSONObject.optInt("num", 3);
            this.isWifi = jSONObject.optInt("is_wifi", 1) == 1;
            this.mSize = jSONObject.optInt("size", 512000);
            e.log("PreLoadVideoSwitchManager parseJson:   num: " + this.enT + " size: " + this.mSize + " isWifi " + this.isWifi);
        }
    }
}
