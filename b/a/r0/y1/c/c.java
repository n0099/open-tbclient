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
    public BaseFragmentActivity f28794a;

    /* renamed from: b  reason: collision with root package name */
    public View f28795b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f28796c;

    /* renamed from: d  reason: collision with root package name */
    public CooperatePrivilegeListView f28797d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.y1.c.j.f f28798e;

    /* renamed from: f  reason: collision with root package name */
    public View f28799f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.y1.c.k.e f28800g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f28801h;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28802e;

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
            this.f28802e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f28802e.f28798e == null || this.f28802e.f28798e.b().size() <= i2) {
                return;
            }
            b.a.r0.y1.c.k.f fVar = this.f28802e.f28798e.b().get(i2);
            if (fVar.f()) {
                ArrayList arrayList = new ArrayList();
                if (!this.f28802e.f28800g.d()) {
                    for (int i3 = 0; i3 < this.f28802e.f28800g.f28916e.item.size(); i3++) {
                        arrayList.add(new b.a.r0.y1.c.k.f(this.f28802e.f28800g.f28916e.item.get(i3)));
                        if (i3 == this.f28802e.f28800g.f28916e.item.size() - 1) {
                            arrayList.add(new b.a.r0.y1.c.k.f(true, true));
                        }
                    }
                    this.f28802e.f28800g.g(true);
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.f28802e.f28800g.f28916e.item.size()) {
                            break;
                        }
                        arrayList.add(new b.a.r0.y1.c.k.f(this.f28802e.f28800g.f28916e.item.get(i4)));
                        if (i4 == b.a.r0.y1.c.k.e.j - 1 && this.f28802e.f28800g.f28916e.item.size() > b.a.r0.y1.c.k.e.j) {
                            arrayList.add(new b.a.r0.y1.c.k.f(true, false));
                            break;
                        }
                        i4++;
                    }
                    this.f28802e.f28800g.g(false);
                }
                this.f28802e.f28798e.c(arrayList);
                this.f28802e.f28798e.notifyDataSetChanged();
            } else if (!StringUtils.isNull(fVar.e())) {
                MemberCenterStatic.a(this.f28802e.f28794a.getPageContext(), new String[]{fVar.e()});
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
        this.f28801h = new a(this);
        this.f28794a = baseFragmentActivity;
        e(view);
    }

    public void d(b.a.r0.y1.c.k.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.e() == null || eVar.e().size() <= 0) {
            return;
        }
        this.f28800g = eVar;
        this.f28796c.fillView(eVar.a());
        if (eVar.f28919h) {
            this.f28799f.setVisibility(0);
        } else {
            this.f28799f.setVisibility(8);
        }
        this.f28798e.c(eVar.e());
        this.f28798e.notifyDataSetChanged();
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f28795b = view;
            this.f28796c = (CategoryView) view.findViewById(R.id.category);
            this.f28799f = this.f28795b.findViewById(R.id.divider_sp_line);
            this.f28797d = (CooperatePrivilegeListView) this.f28795b.findViewById(R.id.cooperate_privilege_list_content);
            b.a.r0.y1.c.j.f fVar = new b.a.r0.y1.c.j.f(this.f28794a);
            this.f28798e = fVar;
            this.f28797d.setAdapter((ListAdapter) fVar);
            this.f28797d.setOnItemClickListener(this.f28801h);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.v0.a.a(this.f28794a.getPageContext(), this.f28795b);
        }
    }
}
