package c.a.p0.o2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.CollectTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f16809b;

    /* renamed from: c  reason: collision with root package name */
    public int f16810c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f16811d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f16812e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f16813f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f16814g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16815h;
    public List i;
    public ViewPager.OnPageChangeListener j;

    /* renamed from: c.a.p0.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1258a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1258a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.l(i);
                this.a.b(false);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collectTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16810c = -1;
        this.f16815h = false;
        this.j = new C1258a(this);
        this.f16814g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.obfuscated_res_0x7f091e43);
        this.f16809b = fragmentTabHost;
        fragmentTabHost.setup(this.f16814g.getSupportFragmentManager());
        this.f16809b.setOnPageChangeListener(this.j);
        this.f16812e = (NavigationBar) this.f16814g.findViewById(R.id.obfuscated_res_0x7f091519);
        this.f16813f = (NoNetworkView) this.f16814g.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.f16812e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f16812e.setCenterTextTitle(this.f16814g.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b30));
        TextView textView = (TextView) this.f16812e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e4, this.f16814g).findViewById(R.id.obfuscated_res_0x7f091ab8);
        this.a = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f050c);
        this.a.setOnClickListener(this.f16814g);
        this.f16812e.onChangeSkinType(this.f16814g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.f16811d;
            if (fragment instanceof CollectFragment) {
                CollectFragment collectFragment = (CollectFragment) fragment;
                if (!collectFragment.D0()) {
                    z = false;
                }
                k(collectFragment.D0());
                i = collectFragment.getType();
            } else {
                i = -1;
            }
            this.f16815h = z;
            this.a.setText(z ? R.string.obfuscated_res_0x7f0f04e0 : R.string.obfuscated_res_0x7f0f050c);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i2 = R.color.navi_op_text;
            if (skinType == 2) {
                SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.obfuscated_res_0x7f060861);
            } else {
                TextView textView = this.a;
                if (this.f16815h) {
                    i2 = R.color.CAM_X0302;
                }
                SkinManager.setNavbarTitleColor(textView, i2, R.color.obfuscated_res_0x7f060861);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_edit_state", this.f16815h);
            bundle.putInt("fragment_type", i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }

    public final void c(c.a.o0.h0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        c.a.o0.h0.c b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, fragmentTabIndicator) == null) || (b2 = bVar.b()) == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f29925c = b2.a;
        bVar2.a = b2.f10299e;
        fragmentTabIndicator.setText(b2.f10296b);
        fragmentTabIndicator.setTextSize(0, this.f16814g.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f29924b = fragmentTabIndicator;
        bVar2.f29926d = bVar;
        this.f16809b.c(bVar2);
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16811d : (Fragment) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16810c : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.i) : invokeV.intValue;
    }

    public void h(ArrayList<c.a.o0.h0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.i = arrayList;
        this.f16809b.u();
        for (int i = 0; i < arrayList.size(); i++) {
            c.a.o0.h0.b bVar = arrayList.get(i);
            if (bVar != null && bVar.d()) {
                c(bVar, (FragmentTabIndicator) bVar.c(this.f16814g.getPageContext().getPageActivity()));
            }
        }
        this.f16809b.n(0);
        this.f16809b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f16809b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16815h : invokeV.booleanValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f16809b.s(i);
            if (this.f16809b.getTabWrapper() != null) {
                if (g() <= 1) {
                    this.f16809b.getTabWrapper().setVisibility(8);
                } else {
                    this.f16809b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.obfuscated_res_0x7f060861);
            this.f16812e.onChangeSkinType(this.f16814g.getPageContext(), i);
            this.f16813f.c(this.f16814g.getPageContext(), i);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a.setEnabled(z);
            if (z) {
                return;
            }
            this.a.setText(R.string.obfuscated_res_0x7f0f050c);
            SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.obfuscated_res_0x7f060861);
        }
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            FragmentTabHost.b i2 = this.f16809b.i(i);
            this.f16810c = i2.a;
            this.f16811d = i2.f29925c;
        }
    }
}
