package c.a.t0.f2.c;

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
    public View f17350b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f17351c;

    /* renamed from: d  reason: collision with root package name */
    public View f17352d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f17353e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f17354f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f17355g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f17356h;

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
        this.f17356h = null;
        this.a = baseFragmentActivity;
        this.f17356h = onClickListener;
        b(view);
    }

    public void a(c.a.t0.f2.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.d() == null || gVar.d().size() <= 0) {
            return;
        }
        this.f17351c.fillView(gVar.a());
        this.f17351c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f17469g) {
            this.f17352d.setVisibility(0);
        } else {
            this.f17352d.setVisibility(8);
        }
        List<c.a.t0.f2.c.k.h> d2 = gVar.d();
        if (d2 != null && d2.size() > 0) {
            c.a.t0.f2.c.k.h hVar = d2.get(0);
            if (hVar != null) {
                this.f17353e.setVisibility(0);
                this.f17353e.renderView(hVar);
                this.f17353e.setTag(hVar);
            } else {
                this.f17353e.setVisibility(4);
            }
            if (d2.size() > 1) {
                c.a.t0.f2.c.k.h hVar2 = d2.get(1);
                if (hVar2 != null) {
                    this.f17354f.setVisibility(0);
                    this.f17354f.renderView(hVar2);
                    this.f17354f.setTag(hVar2);
                } else {
                    this.f17354f.setVisibility(4);
                }
            } else {
                this.f17354f.setVisibility(4);
            }
            if (d2.size() > 2) {
                c.a.t0.f2.c.k.h hVar3 = d2.get(2);
                if (hVar3 != null) {
                    this.f17355g.setVisibility(0);
                    this.f17355g.renderView(hVar3);
                    this.f17355g.setTag(hVar3);
                    return;
                }
                this.f17355g.setVisibility(4);
                return;
            }
            this.f17355g.setVisibility(4);
            return;
        }
        this.f17353e.setVisibility(4);
        this.f17354f.setVisibility(4);
        this.f17355g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f17350b = view;
            this.f17351c = (CategoryView) view.findViewById(R.id.category);
            this.f17353e = (DailyPrivilegeItemView) this.f17350b.findViewById(R.id.daily_privilege_item1);
            this.f17354f = (DailyPrivilegeItemView) this.f17350b.findViewById(R.id.daily_privilege_item2);
            this.f17355g = (DailyPrivilegeItemView) this.f17350b.findViewById(R.id.daily_privilege_item3);
            this.f17353e.setOnClickListener(this.f17356h);
            this.f17354f.setOnClickListener(this.f17356h);
            this.f17355g.setOnClickListener(this.f17356h);
            this.f17352d = this.f17350b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f17350b);
        }
    }
}
