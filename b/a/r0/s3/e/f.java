package b.a.r0.s3.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.s.g0.f;
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
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f24923a;

    /* renamed from: b  reason: collision with root package name */
    public View f24924b;

    /* renamed from: c  reason: collision with root package name */
    public View f24925c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24926d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f24927e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f24928f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.g0.g f24929g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24930h;

    /* renamed from: i  reason: collision with root package name */
    public e f24931i;
    public int j;

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
        this.f24929g = null;
        this.j = 0;
        this.f24923a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f24923a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f24924b = inflate;
        this.f24923a.setContentView(inflate);
        this.f24925c = this.f24924b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f24924b.findViewById(R.id.view_navigation_bar);
        this.f24926d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24926d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f24924b.findViewById(R.id.view_member_recommend);
        this.f24927e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f24928f = (BdListView) this.f24924b.findViewById(R.id.listview_bg_list);
        b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(this.f24923a.getPageContext());
        this.f24929g = gVar;
        this.f24928f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f24923a.getActivity());
        this.f24930h = textView;
        textView.setHeight(l.g(this.f24923a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f24923a.getPageContext(), dVar);
        this.f24931i = eVar;
        this.f24928f.setAdapter((ListAdapter) eVar);
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
            SkinManager.setBackgroundColor(this.f24924b, R.color.CAM_X0204);
            this.f24923a.hideNetRefreshView(this.f24924b);
            this.f24925c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24924b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.q0.v0.a.a(this.f24923a.getPageContext(), this.f24924b);
            NavigationBar navigationBar = this.f24926d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f24923a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f24928f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f24931i) != null) {
                eVar.notifyDataSetChanged();
            }
            b.a.q0.s.g0.g gVar = this.f24929g;
            if (gVar != null) {
                gVar.C(TbadkApplication.getInst().getSkinType());
            }
            this.f24927e.changeSkinType();
            SkinManager.setBackgroundColor(this.f24930h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f24928f.setVisibility(0);
                this.f24931i.b(list);
                this.f24931i.notifyDataSetChanged();
                return;
            }
            this.f24928f.setVisibility(8);
        }
    }

    public final boolean f(b.a.r0.s3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f24927e.setVisibility(0);
                this.f24927e.fillView(eVar);
                return true;
            }
            this.f24927e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f24928f.setOnSrollToBottomListener(pVar);
            this.f24929g.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f24925c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f24924b, R.color.CAM_X0201);
            String string = this.f24923a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f24923a.setNetRefreshViewTopMargin(this.j);
            this.f24923a.showNetRefreshView(this.f24924b, string, false);
        }
    }

    public void i(b.a.r0.s3.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f24928f.removeHeaderView(this.f24930h);
                    this.f24928f.addHeaderView(this.f24930h);
                } else {
                    this.f24928f.removeHeaderView(this.f24930h);
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
            this.f24928f.completePullRefreshPostDelayed(0L);
        }
    }
}
