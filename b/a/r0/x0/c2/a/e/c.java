package b.a.r0.x0.c2.a.e;

import b.a.e.l.e.n;
import b.a.e.l.e.w;
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
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.a.f f25660a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f25661b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f25662c;

    /* renamed from: d  reason: collision with root package name */
    public b f25663d;

    public c(b.a.e.a.f fVar, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25662c = new ArrayList();
        this.f25660a = fVar;
        this.f25661b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = new b((TbPageContext) this.f25660a, b.a.r0.x0.c2.a.a.b.f25622f);
            this.f25663d = bVar;
            this.f25662c.add(bVar);
            this.f25661b.addAdapters(this.f25662c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.f25661b.getAdapter2() instanceof b.a.e.l.e.e)) {
            this.f25661b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar) == null) {
            for (b.a.e.l.e.a aVar : this.f25662c) {
                if (aVar != null) {
                    aVar.c0(wVar);
                }
            }
        }
    }

    public void d(List<n> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (bdTypeListView = this.f25661b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
