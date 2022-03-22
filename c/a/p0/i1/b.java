package c.a.p0.i1;

import c.a.d.o.e.n;
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
/* loaded from: classes2.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f15492e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f15493b;

    /* renamed from: c  reason: collision with root package name */
    public String f15494c;

    /* renamed from: d  reason: collision with root package name */
    public String f15495d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1699013897, "Lc/a/p0/i1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1699013897, "Lc/a/p0/i1/b;");
                return;
            }
        }
        f15492e = BdUniqueId.gen();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public List<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15493b : (List) invokeV.objValue;
    }

    public void e(Esport esport) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, esport) == null) || esport == null) {
            return;
        }
        this.a = esport.floor_no.intValue();
        EsportStatic esportStatic = esport._static;
        if (esportStatic != null) {
            this.f15494c = esportStatic.img;
            this.f15495d = esportStatic.url;
        }
        this.f15493b = new ArrayList();
        if (!StringUtils.isNull(this.f15494c)) {
            a aVar = new a();
            aVar.i(this.f15494c);
            aVar.j(this.f15495d);
            this.f15493b.add(aVar);
        }
        if (ListUtils.isEmpty(esport.billboard)) {
            return;
        }
        for (EsportRank esportRank : esport.billboard) {
            a aVar2 = new a();
            aVar2.h(esportRank);
            this.f15493b.add(aVar2);
        }
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f15492e : (BdUniqueId) invokeV.objValue;
    }
}
