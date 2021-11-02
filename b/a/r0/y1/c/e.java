package b.a.r0.y1.c;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import b.a.r0.y1.c.k.j;
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
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27308a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27309b;

    /* renamed from: c  reason: collision with root package name */
    public View f27310c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f27311d;

    /* renamed from: e  reason: collision with root package name */
    public HListView f27312e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f27313f;

    /* renamed from: g  reason: collision with root package name */
    public View f27314g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.y1.c.j.g f27315h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.y1.c.j.e f27316i;

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
        this.f27308a = baseFragmentActivity;
        this.f27309b = baseFragmentActivity.getActivity();
        b(view);
    }

    public void a(b.a.r0.y1.c.k.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || iVar == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (iVar.f27435e) {
            this.f27314g.setVisibility(0);
        } else {
            this.f27314g.setVisibility(8);
        }
        List<j> d2 = iVar.d();
        if (d2 != null && d2.size() > 0) {
            bool = Boolean.FALSE;
            if (d2.size() > 8) {
                d2 = d2.subList(0, 7);
            }
            this.f27312e.setVisibility(0);
            this.f27315h.d(d2);
            this.f27315h.notifyDataSetChanged();
        } else {
            this.f27312e.setVisibility(8);
        }
        List<j> e2 = iVar.e();
        if (e2 != null && e2.size() > 0) {
            bool = Boolean.FALSE;
            if (e2.size() > 8) {
                e2 = e2.subList(0, 7);
            }
            this.f27313f.setVisibility(0);
            this.f27316i.d(e2);
            this.f27316i.notifyDataSetChanged();
        } else {
            this.f27313f.setVisibility(8);
        }
        if (bool.booleanValue()) {
            this.f27311d.setVisibility(8);
            return;
        }
        this.f27311d.fillView(iVar.a());
        this.f27311d.findViewById(R.id.divider_line_item).setVisibility(8);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f27310c = view;
        this.f27311d = (CategoryView) view.findViewById(R.id.category);
        this.f27312e = (HListView) this.f27310c.findViewById(R.id.listview_skins);
        this.f27313f = (HListView) this.f27310c.findViewById(R.id.listview_cards);
        this.f27312e.setSelector(R.drawable.list_selector_transparent);
        this.f27313f.setSelector(R.drawable.list_selector_transparent);
        this.f27314g = this.f27310c.findViewById(R.id.divider_sp_line);
        b.a.r0.y1.c.j.g gVar = new b.a.r0.y1.c.j.g(this.f27309b);
        this.f27315h = gVar;
        this.f27312e.setAdapter((ListAdapter) gVar);
        b.a.r0.y1.c.j.e eVar = new b.a.r0.y1.c.j.e(this.f27309b);
        this.f27316i = eVar;
        this.f27313f.setAdapter((ListAdapter) eVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.w0.a.a(this.f27308a.getPageContext(), this.f27310c);
        }
    }
}
