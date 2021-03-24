package com.baidu.android.imsdk.group;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BIMGroupManager extends BaseManager {
    public static void addGroupMembers(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).addGroupMembers(str, arrayList, bIMValueCallBack);
    }

    public static void clearStarGroup(Context context, long j) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        try {
            String valueOf = String.valueOf(j);
            String str = BaseManager.TAG;
            LogUtils.d(str, "clearStarGroup quitgroup " + j);
            DialogRecordDBManager.getInstance(context).delete(1, j);
            ConversationManagerImpl.getInstance(context).deleteConversation(1, valueOf);
            GroupInfoDAOImpl.quitGroup(context, valueOf);
        } catch (Exception e2) {
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            LogUtils.d(BaseManager.TAG, "ClearStarGroup exception, this is normal for device sync logic");
        }
    }

    public static void createGroup(Context context, int i, String str, ArrayList<String> arrayList, BIMValueCallBack<CreateResultInfo> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).createGroup(i, str, arrayList, bIMValueCallBack);
    }

    public static void delGroupMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).delGroupMember(str, arrayList, bIMValueCallBack);
    }

    public static void delStarMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).delStarMember(str, arrayList, bIMValueCallBack);
    }

    public static void getGlobalDisturbStatus(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        GroupManagerImpl.getInstance(context).getGlobalDisturbStatus(context, bIMValueCallBack);
    }

    public static void getGroupInfo(Context context, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupInfo>> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getGroupsInfo(0, arrayList, bIMValueCallBack);
    }

    public static void getGroupList(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getAllGroupList(bIMValueCallBack);
    }

    public static void getGroupMember(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<ArrayList<GroupMember>> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        if (arrayList == null) {
            GroupManagerImpl.getInstance(context).getAllGroupMember(str, arrayList, bIMValueCallBack);
        } else {
            GroupManagerImpl.getInstance(context).getGroupMember(0, str, arrayList, bIMValueCallBack);
        }
    }

    public static int getGroupUnread(Context context, String str) {
        return GroupMessageDAOImpl.getUnReadCount(context, str);
    }

    public static String getNickName(Context context, String str, long j) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return GroupManagerImpl.getInstance(context).getNickName(str, String.valueOf(j));
    }

    public static void getStarOnline(Context context, String str, BIMValueCallBack<Integer> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getStarOnline(str, bIMValueCallBack);
    }

    public static void init(Context context) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context);
    }

    public static void joinGroup(Context context, String str, String str2, int i, String str3, BIMValueCallBack<String> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).joinGroup(str, str2, i, str3, bIMValueCallBack);
    }

    public static void joinStarGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).joinStarGroup(str, bIMValueCallBack);
    }

    public static void quitGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).quitGroup(str, bIMValueCallBack);
    }

    public static void quitStarGroup(Context context, String str, BIMValueCallBack<String> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).quitStarGroup(str, bIMValueCallBack);
    }

    public static void setNickName(Context context, String str, long j, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).setNickName(str, j, str2, bIMValueCallBack);
    }

    public static void updateGroupName(Context context, String str, String str2, BIMValueCallBack<String> bIMValueCallBack) {
        GroupManagerImpl.getInstance(context).updateGroupName(str, str2, bIMValueCallBack);
    }

    public static void getGroupList(Context context, BIMValueCallBack<ArrayList<String>> bIMValueCallBack, int i, int i2) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).getGroupList(bIMValueCallBack, i, i2);
    }

    public static ArrayList<GroupMember> getNickName(Context context, String str) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return GroupManagerImpl.getInstance(context).getNickName(str);
    }

    public static ArrayList<GroupMember> getGroupMember(Context context, String str, int i) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(context, str, null, i);
        if (i == 0 || groupMember == null || (groupMember != null && groupMember.size() > 0)) {
            GroupManagerImpl.getInstance(context).getGroupMember(1, str, null, null);
        }
        return groupMember;
    }
}
