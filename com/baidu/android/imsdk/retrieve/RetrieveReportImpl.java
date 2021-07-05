package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class RetrieveReportImpl implements IRetrieveReportTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RetrieveReportImpl";
    public static volatile RetrieveReportImpl instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public RetrieveReportImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public static RetrieveReportImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (instance == null) {
                synchronized (RetrieveReportImpl.class) {
                    if (instance == null) {
                        instance = new RetrieveReportImpl(context);
                    }
                }
            }
            return instance;
        }
        return (RetrieveReportImpl) invokeL.objValue;
    }

    public void reportAsyncRequest(RetrieveTaskObj retrieveTaskObj, IReportListener iReportListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, retrieveTaskObj, iReportListener) == null) {
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, retrieveTaskObj, iReportListener) { // from class: com.baidu.android.imsdk.retrieve.RetrieveReportImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RetrieveReportImpl this$0;
                public final /* synthetic */ IReportListener val$listener;
                public final /* synthetic */ RetrieveTaskObj val$taskObj;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, retrieveTaskObj, iReportListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$taskObj = retrieveTaskObj;
                    this.val$listener = iReportListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        RetrieveReportRequest retrieveReportRequest = new RetrieveReportRequest(this.this$0.mContext, this.val$taskObj.getType(), this.val$taskObj.getValue(), this.val$taskObj.getJobID(), this.val$taskObj.getStatus(), this.val$taskObj.getOrigin(), this.val$taskObj.getFileMeta(), this.val$taskObj.getFileid(), this.val$listener);
                        HttpHelper.executor(this.this$0.mContext, retrieveReportRequest, retrieveReportRequest);
                    }
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveReportTask
    public void reportDispatch(String str, String str2, String str3, JSONObject jSONObject, String str4, IReportListener iReportListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, jSONObject, str4, iReportListener}) == null) {
            reportAsyncRequest(new RetrieveTaskObj(str, "1", str2, str3, str4, jSONObject == null ? "" : jSONObject.toString(), "", ""), iReportListener);
        }
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveReportTask
    public void reportDispatchCheckFail(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, str4, jSONObject) == null) {
            reportAsyncRequest(new RetrieveTaskObj(str, "-1", str2, str3, str4, jSONObject == null ? "" : jSONObject.toString(), "", ""), null);
        }
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveReportTask
    public void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject, IReportListener iReportListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, str2, str3, jSONObject, iReportListener) == null) {
            reportAsyncRequest(new RetrieveTaskObj(str, "2", str2, str3, "", jSONObject == null ? "" : jSONObject.toString(), "", ""), iReportListener);
        }
    }

    @Override // com.baidu.android.imsdk.retrieve.IRetrieveReportTask
    public void reportTaskDone(String str, String str2, String str3, String str4, String str5, String str6, IReportListener iReportListener, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6, iReportListener, str7}) == null) {
            reportAsyncRequest(new RetrieveTaskObj(str, "4", str2, str3, str4, "", str6, str7), iReportListener);
        }
    }
}
