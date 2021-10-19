package c.a.r0.y1.c;

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
    public BaseFragmentActivity f28571a;

    /* renamed from: b  reason: collision with root package name */
    public View f28572b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f28573c;

    /* renamed from: d  reason: collision with root package name */
    public View f28574d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f28575e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f28576f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f28577g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f28578h;

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
        this.f28578h = null;
        this.f28571a = baseFragmentActivity;
        this.f28578h = onClickListener;
        b(view);
    }

    public void a(c.a.r0.y1.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.c() == null || gVar.c().size() <= 0) {
            return;
        }
        this.f28573c.fillView(gVar.b());
        this.f28573c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f28704g) {
            this.f28574d.setVisibility(0);
        } else {
            this.f28574d.setVisibility(8);
        }
        List<c.a.r0.y1.c.k.h> c2 = gVar.c();
        if (c2 != null && c2.size() > 0) {
            c.a.r0.y1.c.k.h hVar = c2.get(0);
            if (hVar != null) {
                this.f28575e.setVisibility(0);
                this.f28575e.renderView(hVar);
                this.f28575e.setTag(hVar);
            } else {
                this.f28575e.setVisibility(4);
            }
            if (c2.size() > 1) {
                c.a.r0.y1.c.k.h hVar2 = c2.get(1);
                if (hVar2 != null) {
                    this.f28576f.setVisibility(0);
                    this.f28576f.renderView(hVar2);
                    this.f28576f.setTag(hVar2);
                } else {
                    this.f28576f.setVisibility(4);
                }
            } else {
                this.f28576f.setVisibility(4);
            }
            if (c2.size() > 2) {
                c.a.r0.y1.c.k.h hVar3 = c2.get(2);
                if (hVar3 != null) {
                    this.f28577g.setVisibility(0);
                    this.f28577g.renderView(hVar3);
                    this.f28577g.setTag(hVar3);
                    return;
                }
                this.f28577g.setVisibility(4);
                return;
            }
            this.f28577g.setVisibility(4);
            return;
        }
        this.f28575e.setVisibility(4);
        this.f28576f.setVisibility(4);
        this.f28577g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f28572b = view;
            this.f28573c = (CategoryView) view.findViewById(R.id.category);
            this.f28575e = (DailyPrivilegeItemView) this.f28572b.findViewById(R.id.daily_privilege_item1);
            this.f28576f = (DailyPrivilegeItemView) this.f28572b.findViewById(R.id.daily_privilege_item2);
            this.f28577g = (DailyPrivilegeItemView) this.f28572b.findViewById(R.id.daily_privilege_item3);
            this.f28575e.setOnClickListener(this.f28578h);
            this.f28576f.setOnClickListener(this.f28578h);
            this.f28577g.setOnClickListener(this.f28578h);
            this.f28574d = this.f28572b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f28571a.getPageContext(), this.f28572b);
        }
    }
}
