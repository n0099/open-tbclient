package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.switchs.VideoPreLoadSwitch;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e dCV;
    private int dCW = 3;
    private boolean isWifi = true;
    private int mSize = 0;

    public static e aPI() {
        if (dCV == null) {
            synchronized (e.class) {
                if (dCV == null) {
                    dCV = new e();
                }
            }
        }
        return dCV;
    }

    private e() {
        g.log("PreLoadVideoSwitchManager init ");
        try {
            parseJson(com.baidu.tbadk.core.sharedPref.b.aNV().getString("video_sync_switch_json", ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isOpen() {
        if (VideoPreLoadSwitch.isOn()) {
            return !this.isWifi || j.isWifiNet();
        }
        g.log("PreLoadVideoSwitchManager isOpen switch close ");
        return false;
    }

    public int aPJ() {
        return this.dCW;
    }

    public int getSize() {
        if (this.mSize == 0) {
            return 512000;
        }
        return this.mSize;
    }

    public void vc(String str) {
        g.log("PreLoadVideoSwitchManager setSyncSwitchJson: " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                parseJson(str);
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("video_sync_switch_json", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJson(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            this.dCW = jSONObject.optInt("num", 3);
            this.isWifi = jSONObject.optInt("is_wifi", 1) == 1;
            this.mSize = jSONObject.optInt(TiebaInitialize.LogFields.SIZE, 512000);
            g.log("PreLoadVideoSwitchManager parseJson:   num: " + this.dCW + " size: " + this.mSize + " isWifi " + this.isWifi);
        }
    }
}
