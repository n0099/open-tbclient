package c.a.r0.g1.k.a.b;

import c.a.e.l.e.n;
import c.a.e.l.e.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18466a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.e.l.e.a> f18467b;

    /* renamed from: c  reason: collision with root package name */
    public s f18468c;

    /* renamed from: d  reason: collision with root package name */
    public c f18469d;

    /* renamed from: e  reason: collision with root package name */
    public a f18470e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.g1.k.b.b.c f18471f;

    public b(TbPageContext tbPageContext, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18466a = tbPageContext;
        this.f18468c = sVar;
        a();
        this.f18468c.addAdapters(this.f18467b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18467b = new ArrayList();
            this.f18469d = new c(this.f18466a);
            this.f18470e = new a(this.f18466a);
            this.f18471f = new c.a.r0.g1.k.b.b.c(this.f18466a);
            this.f18467b.add(this.f18469d);
            this.f18467b.add(this.f18470e);
            this.f18467b.add(this.f18471f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f18468c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f18468c.setData(list);
        }
    }
}
