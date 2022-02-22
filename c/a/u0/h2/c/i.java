package c.a.u0.h2.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.a.u0.h2.c.k.q;
import c.a.u0.h2.c.k.r;
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
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f18293b;

    /* renamed from: c  reason: collision with root package name */
    public Context f18294c;

    /* renamed from: d  reason: collision with root package name */
    public View f18295d;

    /* renamed from: e  reason: collision with root package name */
    public CategoryView f18296e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18297f;

    /* renamed from: g  reason: collision with root package name */
    public TaskItemView f18298g;

    /* renamed from: h  reason: collision with root package name */
    public TaskItemView f18299h;

    /* renamed from: i  reason: collision with root package name */
    public TaskItemView f18300i;

    /* renamed from: j  reason: collision with root package name */
    public View f18301j;

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
        this.f18294c = baseFragmentActivity.getActivity();
        this.f18293b = onClickListener;
        b(view);
    }

    public void a(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        if (qVar.f18420e) {
            this.f18301j.setVisibility(0);
        } else {
            this.f18301j.setVisibility(8);
        }
        this.f18296e.fillView(qVar.a());
        List<r> d2 = qVar.d();
        if (d2 == null || d2.size() <= 0) {
            return;
        }
        int size = d2.size();
        if (size == 1) {
            this.f18298g.renderView(d2.get(0));
            this.f18298g.hideDivideLine();
            this.f18298g.setVisibility(0);
            this.f18299h.setVisibility(8);
            this.f18300i.setVisibility(8);
        } else if (size != 2) {
            this.f18298g.renderView(d2.get(0));
            this.f18299h.renderView(d2.get(1));
            this.f18300i.renderView(d2.get(2));
            this.f18300i.hideDivideLine();
            this.f18298g.setVisibility(0);
            this.f18299h.setVisibility(0);
            this.f18300i.setVisibility(0);
        } else {
            this.f18298g.renderView(d2.get(0));
            this.f18299h.renderView(d2.get(1));
            this.f18299h.hideDivideLine();
            this.f18298g.setVisibility(0);
            this.f18299h.setVisibility(0);
            this.f18300i.setVisibility(8);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f18295d = view;
        this.f18296e = (CategoryView) view.findViewById(R.id.category);
        this.f18297f = (LinearLayout) this.f18295d.findViewById(R.id.ly_items);
        this.f18298g = (TaskItemView) this.f18295d.findViewById(R.id.task_view_one);
        this.f18299h = (TaskItemView) this.f18295d.findViewById(R.id.task_view_two);
        this.f18300i = (TaskItemView) this.f18295d.findViewById(R.id.task_view_three);
        this.f18298g.setOnCommenClickListener(this.f18293b);
        this.f18299h.setOnCommenClickListener(this.f18293b);
        this.f18300i.setOnCommenClickListener(this.f18293b);
        this.f18301j = this.f18295d.findViewById(R.id.divider_sp_line);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.x0.a.a(this.a.getPageContext(), this.f18295d);
        }
    }
}
