package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.ForumPresentInfo;
import tbclient.UserRankPresentInfo;
/* loaded from: classes.dex */
public class t {
    public String WB;
    public ArrayList<a> users;

    public void a(ForumPresentInfo forumPresentInfo) {
        if (forumPresentInfo != null) {
            this.WB = forumPresentInfo.content;
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

    /* loaded from: classes.dex */
    public class a {
        public Integer WC;
        public String userName;
        public String userPortrait;

        public a(UserRankPresentInfo userRankPresentInfo) {
            if (userRankPresentInfo != null) {
                this.WC = userRankPresentInfo.user_id;
                this.userName = userRankPresentInfo.user_name;
                this.userPortrait = userRankPresentInfo.portrait;
            }
        }
    }
}
