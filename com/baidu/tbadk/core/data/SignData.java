package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SignData implements Serializable {
    private static final long serialVersionUID = -7905612002845096083L;
    public BlockPopInfoData blockPopInfoData;
    public String forumId;
    public String forumName;
    public int levelup_score;
    public int is_signed = 0;
    public int user_sign_rank = 0;
    public int count_sign_num = 0;
    public int count_total_sign_num = 0;
    public int forum_rank = 0;
    public int sign_bonus_point = 3;
    public int sign_count = 0;
    public int miss_sign_num = 0;
    public int errorCode = 0;
    public String errorMsg = "";

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
        if (optJSONObject != null) {
            this.is_signed = optJSONObject.optInt("is_sign_in");
            this.user_sign_rank = optJSONObject.optInt("user_sign_rank");
            this.count_sign_num = optJSONObject.optInt("cont_sign_num");
            this.count_total_sign_num = optJSONObject.optInt("cout_total_sing_num");
            this.sign_bonus_point = optJSONObject.optInt("sign_bonus_point");
            this.levelup_score = optJSONObject.optInt("levelup_score");
            this.miss_sign_num = optJSONObject.optInt("miss_sign_num");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(LoginActivityConfig.INFO);
        if (optJSONObject2 != null) {
            this.blockPopInfoData = new BlockPopInfoData();
            this.blockPopInfoData.block_info = optJSONObject2.optString("block_content");
            this.blockPopInfoData.ahead_info = optJSONObject2.optString("block_confirm");
            this.blockPopInfoData.ahead_url = optJSONObject2.optString("block_dealurl");
            this.blockPopInfoData.ok_info = optJSONObject2.optString("block_cancel");
        }
    }
}
