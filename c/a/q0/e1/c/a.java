package c.a.q0.e1.c;

import c.a.q0.i3.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends c.a.q0.f1.i.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.o1.p.a f16954g;

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
            }
        }
    }

    public final void a() {
        List<Object> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.f17867e) == null) {
            return;
        }
        v.e(list, 2);
    }

    public void b(c.a.q0.o1.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f16954g = aVar;
            d();
            a();
        }
    }

    public final void d() {
        c.a.q0.o1.p.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (aVar = this.f16954g) != null && aVar.d()) {
            List<ICardInfo> e2 = this.f16954g.e();
            ArrayList arrayList = new ArrayList();
            this.f17867e = arrayList;
            arrayList.addAll(e2);
            this.f16954g.a();
            this.f16954g.b();
        }
    }
}
