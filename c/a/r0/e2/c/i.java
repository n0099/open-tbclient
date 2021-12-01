package c.a.r0.e2.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.a.r0.e2.c.k.q;
import c.a.r0.e2.c.k.r;
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
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f16754b;

    /* renamed from: c  reason: collision with root package name */
    public Context f16755c;

    /* renamed from: d  reason: collision with root package name */
    public View f16756d;

    /* renamed from: e  reason: collision with root package name */
    public CategoryView f16757e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f16758f;

    /* renamed from: g  reason: collision with root package name */
    public TaskItemView f16759g;

    /* renamed from: h  reason: collision with root package name */
    public TaskItemView f16760h;

    /* renamed from: i  reason: collision with root package name */
    public TaskItemView f16761i;

    /* renamed from: j  reason: collision with root package name */
    public View f16762j;

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
        this.f16755c = baseFragmentActivity.getActivity();
        this.f16754b = onClickListener;
        b(view);
    }

    public void a(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        if (qVar.f16883e) {
            this.f16762j.setVisibility(0);
        } else {
            this.f16762j.setVisibility(8);
        }
        this.f16757e.fillView(qVar.a());
        List<r> d2 = qVar.d();
        if (d2 == null || d2.size() <= 0) {
            return;
        }
        int size = d2.size();
        if (size == 1) {
            this.f16759g.renderView(d2.get(0));
            this.f16759g.hideDivideLine();
            this.f16759g.setVisibility(0);
            this.f16760h.setVisibility(8);
            this.f16761i.setVisibility(8);
        } else if (size != 2) {
            this.f16759g.renderView(d2.get(0));
            this.f16760h.renderView(d2.get(1));
            this.f16761i.renderView(d2.get(2));
            this.f16761i.hideDivideLine();
            this.f16759g.setVisibility(0);
            this.f16760h.setVisibility(0);
            this.f16761i.setVisibility(0);
        } else {
            this.f16759g.renderView(d2.get(0));
            this.f16760h.renderView(d2.get(1));
            this.f16760h.hideDivideLine();
            this.f16759g.setVisibility(0);
            this.f16760h.setVisibility(0);
            this.f16761i.setVisibility(8);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f16756d = view;
        this.f16757e = (CategoryView) view.findViewById(R.id.category);
        this.f16758f = (LinearLayout) this.f16756d.findViewById(R.id.ly_items);
        this.f16759g = (TaskItemView) this.f16756d.findViewById(R.id.task_view_one);
        this.f16760h = (TaskItemView) this.f16756d.findViewById(R.id.task_view_two);
        this.f16761i = (TaskItemView) this.f16756d.findViewById(R.id.task_view_three);
        this.f16759g.setOnCommenClickListener(this.f16754b);
        this.f16760h.setOnCommenClickListener(this.f16754b);
        this.f16761i.setOnCommenClickListener(this.f16754b);
        this.f16762j = this.f16756d.findViewById(R.id.divider_sp_line);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.a.getPageContext(), this.f16756d);
        }
    }
}
