package c.a.q0.w1.c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.a.q0.w1.c.k.q;
import c.a.q0.w1.c.k.r;
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
    public BaseFragmentActivity f27732a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f27733b;

    /* renamed from: c  reason: collision with root package name */
    public Context f27734c;

    /* renamed from: d  reason: collision with root package name */
    public View f27735d;

    /* renamed from: e  reason: collision with root package name */
    public CategoryView f27736e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f27737f;

    /* renamed from: g  reason: collision with root package name */
    public TaskItemView f27738g;

    /* renamed from: h  reason: collision with root package name */
    public TaskItemView f27739h;

    /* renamed from: i  reason: collision with root package name */
    public TaskItemView f27740i;

    /* renamed from: j  reason: collision with root package name */
    public View f27741j;

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
        this.f27732a = baseFragmentActivity;
        this.f27734c = baseFragmentActivity.getActivity();
        this.f27733b = onClickListener;
        b(view);
    }

    public void a(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        if (qVar.f27872e) {
            this.f27741j.setVisibility(0);
        } else {
            this.f27741j.setVisibility(8);
        }
        this.f27736e.fillView(qVar.b());
        List<r> c2 = qVar.c();
        if (c2 == null || c2.size() <= 0) {
            return;
        }
        int size = c2.size();
        if (size == 1) {
            this.f27738g.renderView(c2.get(0));
            this.f27738g.hideDivideLine();
            this.f27738g.setVisibility(0);
            this.f27739h.setVisibility(8);
            this.f27740i.setVisibility(8);
        } else if (size != 2) {
            this.f27738g.renderView(c2.get(0));
            this.f27739h.renderView(c2.get(1));
            this.f27740i.renderView(c2.get(2));
            this.f27740i.hideDivideLine();
            this.f27738g.setVisibility(0);
            this.f27739h.setVisibility(0);
            this.f27740i.setVisibility(0);
        } else {
            this.f27738g.renderView(c2.get(0));
            this.f27739h.renderView(c2.get(1));
            this.f27739h.hideDivideLine();
            this.f27738g.setVisibility(0);
            this.f27739h.setVisibility(0);
            this.f27740i.setVisibility(8);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        this.f27735d = view;
        this.f27736e = (CategoryView) view.findViewById(R.id.category);
        this.f27737f = (LinearLayout) this.f27735d.findViewById(R.id.ly_items);
        this.f27738g = (TaskItemView) this.f27735d.findViewById(R.id.task_view_one);
        this.f27739h = (TaskItemView) this.f27735d.findViewById(R.id.task_view_two);
        this.f27740i = (TaskItemView) this.f27735d.findViewById(R.id.task_view_three);
        this.f27738g.setOnCommenClickListener(this.f27733b);
        this.f27739h.setOnCommenClickListener(this.f27733b);
        this.f27740i.setOnCommenClickListener(this.f27733b);
        this.f27741j = this.f27735d.findViewById(R.id.divider_sp_line);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.u0.a.a(this.f27732a.getPageContext(), this.f27735d);
        }
    }
}
