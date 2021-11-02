package b.a.r0.p2.g;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.q0.n0.c;
import b.a.q0.u.o;
import b.a.r0.p2.d.i;
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
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22352a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.p2.e.a f22353b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f22354c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.p2.g.a f22355d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22356e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.t.e.a f22357f;

    /* renamed from: g  reason: collision with root package name */
    public i f22358g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f22359h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f22360i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22361e;

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
            this.f22361e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f22361e.f22355d.z()) {
                    this.f22361e.w();
                } else if (view == this.f22361e.f22355d.r()) {
                    this.f22361e.r();
                } else if (view != this.f22361e.f22355d.v()) {
                    if (view == this.f22361e.f22355d.D()) {
                        if (this.f22361e.f22356e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.f22361e.E();
                        }
                    } else if (view != this.f22361e.f22355d.y() && view != this.f22361e.f22355d.x()) {
                        if (view == this.f22361e.f22355d.C()) {
                            this.f22361e.z();
                        } else if (view == this.f22361e.f22355d.s()) {
                            this.f22361e.s();
                        } else if (view == this.f22361e.f22355d.t()) {
                            this.f22361e.t();
                        } else if (view == this.f22361e.f22355d.u()) {
                            this.f22361e.u();
                        } else if (view == this.f22361e.f22355d.w()) {
                            this.f22361e.v();
                        } else if (view == this.f22361e.f22355d.B()) {
                            if (this.f22361e.f22356e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.f22361e.y();
                        } else if (view == this.f22361e.f22355d.A()) {
                            this.f22361e.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.f22361e.f22356e) {
                            if (this.f22361e.f22354c != null && this.f22361e.f22354c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.f22361e.f22352a.getPageActivity(), this.f22361e.f22354c.getIntro());
                            }
                            this.f22361e.E();
                            return;
                        }
                        this.f22361e.f22354c.getBaijiahaoInfo();
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f22361e.f22352a.getPageActivity(), this.f22361e.f22354c.getIntro());
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.f22361e.D();
                }
            }
        }
    }

    /* renamed from: b.a.r0.p2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1088b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22362a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1088b(b bVar, int i2) {
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
            this.f22362a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f45669c)) {
                return;
            }
            if (updateAttentionMessage.getData().f45667a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.f22362a.f22352a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.f22362a.f22354c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().j) {
                    this.f22362a.f22352a.showToast(R.string.unlike_success);
                }
                this.f22362a.f22354c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.f22362a.f22352a.getUniqueId())) {
                return;
            }
            this.f22362a.f22355d.N(this.f22362a.f22354c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f45668b)) {
                if (this.f22362a.f22354c.getIsLike()) {
                    this.f22362a.f22352a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    this.f22362a.f22352a.showToast(R.string.attention_fail);
                    return;
                }
            }
            this.f22362a.f22352a.showToast(updateAttentionMessage.getData().f45668b);
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
        this.f22359h = new a(this);
        this.f22360i = new C1088b(this, 2001115);
        this.f22352a = tbPageContext;
        this.f22356e = z;
        this.f22355d = new b.a.r0.p2.g.a(this.f22352a, this.f22356e, this.f22359h);
        this.f22352a.registerListener(this.f22360i);
        TbPageContext tbPageContext2 = this.f22352a;
        this.f22358g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f22358g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22355d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22355d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.f22352a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f22352a.getPageActivity(), this.f22354c.getUserIdLong(), this.f22354c.getUserName(), this.f22354c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
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
        UserData userData = this.f22354c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f22354c.getUserName());
            personChangeData.setSex(this.f22354c.getSex());
            personChangeData.setIntro(this.f22354c.getIntro());
            personChangeData.setNameShow(this.f22354c.getName_show());
            personChangeData.setMem(this.f22354c.getIsMem());
            personChangeData.setForumAge(this.f22354c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f22354c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f22354c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f22354c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f22354c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f22353b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f22354c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f22354c.getBirthdayInfo().f13378c);
                personChangeData.setBirthdayTime(this.f22354c.getBirthdayInfo().f13376a);
                personChangeData.setBirthdayShowStatus(this.f22354c.getBirthdayInfo().f13379d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f22352a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        b.a.r0.p2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f22355d) == null) {
            return;
        }
        aVar.H(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f22358g;
            if (iVar != null) {
                iVar.y();
            }
            b.a.r0.p2.g.a aVar = this.f22355d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(b.a.r0.p2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f22355d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f22355d.L(z);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            BdToast.i(this.f22352a.getPageActivity(), String.format(this.f22352a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void K(String str) {
        b.a.r0.p2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f22355d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(b.a.r0.p2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f22353b = aVar;
        this.f22354c = aVar.j();
        this.f22355d.q(this.f22353b.j(), this.f22353b.g());
        this.f22358g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f22358g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.f22352a.getPageActivity())) {
            if (this.f22357f == null) {
                b.a.q0.t.e.a aVar = new b.a.q0.t.e.a(this.f22352a);
                this.f22357f = aVar;
                aVar.i(true);
            }
            this.f22357f.l(!this.f22354c.isLike(), this.f22354c.getPortrait(), this.f22354c.getUserId(), this.f22354c.isGod(), "2", this.f22352a.getUniqueId(), null, "0");
            this.f22355d.N(true ^ this.f22354c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f22354c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f22352a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f22352a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f22352a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f22352a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f22352a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f22352a.getPageActivity()) != null && c.j(this.f22352a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f22352a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f22352a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f22352a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.f22356e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.f22352a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f22354c.getUserId()) ? 1 : 2).param("obj_source", this.f22354c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f22352a.getPageActivity(), true, this.f22354c.getUserId(), this.f22354c.getSex()).updateFollowNum(this.f22354c.getConcernNum(), this.f22354c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f22356e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.f22352a.getPageActivity())) {
                b.a.r0.a3.a.v().L(2, false, this.f22356e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f22354c.getUserId()) ? 1 : 2).param("obj_source", this.f22354c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f22352a.getPageActivity(), false, this.f22354c.getUserId(), this.f22354c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f22356e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.f22352a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f22354c.getUserId());
                boolean z = this.f22354c.getIsFriend() == 1;
                if (this.f22354c.getPersonPrivate() == null) {
                    J(this.f22354c.getSex());
                } else if (this.f22354c.getPersonPrivate().w() != 1 && !equals && (!z || this.f22354c.getPersonPrivate().w() != 2)) {
                    J(this.f22354c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f22354c.getUserId()) ? 1 : 2).param("obj_source", this.f22354c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f22352a.getPageActivity(), this.f22354c.getLike_bars(), this.f22354c.getUserId(), this.f22354c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f22354c.getAlaUserData();
            if (!this.f22356e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f22352a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            o oVar = new o();
            if (!StringUtils.isNull(this.f22354c.getPortrait()) && this.f22354c.getPortrait().startsWith("http")) {
                oVar.g(this.f22354c.getPortrait());
                oVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f22354c.getPortrait()));
                oVar.h(true);
            } else {
                oVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f22354c.getPortraitH()));
                oVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f22354c.getPortrait()));
                oVar.h(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(oVar);
            this.f22358g.r(oVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f22356e) {
                if (ViewHelper.checkUpIsLogin(this.f22352a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f22352a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f22354c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.f22352a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f22354c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f22354c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f22352a, new String[]{this.f22354c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        b.a.r0.p2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f22353b) == null || aVar.g() == null || TextUtils.isEmpty(this.f22353b.g().f15622b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f22352a, new String[]{this.f22353b.g().f15622b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            b.a.q0.m.a.p(this.f22352a.getPageActivity(), this.f22352a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f22354c.getUserId(), true, true, true);
        }
    }
}
