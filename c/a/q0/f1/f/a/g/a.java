package c.a.q0.f1.f.a.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.f0.n.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements TabLayout.OnTabSelectedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f17585a;

    /* renamed from: b  reason: collision with root package name */
    public Context f17586b;

    /* renamed from: c  reason: collision with root package name */
    public TabLayout f17587c;

    /* renamed from: d  reason: collision with root package name */
    public int f17588d;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17586b = context;
        c();
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17586b : (Context) invokeV.objValue;
    }

    public TabLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17587c : (TabLayout) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TabLayout tabLayout = (TabLayout) LayoutInflater.from(a()).inflate(R.layout.default_tab_layout, (ViewGroup) null);
            this.f17587c = tabLayout;
            tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            this.f17587c.setTabGravity(2);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            for (int i3 = 0; i3 < this.f17587c.getTabCount(); i3++) {
                TabLayout.Tab tabAt = this.f17587c.getTabAt(i3);
                if (tabAt != null) {
                    if (tabAt.isSelected()) {
                        g(tabAt);
                    } else {
                        h(tabAt);
                    }
                    if (tabAt.getCustomView() instanceof TBSpecificationBtn) {
                        ((TBSpecificationBtn) tabAt.getCustomView()).changeSkinType(i2);
                    }
                }
            }
        }
    }

    public void e(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onTabSelectedListener) == null) {
            this.f17585a = onTabSelectedListener;
        }
    }

    public void f(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, frsTabInfoData) == null) {
            i(this.f17588d, frsTabInfoData.tabList, this.f17587c);
        }
    }

    public final void g(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, tab) == null) || tab.getCustomView() == null) {
            return;
        }
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
        if (tBSpecificationBtn.getStyleConfig() instanceof b) {
            ((b) tBSpecificationBtn.getStyleConfig()).s(R.color.CAM_X0304);
        }
    }

    public final void h(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
        if (tBSpecificationBtn.getStyleConfig() instanceof b) {
            ((b) tBSpecificationBtn.getStyleConfig()).s(R.color.CAM_X0108);
        }
    }

    public final void i(int i2, List<FrsTabItemData> list, TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list, tabLayout) == null) {
            int min = Math.min(list.size(), 9);
            if (tabLayout.getTabCount() > min) {
                int tabCount = tabLayout.getTabCount() - min;
                for (int i3 = 0; i3 < tabCount; i3++) {
                    tabLayout.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
            if (linearLayout == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            linearLayout.requestLayout();
            int g2 = l.g(a(), R.dimen.M_W_X006) / 2;
            int g3 = l.g(a(), R.dimen.M_H_X003);
            int g4 = l.g(a(), R.dimen.M_H_X001);
            for (int i4 = 0; i4 < min; i4++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i4);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    View childAt = linearLayout.getChildAt(i4);
                    ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                    layoutParams2.width = -2;
                    layoutParams2.height = -2;
                    childAt.requestLayout();
                    if (childAt != null) {
                        childAt.setPadding(0, 0, 0, 0);
                    }
                }
                FrsTabItemData frsTabItemData = list.get(i4);
                tabAt.setTag(frsTabItemData);
                if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(a());
                    b bVar = new b();
                    bVar.s(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(bVar);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds177), UtilHelper.getDimenPixelSize(R.dimen.tbds75));
                    layoutParams3.setMargins(g2, g3, g2, g4);
                    tBSpecificationBtn.setLayoutParams(layoutParams3);
                    tabAt.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(frsTabItemData.name, 10, "..."));
                if (!tabAt.isSelected() && i2 == frsTabItemData.tabId) {
                    tabAt.select();
                }
            }
            linearLayout.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tab) == null) {
            g(tab);
            TabLayout.OnTabSelectedListener onTabSelectedListener = this.f17585a;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabReselected(tab);
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tab) == null) {
            if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
                this.f17588d = ((FrsTabItemData) tab.getTag()).tabId;
            }
            g(tab);
            TabLayout.OnTabSelectedListener onTabSelectedListener = this.f17585a;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabSelected(tab);
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tab) == null) {
            h(tab);
            TabLayout.OnTabSelectedListener onTabSelectedListener = this.f17585a;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabUnselected(tab);
            }
        }
    }
}
