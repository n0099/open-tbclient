package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FetchUploadManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int KEEP_ALIVE_TIME = 60000;
    public static final String TAG = "FetchUploadManager";
    public static volatile FetchUploadManager sSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor mContentExecutor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(395229172, "Lcom/baidu/searchbox/retrieve/upload/FetchUploadManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(395229172, "Lcom/baidu/searchbox/retrieve/upload/FetchUploadManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchUploadManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContentExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static FetchUploadManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sSingleton == null) {
                synchronized (FetchUploadManager.class) {
                    if (sSingleton == null) {
                        sSingleton = new FetchUploadManager();
                    }
                }
            }
            return sSingleton;
        }
        return (FetchUploadManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statFetchReportData(boolean z, FetchTaskObj fetchTaskObj) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, this, z, fetchTaskObj) == null) && fetchTaskObj != null && TextUtils.equals("0", fetchTaskObj.getStatus()) && TextUtils.equals("4", fetchTaskObj.getValue())) {
            try {
                jSONObject = new JSONObject(fetchTaskObj.getFileMeta());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                jSONObject = null;
            }
            IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
            if (iStatTask != null) {
                iStatTask.recordUploadRetrieveData("report", z, fetchTaskObj.getJobID(), fetchTaskObj.getType(), fetchTaskObj.getVersion(), "", fetchTaskObj.getFileID(), jSONObject);
            }
        }
    }

    public void uploadReportContent(@NonNull FetchTaskObj fetchTaskObj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fetchTaskObj) == null) {
            uploadReportContent(fetchTaskObj, null);
        }
    }

    public void uploadReportContent(@NonNull FetchTaskObj fetchTaskObj, IUploadListener iUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fetchTaskObj, iUploadListener) == null) {
            this.mContentExecutor.execute(new Runnable(this, fetchTaskObj, iUploadListener) { // from class: com.baidu.searchbox.retrieve.upload.FetchUploadManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FetchUploadManager this$0;
                public final /* synthetic */ FetchTaskObj val$taskObj;
                public final /* synthetic */ IUploadListener val$uploadListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, fetchTaskObj, iUploadListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$taskObj = fetchTaskObj;
                    this.val$uploadListener = iUploadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject createFetchReqContent;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (createFetchReqContent = ContentUtils.createFetchReqContent(this.val$taskObj)) == null) {
                        return;
                    }
                    UploaderProvider.getContentUploader().uploadDataRequestASync("0", createFetchReqContent.toString(), null, new ResponseCallback<JSONObject>(this) { // from class: com.baidu.searchbox.retrieve.upload.FetchUploadManager.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public void onFail(Exception exc) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, exc) == null) {
                                if (FetchUploadManager.DEBUG) {
                                    Log.d(FetchUploadManager.TAG, "onFail: " + exc.getMessage());
                                }
                                AnonymousClass1 anonymousClass1 = this.this$1;
                                anonymousClass1.this$0.statFetchReportData(false, anonymousClass1.val$taskObj);
                                IUploadListener iUploadListener2 = this.this$1.val$uploadListener;
                                if (iUploadListener2 != null) {
                                    iUploadListener2.onFailure();
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public void onSuccess(JSONObject jSONObject, int i) {
                            IUploadListener iUploadListener2;
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) || jSONObject == null) {
                                return;
                            }
                            if (TextUtils.equals("0", jSONObject.optString("errno"))) {
                                FetchResult createResult = ContentUtils.createResult(jSONObject.optJSONObject("data"));
                                AnonymousClass1 anonymousClass1 = this.this$1;
                                anonymousClass1.this$0.statFetchReportData(true, anonymousClass1.val$taskObj);
                                if (createResult == null || (iUploadListener2 = this.this$1.val$uploadListener) == null) {
                                    return;
                                }
                                iUploadListener2.onSuccess(createResult);
                                return;
                            }
                            AnonymousClass1 anonymousClass12 = this.this$1;
                            anonymousClass12.this$0.statFetchReportData(false, anonymousClass12.val$taskObj);
                            IUploadListener iUploadListener3 = this.this$1.val$uploadListener;
                            if (iUploadListener3 != null) {
                                iUploadListener3.onFailure();
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public JSONObject parseResponse(Response response, int i) throws Exception {
                            InterceptResult invokeLI;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || (invokeLI = interceptable3.invokeLI(1048580, this, response, i)) == null) {
                                if (response == null || response.body() == null) {
                                    return null;
                                }
                                String string = response.body().string();
                                if (FetchUploadManager.DEBUG) {
                                    Log.d(FetchUploadManager.TAG, "statusCode:" + i + ", response=" + string);
                                }
                                if (TextUtils.isEmpty(string)) {
                                    return null;
                                }
                                return new JSONObject(string);
                            }
                            return (JSONObject) invokeLI.objValue;
                        }
                    });
                }
            });
        }
    }
}
