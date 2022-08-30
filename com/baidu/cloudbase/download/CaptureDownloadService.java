package com.baidu.cloudbase.download;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.tieba.f;
import com.baidu.tieba.m00;
import com.baidu.tieba.n00;
import com.baidu.tieba.o00;
import com.baidu.tieba.s00;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CaptureDownloadService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_CANCEL = "com.baidu.cloudar.download.ACTION_CANCEL";
    public static final String ACTION_CANCEL_ALL = "com.baidu.cloudar.download.ACTION_CANCEL_ALL";
    public static final String ACTION_DOWNLOAD = "com.baidu.cloudar.download.ACTION_DOWNLOAD";
    public static final String ACTION_DOWNLOAD_BROAD_CAST = "com.baidu.cloudar.download.ACTION_BROAD_CAST";
    public static final String ACTION_PAUSE = "com.baidu.cloudar.download.ACTION_PAUSE";
    public static final String ACTION_PAUSE_ALL = "com.baidu.cloudar.download.ACTION_PAUSE_ALL";
    public static final String EXTRA_FILE_INFO = "extra_file_info";
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_TAG = "extra_tag";
    public static final String TAG = "CaptureDownloadService";
    public transient /* synthetic */ FieldHolder $fh;
    public m00 mDownloadManager;

    /* loaded from: classes.dex */
    public static class a extends o00 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public f b;
        public LocalBroadcastManager c;
        public long d;
        public int e;

        public a(int i, f fVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = fVar;
            this.c = LocalBroadcastManager.getInstance(context);
        }

        @Override // com.baidu.tieba.o00
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                f fVar = this.b;
                fVar.g = 6;
                fVar.e = 100;
                fVar.h = str;
                j(fVar);
            }
        }

        @Override // com.baidu.tieba.o00
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.b;
                fVar.g = 0;
                fVar.e = 0;
                fVar.f = "";
                j(fVar);
            }
        }

        @Override // com.baidu.tieba.o00
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                f fVar = this.b;
                fVar.g = 4;
                j(fVar);
            }
        }

        @Override // com.baidu.tieba.o00
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
                downloadException.printStackTrace();
                f fVar = this.b;
                fVar.g = 5;
                j(fVar);
            }
        }

        @Override // com.baidu.tieba.o00
        public void g(long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                if (this.d == 0) {
                    this.d = System.currentTimeMillis();
                }
                f fVar = this.b;
                fVar.g = 3;
                fVar.e = i;
                fVar.f = s00.a(j, j2);
                if (i(i)) {
                    j(this.b);
                }
            }
        }

        public final boolean i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.d <= 300 || i == this.e) {
                    return false;
                }
                this.d = currentTimeMillis;
                this.e = i;
                return true;
            }
            return invokeI.booleanValue;
        }

        public final void j(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
                Intent intent = new Intent();
                intent.setAction(CaptureDownloadService.ACTION_DOWNLOAD_BROAD_CAST);
                intent.putExtra("extra_position", this.a);
                intent.putExtra("extra_file_info", fVar.a().toString());
                this.c.sendBroadcast(intent);
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

    public static void cancel(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction(ACTION_CANCEL);
            intent.putExtra("extra_tag", str);
            context.startService(intent);
        }
    }

    public static void cancelAll(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction(ACTION_CANCEL_ALL);
            context.startService(intent);
        }
    }

    public static void destroy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            context.stopService(new Intent(context, CaptureDownloadService.class));
        }
    }

    private void download(int i, f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65542, this, i, fVar, str) == null) {
            n00.a aVar = new n00.a();
            aVar.d(fVar.d);
            this.mDownloadManager.f(aVar.a(), str, new a(i, fVar, getApplicationContext()));
        }
    }

    public static void pause(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction(ACTION_PAUSE);
            intent.putExtra("extra_tag", str);
            context.startService(intent);
        }
    }

    public static void pauseAll(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction(ACTION_PAUSE_ALL);
            context.startService(intent);
        }
    }

    public static void start(Context context, String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, str, fVar) == null) {
            start(context, 0, str, fVar);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.mDownloadManager = m00.i();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            this.mDownloadManager.n();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
        if (r0.equals(com.baidu.cloudbase.download.CaptureDownloadService.ACTION_DOWNLOAD) != false) goto L10;
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
                f fVar = new f();
                String stringExtra = intent.getStringExtra("extra_file_info");
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        fVar.a = jSONObject.optString("name");
                        fVar.b = jSONObject.optString("id");
                        fVar.c = jSONObject.optString("image");
                        fVar.d = jSONObject.optString("url");
                        fVar.e = jSONObject.optInt("progress");
                        fVar.f = jSONObject.optString("downloadPerSize");
                        fVar.g = jSONObject.optInt("status");
                        fVar.h = jSONObject.optString("savePath");
                    } catch (JSONException unused) {
                    }
                }
                String stringExtra2 = intent.getStringExtra("extra_tag");
                switch (action.hashCode()) {
                    case -1845641145:
                        if (action.equals(ACTION_CANCEL_ALL)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1229466579:
                        if (action.equals(ACTION_PAUSE_ALL)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -540402171:
                        if (action.equals(ACTION_CANCEL)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1657148651:
                        if (action.equals(ACTION_PAUSE)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1915551059:
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    download(intExtra, fVar, stringExtra2);
                } else if (c == 1) {
                    pause(stringExtra2);
                } else if (c == 2) {
                    cancel(stringExtra2);
                } else if (c == 3) {
                    pauseAll();
                } else if (c == 4) {
                    cancelAll();
                }
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }

    public static void start(Context context, int i, String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65547, null, context, i, str, fVar) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction(ACTION_DOWNLOAD);
            intent.putExtra("extra_position", i);
            intent.putExtra("extra_tag", str);
            intent.putExtra("extra_file_info", fVar.a().toString());
            context.startService(intent);
        }
    }

    private void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mDownloadManager.d();
        }
    }

    private void pauseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mDownloadManager.n();
        }
    }

    private void cancel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            this.mDownloadManager.c(str);
        }
    }

    private void pause(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            this.mDownloadManager.m(str);
        }
    }
}
