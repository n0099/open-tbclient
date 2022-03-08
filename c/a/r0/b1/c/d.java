package c.a.r0.b1.c;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.d1.c1;
import c.a.r0.d1.p0;
import c.a.r0.d1.t0;
import c.a.r0.d1.z0;
import c.a.r0.y3.y;
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

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f15103e;

    /* renamed from: f  reason: collision with root package name */
    public String f15104f;

    /* renamed from: g  reason: collision with root package name */
    public String f15105g;

    /* renamed from: h  reason: collision with root package name */
    public y f15106h;

    /* renamed from: i  reason: collision with root package name */
    public List<MemberGroupInfo> f15107i;

    /* renamed from: j  reason: collision with root package name */
    public MemberGodInfo f15108j;
    public ManagerApplyInfo k;
    public boolean l;
    public boolean m;
    public PriManagerApplyInfo n;
    public t0 o;
    public boolean p;
    public c1 q;
    public c.a.d.c.g.a r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
                        this.a.f15106h = forumMemberHttpResponseMessage.getUserInfo();
                        this.a.f15107i = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        this.a.f15108j = forumMemberHttpResponseMessage.getMemberGodInfo();
                        this.a.k = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        this.a.m = forumMemberHttpResponseMessage.isBawuShow();
                        this.a.l = forumMemberHttpResponseMessage.isPrivateForum();
                        this.a.n = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        this.a.f15106h = forumMemberSocketResponseMessage.getUserInfo();
                        this.a.f15107i = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        this.a.f15108j = forumMemberSocketResponseMessage.getMemberGodInfo();
                        this.a.k = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        this.a.m = forumMemberSocketResponseMessage.isBawuShow();
                        this.a.l = forumMemberSocketResponseMessage.isPrivateForum();
                        this.a.n = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                this.a.p = false;
                this.a.q.f15367e = responsedMessage.getError();
                this.a.q.f15368f = responsedMessage.getErrorString();
                this.a.q.f15369g = false;
                this.a.q.f15371i = false;
                this.a.q.f15370h = false;
                this.a.q.f16772b = this.a.f15104f;
                this.a.q.a = this.a.f15105g;
                this.a.q.f16773c = 1;
                if (this.a.o != null) {
                    t0 t0Var = this.a.o;
                    c1 c1Var = this.a.q;
                    d dVar = this.a;
                    t0Var.a(3, 0, c1Var, dVar.A(dVar.f15106h, this.a.f15107i, this.a.f15108j, this.a.k, this.a.m, this.a.l, this.a.n));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.f15106h));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    this.a.f15106h = forumMemberReadCacheResponseMessage.getUserInfo();
                    this.a.f15107i = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    this.a.f15108j = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    this.a.k = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    this.a.m = forumMemberReadCacheResponseMessage.isBawuShow();
                    this.a.l = forumMemberReadCacheResponseMessage.isPrivateForum();
                    this.a.n = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                this.a.q.f15367e = customResponsedMessage.getError();
                this.a.q.f15368f = customResponsedMessage.getErrorString();
                this.a.q.f15369g = false;
                this.a.q.f15371i = false;
                this.a.q.f15370h = false;
                this.a.q.f16772b = this.a.f15104f;
                this.a.q.a = this.a.f15105g;
                this.a.q.f16773c = 1;
                if (this.a.o != null) {
                    d dVar = this.a;
                    ArrayList<c.a.d.o.e.n> A = dVar.A(dVar.f15106h, this.a.f15107i, this.a.f15108j, this.a.k, this.a.m, this.a.l, this.a.n);
                    if (A == null || A.size() <= 0) {
                        if (!this.a.p) {
                            this.a.o.a(3, 0, this.a.q, A);
                        }
                    } else {
                        this.a.o.a(3, 0, this.a.q, A);
                    }
                }
                if (this.a.p) {
                    d dVar2 = this.a;
                    dVar2.z(c.a.d.f.m.b.g(dVar2.f15104f, 0L), this.a.f15105g);
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
        public c(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof y)) {
                this.a.q.f15367e = customResponsedMessage.getError();
                this.a.q.f15368f = customResponsedMessage.getErrorString();
                this.a.q.f15369g = false;
                this.a.q.f15371i = false;
                this.a.q.f15370h = false;
                this.a.q.f16772b = this.a.f15104f;
                this.a.q.a = this.a.f15105g;
                this.a.q.f16773c = 1;
                y yVar = (y) customResponsedMessage.getData();
                if (yVar != null && yVar.m() == 0 && this.a.f15106h != null) {
                    yVar.t(this.a.f15106h.c());
                    yVar.w(this.a.f15106h.i());
                }
                this.a.f15106h = yVar;
                if (this.a.o != null) {
                    t0 t0Var = this.a.o;
                    c1 c1Var = this.a.q;
                    d dVar = this.a;
                    t0Var.a(3, 0, c1Var, dVar.A(dVar.f15106h, this.a.f15107i, this.a.f15108j, this.a.k, this.a.m, this.a.l, this.a.n));
                }
            }
        }
    }

    /* renamed from: c.a.r0.b1.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0966d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0966d(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                d dVar = this.a;
                dVar.z(c.a.d.f.m.b.g(dVar.f15104f, 0L), this.a.f15105g);
            }
        }
    }

    public d() {
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
        this.l = false;
        this.m = false;
        this.p = true;
        this.q = new c1();
        this.r = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.s = new b(this, 2003009);
        this.t = new c(this, 2001266);
        this.u = new C0966d(this, 2001222);
    }

    public ArrayList<c.a.d.o.e.n> A(y yVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{yVar, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (yVar == null) {
                return null;
            }
            ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>();
            if (yVar.m() == 1) {
                h hVar = new h();
                hVar.i(yVar);
                hVar.g(this.f15104f);
                hVar.h(this.f15105g);
                arrayList.add(hVar);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) != null && list.get(i2).member_group_num != null && list.get(i2).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i2).member_group_list) > 0) {
                        j jVar = new j();
                        jVar.e(this.f15104f);
                        jVar.g(this.f15105g);
                        jVar.h(list.get(i2));
                        if (i2 == size - 1) {
                            jVar.i(true);
                        } else {
                            jVar.i(false);
                        }
                        arrayList.add(jVar);
                    }
                }
            }
            if (this.l) {
                if (this.m && priManagerApplyInfo != null) {
                    n nVar = new n();
                    nVar.k(priManagerApplyInfo.assist_left_num.intValue());
                    nVar.i(priManagerApplyInfo.assist_apply_url);
                    nVar.h(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(nVar);
                }
            } else {
                l lVar = new l();
                if (managerApplyInfo != null) {
                    lVar.l(managerApplyInfo.manager_left_num.intValue());
                    lVar.k(managerApplyInfo.manager_apply_url);
                    lVar.h(managerApplyInfo.assist_left_num.intValue());
                    lVar.g(managerApplyInfo.assist_apply_url);
                    lVar.i(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(lVar);
                c.a.r0.b1.c.b bVar = new c.a.r0.b1.c.b();
                bVar.f15101e = R.string.complaint_bar_lord;
                bVar.f15102f = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.f15104f;
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
        c.a.r0.b1.b.b bVar = new c.a.r0.b1.b.b();
        bVar.e(memberGodInfo);
        arrayList.add(bVar);
        boolean z = false;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            User user = list2.get(i2);
            if (user != null && user.god_data.type.intValue() == 2) {
                c.a.r0.b1.b.d dVar = new c.a.r0.b1.b.d();
                dVar.s(user, i2);
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
            c1 c1Var = this.q;
            c1Var.f15367e = 0;
            c1Var.f15369g = false;
            c1Var.f15371i = false;
            c1Var.f15370h = false;
            c1Var.f16772b = this.f15104f;
            c1Var.a = this.f15105g;
            c1Var.f16773c = 1;
            t0 t0Var = this.o;
            if (t0Var != null) {
                t0Var.a(3, 0, c1Var, A(this.f15106h, this.f15107i, this.f15108j, this.k, this.m, this.l, this.n));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.y3.g0.a.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            c.a.r0.y3.g0.a.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            c.a.r0.y3.g0.a.b(2003009, e.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f15103e = bdUniqueId;
    }

    @Override // c.a.r0.d1.p0
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // c.a.r0.d1.p0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.f15103e;
            if (bdUniqueId != null) {
                this.s.setTag(bdUniqueId);
                this.r.setTag(this.f15103e);
                this.s.setSelfListener(true);
                if (this.r.getHttpMessageListener() != null) {
                    this.r.getHttpMessageListener().setSelfListener(true);
                }
                if (this.r.getSocketMessageListener() != null) {
                    this.r.getSocketMessageListener().setSelfListener(true);
                }
            }
            MessageManager.getInstance().registerListener(this.s);
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.t);
            MessageManager.getInstance().registerListener(this.u);
        }
    }

    @Override // c.a.r0.d1.p0
    public void q(int i2, int i3, z0 z0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, z0Var) == null) && i2 == 3 && z0Var != null) {
            String str = z0Var.f16772b;
            this.f15104f = str;
            String str2 = z0Var.a;
            this.f15105g = str2;
            if (this.p) {
                y(str2);
            } else if (z0Var.f16773c == -1) {
                z(c.a.d.f.m.b.g(str, 0L), z0Var.a);
            } else {
                C();
            }
        }
    }

    @Override // c.a.r0.d1.p0
    public void t(t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t0Var) == null) {
            this.o = t0Var;
        }
    }

    public final c.a.r0.d1.n x() {
        InterceptResult invokeV;
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.f15107i;
            if (list == null || list.size() <= 0) {
                return null;
            }
            c.a.r0.d1.n nVar = new c.a.r0.d1.n();
            int i2 = c.a.d.f.p.n.i(TbadkCoreApplication.getInst().getContext());
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100);
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90);
            int f5 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);
            int size = this.f15107i.size();
            if (TbadkCoreApplication.isLogin()) {
                f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds300);
            } else {
                f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds200);
            }
            nVar.g(i2 - (((f3 + f4) + f2) + (f5 * size)));
            nVar.e(R.drawable.transparent_bg);
            return nVar;
        }
        return (c.a.r0.d1.n) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.f15103e;
            if (bdUniqueId != null) {
                forumMemberReadCacheRequestMessage.setTag(bdUniqueId);
            }
            forumMemberReadCacheRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
        }
    }

    public void z(long j2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048587, this, j2, str) == null) || j2 <= 0 || StringUtils.isNull(str)) {
            return;
        }
        ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
        BdUniqueId bdUniqueId = this.f15103e;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j2);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
