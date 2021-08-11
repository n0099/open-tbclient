package com.baidu.android.imsdk.notification;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NotificationMsgData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NotificationMsgData";
    public transient /* synthetic */ FieldHolder $fh;
    public ChatMsg mMsg;
    public PaInfo mPainfo;
    public int mType;
    public List<Long> mUids;

    public NotificationMsgData(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatMsg};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mType = -1;
        this.mUids = new ArrayList();
        this.mMsg = chatMsg;
    }

    public List<Long> getInterActiveUserBduids() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mMsg != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mMsg.getJsonContent());
                    if (!jSONObject.optBoolean("is_merged", false) && (optJSONArray = jSONObject.optJSONArray("user_info")) != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 != null && jSONObject2.has("uk")) {
                                String transBDUK = Utility.transBDUK(jSONObject2.getString("uk"));
                                if (!TextUtils.isEmpty(transBDUK)) {
                                    this.mUids.add(Long.valueOf(Long.parseLong(transBDUK)));
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    LogUtils.e(TAG, "parseJsonString JSONException", e2);
                }
            }
            return this.mUids;
        }
        return (List) invokeV.objValue;
    }

    public ChatMsg getMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMsg : (ChatMsg) invokeV.objValue;
    }

    public PaInfo getPainfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPainfo : (PaInfo) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mType : invokeV.intValue;
    }

    public List<Long> getUids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mUids : (List) invokeV.objValue;
    }

    public void setMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, chatMsg) == null) {
            this.mMsg = chatMsg;
        }
    }

    public void setPainfo(PaInfo paInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, paInfo) == null) {
            this.mPainfo = paInfo;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mType = i2;
        }
    }

    public void updateUserInfo(ChatUser chatUser) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatUser) == null) || chatUser == null || this.mMsg == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mMsg.getJsonContent());
            if (jSONObject.optBoolean("is_merged", false) || (optJSONArray = jSONObject.optJSONArray("user_info")) == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                if (jSONObject2 != null && jSONObject2.has("uk")) {
                    String transBDUK = Utility.transBDUK(jSONObject2.getString("uk"));
                    if (!TextUtils.isEmpty(transBDUK) && chatUser.getBuid() == Long.parseLong(transBDUK)) {
                        jSONObject2.put("nickname", chatUser.getUserName());
                        jSONObject2.put("portrait", chatUser.getIconUrl());
                        jSONObject2.put("v_portrait", chatUser.getVPortrait());
                        jSONObject2.put("relation_follow", chatUser.getSubscribe());
                        jSONObject2.put("relation_phone", chatUser.getPhoneRelation());
                        jSONObject2.put("identify", chatUser.getIdentity());
                        this.mMsg.setMsgContent(jSONObject.toString());
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "updateUserInfo JSONException", e2);
        }
    }
}
