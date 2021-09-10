package c.a.r0.x1.c;

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
    public BaseFragmentActivity f28375a;

    /* renamed from: b  reason: collision with root package name */
    public View f28376b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f28377c;

    /* renamed from: d  reason: collision with root package name */
    public View f28378d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f28379e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f28380f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f28381g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f28382h;

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
        this.f28382h = null;
        this.f28375a = baseFragmentActivity;
        this.f28382h = onClickListener;
        b(view);
    }

    public void a(c.a.r0.x1.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.c() == null || gVar.c().size() <= 0) {
            return;
        }
        this.f28377c.fillView(gVar.b());
        this.f28377c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f28508g) {
            this.f28378d.setVisibility(0);
        } else {
            this.f28378d.setVisibility(8);
        }
        List<c.a.r0.x1.c.k.h> c2 = gVar.c();
        if (c2 != null && c2.size() > 0) {
            c.a.r0.x1.c.k.h hVar = c2.get(0);
            if (hVar != null) {
                this.f28379e.setVisibility(0);
                this.f28379e.renderView(hVar);
                this.f28379e.setTag(hVar);
            } else {
                this.f28379e.setVisibility(4);
            }
            if (c2.size() > 1) {
                c.a.r0.x1.c.k.h hVar2 = c2.get(1);
                if (hVar2 != null) {
                    this.f28380f.setVisibility(0);
                    this.f28380f.renderView(hVar2);
                    this.f28380f.setTag(hVar2);
                } else {
                    this.f28380f.setVisibility(4);
                }
            } else {
                this.f28380f.setVisibility(4);
            }
            if (c2.size() > 2) {
                c.a.r0.x1.c.k.h hVar3 = c2.get(2);
                if (hVar3 != null) {
                    this.f28381g.setVisibility(0);
                    this.f28381g.renderView(hVar3);
                    this.f28381g.setTag(hVar3);
                    return;
                }
                this.f28381g.setVisibility(4);
                return;
            }
            this.f28381g.setVisibility(4);
            return;
        }
        this.f28379e.setVisibility(4);
        this.f28380f.setVisibility(4);
        this.f28381g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f28376b = view;
            this.f28377c = (CategoryView) view.findViewById(R.id.category);
            this.f28379e = (DailyPrivilegeItemView) this.f28376b.findViewById(R.id.daily_privilege_item1);
            this.f28380f = (DailyPrivilegeItemView) this.f28376b.findViewById(R.id.daily_privilege_item2);
            this.f28381g = (DailyPrivilegeItemView) this.f28376b.findViewById(R.id.daily_privilege_item3);
            this.f28379e.setOnClickListener(this.f28382h);
            this.f28380f.setOnClickListener(this.f28382h);
            this.f28381g.setOnClickListener(this.f28382h);
            this.f28378d = this.f28376b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f28375a.getPageContext(), this.f28376b);
        }
    }
}
