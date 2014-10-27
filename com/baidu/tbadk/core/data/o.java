package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.PostInfo;
import tbclient.FrsPage.RecomUserInfo;
/* loaded from: classes.dex */
public class o extends q {
    public static final BdUniqueId Ab = BdUniqueId.gen();
    private String Ac;
    private String Ae;
    private int Af;
    private String Ai;
    private p Ag = new p();
    private ArrayList<String> Ah = new ArrayList<>();
    private ArrayList<String> Aj = new ArrayList<>();

    public int kj() {
        return this.Af;
    }

    public void a(RecomUserInfo recomUserInfo) {
        if (recomUserInfo != null) {
            aZ(recomUserInfo.message);
            if (recomUserInfo.user_info != null && this.Ag != null) {
                this.Ag.a(recomUserInfo.user_info);
            }
            if (recomUserInfo.common_forum != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Af = recomUserInfo.common_forum.size();
                int i = this.Af;
                if (this.Af > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (recomUserInfo.common_forum.get(i2) != null) {
                        stringBuffer.append(recomUserInfo.common_forum.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Af > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Ac = stringBuffer.toString();
            }
            if (recomUserInfo.post_info != null) {
                for (PostInfo postInfo : recomUserInfo.post_info) {
                    this.Ah.add(postInfo.common_post_pic);
                    this.Aj.add(postInfo.large_post_pic);
                }
            }
            if (recomUserInfo.pos_name != null) {
                this.Ae = recomUserInfo.pos_name;
            }
        }
    }

    public String kk() {
        return this.Ac;
    }

    public String kl() {
        return this.Ae;
    }

    public p km() {
        return this.Ag;
    }

    public ArrayList<String> kn() {
        return this.Ah;
    }

    public ArrayList<String> ko() {
        return this.Aj;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.Ag == null) {
                this.Ag = new p();
            }
            this.Ag.b(jSONObject.optJSONObject("user_info"));
            this.Ac = jSONObject.optString("common_forum");
            this.Ac = jSONObject.optString("pos_name");
            this.Af = jSONObject.optInt("common_forum_count");
            this.Ai = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Ah == null) {
                    this.Ah = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Ah.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Aj == null) {
                    this.Aj = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Aj.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.q, com.baidu.adp.widget.ListView.al
    public BdUniqueId hu() {
        return Ab;
    }

    public String kp() {
        return this.Ai;
    }

    public void aZ(String str) {
        this.Ai = str;
    }
}
