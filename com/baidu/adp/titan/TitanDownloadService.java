package com.baidu.adp.titan;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dm;
import com.baidu.tieba.fm;
import com.baidu.tieba.gm;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.rt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TitanDownloadService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Titan";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public final String pkgName;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dm a;
        public final /* synthetic */ TitanDownloadService b;

        public a(TitanDownloadService titanDownloadService, dm dmVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {titanDownloadService, dmVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = titanDownloadService;
            this.a = dmVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gm.e(this.b.mContext, "com.baidu.titan.patch", this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements dm {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ TitanDownloadService b;

        public b(TitanDownloadService titanDownloadService, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {titanDownloadService, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = titanDownloadService;
            this.a = i;
        }

        @Override // com.baidu.tieba.dm
        public void onResult(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
                if (i != -1) {
                    if (i == 0) {
                        DefaultLog.getInstance().i(TitanDownloadService.TAG, "onResult: 0");
                    }
                } else {
                    DefaultLog.getInstance().i(TitanDownloadService.TAG, "onResult: -1");
                }
                this.b.stopSelf(this.a);
            }
        }
    }

    public TitanDownloadService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pkgName = "com.baidu.titan.patch";
    }

    public static void startServiceIfNeeded(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            DefaultLog.getInstance().i(TAG, "start service");
            fm d = fm.d();
            d.g();
            if (d.e() == 0) {
                DefaultLog.getInstance().i(TAG, "startServiceIfNeeded last update time = 0");
                d.i(System.currentTimeMillis());
                d.l();
                return;
            }
            long abs = Math.abs(System.currentTimeMillis() - d.e());
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i(TAG, "startServiceIfNeeded interval = " + abs);
            try {
                DefaultLog.getInstance().i(TAG, "start service");
                context.startService(new Intent(context, TitanDownloadService.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i, i2)) == null) {
            this.mContext = getApplicationContext();
            rt6.a(new a(this, new b(this, i2)), "titan_sandbox_downloader", 0);
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
