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
    public static final BdUniqueId VL = BdUniqueId.gen();
    private String VM;
    private String VN;
    private int VO;
    private String VS;
    private v VP = new v();
    private com.baidu.tbadk.coreExtra.relationship.b VQ = new com.baidu.tbadk.coreExtra.relationship.b();
    private ArrayList<String> VR = new ArrayList<>();
    private ArrayList<String> VT = new ArrayList<>();

    public int sl() {
        return this.VO;
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.VQ;
    }

    public void a(CommonDistance commonDistance) {
        if (commonDistance != null && commonDistance.distance != null) {
            if (this.VQ == null) {
                this.VQ = new com.baidu.tbadk.coreExtra.relationship.b();
            }
            this.VQ.dM(commonDistance.is_hide.intValue());
            this.VQ.setTime(commonDistance.time.intValue());
            int intValue = commonDistance.distance.intValue();
            if (intValue > 0 && intValue <= 100) {
                this.VQ.ex("100米以内");
            } else if (intValue > 100 && intValue <= 1000) {
                this.VQ.ex(String.valueOf(intValue) + "米");
            } else if (intValue > 1000) {
                this.VQ.ex(String.valueOf(new BigDecimal(intValue / 1000.0f).setScale(1, 4).floatValue()) + "公里");
            }
        }
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            a(recomUserInfo.distanceinfo);
            cq(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.VP != null) {
                this.VP.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.VO = recomUserInfo.common_forum.size();
                int i = this.VO;
                if (this.VO > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.VO > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.VM = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.VR.add(postInfo.common_post_pic);
                    this.VT.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.VN = recomUserInfo.pos_name;
            }
        }
    }

    public String sm() {
        return this.VM;
    }

    public String sn() {
        return this.VN;
    }

    public v so() {
        return this.VP;
    }

    public ArrayList<String> sp() {
        return this.VR;
    }

    public ArrayList<String> sq() {
        return this.VT;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.VP == null) {
                this.VP = new v();
            }
            this.VP.h(jSONObject.optJSONObject("user_info"));
            this.VM = jSONObject.optString("common_forum");
            this.VM = jSONObject.optString("pos_name");
            this.VO = jSONObject.optInt("common_forum_count");
            this.VS = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.VR == null) {
                    this.VR = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.VR.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.VT == null) {
                    this.VT = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.VT.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return VL;
    }

    public String sr() {
        return this.VS;
    }

    public void cq(String str) {
        this.VS = str;
    }
}
