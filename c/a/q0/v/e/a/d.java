package c.a.q0.v.e.a;

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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f f25455a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f25456b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f25457c;

    /* renamed from: d  reason: collision with root package name */
    public e f25458d;

    /* renamed from: e  reason: collision with root package name */
    public h f25459e;

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
        this.f25456b = new ArrayList();
        this.f25455a = fVar;
        this.f25457c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25458d = new e((TbPageContext) this.f25455a, c.a.q0.v.e.b.c.f25469f);
            this.f25459e = new h((TbPageContext) this.f25455a, c.a.q0.v.e.b.c.f25470g);
            this.f25456b.add(this.f25458d);
            this.f25456b.add(this.f25459e);
            this.f25457c.addAdapters(this.f25456b);
        }
    }

    public void b(c.a.q0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            e eVar = this.f25458d;
            if (eVar != null) {
                eVar.j0(cVar);
            }
            h hVar = this.f25459e;
            if (hVar != null) {
                hVar.j0(cVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f25457c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
