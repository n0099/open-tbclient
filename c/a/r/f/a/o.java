package c.a.r.f.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.r.g.d.a;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o implements j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f29250a;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f29251a;

        /* renamed from: b  reason: collision with root package name */
        public a.C1372a f29252b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29253c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f29254d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f29255e;

        /* renamed from: f  reason: collision with root package name */
        public long f29256f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f29257g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f29258h;

        /* renamed from: i  reason: collision with root package name */
        public long f29259i;

        public a(o oVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            this.f29252b = new c.a.r.g.d.a(context.getApplicationContext()).d().f("cloud").f("cstore");
        }

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f29258h = jSONObject;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
            if (e() != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    n();
                    o();
                    boolean h2 = c.a.r.b.e(this.f29251a).h();
                    boolean z = false;
                    if (this.f29253c && h2) {
                        if (this.f29257g == null) {
                            return true;
                        }
                        if (!f()) {
                        }
                        z = true;
                        return z;
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
            InterceptResult invokeLL;
            JSONArray jSONArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, jSONObject2)) == null) {
                JSONArray jSONArray2 = null;
                try {
                    jSONArray = m.a(jSONObject.optJSONArray(Config.SID), "pkg");
                    try {
                        jSONArray2 = m.a(jSONObject2.optJSONArray(Config.SID), "pkg");
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONArray = null;
                }
                return o.b(jSONArray, jSONArray2) || m.b(jSONObject, jSONObject2, "oid") || m.b(jSONObject, jSONObject2, Config.GAID) || m.b(jSONObject, jSONObject2, "iid") || m.b(jSONObject, jSONObject2, "adrid") || m.b(jSONObject, jSONObject2, "aid");
            }
            return invokeLL.booleanValue;
        }

        public void d(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
                this.f29257g = jSONObject;
                k();
            }
        }

        public final synchronized boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    if (this.f29257g == null) {
                        return true;
                    }
                    if (this.f29258h != null) {
                        return c(this.f29257g, this.f29258h);
                    }
                    throw new IllegalArgumentException("you forgot invoke methond :IMatchConditions.setComparedCStoreParams before ");
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.abs(System.currentTimeMillis() - this.f29259i) / 1000 > this.f29256f : invokeV.booleanValue;
        }

        public final long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                JSONObject jSONObject = this.f29257g;
                if (jSONObject == null) {
                    return 0L;
                }
                return jSONObject.optLong("ctime", 0L);
            }
            return invokeV.longValue;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                try {
                    this.f29257g = n.a(this.f29252b.g("cs.dat", true));
                    this.f29259i = g();
                } catch (Exception unused) {
                    this.f29259i = 0L;
                }
            }
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                try {
                    JSONObject a2 = n.a(this.f29252b.g("ct.dat", true));
                    if (a2 == null) {
                        this.f29256f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                    } else {
                        this.f29256f = a2.optLong("TIME_OUT", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME);
                    }
                } catch (Exception unused) {
                    this.f29256f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                }
            }
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                try {
                    JSONObject a2 = n.a(this.f29252b.g("ci.dat", true));
                    if (a2 == null) {
                        this.f29253c = true;
                    } else {
                        this.f29253c = a2.optBoolean("isOn", true);
                    }
                } catch (Exception unused) {
                    this.f29253c = true;
                }
            }
        }

        public final boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                try {
                    this.f29252b.i("cs.dat", this.f29257g.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("isOn", this.f29253c);
                    this.f29252b.i("ci.dat", jSONObject.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("TIME_OUT", this.f29256f);
                    this.f29252b.i("ct.dat", jSONObject.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final synchronized void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                synchronized (this) {
                    boolean z = true;
                    if (this.f29254d) {
                        this.f29254d = !l();
                    }
                    if (this.f29255e) {
                        if (m()) {
                            z = false;
                        }
                        this.f29255e = z;
                    }
                }
            }
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                h();
                i();
                j();
            }
        }
    }

    public o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new NullPointerException("context should not be null");
        }
        if (this.f29250a == null) {
            this.f29250a = new a(this, context.getApplicationContext());
        }
    }

    public static boolean b(JSONArray jSONArray, JSONArray jSONArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONArray, jSONArray2)) == null) {
            int length = jSONArray == null ? 0 : jSONArray.length();
            if (length != (jSONArray2 == null ? 0 : jSONArray2.length())) {
                return true;
            }
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                JSONObject optJSONObject2 = jSONArray2.optJSONObject(i2);
                if (m.b(optJSONObject, optJSONObject2, "pkg") || m.b(optJSONObject, optJSONObject2, "aid") || m.c(optJSONObject, optJSONObject2, "priority")) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.r.f.a.j
    public j a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            this.f29250a.a(jSONObject);
            return this;
        }
        return (j) invokeL.objValue;
    }

    @Override // c.a.r.f.a.j
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29250a.b() : invokeV.booleanValue;
    }

    @Override // c.a.r.f.a.j
    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            this.f29250a.d(jSONObject);
        }
    }
}
