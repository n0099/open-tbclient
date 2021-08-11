package c.a.p0.t0.c;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.i3.w;
import c.a.p0.v0.b1;
import c.a.p0.v0.o0;
import c.a.p0.v0.s0;
import c.a.p0.v0.y0;
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
/* loaded from: classes3.dex */
public class d implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f24220e;

    /* renamed from: f  reason: collision with root package name */
    public String f24221f;

    /* renamed from: g  reason: collision with root package name */
    public String f24222g;

    /* renamed from: h  reason: collision with root package name */
    public w f24223h;

    /* renamed from: i  reason: collision with root package name */
    public List<MemberGroupInfo> f24224i;

    /* renamed from: j  reason: collision with root package name */
    public MemberGodInfo f24225j;
    public ManagerApplyInfo k;
    public boolean l;
    public boolean m;
    public PriManagerApplyInfo n;
    public s0 o;
    public boolean p;
    public b1 q;
    public c.a.e.c.g.a r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public CustomMessageListener u;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24226a;

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
            this.f24226a = dVar;
        }

        @Override // c.a.e.c.g.a
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
                        this.f24226a.f24223h = forumMemberHttpResponseMessage.getUserInfo();
                        this.f24226a.f24224i = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        this.f24226a.f24225j = forumMemberHttpResponseMessage.getMemberGodInfo();
                        this.f24226a.k = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        this.f24226a.m = forumMemberHttpResponseMessage.isBawuShow();
                        this.f24226a.l = forumMemberHttpResponseMessage.isPrivateForum();
                        this.f24226a.n = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        this.f24226a.f24223h = forumMemberSocketResponseMessage.getUserInfo();
                        this.f24226a.f24224i = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        this.f24226a.f24225j = forumMemberSocketResponseMessage.getMemberGodInfo();
                        this.f24226a.k = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        this.f24226a.m = forumMemberSocketResponseMessage.isBawuShow();
                        this.f24226a.l = forumMemberSocketResponseMessage.isPrivateForum();
                        this.f24226a.n = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                this.f24226a.p = false;
                this.f24226a.q.f25532e = responsedMessage.getError();
                this.f24226a.q.f25533f = responsedMessage.getErrorString();
                this.f24226a.q.f25534g = false;
                this.f24226a.q.f25536i = false;
                this.f24226a.q.f25535h = false;
                this.f24226a.q.f27037b = this.f24226a.f24221f;
                this.f24226a.q.f27036a = this.f24226a.f24222g;
                this.f24226a.q.f27038c = 1;
                if (this.f24226a.o != null) {
                    s0 s0Var = this.f24226a.o;
                    b1 b1Var = this.f24226a.q;
                    d dVar = this.f24226a;
                    s0Var.a(3, 0, b1Var, dVar.A(dVar.f24223h, this.f24226a.f24224i, this.f24226a.f24225j, this.f24226a.k, this.f24226a.m, this.f24226a.l, this.f24226a.n));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.f24226a.f24223h));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24227a;

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
            this.f24227a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    this.f24227a.f24223h = forumMemberReadCacheResponseMessage.getUserInfo();
                    this.f24227a.f24224i = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    this.f24227a.f24225j = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    this.f24227a.k = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    this.f24227a.m = forumMemberReadCacheResponseMessage.isBawuShow();
                    this.f24227a.l = forumMemberReadCacheResponseMessage.isPrivateForum();
                    this.f24227a.n = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                this.f24227a.q.f25532e = customResponsedMessage.getError();
                this.f24227a.q.f25533f = customResponsedMessage.getErrorString();
                this.f24227a.q.f25534g = false;
                this.f24227a.q.f25536i = false;
                this.f24227a.q.f25535h = false;
                this.f24227a.q.f27037b = this.f24227a.f24221f;
                this.f24227a.q.f27036a = this.f24227a.f24222g;
                this.f24227a.q.f27038c = 1;
                if (this.f24227a.o != null) {
                    d dVar = this.f24227a;
                    ArrayList<c.a.e.k.e.n> A = dVar.A(dVar.f24223h, this.f24227a.f24224i, this.f24227a.f24225j, this.f24227a.k, this.f24227a.m, this.f24227a.l, this.f24227a.n);
                    if (A == null || A.size() <= 0) {
                        if (!this.f24227a.p) {
                            this.f24227a.o.a(3, 0, this.f24227a.q, A);
                        }
                    } else {
                        this.f24227a.o.a(3, 0, this.f24227a.q, A);
                    }
                }
                if (this.f24227a.p) {
                    d dVar2 = this.f24227a;
                    dVar2.z(c.a.e.e.m.b.f(dVar2.f24221f, 0L), this.f24227a.f24222g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24228a;

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
            this.f24228a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                this.f24228a.q.f25532e = customResponsedMessage.getError();
                this.f24228a.q.f25533f = customResponsedMessage.getErrorString();
                this.f24228a.q.f25534g = false;
                this.f24228a.q.f25536i = false;
                this.f24228a.q.f25535h = false;
                this.f24228a.q.f27037b = this.f24228a.f24221f;
                this.f24228a.q.f27036a = this.f24228a.f24222g;
                this.f24228a.q.f27038c = 1;
                w wVar = (w) customResponsedMessage.getData();
                if (wVar != null && wVar.l() == 0 && this.f24228a.f24223h != null) {
                    wVar.r(this.f24228a.f24223h.c());
                    wVar.u(this.f24228a.f24223h.i());
                }
                this.f24228a.f24223h = wVar;
                if (this.f24228a.o != null) {
                    s0 s0Var = this.f24228a.o;
                    b1 b1Var = this.f24228a.q;
                    d dVar = this.f24228a;
                    s0Var.a(3, 0, b1Var, dVar.A(dVar.f24223h, this.f24228a.f24224i, this.f24228a.f24225j, this.f24228a.k, this.f24228a.m, this.f24228a.l, this.f24228a.n));
                }
            }
        }
    }

    /* renamed from: c.a.p0.t0.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1125d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24229a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1125d(d dVar, int i2) {
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
            this.f24229a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                d dVar = this.f24229a;
                dVar.z(c.a.e.e.m.b.f(dVar.f24221f, 0L), this.f24229a.f24222g);
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
        this.q = new b1();
        this.r = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.s = new b(this, 2003009);
        this.t = new c(this, 2001266);
        this.u = new C1125d(this, 2001222);
    }

    public ArrayList<c.a.e.k.e.n> A(w wVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{wVar, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (wVar == null) {
                return null;
            }
            ArrayList<c.a.e.k.e.n> arrayList = new ArrayList<>();
            if (wVar.l() == 1) {
                h hVar = new h();
                hVar.i(wVar);
                hVar.g(this.f24221f);
                hVar.h(this.f24222g);
                arrayList.add(hVar);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) != null && list.get(i2).member_group_num != null && list.get(i2).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i2).member_group_list) > 0) {
                        j jVar = new j();
                        jVar.d(this.f24221f);
                        jVar.g(this.f24222g);
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
                c.a.p0.t0.c.b bVar = new c.a.p0.t0.c.b();
                bVar.f24217e = R.string.complaint_bar_lord;
                bVar.f24218f = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.f24221f;
                arrayList.add(bVar);
            }
            B(memberGodInfo, arrayList);
            c.a.e.k.e.n x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<c.a.e.k.e.n> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        c.a.p0.t0.b.b bVar = new c.a.p0.t0.b.b();
        bVar.d(memberGodInfo);
        arrayList.add(bVar);
        boolean z = false;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            User user = list2.get(i2);
            if (user != null && user.god_data.type.intValue() == 2) {
                c.a.p0.t0.b.d dVar = new c.a.p0.t0.b.d();
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
            b1 b1Var = this.q;
            b1Var.f25532e = 0;
            b1Var.f25534g = false;
            b1Var.f25536i = false;
            b1Var.f25535h = false;
            b1Var.f27037b = this.f24221f;
            b1Var.f27036a = this.f24222g;
            b1Var.f27038c = 1;
            s0 s0Var = this.o;
            if (s0Var != null) {
                s0Var.a(3, 0, b1Var, A(this.f24223h, this.f24224i, this.f24225j, this.k, this.m, this.l, this.n));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.i3.d0.a.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            c.a.p0.i3.d0.a.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            c.a.p0.i3.d0.a.b(2003009, e.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f24220e = bdUniqueId;
    }

    @Override // c.a.p0.v0.o0
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // c.a.p0.v0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.f24220e;
            if (bdUniqueId != null) {
                this.s.setTag(bdUniqueId);
                this.r.setTag(this.f24220e);
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

    @Override // c.a.p0.v0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, y0Var) == null) && i2 == 3 && y0Var != null) {
            String str = y0Var.f27037b;
            this.f24221f = str;
            String str2 = y0Var.f27036a;
            this.f24222g = str2;
            if (this.p) {
                y(str2);
            } else if (y0Var.f27038c == -1) {
                z(c.a.e.e.m.b.f(str, 0L), y0Var.f27036a);
            } else {
                C();
            }
        }
    }

    @Override // c.a.p0.v0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s0Var) == null) {
            this.o = s0Var;
        }
    }

    public final c.a.p0.v0.n x() {
        InterceptResult invokeV;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.f24224i;
            if (list == null || list.size() <= 0) {
                return null;
            }
            c.a.p0.v0.n nVar = new c.a.p0.v0.n();
            int i2 = c.a.e.e.p.l.i(TbadkCoreApplication.getInst().getContext());
            int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100);
            int g4 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90);
            int g5 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);
            int size = this.f24224i.size();
            if (TbadkCoreApplication.isLogin()) {
                g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds300);
            } else {
                g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds200);
            }
            nVar.g(i2 - (((g3 + g4) + g2) + (g5 * size)));
            nVar.d(R.drawable.transparent_bg);
            return nVar;
        }
        return (c.a.p0.v0.n) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.f24220e;
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
        BdUniqueId bdUniqueId = this.f24220e;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j2);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
