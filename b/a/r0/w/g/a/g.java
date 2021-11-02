package b.a.r0.w.g.a;

import b.a.e.l.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.a.f f24981a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f24982b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f24983c;

    /* renamed from: d  reason: collision with root package name */
    public f f24984d;

    /* renamed from: e  reason: collision with root package name */
    public c f24985e;

    /* renamed from: f  reason: collision with root package name */
    public a f24986f;

    /* renamed from: g  reason: collision with root package name */
    public b f24987g;

    public g(b.a.e.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24983c = new ArrayList();
        this.f24981a = fVar;
        this.f24982b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f24981a, b.a.r0.w.j.b.a.f25086g);
                this.f24985e = cVar;
                this.f24983c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f24981a, b.a.r0.w.j.b.a.f25086g);
                this.f24984d = fVar;
                this.f24983c.add(fVar);
            }
            this.f24986f = new a((TbPageContext) this.f24981a, b.a.r0.w.g.b.a.f24988e);
            this.f24987g = new b((TbPageContext) this.f24981a, b.a.r0.w.g.b.b.f24989e);
            this.f24983c.add(this.f24986f);
            this.f24983c.add(this.f24987g);
            this.f24982b.addAdapters(this.f24983c);
        }
    }

    public void b(b.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            f fVar = this.f24984d;
            if (fVar != null) {
                fVar.i0(eVar);
            }
            c cVar = this.f24985e;
            if (cVar != null) {
                cVar.i0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f24982b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
