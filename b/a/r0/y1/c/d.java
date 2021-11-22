package b.a.r0.y1.c;

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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f28803a;

    /* renamed from: b  reason: collision with root package name */
    public View f28804b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f28805c;

    /* renamed from: d  reason: collision with root package name */
    public View f28806d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f28807e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f28808f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f28809g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f28810h;

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
        this.f28810h = null;
        this.f28803a = baseFragmentActivity;
        this.f28810h = onClickListener;
        b(view);
    }

    public void a(b.a.r0.y1.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.d() == null || gVar.d().size() <= 0) {
            return;
        }
        this.f28805c.fillView(gVar.a());
        this.f28805c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f28932g) {
            this.f28806d.setVisibility(0);
        } else {
            this.f28806d.setVisibility(8);
        }
        List<b.a.r0.y1.c.k.h> d2 = gVar.d();
        if (d2 != null && d2.size() > 0) {
            b.a.r0.y1.c.k.h hVar = d2.get(0);
            if (hVar != null) {
                this.f28807e.setVisibility(0);
                this.f28807e.renderView(hVar);
                this.f28807e.setTag(hVar);
            } else {
                this.f28807e.setVisibility(4);
            }
            if (d2.size() > 1) {
                b.a.r0.y1.c.k.h hVar2 = d2.get(1);
                if (hVar2 != null) {
                    this.f28808f.setVisibility(0);
                    this.f28808f.renderView(hVar2);
                    this.f28808f.setTag(hVar2);
                } else {
                    this.f28808f.setVisibility(4);
                }
            } else {
                this.f28808f.setVisibility(4);
            }
            if (d2.size() > 2) {
                b.a.r0.y1.c.k.h hVar3 = d2.get(2);
                if (hVar3 != null) {
                    this.f28809g.setVisibility(0);
                    this.f28809g.renderView(hVar3);
                    this.f28809g.setTag(hVar3);
                    return;
                }
                this.f28809g.setVisibility(4);
                return;
            }
            this.f28809g.setVisibility(4);
            return;
        }
        this.f28807e.setVisibility(4);
        this.f28808f.setVisibility(4);
        this.f28809g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f28804b = view;
            this.f28805c = (CategoryView) view.findViewById(R.id.category);
            this.f28807e = (DailyPrivilegeItemView) this.f28804b.findViewById(R.id.daily_privilege_item1);
            this.f28808f = (DailyPrivilegeItemView) this.f28804b.findViewById(R.id.daily_privilege_item2);
            this.f28809g = (DailyPrivilegeItemView) this.f28804b.findViewById(R.id.daily_privilege_item3);
            this.f28807e.setOnClickListener(this.f28810h);
            this.f28808f.setOnClickListener(this.f28810h);
            this.f28809g.setOnClickListener(this.f28810h);
            this.f28806d = this.f28804b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.v0.a.a(this.f28803a.getPageContext(), this.f28804b);
        }
    }
}
