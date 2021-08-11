package c.a.p0.l2.e;

import android.text.TextUtils;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.l2.e.g;
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
/* loaded from: classes3.dex */
public class f implements c.a.p0.k2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c.a.e.k.e.n> f21439a;

    /* renamed from: b  reason: collision with root package name */
    public UserData f21440b;

    /* renamed from: c  reason: collision with root package name */
    public Duxiaoman f21441c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.b1.b f21442d;

    /* renamed from: e  reason: collision with root package name */
    public List<BannerImage> f21443e;

    /* renamed from: f  reason: collision with root package name */
    public PersonUserGodInfo f21444f;

    /* renamed from: g  reason: collision with root package name */
    public d f21445g;

    /* renamed from: h  reason: collision with root package name */
    public h f21446h;

    /* renamed from: i  reason: collision with root package name */
    public h f21447i;

    /* renamed from: j  reason: collision with root package name */
    public h f21448j;
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
        this.f21439a = new ArrayList<>();
    }

    @Override // c.a.p0.k2.b
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.f21440b == null) {
            this.f21440b = new UserData();
        }
        this.f21440b.parserProtobuf(personalResIdl.data.user);
        i iVar = new i();
        this.l = iVar;
        iVar.f21462e = this.f21440b;
        this.f21439a.add(iVar);
        g();
        k();
        c.a.p0.y2.a.v().K(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.f21440b.getSex());
        }
    }

    @Override // c.a.p0.k2.b
    public void b(ProfileResIdl profileResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new i();
        DataRes dataRes = profileResIdl.data;
        this.f21443e = dataRes.banner;
        this.f21441c = dataRes.duxiaoman;
        t(dataRes.user, dataRes.user_god_info);
        q(profileResIdl.data.tbbookrack);
        r(profileResIdl.data.uc_card);
        s(profileResIdl.data.url_map);
        this.f21439a.add(this.l);
        g();
        h();
        l(profileResIdl.data.recom_swan_list);
        m();
        k();
        c.a.p0.y2.a.v().K(true);
    }

    public void c(boolean z) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (hVar = this.f21448j) == null) {
            return;
        }
        if (hVar.m == null) {
            hVar.m = new j();
        }
        this.f21448j.m.f21463a = z;
    }

    public void d(boolean z) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (dVar = this.f21445g) == null) {
            return;
        }
        dVar.f21436i = z;
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
        this.k.m.f21463a = z;
    }

    public void f(boolean z) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (hVar = this.f21446h) == null) {
            return;
        }
        if (hVar.m == null) {
            hVar.m = new j();
        }
        this.f21446h.m.f21463a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d dVar = this.f21445g;
            if (dVar != null) {
                this.f21439a.add(dVar);
            } else if (this.f21440b == null) {
            } else {
                d dVar2 = new d();
                this.f21445g = dVar2;
                dVar2.f21432e = this.f21440b.getFansNum();
                this.f21445g.f21433f = this.f21440b.getConcern_num();
                this.f21445g.f21434g = this.f21440b.getLike_bars();
                this.f21445g.f21435h = this.f21440b.getThreadNum();
                d dVar3 = this.f21445g;
                dVar3.f21437j = this.f21440b;
                this.f21439a.add(dVar3);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (c.a.o0.s.d0.b.j().k("key_create_center_entrance_switch", 0) == 0) {
                return;
            }
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 4; i2++) {
                g.a aVar = new g.a();
                aVar.f21453b = this.q[i2];
                if (i2 == 1) {
                    UserData userData = this.f21440b;
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
            gVar.f21451f = this.f21440b;
            this.f21439a.add(gVar);
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
            UserData userData = this.f21440b;
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
            UserData userData = this.f21440b;
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
            if (this.f21446h == null) {
                h i2 = i(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
                this.f21446h = i2;
                i2.f21457g = true;
                i2.m = new j();
            }
            this.f21439a.add(this.f21446h);
            h i3 = i(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
            i3.f21457g = true;
            i3.f21460j = true;
            this.f21439a.add(i3);
            h i4 = i(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
            i4.f21460j = true;
            i4.f21457g = true;
            c.a.p0.b1.b bVar = this.f21442d;
            if (bVar != null && bVar.a() && !TextUtils.isEmpty(this.f21442d.f15637b)) {
                h i5 = i(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
                i5.f21457g = true;
                i5.k = this.f21442d.f15637b;
                this.f21439a.add(i5);
            }
            h i6 = i(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
            i6.f21457g = true;
            i6.m = new j();
            if (!c.a.o0.s.d0.b.j().g("key_has_borrow_cash_clicked", false)) {
                i6.m.f21463a = true;
            }
            i6.m.f21470h = true;
            this.f21439a.add(i6);
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                h i7 = i(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
                i7.f21457g = true;
                i7.k = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
                this.f21439a.add(i7);
            }
            if (c.a.o0.s.d0.b.j().k("baidu_financial_display", 1) == 1) {
                h i8 = i(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
                i8.f21457g = true;
                if (!c.a.o0.s.d0.b.j().g("key_baidu_financial_has_clicked", false)) {
                    j jVar = new j();
                    i8.m = jVar;
                    jVar.f21463a = true;
                }
                this.f21439a.add(i8);
            }
            Duxiaoman duxiaoman = this.f21441c;
            if (duxiaoman != null && duxiaoman.is_end.intValue() != 1) {
                h i9 = i(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
                i9.f21457g = true;
                i9.k = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                int intValue = this.f21441c.total_cash.intValue();
                if (intValue > 0) {
                    j jVar2 = new j();
                    jVar2.f21465c = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                    jVar2.f21466d = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                    i9.m = jVar2;
                }
                this.f21439a.add(i9);
            }
            h i10 = i(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            i10.f21457g = true;
            this.f21439a.add(i10);
            h i11 = i(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
            i11.f21457g = true;
            this.f21439a.add(i11);
            h i12 = i(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
            this.f21447i = i12;
            i12.m = new j();
            this.f21447i.f21457g = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.f21440b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.f21440b.getTDouNum());
            }
            j jVar3 = this.f21447i.m;
            jVar3.f21465c = formatNumForTdouDisPlay;
            jVar3.f21467e = CurrencySwitchUtil.getMoneyIcon();
            this.f21439a.add(this.f21447i);
            h i13 = i(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
            i13.f21457g = true;
            this.f21439a.add(i13);
            h i14 = i(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
            i14.f21457g = true;
            MembershipUserInfo membershipUserInfo = this.f21440b.membershipInfo;
            if (membershipUserInfo != null) {
                i14.k = membershipUserInfo.mLink;
            }
            this.f21439a.add(i14);
            boolean f2 = TbadkCoreApplication.getInst().getActivityPrizeData().f();
            String e2 = TbadkCoreApplication.getInst().getActivityPrizeData().e();
            if (f2 && !StringUtils.isNull(e2)) {
                h j2 = j(R.drawable.icon_mine_list_logingift, e2, 38);
                this.f21448j = j2;
                j2.f21460j = true;
                j2.m = new j();
                this.f21439a.add(this.f21448j);
                TiebaStatic.log(new StatisticItem("c12597"));
            } else {
                i14.f21460j = true;
            }
            h i15 = i(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
            i15.f21457g = true;
            this.f21439a.add(i15);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                h i16 = i(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
                i16.f21457g = true;
                i16.f21460j = true;
                this.f21439a.add(i16);
            }
            h i17 = i(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = i17;
            i17.f21460j = true;
            i17.f21457g = true;
            this.f21439a.add(i17);
            h i18 = i(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
            i18.f21457g = true;
            this.f21439a.add(i18);
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
                    i19.m.f21464b = o(R.string.person_center_more_desc, sb.toString());
                }
            }
            this.f21439a.add(i19);
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
            this.f21439a.add(kVar);
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
                this.f21439a.add(nVar);
                return;
            }
            this.n = new n();
            if (ListUtils.isEmpty(this.f21443e)) {
                return;
            }
            for (int i2 = 0; i2 < this.f21443e.size(); i2++) {
                a aVar = new a();
                aVar.d(this.f21443e.get(i2));
                if (!c.a.e.e.p.k.isEmpty(aVar.c())) {
                    this.n.f21482e.add(aVar);
                }
            }
            if (this.n.f21482e.size() > 0) {
                this.f21439a.add(this.n);
            }
        }
    }

    public ArrayList<c.a.e.k.e.n> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f21439a : (ArrayList) invokeV.objValue;
    }

    public final String o(@StringRes int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, objArr)) == null) ? TbadkCoreApplication.getInst().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public UserData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f21440b : (UserData) invokeV.objValue;
    }

    public final void q(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        c.a.p0.k2.h.a aVar = new c.a.p0.k2.h.a();
        aVar.a(tbBookrack);
        new c.a.p0.k2.h.d(true, aVar);
    }

    public final void r(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ucCard) == null) {
            new c.a.p0.k2.f().a(ucCard);
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
            if (this.f21440b == null) {
                this.f21440b = new UserData();
            }
            this.f21440b.parserProtobuf(user);
            if (this.f21444f == null && userGodInfo != null) {
                this.f21444f = new PersonUserGodInfo();
            }
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.f21440b.setIsBigV(true);
                this.f21444f.parserProtobuf(userGodInfo);
            }
            this.l.f21462e = this.f21440b;
        }
    }

    public void u(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, userPendantData) == null) {
            this.f21440b.setPendantData(userPendantData);
        }
    }
}
