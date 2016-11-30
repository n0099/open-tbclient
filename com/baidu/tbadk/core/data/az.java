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
public class az extends bk {
    public static final BdUniqueId Tc = BdUniqueId.gen();
    private String Td;
    private String Te;
    private int Tf;
    private String Tj;
    private bb Tg = new bb();
    private com.baidu.tbadk.coreExtra.relationship.b Th = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> Ti = new ArrayList<>();
    private ArrayList<String> Tk = new ArrayList<>();

    public int qO() {
        return this.Tf;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.Th;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.Th == null) {
                this.Th = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.Th.eb(commonDistance.is_hide.intValue());
            this.Th.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.Th.eN("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.Th.eN(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.Th.eN(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cq(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Tg != null) {
                this.Tg.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Tf = recomUserInfo.common_forum.size();
                int i = this.Tf;
                if (this.Tf > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Tf > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Td = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Ti.add(postInfo.common_post_pic);
                    this.Tk.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Te = recomUserInfo.pos_name;
            }
        }
    }

    public String qP() {
        return this.Td;
    }

    public String qQ() {
        return this.Te;
    }

    public bb qR() {
        return this.Tg;
    }

    public ArrayList<String> qS() {
        return this.Ti;
    }

    public ArrayList<String> qT() {
        return this.Tk;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Tg == null) {
                this.Tg = new bb();
            }
            this.Tg.k(jSONObject.optJSONObject("user_info"));
            this.Td = jSONObject.optString("common_forum");
            this.Td = jSONObject.optString("pos_name");
            this.Tf = jSONObject.optInt("common_forum_count");
            this.Tj = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Ti == null) {
                    this.Ti = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Ti.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Tk == null) {
                    this.Tk = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Tk.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Tc;
    }

    public String qU() {
        return this.Tj;
    }

    public void cq(String str) {
        this.Tj = str;
    }
}
