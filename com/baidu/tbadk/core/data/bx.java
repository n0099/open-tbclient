package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class bx implements com.baidu.tbadk.core.view.commonLike.forum.b {
    public String avatar;
    private boolean eRl;
    private boolean eRm;
    public ad eRn;
    public String eRo;
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
        this.eRm = z;
    }

    public boolean bnh() {
        return this.eRm;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bni() {
        return this.forumLevel;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public boolean getIsLike() {
        return this.eRl;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public void setIsLike(boolean z) {
        this.eRl = z;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.forumId = String.valueOf(jSONObject.optLong("id", 0L));
            this.forumName = jSONObject.optString("name");
            this.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
            this.forumLevel = jSONObject.optInt("level_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
            if (optJSONObject != null) {
                this.eRn = new ad();
                this.eRn.parserJson(optJSONObject);
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
            this.eRl = simpleForum.is_liked.intValue() == 1;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.eRn = new ad();
                this.eRn.a(simpleForum.multi_forum_perm);
            }
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
            this.memberNum = simpleForum.member_num.intValue();
            this.postNum = simpleForum.post_num.intValue();
            this.eRo = simpleForum.first_class;
        }
    }
}
