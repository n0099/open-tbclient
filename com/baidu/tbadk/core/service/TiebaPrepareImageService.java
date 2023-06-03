package com.baidu.tbadk.core.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.by5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TiebaPrepareImageService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DISPLAY_SIZE = "display_size";
    public static final String FILE_NAME = "file_name";
    public static volatile boolean IS_DECODING = false;
    public static final String MAX_SIZE = "max_size";
    public static final String REQUESTCODE = "request_code";
    public transient /* synthetic */ FieldHolder $fh;
    public int mDisplaySize;
    public String mFileName;
    public final Handler mHandler;
    public int mMaxSize;
    public int mRequestCode;
    public final Runnable mStartRun;
    public b mTask;
    public Uri mUri;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-488305374, "Lcom/baidu/tbadk/core/service/TiebaPrepareImageService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-488305374, "Lcom/baidu/tbadk/core/service/TiebaPrepareImageService;");
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

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPrepareImageService a;

        public a(TiebaPrepareImageService tiebaPrepareImageService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPrepareImageService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiebaPrepareImageService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TiebaPrepareImageService.IS_DECODING) {
                    TiebaPrepareImageService tiebaPrepareImageService = this.a;
                    TiebaPrepareImageService tiebaPrepareImageService2 = this.a;
                    tiebaPrepareImageService.mTask = new b(tiebaPrepareImageService2, tiebaPrepareImageService2.mRequestCode, this.a.mUri, this.a.mFileName);
                    this.a.mTask.execute(new Object[0]);
                    return;
                }
                this.a.mHandler.postDelayed(this.a.mStartRun, 1000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Object, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Uri b;
        public String c;
        public String d;
        public final /* synthetic */ TiebaPrepareImageService e;

        public b(TiebaPrepareImageService tiebaPrepareImageService, int i, Uri uri, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPrepareImageService, Integer.valueOf(i), uri, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tiebaPrepareImageService;
            this.a = 0;
            this.b = null;
            this.c = null;
            this.d = null;
            this.a = i;
            this.b = uri;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Bitmap c;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                boolean z = true;
                TiebaPrepareImageService.IS_DECODING = true;
                boolean z2 = false;
                try {
                    c = by5.c(this.a, this.e, this.b, this.c, this.e.mMaxSize);
                } catch (Exception unused) {
                    TiebaPrepareImageService.IS_DECODING = false;
                } catch (Throwable th) {
                    TiebaPrepareImageService.IS_DECODING = false;
                    throw th;
                }
                if (c != null) {
                    if (FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE, c, 85) != null) {
                        int i = 100;
                        if (this.e.mDisplaySize > 0) {
                            i = this.e.mDisplaySize;
                        }
                        Bitmap resizeBitmap = BitmapHelper.resizeBitmap(c, i);
                        if (resizeBitmap == null || FileHelper.saveBitmapByRelativelyPath(null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, resizeBitmap, 85) == null) {
                            this.d = this.e.getString(R.string.error_sd_error);
                        } else {
                            TiebaPrepareImageService.IS_DECODING = false;
                            z2 = z;
                            return Boolean.valueOf(z2);
                        }
                    } else {
                        this.d = this.e.getString(R.string.error_sd_error);
                    }
                } else {
                    this.d = this.e.getString(R.string.pic_parser_error);
                }
                z = false;
                TiebaPrepareImageService.IS_DECODING = false;
                z2 = z;
                return Boolean.valueOf(z2);
            }
            return (Boolean) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.e.mTask = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((b) bool);
                Intent intent = new Intent(TbConfig.getBroadcastActionImageResized());
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra("result", bool);
                String str = this.d;
                if (str != null) {
                    intent.putExtra("error", str);
                }
                this.e.sendBroadcast(intent);
            }
        }
    }

    public TiebaPrepareImageService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRequestCode = 0;
        this.mUri = null;
        this.mFileName = null;
        this.mTask = null;
        this.mHandler = new Handler();
        this.mStartRun = new a(this);
    }

    public static void StartService(int i, Uri uri, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), uri, Integer.valueOf(i2)}) == null) {
            StartService(i, uri, i2, 0);
        }
    }

    public static void StartService(int i, Uri uri, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), uri, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            Intent intent = new Intent(TbadkCoreApplication.getInst().getApp(), TiebaPrepareImageService.class);
            intent.putExtra("request_code", i);
            intent.putExtra(MAX_SIZE, i2);
            intent.putExtra("display_size", i3);
            intent.setData(uri);
            TbadkCoreApplication.getInst().getApp().startService(intent);
        }
    }

    public static void StartService(int i, Uri uri, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), uri, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            Intent intent = new Intent(TbadkCoreApplication.getInst().getApp(), TiebaPrepareImageService.class);
            intent.putExtra("request_code", i);
            intent.putExtra(MAX_SIZE, i2);
            intent.putExtra("display_size", i3);
            intent.putExtra("file_name", str);
            intent.setData(uri);
            TbadkCoreApplication.getInst().getApp().startService(intent);
        }
    }

    public static void StopService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TbadkCoreApplication.getInst().getApp().stopService(new Intent(TbadkCoreApplication.getInst().getApp(), TiebaPrepareImageService.class));
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            b bVar = this.mTask;
            if (bVar != null) {
                bVar.cancel();
            }
            this.mHandler.removeCallbacks(this.mStartRun);
            this.mTask = null;
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, intent, i) == null) {
            super.onStart(intent, i);
            if (intent != null) {
                startPrepareImage(intent);
            }
        }
    }

    private void startPrepareImage(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, intent) == null) {
            b bVar = this.mTask;
            if (bVar != null) {
                bVar.cancel();
            }
            this.mUri = intent.getData();
            this.mFileName = intent.getStringExtra("file_name");
            this.mRequestCode = intent.getIntExtra("request_code", 0);
            this.mMaxSize = intent.getIntExtra(MAX_SIZE, 1800);
            this.mDisplaySize = intent.getIntExtra("display_size", 0);
            TbadkCoreApplication.getInst().addRemoteActivity(null);
            if (!IS_DECODING) {
                b bVar2 = new b(this, this.mRequestCode, this.mUri, this.mFileName);
                this.mTask = bVar2;
                bVar2.execute(new Object[0]);
                return;
            }
            this.mHandler.postDelayed(this.mStartRun, 1000L);
        }
    }
}
