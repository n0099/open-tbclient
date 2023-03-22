package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.model.GetGroupCouponResult;
import com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetGroupCouponRequest extends IMSettingBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGetGroupCouponRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public int mApp;
    public int mBizType;
    public final String mCouponBatchId;
    public String mGroupId;
    public final String mKey;
    public String mMsgContent;
    public long mMsgId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1569567526, "Lcom/baidu/android/imsdk/chatmessage/request/IMGetGroupCouponRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1569567526, "Lcom/baidu/android/imsdk/chatmessage/request/IMGetGroupCouponRequest;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "send_coupon" : (String) invokeV.objValue;
    }

    public IMGetGroupCouponRequest(Context context, String str, long j, String str2, String str3, int i, int i2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j), str2, str3, Integer.valueOf(i), Integer.valueOf(i2), str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mCouponBatchId = str3;
        this.mBizType = i;
        this.mApp = i2;
        this.mKey = str4;
        this.mMsgId = j;
        this.mGroupId = str;
        this.mMsgContent = str2;
    }

    private void updateCouponContent(GetGroupCouponResult getGroupCouponResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, getGroupCouponResult) == null) && getGroupCouponResult != null && !TextUtils.isEmpty(this.mMsgContent)) {
            boolean z = true;
            if (getGroupCouponResult.mCouponAction == 1) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mMsgContent);
                    JSONArray optJSONArray = jSONObject.optJSONArray("coupons");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 != null && !TextUtils.isEmpty(this.mCouponBatchId) && this.mCouponBatchId.equals(jSONObject2.optString("coupon_batch_id"))) {
                                jSONObject2.put("status", getGroupCouponResult.mCouponState);
                                jSONObject2.put("coupon_content", getGroupCouponResult.mCouponContent);
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        String jSONObject3 = jSONObject.toString();
                        this.mMsgContent = jSONObject3;
                        GroupMessageDAOImpl.updateMsgContent(this.mContext, this.mGroupId, this.mMsgId, jSONObject3);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", AccountManager.getAppid(this.mContext));
                jSONObject.put("app_version", BIMManager.getAppVersion(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put("uk", AccountManager.getUK(this.mContext));
                jSONObject.put("host_device_type", 1);
                jSONObject.put("coupon_batch_id", this.mCouponBatchId);
                jSONObject.put("biz_type", this.mBizType);
                jSONObject.put("channel", 30);
                jSONObject.put("app", this.mApp);
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
            String str = TAG;
            LogUtils.d(str, "getRequestParameter :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            GetGroupCouponResult getGroupCouponResult = new GetGroupCouponResult();
            getGroupCouponResult.mBatchId = this.mCouponBatchId;
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), "", getGroupCouponResult);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, bArr) == null) {
            String str = "";
            String str2 = new String(bArr);
            String str3 = TAG;
            LogUtils.d(str3, "IMGetCouponRequest onSuccess :" + str2);
            GetGroupCouponResult getGroupCouponResult = new GetGroupCouponResult();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i2 = jSONObject.optInt("error_code");
                String optString = jSONObject.optString("tips");
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                }
                getGroupCouponResult.mCouponTakeId = jSONObject.optString("coupon_take_id");
                getGroupCouponResult.mCouponContent = jSONObject.optString("coupon_content");
                getGroupCouponResult.mCouponState = jSONObject.optInt("coupon_state");
                getGroupCouponResult.mCouponAction = jSONObject.optInt("coupon_action");
                getGroupCouponResult.mBatchId = this.mCouponBatchId;
                updateCouponContent(getGroupCouponResult);
                getGroupCouponResult.mMsgContent = this.mMsgContent;
                str = optString;
            } catch (JSONException unused) {
                i2 = 1010;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i2, str, getGroupCouponResult);
            }
        }
    }
}
