package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class IMTrackManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FAIL_MAX_COUNT = 3;
    public static final int RETRY_MAX_COUNT = 1;
    public static final String TAG = "IMTrackManager";
    public static int retryCount;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-757875549, "Lcom/baidu/android/imsdk/upload/action/IMTrackManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-757875549, "Lcom/baidu/android/imsdk/upload/action/IMTrackManager;");
        }
    }

    public IMTrackManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* synthetic */ int access$208() {
        int i2 = retryCount;
        retryCount = i2 + 1;
        return i2;
    }

    public static void clearIMTrack(Context context, IMPbGenerator iMPbGenerator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, iMPbGenerator) == null) {
            iMPbGenerator.clearIMActions();
            IMTrackDatabase.getInstance(context).clearAllTables();
            retryCount = 0;
        }
    }

    public static void requestIMRealUpload(Context context, @NonNull IMPushPb.Action action) {
        byte[] generateIMRealClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, context, action) == null) || (generateIMRealClient = new IMPbGenerator().generateIMRealClient(context, action)) == null || generateIMRealClient.length >= 307200) {
            return;
        }
        IMPushUploadManager.getInstance(context).requestUpload(null, generateIMRealClient, "", new IMPushUploadResponseListener(context, generateIMRealClient) { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context val$context;
            public final /* synthetic */ byte[] val$payload;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, generateIMRealClient};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$context = context;
                this.val$payload = generateIMRealClient;
            }

            @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
            public void uploadResponse(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    LogUtils.d(IMTrackManager.TAG, "uploadIMRealAction response :" + i2 + ", msg :" + str);
                    if (i2 != 0) {
                        IMPushUploadManager.getInstance(this.val$context).requestUpload(null, this.val$payload, "", null);
                    }
                }
            }
        });
    }

    public static void requestUpload(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            IMPbGenerator iMPbGenerator = new IMPbGenerator();
            byte[] generateIMClient = iMPbGenerator.generateIMClient(context);
            if (generateIMClient != null && generateIMClient.length < 307200) {
                IMPushUploadManager.getInstance(context).requestUpload(null, generateIMClient, "", new IMPushUploadResponseListener(context, iMPbGenerator) { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IMPbGenerator val$action;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, iMPbGenerator};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$action = iMPbGenerator;
                    }

                    @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
                    public void uploadResponse(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            LogUtils.d(IMTrackManager.TAG, "uploadIMData response :" + i2 + ", msg :" + str);
                            Utility.setIMTrackTime(this.val$context);
                            if (i2 == 0) {
                                IMTrackManager.clearIMTrack(this.val$context, this.val$action);
                                int unused = IMTrackManager.retryCount = 0;
                                return;
                            }
                            int i3 = 1;
                            if (IMTrackManager.retryCount < 1) {
                                IMTrackManager.requestUpload(this.val$context);
                                IMTrackManager.access$208();
                                return;
                            }
                            int unused2 = IMTrackManager.retryCount = 0;
                            int iMTrackFailCount = Utility.getIMTrackFailCount(this.val$context);
                            if (iMTrackFailCount >= 3) {
                                IMTrackManager.clearIMTrack(this.val$context, this.val$action);
                            } else {
                                i3 = 1 + iMTrackFailCount;
                            }
                            Utility.setIMTrackFailCount(this.val$context, i3);
                        }
                    }
                });
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("RequestUpload payload.length = ");
            sb.append(generateIMClient != null ? generateIMClient.length : 0);
            sb.append(", clear datas and no upload.");
            LogUtils.d(TAG, sb.toString());
            clearIMTrack(context, iMPbGenerator);
        }
    }

    public static void uploadIMActionData(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, context) == null) && context != null && RequsetNetworkUtils.isConnected(context) && Utility.needIMTrack(context)) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context) { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        IMTrackManager.requestUpload(this.val$context);
                    }
                }
            });
        }
    }

    public static void uploadIMRealAction(Context context, @NonNull IMPushPb.Action action) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, context, action) == null) && context != null && RequsetNetworkUtils.isConnected(context)) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context, action) { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ IMPushPb.Action val$requestAction;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, action};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                    this.val$requestAction = action;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        IMTrackManager.requestIMRealUpload(this.val$context, this.val$requestAction);
                    }
                }
            });
        }
    }
}
