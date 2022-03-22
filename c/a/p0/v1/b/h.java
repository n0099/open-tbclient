package c.a.p0.v1.b;

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
import c.a.d.a.f;
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
/* loaded from: classes2.dex */
public class h extends c.a.d.a.d implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageCenterFragment a;

    /* renamed from: b  reason: collision with root package name */
    public TbTabLayout f19128b;

    /* renamed from: c  reason: collision with root package name */
    public BdBaseViewPager f19129c;

    /* renamed from: d  reason: collision with root package name */
    public MessageFragmentPagerAdapter f19130d;

    /* renamed from: e  reason: collision with root package name */
    public List<MessageFragmentPagerAdapter.a> f19131e;

    /* renamed from: f  reason: collision with root package name */
    public View f19132f;

    /* renamed from: g  reason: collision with root package name */
    public ChatAggregationFragment f19133g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19134h;
    public NavigationBar i;
    public NoNetworkView j;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.a == null) {
                return;
            }
            this.a.a.F0();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.a == null) {
                return;
            }
            this.a.a.G0();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = messageCenterFragment;
    }

    public static String l(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public TbTabLayout.f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TbTabLayout tbTabLayout = this.f19128b;
            if (tbTabLayout == null || tbTabLayout.getTabCount() <= 0) {
                return null;
            }
            TbTabLayout tbTabLayout2 = this.f19128b;
            return tbTabLayout2.w(tbTabLayout2.getSelectedTabPosition());
        }
        return (TbTabLayout.f) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void f(boolean z) {
        List<MessageFragmentPagerAdapter.a> list;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (list = this.f19131e) == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f19131e.size(); i++) {
            MessageFragmentPagerAdapter.a aVar = this.f19131e.get(i);
            if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof NoNetworkView.b)) {
                ((NoNetworkView.b) fragment).f(z);
            }
        }
    }

    public TbTabLayout.f g(int i) {
        InterceptResult invokeI;
        int tabCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            TbTabLayout tbTabLayout = this.f19128b;
            if (tbTabLayout != null && (tabCount = tbTabLayout.getTabCount()) > 0) {
                for (int i2 = 0; i2 < tabCount; i2++) {
                    TbTabLayout.f w = this.f19128b.w(i2);
                    if (w != null && w.d() != -1 && w.d() == i) {
                        return w;
                    }
                }
            }
            return null;
        }
        return (TbTabLayout.f) invokeI.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f19132f.findViewById(R.id.obfuscated_res_0x7f091519);
            this.i = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            if (addSystemImageButton != null) {
                if (this.a.getActivity() instanceof MessageCenterActivity) {
                    addSystemImageButton.setVisibility(0);
                } else {
                    addSystemImageButton.setVisibility(4);
                }
            }
            this.f19134h = new ImageView(this.a.getContext());
            int f2 = c.a.d.f.p.n.f(this.a.getContext(), R.dimen.obfuscated_res_0x7f0702ff);
            this.f19134h.setLayoutParams(new ViewGroup.LayoutParams(f2, f2));
            this.f19134h.setScaleType(ImageView.ScaleType.CENTER);
            this.i.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f19134h, new b(this));
            if (this.f19134h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f19134h.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, c.a.d.f.p.n.f(this.a.getContext(), R.dimen.obfuscated_res_0x7f0701b2), marginLayoutParams.bottomMargin);
                this.f19134h.setLayoutParams(marginLayoutParams);
            }
            if (SwitchManager.getInstance().findType(MessageChooseFriendSwitch.SWITCH_NAME) == 1) {
                this.f19134h.setVisibility(0);
            } else {
                this.f19134h.setVisibility(4);
            }
            TbTabLayout tbTabLayout = this.f19128b;
            if (tbTabLayout != null) {
                this.i.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, tbTabLayout, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.f19128b.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(17);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 17;
                    viewGroup.setLayoutParams(layoutParams);
                }
                TbTabLayout tbTabLayout2 = this.f19128b;
                tbTabLayout2.setPadding(tbTabLayout2.getPaddingLeft(), this.f19128b.getPaddingTop(), this.f19128b.getPaddingRight(), this.f19128b.getPaddingBottom() + c.a.d.f.p.n.f(this.a.getContext(), R.dimen.obfuscated_res_0x7f070198));
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbTabLayout tbTabLayout = (TbTabLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0556, (ViewGroup) null);
            this.f19128b = tbTabLayout;
            tbTabLayout.setupWithViewPager(this.f19129c);
            int tabCount = this.f19128b.getTabCount();
            if (tabCount > 0) {
                for (int i = 0; i < tabCount; i++) {
                    this.f19128b.w(i).q(1);
                }
            }
        }
    }

    public void j(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null) {
            return;
        }
        this.f19132f = view;
        k();
        i();
        h();
        NoNetworkView noNetworkView = (NoNetworkView) this.f19132f.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.j = noNetworkView;
        noNetworkView.a(this);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f19129c = (BdBaseViewPager) this.f19132f.findViewById(R.id.obfuscated_res_0x7f091410);
            MessageFragmentPagerAdapter.a aVar = new MessageFragmentPagerAdapter.a();
            ChatAggregationFragment chatAggregationFragment = new ChatAggregationFragment();
            this.f19133g = chatAggregationFragment;
            aVar.a = chatAggregationFragment;
            aVar.f34050b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ab7);
            ArrayList arrayList = new ArrayList();
            this.f19131e = arrayList;
            arrayList.add(aVar);
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = new MessageFragmentPagerAdapter(this.a.getActivity().getSupportFragmentManager(), this.f19131e);
            this.f19130d = messageFragmentPagerAdapter;
            this.f19129c.setAdapter(messageFragmentPagerAdapter);
            this.f19129c.setOffscreenPageLimit(this.f19131e.size());
            this.f19130d.notifyDataSetChanged();
        }
    }

    public void m(int i, int i2, Intent intent) {
        List<MessageFragmentPagerAdapter.a> list;
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) || (list = this.f19131e) == null || list.size() <= 0 || (bdBaseViewPager = this.f19129c) == null) {
            return;
        }
        MessageFragmentPagerAdapter.a aVar = this.f19131e.get(bdBaseViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.a) == null) {
            return;
        }
        fragment.onActivityResult(i, i2, intent);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageCenterFragment messageCenterFragment = this.a;
            if (messageCenterFragment != null && this.f19131e != null && this.f19129c != null && this.f19130d != null) {
                FragmentManager supportFragmentManager = messageCenterFragment.getActivity().getSupportFragmentManager();
                if (supportFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.f19131e.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(l(this.f19129c.getId(), this.f19130d.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.d(this);
            }
        }
    }

    public void o() {
        ChatAggregationFragment chatAggregationFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (chatAggregationFragment = this.f19133g) == null) {
            return;
        }
        chatAggregationFragment.n();
    }

    public void onChangeSkinType(int i) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            NavigationBar navigationBar = this.i;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
                SkinManager.setBackgroundColor(this.i.getBarBgView(), R.color.CAM_X0207, i);
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.c(getPageContext(), i);
            }
            List<MessageFragmentPagerAdapter.a> list = this.f19131e;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.f19131e.size(); i2++) {
                    MessageFragmentPagerAdapter.a aVar = this.f19131e.get(i2);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                        ((BaseFragment) fragment).onChangeSkinType(i);
                    }
                }
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19134h, R.drawable.obfuscated_res_0x7f0805fc, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            TbTabLayout tbTabLayout = this.f19128b;
            if (tbTabLayout != null) {
                tbTabLayout.setSelectedTabIndicatorColor(this.mContext.getResources().getColor(R.color.transparent));
                this.f19128b.setSelectedTabIndicatorHeight(0);
                this.f19128b.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void p(int i) {
        TbTabLayout.f g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (g2 = g(i)) == null) {
            return;
        }
        g2.l();
    }

    public void q(boolean z) {
        BdBaseViewPager bdBaseViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            MessageFragmentPagerAdapter messageFragmentPagerAdapter = this.f19130d;
            if (messageFragmentPagerAdapter != null) {
                messageFragmentPagerAdapter.b(z);
            }
            List<MessageFragmentPagerAdapter.a> list = this.f19131e;
            if (list == null || list.size() <= 0 || (bdBaseViewPager = this.f19129c) == null) {
                return;
            }
            MessageFragmentPagerAdapter.a aVar = this.f19131e.get(bdBaseViewPager.getCurrentItem());
            if (aVar == null || (fragment = aVar.a) == null || !(fragment instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) fragment).setPrimary(z);
        }
    }
}
