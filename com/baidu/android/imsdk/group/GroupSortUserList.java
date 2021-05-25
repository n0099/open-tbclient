package com.baidu.android.imsdk.group;

import com.baidu.android.imsdk.chatuser.ChatUser;
import java.util.List;
/* loaded from: classes.dex */
public class GroupSortUserList {
    public int mSort;
    public List<ChatUser> mUsers;

    public GroupSortUserList(List<ChatUser> list, int i2) {
        this.mSort = 0;
        this.mUsers = list;
        this.mSort = i2;
    }

    public int getSort() {
        return this.mSort;
    }

    public List<ChatUser> getUsers() {
        return this.mUsers;
    }
}
