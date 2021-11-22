package b.a.p0.a.u.e.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import b.a.p0.a.r2.a.a;
import b.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends b.a.p0.a.u.e.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8851a;

        /* renamed from: b.a.p0.a.u.e.n.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0438a implements a.InterfaceC0380a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f8852a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ m f8853b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f8854c;

            public C0438a(a aVar, String str, m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8854c = aVar;
                this.f8852a = str;
                this.f8853b = mVar;
            }

            @Override // b.a.p0.a.r2.a.a.InterfaceC0380a
            public void a(double[] dArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                    if (dArr == null || dArr.length != 3) {
                        this.f8854c.f8851a.p("illegal accelerometers", null, true);
                        this.f8854c.f8851a.d(this.f8852a, new b.a.p0.a.u.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("x", dArr[0]);
                        jSONObject.put("y", dArr[1]);
                        jSONObject.put("z", dArr[2]);
                        this.f8853b.d(this.f8854c.f8851a, jSONObject);
                    } catch (JSONException e2) {
                        this.f8854c.f8851a.p("json put data fail", e2, true);
                        this.f8853b.f(this.f8854c.f8851a, "json put data fail");
                    }
                }
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8851a = bVar;
        }

        @Override // b.a.p0.a.u.c.d.a
        public b.a.p0.a.u.h.b a(b.a.p0.a.d2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                m mVar = new m("accelerometerChange", jSONObject, str);
                b.a.p0.a.r2.a.a a2 = b.a.p0.a.r2.a.a.a();
                a2.b(this.f8851a.getContext(), C0439b.a(jSONObject.optString("interval")));
                a2.e(new C0438a(this, str, mVar));
                a2.f();
                mVar.b(this.f8851a);
                return b.a.p0.a.u.h.b.f();
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* renamed from: b.a.p0.a.u.e.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0439b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static ArrayMap<String, Integer> f8855a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1831431594, "Lb/a/p0/a/u/e/n/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1831431594, "Lb/a/p0/a/u/e/n/b$b;");
                    return;
                }
            }
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            f8855a = arrayMap;
            arrayMap.put(IMTrackDatabase.UiEnum.TABLE_NAME, 60);
            f8855a.put("game", 20);
            f8855a.put("normal", 200);
        }

        public static int a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                Integer num = f8855a.get(str);
                if (num != null) {
                    return num.intValue();
                }
                return 200;
            }
            return invokeL.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public b.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#startAccelerometer", false);
            return l(str, true, new a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#stopAccelerometer", true);
            b.a.p0.a.r2.a.a.a().g();
            return b.a.p0.a.u.h.b.f();
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "AccelerometerApi" : (String) invokeV.objValue;
    }
}
