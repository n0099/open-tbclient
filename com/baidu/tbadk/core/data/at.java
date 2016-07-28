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
public class at extends be {
    public static final BdUniqueId PQ = BdUniqueId.gen();
    private String PR;
    private String PT;
    private int PU;
    private String PY;
    private av PV = new av();
    private com.baidu.tbadk.coreExtra.relationship.b PW = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> PX = new ArrayList<>();
    private ArrayList<String> PZ = new ArrayList<>();

    public int px() {
        return this.PU;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.PW;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.PW == null) {
                this.PW = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.PW.dL(commonDistance.is_hide.intValue());
            this.PW.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.PW.eF("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.PW.eF(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.PW.eF(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cn(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.PV != null) {
                this.PV.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.PU = recomUserInfo.common_forum.size();
                int i = this.PU;
                if (this.PU > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.PU > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.PR = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.PX.add(postInfo.common_post_pic);
                    this.PZ.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.PT = recomUserInfo.pos_name;
            }
        }
    }

    public String py() {
        return this.PR;
    }

    public String pz() {
        return this.PT;
    }

    public av pA() {
        return this.PV;
    }

    public ArrayList<String> pB() {
        return this.PX;
    }

    public ArrayList<String> pC() {
        return this.PZ;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.PV == null) {
                this.PV = new av();
            }
            this.PV.k(jSONObject.optJSONObject("user_info"));
            this.PR = jSONObject.optString("common_forum");
            this.PR = jSONObject.optString("pos_name");
            this.PU = jSONObject.optInt("common_forum_count");
            this.PY = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.PX == null) {
                    this.PX = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.PX.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.PZ == null) {
                    this.PZ = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.PZ.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return PQ;
    }

    public String pD() {
        return this.PY;
    }

    public void cn(String str) {
        this.PY = str;
    }
}
