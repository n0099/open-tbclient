package c.a.t0.g2.c;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import c.a.t0.g2.c.k.j;
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
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public Context f17799b;

    /* renamed from: c  reason: collision with root package name */
    public View f17800c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f17801d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f17802e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f17803f;

    /* renamed from: g  reason: collision with root package name */
    public View f17804g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.g2.c.j.g f17805h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.g2.c.j.e f17806i;

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
        this.a = baseFragmentActivity;
        this.f17799b = baseFragmentActivity.getActivity();
        b(view);
    }

    public void a(c.a.t0.g2.c.k.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || iVar == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (iVar.f17916e) {
            this.f17804g.setVisibility(0);
        } else {
            this.f17804g.setVisibility(8);
        }
        List<j> d2 = iVar.d();
        if (d2 != null && d2.size() > 0) {
            bool = Boolean.FALSE;
            if (d2.size() > 8) {
                d2 = d2.subList(0, 7);
            }
            this.f17802e.setVisibility(0);
            this.f17805h.d(d2);
            this.f17805h.notifyDataSetChanged();
        } else {
            this.f17802e.setVisibility(8);
        }
        List<j> e2 = iVar.e();
        if (e2 != null && e2.size() > 0) {
            bool = Boolean.FALSE;
            if (e2.size() > 8) {
                e2 = e2.subList(0, 7);
            }
            this.f17803f.setVisibility(0);
            this.f17806i.d(e2);
            this.f17806i.notifyDataSetChanged();
        } else {
            this.f17803f.setVisibility(8);
        }
        if (bool.booleanValue()) {
            this.f17801d.setVisibility(8);
            return;
        }
        this.f17801d.fillView(iVar.a());
        this.f17801d.findViewById(R.id.divider_line_item).setVisibility(8);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f17800c = view;
        this.f17801d = (CategoryView) view.findViewById(R.id.category);
        this.f17802e = (HListView) this.f17800c.findViewById(R.id.listview_skins);
        this.f17803f = (HListView) this.f17800c.findViewById(R.id.listview_cards);
        this.f17802e.setSelector(R.drawable.list_selector_transparent);
        this.f17803f.setSelector(R.drawable.list_selector_transparent);
        this.f17804g = this.f17800c.findViewById(R.id.divider_sp_line);
        c.a.t0.g2.c.j.g gVar = new c.a.t0.g2.c.j.g(this.f17799b);
        this.f17805h = gVar;
        this.f17802e.setAdapter((ListAdapter) gVar);
        c.a.t0.g2.c.j.e eVar = new c.a.t0.g2.c.j.e(this.f17799b);
        this.f17806i = eVar;
        this.f17803f.setAdapter((ListAdapter) eVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f17800c);
        }
    }
}
