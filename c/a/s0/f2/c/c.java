package c.a.s0.f2.c;

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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f17268b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f17269c;

    /* renamed from: d  reason: collision with root package name */
    public CooperatePrivilegeListView f17270d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.f2.c.j.f f17271e;

    /* renamed from: f  reason: collision with root package name */
    public View f17272f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.f2.c.k.e f17273g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f17274h;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17275e;

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
            this.f17275e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f17275e.f17271e == null || this.f17275e.f17271e.b().size() <= i2) {
                return;
            }
            c.a.s0.f2.c.k.f fVar = this.f17275e.f17271e.b().get(i2);
            if (fVar.f()) {
                ArrayList arrayList = new ArrayList();
                if (!this.f17275e.f17273g.d()) {
                    for (int i3 = 0; i3 < this.f17275e.f17273g.f17383e.item.size(); i3++) {
                        arrayList.add(new c.a.s0.f2.c.k.f(this.f17275e.f17273g.f17383e.item.get(i3)));
                        if (i3 == this.f17275e.f17273g.f17383e.item.size() - 1) {
                            arrayList.add(new c.a.s0.f2.c.k.f(true, true));
                        }
                    }
                    this.f17275e.f17273g.g(true);
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.f17275e.f17273g.f17383e.item.size()) {
                            break;
                        }
                        arrayList.add(new c.a.s0.f2.c.k.f(this.f17275e.f17273g.f17383e.item.get(i4)));
                        if (i4 == c.a.s0.f2.c.k.e.f17381j - 1 && this.f17275e.f17273g.f17383e.item.size() > c.a.s0.f2.c.k.e.f17381j) {
                            arrayList.add(new c.a.s0.f2.c.k.f(true, false));
                            break;
                        }
                        i4++;
                    }
                    this.f17275e.f17273g.g(false);
                }
                this.f17275e.f17271e.c(arrayList);
                this.f17275e.f17271e.notifyDataSetChanged();
            } else if (!StringUtils.isNull(fVar.e())) {
                MemberCenterStatic.a(this.f17275e.a.getPageContext(), new String[]{fVar.e()});
            }
            if (!TbadkCoreApplication.isLogin() || fVar.d() <= 0) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.r0.s.g0.b.j().x("member_center_item_red_tip_" + fVar.d() + currentAccount, fVar.h());
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
        this.f17274h = new a(this);
        this.a = baseFragmentActivity;
        e(view);
    }

    public void d(c.a.s0.f2.c.k.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.e() == null || eVar.e().size() <= 0) {
            return;
        }
        this.f17273g = eVar;
        this.f17269c.fillView(eVar.a());
        if (eVar.f17386h) {
            this.f17272f.setVisibility(0);
        } else {
            this.f17272f.setVisibility(8);
        }
        this.f17271e.c(eVar.e());
        this.f17271e.notifyDataSetChanged();
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f17268b = view;
            this.f17269c = (CategoryView) view.findViewById(R.id.category);
            this.f17272f = this.f17268b.findViewById(R.id.divider_sp_line);
            this.f17270d = (CooperatePrivilegeListView) this.f17268b.findViewById(R.id.cooperate_privilege_list_content);
            c.a.s0.f2.c.j.f fVar = new c.a.s0.f2.c.j.f(this.a);
            this.f17271e = fVar;
            this.f17270d.setAdapter((ListAdapter) fVar);
            this.f17270d.setOnItemClickListener(this.f17274h);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.w0.a.a(this.a.getPageContext(), this.f17268b);
        }
    }
}
