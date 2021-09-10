package c.a.r0.v.e.a;

import c.a.e.l.e.n;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f25938a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25939b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f25940c;

    /* renamed from: d  reason: collision with root package name */
    public f f25941d;

    /* renamed from: e  reason: collision with root package name */
    public c f25942e;

    /* renamed from: f  reason: collision with root package name */
    public a f25943f;

    /* renamed from: g  reason: collision with root package name */
    public b f25944g;

    public g(c.a.e.a.f fVar, BdTypeListView bdTypeListView, boolean z) {
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
        this.f25940c = new ArrayList();
        this.f25938a = fVar;
        this.f25939b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                c cVar = new c((TbPageContext) this.f25938a, c.a.r0.v.h.b.a.f26051g);
                this.f25942e = cVar;
                this.f25940c.add(cVar);
            } else {
                f fVar = new f((TbPageContext) this.f25938a, c.a.r0.v.h.b.a.f26051g);
                this.f25941d = fVar;
                this.f25940c.add(fVar);
            }
            this.f25943f = new a((TbPageContext) this.f25938a, c.a.r0.v.e.b.a.f25945e);
            this.f25944g = new b((TbPageContext) this.f25938a, c.a.r0.v.e.b.b.f25946e);
            this.f25940c.add(this.f25943f);
            this.f25940c.add(this.f25944g);
            this.f25939b.addAdapters(this.f25940c);
        }
    }

    public void b(c.a.r0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            f fVar = this.f25941d;
            if (fVar != null) {
                fVar.j0(cVar);
            }
            c cVar2 = this.f25942e;
            if (cVar2 != null) {
                cVar2.j0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.f25939b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
