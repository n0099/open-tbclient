package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.switchs.VideoPreLoadSwitch;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static d fgB;
    private int fgC = 3;
    private boolean isWifi = true;
    private int mSize = 0;

    public static d bxf() {
        if (fgB == null) {
            synchronized (d.class) {
                if (fgB == null) {
                    fgB = new d();
                }
            }
        }
        return fgB;
    }

    private d() {
        e.log("PreLoadVideoSwitchManager init ");
        try {
            parseJson(com.baidu.tbadk.core.sharedPref.b.bvq().getString("video_sync_switch_json", ""));
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

    public int bxg() {
        return this.fgC;
    }

    public int getSize() {
        return this.mSize == 0 ? IoUtils.DEFAULT_IMAGE_TOTAL_SIZE : this.mSize;
    }

    public void Cs(String str) {
        e.log("PreLoadVideoSwitchManager setSyncSwitchJson: " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                parseJson(str);
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("video_sync_switch_json", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJson(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            this.fgC = jSONObject.optInt("num", 3);
            this.isWifi = jSONObject.optInt("is_wifi", 1) == 1;
            this.mSize = jSONObject.optInt("size", IoUtils.DEFAULT_IMAGE_TOTAL_SIZE);
            e.log("PreLoadVideoSwitchManager parseJson:   num: " + this.fgC + " size: " + this.mSize + " isWifi " + this.isWifi);
        }
    }
}
