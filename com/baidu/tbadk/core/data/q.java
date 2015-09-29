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
public class q extends v {
    public static final BdUniqueId Vc = BdUniqueId.gen();
    private String Vd;
    private String Ve;
    private int Vf;
    private String Vj;
    private r Vg = new r();
    private com.baidu.tbadk.coreExtra.relationship.b Vh = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Vi = new ArrayList<>();
    private ArrayList<String> Vk = new ArrayList<>();

    public int rP() {
        return this.Vf;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Vh;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Vh == null) {
                this.Vh = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Vh.dx(commonDistance.is_hide.intValue());
            this.Vh.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Vh.eo("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Vh.eo(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Vh.eo(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cj(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Vg != null) {
                this.Vg.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Vf = recomUserInfo.common_forum.size();
                int i = this.Vf;
                if (this.Vf > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Vf > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Vd = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Vi.add(postInfo.common_post_pic);
                    this.Vk.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Ve = recomUserInfo.pos_name;
            }
        }
    }

    public String rQ() {
        return this.Vd;
    }

    public String rR() {
        return this.Ve;
    }

    public r rS() {
        return this.Vg;
    }

    public ArrayList<String> rT() {
        return this.Vi;
    }

    public ArrayList<String> rU() {
        return this.Vk;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Vg == null) {
                this.Vg = new r();
            }
            this.Vg.h(jSONObject.optJSONObject("user_info"));
            this.Vd = jSONObject.optString("common_forum");
            this.Vd = jSONObject.optString("pos_name");
            this.Vf = jSONObject.optInt("common_forum_count");
            this.Vj = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Vi == null) {
                    this.Vi = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Vi.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Vk == null) {
                    this.Vk = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Vk.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vc;
    }

    public String rV() {
        return this.Vj;
    }

    public void cj(String str) {
        this.Vj = str;
    }
}
