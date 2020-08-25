package com.baidu.ala.data;

import alaim.LiveMarkInfo;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaLiveMarkData extends OrmObject implements Serializable {
    public static final String DEFAULT_ANCHOR_USER_ID = "0";
    public static final int TYPE_USER_LABEL = 3;
    public static final int TYPE_USER_LEVEL = 1;
    public String anchor_user_id;
    public int height;
    public long mark_id;
    public String mark_name;
    public String mark_pic;
    public int type;
    public int width;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.anchor_user_id = jSONObject.optString("anchor_user_id");
            this.mark_id = jSONObject.optLong("mark_id");
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
        }
    }

    public void parserProto(LiveMarkInfo liveMarkInfo) {
        if (liveMarkInfo != null) {
            this.type = liveMarkInfo.type == null ? 0 : liveMarkInfo.type.intValue();
            this.anchor_user_id = String.valueOf(liveMarkInfo.anchor_user_id);
            this.mark_id = liveMarkInfo.mark_id.longValue();
            this.mark_name = liveMarkInfo.mark_name;
            this.mark_pic = liveMarkInfo.mark_pic;
            this.width = liveMarkInfo.width == null ? 0 : liveMarkInfo.width.intValue();
            this.height = liveMarkInfo.height != null ? liveMarkInfo.height.intValue() : 0;
        }
    }
}
