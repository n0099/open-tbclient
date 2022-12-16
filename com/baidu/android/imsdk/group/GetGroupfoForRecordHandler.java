package com.baidu.android.imsdk.group;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetGroupfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GetGroupfoForRecordHandler";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetGroupfoForRecordHandler(Context context) {
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
            if (IMConfigInternal.getInstance().getProductLine(this.mContext) == 4) {
                deleteUUid();
                if (callBack != null) {
                    GroupInfo groupInfo = new GroupInfo(String.valueOf(j));
                    groupInfo.setDescription("no");
                    groupInfo.setGroupName("no");
                    groupInfo.setType(3);
                    callBack.onSuccess(3, 1, groupInfo);
                    return;
                }
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(String.valueOf(j));
            LogUtils.d(TAG, "STAR Recordhandler get groupinfo " + j);
            GroupManagerImpl.getInstance(this.mContext).getGroupsInfo(1, arrayList, new BIMValueCallBack<ArrayList<GroupInfo>>(this, callBack, j) { // from class: com.baidu.android.imsdk.group.GetGroupfoForRecordHandler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GetGroupfoForRecordHandler this$0;
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
                        LogUtils.e(" ", "STAR Recordhandler get groupinfo size is 0");
                        this.val$callBack.onError(3, 1, 0L);
                        return;
                    }
                    ShieldAndTopManager.getInstance(this.this$0.mContext).getSingleContacterSetting(this.val$contacter, 3, new IGetShieldAndTopListener(this, arrayList2) { // from class: com.baidu.android.imsdk.group.GetGroupfoForRecordHandler.1.1
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
                                    GroupInfo groupInfo2 = (GroupInfo) this.val$object.get(0);
                                    groupInfo2.setMarkTop(getShieldAndTopResult.getMarkTop());
                                    groupInfo2.setMarkTopTime(getShieldAndTopResult.getMarkTopTime());
                                    groupInfo2.setDisturb(getShieldAndTopResult.getDisturbStatus());
                                    GroupInfoDAOImpl.updateGroupMarkTop(this.this$1.this$0.mContext, Utility.getLongByString(groupInfo2.getGroupId(), 0L), getShieldAndTopResult.getMarkTop(), getShieldAndTopResult.getMarkTopTime());
                                    GroupInfoDAOImpl.updateGroupDoNotDisturb(this.this$1.this$0.mContext, Utility.getLongByString(groupInfo2.getGroupId(), 0L), getShieldAndTopResult.getDisturbStatus());
                                }
                                this.this$1.val$callBack.onSuccess(3, 1, this.val$object.get(0));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{chatObject, Integer.valueOf(i), Integer.valueOf(i2), obj}) == null) && obj != null && (obj instanceof GroupInfo)) {
            LogUtils.d(TAG, "RECORDSESSION updatechatrecord " + obj.toString());
            GroupInfo groupInfo = (GroupInfo) obj;
            String groupName = groupInfo.getGroupName();
            if (groupInfo.getType() == 2) {
                i3 = 4;
            } else {
                i3 = i;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("disturb", groupInfo.getDisturb());
            } catch (JSONException unused) {
                LogUtils.e(TAG, "json put is error !");
            }
            updateChatRecord(chatObject, groupName, i3, "", 0, "", "", 0, groupInfo.getMarkTop(), groupInfo.getMarkTopTime(), 0, 0L, "", "", "", jSONObject.toString());
        }
    }
}
