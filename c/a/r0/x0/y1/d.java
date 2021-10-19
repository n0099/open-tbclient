package c.a.r0.x0.y1;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f28229a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f28230b;

    /* renamed from: c  reason: collision with root package name */
    public SpecialFrsWebFragment f28231c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.f0.d f28232d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f28233e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f28234f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f28235g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f28236h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f28237i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f28238e;

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
            this.f28238e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f28238e.f28233e) {
                    this.f28238e.r();
                } else if (this.f28238e.f28232d == null || view != this.f28238e.f28232d.c()) {
                    if (view != this.f28238e.f28235g) {
                        if (view == this.f28238e.f28234f) {
                            d dVar = this.f28238e;
                            dVar.q(dVar.f28231c.getShareContent(null, null, null, null));
                        }
                    } else if (StringUtils.isNull(this.f28238e.h())) {
                    } else {
                        this.f28238e.f28229a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f28238e.f28229a.getPageActivity(), this.f28238e.h(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.f28238e.f28229a.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                    this.f28238e.f28229a.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.f28238e.f28229a.getPageActivity())));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f28239a;

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
            this.f28239a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (this.f28239a.f28232d != null) {
                    this.f28239a.f28232d.e(z, msgCount);
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
        this.f28236h = new a(this);
        this.f28237i = new b(this, 2001626);
        this.f28229a = fVar;
        c.a.r0.f0.d dVar = new c.a.r0.f0.d(fVar.getPageActivity());
        this.f28232d = dVar;
        dVar.c().setOnClickListener(this.f28236h);
        this.f28229a.registerListener(this.f28237i);
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SpecialFrsWebFragment specialFrsWebFragment = this.f28231c;
            return specialFrsWebFragment != null ? specialFrsWebFragment.getForumId() : "";
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SpecialFrsWebFragment specialFrsWebFragment = this.f28231c;
            return specialFrsWebFragment != null ? specialFrsWebFragment.getForumName() : "";
        }
        return (String) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28230b : (NavigationBar) invokeV.objValue;
    }

    public void k(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, navigationBar, specialFrsWebFragment) == null) {
            this.f28230b = navigationBar;
            this.f28231c = specialFrsWebFragment;
            navigationBar.showBottomLine();
            this.f28230b.getBarBgView().setAlpha(1.0f);
            this.f28230b.setCenterTextTitle(i());
            ImageView imageView = (ImageView) this.f28230b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
            this.f28233e = imageView;
            imageView.setOnClickListener(this.f28236h);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.g(this.f28229a.getPageActivity(), R.dimen.ds24), 0);
            ImageView imageView2 = (ImageView) this.f28230b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
            this.f28234f = imageView2;
            imageView2.setLayoutParams(layoutParams);
            this.f28234f.setOnClickListener(this.f28236h);
            ImageView imageView3 = (ImageView) this.f28230b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.f28235g = imageView3;
            imageView3.setLayoutParams(layoutParams);
            this.f28235g.setOnClickListener(this.f28236h);
            o(specialFrsWebFragment.isNeedShowNavigationBar());
            p(specialFrsWebFragment.isNeedShowShareItem());
            n(specialFrsWebFragment.isNeedShowMenuItem());
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(int i2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f28231c == null || (navigationBar = this.f28230b) == null) {
            return;
        }
        navigationBar.onChangeSkinType(this.f28229a, i2);
        SkinManager.setViewTextColor(this.f28230b.mTextTitle, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f28230b.mCenterText, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.f28230b.getBottomLine(), R.color.CAM_X0204);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f28233e, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        c.a.r0.f0.d dVar = this.f28232d;
        if (dVar != null) {
            dVar.d(i2);
        }
        SkinManager.setNavbarIconSrc(this.f28235g, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f28234f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NavigationBar navigationBar = this.f28230b;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MessageManager.getInstance().unRegisterListener(this.f28237i);
        }
    }

    public void n(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (imageView = this.f28235g) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void o(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (navigationBar = this.f28230b) == null) {
            return;
        }
        navigationBar.setVisibility(z ? 0 : 8);
    }

    public void p(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.f28234f) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void q(ShareItem shareItem) {
        SpecialFrsWebFragment specialFrsWebFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, shareItem) == null) || (specialFrsWebFragment = this.f28231c) == null) {
            return;
        }
        specialFrsWebFragment.showShareDialog(shareItem);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f28229a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }
}
