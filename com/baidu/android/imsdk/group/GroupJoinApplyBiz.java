package com.baidu.android.imsdk.group;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GroupJoinApplyBiz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GroupJoinApplyBiz() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void getFansGroupApplyCountFromServer(Context context, List<String> list, BIMValuesCallBack<Long, Integer> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, list, bIMValuesCallBack) == null) {
            GroupManagerImpl.getInstance(context).getFansGroupApplyCountFromServer(list, new BIMValueCallBack<ArrayList<GroupApplyBean>>(bIMValuesCallBack) { // from class: com.baidu.android.imsdk.group.GroupJoinApplyBiz.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BIMValuesCallBack val$callBack;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bIMValuesCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$callBack = bIMValuesCallBack;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i, String str, ArrayList<GroupApplyBean> arrayList) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, arrayList) == null) {
                        if (i == 0 && arrayList != null && arrayList.size() > 0) {
                            GroupApplyBean groupApplyBean = arrayList.get(0);
                            if (groupApplyBean != null) {
                                long j = groupApplyBean.groupId;
                                if (j > 0) {
                                    this.val$callBack.onResult(i, "", Long.valueOf(j), Integer.valueOf(groupApplyBean.joinApplyCount));
                                    return;
                                }
                            }
                            this.val$callBack.onResult(i, "", 0L, 0);
                            return;
                        }
                        this.val$callBack.onResult(i, "", 0L, 0);
                    }
                }
            });
        }
    }

    public static void isGroupOwnerOrManager(Context context, String str, ArrayList<String> arrayList, BIMValueCallBack<Boolean> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, context, str, arrayList, bIMValueCallBack) == null) {
            BIMGroupManager.getFansGroupMember(context, str, arrayList, true, new BIMValueCallBack<ArrayList<GroupMember>>(bIMValueCallBack) { // from class: com.baidu.android.imsdk.group.GroupJoinApplyBiz.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BIMValueCallBack val$callBack;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bIMValueCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$callBack = bIMValueCallBack;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i, String str2, ArrayList<GroupMember> arrayList2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, arrayList2) == null) {
                        if (i == 0 && arrayList2 != null && arrayList2.size() > 0) {
                            int role = arrayList2.get(0).getRole();
                            if (role != 1 && role != 2) {
                                this.val$callBack.onResult(0, "", Boolean.FALSE);
                                return;
                            } else {
                                this.val$callBack.onResult(0, "", Boolean.TRUE);
                                return;
                            }
                        }
                        this.val$callBack.onResult(-1003, "", Boolean.FALSE);
                    }
                }
            });
        }
    }

    public static void fetchJoinGroupApplyCountIfNeed(Context context, String str, BIMValuesCallBack<Long, Integer> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, bIMValuesCallBack) == null) {
            if (!TextUtils.isEmpty(str) && bIMValuesCallBack != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                BIMGroupManager.getFansGroupInfo(context, arrayList, true, new BIMValueCallBack<ArrayList<GroupInfo>>(context, str, arrayList, bIMValuesCallBack) { // from class: com.baidu.android.imsdk.group.GroupJoinApplyBiz.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BIMValuesCallBack val$callBack;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$groupId;
                    public final /* synthetic */ ArrayList val$list;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, str, arrayList, bIMValuesCallBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$groupId = str;
                        this.val$list = arrayList;
                        this.val$callBack = bIMValuesCallBack;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                    public void onResult(int i, String str2, ArrayList<GroupInfo> arrayList2) {
                        GroupInfo groupInfo;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, arrayList2) == null) {
                            if (i == 0 && arrayList2 != null && arrayList2.size() > 0 && (groupInfo = arrayList2.get(0)) != null && groupInfo.getState() == 0 && groupInfo.getAuditState() == 1 && groupInfo.getNum() < groupInfo.getGroupCapacity()) {
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(AccountManager.getUid(this.val$context));
                                GroupJoinApplyBiz.isGroupOwnerOrManager(this.val$context, this.val$groupId, arrayList3, new BIMValueCallBack<Boolean>(this) { // from class: com.baidu.android.imsdk.group.GroupJoinApplyBiz.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$0;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                    public void onResult(int i2, String str3, Boolean bool) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeILL(1048576, this, i2, str3, bool) == null) {
                                            if (bool.booleanValue()) {
                                                AnonymousClass1 anonymousClass1 = this.this$0;
                                                GroupJoinApplyBiz.getFansGroupApplyCountFromServer(anonymousClass1.val$context, anonymousClass1.val$list, anonymousClass1.val$callBack);
                                                return;
                                            }
                                            this.this$0.val$callBack.onResult(0, "", 0L, 0);
                                        }
                                    }
                                });
                                return;
                            }
                            this.val$callBack.onResult(0, "", 0L, 0);
                        }
                    }
                });
            } else if (bIMValuesCallBack != null) {
                bIMValuesCallBack.onResult(1005, "group id empty", 0L, 0);
            }
        }
    }
}
