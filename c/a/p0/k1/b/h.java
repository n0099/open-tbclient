package c.a.p0.k1.b;

import android.content.Intent;
import android.os.Bundle;
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
import c.a.e.a.f;
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
/* loaded from: classes3.dex */
public class h extends c.a.e.a.d implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MessageCenterFragment f21034e;

    /* renamed from: f  reason: collision with root package name */
    public TbTabLayout f21035f;

    /* renamed from: g  reason: collision with root package name */
    public BdBaseViewPager f21036g;

    /* renamed from: h  reason: collision with root package name */
    public MessageFragmentPagerAdapter f21037h;

    /* renamed from: i  reason: collision with root package name */
    public List<MessageFragmentPagerAdapter.a> f21038i;

    /* renamed from: j  reason: collision with root package name */
    public View f21039j;
    public ChatAggregationFragment k;
    public ImageView l;
    public NavigationBar m;
    public NoNetworkView n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f21040e;

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
            this.f21040e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21040e.f21034e == null) {
                return;
            }
            this.f21040e.f21034e.onNavigationBarBackBtnClick();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f21041e;

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
            this.f21041e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21041e.f21034e == null) {
                return;
            }
            this.f21041e.f21034e.onNavigationBarChatBtnClick();
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
        this.f21034e = messageCenterFragment;
    }

    public static String k(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            return "android:switcher:" + i2 + ":" + j2;
        }
        return (String) invokeCommon.objValue;
    }

    public void d(TbTabLayout.c cVar) {
        TbTabLayout tbTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || (tbTabLayout = this.f21035f) == null || cVar == null) {
            return;
        }
        tbTabLayout.addOnTabSelectedListener(cVar);
    }

    public TbTabLayout.f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbTabLayout tbTabLayout = this.f21035f;
            if (tbTabLayout == null || tbTabLayout.getTabCount() <= 0) {
                return null;
            }
            TbTabLayout tbTabLayout2 = this.f21035f;
            return tbTabLayout2.getTabAt(tbTabLayout2.getSelectedTabPosition());
        }
        return (TbTabLayout.f) invokeV.objValue;
    }

    public TbTabLayout.f f(int i2) {
        InterceptResult invokeI;
        int tabCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            TbTabLayout tbTabLayout = this.f21035f;
            if (tbTabLayout != null && (tabCount = tbTabLayout.getTabCount()) > 0) {
                for (int i3 = 0; i3 < tabCount; i3++) {
                    TbTabLayout.f tabAt = this.f21035f.getTabAt(i3);
                    if (tabAt != null && tabAt.d() != -1 && tabAt.d() == i2) {
                        return tabAt;
                    }
                }
            }
            return null;
        }
        return (TbTabLayout.f) invokeI.objValue;
    }

    public final void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f21039j.findViewById(R.id.navigation_bar);
            this.m = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (addSystemImageButton != null) {
                if (this.f21034e.getActivity() instanceof MessageCenterActivity) {
                    addSystemImageButton.setVisibility(0);
                } else {
                    addSystemImageButton.setVisibility(4);
                }
            }
            this.l = new ImageView(this.f21034e.getContext());
            int g2 = c.a.e.e.p.l.g(this.f21034e.getContext(), R.dimen.ds88);
            this.l.setLayoutParams(new ViewGroup.LayoutParams(g2, g2));
            this.l.setScaleType(ImageView.ScaleType.CENTER);
            this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.l, new b(this));
            if (this.l.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, c.a.e.e.p.l.g(this.f21034e.getContext(), R.dimen.ds14), marginLayoutParams.bottomMargin);
                this.l.setLayoutParams(marginLayoutParams);
            }
            if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(4);
            }
            TbTabLayout tbTabLayout = this.f21035f;
            if (tbTabLayout != null) {
                this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, tbTabLayout, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.f21035f.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 17;
                    viewGroup.setLayoutParams(layoutParams);
                }
                TbTabLayout tbTabLayout2 = this.f21035f;
                tbTabLayout2.setPadding(tbTabLayout2.getPaddingLeft(), this.f21035f.getPaddingTop(), this.f21035f.getPaddingRight(), this.f21035f.getPaddingBottom() + c.a.e.e.p.l.g(this.f21034e.getContext(), R.dimen.ds1));
            }
        }
    }

    public final void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            TbTabLayout tbTabLayout = (TbTabLayout) LayoutInflater.from(this.f21034e.getContext()).inflate(R.layout.message_center_tab_layout, (ViewGroup) null);
            this.f21035f = tbTabLayout;
            tbTabLayout.setupWithViewPager(this.f21036g);
            int tabCount = this.f21035f.getTabCount();
            if (tabCount > 0) {
                for (int i2 = 0; i2 < tabCount; i2++) {
                    this.f21035f.getTabAt(i2).q(1);
                }
            }
        }
    }

    public void i(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, view, bundle) == null) || view == null) {
            return;
        }
        this.f21039j = view;
        j(bundle);
        h(bundle);
        g(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) this.f21039j.findViewById(R.id.view_no_network);
        this.n = noNetworkView;
        noNetworkView.addNetworkChangeListener(this);
    }

    public final void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            this.f21036g = (BdBaseViewPager) this.f21039j.findViewById(R.id.message_viewpager);
            MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
            ChatAggregationFragment chatAggregationFragment = new ChatAggregationFragment();
            this.k = chatAggregationFragment;
            aVar.f53216a = chatAggregationFragment;
            aVar.f53217b = this.f21034e.getResources().getString(R.string.message_center_message_tab);
            ArrayList arrayList = new ArrayList();
            this.f21038i = arrayList;
            arrayList.add(aVar);
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = new MessageFragmentPagerAdapter(this.f21034e.getActivity().getSupportFragmentManager(), this.f21038i);
            this.f21037h = messageFragmentPagerAdapter;
            this.f21036g.setAdapter(messageFragmentPagerAdapter);
            this.f21036g.setOffscreenPageLimit(this.f21038i.size());
            this.f21037h.notifyDataSetChanged();
        }
    }

    public void l(int i2, int i3, Intent intent) {
        List<MessageFragmentPagerAdapter.a> list;
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) || (list = this.f21038i) == null || list.size() <= 0 || (bdBaseViewPager = this.f21036g) == null) {
            return;
        }
        MessageFragmentPagerAdapter.a aVar = this.f21038i.get(bdBaseViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f53216a) == null) {
            return;
        }
        fragment.onActivityResult(i2, i3, intent);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageCenterFragment messageCenterFragment = this.f21034e;
            if (messageCenterFragment != null && this.f21038i != null && this.f21036g != null && this.f21037h != null) {
                FragmentManager supportFragmentManager = messageCenterFragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i2 = 0; i2 < this.f21038i.size(); i2++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(k(this.f21036g.getId(), this.f21037h.getItemId(i2)));
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

    public void n() {
        ChatAggregationFragment chatAggregationFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (chatAggregationFragment = this.k) == null) {
            return;
        }
        chatAggregationFragment.refreshPage();
    }

    public void o(TbTabLayout.c cVar) {
        TbTabLayout tbTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || (tbTabLayout = this.f21035f) == null || cVar == null) {
            return;
        }
        tbTabLayout.removeOnTabSelectedListener(cVar);
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
            List<MessageFragmentPagerAdapter.a> list = this.f21038i;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.f21038i.size(); i3++) {
                    MessageFragmentPagerAdapter.a aVar = this.f21038i.get(i3);
                    if (aVar != null && (fragment = aVar.f53216a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i2);
                    }
                }
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_chat_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            TbTabLayout tbTabLayout = this.f21035f;
            if (tbTabLayout != null) {
                tbTabLayout.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
                this.f21035f.setSelectedTabIndicatorHeight(0);
                this.f21035f.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void onNetworkChange(boolean z) {
        List<MessageFragmentPagerAdapter.a> list;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f21038i) == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f21038i.size(); i2++) {
            MessageFragmentPagerAdapter.a aVar = this.f21038i.get(i2);
            if (aVar != null && (fragment = aVar.f53216a) != null && (fragment instanceof NoNetworkView.b)) {
                ((NoNetworkView.b) fragment).onNetworkChange(z);
            }
        }
    }

    public void p(int i2) {
        TbTabLayout.f f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (f2 = f(i2)) == null) {
            return;
        }
        f2.l();
    }

    public void q(boolean z) {
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = this.f21037h;
            if (messageFragmentPagerAdapter != null) {
                messageFragmentPagerAdapter.setPrimary(z);
            }
            List<MessageFragmentPagerAdapter.a> list = this.f21038i;
            if (list == null || list.size() <= 0 || (bdBaseViewPager = this.f21036g) == null) {
                return;
            }
            MessageFragmentPagerAdapter.a aVar = this.f21038i.get(bdBaseViewPager.getCurrentItem());
            if (aVar == null || (fragment = aVar.f53216a) == null || !(fragment instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) fragment).setPrimary(z);
        }
    }
}
