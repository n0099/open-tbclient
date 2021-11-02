package b.a.r0.y1.c;

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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27291a;

    /* renamed from: b  reason: collision with root package name */
    public View f27292b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f27293c;

    /* renamed from: d  reason: collision with root package name */
    public CooperatePrivilegeListView f27294d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.y1.c.j.f f27295e;

    /* renamed from: f  reason: collision with root package name */
    public View f27296f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.y1.c.k.e f27297g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f27298h;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27299e;

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
            this.f27299e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f27299e.f27295e == null || this.f27299e.f27295e.b().size() <= i2) {
                return;
            }
            b.a.r0.y1.c.k.f fVar = this.f27299e.f27295e.b().get(i2);
            if (fVar.f()) {
                ArrayList arrayList = new ArrayList();
                if (!this.f27299e.f27297g.d()) {
                    for (int i3 = 0; i3 < this.f27299e.f27297g.f27413e.item.size(); i3++) {
                        arrayList.add(new b.a.r0.y1.c.k.f(this.f27299e.f27297g.f27413e.item.get(i3)));
                        if (i3 == this.f27299e.f27297g.f27413e.item.size() - 1) {
                            arrayList.add(new b.a.r0.y1.c.k.f(true, true));
                        }
                    }
                    this.f27299e.f27297g.g(true);
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.f27299e.f27297g.f27413e.item.size()) {
                            break;
                        }
                        arrayList.add(new b.a.r0.y1.c.k.f(this.f27299e.f27297g.f27413e.item.get(i4)));
                        if (i4 == b.a.r0.y1.c.k.e.j - 1 && this.f27299e.f27297g.f27413e.item.size() > b.a.r0.y1.c.k.e.j) {
                            arrayList.add(new b.a.r0.y1.c.k.f(true, false));
                            break;
                        }
                        i4++;
                    }
                    this.f27299e.f27297g.g(false);
                }
                this.f27299e.f27295e.c(arrayList);
                this.f27299e.f27295e.notifyDataSetChanged();
            } else if (!StringUtils.isNull(fVar.e())) {
                MemberCenterStatic.a(this.f27299e.f27291a.getPageContext(), new String[]{fVar.e()});
            }
            if (!TbadkCoreApplication.isLogin() || fVar.d() <= 0) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            b.a.q0.s.e0.b.j().x("member_center_item_red_tip_" + fVar.d() + currentAccount, fVar.h());
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
        this.f27298h = new a(this);
        this.f27291a = baseFragmentActivity;
        e(view);
    }

    public void d(b.a.r0.y1.c.k.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.e() == null || eVar.e().size() <= 0) {
            return;
        }
        this.f27297g = eVar;
        this.f27293c.fillView(eVar.a());
        if (eVar.f27416h) {
            this.f27296f.setVisibility(0);
        } else {
            this.f27296f.setVisibility(8);
        }
        this.f27295e.c(eVar.e());
        this.f27295e.notifyDataSetChanged();
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f27292b = view;
            this.f27293c = (CategoryView) view.findViewById(R.id.category);
            this.f27296f = this.f27292b.findViewById(R.id.divider_sp_line);
            this.f27294d = (CooperatePrivilegeListView) this.f27292b.findViewById(R.id.cooperate_privilege_list_content);
            b.a.r0.y1.c.j.f fVar = new b.a.r0.y1.c.j.f(this.f27291a);
            this.f27295e = fVar;
            this.f27294d.setAdapter((ListAdapter) fVar);
            this.f27294d.setOnItemClickListener(this.f27298h);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.w0.a.a(this.f27291a.getPageContext(), this.f27292b);
        }
    }
}
