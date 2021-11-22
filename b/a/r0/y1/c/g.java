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
    public BaseFragmentActivity f28828a;

    /* renamed from: b  reason: collision with root package name */
    public View f28829b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f28830c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f28831d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f28832e;

    /* renamed from: f  reason: collision with root package name */
    public PrivilegeItemView f28833f;

    /* renamed from: g  reason: collision with root package name */
    public PrivilegeItemView f28834g;

    /* renamed from: h  reason: collision with root package name */
    public PrivilegeItemView f28835h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeItemView f28836i;
    public View j;
    public n k;
    public View.OnClickListener l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f28837e;

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
            this.f28837e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= 4) {
                return;
            }
            o oVar = this.f28837e.k.d().get(intValue);
            TiebaStatic.log(new StatisticItem("c11217").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", intValue + 1));
            if (!StringUtils.isNull(oVar.e())) {
                MemberCenterStatic.a(this.f28837e.f28828a.getPageContext(), new String[]{oVar.e()});
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
        this.f28828a = baseFragmentActivity;
        d(view);
    }

    public void c(n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) || nVar == null || nVar.d() == null || nVar.d().size() <= 0) {
            return;
        }
        this.k = nVar;
        this.f28830c.fillView(nVar.a());
        if (nVar.f28966g) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        List<o> d2 = nVar.d();
        int size = d2.size();
        if (size == 1) {
            this.f28833f.renderView(d2.get(0));
            this.f28833f.setVisibility(0);
            this.f28834g.setVisibility(8);
            this.f28835h.setVisibility(8);
            this.f28836i.setVisibility(8);
            this.f28833f.setTag(0);
            this.f28831d.setVisibility(0);
            this.f28832e.setVisibility(8);
        } else if (size == 2) {
            this.f28833f.renderView(d2.get(0));
            this.f28834g.renderView(d2.get(1));
            this.f28833f.setTag(0);
            this.f28834g.setTag(1);
            this.f28833f.setVisibility(0);
            this.f28834g.setVisibility(0);
            this.f28835h.setVisibility(8);
            this.f28836i.setVisibility(8);
            this.f28831d.setVisibility(0);
            this.f28832e.setVisibility(8);
        } else if (size != 3) {
            this.f28833f.renderView(d2.get(0));
            this.f28834g.renderView(d2.get(1));
            this.f28835h.renderView(d2.get(2));
            this.f28836i.renderView(d2.get(3));
            this.f28833f.setTag(0);
            this.f28834g.setTag(1);
            this.f28835h.setTag(2);
            this.f28836i.setTag(3);
            this.f28833f.setVisibility(0);
            this.f28834g.setVisibility(0);
            this.f28835h.setVisibility(0);
            this.f28836i.setVisibility(0);
            this.f28831d.setVisibility(0);
            this.f28832e.setVisibility(0);
        } else {
            this.f28833f.renderView(d2.get(0));
            this.f28834g.renderView(d2.get(1));
            this.f28835h.renderView(d2.get(2));
            this.f28833f.setTag(0);
            this.f28834g.setTag(1);
            this.f28835h.setTag(2);
            this.f28833f.setVisibility(0);
            this.f28834g.setVisibility(0);
            this.f28835h.setVisibility(0);
            this.f28836i.setVisibility(8);
            this.f28831d.setVisibility(0);
            this.f28832e.setVisibility(0);
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f28829b = view;
            this.f28830c = (CategoryView) view.findViewById(R.id.category);
            this.f28831d = (LinearLayout) this.f28829b.findViewById(R.id.ly_items1);
            this.f28832e = (LinearLayout) this.f28829b.findViewById(R.id.ly_items2);
            this.f28833f = (PrivilegeItemView) this.f28829b.findViewById(R.id.privilege_item1);
            this.f28834g = (PrivilegeItemView) this.f28829b.findViewById(R.id.privilege_item2);
            this.f28835h = (PrivilegeItemView) this.f28829b.findViewById(R.id.privilege_item3);
            this.f28836i = (PrivilegeItemView) this.f28829b.findViewById(R.id.privilege_item4);
            this.j = this.f28829b.findViewById(R.id.divider_sp_line);
            this.f28833f.setOnClickListener(this.l);
            this.f28834g.setOnClickListener(this.l);
            this.f28835h.setOnClickListener(this.l);
            this.f28836i.setOnClickListener(this.l);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.v0.a.a(this.f28828a.getPageContext(), this.f28829b);
        }
    }
}
