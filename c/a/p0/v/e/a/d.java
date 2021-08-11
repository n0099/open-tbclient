package c.a.p0.v.e.a;

import c.a.e.k.e.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f25122a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.e.k.e.a> f25123b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f25124c;

    /* renamed from: d  reason: collision with root package name */
    public e f25125d;

    /* renamed from: e  reason: collision with root package name */
    public h f25126e;

    public d(c.a.e.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeMultiColumnListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25123b = new ArrayList();
        this.f25122a = fVar;
        this.f25124c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25125d = new e((TbPageContext) this.f25122a, c.a.p0.v.e.b.c.f25136f);
            this.f25126e = new h((TbPageContext) this.f25122a, c.a.p0.v.e.b.c.f25137g);
            this.f25123b.add(this.f25125d);
            this.f25123b.add(this.f25126e);
            this.f25124c.addAdapters(this.f25123b);
        }
    }

    public void b(c.a.p0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            e eVar = this.f25125d;
            if (eVar != null) {
                eVar.j0(cVar);
            }
            h hVar = this.f25126e;
            if (hVar != null) {
                hVar.j0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f25124c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
