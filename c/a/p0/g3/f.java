package c.a.p0.g3;

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
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PostSearchActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15261b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f15262c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f15263d;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchListFragment f15264e;

    /* renamed from: f  reason: collision with root package name */
    public PostSearchListFragment f15265f;

    /* renamed from: g  reason: collision with root package name */
    public PostSearchListFragment f15266g;

    public f(PostSearchActivity postSearchActivity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = postSearchActivity;
        this.f15261b = view;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f15264e.C0();
            this.f15265f.C0();
            this.f15266g.C0();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment = new PostSearchListFragment(1);
            this.f15264e = postSearchListFragment;
            bVar.f29925c = postSearchListFragment;
            bVar.f29924b = c(R.string.obfuscated_res_0x7f0f10a3);
            bVar.a = 1;
            this.f15262c.c(bVar);
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment2 = new PostSearchListFragment(2);
            this.f15265f = postSearchListFragment2;
            bVar2.f29925c = postSearchListFragment2;
            bVar2.f29924b = c(R.string.obfuscated_res_0x7f0f10a2);
            bVar2.a = 2;
            this.f15262c.c(bVar2);
            FragmentTabHost.b bVar3 = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment3 = new PostSearchListFragment(3);
            this.f15266g = postSearchListFragment3;
            bVar3.f29925c = postSearchListFragment3;
            bVar3.f29924b = c(R.string.obfuscated_res_0x7f0f10a1);
            bVar3.a = 3;
            this.f15262c.c(bVar3);
        }
    }

    public final FragmentTabIndicator c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02f8, (ViewGroup) null);
            fragmentTabIndicator.setText(i);
            fragmentTabIndicator.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            fragmentTabIndicator.f30573h = R.color.s_actionbar_text_color;
            fragmentTabIndicator.setContentTvTopMargin(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
            fragmentTabIndicator.setWidth((n.k(this.a.getPageContext().getContext()) - (this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f) * 2)) / 3);
            return fragmentTabIndicator;
        }
        return (FragmentTabIndicator) invokeI.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15262c.getCurrentTabType() : invokeV.intValue;
    }

    public final PostSearchListFragment e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return this.f15266g;
                }
                return this.f15265f;
            }
            return this.f15264e;
        }
        return (PostSearchListFragment) invokeI.objValue;
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            View inflate = ((ViewStub) this.f15261b.findViewById(R.id.obfuscated_res_0x7f091c4a)).inflate();
            inflate.setVisibility(0);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) inflate.findViewById(R.id.obfuscated_res_0x7f0918bc);
            this.f15262c = fragmentTabHost;
            fragmentTabHost.setup(this.a.getSupportFragmentManager());
            this.f15262c.setTabWidgetViewHeight((int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275));
            this.f15262c.setShouldDrawIndicatorLine(true);
            b();
            this.f15262c.n(3);
            this.f15262c.setCurrentTabByType(i);
            this.f15262c.setNeedShowThemeStyle(false);
            this.f15262c.getFragmentTabWidget().setBackGroundDrawableResId(0);
            this.f15262c.s(TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.f15262c.getFragmentTabWidget(), R.color.CAM_X0201);
            this.f15262c.setOnPageChangeListener(this.f15263d);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            FragmentTabHost fragmentTabHost = this.f15262c;
            if (fragmentTabHost != null) {
                fragmentTabHost.s(i);
            }
            FragmentTabHost fragmentTabHost2 = this.f15262c;
            if (fragmentTabHost2 == null || fragmentTabHost2.getFragmentTabWidget() == null) {
                return;
            }
            SkinManager.setBackgroundColor(this.f15262c.getFragmentTabWidget(), R.color.CAM_X0201);
        }
    }

    public void h(int i, b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), bVar, Boolean.valueOf(z)}) == null) {
            j(true);
            PostSearchListFragment e2 = e(i);
            if (e2 != null) {
                e2.G0(bVar, z);
            }
        }
    }

    public void i(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.f15263d = onPageChangeListener;
            FragmentTabHost fragmentTabHost = this.f15262c;
            if (fragmentTabHost != null) {
                fragmentTabHost.setOnPageChangeListener(onPageChangeListener);
            }
        }
    }

    public void j(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (fragmentTabHost = this.f15262c) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.setVisibility(0);
        } else {
            fragmentTabHost.setVisibility(8);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (this.f15262c == null) {
                f(1);
                return;
            }
            a();
            if (this.f15262c.getCurrentTabType() == i) {
                PostSearchListFragment e2 = e(i);
                if (e2 != null) {
                    e2.H0(true);
                    return;
                }
                return;
            }
            this.f15262c.setCurrentTabByType(i);
        }
    }
}
