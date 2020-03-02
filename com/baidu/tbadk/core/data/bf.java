package com.baidu.tbadk.core.data;

import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class bf implements com.baidu.tbadk.core.view.commonLike.forum.b {
    public String avatar;
    private boolean cQN;
    private boolean cQO;
    public w cQP;
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
    public void fy(boolean z) {
        this.cQO = z;
    }

    public boolean aBE() {
        return this.cQO;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int aBF() {
        return this.forumLevel;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public boolean getIsLike() {
        return this.cQN;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public void setIsLike(boolean z) {
        this.cQN = z;
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.cQN = simpleForum.is_liked.intValue() == 1;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.cQP = new w();
                this.cQP.a(simpleForum.multi_forum_perm);
            }
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
            this.memberNum = simpleForum.member_num.intValue();
            this.postNum = simpleForum.post_num.intValue();
        }
    }
}
