package c.a.p0.h.b.e;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.h.b.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class a implements c.a.p0.j.u.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.h.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0673a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f10065b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(993820836, "Lc/a/p0/h/b/e/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(993820836, "Lc/a/p0/h/b/e/a$a;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f10065b = iArr;
            try {
                iArr[Download.DownloadState.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10065b[Download.DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10065b[Download.DownloadState.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10065b[Download.DownloadState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10065b[Download.DownloadState.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10065b[Download.DownloadState.FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            a = iArr2;
            try {
                iArr2[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends c.a.p0.a.o1.a.b.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public c.a.p0.h.a.c.f.a f10066c;

        public b(c.a.p0.h.a.c.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10066c = aVar;
        }

        @Override // c.a.p0.a.o1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // c.a.p0.a.o1.a.b.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.o1.a.b.c.c, c.a.p0.a.o1.a.b.c.a
        public void onEvent(@NonNull c.a.p0.a.o1.a.b.a.b bVar) {
            Bundle a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (a = bVar.a()) == null) {
                return;
            }
            a.g(a, this.f10066c);
        }
    }

    public a() {
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

    public static void g(@NonNull Bundle bundle, c.a.p0.h.a.c.f.a aVar) {
        String string;
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, bundle, aVar) == null) || (string = bundle.getString("functionType")) == null || aVar == null) {
            return;
        }
        String string2 = bundle.getString("resultData", "");
        int hashCode = string.hashCode();
        if (hashCode != -1013362275) {
            if (hashCode == -530890460 && string.equals("onSuccess")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (string.equals("onFail")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            int optInt = jSONObject.optInt("progress", -1);
            if (optInt > -1 && optInt <= 100) {
                aVar.a(optInt);
            }
            if (jSONObject.optBoolean("installed")) {
                aVar.c(DownloadState.INSTALLED, optInt);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            switch (C0673a.f10065b[Download.DownloadState.getState(optJSONObject.optInt("status", -1)).ordinal()]) {
                case 1:
                    aVar.c(DownloadState.WAIT, optInt);
                    return;
                case 2:
                    aVar.c(DownloadState.DOWNLOADING, optInt);
                    return;
                case 3:
                    aVar.c(DownloadState.DOWNLOAD_PAUSED, optInt);
                    return;
                case 4:
                    aVar.c(DownloadState.DOWNLOAD_FAILED, optInt);
                    return;
                case 5:
                    aVar.c(DownloadState.DELETED, optInt);
                    return;
                case 6:
                    aVar.c(DownloadState.DOWNLOADED, optInt);
                    return;
                default:
                    aVar.c(DownloadState.NOT_START, optInt);
                    return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.a.p0.j.u.c.c
    public boolean a(@NonNull Context context, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull c.a.p0.h.a.c.f.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, swanAppDownloadType, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key_download_package_name", getPackageName());
                jSONObject.put("key_download_url", f());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, c.a.p0.h.b.b.o.z() == null ? "" : c.a.p0.h.b.b.o.z().configName);
                jSONObject.put("download_params", jSONObject2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String e3 = e(swanAppDownloadType);
            Bundle bundle = new Bundle();
            bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, e3);
            bundle.putString("ubc_params", new c.a.p0.h.b.j.a().a());
            bundle.putString("data", jSONObject.toString());
            c.a.p0.a.o1.c.e.a z = c.a.p0.a.t1.d.J().z();
            if (z != null) {
                z.W(bundle, f.class, new b(aVar));
                return false;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // c.a.p0.j.u.c.c
    public boolean b(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(c.f10067b, str2);
                jSONObject.put("key_download_url", str);
                jSONObject.put(c.f10068c, str3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Bundle bundle = new Bundle();
            bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "startDownloadFile");
            bundle.putString("ubc_params", new c.a.p0.h.b.j.a().a());
            bundle.putString("data", jSONObject.toString());
            c.a.p0.a.o1.c.e.a z = c.a.p0.a.t1.d.J().z();
            if (z != null) {
                z.V(bundle, f.class);
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.p0.j.u.c.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (TextUtils.isEmpty(f()) || TextUtils.isEmpty(getPackageName())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final String e(SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, swanAppDownloadType)) == null) {
            switch (C0673a.a[swanAppDownloadType.ordinal()]) {
                case 1:
                    return "queryStatus";
                case 2:
                    return "startDownload";
                case 3:
                    return "pauseDownload";
                case 4:
                case 5:
                    return "deleteDownload";
                case 6:
                    return "resumeDownload";
                case 7:
                    return "installApp";
                default:
                    return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.p0.h.b.b.o.H() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.j.u.c.c
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c.a.p0.h.b.b.o.I() : (String) invokeV.objValue;
    }

    @Override // c.a.p0.j.u.c.c
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.p0.h.b.b.o.w();
        }
    }
}
