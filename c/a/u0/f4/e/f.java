package c.a.u0.f4.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.l0.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.BackgroundListActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f17762b;

    /* renamed from: c  reason: collision with root package name */
    public View f17763c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f17764d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f17765e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f17766f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.s.l0.g f17767g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17768h;

    /* renamed from: i  reason: collision with root package name */
    public e f17769i;

    /* renamed from: j  reason: collision with root package name */
    public int f17770j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundListActivity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17767g = null;
        this.f17770j = 0;
        this.a = backgroundListActivity;
        this.f17770j = n.f(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f17762b = inflate;
        this.a.setContentView(inflate);
        this.f17763c = this.f17762b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f17762b.findViewById(R.id.view_navigation_bar);
        this.f17764d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f17764d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f17762b.findViewById(R.id.view_member_recommend);
        this.f17765e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f17766f = (BdListView) this.f17762b.findViewById(R.id.listview_bg_list);
        c.a.t0.s.l0.g gVar = new c.a.t0.s.l0.g(this.a.getPageContext());
        this.f17767g = gVar;
        this.f17766f.setPullRefresh(gVar);
        TextView textView = new TextView(this.a.getActivity());
        this.f17768h = textView;
        textView.setHeight(n.f(this.a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.a.getPageContext(), dVar);
        this.f17769i = eVar;
        this.f17766f.setAdapter((ListAdapter) eVar);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 = i2 + 2 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < 3; i3++) {
                    int i4 = i2 + i3;
                    if (i4 < size) {
                        arrayList2.add(list.get(i4));
                    }
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.f17762b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.f17762b);
            this.f17763c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17762b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.t0.x0.a.a(this.a.getPageContext(), this.f17762b);
            NavigationBar navigationBar = this.f17764d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f17766f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f17769i) != null) {
                eVar.notifyDataSetChanged();
            }
            c.a.t0.s.l0.g gVar = this.f17767g;
            if (gVar != null) {
                gVar.C(TbadkApplication.getInst().getSkinType());
            }
            this.f17765e.changeSkinType();
            SkinManager.setBackgroundColor(this.f17768h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f17766f.setVisibility(0);
                this.f17769i.b(list);
                this.f17769i.notifyDataSetChanged();
                return;
            }
            this.f17766f.setVisibility(8);
        }
    }

    public final boolean f(c.a.u0.f4.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f17765e.setVisibility(0);
                this.f17765e.fillView(eVar);
                return true;
            }
            this.f17765e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f17766f.setOnSrollToBottomListener(pVar);
            this.f17767g.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f17763c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f17762b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(this.f17770j);
            this.a.showNetRefreshView(this.f17762b, string, false);
        }
    }

    public void i(c.a.u0.f4.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f17766f.removeHeaderView(this.f17768h);
                    this.f17766f.addHeaderView(this.f17768h);
                } else {
                    this.f17766f.removeHeaderView(this.f17768h);
                }
                e(a(list));
                return;
            }
            h();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f17766f.completePullRefreshPostDelayed(0L);
        }
    }
}
