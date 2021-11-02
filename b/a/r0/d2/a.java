package b.a.r0.d2;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f15623a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f15624b;

    /* renamed from: c  reason: collision with root package name */
    public int f15625c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f15626d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f15627e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f15628f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f15629g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15630h;

    /* renamed from: i  reason: collision with root package name */
    public List f15631i;
    public ViewPager.OnPageChangeListener j;

    /* renamed from: b.a.r0.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0792a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15632e;

        public C0792a(a aVar) {
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
            this.f15632e = aVar;
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
                this.f15632e.l(i2);
                this.f15632e.b(false);
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
        this.f15625c = -1;
        this.f15630h = false;
        this.j = new C0792a(this);
        this.f15629g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f15624b = fragmentTabHost;
        fragmentTabHost.setup(this.f15629g.getSupportFragmentManager());
        this.f15624b.setOnPageChangeListener(this.j);
        this.f15627e = (NavigationBar) this.f15629g.findViewById(R.id.navigation_bar);
        this.f15628f = (NoNetworkView) this.f15629g.findViewById(R.id.view_no_network);
        this.f15627e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15627e.setCenterTextTitle(this.f15629g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f15627e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f15629g).findViewById(R.id.right_textview);
        this.f15623a = textView;
        textView.setText(R.string.edit);
        this.f15623a.setOnClickListener(this.f15629g);
        this.f15627e.onChangeSkinType(this.f15629g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.f15626d;
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
            this.f15630h = z;
            this.f15623a.setText(z ? R.string.done : R.string.edit);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setNavbarTitleColor(this.f15623a, R.color.navi_op_text, R.color.navi_op_text_skin);
            } else {
                SkinManager.setNavbarTitleColor(this.f15623a, this.f15630h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(CollectFragment.EDITOR_STATE_EXTRA, this.f15630h);
            bundle.putInt(CollectFragment.FRAGMENT_TYPE, i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }

    public final void c(b.a.q0.h0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        b.a.q0.h0.c fragmentTabStructure;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, fragmentTabIndicator) == null) || (fragmentTabStructure = bVar.getFragmentTabStructure()) == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f45185c = fragmentTabStructure.f12612a;
        bVar2.f45183a = fragmentTabStructure.f12616e;
        fragmentTabIndicator.setText(fragmentTabStructure.f12613b);
        fragmentTabIndicator.setTextSize(0, this.f15629g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f45184b = fragmentTabIndicator;
        bVar2.f45186d = bVar;
        this.f15624b.addTabSpec(bVar2);
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15623a : (TextView) invokeV.objValue;
    }

    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15626d : (Fragment) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15625c : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f15631i) : invokeV.intValue;
    }

    public void h(ArrayList<b.a.q0.h0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f15631i = arrayList;
        this.f15624b.reset();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            b.a.q0.h0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f15629g.getPageContext().getPageActivity()));
            }
        }
        this.f15624b.initViewPager(0);
        this.f15624b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f15624b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15630h : invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f15624b.onChangeSkinType(i2);
            if (this.f15624b.getTabWrapper() != null) {
                if (g() <= 1) {
                    this.f15624b.getTabWrapper().setVisibility(8);
                } else {
                    this.f15624b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.f15623a, R.color.navi_op_text, R.color.navi_op_text_skin);
            this.f15627e.onChangeSkinType(this.f15629g.getPageContext(), i2);
            this.f15628f.onChangeSkinType(this.f15629g.getPageContext(), i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f15623a.setEnabled(z);
            if (z) {
                return;
            }
            this.f15623a.setText(R.string.edit);
            SkinManager.setNavbarTitleColor(this.f15623a, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            FragmentTabHost.b tabSpec = this.f15624b.getTabSpec(i2);
            this.f15625c = tabSpec.f45183a;
            this.f15626d = tabSpec.f45185c;
        }
    }
}
