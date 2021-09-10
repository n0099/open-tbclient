package c.a.r0.c2;

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
    public final TextView f16436a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f16437b;

    /* renamed from: c  reason: collision with root package name */
    public int f16438c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f16439d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f16440e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f16441f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f16442g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16443h;

    /* renamed from: i  reason: collision with root package name */
    public List f16444i;

    /* renamed from: j  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f16445j;

    /* renamed from: c.a.r0.c2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0790a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16446e;

        public C0790a(a aVar) {
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
            this.f16446e = aVar;
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
                this.f16446e.l(i2);
                this.f16446e.b(false);
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
        this.f16438c = -1;
        this.f16443h = false;
        this.f16445j = new C0790a(this);
        this.f16442g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f16437b = fragmentTabHost;
        fragmentTabHost.setup(this.f16442g.getSupportFragmentManager());
        this.f16437b.setOnPageChangeListener(this.f16445j);
        this.f16440e = (NavigationBar) this.f16442g.findViewById(R.id.navigation_bar);
        this.f16441f = (NoNetworkView) this.f16442g.findViewById(R.id.view_no_network);
        this.f16440e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f16440e.setCenterTextTitle(this.f16442g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f16440e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f16442g).findViewById(R.id.right_textview);
        this.f16436a = textView;
        textView.setText(R.string.edit);
        this.f16436a.setOnClickListener(this.f16442g);
        this.f16440e.onChangeSkinType(this.f16442g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.f16439d;
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
            this.f16443h = z;
            this.f16436a.setText(z ? R.string.done : R.string.edit);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setNavbarTitleColor(this.f16436a, R.color.navi_op_text, R.color.navi_op_text_skin);
            } else {
                SkinManager.setNavbarTitleColor(this.f16436a, this.f16443h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(CollectFragment.EDITOR_STATE_EXTRA, this.f16443h);
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
        bVar2.f47569c = fragmentTabStructure.f13467a;
        bVar2.f47567a = fragmentTabStructure.f13471e;
        fragmentTabIndicator.setText(fragmentTabStructure.f13468b);
        fragmentTabIndicator.setTextSize(0, this.f16442g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f47568b = fragmentTabIndicator;
        bVar2.f47570d = bVar;
        this.f16437b.addTabSpec(bVar2);
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16436a : (TextView) invokeV.objValue;
    }

    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16439d : (Fragment) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16438c : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f16444i) : invokeV.intValue;
    }

    public void h(ArrayList<c.a.q0.h0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f16444i = arrayList;
        this.f16437b.reset();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c.a.q0.h0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f16442g.getPageContext().getPageActivity()));
            }
        }
        this.f16437b.initViewPager(0);
        this.f16437b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f16437b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16443h : invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f16437b.onChangeSkinType(i2);
            if (this.f16437b.getTabWrapper() != null) {
                if (g() <= 1) {
                    this.f16437b.getTabWrapper().setVisibility(8);
                } else {
                    this.f16437b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.f16436a, R.color.navi_op_text, R.color.navi_op_text_skin);
            this.f16440e.onChangeSkinType(this.f16442g.getPageContext(), i2);
            this.f16441f.onChangeSkinType(this.f16442g.getPageContext(), i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f16436a.setEnabled(z);
            if (z) {
                return;
            }
            this.f16436a.setText(R.string.edit);
            SkinManager.setNavbarTitleColor(this.f16436a, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            FragmentTabHost.b tabSpec = this.f16437b.getTabSpec(i2);
            this.f16438c = tabSpec.f47567a;
            this.f16439d = tabSpec.f47569c;
        }
    }
}
