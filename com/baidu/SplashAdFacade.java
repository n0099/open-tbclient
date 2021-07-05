package com.baidu;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.h0.b.f;
import d.a.h0.b.g.g;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class SplashAdFacade {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final SplashAdFacade f2118e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f2119a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.b.a f2120b;

    /* renamed from: c  reason: collision with root package name */
    public long f2121c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f2122d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class AdLoadState {
        public static final /* synthetic */ AdLoadState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AdLoadState FAILED;
        public static final AdLoadState INIT;
        public static final AdLoadState LOADING;
        public static final AdLoadState SUCCEED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1770562171, "Lcom/baidu/SplashAdFacade$AdLoadState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1770562171, "Lcom/baidu/SplashAdFacade$AdLoadState;");
                    return;
                }
            }
            INIT = new AdLoadState("INIT", 0);
            LOADING = new AdLoadState("LOADING", 1);
            SUCCEED = new AdLoadState("SUCCEED", 2);
            AdLoadState adLoadState = new AdLoadState("FAILED", 3);
            FAILED = adLoadState;
            $VALUES = new AdLoadState[]{INIT, LOADING, SUCCEED, adLoadState};
        }

        public AdLoadState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AdLoadState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdLoadState) Enum.valueOf(AdLoadState.class, str) : (AdLoadState) invokeL.objValue;
        }

        public static AdLoadState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdLoadState[]) $VALUES.clone() : (AdLoadState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f2123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SplashAdFacade f2124f;

        public a(SplashAdFacade splashAdFacade, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdFacade, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2124f = splashAdFacade;
            this.f2123e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f2123e != 1 || ((float) (System.currentTimeMillis() - this.f2124f.f2121c)) >= g.d() * 60000.0f) {
                    if (this.f2124f.f2120b == null) {
                        this.f2124f.f2120b = new d.a.h0.b.a();
                    }
                    this.f2124f.f2120b.l(d.a.h0.a.b.a.f45561a.get());
                    this.f2124f.f2121c = System.currentTimeMillis();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onFailed();

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(880329129, "Lcom/baidu/SplashAdFacade;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(880329129, "Lcom/baidu/SplashAdFacade;");
                return;
            }
        }
        f2118e = new SplashAdFacade();
    }

    public SplashAdFacade() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        AdLoadState adLoadState = AdLoadState.INIT;
        AdLoadState adLoadState2 = AdLoadState.INIT;
        this.f2119a = false;
        new AtomicInteger(0);
        this.f2122d = new Handler(Looper.myLooper());
    }

    public static SplashAdFacade e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f2118e : (SplashAdFacade) invokeV.objValue;
    }

    public void f(d.a.h0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar == null) {
                Log.e("SplashAdFacade", "appContext is null ,init failed");
                return;
            }
            d.a.h0.a.b.a.f45561a.set(aVar);
            aVar.o().registerActivityLifecycleCallbacks(new f());
            new BDAdConfig.Builder().setAppName(aVar.u()).setAppsid(aVar.r()).build(aVar.o()).init();
            MobadsPermissionSettings.setPermissionReadDeviceID(true);
            MobadsPermissionSettings.setPermissionLocation(true);
            MobadsPermissionSettings.setPermissionStorage(true);
            MobadsPermissionSettings.setPermissionAppList(true);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2119a : invokeV.booleanValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || d.a.h0.a.b.a.f45561a.get() == null) {
            return;
        }
        this.f2122d.postDelayed(new a(this, i2), 5000L);
    }
}
