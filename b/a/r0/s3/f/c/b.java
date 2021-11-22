package b.a.r0.s3.f.c;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import b.a.r0.s3.h.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BubbleListActivity f24988a;

    /* renamed from: b  reason: collision with root package name */
    public View f24989b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f24990c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f24991d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f24992e;

    /* renamed from: f  reason: collision with root package name */
    public g f24993f;

    /* renamed from: g  reason: collision with root package name */
    public a f24994g;

    /* renamed from: h  reason: collision with root package name */
    public int f24995h;

    public b(BubbleListActivity bubbleListActivity, b.a.r0.s3.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleListActivity, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24993f = null;
        this.f24995h = 0;
        this.f24988a = bubbleListActivity;
        this.f24995h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f24988a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f24989b = inflate;
        this.f24988a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f24989b.findViewById(R.id.view_navigation_bar);
        this.f24990c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f24990c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f24989b.findViewById(R.id.view_member_recommend);
        this.f24991d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f24992e = (BdListView) this.f24989b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f24988a.getPageContext());
        this.f24993f = gVar;
        this.f24992e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f24988a.getActivity());
        textView.setHeight(l.g(this.f24988a.getActivity(), R.dimen.ds20));
        this.f24992e.addFooterView(textView);
        a aVar2 = new a(this.f24988a.getPageContext(), aVar);
        this.f24994g = aVar2;
        this.f24992e.setAdapter((ListAdapter) aVar2);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 = i2 + 1 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < 2; i3++) {
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
            SkinManager.setBackgroundColor(this.f24989b, R.color.CAM_X0204);
            this.f24988a.hideNetRefreshView(this.f24989b);
            this.f24991d.setVisibility(0);
            this.f24992e.setVisibility(0);
            this.f24989b.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24989b : (View) invokeV.objValue;
    }

    public void d() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.q0.v0.a.a(this.f24988a.getPageContext(), this.f24989b);
            NavigationBar navigationBar = this.f24990c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f24988a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f24992e;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f24994g) != null) {
                aVar.notifyDataSetChanged();
            }
            g gVar = this.f24993f;
            if (gVar != null) {
                gVar.C(TbadkApplication.getInst().getSkinType());
            }
            this.f24991d.changeSkinType();
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f24992e.setVisibility(0);
                this.f24994g.b(list);
                this.f24994g.notifyDataSetChanged();
                return;
            }
            this.f24992e.setVisibility(8);
        }
    }

    public final boolean f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f24991d.setVisibility(0);
                this.f24991d.fillView(eVar);
                return true;
            }
            this.f24991d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f24992e.setOnSrollToBottomListener(pVar);
            this.f24993f.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f24991d.setVisibility(8);
            this.f24992e.setVisibility(8);
            this.f24989b.setVisibility(8);
            SkinManager.setBackgroundColor(this.f24989b, R.color.CAM_X0201);
            String string = this.f24988a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f24988a.setNetRefreshViewTopMargin(this.f24995h);
            this.f24988a.showNetRefreshView(this.f24989b, string, false);
        }
    }

    public void i(e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                f(eVar);
                e(a(list));
                return;
            }
            h();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f24992e.completePullRefreshPostDelayed(0L);
        }
    }
}
