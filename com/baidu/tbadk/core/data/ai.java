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
public class ai extends as {
    public static final BdUniqueId Uj = BdUniqueId.gen();
    private String Uk;
    private String Ul;
    private int Um;
    private String Uq;
    private ak Un = new ak();
    private com.baidu.tbadk.coreExtra.relationship.b Uo = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Up = new ArrayList<>();
    private ArrayList<String> Ur = new ArrayList<>();

    public int sw() {
        return this.Um;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Uo;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Uo == null) {
                this.Uo = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Uo.ee(commonDistance.is_hide.intValue());
            this.Uo.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Uo.eG("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Uo.eG(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Uo.eG(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cq(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Un != null) {
                this.Un.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Um = recomUserInfo.common_forum.size();
                int i = this.Um;
                if (this.Um > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Um > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Uk = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Up.add(postInfo.common_post_pic);
                    this.Ur.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Ul = recomUserInfo.pos_name;
            }
        }
    }

    public String sx() {
        return this.Uk;
    }

    public String sy() {
        return this.Ul;
    }

    public ak sz() {
        return this.Un;
    }

    public ArrayList<String> sA() {
        return this.Up;
    }

    public ArrayList<String> sB() {
        return this.Ur;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Un == null) {
                this.Un = new ak();
            }
            this.Un.h(jSONObject.optJSONObject("user_info"));
            this.Uk = jSONObject.optString("common_forum");
            this.Uk = jSONObject.optString("pos_name");
            this.Um = jSONObject.optInt("common_forum_count");
            this.Uq = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Up == null) {
                    this.Up = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Up.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Ur == null) {
                    this.Ur = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Ur.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.as, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Uj;
    }

    public String sC() {
        return this.Uq;
    }

    public void cq(String str) {
        this.Uq = str;
    }
}
