package c.a.p0.c1.c;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.a4.y;
import c.a.p0.f1.c1;
import c.a.p0.f1.p0;
import c.a.p0.f1.t0;
import c.a.p0.f1.z0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.ForumMemberHttpResponseMessage;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheRequestMessage;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheResponseMessage;
import com.baidu.tieba.forumMember.member.ForumMemberRequestMessage;
import com.baidu.tieba.forumMember.member.ForumMemberSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class d implements p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public String f13412b;

    /* renamed from: c  reason: collision with root package name */
    public String f13413c;

    /* renamed from: d  reason: collision with root package name */
    public y f13414d;

    /* renamed from: e  reason: collision with root package name */
    public List<MemberGroupInfo> f13415e;

    /* renamed from: f  reason: collision with root package name */
    public MemberGodInfo f13416f;

    /* renamed from: g  reason: collision with root package name */
    public ManagerApplyInfo f13417g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13418h;
    public boolean i;
    public PriManagerApplyInfo j;
    public t0 k;
    public boolean l;
    public c1 m;
    public c.a.d.c.g.a n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ForumMemberHttpResponseMessage;
            if (z || (responsedMessage instanceof ForumMemberSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        ForumMemberHttpResponseMessage forumMemberHttpResponseMessage = (ForumMemberHttpResponseMessage) responsedMessage;
                        this.a.f13414d = forumMemberHttpResponseMessage.getUserInfo();
                        this.a.f13415e = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        this.a.f13416f = forumMemberHttpResponseMessage.getMemberGodInfo();
                        this.a.f13417g = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        this.a.i = forumMemberHttpResponseMessage.isBawuShow();
                        this.a.f13418h = forumMemberHttpResponseMessage.isPrivateForum();
                        this.a.j = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        this.a.f13414d = forumMemberSocketResponseMessage.getUserInfo();
                        this.a.f13415e = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        this.a.f13416f = forumMemberSocketResponseMessage.getMemberGodInfo();
                        this.a.f13417g = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        this.a.i = forumMemberSocketResponseMessage.isBawuShow();
                        this.a.f13418h = forumMemberSocketResponseMessage.isPrivateForum();
                        this.a.j = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                this.a.l = false;
                this.a.m.f13864e = responsedMessage.getError();
                this.a.m.f13865f = responsedMessage.getErrorString();
                this.a.m.f13866g = false;
                this.a.m.i = false;
                this.a.m.f13867h = false;
                this.a.m.f14892b = this.a.f13412b;
                this.a.m.a = this.a.f13413c;
                this.a.m.f14893c = 1;
                if (this.a.k != null) {
                    t0 t0Var = this.a.k;
                    c1 c1Var = this.a.m;
                    d dVar = this.a;
                    t0Var.a(3, 0, c1Var, dVar.A(dVar.f13414d, this.a.f13415e, this.a.f13416f, this.a.f13417g, this.a.i, this.a.f13418h, this.a.j));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.f13414d));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    this.a.f13414d = forumMemberReadCacheResponseMessage.getUserInfo();
                    this.a.f13415e = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    this.a.f13416f = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    this.a.f13417g = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    this.a.i = forumMemberReadCacheResponseMessage.isBawuShow();
                    this.a.f13418h = forumMemberReadCacheResponseMessage.isPrivateForum();
                    this.a.j = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                this.a.m.f13864e = customResponsedMessage.getError();
                this.a.m.f13865f = customResponsedMessage.getErrorString();
                this.a.m.f13866g = false;
                this.a.m.i = false;
                this.a.m.f13867h = false;
                this.a.m.f14892b = this.a.f13412b;
                this.a.m.a = this.a.f13413c;
                this.a.m.f14893c = 1;
                if (this.a.k != null) {
                    d dVar = this.a;
                    ArrayList<c.a.d.o.e.n> A = dVar.A(dVar.f13414d, this.a.f13415e, this.a.f13416f, this.a.f13417g, this.a.i, this.a.f13418h, this.a.j);
                    if (A == null || A.size() <= 0) {
                        if (!this.a.l) {
                            this.a.k.a(3, 0, this.a.m, A);
                        }
                    } else {
                        this.a.k.a(3, 0, this.a.m, A);
                    }
                }
                if (this.a.l) {
                    d dVar2 = this.a;
                    dVar2.z(c.a.d.f.m.b.g(dVar2.f13412b, 0L), this.a.f13413c);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                this.a.m.f13864e = customResponsedMessage.getError();
                this.a.m.f13865f = customResponsedMessage.getErrorString();
                this.a.m.f13866g = false;
                this.a.m.i = false;
                this.a.m.f13867h = false;
                this.a.m.f14892b = this.a.f13412b;
                this.a.m.a = this.a.f13413c;
                this.a.m.f14893c = 1;
                y yVar = (y) customResponsedMessage.getData();
                if (yVar != null && yVar.n() == 0 && this.a.f13414d != null) {
                    yVar.u(this.a.f13414d.c());
                    yVar.x(this.a.f13414d.i());
                }
                this.a.f13414d = yVar;
                if (this.a.k != null) {
                    t0 t0Var = this.a.k;
                    c1 c1Var = this.a.m;
                    d dVar = this.a;
                    t0Var.a(3, 0, c1Var, dVar.A(dVar.f13414d, this.a.f13415e, this.a.f13416f, this.a.f13417g, this.a.i, this.a.f13418h, this.a.j));
                }
            }
        }
    }

    /* renamed from: c.a.p0.c1.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1012d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1012d(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                d dVar = this.a;
                dVar.z(c.a.d.f.m.b.g(dVar.f13412b, 0L), this.a.f13413c);
            }
        }
    }

    public d() {
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
        this.f13418h = false;
        this.i = false;
        this.l = true;
        this.m = new c1();
        this.n = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.o = new b(this, 2003009);
        this.p = new c(this, 2001266);
        this.q = new C1012d(this, 2001222);
    }

    public ArrayList<c.a.d.o.e.n> A(y yVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{yVar, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (yVar == null) {
                return null;
            }
            ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>();
            if (yVar.n() == 1) {
                h hVar = new h();
                hVar.i(yVar);
                hVar.f(this.f13412b);
                hVar.g(this.f13413c);
                arrayList.add(hVar);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i).member_group_list) > 0) {
                        j jVar = new j();
                        jVar.e(this.f13412b);
                        jVar.f(this.f13413c);
                        jVar.g(list.get(i));
                        if (i == size - 1) {
                            jVar.i(true);
                        } else {
                            jVar.i(false);
                        }
                        arrayList.add(jVar);
                    }
                }
            }
            if (this.f13418h) {
                if (this.i && priManagerApplyInfo != null) {
                    n nVar = new n();
                    nVar.j(priManagerApplyInfo.assist_left_num.intValue());
                    nVar.i(priManagerApplyInfo.assist_apply_url);
                    nVar.g(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(nVar);
                }
            } else {
                l lVar = new l();
                if (managerApplyInfo != null) {
                    lVar.k(managerApplyInfo.manager_left_num.intValue());
                    lVar.j(managerApplyInfo.manager_apply_url);
                    lVar.g(managerApplyInfo.assist_left_num.intValue());
                    lVar.f(managerApplyInfo.assist_apply_url);
                    lVar.i(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(lVar);
                c.a.p0.c1.c.b bVar = new c.a.p0.c1.c.b();
                bVar.a = R.string.obfuscated_res_0x7f0f040b;
                bVar.f13411b = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.f13412b;
                arrayList.add(bVar);
            }
            B(memberGodInfo, arrayList);
            c.a.d.o.e.n x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<c.a.d.o.e.n> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        c.a.p0.c1.b.b bVar = new c.a.p0.c1.b.b();
        bVar.e(memberGodInfo);
        arrayList.add(bVar);
        boolean z = false;
        for (int i = 0; i < list2.size(); i++) {
            User user = list2.get(i);
            if (user != null && user.god_data.type.intValue() == 2) {
                c.a.p0.c1.b.d dVar = new c.a.p0.c1.b.d();
                dVar.r(user, i);
                arrayList.add(dVar);
                if (!z) {
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        arrayList.remove(bVar);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c1 c1Var = this.m;
            c1Var.f13864e = 0;
            c1Var.f13866g = false;
            c1Var.i = false;
            c1Var.f13867h = false;
            c1Var.f14892b = this.f13412b;
            c1Var.a = this.f13413c;
            c1Var.f14893c = 1;
            t0 t0Var = this.k;
            if (t0Var != null) {
                t0Var.a(3, 0, c1Var, A(this.f13414d, this.f13415e, this.f13416f, this.f13417g, this.i, this.f13418h, this.j));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.a4.g0.a.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            c.a.p0.a4.g0.a.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            c.a.p0.a4.g0.a.b(2003009, e.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    @Override // c.a.p0.f1.p0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // c.a.p0.f1.p0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.o.setTag(bdUniqueId);
                this.n.setTag(this.a);
                this.o.setSelfListener(true);
                if (this.n.getHttpMessageListener() != null) {
                    this.n.getHttpMessageListener().setSelfListener(true);
                }
                if (this.n.getSocketMessageListener() != null) {
                    this.n.getSocketMessageListener().setSelfListener(true);
                }
            }
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.n);
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.q);
        }
    }

    @Override // c.a.p0.f1.p0
    public void s(int i, int i2, z0 z0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, z0Var) == null) && i == 3 && z0Var != null) {
            String str = z0Var.f14892b;
            this.f13412b = str;
            String str2 = z0Var.a;
            this.f13413c = str2;
            if (this.l) {
                y(str2);
            } else if (z0Var.f14893c == -1) {
                z(c.a.d.f.m.b.g(str, 0L), z0Var.a);
            } else {
                C();
            }
        }
    }

    @Override // c.a.p0.f1.p0
    public void v(t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t0Var) == null) {
            this.k = t0Var;
        }
    }

    public final c.a.p0.f1.n x() {
        InterceptResult invokeV;
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.f13415e;
            if (list == null || list.size() <= 0) {
                return null;
            }
            c.a.p0.f1.n nVar = new c.a.p0.f1.n();
            int i = c.a.d.f.p.n.i(TbadkCoreApplication.getInst().getContext());
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07019a);
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070301);
            int f5 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070297);
            int size = this.f13415e.size();
            if (TbadkCoreApplication.isLogin()) {
                f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070292);
            } else {
                f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070263);
            }
            nVar.f(i - (((f3 + f4) + f2) + (f5 * size)));
            nVar.e(R.drawable.obfuscated_res_0x7f081200);
            return nVar;
        }
        return (c.a.p0.f1.n) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                forumMemberReadCacheRequestMessage.setTag(bdUniqueId);
            }
            forumMemberReadCacheRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
        }
    }

    public void z(long j, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048587, this, j, str) == null) || j <= 0 || StringUtils.isNull(str)) {
            return;
        }
        ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
        BdUniqueId bdUniqueId = this.a;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
