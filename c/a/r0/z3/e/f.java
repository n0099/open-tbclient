package c.a.r0.z3.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.g0.f;
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
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f25956b;

    /* renamed from: c  reason: collision with root package name */
    public View f25957c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f25958d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f25959e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f25960f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.g0.g f25961g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25962h;

    /* renamed from: i  reason: collision with root package name */
    public e f25963i;

    /* renamed from: j  reason: collision with root package name */
    public int f25964j;

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
        this.f25961g = null;
        this.f25964j = 0;
        this.a = backgroundListActivity;
        this.f25964j = l.f(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f25956b = inflate;
        this.a.setContentView(inflate);
        this.f25957c = this.f25956b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f25956b.findViewById(R.id.view_navigation_bar);
        this.f25958d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f25958d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f25956b.findViewById(R.id.view_member_recommend);
        this.f25959e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f25960f = (BdListView) this.f25956b.findViewById(R.id.listview_bg_list);
        c.a.q0.s.g0.g gVar = new c.a.q0.s.g0.g(this.a.getPageContext());
        this.f25961g = gVar;
        this.f25960f.setPullRefresh(gVar);
        TextView textView = new TextView(this.a.getActivity());
        this.f25962h = textView;
        textView.setHeight(l.f(this.a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.a.getPageContext(), dVar);
        this.f25963i = eVar;
        this.f25960f.setAdapter((ListAdapter) eVar);
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
            SkinManager.setBackgroundColor(this.f25956b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.f25956b);
            this.f25957c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25956b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.w0.a.a(this.a.getPageContext(), this.f25956b);
            NavigationBar navigationBar = this.f25958d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f25960f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f25963i) != null) {
                eVar.notifyDataSetChanged();
            }
            c.a.q0.s.g0.g gVar = this.f25961g;
            if (gVar != null) {
                gVar.C(TbadkApplication.getInst().getSkinType());
            }
            this.f25959e.changeSkinType();
            SkinManager.setBackgroundColor(this.f25962h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f25960f.setVisibility(0);
                this.f25963i.b(list);
                this.f25963i.notifyDataSetChanged();
                return;
            }
            this.f25960f.setVisibility(8);
        }
    }

    public final boolean f(c.a.r0.z3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f25959e.setVisibility(0);
                this.f25959e.fillView(eVar);
                return true;
            }
            this.f25959e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f25960f.setOnSrollToBottomListener(pVar);
            this.f25961g.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25957c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f25956b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(this.f25964j);
            this.a.showNetRefreshView(this.f25956b, string, false);
        }
    }

    public void i(c.a.r0.z3.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f25960f.removeHeaderView(this.f25962h);
                    this.f25960f.addHeaderView(this.f25962h);
                } else {
                    this.f25960f.removeHeaderView(this.f25962h);
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
            this.f25960f.completePullRefreshPostDelayed(0L);
        }
    }
}
