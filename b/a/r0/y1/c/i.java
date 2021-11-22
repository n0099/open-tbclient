package b.a.r0.y1.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import b.a.r0.y1.c.k.q;
import b.a.r0.y1.c.k.r;
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
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f28846a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f28847b;

    /* renamed from: c  reason: collision with root package name */
    public Context f28848c;

    /* renamed from: d  reason: collision with root package name */
    public View f28849d;

    /* renamed from: e  reason: collision with root package name */
    public CategoryView f28850e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f28851f;

    /* renamed from: g  reason: collision with root package name */
    public TaskItemView f28852g;

    /* renamed from: h  reason: collision with root package name */
    public TaskItemView f28853h;

    /* renamed from: i  reason: collision with root package name */
    public TaskItemView f28854i;
    public View j;

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
        this.f28846a = baseFragmentActivity;
        this.f28848c = baseFragmentActivity.getActivity();
        this.f28847b = onClickListener;
        b(view);
    }

    public void a(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        if (qVar.f28981e) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.f28850e.fillView(qVar.a());
        List<r> d2 = qVar.d();
        if (d2 == null || d2.size() <= 0) {
            return;
        }
        int size = d2.size();
        if (size == 1) {
            this.f28852g.renderView(d2.get(0));
            this.f28852g.hideDivideLine();
            this.f28852g.setVisibility(0);
            this.f28853h.setVisibility(8);
            this.f28854i.setVisibility(8);
        } else if (size != 2) {
            this.f28852g.renderView(d2.get(0));
            this.f28853h.renderView(d2.get(1));
            this.f28854i.renderView(d2.get(2));
            this.f28854i.hideDivideLine();
            this.f28852g.setVisibility(0);
            this.f28853h.setVisibility(0);
            this.f28854i.setVisibility(0);
        } else {
            this.f28852g.renderView(d2.get(0));
            this.f28853h.renderView(d2.get(1));
            this.f28853h.hideDivideLine();
            this.f28852g.setVisibility(0);
            this.f28853h.setVisibility(0);
            this.f28854i.setVisibility(8);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f28849d = view;
        this.f28850e = (CategoryView) view.findViewById(R.id.category);
        this.f28851f = (LinearLayout) this.f28849d.findViewById(R.id.ly_items);
        this.f28852g = (TaskItemView) this.f28849d.findViewById(R.id.task_view_one);
        this.f28853h = (TaskItemView) this.f28849d.findViewById(R.id.task_view_two);
        this.f28854i = (TaskItemView) this.f28849d.findViewById(R.id.task_view_three);
        this.f28852g.setOnCommenClickListener(this.f28847b);
        this.f28853h.setOnCommenClickListener(this.f28847b);
        this.f28854i.setOnCommenClickListener(this.f28847b);
        this.j = this.f28849d.findViewById(R.id.divider_sp_line);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.v0.a.a(this.f28846a.getPageContext(), this.f28849d);
        }
    }
}
