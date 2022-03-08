package c.a.r0.m2;

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
    public final FragmentTabHost f19267b;

    /* renamed from: c  reason: collision with root package name */
    public int f19268c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f19269d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f19270e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f19271f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f19272g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19273h;

    /* renamed from: i  reason: collision with root package name */
    public List f19274i;

    /* renamed from: j  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f19275j;

    /* renamed from: c.a.r0.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1204a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19276e;

        public C1204a(a aVar) {
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
            this.f19276e = aVar;
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
                this.f19276e.l(i2);
                this.f19276e.b(false);
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
        this.f19268c = -1;
        this.f19273h = false;
        this.f19275j = new C1204a(this);
        this.f19272g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f19267b = fragmentTabHost;
        fragmentTabHost.setup(this.f19272g.getSupportFragmentManager());
        this.f19267b.setOnPageChangeListener(this.f19275j);
        this.f19270e = (NavigationBar) this.f19272g.findViewById(R.id.navigation_bar);
        this.f19271f = (NoNetworkView) this.f19272g.findViewById(R.id.view_no_network);
        this.f19270e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f19270e.setCenterTextTitle(this.f19272g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f19270e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f19272g).findViewById(R.id.right_textview);
        this.a = textView;
        textView.setText(R.string.edit);
        this.a.setOnClickListener(this.f19272g);
        this.f19270e.onChangeSkinType(this.f19272g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.f19269d;
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
            this.f19273h = z;
            this.a.setText(z ? R.string.done : R.string.edit);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i3 = R.color.navi_op_text;
            if (skinType == 2) {
                SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.navi_op_text_skin);
            } else {
                TextView textView = this.a;
                if (this.f19273h) {
                    i3 = R.color.CAM_X0302;
                }
                SkinManager.setNavbarTitleColor(textView, i3, R.color.navi_op_text_skin);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(CollectFragment.EDITOR_STATE_EXTRA, this.f19273h);
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
        bVar2.f38929c = fragmentTabStructure.a;
        bVar2.a = fragmentTabStructure.f12602e;
        fragmentTabIndicator.setText(fragmentTabStructure.f12599b);
        fragmentTabIndicator.setTextSize(0, this.f19272g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f38928b = fragmentTabIndicator;
        bVar2.f38930d = bVar;
        this.f19267b.addTabSpec(bVar2);
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19269d : (Fragment) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19268c : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f19274i) : invokeV.intValue;
    }

    public void h(ArrayList<c.a.q0.h0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f19274i = arrayList;
        this.f19267b.reset();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.a.q0.h0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f19272g.getPageContext().getPageActivity()));
            }
        }
        this.f19267b.initViewPager(0);
        this.f19267b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f19267b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19273h : invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f19267b.onChangeSkinType(i2);
            if (this.f19267b.getTabWrapper() != null) {
                if (g() <= 1) {
                    this.f19267b.getTabWrapper().setVisibility(8);
                } else {
                    this.f19267b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.navi_op_text_skin);
            this.f19270e.onChangeSkinType(this.f19272g.getPageContext(), i2);
            this.f19271f.onChangeSkinType(this.f19272g.getPageContext(), i2);
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
            this.a.setText(R.string.edit);
            SkinManager.setNavbarTitleColor(this.a, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            FragmentTabHost.b tabSpec = this.f19267b.getTabSpec(i2);
            this.f19268c = tabSpec.a;
            this.f19269d = tabSpec.f38929c;
        }
    }
}
