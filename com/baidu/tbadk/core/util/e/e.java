package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.tbadk.p.bj;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e aEJ;
    private int aEK = 3;
    private boolean isWifi = true;
    private int mSize = 0;

    public static e EC() {
        if (aEJ == null) {
            synchronized (e.class) {
                if (aEJ == null) {
                    aEJ = new e();
                }
            }
        }
        return aEJ;
    }

    private e() {
        g.log("PreLoadVideoSwitchManager init ");
        try {
            parseJson(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("video_sync_switch_json", ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isOpen() {
        if (bj.jJ()) {
            return !this.isWifi || j.kW();
        }
        g.log("PreLoadVideoSwitchManager isOpen switch close ");
        return false;
    }

    public int ED() {
        return this.aEK;
    }

    public int getSize() {
        if (this.mSize == 0) {
            return 512000;
        }
        return this.mSize;
    }

    public void gh(String str) {
        g.log("PreLoadVideoSwitchManager setSyncSwitchJson: " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                parseJson(str);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("video_sync_switch_json", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJson(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            this.aEK = jSONObject.optInt("num", 3);
            this.isWifi = jSONObject.optInt("is_wifi", 1) == 1;
            this.mSize = jSONObject.optInt(ChooseVideoAction.CB_KEY_SIZE, 512000);
            g.log("PreLoadVideoSwitchManager parseJson:   num: " + this.aEK + " size: " + this.mSize + " isWifi " + this.isWifi);
        }
    }
}
