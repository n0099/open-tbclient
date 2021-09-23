package c.a.r0.o2.g;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.n0.c;
import c.a.q0.u.m;
import c.a.r0.o2.d.i;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23280a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.o2.e.a f23281b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f23282c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.o2.g.a f23283d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23284e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.t.e.a f23285f;

    /* renamed from: g  reason: collision with root package name */
    public i f23286g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f23287h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f23288i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23289e;

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
            this.f23289e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f23289e.f23283d.z()) {
                    this.f23289e.w();
                } else if (view == this.f23289e.f23283d.r()) {
                    this.f23289e.r();
                } else if (view != this.f23289e.f23283d.v()) {
                    if (view == this.f23289e.f23283d.D()) {
                        if (this.f23289e.f23284e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.f23289e.E();
                        }
                    } else if (view != this.f23289e.f23283d.y() && view != this.f23289e.f23283d.x()) {
                        if (view == this.f23289e.f23283d.C()) {
                            this.f23289e.z();
                        } else if (view == this.f23289e.f23283d.s()) {
                            this.f23289e.s();
                        } else if (view == this.f23289e.f23283d.t()) {
                            this.f23289e.t();
                        } else if (view == this.f23289e.f23283d.u()) {
                            this.f23289e.u();
                        } else if (view == this.f23289e.f23283d.w()) {
                            this.f23289e.v();
                        } else if (view == this.f23289e.f23283d.B()) {
                            if (this.f23289e.f23284e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.f23289e.y();
                        } else if (view == this.f23289e.f23283d.A()) {
                            this.f23289e.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.f23289e.f23284e) {
                            if (this.f23289e.f23282c != null && this.f23289e.f23282c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.f23289e.f23280a.getPageActivity(), this.f23289e.f23282c.getIntro());
                            }
                            this.f23289e.E();
                            return;
                        }
                        this.f23289e.f23282c.getBaijiahaoInfo();
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f23289e.f23280a.getPageActivity(), this.f23289e.f23282c.getIntro());
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.f23289e.D();
                }
            }
        }
    }

    /* renamed from: c.a.r0.o2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1079b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23290a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1079b(b bVar, int i2) {
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
            this.f23290a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f48192c)) {
                return;
            }
            if (updateAttentionMessage.getData().f48190a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.f23290a.f23280a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.f23290a.f23282c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().f48199j) {
                    this.f23290a.f23280a.showToast(R.string.unlike_success);
                }
                this.f23290a.f23282c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.f23290a.f23280a.getUniqueId())) {
                return;
            }
            this.f23290a.f23283d.N(this.f23290a.f23282c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f48191b)) {
                if (this.f23290a.f23282c.getIsLike()) {
                    this.f23290a.f23280a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    this.f23290a.f23280a.showToast(R.string.attention_fail);
                    return;
                }
            }
            this.f23290a.f23280a.showToast(updateAttentionMessage.getData().f48191b);
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
        this.f23287h = new a(this);
        this.f23288i = new C1079b(this, 2001115);
        this.f23280a = tbPageContext;
        this.f23284e = z;
        this.f23283d = new c.a.r0.o2.g.a(this.f23280a, this.f23284e, this.f23287h);
        this.f23280a.registerListener(this.f23288i);
        TbPageContext tbPageContext2 = this.f23280a;
        this.f23286g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f23286g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23283d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23283d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.f23280a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f23280a.getPageActivity(), this.f23282c.getUserIdLong(), this.f23282c.getUserName(), this.f23282c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
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
        UserData userData = this.f23282c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f23282c.getUserName());
            personChangeData.setSex(this.f23282c.getSex());
            personChangeData.setIntro(this.f23282c.getIntro());
            personChangeData.setNameShow(this.f23282c.getName_show());
            personChangeData.setMem(this.f23282c.getIsMem());
            personChangeData.setForumAge(this.f23282c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f23282c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f23282c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f23282c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f23282c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f23281b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f23282c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f23282c.getBirthdayInfo().f14242c);
                personChangeData.setBirthdayTime(this.f23282c.getBirthdayInfo().f14240a);
                personChangeData.setBirthdayShowStatus(this.f23282c.getBirthdayInfo().f14243d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f23280a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        c.a.r0.o2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f23283d) == null) {
            return;
        }
        aVar.H(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f23286g;
            if (iVar != null) {
                iVar.y();
            }
            c.a.r0.o2.g.a aVar = this.f23283d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(c.a.r0.o2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f23283d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f23283d.L(z);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            BdToast.i(this.f23280a.getPageActivity(), String.format(this.f23280a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void K(String str) {
        c.a.r0.o2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f23283d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(c.a.r0.o2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f23281b = aVar;
        this.f23282c = aVar.j();
        this.f23283d.q(this.f23281b.j(), this.f23281b.g());
        this.f23286g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f23286g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.f23280a.getPageActivity())) {
            if (this.f23285f == null) {
                c.a.q0.t.e.a aVar = new c.a.q0.t.e.a(this.f23280a);
                this.f23285f = aVar;
                aVar.j(true);
            }
            this.f23285f.m(!this.f23282c.isLike(), this.f23282c.getPortrait(), this.f23282c.getUserId(), this.f23282c.isGod(), "2", this.f23280a.getUniqueId(), null, "0");
            this.f23283d.N(true ^ this.f23282c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f23282c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f23280a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f23280a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f23280a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f23280a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f23280a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f23280a.getPageActivity()) != null && c.j(this.f23280a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f23280a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f23280a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f23280a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.f23284e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.f23280a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f23282c.getUserId()) ? 1 : 2).param("obj_source", this.f23282c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f23280a.getPageActivity(), true, this.f23282c.getUserId(), this.f23282c.getSex()).updateFollowNum(this.f23282c.getConcernNum(), this.f23282c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f23284e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.f23280a.getPageActivity())) {
                c.a.r0.z2.a.v().L(2, false, this.f23284e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f23282c.getUserId()) ? 1 : 2).param("obj_source", this.f23282c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f23280a.getPageActivity(), false, this.f23282c.getUserId(), this.f23282c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f23284e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.f23280a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f23282c.getUserId());
                boolean z = this.f23282c.getIsFriend() == 1;
                if (this.f23282c.getPersonPrivate() == null) {
                    J(this.f23282c.getSex());
                } else if (this.f23282c.getPersonPrivate().w() != 1 && !equals && (!z || this.f23282c.getPersonPrivate().w() != 2)) {
                    J(this.f23282c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f23282c.getUserId()) ? 1 : 2).param("obj_source", this.f23282c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f23280a.getPageActivity(), this.f23282c.getLike_bars(), this.f23282c.getUserId(), this.f23282c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f23282c.getAlaUserData();
            if (!this.f23284e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f23280a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            m mVar = new m();
            if (!StringUtils.isNull(this.f23282c.getPortrait()) && this.f23282c.getPortrait().startsWith("http")) {
                mVar.g(this.f23282c.getPortrait());
                mVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f23282c.getPortrait()));
                mVar.h(true);
            } else {
                mVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f23282c.getPortraitH()));
                mVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f23282c.getPortrait()));
                mVar.h(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(mVar);
            this.f23286g.r(mVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f23284e) {
                if (ViewHelper.checkUpIsLogin(this.f23280a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f23280a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f23282c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.f23280a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f23282c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f23282c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f23280a, new String[]{this.f23282c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        c.a.r0.o2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f23281b) == null || aVar.g() == null || TextUtils.isEmpty(this.f23281b.g().f16445b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f23280a, new String[]{this.f23281b.g().f16445b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            c.a.q0.m.a.o(this.f23280a.getPageActivity(), this.f23280a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f23282c.getUserId(), true, true, true);
        }
    }
}
