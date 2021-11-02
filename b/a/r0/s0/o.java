package b.a.r0.s0;

import b.a.q0.x.p.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class o extends b.a.q0.x.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static o f23363f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<b.a.q0.x.p.c> f23364e;

    public o() {
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
        this.f23364e = new LinkedList<>();
    }

    public static o e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f23363f == null) {
                synchronized (o.class) {
                    if (f23363f == null) {
                        f23363f = new o();
                    }
                }
            }
            return f23363f;
        }
        return (o) invokeV.objValue;
    }

    @Override // b.a.q0.x.p.a
    public void b(a.InterfaceC0714a interfaceC0714a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, interfaceC0714a) == null) && FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f23364e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f23364e.add(cVar);
                        if (interfaceC0714a != null) {
                            interfaceC0714a.a(cVar);
                        }
                    }
                }
            }
        }
    }

    @Override // b.a.q0.x.p.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // b.a.q0.x.p.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
