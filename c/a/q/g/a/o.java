package c.a.q.g.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.q.h.d.a;
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
/* loaded from: classes5.dex */
public class o implements j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public a.C0742a f11422b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11423c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11424d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11425e;

        /* renamed from: f  reason: collision with root package name */
        public long f11426f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f11427g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f11428h;

        /* renamed from: i  reason: collision with root package name */
        public long f11429i;

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
            this.f11422b = new c.a.q.h.d.a(context.getApplicationContext()).d().f("cloud").f("cstore");
        }

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f11427g = jSONObject;
                h();
            }
        }

        public final boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
            InterceptResult invokeLL;
            JSONArray jSONArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, jSONObject2)) == null) {
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
                return o.c(jSONArray, jSONArray2) || m.c(jSONObject, jSONObject2, "oid") || m.c(jSONObject, jSONObject2, Config.GAID) || m.c(jSONObject, jSONObject2, "iid") || m.c(jSONObject, jSONObject2, "adrid") || m.c(jSONObject, jSONObject2, "aid");
            }
            return invokeLL.booleanValue;
        }

        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.f11428h = jSONObject;
            }
        }

        public final synchronized boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this) {
                    JSONObject jSONObject = this.f11427g;
                    if (jSONObject == null) {
                        return true;
                    }
                    JSONObject jSONObject2 = this.f11428h;
                    if (jSONObject2 != null) {
                        return b(jSONObject, jSONObject2);
                    }
                    throw new IllegalArgumentException("you forgot invoke methond :IMatchConditions.setComparedCStoreParams before ");
                }
            }
            return invokeV.booleanValue;
        }

        public final long e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject jSONObject = this.f11427g;
                if (jSONObject == null) {
                    return 0L;
                }
                return jSONObject.optLong("ctime", 0L);
            }
            return invokeV.longValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.abs(System.currentTimeMillis() - this.f11429i) / 1000 > this.f11426f : invokeV.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
            if (d() != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this) {
                    i();
                    l();
                    boolean i2 = c.a.q.b.f(this.a).i();
                    boolean z = false;
                    if (this.f11423c && i2) {
                        if (this.f11427g == null) {
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

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                try {
                    this.f11422b.i("cs.dat", this.f11427g.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final synchronized void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (this) {
                    if (this.f11424d) {
                        this.f11424d = !j();
                    }
                    if (this.f11425e) {
                        this.f11425e = !k();
                    }
                }
            }
        }

        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("isOn", this.f11423c);
                    this.f11422b.i("ci.dat", jSONObject.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("TIME_OUT", this.f11426f);
                    this.f11422b.i("ct.dat", jSONObject.toString(), true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                m();
                o();
                n();
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                try {
                    this.f11427g = n.a(this.f11422b.g("cs.dat", true));
                    this.f11429i = e();
                } catch (Exception unused) {
                    this.f11429i = 0L;
                }
            }
        }

        public final void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                try {
                    JSONObject a = n.a(this.f11422b.g("ci.dat", true));
                    if (a == null) {
                        this.f11423c = true;
                    } else {
                        this.f11423c = a.optBoolean("isOn", true);
                    }
                } catch (Exception unused) {
                    this.f11423c = true;
                }
            }
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                try {
                    JSONObject a = n.a(this.f11422b.g("ct.dat", true));
                    if (a == null) {
                        this.f11426f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                    } else {
                        this.f11426f = a.optLong("TIME_OUT", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME);
                    }
                } catch (Exception unused) {
                    this.f11426f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                }
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
        if (this.a == null) {
            this.a = new a(this, context.getApplicationContext());
        }
    }

    public static boolean c(JSONArray jSONArray, JSONArray jSONArray2) {
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
                if (m.c(optJSONObject, optJSONObject2, "pkg") || m.c(optJSONObject, optJSONObject2, "aid") || m.b(optJSONObject, optJSONObject2, "priority")) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.q.g.a.j
    public j a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            this.a.c(jSONObject);
            return this;
        }
        return (j) invokeL.objValue;
    }

    @Override // c.a.q.g.a.j
    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            this.a.a(jSONObject);
        }
    }

    @Override // c.a.q.g.a.j
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.g() : invokeV.booleanValue;
    }
}
