package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.UserStatus;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class IMGetUsersStatusRequest extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public int mReSendCount;
    public JSONArray mToUsers;

    public IMGetUsersStatusRequest(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mReSendCount = 0;
        initCommonParameter(context);
        this.mContext = context;
        this.mToUsers = jSONArray;
        setNeedReplay(true);
        setType(21);
    }

    public static IMGetUsersStatusRequest newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (!intent.hasExtra(Constants.EXTRA_LISTENER_ID) || (arrayList = (ArrayList) intent.getExtras().getSerializable(Constants.EXTRA_UIDS)) == null || arrayList.size() < 1) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    jSONArray.put(arrayList.get(i2));
                }
            }
            IMGetUsersStatusRequest iMGetUsersStatusRequest = new IMGetUsersStatusRequest(context, jSONArray);
            iMGetUsersStatusRequest.setListenerKey(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            return iMGetUsersStatusRequest;
        }
        return (IMGetUsersStatusRequest) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", getType());
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("to_users", this.mToUsers);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rpc_retry_time", this.mReSendCount);
                jSONObject.put("rpc", jSONObject2.toString());
                this.mBody = jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e(IMGetUsersStatusRequest.class.getSimpleName(), "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i2, str) == null) {
            if (i2 != 0) {
                int i3 = this.mReSendCount;
                if (i3 >= 3) {
                    setNeedReSend(false);
                } else {
                    this.mReSendCount = i3 + 1;
                    setNeedReSend(true);
                    return;
                }
            }
            ArrayList<UserStatus> arrayList = null;
            if (i2 == 0) {
                try {
                    if (jSONObject.has("user_status") && (jSONArray = jSONObject.getJSONArray("user_status")) != null && jSONArray.length() > 0) {
                        ArrayList<UserStatus> arrayList2 = new ArrayList<>();
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                                if (jSONObject2.has("uid") && jSONObject2.has("status")) {
                                    long j2 = jSONObject2.getLong("uid");
                                    int i5 = jSONObject2.getInt("status");
                                    arrayList2.add(new UserStatus(j2, i5 == 1, jSONObject2.has("last_operate_time") ? jSONObject2.getLong("last_operate_time") : 0L));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                arrayList = arrayList2;
                                LogUtils.e("IMGetUsersStatusRequest", "handleMessageResult :", e);
                                super.handleMessageResult(context, jSONObject, i2, str);
                                if (arrayList == null) {
                                }
                                ChatUserManagerImpl.getInstance(context).onGetUsersStatusResult(getListenerKey(), 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList);
                            }
                        }
                        arrayList = arrayList2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            super.handleMessageResult(context, jSONObject, i2, str);
            if (arrayList == null && arrayList.size() > 0) {
                ChatUserManagerImpl.getInstance(context).onGetUsersStatusResult(getListenerKey(), i2, str, arrayList);
            } else {
                ChatUserManagerImpl.getInstance(context).onGetUsersStatusResult(getListenerKey(), 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList);
            }
        }
    }
}
