package c.a.p0.f4.f.c;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
import c.a.p0.f4.h.e;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15079b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15080c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f15081d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f15082e;

    /* renamed from: f  reason: collision with root package name */
    public g f15083f;

    /* renamed from: g  reason: collision with root package name */
    public a f15084g;

    /* renamed from: h  reason: collision with root package name */
    public int f15085h;

    public b(BubbleListActivity bubbleListActivity, c.a.p0.f4.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleListActivity, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15083f = null;
        this.f15085h = 0;
        this.a = bubbleListActivity;
        this.f15085h = n.f(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070235);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0168, (ViewGroup) null);
        this.f15079b = inflate;
        this.a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f15079b.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f15080c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15080c.setTitleText(R.string.obfuscated_res_0x7f0f033a);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f15079b.findViewById(R.id.obfuscated_res_0x7f0923ce);
        this.f15081d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f15082e = (BdListView) this.f15079b.findViewById(R.id.obfuscated_res_0x7f091285);
        g gVar = new g(this.a.getPageContext());
        this.f15083f = gVar;
        this.f15082e.setPullRefresh(gVar);
        TextView textView = new TextView(this.a.getActivity());
        textView.setHeight(n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0701d5));
        this.f15082e.addFooterView(textView);
        a aVar2 = new a(this.a.getPageContext(), aVar);
        this.f15084g = aVar2;
        this.f15082e.setAdapter((ListAdapter) aVar2);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i = i + 1 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 2; i2++) {
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
            SkinManager.setBackgroundColor(this.f15079b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.f15079b);
            this.f15081d.setVisibility(0);
            this.f15082e.setVisibility(0);
            this.f15079b.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15079b : (View) invokeV.objValue;
    }

    public void d() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.o0.w0.a.a(this.a.getPageContext(), this.f15079b);
            NavigationBar navigationBar = this.f15080c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f15082e;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f15084g) != null) {
                aVar.notifyDataSetChanged();
            }
            g gVar = this.f15083f;
            if (gVar != null) {
                gVar.H(TbadkApplication.getInst().getSkinType());
            }
            this.f15081d.d();
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f15082e.setVisibility(0);
                this.f15084g.b(list);
                this.f15084g.notifyDataSetChanged();
                return;
            }
            this.f15082e.setVisibility(8);
        }
    }

    public final boolean f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f15081d.setVisibility(0);
                this.f15081d.e(eVar);
                return true;
            }
            this.f15081d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f15082e.setOnSrollToBottomListener(pVar);
            this.f15083f.f(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f15081d.setVisibility(8);
            this.f15082e.setVisibility(8);
            this.f15079b.setVisibility(8);
            SkinManager.setBackgroundColor(this.f15079b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
            this.a.setNetRefreshViewTopMargin(this.f15085h);
            this.a.showNetRefreshView(this.f15079b, string, false);
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
            this.f15082e.A(0L);
        }
    }
}
