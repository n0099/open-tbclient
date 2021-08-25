package c.a.o0.a.e0.f.f;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.a.o0.a.c2.e;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.f1.e.b;
import c.a.o0.a.f1.e.c;
import c.a.o0.a.j2.k;
import c.a.o0.a.j2.p.f;
import c.a.o0.a.k2.g.h;
import c.a.o0.t.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f5262c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f5263d;

    /* renamed from: e  reason: collision with root package name */
    public int f5264e;

    /* renamed from: c.a.o0.a.e0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0152a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f5265e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f5266f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5267g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5268h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f5269i;

        public RunnableC0152a(a aVar, Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5269i = aVar;
            this.f5265e = context;
            this.f5266f = file;
            this.f5267g = unitedSchemeEntity;
            this.f5268h = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f5269i;
                aVar.q(this.f5265e, aVar.f5262c.f5278b, this.f5269i.f5262c.f5279c, this.f5266f, this.f5267g, this.f5268h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f5270e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5271f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5272g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f5273h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5274i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5275j;
        public final /* synthetic */ a k;

        public b(a aVar, Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, str, str2, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = aVar;
            this.f5270e = context;
            this.f5271f = str;
            this.f5272g = str2;
            this.f5273h = file;
            this.f5274i = unitedSchemeEntity;
            this.f5275j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.q(this.f5270e, this.f5271f, this.f5272g, this.f5273h, this.f5274i, this.f5275j);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/wirelessdebuglaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                c e2 = c.e(optParamsAsJo);
                this.f5262c = e2;
                if (e2 != null && !e2.d()) {
                    l(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
                boolean z = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.o0.a.e0.d.b("WirelessDebugAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = c.a.o0.a.e0.f.f.b.b();
            if (b2.exists()) {
                b2.delete();
            }
            this.f5263d = Executors.newFixedThreadPool(4);
            this.f5264e = 0;
            JSONArray jSONArray = this.f5262c.f5283g;
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = this.f5262c.f5283g.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String a2 = this.f5262c.a(i2);
                    if (TextUtils.isEmpty(a2)) {
                        int i3 = this.f5264e + 1;
                        this.f5264e = i3;
                        if (i3 >= length) {
                            c.a.o0.a.e0.d.b("WirelessDebugAction", "Hosts are invalid");
                            p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                        }
                    } else {
                        this.f5263d.execute(new b(this, context, a2, this.f5262c.c(i2), b2, unitedSchemeEntity, callbackHandler));
                    }
                }
                return;
            }
            ExecutorUtilsExt.postOnSerial(new RunnableC0152a(this, context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
        }
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                boolean z = a0.f4738b;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a L = c.a.o0.a.a2.d.g().r().L();
            f fVar = new f();
            fVar.j(L);
            fVar.f7035a = k.m(L.G());
            fVar.f7036b = "launch";
            fVar.f7037c = "adb-debug";
            fVar.f7039e = "download_fail";
            k.onEvent(fVar);
        }
    }

    public final c.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (c.a) ((c.a) ((c.a) new c.a().u0(this.f5262c.f5277a)).z0(false)).O0(this.f5262c.f5280d) : (c.a) invokeV.objValue;
    }

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            String string = h.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                c.a.o0.a.z1.b.f.e.g(context, "IPs are invalid ：" + str).F();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SchemeConfig.getSchemeHead());
            sb.append("://v1/easybrowse/open?url=");
            sb.append(m(string + "?" + str));
            SchemeRouter.invoke(context, sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b0, code lost:
        if (r6 >= r4.f5262c.f5283g.length()) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, file, unitedSchemeEntity, callbackHandler}) == null) {
            try {
                Response executeSync = c.a.o0.m.e.a.g().getRequest().url(str).connectionTimeout(1500).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    g.a(executeSync.body().byteStream(), file);
                    Intent d1 = c.a.o0.a.f1.e.c.d1(context, o());
                    d1.putExtra(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, this.f5262c.f5281e);
                    d1.putExtra("slavePreload", this.f5262c.f5282f);
                    d1.putExtra("extraWSUrl", str2);
                    context.startActivity(d1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f5263d != null) {
                        this.f5263d.shutdownNow();
                        this.f5263d = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        boolean z = a0.f4738b;
                        d.d();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                synchronized (this) {
                    if (this.f5262c.f5283g != null) {
                        int i2 = this.f5264e + 1;
                        this.f5264e = i2;
                    }
                    c.a.o0.a.e0.d.b("WirelessDebugAction", "Host IPs are invalid");
                    p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    n();
                }
            }
        }
    }
}
