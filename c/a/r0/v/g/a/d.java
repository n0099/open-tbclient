package c.a.r0.v.g.a;

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
    public c.a.e.a.f f25956a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f25957b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f25958c;

    /* renamed from: d  reason: collision with root package name */
    public e f25959d;

    /* renamed from: e  reason: collision with root package name */
    public h f25960e;

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
        this.f25957b = new ArrayList();
        this.f25956a = fVar;
        this.f25958c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25959d = new e((TbPageContext) this.f25956a, c.a.r0.v.g.b.c.f25970f);
            this.f25960e = new h((TbPageContext) this.f25956a, c.a.r0.v.g.b.c.f25971g);
            this.f25957b.add(this.f25959d);
            this.f25957b.add(this.f25960e);
            this.f25958c.addAdapters(this.f25957b);
        }
    }

    public void b(c.a.r0.v.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            e eVar2 = this.f25959d;
            if (eVar2 != null) {
                eVar2.j0(eVar);
            }
            h hVar = this.f25960e;
            if (hVar != null) {
                hVar.j0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f25958c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
