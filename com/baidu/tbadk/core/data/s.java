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
    public static final BdUniqueId Qb = BdUniqueId.gen();
    private String Qc;
    private String Qd;
    private int Qe;
    private String Qi;
    private t Qf = new t();
    private com.baidu.tbadk.coreExtra.relationship.b Qg = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Qh = new ArrayList<>();
    private ArrayList<String> Qj = new ArrayList<>();

    public int qn() {
        return this.Qe;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Qg;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Qg == null) {
                this.Qg = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Qg.cW(commonDistance.is_hide.intValue());
            this.Qg.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Qg.dK("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Qg.dK(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Qg.dK(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            bS(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Qf != null) {
                this.Qf.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Qe = recomUserInfo.common_forum.size();
                int i = this.Qe;
                if (this.Qe > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Qe > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Qc = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Qh.add(postInfo.common_post_pic);
                    this.Qj.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Qd = recomUserInfo.pos_name;
            }
        }
    }

    public String qo() {
        return this.Qc;
    }

    public String qp() {
        return this.Qd;
    }

    public t qq() {
        return this.Qf;
    }

    public ArrayList<String> qr() {
        return this.Qh;
    }

    public ArrayList<String> qs() {
        return this.Qj;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Qf == null) {
                this.Qf = new t();
            }
            this.Qf.e(jSONObject.optJSONObject("user_info"));
            this.Qc = jSONObject.optString("common_forum");
            this.Qc = jSONObject.optString("pos_name");
            this.Qe = jSONObject.optInt("common_forum_count");
            this.Qi = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Qh == null) {
                    this.Qh = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Qh.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Qj == null) {
                    this.Qj = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Qj.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return Qb;
    }

    public String qt() {
        return this.Qi;
    }

    public void bS(String str) {
        this.Qi = str;
    }
}
