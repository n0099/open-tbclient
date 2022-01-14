package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.IGetPaInfoListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class IMPaGetOneInfoRequest extends PaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMPaGetOneInfoRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppid;
    public String mKey;
    public ArrayList<Long> mPaids;
    public long mUk;

    public IMPaGetOneInfoRequest(Context context, String str, ArrayList<Long> arrayList, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, arrayList, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mAppid = j2;
        this.mKey = str;
        this.mUk = j3;
        this.mPaids = arrayList;
    }

    private void onRequestReturn(Integer num, String str, IGetPaInfoListener iGetPaInfoListener) {
        ArrayList<Long> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, this, num, str, iGetPaInfoListener) == null) || (arrayList = this.mPaids) == null || arrayList.size() <= 0) {
            return;
        }
        PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(this.mPaids.get(0).longValue());
        if (iGetPaInfoListener != null) {
            if (queryPaInfo != null) {
                iGetPaInfoListener.onGetPaInfoResult(0, Constants.ERROR_MSG_SUCCESS, queryPaInfo);
            } else {
                iGetPaInfoListener.onGetPaInfoResult(num.intValue(), str, null);
            }
        }
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
                    Iterator<Long> it = this.mPaids.iterator();
                    while (it.hasNext()) {
                        Long next = it.next();
                        if (next.longValue() > 0) {
                            jSONArray.put(next);
                        }
                    }
                }
                jSONObject.put("pa_uids", jSONArray);
                jSONObject.put("is_https", true);
                jSONObject.put("sign", getSignByMd5Error(bduss, currentTimeMillis, this.mAppid, md5));
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("account_type", AccountManagerImpl.getInstance(this.mContext).getLoginType());
                if (AccountManager.isCuidLogin(this.mContext)) {
                    jSONObject.put("token", AccountManager.getToken(this.mContext));
                }
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
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
            onRequestReturn((Integer) transErrorCode.first, (String) transErrorCode.second, (IGetPaInfoListener) ListenerManager.getInstance().removeListener(this.mKey));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i2, byte[] bArr) {
        ArrayList arrayList;
        int i3;
        String str;
        IGetPaInfoListener iGetPaInfoListener;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIL(1048581, this, i2, bArr) != null) {
            return;
        }
        String str2 = new String(bArr);
        PaInfo paInfo = null;
        try {
            jSONObject = new JSONObject(str2);
            i3 = jSONObject.getInt("error_code");
            str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
        } catch (JSONException e2) {
            e = e2;
            arrayList = null;
        }
        if (i3 != 0) {
            LogUtils.e(TAG, "error code :" + i3 + "===errorMsg:" + str);
        } else if (jSONObject.has("response_params")) {
            JSONArray jSONArray = jSONObject.getJSONArray("response_params");
            arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                    if (jSONObject2.optInt("pa_type") != 16) {
                        PaInfo paInfo2 = new PaInfo();
                        paInfo2.setPaId(jSONObject2.optLong("pa_uid"));
                        paInfo2.setNickName(jSONObject2.optString("pa_nickname"));
                        paInfo2.setUsername(jSONObject2.optString("pa_username"));
                        paInfo2.setAvatar(jSONObject2.optString("pa_avatar"));
                        paInfo2.setDescription(jSONObject2.optString("description"));
                        paInfo2.setDetail(jSONObject2.optString("detail_description"));
                        paInfo2.setTPL(jSONObject2.optLong("tpl", -1L));
                        paInfo2.setAcceptPush(jSONObject2.optBoolean("is_accept_msg"));
                        paInfo2.setUrl(jSONObject2.optString("pa_url"));
                        paInfo2.setSubcribeTime(jSONObject2.optLong("create_time"));
                        paInfo2.setDisturb(jSONObject2.optInt("do_not_disturb"));
                        paInfo2.setSubtype(jSONObject2.optInt("pa_type"));
                        paInfo2.setClassType(jSONObject2.optInt("pa_classtype", 0));
                        paInfo2.setClasstitle(jSONObject2.optString("pa_classtitle"));
                        paInfo2.setClassAvatar(jSONObject2.optString("pa_classavatar"));
                        paInfo2.setClassshow(jSONObject2.optInt("pa_classshow", 0));
                        paInfo2.setStatus(jSONObject2.optInt("status", 0));
                        String optString = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, "");
                        paInfo2.setPaExt(optString);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                paInfo2.setSubsetType(new JSONObject(optString).optInt("sub_pa_type", 0));
                            } catch (JSONException e3) {
                                LogUtils.e(LogUtils.TAG, "IMPaGetInfoListRequest JSONException", e3);
                            }
                        }
                        paInfo2.setVipId(jSONObject2.optString("vip"));
                        paInfo2.setVPortrait(jSONObject2.optString("v_portrait", ""));
                        paInfo2.setHasIdentity(jSONObject2.optInt(TableDefine.PaSubscribeColumns.COLUMN_HAS_IDENTITY, 0));
                        paInfo2.setIdentity(jSONObject2.optString("identity", ""));
                        paInfo2.setThirdExt(jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
                        paInfo2.setRejectMenu(jSONObject2.optInt(TableDefine.PaSubscribeColumns.COLUMN_REJECT_MENU, 1));
                        PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(paInfo2.getPaId());
                        if (queryPaInfo != null) {
                            paInfo2.setMarkTop(queryPaInfo.getMarkTop());
                            paInfo2.setMarkTopTime(queryPaInfo.getMarkTopTime());
                            paInfo2.setShield(queryPaInfo.getShield());
                            paInfo2.setShieldTime(queryPaInfo.getShieldTime());
                        }
                        arrayList.add(paInfo2);
                    }
                } catch (JSONException e4) {
                    e = e4;
                    LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", e);
                    i3 = 1010;
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                    iGetPaInfoListener = (IGetPaInfoListener) ListenerManager.getInstance().removeListener(this.mKey);
                    if (iGetPaInfoListener != null) {
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PaInfoDBManager.getInstance(this.mContext).subscribePa((PaInfo) it.next());
            }
            iGetPaInfoListener = (IGetPaInfoListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (iGetPaInfoListener != null) {
                if (arrayList != null && arrayList.size() > 0) {
                    paInfo = (PaInfo) arrayList.get(0);
                }
                if (paInfo != null) {
                    iGetPaInfoListener.onGetPaInfoResult(i3, str, PaInfoDBManager.getInstance(this.mContext).queryPaInfo(paInfo.getPaId()));
                    return;
                } else {
                    onRequestReturn(Integer.valueOf(i3), str, iGetPaInfoListener);
                    return;
                }
            }
            return;
        }
        arrayList = null;
        iGetPaInfoListener = (IGetPaInfoListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iGetPaInfoListener != null) {
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
