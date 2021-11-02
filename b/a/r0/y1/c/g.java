package b.a.r0.y1.c;

import android.view.View;
import android.widget.LinearLayout;
import b.a.r0.y1.c.k.n;
import b.a.r0.y1.c.k.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.CategoryView;
import com.baidu.tieba.memberCenter.index.PrivilegeItemView;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27325a;

    /* renamed from: b  reason: collision with root package name */
    public View f27326b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f27327c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f27328d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f27329e;

    /* renamed from: f  reason: collision with root package name */
    public PrivilegeItemView f27330f;

    /* renamed from: g  reason: collision with root package name */
    public PrivilegeItemView f27331g;

    /* renamed from: h  reason: collision with root package name */
    public PrivilegeItemView f27332h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeItemView f27333i;
    public View j;
    public n k;
    public View.OnClickListener l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f27334e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27334e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= 4) {
                return;
            }
            o oVar = this.f27334e.k.d().get(intValue);
            TiebaStatic.log(new StatisticItem("c11217").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", intValue + 1));
            if (!StringUtils.isNull(oVar.e())) {
                MemberCenterStatic.a(this.f27334e.f27325a.getPageContext(), new String[]{oVar.e()});
            }
            if (oVar.d() > 0) {
                String currentAccount = !TbadkCoreApplication.isLogin() ? SevenZipUtils.FILE_NAME_TEMP : TbadkCoreApplication.getCurrentAccount();
                b.a.q0.s.e0.b.j().x("member_center_item_red_tip_" + oVar.d() + currentAccount, oVar.g());
                if (view instanceof PrivilegeItemView) {
                    ((PrivilegeItemView) view).getPrivilegeName().setCompoundDrawables(null, null, null, null);
                }
            }
        }
    }

    public g(BaseFragmentActivity baseFragmentActivity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.f27325a = baseFragmentActivity;
        d(view);
    }

    public void c(n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) || nVar == null || nVar.d() == null || nVar.d().size() <= 0) {
            return;
        }
        this.k = nVar;
        this.f27327c.fillView(nVar.a());
        if (nVar.f27463g) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        List<o> d2 = nVar.d();
        int size = d2.size();
        if (size == 1) {
            this.f27330f.renderView(d2.get(0));
            this.f27330f.setVisibility(0);
            this.f27331g.setVisibility(8);
            this.f27332h.setVisibility(8);
            this.f27333i.setVisibility(8);
            this.f27330f.setTag(0);
            this.f27328d.setVisibility(0);
            this.f27329e.setVisibility(8);
        } else if (size == 2) {
            this.f27330f.renderView(d2.get(0));
            this.f27331g.renderView(d2.get(1));
            this.f27330f.setTag(0);
            this.f27331g.setTag(1);
            this.f27330f.setVisibility(0);
            this.f27331g.setVisibility(0);
            this.f27332h.setVisibility(8);
            this.f27333i.setVisibility(8);
            this.f27328d.setVisibility(0);
            this.f27329e.setVisibility(8);
        } else if (size != 3) {
            this.f27330f.renderView(d2.get(0));
            this.f27331g.renderView(d2.get(1));
            this.f27332h.renderView(d2.get(2));
            this.f27333i.renderView(d2.get(3));
            this.f27330f.setTag(0);
            this.f27331g.setTag(1);
            this.f27332h.setTag(2);
            this.f27333i.setTag(3);
            this.f27330f.setVisibility(0);
            this.f27331g.setVisibility(0);
            this.f27332h.setVisibility(0);
            this.f27333i.setVisibility(0);
            this.f27328d.setVisibility(0);
            this.f27329e.setVisibility(0);
        } else {
            this.f27330f.renderView(d2.get(0));
            this.f27331g.renderView(d2.get(1));
            this.f27332h.renderView(d2.get(2));
            this.f27330f.setTag(0);
            this.f27331g.setTag(1);
            this.f27332h.setTag(2);
            this.f27330f.setVisibility(0);
            this.f27331g.setVisibility(0);
            this.f27332h.setVisibility(0);
            this.f27333i.setVisibility(8);
            this.f27328d.setVisibility(0);
            this.f27329e.setVisibility(0);
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f27326b = view;
            this.f27327c = (CategoryView) view.findViewById(R.id.category);
            this.f27328d = (LinearLayout) this.f27326b.findViewById(R.id.ly_items1);
            this.f27329e = (LinearLayout) this.f27326b.findViewById(R.id.ly_items2);
            this.f27330f = (PrivilegeItemView) this.f27326b.findViewById(R.id.privilege_item1);
            this.f27331g = (PrivilegeItemView) this.f27326b.findViewById(R.id.privilege_item2);
            this.f27332h = (PrivilegeItemView) this.f27326b.findViewById(R.id.privilege_item3);
            this.f27333i = (PrivilegeItemView) this.f27326b.findViewById(R.id.privilege_item4);
            this.j = this.f27326b.findViewById(R.id.divider_sp_line);
            this.f27330f.setOnClickListener(this.l);
            this.f27331g.setOnClickListener(this.l);
            this.f27332h.setOnClickListener(this.l);
            this.f27333i.setOnClickListener(this.l);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.w0.a.a(this.f27325a.getPageContext(), this.f27326b);
        }
    }
}
