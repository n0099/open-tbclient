package c.a.d0.k.c;

import androidx.core.view.InputDeviceCompat;
import c.a.d0.n.c;
import c.a.d0.n.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.d0.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0026a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.d0.l.a f1770e;

        /* renamed from: c.a.d0.k.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0027a extends c.a.d0.l.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONArray f1771a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0026a f1772b;

            public C0027a(RunnableC0026a runnableC0026a, JSONArray jSONArray) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0026a, jSONArray};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1772b = runnableC0026a;
                this.f1771a = jSONArray;
            }

            @Override // c.a.d0.l.a
            public void a(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                    c.a.d0.l.a aVar = this.f1772b.f1770e;
                    if (aVar != null) {
                        aVar.a(i2, str);
                    }
                    if (i2 == 1) {
                        a.d(this.f1771a);
                    }
                }
            }
        }

        public RunnableC0026a(c.a.d0.l.a aVar) {
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
            this.f1770e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f2 = a.f()) == null) {
                return;
            }
            c.a.d0.k.b.a.a(f2, new C0027a(this, f2));
        }
    }

    public static void a(c.a.d0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, aVar) == null) {
            c.a.d0.m.a.a(new RunnableC0026a(aVar));
        }
    }

    public static synchronized void d(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jSONArray) == null) {
            synchronized (a.class) {
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        c.b(jSONArray.toString(), new File(g.a().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                    }
                }
            }
        }
    }

    public static void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
        } catch (JSONException unused) {
        }
        JSONArray f2 = f();
        if (f2 == null) {
            f2 = new JSONArray();
        }
        f2.put(jSONObject);
        if (f2.length() > 100) {
            f2.remove(0);
        }
        d(f2);
    }

    public static synchronized JSONArray f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            synchronized (a.class) {
                File file = new File(g.a().getFilesDir(), "poly_cashier_commission_record_cache.json");
                JSONArray jSONArray = null;
                if (file.exists()) {
                    try {
                        JSONArray jSONArray2 = new JSONArray(c.d(file));
                        try {
                            file.delete();
                        } catch (JSONException unused) {
                        }
                        jSONArray = jSONArray2;
                    } catch (JSONException unused2) {
                    }
                    return jSONArray;
                }
                return null;
            }
        }
        return (JSONArray) invokeV.objValue;
    }
}
