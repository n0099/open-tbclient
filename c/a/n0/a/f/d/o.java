package c.a.n0.a.f.d;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface o {

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f4309b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1309316056, "Lc/a/n0/a/f/d/o$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1309316056, "Lc/a/n0/a/f/d/o$a;");
                    return;
                }
            }
            int[] iArr = new int[ISwanApkFetcher.FetchStates.values().length];
            f4309b = iArr;
            try {
                iArr[ISwanApkFetcher.FetchStates.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4309b[ISwanApkFetcher.FetchStates.FETCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4309b[ISwanApkFetcher.FetchStates.FETCH_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4309b[ISwanApkFetcher.FetchStates.FETCHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4309b[ISwanApkFetcher.FetchStates.FETCH_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4309b[ISwanApkFetcher.FetchStates.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4309b[ISwanApkFetcher.FetchStates.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4309b[ISwanApkFetcher.FetchStates.FETCH_PREPARE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4309b[ISwanApkFetcher.FetchStates.WAITING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[DownloadParams.SwanAppDownloadType.values().length];
            a = iArr2;
            try {
                iArr2[DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements o {
        public static /* synthetic */ Interceptable $ic;
        public static final boolean j;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public f f4310b;

        /* renamed from: c  reason: collision with root package name */
        public String f4311c;

        /* renamed from: d  reason: collision with root package name */
        public String f4312d;

        /* renamed from: e  reason: collision with root package name */
        public String f4313e;

        /* renamed from: f  reason: collision with root package name */
        public String f4314f;

        /* renamed from: g  reason: collision with root package name */
        public String f4315g;

        /* renamed from: h  reason: collision with root package name */
        public Context f4316h;
        public CallbackHandler i;

        /* loaded from: classes.dex */
        public class a implements c.a.n0.h.a.c.f.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadParams.SwanAppDownloadType a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f4317b;

            public a(b bVar, DownloadParams.SwanAppDownloadType swanAppDownloadType) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppDownloadType};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4317b = bVar;
                this.a = swanAppDownloadType;
            }

            @Override // c.a.n0.h.a.c.f.a
            public void a(int i) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onProgressChange:" + i);
                }
            }

            @Override // c.a.n0.h.a.c.f.a
            public void b() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onInstall:");
                }
            }

            @Override // c.a.n0.h.a.c.f.a
            public void c(DownloadState downloadState, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) {
                    if (b.j) {
                        Log.d("SwanAdDownloadImpl", "onStateChange   onStateChange:" + downloadState + ", onProgressChange:" + i);
                    }
                    switch (a.a[this.a.ordinal()]) {
                        case 1:
                            this.f4317b.w(downloadState, String.valueOf(i));
                            return;
                        case 2:
                            this.f4317b.y(downloadState, String.valueOf(i));
                            return;
                        case 3:
                            this.f4317b.v(String.valueOf(i));
                            return;
                        case 4:
                            this.f4317b.t();
                            return;
                        case 5:
                            this.f4317b.x(downloadState, String.valueOf(i));
                            return;
                        case 6:
                            this.f4317b.u();
                            return;
                        default:
                            return;
                    }
                }
            }

            @Override // c.a.n0.h.a.c.f.a
            public void d(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onPackageNameChange:" + str);
                }
            }

            @Override // c.a.n0.h.a.c.f.a
            public String e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    if (b.j) {
                        Log.d("SwanAdDownloadImpl", "onAppOpen:");
                        return null;
                    }
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // c.a.n0.h.a.c.f.a
            public void f(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && b.j) {
                    Log.d("SwanAdDownloadImpl", "onShowButton:" + z);
                }
            }
        }

        /* renamed from: c.a.n0.a.f.d.o$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0260b implements c.a.n0.a.p2.g1.c<ISwanApkFetcher> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f4318b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f4319c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f4320d;

            public C0260b(b bVar, String str, String str2, String str3, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2, str3, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.f4318b = str2;
                this.f4319c = str3;
                this.f4320d = z;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(ISwanApkFetcher iSwanApkFetcher) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iSwanApkFetcher) == null) {
                    iSwanApkFetcher.g(this.a, new c.a.n0.a.f.d.s1.a().N(this.f4318b).I(this.f4319c).H(c.a.n0.a.t1.d.J().getAppId()).E(Boolean.valueOf(this.f4320d)));
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements c.a.n0.a.l1.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f4321b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f4322c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f4323d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f4324e;

            public c(b bVar, String str, String str2, String str3, boolean z, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2, str3, Boolean.valueOf(z), context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.f4321b = str2;
                this.f4322c = str3;
                this.f4323d = z;
                this.f4324e = context;
            }

            @Override // c.a.n0.a.l1.f
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.a));
                    String str2 = Environment.DIRECTORY_DOWNLOADS;
                    String str3 = this.a;
                    request.setDestinationInExternalPublicDir(str2, str3.substring(str3.lastIndexOf("/") + 1));
                    if (!TextUtils.isEmpty(this.f4321b) && !TextUtils.isEmpty(this.f4322c)) {
                        request.setNotificationVisibility(1);
                        request.setTitle(this.f4321b);
                        request.setDescription(this.f4322c);
                        request.setVisibleInDownloadsUi(true);
                        request.allowScanningByMediaScanner();
                        request.setMimeType("application/vnd.android.package-archive");
                    }
                    DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                    if (downloadManager != null) {
                        downloadManager.enqueue(request);
                        if (this.f4323d) {
                            return;
                        }
                        c.a.n0.a.p2.f.g(this.f4324e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                    }
                }
            }

            @Override // c.a.n0.a.l1.f
            public void b(int i, String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && b.j) {
                    Log.d("DownloadImpl", "onAuthorizedFailed,  errorCode: " + i + " errorMsg: " + str);
                }
            }
        }

        /* loaded from: classes.dex */
        public class d implements c.a.n0.a.p2.g1.c<ISwanApkFetcher> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DownloadParams.SwanAppDownloadType f4325b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.h.a.c.f.a f4326c;

            public d(b bVar, JSONObject jSONObject, DownloadParams.SwanAppDownloadType swanAppDownloadType, c.a.n0.h.a.c.f.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, jSONObject, swanAppDownloadType, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jSONObject;
                this.f4325b = swanAppDownloadType;
                this.f4326c = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(ISwanApkFetcher iSwanApkFetcher) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iSwanApkFetcher) == null) {
                    String optString = this.a.optString("url");
                    c.a.n0.a.f.d.s1.a G = new c.a.n0.a.f.d.s1.a().L(this.a.optString("name")).H(c.a.n0.a.t1.d.J().getAppId()).F(this.a.optString("contentDisposition")).K(this.a.optString("mimeType")).O(this.a.optString(TTDownloadField.TT_USERAGENT)).E(Boolean.valueOf(this.a.optBoolean("apk_auto_install") || this.f4325b == DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP)).J(this.a.optString("ext_info")).G(this.a.optString("contentLength"));
                    e eVar = new e(optString, this.f4326c, null);
                    iSwanApkFetcher.f(optString, eVar);
                    switch (a.a[this.f4325b.ordinal()]) {
                        case 1:
                            iSwanApkFetcher.c(optString, G);
                            return;
                        case 2:
                            iSwanApkFetcher.g(optString, G);
                            return;
                        case 3:
                            iSwanApkFetcher.i(optString, G);
                            return;
                        case 4:
                            iSwanApkFetcher.d(optString, G);
                            return;
                        case 5:
                            iSwanApkFetcher.e(optString, G);
                            return;
                        case 6:
                            iSwanApkFetcher.g(optString, G.E(Boolean.TRUE));
                            return;
                        case 7:
                            iSwanApkFetcher.release();
                            return;
                        default:
                            iSwanApkFetcher.E(optString, eVar);
                            return;
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public static class e implements ISwanApkFetcher.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ e(String str, c.a.n0.h.a.c.f.a aVar, a aVar2) {
                this(str, aVar);
            }

            public e(String str, c.a.n0.h.a.c.f.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1309316087, "Lc/a/n0/a/f/d/o$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1309316087, "Lc/a/n0/a/f/d/o$b;");
                    return;
                }
            }
            j = c.a.n0.a.a.a;
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public void A() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f4310b) == null) {
                return;
            }
            this.f4316h.unregisterReceiver(fVar);
            this.f4310b = null;
        }

        @Override // c.a.n0.a.f.d.o
        public boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull c.a.n0.h.a.c.f.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, swanAppDownloadType, aVar)) == null) ? r(context, jSONObject, swanAppDownloadType, aVar) : invokeLLLL.booleanValue;
        }

        @Override // c.a.n0.a.f.d.o
        public boolean e(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler)) == null) {
                this.f4316h = context;
                this.i = callbackHandler;
                this.f4314f = jSONObject.optString("cb");
                this.f4315g = jSONObject.optString("onProgressUpdate");
                this.f4311c = jSONObject.optString("url");
                this.f4312d = jSONObject.optString("name");
                this.f4313e = String.valueOf(this.f4311c.hashCode());
                if (!TextUtils.isEmpty(this.f4314f) && !TextUtils.isEmpty(this.f4311c)) {
                    if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
                        z();
                    }
                    DownloadParams.SwanAppDownloadType find = DownloadParams.SwanAppDownloadType.find(swanAppDownloadType.getTypeName());
                    return r(context, jSONObject, find, new a(this, find));
                }
                n(false, "Missing parameters");
                return false;
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // c.a.n0.a.f.d.o
        public boolean f(Context context, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, jSONObject)) == null) ? s(context, jSONObject) : invokeLL.booleanValue;
        }

        @NonNull
        public final String l(DownloadState downloadState, @NonNull String str, @NonNull String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, downloadState, str, str2)) == null) ? m(downloadState, str, str2, -1) : (String) invokeLLL.objValue;
        }

        @NonNull
        public final String m(DownloadState downloadState, @NonNull String str, @NonNull String str2, int i) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048581, this, downloadState, str, str2, i)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (i > 0) {
                        jSONObject.put("state", i);
                    } else {
                        jSONObject.put("state", downloadState);
                    }
                    jSONObject.put("progress", str);
                    jSONObject.put(StatConstants.KEY_EXT_FILE_ID, str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return o(true, null, jSONObject);
            }
            return (String) invokeLLLI.objValue;
        }

        @NonNull
        public final String n(boolean z, @Nullable String str) {
            InterceptResult invokeZL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZL = interceptable.invokeZL(1048582, this, z, str)) == null) ? o(z, str, null) : (String) invokeZL.objValue;
        }

        @NonNull
        public final String o(boolean z, @Nullable String str, @Nullable JSONObject jSONObject) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, jSONObject})) == null) {
                if (str == null) {
                    str = z ? "success" : SmsLoginView.f.l;
                }
                return UnitedSchemeUtility.wrapCallbackParams(jSONObject, z ? 0 : 1001, str).toString();
            }
            return (String) invokeCommon.objValue;
        }

        public final boolean p(c.a.n0.a.p2.g1.c<ISwanApkFetcher> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
                ISwanApkFetcher b2 = c.a.n0.a.s0.a.b();
                boolean C = b2.C();
                if (C && cVar != null) {
                    cVar.onCallback(b2);
                }
                return C;
            }
            return invokeL.booleanValue;
        }

        public final boolean q(DownloadParams.SwanAppDownloadType swanAppDownloadType, JSONObject jSONObject, c.a.n0.h.a.c.f.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, swanAppDownloadType, jSONObject, aVar)) == null) {
                if (swanAppDownloadType == null) {
                    swanAppDownloadType = DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS;
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                return p(new d(this, jSONObject, swanAppDownloadType, aVar));
            }
            return invokeLLL.booleanValue;
        }

        public final boolean r(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull c.a.n0.h.a.c.f.a aVar) {
            InterceptResult invokeLLLL;
            c.a.n0.a.o1.c.e.a P;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, jSONObject, swanAppDownloadType, aVar)) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("type", swanAppDownloadType.getTypeName());
                bundle.putString(PushConstants.PARAMS, jSONObject != null ? jSONObject.toString() : "");
                if (!q(swanAppDownloadType, jSONObject, aVar) && (P = c.a.n0.a.o1.c.e.a.P()) != null) {
                    P.W(bundle, c.a.n0.a.e.h.a.class, new c.a.n0.a.e.h.b(aVar, swanAppDownloadType));
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        public final boolean s(Context context, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, context, jSONObject)) == null) {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("description");
                boolean optBoolean = jSONObject.optBoolean("autoinstall");
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.s1.b.f.e.g(AppRuntime.getAppContext(), "download url is empty");
                    return false;
                } else if (p(new C0260b(this, optString, optString2, optString3, optBoolean))) {
                    return true;
                } else {
                    c.a.n0.a.l1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new c(this, optString, optString2, optString3, optBoolean, context));
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                this.i.handleSchemeDispatchCallback(this.f4315g, l(DownloadState.DOWNLOAD_FAILED, "0", this.f4313e));
                this.i.handleSchemeDispatchCallback(this.f4314f, n(true, null));
                String str = this.a;
                if (str != null) {
                    this.i.handleSchemeDispatchCallback(str, n(false, "onStopped"));
                    this.a = null;
                }
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                if (j) {
                    Log.d("SwanAdDownloadImpl", "handleInstallApp");
                }
                String concat = new File(c.a.n0.a.e.h.a.m()).getAbsolutePath().concat("/");
                String concat2 = concat.concat(this.f4313e + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                if (new File(concat2).exists()) {
                    z();
                    if (c.a.n0.h.a.k.g.c(concat2, false)) {
                        return;
                    }
                    this.i.handleSchemeDispatchCallback(this.f4314f, n(false, "install apk error"));
                    return;
                }
                this.i.handleSchemeDispatchCallback(this.f4314f, n(false, "Apk Not Found"));
            }
        }

        public final void v(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.i.handleSchemeDispatchCallback(this.f4315g, l(DownloadState.DOWNLOAD_PAUSED, str, this.f4313e));
                this.i.handleSchemeDispatchCallback(this.f4314f, n(true, null));
                String str2 = this.a;
                if (str2 != null) {
                    this.i.handleSchemeDispatchCallback(str2, n(false, MissionEvent.MESSAGE_PAUSE));
                    this.a = null;
                }
            }
        }

        public final void w(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, downloadState, str) == null) {
                this.i.handleSchemeDispatchCallback(this.f4315g, l(downloadState, str, this.f4313e));
                if (downloadState == DownloadState.DOWNLOADED && "-1".equals(str)) {
                    this.i.handleSchemeDispatchCallback(this.f4314f, m(downloadState, str, this.f4313e, DownloadState.DELETED.value()));
                } else if (TextUtils.equals(str, "100")) {
                    this.i.handleSchemeDispatchCallback(this.f4314f, l(DownloadState.DOWNLOADED, str, this.f4313e));
                } else {
                    this.i.handleSchemeDispatchCallback(this.f4314f, l(downloadState, str, this.f4313e));
                }
            }
        }

        public final void x(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048592, this, downloadState, str) == null) && j) {
                Log.d("SwanAdDownloadImpl", "handleResumeDownload");
            }
        }

        public final void y(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, downloadState, str) == null) {
                this.a = this.f4314f;
                this.i.handleSchemeDispatchCallback(this.f4315g, l(downloadState, str, this.f4313e));
                if (downloadState == DownloadState.DOWNLOADED) {
                    this.i.handleSchemeDispatchCallback(this.f4314f, n(true, "onSuccess"));
                    this.a = null;
                }
            }
        }

        public final void z() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.f4310b == null) {
                this.f4310b = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addDataScheme("package");
                this.f4316h.registerReceiver(this.f4310b, intentFilter);
            }
        }

        /* loaded from: classes.dex */
        public class f extends BroadcastReceiver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b this$0;
            public long time;

            public f(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = bVar;
                this.time = 0L;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || intent.getData() == null || !PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                    return;
                }
                if (TextUtils.equals(this.this$0.f4312d, intent.getData().getSchemeSpecificPart())) {
                    b bVar = this.this$0;
                    bVar.i.handleSchemeDispatchCallback(bVar.f4314f, bVar.n(true, null));
                    this.this$0.A();
                }
            }

            public /* synthetic */ f(b bVar, a aVar) {
                this(bVar);
            }
        }
    }

    boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull c.a.n0.h.a.c.f.a aVar);

    boolean e(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean f(Context context, JSONObject jSONObject);
}
