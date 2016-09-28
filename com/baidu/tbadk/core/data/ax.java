package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.CommonDistance;
import tbclient.FrsPage.PostInfo;
import tbclient.FrsPage.RecomUserInfo;
/* loaded from: classes.dex */
public class ax extends bi {
    public static final BdUniqueId SH = BdUniqueId.gen();
    private String SI;
    private String SJ;
    private int SK;
    private String SO;
    private az SL = new az();
    private com.baidu.tbadk.coreExtra.relationship.b SM = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> SN = new ArrayList<>();
    private ArrayList<String> SP = new ArrayList<>();

    public int qM() {
        return this.SK;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.SM;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.SM == null) {
                this.SM = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.SM.dZ(commonDistance.is_hide.intValue());
            this.SM.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.SM.eL("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.SM.eL(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.SM.eL(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            co(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.SL != null) {
                this.SL.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.SK = recomUserInfo.common_forum.size();
                int i = this.SK;
                if (this.SK > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.SK > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.SI = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.SN.add(postInfo.common_post_pic);
                    this.SP.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.SJ = recomUserInfo.pos_name;
            }
        }
    }

    public String qN() {
        return this.SI;
    }

    public String qO() {
        return this.SJ;
    }

    public az qP() {
        return this.SL;
    }

    public ArrayList<String> qQ() {
        return this.SN;
    }

    public ArrayList<String> qR() {
        return this.SP;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.SL == null) {
                this.SL = new az();
            }
            this.SL.k(jSONObject.optJSONObject("user_info"));
            this.SI = jSONObject.optString("common_forum");
            this.SI = jSONObject.optString("pos_name");
            this.SK = jSONObject.optInt("common_forum_count");
            this.SO = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.SN == null) {
                    this.SN = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.SN.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.SP == null) {
                    this.SP = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.SP.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return SH;
    }

    public String qS() {
        return this.SO;
    }

    public void co(String str) {
        this.SO = str;
    }
}
