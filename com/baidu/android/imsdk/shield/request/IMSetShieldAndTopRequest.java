package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSetShieldAndTopRequest extends IMSettingBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSetShieldAndTopRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mContacter;
    public int mContacterType;
    public String mKey;
    public int mState;
    public int mSubBusiness;
    public long timeStamp;
    public ChatSession user;

    private int getContacterType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            if (i != 0) {
                return i != 3 ? 1 : 2;
            }
            return 0;
        }
        return invokeI.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "set_user_contacter_setting" : (String) invokeV.objValue;
    }

    public IMSetShieldAndTopRequest(Context context, String str, long j, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
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
        this.mContacter = j;
        this.mSubBusiness = i;
        this.mKey = str;
        this.mContacterType = getContacterType(i2);
        this.mState = i3;
        this.user = new ChatSession();
    }

    private boolean isShieldBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i = this.mSubBusiness;
            if (i == 1 || i == 6 || i == 7 || i == 8 || i == 9) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                long appid = AccountManager.getAppid(this.mContext);
                long uk = AccountManager.getUK(this.mContext);
                this.timeStamp = System.currentTimeMillis() / 1000;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", appid);
                jSONObject.put("uk", uk);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("sub_business", this.mSubBusiness);
                jSONObject.put("contacter", this.mContacter);
                jSONObject.put("contacter_type", this.mContacterType);
                jSONObject.put("timestamp", this.timeStamp);
                jSONObject.put("ability", this.mState);
                jSONObject.put("sign", getMd5("" + this.timeStamp + uk + appid));
                if (AccountManager.isCuidLogin(this.mContext)) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("account_type", i);
                LogUtils.d(TAG, "IMSetShieldAndTopRequest msg :" + jSONObject.toString());
                return jSONObject.toString().getBytes();
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            if (isShieldBusiness()) {
                if (this.mContacterType == 0) {
                    ShieldAndTopManager.getInstance(this.mContext).onUserShieldResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mSubBusiness, this.mKey);
                    return;
                } else {
                    ShieldAndTopManager.getInstance(this.mContext).onPaShieldResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mSubBusiness, this.mKey);
                    return;
                }
            }
            int i2 = this.mSubBusiness;
            if (i2 == 2) {
                int i3 = this.mContacterType;
                if (i3 == 0) {
                    ShieldAndTopManager.getInstance(this.mContext).onUserMarkTopResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
                } else if (i3 == 2) {
                    ShieldAndTopManager.getInstance(this.mContext).onGroupMarkTopResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
                } else {
                    ShieldAndTopManager.getInstance(this.mContext).onPaMarkTopResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
                }
            } else if (i2 == 3) {
                int i4 = this.mContacterType;
                if (i4 == 2) {
                    ShieldAndTopManager.getInstance(this.mContext).onSetGroupNotDisturbResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
                } else if (i4 == 1) {
                    this.user.setCategory(0);
                    ShieldAndTopManager.getInstance(this.mContext).onPaDisturbResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
                } else if (i4 == 0) {
                    this.user.setCategory(0);
                    ShieldAndTopManager.getInstance(this.mContext).onUserDisturbResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
                }
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        IStatusListener iStatusListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.e(TAG, "IMSetShieldAndTopRequest onSuccess :" + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
            } catch (JSONException e) {
                LogUtils.e(TAG, "JSONException", e);
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                i2 = 1010;
            }
            if (i2 == 0) {
                this.user.setContacter(this.mContacter);
                if (isShieldBusiness()) {
                    this.user.setShield(this.mState);
                    this.user.setShieldTime(this.timeStamp);
                } else {
                    int i3 = this.mSubBusiness;
                    if (i3 == 2) {
                        this.user.setMarkTop(this.mState);
                        this.user.setMarkTopTime(this.timeStamp);
                    } else if (i3 == 3) {
                        this.user.setDisturb(this.mState);
                    }
                }
                this.user.setChatType(this.mContacterType);
            }
            if (isShieldBusiness()) {
                if (this.mContacterType == 0) {
                    ShieldAndTopManager.getInstance(this.mContext).onUserShieldResult(i2, str, this.user, this.mSubBusiness, this.mKey);
                    return;
                } else {
                    ShieldAndTopManager.getInstance(this.mContext).onPaShieldResult(i2, str, this.user, this.mSubBusiness, this.mKey);
                    return;
                }
            }
            int i4 = this.mSubBusiness;
            if (i4 == 2) {
                int i5 = this.mContacterType;
                if (i5 == 0) {
                    ShieldAndTopManager.getInstance(this.mContext).onUserMarkTopResult(i2, str, this.user, this.mKey);
                } else if (i5 == 2) {
                    ShieldAndTopManager.getInstance(this.mContext).onGroupMarkTopResult(i2, str, this.user, this.mKey);
                } else {
                    this.user.setMarkTop(this.mState);
                    ShieldAndTopManager.getInstance(this.mContext).onPaMarkTopResult(i2, str, this.user, this.mKey);
                }
            } else if (i4 == 3) {
                int i6 = this.mContacterType;
                if (i6 == 2) {
                    ShieldAndTopManager.getInstance(this.mContext).onSetGroupNotDisturbResult(i2, str, this.user, this.mKey);
                } else if (i6 == 1) {
                    this.user.setCategory(0);
                    ShieldAndTopManager.getInstance(this.mContext).onPaDisturbResult(i2, str, this.user, this.mKey);
                } else if (i6 == 0) {
                    this.user.setCategory(0);
                    ShieldAndTopManager.getInstance(this.mContext).onUserDisturbResult(i2, str, this.user, this.mKey);
                } else {
                    IStatusListener iStatusListener2 = (IStatusListener) ListenerManager.getInstance().removeListener(this.mKey);
                    if (iStatusListener2 != null) {
                        iStatusListener2.onResult(i2, str, this.mState, this.mContacter);
                    }
                }
            } else if ((i4 == 4 || i4 == 5) && (iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(this.mKey)) != null) {
                iStatusListener.onResult(i2, str, this.mState, this.mContacter);
            }
        }
    }
}
