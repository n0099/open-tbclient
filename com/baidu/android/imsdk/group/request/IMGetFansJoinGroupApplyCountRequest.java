package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMGroupManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupApplyBean;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
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
public class IMGetFansJoinGroupApplyCountRequest extends FansGroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGetFansJoinGroupApplyCountRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> mGroupIds;
    public String mKey;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
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

    public IMGetFansJoinGroupApplyCountRequest(Context context, List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mGroupIds = list;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("method=group_application_get_counts");
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.mGroupIds;
            if (list != null) {
                for (String str : list) {
                    jSONArray.put(str);
                }
            }
            sb.append("&group_ids=");
            sb.append(jSONArray.toString());
            sb.append(getCommonParams());
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            LogUtils.d(TAG, "onFailure result = " + new String(bArr));
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "onSuccess result = " + str);
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(str);
                i2 = jSONObject.optInt("error_code");
                if (i2 == 0 && jSONObject.has("response_params")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                    if (jSONObject2.has("application_counts")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("application_counts");
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                            long j = jSONObject3.getLong("group_id");
                            int optInt = jSONObject3.optInt("count", -1);
                            if (j > 0 && optInt >= 0) {
                                GroupApplyBean groupApplyBean = new GroupApplyBean();
                                groupApplyBean.groupId = j;
                                int optInt2 = jSONObject3.optInt("state", -1);
                                if (optInt2 == 0) {
                                    groupApplyBean.joinApplyCount = optInt;
                                } else if (optInt2 == 1 || optInt2 == 2 || optInt2 == 3 || optInt2 == 4 || optInt2 == 5) {
                                    groupApplyBean.joinApplyCount = 0;
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(String.valueOf(j));
                                    BIMGroupManager.getFansGroupInfo(this.mContext, arrayList2, true, null);
                                }
                                if (optInt2 >= 0) {
                                    arrayList.add(groupApplyBean);
                                    GroupMessageManagerImpl.getInstance(this.mContext).updateAndNotifyChatSession(j, optInt);
                                }
                            }
                            LogUtils.d(TAG, "applyCount:" + optInt);
                        }
                    }
                }
            } catch (JSONException e) {
                LogUtils.e(TAG, "parse response failed:", e);
                i2 = 1010;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i2, "", arrayList);
            }
        }
    }
}
