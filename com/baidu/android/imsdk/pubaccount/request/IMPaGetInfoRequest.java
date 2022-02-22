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
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
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
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class IMPaGetInfoRequest extends PaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMPaGetInfoRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppid;
    public String mKey;
    public long mUk;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1080395613, "Lcom/baidu/android/imsdk/pubaccount/request/IMPaGetInfoRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1080395613, "Lcom/baidu/android/imsdk/pubaccount/request/IMPaGetInfoRequest;");
        }
    }

    public IMPaGetInfoRequest(Context context, String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j2), Long.valueOf(j3)};
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
        this.mAppid = j2;
        this.mKey = str;
        this.mUk = j3;
    }

    private void localSyncSubscribedPaList(Context context, List<PaInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, context, list) == null) || list == null) {
            return;
        }
        if (list.size() == 0) {
            PaInfoDBManager.getInstance(context).deleteAllSubscribedPa();
            return;
        }
        List<PaInfo> querySubscribedPaList = PaInfoDBManager.getInstance(context).querySubscribedPaList();
        ArrayList arrayList = new ArrayList();
        for (PaInfo paInfo : list) {
            boolean z = false;
            if (querySubscribedPaList != null) {
                Iterator<PaInfo> it = querySubscribedPaList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PaInfo next = it.next();
                    if (paInfo.getPaId() == next.getPaId()) {
                        querySubscribedPaList.remove(next);
                        PaInfoDBManager.getInstance(context).acceptPaPush(paInfo.getPaId(), paInfo.isAcceptPush());
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                arrayList.add(paInfo);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            PaInfo paInfo2 = (PaInfo) it2.next();
            String str = TAG;
            LogUtils.d(str, "FXF  add to db " + paInfo2.toString());
            PaInfoDBManager.getInstance(context).subscribePa(paInfo2);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("method=pa_detail_list");
            sb.append("&appid=");
            sb.append(this.mAppid);
            sb.append("&timestamp=");
            sb.append(currentTimeMillis);
            sb.append("&uk=");
            sb.append(this.mUk);
            sb.append("&sdk_version=");
            sb.append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            sb.append("&sign=");
            sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
            sb.append("&is_https=");
            sb.append(true);
            sb.append("&account_type=");
            sb.append(AccountManagerImpl.getInstance(this.mContext).getLoginType());
            if (AccountManager.isCuidLogin(this.mContext)) {
                sb.append("&token");
                sb.append(AccountManager.getToken(this.mContext));
            }
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            String str3 = TAG;
            LogUtils.d(str3, "FXF  json is " + str2);
            ArrayList arrayList = null;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i3 = jSONObject.getInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                if (i3 == 0) {
                    if (jSONObject.has("response_params")) {
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
                                    paInfo.setSubtype(jSONObject2.optInt("pa_type"));
                                    paInfo.setClassType(jSONObject2.optInt("pa_classtype", 0));
                                    paInfo.setClasstitle(jSONObject2.optString("pa_classtitle"));
                                    paInfo.setClassAvatar(jSONObject2.optString("pa_classavatar"));
                                    paInfo.setClassshow(jSONObject2.optInt("pa_classshow", 0));
                                    paInfo.setStatus(jSONObject2.optInt("status", 0));
                                    paInfo.setMarkTopTime(jSONObject2.optLong("upmark_time"));
                                    paInfo.setMarkTop(jSONObject2.optInt("is_upmark", 0));
                                    String optString = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, "");
                                    paInfo.setPaExt(optString);
                                    if (!TextUtils.isEmpty(optString)) {
                                        try {
                                            paInfo.setSubsetType(new JSONObject(optString).optInt("sub_pa_type", 0));
                                        } catch (JSONException e2) {
                                            LogUtils.e(LogUtils.TAG, "IMPaGetInfoListRequest JSONException", e2);
                                        }
                                    }
                                    arrayList2.add(paInfo);
                                }
                            } catch (JSONException e3) {
                                e = e3;
                                arrayList = arrayList2;
                                LogUtils.e(LogUtils.TAG, "IMGetZhidaInfoRequest JSONException", e);
                                i3 = 1010;
                                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                                PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, i3, str, arrayList);
                            }
                        }
                        localSyncSubscribedPaList(this.mContext, arrayList2);
                        arrayList = arrayList2;
                    }
                } else {
                    str = "query from local db";
                    arrayList = PaInfoDBManager.getInstance(this.mContext).querySubscribedPaList();
                }
            } catch (JSONException e4) {
                e = e4;
            }
            PaManagerImpl.getInstance(this.mContext).onQueryScribedPaListResult(this.mKey, i3, str, arrayList);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
