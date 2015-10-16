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
public class r extends w {
    public static final BdUniqueId Ve = BdUniqueId.gen();
    private String Vf;
    private String Vg;
    private int Vh;
    private String Vl;
    private s Vi = new s();
    private com.baidu.tbadk.coreExtra.relationship.b Vj = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Vk = new ArrayList<>();
    private ArrayList<String> Vm = new ArrayList<>();

    public int rP() {
        return this.Vh;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Vj;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Vj == null) {
                this.Vj = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Vj.dx(commonDistance.is_hide.intValue());
            this.Vj.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Vj.eo("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Vj.eo(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Vj.eo(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            ck(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Vi != null) {
                this.Vi.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Vh = recomUserInfo.common_forum.size();
                int i = this.Vh;
                if (this.Vh > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Vh > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Vf = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Vk.add(postInfo.common_post_pic);
                    this.Vm.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Vg = recomUserInfo.pos_name;
            }
        }
    }

    public String rQ() {
        return this.Vf;
    }

    public String rR() {
        return this.Vg;
    }

    public s rS() {
        return this.Vi;
    }

    public ArrayList<String> rT() {
        return this.Vk;
    }

    public ArrayList<String> rU() {
        return this.Vm;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Vi == null) {
                this.Vi = new s();
            }
            this.Vi.h(jSONObject.optJSONObject("user_info"));
            this.Vf = jSONObject.optString("common_forum");
            this.Vf = jSONObject.optString("pos_name");
            this.Vh = jSONObject.optInt("common_forum_count");
            this.Vl = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Vk == null) {
                    this.Vk = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Vk.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Vm == null) {
                    this.Vm = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Vm.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Ve;
    }

    public String rV() {
        return this.Vl;
    }

    public void ck(String str) {
        this.Vl = str;
    }
}
