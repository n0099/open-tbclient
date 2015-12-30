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
public class u extends z {
    public static final BdUniqueId Wl = BdUniqueId.gen();
    private String Wm;
    private String Wn;
    private int Wo;
    private String Ws;
    private v Wp = new v();
    private com.baidu.tbadk.coreExtra.relationship.b Wq = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Wr = new ArrayList<>();
    private ArrayList<String> Wt = new ArrayList<>();

    public int rU() {
        return this.Wo;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Wq;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Wq == null) {
                this.Wq = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Wq.dG(commonDistance.is_hide.intValue());
            this.Wq.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Wq.eA("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Wq.eA(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Wq.eA(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            ct(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Wp != null) {
                this.Wp.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Wo = recomUserInfo.common_forum.size();
                int i = this.Wo;
                if (this.Wo > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Wo > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Wm = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Wr.add(postInfo.common_post_pic);
                    this.Wt.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Wn = recomUserInfo.pos_name;
            }
        }
    }

    public String rV() {
        return this.Wm;
    }

    public String rW() {
        return this.Wn;
    }

    public v rX() {
        return this.Wp;
    }

    public ArrayList<String> rY() {
        return this.Wr;
    }

    public ArrayList<String> rZ() {
        return this.Wt;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Wp == null) {
                this.Wp = new v();
            }
            this.Wp.h(jSONObject.optJSONObject("user_info"));
            this.Wm = jSONObject.optString("common_forum");
            this.Wm = jSONObject.optString("pos_name");
            this.Wo = jSONObject.optInt("common_forum_count");
            this.Ws = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Wr == null) {
                    this.Wr = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Wr.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Wt == null) {
                    this.Wt = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Wt.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Wl;
    }

    public String sa() {
        return this.Ws;
    }

    public void ct(String str) {
        this.Ws = str;
    }
}
