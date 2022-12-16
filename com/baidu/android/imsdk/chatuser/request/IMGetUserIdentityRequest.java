package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.GetUserSliceListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.ubc.CaseUbc;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetUserIdentityRequest extends IMUserBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGetUserIdentityRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public List<Long> mBduids;
    public GetUserSliceListener mListener;

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 5000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 5000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMGetUserIdentityRequest(Context context, List<Long> list, GetUserSliceListener getUserSliceListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, getUserSliceListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.mBduids = arrayList;
        arrayList.addAll(list);
        this.mContext = context;
        this.mListener = getUserSliceListener;
    }

    @Override // com.baidu.android.imsdk.chatuser.request.IMUserBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/3.0/im/get_user_info";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            String md5 = getMd5("" + bduss + currentTimeMillis);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("appid", AccountManager.getAppid(this.mContext));
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put("sign", md5);
                int loginType = AccountManagerImpl.getInstance(this.mContext).getLoginType();
                jSONObject.put("account_type", loginType);
                if (loginType == 11) {
                    jSONObject.put("client_id", AccountManagerImpl.getInstance(this.mContext).getXDClientId());
                }
                JSONArray jSONArray = new JSONArray();
                if (this.mBduids != null && this.mBduids.size() > 0) {
                    for (Long l : this.mBduids) {
                        long longValue = l.longValue();
                        if (longValue > 0) {
                            jSONArray.put(longValue);
                        }
                    }
                }
                jSONObject.put("bd_uids", jSONArray);
                LogUtils.d(TAG, "body :" + jSONObject.toString());
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        GetUserSliceListener getUserSliceListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048582, this, i, bArr, th) == null) && (getUserSliceListener = this.mListener) != null) {
            getUserSliceListener.onResult(i, "", null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        GetUserSliceListener getUserSliceListener;
        JSONObject jSONObject;
        int optInt;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, bArr) == null) {
            IMGetUserIdentityRequest iMGetUserIdentityRequest = this;
            String str2 = new String(bArr);
            String str3 = TAG;
            LogUtils.d(TAG, "onSuccess content = " + str2);
            ArrayList arrayList = null;
            try {
                jSONObject = new JSONObject(str2);
                optInt = jSONObject.optInt("error_code");
            } catch (JSONException e) {
                e = e;
            }
            if (optInt == 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                try {
                } catch (JSONException e2) {
                    e = e2;
                }
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (i4 < optJSONArray.length()) {
                        try {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                            long optLong = jSONObject2.optLong("bd_uid");
                            long optLong2 = jSONObject2.optLong("uk", 0L);
                            String optString = jSONObject2.optString("avatar");
                            String optString2 = jSONObject2.optString("display_name");
                            jSONObject2.optString("vip");
                            String optString3 = jSONObject2.optString("v_portrait");
                            String optString4 = jSONObject2.optString("identity");
                            JSONArray jSONArray = optJSONArray;
                            int optInt2 = jSONObject2.optInt("relation_follow");
                            int optInt3 = jSONObject2.optInt("relation_phone");
                            int optInt4 = jSONObject2.optInt(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY);
                            String optString5 = jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY);
                            int i5 = optInt;
                            String str4 = str3;
                            ArrayList arrayList3 = arrayList2;
                            int i6 = i4;
                            try {
                                ChatUser chatUser = new ChatUser(optLong2, optLong, optString2, optString);
                                chatUser.setVipId(jSONObject2.optString("vip"));
                                chatUser.setIdentity(optString4);
                                chatUser.setSubscribe(optInt2);
                                chatUser.setPhoneRelation(optInt3);
                                chatUser.setHasSpecialIdentity(optInt4);
                                chatUser.setSpecialIdentity(optString5);
                                chatUser.setVPortrait(optString3);
                                chatUser.setUserExt(jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_USER_EXT, ""));
                                iMGetUserIdentityRequest = this;
                                try {
                                    ChatUser chatUser2 = ChatUserDBManager.getInstance(iMGetUserIdentityRequest.mContext).getChatUser(optLong2);
                                    if (chatUser2 != null) {
                                        chatUser.setMarkTop(chatUser2.getMarkTop());
                                        chatUser.setMarkTopTime(chatUser2.getMarkTopTime());
                                        chatUser.setShield(chatUser2.getShield());
                                        chatUser.setShieldTime(chatUser2.getShieldTime());
                                    }
                                    arrayList3.add(chatUser);
                                    optJSONArray = jSONArray;
                                    arrayList2 = arrayList3;
                                    str3 = str4;
                                    i4 = i6 + 1;
                                    optInt = i5;
                                } catch (JSONException e3) {
                                    e = e3;
                                    arrayList = arrayList3;
                                    str = str4;
                                    LogUtils.e(str, "Exception ", e);
                                    i2 = 1010;
                                    getUserSliceListener = iMGetUserIdentityRequest.mListener;
                                    if (getUserSliceListener != null) {
                                    }
                                }
                            } catch (JSONException e4) {
                                e = e4;
                                iMGetUserIdentityRequest = this;
                            }
                        } catch (JSONException e5) {
                            e = e5;
                            arrayList = arrayList2;
                            str = str3;
                            LogUtils.e(str, "Exception ", e);
                            i2 = 1010;
                            getUserSliceListener = iMGetUserIdentityRequest.mListener;
                            if (getUserSliceListener != null) {
                            }
                        }
                    }
                    arrayList = arrayList2;
                } else {
                    CaseUbc.DebugInfo debugInfo = new CaseUbc.DebugInfo();
                    str = TAG;
                    try {
                        debugInfo.curClassName = str;
                        debugInfo.extInfo = "getUserInfo == null, server msg: " + jSONObject.toString();
                        i3 = optInt;
                        CaseUbc.debugUbc(iMGetUserIdentityRequest.mContext, "get_user_info", i3, "", debugInfo);
                        i2 = i3;
                    } catch (JSONException e6) {
                        e = e6;
                        LogUtils.e(str, "Exception ", e);
                        i2 = 1010;
                        getUserSliceListener = iMGetUserIdentityRequest.mListener;
                        if (getUserSliceListener != null) {
                        }
                    }
                    getUserSliceListener = iMGetUserIdentityRequest.mListener;
                    if (getUserSliceListener != null) {
                        getUserSliceListener.onResult(i2, "", arrayList);
                        return;
                    }
                    return;
                }
            }
            i3 = optInt;
            i2 = i3;
            getUserSliceListener = iMGetUserIdentityRequest.mListener;
            if (getUserSliceListener != null) {
            }
        }
    }
}
