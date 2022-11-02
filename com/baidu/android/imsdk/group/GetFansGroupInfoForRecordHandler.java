package com.baidu.android.imsdk.group;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.shield.IGetShieldAndTopListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GetFansGroupInfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GetFansGroupInfoForRecordHandler";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetFansGroupInfoForRecordHandler(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j, CallBack callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, callBack) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(String.valueOf(j));
            LogUtils.d(TAG, "getChatObjectInfo " + j);
            GroupManagerImpl.getInstance(this.mContext).getFansGroupInfo(arrayList, true, new BIMValueCallBack<ArrayList<GroupInfo>>(this, callBack, j) { // from class: com.baidu.android.imsdk.group.GetFansGroupInfoForRecordHandler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GetFansGroupInfoForRecordHandler this$0;
                public final /* synthetic */ CallBack val$callBack;
                public final /* synthetic */ long val$contacter;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, callBack, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callBack = callBack;
                    this.val$contacter = j;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i, String str, ArrayList<GroupInfo> arrayList2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, arrayList2) != null) || i != 0) {
                        return;
                    }
                    this.this$0.deleteUUid();
                    if (arrayList2.size() == 0) {
                        LogUtils.e(GetFansGroupInfoForRecordHandler.TAG, "getChatObjectInfo get groupinfo size is 0");
                        this.val$callBack.onError(57, 1, 0L);
                        return;
                    }
                    ShieldAndTopManager.getInstance(this.this$0.mContext).getSingleContacterSetting(this.val$contacter, 57, new IGetShieldAndTopListener(this, arrayList2) { // from class: com.baidu.android.imsdk.group.GetFansGroupInfoForRecordHandler.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ ArrayList val$object;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList2};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$object = arrayList2;
                        }

                        @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                        public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, getShieldAndTopResult) == null) {
                                if (getShieldAndTopResult.getErrorCode() == 0 && this.val$object.get(0) != null) {
                                    GroupInfo groupInfo = (GroupInfo) this.val$object.get(0);
                                    groupInfo.setMarkTop(getShieldAndTopResult.getMarkTop());
                                    groupInfo.setMarkTopTime(getShieldAndTopResult.getMarkTopTime());
                                    GroupInfoDAOImpl.updateGroupMarkTop(this.this$1.this$0.mContext, Utility.getLongByString(groupInfo.getGroupId(), 0L), getShieldAndTopResult.getMarkTop(), getShieldAndTopResult.getMarkTopTime());
                                }
                                this.this$1.val$callBack.onSuccess(57, 1, this.val$object.get(0));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{chatObject, Integer.valueOf(i), Integer.valueOf(i2), obj}) != null) || !(obj instanceof GroupInfo)) {
            return;
        }
        LogUtils.d(TAG, "updateChatRecord " + obj.toString());
        GroupInfo groupInfo = (GroupInfo) obj;
        updateChatRecord(chatObject, groupInfo.getGroupName(), i, groupInfo.getHeadUrl(), 0, "", "", 0, groupInfo.getMarkTop(), groupInfo.getMarkTopTime(), 0, 0L, "", "", "");
    }
}
