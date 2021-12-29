package c.a.t0.x2.g;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.u.q;
import c.a.t0.x2.d.i;
import c.a.t0.y2.c;
import c.a.t0.y2.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.x2.e.a f26256b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f26257c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.x2.g.a f26258d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26259e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.t.e.a f26260f;

    /* renamed from: g  reason: collision with root package name */
    public i f26261g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f26262h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f26263i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26264e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26264e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f26264e.f26258d.z()) {
                    this.f26264e.w();
                } else if (view == this.f26264e.f26258d.r()) {
                    this.f26264e.r();
                } else if (view != this.f26264e.f26258d.v()) {
                    if (view == this.f26264e.f26258d.D()) {
                        if (this.f26264e.f26259e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.f26264e.E();
                        }
                    } else if (view != this.f26264e.f26258d.y() && view != this.f26264e.f26258d.x()) {
                        if (view == this.f26264e.f26258d.C()) {
                            this.f26264e.z();
                        } else if (view == this.f26264e.f26258d.s()) {
                            this.f26264e.s();
                        } else if (view == this.f26264e.f26258d.t()) {
                            this.f26264e.t();
                        } else if (view == this.f26264e.f26258d.u()) {
                            this.f26264e.u();
                        } else if (view == this.f26264e.f26258d.w()) {
                            this.f26264e.v();
                        } else if (view == this.f26264e.f26258d.B()) {
                            if (this.f26264e.f26259e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.f26264e.y();
                        } else if (view == this.f26264e.f26258d.A()) {
                            this.f26264e.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.f26264e.f26259e) {
                            if (this.f26264e.f26257c != null && this.f26264e.f26257c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.f26264e.a.getPageActivity(), this.f26264e.f26257c.getIntro());
                            }
                            this.f26264e.E();
                            return;
                        }
                        this.f26264e.f26257c.getBaijiahaoInfo();
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f26264e.a.getPageActivity(), this.f26264e.f26257c.getIntro());
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.f26264e.D();
                }
            }
        }
    }

    /* renamed from: c.a.t0.x2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1515b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1515b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f42213c)) {
                return;
            }
            if (updateAttentionMessage.getData().a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.a.a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.a.f26257c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().f42220j) {
                    this.a.a.showToast(g.unlike_success);
                }
                this.a.f26257c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.a.a.getUniqueId())) {
                return;
            }
            this.a.f26258d.N(this.a.f26257c.isLike());
            if (updateAttentionMessage.getData() == null || m.isEmpty(updateAttentionMessage.getData().f42212b)) {
                if (this.a.f26257c.getIsLike()) {
                    this.a.a.showToast(g.unlike_failure);
                    return;
                } else {
                    this.a.a.showToast(g.attention_fail);
                    return;
                }
            }
            this.a.a.showToast(updateAttentionMessage.getData().f42212b);
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26262h = new a(this);
        this.f26263i = new C1515b(this, 2001115);
        this.a = tbPageContext;
        this.f26259e = z;
        this.f26258d = new c.a.t0.x2.g.a(this.a, this.f26259e, this.f26262h);
        this.a.registerListener(this.f26263i);
        TbPageContext tbPageContext2 = this.a;
        this.f26261g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f26261g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26258d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26258d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.a.getPageActivity(), this.f26257c.getUserIdLong(), this.f26257c.getUserName(), this.f26257c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        PersonChangeData personChangeData = new PersonChangeData();
        UserData userData = this.f26257c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f26257c.getUserName());
            personChangeData.setSex(this.f26257c.getSex());
            personChangeData.setIntro(this.f26257c.getIntro());
            personChangeData.setNameShow(this.f26257c.getName_show());
            personChangeData.setMem(this.f26257c.getIsMem());
            personChangeData.setForumAge(this.f26257c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f26257c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f26257c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f26257c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f26257c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f26256b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f26257c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f26257c.getBirthdayInfo().f13755c);
                personChangeData.setBirthdayTime(this.f26257c.getBirthdayInfo().a);
                personChangeData.setBirthdayShowStatus(this.f26257c.getBirthdayInfo().f13756d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        c.a.t0.x2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f26258d) == null) {
            return;
        }
        aVar.H(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f26261g;
            if (iVar != null) {
                iVar.y();
            }
            c.a.t0.x2.g.a aVar = this.f26258d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(c.a.t0.x2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f26258d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f26258d.L(z);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            BdToast.i(this.a.getPageActivity(), String.format(this.a.getString(g.person_privacy_toast), StringHelper.getUserDescByGender(i2)), c.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void K(String str) {
        c.a.t0.x2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f26258d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(c.a.t0.x2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f26256b = aVar;
        this.f26257c = aVar.j();
        this.f26258d.q(this.f26256b.j(), this.f26256b.g());
        this.f26261g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f26261g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            if (this.f26260f == null) {
                c.a.s0.t.e.a aVar = new c.a.s0.t.e.a(this.a);
                this.f26260f = aVar;
                aVar.i(true);
            }
            this.f26260f.l(!this.f26257c.isLike(), this.f26257c.getPortrait(), this.f26257c.getUserId(), this.f26257c.isGod(), "2", this.a.getUniqueId(), null, "0");
            this.f26258d.N(true ^ this.f26257c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f26257c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.a;
            if (tbPageContext2 != null) {
                c.a.s0.p0.c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.a.s0.p0.c.j(this.a.getPageActivity()) != null && c.a.s0.p0.c.j(this.a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.a.s0.p0.c.j(this.a.getPageActivity()).b().locatePage) && "a002".equals(c.a.s0.p0.c.j(this.a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.a.s0.p0.c.j(this.a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.f26259e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f26257c.getUserId()) ? 1 : 2).param("obj_source", this.f26257c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), true, this.f26257c.getUserId(), this.f26257c.getSex()).updateFollowNum(this.f26257c.getConcernNum(), this.f26257c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f26259e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                c.a.t0.k3.a.v().L(2, false, this.f26259e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f26257c.getUserId()) ? 1 : 2).param("obj_source", this.f26257c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), false, this.f26257c.getUserId(), this.f26257c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f26259e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f26257c.getUserId());
                boolean z = this.f26257c.getIsFriend() == 1;
                if (this.f26257c.getPersonPrivate() == null) {
                    J(this.f26257c.getSex());
                } else if (this.f26257c.getPersonPrivate().w() != 1 && !equals && (!z || this.f26257c.getPersonPrivate().w() != 2)) {
                    J(this.f26257c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f26257c.getUserId()) ? 1 : 2).param("obj_source", this.f26257c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.a.getPageActivity(), this.f26257c.getLike_bars(), this.f26257c.getUserId(), this.f26257c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f26257c.getAlaUserData();
            if (!this.f26259e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            q qVar = new q();
            if (!StringUtils.isNull(this.f26257c.getPortrait()) && this.f26257c.getPortrait().startsWith("http")) {
                qVar.g(this.f26257c.getPortrait());
                qVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f26257c.getPortrait()));
                qVar.h(true);
            } else {
                qVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f26257c.getPortraitH()));
                qVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f26257c.getPortrait()));
                qVar.h(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(qVar);
            this.f26261g.r(qVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f26259e) {
                if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f26257c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f26257c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f26257c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.a, new String[]{this.f26257c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        c.a.t0.x2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f26256b) == null || aVar.g() == null || TextUtils.isEmpty(this.f26256b.g().f18679b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.a, new String[]{this.f26256b.g().f18679b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            c.a.s0.m.a.q(this.a.getPageActivity(), this.a.getString(g.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f26257c.getUserId(), true, true, true);
        }
    }
}
