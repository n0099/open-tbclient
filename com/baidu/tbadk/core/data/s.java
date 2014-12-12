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
    public static final BdUniqueId Em = BdUniqueId.gen();
    private String En;
    private String Eo;
    private int Ep;
    private String Et;
    private t Eq = new t();
    private com.baidu.tbadk.coreExtra.relationship.f Er = new com.baidu.tbadk.coreExtra.relationship.f();
    private ArrayList<String> Es = new ArrayList<>();
    private ArrayList<String> Eu = new ArrayList<>();

    public int nc() {
        return this.Ep;
    }

    public com.baidu.tbadk.coreExtra.relationship.f getLbsInfo() {
        return this.Er;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Er == null) {
                this.Er = new com.baidu.tbadk.coreExtra.relationship.f();
            }
            this.Er.cO(commonDistance.is_hide.intValue());
            this.Er.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Er.dD("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Er.dD(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Er.dD(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            bQ(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Eq != null) {
                this.Eq.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Ep = recomUserInfo.common_forum.size();
                int i = this.Ep;
                if (this.Ep > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Ep > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.En = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Es.add(postInfo.common_post_pic);
                    this.Eu.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Eo = recomUserInfo.pos_name;
            }
        }
    }

    public String nd() {
        return this.En;
    }

    public String ne() {
        return this.Eo;
    }

    public t nf() {
        return this.Eq;
    }

    public ArrayList<String> ng() {
        return this.Es;
    }

    public ArrayList<String> nh() {
        return this.Eu;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Eq == null) {
                this.Eq = new t();
            }
            this.Eq.f(jSONObject.optJSONObject("user_info"));
            this.En = jSONObject.optString("common_forum");
            this.En = jSONObject.optString("pos_name");
            this.Ep = jSONObject.optInt("common_forum_count");
            this.Et = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Es == null) {
                    this.Es = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Es.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Eu == null) {
                    this.Eu = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Eu.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.am
    public BdUniqueId jr() {
        return Em;
    }

    public String ni() {
        return this.Et;
    }

    public void bQ(String str) {
        this.Et = str;
    }
}
