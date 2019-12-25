package com.baidu.tbadk.core.data;

import com.baidu.tieba.pb.data.ContriInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SignData implements Serializable {
    private static final long serialVersionUID = -7905612002845096083L;
    public BlockPopInfoData blockPopInfoData;
    public int cashBalance;
    public int contDays;
    public String forumId;
    public String forumName;
    public int getCash;
    public int levelup_score;
    public String userInfoJson;
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
    public ContriInfo mContriInfo = new ContriInfo();

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
            this.userInfoJson = optJSONObject.toString();
            this.is_signed = optJSONObject.optInt("is_sign_in");
            this.user_sign_rank = optJSONObject.optInt("user_sign_rank");
            this.count_sign_num = optJSONObject.optInt("cont_sign_num");
            this.count_total_sign_num = optJSONObject.optInt("cout_total_sing_num");
            this.sign_bonus_point = optJSONObject.optInt("sign_bonus_point");
            this.levelup_score = optJSONObject.optInt("levelup_score");
            this.miss_sign_num = optJSONObject.optInt("miss_sign_num");
            this.getCash = optJSONObject.optInt("get_cash");
            this.cashBalance = optJSONObject.optInt("cash_balance");
            this.contDays = optJSONObject.optInt("cont_days");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
        if (optJSONObject2 != null) {
            this.blockPopInfoData = new BlockPopInfoData();
            this.blockPopInfoData.block_info = optJSONObject2.optString("block_content");
            this.blockPopInfoData.ahead_info = optJSONObject2.optString("block_confirm");
            this.blockPopInfoData.ahead_url = optJSONObject2.optString("block_dealurl");
            this.blockPopInfoData.ok_info = optJSONObject2.optString("block_cancel");
        }
        this.mContriInfo.parseJson(jSONObject.optJSONObject("contri_info"));
    }
}
