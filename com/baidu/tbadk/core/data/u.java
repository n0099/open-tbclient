package com.baidu.tbadk.core.data;

import tbclient.MultiForumPerm;
/* loaded from: classes.dex */
public class u {
    public boolean afV;
    public boolean isDeleted;
    public int type;

    public void a(MultiForumPerm multiForumPerm) {
        int i;
        if (multiForumPerm != null) {
            this.afV = multiForumPerm.is_bawu.intValue() == 1;
            if ("manager".equals(multiForumPerm.bawu_type)) {
                i = 1;
            } else {
                i = "assist".equals(multiForumPerm.bawu_type) ? 2 : 0;
            }
            this.type = i;
            this.isDeleted = multiForumPerm.is_deleted.intValue() == 1;
        }
    }
}
