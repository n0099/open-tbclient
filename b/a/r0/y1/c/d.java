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
    public BaseFragmentActivity f27300a;

    /* renamed from: b  reason: collision with root package name */
    public View f27301b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f27302c;

    /* renamed from: d  reason: collision with root package name */
    public View f27303d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f27304e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f27305f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f27306g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f27307h;

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
        this.f27307h = null;
        this.f27300a = baseFragmentActivity;
        this.f27307h = onClickListener;
        b(view);
    }

    public void a(b.a.r0.y1.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.d() == null || gVar.d().size() <= 0) {
            return;
        }
        this.f27302c.fillView(gVar.a());
        this.f27302c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f27429g) {
            this.f27303d.setVisibility(0);
        } else {
            this.f27303d.setVisibility(8);
        }
        List<b.a.r0.y1.c.k.h> d2 = gVar.d();
        if (d2 != null && d2.size() > 0) {
            b.a.r0.y1.c.k.h hVar = d2.get(0);
            if (hVar != null) {
                this.f27304e.setVisibility(0);
                this.f27304e.renderView(hVar);
                this.f27304e.setTag(hVar);
            } else {
                this.f27304e.setVisibility(4);
            }
            if (d2.size() > 1) {
                b.a.r0.y1.c.k.h hVar2 = d2.get(1);
                if (hVar2 != null) {
                    this.f27305f.setVisibility(0);
                    this.f27305f.renderView(hVar2);
                    this.f27305f.setTag(hVar2);
                } else {
                    this.f27305f.setVisibility(4);
                }
            } else {
                this.f27305f.setVisibility(4);
            }
            if (d2.size() > 2) {
                b.a.r0.y1.c.k.h hVar3 = d2.get(2);
                if (hVar3 != null) {
                    this.f27306g.setVisibility(0);
                    this.f27306g.renderView(hVar3);
                    this.f27306g.setTag(hVar3);
                    return;
                }
                this.f27306g.setVisibility(4);
                return;
            }
            this.f27306g.setVisibility(4);
            return;
        }
        this.f27304e.setVisibility(4);
        this.f27305f.setVisibility(4);
        this.f27306g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f27301b = view;
            this.f27302c = (CategoryView) view.findViewById(R.id.category);
            this.f27304e = (DailyPrivilegeItemView) this.f27301b.findViewById(R.id.daily_privilege_item1);
            this.f27305f = (DailyPrivilegeItemView) this.f27301b.findViewById(R.id.daily_privilege_item2);
            this.f27306g = (DailyPrivilegeItemView) this.f27301b.findViewById(R.id.daily_privilege_item3);
            this.f27304e.setOnClickListener(this.f27307h);
            this.f27305f.setOnClickListener(this.f27307h);
            this.f27306g.setOnClickListener(this.f27307h);
            this.f27303d = this.f27301b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.w0.a.a(this.f27300a.getPageContext(), this.f27301b);
        }
    }
}
