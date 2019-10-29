package com.baidu.tbadk.core.data;

import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class bd implements com.baidu.tbadk.core.view.commonLike.forum.b {
    private String avatar;
    private boolean caZ;
    private boolean cba;
    public v cbb;
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
    public void dY(boolean z) {
        this.cba = z;
    }

    public boolean ahV() {
        return this.cba;
    }

    public String getAvatar() {
        return this.avatar;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public boolean getIsLike() {
        return this.caZ;
    }

    @Override // com.baidu.tbadk.core.view.commonLike.a
    public void setIsLike(boolean z) {
        this.caZ = z;
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.caZ = simpleForum.is_liked.intValue() == 1;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.cbb = new v();
                this.cbb.a(simpleForum.multi_forum_perm);
            }
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
        }
    }
}
