package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
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
public class IMQueryMemberPauidRequest extends FansGroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMQueryMemberPauidRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public String mKey;
    public List<Long> mUids;

    /* loaded from: classes6.dex */
    public static class UserId {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mBduid;
        public long mPauid;
        public long mUk;

        public UserId(long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBduid = 0L;
            this.mPauid = 0L;
            this.mUk = 0L;
            this.mBduid = j;
            this.mPauid = j2;
            this.mUk = j3;
        }

        public long getBduid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBduid : invokeV.longValue;
        }

        public long getPauid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPauid : invokeV.longValue;
        }

        public long getUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mUk : invokeV.longValue;
        }
    }

    public IMQueryMemberPauidRequest(Context context, List<Long> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str};
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
        this.mUids = list;
        this.mKey = str;
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
            StringBuilder sb = new StringBuilder();
            sb.append("method=get_user_ids");
            JSONArray jSONArray = new JSONArray();
            List<Long> list = this.mUids;
            if (list != null && list.size() > 0) {
                for (Long l : this.mUids) {
                    jSONArray.put(Utility.transBDUID(String.valueOf(l.longValue())));
                }
            }
            sb.append("&members=");
            sb.append(jSONArray.toString());
            sb.append(getCommonParams());
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, "json is " + str2);
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i3 = jSONObject.getInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                JSONArray optJSONArray = jSONObject.optJSONObject("response_params").optJSONArray("members");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                        arrayList.add(new UserId(jSONObject2.getLong("bduid"), jSONObject2.getLong("pauid"), jSONObject2.getLong("uk")));
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMQueryMemberPauidRequest JSONException", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                i3 = 1010;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i3, str, arrayList);
            }
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
