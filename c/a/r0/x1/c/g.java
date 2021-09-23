package c.a.r0.x1.c;

import android.view.View;
import android.widget.LinearLayout;
import c.a.r0.x1.c.k.n;
import c.a.r0.x1.c.k.o;
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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f28420a;

    /* renamed from: b  reason: collision with root package name */
    public View f28421b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f28422c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f28423d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f28424e;

    /* renamed from: f  reason: collision with root package name */
    public PrivilegeItemView f28425f;

    /* renamed from: g  reason: collision with root package name */
    public PrivilegeItemView f28426g;

    /* renamed from: h  reason: collision with root package name */
    public PrivilegeItemView f28427h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeItemView f28428i;

    /* renamed from: j  reason: collision with root package name */
    public View f28429j;
    public n k;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f28430e;

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
            this.f28430e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= 4) {
                return;
            }
            o oVar = this.f28430e.k.c().get(intValue);
            TiebaStatic.log(new StatisticItem("c11217").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", intValue + 1));
            if (!StringUtils.isNull(oVar.e())) {
                MemberCenterStatic.a(this.f28430e.f28420a.getPageContext(), new String[]{oVar.e()});
            }
            if (oVar.d() > 0) {
                String currentAccount = !TbadkCoreApplication.isLogin() ? SevenZipUtils.FILE_NAME_TEMP : TbadkCoreApplication.getCurrentAccount();
                c.a.q0.s.d0.b.j().x("member_center_item_red_tip_" + oVar.d() + currentAccount, oVar.g());
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
        this.f28420a = baseFragmentActivity;
        d(view);
    }

    public void c(n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) || nVar == null || nVar.c() == null || nVar.c().size() <= 0) {
            return;
        }
        this.k = nVar;
        this.f28422c.fillView(nVar.b());
        if (nVar.f28564g) {
            this.f28429j.setVisibility(0);
        } else {
            this.f28429j.setVisibility(8);
        }
        List<o> c2 = nVar.c();
        int size = c2.size();
        if (size == 1) {
            this.f28425f.renderView(c2.get(0));
            this.f28425f.setVisibility(0);
            this.f28426g.setVisibility(8);
            this.f28427h.setVisibility(8);
            this.f28428i.setVisibility(8);
            this.f28425f.setTag(0);
            this.f28423d.setVisibility(0);
            this.f28424e.setVisibility(8);
        } else if (size == 2) {
            this.f28425f.renderView(c2.get(0));
            this.f28426g.renderView(c2.get(1));
            this.f28425f.setTag(0);
            this.f28426g.setTag(1);
            this.f28425f.setVisibility(0);
            this.f28426g.setVisibility(0);
            this.f28427h.setVisibility(8);
            this.f28428i.setVisibility(8);
            this.f28423d.setVisibility(0);
            this.f28424e.setVisibility(8);
        } else if (size != 3) {
            this.f28425f.renderView(c2.get(0));
            this.f28426g.renderView(c2.get(1));
            this.f28427h.renderView(c2.get(2));
            this.f28428i.renderView(c2.get(3));
            this.f28425f.setTag(0);
            this.f28426g.setTag(1);
            this.f28427h.setTag(2);
            this.f28428i.setTag(3);
            this.f28425f.setVisibility(0);
            this.f28426g.setVisibility(0);
            this.f28427h.setVisibility(0);
            this.f28428i.setVisibility(0);
            this.f28423d.setVisibility(0);
            this.f28424e.setVisibility(0);
        } else {
            this.f28425f.renderView(c2.get(0));
            this.f28426g.renderView(c2.get(1));
            this.f28427h.renderView(c2.get(2));
            this.f28425f.setTag(0);
            this.f28426g.setTag(1);
            this.f28427h.setTag(2);
            this.f28425f.setVisibility(0);
            this.f28426g.setVisibility(0);
            this.f28427h.setVisibility(0);
            this.f28428i.setVisibility(8);
            this.f28423d.setVisibility(0);
            this.f28424e.setVisibility(0);
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f28421b = view;
            this.f28422c = (CategoryView) view.findViewById(R.id.category);
            this.f28423d = (LinearLayout) this.f28421b.findViewById(R.id.ly_items1);
            this.f28424e = (LinearLayout) this.f28421b.findViewById(R.id.ly_items2);
            this.f28425f = (PrivilegeItemView) this.f28421b.findViewById(R.id.privilege_item1);
            this.f28426g = (PrivilegeItemView) this.f28421b.findViewById(R.id.privilege_item2);
            this.f28427h = (PrivilegeItemView) this.f28421b.findViewById(R.id.privilege_item3);
            this.f28428i = (PrivilegeItemView) this.f28421b.findViewById(R.id.privilege_item4);
            this.f28429j = this.f28421b.findViewById(R.id.divider_sp_line);
            this.f28425f.setOnClickListener(this.l);
            this.f28426g.setOnClickListener(this.l);
            this.f28427h.setOnClickListener(this.l);
            this.f28428i.setOnClickListener(this.l);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f28420a.getPageContext(), this.f28421b);
        }
    }
}
