package c.a.p0.c0.g.a;

import c.a.d.o.e.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f13162b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f13163c;

    /* renamed from: d  reason: collision with root package name */
    public e f13164d;

    /* renamed from: e  reason: collision with root package name */
    public h f13165e;

    public d(c.a.d.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdTypeMultiColumnListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13162b = new ArrayList();
        this.a = fVar;
        this.f13163c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13164d = new e((TbPageContext) this.a, c.a.p0.c0.g.b.c.f13172b);
            this.f13165e = new h((TbPageContext) this.a, c.a.p0.c0.g.b.c.f13173c);
            this.f13162b.add(this.f13164d);
            this.f13162b.add(this.f13165e);
            this.f13163c.addAdapters(this.f13162b);
        }
    }

    public void b(c.a.p0.c0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            e eVar2 = this.f13164d;
            if (eVar2 != null) {
                eVar2.b0(eVar);
            }
            h hVar = this.f13165e;
            if (hVar != null) {
                hVar.b0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f13163c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
