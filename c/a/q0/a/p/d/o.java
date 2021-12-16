package c.a.q0.a.p.d;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
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
        public static final /* synthetic */ int[] f7571b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(677341201, "Lc/a/q0/a/p/d/o$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(677341201, "Lc/a/q0/a/p/d/o$a;");
                    return;
                }
            }
            int[] iArr = new int[ISwanApkFetcher.FetchStates.values().length];
            f7571b = iArr;
            try {
                iArr[ISwanApkFetcher.FetchStates.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7571b[ISwanApkFetcher.FetchStates.FETCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7571b[ISwanApkFetcher.FetchStates.FETCH_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7571b[ISwanApkFetcher.FetchStates.FETCHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7571b[ISwanApkFetcher.FetchStates.FETCH_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7571b[ISwanApkFetcher.FetchStates.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7571b[ISwanApkFetcher.FetchStates.DELETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7571b[ISwanApkFetcher.FetchStates.FETCH_PREPARE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7571b[ISwanApkFetcher.FetchStates.WAITING.ordinal()] = 9;
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

        /* renamed from: j  reason: collision with root package name */
        public static final boolean f7572j;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public f f7573b;

        /* renamed from: c  reason: collision with root package name */
        public String f7574c;

        /* renamed from: d  reason: collision with root package name */
        public String f7575d;

        /* renamed from: e  reason: collision with root package name */
        public String f7576e;

        /* renamed from: f  reason: collision with root package name */
        public String f7577f;

        /* renamed from: g  reason: collision with root package name */
        public String f7578g;

        /* renamed from: h  reason: collision with root package name */
        public Context f7579h;

        /* renamed from: i  reason: collision with root package name */
        public CallbackHandler f7580i;

        /* loaded from: classes.dex */
        public class a implements c.a.q0.h.i.k.f.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadParams.SwanAppDownloadType a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f7581b;

            public a(b bVar, DownloadParams.SwanAppDownloadType swanAppDownloadType) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppDownloadType};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7581b = bVar;
                this.a = swanAppDownloadType;
            }

            @Override // c.a.q0.h.i.k.f.a
            public void a(int i2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && b.f7572j) {
                    String str = "onProgressChange:" + i2;
                }
            }

            @Override // c.a.q0.h.i.k.f.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    boolean unused = b.f7572j;
                }
            }

            @Override // c.a.q0.h.i.k.f.a
            public void c(DownloadState downloadState, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                    if (b.f7572j) {
                        String str = "onStateChange   onStateChange:" + downloadState + ", onProgressChange:" + i2;
                    }
                    switch (a.a[this.a.ordinal()]) {
                        case 1:
                            this.f7581b.w(downloadState, String.valueOf(i2));
                            return;
                        case 2:
                            this.f7581b.y(downloadState, String.valueOf(i2));
                            return;
                        case 3:
                            this.f7581b.v(String.valueOf(i2));
                            return;
                        case 4:
                            this.f7581b.t();
                            return;
                        case 5:
                            this.f7581b.x(downloadState, String.valueOf(i2));
                            return;
                        case 6:
                            this.f7581b.u();
                            return;
                        default:
                            return;
                    }
                }
            }

            @Override // c.a.q0.h.i.k.f.a
            public void d(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && b.f7572j) {
                    String str2 = "onPackageNameChange:" + str;
                }
            }

            @Override // c.a.q0.h.i.k.f.a
            public String e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    boolean unused = b.f7572j;
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // c.a.q0.h.i.k.f.a
            public void f(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && b.f7572j) {
                    String str = "onShowButton:" + z;
                }
            }
        }

        /* renamed from: c.a.q0.a.p.d.o$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0436b implements c.a.q0.a.z2.g1.c<ISwanApkFetcher> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7582e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f7583f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f7584g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ boolean f7585h;

            public C0436b(b bVar, String str, String str2, String str3, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2, str3, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7582e = str;
                this.f7583f = str2;
                this.f7584g = str3;
                this.f7585h = z;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(ISwanApkFetcher iSwanApkFetcher) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iSwanApkFetcher) == null) {
                    iSwanApkFetcher.g(this.f7582e, new c.a.q0.a.p.d.s1.a().N(this.f7583f).I(this.f7584g).H(c.a.q0.a.d2.d.J().getAppId()).E(Boolean.valueOf(this.f7585h)));
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements c.a.q0.a.v1.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f7586e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f7587f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f7588g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ boolean f7589h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ Context f7590i;

            public c(b bVar, String str, String str2, String str3, boolean z, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, str2, str3, Boolean.valueOf(z), context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7586e = str;
                this.f7587f = str2;
                this.f7588g = str3;
                this.f7589h = z;
                this.f7590i = context;
            }

            @Override // c.a.q0.a.v1.f
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f7586e));
                    String str2 = Environment.DIRECTORY_DOWNLOADS;
                    String str3 = this.f7586e;
                    request.setDestinationInExternalPublicDir(str2, str3.substring(str3.lastIndexOf("/") + 1));
                    if (!TextUtils.isEmpty(this.f7587f) && !TextUtils.isEmpty(this.f7588g)) {
                        request.setNotificationVisibility(1);
                        request.setTitle(this.f7587f);
                        request.setDescription(this.f7588g);
                        request.setVisibleInDownloadsUi(true);
                        request.allowScanningByMediaScanner();
                        request.setMimeType("application/vnd.android.package-archive");
                    }
                    DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                    if (downloadManager != null) {
                        downloadManager.enqueue(request);
                        if (this.f7589h) {
                            return;
                        }
                        c.a.q0.a.z2.f.g(this.f7590i, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                    }
                }
            }

            @Override // c.a.q0.a.v1.f
            public void b(int i2, String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && b.f7572j) {
                    String str2 = "onAuthorizedFailed,  errorCode: " + i2 + " errorMsg: " + str;
                }
            }
        }

        /* loaded from: classes.dex */
        public class d implements c.a.q0.a.z2.g1.c<ISwanApkFetcher> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f7591e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DownloadParams.SwanAppDownloadType f7592f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.h.i.k.f.a f7593g;

            public d(b bVar, JSONObject jSONObject, DownloadParams.SwanAppDownloadType swanAppDownloadType, c.a.q0.h.i.k.f.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, jSONObject, swanAppDownloadType, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7591e = jSONObject;
                this.f7592f = swanAppDownloadType;
                this.f7593g = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(ISwanApkFetcher iSwanApkFetcher) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iSwanApkFetcher) == null) {
                    String optString = this.f7591e.optString("url");
                    c.a.q0.a.p.d.s1.a G = new c.a.q0.a.p.d.s1.a().L(this.f7591e.optString("name")).H(c.a.q0.a.d2.d.J().getAppId()).F(this.f7591e.optString("contentDisposition")).K(this.f7591e.optString("mimeType")).O(this.f7591e.optString(TTDownloadField.TT_USERAGENT)).E(Boolean.valueOf(this.f7591e.optBoolean("apk_auto_install") || this.f7592f == DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP)).J(this.f7591e.optString("ext_info")).G(this.f7591e.optString("contentLength"));
                    e eVar = new e(optString, this.f7593g, null);
                    iSwanApkFetcher.f(optString, eVar);
                    switch (a.a[this.f7592f.ordinal()]) {
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

            public /* synthetic */ e(String str, c.a.q0.h.i.k.f.a aVar, a aVar2) {
                this(str, aVar);
            }

            public e(String str, c.a.q0.h.i.k.f.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(677341232, "Lc/a/q0/a/p/d/o$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(677341232, "Lc/a/q0/a/p/d/o$b;");
                    return;
                }
            }
            f7572j = c.a.q0.a.k.a;
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public void A() {
            f fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f7573b) == null) {
                return;
            }
            this.f7579h.unregisterReceiver(fVar);
            this.f7573b = null;
        }

        @Override // c.a.q0.a.p.d.o
        public boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull c.a.q0.h.i.k.f.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, swanAppDownloadType, aVar)) == null) ? r(context, jSONObject, swanAppDownloadType, aVar) : invokeLLLL.booleanValue;
        }

        @Override // c.a.q0.a.p.d.o
        public boolean e(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler)) == null) {
                this.f7579h = context;
                this.f7580i = callbackHandler;
                this.f7577f = jSONObject.optString("cb");
                this.f7578g = jSONObject.optString("onProgressUpdate");
                this.f7574c = jSONObject.optString("url");
                this.f7575d = jSONObject.optString("name");
                this.f7576e = String.valueOf(this.f7574c.hashCode());
                if (!TextUtils.isEmpty(this.f7577f) && !TextUtils.isEmpty(this.f7574c)) {
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

        @Override // c.a.q0.a.p.d.o
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
        public final String m(DownloadState downloadState, @NonNull String str, @NonNull String str2, int i2) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048581, this, downloadState, str, str2, i2)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (i2 > 0) {
                        jSONObject.put("state", i2);
                    } else {
                        jSONObject.put("state", downloadState);
                    }
                    jSONObject.put("progress", str);
                    jSONObject.put("fileId", str2);
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

        public final boolean p(c.a.q0.a.z2.g1.c<ISwanApkFetcher> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
                ISwanApkFetcher b2 = c.a.q0.a.c1.a.b();
                boolean C = b2.C();
                if (C && cVar != null) {
                    cVar.onCallback(b2);
                }
                return C;
            }
            return invokeL.booleanValue;
        }

        public final boolean q(DownloadParams.SwanAppDownloadType swanAppDownloadType, JSONObject jSONObject, c.a.q0.h.i.k.f.a aVar) {
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

        public final boolean r(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull c.a.q0.h.i.k.f.a aVar) {
            InterceptResult invokeLLLL;
            c.a.q0.a.y1.c.e.a P;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, jSONObject, swanAppDownloadType, aVar)) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("type", swanAppDownloadType.getTypeName());
                bundle.putString(PushConstants.PARAMS, jSONObject != null ? jSONObject.toString() : "");
                if (!q(swanAppDownloadType, jSONObject, aVar) && (P = c.a.q0.a.y1.c.e.a.P()) != null) {
                    P.W(bundle, c.a.q0.a.o.h.a.class, new c.a.q0.a.o.h.b(aVar, swanAppDownloadType));
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
                    c.a.q0.a.c2.b.f.e.g(AppRuntime.getAppContext(), "download url is empty");
                    return false;
                } else if (p(new C0436b(this, optString, optString2, optString3, optBoolean))) {
                    return true;
                } else {
                    c.a.q0.a.v1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new c(this, optString, optString2, optString3, optBoolean, context));
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                this.f7580i.handleSchemeDispatchCallback(this.f7578g, l(DownloadState.DOWNLOAD_FAILED, "0", this.f7576e));
                this.f7580i.handleSchemeDispatchCallback(this.f7577f, n(true, null));
                String str = this.a;
                if (str != null) {
                    this.f7580i.handleSchemeDispatchCallback(str, n(false, "onStopped"));
                    this.a = null;
                }
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                boolean z = f7572j;
                String concat = new File(c.a.q0.a.o.h.a.m()).getAbsolutePath().concat("/");
                String concat2 = concat.concat(this.f7576e + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                if (new File(concat2).exists()) {
                    z();
                    if (c.a.q0.h.i.s.g.c(concat2, false)) {
                        return;
                    }
                    this.f7580i.handleSchemeDispatchCallback(this.f7577f, n(false, "install apk error"));
                    return;
                }
                this.f7580i.handleSchemeDispatchCallback(this.f7577f, n(false, "Apk Not Found"));
            }
        }

        public final void v(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.f7580i.handleSchemeDispatchCallback(this.f7578g, l(DownloadState.DOWNLOAD_PAUSED, str, this.f7576e));
                this.f7580i.handleSchemeDispatchCallback(this.f7577f, n(true, null));
                String str2 = this.a;
                if (str2 != null) {
                    this.f7580i.handleSchemeDispatchCallback(str2, n(false, MissionEvent.MESSAGE_PAUSE));
                    this.a = null;
                }
            }
        }

        public final void w(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, downloadState, str) == null) {
                this.f7580i.handleSchemeDispatchCallback(this.f7578g, l(downloadState, str, this.f7576e));
                if (downloadState == DownloadState.DOWNLOADED && "-1".equals(str)) {
                    this.f7580i.handleSchemeDispatchCallback(this.f7577f, m(downloadState, str, this.f7576e, DownloadState.DELETED.value()));
                } else if (TextUtils.equals(str, HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP)) {
                    this.f7580i.handleSchemeDispatchCallback(this.f7577f, l(DownloadState.DOWNLOADED, str, this.f7576e));
                } else {
                    this.f7580i.handleSchemeDispatchCallback(this.f7577f, l(downloadState, str, this.f7576e));
                }
            }
        }

        public final void x(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, downloadState, str) == null) {
                boolean z = f7572j;
            }
        }

        public final void y(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, downloadState, str) == null) {
                this.a = this.f7577f;
                this.f7580i.handleSchemeDispatchCallback(this.f7578g, l(downloadState, str, this.f7576e));
                if (downloadState == DownloadState.DOWNLOADED) {
                    this.f7580i.handleSchemeDispatchCallback(this.f7577f, n(true, "onSuccess"));
                    this.a = null;
                }
            }
        }

        public final void z() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.f7573b == null) {
                this.f7573b = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addDataScheme("package");
                this.f7579h.registerReceiver(this.f7573b, intentFilter);
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                if (TextUtils.equals(this.this$0.f7575d, intent.getData().getSchemeSpecificPart())) {
                    b bVar = this.this$0;
                    bVar.f7580i.handleSchemeDispatchCallback(bVar.f7577f, bVar.n(true, null));
                    this.this$0.A();
                }
            }

            public /* synthetic */ f(b bVar, a aVar) {
                this(bVar);
            }
        }
    }

    boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull c.a.q0.h.i.k.f.a aVar);

    boolean e(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean f(Context context, JSONObject jSONObject);
}
