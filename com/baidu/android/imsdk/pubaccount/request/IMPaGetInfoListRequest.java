package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.pubaccount.GetPaInfoSliceListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMPaGetInfoListRequest extends PaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMPaGetInfoListRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppid;
    public List<Long> mPaids;
    public long mUk;
    public GetPaInfoSliceListener sliceListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-465327135, "Lcom/baidu/android/imsdk/pubaccount/request/IMPaGetInfoListRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-465327135, "Lcom/baidu/android/imsdk/pubaccount/request/IMPaGetInfoListRequest;");
        }
    }

    public IMPaGetInfoListRequest(Context context, List<Long> list, long j, long j2, GetPaInfoSliceListener getPaInfoSliceListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Long.valueOf(j), Long.valueOf(j2), getPaInfoSliceListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mAppid = j;
        this.mUk = j2;
        this.mPaids = list;
        this.sliceListener = getPaInfoSliceListener;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/3.0/im/box?method=all_pa_detail_list";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String md5 = getMd5("" + currentTimeMillis + bduss + this.mAppid);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("timestamp", currentTimeMillis);
                JSONArray jSONArray = new JSONArray();
                if (this.mPaids != null) {
                    for (Long l : this.mPaids) {
                        if (l.longValue() > 0) {
                            jSONArray.put(l);
                        }
                    }
                }
                jSONObject.put("pa_uids", jSONArray);
                jSONObject.put("is_https", true);
                jSONObject.put("sign", getSignByMd5Error(bduss, currentTimeMillis, this.mAppid, md5));
                jSONObject.put("account_type", AccountManagerImpl.getInstance(this.mContext).getLoginType());
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("device_type", 2);
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                if (AccountManager.isCuidLogin(this.mContext)) {
                    jSONObject.put("token", AccountManager.getToken(this.mContext));
                }
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            GetPaInfoSliceListener getPaInfoSliceListener = this.sliceListener;
            if (getPaInfoSliceListener != null) {
                getPaInfoSliceListener.onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        int i3;
        GetPaInfoSliceListener getPaInfoSliceListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            String str3 = TAG;
            LogUtils.d(str3, "FXF  json is " + str2);
            ArrayList arrayList = null;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i3 = jSONObject.getInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                if (i3 == 0 && jSONObject.has("response_params")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("response_params");
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                            if (jSONObject2.optInt("pa_type") != 16) {
                                PaInfo paInfo = new PaInfo();
                                paInfo.setPaId(jSONObject2.optLong("pa_uid"));
                                paInfo.setNickName(jSONObject2.optString("pa_nickname"));
                                paInfo.setUsername(jSONObject2.optString("pa_username"));
                                paInfo.setAvatar(jSONObject2.optString("pa_avatar"));
                                paInfo.setDescription(jSONObject2.optString("description"));
                                paInfo.setDetail(jSONObject2.optString("detail_description"));
                                paInfo.setTPL(jSONObject2.optLong("tpl", -1L));
                                paInfo.setAcceptPush(jSONObject2.optBoolean("is_accept_msg"));
                                paInfo.setUrl(jSONObject2.optString("pa_url"));
                                paInfo.setSubcribeTime(jSONObject2.optLong("create_time"));
                                paInfo.setDisturb(jSONObject2.optInt("do_not_disturb"));
                                paInfo.setSubtype(jSONObject2.optInt("pa_type"));
                                paInfo.setClassType(jSONObject2.optInt("pa_classtype", 0));
                                paInfo.setClasstitle(jSONObject2.optString("pa_classtitle"));
                                paInfo.setClassAvatar(jSONObject2.optString("pa_classavatar"));
                                paInfo.setClassshow(jSONObject2.optInt("pa_classshow", 0));
                                paInfo.setStatus(jSONObject2.optInt("status", 0));
                                String optString = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, "");
                                paInfo.setPaExt(optString);
                                if (!TextUtils.isEmpty(optString)) {
                                    try {
                                        paInfo.setSubsetType(new JSONObject(optString).optInt("sub_pa_type", 0));
                                    } catch (JSONException e2) {
                                        LogUtils.e(LogUtils.TAG, "IMPaGetInfoListRequest JSONException", e2);
                                    }
                                }
                                paInfo.setVipId(jSONObject2.optString("vip"));
                                paInfo.setVPortrait(jSONObject2.optString("v_portrait", ""));
                                paInfo.setHasIdentity(jSONObject2.optInt(TableDefine.PaSubscribeColumns.COLUMN_HAS_IDENTITY, 0));
                                paInfo.setIdentity(jSONObject2.optString("identity", ""));
                                paInfo.setThirdExt(jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
                                paInfo.setRejectMenu(jSONObject2.optInt(TableDefine.PaSubscribeColumns.COLUMN_REJECT_MENU, 1));
                                PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(paInfo.getPaId());
                                if (queryPaInfo != null) {
                                    paInfo.setMarkTop(queryPaInfo.getMarkTop());
                                    paInfo.setMarkTopTime(queryPaInfo.getMarkTopTime());
                                    paInfo.setShield(queryPaInfo.getShield());
                                    paInfo.setShieldTime(queryPaInfo.getShieldTime());
                                }
                                arrayList2.add(paInfo);
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            arrayList = arrayList2;
                            LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", e);
                            i3 = 1010;
                            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            getPaInfoSliceListener = this.sliceListener;
                            if (getPaInfoSliceListener == null) {
                            }
                        }
                    }
                    arrayList = arrayList2;
                }
            } catch (JSONException e4) {
                e = e4;
            }
            getPaInfoSliceListener = this.sliceListener;
            if (getPaInfoSliceListener == null) {
                getPaInfoSliceListener.onResult(i3, str, arrayList);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
