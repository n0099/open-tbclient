package c.a.t0.g2.c;

import android.view.View;
import android.widget.LinearLayout;
import c.a.t0.g2.c.k.n;
import c.a.t0.g2.c.k.o;
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
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f17814b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f17815c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f17816d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f17817e;

    /* renamed from: f  reason: collision with root package name */
    public PrivilegeItemView f17818f;

    /* renamed from: g  reason: collision with root package name */
    public PrivilegeItemView f17819g;

    /* renamed from: h  reason: collision with root package name */
    public PrivilegeItemView f17820h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeItemView f17821i;

    /* renamed from: j  reason: collision with root package name */
    public View f17822j;
    public n k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f17823e;

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
            this.f17823e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= 4) {
                return;
            }
            o oVar = this.f17823e.k.d().get(intValue);
            TiebaStatic.log(new StatisticItem("c11217").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", intValue + 1));
            if (!StringUtils.isNull(oVar.e())) {
                MemberCenterStatic.a(this.f17823e.a.getPageContext(), new String[]{oVar.e()});
            }
            if (oVar.d() > 0) {
                String currentAccount = !TbadkCoreApplication.isLogin() ? SevenZipUtils.FILE_NAME_TEMP : TbadkCoreApplication.getCurrentAccount();
                c.a.s0.s.i0.b.k().y("member_center_item_red_tip_" + oVar.d() + currentAccount, oVar.g());
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
        this.a = baseFragmentActivity;
        d(view);
    }

    public void c(n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) || nVar == null || nVar.d() == null || nVar.d().size() <= 0) {
            return;
        }
        this.k = nVar;
        this.f17815c.fillView(nVar.a());
        if (nVar.f17944g) {
            this.f17822j.setVisibility(0);
        } else {
            this.f17822j.setVisibility(8);
        }
        List<o> d2 = nVar.d();
        int size = d2.size();
        if (size == 1) {
            this.f17818f.renderView(d2.get(0));
            this.f17818f.setVisibility(0);
            this.f17819g.setVisibility(8);
            this.f17820h.setVisibility(8);
            this.f17821i.setVisibility(8);
            this.f17818f.setTag(0);
            this.f17816d.setVisibility(0);
            this.f17817e.setVisibility(8);
        } else if (size == 2) {
            this.f17818f.renderView(d2.get(0));
            this.f17819g.renderView(d2.get(1));
            this.f17818f.setTag(0);
            this.f17819g.setTag(1);
            this.f17818f.setVisibility(0);
            this.f17819g.setVisibility(0);
            this.f17820h.setVisibility(8);
            this.f17821i.setVisibility(8);
            this.f17816d.setVisibility(0);
            this.f17817e.setVisibility(8);
        } else if (size != 3) {
            this.f17818f.renderView(d2.get(0));
            this.f17819g.renderView(d2.get(1));
            this.f17820h.renderView(d2.get(2));
            this.f17821i.renderView(d2.get(3));
            this.f17818f.setTag(0);
            this.f17819g.setTag(1);
            this.f17820h.setTag(2);
            this.f17821i.setTag(3);
            this.f17818f.setVisibility(0);
            this.f17819g.setVisibility(0);
            this.f17820h.setVisibility(0);
            this.f17821i.setVisibility(0);
            this.f17816d.setVisibility(0);
            this.f17817e.setVisibility(0);
        } else {
            this.f17818f.renderView(d2.get(0));
            this.f17819g.renderView(d2.get(1));
            this.f17820h.renderView(d2.get(2));
            this.f17818f.setTag(0);
            this.f17819g.setTag(1);
            this.f17820h.setTag(2);
            this.f17818f.setVisibility(0);
            this.f17819g.setVisibility(0);
            this.f17820h.setVisibility(0);
            this.f17821i.setVisibility(8);
            this.f17816d.setVisibility(0);
            this.f17817e.setVisibility(0);
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f17814b = view;
            this.f17815c = (CategoryView) view.findViewById(R.id.category);
            this.f17816d = (LinearLayout) this.f17814b.findViewById(R.id.ly_items1);
            this.f17817e = (LinearLayout) this.f17814b.findViewById(R.id.ly_items2);
            this.f17818f = (PrivilegeItemView) this.f17814b.findViewById(R.id.privilege_item1);
            this.f17819g = (PrivilegeItemView) this.f17814b.findViewById(R.id.privilege_item2);
            this.f17820h = (PrivilegeItemView) this.f17814b.findViewById(R.id.privilege_item3);
            this.f17821i = (PrivilegeItemView) this.f17814b.findViewById(R.id.privilege_item4);
            this.f17822j = this.f17814b.findViewById(R.id.divider_sp_line);
            this.f17818f.setOnClickListener(this.l);
            this.f17819g.setOnClickListener(this.l);
            this.f17820h.setOnClickListener(this.l);
            this.f17821i.setOnClickListener(this.l);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f17814b);
        }
    }
}
