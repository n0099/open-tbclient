package com.baidu.cloudbase.download;

import a.a.a.c.ac;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.l.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
    public d.a.l.b.a mDownloadManager;

    /* loaded from: classes2.dex */
    public static class a extends d.a.l.b.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ac f4693a;

        /* renamed from: b  reason: collision with root package name */
        public int f4694b;

        /* renamed from: c  reason: collision with root package name */
        public long f4695c;

        /* renamed from: d  reason: collision with root package name */
        public LocalBroadcastManager f4696d;

        /* renamed from: e  reason: collision with root package name */
        public int f4697e;

        public a(int i2, ac acVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), acVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4697e = i2;
            this.f4693a = acVar;
            this.f4696d = LocalBroadcastManager.getInstance(context);
        }

        public final boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f4695c <= 300 || i2 == this.f4694b) {
                    return false;
                }
                this.f4695c = currentTimeMillis;
                this.f4694b = i2;
                return true;
            }
            return invokeI.booleanValue;
        }

        public final void b(ac acVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acVar) == null) {
                Intent intent = new Intent();
                intent.setAction(CaptureDownloadService.ACTION_DOWNLOAD_BROAD_CAST);
                intent.putExtra("extra_position", this.f4697e);
                intent.putExtra("extra_file_info", acVar.a().toString());
                this.f4696d.sendBroadcast(intent);
            }
        }

        @Override // d.a.l.b.c.a
        public void onCompleted(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ac acVar = this.f4693a;
                acVar.f1424g = 6;
                acVar.f1422e = 100;
                acVar.f1425h = str;
                b(acVar);
            }
        }

        @Override // d.a.l.b.c.a
        public void onDownloadCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ac acVar = this.f4693a;
                acVar.f1424g = 0;
                acVar.f1422e = 0;
                acVar.f1423f = "";
                b(acVar);
            }
        }

        @Override // d.a.l.b.c.a
        public void onDownloadPaused() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ac acVar = this.f4693a;
                acVar.f1424g = 4;
                b(acVar);
            }
        }

        @Override // d.a.l.b.c.a
        public void onFailed(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, downloadException) == null) {
                downloadException.printStackTrace();
                ac acVar = this.f4693a;
                acVar.f1424g = 5;
                b(acVar);
            }
        }

        @Override // d.a.l.b.c.a
        public void onProgress(long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                if (this.f4695c == 0) {
                    this.f4695c = System.currentTimeMillis();
                }
                ac acVar = this.f4693a;
                acVar.f1424g = 3;
                acVar.f1422e = i2;
                acVar.f1423f = d.a.l.b.d.a.a(j, j2);
                if (a(i2)) {
                    b(this.f4693a);
                }
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

    private void cancel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            this.mDownloadManager.c(str);
        }
    }

    private void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mDownloadManager.d();
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

    private void download(int i2, ac acVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(AdIconUtil.BAIDU_LOGO_ID, this, i2, acVar, str) == null) {
            b.a aVar = new b.a();
            aVar.d(acVar.f1421d);
            this.mDownloadManager.f(aVar.a(), str, new a(i2, acVar, getApplicationContext()));
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

    private void pause(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            this.mDownloadManager.m(str);
        }
    }

    private void pauseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mDownloadManager.n();
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

    public static void start(Context context, int i2, String str, ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65547, null, context, i2, str, acVar) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction(ACTION_DOWNLOAD);
            intent.putExtra("extra_position", i2);
            intent.putExtra("extra_tag", str);
            intent.putExtra("extra_file_info", acVar.a().toString());
            context.startService(intent);
        }
    }

    public static void start(Context context, String str, ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, str, acVar) == null) {
            start(context, 0, str, acVar);
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
            this.mDownloadManager = d.a.l.b.a.i();
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
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0085, code lost:
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
                ac acVar = new ac();
                String stringExtra = intent.getStringExtra("extra_file_info");
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        acVar.f1418a = jSONObject.optString("name");
                        acVar.f1419b = jSONObject.optString("id");
                        acVar.f1420c = jSONObject.optString("image");
                        acVar.f1421d = jSONObject.optString("url");
                        acVar.f1422e = jSONObject.optInt("progress");
                        acVar.f1423f = jSONObject.optString("downloadPerSize");
                        acVar.f1424g = jSONObject.optInt("status");
                        acVar.f1425h = jSONObject.optString("savePath");
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
                    download(intExtra, acVar, stringExtra2);
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
}
