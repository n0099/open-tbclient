package b.a.r0.r3.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
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
    public BackgroundListActivity f23136a;

    /* renamed from: b  reason: collision with root package name */
    public View f23137b;

    /* renamed from: c  reason: collision with root package name */
    public View f23138c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23139d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f23140e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f23141f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.g0.g f23142g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23143h;

    /* renamed from: i  reason: collision with root package name */
    public e f23144i;
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
        this.f23142g = null;
        this.j = 0;
        this.f23136a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f23136a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f23137b = inflate;
        this.f23136a.setContentView(inflate);
        this.f23138c = this.f23137b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f23137b.findViewById(R.id.view_navigation_bar);
        this.f23139d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23139d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f23137b.findViewById(R.id.view_member_recommend);
        this.f23140e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f23141f = (BdListView) this.f23137b.findViewById(R.id.listview_bg_list);
        b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(this.f23136a.getPageContext());
        this.f23142g = gVar;
        this.f23141f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f23136a.getActivity());
        this.f23143h = textView;
        textView.setHeight(l.g(this.f23136a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f23136a.getPageContext(), dVar);
        this.f23144i = eVar;
        this.f23141f.setAdapter((ListAdapter) eVar);
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
            SkinManager.setBackgroundColor(this.f23137b, R.color.CAM_X0204);
            this.f23136a.hideNetRefreshView(this.f23137b);
            this.f23138c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23137b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.q0.w0.a.a(this.f23136a.getPageContext(), this.f23137b);
            NavigationBar navigationBar = this.f23139d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23136a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f23141f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f23144i) != null) {
                eVar.notifyDataSetChanged();
            }
            b.a.q0.s.g0.g gVar = this.f23142g;
            if (gVar != null) {
                gVar.C(TbadkApplication.getInst().getSkinType());
            }
            this.f23140e.changeSkinType();
            SkinManager.setBackgroundColor(this.f23143h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f23141f.setVisibility(0);
                this.f23144i.b(list);
                this.f23144i.notifyDataSetChanged();
                return;
            }
            this.f23141f.setVisibility(8);
        }
    }

    public final boolean f(b.a.r0.r3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f23140e.setVisibility(0);
                this.f23140e.fillView(eVar);
                return true;
            }
            this.f23140e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f23141f.setOnSrollToBottomListener(pVar);
            this.f23142g.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23138c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23137b, R.color.CAM_X0201);
            String string = this.f23136a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23136a.setNetRefreshViewTopMargin(this.j);
            this.f23136a.showNetRefreshView(this.f23137b, string, false);
        }
    }

    public void i(b.a.r0.r3.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f23141f.removeHeaderView(this.f23143h);
                    this.f23141f.addHeaderView(this.f23143h);
                } else {
                    this.f23141f.removeHeaderView(this.f23143h);
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
            this.f23141f.completePullRefreshPostDelayed(0L);
        }
    }
}
