package b.a.r0.p2.e;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.HotUserRankEntry;
import tbclient.PostInfoList;
import tbclient.PrivSets;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NicknameInfo A;
    public User B;
    public MetaData C;
    public List<d2> D;
    public HotUserRankEntry E;

    /* renamed from: a  reason: collision with root package name */
    public boolean f22268a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22269b;

    /* renamed from: c  reason: collision with root package name */
    public int f22270c;

    /* renamed from: d  reason: collision with root package name */
    public int f22271d;

    /* renamed from: e  reason: collision with root package name */
    public int f22272e;

    /* renamed from: f  reason: collision with root package name */
    public int f22273f;

    /* renamed from: g  reason: collision with root package name */
    public UserData f22274g;

    /* renamed from: h  reason: collision with root package name */
    public AntiData f22275h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<b.a.e.l.e.n> f22276i;
    public c j;
    public b.a.r0.m2.g.f k;
    public b.a.r0.d1.b l;
    public List<AlaLiveInfoCoreData> m;
    public g n;
    public i o;
    public List<b.a.e.l.e.n> p;
    public ArrayList<b.a.e.l.e.n> q;
    public ArrayList<n> r;
    public ArrayList<b.a.e.l.e.n> s;
    public b.a.r0.m2.h.d t;
    public n u;
    public n v;
    public n w;
    public n x;
    public n y;
    public PersonUserGodInfo z;

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22269b = true;
        this.f22270c = 1;
        this.f22271d = 1;
        this.f22272e = 1;
        this.f22273f = -1;
        this.f22268a = z;
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.D = new ArrayList();
    }

    public b.a.r0.m2.d a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            b.a.r0.m2.d dVar = new b.a.r0.m2.d();
            dVar.f21162e = i2;
            dVar.f21164g = i3;
            return dVar;
        }
        return (b.a.r0.m2.d) invokeII.objValue;
    }

    public abstract void b();

    public final n c(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4)) == null) {
            n nVar = new n();
            TbadkCoreApplication.getInst().getString(i3);
            b.a.r0.n2.f.a aVar = new b.a.r0.n2.f.a();
            nVar.f22324a = aVar;
            aVar.f22132a = i4;
            return nVar;
        }
        return (n) invokeIII.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.clear();
            n c2 = c(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
            this.v = c2;
            c2.f22325b = new Bundle();
            this.v.f22325b.putBoolean("person_center_item_red_tip", true);
            this.v.f22324a.f22133b = new Bundle();
            this.v.f22324a.f22133b.putSerializable(UserData.TYPE_USER, this.f22274g);
            this.r.add(this.v);
            n c3 = c(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
            this.w = c3;
            c3.f22325b = new Bundle();
            this.w.f22325b.putBoolean("person_center_item_red_tip", true);
            this.w.f22324a.f22133b = new Bundle();
            this.w.f22324a.f22133b.putSerializable(UserData.TYPE_USER, this.f22274g);
            this.r.add(this.w);
            n c4 = c(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
            this.u = c4;
            c4.f22325b = new Bundle();
            this.u.f22325b.putBoolean("person_center_item_red_tip", true);
            this.u.f22324a.f22133b = new Bundle();
            this.u.f22324a.f22133b.putSerializable(UserData.TYPE_USER, this.f22274g);
            this.r.add(this.u);
            n c5 = c(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
            c5.f22324a.f22133b = new Bundle();
            c5.f22324a.f22133b.putSerializable(UserData.TYPE_USER, this.f22274g);
            this.r.add(c5);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
                n c6 = c(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
                c6.f22325b = new Bundle();
                c6.f22324a.f22133b = new Bundle();
                c6.f22324a.f22133b.putSerializable(UserData.TYPE_USER, this.f22274g);
                this.r.add(c6);
            }
            n c7 = c(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
            this.x = c7;
            c7.f22325b = new Bundle();
            this.x.f22325b.putBoolean("person_center_item_red_tip", true);
            this.x.f22324a.f22133b = new Bundle();
            this.x.f22324a.f22133b.putSerializable(UserData.TYPE_USER, this.f22274g);
            this.r.add(this.x);
            n c8 = c(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
            c8.f22324a.f22133b = new Bundle();
            c8.f22324a.f22133b.putSerializable(UserData.TYPE_USER, this.f22274g);
            b.a.r0.m2.h.d dVar = this.t;
            if (dVar != null) {
                c8.f22324a.f22133b.putString("book_jump_link", dVar.f21195e);
            }
            this.r.add(c8);
            n c9 = c(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
            c9.f22324a.f22133b = new Bundle();
            c9.f22324a.f22133b.putSerializable(UserData.TYPE_USER, this.f22274g);
            this.r.add(c9);
            n c10 = c(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
            c10.f22324a.f22133b = new Bundle();
            c10.f22324a.f22133b.putSerializable(UserData.TYPE_USER, this.f22274g);
            this.r.add(c10);
            n c11 = c(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
            c11.f22324a.f22133b = new Bundle();
            c11.f22324a.f22133b.putString("key_service_centre", "");
            this.r.add(c11);
        }
    }

    public AntiData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22275h : (AntiData) invokeV.objValue;
    }

    public ArrayList<b.a.e.l.e.n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public b.a.r0.d1.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (b.a.r0.d1.b) invokeV.objValue;
    }

    public List<d2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : (List) invokeV.objValue;
    }

    public User i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (User) invokeV.objValue;
    }

    public UserData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22274g : (UserData) invokeV.objValue;
    }

    public List<b.a.e.l.e.n> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b.a.r0.m2.g.f fVar = this.k;
            if (fVar == null) {
                return null;
            }
            return fVar.a();
        }
        return (List) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f22269b : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f22268a : invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f22268a) {
                return false;
            }
            int i2 = this.f22271d;
            if (i2 == 3) {
                return true;
            }
            return i2 == 2 && !this.f22269b;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f22268a) {
                return false;
            }
            int i2 = this.f22272e;
            if (i2 == 3) {
                return true;
            }
            return i2 == 2 && !this.f22269b;
        }
        return invokeV.booleanValue;
    }

    public final void p(List<ForumDynamic> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            c cVar = new c();
            this.j = cVar;
            cVar.f22283e = new ArrayList();
            for (ForumDynamic forumDynamic : list) {
                if (forumDynamic != null) {
                    f fVar = new f();
                    fVar.f22293e = forumDynamic.forum_id.longValue();
                    fVar.f22294f = forumDynamic.forum_name;
                    fVar.f22295g = forumDynamic.avatar;
                    fVar.f22297i = this.f22270c;
                    fVar.f22296h = forumDynamic.user_thread_count.intValue();
                    this.j.f22283e.add(fVar);
                }
            }
        }
    }

    public final void q(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, dynamicInfo, z) == null) {
            if ((!n() || this.f22268a) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
                if (this.p == null) {
                    this.p = new ArrayList();
                }
                b bVar = new b();
                bVar.f22277e = this.f22268a;
                bVar.f22278f = this.f22270c;
                bVar.f22279g = z;
                bVar.f22280h = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                bVar.f22281i = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                bVar.j = forumDynamic.forum_id.longValue();
                bVar.k = forumDynamic.avatar;
                bVar.l = forumDynamic.forum_name;
                bVar.m = forumDynamic.is_like.intValue() == 1;
                bVar.n = forumDynamic.member_count.intValue();
                bVar.o = forumDynamic.thread_count.intValue();
                this.p.add(bVar);
                this.p.add(a(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
            }
        }
    }

    public final void r(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048593, this, dynamicInfo, z) == null) || (userDynamic = dynamicInfo.user_dynamic) == null) {
            return;
        }
        List<User> list = userDynamic.concerned_user_list;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        d dVar = new d();
        dVar.f22284e = this.f22268a;
        dVar.f22285f = z;
        dVar.f22288i = this.f22270c;
        dVar.f22286g = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.f22287h = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.f22287h = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        dVar.j = new ArrayList();
        for (User user : list) {
            if (user != null) {
                UserData userData = new UserData();
                userData.parserProtobuf(user);
                dVar.j.add(userData);
            }
        }
        this.p.add(dVar);
    }

    public final void s(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{user, dynamicInfo, random, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if ((!o() || this.f22268a) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
                if (this.p == null) {
                    this.p = new ArrayList();
                }
                int random2 = UtilHelper.getRandom(random, 3, this.f22273f);
                this.f22273f = random2;
                CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
                cardPersonDynamicThreadData.J = this.f22268a;
                cardPersonDynamicThreadData.H = z;
                cardPersonDynamicThreadData.G = z2;
                cardPersonDynamicThreadData.I = z3;
                cardPersonDynamicThreadData.u = 3;
                cardPersonDynamicThreadData.o(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
                this.p.add(cardPersonDynamicThreadData);
            }
        }
    }

    public final void t(User user, PostInfoList postInfoList, Random random) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, user, postInfoList, random) == null) {
            if (!o() || this.f22268a) {
                if (this.s == null) {
                    this.s = new ArrayList<>();
                }
                this.f22273f = UtilHelper.getRandom(random, 3, this.f22273f);
                CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
                cardPersonDynamicThreadData.J = this.f22268a;
                cardPersonDynamicThreadData.H = false;
                cardPersonDynamicThreadData.G = false;
                cardPersonDynamicThreadData.k(user, null, postInfoList, this.f22273f);
                this.s.add(cardPersonDynamicThreadData);
            }
        }
    }

    public final void u(User user) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, user) == null) || user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        g gVar = new g();
        this.n = gVar;
        gVar.g(user);
    }

    public void v(b.a.r0.m2.c cVar) {
        String str;
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) || cVar == null) {
            return;
        }
        this.B = cVar.GetUser();
        if (this.f22274g == null) {
            this.f22274g = new UserData();
        }
        this.f22274g.parserProtobuf(this.B);
        if (this.C == null) {
            this.C = new MetaData();
        }
        this.C.parserProtobuf(this.B);
        if (this.z == null) {
            this.z = new PersonUserGodInfo();
        }
        UserGodInfo userGodInfo = cVar.getUserGodInfo();
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.f22274g.setIsBigV(true);
            this.z.parserProtobuf(cVar.getUserGodInfo());
        }
        if (this.f22275h == null) {
            this.f22275h = new AntiData();
        }
        this.f22275h.parserProtobuf(cVar.GetAntiStat());
        User user = this.B;
        if (user != null) {
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.f22271d = privSets.like.intValue();
                this.f22272e = this.B.priv_sets.post.intValue();
            }
            this.f22270c = this.B.sex.intValue();
        }
        if (cVar.getTaInfo() != null) {
            this.f22269b = cVar.getTaInfo().is_friend.intValue() == 1;
        }
        this.f22274g.setIsFriend(cVar.getTaInfo().is_friend.intValue());
        if (cVar.getBookrackData() != null) {
            b.a.r0.m2.h.a aVar = new b.a.r0.m2.h.a();
            aVar.a(cVar.getBookrackData());
            this.t = new b.a.r0.m2.h.d(true, aVar);
        }
        if (!ListUtils.isEmpty(cVar.getConcernedForumList()) && !this.f22268a && !n()) {
            p(cVar.getConcernedForumList());
        }
        if (this.n == null) {
            u(this.B);
        }
        Random random = new Random();
        if (this.f22268a && !ListUtils.isEmpty(cVar.GetPostList())) {
            for (PostInfoList postInfoList : cVar.GetPostList()) {
                if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                    t(this.B, postInfoList, random);
                }
            }
        }
        String yearBytime = StringHelper.getYearBytime(System.currentTimeMillis());
        if (!ListUtils.isEmpty(cVar.getDynamicInfoList())) {
            Date date = new Date();
            String str3 = "";
            String str4 = "";
            boolean z2 = true;
            for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                    long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                    date.setTime(longValue);
                    String yearBytime2 = StringHelper.getYearBytime(longValue);
                    String chineseMonthBytime = StringHelper.getChineseMonthBytime(longValue);
                    String dateBytime = StringHelper.getDateBytime(longValue);
                    boolean z3 = !StringHelper.equals(yearBytime2, yearBytime);
                    if (StringHelper.equals(dateBytime, str3) && StringHelper.equals(chineseMonthBytime, str4) && StringHelper.equals(yearBytime2, yearBytime)) {
                        yearBytime2 = yearBytime;
                        str2 = str3;
                        str = str4;
                        z = false;
                    } else {
                        str = chineseMonthBytime;
                        str2 = dateBytime;
                        z = true;
                    }
                    int intValue = dynamicInfo.type.intValue();
                    if (intValue == 1) {
                        s(this.B, dynamicInfo, random, z3, z, z2);
                    } else if (intValue == 2) {
                        r(dynamicInfo, z);
                    } else if (intValue == 3) {
                        q(dynamicInfo, z);
                    }
                    yearBytime = yearBytime2;
                    str3 = str2;
                    str4 = str;
                    z2 = false;
                }
            }
        }
        if (this.o == null && ListUtils.isEmpty(this.p) && ListUtils.isEmpty(this.s)) {
            i iVar = new i();
            this.o = iVar;
            iVar.f22308f = this.f22270c;
            iVar.f22307e = this.f22268a;
        }
        if (this.f22268a) {
            d();
            cVar.getMaskType();
        }
        cVar.getUserAgreeInfo();
        cVar.getLiveInfo();
        this.l = cVar.getGoodsWindowInfo();
        this.m = cVar.getLiveReplayInfo();
        this.A = cVar.getNicknameInfo();
        this.E = cVar.getHotRankEntry();
        List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
        if (ListUtils.isEmpty(newestThreadList)) {
            return;
        }
        for (int i2 = 0; i2 < newestThreadList.size(); i2++) {
            d2 d2Var = new d2();
            d2Var.Y2(newestThreadList.get(i2));
            d2Var.x3(this.C);
            d2Var.e3();
            this.D.add(d2Var);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f22269b = true;
            this.f22270c = 1;
            this.f22271d = 1;
            this.f22272e = 1;
            this.f22273f = -1;
            this.f22274g = null;
            ArrayList<b.a.e.l.e.n> arrayList = this.f22276i;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.f22276i = null;
            this.j = null;
            this.k = null;
            this.n = null;
            this.o = null;
            List<b.a.e.l.e.n> list = this.p;
            if (list != null) {
                list.clear();
            }
            ArrayList<b.a.e.l.e.n> arrayList2 = this.s;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.p = null;
            this.s = null;
            this.q.clear();
            this.A = null;
            this.l = null;
            List<AlaLiveInfoCoreData> list2 = this.m;
            if (list2 != null) {
                list2.clear();
            }
            List<d2> list3 = this.D;
            if (list3 != null) {
                list3.clear();
            }
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f22269b = z;
        }
    }
}
