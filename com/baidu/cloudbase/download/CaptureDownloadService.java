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
import com.baidu.tieba.b10;
import com.baidu.tieba.c10;
import com.baidu.tieba.d10;
import com.baidu.tieba.g;
import com.baidu.tieba.h10;
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
    public b10 mDownloadManager;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    /* loaded from: classes.dex */
    public class a extends d10 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public g b;
        public LocalBroadcastManager c;
        public long d;
        public int e;

        public a(int i, g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), gVar, context};
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
            this.b = gVar;
            this.c = LocalBroadcastManager.getInstance(context);
        }

        @Override // com.baidu.tieba.d10
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                g gVar = this.b;
                gVar.g = 6;
                gVar.e = 100;
                gVar.h = str;
                j(gVar);
            }
        }

        @Override // com.baidu.tieba.d10
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
                downloadException.printStackTrace();
                g gVar = this.b;
                gVar.g = 5;
                j(gVar);
            }
        }

        public final boolean i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.d > 300 && i != this.e) {
                    this.d = currentTimeMillis;
                    this.e = i;
                    return true;
                }
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.tieba.d10
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g gVar = this.b;
                gVar.g = 0;
                gVar.e = 0;
                gVar.f = "";
                j(gVar);
            }
        }

        @Override // com.baidu.tieba.d10
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g gVar = this.b;
                gVar.g = 4;
                j(gVar);
            }
        }

        @Override // com.baidu.tieba.d10
        public void g(long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                if (this.d == 0) {
                    this.d = System.currentTimeMillis();
                }
                g gVar = this.b;
                gVar.g = 3;
                gVar.e = i;
                gVar.f = h10.a(j, j2);
                if (i(i)) {
                    j(this.b);
                }
            }
        }

        public final void j(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
                Intent intent = new Intent();
                intent.setAction(CaptureDownloadService.ACTION_DOWNLOAD_BROAD_CAST);
                intent.putExtra("extra_position", this.a);
                intent.putExtra("extra_file_info", gVar.a().toString());
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

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.mDownloadManager = b10.i();
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

    public static void cancel(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction(ACTION_CANCEL);
            intent.putExtra("extra_tag", str);
            context.startService(intent);
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

    private void cancel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            this.mDownloadManager.c(str);
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

    private void pause(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            this.mDownloadManager.m(str);
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

    private void download(int i, g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65542, this, i, gVar, str) == null) {
            c10.a aVar = new c10.a();
            aVar.d(gVar.d);
            this.mDownloadManager.f(aVar.a(), str, new a(i, gVar, getApplicationContext()));
        }
    }

    public static void start(Context context, String str, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, str, gVar) == null) {
            start(context, 0, str, gVar);
        }
    }

    public static void start(Context context, int i, String str, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65547, null, context, i, str, gVar) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction(ACTION_DOWNLOAD);
            intent.putExtra("extra_position", i);
            intent.putExtra("extra_tag", str);
            intent.putExtra("extra_file_info", gVar.a().toString());
            context.startService(intent);
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
                g gVar = new g();
                String stringExtra = intent.getStringExtra("extra_file_info");
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        gVar.a = jSONObject.optString("name");
                        gVar.b = jSONObject.optString("id");
                        gVar.c = jSONObject.optString("image");
                        gVar.d = jSONObject.optString("url");
                        gVar.e = jSONObject.optInt("progress");
                        gVar.f = jSONObject.optString("downloadPerSize");
                        gVar.g = jSONObject.optInt("status");
                        gVar.h = jSONObject.optString("savePath");
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
                            cancel(stringExtra2);
                        }
                    } else {
                        pause(stringExtra2);
                    }
                } else {
                    download(intExtra, gVar, stringExtra2);
                }
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
