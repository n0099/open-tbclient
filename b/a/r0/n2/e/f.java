package b.a.r0.n2.e;

import android.text.TextUtils;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.n2.e.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.MembershipUserInfo;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.DataRes;
import tbclient.Profile.Duxiaoman;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes5.dex */
public class f implements b.a.r0.m2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b.a.e.l.e.n> f21440a;

    /* renamed from: b  reason: collision with root package name */
    public UserData f21441b;

    /* renamed from: c  reason: collision with root package name */
    public Duxiaoman f21442c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.d1.b f21443d;

    /* renamed from: e  reason: collision with root package name */
    public List<BannerImage> f21444e;

    /* renamed from: f  reason: collision with root package name */
    public PersonUserGodInfo f21445f;

    /* renamed from: g  reason: collision with root package name */
    public d f21446g;

    /* renamed from: h  reason: collision with root package name */
    public h f21447h;

    /* renamed from: i  reason: collision with root package name */
    public h f21448i;
    public h j;
    public h k;
    public i l;
    public PersonMoreData m;
    public n n;
    public k o;
    public int[] p;
    public int[] q;
    public int[] r;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new int[]{R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
        this.q = new int[]{R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
        this.r = new int[]{1, 2, 3, 4};
        this.f21440a = new ArrayList<>();
    }

    @Override // b.a.r0.m2.b
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.f21441b == null) {
            this.f21441b = new UserData();
        }
        this.f21441b.parserProtobuf(personalResIdl.data.user);
        i iVar = new i();
        this.l = iVar;
        iVar.f21461e = this.f21441b;
        this.f21440a.add(iVar);
        g();
        k();
        b.a.r0.a3.a.v().K(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.f21441b.getSex());
        }
    }

    @Override // b.a.r0.m2.b
    public void b(ProfileResIdl profileResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new i();
        DataRes dataRes = profileResIdl.data;
        this.f21444e = dataRes.banner;
        this.f21442c = dataRes.duxiaoman;
        t(dataRes.user, dataRes.user_god_info);
        q(profileResIdl.data.tbbookrack);
        r(profileResIdl.data.uc_card);
        s(profileResIdl.data.url_map);
        this.f21440a.add(this.l);
        g();
        h();
        l(profileResIdl.data.recom_swan_list);
        m();
        k();
        b.a.r0.a3.a.v().K(true);
    }

    public void c(boolean z) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (hVar = this.j) == null) {
            return;
        }
        if (hVar.m == null) {
            hVar.m = new j();
        }
        this.j.m.f21462a = z;
    }

    public void d(boolean z) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (dVar = this.f21446g) == null) {
            return;
        }
        dVar.f21438i = z;
    }

    public void e(boolean z) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (hVar = this.k) == null) {
            return;
        }
        if (hVar.m == null) {
            hVar.m = new j();
        }
        this.k.m.f21462a = z;
    }

    public void f(boolean z) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (hVar = this.f21447h) == null) {
            return;
        }
        if (hVar.m == null) {
            hVar.m = new j();
        }
        this.f21447h.m.f21462a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d dVar = this.f21446g;
            if (dVar != null) {
                this.f21440a.add(dVar);
            } else if (this.f21441b == null) {
            } else {
                d dVar2 = new d();
                this.f21446g = dVar2;
                dVar2.f21434e = this.f21441b.getFansNum();
                this.f21446g.f21435f = this.f21441b.getConcern_num();
                this.f21446g.f21436g = this.f21441b.getLike_bars();
                this.f21446g.f21437h = this.f21441b.getThreadNum();
                d dVar3 = this.f21446g;
                dVar3.j = this.f21441b;
                this.f21440a.add(dVar3);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (b.a.q0.s.e0.b.j().k("key_create_center_entrance_switch", 0) == 0) {
                return;
            }
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 4; i2++) {
                g.a aVar = new g.a();
                aVar.f21453b = this.q[i2];
                if (i2 == 1) {
                    UserData userData = this.f21441b;
                    if (userData != null && userData.isNewGod()) {
                        aVar.f21454c = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.f21452a = 5;
                    } else {
                        aVar.f21454c = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.f21452a = 2;
                    }
                } else {
                    aVar.f21454c = TbadkCoreApplication.getInst().getString(this.p[i2]);
                    aVar.f21452a = this.r[i2];
                }
                arrayList.add(aVar);
            }
            gVar.g(arrayList);
            gVar.f21451f = this.f21441b;
            this.f21440a.add(gVar);
        }
    }

    public final h i(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4)) == null) {
            h hVar = new h();
            hVar.f21456f = i2;
            hVar.f21459i = TbadkCoreApplication.getInst().getString(i3);
            hVar.f21455e = i4;
            UserData userData = this.f21441b;
            if (userData != null) {
                hVar.l = userData;
            }
            return hVar;
        }
        return (h) invokeIII.objValue;
    }

    public final h j(int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            h hVar = new h();
            hVar.f21456f = i2;
            hVar.f21459i = str;
            hVar.f21455e = i3;
            UserData userData = this.f21441b;
            if (userData != null) {
                hVar.l = userData;
            }
            return hVar;
        }
        return (h) invokeCommon.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f21447h == null) {
                h i2 = i(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
                this.f21447h = i2;
                i2.f21457g = true;
                i2.m = new j();
            }
            this.f21440a.add(this.f21447h);
            h i3 = i(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
            i3.f21457g = true;
            i3.j = true;
            this.f21440a.add(i3);
            h i4 = i(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
            i4.j = true;
            i4.f21457g = true;
            b.a.r0.d1.b bVar = this.f21443d;
            if (bVar != null && bVar.a() && !TextUtils.isEmpty(this.f21443d.f15622b)) {
                h i5 = i(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
                i5.f21457g = true;
                i5.k = this.f21443d.f15622b;
                this.f21440a.add(i5);
            }
            h i6 = i(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
            i6.f21457g = true;
            i6.m = new j();
            if (!b.a.q0.s.e0.b.j().g("key_has_borrow_cash_clicked", false)) {
                i6.m.f21462a = true;
            }
            i6.m.f21469h = true;
            this.f21440a.add(i6);
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                h i7 = i(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
                i7.f21457g = true;
                i7.k = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
                this.f21440a.add(i7);
            }
            if (b.a.q0.s.e0.b.j().k("baidu_financial_display", 1) == 1) {
                h i8 = i(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
                i8.f21457g = true;
                if (!b.a.q0.s.e0.b.j().g("key_baidu_financial_has_clicked", false)) {
                    j jVar = new j();
                    i8.m = jVar;
                    jVar.f21462a = true;
                }
                this.f21440a.add(i8);
            }
            Duxiaoman duxiaoman = this.f21442c;
            if (duxiaoman != null && duxiaoman.is_end.intValue() != 1) {
                h i9 = i(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
                i9.f21457g = true;
                i9.k = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                int intValue = this.f21442c.total_cash.intValue();
                if (intValue > 0) {
                    j jVar2 = new j();
                    jVar2.f21464c = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                    jVar2.f21465d = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                    i9.m = jVar2;
                }
                this.f21440a.add(i9);
            }
            h i10 = i(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            i10.f21457g = true;
            this.f21440a.add(i10);
            h i11 = i(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
            i11.f21457g = true;
            this.f21440a.add(i11);
            h i12 = i(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
            this.f21448i = i12;
            i12.m = new j();
            this.f21448i.f21457g = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.f21441b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.f21441b.getTDouNum());
            }
            j jVar3 = this.f21448i.m;
            jVar3.f21464c = formatNumForTdouDisPlay;
            jVar3.f21466e = CurrencySwitchUtil.getMoneyIcon();
            this.f21440a.add(this.f21448i);
            h i13 = i(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
            i13.f21457g = true;
            this.f21440a.add(i13);
            h i14 = i(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
            i14.f21457g = true;
            MembershipUserInfo membershipUserInfo = this.f21441b.membershipInfo;
            if (membershipUserInfo != null) {
                i14.k = membershipUserInfo.mLink;
            }
            this.f21440a.add(i14);
            boolean f2 = TbadkCoreApplication.getInst().getActivityPrizeData().f();
            String e2 = TbadkCoreApplication.getInst().getActivityPrizeData().e();
            if (f2 && !StringUtils.isNull(e2)) {
                h j = j(R.drawable.icon_mine_list_logingift, e2, 38);
                this.j = j;
                j.j = true;
                j.m = new j();
                this.f21440a.add(this.j);
                TiebaStatic.log(new StatisticItem("c12597"));
            } else {
                i14.j = true;
            }
            h i15 = i(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
            i15.f21457g = true;
            this.f21440a.add(i15);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                h i16 = i(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
                i16.f21457g = true;
                i16.j = true;
                this.f21440a.add(i16);
            }
            h i17 = i(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = i17;
            i17.j = true;
            i17.f21457g = true;
            this.f21440a.add(i17);
            h i18 = i(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
            i18.f21457g = true;
            this.f21440a.add(i18);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            h i19 = i(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
            i19.f21457g = true;
            i19.f21458h = true;
            i19.n = OrmObject.bundleWithObject(this.m);
            i19.m = new j();
            List<PersonMoreItemData> list = this.m.mUrlMaps;
            if (list != null) {
                StringBuilder sb = new StringBuilder();
                for (PersonMoreItemData personMoreItemData : list) {
                    if (personMoreItemData != null && !TextUtils.isEmpty(personMoreItemData.mName)) {
                        sb.append(personMoreItemData.mName);
                        sb.append("、");
                    }
                }
                if (sb.toString().endsWith("、")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    i19.m.f21463b = o(R.string.person_center_more_desc, sb.toString());
                }
            }
            this.f21440a.add(i19);
        }
    }

    public final void l(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o == null) {
            k kVar = new k();
            this.o = kVar;
            this.f21440a.add(kVar);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new m(smartApp));
                }
            }
        }
        this.o.i(arrayList);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            n nVar = this.n;
            if (nVar != null) {
                this.f21440a.add(nVar);
                return;
            }
            this.n = new n();
            if (ListUtils.isEmpty(this.f21444e)) {
                return;
            }
            for (int i2 = 0; i2 < this.f21444e.size(); i2++) {
                a aVar = new a();
                aVar.d(this.f21444e.get(i2));
                if (!b.a.e.e.p.k.isEmpty(aVar.c())) {
                    this.n.f21481e.add(aVar);
                }
            }
            if (this.n.f21481e.size() > 0) {
                this.f21440a.add(this.n);
            }
        }
    }

    public ArrayList<b.a.e.l.e.n> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f21440a : (ArrayList) invokeV.objValue;
    }

    public final String o(@StringRes int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, objArr)) == null) ? TbadkCoreApplication.getInst().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public UserData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f21441b : (UserData) invokeV.objValue;
    }

    public final void q(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        b.a.r0.m2.h.a aVar = new b.a.r0.m2.h.a();
        aVar.a(tbBookrack);
        new b.a.r0.m2.h.d(true, aVar);
    }

    public final void r(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ucCard) == null) {
            new b.a.r0.m2.f().a(ucCard);
        }
    }

    public final void s(List<UserMap> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.m = new PersonMoreData();
        for (UserMap userMap : list) {
            if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                String replaceAll = userMap.url.replaceAll("amp;", "");
                PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                personMoreItemData.mId = userMap.id.intValue();
                personMoreItemData.mName = userMap.name;
                personMoreItemData.mUrl = replaceAll;
                this.m.mUrlMaps.add(personMoreItemData);
            }
        }
    }

    public final void t(User user, UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, user, userGodInfo) == null) {
            if (this.f21441b == null) {
                this.f21441b = new UserData();
            }
            this.f21441b.parserProtobuf(user);
            if (this.f21445f == null && userGodInfo != null) {
                this.f21445f = new PersonUserGodInfo();
            }
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.f21441b.setIsBigV(true);
                this.f21445f.parserProtobuf(userGodInfo);
            }
            this.l.f21461e = this.f21441b;
        }
    }

    public void u(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, userPendantData) == null) {
            this.f21441b.setPendantData(userPendantData);
        }
    }
}
