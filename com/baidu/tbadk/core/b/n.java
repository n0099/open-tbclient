package com.baidu.tbadk.core.b;

import android.app.Activity;
import android.content.Intent;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.core.frameworkData.a {
    private GroupData a;
    private String b;

    public n(Activity activity, int i, String str, long j, String str2) {
        super(activity);
        this.a = null;
        this.b = null;
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        groupData.setName(str);
        groupData.setAuthorId(j);
        this.a = groupData;
        this.b = str2;
        Intent d = d();
        d.putExtra("group_author_id", String.valueOf(groupData.getAuthorId()));
        d.putExtra("ObjTp", str2);
        d.putExtra("chat_mode", 0);
        d.putExtra("group", groupData);
        d.putExtra("is_accept_notify", true);
        d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    @Override // com.baidu.tbadk.core.frameworkData.a
    public final boolean a() {
        GroupData groupData = this.a;
        return (groupData == null || groupData.getGroupId() == 0) ? false : true;
    }
}
