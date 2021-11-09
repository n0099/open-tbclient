package b.a.r0.m1.b;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import b.a.e.a.f;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.switchs.MessageChooseFriendSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
import com.baidu.tieba.imMessageCenter.mention.MessageFragmentPagerAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h extends b.a.e.a.d implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MessageCenterFragment f21050e;

    /* renamed from: f  reason: collision with root package name */
    public TbTabLayout f21051f;

    /* renamed from: g  reason: collision with root package name */
    public BdBaseViewPager f21052g;

    /* renamed from: h  reason: collision with root package name */
    public MessageFragmentPagerAdapter f21053h;

    /* renamed from: i  reason: collision with root package name */
    public List<MessageFragmentPagerAdapter.a> f21054i;
    public View j;
    public ChatAggregationFragment k;
    public ImageView l;
    public NavigationBar m;
    public NoNetworkView n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f21055e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21055e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21055e.f21050e == null) {
                return;
            }
            this.f21055e.f21050e.onNavigationBarBackBtnClick();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f21056e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21056e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21056e.f21050e == null) {
                return;
            }
            this.f21056e.f21050e.onNavigationBarChatBtnClick();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MessageCenterFragment messageCenterFragment) {
        super(messageCenterFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageCenterFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21050e = messageCenterFragment;
    }

    public static String j(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i2 + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public TbTabLayout.f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TbTabLayout tbTabLayout = this.f21051f;
            if (tbTabLayout == null || tbTabLayout.getTabCount() <= 0) {
                return null;
            }
            TbTabLayout tbTabLayout2 = this.f21051f;
            return tbTabLayout2.getTabAt(tbTabLayout2.getSelectedTabPosition());
        }
        return (TbTabLayout.f) invokeV.objValue;
    }

    public TbTabLayout.f e(int i2) {
        InterceptResult invokeI;
        int tabCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            TbTabLayout tbTabLayout = this.f21051f;
            if (tbTabLayout != null && (tabCount = tbTabLayout.getTabCount()) > 0) {
                for (int i3 = 0; i3 < tabCount; i3++) {
                    TbTabLayout.f tabAt = this.f21051f.getTabAt(i3);
                    if (tabAt != null && tabAt.d() != -1 && tabAt.d() == i2) {
                        return tabAt;
                    }
                }
            }
            return null;
        }
        return (TbTabLayout.f) invokeI.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.navigation_bar);
            this.m = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (addSystemImageButton != null) {
                if (this.f21050e.getActivity() instanceof MessageCenterActivity) {
                    addSystemImageButton.setVisibility(0);
                } else {
                    addSystemImageButton.setVisibility(4);
                }
            }
            this.l = new ImageView(this.f21050e.getContext());
            int g2 = b.a.e.e.p.l.g(this.f21050e.getContext(), R.dimen.ds88);
            this.l.setLayoutParams(new ViewGroup.LayoutParams(g2, g2));
            this.l.setScaleType(ImageView.ScaleType.CENTER);
            this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.l, new b(this));
            if (this.l.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, b.a.e.e.p.l.g(this.f21050e.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
                this.l.setLayoutParams(marginLayoutParams);
            }
            if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(4);
            }
            TbTabLayout tbTabLayout = this.f21051f;
            if (tbTabLayout != null) {
                this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, tbTabLayout, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.f21051f.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 17;
                    viewGroup.setLayoutParams(layoutParams);
                }
                TbTabLayout tbTabLayout2 = this.f21051f;
                tbTabLayout2.setPadding(tbTabLayout2.getPaddingLeft(), this.f21051f.getPaddingTop(), this.f21051f.getPaddingRight(), this.f21051f.getPaddingBottom() + b.a.e.e.p.l.g(this.f21050e.getContext(), R.dimen.ds1));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbTabLayout tbTabLayout = (TbTabLayout) LayoutInflater.from(this.f21050e.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
            this.f21051f = tbTabLayout;
            tbTabLayout.setupWithViewPager(this.f21052g);
            int tabCount = this.f21051f.getTabCount();
            if (tabCount > 0) {
                for (int i2 = 0; i2 < tabCount; i2++) {
                    this.f21051f.getTabAt(i2).q(1);
                }
            }
        }
    }

    public void h(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || view == null) {
            return;
        }
        this.j = view;
        i();
        g();
        f();
        NoNetworkView noNetworkView = (NoNetworkView) this.j.findViewById(R.id.view_no_network);
        this.n = noNetworkView;
        noNetworkView.addNetworkChangeListener(this);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21052g = (BdBaseViewPager) this.j.findViewById(R.id.message_viewpager);
            MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
            ChatAggregationFragment chatAggregationFragment = new ChatAggregationFragment();
            this.k = chatAggregationFragment;
            aVar.f50805a = chatAggregationFragment;
            aVar.f50806b = this.f21050e.getResources().getString(R.string.message_center_message_tab);
            ArrayList arrayList = new ArrayList();
            this.f21054i = arrayList;
            arrayList.add(aVar);
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = new MessageFragmentPagerAdapter(this.f21050e.getActivity().getSupportFragmentManager(), this.f21054i);
            this.f21053h = messageFragmentPagerAdapter;
            this.f21052g.setAdapter(messageFragmentPagerAdapter);
            this.f21052g.setOffscreenPageLimit(this.f21054i.size());
            this.f21053h.notifyDataSetChanged();
        }
    }

    public void k(int i2, int i3, Intent intent) {
        List<MessageFragmentPagerAdapter.a> list;
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) || (list = this.f21054i) == null || list.size() <= 0 || (bdBaseViewPager = this.f21052g) == null) {
            return;
        }
        MessageFragmentPagerAdapter.a aVar = this.f21054i.get(bdBaseViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f50805a) == null) {
            return;
        }
        fragment.onActivityResult(i2, i3, intent);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageCenterFragment messageCenterFragment = this.f21050e;
            if (messageCenterFragment != null && this.f21054i != null && this.f21052g != null && this.f21053h != null) {
                FragmentManager supportFragmentManager = messageCenterFragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i2 = 0; i2 < this.f21054i.size(); i2++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(j(this.f21052g.getId(), this.f21053h.getItemId(i2)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.n;
            if (noNetworkView != null) {
                noNetworkView.removeNetworkChangeListener(this);
            }
        }
    }

    public void m() {
        ChatAggregationFragment chatAggregationFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (chatAggregationFragment = this.k) == null) {
            return;
        }
        chatAggregationFragment.refreshPage();
    }

    public void n(int i2) {
        TbTabLayout.f e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (e2 = e(i2)) == null) {
            return;
        }
        e2.l();
    }

    public void o(boolean z) {
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = this.f21053h;
            if (messageFragmentPagerAdapter != null) {
                messageFragmentPagerAdapter.setPrimary(z);
            }
            List<MessageFragmentPagerAdapter.a> list = this.f21054i;
            if (list == null || list.size() <= 0 || (bdBaseViewPager = this.f21052g) == null) {
                return;
            }
            MessageFragmentPagerAdapter.a aVar = this.f21054i.get(bdBaseViewPager.getCurrentItem());
            if (aVar == null || (fragment = aVar.f50805a) == null || !(fragment instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) fragment).setPrimary(z);
        }
    }

    public void onChangeSkinType(int i2) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            NavigationBar navigationBar = this.m;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i2);
                SkinManager.setBackgroundColor(this.m.getBarBgView(), R.color.CAM_X0207, i2);
            }
            NoNetworkView noNetworkView = this.n;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), i2);
            }
            List<MessageFragmentPagerAdapter.a> list = this.f21054i;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.f21054i.size(); i3++) {
                    MessageFragmentPagerAdapter.a aVar = this.f21054i.get(i3);
                    if (aVar != null && (fragment = aVar.f50805a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i2);
                    }
                }
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            TbTabLayout tbTabLayout = this.f21051f;
            if (tbTabLayout != null) {
                tbTabLayout.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
                this.f21051f.setSelectedTabIndicatorHeight(0);
                this.f21051f.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void onNetworkChange(boolean z) {
        List<MessageFragmentPagerAdapter.a> list;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f21054i) == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f21054i.size(); i2++) {
            MessageFragmentPagerAdapter.a aVar = this.f21054i.get(i2);
            if (aVar != null && (fragment = aVar.f50805a) != null && (fragment instanceof NoNetworkView.b)) {
                ((NoNetworkView.b) fragment).onNetworkChange(z);
            }
        }
    }
}
