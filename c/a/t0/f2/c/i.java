package c.a.t0.f2.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.a.t0.f2.c.k.q;
import c.a.t0.f2.c.k.r;
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
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f17389b;

    /* renamed from: c  reason: collision with root package name */
    public Context f17390c;

    /* renamed from: d  reason: collision with root package name */
    public View f17391d;

    /* renamed from: e  reason: collision with root package name */
    public CategoryView f17392e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17393f;

    /* renamed from: g  reason: collision with root package name */
    public TaskItemView f17394g;

    /* renamed from: h  reason: collision with root package name */
    public TaskItemView f17395h;

    /* renamed from: i  reason: collision with root package name */
    public TaskItemView f17396i;

    /* renamed from: j  reason: collision with root package name */
    public View f17397j;

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
        this.a = baseFragmentActivity;
        this.f17390c = baseFragmentActivity.getActivity();
        this.f17389b = onClickListener;
        b(view);
    }

    public void a(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        if (qVar.f17516e) {
            this.f17397j.setVisibility(0);
        } else {
            this.f17397j.setVisibility(8);
        }
        this.f17392e.fillView(qVar.a());
        List<r> d2 = qVar.d();
        if (d2 == null || d2.size() <= 0) {
            return;
        }
        int size = d2.size();
        if (size == 1) {
            this.f17394g.renderView(d2.get(0));
            this.f17394g.hideDivideLine();
            this.f17394g.setVisibility(0);
            this.f17395h.setVisibility(8);
            this.f17396i.setVisibility(8);
        } else if (size != 2) {
            this.f17394g.renderView(d2.get(0));
            this.f17395h.renderView(d2.get(1));
            this.f17396i.renderView(d2.get(2));
            this.f17396i.hideDivideLine();
            this.f17394g.setVisibility(0);
            this.f17395h.setVisibility(0);
            this.f17396i.setVisibility(0);
        } else {
            this.f17394g.renderView(d2.get(0));
            this.f17395h.renderView(d2.get(1));
            this.f17395h.hideDivideLine();
            this.f17394g.setVisibility(0);
            this.f17395h.setVisibility(0);
            this.f17396i.setVisibility(8);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f17391d = view;
        this.f17392e = (CategoryView) view.findViewById(R.id.category);
        this.f17393f = (LinearLayout) this.f17391d.findViewById(R.id.ly_items);
        this.f17394g = (TaskItemView) this.f17391d.findViewById(R.id.task_view_one);
        this.f17395h = (TaskItemView) this.f17391d.findViewById(R.id.task_view_two);
        this.f17396i = (TaskItemView) this.f17391d.findViewById(R.id.task_view_three);
        this.f17394g.setOnCommenClickListener(this.f17389b);
        this.f17395h.setOnCommenClickListener(this.f17389b);
        this.f17396i.setOnCommenClickListener(this.f17389b);
        this.f17397j = this.f17391d.findViewById(R.id.divider_sp_line);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f17391d);
        }
    }
}
