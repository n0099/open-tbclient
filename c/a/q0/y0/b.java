package c.a.q0.y0;

import c.a.e.l.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
import tbclient.EsportStatic;
/* loaded from: classes4.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f29090i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f29091e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f29092f;

    /* renamed from: g  reason: collision with root package name */
    public String f29093g;

    /* renamed from: h  reason: collision with root package name */
    public String f29094h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(58542983, "Lc/a/q0/y0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(58542983, "Lc/a/q0/y0/b;");
                return;
            }
        }
        f29090i = BdUniqueId.gen();
    }

    public b() {
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

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29091e : invokeV.intValue;
    }

    public List<a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29092f : (List) invokeV.objValue;
    }

    public void d(Esport esport) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, esport) == null) || esport == null) {
            return;
        }
        this.f29091e = esport.floor_no.intValue();
        EsportStatic esportStatic = esport._static;
        if (esportStatic != null) {
            this.f29093g = esportStatic.img;
            this.f29094h = esportStatic.url;
        }
        this.f29092f = new ArrayList();
        if (!StringUtils.isNull(this.f29093g)) {
            a aVar = new a();
            aVar.i(this.f29093g);
            aVar.j(this.f29094h);
            this.f29092f.add(aVar);
        }
        if (ListUtils.isEmpty(esport.billboard)) {
            return;
        }
        for (EsportRank esportRank : esport.billboard) {
            a aVar2 = new a();
            aVar2.h(esportRank);
            this.f29092f.add(aVar2);
        }
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f29090i : (BdUniqueId) invokeV.objValue;
    }
}
