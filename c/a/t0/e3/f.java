package c.a.t0.e3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.tieba.postsearch.PostSearchListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PostSearchActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f17245b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f17246c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f17247d;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchListFragment f17248e;

    /* renamed from: f  reason: collision with root package name */
    public PostSearchListFragment f17249f;

    /* renamed from: g  reason: collision with root package name */
    public PostSearchListFragment f17250g;

    public f(PostSearchActivity postSearchActivity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = postSearchActivity;
        this.f17245b = view;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17248e.clearListData();
            this.f17249f.clearListData();
            this.f17250g.clearListData();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment = new PostSearchListFragment(1);
            this.f17248e = postSearchListFragment;
            bVar.f40268c = postSearchListFragment;
            bVar.f40267b = c(R.string.searching_time_tab);
            bVar.a = 1;
            this.f17246c.addTabSpec(bVar);
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment2 = new PostSearchListFragment(2);
            this.f17249f = postSearchListFragment2;
            bVar2.f40268c = postSearchListFragment2;
            bVar2.f40267b = c(R.string.searching_relative_tab);
            bVar2.a = 2;
            this.f17246c.addTabSpec(bVar2);
            FragmentTabHost.b bVar3 = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment3 = new PostSearchListFragment(3);
            this.f17250g = postSearchListFragment3;
            bVar3.f40268c = postSearchListFragment3;
            bVar3.f40267b = c(R.string.searching_only_thread_tab);
            bVar3.a = 3;
            this.f17246c.addTabSpec(bVar3);
        }
    }

    public final FragmentTabIndicator c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            fragmentTabIndicator.setText(i2);
            fragmentTabIndicator.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.ds32));
            fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
            fragmentTabIndicator.setContentTvTopMargin(this.a.getResources().getDimensionPixelSize(R.dimen.ds4));
            fragmentTabIndicator.setWidth((n.k(this.a.getPageContext().getContext()) - (this.a.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3);
            return fragmentTabIndicator;
        }
        return (FragmentTabIndicator) invokeI.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17246c.getCurrentTabType() : invokeV.intValue;
    }

    public final PostSearchListFragment e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return this.f17250g;
                }
                return this.f17249f;
            }
            return this.f17248e;
        }
        return (PostSearchListFragment) invokeI.objValue;
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            View inflate = ((ViewStub) this.f17245b.findViewById(R.id.search_tab_host_viewstub)).inflate();
            inflate.setVisibility(0);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
            this.f17246c = fragmentTabHost;
            fragmentTabHost.setup(this.a.getSupportFragmentManager());
            this.f17246c.setTabWidgetViewHeight((int) this.a.getResources().getDimension(R.dimen.ds80));
            this.f17246c.setShouldDrawIndicatorLine(true);
            b();
            this.f17246c.initViewPager(3);
            this.f17246c.setCurrentTabByType(i2);
            this.f17246c.setNeedShowThemeStyle(false);
            this.f17246c.getFragmentTabWidget().setBackGroundDrawableResId(0);
            this.f17246c.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.f17246c.getFragmentTabWidget(), R.color.CAM_X0201);
            this.f17246c.setOnPageChangeListener(this.f17247d);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            FragmentTabHost fragmentTabHost = this.f17246c;
            if (fragmentTabHost != null) {
                fragmentTabHost.onChangeSkinType(i2);
            }
            FragmentTabHost fragmentTabHost2 = this.f17246c;
            if (fragmentTabHost2 == null || fragmentTabHost2.getFragmentTabWidget() == null) {
                return;
            }
            SkinManager.setBackgroundColor(this.f17246c.getFragmentTabWidget(), R.color.CAM_X0201);
        }
    }

    public void h(int i2, b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)}) == null) {
            j(true);
            PostSearchListFragment e2 = e(i2);
            if (e2 != null) {
                e2.refreshResultList(bVar, z);
            }
        }
    }

    public void i(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.f17247d = onPageChangeListener;
            FragmentTabHost fragmentTabHost = this.f17246c;
            if (fragmentTabHost != null) {
                fragmentTabHost.setOnPageChangeListener(onPageChangeListener);
            }
        }
    }

    public void j(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (fragmentTabHost = this.f17246c) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.setVisibility(0);
        } else {
            fragmentTabHost.setVisibility(8);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f17246c == null) {
                f(1);
                return;
            }
            a();
            if (this.f17246c.getCurrentTabType() == i2) {
                PostSearchListFragment e2 = e(i2);
                if (e2 != null) {
                    e2.requestData(true);
                    return;
                }
                return;
            }
            this.f17246c.setCurrentTabByType(i2);
        }
    }
}
