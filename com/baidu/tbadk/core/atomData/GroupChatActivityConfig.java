package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class GroupChatActivityConfig extends IntentConfig {
    public static final String AUTO_SEND_EXTRA_MSG = "auto_send_extra_msg";
    public static final String AUTO_SEND_TEXT_MSG = "auto_send_text_msg";
    public static final String GROUP_AUTHOR_ID = "group_author_id";
    public static final String GROUP_ID = "group_id";
    public static final String GROUP_NAME = "group_name";
    public static final String GROUP_OBJ_TP = "ObjTp";
    private GroupData mGroupData;
    private String mObjTp;

    public GroupChatActivityConfig(Context context) {
        super(context);
        this.mGroupData = null;
        this.mObjTp = null;
    }

    public GroupChatActivityConfig(Activity activity, long j, String str, long j2, String str2) {
        super(activity);
        this.mGroupData = null;
        this.mObjTp = null;
        GroupData groupData = new GroupData();
        groupData.setGroupId(j);
        groupData.setName(str);
        groupData.setAuthorId(j2);
        this.mGroupData = groupData;
        this.mObjTp = str2;
        Intent intent = getIntent();
        intent.putExtra(GROUP_AUTHOR_ID, String.valueOf(groupData.getAuthorId()));
        intent.putExtra(GROUP_OBJ_TP, str2);
        intent.putExtra("chat_mode", 0);
        intent.putExtra("group", groupData);
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    public GroupChatActivityConfig(Activity activity, long j, String str, long j2, String str2, String str3, String str4) {
        super(activity);
        this.mGroupData = null;
        this.mObjTp = null;
        GroupData groupData = new GroupData();
        groupData.setGroupId(j);
        groupData.setName(str);
        groupData.setAuthorId(j2);
        this.mGroupData = groupData;
        this.mObjTp = str2;
        Intent intent = getIntent();
        intent.putExtra(GROUP_AUTHOR_ID, String.valueOf(groupData.getAuthorId()));
        intent.putExtra(GROUP_OBJ_TP, str2);
        intent.putExtra("chat_mode", 0);
        intent.putExtra("group", groupData);
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        if (str3 != null) {
            intent.putExtra(AUTO_SEND_TEXT_MSG, str3);
        }
        if (str4 != null) {
            intent.putExtra(AUTO_SEND_EXTRA_MSG, str4);
        }
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        GroupData groupData = getGroupData();
        return (groupData == null || groupData.getGroupId() == 0) ? false : true;
    }

    public GroupData getGroupData() {
        return this.mGroupData;
    }

    public String getObjTp() {
        return this.mObjTp;
    }
}
