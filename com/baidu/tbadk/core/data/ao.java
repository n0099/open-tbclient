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
public class ao extends az {
    public static final BdUniqueId Ps = BdUniqueId.gen();
    private String Pt;
    private String Pu;
    private int Pv;
    private String Pz;
    private aq Pw = new aq();
    private com.baidu.tbadk.coreExtra.relationship.b Px = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Py = new ArrayList<>();
    private ArrayList<String> PA = new ArrayList<>();

    public int pO() {
        return this.Pv;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Px;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Px == null) {
                this.Px = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Px.dL(commonDistance.is_hide.intValue());
            this.Px.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Px.eH("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Px.eH(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Px.eH(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cn(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Pw != null) {
                this.Pw.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Pv = recomUserInfo.common_forum.size();
                int i = this.Pv;
                if (this.Pv > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Pv > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Pt = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Py.add(postInfo.common_post_pic);
                    this.PA.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Pu = recomUserInfo.pos_name;
            }
        }
    }

    public String pP() {
        return this.Pt;
    }

    public String pQ() {
        return this.Pu;
    }

    public aq pR() {
        return this.Pw;
    }

    public ArrayList<String> pS() {
        return this.Py;
    }

    public ArrayList<String> pT() {
        return this.PA;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Pw == null) {
                this.Pw = new aq();
            }
            this.Pw.i(jSONObject.optJSONObject("user_info"));
            this.Pt = jSONObject.optString("common_forum");
            this.Pt = jSONObject.optString("pos_name");
            this.Pv = jSONObject.optInt("common_forum_count");
            this.Pz = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Py == null) {
                    this.Py = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Py.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.PA == null) {
                    this.PA = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.PA.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.az, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ps;
    }

    public String pU() {
        return this.Pz;
    }

    public void cn(String str) {
        this.Pz = str;
    }
}
