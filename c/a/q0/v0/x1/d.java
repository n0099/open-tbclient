package c.a.q0.v0.x1;

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
    public f f27348a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f27349b;

    /* renamed from: c  reason: collision with root package name */
    public SpecialFrsWebFragment f27350c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.e0.d f27351d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f27352e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f27353f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f27354g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f27355h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f27356i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f27357e;

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
            this.f27357e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f27357e.f27352e) {
                    this.f27357e.r();
                } else if (this.f27357e.f27351d == null || view != this.f27357e.f27351d.c()) {
                    if (view != this.f27357e.f27354g) {
                        if (view == this.f27357e.f27353f) {
                            d dVar = this.f27357e;
                            dVar.q(dVar.f27350c.getShareContent(null, null, null, null));
                        }
                    } else if (StringUtils.isNull(this.f27357e.h())) {
                    } else {
                        this.f27357e.f27348a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f27357e.f27348a.getPageActivity(), this.f27357e.h(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.f27357e.f27348a.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                    this.f27357e.f27348a.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.f27357e.f27348a.getPageActivity())));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f27358a;

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
            this.f27358a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (this.f27358a.f27351d != null) {
                    this.f27358a.f27351d.e(z, msgCount);
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
        this.f27355h = new a(this);
        this.f27356i = new b(this, 2001626);
        this.f27348a = fVar;
        c.a.q0.e0.d dVar = new c.a.q0.e0.d(fVar.getPageActivity());
        this.f27351d = dVar;
        dVar.c().setOnClickListener(this.f27355h);
        this.f27348a.registerListener(this.f27356i);
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SpecialFrsWebFragment specialFrsWebFragment = this.f27350c;
            return specialFrsWebFragment != null ? specialFrsWebFragment.getForumId() : "";
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SpecialFrsWebFragment specialFrsWebFragment = this.f27350c;
            return specialFrsWebFragment != null ? specialFrsWebFragment.getForumName() : "";
        }
        return (String) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27349b : (NavigationBar) invokeV.objValue;
    }

    public void k(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, navigationBar, specialFrsWebFragment) == null) {
            this.f27349b = navigationBar;
            this.f27350c = specialFrsWebFragment;
            navigationBar.showBottomLine();
            this.f27349b.getBarBgView().setAlpha(1.0f);
            this.f27349b.setCenterTextTitle(i());
            ImageView imageView = (ImageView) this.f27349b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
            this.f27352e = imageView;
            imageView.setOnClickListener(this.f27355h);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.g(this.f27348a.getPageActivity(), R.dimen.ds24), 0);
            ImageView imageView2 = (ImageView) this.f27349b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
            this.f27353f = imageView2;
            imageView2.setLayoutParams(layoutParams);
            this.f27353f.setOnClickListener(this.f27355h);
            ImageView imageView3 = (ImageView) this.f27349b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.f27354g = imageView3;
            imageView3.setLayoutParams(layoutParams);
            this.f27354g.setOnClickListener(this.f27355h);
            o(specialFrsWebFragment.isNeedShowNavigationBar());
            p(specialFrsWebFragment.isNeedShowShareItem());
            n(specialFrsWebFragment.isNeedShowMenuItem());
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void l(int i2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f27350c == null || (navigationBar = this.f27349b) == null) {
            return;
        }
        navigationBar.onChangeSkinType(this.f27348a, i2);
        SkinManager.setViewTextColor(this.f27349b.mTextTitle, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f27349b.mCenterText, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.f27349b.getBottomLine(), R.color.CAM_X0204);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f27352e, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        c.a.q0.e0.d dVar = this.f27351d;
        if (dVar != null) {
            dVar.d(i2);
        }
        SkinManager.setNavbarIconSrc(this.f27354g, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f27353f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NavigationBar navigationBar = this.f27349b;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MessageManager.getInstance().unRegisterListener(this.f27356i);
        }
    }

    public void n(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (imageView = this.f27354g) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void o(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (navigationBar = this.f27349b) == null) {
            return;
        }
        navigationBar.setVisibility(z ? 0 : 8);
    }

    public void p(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.f27353f) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void q(ShareItem shareItem) {
        SpecialFrsWebFragment specialFrsWebFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, shareItem) == null) || (specialFrsWebFragment = this.f27350c) == null) {
            return;
        }
        specialFrsWebFragment.showShareDialog(shareItem);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f27348a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }
}
