package com.baidu.tbadk.core.data;

import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class bc implements com.baidu.tbadk.core.view.commonLike.forum.b {
    private String avatar;
    private boolean bAC;
    private boolean bAD;
    public v bAE;
    private String forumId;
    private int forumLevel;
    public String forumName;
    public boolean isBrandForum;

    @Override // com.baidu.tbadk.core.view.commonLike.forum.b
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.forum.b
    public String getForumName() {
        return this.forumName;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.forum.b
    public void dj(boolean z) {
        this.bAD = z;
    }

    public boolean Yd() {
        return this.bAD;
    }

    public String getAvatar() {
        return this.avatar;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public boolean getIsLike() {
        return this.bAC;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public void setIsLike(boolean z) {
        this.bAC = z;
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.bAC = simpleForum.is_liked.intValue() == 1;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.bAE = new v();
                this.bAE.a(simpleForum.multi_forum_perm);
            }
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
        }
    }
}
