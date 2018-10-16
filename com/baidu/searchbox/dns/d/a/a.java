package com.baidu.searchbox.dns.d.a;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public String E;
    private String F;
    private List<String> l;
    public int v;
    public String w;
    public long x;

    public a(String str, int i, String str2, long j, List<String> list) {
        this.w = str;
        this.v = i;
        this.E = str2;
        this.x = j;
        this.l = list;
        this.F = s();
    }

    public a(String str) {
        this.F = str;
        if (!TextUtils.isEmpty(this.F)) {
            try {
                JSONObject jSONObject = new JSONObject(this.F);
                this.w = jSONObject.optString("msg", AiAppsTouchHelper.TouchEventName.TOUCH_ERROR);
                this.E = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
                this.v = jSONObject.optInt("ttl", -1);
                this.x = jSONObject.optLong("cachetime", -1L);
                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                this.l = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.l.add(optJSONArray.getString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getIpList() {
        if (this.l != null) {
            return Collections.unmodifiableList(this.l);
        }
        return null;
    }

    private String s() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray((Collection) this.l);
            jSONObject.put("msg", this.w);
            jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.E);
            jSONObject.put("ttl", this.v);
            jSONObject.put("cachetime", this.x);
            jSONObject.put("ip", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return this.F;
    }
}
