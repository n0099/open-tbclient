package c.a.t0.g1;

import c.a.d.n.e.n;
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
/* loaded from: classes7.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f17898i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f17899e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f17900f;

    /* renamed from: g  reason: collision with root package name */
    public String f17901g;

    /* renamed from: h  reason: collision with root package name */
    public String f17902h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975413105, "Lc/a/t0/g1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(975413105, "Lc/a/t0/g1/b;");
                return;
            }
        }
        f17898i = BdUniqueId.gen();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17899e : invokeV.intValue;
    }

    public List<a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17900f : (List) invokeV.objValue;
    }

    public void e(Esport esport) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, esport) == null) || esport == null) {
            return;
        }
        this.f17899e = esport.floor_no.intValue();
        EsportStatic esportStatic = esport._static;
        if (esportStatic != null) {
            this.f17901g = esportStatic.img;
            this.f17902h = esportStatic.url;
        }
        this.f17900f = new ArrayList();
        if (!StringUtils.isNull(this.f17901g)) {
            a aVar = new a();
            aVar.i(this.f17901g);
            aVar.j(this.f17902h);
            this.f17900f.add(aVar);
        }
        if (ListUtils.isEmpty(esport.billboard)) {
            return;
        }
        for (EsportRank esportRank : esport.billboard) {
            a aVar2 = new a();
            aVar2.h(esportRank);
            this.f17900f.add(aVar2);
        }
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f17898i : (BdUniqueId) invokeV.objValue;
    }
}
