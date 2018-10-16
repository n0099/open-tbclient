package com.baidu.tbadk.core.data;

import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class ay implements com.baidu.tbadk.core.view.commonLike.forum.b {
    private boolean aoK;
    private boolean aoL;
    public t aoM;
    private String avatar;
    private String forumId;
    private int forumLevel;
    private String forumName;
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
    public void aI(boolean z) {
        this.aoL = z;
    }

    public boolean xT() {
        return this.aoL;
    }

    public String getAvatar() {
        return this.avatar;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public boolean getIsLike() {
        return this.aoK;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public void setIsLike(boolean z) {
        this.aoK = z;
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.aoK = simpleForum.is_liked.intValue() == 1;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.aoM = new t();
                this.aoM.a(simpleForum.multi_forum_perm);
            }
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
        }
    }
}
