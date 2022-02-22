package c.a.u0.h2.c;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f18246b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f18247c;

    /* renamed from: d  reason: collision with root package name */
    public CooperatePrivilegeListView f18248d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.u0.h2.c.j.f f18249e;

    /* renamed from: f  reason: collision with root package name */
    public View f18250f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.u0.h2.c.k.e f18251g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f18252h;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18253e;

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
            this.f18253e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f18253e.f18249e == null || this.f18253e.f18249e.b().size() <= i2) {
                return;
            }
            c.a.u0.h2.c.k.f fVar = this.f18253e.f18249e.b().get(i2);
            if (fVar.f()) {
                ArrayList arrayList = new ArrayList();
                if (!this.f18253e.f18251g.d()) {
                    for (int i3 = 0; i3 < this.f18253e.f18251g.f18358e.item.size(); i3++) {
                        arrayList.add(new c.a.u0.h2.c.k.f(this.f18253e.f18251g.f18358e.item.get(i3)));
                        if (i3 == this.f18253e.f18251g.f18358e.item.size() - 1) {
                            arrayList.add(new c.a.u0.h2.c.k.f(true, true));
                        }
                    }
                    this.f18253e.f18251g.g(true);
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.f18253e.f18251g.f18358e.item.size()) {
                            break;
                        }
                        arrayList.add(new c.a.u0.h2.c.k.f(this.f18253e.f18251g.f18358e.item.get(i4)));
                        if (i4 == c.a.u0.h2.c.k.e.f18357j - 1 && this.f18253e.f18251g.f18358e.item.size() > c.a.u0.h2.c.k.e.f18357j) {
                            arrayList.add(new c.a.u0.h2.c.k.f(true, false));
                            break;
                        }
                        i4++;
                    }
                    this.f18253e.f18251g.g(false);
                }
                this.f18253e.f18249e.c(arrayList);
                this.f18253e.f18249e.notifyDataSetChanged();
            } else if (!StringUtils.isNull(fVar.e())) {
                MemberCenterStatic.a(this.f18253e.a.getPageContext(), new String[]{fVar.e()});
            }
            if (!TbadkCoreApplication.isLogin() || fVar.d() <= 0) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.t0.s.j0.b.k().y("member_center_item_red_tip_" + fVar.d() + currentAccount, fVar.h());
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
        this.f18252h = new a(this);
        this.a = baseFragmentActivity;
        e(view);
    }

    public void d(c.a.u0.h2.c.k.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.e() == null || eVar.e().size() <= 0) {
            return;
        }
        this.f18251g = eVar;
        this.f18247c.fillView(eVar.a());
        if (eVar.f18361h) {
            this.f18250f.setVisibility(0);
        } else {
            this.f18250f.setVisibility(8);
        }
        this.f18249e.c(eVar.e());
        this.f18249e.notifyDataSetChanged();
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f18246b = view;
            this.f18247c = (CategoryView) view.findViewById(R.id.category);
            this.f18250f = this.f18246b.findViewById(R.id.divider_sp_line);
            this.f18248d = (CooperatePrivilegeListView) this.f18246b.findViewById(R.id.cooperate_privilege_list_content);
            c.a.u0.h2.c.j.f fVar = new c.a.u0.h2.c.j.f(this.a);
            this.f18249e = fVar;
            this.f18248d.setAdapter((ListAdapter) fVar);
            this.f18248d.setOnItemClickListener(this.f18252h);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.x0.a.a(this.a.getPageContext(), this.f18246b);
        }
    }
}
