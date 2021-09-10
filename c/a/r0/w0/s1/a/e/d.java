package c.a.r0.w0.s1.a.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment;
import com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGameStrategyMainFragment f27805a;

    /* renamed from: b  reason: collision with root package name */
    public View f27806b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f27807c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f27808d;

    /* renamed from: e  reason: collision with root package name */
    public ScrollLabelTabHost f27809e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f27810f;

    /* renamed from: g  reason: collision with root package name */
    public String f27811g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f27812e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27812e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f27812e.f27805a.getFid())) {
                return;
            }
            this.f27812e.f27805a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f27812e.f27805a.getPageContext().getPageActivity(), this.f27812e.f27805a.getFid(), ForumDetailActivityConfig.FromType.FRS_GAME_STRATEGY)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f27813e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27813e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (FrsGameStrategyMainFragment.FROM_SINGLE_ACT.equals(this.f27813e.f27811g)) {
                    this.f27813e.f27805a.getActivity().finish();
                    return;
                }
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f27813e.f27805a.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    public d(FrsGameStrategyMainFragment frsGameStrategyMainFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGameStrategyMainFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27805a = frsGameStrategyMainFragment;
        this.f27806b = view;
        if (view != null) {
            g();
        }
    }

    public void c(int i2, int i3, List<n> list, List<c.a.r0.w0.s1.a.d.e> list2, boolean z, boolean z2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) {
            this.f27809e.fillDataByTabAndLabel(i2, i3, list, list2, z, z2, i4);
        }
    }

    public void d() {
        ScrollLabelTabHost scrollLabelTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (scrollLabelTabHost = this.f27809e) == null) {
            return;
        }
        scrollLabelTabHost.forceRefresh();
    }

    public NavigationBar e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27807c : (NavigationBar) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27806b : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f27807c = (NavigationBar) this.f27806b.findViewById(R.id.view_navigation_bar);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.g(this.f27805a.getPageContext().getPageActivity(), R.dimen.ds24), 0);
            ImageView imageView = (ImageView) this.f27807c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_game_forum_info_item, (View.OnClickListener) null);
            this.f27810f = imageView;
            imageView.setLayoutParams(layoutParams);
            this.f27810f.setOnClickListener(new a(this));
            this.f27807c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
            this.f27808d = (NoNetworkView) this.f27806b.findViewById(R.id.view_no_network);
            ScrollLabelTabHost scrollLabelTabHost = (ScrollLabelTabHost) this.f27806b.findViewById(R.id.frs_game_tabview);
            this.f27809e = scrollLabelTabHost;
            scrollLabelTabHost.setPageId(this.f27805a.getBaseFragmentActivity().getUniqueId());
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f27807c.onChangeSkinType(this.f27805a.getPageContext(), i2);
            this.f27808d.onChangeSkinType(this.f27805a.getPageContext(), i2);
            this.f27809e.onChangeSkinType(i2);
            ImageView imageView = this.f27810f;
            if (imageView != null) {
                SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f27809e.onDestory();
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f27811g = str;
        }
    }

    public void k(c.a.r0.w0.s1.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f27809e.setDelegateFrsGameTabDataLoadListener(aVar);
        }
    }

    public void l(List<c.a.r0.w0.s1.a.d.e> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, list, z) == null) {
            this.f27809e.setTabData(list, z);
        }
    }

    public void m(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, str) == null) {
            this.f27809e.showErrorByTabAndLabel(i2, i3, str);
        }
    }
}
