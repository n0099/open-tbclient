package c.a.p0.f4.g.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.f4.h.e;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalCardCategoryActivity f15094b;

    /* renamed from: c  reason: collision with root package name */
    public View f15095c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15096d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f15097e;

    /* renamed from: f  reason: collision with root package name */
    public MemberRecommendView f15098f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f15099g;

    /* renamed from: h  reason: collision with root package name */
    public b f15100h;
    public View i;
    public TextView j;
    public int k;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardCategoryActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.k = 0;
        this.f15094b = personalCardCategoryActivity;
        this.k = n.f(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070235);
        View inflate = LayoutInflater.from(this.f15094b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01ce, (ViewGroup) null);
        this.f15095c = inflate;
        this.f15094b.setContentView(inflate);
        this.i = this.f15095c.findViewById(R.id.obfuscated_res_0x7f090392);
        NavigationBar navigationBar = (NavigationBar) this.f15095c.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15096d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15096d.setTitleText(R.string.obfuscated_res_0x7f0f0e35);
        this.f15097e = (NoNetworkView) this.f15095c.findViewById(R.id.obfuscated_res_0x7f0923d1);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f15095c.findViewById(R.id.obfuscated_res_0x7f09059e);
        this.f15098f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.f15094b.getActivity());
        this.j = textView;
        textView.setHeight(n.f(this.f15094b.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        this.f15099g = (BdListView) this.f15095c.findViewById(R.id.obfuscated_res_0x7f09059d);
        b bVar = new b(this.f15094b.getPageContext());
        this.f15100h = bVar;
        this.f15099g.setAdapter((ListAdapter) bVar);
    }

    public final List<Object> a(List<a> list) {
        InterceptResult invokeL;
        int size;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (a aVar : list) {
                ArrayList<c.a.p0.f4.a> a = aVar.a();
                if (a != null && (size = a.size()) != 0) {
                    arrayList.add(aVar.b());
                    if (size > 6) {
                        size = 6;
                    }
                    int i2 = 0;
                    while (i2 < size) {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        while (true) {
                            i = this.a;
                            if (i3 < i) {
                                int i4 = i2 + i3;
                                if (i4 < size) {
                                    arrayList2.add(a.get(i4));
                                }
                                i3++;
                            }
                        }
                        arrayList.add(arrayList2);
                        i2 = i2 + (i - 1) + 1;
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
            this.f15094b.hideNetRefreshView(this.f15095c);
            this.i.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15095c : (View) invokeV.objValue;
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15094b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f15094b.getLayoutMode().j(this.f15095c);
            NavigationBar navigationBar = this.f15096d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f15094b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f15097e;
            if (noNetworkView != null) {
                noNetworkView.c(this.f15094b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f15099g;
            if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f15100h) != null) {
                bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f15098f;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f15098f.d();
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        }
    }

    public final void e(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f15099g.setVisibility(0);
                this.f15100h.b(a(list));
                this.f15100h.notifyDataSetChanged();
                return;
            }
            this.f15099g.setVisibility(8);
        }
    }

    public final boolean f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f15098f.setVisibility(0);
                this.f15098f.e(eVar);
                return true;
            }
            this.f15098f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(PersonalCardItemView.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (bVar2 = this.f15100h) == null) {
            return;
        }
        bVar2.a(bVar);
    }

    public void h(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            this.f15099g.setOnSrollToBottomListener(pVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.i.setVisibility(8);
            String string = this.f15094b.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
            this.f15094b.setNetRefreshViewTopMargin(this.k);
            this.f15094b.showNetRefreshView(this.f15095c, string, false);
        }
    }

    public void j(int i, e eVar, List<a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), eVar, list, Boolean.valueOf(z)}) == null) {
            if ((eVar == null || StringUtils.isNull(eVar.c())) && (list == null || list.size() <= 0)) {
                i();
            } else if (i != 0) {
            } else {
                b();
                if (f(eVar)) {
                    this.f15099g.removeHeaderView(this.j);
                    this.f15099g.addHeaderView(this.j);
                } else {
                    this.f15099g.removeHeaderView(this.j);
                }
                e(list);
            }
        }
    }
}
