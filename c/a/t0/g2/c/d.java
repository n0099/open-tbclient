package c.a.t0.g2.c;

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
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f17792b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f17793c;

    /* renamed from: d  reason: collision with root package name */
    public View f17794d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f17795e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f17796f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f17797g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f17798h;

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
        this.f17798h = null;
        this.a = baseFragmentActivity;
        this.f17798h = onClickListener;
        b(view);
    }

    public void a(c.a.t0.g2.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.d() == null || gVar.d().size() <= 0) {
            return;
        }
        this.f17793c.fillView(gVar.a());
        this.f17793c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f17911g) {
            this.f17794d.setVisibility(0);
        } else {
            this.f17794d.setVisibility(8);
        }
        List<c.a.t0.g2.c.k.h> d2 = gVar.d();
        if (d2 != null && d2.size() > 0) {
            c.a.t0.g2.c.k.h hVar = d2.get(0);
            if (hVar != null) {
                this.f17795e.setVisibility(0);
                this.f17795e.renderView(hVar);
                this.f17795e.setTag(hVar);
            } else {
                this.f17795e.setVisibility(4);
            }
            if (d2.size() > 1) {
                c.a.t0.g2.c.k.h hVar2 = d2.get(1);
                if (hVar2 != null) {
                    this.f17796f.setVisibility(0);
                    this.f17796f.renderView(hVar2);
                    this.f17796f.setTag(hVar2);
                } else {
                    this.f17796f.setVisibility(4);
                }
            } else {
                this.f17796f.setVisibility(4);
            }
            if (d2.size() > 2) {
                c.a.t0.g2.c.k.h hVar3 = d2.get(2);
                if (hVar3 != null) {
                    this.f17797g.setVisibility(0);
                    this.f17797g.renderView(hVar3);
                    this.f17797g.setTag(hVar3);
                    return;
                }
                this.f17797g.setVisibility(4);
                return;
            }
            this.f17797g.setVisibility(4);
            return;
        }
        this.f17795e.setVisibility(4);
        this.f17796f.setVisibility(4);
        this.f17797g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f17792b = view;
            this.f17793c = (CategoryView) view.findViewById(R.id.category);
            this.f17795e = (DailyPrivilegeItemView) this.f17792b.findViewById(R.id.daily_privilege_item1);
            this.f17796f = (DailyPrivilegeItemView) this.f17792b.findViewById(R.id.daily_privilege_item2);
            this.f17797g = (DailyPrivilegeItemView) this.f17792b.findViewById(R.id.daily_privilege_item3);
            this.f17795e.setOnClickListener(this.f17798h);
            this.f17796f.setOnClickListener(this.f17798h);
            this.f17797g.setOnClickListener(this.f17798h);
            this.f17794d = this.f17792b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f17792b);
        }
    }
}
