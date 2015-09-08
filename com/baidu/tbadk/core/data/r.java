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
public class r extends x {
    public static final BdUniqueId Vn = BdUniqueId.gen();
    private String Vo;
    private String Vp;
    private int Vq;
    private String Vu;
    private s Vr = new s();
    private com.baidu.tbadk.coreExtra.relationship.b Vs = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Vt = new ArrayList<>();
    private ArrayList<String> Vv = new ArrayList<>();

    public int rU() {
        return this.Vq;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Vs;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Vs == null) {
                this.Vs = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Vs.dw(commonDistance.is_hide.intValue());
            this.Vs.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Vs.el("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Vs.el(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Vs.el(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cj(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Vr != null) {
                this.Vr.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Vq = recomUserInfo.common_forum.size();
                int i = this.Vq;
                if (this.Vq > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Vq > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Vo = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Vt.add(postInfo.common_post_pic);
                    this.Vv.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Vp = recomUserInfo.pos_name;
            }
        }
    }

    public String rV() {
        return this.Vo;
    }

    public String rW() {
        return this.Vp;
    }

    public s rX() {
        return this.Vr;
    }

    public ArrayList<String> rY() {
        return this.Vt;
    }

    public ArrayList<String> rZ() {
        return this.Vv;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Vr == null) {
                this.Vr = new s();
            }
            this.Vr.i(jSONObject.optJSONObject("user_info"));
            this.Vo = jSONObject.optString("common_forum");
            this.Vo = jSONObject.optString("pos_name");
            this.Vq = jSONObject.optInt("common_forum_count");
            this.Vu = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Vt == null) {
                    this.Vt = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Vt.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Vv == null) {
                    this.Vv = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Vv.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vn;
    }

    public String sa() {
        return this.Vu;
    }

    public void cj(String str) {
        this.Vu = str;
    }
}
