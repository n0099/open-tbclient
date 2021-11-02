package b.a.p0.a.e0.f.f;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import b.a.p0.a.c2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.f1.e.c;
import b.a.p0.a.j2.k;
import b.a.p0.a.j2.p.f;
import b.a.p0.a.k2.g.h;
import b.a.p0.t.g;
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
    public c f4666c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f4667d;

    /* renamed from: e  reason: collision with root package name */
    public int f4668e;

    /* renamed from: b.a.p0.a.e0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0149a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f4670f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4671g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4672h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f4673i;

        public RunnableC0149a(a aVar, Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
            this.f4673i = aVar;
            this.f4669e = context;
            this.f4670f = file;
            this.f4671g = unitedSchemeEntity;
            this.f4672h = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f4673i;
                aVar.q(this.f4669e, aVar.f4666c.f4681b, this.f4673i.f4666c.f4682c, this.f4670f, this.f4671g, this.f4672h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4674e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4675f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4676g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f4677h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4678i;
        public final /* synthetic */ CallbackHandler j;
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
            this.f4674e = context;
            this.f4675f = str;
            this.f4676g = str2;
            this.f4677h = file;
            this.f4678i = unitedSchemeEntity;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.q(this.f4674e, this.f4675f, this.f4676g, this.f4677h, this.f4678i, this.j);
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                c e2 = c.e(optParamsAsJo);
                this.f4666c = e2;
                if (e2 != null && !e2.d()) {
                    l(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
                boolean z = a0.f4160b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.e0.d.b("WirelessDebugAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = b.a.p0.a.e0.f.f.b.b();
            if (b2.exists()) {
                b2.delete();
            }
            this.f4667d = Executors.newFixedThreadPool(4);
            this.f4668e = 0;
            JSONArray jSONArray = this.f4666c.f4686g;
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = this.f4666c.f4686g.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String a2 = this.f4666c.a(i2);
                    if (TextUtils.isEmpty(a2)) {
                        int i3 = this.f4668e + 1;
                        this.f4668e = i3;
                        if (i3 >= length) {
                            b.a.p0.a.e0.d.b("WirelessDebugAction", "Hosts are invalid");
                            p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                        }
                    } else {
                        this.f4667d.execute(new b(this, context, a2, this.f4666c.c(i2), b2, unitedSchemeEntity, callbackHandler));
                    }
                }
                return;
            }
            ExecutorUtilsExt.postOnSerial(new RunnableC0149a(this, context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
        }
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                boolean z = a0.f4160b;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a K = b.a.p0.a.a2.d.g().r().K();
            f fVar = new f();
            fVar.j(K);
            fVar.f6383a = k.m(K.F());
            fVar.f6384b = "launch";
            fVar.f6385c = "adb-debug";
            fVar.f6387e = "download_fail";
            k.onEvent(fVar);
        }
    }

    public final c.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (c.a) ((c.a) ((c.a) new c.a().t0(this.f4666c.f4680a)).y0(false)).N0(this.f4666c.f4683d) : (c.a) invokeV.objValue;
    }

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            String string = h.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                b.a.p0.a.z1.b.f.e.g(context, "IPs are invalid ：" + str).F();
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
        if (r6 >= r4.f4666c.f4686g.length()) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, file, unitedSchemeEntity, callbackHandler}) == null) {
            try {
                Response executeSync = b.a.p0.m.e.a.g().getRequest().url(str).connectionTimeout(1500).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    g.a(executeSync.body().byteStream(), file);
                    Intent c1 = b.a.p0.a.f1.e.c.c1(context, o());
                    c1.putExtra(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, this.f4666c.f4684e);
                    c1.putExtra("slavePreload", this.f4666c.f4685f);
                    c1.putExtra("extraWSUrl", str2);
                    context.startActivity(c1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f4667d != null) {
                        this.f4667d.shutdownNow();
                        this.f4667d = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        boolean z = a0.f4160b;
                        d.d();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                synchronized (this) {
                    if (this.f4666c.f4686g != null) {
                        int i2 = this.f4668e + 1;
                        this.f4668e = i2;
                    }
                    b.a.p0.a.e0.d.b("WirelessDebugAction", "Host IPs are invalid");
                    p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    n();
                }
            }
        }
    }
}
