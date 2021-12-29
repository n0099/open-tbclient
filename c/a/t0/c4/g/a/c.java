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
    public PersonalCardCategoryActivity f16014b;

    /* renamed from: c  reason: collision with root package name */
    public View f16015c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f16016d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f16017e;

    /* renamed from: f  reason: collision with root package name */
    public MemberRecommendView f16018f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f16019g;

    /* renamed from: h  reason: collision with root package name */
    public b f16020h;

    /* renamed from: i  reason: collision with root package name */
    public View f16021i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f16022j;

    /* renamed from: k  reason: collision with root package name */
    public int f16023k;

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
        this.f16023k = 0;
        this.f16014b = personalCardCategoryActivity;
        this.f16023k = n.f(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f16014b.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.f16015c = inflate;
        this.f16014b.setContentView(inflate);
        this.f16021i = this.f16015c.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f16015c.findViewById(R.id.view_navigation_bar);
        this.f16016d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f16016d.setTitleText(R.string.personal_card);
        this.f16017e = (NoNetworkView) this.f16015c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f16015c.findViewById(R.id.categary_card_recommend);
        this.f16018f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.f16014b.getActivity());
        this.f16022j = textView;
        textView.setHeight(n.f(this.f16014b.getActivity(), R.dimen.ds104));
        this.f16019g = (BdListView) this.f16015c.findViewById(R.id.categary_card_listview);
        b bVar = new b(this.f16014b.getPageContext());
        this.f16020h = bVar;
        this.f16019g.setAdapter((ListAdapter) bVar);
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
            this.f16014b.hideNetRefreshView(this.f16015c);
            this.f16021i.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16015c : (View) invokeV.objValue;
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16014b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f16014b.getLayoutMode().j(this.f16015c);
            NavigationBar navigationBar = this.f16016d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f16014b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f16017e;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f16014b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f16019g;
            if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f16020h) != null) {
                bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f16018f;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f16018f.changeSkinType();
            }
            SkinManager.setBackgroundColor(this.f16022j, R.color.CAM_X0204);
        }
    }

    public final void e(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f16019g.setVisibility(0);
                this.f16020h.b(a(list));
                this.f16020h.notifyDataSetChanged();
                return;
            }
            this.f16019g.setVisibility(8);
        }
    }

    public final boolean f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f16018f.setVisibility(0);
                this.f16018f.fillView(eVar);
                return true;
            }
            this.f16018f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(PersonalCardItemView.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (bVar2 = this.f16020h) == null) {
            return;
        }
        bVar2.a(bVar);
    }

    public void h(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            this.f16019g.setOnSrollToBottomListener(pVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16021i.setVisibility(8);
            String string = this.f16014b.getPageContext().getResources().getString(R.string.no_data_text);
            this.f16014b.setNetRefreshViewTopMargin(this.f16023k);
            this.f16014b.showNetRefreshView(this.f16015c, string, false);
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
                    this.f16019g.removeHeaderView(this.f16022j);
                    this.f16019g.addHeaderView(this.f16022j);
                } else {
                    this.f16019g.removeHeaderView(this.f16022j);
                }
                e(list);
            }
        }
    }
}
