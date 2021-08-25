package c.a.q0.w1.c;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.CategoryView;
import com.baidu.tieba.memberCenter.index.CooperatePrivilegeListView;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27679a;

    /* renamed from: b  reason: collision with root package name */
    public View f27680b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f27681c;

    /* renamed from: d  reason: collision with root package name */
    public CooperatePrivilegeListView f27682d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.w1.c.j.f f27683e;

    /* renamed from: f  reason: collision with root package name */
    public View f27684f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.w1.c.k.e f27685g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f27686h;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27687e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27687e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f27687e.f27683e == null || this.f27687e.f27683e.b().size() <= i2) {
                return;
            }
            c.a.q0.w1.c.k.f fVar = this.f27687e.f27683e.b().get(i2);
            if (fVar.f()) {
                ArrayList arrayList = new ArrayList();
                if (!this.f27687e.f27685g.c()) {
                    for (int i3 = 0; i3 < this.f27687e.f27685g.f27805e.item.size(); i3++) {
                        arrayList.add(new c.a.q0.w1.c.k.f(this.f27687e.f27685g.f27805e.item.get(i3)));
                        if (i3 == this.f27687e.f27685g.f27805e.item.size() - 1) {
                            arrayList.add(new c.a.q0.w1.c.k.f(true, true));
                        }
                    }
                    this.f27687e.f27685g.g(true);
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.f27687e.f27685g.f27805e.item.size()) {
                            break;
                        }
                        arrayList.add(new c.a.q0.w1.c.k.f(this.f27687e.f27685g.f27805e.item.get(i4)));
                        if (i4 == c.a.q0.w1.c.k.e.f27804j - 1 && this.f27687e.f27685g.f27805e.item.size() > c.a.q0.w1.c.k.e.f27804j) {
                            arrayList.add(new c.a.q0.w1.c.k.f(true, false));
                            break;
                        }
                        i4++;
                    }
                    this.f27687e.f27685g.g(false);
                }
                this.f27687e.f27683e.c(arrayList);
                this.f27687e.f27683e.notifyDataSetChanged();
            } else if (!StringUtils.isNull(fVar.e())) {
                MemberCenterStatic.a(this.f27687e.f27679a.getPageContext(), new String[]{fVar.e()});
            }
            if (!TbadkCoreApplication.isLogin() || fVar.d() <= 0) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.p0.s.d0.b.j().x("member_center_item_red_tip_" + fVar.d() + currentAccount, fVar.h());
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                relativeLayout.findViewById(R.id.privilege_new_icon).setVisibility(8);
                relativeLayout.findViewById(R.id.privilege_red_dot).setVisibility(8);
            }
        }
    }

    public c(BaseFragmentActivity baseFragmentActivity, View view) {
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
        this.f27686h = new a(this);
        this.f27679a = baseFragmentActivity;
        e(view);
    }

    public void d(c.a.q0.w1.c.k.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.d() == null || eVar.d().size() <= 0) {
            return;
        }
        this.f27685g = eVar;
        this.f27681c.fillView(eVar.b());
        if (eVar.f27808h) {
            this.f27684f.setVisibility(0);
        } else {
            this.f27684f.setVisibility(8);
        }
        this.f27683e.c(eVar.d());
        this.f27683e.notifyDataSetChanged();
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f27680b = view;
            this.f27681c = (CategoryView) view.findViewById(R.id.category);
            this.f27684f = this.f27680b.findViewById(R.id.divider_sp_line);
            this.f27682d = (CooperatePrivilegeListView) this.f27680b.findViewById(R.id.cooperate_privilege_list_content);
            c.a.q0.w1.c.j.f fVar = new c.a.q0.w1.c.j.f(this.f27679a);
            this.f27683e = fVar;
            this.f27682d.setAdapter((ListAdapter) fVar);
            this.f27682d.setOnItemClickListener(this.f27686h);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.u0.a.a(this.f27679a.getPageContext(), this.f27680b);
        }
    }
}
