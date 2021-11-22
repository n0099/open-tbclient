package com.baidu.cloudbase.download;

import a.a.a.b.b;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import b.a.a.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
    public b.a.a.c.a mDownloadManager;

    /* loaded from: classes7.dex */
    public static class a extends b.a.a.c.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f37762a;

        /* renamed from: b  reason: collision with root package name */
        public b f37763b;

        /* renamed from: c  reason: collision with root package name */
        public LocalBroadcastManager f37764c;

        /* renamed from: d  reason: collision with root package name */
        public long f37765d;

        /* renamed from: e  reason: collision with root package name */
        public int f37766e;

        public a(int i2, b bVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37762a = i2;
            this.f37763b = bVar;
            this.f37764c = LocalBroadcastManager.getInstance(context);
        }

        @Override // b.a.a.c.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b bVar = this.f37763b;
                bVar.f1017g = 6;
                bVar.f1015e = 100;
                bVar.f1018h = str;
                j(bVar);
            }
        }

        @Override // b.a.a.c.c.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b bVar = this.f37763b;
                bVar.f1017g = 0;
                bVar.f1015e = 0;
                bVar.f1016f = "";
                j(bVar);
            }
        }

        @Override // b.a.a.c.c.a
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b bVar = this.f37763b;
                bVar.f1017g = 4;
                j(bVar);
            }
        }

        @Override // b.a.a.c.c.a
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
                downloadException.printStackTrace();
                b bVar = this.f37763b;
                bVar.f1017g = 5;
                j(bVar);
            }
        }

        @Override // b.a.a.c.c.a
        public void g(long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                if (this.f37765d == 0) {
                    this.f37765d = System.currentTimeMillis();
                }
                b bVar = this.f37763b;
                bVar.f1017g = 3;
                bVar.f1015e = i2;
                bVar.f1016f = b.a.a.c.d.a.a(j, j2);
                if (i(i2)) {
                    j(this.f37763b);
                }
            }
        }

        public final boolean i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f37765d <= 300 || i2 == this.f37766e) {
                    return false;
                }
                this.f37765d = currentTimeMillis;
                this.f37766e = i2;
                return true;
            }
            return invokeI.booleanValue;
        }

        public final void j(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
                Intent intent = new Intent();
                intent.setAction(CaptureDownloadService.ACTION_DOWNLOAD_BROAD_CAST);
                intent.putExtra("extra_position", this.f37762a);
                intent.putExtra("extra_file_info", bVar.a().toString());
                this.f37764c.sendBroadcast(intent);
            }
        }
    }

    public CaptureDownloadService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            context.stopService(new Intent(context, CaptureDownloadService.class));
        }
    }

    private void download(int i2, b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(AdIconUtil.BAIDU_LOGO_ID, this, i2, bVar, str) == null) {
            b.a aVar = new b.a();
            aVar.d(bVar.f1014d);
            this.mDownloadManager.f(aVar.a(), str, new a(i2, bVar, getApplicationContext()));
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

    public static void start(Context context, String str, a.a.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, str, bVar) == null) {
            start(context, 0, str, bVar);
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
            this.mDownloadManager = b.a.a.c.a.i();
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
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        if (r0.equals(com.baidu.cloudbase.download.CaptureDownloadService.ACTION_DOWNLOAD) != false) goto L10;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i2, i3)) == null) {
            if (intent != null) {
                String action = intent.getAction();
                char c2 = 0;
                int intExtra = intent.getIntExtra("extra_position", 0);
                a.a.a.b.b bVar = new a.a.a.b.b();
                String stringExtra = intent.getStringExtra("extra_file_info");
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        bVar.f1011a = jSONObject.optString("name");
                        bVar.f1012b = jSONObject.optString("id");
                        bVar.f1013c = jSONObject.optString("image");
                        bVar.f1014d = jSONObject.optString("url");
                        bVar.f1015e = jSONObject.optInt("progress");
                        bVar.f1016f = jSONObject.optString("downloadPerSize");
                        bVar.f1017g = jSONObject.optInt("status");
                        bVar.f1018h = jSONObject.optString("savePath");
                    } catch (JSONException unused) {
                    }
                }
                String stringExtra2 = intent.getStringExtra("extra_tag");
                switch (action.hashCode()) {
                    case -1845641145:
                        if (action.equals(ACTION_CANCEL_ALL)) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1229466579:
                        if (action.equals(ACTION_PAUSE_ALL)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -540402171:
                        if (action.equals(ACTION_CANCEL)) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1657148651:
                        if (action.equals(ACTION_PAUSE)) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1915551059:
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    download(intExtra, bVar, stringExtra2);
                } else if (c2 == 1) {
                    pause(stringExtra2);
                } else if (c2 == 2) {
                    cancel(stringExtra2);
                } else if (c2 == 3) {
                    pauseAll();
                } else if (c2 == 4) {
                    cancelAll();
                }
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }

    public static void start(Context context, int i2, String str, a.a.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65547, null, context, i2, str, bVar) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction(ACTION_DOWNLOAD);
            intent.putExtra("extra_position", i2);
            intent.putExtra("extra_tag", str);
            intent.putExtra("extra_file_info", bVar.a().toString());
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
