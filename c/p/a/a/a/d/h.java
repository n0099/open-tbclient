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
    public String f34443a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34444b;

    /* renamed from: c  reason: collision with root package name */
    public String f34445c;

    /* renamed from: d  reason: collision with root package name */
    public String f34446d;

    /* renamed from: e  reason: collision with root package name */
    public String f34447e;

    /* renamed from: f  reason: collision with root package name */
    public String f34448f;

    /* renamed from: g  reason: collision with root package name */
    public String f34449g;

    /* renamed from: h  reason: collision with root package name */
    public String f34450h;

    /* renamed from: i  reason: collision with root package name */
    public Object f34451i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f34452j;
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
        public String f34453a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f34454b;

        /* renamed from: c  reason: collision with root package name */
        public String f34455c;

        /* renamed from: d  reason: collision with root package name */
        public String f34456d;

        /* renamed from: e  reason: collision with root package name */
        public String f34457e;

        /* renamed from: f  reason: collision with root package name */
        public String f34458f;

        /* renamed from: g  reason: collision with root package name */
        public String f34459g;

        /* renamed from: h  reason: collision with root package name */
        public String f34460h;

        /* renamed from: i  reason: collision with root package name */
        public String f34461i;

        /* renamed from: j  reason: collision with root package name */
        public String f34462j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34443a : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34445c : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34446d : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34447e : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34448f : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34449g : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34450h : (String) invokeV.objValue;
    }

    @Override // c.p.a.a.a.d.c
    public Object j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34451i : invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f34444b : invokeV.booleanValue;
    }

    @Override // c.p.a.a.a.d.c
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f34452j : invokeV.booleanValue;
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
        this.f34443a = bVar.f34453a;
        this.f34444b = bVar.f34454b;
        this.f34445c = bVar.f34455c;
        this.f34446d = bVar.f34456d;
        this.f34447e = bVar.f34457e;
        this.f34448f = bVar.f34458f;
        this.f34449g = bVar.f34459g;
        String unused = bVar.f34460h;
        String unused2 = bVar.f34461i;
        this.f34450h = bVar.f34462j;
        String unused3 = bVar.k;
        this.f34451i = bVar.l;
        this.f34452j = bVar.m;
        boolean unused4 = bVar.n;
        boolean unused5 = bVar.o;
        String unused6 = bVar.p;
        this.k = bVar.q;
    }
}
