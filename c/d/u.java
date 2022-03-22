package c.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.http.PostRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u implements Reporter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* renamed from: b  reason: collision with root package name */
    public final String f23228b;

    /* loaded from: classes3.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f23229e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar, JSONObject jSONObject) {
            super(uVar, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((u) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23229e = uVar;
            o.j();
        }

        @Override // c.d.u.b
        public void c() {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o.e("key_rpt_suc_c", o.h() + 1);
                u uVar = this.f23229e;
                uVar.getClass();
                int a = o.a();
                int f2 = o.f();
                if (a > 0 || f2 > 0) {
                    int h2 = o.h();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("fai", a);
                        jSONObject.put("suc", h2);
                        jSONObject.put("mis", f2);
                    } catch (JSONException unused) {
                    }
                    dVar = new d(uVar, HostAppInfo.buildReportJson("k_rpt", jSONObject, System.currentTimeMillis()), a, h2, f2);
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    dVar.d();
                }
            }
        }

        @Override // c.d.u.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                o.e("key_rpt_fai_c", o.a() + 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u f23230b;

        public b(u uVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23230b = uVar;
            this.a = jSONObject;
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // c.d.u.c
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d() : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean d() {
            boolean z;
            Response perform;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                try {
                    perform = new PostRequest(this.f23230b.f23228b, new RequestParams(this.a)).perform();
                } catch (IOException e2) {
                    LogPrinter.e(e2);
                }
                if (perform != null) {
                    if (perform.getResponseCode() == 200) {
                        z = true;
                        if (z) {
                            b();
                        } else {
                            c();
                        }
                        return z;
                    }
                }
                z = false;
                if (z) {
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                try {
                    return "Event{key=" + this.a.getString("key") + ", content=" + this.a.getString("content") + '}';
                } catch (JSONException unused) {
                    return "Unknown Event";
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean a();
    }

    /* loaded from: classes3.dex */
    public class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final int f23231c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23232d;

        /* renamed from: e  reason: collision with root package name */
        public final int f23233e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(u uVar, JSONObject jSONObject, int i, int i2, int i3) {
            super(uVar, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, jSONObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((u) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23231c = i;
            this.f23232d = i2;
            this.f23233e = i3;
        }

        @Override // c.d.u.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o.d(this.f23231c, this.f23232d, this.f23233e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f23234c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ u f23235d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(u uVar, JSONObject jSONObject) {
            super(uVar, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((u) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23235d = uVar;
            this.f23234c = 0;
        }

        @Override // c.d.u.b
        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.f23234c;
                int i2 = i + 1;
                this.f23234c = i2;
                if (i < 3) {
                    try {
                        this.a.put(HostAppInfo.RETRY_I, i2);
                    } catch (JSONException unused) {
                    }
                    u uVar = this.f23235d;
                    uVar.a.sendMessageDelayed(uVar.a.obtainMessage(102, this), 2000L);
                    return;
                }
                LogPrinter.e("Give up report event:" + this, new Object[0]);
                e();
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NonNull Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 101) {
                    if (i != 102) {
                        return;
                    }
                    ((c) message.obj).a();
                    return;
                }
                int i2 = message.arg1;
                int h2 = o.h();
                int a = o.a();
                int i3 = (i2 - h2) - a;
                LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i2), Integer.valueOf(h2), Integer.valueOf(a), Integer.valueOf(i3));
                if (i3 > 0) {
                    o.e("key_rpt_mis_c", i3);
                }
            }
        }
    }

    public u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("rep");
        handlerThread.start();
        f fVar = new f(handlerThread.getLooper());
        this.a = fVar;
        this.f23228b = str;
        fVar.obtainMessage(101, o.g(), 0).sendToTarget();
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            logEvent(str, jSONObject);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
            logEvent(str, new JSONObject(map));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            JSONObject buildReportJson = HostAppInfo.buildReportJson(str, jSONObject, System.currentTimeMillis());
            this.a.sendMessageDelayed(this.a.obtainMessage(102, "ad".equals(str) ? new a(this, buildReportJson) : new e(this, buildReportJson)), 0L);
        }
    }
}
