package c.a.p0.n2.g;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.o0.l0.c;
import c.a.o0.u.m;
import c.a.p0.n2.d.i;
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
import tbclient.BaijiahaoInfo;
import tbclient.Profile.NicknameInfo;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22353a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.n2.e.a f22354b;

    /* renamed from: c  reason: collision with root package name */
    public UserData f22355c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.n2.g.a f22356d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22357e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.t.e.a f22358f;

    /* renamed from: g  reason: collision with root package name */
    public i f22359g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f22360h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f22361i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22362e;

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
            this.f22362e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f22362e.f22356d.z()) {
                    this.f22362e.w();
                } else if (view == this.f22362e.f22356d.r()) {
                    this.f22362e.r();
                } else if (view != this.f22362e.f22356d.v()) {
                    if (view == this.f22362e.f22356d.D()) {
                        if (this.f22362e.f22357e) {
                            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "7"));
                            this.f22362e.E();
                        }
                    } else if (view != this.f22362e.f22356d.y() && view != this.f22362e.f22356d.x()) {
                        if (view == this.f22362e.f22356d.C()) {
                            this.f22362e.z();
                        } else if (view == this.f22362e.f22356d.s()) {
                            this.f22362e.s();
                        } else if (view == this.f22362e.f22356d.t()) {
                            this.f22362e.t();
                        } else if (view == this.f22362e.f22356d.u()) {
                            this.f22362e.u();
                        } else if (view == this.f22362e.f22356d.w()) {
                            this.f22362e.v();
                        } else if (view == this.f22362e.f22356d.B()) {
                            if (this.f22362e.f22357e) {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "0"));
                            } else {
                                TiebaStatic.log(new StatisticItem("c13613").param("obj_param1", "1"));
                            }
                            this.f22362e.y();
                        } else if (view == this.f22362e.f22356d.A()) {
                            this.f22362e.x();
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "14"));
                        if (this.f22362e.f22357e) {
                            if (this.f22362e.f22355c != null && this.f22362e.f22355c.isBaijiahaoUser()) {
                                PersonIntroductionActivity.startPersonIntroductionActivity(this.f22362e.f22353a.getPageActivity(), this.f22362e.f22355c.getIntro());
                            }
                            this.f22362e.E();
                            return;
                        }
                        BaijiahaoInfo baijiahaoInfo = this.f22362e.f22355c.getBaijiahaoInfo();
                        if (baijiahaoInfo == null || k.isEmpty(baijiahaoInfo.auth_desc)) {
                            intro = this.f22362e.f22355c.getIntro();
                        } else {
                            intro = baijiahaoInfo.auth_desc;
                        }
                        PersonIntroductionActivity.startPersonIntroductionActivity(this.f22362e.f22353a.getPageActivity(), intro);
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "3"));
                    TiebaStatic.log("igift_icon_ck");
                    this.f22362e.D();
                }
            }
        }
    }

    /* renamed from: c.a.p0.n2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1037b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22363a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1037b(b bVar, int i2) {
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
            this.f22363a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f47849c)) {
                return;
            }
            if (updateAttentionMessage.getData().f47847a) {
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                if (message == null || message.getTag() == null || !message.getTag().equals(this.f22363a.f22353a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.isAttention()) {
                    this.f22363a.f22355c.setLike(true);
                    return;
                }
                if (!updateAttentionMessage.getData().f47856j) {
                    this.f22363a.f22353a.showToast(R.string.unlike_success);
                }
                this.f22363a.f22355c.setLike(false);
                return;
            }
            Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
            if (message2 == null || message2.getTag() == null || !message2.getTag().equals(this.f22363a.f22353a.getUniqueId())) {
                return;
            }
            this.f22363a.f22356d.N(this.f22363a.f22355c.isLike());
            if (updateAttentionMessage.getData() == null || k.isEmpty(updateAttentionMessage.getData().f47848b)) {
                if (this.f22363a.f22355c.getIsLike()) {
                    this.f22363a.f22353a.showToast(R.string.unlike_failure);
                    return;
                } else {
                    this.f22363a.f22353a.showToast(R.string.attention_fail);
                    return;
                }
            }
            this.f22363a.f22353a.showToast(updateAttentionMessage.getData().f47848b);
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
        this.f22360h = new a(this);
        this.f22361i = new C1037b(this, 2001115);
        this.f22353a = tbPageContext;
        this.f22357e = z;
        this.f22356d = new c.a.p0.n2.g.a(this.f22353a, this.f22357e, this.f22360h);
        this.f22353a.registerListener(this.f22361i);
        TbPageContext tbPageContext2 = this.f22353a;
        this.f22359g = new i(tbPageContext2, tbPageContext2.getUniqueId(), z);
    }

    public void A(Intent intent) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || (iVar = this.f22359g) == null) {
            return;
        }
        iVar.p(intent);
    }

    public FollowUserSpinnerBtn B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22356d.r() : (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22356d.E() : (View) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && ViewHelper.checkUpIsLogin(this.f22353a.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f22353a.getPageActivity(), this.f22355c.getUserIdLong(), this.f22355c.getUserName(), this.f22355c.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
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
        UserData userData = this.f22355c;
        if (userData != null) {
            personChangeData.setPortrait(userData.getPortrait());
            personChangeData.setName(this.f22355c.getUserName());
            personChangeData.setSex(this.f22355c.getSex());
            personChangeData.setIntro(this.f22355c.getIntro());
            personChangeData.setNameShow(this.f22355c.getName_show());
            personChangeData.setMem(this.f22355c.getIsMem());
            personChangeData.setForumAge(this.f22355c.getTb_age());
            personChangeData.setCanModifyAvatar(this.f22355c.canModifyAvatar());
            personChangeData.setCantModifyAvatarDesc(this.f22355c.getCantModifyAvatarDesc());
            personChangeData.setTiebaId(this.f22355c.getmTiebaUid());
            AlaUserInfoData alaUserInfoData = this.f22355c.alaUserData;
            if (alaUserInfoData != null) {
                personChangeData.setAlaId(alaUserInfoData.ala_id);
            }
            NicknameInfo nicknameInfo = this.f22354b.A;
            if (nicknameInfo != null) {
                personChangeData.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (this.f22355c.getBirthdayInfo() != null) {
                personChangeData.setUserAge(this.f22355c.getBirthdayInfo().f13960c);
                personChangeData.setBirthdayTime(this.f22355c.getBirthdayInfo().f13958a);
                personChangeData.setBirthdayShowStatus(this.f22355c.getBirthdayInfo().f13961d);
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f22353a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
    }

    public void F(int i2) {
        c.a.p0.n2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f22356d) == null) {
            return;
        }
        aVar.H(i2);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i iVar = this.f22359g;
            if (iVar != null) {
                iVar.y();
            }
            c.a.p0.n2.g.a aVar = this.f22356d;
            if (aVar != null) {
                aVar.I();
            }
        }
    }

    public void H(c.a.p0.n2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f22356d.K(aVar);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f22356d.L(z);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            BdToast.i(this.f22353a.getPageActivity(), String.format(this.f22353a.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public void K(String str) {
        c.a.p0.n2.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (aVar = this.f22356d) == null) {
            return;
        }
        aVar.O(str);
    }

    public void p(c.a.p0.n2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.j() == null) {
            return;
        }
        this.f22354b = aVar;
        this.f22355c = aVar.j();
        this.f22356d.q(this.f22354b.j(), this.f22354b.g());
        this.f22359g.A(aVar);
    }

    public void q() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iVar = this.f22359g) == null) {
            return;
        }
        iVar.o();
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && ViewHelper.checkUpIsLogin(this.f22353a.getPageActivity())) {
            if (this.f22358f == null) {
                c.a.o0.t.e.a aVar = new c.a.o0.t.e.a(this.f22353a);
                this.f22358f = aVar;
                aVar.j(true);
            }
            this.f22358f.m(!this.f22355c.isLike(), this.f22355c.getPortrait(), this.f22355c.getUserId(), this.f22355c.isGod(), "2", this.f22353a.getUniqueId(), null, "0");
            this.f22356d.N(true ^ this.f22355c.isLike());
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem.param("obj_id", this.f22355c.getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TbPageContext tbPageContext = this.f22353a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f22353a.getPageActivity().getIntent() != null) {
                statisticItem.param("nid", this.f22353a.getPageActivity().getIntent().getStringExtra("nid"));
            }
            TbPageContext tbPageContext2 = this.f22353a;
            if (tbPageContext2 != null) {
                c.e(tbPageContext2.getPageActivity(), statisticItem);
            }
            TbPageContext tbPageContext3 = this.f22353a;
            if (tbPageContext3 != null && tbPageContext3.getPageActivity() != null && c.j(this.f22353a.getPageActivity()) != null && c.j(this.f22353a.getPageActivity()).b() != null && !TextUtils.isEmpty(c.j(this.f22353a.getPageActivity()).b().locatePage) && "a002".equals(c.j(this.f22353a.getPageActivity()).b().locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, c.j(this.f22353a.getPageActivity()).b().locatePage);
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a011");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13575");
            statisticItem.param("obj_type", this.f22357e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "9"));
            if (ViewHelper.checkUpIsLogin(this.f22353a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f22355c.getUserId()) ? 1 : 2).param("obj_source", this.f22355c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f22353a.getPageActivity(), true, this.f22355c.getUserId(), this.f22355c.getSex()).updateFollowNum(this.f22355c.getConcernNum(), this.f22355c.getPortrait())));
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13573");
            statisticItem.param("obj_type", this.f22357e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
            if (ViewHelper.checkUpIsLogin(this.f22353a.getPageActivity())) {
                c.a.p0.y2.a.v().L(2, false, this.f22357e);
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f22355c.getUserId()) ? 1 : 2).param("obj_source", this.f22355c.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f22353a.getPageActivity(), false, this.f22355c.getUserId(), this.f22355c.getSex())));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13574");
            statisticItem.param("obj_type", this.f22357e ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
            if (ViewHelper.checkUpIsLogin(this.f22353a.getPageActivity())) {
                boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.f22355c.getUserId());
                boolean z = this.f22355c.getIsFriend() == 1;
                if (this.f22355c.getPersonPrivate() == null) {
                    J(this.f22355c.getSex());
                } else if (this.f22355c.getPersonPrivate().w() != 1 && !equals && (!z || this.f22355c.getPersonPrivate().w() != 2)) {
                    J(this.f22355c.getSex());
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f22355c.getUserId()) ? 1 : 2).param("obj_source", this.f22355c.isGod() ? 1 : 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f22353a.getPageActivity(), this.f22355c.getLike_bars(), this.f22355c.getUserId(), this.f22355c.getSex())));
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            AlaUserInfoData alaUserData = this.f22355c.getAlaUserData();
            if (!this.f22357e && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                TiebaStatic.log("c12542");
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f22353a.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
                return;
            }
            m mVar = new m();
            if (this.f22355c.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.f22355c.getBaijiahaoInfo().avatar)) {
                mVar.g(this.f22355c.getBaijiahaoInfo().avatar);
                mVar.i(this.f22355c.getBaijiahaoInfo().avatar);
                mVar.h(true);
            } else if (!StringUtils.isNull(this.f22355c.getPortrait()) && this.f22355c.getPortrait().startsWith("http")) {
                mVar.g(this.f22355c.getPortrait());
                mVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f22355c.getPortrait()));
                mVar.h(true);
            } else {
                mVar.g(HeadIconRefreshHelper.headPortraitFilter(this.f22355c.getPortraitH()));
                mVar.i(HeadIconRefreshHelper.headPortraitFilter(this.f22355c.getPortrait()));
                mVar.h(true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(mVar);
            this.f22359g.r(mVar, arrayList, 0);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "6"));
            if (this.f22357e) {
                if (ViewHelper.checkUpIsLogin(this.f22353a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f22353a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            }
            ArrayList<IconData> tShowInfo = this.f22355c.getTShowInfo();
            if (ListUtils.getItem(tShowInfo, 0) != null) {
                UrlManager.getInstance().dealOneLink(this.f22353a, new String[]{tShowInfo.get(0).getUrl()});
            }
        }
    }

    public final void x() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (userData = this.f22355c) == null || userData.getLiveRoomInfo() == null || TextUtils.isEmpty(this.f22355c.getLiveRoomInfo().jump_url)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f22353a, new String[]{this.f22355c.getLiveRoomInfo().jump_url}, true);
    }

    public final void y() {
        c.a.p0.n2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.f22354b) == null || aVar.g() == null || TextUtils.isEmpty(this.f22354b.g().f15637b)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f22353a, new String[]{this.f22354b.g().f15637b}, true);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "4"));
            c.a.o0.m.a.o(this.f22353a.getPageActivity(), this.f22353a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f22355c.getUserId(), true, true, true);
        }
    }
}
