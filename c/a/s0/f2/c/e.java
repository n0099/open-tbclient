package c.a.s0.f2.c;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import c.a.s0.f2.c.k.j;
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
    public Context f17283b;

    /* renamed from: c  reason: collision with root package name */
    public View f17284c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f17285d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f17286e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f17287f;

    /* renamed from: g  reason: collision with root package name */
    public View f17288g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.f2.c.j.g f17289h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.f2.c.j.e f17290i;

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
        this.f17283b = baseFragmentActivity.getActivity();
        b(view);
    }

    public void a(c.a.s0.f2.c.k.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || iVar == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (iVar.f17403e) {
            this.f17288g.setVisibility(0);
        } else {
            this.f17288g.setVisibility(8);
        }
        List<j> d2 = iVar.d();
        if (d2 != null && d2.size() > 0) {
            bool = Boolean.FALSE;
            if (d2.size() > 8) {
                d2 = d2.subList(0, 7);
            }
            this.f17286e.setVisibility(0);
            this.f17289h.d(d2);
            this.f17289h.notifyDataSetChanged();
        } else {
            this.f17286e.setVisibility(8);
        }
        List<j> e2 = iVar.e();
        if (e2 != null && e2.size() > 0) {
            bool = Boolean.FALSE;
            if (e2.size() > 8) {
                e2 = e2.subList(0, 7);
            }
            this.f17287f.setVisibility(0);
            this.f17290i.d(e2);
            this.f17290i.notifyDataSetChanged();
        } else {
            this.f17287f.setVisibility(8);
        }
        if (bool.booleanValue()) {
            this.f17285d.setVisibility(8);
            return;
        }
        this.f17285d.fillView(iVar.a());
        this.f17285d.findViewById(R.id.divider_line_item).setVisibility(8);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f17284c = view;
        this.f17285d = (CategoryView) view.findViewById(R.id.category);
        this.f17286e = (HListView) this.f17284c.findViewById(R.id.listview_skins);
        this.f17287f = (HListView) this.f17284c.findViewById(R.id.listview_cards);
        this.f17286e.setSelector(R.drawable.list_selector_transparent);
        this.f17287f.setSelector(R.drawable.list_selector_transparent);
        this.f17288g = this.f17284c.findViewById(R.id.divider_sp_line);
        c.a.s0.f2.c.j.g gVar = new c.a.s0.f2.c.j.g(this.f17283b);
        this.f17289h = gVar;
        this.f17286e.setAdapter((ListAdapter) gVar);
        c.a.s0.f2.c.j.e eVar = new c.a.s0.f2.c.j.e(this.f17283b);
        this.f17290i = eVar;
        this.f17287f.setAdapter((ListAdapter) eVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.w0.a.a(this.a.getPageContext(), this.f17284c);
        }
    }
}
