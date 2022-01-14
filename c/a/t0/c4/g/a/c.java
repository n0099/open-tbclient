package c.a.t0.c4.g.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.c4.h.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalCardCategoryActivity f15607b;

    /* renamed from: c  reason: collision with root package name */
    public View f15608c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15609d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f15610e;

    /* renamed from: f  reason: collision with root package name */
    public MemberRecommendView f15611f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f15612g;

    /* renamed from: h  reason: collision with root package name */
    public b f15613h;

    /* renamed from: i  reason: collision with root package name */
    public View f15614i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f15615j;
    public int k;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardCategoryActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.k = 0;
        this.f15607b = personalCardCategoryActivity;
        this.k = n.f(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f15607b.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.f15608c = inflate;
        this.f15607b.setContentView(inflate);
        this.f15614i = this.f15608c.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f15608c.findViewById(R.id.view_navigation_bar);
        this.f15609d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15609d.setTitleText(R.string.personal_card);
        this.f15610e = (NoNetworkView) this.f15608c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f15608c.findViewById(R.id.categary_card_recommend);
        this.f15611f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.f15607b.getActivity());
        this.f15615j = textView;
        textView.setHeight(n.f(this.f15607b.getActivity(), R.dimen.ds104));
        this.f15612g = (BdListView) this.f15608c.findViewById(R.id.categary_card_listview);
        b bVar = new b(this.f15607b.getPageContext());
        this.f15613h = bVar;
        this.f15612g.setAdapter((ListAdapter) bVar);
    }

    public final List<Object> a(List<a> list) {
        InterceptResult invokeL;
        int size;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (a aVar : list) {
                ArrayList<c.a.t0.c4.a> a = aVar.a();
                if (a != null && (size = a.size()) != 0) {
                    arrayList.add(aVar.b());
                    if (size > 6) {
                        size = 6;
                    }
                    int i3 = 0;
                    while (i3 < size) {
                        ArrayList arrayList2 = new ArrayList();
                        int i4 = 0;
                        while (true) {
                            i2 = this.a;
                            if (i4 < i2) {
                                int i5 = i3 + i4;
                                if (i5 < size) {
                                    arrayList2.add(a.get(i5));
                                }
                                i4++;
                            }
                        }
                        arrayList.add(arrayList2);
                        i3 = i3 + (i2 - 1) + 1;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15607b.hideNetRefreshView(this.f15608c);
            this.f15614i.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15608c : (View) invokeV.objValue;
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15607b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f15607b.getLayoutMode().j(this.f15608c);
            NavigationBar navigationBar = this.f15609d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f15607b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f15610e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f15607b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f15612g;
            if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f15613h) != null) {
                bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f15611f;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f15611f.changeSkinType();
            }
            SkinManager.setBackgroundColor(this.f15615j, R.color.CAM_X0204);
        }
    }

    public final void e(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f15612g.setVisibility(0);
                this.f15613h.b(a(list));
                this.f15613h.notifyDataSetChanged();
                return;
            }
            this.f15612g.setVisibility(8);
        }
    }

    public final boolean f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f15611f.setVisibility(0);
                this.f15611f.fillView(eVar);
                return true;
            }
            this.f15611f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(PersonalCardItemView.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (bVar2 = this.f15613h) == null) {
            return;
        }
        bVar2.a(bVar);
    }

    public void h(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            this.f15612g.setOnSrollToBottomListener(pVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f15614i.setVisibility(8);
            String string = this.f15607b.getPageContext().getResources().getString(R.string.no_data_text);
            this.f15607b.setNetRefreshViewTopMargin(this.k);
            this.f15607b.showNetRefreshView(this.f15608c, string, false);
        }
    }

    public void j(int i2, e eVar, List<a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), eVar, list, Boolean.valueOf(z)}) == null) {
            if ((eVar == null || StringUtils.isNull(eVar.c())) && (list == null || list.size() <= 0)) {
                i();
            } else if (i2 != 0) {
            } else {
                b();
                if (f(eVar)) {
                    this.f15612g.removeHeaderView(this.f15615j);
                    this.f15612g.addHeaderView(this.f15615j);
                } else {
                    this.f15612g.removeHeaderView(this.f15615j);
                }
                e(list);
            }
        }
    }
}
