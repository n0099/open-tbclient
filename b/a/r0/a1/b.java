package b.a.r0.a1;

import b.a.e.l.e.n;
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
    public static final BdUniqueId f14668i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14669e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f14670f;

    /* renamed from: g  reason: collision with root package name */
    public String f14671g;

    /* renamed from: h  reason: collision with root package name */
    public String f14672h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1650135886, "Lb/a/r0/a1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1650135886, "Lb/a/r0/a1/b;");
                return;
            }
        }
        f14668i = BdUniqueId.gen();
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14669e : invokeV.intValue;
    }

    public List<a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14670f : (List) invokeV.objValue;
    }

    public void e(Esport esport) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, esport) == null) || esport == null) {
            return;
        }
        this.f14669e = esport.floor_no.intValue();
        EsportStatic esportStatic = esport._static;
        if (esportStatic != null) {
            this.f14671g = esportStatic.img;
            this.f14672h = esportStatic.url;
        }
        this.f14670f = new ArrayList();
        if (!StringUtils.isNull(this.f14671g)) {
            a aVar = new a();
            aVar.i(this.f14671g);
            aVar.j(this.f14672h);
            this.f14670f.add(aVar);
        }
        if (ListUtils.isEmpty(esport.billboard)) {
            return;
        }
        for (EsportRank esportRank : esport.billboard) {
            a aVar2 = new a();
            aVar2.h(esportRank);
            this.f14670f.add(aVar2);
        }
    }

    @Override // b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f14668i : (BdUniqueId) invokeV.objValue;
    }
}
