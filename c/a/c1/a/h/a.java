package c.a.c1.a.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f2640b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f2641c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2642d;

    /* renamed from: e  reason: collision with root package name */
    public long f2643e;

    /* renamed from: f  reason: collision with root package name */
    public int f2644f;

    /* renamed from: g  reason: collision with root package name */
    public int f2645g;

    /* renamed from: h  reason: collision with root package name */
    public int f2646h;

    /* renamed from: i  reason: collision with root package name */
    public int f2647i;

    /* renamed from: j  reason: collision with root package name */
    public long f2648j;
    public JSONObject k;
    public JSONObject l;

    /* renamed from: c.a.c1.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0109a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ a(b bVar, C0109a c0109a) {
        this(bVar);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2640b : (String) invokeV.objValue;
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (JSONObject) invokeV.objValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (JSONObject) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2647i : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2648j : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2646h : invokeV.intValue;
    }

    public ArrayList<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2641c : (ArrayList) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2645g : invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2643e : invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2644f : invokeV.intValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2642d : invokeV.booleanValue;
    }

    public void m(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.l = jSONObject;
        }
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            this.k = jSONObject;
        }
    }

    public void o(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            this.f2648j = j2;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
        }
    }

    public void q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f2644f = i2;
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
        this.a = bVar.a;
        this.f2643e = bVar.f2652e;
        this.f2640b = bVar.f2649b;
        this.f2641c = bVar.f2650c;
        this.f2642d = bVar.f2651d;
        this.f2645g = bVar.f2653f;
        this.l = bVar.f2657j;
        this.f2647i = bVar.f2654g;
        this.f2648j = bVar.f2656i;
        this.f2646h = bVar.f2655h;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f2649b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f2650c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2651d;

        /* renamed from: e  reason: collision with root package name */
        public long f2652e;

        /* renamed from: f  reason: collision with root package name */
        public int f2653f;

        /* renamed from: g  reason: collision with root package name */
        public int f2654g;

        /* renamed from: h  reason: collision with root package name */
        public int f2655h;

        /* renamed from: i  reason: collision with root package name */
        public long f2656i;

        /* renamed from: j  reason: collision with root package name */
        public JSONObject f2657j;

        public b(String str, ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, arrayList};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = UUID.randomUUID().toString().replace("-", "");
            this.f2652e = System.currentTimeMillis();
            this.f2653f = 0;
            this.f2651d = true;
            this.f2656i = c.a.c1.a.b.b.f().j();
            this.f2654g = c.a.c1.a.b.b.f().k();
            this.f2655h = c.a.c1.a.b.b.f().i();
            this.f2649b = str;
            this.f2650c = arrayList;
        }

        public a k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this, null) : (a) invokeV.objValue;
        }

        public b l(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
                this.f2657j = jSONObject;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b m(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                this.f2656i = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f2655h = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f2653f = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b p(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.f2651d = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b(String str, String str2, ArrayList<String> arrayList, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, arrayList, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f2652e = j2;
            this.f2649b = str2;
            this.f2650c = arrayList;
            this.f2653f = 0;
            this.f2651d = true;
            this.f2656i = c.a.c1.a.b.b.f().j();
            this.f2654g = c.a.c1.a.b.b.f().k();
            this.f2655h = c.a.c1.a.b.b.f().i();
        }
    }
}
