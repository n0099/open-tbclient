package c.a.q0.k2.g;

import android.view.View;
import c.a.e.l.e.n;
import c.a.p0.u.m;
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
    public List<c.a.e.l.e.a> f21497a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f21498b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f21499c;

    /* renamed from: d  reason: collision with root package name */
    public c f21500d;

    /* renamed from: e  reason: collision with root package name */
    public b f21501e;

    /* renamed from: f  reason: collision with root package name */
    public a f21502f;

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
        this.f21497a = new ArrayList();
        this.f21498b = tbPageContext;
        this.f21499c = hTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21500d = new c(this.f21498b, m.f15040h);
            this.f21501e = new b(this.f21498b, c.a.q0.k2.h.c.f21511f);
            this.f21502f = new a(this.f21498b.getPageActivity(), c.a.q0.k2.d.f21480h);
            this.f21497a.add(this.f21500d);
            this.f21497a.add(this.f21501e);
            this.f21497a.add(this.f21502f);
            this.f21499c.addAdapters(this.f21497a);
        }
    }

    public void b() {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hTypeListView = this.f21499c) != null && (hTypeListView.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.f21499c.getAdapter()).notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (hTypeListView = this.f21499c) == null) {
            return;
        }
        hTypeListView.setData(list);
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f21500d.j0(onClickListener);
            this.f21501e.j0(onClickListener);
        }
    }
}
