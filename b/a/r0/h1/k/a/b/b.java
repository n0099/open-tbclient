package b.a.r0.h1.k.a.b;

import b.a.e.m.e.n;
import b.a.e.m.e.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19044a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.e.m.e.a> f19045b;

    /* renamed from: c  reason: collision with root package name */
    public s f19046c;

    /* renamed from: d  reason: collision with root package name */
    public c f19047d;

    /* renamed from: e  reason: collision with root package name */
    public a f19048e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.h1.k.b.b.c f19049f;

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
        this.f19044a = tbPageContext;
        this.f19046c = sVar;
        a();
        this.f19046c.addAdapters(this.f19045b);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19045b = new ArrayList();
            this.f19047d = new c(this.f19044a);
            this.f19048e = new a(this.f19044a);
            this.f19049f = new b.a.r0.h1.k.b.b.c(this.f19044a);
            this.f19045b.add(this.f19047d);
            this.f19045b.add(this.f19048e);
            this.f19045b.add(this.f19049f);
        }
    }

    public void b() {
        s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f19046c) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f19046c.setData(list);
        }
    }
}
