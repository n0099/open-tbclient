package com.baidu.tbadk.core.data;

import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class br implements com.baidu.tbadk.core.view.commonLike.forum.b {
    public String avatar;
    private boolean dQY;
    private boolean dQZ;
    public aa dRa;
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
    public void hA(boolean z) {
        this.dQZ = z;
    }

    public boolean aVA() {
        return this.dQZ;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int aVB() {
        return this.forumLevel;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public boolean getIsLike() {
        return this.dQY;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public void setIsLike(boolean z) {
        this.dQY = z;
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.dQY = simpleForum.is_liked.intValue() == 1;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.dRa = new aa();
                this.dRa.a(simpleForum.multi_forum_perm);
            }
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
            this.memberNum = simpleForum.member_num.intValue();
            this.postNum = simpleForum.post_num.intValue();
        }
    }
}
