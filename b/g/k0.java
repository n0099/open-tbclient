package b.g;

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
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k0 extends i0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f31176c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31177d;

    /* loaded from: classes6.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k0 f31178e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k0 k0Var, JSONObject jSONObject) {
            super(k0Var, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((k0) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31178e = k0Var;
            v.h();
        }

        @Override // b.g.k0.b
        public void c() {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v.d("key_rpt_suc_c", v.g() + 1);
                k0 k0Var = this.f31178e;
                k0Var.getClass();
                int a2 = v.a();
                int e2 = v.e();
                if (a2 > 0 || e2 > 0) {
                    int g2 = v.g();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("fai", a2);
                        jSONObject.put("suc", g2);
                        jSONObject.put("mis", e2);
                    } catch (JSONException unused) {
                    }
                    dVar = new d(k0Var, g0.b("k_rpt", jSONObject, System.currentTimeMillis()), a2, g2, e2);
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    dVar.d();
                }
            }
        }

        @Override // b.g.k0.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                v.d("key_rpt_fai_c", v.a() + 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final JSONObject f31179a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k0 f31180b;

        public b(k0 k0Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31180b = k0Var;
            this.f31179a = jSONObject;
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // b.g.k0.c
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

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                boolean z = false;
                try {
                    if (new j0(this.f31180b.f31177d, new n0(this.f31179a.toString(), e0.f31136b), false).a().f31224a == 200) {
                        z = true;
                    }
                } catch (IOException e2) {
                    LogPrinter.e(e2);
                }
                if (z) {
                    c();
                } else {
                    b();
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
                    return "Event{key=" + this.f31179a.getString("key") + ", content=" + this.f31179a.getString("content") + ExtendedMessageFormat.END_FE;
                } catch (JSONException unused) {
                    return "Unknown Event";
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        boolean a();
    }

    /* loaded from: classes6.dex */
    public class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final int f31181c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31182d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31183e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k0 k0Var, JSONObject jSONObject, int i2, int i3, int i4) {
            super(k0Var, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, jSONObject, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((k0) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31181c = i2;
            this.f31182d = i3;
            this.f31183e = i4;
        }

        @Override // b.g.k0.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v.c(this.f31181c, this.f31182d, this.f31183e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f31184c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k0 f31185d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(k0 k0Var, JSONObject jSONObject) {
            super(k0Var, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((k0) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31185d = k0Var;
            this.f31184c = 0;
        }

        @Override // b.g.k0.b
        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f31184c;
                int i3 = i2 + 1;
                this.f31184c = i3;
                if (i2 < 3) {
                    try {
                        this.f31179a.put("retry_i", i3);
                    } catch (JSONException unused) {
                    }
                    k0 k0Var = this.f31185d;
                    k0Var.f31176c.sendMessageDelayed(k0Var.f31176c.obtainMessage(102, this), 2000L);
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

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i2 = message.what;
                if (i2 != 101) {
                    if (i2 != 102) {
                        return;
                    }
                    ((c) message.obj).a();
                    return;
                }
                int i3 = message.arg1;
                int g2 = v.g();
                int a2 = v.a();
                int i4 = (i3 - g2) - a2;
                LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i3), Integer.valueOf(g2), Integer.valueOf(a2), Integer.valueOf(i4));
                if (i4 > 0) {
                    v.d("key_rpt_mis_c", i4);
                }
            }
        }
    }

    public k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("rep");
        handlerThread.start();
        f fVar = new f(handlerThread.getLooper());
        this.f31176c = fVar;
        this.f31177d = str;
        fVar.obtainMessage(101, v.f(), 0).sendToTarget();
    }

    @Override // b.g.i0
    public void b(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            d(str, jSONObject);
        }
    }

    @Override // b.g.i0
    public void c(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
            d(str, new JSONObject(map));
        }
    }

    @Override // b.g.i0
    public void d(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            JSONObject b2 = g0.b(str, jSONObject, System.currentTimeMillis());
            this.f31176c.sendMessageDelayed(this.f31176c.obtainMessage(102, "ad".equals(str) ? new a(this, b2) : new e(this, b2)), 0L);
        }
    }
}
