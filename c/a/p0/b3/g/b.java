package c.a.p0.b3.g;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.o0.o0.c;
import c.a.o0.t.q;
import c.a.p0.b3.d.i;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.b3.e.a f12755b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f12756c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.b3.g.a f12757d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12758e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.s.e.a f12759f;

    /* renamed from: g  reason: collision with root package name */
    public i f12760g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f12761h;
    public CustomMessageListener i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.a.f12757d.z()) {
                    this.a.w();
                } else if (view == this.a.f12757d.r()) {
                    this.a.r();
                } else if (view != this.a.f12757d.v()) {
                    if (view == this.a.f12757d.D()) {
                        if (this.a.f12758e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.a.E();
                        }
                    } else if (view != this.a.f12757d.y() && view != this.a.f12757d.x()) {
                        if (view == this.a.f12757d.C()) {
                            this.a.z();
                        } else if (view == this.a.f12757d.s()) {
                            this.a.s();
                        } else if (view == this.a.f12757d.t()) {
                            this.a.t();
                        } else if (view == this.a.f12757d.u()) {
                            this.a.u();
                        } else if (view == this.a.f12757d.w()) {
                            this.a.v();
                        } else if (view == this.a.f12757d.B()) {
                            if (this.a.f12758e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.a.y();
                        } else if (view == this.a.f12757d.A()) {
                            this.a.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.a.f12758e) {
                            if (this.a.f12756c != null && this.a.f12756c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.a.a.getPageActivity(), this.a.f12756c.getIntro());
                            }
                            this.a.E();
                            return;
                        }
                        this.a.f12756c.getBaijiahaoInfo();
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.a.a.getPageActivity(), this.a.f12756c.getIntro());
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.a.D();
                }
            }
        }
    }

    /* renamed from: c.a.p0.b3.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0958b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0958b(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f30338c)) {
                return;
            }
            if (updateAttentionMessage.getData().a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.a.a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.a.f12756c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().j) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f1480);
                }
                this.a.f12756c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.a.a.getUniqueId())) {
                return;
            }
            this.a.f12757d.N(this.a.f12756c.isLike());
            if (updateAttentionMessage.getData() == null || m.isEmpty(updateAttentionMessage.getData().f30337b)) {
                if (this.a.f12756c.getIsLike()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f147f);
                    return;
                } else {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f02a5);
                    return;
                }
            }
            this.a.a.showToast(updateAttentionMessage.getData().f30337b);
        }
    }

    public b(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12761h = new a(this);
        this.i = new C0958b(this, 2001115);
        this.a = tbPageContext;
        this.f12758e = z;
        this.f12757d = new c.a.p0.b3.g.a(this.a, this.f12758e, this.f12761h);
        this.a.registerListener(this.i);
        TbPageContext tbPageContext2 = this.a;
        this.f12760g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f12760g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12757d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12757d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.a.getPageActivity(), this.f12756c.getUserIdLong(), this.f12756c.getUserName(), this.f12756c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
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
        UserData userData = this.f12756c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f12756c.getUserName());
            personChangeData.setSex(this.f12756c.getSex());
            personChangeData.setIntro(this.f12756c.getIntro());
            personChangeData.setNameShow(this.f12756c.getName_show());
            personChangeData.setMem(this.f12756c.getIsMem());
            personChangeData.setForumAge(this.f12756c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f12756c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f12756c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f12756c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f12756c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f12755b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f12756c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f12756c.getBirthdayInfo().f10850c);
                personChangeData.setBirthdayTime(this.f12756c.getBirthdayInfo().a);
                personChangeData.setBirthdayShowStatus(this.f12756c.getBirthdayInfo().f10851d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i) {
        c.a.p0.b3.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (aVar = this.f12757d) == null) {
            return;
        }
        aVar.H(i);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f12760g;
            if (iVar != null) {
                iVar.y();
            }
            c.a.p0.b3.g.a aVar = this.f12757d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(c.a.p0.b3.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f12757d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f12757d.L(z);
        }
    }

    public final void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            BdToast.i(this.a.getPageActivity(), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0e2a), StringHelper.getUserDescByGender(i)), R.drawable.obfuscated_res_0x7f08099f, true).q();
        }
    }

    public void K(String str) {
        c.a.p0.b3.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f12757d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(c.a.p0.b3.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f12755b = aVar;
        this.f12756c = aVar.j();
        this.f12757d.q(this.f12755b.j(), this.f12755b.g());
        this.f12760g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f12760g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
            if (this.f12759f == null) {
                c.a.o0.s.e.a aVar = new c.a.o0.s.e.a(this.a);
                this.f12759f = aVar;
                aVar.i(true);
            }
            this.f12759f.l(!this.f12756c.isLike(), this.f12756c.getPortrait(), this.f12756c.getUserId(), this.f12756c.isGod(), "2", this.a.getUniqueId(), null, "0");
            this.f12757d.N(true ^ this.f12756c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f12756c.getUserId());
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
            statisticItem.param("obj_type", this.f12758e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f12756c.getUserId()) ? 1 : 2).param("obj_source", this.f12756c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), true, this.f12756c.getUserId(), this.f12756c.getSex()).updateFollowNum(this.f12756c.getConcernNum(), this.f12756c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f12758e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                PersonRedTipManager.getInstance().updateRedTipState(2, false, this.f12758e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f12756c.getUserId()) ? 1 : 2).param("obj_source", this.f12756c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.a.getPageActivity(), false, this.f12756c.getUserId(), this.f12756c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f12758e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f12756c.getUserId());
                boolean z = this.f12756c.getIsFriend() == 1;
                if (this.f12756c.getPersonPrivate() == null) {
                    J(this.f12756c.getSex());
                } else if (this.f12756c.getPersonPrivate().y() != 1 && !equals && (!z || this.f12756c.getPersonPrivate().y() != 2)) {
                    J(this.f12756c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f12756c.getUserId()) ? 1 : 2).param("obj_source", this.f12756c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.a.getPageActivity(), this.f12756c.getLike_bars(), this.f12756c.getUserId(), this.f12756c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f12756c.getAlaUserData();
            if (!this.f12758e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            q qVar = new q();
            if (!StringUtils.isNull(this.f12756c.getPortrait()) && this.f12756c.getPortrait().startsWith("http")) {
                qVar.f(this.f12756c.getPortrait());
                qVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f12756c.getPortrait()));
                qVar.g(true);
            } else {
                qVar.f(HeadIconRefreshHelper.headPortraitFilter(this.f12756c.getPortraitH()));
                qVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f12756c.getPortrait()));
                qVar.g(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(qVar);
            this.f12760g.r(qVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f12758e) {
                if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f12756c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f12756c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f12756c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.a, new String[]{this.f12756c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        c.a.p0.b3.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f12755b) == null || aVar.g() == null || TextUtils.isEmpty(this.f12755b.g().f16074b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.a, new String[]{this.f12755b.g().f16074b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            c.a.o0.l.a.q(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f14a5), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f12756c.getUserId() + "&opacity=0", true, true, true);
        }
    }
}
