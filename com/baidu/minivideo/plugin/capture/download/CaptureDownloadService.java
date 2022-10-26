package com.baidu.minivideo.plugin.capture.download;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.minivideo.plugin.capture.download.DownloadRequest;
import com.baidu.minivideo.plugin.capture.download.base.DownloadCallback;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.utils.CommonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CaptureDownloadService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_CANCEL = "com.baidu.ugc.download.ACTION_CANCEL";
    public static final String ACTION_CANCEL_ALL = "com.baidu.ugc.download.ACTION_CANCEL_ALL";
    public static final String ACTION_DOWNLOAD = "com.baidu.ugc.download.ACTION_DOWNLOAD";
    public static final String ACTION_DOWNLOAD_BROAD_CAST = "com.baidu.ugc.download.ACTION_BROAD_CAST";
    public static final String ACTION_PAUSE = "com.baidu.ugc.download.ACTION_PAUSE";
    public static final String ACTION_PAUSE_ALL = "com.baidu.ugc.download.ACTION_PAUSE_ALL";
    public static final String EXTRA_FILE_INFO = "extra_file_info";
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_TAG = "extra_tag";
    public static final String TAG = "CaptureDownloadService";
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadManager mDownloadManager;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    /* loaded from: classes2.dex */
    public class ProgressCallback extends DownloadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RequestTask mAppInfo;
        public int mLastProgress;
        public long mLastTime;
        public LocalBroadcastManager mLocalBroadcastManager;
        public int mPosition;

        public ProgressCallback(int i, RequestTask requestTask, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), requestTask, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPosition = i;
            this.mAppInfo = requestTask;
            this.mLocalBroadcastManager = LocalBroadcastManager.getInstance(context);
        }

        private boolean checkSendBroadLimit(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mLastTime > 300 && i != this.mLastProgress) {
                    this.mLastTime = currentTimeMillis;
                    this.mLastProgress = i;
                    return true;
                }
                return false;
            }
            return invokeI.booleanValue;
        }

        private void sendBroadCast(RequestTask requestTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, requestTask) == null) {
                Intent intent = new Intent();
                intent.setAction("com.baidu.ugc.download.ACTION_BROAD_CAST");
                intent.putExtra("extra_position", this.mPosition);
                intent.putExtra("extra_file_info", requestTask);
                this.mLocalBroadcastManager.sendBroadcast(intent);
            }
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onCompleted(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.mAppInfo.setStatus(6);
                this.mAppInfo.setProgress(100);
                this.mAppInfo.setSavePath(str);
                sendBroadCast(this.mAppInfo);
            }
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onFailed(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
                downloadException.printStackTrace();
                this.mAppInfo.setStatus(5);
                sendBroadCast(this.mAppInfo);
            }
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onDownloadCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mAppInfo.setStatus(0);
                this.mAppInfo.setProgress(0);
                this.mAppInfo.setDownloadPerSize("");
                sendBroadCast(this.mAppInfo);
            }
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onDownloadPaused() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mAppInfo.setStatus(4);
                sendBroadCast(this.mAppInfo);
            }
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onProgress(long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                if (this.mLastTime == 0) {
                    this.mLastTime = System.currentTimeMillis();
                }
                this.mAppInfo.setStatus(3);
                this.mAppInfo.setProgress(i);
                this.mAppInfo.setDownloadPerSize(CommonUtils.getDownloadPerSize(j, j2));
                if (checkSendBroadLimit(i)) {
                    sendBroadCast(this.mAppInfo);
                }
            }
        }
    }

    public CaptureDownloadService() {
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

    private void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mDownloadManager.cancelAll();
        }
    }

    private void pauseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mDownloadManager.pauseAll();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.mDownloadManager = DownloadManager.getInstance();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            this.mDownloadManager.pauseAll();
        }
    }

    public static void cancel(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_CANCEL");
            intent.putExtra("extra_tag", str);
            context.startService(intent);
        }
    }

    public static void pause(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_PAUSE");
            intent.putExtra("extra_tag", str);
            context.startService(intent);
        }
    }

    private void cancel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            this.mDownloadManager.cancel(str);
        }
    }

    public static void cancelAll(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_CANCEL_ALL");
            context.startService(intent);
        }
    }

    public static void destroy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            context.stopService(new Intent(context, CaptureDownloadService.class));
        }
    }

    private void pause(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            this.mDownloadManager.pause(str);
        }
    }

    public static void pauseAll(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_PAUSE_ALL");
            context.startService(intent);
        }
    }

    private void download(int i, RequestTask requestTask, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65542, this, i, requestTask, str) == null) {
            this.mDownloadManager.download(new DownloadRequest.Builder().setUri(requestTask.getUrl()).build(), str, new ProgressCallback(i, requestTask, getApplicationContext()));
        }
    }

    public static void start(Context context, String str, RequestTask requestTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, str, requestTask) == null) {
            start(context, 0, str, requestTask);
        }
    }

    public static void start(Context context, int i, String str, RequestTask requestTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65547, null, context, i, str, requestTask) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_DOWNLOAD");
            intent.putExtra("extra_position", i);
            intent.putExtra("extra_tag", str);
            intent.putExtra("extra_file_info", requestTask);
            context.startService(intent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (r0.equals("com.baidu.ugc.download.ACTION_DOWNLOAD") != false) goto L9;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i, i2)) == null) {
            if (intent != null) {
                String action = intent.getAction();
                char c = 0;
                int intExtra = intent.getIntExtra("extra_position", 0);
                RequestTask requestTask = (RequestTask) intent.getSerializableExtra("extra_file_info");
                String stringExtra = intent.getStringExtra("extra_tag");
                switch (action.hashCode()) {
                    case -2000112966:
                        if (action.equals("com.baidu.ugc.download.ACTION_CANCEL")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1148652932:
                        if (action.equals("com.baidu.ugc.download.ACTION_CANCEL_ALL")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -929888424:
                        if (action.equals("com.baidu.ugc.download.ACTION_PAUSE_ALL")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -707184440:
                        break;
                    case 1610061206:
                        if (action.equals("com.baidu.ugc.download.ACTION_PAUSE")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (c == 4) {
                                    cancelAll();
                                }
                            } else {
                                pauseAll();
                            }
                        } else {
                            cancel(stringExtra);
                        }
                    } else {
                        pause(stringExtra);
                    }
                } else {
                    download(intExtra, requestTask, stringExtra);
                }
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
