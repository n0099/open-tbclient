package c.a.t0.p1.k.b.b;

import c.a.d.n.e.n;
import c.a.d.n.e.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.d.n.e.a> f20986b;

    /* renamed from: c  reason: collision with root package name */
    public s f20987c;

    /* renamed from: d  reason: collision with root package name */
    public c f20988d;

    /* renamed from: e  reason: collision with root package name */
    public a f20989e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.p1.k.c.b.c f20990f;

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
        this.a = tbPageContext;
        this.f20987c = sVar;
        a();
        this.f20987c.addAdapters(this.f20986b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20986b = new ArrayList();
            this.f20988d = new c(this.a);
            this.f20989e = new a(this.a);
            this.f20990f = new c.a.t0.p1.k.c.b.c(this.a);
            this.f20986b.add(this.f20988d);
            this.f20986b.add(this.f20989e);
            this.f20986b.add(this.f20990f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f20987c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f20987c.setData(list);
        }
    }
}
