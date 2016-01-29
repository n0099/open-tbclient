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
public class y extends ah {
    public static final BdUniqueId Wa = BdUniqueId.gen();
    private String Wb;
    private String Wc;
    private int Wd;
    private String Wh;
    private aa We = new aa();
    private com.baidu.tbadk.coreExtra.relationship.b Wf = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Wg = new ArrayList<>();
    private ArrayList<String> Wi = new ArrayList<>();

    public int sB() {
        return this.Wd;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Wf;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Wf == null) {
                this.Wf = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Wf.eb(commonDistance.is_hide.intValue());
            this.Wf.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Wf.ez("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Wf.ez(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Wf.ez(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cs(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.We != null) {
                this.We.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Wd = recomUserInfo.common_forum.size();
                int i = this.Wd;
                if (this.Wd > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Wd > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Wb = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Wg.add(postInfo.common_post_pic);
                    this.Wi.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Wc = recomUserInfo.pos_name;
            }
        }
    }

    public String sC() {
        return this.Wb;
    }

    public String sD() {
        return this.Wc;
    }

    public aa sE() {
        return this.We;
    }

    public ArrayList<String> sF() {
        return this.Wg;
    }

    public ArrayList<String> sG() {
        return this.Wi;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.We == null) {
                this.We = new aa();
            }
            this.We.h(jSONObject.optJSONObject("user_info"));
            this.Wb = jSONObject.optString("common_forum");
            this.Wb = jSONObject.optString("pos_name");
            this.Wd = jSONObject.optInt("common_forum_count");
            this.Wh = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Wg == null) {
                    this.Wg = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Wg.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Wi == null) {
                    this.Wi = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Wi.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.ah, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Wa;
    }

    public String sH() {
        return this.Wh;
    }

    public void cs(String str) {
        this.Wh = str;
    }
}
