package b.a.q0.h0.e;

import b.a.e.e.l.d;
import b.a.e.e.p.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f12623a;

    /* renamed from: b  reason: collision with root package name */
    public String f12624b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12625c;

    /* renamed from: d  reason: collision with root package name */
    public String f12626d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12627e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12628f;

    /* renamed from: g  reason: collision with root package name */
    public b f12629g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.e.l.c<b.a.e.l.d.a> f12630h;

    /* renamed from: b.a.q0.h0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0663a extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f12631a;

        public C0663a(a aVar) {
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
            this.f12631a = aVar;
        }

        @Override // b.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // b.a.e.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                if (aVar != null && str != null) {
                    if (str.equals(this.f12631a.f12624b)) {
                        this.f12631a.f12625c = true;
                    } else if (str.equals(this.f12631a.f12626d)) {
                        this.f12631a.f12627e = true;
                    }
                }
                if (this.f12631a.f12625c && this.f12631a.f12627e) {
                    this.f12631a.f12628f = true;
                }
                if (this.f12631a.f12629g == null || !this.f12631a.f12628f) {
                    return;
                }
                this.f12631a.f12629g.a();
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
        this.f12630h = new C0663a(this);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12624b : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12626d : (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12628f : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String str = this.f12624b;
            if (str != null && !k.isEmpty(str)) {
                d.h().k(this.f12624b, j(), this.f12630h, 0, 0, this.f12623a, new Object[0]);
            }
            String str2 = this.f12626d;
            if (str2 == null || k.isEmpty(str2)) {
                return;
            }
            d.h().k(this.f12626d, j(), this.f12630h, 0, 0, this.f12623a, new Object[0]);
        }
    }

    public void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            this.f12624b = jSONObject.optString("pic_before");
            this.f12626d = jSONObject.optString("pic_after");
        }
    }

    public void p(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f12629g = bVar;
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.f12623a = bdUniqueId;
        }
    }
}
