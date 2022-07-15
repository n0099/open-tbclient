package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class RetrieveTaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_FETCH_LOG_NOTICE = "fetch_log_notice";
    public static final String DATA = "data";
    public static final String KEY = "api";
    public static final String TAG = "RetrieveTaskManager";
    public static volatile RetrieveTaskManager instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public RetrieveTaskManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    public static RetrieveTaskManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (instance == null) {
                synchronized (RetrieveTaskManager.class) {
                    if (instance == null) {
                        instance = new RetrieveTaskManager(context);
                    }
                }
            }
            return instance;
        }
        return (RetrieveTaskManager) invokeL.objValue;
    }

    public void dispatch(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            if (jSONObject == null) {
                LogUtils.d(TAG, "retrieve-->dispatch jsondata is null");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                LogUtils.d(TAG, "retrieve-->dispatch jsondata data value is null");
                return;
            }
            String optString = optJSONObject.optString("api");
            if (!TextUtils.equals(ACTION_FETCH_LOG_NOTICE, optString)) {
                LogUtils.d(TAG, "retrieve-->dispatch jsondata api value not equal fetch_log_notice:" + optString);
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
            if (optJSONObject2 == null) {
                LogUtils.d(TAG, "retrieve-->dispatch jsondata inner data value is null");
            } else {
                RetrieveProcesser.process(optJSONObject2, this.mContext);
            }
        }
    }
}
