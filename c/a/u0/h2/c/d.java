package c.a.u0.h2.c;

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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f18254b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f18255c;

    /* renamed from: d  reason: collision with root package name */
    public View f18256d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f18257e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f18258f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f18259g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f18260h;

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
        this.f18260h = null;
        this.a = baseFragmentActivity;
        this.f18260h = onClickListener;
        b(view);
    }

    public void a(c.a.u0.h2.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.d() == null || gVar.d().size() <= 0) {
            return;
        }
        this.f18255c.fillView(gVar.a());
        this.f18255c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f18373g) {
            this.f18256d.setVisibility(0);
        } else {
            this.f18256d.setVisibility(8);
        }
        List<c.a.u0.h2.c.k.h> d2 = gVar.d();
        if (d2 != null && d2.size() > 0) {
            c.a.u0.h2.c.k.h hVar = d2.get(0);
            if (hVar != null) {
                this.f18257e.setVisibility(0);
                this.f18257e.renderView(hVar);
                this.f18257e.setTag(hVar);
            } else {
                this.f18257e.setVisibility(4);
            }
            if (d2.size() > 1) {
                c.a.u0.h2.c.k.h hVar2 = d2.get(1);
                if (hVar2 != null) {
                    this.f18258f.setVisibility(0);
                    this.f18258f.renderView(hVar2);
                    this.f18258f.setTag(hVar2);
                } else {
                    this.f18258f.setVisibility(4);
                }
            } else {
                this.f18258f.setVisibility(4);
            }
            if (d2.size() > 2) {
                c.a.u0.h2.c.k.h hVar3 = d2.get(2);
                if (hVar3 != null) {
                    this.f18259g.setVisibility(0);
                    this.f18259g.renderView(hVar3);
                    this.f18259g.setTag(hVar3);
                    return;
                }
                this.f18259g.setVisibility(4);
                return;
            }
            this.f18259g.setVisibility(4);
            return;
        }
        this.f18257e.setVisibility(4);
        this.f18258f.setVisibility(4);
        this.f18259g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f18254b = view;
            this.f18255c = (CategoryView) view.findViewById(R.id.category);
            this.f18257e = (DailyPrivilegeItemView) this.f18254b.findViewById(R.id.daily_privilege_item1);
            this.f18258f = (DailyPrivilegeItemView) this.f18254b.findViewById(R.id.daily_privilege_item2);
            this.f18259g = (DailyPrivilegeItemView) this.f18254b.findViewById(R.id.daily_privilege_item3);
            this.f18257e.setOnClickListener(this.f18260h);
            this.f18258f.setOnClickListener(this.f18260h);
            this.f18259g.setOnClickListener(this.f18260h);
            this.f18256d = this.f18254b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.x0.a.a(this.a.getPageContext(), this.f18254b);
        }
    }
}
