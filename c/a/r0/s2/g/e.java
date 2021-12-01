package c.a.r0.s2.g;

import android.view.View;
import c.a.q0.u.n;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.d.m.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f23482b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f23483c;

    /* renamed from: d  reason: collision with root package name */
    public c f23484d;

    /* renamed from: e  reason: collision with root package name */
    public b f23485e;

    /* renamed from: f  reason: collision with root package name */
    public a f23486f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f23482b = tbPageContext;
        this.f23483c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23484d = new c(this.f23482b, n.f13655h);
            this.f23485e = new b(this.f23482b, c.a.r0.s2.h.c.f23494f);
            this.f23486f = new a(this.f23482b.getPageActivity(), c.a.r0.s2.d.f23468h);
            this.a.add(this.f23484d);
            this.a.add(this.f23485e);
            this.a.add(this.f23486f);
            this.f23483c.addAdapters(this.a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.f23483c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.f23483c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<c.a.d.m.e.n> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (hTypeListView = this.f23483c) == null) {
            return;
        }
        hTypeListView.setData(list);
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f23484d.i0(onClickListener);
            this.f23485e.i0(onClickListener);
        }
    }
}
