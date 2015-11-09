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
    public static final BdUniqueId Vg = BdUniqueId.gen();
    private String Vh;
    private String Vi;
    private int Vj;
    private String Vn;
    private s Vk = new s();
    private com.baidu.tbadk.coreExtra.relationship.b Vl = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Vm = new ArrayList<>();
    private ArrayList<String> Vo = new ArrayList<>();

    public int rO() {
        return this.Vj;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Vl;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Vl == null) {
                this.Vl = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Vl.dx(commonDistance.is_hide.intValue());
            this.Vl.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Vl.eo("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Vl.eo(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Vl.eo(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            ci(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Vk != null) {
                this.Vk.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Vj = recomUserInfo.common_forum.size();
                int i = this.Vj;
                if (this.Vj > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Vj > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Vh = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Vm.add(postInfo.common_post_pic);
                    this.Vo.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Vi = recomUserInfo.pos_name;
            }
        }
    }

    public String rP() {
        return this.Vh;
    }

    public String rQ() {
        return this.Vi;
    }

    public s rR() {
        return this.Vk;
    }

    public ArrayList<String> rS() {
        return this.Vm;
    }

    public ArrayList<String> rT() {
        return this.Vo;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Vk == null) {
                this.Vk = new s();
            }
            this.Vk.h(jSONObject.optJSONObject("user_info"));
            this.Vh = jSONObject.optString("common_forum");
            this.Vh = jSONObject.optString("pos_name");
            this.Vj = jSONObject.optInt("common_forum_count");
            this.Vn = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Vm == null) {
                    this.Vm = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Vm.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Vo == null) {
                    this.Vo = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Vo.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vg;
    }

    public String rU() {
        return this.Vn;
    }

    public void ci(String str) {
        this.Vn = str;
    }
}
