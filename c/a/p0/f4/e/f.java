package c.a.p0.f4.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.l0.f;
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
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15034b;

    /* renamed from: c  reason: collision with root package name */
    public View f15035c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f15036d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f15037e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f15038f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.r.l0.g f15039g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15040h;
    public e i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundListActivity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15039g = null;
        this.j = 0;
        this.a = backgroundListActivity;
        this.j = n.f(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070235);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0130, (ViewGroup) null);
        this.f15034b = inflate;
        this.a.setContentView(inflate);
        this.f15035c = this.f15034b.findViewById(R.id.obfuscated_res_0x7f090392);
        NavigationBar navigationBar = (NavigationBar) this.f15034b.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15036d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15036d.setTitleText(R.string.obfuscated_res_0x7f0f0e34);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f15034b.findViewById(R.id.obfuscated_res_0x7f0923ce);
        this.f15037e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f15038f = (BdListView) this.f15034b.findViewById(R.id.obfuscated_res_0x7f091284);
        c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(this.a.getPageContext());
        this.f15039g = gVar;
        this.f15038f.setPullRefresh(gVar);
        TextView textView = new TextView(this.a.getActivity());
        this.f15040h = textView;
        textView.setHeight(n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        e eVar = new e(this.a.getPageContext(), dVar);
        this.i = eVar;
        this.f15038f.setAdapter((ListAdapter) eVar);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i = i + 2 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 3; i2++) {
                    int i3 = i + i2;
                    if (i3 < size) {
                        arrayList2.add(list.get(i3));
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
            SkinManager.setBackgroundColor(this.f15034b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.f15034b);
            this.f15035c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15034b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.o0.w0.a.a(this.a.getPageContext(), this.f15034b);
            NavigationBar navigationBar = this.f15036d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f15038f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.i) != null) {
                eVar.notifyDataSetChanged();
            }
            c.a.o0.r.l0.g gVar = this.f15039g;
            if (gVar != null) {
                gVar.H(TbadkApplication.getInst().getSkinType());
            }
            this.f15037e.d();
            SkinManager.setBackgroundColor(this.f15040h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f15038f.setVisibility(0);
                this.i.b(list);
                this.i.notifyDataSetChanged();
                return;
            }
            this.f15038f.setVisibility(8);
        }
    }

    public final boolean f(c.a.p0.f4.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f15037e.setVisibility(0);
                this.f15037e.e(eVar);
                return true;
            }
            this.f15037e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f15038f.setOnSrollToBottomListener(pVar);
            this.f15039g.f(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15035c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f15034b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
            this.a.setNetRefreshViewTopMargin(this.j);
            this.a.showNetRefreshView(this.f15034b, string, false);
        }
    }

    public void i(c.a.p0.f4.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f15038f.removeHeaderView(this.f15040h);
                    this.f15038f.addHeaderView(this.f15040h);
                } else {
                    this.f15038f.removeHeaderView(this.f15040h);
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
            this.f15038f.A(0L);
        }
    }
}
