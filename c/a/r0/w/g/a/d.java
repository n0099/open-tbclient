package c.a.r0.w.g.a;

import c.a.e.l.e.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f26131a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f26132b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f26133c;

    /* renamed from: d  reason: collision with root package name */
    public e f26134d;

    /* renamed from: e  reason: collision with root package name */
    public h f26135e;

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
        this.f26132b = new ArrayList();
        this.f26131a = fVar;
        this.f26133c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26134d = new e((TbPageContext) this.f26131a, c.a.r0.w.g.b.c.f26145f);
            this.f26135e = new h((TbPageContext) this.f26131a, c.a.r0.w.g.b.c.f26146g);
            this.f26132b.add(this.f26134d);
            this.f26132b.add(this.f26135e);
            this.f26133c.addAdapters(this.f26132b);
        }
    }

    public void b(c.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            e eVar2 = this.f26134d;
            if (eVar2 != null) {
                eVar2.j0(eVar);
            }
            h hVar = this.f26135e;
            if (hVar != null) {
                hVar.j0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f26133c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
