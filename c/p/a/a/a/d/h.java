package c.p.a.a.a.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class h implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f34447a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34448b;

    /* renamed from: c  reason: collision with root package name */
    public String f34449c;

    /* renamed from: d  reason: collision with root package name */
    public String f34450d;

    /* renamed from: e  reason: collision with root package name */
    public String f34451e;

    /* renamed from: f  reason: collision with root package name */
    public String f34452f;

    /* renamed from: g  reason: collision with root package name */
    public String f34453g;

    /* renamed from: h  reason: collision with root package name */
    public String f34454h;

    /* renamed from: i  reason: collision with root package name */
    public Object f34455i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f34456j;
    public String k;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f34457a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f34458b;

        /* renamed from: c  reason: collision with root package name */
        public String f34459c;

        /* renamed from: d  reason: collision with root package name */
        public String f34460d;

        /* renamed from: e  reason: collision with root package name */
        public String f34461e;

        /* renamed from: f  reason: collision with root package name */
        public String f34462f;

        /* renamed from: g  reason: collision with root package name */
        public String f34463g;

        /* renamed from: h  reason: collision with root package name */
        public String f34464h;

        /* renamed from: i  reason: collision with root package name */
        public String f34465i;

        /* renamed from: j  reason: collision with root package name */
        public String f34466j;
        public String k;
        public Object l;
        public boolean m;
        public boolean n;
        public boolean o;
        public String p;
        public String q;

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

        public h a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new h(this, null) : (h) invokeV.objValue;
        }
    }

    public /* synthetic */ h(b bVar, a aVar) {
        this(bVar);
    }

    @Override // c.p.a.a.a.d.c
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    @Override // c.p.a.a.a.d.c
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // c.p.a.a.a.d.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34447a : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34449c : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34450d : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34451e : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34452f : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34453g : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34454h : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public Object j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34455i : invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.p.a.a.a.d.c
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f34448b : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.c
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f34456j : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.c
    public JSONObject n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public JSONObject o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public h() {
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

    public h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34447a = bVar.f34457a;
        this.f34448b = bVar.f34458b;
        this.f34449c = bVar.f34459c;
        this.f34450d = bVar.f34460d;
        this.f34451e = bVar.f34461e;
        this.f34452f = bVar.f34462f;
        this.f34453g = bVar.f34463g;
        String unused = bVar.f34464h;
        String unused2 = bVar.f34465i;
        this.f34454h = bVar.f34466j;
        String unused3 = bVar.k;
        this.f34455i = bVar.l;
        this.f34456j = bVar.m;
        boolean unused4 = bVar.n;
        boolean unused5 = bVar.o;
        String unused6 = bVar.p;
        this.k = bVar.q;
    }
}
