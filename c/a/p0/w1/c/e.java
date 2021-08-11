package c.a.p0.w1.c;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import c.a.p0.w1.c.k.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.memberCenter.index.CategoryView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27357a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27358b;

    /* renamed from: c  reason: collision with root package name */
    public View f27359c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f27360d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f27361e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f27362f;

    /* renamed from: g  reason: collision with root package name */
    public View f27363g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.w1.c.j.g f27364h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.w1.c.j.e f27365i;

    public e(View view, BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27357a = baseFragmentActivity;
        this.f27358b = baseFragmentActivity.getActivity();
        b(view);
    }

    public void a(c.a.p0.w1.c.k.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || iVar == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (iVar.f27488e) {
            this.f27363g.setVisibility(0);
        } else {
            this.f27363g.setVisibility(8);
        }
        List<j> c2 = iVar.c();
        if (c2 != null && c2.size() > 0) {
            bool = Boolean.FALSE;
            if (c2.size() > 8) {
                c2 = c2.subList(0, 7);
            }
            this.f27361e.setVisibility(0);
            this.f27364h.d(c2);
            this.f27364h.notifyDataSetChanged();
        } else {
            this.f27361e.setVisibility(8);
        }
        List<j> d2 = iVar.d();
        if (d2 != null && d2.size() > 0) {
            bool = Boolean.FALSE;
            if (d2.size() > 8) {
                d2 = d2.subList(0, 7);
            }
            this.f27362f.setVisibility(0);
            this.f27365i.d(d2);
            this.f27365i.notifyDataSetChanged();
        } else {
            this.f27362f.setVisibility(8);
        }
        if (bool.booleanValue()) {
            this.f27360d.setVisibility(8);
            return;
        }
        this.f27360d.fillView(iVar.b());
        this.f27360d.findViewById(R.id.divider_line_item).setVisibility(8);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f27359c = view;
        this.f27360d = (CategoryView) view.findViewById(R.id.category);
        this.f27361e = (HListView) this.f27359c.findViewById(R.id.listview_skins);
        this.f27362f = (HListView) this.f27359c.findViewById(R.id.listview_cards);
        this.f27361e.setSelector(R.drawable.list_selector_transparent);
        this.f27362f.setSelector(R.drawable.list_selector_transparent);
        this.f27363g = this.f27359c.findViewById(R.id.divider_sp_line);
        c.a.p0.w1.c.j.g gVar = new c.a.p0.w1.c.j.g(this.f27358b);
        this.f27364h = gVar;
        this.f27361e.setAdapter((ListAdapter) gVar);
        c.a.p0.w1.c.j.e eVar = new c.a.p0.w1.c.j.e(this.f27358b);
        this.f27365i = eVar;
        this.f27362f.setAdapter((ListAdapter) eVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.u0.a.a(this.f27357a.getPageContext(), this.f27359c);
        }
    }
}
