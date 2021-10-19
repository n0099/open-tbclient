package c.a.r0.q3.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.f0.f;
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
    public BackgroundListActivity f24119a;

    /* renamed from: b  reason: collision with root package name */
    public View f24120b;

    /* renamed from: c  reason: collision with root package name */
    public View f24121c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f24122d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f24123e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f24124f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.f0.g f24125g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24126h;

    /* renamed from: i  reason: collision with root package name */
    public e f24127i;

    /* renamed from: j  reason: collision with root package name */
    public int f24128j;

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
        this.f24125g = null;
        this.f24128j = 0;
        this.f24119a = backgroundListActivity;
        this.f24128j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f24119a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f24120b = inflate;
        this.f24119a.setContentView(inflate);
        this.f24121c = this.f24120b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f24120b.findViewById(R.id.view_navigation_bar);
        this.f24122d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24122d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f24120b.findViewById(R.id.view_member_recommend);
        this.f24123e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f24124f = (BdListView) this.f24120b.findViewById(R.id.listview_bg_list);
        c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(this.f24119a.getPageContext());
        this.f24125g = gVar;
        this.f24124f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f24119a.getActivity());
        this.f24126h = textView;
        textView.setHeight(l.g(this.f24119a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f24119a.getPageContext(), dVar);
        this.f24127i = eVar;
        this.f24124f.setAdapter((ListAdapter) eVar);
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
            SkinManager.setBackgroundColor(this.f24120b, R.color.CAM_X0204);
            this.f24119a.hideNetRefreshView(this.f24120b);
            this.f24121c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24120b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.w0.a.a(this.f24119a.getPageContext(), this.f24120b);
            NavigationBar navigationBar = this.f24122d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f24119a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f24124f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f24127i) != null) {
                eVar.notifyDataSetChanged();
            }
            c.a.q0.s.f0.g gVar = this.f24125g;
            if (gVar != null) {
                gVar.D(TbadkApplication.getInst().getSkinType());
            }
            this.f24123e.changeSkinType();
            SkinManager.setBackgroundColor(this.f24126h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f24124f.setVisibility(0);
                this.f24127i.b(list);
                this.f24127i.notifyDataSetChanged();
                return;
            }
            this.f24124f.setVisibility(8);
        }
    }

    public final boolean f(c.a.r0.q3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f24123e.setVisibility(0);
                this.f24123e.fillView(eVar);
                return true;
            }
            this.f24123e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f24124f.setOnSrollToBottomListener(pVar);
            this.f24125g.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f24121c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f24120b, R.color.CAM_X0201);
            String string = this.f24119a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f24119a.setNetRefreshViewTopMargin(this.f24128j);
            this.f24119a.showNetRefreshView(this.f24120b, string, false);
        }
    }

    public void i(c.a.r0.q3.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f24124f.removeHeaderView(this.f24126h);
                    this.f24124f.addHeaderView(this.f24126h);
                } else {
                    this.f24124f.removeHeaderView(this.f24126h);
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
            this.f24124f.completePullRefreshPostDelayed(0L);
        }
    }
}
