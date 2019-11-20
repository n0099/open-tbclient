package com.baidu.tbadk.core.data;

import com.baidu.live.tbadk.data.Config;
import tbclient.MultiForumPerm;
/* loaded from: classes.dex */
public class v {
    public boolean bYd;
    public boolean isDeleted;
    public int type;

    public void a(MultiForumPerm multiForumPerm) {
        int i;
        if (multiForumPerm != null) {
            this.bYd = multiForumPerm.is_bawu.intValue() == 1;
            if (Config.BAWU_TYPE_MANAGER.equals(multiForumPerm.bawu_type)) {
                i = 1;
            } else {
                i = Config.BAWU_TYPE_ASSIST.equals(multiForumPerm.bawu_type) ? 2 : 0;
            }
            this.type = i;
            this.isDeleted = multiForumPerm.is_deleted.intValue() == 1;
        }
    }
}
