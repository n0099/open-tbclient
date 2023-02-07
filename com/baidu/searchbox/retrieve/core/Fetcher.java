package com.baidu.searchbox.retrieve.core;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.upload.FetchResult;
import com.baidu.searchbox.retrieve.upload.FetchTaskObj;
import com.baidu.searchbox.retrieve.upload.FetchUploadManager;
import com.baidu.searchbox.retrieve.upload.IUploadListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Fetcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "Fetcher";
    public static final String UPLOAD_RESULT_VALID = "1";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(263091115, "Lcom/baidu/searchbox/retrieve/core/Fetcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(263091115, "Lcom/baidu/searchbox/retrieve/core/Fetcher;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public Fetcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void dispatch(List<IFetchJob> list, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, jSONObject, str) == null) && list != null && list.size() != 0) {
            if (DEBUG) {
                Log.d(TAG, "开始分发回捞命令 ");
            }
            boolean z = false;
            for (IFetchJob iFetchJob : list) {
                if (TextUtils.equals(str, iFetchJob.getFetchJobType())) {
                    iFetchJob.dispatch(jSONObject);
                    z = true;
                }
            }
            if (!z) {
                FetchReport.reportDispatch(str, "", "", jSONObject, "2");
                if (DEBUG) {
                    Log.e(TAG, "本地没有注册的type类型 ");
                }
                statDispatchDataFail(str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean process(JSONObject jSONObject) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            synchronized (Fetcher.class) {
                if (jSONObject == null) {
                    FetchReport.reportDataNull();
                    statCheckData(true, false, "", "", "", "1");
                    return false;
                }
                if (DEBUG) {
                    Log.d(TAG, "收到回捞命令 " + jSONObject.toString());
                }
                String optString = jSONObject.optString("type");
                String optString2 = jSONObject.optString("jobId");
                String optString3 = jSONObject.optString("version");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    String optString4 = jSONObject.optString("expiredTime");
                    if (!TextUtils.isEmpty(optString4)) {
                        if (System.currentTimeMillis() >= Long.parseLong(optString4) * 1000) {
                            FetchReport.reportDispatch(optString, optString2, optString3, jSONObject, "1");
                            if (DEBUG) {
                                Log.w(TAG, "回捞命令已过期 ");
                            }
                            z = false;
                            if (!z) {
                                statCheckData(true, false, optString2, optString, optString3, "3");
                                return false;
                            }
                        } else {
                            z = true;
                            if (!z) {
                            }
                        }
                    }
                    statCheckData(true, true, optString2, optString, optString3, "");
                    FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(optString, "1", optString2, optString3, "0", "", ""), new IUploadListener(optString2, optString, optString3, jSONObject) { // from class: com.baidu.searchbox.retrieve.core.Fetcher.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ JSONObject val$data;
                        public final /* synthetic */ String val$jobId;
                        public final /* synthetic */ String val$type;
                        public final /* synthetic */ String val$version;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {optString2, optString, optString3, jSONObject};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$jobId = optString2;
                            this.val$type = optString;
                            this.val$version = optString3;
                            this.val$data = jSONObject;
                        }

                        @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                        public void onFailure() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Fetcher.statCheckData(false, false, this.val$jobId, this.val$type, this.val$version, "");
                            }
                        }

                        @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                        public void onSuccess(FetchResult fetchResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fetchResult) == null) {
                                if (fetchResult == null || !TextUtils.equals("1", fetchResult.getValid())) {
                                    Fetcher.statCheckData(false, false, this.val$jobId, this.val$type, this.val$version, "");
                                    return;
                                }
                                Fetcher.statCheckData(false, true, this.val$jobId, this.val$type, this.val$version, "");
                                Fetcher.dispatch(FetchActions.getInstance().getFetchCommandList(), this.val$data, this.val$type);
                            }
                        }
                    });
                    return true;
                }
                FetchReport.reportDataError(optString, optString2, optString3, jSONObject);
                if (DEBUG) {
                    Log.w(TAG, "回捞命令校验错误 " + jSONObject.toString());
                }
                statCheckData(true, false, optString2, optString, optString3, "2");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean processTimerJob(JSONObject jSONObject) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            synchronized (Fetcher.class) {
                if (DEBUG) {
                    Log.d(TAG, "冷启后继续执行定时上传任务 ：" + jSONObject.toString());
                }
                String optString = jSONObject.optString("type");
                String optString2 = jSONObject.optString("jobId");
                String optString3 = jSONObject.optString("version");
                String optString4 = jSONObject.optString("expiredTime");
                if (!TextUtils.isEmpty(optString4)) {
                    if (System.currentTimeMillis() >= Long.parseLong(optString4) * 1000) {
                        FetchReport.reportDispatch(optString, optString2, optString3, jSONObject, "1");
                        if (DEBUG) {
                            Log.w(TAG, "定时上传任务命令已过期 : " + optString2);
                        }
                        z = false;
                        if (!z) {
                            statCheckData(true, false, optString2, optString, optString3, "3");
                            return false;
                        }
                    } else {
                        z = true;
                        if (!z) {
                        }
                    }
                }
                dispatch(FetchActions.getInstance().getFetchCommandList(), jSONObject, optString);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static void statCheckData(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4}) == null) && (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) != null) {
            iStatTask.recordCheckRetrieveData(z, z2, str, str2, str3, str4);
        }
    }

    public static void statDispatchDataFail(String str) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) != null) {
            iStatTask.recordDispatchRetrieveData(false, "", str, "", "1");
        }
    }
}
