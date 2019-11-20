package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.t.bv;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e clj;
    private int clk = 3;
    private boolean isWifi = true;
    private int mSize = 0;

    public static e ann() {
        if (clj == null) {
            synchronized (e.class) {
                if (clj == null) {
                    clj = new e();
                }
            }
        }
        return clj;
    }

    private e() {
        g.log("PreLoadVideoSwitchManager init ");
        try {
            parseJson(com.baidu.tbadk.core.sharedPref.b.alP().getString("video_sync_switch_json", ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isOpen() {
        if (bv.isOn()) {
            return !this.isWifi || j.isWifiNet();
        }
        g.log("PreLoadVideoSwitchManager isOpen switch close ");
        return false;
    }

    public int ano() {
        return this.clk;
    }

    public int getSize() {
        if (this.mSize == 0) {
            return 512000;
        }
        return this.mSize;
    }

    public void oq(String str) {
        g.log("PreLoadVideoSwitchManager setSyncSwitchJson: " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                parseJson(str);
                com.baidu.tbadk.core.sharedPref.b.alP().putString("video_sync_switch_json", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJson(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            this.clk = jSONObject.optInt("num", 3);
            this.isWifi = jSONObject.optInt("is_wifi", 1) == 1;
            this.mSize = jSONObject.optInt(TiebaInitialize.LogFields.SIZE, 512000);
            g.log("PreLoadVideoSwitchManager parseJson:   num: " + this.clk + " size: " + this.mSize + " isWifi " + this.isWifi);
        }
    }
}
