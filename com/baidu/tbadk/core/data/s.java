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
    public static final BdUniqueId Qw = BdUniqueId.gen();
    private String QE;
    private String Qx;
    private String Qy;
    private int Qz;
    private t QB = new t();
    private com.baidu.tbadk.coreExtra.relationship.b QC = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> QD = new ArrayList<>();
    private ArrayList<String> QF = new ArrayList<>();

    public int qT() {
        return this.Qz;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.QC;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.QC == null) {
                this.QC = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.QC.df(commonDistance.is_hide.intValue());
            this.QC.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.QC.eb("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.QC.eb(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.QC.eb(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cf(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.QB != null) {
                this.QB.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Qz = recomUserInfo.common_forum.size();
                int i = this.Qz;
                if (this.Qz > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Qz > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Qx = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.QD.add(postInfo.common_post_pic);
                    this.QF.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Qy = recomUserInfo.pos_name;
            }
        }
    }

    public String qU() {
        return this.Qx;
    }

    public String qV() {
        return this.Qy;
    }

    public t qW() {
        return this.QB;
    }

    public ArrayList<String> qX() {
        return this.QD;
    }

    public ArrayList<String> qY() {
        return this.QF;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.QB == null) {
                this.QB = new t();
            }
            this.QB.e(jSONObject.optJSONObject("user_info"));
            this.Qx = jSONObject.optString("common_forum");
            this.Qx = jSONObject.optString("pos_name");
            this.Qz = jSONObject.optInt("common_forum_count");
            this.QE = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.QD == null) {
                    this.QD = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.QD.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.QF == null) {
                    this.QF = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.QF.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return Qw;
    }

    public String qZ() {
        return this.QE;
    }

    public void cf(String str) {
        this.QE = str;
    }
}
