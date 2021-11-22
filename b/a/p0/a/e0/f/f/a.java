package b.a.p0.a.e0.f.f;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.f1.e.c;
import b.a.p0.a.f2.e;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.n2.n;
import b.a.p0.a.n2.s.f;
import b.a.p0.a.o2.g.h;
import b.a.p0.w.g;
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
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f4636c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f4637d;

    /* renamed from: e  reason: collision with root package name */
    public int f4638e;

    /* renamed from: b.a.p0.a.e0.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0152a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f4640f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4641g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4642h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f4643i;

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
            this.f4643i = aVar;
            this.f4639e = context;
            this.f4640f = file;
            this.f4641g = unitedSchemeEntity;
            this.f4642h = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f4643i;
                aVar.q(this.f4639e, aVar.f4636c.f4651b, this.f4643i.f4636c.f4652c, this.f4640f, this.f4641g, this.f4642h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4645f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4646g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f4647h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4648i;
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
            this.f4644e = context;
            this.f4645f = str;
            this.f4646g = str2;
            this.f4647h = file;
            this.f4648i = unitedSchemeEntity;
            this.j = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.q(this.f4644e, this.f4645f, this.f4646g, this.f4647h, this.f4648i, this.j);
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                c e2 = c.e(optParamsAsJo);
                this.f4636c = e2;
                if (e2 != null && !e2.d()) {
                    l(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
                boolean z = z.f5228b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            b.a.p0.a.e0.d.c("WirelessDebugAction", "param is null");
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
            this.f4637d = Executors.newFixedThreadPool(4);
            this.f4638e = 0;
            JSONArray jSONArray = this.f4636c.f4656g;
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = this.f4636c.f4656g.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String a2 = this.f4636c.a(i2);
                    if (TextUtils.isEmpty(a2)) {
                        int i3 = this.f4638e + 1;
                        this.f4638e = i3;
                        if (i3 >= length) {
                            b.a.p0.a.e0.d.c("WirelessDebugAction", "Hosts are invalid");
                            p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                        }
                    } else {
                        this.f4637d.execute(new b(this, context, a2, this.f4636c.c(i2), b2, unitedSchemeEntity, callbackHandler));
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
                boolean z = z.f5228b;
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a V = b.a.p0.a.d2.d.J().r().V();
            f fVar = new f();
            fVar.j(V);
            fVar.f7379a = n.n(V.G());
            fVar.f7380b = "launch";
            fVar.f7381c = "adb-debug";
            fVar.f7383e = "download_fail";
            n.onEvent(fVar);
        }
    }

    public final c.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (c.a) ((c.a) ((c.a) new c.a().v0(this.f4636c.f4650a)).A0(false)).P0(this.f4636c.f4653d) : (c.a) invokeV.objValue;
    }

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            String string = h.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                b.a.p0.a.c2.b.f.e.g(context, "IPs are invalid ：" + str).G();
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
        if (r6 >= r4.f4636c.f4656g.length()) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, file, unitedSchemeEntity, callbackHandler}) == null) {
            try {
                Response executeSync = b.a.p0.p.e.a.g().getRequest().url(str).connectionTimeout(1500).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    g.a(executeSync.body().byteStream(), file);
                    Intent g1 = b.a.p0.a.f1.e.c.g1(context, o());
                    g1.putExtra(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, this.f4636c.f4654e);
                    g1.putExtra("slavePreload", this.f4636c.f4655f);
                    g1.putExtra("extraWSUrl", str2);
                    context.startActivity(g1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f4637d != null) {
                        this.f4637d.shutdownNow();
                        this.f4637d = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        boolean z = z.f5228b;
                        d.d();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                synchronized (this) {
                    if (this.f4636c.f4656g != null) {
                        int i2 = this.f4638e + 1;
                        this.f4638e = i2;
                    }
                    b.a.p0.a.e0.d.c("WirelessDebugAction", "Host IPs are invalid");
                    p(context, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH);
                    n();
                }
            }
        }
    }
}
