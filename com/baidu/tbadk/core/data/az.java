package com.baidu.tbadk.core.data;

import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class az {
    public t aMT;
    private String avatar;
    private String forumId;
    private int forumLevel;
    private String forumName;

    public String getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            this.forumId = String.valueOf(simpleForum.id);
            this.forumName = simpleForum.name;
            this.avatar = simpleForum.avatar;
            this.forumLevel = simpleForum.level_id.intValue();
            if (simpleForum.multi_forum_perm != null) {
                this.aMT = new t();
                this.aMT.a(simpleForum.multi_forum_perm);
            }
        }
    }
}
