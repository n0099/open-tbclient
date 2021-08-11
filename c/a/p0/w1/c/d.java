package c.a.p0.w1.c;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.CategoryView;
import com.baidu.tieba.memberCenter.index.DailyPrivilegeItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27349a;

    /* renamed from: b  reason: collision with root package name */
    public View f27350b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f27351c;

    /* renamed from: d  reason: collision with root package name */
    public View f27352d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f27353e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f27354f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f27355g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f27356h;

    public d(BaseFragmentActivity baseFragmentActivity, View view, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, view, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27356h = null;
        this.f27349a = baseFragmentActivity;
        this.f27356h = onClickListener;
        b(view);
    }

    public void a(c.a.p0.w1.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.c() == null || gVar.c().size() <= 0) {
            return;
        }
        this.f27351c.fillView(gVar.b());
        this.f27351c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f27482g) {
            this.f27352d.setVisibility(0);
        } else {
            this.f27352d.setVisibility(8);
        }
        List<c.a.p0.w1.c.k.h> c2 = gVar.c();
        if (c2 != null && c2.size() > 0) {
            c.a.p0.w1.c.k.h hVar = c2.get(0);
            if (hVar != null) {
                this.f27353e.setVisibility(0);
                this.f27353e.renderView(hVar);
                this.f27353e.setTag(hVar);
            } else {
                this.f27353e.setVisibility(4);
            }
            if (c2.size() > 1) {
                c.a.p0.w1.c.k.h hVar2 = c2.get(1);
                if (hVar2 != null) {
                    this.f27354f.setVisibility(0);
                    this.f27354f.renderView(hVar2);
                    this.f27354f.setTag(hVar2);
                } else {
                    this.f27354f.setVisibility(4);
                }
            } else {
                this.f27354f.setVisibility(4);
            }
            if (c2.size() > 2) {
                c.a.p0.w1.c.k.h hVar3 = c2.get(2);
                if (hVar3 != null) {
                    this.f27355g.setVisibility(0);
                    this.f27355g.renderView(hVar3);
                    this.f27355g.setTag(hVar3);
                    return;
                }
                this.f27355g.setVisibility(4);
                return;
            }
            this.f27355g.setVisibility(4);
            return;
        }
        this.f27353e.setVisibility(4);
        this.f27354f.setVisibility(4);
        this.f27355g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f27350b = view;
            this.f27351c = (CategoryView) view.findViewById(R.id.category);
            this.f27353e = (DailyPrivilegeItemView) this.f27350b.findViewById(R.id.daily_privilege_item1);
            this.f27354f = (DailyPrivilegeItemView) this.f27350b.findViewById(R.id.daily_privilege_item2);
            this.f27355g = (DailyPrivilegeItemView) this.f27350b.findViewById(R.id.daily_privilege_item3);
            this.f27353e.setOnClickListener(this.f27356h);
            this.f27354f.setOnClickListener(this.f27356h);
            this.f27355g.setOnClickListener(this.f27356h);
            this.f27352d = this.f27350b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.u0.a.a(this.f27349a.getPageContext(), this.f27350b);
        }
    }
}
