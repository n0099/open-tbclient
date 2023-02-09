package com.baidu.searchbox.retrieve.file;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.bean.FetchFileData;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.upload.FetchResult;
import com.baidu.searchbox.retrieve.upload.FetchTaskObj;
import com.baidu.searchbox.retrieve.upload.FetchUploadManager;
import com.baidu.searchbox.retrieve.upload.IUploadListener;
import com.baidu.tieba.oz9;
import com.baidu.tieba.pz9;
import com.baidu.tieba.rz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.Executors;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class FetchFileJob extends IFetchJob {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BIZ_TYPE = "fetchlog";
    public static final boolean DEBUG;
    public static final String TAG = "FetchFileJob";
    public static final String UPLOAD_RESULT_VALID = "1";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "file" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-143595878, "Lcom/baidu/searchbox/retrieve/file/FetchFileJob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-143595878, "Lcom/baidu/searchbox/retrieve/file/FetchFileJob;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchFileJob() {
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

    public static void statDispatchData(FetchFileData.FetchBean fetchBean) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, fetchBean) == null) && (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) != null) {
            iStatTask.recordDispatchRetrieveData(true, fetchBean.mJobId, fetchBean.mType, fetchBean.mVersion, "");
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            Executors.newSingleThreadExecutor().execute(new Runnable(this, jSONObject) { // from class: com.baidu.searchbox.retrieve.file.FetchFileJob.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FetchFileJob this$0;
                public final /* synthetic */ JSONObject val$data;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject};
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
                    this.val$data = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    FetchFileData.FetchBean parseJsonContent;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || (parseJsonContent = FetchFileData.parseJsonContent(this.val$data)) == null) {
                        return;
                    }
                    if (FetchFileJob.DEBUG) {
                        Log.i(FetchFileJob.TAG, "文件回捞收到命令 " + this.val$data);
                    }
                    FetchFileJob.statDispatchData(parseJsonContent);
                    FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(parseJsonContent.mType, "3", parseJsonContent.mJobId, parseJsonContent.mVersion, "", "", ""), new IUploadListener(this, parseJsonContent) { // from class: com.baidu.searchbox.retrieve.file.FetchFileJob.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ FetchFileData.FetchBean val$fetchBean;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, parseJsonContent};
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
                            this.val$fetchBean = parseJsonContent;
                        }

                        @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                        public void onFailure() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null && interceptable3.invokeV(1048576, this) != null) {
                                return;
                            }
                            this.this$1.this$0.statFetchData("start", false, this.val$fetchBean, StatConstants.ERR_MSG_START_FAIL, "", null);
                        }

                        @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                        public void onSuccess(FetchResult fetchResult) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fetchResult) == null) {
                                if (fetchResult == null || !TextUtils.equals("1", fetchResult.getValid())) {
                                    this.this$1.this$0.statFetchData("start", false, this.val$fetchBean, StatConstants.ERR_MSG_START_FAIL, "", null);
                                    return;
                                }
                                this.this$1.this$0.statFetchData("start", true, this.val$fetchBean, "", "", null);
                                this.this$1.this$0.startFetchFile(this.val$fetchBean);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportTaskDone(FetchFileData.FetchBean fetchBean, String str, String str2, JSONObject jSONObject) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65544, this, fetchBean, str, str2, jSONObject) != null) || fetchBean == null) {
            return;
        }
        if ("0".equals(str2)) {
            FetchTaskManager.getInstance().clearOriginData();
            FetchTaskManager.getInstance().saveRetryCount(0);
        }
        IFetchTask iFetchTask = (IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE);
        String str3 = fetchBean.mType;
        String str4 = fetchBean.mJobId;
        String str5 = fetchBean.mVersion;
        if (jSONObject == null) {
            jSONObject2 = "";
        } else {
            jSONObject2 = jSONObject.toString();
        }
        iFetchTask.reportTaskDone(str3, str4, str5, str2, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFetchFile(FetchFileData.FetchBean fetchBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, fetchBean) == null) {
            List<String> list = fetchBean.mPathList;
            if (list != null && list.size() != 0) {
                statFetchData(StatConstants.VALUE_TYPE_CHECK_PARAM, true, fetchBean, "", "", null);
                pz9 pz9Var = (pz9) ServiceManager.getService(pz9.a);
                if (pz9Var == null) {
                    if (DEBUG) {
                        Log.d(TAG, "loss voyager impl component");
                        return;
                    }
                    return;
                }
                pz9Var.g(list, "fetchlog", fetchBean.mMaxFileSize * 1024, new oz9(this, fetchBean) { // from class: com.baidu.searchbox.retrieve.file.FetchFileJob.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FetchFileJob this$0;
                    public final /* synthetic */ FetchFileData.FetchBean val$fetchBean;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fetchBean};
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
                        this.val$fetchBean = fetchBean;
                    }

                    @Override // com.baidu.tieba.oz9
                    public void onFailure(String str, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeLL(1048576, this, str, jSONObject) != null) {
                            return;
                        }
                        this.this$0.statFetchFileData(false, this.val$fetchBean, str, "", jSONObject);
                        if (!TextUtils.equals("dir not found", str)) {
                            FetchFileJob fetchFileJob = this.this$0;
                            FetchFileData.FetchBean fetchBean2 = this.val$fetchBean;
                            rz9.a(jSONObject, str);
                            fetchFileJob.reportTaskDone(fetchBean2, "", "2", jSONObject);
                            return;
                        }
                        this.this$0.reportTaskDone(this.val$fetchBean, "", "1", jSONObject);
                    }

                    @Override // com.baidu.tieba.oz9
                    public void onSuccess(String str, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) != null) {
                            return;
                        }
                        this.this$0.statFetchFileData(true, this.val$fetchBean, "", str, jSONObject);
                        this.this$0.reportTaskDone(this.val$fetchBean, str, "0", jSONObject);
                    }
                });
                return;
            }
            statFetchData(StatConstants.VALUE_TYPE_CHECK_PARAM, false, fetchBean, StatConstants.ERR_MSG_CHECK_PARAM_FAIL, "", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statFetchData(String str, boolean z, FetchFileData.FetchBean fetchBean, String str2, String str3, JSONObject jSONObject) {
        IStatTask iStatTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{str, Boolean.valueOf(z), fetchBean, str2, str3, jSONObject}) == null) && (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) != null) {
            iStatTask.recordUploadRetrieveData(str, z, fetchBean.mJobId, fetchBean.mType, fetchBean.mVersion, str2, str3, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statFetchFileData(boolean z, FetchFileData.FetchBean fetchBean, String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Boolean.valueOf(z), fetchBean, str, str2, jSONObject}) == null) {
            if (z) {
                statFetchData("query", true, fetchBean, "", "", jSONObject);
                statFetchData(StatConstants.VALUE_TYPE_ZIP, true, fetchBean, "", "", jSONObject);
                statFetchData(StatConstants.VALUE_TYPE_UPLOAD, true, fetchBean, "", str2, jSONObject);
            } else if (TextUtils.equals("dir not found", str)) {
                statFetchData("query", false, fetchBean, str, "", jSONObject);
            } else if (TextUtils.equals("zip failed", str)) {
                statFetchData("query", true, fetchBean, "", "", jSONObject);
                statFetchData(StatConstants.VALUE_TYPE_ZIP, false, fetchBean, str, "", jSONObject);
            } else {
                statFetchData("query", true, fetchBean, "", "", jSONObject);
                statFetchData(StatConstants.VALUE_TYPE_ZIP, true, fetchBean, "", "", jSONObject);
                statFetchData(StatConstants.VALUE_TYPE_UPLOAD, false, fetchBean, str, "", jSONObject);
            }
        }
    }
}
