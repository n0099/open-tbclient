package com.baidu.searchbox.retrieve.connect;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.core.Fetcher;
import com.baidu.searchbox.retrieve.file.util.Constants;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.log.FetchLogJob;
import com.baidu.searchbox.retrieve.timer.FetchTimerJob;
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
public class FetchConnManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_FETCH_LOG_NOTICE = "fetch_log_notice";
    public static final String DATA = "data";
    public static final boolean DEBUG;
    public static final String KEY = "api";
    public static final int RETRY_COUNT = 3;
    public static final long RETRY_DELAY = 30000;
    public static volatile FetchConnManager sSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Handler mMainHandler;

    @Deprecated
    public void registerFetchReceiveListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(689012662, "Lcom/baidu/searchbox/retrieve/connect/FetchConnManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(689012662, "Lcom/baidu/searchbox/retrieve/connect/FetchConnManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.mMainHandler.postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.retrieve.connect.FetchConnManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FetchConnManager this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.checkRetryFetch();
                    }
                }, 30000L);
            }
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.mMainHandler.removeCallbacksAndMessages(null);
                this.mMainHandler = null;
                sSingleton = null;
            }
        }
    }

    public FetchConnManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context != null) {
            this.mContext = context.getApplicationContext();
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    private void statReceiveData(boolean z) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65541, this, z) == null) && (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) != null) {
            iStatTask.recordReceiveRetrieveData(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRetryFetch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            String originData = FetchTaskManager.getInstance().getOriginData();
            int retryCount = FetchTaskManager.getInstance().getRetryCount();
            if (DEBUG) {
                Log.i(FetchLogJob.TAG, "FetchLogJob retry originData " + originData);
                Log.i(FetchLogJob.TAG, "FetchLogJob retry retryCount " + retryCount);
            }
            if (!TextUtils.isEmpty(originData) && retryCount <= 3) {
                FetchTaskManager.getInstance().saveRetryCount(retryCount + 1);
                try {
                    Fetcher.process(new JSONObject(originData));
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            List<JSONObject> allOriginTimerData = FetchTaskManager.getInstance().getAllOriginTimerData();
            if (allOriginTimerData != null && allOriginTimerData.size() > 0) {
                for (JSONObject jSONObject : allOriginTimerData) {
                    if (DEBUG) {
                        Log.i(FetchTimerJob.TAG, "FetchTimerJob continue originData " + jSONObject);
                    }
                    if (!Fetcher.processTimerJob(jSONObject)) {
                        FetchTaskManager.getInstance().removeOriginTimerData(jSONObject.optString("jobId"));
                    }
                }
            }
        }
    }

    public static FetchConnManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sSingleton == null) {
                synchronized (FetchConnManager.class) {
                    if (sSingleton == null) {
                        sSingleton = new FetchConnManager(AppRuntime.getAppContext());
                    }
                }
            }
            return sSingleton;
        }
        return (FetchConnManager) invokeV.objValue;
    }

    public void dispatch(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            if (jSONObject == null) {
                statReceiveData(false);
                return;
            }
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString("jobId");
            if (Constants.FetchType.isTimerType(optString)) {
                FetchTaskManager.getInstance().saveOriginTimerData(optString2, jSONObject);
            } else if (!Constants.FetchType.isCancelType(optString)) {
                FetchTaskManager.getInstance().saveOriginData(jSONObject.toString());
                FetchTaskManager.getInstance().saveRetryCount(0);
            }
            statReceiveData(true);
            if (!Fetcher.process(jSONObject) && Constants.FetchType.isTimerType(optString)) {
                FetchTaskManager.getInstance().removeOriginTimerData(optString2);
            }
        }
    }
}
