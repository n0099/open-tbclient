package b.a.p0.a.p.d;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface o {

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7172a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-382565489, "Lb/a/p0/a/p/d/o$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-382565489, "Lb/a/p0/a/p/d/o$a;");
                    return;
                }
            }
            int[] iArr = new int[DownloadParams.SwanAppDownloadType.values().length];
            f7172a = iArr;
            try {
                iArr[DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7172a[DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7172a[DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7172a[DownloadParams.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7172a[DownloadParams.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7172a[DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements o {
        public static /* synthetic */ Interceptable $ic;
        public static final boolean j;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f7173a;

        /* renamed from: b  reason: collision with root package name */
        public c f7174b;

        /* renamed from: c  reason: collision with root package name */
        public String f7175c;

        /* renamed from: d  reason: collision with root package name */
        public String f7176d;

        /* renamed from: e  reason: collision with root package name */
        public String f7177e;

        /* renamed from: f  reason: collision with root package name */
        public String f7178f;

        /* renamed from: g  reason: collision with root package name */
        public String f7179g;

        /* renamed from: h  reason: collision with root package name */
        public Context f7180h;

        /* renamed from: i  reason: collision with root package name */
        public CallbackHandler f7181i;

        /* loaded from: classes.dex */
        public class a implements b.a.p0.f.i.k.f.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadParams.SwanAppDownloadType f7182a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f7183b;

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
                this.f7183b = bVar;
                this.f7182a = swanAppDownloadType;
            }

            @Override // b.a.p0.f.i.k.f.a
            public void a(int i2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && b.j) {
                    String str = "onProgressChange:" + i2;
                }
            }

            @Override // b.a.p0.f.i.k.f.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    boolean unused = b.j;
                }
            }

            @Override // b.a.p0.f.i.k.f.a
            public void c(DownloadState downloadState, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                    if (b.j) {
                        String str = "onStateChange   onStateChange:" + downloadState + ", onProgressChange:" + i2;
                    }
                    switch (a.f7172a[this.f7182a.ordinal()]) {
                        case 1:
                            this.f7183b.u(downloadState, String.valueOf(i2));
                            return;
                        case 2:
                            this.f7183b.w(downloadState, String.valueOf(i2));
                            return;
                        case 3:
                            this.f7183b.t(String.valueOf(i2));
                            return;
                        case 4:
                            this.f7183b.r();
                            return;
                        case 5:
                            this.f7183b.v(downloadState, String.valueOf(i2));
                            return;
                        case 6:
                            this.f7183b.s();
                            return;
                        default:
                            return;
                    }
                }
            }

            @Override // b.a.p0.f.i.k.f.a
            public void d(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && b.j) {
                    String str2 = "onPackageNameChange:" + str;
                }
            }

            @Override // b.a.p0.f.i.k.f.a
            public String e() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    boolean unused = b.j;
                    return null;
                }
                return (String) invokeV.objValue;
            }

            @Override // b.a.p0.f.i.k.f.a
            public void f(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && b.j) {
                    String str = "onShowButton:" + z;
                }
            }
        }

        /* renamed from: b.a.p0.a.p.d.o$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0336b implements b.a.p0.a.s1.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f7184a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f7185b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f7186c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f7187d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f7188e;

            public C0336b(b bVar, String str, String str2, String str3, boolean z, Context context) {
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
                this.f7184a = str;
                this.f7185b = str2;
                this.f7186c = str3;
                this.f7187d = z;
                this.f7188e = context;
            }

            @Override // b.a.p0.a.s1.f
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.f7184a));
                    String str2 = this.f7184a;
                    request.setDestinationInExternalPublicDir("", str2.substring(str2.lastIndexOf("/") + 1));
                    if (!TextUtils.isEmpty(this.f7185b) && !TextUtils.isEmpty(this.f7186c)) {
                        request.setNotificationVisibility(1);
                        request.setTitle(this.f7185b);
                        request.setDescription(this.f7186c);
                        request.setVisibleInDownloadsUi(true);
                        request.allowScanningByMediaScanner();
                        request.setMimeType("application/vnd.android.package-archive");
                    }
                    DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                    if (downloadManager != null) {
                        downloadManager.enqueue(request);
                        if (this.f7187d) {
                            return;
                        }
                        b.a.p0.a.v2.f.g(this.f7188e, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                    }
                }
            }

            @Override // b.a.p0.a.s1.f
            public void b(int i2, String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && b.j) {
                    String str2 = "onAuthorizedFailed,  errorCode: " + i2 + " errorMsg: " + str;
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-382565458, "Lb/a/p0/a/p/d/o$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-382565458, "Lb/a/p0/a/p/d/o$b;");
                    return;
                }
            }
            j = b.a.p0.a.k.f6397a;
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

        @Override // b.a.p0.a.p.d.o
        public boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull b.a.p0.f.i.k.f.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, jSONObject, swanAppDownloadType, aVar)) == null) ? p(context, jSONObject, swanAppDownloadType, aVar) : invokeLLLL.booleanValue;
        }

        @Override // b.a.p0.a.p.d.o
        public boolean c(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler)) == null) {
                this.f7180h = context;
                this.f7181i = callbackHandler;
                this.f7178f = jSONObject.optString("cb");
                this.f7179g = jSONObject.optString("onProgressUpdate");
                this.f7175c = jSONObject.optString("url");
                this.f7176d = jSONObject.optString("name");
                this.f7177e = String.valueOf(this.f7175c.hashCode());
                if (!TextUtils.isEmpty(this.f7178f) && !TextUtils.isEmpty(this.f7175c)) {
                    if (swanAppDownloadType == SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP) {
                        x();
                    }
                    DownloadParams.SwanAppDownloadType find = DownloadParams.SwanAppDownloadType.find(swanAppDownloadType.getTypeName());
                    return p(context, jSONObject, find, new a(this, find));
                }
                n(false, "Missing parameters");
                return false;
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // b.a.p0.a.p.d.o
        public boolean d(Context context, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject)) == null) ? q(context, jSONObject) : invokeLL.booleanValue;
        }

        @NonNull
        public final String l(DownloadState downloadState, @NonNull String str, @NonNull String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, downloadState, str, str2)) == null) ? m(downloadState, str, str2, -1) : (String) invokeLLL.objValue;
        }

        @NonNull
        public final String m(DownloadState downloadState, @NonNull String str, @NonNull String str2, int i2) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048580, this, downloadState, str, str2, i2)) == null) {
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
            return (interceptable == null || (invokeZL = interceptable.invokeZL(1048581, this, z, str)) == null) ? o(z, str, null) : (String) invokeZL.objValue;
        }

        @NonNull
        public final String o(boolean z, @Nullable String str, @Nullable JSONObject jSONObject) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, jSONObject})) == null) {
                if (str == null) {
                    str = z ? "success" : SmsLoginView.f.l;
                }
                return UnitedSchemeUtility.wrapCallbackParams(jSONObject, z ? 0 : 1001, str).toString();
            }
            return (String) invokeCommon.objValue;
        }

        public final boolean p(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull b.a.p0.f.i.k.f.a aVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, jSONObject, swanAppDownloadType, aVar)) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("type", swanAppDownloadType.getTypeName());
                bundle.putString(PushConstants.PARAMS, jSONObject != null ? jSONObject.toString() : "");
                b.a.p0.a.v1.c.e.a E = b.a.p0.a.v1.c.e.a.E();
                if (E != null) {
                    E.L(bundle, b.a.p0.a.o.h.a.class, new b.a.p0.a.o.h.b(aVar, swanAppDownloadType));
                    return true;
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        public final boolean q(Context context, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, jSONObject)) == null) {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("description");
                boolean optBoolean = jSONObject.optBoolean("autoinstall");
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "download url is empty");
                    return false;
                }
                b.a.p0.a.s1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new C0336b(this, optString, optString2, optString3, optBoolean, context));
                return true;
            }
            return invokeLL.booleanValue;
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f7181i.handleSchemeDispatchCallback(this.f7179g, l(DownloadState.DOWNLOAD_FAILED, "0", this.f7177e));
                this.f7181i.handleSchemeDispatchCallback(this.f7178f, n(true, null));
                String str = this.f7173a;
                if (str != null) {
                    this.f7181i.handleSchemeDispatchCallback(str, n(false, "onStopped"));
                    this.f7173a = null;
                }
            }
        }

        public final void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                boolean z = j;
                String concat = new File(b.a.p0.a.o.h.a.m()).getAbsolutePath().concat("/");
                String concat2 = concat.concat(this.f7177e + ".apk");
                if (new File(concat2).exists()) {
                    x();
                    if (b.a.p0.f.i.r.g.c(concat2, false)) {
                        return;
                    }
                    this.f7181i.handleSchemeDispatchCallback(this.f7178f, n(false, "install apk error"));
                    return;
                }
                this.f7181i.handleSchemeDispatchCallback(this.f7178f, n(false, "Apk Not Found"));
            }
        }

        public final void t(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.f7181i.handleSchemeDispatchCallback(this.f7179g, l(DownloadState.DOWNLOAD_PAUSED, str, this.f7177e));
                this.f7181i.handleSchemeDispatchCallback(this.f7178f, n(true, null));
                String str2 = this.f7173a;
                if (str2 != null) {
                    this.f7181i.handleSchemeDispatchCallback(str2, n(false, MissionEvent.MESSAGE_PAUSE));
                    this.f7173a = null;
                }
            }
        }

        public final void u(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, downloadState, str) == null) {
                this.f7181i.handleSchemeDispatchCallback(this.f7179g, l(downloadState, str, this.f7177e));
                if (downloadState == DownloadState.DOWNLOADED && "-1".equals(str)) {
                    this.f7181i.handleSchemeDispatchCallback(this.f7178f, m(downloadState, str, this.f7177e, DownloadState.DELETED.value()));
                } else if (TextUtils.equals(str, HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP)) {
                    this.f7181i.handleSchemeDispatchCallback(this.f7178f, l(DownloadState.DOWNLOADED, str, this.f7177e));
                } else {
                    this.f7181i.handleSchemeDispatchCallback(this.f7178f, l(downloadState, str, this.f7177e));
                }
            }
        }

        public final void v(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, downloadState, str) == null) {
                boolean z = j;
            }
        }

        public final void w(@NonNull DownloadState downloadState, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, downloadState, str) == null) {
                this.f7173a = this.f7178f;
                this.f7181i.handleSchemeDispatchCallback(this.f7179g, l(downloadState, str, this.f7177e));
                if (downloadState == DownloadState.DOWNLOADED) {
                    this.f7181i.handleSchemeDispatchCallback(this.f7178f, n(true, "onSuccess"));
                    this.f7173a = null;
                }
            }
        }

        public final void x() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f7174b == null) {
                this.f7174b = new c(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                intentFilter.addDataScheme("package");
                this.f7180h.registerReceiver(this.f7174b, intentFilter);
            }
        }

        public void y() {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (cVar = this.f7174b) == null) {
                return;
            }
            this.f7180h.unregisterReceiver(cVar);
            this.f7174b = null;
        }

        /* loaded from: classes.dex */
        public class c extends BroadcastReceiver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b this$0;
            public long time;

            public c(b bVar) {
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
                if (TextUtils.equals(this.this$0.f7176d, intent.getData().getSchemeSpecificPart())) {
                    b bVar = this.this$0;
                    bVar.f7181i.handleSchemeDispatchCallback(bVar.f7178f, bVar.n(true, null));
                    this.this$0.y();
                }
            }

            public /* synthetic */ c(b bVar, a aVar) {
                this(bVar);
            }
        }
    }

    boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull b.a.p0.f.i.k.f.a aVar);

    boolean c(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean d(Context context, JSONObject jSONObject);
}
