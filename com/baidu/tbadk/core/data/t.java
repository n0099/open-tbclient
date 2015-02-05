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
public class t extends x {
    public static final BdUniqueId En = BdUniqueId.gen();
    private String Eo;
    private String Ep;
    private int Eq;
    private String Eu;
    private u Er = new u();
    private com.baidu.tbadk.coreExtra.relationship.f Es = new com.baidu.tbadk.coreExtra.relationship.f();
    private ArrayList<String> Et = new ArrayList<>();
    private ArrayList<String> Ev = new ArrayList<>();

    public int mX() {
        return this.Eq;
    }

    public com.baidu.tbadk.coreExtra.relationship.f getLbsInfo() {
        return this.Es;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Es == null) {
                this.Es = new com.baidu.tbadk.coreExtra.relationship.f();
            }
            this.Es.cV(commonDistance.is_hide.intValue());
            this.Es.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Es.dz("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Es.dz(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Es.dz(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            bL(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Er != null) {
                this.Er.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Eq = recomUserInfo.common_forum.size();
                int i = this.Eq;
                if (this.Eq > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Eq > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Eo = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Et.add(postInfo.common_post_pic);
                    this.Ev.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Ep = recomUserInfo.pos_name;
            }
        }
    }

    public String mY() {
        return this.Eo;
    }

    public String mZ() {
        return this.Ep;
    }

    public u na() {
        return this.Er;
    }

    public ArrayList<String> nb() {
        return this.Et;
    }

    public ArrayList<String> nc() {
        return this.Ev;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Er == null) {
                this.Er = new u();
            }
            this.Er.f(jSONObject.optJSONObject("user_info"));
            this.Eo = jSONObject.optString("common_forum");
            this.Eo = jSONObject.optString("pos_name");
            this.Eq = jSONObject.optInt("common_forum_count");
            this.Eu = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Et == null) {
                    this.Et = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Et.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Ev == null) {
                    this.Ev = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Ev.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.am
    public BdUniqueId jl() {
        return En;
    }

    public String nd() {
        return this.Eu;
    }

    public void bL(String str) {
        this.Eu = str;
    }
}
