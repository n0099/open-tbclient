package c.a.q0.h0.e;

import c.a.e.e.l.d;
import c.a.e.e.p.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f13478a;

    /* renamed from: b  reason: collision with root package name */
    public String f13479b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13480c;

    /* renamed from: d  reason: collision with root package name */
    public String f13481d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13482e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13483f;

    /* renamed from: g  reason: collision with root package name */
    public b f13484g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.e.l.c<c.a.e.l.d.a> f13485h;

    /* renamed from: c.a.q0.h0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0669a extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13486a;

        public C0669a(a aVar) {
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
            this.f13486a = aVar;
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // c.a.e.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                if (aVar != null && str != null) {
                    if (str.equals(this.f13486a.f13479b)) {
                        this.f13486a.f13480c = true;
                    } else if (str.equals(this.f13486a.f13481d)) {
                        this.f13486a.f13482e = true;
                    }
                }
                if (this.f13486a.f13480c && this.f13486a.f13482e) {
                    this.f13486a.f13483f = true;
                }
                if (this.f13486a.f13484g == null || !this.f13486a.f13483f) {
                    return;
                }
                this.f13486a.f13484g.a();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13485h = new C0669a(this);
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 45;
        }
        return invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13479b : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13481d : (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13483f : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String str = this.f13479b;
            if (str != null && !k.isEmpty(str)) {
                d.h().k(this.f13479b, j(), this.f13485h, 0, 0, this.f13478a, new Object[0]);
            }
            String str2 = this.f13481d;
            if (str2 == null || k.isEmpty(str2)) {
                return;
            }
            d.h().k(this.f13481d, j(), this.f13485h, 0, 0, this.f13478a, new Object[0]);
        }
    }

    public void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            this.f13479b = jSONObject.optString("pic_before");
            this.f13481d = jSONObject.optString("pic_after");
        }
    }

    public void p(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f13484g = bVar;
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.f13478a = bdUniqueId;
        }
    }
}
