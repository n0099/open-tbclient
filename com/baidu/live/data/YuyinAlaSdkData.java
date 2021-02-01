package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YuyinAlaSdkData implements Serializable {
    public String mcastsIds;
    public String roomId;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.roomId = jSONObject.optString("room_id");
            this.mcastsIds = jSONObject.optString(Constants.EXTRA_CAST_IDS);
        }
    }
}
