package c.a.p0.z2.d;

import android.text.TextUtils;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.z2.d.g;
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
import com.baidu.tieba.redtip.PersonRedTipManager;
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
public class f implements c.a.p0.y2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c.a.d.o.e.n> a;

    /* renamed from: b  reason: collision with root package name */
    public UserData f20934b;

    /* renamed from: c  reason: collision with root package name */
    public Duxiaoman f20935c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.l1.b f20936d;

    /* renamed from: e  reason: collision with root package name */
    public List<BannerImage> f20937e;

    /* renamed from: f  reason: collision with root package name */
    public PersonUserGodInfo f20938f;

    /* renamed from: g  reason: collision with root package name */
    public d f20939g;

    /* renamed from: h  reason: collision with root package name */
    public h f20940h;
    public h i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new int[]{R.string.obfuscated_res_0x7f0f0b37, R.string.obfuscated_res_0x7f0f07b6, R.string.obfuscated_res_0x7f0f0457, R.string.obfuscated_res_0x7f0f0856};
        this.q = new int[]{R.drawable.obfuscated_res_0x7f08084e, R.drawable.obfuscated_res_0x7f08083a, R.drawable.obfuscated_res_0x7f08084f, R.drawable.obfuscated_res_0x7f08083b};
        this.r = new int[]{1, 2, 3, 4};
        this.a = new ArrayList<>();
    }

    @Override // c.a.p0.y2.b
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.f20934b == null) {
            this.f20934b = new UserData();
        }
        this.f20934b.parserProtobuf(personalResIdl.data.user);
        i iVar = new i();
        this.l = iVar;
        iVar.a = this.f20934b;
        this.a.add(iVar);
        g();
        k();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.f20934b.getSex());
        }
    }

    @Override // c.a.p0.y2.b
    public void b(ProfileResIdl profileResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new i();
        DataRes dataRes = profileResIdl.data;
        this.f20937e = dataRes.banner;
        this.f20935c = dataRes.duxiaoman;
        t(dataRes.user, dataRes.user_god_info);
        q(profileResIdl.data.tbbookrack);
        r(profileResIdl.data.uc_card);
        s(profileResIdl.data.url_map);
        this.a.add(this.l);
        g();
        h();
        l(profileResIdl.data.recom_swan_list);
        m();
        k();
        PersonRedTipManager.getInstance().syncRedTipState(true);
    }

    public void c(boolean z) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (hVar = this.j) == null) {
            return;
        }
        if (hVar.i == null) {
            hVar.i = new j();
        }
        this.j.i.a = z;
    }

    public void d(boolean z) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (dVar = this.f20939g) == null) {
            return;
        }
        dVar.f20932e = z;
    }

    public void e(boolean z) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (hVar = this.k) == null) {
            return;
        }
        if (hVar.i == null) {
            hVar.i = new j();
        }
        this.k.i.a = z;
    }

    public void f(boolean z) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (hVar = this.f20940h) == null) {
            return;
        }
        if (hVar.i == null) {
            hVar.i = new j();
        }
        this.f20940h.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d dVar = this.f20939g;
            if (dVar != null) {
                this.a.add(dVar);
            } else if (this.f20934b == null) {
            } else {
                d dVar2 = new d();
                this.f20939g = dVar2;
                dVar2.a = this.f20934b.getFansNum();
                this.f20939g.f20929b = this.f20934b.getConcern_num();
                this.f20939g.f20930c = this.f20934b.getLike_bars();
                this.f20939g.f20931d = this.f20934b.getThreadNum();
                d dVar3 = this.f20939g;
                dVar3.f20933f = this.f20934b;
                this.a.add(dVar3);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (c.a.o0.r.j0.b.k().l("key_create_center_entrance_switch", 0) == 0) {
                return;
            }
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.f20943b = this.q[i];
                if (i == 1) {
                    UserData userData = this.f20934b;
                    if (userData != null && userData.isNewGod()) {
                        aVar.f20944c = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07b6);
                        aVar.a = 5;
                    } else {
                        aVar.f20944c = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07b1);
                        aVar.a = 2;
                    }
                } else {
                    aVar.f20944c = TbadkCoreApplication.getInst().getString(this.p[i]);
                    aVar.a = this.r[i];
                }
                arrayList.add(aVar);
            }
            gVar.e(arrayList);
            gVar.f20942b = this.f20934b;
            this.a.add(gVar);
        }
    }

    public final h i(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3)) == null) {
            h hVar = new h();
            hVar.f20945b = i;
            hVar.f20948e = TbadkCoreApplication.getInst().getString(i2);
            hVar.a = i3;
            UserData userData = this.f20934b;
            if (userData != null) {
                hVar.f20951h = userData;
            }
            return hVar;
        }
        return (h) invokeIII.objValue;
    }

    public final h j(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            h hVar = new h();
            hVar.f20945b = i;
            hVar.f20948e = str;
            hVar.a = i2;
            UserData userData = this.f20934b;
            if (userData != null) {
                hVar.f20951h = userData;
            }
            return hVar;
        }
        return (h) invokeCommon.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f20940h == null) {
                h i = i(R.drawable.icon_mask_wo_list_collect24_svg, R.string.obfuscated_res_0x7f0f0b30, 16);
                this.f20940h = i;
                i.f20946c = true;
                i.i = new j();
            }
            this.a.add(this.f20940h);
            h i2 = i(R.drawable.icon_mask_wo_list_history24_svg, R.string.obfuscated_res_0x7f0f0b2c, 17);
            i2.f20946c = true;
            i2.f20949f = true;
            this.a.add(i2);
            h i3 = i(R.drawable.icon_mask_wo_list_group24_svg, R.string.obfuscated_res_0x7f0f0b2b, 22);
            i3.f20949f = true;
            i3.f20946c = true;
            c.a.p0.l1.b bVar = this.f20936d;
            if (bVar != null && bVar.a() && !TextUtils.isEmpty(this.f20936d.f16074b)) {
                h i4 = i(R.drawable.obfuscated_res_0x7f080848, R.string.obfuscated_res_0x7f0f0e1b, 46);
                i4.f20946c = true;
                i4.f20950g = this.f20936d.f16074b;
                this.a.add(i4);
            }
            h i5 = i(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.obfuscated_res_0x7f0f032b, 37);
            i5.f20946c = true;
            i5.i = new j();
            if (!c.a.o0.r.j0.b.k().h("key_has_borrow_cash_clicked", false)) {
                i5.i.a = true;
            }
            i5.i.f20959h = true;
            this.a.add(i5);
            if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                h i6 = i(R.drawable.icon_mask_wo_list_game24_svg, R.string.obfuscated_res_0x7f0f09ec, 44);
                i6.f20946c = true;
                i6.f20950g = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
                this.a.add(i6);
            }
            if (c.a.o0.r.j0.b.k().l("baidu_financial_display", 1) == 1) {
                h i7 = i(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.obfuscated_res_0x7f0f02c2, 41);
                i7.f20946c = true;
                if (!c.a.o0.r.j0.b.k().h("key_baidu_financial_has_clicked", false)) {
                    j jVar = new j();
                    i7.i = jVar;
                    jVar.a = true;
                }
                this.a.add(i7);
            }
            Duxiaoman duxiaoman = this.f20935c;
            if (duxiaoman != null && duxiaoman.is_end.intValue() != 1) {
                h i8 = i(R.drawable.icon_mask_wo_list_sign24_svg, R.string.obfuscated_res_0x7f0f0df0, 45);
                i8.f20946c = true;
                i8.f20950g = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                int intValue = this.f20935c.total_cash.intValue();
                if (intValue > 0) {
                    j jVar2 = new j();
                    jVar2.f20954c = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f115c, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                    jVar2.f20955d = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                    i8.i = jVar2;
                }
                this.a.add(i8);
            }
            h i9 = i(R.drawable.icon_mask_wo_list_task24_svg, R.string.obfuscated_res_0x7f0f0e2e, 43);
            i9.f20946c = true;
            this.a.add(i9);
            h i10 = i(R.drawable.icon_mask_wo_list_member24_svg, R.string.obfuscated_res_0x7f0f0a9f, 12);
            i10.f20946c = true;
            this.a.add(i10);
            h i11 = i(R.drawable.icon_mask_wo_list_gift24_svg, R.string.obfuscated_res_0x7f0f0b28, 10);
            this.i = i11;
            i11.i = new j();
            this.i.f20946c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.f20934b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.f20934b.getTDouNum());
            }
            j jVar3 = this.i.i;
            jVar3.f20954c = formatNumForTdouDisPlay;
            jVar3.f20956e = CurrencySwitchUtil.getMoneyIcon();
            this.a.add(this.i);
            h i12 = i(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.obfuscated_res_0x7f0f037d, 18);
            i12.f20946c = true;
            this.a.add(i12);
            h i13 = i(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.obfuscated_res_0x7f0f0316, 11);
            i13.f20946c = true;
            MembershipUserInfo membershipUserInfo = this.f20934b.membershipInfo;
            if (membershipUserInfo != null) {
                i13.f20950g = membershipUserInfo.mLink;
            }
            this.a.add(i13);
            boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
            String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
            if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
                h j = j(R.drawable.icon_mine_list_logingift, personItemText, 38);
                this.j = j;
                j.f20949f = true;
                j.i = new j();
                this.a.add(this.j);
                TiebaStatic.log(new StatisticItem("c12597"));
            } else {
                i13.f20949f = true;
            }
            h i14 = i(R.drawable.icon_mask_wo_list_topic24_svg, R.string.obfuscated_res_0x7f0f085f, 30);
            i14.f20946c = true;
            this.a.add(i14);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                h i15 = i(R.drawable.icon_mask_wo_list_live24_svg, R.string.obfuscated_res_0x7f0f021b, 25);
                i15.f20946c = true;
                i15.f20949f = true;
                this.a.add(i15);
            }
            h i16 = i(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e2b, 31);
            this.k = i16;
            i16.f20949f = true;
            i16.f20946c = true;
            this.a.add(i16);
            h i17 = i(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02c5, 39);
            i17.f20946c = true;
            this.a.add(i17);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            h i18 = i(R.drawable.icon_pure_wo_list_more24_svg, R.string.obfuscated_res_0x7f0f0dec, 33);
            i18.f20946c = true;
            i18.f20947d = true;
            i18.j = OrmObject.bundleWithObject(this.m);
            i18.i = new j();
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
                    i18.i.f20953b = o(R.string.obfuscated_res_0x7f0f0ded, sb.toString());
                }
            }
            this.a.add(i18);
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
            this.a.add(kVar);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new m(smartApp));
                }
            }
        }
        this.o.g(arrayList);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            n nVar = this.n;
            if (nVar != null) {
                this.a.add(nVar);
                return;
            }
            this.n = new n();
            if (ListUtils.isEmpty(this.f20937e)) {
                return;
            }
            for (int i = 0; i < this.f20937e.size(); i++) {
                a aVar = new a();
                aVar.d(this.f20937e.get(i));
                if (!c.a.d.f.p.m.isEmpty(aVar.c())) {
                    this.n.a.add(aVar);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }

    public ArrayList<c.a.d.o.e.n> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public final String o(@StringRes int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, objArr)) == null) ? TbadkCoreApplication.getInst().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public UserData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f20934b : (UserData) invokeV.objValue;
    }

    public final void q(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        c.a.p0.y2.i.a aVar = new c.a.p0.y2.i.a();
        aVar.a(tbBookrack);
        new c.a.p0.y2.i.d(true, aVar);
    }

    public final void r(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ucCard) == null) {
            new c.a.p0.y2.g().a(ucCard);
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
            if (this.f20934b == null) {
                this.f20934b = new UserData();
            }
            this.f20934b.parserProtobuf(user);
            if (this.f20938f == null && userGodInfo != null) {
                this.f20938f = new PersonUserGodInfo();
            }
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.f20934b.setIsBigV(true);
                this.f20938f.parserProtobuf(userGodInfo);
            }
            this.l.a = this.f20934b;
        }
    }

    public void u(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, userPendantData) == null) {
            this.f20934b.setPendantData(userPendantData);
        }
    }
}
