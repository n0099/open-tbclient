package b.a.r0.v0.c;

import androidx.core.view.InputDeviceCompat;
import b.a.r0.l3.x;
import b.a.r0.x0.l1;
import b.a.r0.x0.o0;
import b.a.r0.x0.s0;
import b.a.r0.x0.y0;
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
/* loaded from: classes5.dex */
public class d implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f24265e;

    /* renamed from: f  reason: collision with root package name */
    public String f24266f;

    /* renamed from: g  reason: collision with root package name */
    public String f24267g;

    /* renamed from: h  reason: collision with root package name */
    public x f24268h;

    /* renamed from: i  reason: collision with root package name */
    public List<MemberGroupInfo> f24269i;
    public MemberGodInfo j;
    public ManagerApplyInfo k;
    public boolean l;
    public boolean m;
    public PriManagerApplyInfo n;
    public s0 o;
    public boolean p;
    public l1 q;
    public b.a.e.c.g.a r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;

    /* loaded from: classes5.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24270a;

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
            this.f24270a = dVar;
        }

        @Override // b.a.e.c.g.a
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
                        this.f24270a.f24268h = forumMemberHttpResponseMessage.getUserInfo();
                        this.f24270a.f24269i = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        this.f24270a.j = forumMemberHttpResponseMessage.getMemberGodInfo();
                        this.f24270a.k = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        this.f24270a.m = forumMemberHttpResponseMessage.isBawuShow();
                        this.f24270a.l = forumMemberHttpResponseMessage.isPrivateForum();
                        this.f24270a.n = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        this.f24270a.f24268h = forumMemberSocketResponseMessage.getUserInfo();
                        this.f24270a.f24269i = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        this.f24270a.j = forumMemberSocketResponseMessage.getMemberGodInfo();
                        this.f24270a.k = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        this.f24270a.m = forumMemberSocketResponseMessage.isBawuShow();
                        this.f24270a.l = forumMemberSocketResponseMessage.isPrivateForum();
                        this.f24270a.n = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                this.f24270a.p = false;
                this.f24270a.q.f25911e = responsedMessage.getError();
                this.f24270a.q.f25912f = responsedMessage.getErrorString();
                this.f24270a.q.f25913g = false;
                this.f24270a.q.f25915i = false;
                this.f24270a.q.f25914h = false;
                this.f24270a.q.f26788b = this.f24270a.f24266f;
                this.f24270a.q.f26787a = this.f24270a.f24267g;
                this.f24270a.q.f26789c = 1;
                if (this.f24270a.o != null) {
                    s0 s0Var = this.f24270a.o;
                    l1 l1Var = this.f24270a.q;
                    d dVar = this.f24270a;
                    s0Var.a(3, 0, l1Var, dVar.A(dVar.f24268h, this.f24270a.f24269i, this.f24270a.j, this.f24270a.k, this.f24270a.m, this.f24270a.l, this.f24270a.n));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.f24270a.f24268h));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24271a;

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
            this.f24271a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    this.f24271a.f24268h = forumMemberReadCacheResponseMessage.getUserInfo();
                    this.f24271a.f24269i = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    this.f24271a.j = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    this.f24271a.k = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    this.f24271a.m = forumMemberReadCacheResponseMessage.isBawuShow();
                    this.f24271a.l = forumMemberReadCacheResponseMessage.isPrivateForum();
                    this.f24271a.n = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                this.f24271a.q.f25911e = customResponsedMessage.getError();
                this.f24271a.q.f25912f = customResponsedMessage.getErrorString();
                this.f24271a.q.f25913g = false;
                this.f24271a.q.f25915i = false;
                this.f24271a.q.f25914h = false;
                this.f24271a.q.f26788b = this.f24271a.f24266f;
                this.f24271a.q.f26787a = this.f24271a.f24267g;
                this.f24271a.q.f26789c = 1;
                if (this.f24271a.o != null) {
                    d dVar = this.f24271a;
                    ArrayList<b.a.e.l.e.n> A = dVar.A(dVar.f24268h, this.f24271a.f24269i, this.f24271a.j, this.f24271a.k, this.f24271a.m, this.f24271a.l, this.f24271a.n);
                    if (A == null || A.size() <= 0) {
                        if (!this.f24271a.p) {
                            this.f24271a.o.a(3, 0, this.f24271a.q, A);
                        }
                    } else {
                        this.f24271a.o.a(3, 0, this.f24271a.q, A);
                    }
                }
                if (this.f24271a.p) {
                    d dVar2 = this.f24271a;
                    dVar2.z(b.a.e.e.m.b.g(dVar2.f24266f, 0L), this.f24271a.f24267g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24272a;

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
            this.f24272a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                this.f24272a.q.f25911e = customResponsedMessage.getError();
                this.f24272a.q.f25912f = customResponsedMessage.getErrorString();
                this.f24272a.q.f25913g = false;
                this.f24272a.q.f25915i = false;
                this.f24272a.q.f25914h = false;
                this.f24272a.q.f26788b = this.f24272a.f24266f;
                this.f24272a.q.f26787a = this.f24272a.f24267g;
                this.f24272a.q.f26789c = 1;
                x xVar = (x) customResponsedMessage.getData();
                if (xVar != null && xVar.l() == 0 && this.f24272a.f24268h != null) {
                    xVar.r(this.f24272a.f24268h.c());
                    xVar.u(this.f24272a.f24268h.i());
                }
                this.f24272a.f24268h = xVar;
                if (this.f24272a.o != null) {
                    s0 s0Var = this.f24272a.o;
                    l1 l1Var = this.f24272a.q;
                    d dVar = this.f24272a;
                    s0Var.a(3, 0, l1Var, dVar.A(dVar.f24268h, this.f24272a.f24269i, this.f24272a.j, this.f24272a.k, this.f24272a.m, this.f24272a.l, this.f24272a.n));
                }
            }
        }
    }

    /* renamed from: b.a.r0.v0.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1186d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24273a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1186d(d dVar, int i2) {
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
            this.f24273a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                d dVar = this.f24273a;
                dVar.z(b.a.e.e.m.b.g(dVar.f24266f, 0L), this.f24273a.f24267g);
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
        this.q = new l1();
        this.r = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.s = new b(this, 2003009);
        this.t = new c(this, 2001266);
        this.u = new C1186d(this, 2001222);
    }

    public ArrayList<b.a.e.l.e.n> A(x xVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{xVar, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (xVar == null) {
                return null;
            }
            ArrayList<b.a.e.l.e.n> arrayList = new ArrayList<>();
            if (xVar.l() == 1) {
                h hVar = new h();
                hVar.i(xVar);
                hVar.g(this.f24266f);
                hVar.h(this.f24267g);
                arrayList.add(hVar);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) != null && list.get(i2).member_group_num != null && list.get(i2).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i2).member_group_list) > 0) {
                        j jVar = new j();
                        jVar.e(this.f24266f);
                        jVar.g(this.f24267g);
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
                b.a.r0.v0.c.b bVar = new b.a.r0.v0.c.b();
                bVar.f24262e = R.string.complaint_bar_lord;
                bVar.f24263f = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.f24266f;
                arrayList.add(bVar);
            }
            B(memberGodInfo, arrayList);
            b.a.e.l.e.n x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<b.a.e.l.e.n> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        b.a.r0.v0.b.b bVar = new b.a.r0.v0.b.b();
        bVar.e(memberGodInfo);
        arrayList.add(bVar);
        boolean z = false;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            User user = list2.get(i2);
            if (user != null && user.god_data.type.intValue() == 2) {
                b.a.r0.v0.b.d dVar = new b.a.r0.v0.b.d();
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
            l1 l1Var = this.q;
            l1Var.f25911e = 0;
            l1Var.f25913g = false;
            l1Var.f25915i = false;
            l1Var.f25914h = false;
            l1Var.f26788b = this.f24266f;
            l1Var.f26787a = this.f24267g;
            l1Var.f26789c = 1;
            s0 s0Var = this.o;
            if (s0Var != null) {
                s0Var.a(3, 0, l1Var, A(this.f24268h, this.f24269i, this.j, this.k, this.m, this.l, this.n));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.r0.l3.f0.a.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            b.a.r0.l3.f0.a.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            b.a.r0.l3.f0.a.b(2003009, e.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f24265e = bdUniqueId;
    }

    @Override // b.a.r0.x0.o0
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // b.a.r0.x0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.f24265e;
            if (bdUniqueId != null) {
                this.s.setTag(bdUniqueId);
                this.r.setTag(this.f24265e);
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

    @Override // b.a.r0.x0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, y0Var) == null) && i2 == 3 && y0Var != null) {
            String str = y0Var.f26788b;
            this.f24266f = str;
            String str2 = y0Var.f26787a;
            this.f24267g = str2;
            if (this.p) {
                y(str2);
            } else if (y0Var.f26789c == -1) {
                z(b.a.e.e.m.b.g(str, 0L), y0Var.f26787a);
            } else {
                C();
            }
        }
    }

    @Override // b.a.r0.x0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s0Var) == null) {
            this.o = s0Var;
        }
    }

    public final b.a.r0.x0.n x() {
        InterceptResult invokeV;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.f24269i;
            if (list == null || list.size() <= 0) {
                return null;
            }
            b.a.r0.x0.n nVar = new b.a.r0.x0.n();
            int i2 = b.a.e.e.p.l.i(TbadkCoreApplication.getInst().getContext());
            int g3 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100);
            int g4 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90);
            int g5 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);
            int size = this.f24269i.size();
            if (TbadkCoreApplication.isLogin()) {
                g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds300);
            } else {
                g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds200);
            }
            nVar.g(i2 - (((g3 + g4) + g2) + (g5 * size)));
            nVar.e(R.drawable.transparent_bg);
            return nVar;
        }
        return (b.a.r0.x0.n) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.f24265e;
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
        BdUniqueId bdUniqueId = this.f24265e;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
