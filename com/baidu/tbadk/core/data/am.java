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
public class am extends ax {
    public static final BdUniqueId Pi = BdUniqueId.gen();
    private String Pj;
    private String Pk;
    private int Pl;
    private String Pp;
    private ao Pm = new ao();
    private com.baidu.tbadk.coreExtra.relationship.b Pn = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Po = new ArrayList<>();
    private ArrayList<String> Pq = new ArrayList<>();

    public int pU() {
        return this.Pl;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Pn;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Pn == null) {
                this.Pn = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Pn.dJ(commonDistance.is_hide.intValue());
            this.Pn.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Pn.eD("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Pn.eD(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Pn.eD(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cn(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Pm != null) {
                this.Pm.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Pl = recomUserInfo.common_forum.size();
                int i = this.Pl;
                if (this.Pl > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Pl > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Pj = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Po.add(postInfo.common_post_pic);
                    this.Pq.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Pk = recomUserInfo.pos_name;
            }
        }
    }

    public String pV() {
        return this.Pj;
    }

    public String pW() {
        return this.Pk;
    }

    public ao pX() {
        return this.Pm;
    }

    public ArrayList<String> pY() {
        return this.Po;
    }

    public ArrayList<String> pZ() {
        return this.Pq;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Pm == null) {
                this.Pm = new ao();
            }
            this.Pm.h(jSONObject.optJSONObject("user_info"));
            this.Pj = jSONObject.optString("common_forum");
            this.Pj = jSONObject.optString("pos_name");
            this.Pl = jSONObject.optInt("common_forum_count");
            this.Pp = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Po == null) {
                    this.Po = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Po.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Pq == null) {
                    this.Pq = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Pq.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.ax, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Pi;
    }

    public String qa() {
        return this.Pp;
    }

    public void cn(String str) {
        this.Pp = str;
    }
}
