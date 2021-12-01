package c.a.r0.d1.j2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f15619b;

    /* renamed from: c  reason: collision with root package name */
    public SpecialFrsWebFragment f15620c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.k0.f f15621d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15622e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15623f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15624g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f15625h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f15626i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15627e;

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
            this.f15627e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f15627e.f15622e) {
                    this.f15627e.r();
                } else if (this.f15627e.f15621d == null || view != this.f15627e.f15621d.c()) {
                    if (view != this.f15627e.f15624g) {
                        if (view == this.f15627e.f15623f) {
                            d dVar = this.f15627e;
                            dVar.q(dVar.f15620c.getShareContent(null, null, null, null));
                        }
                    } else if (StringUtils.isNull(this.f15627e.h())) {
                    } else {
                        this.f15627e.a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f15627e.a.getPageActivity(), this.f15627e.h(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.f15627e.a.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                    this.f15627e.a.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.f15627e.a.getPageActivity())));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (this.a.f15621d != null) {
                    this.a.f15621d.e(z, msgCount);
                }
            }
        }
    }

    public d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15625h = new a(this);
        this.f15626i = new b(this, 2001626);
        this.a = fVar;
        c.a.r0.k0.f fVar2 = new c.a.r0.k0.f(fVar.getPageActivity());
        this.f15621d = fVar2;
        fVar2.c().setOnClickListener(this.f15625h);
        this.a.registerListener(this.f15626i);
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SpecialFrsWebFragment specialFrsWebFragment = this.f15620c;
            return specialFrsWebFragment != null ? specialFrsWebFragment.getForumId() : "";
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SpecialFrsWebFragment specialFrsWebFragment = this.f15620c;
            return specialFrsWebFragment != null ? specialFrsWebFragment.getForumName() : "";
        }
        return (String) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15619b : (NavigationBar) invokeV.objValue;
    }

    public void k(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, navigationBar, specialFrsWebFragment) == null) {
            this.f15619b = navigationBar;
            this.f15620c = specialFrsWebFragment;
            navigationBar.showBottomLine();
            this.f15619b.getBarBgView().setAlpha(1.0f);
            this.f15619b.setCenterTextTitle(i());
            ImageView imageView = (ImageView) this.f15619b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
            this.f15622e = imageView;
            imageView.setOnClickListener(this.f15625h);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.f(this.a.getPageActivity(), R.dimen.ds24), 0);
            ImageView imageView2 = (ImageView) this.f15619b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
            this.f15623f = imageView2;
            imageView2.setLayoutParams(layoutParams);
            this.f15623f.setOnClickListener(this.f15625h);
            ImageView imageView3 = (ImageView) this.f15619b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.f15624g = imageView3;
            imageView3.setLayoutParams(layoutParams);
            this.f15624g.setOnClickListener(this.f15625h);
            o(specialFrsWebFragment.isNeedShowNavigationBar());
            p(specialFrsWebFragment.isNeedShowShareItem());
            n(specialFrsWebFragment.isNeedShowMenuItem());
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(int i2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f15620c == null || (navigationBar = this.f15619b) == null) {
            return;
        }
        navigationBar.onChangeSkinType(this.a, i2);
        SkinManager.setViewTextColor(this.f15619b.mTextTitle, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f15619b.mCenterText, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.f15619b.getBottomLine(), R.color.CAM_X0204);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15622e, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        c.a.r0.k0.f fVar = this.f15621d;
        if (fVar != null) {
            fVar.d(i2);
        }
        SkinManager.setNavbarIconSrc(this.f15624g, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15623f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NavigationBar navigationBar = this.f15619b;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MessageManager.getInstance().unRegisterListener(this.f15626i);
        }
    }

    public void n(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (imageView = this.f15624g) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void o(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (navigationBar = this.f15619b) == null) {
            return;
        }
        navigationBar.setVisibility(z ? 0 : 8);
    }

    public void p(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.f15623f) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void q(ShareItem shareItem) {
        SpecialFrsWebFragment specialFrsWebFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, shareItem) == null) || (specialFrsWebFragment = this.f15620c) == null) {
            return;
        }
        specialFrsWebFragment.showShareDialog(shareItem);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }
}
