package a.a.a.a.y.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends a.a.a.a.y.f.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f1385b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1386c;

    /* loaded from: classes.dex */
    public class a extends C0005e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f1387e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, JSONObject jSONObject) {
            super(eVar, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((e) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1387e = eVar;
            a.a.a.a.y.b.d();
        }

        @Override // a.a.a.a.y.f.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.y.b.a("key_rpt_suc_c", a.a.a.a.y.b.c() + 1);
                e eVar = this.f1387e;
                d dVar = null;
                if (eVar != null) {
                    int a2 = a.a.a.a.y.b.a();
                    int i2 = a.a.a.a.y.b.f1371a.getInt("key_rpt_mis_c", 0);
                    if (a2 > 0 || i2 > 0) {
                        int b2 = a.a.a.a.y.b.b();
                        int c2 = a.a.a.a.y.b.c();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(ContentUtil.REQ_KEY_REQ, b2);
                            jSONObject.put("fai", a2);
                            jSONObject.put("suc", c2);
                            jSONObject.put("mis", i2);
                        } catch (JSONException unused) {
                        }
                        dVar = new d(eVar, a.a.a.a.y.f.c.a("k_rpt", jSONObject, System.currentTimeMillis()), b2, a2, c2, i2);
                    }
                    if (dVar != null) {
                        dVar.a();
                        return;
                    }
                    return;
                }
                throw null;
            }
        }

        @Override // a.a.a.a.y.f.e.C0005e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.a.a.a.y.b.a("key_rpt_fai_c", a.a.a.a.y.b.a() + 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final JSONObject f1388a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f1389b;

        public b(e eVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1389b = eVar;
            this.f1388a = jSONObject;
            if (FunAdSdk.isLogEnabled()) {
                a.a.a.a.y.d.c("report Event:" + this, new Object[0]);
            }
        }

        @Override // a.a.a.a.y.f.e.c
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
                    a.a.a.a.w.f a2 = new a.a.a.a.w.c(this.f1389b.f1386c, new a.a.a.a.w.e(this.f1388a)).a();
                    if (a2 != null) {
                        if (a2.f1363a == 200) {
                            z = true;
                        }
                    }
                } catch (IOException e2) {
                    a.a.a.a.y.d.a(e2);
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
                    return "Event{key=" + this.f1388a.getString("key") + ", content=" + this.f1388a.getString("content") + '}';
                } catch (JSONException unused) {
                    return "Unknown Event";
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a();
    }

    /* loaded from: classes.dex */
    public class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final int f1390c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1391d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1392e;

        /* renamed from: f  reason: collision with root package name */
        public final int f1393f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, JSONObject jSONObject, int i2, int i3, int i4, int i5) {
            super(eVar, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((e) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1390c = i2;
            this.f1391d = i3;
            this.f1392e = i4;
            this.f1393f = i5;
        }

        @Override // a.a.a.a.y.f.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.y.b.a(this.f1390c, this.f1391d, this.f1392e, this.f1393f);
            }
        }
    }

    /* renamed from: a.a.a.a.y.f.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0005e extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f1394c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f1395d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0005e(e eVar, JSONObject jSONObject) {
            super(eVar, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((e) objArr2[0], (JSONObject) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1395d = eVar;
            this.f1394c = 0;
        }

        @Override // a.a.a.a.y.f.e.b
        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f1394c;
                int i3 = i2 + 1;
                this.f1394c = i3;
                if (i2 < 3) {
                    try {
                        this.f1388a.put("retry_i", i3);
                    } catch (JSONException unused) {
                    }
                    e eVar = this.f1395d;
                    eVar.f1385b.sendMessageDelayed(eVar.f1385b.obtainMessage(102, this), 2000L);
                    return;
                }
                a.a.a.a.y.d.b("Give up report event:" + this, new Object[0]);
                e();
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
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
                int c2 = a.a.a.a.y.b.c();
                int a2 = a.a.a.a.y.b.a();
                int i4 = (i3 - c2) - a2;
                a.a.a.a.y.d.a("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i3), Integer.valueOf(c2), Integer.valueOf(a2), Integer.valueOf(i4));
                if (i4 > 0) {
                    a.a.a.a.y.b.a("key_rpt_mis_c", i4);
                }
            }
        }
    }

    public e(String str) {
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
        this.f1385b = new f(handlerThread.getLooper());
        this.f1386c = str;
        this.f1385b.obtainMessage(101, a.a.a.a.y.b.b(), 0).sendToTarget();
    }

    @Override // a.a.a.a.y.f.d
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            a(str, jSONObject);
        }
    }

    @Override // a.a.a.a.y.f.d
    public void a(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
            a(str, new JSONObject(map));
        }
    }

    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            JSONObject a2 = a.a.a.a.y.f.c.a(str, jSONObject, System.currentTimeMillis());
            this.f1385b.sendMessageDelayed(this.f1385b.obtainMessage(102, "ad".equals(str) ? new a(this, a2) : new C0005e(this, a2)), 0L);
        }
    }
}
