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
public class s extends w {
    public static final BdUniqueId PZ = BdUniqueId.gen();
    private String Qa;
    private String Qb;
    private int Qc;
    private String Qg;
    private t Qd = new t();
    private com.baidu.tbadk.coreExtra.relationship.b Qe = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Qf = new ArrayList<>();
    private ArrayList<String> Qh = new ArrayList<>();

    public int qn() {
        return this.Qc;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Qe;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Qe == null) {
                this.Qe = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Qe.cW(commonDistance.is_hide.intValue());
            this.Qe.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Qe.dH("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Qe.dH(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Qe.dH(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            bS(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Qd != null) {
                this.Qd.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Qc = recomUserInfo.common_forum.size();
                int i = this.Qc;
                if (this.Qc > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Qc > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Qa = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Qf.add(postInfo.common_post_pic);
                    this.Qh.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Qb = recomUserInfo.pos_name;
            }
        }
    }

    public String qo() {
        return this.Qa;
    }

    public String qp() {
        return this.Qb;
    }

    public t qq() {
        return this.Qd;
    }

    public ArrayList<String> qr() {
        return this.Qf;
    }

    public ArrayList<String> qs() {
        return this.Qh;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Qd == null) {
                this.Qd = new t();
            }
            this.Qd.e(jSONObject.optJSONObject("user_info"));
            this.Qa = jSONObject.optString("common_forum");
            this.Qa = jSONObject.optString("pos_name");
            this.Qc = jSONObject.optInt("common_forum_count");
            this.Qg = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Qf == null) {
                    this.Qf = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Qf.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Qh == null) {
                    this.Qh = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Qh.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return PZ;
    }

    public String qt() {
        return this.Qg;
    }

    public void bS(String str) {
        this.Qg = str;
    }
}
