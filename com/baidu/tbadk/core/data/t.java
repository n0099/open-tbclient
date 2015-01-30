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
    public static final BdUniqueId Eq = BdUniqueId.gen();
    private String Er;
    private String Es;
    private int Et;
    private String Ex;
    private u Eu = new u();
    private com.baidu.tbadk.coreExtra.relationship.f Ev = new com.baidu.tbadk.coreExtra.relationship.f();
    private ArrayList<String> Ew = new ArrayList<>();
    private ArrayList<String> Ey = new ArrayList<>();

    public int ne() {
        return this.Et;
    }

    public com.baidu.tbadk.coreExtra.relationship.f getLbsInfo() {
        return this.Ev;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Ev == null) {
                this.Ev = new com.baidu.tbadk.coreExtra.relationship.f();
            }
            this.Ev.cV(commonDistance.is_hide.intValue());
            this.Ev.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Ev.dC("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Ev.dC(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Ev.dC(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            bO(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Eu != null) {
                this.Eu.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Et = recomUserInfo.common_forum.size();
                int i = this.Et;
                if (this.Et > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Et > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Er = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Ew.add(postInfo.common_post_pic);
                    this.Ey.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Es = recomUserInfo.pos_name;
            }
        }
    }

    public String nf() {
        return this.Er;
    }

    public String ng() {
        return this.Es;
    }

    public u nh() {
        return this.Eu;
    }

    public ArrayList<String> ni() {
        return this.Ew;
    }

    public ArrayList<String> nj() {
        return this.Ey;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Eu == null) {
                this.Eu = new u();
            }
            this.Eu.f(jSONObject.optJSONObject("user_info"));
            this.Er = jSONObject.optString("common_forum");
            this.Er = jSONObject.optString("pos_name");
            this.Et = jSONObject.optInt("common_forum_count");
            this.Ex = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Ew == null) {
                    this.Ew = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Ew.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Ey == null) {
                    this.Ey = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Ey.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.am
    public BdUniqueId js() {
        return Eq;
    }

    public String nk() {
        return this.Ex;
    }

    public void bO(String str) {
        this.Ex = str;
    }
}
