package com.baidu.tbadk.core.data;

import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class bf implements com.baidu.tbadk.core.view.commonLike.forum.b {
    public String avatar;
    private boolean cRb;
    private boolean cRc;
    public w cRd;
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
    public void fz(boolean z) {
        this.cRc = z;
    }

    public boolean aBH() {
        return this.cRc;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int aBI() {
        return this.forumLevel;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public boolean getIsLike() {
        return this.cRb;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public void setIsLike(boolean z) {
        this.cRb = z;
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.cRb = simpleForum.is_liked.intValue() == 1;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.cRd = new w();
                this.cRd.a(simpleForum.multi_forum_perm);
            }
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
            this.memberNum = simpleForum.member_num.intValue();
            this.postNum = simpleForum.post_num.intValue();
        }
    }
}
