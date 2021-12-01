package c.a.r0.e2.c.k;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes5.dex */
public class q implements c.a.d.m.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f16882h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16883e;

    /* renamed from: f  reason: collision with root package name */
    public d f16884f;

    /* renamed from: g  reason: collision with root package name */
    public List<r> f16885g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1755751345, "Lc/a/r0/e2/c/k/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1755751345, "Lc/a/r0/e2/c/k/q;");
                return;
            }
        }
        f16882h = BdUniqueId.gen();
    }

    public q(VipTaskList vipTaskList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipTaskList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16883e = true;
        if (vipTaskList == null || vipTaskList.item == null) {
            return;
        }
        String str = vipTaskList.card_id;
        d dVar = new d();
        this.f16884f = dVar;
        dVar.f(3);
        this.f16884f.e(vipTaskList.class_name);
        this.f16884f.g(vipTaskList.class_url_name);
        this.f16884f.h(vipTaskList.class_url);
        this.f16885g = new ArrayList();
        for (VipTaskItem vipTaskItem : vipTaskList.item) {
            this.f16885g.add(new r(vipTaskItem));
        }
    }

    public d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16884f : (d) invokeV.objValue;
    }

    public List<r> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16885g : (List) invokeV.objValue;
    }

    @Override // c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f16882h : (BdUniqueId) invokeV.objValue;
    }
}
