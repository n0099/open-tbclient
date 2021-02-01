package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class bx implements com.baidu.tbadk.core.view.commonLike.forum.b {
    public String avatar;
    private boolean ePK;
    private boolean ePL;
    public ad ePM;
    public String ePN;
    public String forumId;
    private int forumLevel;
    public String forumName;
    public boolean isBrandForum;
    public int memberNum;
    public int postNum;

    @Override // com.baidu.tbadk.core.view.commonLike.forum.b
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.forum.b
    public String getForumName() {
        return this.forumName;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.forum.b
    public void jw(boolean z) {
        this.ePL = z;
    }

    public boolean bnf() {
        return this.ePL;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bng() {
        return this.forumLevel;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public boolean getIsLike() {
        return this.ePK;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public void setIsLike(boolean z) {
        this.ePK = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = String.valueOf(jSONObject.optLong("id", 0L));
            this.forumName = jSONObject.optString("name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.forumLevel = jSONObject.optInt("level_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
            if (optJSONObject != null) {
                this.ePM = new ad();
                this.ePM.parserJson(optJSONObject);
            }
            this.memberNum = jSONObject.optInt("memberNum", 0);
            this.postNum = jSONObject.optInt("post_num", 0);
        }
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.ePK = simpleForum.is_liked.intValue() == 1;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.ePM = new ad();
                this.ePM.a(simpleForum.multi_forum_perm);
            }
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
            this.memberNum = simpleForum.member_num.intValue();
            this.postNum = simpleForum.post_num.intValue();
            this.ePN = simpleForum.first_class;
        }
    }
}
