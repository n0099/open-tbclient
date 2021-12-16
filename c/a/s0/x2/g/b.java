package c.a.s0.x2.g;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.r0.u.n;
import c.a.s0.x2.d.i;
import c.a.s0.y2.c;
import c.a.s0.y2.g;
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
    public c.a.s0.x2.e.a f25768b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f25769c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.x2.g.a f25770d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25771e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.t.e.a f25772f;

    /* renamed from: g  reason: collision with root package name */
    public i f25773g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f25774h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f25775i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25776e;

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
            this.f25776e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f25776e.f25770d.z()) {
                    this.f25776e.w();
                } else if (view == this.f25776e.f25770d.r()) {
                    this.f25776e.r();
                } else if (view != this.f25776e.f25770d.v()) {
                    if (view == this.f25776e.f25770d.D()) {
                        if (this.f25776e.f25771e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.f25776e.E();
                        }
                    } else if (view != this.f25776e.f25770d.y() && view != this.f25776e.f25770d.x()) {
                        if (view == this.f25776e.f25770d.C()) {
                            this.f25776e.z();
                        } else if (view == this.f25776e.f25770d.s()) {
                            this.f25776e.s();
                        } else if (view == this.f25776e.f25770d.t()) {
                            this.f25776e.t();
                        } else if (view == this.f25776e.f25770d.u()) {
                            this.f25776e.u();
                        } else if (view == this.f25776e.f25770d.w()) {
                            this.f25776e.v();
                        } else if (view == this.f25776e.f25770d.B()) {
                            if (this.f25776e.f25771e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.f25776e.y();
                        } else if (view == this.f25776e.f25770d.A()) {
                            this.f25776e.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.f25776e.f25771e) {
                            if (this.f25776e.f25769c != null && this.f25776e.f25769c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.f25776e.a.getPageActivity(), this.f25776e.f25769c.getIntro());
                            }
                            this.f25776e.E();
                            return;
                        }
                        this.f25776e.f25769c.getBaijiahaoInfo();
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f25776e.a.getPageActivity(), this.f25776e.f25769c.getIntro());
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.f25776e.D();
                }
            }
        }
    }

    /* renamed from: c.a.s0.x2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1492b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1492b(b bVar, int i2) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f42047c)) {
                return;
            }
            if (updateAttentionMessage.getData().a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.a.a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.a.f25769c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().f42054j) {
                    this.a.a.showToast(g.unlike_success);
                }
                this.a.f25769c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.a.a.getUniqueId())) {
                return;
            }
            this.a.f25770d.N(this.a.f25769c.isLike());
            if (updateAttentionMessage.getData() == null || l.isEmpty(updateAttentionMessage.getData().f42046b)) {
                if (this.a.f25769c.getIsLike()) {
                    this.a.a.showToast(g.unlike_failure);
                    return;
                } else {
                    this.a.a.showToast(g.attention_fail);
                    return;
                }
            }
            this.a.a.showToast(updateAttentionMessage.getData().f42046b);
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
        this.f25774h = new a(this);
        this.f25775i = new C1492b(this, 2001115);
        this.a = tbPageContext;
        this.f25771e = z;
        this.f25770d = new c.a.s0.x2.g.a(this.a, this.f25771e, this.f25774h);
        this.a.registerListener(this.f25775i);
        TbPageContext tbPageContext2 = this.a;
        this.f25773g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f25773g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25770d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25770d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.a.getPageActivity(), this.f25769c.getUserIdLong(), this.f25769c.getUserName(), this.f25769c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
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
        UserData userData = this.f25769c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f25769c.getUserName());
            personChangeData.setSex(this.f25769c.getSex());
            personChangeData.setIntro(this.f25769c.getIntro());
            personChangeData.setNameShow(this.f25769c.getName_show());
            personChangeData.setMem(this.f25769c.getIsMem());
            personChangeData.setForumAge(this.f25769c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f25769c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f25769c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f25769c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f25769c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f25768b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f25769c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f25769c.getBirthdayInfo().f13379c);
                personChangeData.setBirthdayTime(this.f25769c.getBirthdayInfo().a);
                personChangeData.setBirthdayShowStatus(this.f25769c.getBirthdayInfo().f13380d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        c.a.s0.x2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f25770d) == null) {
            return;
        }
        aVar.H(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f25773g;
            if (iVar != null) {
                iVar.y();
            }
            c.a.s0.x2.g.a aVar = this.f25770d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(c.a.s0.x2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f25770d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f25770d.L(z);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            BdToast.i(this.a.getPageActivity(), String.format(this.a.getString(g.person_privacy_toast), StringHelper.getUserDescByGender(i2)), c.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void K(String str) {
        c.a.s0.x2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f25770d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(c.a.s0.x2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f25768b = aVar;
        this.f25769c = aVar.j();
        this.f25770d.q(this.f25768b.j(), this.f25768b.g());
        this.f25773g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f25773g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            if (this.f25772f == null) {
                c.a.r0.t.e.a aVar = new c.a.r0.t.e.a(this.a);
                this.f25772f = aVar;
                aVar.i(true);
            }
            this.f25772f.l(!this.f25769c.isLike(), this.f25769c.getPortrait(), this.f25769c.getUserId(), this.f25769c.isGod(), "2", this.a.getUniqueId(), null, "0");
            this.f25770d.N(true ^ this.f25769c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f25769c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.a;
            if (tbPageContext2 != null) {
                c.a.r0.o0.c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.a.r0.o0.c.j(this.a.getPageActivity()) != null && c.a.r0.o0.c.j(this.a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.a.r0.o0.c.j(this.a.getPageActivity()).b().locatePage) && "a002".equals(c.a.r0.o0.c.j(this.a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.a.r0.o0.c.j(this.a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.f25771e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f25769c.getUserId()) ? 1 : 2).param("obj_source", this.f25769c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), true, this.f25769c.getUserId(), this.f25769c.getSex()).updateFollowNum(this.f25769c.getConcernNum(), this.f25769c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f25771e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                c.a.s0.k3.a.v().L(2, false, this.f25771e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f25769c.getUserId()) ? 1 : 2).param("obj_source", this.f25769c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), false, this.f25769c.getUserId(), this.f25769c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f25771e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f25769c.getUserId());
                boolean z = this.f25769c.getIsFriend() == 1;
                if (this.f25769c.getPersonPrivate() == null) {
                    J(this.f25769c.getSex());
                } else if (this.f25769c.getPersonPrivate().w() != 1 && !equals && (!z || this.f25769c.getPersonPrivate().w() != 2)) {
                    J(this.f25769c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f25769c.getUserId()) ? 1 : 2).param("obj_source", this.f25769c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.a.getPageActivity(), this.f25769c.getLike_bars(), this.f25769c.getUserId(), this.f25769c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f25769c.getAlaUserData();
            if (!this.f25771e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            n nVar = new n();
            if (!StringUtils.isNull(this.f25769c.getPortrait()) && this.f25769c.getPortrait().startsWith("http")) {
                nVar.g(this.f25769c.getPortrait());
                nVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f25769c.getPortrait()));
                nVar.h(true);
            } else {
                nVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f25769c.getPortraitH()));
                nVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f25769c.getPortrait()));
                nVar.h(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(nVar);
            this.f25773g.r(nVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f25771e) {
                if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f25769c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f25769c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f25769c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.a, new String[]{this.f25769c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        c.a.s0.x2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f25768b) == null || aVar.g() == null || TextUtils.isEmpty(this.f25768b.g().f18205b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.a, new String[]{this.f25768b.g().f18205b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            c.a.r0.m.a.q(this.a.getPageActivity(), this.a.getString(g.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f25769c.getUserId(), true, true, true);
        }
    }
}
