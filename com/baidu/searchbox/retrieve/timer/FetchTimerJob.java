package com.baidu.searchbox.retrieve.timer;

import android.os.Handler;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.util.Constants;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimer;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimerBean;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class FetchTimerJob extends IFetchJob {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "FetchTimerJob";
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Constants.FetchType.FETCH_TIMER_TYPE : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public static class TimerJobRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler mHandler;
        public final FetchTimerBean mTimerBean;

        public TimerJobRunnable(FetchTimerBean fetchTimerBean, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fetchTimerBean, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTimerBean = fetchTimerBean;
            this.mHandler = handler;
        }

        private void statDispatchData(boolean z, FetchTimerBean fetchTimerBean, String str) {
            IStatTask iStatTask;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), fetchTimerBean, str}) == null) && (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) != null) {
                iStatTask.recordDispatchRetrieveData(z, fetchTimerBean.getJobId(), fetchTimerBean.getType(), fetchTimerBean.getVersion(), str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ("1".equals(this.mTimerBean.getNetwork()) && !NetWorkUtils.NetType.WIFI.equals(NetWorkUtils.getNetworkType())) {
                    statDispatchData(false, this.mTimerBean, "2");
                    this.mHandler.postDelayed(this, TimeUnit.MINUTES.toMillis(this.mTimerBean.getFrequency()));
                    return;
                }
                String jobId = this.mTimerBean.getJobId();
                if (!FetchTimerList.getInstance().hasJob(jobId)) {
                    this.mHandler.removeCallbacks(this);
                    FetchTaskManager.getInstance().removeOriginTimerData(jobId);
                }
                if (System.currentTimeMillis() > this.mTimerBean.getExpiredTime()) {
                    this.mHandler.removeCallbacks(this);
                    FetchTaskManager.getInstance().removeOriginTimerData(jobId);
                }
                statDispatchData(true, this.mTimerBean, "");
                ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).activeUploadSnapShot(this.mTimerBean.getType(), this.mTimerBean.getJobId(), this.mTimerBean.getSpace(), this.mTimerBean.getMaxTotalFileSize(), this.mTimerBean.getStartTime(), this.mTimerBean.getEndTime(), true, new IActiveUploadListener(this) { // from class: com.baidu.searchbox.retrieve.timer.FetchTimerJob.TimerJobRunnable.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TimerJobRunnable this$0;

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

                    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                    public void onFailure(String str) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) && FetchTimerJob.DEBUG) {
                            Log.i(FetchTimerJob.TAG, "周期性定时任务上传失败 jobId ：" + this.this$0.mTimerBean.getJobId() + " ;error :" + str);
                        }
                    }

                    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                    public void onSuccess() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && FetchTimerJob.DEBUG) {
                            Log.i(FetchTimerJob.TAG, "周期性定时任务上传成功 jobId ：" + this.this$0.mTimerBean.getJobId());
                        }
                    }
                });
                this.mHandler.postDelayed(this, TimeUnit.MINUTES.toMillis(this.mTimerBean.getFrequency()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1902427852, "Lcom/baidu/searchbox/retrieve/timer/FetchTimerJob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1902427852, "Lcom/baidu/searchbox/retrieve/timer/FetchTimerJob;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchTimerJob() {
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

    private void startJob(FetchTimerBean fetchTimerBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, fetchTimerBean) == null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(AppRuntime.getAppContext().getMainLooper());
            }
            this.mHandler.post(new TimerJobRunnable(fetchTimerBean, this.mHandler));
            ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskDone(fetchTimerBean.getType(), fetchTimerBean.getJobId(), fetchTimerBean.getVersion(), "0", "", "");
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(JSONObject jSONObject) {
        FetchTimerBean parseJsonContent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || (parseJsonContent = FetchTimer.parseJsonContent(jSONObject)) == null) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "日志回捞收到命令 " + jSONObject);
        }
        String jobId = parseJsonContent.getJobId();
        if (FetchTimerList.getInstance().hasJob(jobId)) {
            if (DEBUG) {
                Log.i(TAG, "周期性定时回捞任务已存在 ：" + jobId);
                return;
            }
            return;
        }
        FetchTimerList.getInstance().addJob(jobId);
        startJob(parseJsonContent);
    }
}
