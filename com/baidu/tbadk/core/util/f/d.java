package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.switchs.VideoPreLoadSwitch;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static d eXa;
    private int eXb = 3;
    private boolean isWifi = true;
    private int mSize = 0;

    public static d buK() {
        if (eXa == null) {
            synchronized (d.class) {
                if (eXa == null) {
                    eXa = new d();
                }
            }
        }
        return eXa;
    }

    private d() {
        e.log("PreLoadVideoSwitchManager init ");
        try {
            parseJson(com.baidu.tbadk.core.sharedPref.b.bsO().getString("video_sync_switch_json", ""));
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

    public int buL() {
        return this.eXb;
    }

    public int getSize() {
        if (this.mSize == 0) {
            return 512000;
        }
        return this.mSize;
    }

    public void Cu(String str) {
        e.log("PreLoadVideoSwitchManager setSyncSwitchJson: " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                parseJson(str);
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("video_sync_switch_json", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJson(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            this.eXb = jSONObject.optInt("num", 3);
            this.isWifi = jSONObject.optInt("is_wifi", 1) == 1;
            this.mSize = jSONObject.optInt("size", 512000);
            e.log("PreLoadVideoSwitchManager parseJson:   num: " + this.eXb + " size: " + this.mSize + " isWifi " + this.isWifi);
        }
    }
}
