package c.a.q0.o3.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.f0.f;
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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f23338a;

    /* renamed from: b  reason: collision with root package name */
    public View f23339b;

    /* renamed from: c  reason: collision with root package name */
    public View f23340c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23341d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f23342e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f23343f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.s.f0.g f23344g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23345h;

    /* renamed from: i  reason: collision with root package name */
    public e f23346i;

    /* renamed from: j  reason: collision with root package name */
    public int f23347j;

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
        this.f23344g = null;
        this.f23347j = 0;
        this.f23338a = backgroundListActivity;
        this.f23347j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f23338a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f23339b = inflate;
        this.f23338a.setContentView(inflate);
        this.f23340c = this.f23339b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f23339b.findViewById(R.id.view_navigation_bar);
        this.f23341d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23341d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f23339b.findViewById(R.id.view_member_recommend);
        this.f23342e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f23343f = (BdListView) this.f23339b.findViewById(R.id.listview_bg_list);
        c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(this.f23338a.getPageContext());
        this.f23344g = gVar;
        this.f23343f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f23338a.getActivity());
        this.f23345h = textView;
        textView.setHeight(l.g(this.f23338a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f23338a.getPageContext(), dVar);
        this.f23346i = eVar;
        this.f23343f.setAdapter((ListAdapter) eVar);
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
            SkinManager.setBackgroundColor(this.f23339b, R.color.CAM_X0204);
            this.f23338a.hideNetRefreshView(this.f23339b);
            this.f23340c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23339b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.u0.a.a(this.f23338a.getPageContext(), this.f23339b);
            NavigationBar navigationBar = this.f23341d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23338a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f23343f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f23346i) != null) {
                eVar.notifyDataSetChanged();
            }
            c.a.p0.s.f0.g gVar = this.f23344g;
            if (gVar != null) {
                gVar.D(TbadkApplication.getInst().getSkinType());
            }
            this.f23342e.changeSkinType();
            SkinManager.setBackgroundColor(this.f23345h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f23343f.setVisibility(0);
                this.f23346i.b(list);
                this.f23346i.notifyDataSetChanged();
                return;
            }
            this.f23343f.setVisibility(8);
        }
    }

    public final boolean f(c.a.q0.o3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f23342e.setVisibility(0);
                this.f23342e.fillView(eVar);
                return true;
            }
            this.f23342e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f23343f.setOnSrollToBottomListener(pVar);
            this.f23344g.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23340c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23339b, R.color.CAM_X0201);
            String string = this.f23338a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23338a.setNetRefreshViewTopMargin(this.f23347j);
            this.f23338a.showNetRefreshView(this.f23339b, string, false);
        }
    }

    public void i(c.a.q0.o3.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f23343f.removeHeaderView(this.f23345h);
                    this.f23343f.addHeaderView(this.f23345h);
                } else {
                    this.f23343f.removeHeaderView(this.f23345h);
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
            this.f23343f.completePullRefreshPostDelayed(0L);
        }
    }
}
