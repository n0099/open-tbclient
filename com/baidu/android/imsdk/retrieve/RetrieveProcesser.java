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
public class RetrieveProcesser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RetrieveProcesser";
    public transient /* synthetic */ FieldHolder $fh;

    public RetrieveProcesser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba A[Catch: all -> 0x0128, TryCatch #1 {, blocks: (B:8:0x000a, B:11:0x0023, B:13:0x0057, B:15:0x005d, B:18:0x0065, B:21:0x0072, B:23:0x0086, B:31:0x00a4, B:39:0x00ba, B:40:0x00df, B:34:0x00ae, B:43:0x00f3), top: B:56:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00df A[Catch: all -> 0x0128, TRY_LEAVE, TryCatch #1 {, blocks: (B:8:0x000a, B:11:0x0023, B:13:0x0057, B:15:0x005d, B:18:0x0065, B:21:0x0072, B:23:0x0086, B:31:0x00a4, B:39:0x00ba, B:40:0x00df, B:34:0x00ae, B:43:0x00f3), top: B:56:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean process(JSONObject jSONObject, Context context) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONObject, context)) == null) {
            synchronized (RetrieveProcesser.class) {
                char c = 0;
                if (jSONObject == null) {
                    LogUtils.d(TAG, "retrieve-->data is null");
                    RetrieveReportImpl.getInstance(context).reportDispatchCheckFail("", "", "", "0", null);
                    return false;
                }
                LogUtils.d(TAG, "retrieve-->data is：" + jSONObject.toString());
                String optString = jSONObject.optString("type");
                String optString2 = jSONObject.optString("jobId");
                String optString3 = jSONObject.optString("version");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    String optString4 = jSONObject.optString("expiredTime");
                    if (!TextUtils.isEmpty(optString4)) {
                        if (System.currentTimeMillis() >= Long.valueOf(optString4).longValue() * 1000) {
                            LogUtils.d(TAG, "retrieve-->任务过期");
                            RetrieveReportImpl.getInstance(context).reportDispatch(optString, optString2, optString3, jSONObject, "1", null);
                            z = false;
                            if (!z) {
                                return false;
                            }
                        } else {
                            z = true;
                            if (!z) {
                            }
                        }
                    }
                    if (optString.hashCode() == 3143036 && optString.equals("file")) {
                        if (c == 0) {
                            LogUtils.d(TAG, "retrieve-->不支持的回捞类型：" + optString);
                            RetrieveReportImpl.getInstance(context).reportDispatch(optString, optString2, optString3, jSONObject, "2", null);
                        } else {
                            RetrieveReportImpl.getInstance(context).reportDispatch(optString, optString2, optString3, jSONObject, "0", new IReportListener(jSONObject, context) { // from class: com.baidu.android.imsdk.retrieve.RetrieveProcesser.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Context val$context;
                                public final /* synthetic */ JSONObject val$data;

                                @Override // com.baidu.android.imsdk.retrieve.IReportListener
                                public void onFailure() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    }
                                }

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {jSONObject, context};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$data = jSONObject;
                                    this.val$context = context;
                                }

                                @Override // com.baidu.android.imsdk.retrieve.IReportListener
                                public void onSuccess(ReportResult reportResult) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reportResult) == null) {
                                        RetrieveFileJob retrieveFileJob = new RetrieveFileJob();
                                        if (reportResult != null && "1".equals(reportResult.getValid())) {
                                            retrieveFileJob.dispatch(this.val$data, this.val$context);
                                        }
                                    }
                                }
                            });
                        }
                        return true;
                    }
                    c = 65535;
                    if (c == 0) {
                    }
                    return true;
                }
                LogUtils.d(TAG, "retrieve-->缺少必要字段，type：" + optString + ", jobId:" + optString2 + ", version:" + optString3);
                RetrieveReportImpl.getInstance(context).reportDispatchCheckFail(optString, optString2, optString3, "1", jSONObject);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
