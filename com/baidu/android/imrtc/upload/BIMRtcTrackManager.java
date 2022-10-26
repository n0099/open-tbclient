package com.baidu.android.imrtc.upload;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.TaskManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BIMRtcTrackManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMRtcTrackManager";
    public transient /* synthetic */ FieldHolder $fh;

    public BIMRtcTrackManager() {
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

    public static void requestRtcUpload(Context context) {
        BIMRtcPbGenerator bIMRtcPbGenerator;
        byte[] generateRtcClient;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) != null) || (generateRtcClient = (bIMRtcPbGenerator = new BIMRtcPbGenerator()).generateRtcClient(context)) == null) {
            return;
        }
        IMPushUploadManager.getInstance(context).requestUpload(null, generateRtcClient, "", new IMPushUploadResponseListener(context, bIMRtcPbGenerator) { // from class: com.baidu.android.imrtc.upload.BIMRtcTrackManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BIMRtcPbGenerator val$action;
            public final /* synthetic */ Context val$context;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, bIMRtcPbGenerator};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$context = context;
                this.val$action = bIMRtcPbGenerator;
            }

            @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
            public void uploadResponse(int i, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                    LogUtils.d(BIMRtcTrackManager.TAG, "requestRtcUpload response :" + i + ", msg :" + str);
                    if (i != 0) {
                        return;
                    }
                    BIMRtcTrackManager.clearRtcTrack(this.val$context, this.val$action);
                }
            }
        });
    }

    public static void uploadRtcActionData(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, context) == null) && context != null && RequsetNetworkUtils.isConnected(context)) {
            TaskManager.getInstance().submitForNetWork(new Runnable(context) { // from class: com.baidu.android.imrtc.upload.BIMRtcTrackManager.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        BIMRtcTrackManager.requestRtcUpload(this.val$context);
                    }
                }
            });
        }
    }

    public static void clearRtcTrack(Context context, BIMRtcPbGenerator bIMRtcPbGenerator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, bIMRtcPbGenerator) == null) {
            bIMRtcPbGenerator.clearRtcActions(context);
        }
    }
}
