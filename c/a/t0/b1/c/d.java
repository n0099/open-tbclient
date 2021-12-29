package c.a.t0.b1.c;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.m1;
import c.a.t0.d1.p0;
import c.a.t0.d1.t0;
import c.a.t0.d1.z0;
import c.a.t0.w3.x;
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
/* loaded from: classes6.dex */
public class d implements p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f15527e;

    /* renamed from: f  reason: collision with root package name */
    public String f15528f;

    /* renamed from: g  reason: collision with root package name */
    public String f15529g;

    /* renamed from: h  reason: collision with root package name */
    public x f15530h;

    /* renamed from: i  reason: collision with root package name */
    public List<MemberGroupInfo> f15531i;

    /* renamed from: j  reason: collision with root package name */
    public MemberGodInfo f15532j;

    /* renamed from: k  reason: collision with root package name */
    public ManagerApplyInfo f15533k;
    public boolean l;
    public boolean m;
    public PriManagerApplyInfo n;
    public t0 o;
    public boolean p;
    public m1 q;
    public c.a.d.c.g.a r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;

    /* loaded from: classes6.dex */
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
                        this.a.f15530h = forumMemberHttpResponseMessage.getUserInfo();
                        this.a.f15531i = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        this.a.f15532j = forumMemberHttpResponseMessage.getMemberGodInfo();
                        this.a.f15533k = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        this.a.m = forumMemberHttpResponseMessage.isBawuShow();
                        this.a.l = forumMemberHttpResponseMessage.isPrivateForum();
                        this.a.n = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        this.a.f15530h = forumMemberSocketResponseMessage.getUserInfo();
                        this.a.f15531i = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        this.a.f15532j = forumMemberSocketResponseMessage.getMemberGodInfo();
                        this.a.f15533k = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        this.a.m = forumMemberSocketResponseMessage.isBawuShow();
                        this.a.l = forumMemberSocketResponseMessage.isPrivateForum();
                        this.a.n = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                this.a.p = false;
                this.a.q.f16566e = responsedMessage.getError();
                this.a.q.f16567f = responsedMessage.getErrorString();
                this.a.q.f16568g = false;
                this.a.q.f16570i = false;
                this.a.q.f16569h = false;
                this.a.q.f17321b = this.a.f15528f;
                this.a.q.a = this.a.f15529g;
                this.a.q.f17322c = 1;
                if (this.a.o != null) {
                    t0 t0Var = this.a.o;
                    m1 m1Var = this.a.q;
                    d dVar = this.a;
                    t0Var.a(3, 0, m1Var, dVar.A(dVar.f15530h, this.a.f15531i, this.a.f15532j, this.a.f15533k, this.a.m, this.a.l, this.a.n));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.f15530h));
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.f15530h = forumMemberReadCacheResponseMessage.getUserInfo();
                    this.a.f15531i = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    this.a.f15532j = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    this.a.f15533k = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    this.a.m = forumMemberReadCacheResponseMessage.isBawuShow();
                    this.a.l = forumMemberReadCacheResponseMessage.isPrivateForum();
                    this.a.n = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                this.a.q.f16566e = customResponsedMessage.getError();
                this.a.q.f16567f = customResponsedMessage.getErrorString();
                this.a.q.f16568g = false;
                this.a.q.f16570i = false;
                this.a.q.f16569h = false;
                this.a.q.f17321b = this.a.f15528f;
                this.a.q.a = this.a.f15529g;
                this.a.q.f17322c = 1;
                if (this.a.o != null) {
                    d dVar = this.a;
                    ArrayList<c.a.d.n.e.n> A = dVar.A(dVar.f15530h, this.a.f15531i, this.a.f15532j, this.a.f15533k, this.a.m, this.a.l, this.a.n);
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
                    dVar2.z(c.a.d.f.m.b.g(dVar2.f15528f, 0L), this.a.f15529g);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                this.a.q.f16566e = customResponsedMessage.getError();
                this.a.q.f16567f = customResponsedMessage.getErrorString();
                this.a.q.f16568g = false;
                this.a.q.f16570i = false;
                this.a.q.f16569h = false;
                this.a.q.f17321b = this.a.f15528f;
                this.a.q.a = this.a.f15529g;
                this.a.q.f17322c = 1;
                x xVar = (x) customResponsedMessage.getData();
                if (xVar != null && xVar.l() == 0 && this.a.f15530h != null) {
                    xVar.r(this.a.f15530h.c());
                    xVar.u(this.a.f15530h.i());
                }
                this.a.f15530h = xVar;
                if (this.a.o != null) {
                    t0 t0Var = this.a.o;
                    m1 m1Var = this.a.q;
                    d dVar = this.a;
                    t0Var.a(3, 0, m1Var, dVar.A(dVar.f15530h, this.a.f15531i, this.a.f15532j, this.a.f15533k, this.a.m, this.a.l, this.a.n));
                }
            }
        }
    }

    /* renamed from: c.a.t0.b1.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0958d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0958d(d dVar, int i2) {
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
                dVar.z(c.a.d.f.m.b.g(dVar.f15528f, 0L), this.a.f15529g);
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
        this.q = new m1();
        this.r = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.s = new b(this, 2003009);
        this.t = new c(this, 2001266);
        this.u = new C0958d(this, 2001222);
    }

    public ArrayList<c.a.d.n.e.n> A(x xVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{xVar, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (xVar == null) {
                return null;
            }
            ArrayList<c.a.d.n.e.n> arrayList = new ArrayList<>();
            if (xVar.l() == 1) {
                h hVar = new h();
                hVar.i(xVar);
                hVar.g(this.f15528f);
                hVar.h(this.f15529g);
                arrayList.add(hVar);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) != null && list.get(i2).member_group_num != null && list.get(i2).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i2).member_group_list) > 0) {
                        j jVar = new j();
                        jVar.e(this.f15528f);
                        jVar.g(this.f15529g);
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
                c.a.t0.b1.c.b bVar = new c.a.t0.b1.c.b();
                bVar.f15525e = R.string.complaint_bar_lord;
                bVar.f15526f = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.f15528f;
                arrayList.add(bVar);
            }
            B(memberGodInfo, arrayList);
            c.a.d.n.e.n x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<c.a.d.n.e.n> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        c.a.t0.b1.b.b bVar = new c.a.t0.b1.b.b();
        bVar.e(memberGodInfo);
        arrayList.add(bVar);
        boolean z = false;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            User user = list2.get(i2);
            if (user != null && user.god_data.type.intValue() == 2) {
                c.a.t0.b1.b.d dVar = new c.a.t0.b1.b.d();
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
            m1 m1Var = this.q;
            m1Var.f16566e = 0;
            m1Var.f16568g = false;
            m1Var.f16570i = false;
            m1Var.f16569h = false;
            m1Var.f17321b = this.f15528f;
            m1Var.a = this.f15529g;
            m1Var.f17322c = 1;
            t0 t0Var = this.o;
            if (t0Var != null) {
                t0Var.a(3, 0, m1Var, A(this.f15530h, this.f15531i, this.f15532j, this.f15533k, this.m, this.l, this.n));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.t0.w3.f0.a.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            c.a.t0.w3.f0.a.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            c.a.t0.w3.f0.a.b(2003009, e.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f15527e = bdUniqueId;
    }

    @Override // c.a.t0.d1.p0
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // c.a.t0.d1.p0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.f15527e;
            if (bdUniqueId != null) {
                this.s.setTag(bdUniqueId);
                this.r.setTag(this.f15527e);
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

    @Override // c.a.t0.d1.p0
    public void q(int i2, int i3, z0 z0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, z0Var) == null) && i2 == 3 && z0Var != null) {
            String str = z0Var.f17321b;
            this.f15528f = str;
            String str2 = z0Var.a;
            this.f15529g = str2;
            if (this.p) {
                y(str2);
            } else if (z0Var.f17322c == -1) {
                z(c.a.d.f.m.b.g(str, 0L), z0Var.a);
            } else {
                C();
            }
        }
    }

    @Override // c.a.t0.d1.p0
    public void t(t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t0Var) == null) {
            this.o = t0Var;
        }
    }

    public final c.a.t0.d1.n x() {
        InterceptResult invokeV;
        int f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.f15531i;
            if (list == null || list.size() <= 0) {
                return null;
            }
            c.a.t0.d1.n nVar = new c.a.t0.d1.n();
            int i2 = c.a.d.f.p.n.i(TbadkCoreApplication.getInst().getContext());
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100);
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90);
            int f5 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);
            int size = this.f15531i.size();
            if (TbadkCoreApplication.isLogin()) {
                f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds300);
            } else {
                f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds200);
            }
            nVar.g(i2 - (((f3 + f4) + f2) + (f5 * size)));
            nVar.e(R.drawable.transparent_bg);
            return nVar;
        }
        return (c.a.t0.d1.n) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.f15527e;
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
        BdUniqueId bdUniqueId = this.f15527e;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j2);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
