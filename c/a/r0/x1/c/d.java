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
    public BaseFragmentActivity f28395a;

    /* renamed from: b  reason: collision with root package name */
    public View f28396b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f28397c;

    /* renamed from: d  reason: collision with root package name */
    public View f28398d;

    /* renamed from: e  reason: collision with root package name */
    public DailyPrivilegeItemView f28399e;

    /* renamed from: f  reason: collision with root package name */
    public DailyPrivilegeItemView f28400f;

    /* renamed from: g  reason: collision with root package name */
    public DailyPrivilegeItemView f28401g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f28402h;

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
        this.f28402h = null;
        this.f28395a = baseFragmentActivity;
        this.f28402h = onClickListener;
        b(view);
    }

    public void a(c.a.r0.x1.c.k.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null || gVar.c() == null || gVar.c().size() <= 0) {
            return;
        }
        this.f28397c.fillView(gVar.b());
        this.f28397c.findViewById(R.id.divider_line_item).setVisibility(8);
        if (gVar.f28528g) {
            this.f28398d.setVisibility(0);
        } else {
            this.f28398d.setVisibility(8);
        }
        List<c.a.r0.x1.c.k.h> c2 = gVar.c();
        if (c2 != null && c2.size() > 0) {
            c.a.r0.x1.c.k.h hVar = c2.get(0);
            if (hVar != null) {
                this.f28399e.setVisibility(0);
                this.f28399e.renderView(hVar);
                this.f28399e.setTag(hVar);
            } else {
                this.f28399e.setVisibility(4);
            }
            if (c2.size() > 1) {
                c.a.r0.x1.c.k.h hVar2 = c2.get(1);
                if (hVar2 != null) {
                    this.f28400f.setVisibility(0);
                    this.f28400f.renderView(hVar2);
                    this.f28400f.setTag(hVar2);
                } else {
                    this.f28400f.setVisibility(4);
                }
            } else {
                this.f28400f.setVisibility(4);
            }
            if (c2.size() > 2) {
                c.a.r0.x1.c.k.h hVar3 = c2.get(2);
                if (hVar3 != null) {
                    this.f28401g.setVisibility(0);
                    this.f28401g.renderView(hVar3);
                    this.f28401g.setTag(hVar3);
                    return;
                }
                this.f28401g.setVisibility(4);
                return;
            }
            this.f28401g.setVisibility(4);
            return;
        }
        this.f28399e.setVisibility(4);
        this.f28400f.setVisibility(4);
        this.f28401g.setVisibility(4);
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f28396b = view;
            this.f28397c = (CategoryView) view.findViewById(R.id.category);
            this.f28399e = (DailyPrivilegeItemView) this.f28396b.findViewById(R.id.daily_privilege_item1);
            this.f28400f = (DailyPrivilegeItemView) this.f28396b.findViewById(R.id.daily_privilege_item2);
            this.f28401g = (DailyPrivilegeItemView) this.f28396b.findViewById(R.id.daily_privilege_item3);
            this.f28399e.setOnClickListener(this.f28402h);
            this.f28400f.setOnClickListener(this.f28402h);
            this.f28401g.setOnClickListener(this.f28402h);
            this.f28398d = this.f28396b.findViewById(R.id.divider_sp_line);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f28395a.getPageContext(), this.f28396b);
        }
    }
}
