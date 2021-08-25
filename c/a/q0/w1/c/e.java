package c.a.q0.w1.c;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import c.a.q0.w1.c.k.j;
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
    public BaseFragmentActivity f27696a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27697b;

    /* renamed from: c  reason: collision with root package name */
    public View f27698c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f27699d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f27700e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f27701f;

    /* renamed from: g  reason: collision with root package name */
    public View f27702g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.w1.c.j.g f27703h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.w1.c.j.e f27704i;

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
        this.f27696a = baseFragmentActivity;
        this.f27697b = baseFragmentActivity.getActivity();
        b(view);
    }

    public void a(c.a.q0.w1.c.k.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || iVar == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (iVar.f27827e) {
            this.f27702g.setVisibility(0);
        } else {
            this.f27702g.setVisibility(8);
        }
        List<j> c2 = iVar.c();
        if (c2 != null && c2.size() > 0) {
            bool = Boolean.FALSE;
            if (c2.size() > 8) {
                c2 = c2.subList(0, 7);
            }
            this.f27700e.setVisibility(0);
            this.f27703h.d(c2);
            this.f27703h.notifyDataSetChanged();
        } else {
            this.f27700e.setVisibility(8);
        }
        List<j> d2 = iVar.d();
        if (d2 != null && d2.size() > 0) {
            bool = Boolean.FALSE;
            if (d2.size() > 8) {
                d2 = d2.subList(0, 7);
            }
            this.f27701f.setVisibility(0);
            this.f27704i.d(d2);
            this.f27704i.notifyDataSetChanged();
        } else {
            this.f27701f.setVisibility(8);
        }
        if (bool.booleanValue()) {
            this.f27699d.setVisibility(8);
            return;
        }
        this.f27699d.fillView(iVar.b());
        this.f27699d.findViewById(R.id.divider_line_item).setVisibility(8);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f27698c = view;
        this.f27699d = (CategoryView) view.findViewById(R.id.category);
        this.f27700e = (HListView) this.f27698c.findViewById(R.id.listview_skins);
        this.f27701f = (HListView) this.f27698c.findViewById(R.id.listview_cards);
        this.f27700e.setSelector(R.drawable.list_selector_transparent);
        this.f27701f.setSelector(R.drawable.list_selector_transparent);
        this.f27702g = this.f27698c.findViewById(R.id.divider_sp_line);
        c.a.q0.w1.c.j.g gVar = new c.a.q0.w1.c.j.g(this.f27697b);
        this.f27703h = gVar;
        this.f27700e.setAdapter((ListAdapter) gVar);
        c.a.q0.w1.c.j.e eVar = new c.a.q0.w1.c.j.e(this.f27697b);
        this.f27704i = eVar;
        this.f27701f.setAdapter((ListAdapter) eVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.u0.a.a(this.f27696a.getPageContext(), this.f27698c);
        }
    }
}
