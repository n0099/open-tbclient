package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinAlaPersonManagerData implements Serializable {
    public boolean isShowManagerBtn = false;
    public int userIndentity = 3;
    public int userCardIndentity = 3;
    public int userBanManger = 0;
    public boolean isShowSinglePrivate = false;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.isShowManagerBtn = jSONObject.optInt("show_manager") == 1;
            this.userIndentity = jSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY, 3);
            this.userCardIndentity = jSONObject.optInt("card_user_identity", 3);
            this.userBanManger = jSONObject.optInt("ban_manager");
            this.isShowSinglePrivate = jSONObject.optInt("im_chat") == 1;
        }
    }
}
