package c.a.r0.x1.c;

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
    public BaseFragmentActivity f28386a;

    /* renamed from: b  reason: collision with root package name */
    public View f28387b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryView f28388c;

    /* renamed from: d  reason: collision with root package name */
    public CooperatePrivilegeListView f28389d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.x1.c.j.f f28390e;

    /* renamed from: f  reason: collision with root package name */
    public View f28391f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.x1.c.k.e f28392g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f28393h;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28394e;

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
            this.f28394e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f28394e.f28390e == null || this.f28394e.f28390e.b().size() <= i2) {
                return;
            }
            c.a.r0.x1.c.k.f fVar = this.f28394e.f28390e.b().get(i2);
            if (fVar.f()) {
                ArrayList arrayList = new ArrayList();
                if (!this.f28394e.f28392g.c()) {
                    for (int i3 = 0; i3 < this.f28394e.f28392g.f28512e.item.size(); i3++) {
                        arrayList.add(new c.a.r0.x1.c.k.f(this.f28394e.f28392g.f28512e.item.get(i3)));
                        if (i3 == this.f28394e.f28392g.f28512e.item.size() - 1) {
                            arrayList.add(new c.a.r0.x1.c.k.f(true, true));
                        }
                    }
                    this.f28394e.f28392g.g(true);
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.f28394e.f28392g.f28512e.item.size()) {
                            break;
                        }
                        arrayList.add(new c.a.r0.x1.c.k.f(this.f28394e.f28392g.f28512e.item.get(i4)));
                        if (i4 == c.a.r0.x1.c.k.e.f28511j - 1 && this.f28394e.f28392g.f28512e.item.size() > c.a.r0.x1.c.k.e.f28511j) {
                            arrayList.add(new c.a.r0.x1.c.k.f(true, false));
                            break;
                        }
                        i4++;
                    }
                    this.f28394e.f28392g.g(false);
                }
                this.f28394e.f28390e.c(arrayList);
                this.f28394e.f28390e.notifyDataSetChanged();
            } else if (!StringUtils.isNull(fVar.e())) {
                MemberCenterStatic.a(this.f28394e.f28386a.getPageContext(), new String[]{fVar.e()});
            }
            if (!TbadkCoreApplication.isLogin() || fVar.d() <= 0) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.q0.s.d0.b.j().x("member_center_item_red_tip_" + fVar.d() + currentAccount, fVar.h());
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
        this.f28393h = new a(this);
        this.f28386a = baseFragmentActivity;
        e(view);
    }

    public void d(c.a.r0.x1.c.k.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || eVar.d() == null || eVar.d().size() <= 0) {
            return;
        }
        this.f28392g = eVar;
        this.f28388c.fillView(eVar.b());
        if (eVar.f28515h) {
            this.f28391f.setVisibility(0);
        } else {
            this.f28391f.setVisibility(8);
        }
        this.f28390e.c(eVar.d());
        this.f28390e.notifyDataSetChanged();
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f28387b = view;
            this.f28388c = (CategoryView) view.findViewById(R.id.category);
            this.f28391f = this.f28387b.findViewById(R.id.divider_sp_line);
            this.f28389d = (CooperatePrivilegeListView) this.f28387b.findViewById(R.id.cooperate_privilege_list_content);
            c.a.r0.x1.c.j.f fVar = new c.a.r0.x1.c.j.f(this.f28386a);
            this.f28390e = fVar;
            this.f28389d.setAdapter((ListAdapter) fVar);
            this.f28389d.setOnItemClickListener(this.f28393h);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w0.a.a(this.f28386a.getPageContext(), this.f28387b);
        }
    }
}
