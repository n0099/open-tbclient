package c.a.p0.a.e0.f.f;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.f1.e.c;
import c.a.p0.a.f2.e;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.n2.n;
import c.a.p0.a.n2.s.f;
import c.a.p0.a.o2.g.h;
import c.a.p0.w.g;
import com.baidu.android.imsdk.internal.Constants;
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
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f4757c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f4758d;

    /* renamed from: e  reason: collision with root package name */
    public int f4759e;

    /* renamed from: c.a.p0.a.e0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0208a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4760e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f4761f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4762g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4763h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f4764i;

        public RunnableC0208a(a aVar, Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
            this.f4764i = aVar;
            this.f4760e = context;
            this.f4761f = file;
            this.f4762g = unitedSchemeEntity;
            this.f4763h = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f4764i;
                aVar.q(this.f4760e, aVar.f4757c.f4773b, this.f4764i.f4757c.f4774c, this.f4761f, this.f4762g, this.f4763h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4766f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4767g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f4768h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4769i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4770j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ a f4771k;

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
            this.f4771k = aVar;
            this.f4765e = context;
            this.f4766f = str;
            this.f4767g = str2;
            this.f4768h = file;
            this.f4769i = unitedSchemeEntity;
            this.f4770j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4771k.q(this.f4765e, this.f4766f, this.f4767g, this.f4768h, this.f4769i, this.f4770j);
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                c e2 = c.e(optParamsAsJo);
                this.f4757c = e2;
                if (e2 != null && !e2.d()) {
                    l(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
                boolean z = z.f5296b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.a.p0.a.e0.d.c("WirelessDebugAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = c.a.p0.a.e0.f.f.b.b();
            if (b2.exists()) {
                b2.delete();
            }
            this.f4758d = Executors.newFixedThreadPool(4);
            this.f4759e = 0;
            JSONArray jSONArray = this.f4757c.f4778g;
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = this.f4757c.f4778g.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String a = this.f4757c.a(i2);
                    if (TextUtils.isEmpty(a)) {
                        int i3 = this.f4759e + 1;
                        this.f4759e = i3;
                        if (i3 >= length) {
                            c.a.p0.a.e0.d.c("WirelessDebugAction", "Hosts are invalid");
                            p(context, "404");
                        }
                    } else {
                        this.f4758d.execute(new b(this, context, a, this.f4757c.c(i2), b2, unitedSchemeEntity, callbackHandler));
                    }
                }
                return;
            }
            ExecutorUtilsExt.postOnSerial(new RunnableC0208a(this, context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
        }
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                boolean z = z.f5296b;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a V = c.a.p0.a.d2.d.J().r().V();
            f fVar = new f();
            fVar.j(V);
            fVar.a = n.n(V.G());
            fVar.f7113b = "launch";
            fVar.f7114c = "adb-debug";
            fVar.f7116e = "download_fail";
            n.onEvent(fVar);
        }
    }

    public final c.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (c.a) ((c.a) ((c.a) new c.a().v0(this.f4757c.a)).A0(false)).P0(this.f4757c.f4775d) : (c.a) invokeV.objValue;
    }

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            String string = h.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                c.a.p0.a.c2.b.f.e.g(context, "IPs are invalid ：" + str).G();
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
        if (r6 >= r4.f4757c.f4778g.length()) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, file, unitedSchemeEntity, callbackHandler}) == null) {
            try {
                Response executeSync = c.a.p0.p.e.a.g().getRequest().url(str).connectionTimeout(1500).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    g.a(executeSync.body().byteStream(), file);
                    Intent g1 = c.a.p0.a.f1.e.c.g1(context, o());
                    g1.putExtra(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, this.f4757c.f4776e);
                    g1.putExtra("slavePreload", this.f4757c.f4777f);
                    g1.putExtra("extraWSUrl", str2);
                    context.startActivity(g1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f4758d != null) {
                        this.f4758d.shutdownNow();
                        this.f4758d = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        boolean z = z.f5296b;
                        d.d();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                synchronized (this) {
                    if (this.f4757c.f4778g != null) {
                        int i2 = this.f4759e + 1;
                        this.f4759e = i2;
                    }
                    c.a.p0.a.e0.d.c("WirelessDebugAction", "Host IPs are invalid");
                    p(context, "404");
                    n();
                }
            }
        }
    }
}
