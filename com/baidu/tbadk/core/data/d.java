package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes.dex */
public class d {
    public int UB;
    public String UC;
    public long Uy;
    public int Uz;
    public String main_title;
    public String sub_title;
    public String subpage_link;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Uy = jSONObject.optLong(GroupActivityActivityConfig.ACTIVITY_ID);
                this.main_title = jSONObject.optString("main_title");
                this.sub_title = jSONObject.optString("sub_title");
                this.Uz = jSONObject.optInt("back_pic_width");
                this.UB = jSONObject.optInt("back_pic_height");
                this.UC = jSONObject.optString("back_pic");
                this.subpage_link = jSONObject.optString("subpage_link");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(ActivityInfo activityInfo) {
        if (activityInfo != null) {
            try {
                this.Uy = activityInfo.activity_id.longValue();
                this.main_title = activityInfo.main_title;
                this.sub_title = activityInfo.sub_title;
                this.Uz = activityInfo.back_pic_width.intValue();
                this.UB = activityInfo.back_pic_height.intValue();
                this.UC = activityInfo.back_pic;
                this.subpage_link = activityInfo.subpage_link;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
