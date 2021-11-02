package b.a.p0.a.a2.n;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3994a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final f<a> f3995e;

        /* renamed from: f  reason: collision with root package name */
        public static final e<a> f3996f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f3997a;

        /* renamed from: b  reason: collision with root package name */
        public int f3998b;

        /* renamed from: c  reason: collision with root package name */
        public int f3999c;

        /* renamed from: d  reason: collision with root package name */
        public int f4000d;

        /* renamed from: b.a.p0.a.a2.n.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0114a extends f<a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0114a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.a2.n.f
            /* renamed from: b */
            public void a(@NonNull a aVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
                    dVar.writeInt(aVar.f3997a);
                    dVar.writeInt(aVar.f3998b);
                    dVar.writeInt(aVar.f3999c);
                    dVar.writeInt(aVar.f4000d);
                }
            }
        }

        /* loaded from: classes.dex */
        public static class b extends e<a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.a2.n.e
            /* renamed from: b */
            public a a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                    a aVar = new a();
                    aVar.f3997a = cVar.readInt();
                    aVar.f3998b = cVar.readInt();
                    aVar.f3999c = cVar.readInt();
                    aVar.f4000d = cVar.readInt();
                    return aVar;
                }
                return (a) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(959177092, "Lb/a/p0/a/a2/n/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(959177092, "Lb/a/p0/a/a2/n/c$a;");
                    return;
                }
            }
            f3995e = new C0114a();
            f3996f = new b();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return b();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
                if (optJSONObject == null) {
                    return b();
                }
                a aVar = new a();
                aVar.f3998b = optJSONObject.optInt("connectSocket", 60000);
                aVar.f3997a = optJSONObject.optInt("request", c());
                aVar.f3998b = optJSONObject.optInt("connectSocket", 60000);
                aVar.f3999c = optJSONObject.optInt("uploadFile");
                aVar.f4000d = optJSONObject.optInt("downloadFile");
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public static a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                boolean z = c.f3994a;
                a aVar = new a();
                aVar.f3997a = 60000;
                aVar.f3998b = 60000;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public static int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b.a.p0.a.c1.a.Z().u() : invokeV.intValue;
        }

        public static int d(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar)) == null) {
                return aVar != null && aVar.f3997a > 0 ? aVar.f3997a : c();
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-262688735, "Lb/a/p0/a/a2/n/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-262688735, "Lb/a/p0/a/a2/n/c;");
                return;
            }
        }
        f3994a = k.f6397a;
    }
}
