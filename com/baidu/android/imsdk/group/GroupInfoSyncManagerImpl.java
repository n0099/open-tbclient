package com.baidu.android.imsdk.group;

import android.content.Context;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class GroupInfoSyncManagerImpl {
    public static final String TAG_FANSGROUPLIST_STATE = "get_all_fansgrouplist_state";
    public static final String TAG_GROUPLIST_STATE = "get_all_grouplist_state";
    public static HashMap<String, ArrayList<String>> sUpdateGroupMembers = new HashMap<>();
    public static ArrayList<String> sUpdateGroupInfo = new ArrayList<>();
    public static ArrayList<String> sUpdateAllMember = new ArrayList<>();

    public static void activeSyncAllGroup(Context context) {
        ArrayList arrayList;
        if (sUpdateGroupInfo.size() > 0 || sUpdateGroupMembers.size() > 0) {
            synchronized (sUpdateGroupMembers) {
                for (String str : sUpdateGroupMembers.keySet()) {
                    handleGetGroupMember(context, str, sUpdateGroupMembers.remove(str));
                }
            }
            synchronized (sUpdateGroupInfo) {
                arrayList = new ArrayList(sUpdateGroupInfo);
                sUpdateGroupInfo.clear();
            }
            handleGetGroupinfos(context, arrayList);
        }
    }

    public static void activeSyncAllMembers(Context context, String str, int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        if (i2 == 3) {
            GroupManagerImpl.getInstance(context).getFansGroupMember(str, null, true, null);
            GroupManagerImpl.getInstance(context).getFansGroupInfo(arrayList, true, null);
            return;
        }
        handleGetGroupMember(context, str, null);
        handleGetGroupinfos(context, arrayList);
    }

    public static void activeSyncGroup(Context context, String str) {
        boolean z;
        ArrayList<String> arrayList;
        boolean z2;
        synchronized (sUpdateGroupMembers) {
            z = true;
            if (sUpdateGroupMembers.containsKey(str)) {
                arrayList = sUpdateGroupMembers.remove(str);
                z2 = true;
            } else {
                arrayList = null;
                z2 = false;
            }
        }
        if (z2) {
            handleGetGroupMember(context, str, arrayList);
        }
        synchronized (sUpdateGroupInfo) {
            if (sUpdateGroupInfo.contains(str)) {
                sUpdateGroupInfo.remove(str);
            } else {
                z = false;
            }
        }
        if (z) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str);
            handleGetGroupinfos(context, arrayList2);
        }
    }

    public static void addSyncGroupInfo(String str) {
        synchronized (sUpdateGroupInfo) {
            if (!sUpdateGroupInfo.contains(str)) {
                sUpdateGroupInfo.add(str);
            }
        }
    }

    public static void addSyncGroupMemeber(String str, List<String> list) {
        if (list != null) {
            synchronized (sUpdateGroupMembers) {
                if (sUpdateGroupMembers.containsKey(str)) {
                    if (sUpdateGroupMembers.get(str) != null) {
                        sUpdateGroupMembers.get(str).addAll(list);
                    }
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(list);
                    sUpdateGroupMembers.put(str, arrayList);
                }
            }
            return;
        }
        synchronized (sUpdateGroupMembers) {
            sUpdateGroupMembers.put(str, null);
        }
    }

    public static void deleteSyncGroupMemeber(String str, List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (sUpdateGroupMembers) {
            if (sUpdateGroupMembers.containsKey(str)) {
                ArrayList<String> arrayList = sUpdateGroupMembers.get(str);
                if (arrayList != null) {
                    for (String str2 : list) {
                        if (arrayList.contains(str2)) {
                            arrayList.remove(str2);
                        }
                    }
                }
            } else {
                sUpdateGroupMembers.put(str, new ArrayList<>());
            }
        }
    }

    public static void handleGetGroupMember(Context context, final String str, final ArrayList<String> arrayList) {
        if ((arrayList == null || arrayList.size() <= 0) && arrayList != null) {
            return;
        }
        GroupManagerImpl.getInstance(context).getGroupMember(1, str, arrayList, new BIMValueCallBack<ArrayList<GroupMember>>() { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i2, String str2, ArrayList<GroupMember> arrayList2) {
                if (i2 != 0) {
                    GroupInfoSyncManagerImpl.addSyncGroupMemeber(str, arrayList);
                }
            }
        });
    }

    public static void handleGetGroupinfos(Context context, final ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int size = arrayList.size() / 20;
        for (int i2 = 0; i2 < size; i2++) {
            LogUtils.d("GroupInfoSyncManagerImpl", "handleGetGroupinfos times = " + i2);
            int i3 = i2 * 20;
            GroupManagerImpl.getInstance(context).getGroupsInfo(1, new ArrayList<>(arrayList.subList(i3, i3 + 20)), new BIMValueCallBack<ArrayList<GroupInfo>>() { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i4, String str, ArrayList<GroupInfo> arrayList2) {
                    if (i4 != 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupInfoSyncManagerImpl.addSyncGroupInfo((String) it.next());
                        }
                    }
                }
            });
        }
        if (arrayList.size() % 20 != 0) {
            LogUtils.d("GroupInfoSyncManagerImpl", "handleGetGroupinfos rest");
            GroupManagerImpl.getInstance(context).getGroupsInfo(1, new ArrayList<>(arrayList.subList(size * 20, arrayList.size())), new BIMValueCallBack<ArrayList<GroupInfo>>() { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i4, String str, ArrayList<GroupInfo> arrayList2) {
                    if (i4 != 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupInfoSyncManagerImpl.addSyncGroupInfo((String) it.next());
                        }
                    }
                }
            });
        }
    }

    public static void syncAllGroupList(final Context context) {
        if (AccountManagerImpl.getInstance(context).getLoginType() == 6) {
            return;
        }
        if (Utility.readIntData(context, TAG_GROUPLIST_STATE + AccountManager.getAppid(context) + AccountManager.getUid(context), -1) < 0) {
            GroupManagerImpl.getInstance(context).getGroupList(null);
        }
        if (Utility.readIntData(context, TAG_FANSGROUPLIST_STATE + AccountManager.getAppid(context) + AccountManager.getUid(context), -1) < 0) {
            GroupManagerImpl.getInstance(context).getFansGroupList(true, null);
        } else {
            updateExpiredFansGroups(context);
        }
        final ArrayList<String> starGroupList = GroupInfoDAOImpl.getStarGroupList(context);
        if (starGroupList == null || starGroupList.size() <= 0) {
            return;
        }
        new Timer(true).schedule(new TimerTask() { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LogUtils.d("", "SYNCGROUP star begin..." + starGroupList.toString());
                GroupInfoSyncManagerImpl.handleGetGroupinfos(context, starGroupList);
            }
        }, 30000L);
    }

    public static void syncAllGroupListDone(Context context) {
        Utility.writeIntData(context, TAG_GROUPLIST_STATE + AccountManager.getAppid(context) + AccountManager.getUid(context), 1);
    }

    public static void syncAllMembers(Context context, String str) {
        synchronized (sUpdateAllMember) {
            if (!sUpdateAllMember.contains(str)) {
                LogUtils.d("", "HHHto do handleGetGroupMember " + str);
                handleGetGroupMember(context, str, null);
                sUpdateAllMember.add(str);
            }
        }
    }

    public static void syncFansGroupListDone(Context context) {
        Utility.writeIntData(context, TAG_FANSGROUPLIST_STATE + AccountManager.getAppid(context) + AccountManager.getUid(context), 1);
    }

    public static void updateExpiredFansGroups(final Context context) {
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis() - IMConstants.FANS_GROUP_INFO_EXPIRED_TIME;
                ArrayList<String> expiredFansGroupInfoList = GroupInfoDAOImpl.getExpiredFansGroupInfoList(context, currentTimeMillis);
                if (expiredFansGroupInfoList != null && expiredFansGroupInfoList.size() > 0) {
                    GroupManagerImpl.getInstance(context).getFansGroupInfo(expiredFansGroupInfoList, true, null);
                }
                ArrayList<String> expiredFansGroupMemberList = GroupInfoDAOImpl.getExpiredFansGroupMemberList(context, currentTimeMillis);
                if (expiredFansGroupMemberList == null || expiredFansGroupMemberList.size() <= 0) {
                    return;
                }
                Iterator<String> it = expiredFansGroupMemberList.iterator();
                while (it.hasNext()) {
                    GroupManagerImpl.getInstance(context).getFansGroupMember(it.next(), null, true, null);
                }
            }
        });
    }
}
