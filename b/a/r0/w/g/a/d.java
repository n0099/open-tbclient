package b.a.r0.w.g.a;

import b.a.e.m.e.n;
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
    public b.a.e.a.f f26493a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f26494b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f26495c;

    /* renamed from: d  reason: collision with root package name */
    public e f26496d;

    /* renamed from: e  reason: collision with root package name */
    public h f26497e;

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
        this.f26494b = new ArrayList();
        this.f26493a = fVar;
        this.f26495c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26496d = new e((TbPageContext) this.f26493a, b.a.r0.w.g.b.c.f26507f);
            this.f26497e = new h((TbPageContext) this.f26493a, b.a.r0.w.g.b.c.f26508g);
            this.f26494b.add(this.f26496d);
            this.f26494b.add(this.f26497e);
            this.f26495c.addAdapters(this.f26494b);
        }
    }

    public void b(b.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            e eVar2 = this.f26496d;
            if (eVar2 != null) {
                eVar2.i0(eVar);
            }
            h hVar = this.f26497e;
            if (hVar != null) {
                hVar.i0(eVar);
            }
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.f26495c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
