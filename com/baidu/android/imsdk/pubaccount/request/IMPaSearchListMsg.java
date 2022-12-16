package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMPaSearchListMsg extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mSearchContent;

    public IMPaSearchListMsg(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
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
        initCommonParameter(context);
        this.mSearchContent = str;
        setNeedReplay(true);
        setType(103);
    }

    public static IMPaSearchListMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent.hasExtra(Constants.EXTRA_PA_SEARCH_CONTENT)) {
                return new IMPaSearchListMsg(context, intent.getStringExtra(Constants.EXTRA_PA_SEARCH_CONTENT));
            }
            return null;
        }
        return (IMPaSearchListMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 103);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("content", this.mSearchContent);
                this.mBody = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "buildBody:", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        ArrayList arrayList;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            ArrayList arrayList2 = null;
            if (i == 0) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("pa_list");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            try {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                PaInfo paInfo = new PaInfo();
                                paInfo.setPaId(jSONObject2.optLong(Constants.EXTRA_PAUID_TYPE));
                                paInfo.setNickName(jSONObject2.optString("pa_nickname"));
                                paInfo.setAvatar(jSONObject2.optString("pa_avatar"));
                                paInfo.setDescription("");
                                paInfo.setUrl(jSONObject2.optString("pa_url"));
                                paInfo.setAcceptPush(true);
                                paInfo.setStatus(jSONObject2.optInt("status"));
                                arrayList.add(paInfo);
                            } catch (Exception e2) {
                                e = e2;
                                LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                                super.handleMessageResult(context, jSONObject, i, str);
                                PaManagerImpl.getInstance(context).onSearchPaListResult(getListenerKey(), i, str, arrayList);
                            }
                        }
                        arrayList2 = arrayList;
                    }
                } catch (Exception e3) {
                    arrayList = null;
                    e = e3;
                }
            }
            arrayList = arrayList2;
            super.handleMessageResult(context, jSONObject, i, str);
            PaManagerImpl.getInstance(context).onSearchPaListResult(getListenerKey(), i, str, arrayList);
        }
    }
}
