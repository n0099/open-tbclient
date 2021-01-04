package com.baidu.android.imsdk.group;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class GroupInfoSyncManagerImpl {
    public static final String TAG_GROUPLIST_STATE = "get_all_grouplist_state";
    public static HashMap<String, ArrayList<String>> sUpdateGroupMembers = new HashMap<>();
    public static ArrayList<String> sUpdateGroupInfo = new ArrayList<>();
    public static ArrayList<String> sUpdateAllMember = new ArrayList<>();

    public static void syncAllGroupList(final Context context) {
        if (AccountManagerImpl.getInstance(context).getLoginType() != 6) {
            if (Utility.readIntData(context, TAG_GROUPLIST_STATE + AccountManager.getAppid(context) + AccountManager.getUid(context), -1) < 0) {
                GroupManagerImpl.getInstance(context).getGroupList(null);
            }
            final ArrayList<String> starGroupList = GroupInfoDAOImpl.getStarGroupList(context);
            if (starGroupList != null && starGroupList.size() > 0) {
                new Timer(true).schedule(new TimerTask() { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        LogUtils.d("", "SYNCGROUP star begin..." + starGroupList.toString());
                        GroupInfoSyncManagerImpl.handleGetGroupinfos(context, starGroupList);
                    }
                }, 30000L);
            }
        }
    }

    public static void syncAllGroupListDone(Context context) {
        Utility.writeIntData(context, TAG_GROUPLIST_STATE + AccountManager.getAppid(context) + AccountManager.getUid(context), 1);
    }

    public static void addSyncGroupInfo(String str) {
        synchronized (sUpdateGroupInfo) {
            if (!sUpdateGroupInfo.contains(str)) {
                sUpdateGroupInfo.add(str);
            }
        }
    }

    public static void deleteSyncGroupMemeber(String str, List<String> list) {
        if (list != null && list.size() != 0) {
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

    public static void activeSyncAllMembers(Context context, String str) {
        handleGetGroupMember(context, str, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        handleGetGroupinfos(context, arrayList);
    }

    public static void syncAllMembers(Context context, String str) {
        synchronized (sUpdateAllMember) {
            boolean z = true;
            if (sUpdateAllMember.contains(str)) {
                z = false;
            }
            if (z) {
                LogUtils.d("", "HHHto do handleGetGroupMember " + str);
                handleGetGroupMember(context, str, null);
                sUpdateAllMember.add(str);
            }
        }
    }

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
            if (arrayList != null && arrayList.size() > 0) {
                int size = arrayList.size() / 20;
                for (int i = 0; i < size; i++) {
                    handleGetGroupinfos(context, new ArrayList(arrayList.subList(i * 20, (i * 20) + 20)));
                }
                if (arrayList.size() % 20 != 0) {
                    handleGetGroupinfos(context, new ArrayList(arrayList.subList(20 * size, arrayList.size())));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleGetGroupinfos(Context context, final ArrayList<String> arrayList) {
        GroupManagerImpl.getInstance(context).getGroupsInfo(1, arrayList, new BIMValueCallBack<ArrayList<GroupInfo>>() { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i, String str, ArrayList<GroupInfo> arrayList2) {
                if (i != 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        GroupInfoSyncManagerImpl.addSyncGroupInfo((String) it.next());
                    }
                }
            }
        });
    }

    private static void handleGetGroupMember(Context context, final String str, final ArrayList<String> arrayList) {
        if ((arrayList != null && arrayList.size() > 0) || arrayList == null) {
            GroupManagerImpl.getInstance(context).getGroupMember(1, str, arrayList, new BIMValueCallBack<ArrayList<GroupMember>>() { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i, String str2, ArrayList<GroupMember> arrayList2) {
                    if (i != 0) {
                        GroupInfoSyncManagerImpl.addSyncGroupMemeber(str, arrayList);
                    }
                }
            });
        }
    }

    public static void activeSyncGroup(Context context, String str) {
        boolean z;
        boolean z2;
        ArrayList<String> arrayList = null;
        synchronized (sUpdateGroupMembers) {
            if (sUpdateGroupMembers.containsKey(str)) {
                arrayList = sUpdateGroupMembers.remove(str);
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            handleGetGroupMember(context, str, arrayList);
        }
        synchronized (sUpdateGroupInfo) {
            if (sUpdateGroupInfo.contains(str)) {
                sUpdateGroupInfo.remove(str);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str);
            handleGetGroupinfos(context, arrayList2);
        }
    }
}
