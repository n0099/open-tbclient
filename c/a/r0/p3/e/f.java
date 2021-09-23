package c.a.r0.p3.e;

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
    public BackgroundListActivity f23944a;

    /* renamed from: b  reason: collision with root package name */
    public View f23945b;

    /* renamed from: c  reason: collision with root package name */
    public View f23946c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f23947d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f23948e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f23949f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.f0.g f23950g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23951h;

    /* renamed from: i  reason: collision with root package name */
    public e f23952i;

    /* renamed from: j  reason: collision with root package name */
    public int f23953j;

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
        this.f23950g = null;
        this.f23953j = 0;
        this.f23944a = backgroundListActivity;
        this.f23953j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f23944a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f23945b = inflate;
        this.f23944a.setContentView(inflate);
        this.f23946c = this.f23945b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f23945b.findViewById(R.id.view_navigation_bar);
        this.f23947d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f23947d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f23945b.findViewById(R.id.view_member_recommend);
        this.f23948e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f23949f = (BdListView) this.f23945b.findViewById(R.id.listview_bg_list);
        c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(this.f23944a.getPageContext());
        this.f23950g = gVar;
        this.f23949f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f23944a.getActivity());
        this.f23951h = textView;
        textView.setHeight(l.g(this.f23944a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f23944a.getPageContext(), dVar);
        this.f23952i = eVar;
        this.f23949f.setAdapter((ListAdapter) eVar);
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
            SkinManager.setBackgroundColor(this.f23945b, R.color.CAM_X0204);
            this.f23944a.hideNetRefreshView(this.f23945b);
            this.f23946c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23945b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.w0.a.a(this.f23944a.getPageContext(), this.f23945b);
            NavigationBar navigationBar = this.f23947d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f23944a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f23949f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f23952i) != null) {
                eVar.notifyDataSetChanged();
            }
            c.a.q0.s.f0.g gVar = this.f23950g;
            if (gVar != null) {
                gVar.D(TbadkApplication.getInst().getSkinType());
            }
            this.f23948e.changeSkinType();
            SkinManager.setBackgroundColor(this.f23951h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f23949f.setVisibility(0);
                this.f23952i.b(list);
                this.f23952i.notifyDataSetChanged();
                return;
            }
            this.f23949f.setVisibility(8);
        }
    }

    public final boolean f(c.a.r0.p3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f23948e.setVisibility(0);
                this.f23948e.fillView(eVar);
                return true;
            }
            this.f23948e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f23949f.setOnSrollToBottomListener(pVar);
            this.f23950g.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23946c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23945b, R.color.CAM_X0201);
            String string = this.f23944a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f23944a.setNetRefreshViewTopMargin(this.f23953j);
            this.f23944a.showNetRefreshView(this.f23945b, string, false);
        }
    }

    public void i(c.a.r0.p3.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f23949f.removeHeaderView(this.f23951h);
                    this.f23949f.addHeaderView(this.f23951h);
                } else {
                    this.f23949f.removeHeaderView(this.f23951h);
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
            this.f23949f.completePullRefreshPostDelayed(0L);
        }
    }
}
