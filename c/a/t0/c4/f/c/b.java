package c.a.t0.c4.f.c;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.i0.f;
import c.a.s0.s.i0.g;
import c.a.t0.c4.h.e;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15998b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15999c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f16000d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f16001e;

    /* renamed from: f  reason: collision with root package name */
    public g f16002f;

    /* renamed from: g  reason: collision with root package name */
    public a f16003g;

    /* renamed from: h  reason: collision with root package name */
    public int f16004h;

    public b(BubbleListActivity bubbleListActivity, c.a.t0.c4.f.a.a aVar) {
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
        this.f16002f = null;
        this.f16004h = 0;
        this.a = bubbleListActivity;
        this.f16004h = n.f(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f15998b = inflate;
        this.a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f15998b.findViewById(R.id.view_navigation_bar);
        this.f15999c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15999c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f15998b.findViewById(R.id.view_member_recommend);
        this.f16000d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f16001e = (BdListView) this.f15998b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.a.getPageContext());
        this.f16002f = gVar;
        this.f16001e.setPullRefresh(gVar);
        TextView textView = new TextView(this.a.getActivity());
        textView.setHeight(n.f(this.a.getActivity(), R.dimen.ds20));
        this.f16001e.addFooterView(textView);
        a aVar2 = new a(this.a.getPageContext(), aVar);
        this.f16003g = aVar2;
        this.f16001e.setAdapter((ListAdapter) aVar2);
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
            SkinManager.setBackgroundColor(this.f15998b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.f15998b);
            this.f16000d.setVisibility(0);
            this.f16001e.setVisibility(0);
            this.f15998b.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15998b : (View) invokeV.objValue;
    }

    public void d() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f15998b);
            NavigationBar navigationBar = this.f15999c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f16001e;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f16003g) != null) {
                aVar.notifyDataSetChanged();
            }
            g gVar = this.f16002f;
            if (gVar != null) {
                gVar.C(TbadkApplication.getInst().getSkinType());
            }
            this.f16000d.changeSkinType();
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f16001e.setVisibility(0);
                this.f16003g.b(list);
                this.f16003g.notifyDataSetChanged();
                return;
            }
            this.f16001e.setVisibility(8);
        }
    }

    public final boolean f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f16000d.setVisibility(0);
                this.f16000d.fillView(eVar);
                return true;
            }
            this.f16000d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f16001e.setOnSrollToBottomListener(pVar);
            this.f16002f.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16000d.setVisibility(8);
            this.f16001e.setVisibility(8);
            this.f15998b.setVisibility(8);
            SkinManager.setBackgroundColor(this.f15998b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(this.f16004h);
            this.a.showNetRefreshView(this.f15998b, string, false);
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
            this.f16001e.completePullRefreshPostDelayed(0L);
        }
    }
}
