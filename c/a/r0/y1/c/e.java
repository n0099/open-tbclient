package c.a.r0.y1.c;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import c.a.r0.y1.c.k.j;
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
    public BaseFragmentActivity f28579a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28580b;

    /* renamed from: c  reason: collision with root package name */
    public View f28581c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f28582d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f28583e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f28584f;

    /* renamed from: g  reason: collision with root package name */
    public View f28585g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.y1.c.j.g f28586h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.y1.c.j.e f28587i;

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
        this.f28579a = baseFragmentActivity;
        this.f28580b = baseFragmentActivity.getActivity();
        b(view);
    }

    public void a(c.a.r0.y1.c.k.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || iVar == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (iVar.f28710e) {
            this.f28585g.setVisibility(0);
        } else {
            this.f28585g.setVisibility(8);
        }
        List<j> c2 = iVar.c();
        if (c2 != null && c2.size() > 0) {
            bool = Boolean.FALSE;
            if (c2.size() > 8) {
                c2 = c2.subList(0, 7);
            }
            this.f28583e.setVisibility(0);
            this.f28586h.d(c2);
            this.f28586h.notifyDataSetChanged();
        } else {
            this.f28583e.setVisibility(8);
        }
        List<j> d2 = iVar.d();
        if (d2 != null && d2.size() > 0) {
            bool = Boolean.FALSE;
            if (d2.size() > 8) {
                d2 = d2.subList(0, 7);
            }
            this.f28584f.setVisibility(0);
            this.f28587i.d(d2);
            this.f28587i.notifyDataSetChanged();
        } else {
            this.f28584f.setVisibility(8);
        }
        if (bool.booleanValue()) {
            this.f28582d.setVisibility(8);
            return;
        }
        this.f28582d.fillView(iVar.b());
        this.f28582d.findViewById(R.id.divider_line_item).setVisibility(8);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f28581c = view;
        this.f28582d = (CategoryView) view.findViewById(R.id.category);
        this.f28583e = (HListView) this.f28581c.findViewById(R.id.listview_skins);
        this.f28584f = (HListView) this.f28581c.findViewById(R.id.listview_cards);
        this.f28583e.setSelector(R.drawable.list_selector_transparent);
        this.f28584f.setSelector(R.drawable.list_selector_transparent);
        this.f28585g = this.f28581c.findViewById(R.id.divider_sp_line);
        c.a.r0.y1.c.j.g gVar = new c.a.r0.y1.c.j.g(this.f28580b);
        this.f28586h = gVar;
        this.f28583e.setAdapter((ListAdapter) gVar);
        c.a.r0.y1.c.j.e eVar = new c.a.r0.y1.c.j.e(this.f28580b);
        this.f28587i = eVar;
        this.f28584f.setAdapter((ListAdapter) eVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f28579a.getPageContext(), this.f28581c);
        }
    }
}
