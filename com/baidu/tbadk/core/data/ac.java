package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.ForumPresentInfo;
import tbclient.UserRankPresentInfo;
/* loaded from: classes2.dex */
public class ac {
    public String dYi;
    public ArrayList<a> users;

    public void a(ForumPresentInfo forumPresentInfo) {
        if (forumPresentInfo != null) {
            this.dYi = forumPresentInfo.content;
            this.users = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < forumPresentInfo.user_list.size()) {
                    this.users.add(new a(forumPresentInfo.user_list.get(i2)));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public Integer dYj;
        public String userName;
        public String userPortrait;

        public a(UserRankPresentInfo userRankPresentInfo) {
            if (userRankPresentInfo != null) {
                this.dYj = userRankPresentInfo.user_id;
                this.userName = userRankPresentInfo.user_name;
                this.userPortrait = userRankPresentInfo.portrait;
            }
        }
    }
}
