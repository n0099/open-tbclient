package c.a.r0.x1.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.a.r0.x1.c.k.q;
import c.a.r0.x1.c.k.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.CategoryView;
import com.baidu.tieba.memberCenter.index.TaskItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f28439a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f28440b;

    /* renamed from: c  reason: collision with root package name */
    public Context f28441c;

    /* renamed from: d  reason: collision with root package name */
    public View f28442d;

    /* renamed from: e  reason: collision with root package name */
    public CategoryView f28443e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f28444f;

    /* renamed from: g  reason: collision with root package name */
    public TaskItemView f28445g;

    /* renamed from: h  reason: collision with root package name */
    public TaskItemView f28446h;

    /* renamed from: i  reason: collision with root package name */
    public TaskItemView f28447i;

    /* renamed from: j  reason: collision with root package name */
    public View f28448j;

    public i(View view, BaseFragmentActivity baseFragmentActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, baseFragmentActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28439a = baseFragmentActivity;
        this.f28441c = baseFragmentActivity.getActivity();
        this.f28440b = onClickListener;
        b(view);
    }

    public void a(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        if (qVar.f28579e) {
            this.f28448j.setVisibility(0);
        } else {
            this.f28448j.setVisibility(8);
        }
        this.f28443e.fillView(qVar.b());
        List<r> c2 = qVar.c();
        if (c2 == null || c2.size() <= 0) {
            return;
        }
        int size = c2.size();
        if (size == 1) {
            this.f28445g.renderView(c2.get(0));
            this.f28445g.hideDivideLine();
            this.f28445g.setVisibility(0);
            this.f28446h.setVisibility(8);
            this.f28447i.setVisibility(8);
        } else if (size != 2) {
            this.f28445g.renderView(c2.get(0));
            this.f28446h.renderView(c2.get(1));
            this.f28447i.renderView(c2.get(2));
            this.f28447i.hideDivideLine();
            this.f28445g.setVisibility(0);
            this.f28446h.setVisibility(0);
            this.f28447i.setVisibility(0);
        } else {
            this.f28445g.renderView(c2.get(0));
            this.f28446h.renderView(c2.get(1));
            this.f28446h.hideDivideLine();
            this.f28445g.setVisibility(0);
            this.f28446h.setVisibility(0);
            this.f28447i.setVisibility(8);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f28442d = view;
        this.f28443e = (CategoryView) view.findViewById(R.id.category);
        this.f28444f = (LinearLayout) this.f28442d.findViewById(R.id.ly_items);
        this.f28445g = (TaskItemView) this.f28442d.findViewById(R.id.task_view_one);
        this.f28446h = (TaskItemView) this.f28442d.findViewById(R.id.task_view_two);
        this.f28447i = (TaskItemView) this.f28442d.findViewById(R.id.task_view_three);
        this.f28445g.setOnCommenClickListener(this.f28440b);
        this.f28446h.setOnCommenClickListener(this.f28440b);
        this.f28447i.setOnCommenClickListener(this.f28440b);
        this.f28448j = this.f28442d.findViewById(R.id.divider_sp_line);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f28439a.getPageContext(), this.f28442d);
        }
    }
}
