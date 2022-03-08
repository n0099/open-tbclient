package c.a.r0.h2.c;

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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f17714b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f17715c;

    /* renamed from: d  reason: collision with root package name */
    public View f17716d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f17717e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f17718f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f17719g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f17720h;

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
        this.f17720h = null;
        this.a = baseFragmentActivity;
        this.f17720h = onClickListener;
        b(view);
    }

    public void a(c.a.r0.h2.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.d() == null || gVar.d().size() <= 0) {
            return;
        }
        this.f17715c.fillView(gVar.a());
        this.f17715c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f17833g) {
            this.f17716d.setVisibility(0);
        } else {
            this.f17716d.setVisibility(8);
        }
        List<c.a.r0.h2.c.k.h> d2 = gVar.d();
        if (d2 != null && d2.size() > 0) {
            c.a.r0.h2.c.k.h hVar = d2.get(0);
            if (hVar != null) {
                this.f17717e.setVisibility(0);
                this.f17717e.renderView(hVar);
                this.f17717e.setTag(hVar);
            } else {
                this.f17717e.setVisibility(4);
            }
            if (d2.size() > 1) {
                c.a.r0.h2.c.k.h hVar2 = d2.get(1);
                if (hVar2 != null) {
                    this.f17718f.setVisibility(0);
                    this.f17718f.renderView(hVar2);
                    this.f17718f.setTag(hVar2);
                } else {
                    this.f17718f.setVisibility(4);
                }
            } else {
                this.f17718f.setVisibility(4);
            }
            if (d2.size() > 2) {
                c.a.r0.h2.c.k.h hVar3 = d2.get(2);
                if (hVar3 != null) {
                    this.f17719g.setVisibility(0);
                    this.f17719g.renderView(hVar3);
                    this.f17719g.setTag(hVar3);
                    return;
                }
                this.f17719g.setVisibility(4);
                return;
            }
            this.f17719g.setVisibility(4);
            return;
        }
        this.f17717e.setVisibility(4);
        this.f17718f.setVisibility(4);
        this.f17719g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f17714b = view;
            this.f17715c = (CategoryView) view.findViewById(R.id.category);
            this.f17717e = (DailyPrivilegeItemView) this.f17714b.findViewById(R.id.daily_privilege_item1);
            this.f17718f = (DailyPrivilegeItemView) this.f17714b.findViewById(R.id.daily_privilege_item2);
            this.f17719g = (DailyPrivilegeItemView) this.f17714b.findViewById(R.id.daily_privilege_item3);
            this.f17717e.setOnClickListener(this.f17720h);
            this.f17718f.setOnClickListener(this.f17720h);
            this.f17719g.setOnClickListener(this.f17720h);
            this.f17716d = this.f17714b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.a.getPageContext(), this.f17714b);
        }
    }
}
