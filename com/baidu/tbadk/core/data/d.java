package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes.dex */
public class d {
    public long Uw;
    public int Ux;
    public int Uy;
    public String Uz;
    public String main_title;
    public String sub_title;
    public String subpage_link;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Uw = jSONObject.optLong(GroupActivityActivityConfig.ACTIVITY_ID);
                this.main_title = jSONObject.optString("main_title");
                this.sub_title = jSONObject.optString("sub_title");
                this.Ux = jSONObject.optInt("back_pic_width");
                this.Uy = jSONObject.optInt("back_pic_height");
                this.Uz = jSONObject.optString("back_pic");
                this.subpage_link = jSONObject.optString("subpage_link");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(ActivityInfo activityInfo) {
        if (activityInfo != null) {
            try {
                this.Uw = activityInfo.activity_id.longValue();
                this.main_title = activityInfo.main_title;
                this.sub_title = activityInfo.sub_title;
                this.Ux = activityInfo.back_pic_width.intValue();
                this.Uy = activityInfo.back_pic_height.intValue();
                this.Uz = activityInfo.back_pic;
                this.subpage_link = activityInfo.subpage_link;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
