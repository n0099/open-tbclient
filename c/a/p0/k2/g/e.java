package c.a.p0.k2.g;

import android.view.View;
import c.a.e.k.e.n;
import c.a.o0.u.m;
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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<c.a.e.k.e.a> f21167a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f21168b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f21169c;

    /* renamed from: d  reason: collision with root package name */
    public c f21170d;

    /* renamed from: e  reason: collision with root package name */
    public b f21171e;

    /* renamed from: f  reason: collision with root package name */
    public a f21172f;

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
        this.f21167a = new ArrayList();
        this.f21168b = tbPageContext;
        this.f21169c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21170d = new c(this.f21168b, m.f14729h);
            this.f21171e = new b(this.f21168b, c.a.p0.k2.h.c.f21181f);
            this.f21172f = new a(this.f21168b.getPageActivity(), c.a.p0.k2.d.f21150h);
            this.f21167a.add(this.f21170d);
            this.f21167a.add(this.f21171e);
            this.f21167a.add(this.f21172f);
            this.f21169c.addAdapters(this.f21167a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.f21169c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.f21169c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (hTypeListView = this.f21169c) == null) {
            return;
        }
        hTypeListView.setData(list);
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f21170d.j0(onClickListener);
            this.f21171e.j0(onClickListener);
        }
    }
}
