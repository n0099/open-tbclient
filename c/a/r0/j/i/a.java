package c.a.r0.j.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.n2.n;
import c.a.r0.a.n2.s.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.h.i.k.f.a f11173e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a.y.b.a f11174f;

    /* renamed from: g  reason: collision with root package name */
    public String f11175g;

    /* renamed from: c.a.r0.j.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0758a implements c.a.r0.h.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0758a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.r0.h.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                b bVar = new b();
                bVar.progress = i2;
                JSEvent jSEvent = new JSEvent("ProgressChange");
                jSEvent.data = bVar;
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                d dVar = new d();
                dVar.state = downloadState.value();
                JSEvent jSEvent = new JSEvent("StateChange");
                jSEvent.data = dVar;
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.f11175g : (String) invokeV.objValue;
        }

        @Override // c.a.r0.h.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(JSRuntime jSRuntime, c.a.r0.a.y.b.a aVar) {
        super(jSRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11174f = aVar;
        if (y()) {
            this.f11173e = new C0758a(this);
            c.a.r0.j.u.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.f11173e);
        }
    }

    public final boolean A(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (context != null) {
                try {
                    if (context.getPackageManager() != null) {
                        return context.getPackageManager().getPackageInfo(str, 0) != null;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void B(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || queryIntentActivities.iterator().next() == null) {
            return;
        }
        String str2 = queryIntentActivities.iterator().next().activityInfo.name;
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setComponent(new ComponentName(str, str2));
        intent2.setFlags(270532608);
        try {
            context.startActivity(intent2);
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void deleteDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.j.u.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD, this.f11173e);
        }
    }

    @JavascriptInterface
    public void installApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.j.u.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.f11173e);
        }
    }

    @JavascriptInterface
    public void openApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            B(AppRuntime.getAppContext(), this.f11175g);
        }
    }

    @JavascriptInterface
    public void pauseDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.j.u.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f11173e);
        }
    }

    @JavascriptInterface
    public void resumeDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.r0.j.u.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD, this.f11173e);
        }
    }

    @JavascriptInterface
    public void startDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.j.u.a.f().a(AppRuntime.getAppContext(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f11173e);
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.f11175g = c.a.r0.j.u.a.f().getPackageName();
            if (!c.a.r0.j.u.a.f().c()) {
                c.a.r0.j.d.c.b bVar = new c.a.r0.j.d.c.b();
                bVar.errMsg = "download url is empty";
                c.a.r0.j.n0.c.call(this.f11174f, false, bVar);
                z("reallyDownloadNull", this.f11175g);
                return false;
            } else if (A(AppRuntime.getAppContext(), this.f11175g)) {
                c.a.r0.j.d.c.b bVar2 = new c.a.r0.j.d.c.b();
                bVar2.errMsg = "apk has installed";
                c.a.r0.j.n0.c.call(this.f11174f, false, bVar2);
                z("reallyHasInstalled", this.f11175g);
                return false;
            } else {
                c cVar = new c();
                cVar.statusCode = 0;
                cVar.packageName = this.f11175g;
                c.a.r0.j.n0.c.call(this.f11174f, true, cVar);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            e eVar = new e();
            eVar.f8119b = str;
            eVar.a = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
            eVar.a("targetPackageName", str2);
            n.g(eVar);
        }
    }
}
