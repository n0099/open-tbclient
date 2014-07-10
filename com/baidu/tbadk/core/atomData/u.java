package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Intent;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.core.frameworkData.a {
    private GroupData a;
    private String b;

    public u(Activity activity, int i, String str, long j, String str2) {
        super(activity);
        this.a = null;
        this.b = null;
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        groupData.setName(str);
        groupData.setAuthorId(j);
        this.a = groupData;
        this.b = str2;
        Intent intent = getIntent();
        intent.putExtra("group_author_id", String.valueOf(groupData.getAuthorId()));
        intent.putExtra("ObjTp", str2);
        intent.putExtra("chat_mode", 0);
        intent.putExtra("group", groupData);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    public u(Activity activity, int i, String str, long j, String str2, String str3, String str4) {
        super(activity);
        this.a = null;
        this.b = null;
        GroupData groupData = new GroupData();
        groupData.setGroupId(i);
        groupData.setName(str);
        groupData.setAuthorId(j);
        this.a = groupData;
        this.b = str2;
        Intent intent = getIntent();
        intent.putExtra("group_author_id", String.valueOf(groupData.getAuthorId()));
        intent.putExtra("ObjTp", str2);
        intent.putExtra("chat_mode", 0);
        intent.putExtra("group", groupData);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true);
        if (str3 != null) {
            intent.putExtra("auto_send_text_msg", str3);
        }
        if (str4 != null) {
            intent.putExtra("auto_send_extra_msg", str4);
        }
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    @Override // com.baidu.tbadk.core.frameworkData.a
    public boolean isValid() {
        GroupData a = a();
        return (a == null || a.getGroupId() == 0) ? false : true;
    }

    public GroupData a() {
        return this.a;
    }
}
