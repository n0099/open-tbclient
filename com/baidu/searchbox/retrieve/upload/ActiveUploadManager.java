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
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
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
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ActiveUploadManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int KEEP_ALIVE_TIME = 60000;
    public static final String TAG = "FetchLogActive";
    public static volatile ActiveUploadManager sSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor mActiveExecutor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1130843658, "Lcom/baidu/searchbox/retrieve/upload/ActiveUploadManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1130843658, "Lcom/baidu/searchbox/retrieve/upload/ActiveUploadManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public ActiveUploadManager() {
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
        this.mActiveExecutor = new ThreadPoolExecutor(1, 1, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static ActiveUploadManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sSingleton == null) {
                synchronized (ActiveUploadManager.class) {
                    if (sSingleton == null) {
                        sSingleton = new ActiveUploadManager();
                    }
                }
            }
            return sSingleton;
        }
        return (ActiveUploadManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statActiveReportData(boolean z, ActiveUpObj activeUpObj) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, this, z, activeUpObj) == null) || activeUpObj == null || (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) == null) {
            return;
        }
        iStatTask.recordActiveUploadData(z, "report", activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
    }

    public void activeUploadReportContent(@NonNull ActiveUpObj activeUpObj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activeUpObj) == null) {
            activeUploadReportContent(activeUpObj, null);
        }
    }

    public void activeUploadReportContent(@NonNull ActiveUpObj activeUpObj, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activeUpObj, iActiveUploadListener) == null) {
            this.mActiveExecutor.execute(new Runnable(this, activeUpObj, iActiveUploadListener) { // from class: com.baidu.searchbox.retrieve.upload.ActiveUploadManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ActiveUploadManager this$0;
                public final /* synthetic */ IActiveUploadListener val$activeListener;
                public final /* synthetic */ ActiveUpObj val$activeObj;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activeUpObj, iActiveUploadListener};
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
                    this.val$activeObj = activeUpObj;
                    this.val$activeListener = iActiveUploadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject createActiveReqContent;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (createActiveReqContent = ContentUtils.createActiveReqContent(this.val$activeObj)) == null) {
                        return;
                    }
                    UploaderProvider.getContentUploader().uploadDataRequestASync("1", createActiveReqContent.toString(), null, new ResponseCallback<JSONObject>(this) { // from class: com.baidu.searchbox.retrieve.upload.ActiveUploadManager.1.1
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
                                if (ActiveUploadManager.DEBUG) {
                                    Log.d(ActiveUploadManager.TAG, "onFail: " + exc.getMessage());
                                }
                                AnonymousClass1 anonymousClass1 = this.this$1;
                                anonymousClass1.this$0.statActiveReportData(false, anonymousClass1.val$activeObj);
                                IActiveUploadListener iActiveUploadListener2 = this.this$1.val$activeListener;
                                if (iActiveUploadListener2 != null) {
                                    iActiveUploadListener2.onFailure(exc.getMessage());
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public void onSuccess(JSONObject jSONObject, int i) {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) || jSONObject == null) {
                                return;
                            }
                            if (TextUtils.equals("0", jSONObject.optString("errno"))) {
                                if (ActiveUploadManager.DEBUG) {
                                    Log.d(ActiveUploadManager.TAG, "active upload success");
                                }
                                AnonymousClass1 anonymousClass1 = this.this$1;
                                anonymousClass1.this$0.statActiveReportData(true, anonymousClass1.val$activeObj);
                                IActiveUploadListener iActiveUploadListener2 = this.this$1.val$activeListener;
                                if (iActiveUploadListener2 != null) {
                                    iActiveUploadListener2.onSuccess();
                                    return;
                                }
                                return;
                            }
                            AnonymousClass1 anonymousClass12 = this.this$1;
                            anonymousClass12.this$0.statActiveReportData(false, anonymousClass12.val$activeObj);
                            IActiveUploadListener iActiveUploadListener3 = this.this$1.val$activeListener;
                            if (iActiveUploadListener3 != null) {
                                iActiveUploadListener3.onFailure(jSONObject.toString());
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
                                if (ActiveUploadManager.DEBUG) {
                                    Log.d(ActiveUploadManager.TAG, "statusCode:" + i + ", response=" + string);
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
