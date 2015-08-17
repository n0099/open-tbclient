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
    public static final BdUniqueId Vk = BdUniqueId.gen();
    private String Vl;
    private String Vm;
    private int Vn;
    private String Vr;
    private r Vo = new r();
    private com.baidu.tbadk.coreExtra.relationship.b Vp = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Vq = new ArrayList<>();
    private ArrayList<String> Vs = new ArrayList<>();

    public int rW() {
        return this.Vn;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Vp;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Vp == null) {
                this.Vp = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Vp.dq(commonDistance.is_hide.intValue());
            this.Vp.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Vp.ee("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Vp.ee(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Vp.ee(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cf(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Vo != null) {
                this.Vo.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Vn = recomUserInfo.common_forum.size();
                int i = this.Vn;
                if (this.Vn > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Vn > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Vl = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Vq.add(postInfo.common_post_pic);
                    this.Vs.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Vm = recomUserInfo.pos_name;
            }
        }
    }

    public String rX() {
        return this.Vl;
    }

    public String rY() {
        return this.Vm;
    }

    public r rZ() {
        return this.Vo;
    }

    public ArrayList<String> sa() {
        return this.Vq;
    }

    public ArrayList<String> sb() {
        return this.Vs;
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Vo == null) {
                this.Vo = new r();
            }
            this.Vo.i(jSONObject.optJSONObject("user_info"));
            this.Vl = jSONObject.optString("common_forum");
            this.Vl = jSONObject.optString("pos_name");
            this.Vn = jSONObject.optInt("common_forum_count");
            this.Vr = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Vq == null) {
                    this.Vq = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Vq.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Vs == null) {
                    this.Vs = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Vs.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vk;
    }

    public String sc() {
        return this.Vr;
    }

    public void cf(String str) {
        this.Vr = str;
    }
}
