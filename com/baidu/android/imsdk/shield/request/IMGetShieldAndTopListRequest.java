package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.shield.IGetDisturbListListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
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
/* loaded from: classes6.dex */
public class IMGetShieldAndTopListRequest extends IMSettingBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGetShieldAndTopListRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public int mFilterType;
    public String mKey;
    public int mSubBusiness;

    public IMGetShieldAndTopListRequest(Context context, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mKey = str;
        this.mSubBusiness = i2;
        this.mFilterType = i3;
    }

    private void generateUser(List<ChatSession> list, JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65537, this, list, jSONObject, i2, i3) == null) {
            ChatSession chatSession = new ChatSession();
            chatSession.setContacter(jSONObject.optLong("uk", -1L));
            long optLong = jSONObject.optLong("timestamp", -1L);
            int i4 = this.mSubBusiness;
            if (i4 == 2) {
                chatSession.setMarkTopTime(optLong);
                chatSession.setMarkTop(1);
            } else if (i4 == 1) {
                chatSession.setShieldTime(optLong);
                chatSession.setShield(1);
            } else if (i4 == 3) {
                LogUtils.d(TAG, "generateUser mSubBusiness = 3");
            }
            chatSession.setChatType(i2);
            list.add(chatSession);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "get_subbusiness_contacter_list" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                long appid = AccountManager.getAppid(this.mContext);
                long uk = AccountManager.getUK(this.mContext);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", appid);
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("device_type", 2);
                jSONObject.put("uk", uk);
                jSONObject.put("sub_business", this.mSubBusiness);
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put("business_filter", this.mFilterType);
                jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
                StringBuilder sb = new StringBuilder();
                sb.append("IMGetShieldAndTopListRequest msg :");
                sb.append(jSONObject.toString());
                LogUtils.d(TAG, sb.toString());
                return jSONObject.toString().getBytes();
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            LogUtils.d(TAG, "IMGetShieldAndTopListRequest onFailure :" + transErrorCode.first);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i3 = this.mSubBusiness;
            if (i3 == 1) {
                int i4 = this.mFilterType;
                if (i4 == 1 || i4 == 0) {
                    ShieldAndTopManager.getInstance(this.mContext).onMsgShieldListResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, arrayList, arrayList2, this.mKey);
                } else if (i4 == 2) {
                    ShieldAndTopManager.getInstance(this.mContext).onNotifyShieldListResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, arrayList2, this.mKey);
                }
            } else if (i3 == 2) {
                if (this.mFilterType == 1) {
                    ShieldAndTopManager.getInstance(this.mContext).onMsgMarkTopListResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, arrayList, arrayList2, arrayList3);
                }
            } else if (i3 == 3 && this.mFilterType == 1 && !TextUtils.isEmpty(this.mKey)) {
                ((IGetDisturbListListener) ListenerManager.getInstance().removeListener(this.mKey)).onDisturbList(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, bArr == null ? null : new String(bArr));
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, "IMGetShieldAndTopListRequest onSuccess :" + str2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                int i4 = jSONObject.getInt("error_code");
                String optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                JSONArray optJSONArray = jSONObject.optJSONArray("uks");
                if (optJSONArray != null) {
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        generateUser(arrayList, (JSONObject) optJSONArray.opt(i5), 0, i5);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("pa_uids");
                if (optJSONArray2 != null) {
                    for (int i6 = 0; i6 < optJSONArray2.length(); i6++) {
                        generateUser(arrayList2, (JSONObject) optJSONArray2.opt(i6), 1, i6);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("group_ids");
                if (optJSONArray3 != null) {
                    for (int i7 = 0; i7 < optJSONArray3.length(); i7++) {
                        generateUser(arrayList3, (JSONObject) optJSONArray3.opt(i7), 2, i7);
                    }
                }
                i3 = i4;
                str = optString;
            } catch (JSONException e2) {
                LogUtils.e(TAG, "JSONException", e2);
                i3 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            LogUtils.e(TAG, "mSubBusiness :" + this.mSubBusiness + ", user :" + arrayList.size() + ", Pa :" + arrayList2.size() + ", mFilterType :" + this.mFilterType);
            int i8 = this.mSubBusiness;
            if (i8 == 1) {
                int i9 = this.mFilterType;
                if (i9 == 1 || i9 == 0) {
                    ShieldAndTopManager.getInstance(this.mContext).onMsgShieldListResult(i3, str, arrayList, arrayList2, this.mKey);
                } else if (i9 == 2) {
                    ShieldAndTopManager.getInstance(this.mContext).onNotifyShieldListResult(i3, str, arrayList2, this.mKey);
                }
            } else if (i8 == 2) {
                if (this.mFilterType == 1) {
                    ShieldAndTopManager.getInstance(this.mContext).onMsgMarkTopListResult(i3, str, arrayList, arrayList2, arrayList3);
                }
            } else if (i8 == 3 && this.mFilterType == 1 && !TextUtils.isEmpty(this.mKey)) {
                ((IGetDisturbListListener) ListenerManager.getInstance().removeListener(this.mKey)).onDisturbList(i2, str, str2);
            }
        }
    }
}
