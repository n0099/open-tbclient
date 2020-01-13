package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes.dex */
public class f {
    public long cJF;
    public int cJG;
    public int cJH;
    public String cJI;
    public String main_title;
    public String sub_title;
    public String subpage_link;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cJF = jSONObject.optLong("activity_id");
                this.main_title = jSONObject.optString("main_title");
                this.sub_title = jSONObject.optString("sub_title");
                this.cJG = jSONObject.optInt("back_pic_width");
                this.cJH = jSONObject.optInt("back_pic_height");
                this.cJI = jSONObject.optString("back_pic");
                this.subpage_link = jSONObject.optString("subpage_link");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(ActivityInfo activityInfo) {
        if (activityInfo != null) {
            try {
                this.cJF = activityInfo.activity_id.longValue();
                this.main_title = activityInfo.main_title;
                this.sub_title = activityInfo.sub_title;
                this.cJG = activityInfo.back_pic_width.intValue();
                this.cJH = activityInfo.back_pic_height.intValue();
                this.cJI = activityInfo.back_pic;
                this.subpage_link = activityInfo.subpage_link;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
