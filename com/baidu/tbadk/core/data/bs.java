package com.baidu.tbadk.core.data;

import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class bs implements com.baidu.tbadk.core.view.commonLike.forum.b {
    public String avatar;
    private boolean eas;
    private boolean eat;
    public ab eau;
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
    public void hW(boolean z) {
        this.eat = z;
    }

    public boolean bdT() {
        return this.eat;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int bdU() {
        return this.forumLevel;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public boolean getIsLike() {
        return this.eas;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public void setIsLike(boolean z) {
        this.eas = z;
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.eas = simpleForum.is_liked.intValue() == 1;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.eau = new ab();
                this.eau.a(simpleForum.multi_forum_perm);
            }
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
            this.memberNum = simpleForum.member_num.intValue();
            this.postNum = simpleForum.post_num.intValue();
        }
    }
}
