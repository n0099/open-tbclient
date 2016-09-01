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
public class av extends bg {
    public static final BdUniqueId SA = BdUniqueId.gen();
    private String SB;
    private String SC;
    private int SD;
    private String SH;
    private ax SE = new ax();
    private com.baidu.tbadk.coreExtra.relationship.b SF = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> SG = new ArrayList<>();
    private ArrayList<String> SI = new ArrayList<>();

    public int qB() {
        return this.SD;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.SF;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.SF == null) {
                this.SF = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.SF.dZ(commonDistance.is_hide.intValue());
            this.SF.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.SF.eI("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.SF.eI(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.SF.eI(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            co(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.SE != null) {
                this.SE.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.SD = recomUserInfo.common_forum.size();
                int i = this.SD;
                if (this.SD > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.SD > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.SB = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.SG.add(postInfo.common_post_pic);
                    this.SI.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.SC = recomUserInfo.pos_name;
            }
        }
    }

    public String qC() {
        return this.SB;
    }

    public String qD() {
        return this.SC;
    }

    public ax qE() {
        return this.SE;
    }

    public ArrayList<String> qF() {
        return this.SG;
    }

    public ArrayList<String> qG() {
        return this.SI;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.SE == null) {
                this.SE = new ax();
            }
            this.SE.k(jSONObject.optJSONObject("user_info"));
            this.SB = jSONObject.optString("common_forum");
            this.SB = jSONObject.optString("pos_name");
            this.SD = jSONObject.optInt("common_forum_count");
            this.SH = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.SG == null) {
                    this.SG = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.SG.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.SI == null) {
                    this.SI = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.SI.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return SA;
    }

    public String qH() {
        return this.SH;
    }

    public void co(String str) {
        this.SH = str;
    }
}
