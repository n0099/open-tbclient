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
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONArray.put(arrayList.get(i));
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
            } catch (JSONException e) {
                LogUtils.e(IMGetUsersStatusRequest.class.getSimpleName(), "Exception ", e);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        JSONArray jSONArray;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            if (i != 0) {
                int i2 = this.mReSendCount;
                if (i2 >= 3) {
                    setNeedReSend(false);
                } else {
                    this.mReSendCount = i2 + 1;
                    setNeedReSend(true);
                    return;
                }
            }
            ArrayList<UserStatus> arrayList = null;
            if (i == 0) {
                try {
                    if (jSONObject.has("user_status") && (jSONArray = jSONObject.getJSONArray("user_status")) != null && jSONArray.length() > 0) {
                        ArrayList<UserStatus> arrayList2 = new ArrayList<>();
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                                if (jSONObject2.has("uid") && jSONObject2.has("status")) {
                                    long j = jSONObject2.getLong("uid");
                                    int i4 = jSONObject2.getInt("status");
                                    long j2 = 0;
                                    if (jSONObject2.has("last_operate_time")) {
                                        j2 = jSONObject2.getLong("last_operate_time");
                                    }
                                    long j3 = j2;
                                    if (i4 == 1) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    arrayList2.add(new UserStatus(j, z, j3));
                                }
                            } catch (Exception e) {
                                e = e;
                                arrayList = arrayList2;
                                LogUtils.e("IMGetUsersStatusRequest", "handleMessageResult :", e);
                                super.handleMessageResult(context, jSONObject, i, str);
                                if (arrayList == null) {
                                }
                                ChatUserManagerImpl.getInstance(context).onGetUsersStatusResult(getListenerKey(), 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList);
                            }
                        }
                        arrayList = arrayList2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            super.handleMessageResult(context, jSONObject, i, str);
            if (arrayList == null && arrayList.size() > 0) {
                ChatUserManagerImpl.getInstance(context).onGetUsersStatusResult(getListenerKey(), i, str, arrayList);
            } else {
                ChatUserManagerImpl.getInstance(context).onGetUsersStatusResult(getListenerKey(), 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList);
            }
        }
    }
}
