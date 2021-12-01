package c.a.r0.e2.c;

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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f16706b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f16707c;

    /* renamed from: d  reason: collision with root package name */
    public CooperatePrivilegeListView f16708d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.e2.c.j.f f16709e;

    /* renamed from: f  reason: collision with root package name */
    public View f16710f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.e2.c.k.e f16711g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f16712h;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16713e;

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
            this.f16713e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f16713e.f16709e == null || this.f16713e.f16709e.b().size() <= i2) {
                return;
            }
            c.a.r0.e2.c.k.f fVar = this.f16713e.f16709e.b().get(i2);
            if (fVar.f()) {
                ArrayList arrayList = new ArrayList();
                if (!this.f16713e.f16711g.d()) {
                    for (int i3 = 0; i3 < this.f16713e.f16711g.f16821e.item.size(); i3++) {
                        arrayList.add(new c.a.r0.e2.c.k.f(this.f16713e.f16711g.f16821e.item.get(i3)));
                        if (i3 == this.f16713e.f16711g.f16821e.item.size() - 1) {
                            arrayList.add(new c.a.r0.e2.c.k.f(true, true));
                        }
                    }
                    this.f16713e.f16711g.g(true);
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.f16713e.f16711g.f16821e.item.size()) {
                            break;
                        }
                        arrayList.add(new c.a.r0.e2.c.k.f(this.f16713e.f16711g.f16821e.item.get(i4)));
                        if (i4 == c.a.r0.e2.c.k.e.f16819j - 1 && this.f16713e.f16711g.f16821e.item.size() > c.a.r0.e2.c.k.e.f16819j) {
                            arrayList.add(new c.a.r0.e2.c.k.f(true, false));
                            break;
                        }
                        i4++;
                    }
                    this.f16713e.f16711g.g(false);
                }
                this.f16713e.f16709e.c(arrayList);
                this.f16713e.f16709e.notifyDataSetChanged();
            } else if (!StringUtils.isNull(fVar.e())) {
                MemberCenterStatic.a(this.f16713e.a.getPageContext(), new String[]{fVar.e()});
            }
            if (!TbadkCoreApplication.isLogin() || fVar.d() <= 0) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.q0.s.e0.b.j().x("member_center_item_red_tip_" + fVar.d() + currentAccount, fVar.h());
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
        this.f16712h = new a(this);
        this.a = baseFragmentActivity;
        e(view);
    }

    public void d(c.a.r0.e2.c.k.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.e() == null || eVar.e().size() <= 0) {
            return;
        }
        this.f16711g = eVar;
        this.f16707c.fillView(eVar.a());
        if (eVar.f16824h) {
            this.f16710f.setVisibility(0);
        } else {
            this.f16710f.setVisibility(8);
        }
        this.f16709e.c(eVar.e());
        this.f16709e.notifyDataSetChanged();
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f16706b = view;
            this.f16707c = (CategoryView) view.findViewById(R.id.category);
            this.f16710f = this.f16706b.findViewById(R.id.divider_sp_line);
            this.f16708d = (CooperatePrivilegeListView) this.f16706b.findViewById(R.id.cooperate_privilege_list_content);
            c.a.r0.e2.c.j.f fVar = new c.a.r0.e2.c.j.f(this.a);
            this.f16709e = fVar;
            this.f16708d.setAdapter((ListAdapter) fVar);
            this.f16708d.setOnItemClickListener(this.f16712h);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.a.getPageContext(), this.f16706b);
        }
    }
}
