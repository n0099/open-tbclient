package b.a.r0.w.g.a;

import b.a.e.l.e.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.a.f f24976a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f24977b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f24978c;

    /* renamed from: d  reason: collision with root package name */
    public e f24979d;

    /* renamed from: e  reason: collision with root package name */
    public h f24980e;

    public d(b.a.e.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
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
        this.f24977b = new ArrayList();
        this.f24976a = fVar;
        this.f24978c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24979d = new e((TbPageContext) this.f24976a, b.a.r0.w.g.b.c.f24990f);
            this.f24980e = new h((TbPageContext) this.f24976a, b.a.r0.w.g.b.c.f24991g);
            this.f24977b.add(this.f24979d);
            this.f24977b.add(this.f24980e);
            this.f24978c.addAdapters(this.f24977b);
        }
    }

    public void b(b.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            e eVar2 = this.f24979d;
            if (eVar2 != null) {
                eVar2.i0(eVar);
            }
            h hVar = this.f24980e;
            if (hVar != null) {
                hVar.i0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f24978c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
