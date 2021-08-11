package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMGetUserIdentityRequest extends IMUserBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGetUserIdentityRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public List<Long> mBduids;
    public IGetUserIdentityListener mListener;

    public IMGetUserIdentityRequest(Context context, List<Long> list, IGetUserIdentityListener iGetUserIdentityListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, iGetUserIdentityListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.mBduids = arrayList;
        arrayList.addAll(list);
        this.mContext = context;
        this.mListener = iGetUserIdentityListener;
    }

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
                jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("appid", AccountManager.getAppid(this.mContext));
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put("sign", md5);
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
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        IGetUserIdentityListener iGetUserIdentityListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048582, this, i2, bArr, th) == null) || (iGetUserIdentityListener = this.mListener) == null) {
            return;
        }
        iGetUserIdentityListener.onGetUserIdentityResult(i2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        int i3;
        IGetUserIdentityListener iGetUserIdentityListener;
        JSONObject jSONObject;
        int optInt;
        JSONArray optJSONArray;
        int i4;
        ArrayList arrayList;
        int i5;
        JSONObject jSONObject2;
        long optLong;
        long optLong2;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        int optInt2;
        JSONArray jSONArray;
        ChatUser chatUser;
        int i6;
        ArrayList arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIL(1048583, this, i2, bArr) != null) {
            return;
        }
        IMGetUserIdentityRequest iMGetUserIdentityRequest = this;
        String str2 = new String(bArr);
        String str3 = TAG;
        LogUtils.d(TAG, "onSuccess content = " + str2);
        int i7 = 0;
        ArrayList arrayList3 = null;
        try {
            jSONObject = new JSONObject(str2);
            optInt = jSONObject.optInt("error_code");
        } catch (JSONException e2) {
            e = e2;
            str = TAG;
        }
        if (optInt == 0) {
            try {
                optJSONArray = jSONObject.optJSONArray("user_list");
            } catch (JSONException e3) {
                e = e3;
                str = TAG;
                i7 = optInt;
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList4 = new ArrayList();
                while (i7 < optJSONArray.length()) {
                    try {
                        jSONObject2 = optJSONArray.getJSONObject(i7);
                        optLong = jSONObject2.optLong("bd_uid");
                        optLong2 = jSONObject2.optLong("uk", 0L);
                        optString = jSONObject2.optString("avatar");
                        optString2 = jSONObject2.optString("display_name");
                        jSONObject2.optString("vip");
                        optString3 = jSONObject2.optString("v_portrait");
                        optString4 = jSONObject2.optString("identity");
                        optInt2 = jSONObject2.optInt("relation_follow");
                        i4 = optInt;
                    } catch (JSONException e4) {
                        e = e4;
                        i4 = optInt;
                    }
                    try {
                        int optInt3 = jSONObject2.optInt("relation_phone");
                        jSONArray = optJSONArray;
                        int optInt4 = jSONObject2.optInt(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY);
                        String optString5 = jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY);
                        str = str3;
                        try {
                            i6 = i7;
                            arrayList2 = arrayList4;
                            try {
                                chatUser = new ChatUser(optLong2, optLong, optString2, optString);
                                chatUser.setVipId(jSONObject2.optString("vip"));
                                chatUser.setIdentity(optString4);
                                chatUser.setSubscribe(optInt2);
                                chatUser.setPhoneRelation(optInt3);
                                chatUser.setHasSpecialIdentity(optInt4);
                                chatUser.setSpecialIdentity(optString5);
                                chatUser.setVPortrait(optString3);
                                chatUser.setUserExt(jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_USER_EXT, ""));
                                iMGetUserIdentityRequest = this;
                            } catch (JSONException e5) {
                                e = e5;
                                iMGetUserIdentityRequest = this;
                            }
                        } catch (JSONException e6) {
                            e = e6;
                            arrayList = arrayList4;
                            i7 = i4;
                            arrayList3 = arrayList;
                            LogUtils.e(str, "Exception ", e);
                            i3 = i7;
                            iGetUserIdentityListener = iMGetUserIdentityRequest.mListener;
                            if (iGetUserIdentityListener != null) {
                            }
                        }
                    } catch (JSONException e7) {
                        e = e7;
                        str = str3;
                        arrayList = arrayList4;
                        i7 = i4;
                        arrayList3 = arrayList;
                        LogUtils.e(str, "Exception ", e);
                        i3 = i7;
                        iGetUserIdentityListener = iMGetUserIdentityRequest.mListener;
                        if (iGetUserIdentityListener != null) {
                        }
                    }
                    try {
                        ChatUser chatUser2 = ChatUserDBManager.getInstance(iMGetUserIdentityRequest.mContext).getChatUser(optLong2);
                        if (chatUser2 != null) {
                            try {
                                chatUser.setMarkTop(chatUser2.getMarkTop());
                                chatUser.setMarkTopTime(chatUser2.getMarkTopTime());
                                chatUser.setShield(chatUser2.getShield());
                                chatUser.setShieldTime(chatUser2.getShieldTime());
                            } catch (JSONException e8) {
                                e = e8;
                                i7 = i4;
                                arrayList3 = arrayList2;
                                LogUtils.e(str, "Exception ", e);
                                i3 = i7;
                                iGetUserIdentityListener = iMGetUserIdentityRequest.mListener;
                                if (iGetUserIdentityListener != null) {
                                }
                            }
                        }
                        arrayList = arrayList2;
                        try {
                            arrayList.add(chatUser);
                            i7 = i6 + 1;
                            optJSONArray = jSONArray;
                            arrayList4 = arrayList;
                            str3 = str;
                            optInt = i4;
                        } catch (JSONException e9) {
                            e = e9;
                            i7 = i4;
                            arrayList3 = arrayList;
                            LogUtils.e(str, "Exception ", e);
                            i3 = i7;
                            iGetUserIdentityListener = iMGetUserIdentityRequest.mListener;
                            if (iGetUserIdentityListener != null) {
                            }
                        }
                    } catch (JSONException e10) {
                        e = e10;
                        arrayList = arrayList2;
                        i7 = i4;
                        arrayList3 = arrayList;
                        LogUtils.e(str, "Exception ", e);
                        i3 = i7;
                        iGetUserIdentityListener = iMGetUserIdentityRequest.mListener;
                        if (iGetUserIdentityListener != null) {
                        }
                    }
                }
                i5 = optInt;
                arrayList3 = arrayList4;
                i3 = i5;
                iGetUserIdentityListener = iMGetUserIdentityRequest.mListener;
                if (iGetUserIdentityListener != null) {
                    iGetUserIdentityListener.onGetUserIdentityResult(i3, arrayList3);
                    return;
                }
                return;
            }
        }
        i5 = optInt;
        i3 = i5;
        iGetUserIdentityListener = iMGetUserIdentityRequest.mListener;
        if (iGetUserIdentityListener != null) {
        }
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
}
