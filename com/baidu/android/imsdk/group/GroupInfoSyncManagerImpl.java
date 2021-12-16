package com.baidu.android.imsdk.group;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public class GroupInfoSyncManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG_FANSGROUPLIST_STATE = "get_all_fansgrouplist_state";
    public static final String TAG_GROUPLIST_STATE = "get_all_grouplist_state";
    public static ArrayList<String> sUpdateAllMember;
    public static ArrayList<String> sUpdateGroupInfo;
    public static HashMap<String, ArrayList<String>> sUpdateGroupMembers;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1558054271, "Lcom/baidu/android/imsdk/group/GroupInfoSyncManagerImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1558054271, "Lcom/baidu/android/imsdk/group/GroupInfoSyncManagerImpl;");
                return;
            }
        }
        sUpdateGroupMembers = new HashMap<>();
        sUpdateGroupInfo = new ArrayList<>();
        sUpdateAllMember = new ArrayList<>();
    }

    public GroupInfoSyncManagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void activeSyncAllGroup(Context context) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
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
    }

    public static void activeSyncAllMembers(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, i2) == null) {
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
    }

    public static void activeSyncGroup(Context context, String str) {
        boolean z;
        ArrayList<String> arrayList;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
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
    }

    public static void addSyncGroupInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            synchronized (sUpdateGroupInfo) {
                if (!sUpdateGroupInfo.contains(str)) {
                    sUpdateGroupInfo.add(str);
                }
            }
        }
    }

    public static void addSyncGroupMemeber(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, list) == null) {
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
    }

    public static void deleteSyncGroupMemeber(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, str, list) == null) || list == null || list.size() == 0) {
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

    public static void handleGetGroupMember(Context context, String str, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, str, arrayList) == null) {
            if ((arrayList == null || arrayList.size() <= 0) && arrayList != null) {
                return;
            }
            GroupManagerImpl.getInstance(context).getGroupMember(1, str, arrayList, new BIMValueCallBack<ArrayList<GroupMember>>(str, arrayList) { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$groupid;
                public final /* synthetic */ ArrayList val$uids;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$groupid = str;
                    this.val$uids = arrayList;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i2, String str2, ArrayList<GroupMember> arrayList2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2, arrayList2) == null) || i2 == 0) {
                        return;
                    }
                    GroupInfoSyncManagerImpl.addSyncGroupMemeber(this.val$groupid, this.val$uids);
                }
            });
        }
    }

    public static void handleGetGroupinfos(Context context, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int size = arrayList.size() / 20;
        for (int i2 = 0; i2 < size; i2++) {
            LogUtils.d("GroupInfoSyncManagerImpl", "handleGetGroupinfos times = " + i2);
            int i3 = i2 * 20;
            GroupManagerImpl.getInstance(context).getGroupsInfo(1, new ArrayList<>(arrayList.subList(i3, i3 + 20)), new BIMValueCallBack<ArrayList<GroupInfo>>(arrayList) { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ArrayList val$groupids;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$groupids = arrayList;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i4, String str, ArrayList<GroupInfo> arrayList2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str, arrayList2) == null) || i4 == 0) {
                        return;
                    }
                    Iterator it = this.val$groupids.iterator();
                    while (it.hasNext()) {
                        GroupInfoSyncManagerImpl.addSyncGroupInfo((String) it.next());
                    }
                }
            });
        }
        if (arrayList.size() % 20 != 0) {
            LogUtils.d("GroupInfoSyncManagerImpl", "handleGetGroupinfos rest");
            GroupManagerImpl.getInstance(context).getGroupsInfo(1, new ArrayList<>(arrayList.subList(size * 20, arrayList.size())), new BIMValueCallBack<ArrayList<GroupInfo>>(arrayList) { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ArrayList val$groupids;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$groupids = arrayList;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i4, String str, ArrayList<GroupInfo> arrayList2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str, arrayList2) == null) || i4 == 0) {
                        return;
                    }
                    Iterator it = this.val$groupids.iterator();
                    while (it.hasNext()) {
                        GroupInfoSyncManagerImpl.addSyncGroupInfo((String) it.next());
                    }
                }
            });
        }
    }

    public static void syncAllGroupList(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, context) == null) || AccountManagerImpl.getInstance(context).getLoginType() == 6) {
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
        ArrayList<String> starGroupList = GroupInfoDAOImpl.getStarGroupList(context);
        if (starGroupList == null || starGroupList.size() <= 0) {
            return;
        }
        new Timer(true).schedule(new TimerTask(starGroupList, context) { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ArrayList val$gids;
            public final /* synthetic */ Context val$lcontext;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {starGroupList, context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$gids = starGroupList;
                this.val$lcontext = context;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogUtils.d("", "SYNCGROUP star begin..." + this.val$gids.toString());
                    GroupInfoSyncManagerImpl.handleGetGroupinfos(this.val$lcontext, this.val$gids);
                }
            }
        }, 30000L);
    }

    public static void syncAllGroupListDone(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            Utility.writeIntData(context, TAG_GROUPLIST_STATE + AccountManager.getAppid(context) + AccountManager.getUid(context), 1);
        }
    }

    public static void syncAllMembers(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
            synchronized (sUpdateAllMember) {
                if (!sUpdateAllMember.contains(str)) {
                    LogUtils.d("", "HHHto do handleGetGroupMember " + str);
                    handleGetGroupMember(context, str, null);
                    sUpdateAllMember.add(str);
                }
            }
        }
    }

    public static void syncFansGroupListDone(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            Utility.writeIntData(context, TAG_FANSGROUPLIST_STATE + AccountManager.getAppid(context) + AccountManager.getUid(context), 1);
        }
    }

    public static void updateExpiredFansGroups(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, context) == null) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context) { // from class: com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis() - IMConstants.FANS_GROUP_INFO_EXPIRED_TIME;
                        ArrayList<String> expiredFansGroupInfoList = GroupInfoDAOImpl.getExpiredFansGroupInfoList(this.val$context, currentTimeMillis);
                        if (expiredFansGroupInfoList != null && expiredFansGroupInfoList.size() > 0) {
                            GroupManagerImpl.getInstance(this.val$context).getFansGroupInfo(expiredFansGroupInfoList, true, null);
                        }
                        ArrayList<String> expiredFansGroupMemberList = GroupInfoDAOImpl.getExpiredFansGroupMemberList(this.val$context, currentTimeMillis);
                        if (expiredFansGroupMemberList == null || expiredFansGroupMemberList.size() <= 0) {
                            return;
                        }
                        Iterator<String> it = expiredFansGroupMemberList.iterator();
                        while (it.hasNext()) {
                            GroupManagerImpl.getInstance(this.val$context).getFansGroupMember(it.next(), null, true, null);
                        }
                    }
                }
            });
        }
    }
}
