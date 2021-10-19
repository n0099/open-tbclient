package c.a.r0.d2;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16613a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f16614b;

    /* renamed from: c  reason: collision with root package name */
    public int f16615c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f16616d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f16617e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f16618f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f16619g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16620h;

    /* renamed from: i  reason: collision with root package name */
    public List f16621i;

    /* renamed from: j  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f16622j;

    /* renamed from: c.a.r0.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0797a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16623e;

        public C0797a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16623e = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f16623e.l(i2);
                this.f16623e.b(false);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16615c = -1;
        this.f16620h = false;
        this.f16622j = new C0797a(this);
        this.f16619g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f16614b = fragmentTabHost;
        fragmentTabHost.setup(this.f16619g.getSupportFragmentManager());
        this.f16614b.setOnPageChangeListener(this.f16622j);
        this.f16617e = (NavigationBar) this.f16619g.findViewById(R.id.navigation_bar);
        this.f16618f = (NoNetworkView) this.f16619g.findViewById(R.id.view_no_network);
        this.f16617e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f16617e.setCenterTextTitle(this.f16619g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f16617e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f16619g).findViewById(R.id.right_textview);
        this.f16613a = textView;
        textView.setText(R.string.edit);
        this.f16613a.setOnClickListener(this.f16619g);
        this.f16617e.onChangeSkinType(this.f16619g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.f16616d;
            if (fragment instanceof CollectFragment) {
                CollectFragment collectFragment = (CollectFragment) fragment;
                if (!collectFragment.isEnableEdit()) {
                    z = false;
                }
                k(collectFragment.isEnableEdit());
                i2 = collectFragment.getType();
            } else {
                i2 = -1;
            }
            this.f16620h = z;
            this.f16613a.setText(z ? R.string.done : R.string.edit);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setNavbarTitleColor(this.f16613a, R.color.navi_op_text, R.color.navi_op_text_skin);
            } else {
                SkinManager.setNavbarTitleColor(this.f16613a, this.f16620h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(CollectFragment.EDITOR_STATE_EXTRA, this.f16620h);
            bundle.putInt(CollectFragment.FRAGMENT_TYPE, i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }

    public final void c(c.a.q0.h0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        c.a.q0.h0.c fragmentTabStructure;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, fragmentTabIndicator) == null) || (fragmentTabStructure = bVar.getFragmentTabStructure()) == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f47591c = fragmentTabStructure.f13471a;
        bVar2.f47589a = fragmentTabStructure.f13475e;
        fragmentTabIndicator.setText(fragmentTabStructure.f13472b);
        fragmentTabIndicator.setTextSize(0, this.f16619g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f47590b = fragmentTabIndicator;
        bVar2.f47592d = bVar;
        this.f16614b.addTabSpec(bVar2);
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16613a : (TextView) invokeV.objValue;
    }

    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16616d : (Fragment) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16615c : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f16621i) : invokeV.intValue;
    }

    public void h(ArrayList<c.a.q0.h0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f16621i = arrayList;
        this.f16614b.reset();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.a.q0.h0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f16619g.getPageContext().getPageActivity()));
            }
        }
        this.f16614b.initViewPager(0);
        this.f16614b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f16614b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16620h : invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f16614b.onChangeSkinType(i2);
            if (this.f16614b.getTabWrapper() != null) {
                if (g() <= 1) {
                    this.f16614b.getTabWrapper().setVisibility(8);
                } else {
                    this.f16614b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.f16613a, R.color.navi_op_text, R.color.navi_op_text_skin);
            this.f16617e.onChangeSkinType(this.f16619g.getPageContext(), i2);
            this.f16618f.onChangeSkinType(this.f16619g.getPageContext(), i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f16613a.setEnabled(z);
            if (z) {
                return;
            }
            this.f16613a.setText(R.string.edit);
            SkinManager.setNavbarTitleColor(this.f16613a, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            FragmentTabHost.b tabSpec = this.f16614b.getTabSpec(i2);
            this.f16615c = tabSpec.f47589a;
            this.f16616d = tabSpec.f47591c;
        }
    }
}
