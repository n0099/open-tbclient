package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YuanPackageData implements Serializable {
    public long dubi;
    public int giftId;
    public String giftName;
    public String iconId;
    public long nonMemberT;
    public int openSwitch;
    public String photoUrl;
    public int previewGiftId;
    public String productId;
    public int showNum;
    public long timeThreshold;
    public String toastFollowText;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftName = jSONObject.optString("gift_name");
            this.giftId = jSONObject.optInt("gif_id");
            this.previewGiftId = jSONObject.optInt("preview_gift_id");
            this.openSwitch = jSONObject.optInt("switch");
            this.showNum = jSONObject.optInt("show_num");
            this.timeThreshold = jSONObject.optInt("time_threshold");
            this.photoUrl = jSONObject.optString("photo_url");
            this.productId = jSONObject.optString("product_id");
            this.iconId = jSONObject.optString("icon_id");
            this.nonMemberT = jSONObject.optLong("non_member_t");
            this.dubi = jSONObject.optLong("dubi");
            this.toastFollowText = jSONObject.optString("toast_follow_text");
        }
    }
}
