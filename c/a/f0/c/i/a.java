package c.a.f0.c.i;

import androidx.core.view.InputDeviceCompat;
import c.a.f0.i.f;
import c.a.f0.i.l;
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

    /* renamed from: c.a.f0.c.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0132a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.f.a f3284e;

        /* renamed from: c.a.f0.c.i.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0133a extends c.a.f0.f.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONArray a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0132a f3285b;

            public C0133a(RunnableC0132a runnableC0132a, JSONArray jSONArray) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0132a, jSONArray};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3285b = runnableC0132a;
                this.a = jSONArray;
            }

            @Override // c.a.f0.f.a
            public void a(int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                    c.a.f0.f.a aVar = this.f3285b.f3284e;
                    if (aVar != null) {
                        aVar.a(i2, str);
                    }
                    if (i2 == 1) {
                        a.e(this.a);
                    }
                }
            }
        }

        public RunnableC0132a(c.a.f0.f.a aVar) {
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
            this.f3284e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = a.c()) == null) {
                return;
            }
            c.a.f0.c.h.a.d(c2, new C0133a(this, c2));
        }
    }

    public static synchronized JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                File file = new File(l.a().getFilesDir(), "poly_cashier_commission_record_cache.json");
                JSONArray jSONArray = null;
                if (file.exists()) {
                    try {
                        JSONArray jSONArray2 = new JSONArray(f.b(file));
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

    public static void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
        } catch (JSONException unused) {
        }
        JSONArray c2 = c();
        if (c2 == null) {
            c2 = new JSONArray();
        }
        c2.put(jSONObject);
        if (c2.length() > 100) {
            c2.remove(0);
        }
        e(c2);
    }

    public static synchronized void e(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray) == null) {
            synchronized (a.class) {
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        f.d(jSONArray.toString(), new File(l.a().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                    }
                }
            }
        }
    }

    public static void f(c.a.f0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, aVar) == null) {
            c.a.f0.h.a.a(new RunnableC0132a(aVar));
        }
    }
}
