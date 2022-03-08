package c.a.r0.z2.g;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.q0.o0.c;
import c.a.q0.t.q;
import c.a.r0.z2.d.i;
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
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.header.PersonIntroductionActivity;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.z2.e.a f25705b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f25706c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.z2.g.a f25707d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25708e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.s.e.a f25709f;

    /* renamed from: g  reason: collision with root package name */
    public i f25710g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f25711h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f25712i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25713e;

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
            this.f25713e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f25713e.f25707d.z()) {
                    this.f25713e.w();
                } else if (view == this.f25713e.f25707d.r()) {
                    this.f25713e.r();
                } else if (view != this.f25713e.f25707d.v()) {
                    if (view == this.f25713e.f25707d.D()) {
                        if (this.f25713e.f25708e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.f25713e.E();
                        }
                    } else if (view != this.f25713e.f25707d.y() && view != this.f25713e.f25707d.x()) {
                        if (view == this.f25713e.f25707d.C()) {
                            this.f25713e.z();
                        } else if (view == this.f25713e.f25707d.s()) {
                            this.f25713e.s();
                        } else if (view == this.f25713e.f25707d.t()) {
                            this.f25713e.t();
                        } else if (view == this.f25713e.f25707d.u()) {
                            this.f25713e.u();
                        } else if (view == this.f25713e.f25707d.w()) {
                            this.f25713e.v();
                        } else if (view == this.f25713e.f25707d.B()) {
                            if (this.f25713e.f25708e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.f25713e.y();
                        } else if (view == this.f25713e.f25707d.A()) {
                            this.f25713e.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.f25713e.f25708e) {
                            if (this.f25713e.f25706c != null && this.f25713e.f25706c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.f25713e.a.getPageActivity(), this.f25713e.f25706c.getIntro());
                            }
                            this.f25713e.E();
                            return;
                        }
                        this.f25713e.f25706c.getBaijiahaoInfo();
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f25713e.a.getPageActivity(), this.f25713e.f25706c.getIntro());
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.f25713e.D();
                }
            }
        }
    }

    /* renamed from: c.a.r0.z2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1566b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1566b(b bVar, int i2) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f39406c)) {
                return;
            }
            if (updateAttentionMessage.getData().a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.a.a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.a.f25706c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().f39413j) {
                    this.a.a.showToast(R.string.unlike_success);
                }
                this.a.f25706c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.a.a.getUniqueId())) {
                return;
            }
            this.a.f25707d.N(this.a.f25706c.isLike());
            if (updateAttentionMessage.getData() == null || m.isEmpty(updateAttentionMessage.getData().f39405b)) {
                if (this.a.f25706c.getIsLike()) {
                    this.a.a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    this.a.a.showToast(R.string.attention_fail);
                    return;
                }
            }
            this.a.a.showToast(updateAttentionMessage.getData().f39405b);
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
        this.f25711h = new a(this);
        this.f25712i = new C1566b(this, 2001115);
        this.a = tbPageContext;
        this.f25708e = z;
        this.f25707d = new c.a.r0.z2.g.a(this.a, this.f25708e, this.f25711h);
        this.a.registerListener(this.f25712i);
        TbPageContext tbPageContext2 = this.a;
        this.f25710g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f25710g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25707d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25707d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.a.getPageActivity(), this.f25706c.getUserIdLong(), this.f25706c.getUserName(), this.f25706c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
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
        UserData userData = this.f25706c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f25706c.getUserName());
            personChangeData.setSex(this.f25706c.getSex());
            personChangeData.setIntro(this.f25706c.getIntro());
            personChangeData.setNameShow(this.f25706c.getName_show());
            personChangeData.setMem(this.f25706c.getIsMem());
            personChangeData.setForumAge(this.f25706c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f25706c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f25706c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f25706c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f25706c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f25705b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f25706c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f25706c.getBirthdayInfo().f13325c);
                personChangeData.setBirthdayTime(this.f25706c.getBirthdayInfo().a);
                personChangeData.setBirthdayShowStatus(this.f25706c.getBirthdayInfo().f13326d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        c.a.r0.z2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f25707d) == null) {
            return;
        }
        aVar.H(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f25710g;
            if (iVar != null) {
                iVar.y();
            }
            c.a.r0.z2.g.a aVar = this.f25707d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(c.a.r0.z2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f25707d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f25707d.L(z);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            BdToast.i(this.a.getPageActivity(), String.format(this.a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void K(String str) {
        c.a.r0.z2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f25707d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(c.a.r0.z2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f25705b = aVar;
        this.f25706c = aVar.j();
        this.f25707d.q(this.f25705b.j(), this.f25705b.g());
        this.f25710g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f25710g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            if (this.f25709f == null) {
                c.a.q0.s.e.a aVar = new c.a.q0.s.e.a(this.a);
                this.f25709f = aVar;
                aVar.i(true);
            }
            this.f25709f.l(!this.f25706c.isLike(), this.f25706c.getPortrait(), this.f25706c.getUserId(), this.f25706c.isGod(), "2", this.a.getUniqueId(), null, "0");
            this.f25707d.N(true ^ this.f25706c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f25706c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.a.getPageActivity()) != null && c.j(this.a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.f25708e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f25706c.getUserId()) ? 1 : 2).param("obj_source", this.f25706c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), true, this.f25706c.getUserId(), this.f25706c.getSex()).updateFollowNum(this.f25706c.getConcernNum(), this.f25706c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f25708e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                PersonRedTipManager.getInstance().updateRedTipState(2, false, this.f25708e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f25706c.getUserId()) ? 1 : 2).param("obj_source", this.f25706c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), false, this.f25706c.getUserId(), this.f25706c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f25708e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f25706c.getUserId());
                boolean z = this.f25706c.getIsFriend() == 1;
                if (this.f25706c.getPersonPrivate() == null) {
                    J(this.f25706c.getSex());
                } else if (this.f25706c.getPersonPrivate().w() != 1 && !equals && (!z || this.f25706c.getPersonPrivate().w() != 2)) {
                    J(this.f25706c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f25706c.getUserId()) ? 1 : 2).param("obj_source", this.f25706c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.a.getPageActivity(), this.f25706c.getLike_bars(), this.f25706c.getUserId(), this.f25706c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f25706c.getAlaUserData();
            if (!this.f25708e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            q qVar = new q();
            if (!StringUtils.isNull(this.f25706c.getPortrait()) && this.f25706c.getPortrait().startsWith("http")) {
                qVar.g(this.f25706c.getPortrait());
                qVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f25706c.getPortrait()));
                qVar.h(true);
            } else {
                qVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f25706c.getPortraitH()));
                qVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f25706c.getPortrait()));
                qVar.h(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(qVar);
            this.f25710g.r(qVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f25708e) {
                if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f25706c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f25706c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f25706c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.a, new String[]{this.f25706c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        c.a.r0.z2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f25705b) == null || aVar.g() == null || TextUtils.isEmpty(this.f25705b.g().f18283b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.a, new String[]{this.f25705b.g().f18283b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            c.a.q0.l.a.q(this.a.getPageActivity(), this.a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f25706c.getUserId() + "&opacity=0", true, true, true);
        }
    }
}
