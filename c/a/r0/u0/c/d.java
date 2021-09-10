package c.a.r0.u0.c;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.j3.w;
import c.a.r0.w0.b1;
import c.a.r0.w0.o0;
import c.a.r0.w0.s0;
import c.a.r0.w0.y0;
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
    public BdUniqueId f25235e;

    /* renamed from: f  reason: collision with root package name */
    public String f25236f;

    /* renamed from: g  reason: collision with root package name */
    public String f25237g;

    /* renamed from: h  reason: collision with root package name */
    public w f25238h;

    /* renamed from: i  reason: collision with root package name */
    public List<MemberGroupInfo> f25239i;

    /* renamed from: j  reason: collision with root package name */
    public MemberGodInfo f25240j;
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
        public final /* synthetic */ d f25241a;

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
            this.f25241a = dVar;
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
                        this.f25241a.f25238h = forumMemberHttpResponseMessage.getUserInfo();
                        this.f25241a.f25239i = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                        this.f25241a.f25240j = forumMemberHttpResponseMessage.getMemberGodInfo();
                        this.f25241a.k = forumMemberHttpResponseMessage.getManagerApplyInfo();
                        this.f25241a.m = forumMemberHttpResponseMessage.isBawuShow();
                        this.f25241a.l = forumMemberHttpResponseMessage.isPrivateForum();
                        this.f25241a.n = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                    } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                        ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                        this.f25241a.f25238h = forumMemberSocketResponseMessage.getUserInfo();
                        this.f25241a.f25239i = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                        this.f25241a.f25240j = forumMemberSocketResponseMessage.getMemberGodInfo();
                        this.f25241a.k = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        this.f25241a.m = forumMemberSocketResponseMessage.isBawuShow();
                        this.f25241a.l = forumMemberSocketResponseMessage.isPrivateForum();
                        this.f25241a.n = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                    }
                }
                this.f25241a.p = false;
                this.f25241a.q.f26459e = responsedMessage.getError();
                this.f25241a.q.f26460f = responsedMessage.getErrorString();
                this.f25241a.q.f26461g = false;
                this.f25241a.q.f26463i = false;
                this.f25241a.q.f26462h = false;
                this.f25241a.q.f28026b = this.f25241a.f25236f;
                this.f25241a.q.f28025a = this.f25241a.f25237g;
                this.f25241a.q.f28027c = 1;
                if (this.f25241a.o != null) {
                    s0 s0Var = this.f25241a.o;
                    b1 b1Var = this.f25241a.q;
                    d dVar = this.f25241a;
                    s0Var.a(3, 0, b1Var, dVar.A(dVar.f25238h, this.f25241a.f25239i, this.f25241a.f25240j, this.f25241a.k, this.f25241a.m, this.f25241a.l, this.f25241a.n));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.f25241a.f25238h));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25242a;

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
            this.f25242a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    this.f25242a.f25238h = forumMemberReadCacheResponseMessage.getUserInfo();
                    this.f25242a.f25239i = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    this.f25242a.f25240j = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    this.f25242a.k = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    this.f25242a.m = forumMemberReadCacheResponseMessage.isBawuShow();
                    this.f25242a.l = forumMemberReadCacheResponseMessage.isPrivateForum();
                    this.f25242a.n = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                this.f25242a.q.f26459e = customResponsedMessage.getError();
                this.f25242a.q.f26460f = customResponsedMessage.getErrorString();
                this.f25242a.q.f26461g = false;
                this.f25242a.q.f26463i = false;
                this.f25242a.q.f26462h = false;
                this.f25242a.q.f28026b = this.f25242a.f25236f;
                this.f25242a.q.f28025a = this.f25242a.f25237g;
                this.f25242a.q.f28027c = 1;
                if (this.f25242a.o != null) {
                    d dVar = this.f25242a;
                    ArrayList<c.a.e.l.e.n> A = dVar.A(dVar.f25238h, this.f25242a.f25239i, this.f25242a.f25240j, this.f25242a.k, this.f25242a.m, this.f25242a.l, this.f25242a.n);
                    if (A == null || A.size() <= 0) {
                        if (!this.f25242a.p) {
                            this.f25242a.o.a(3, 0, this.f25242a.q, A);
                        }
                    } else {
                        this.f25242a.o.a(3, 0, this.f25242a.q, A);
                    }
                }
                if (this.f25242a.p) {
                    d dVar2 = this.f25242a;
                    dVar2.z(c.a.e.e.m.b.g(dVar2.f25236f, 0L), this.f25242a.f25237g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25243a;

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
            this.f25243a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                this.f25243a.q.f26459e = customResponsedMessage.getError();
                this.f25243a.q.f26460f = customResponsedMessage.getErrorString();
                this.f25243a.q.f26461g = false;
                this.f25243a.q.f26463i = false;
                this.f25243a.q.f26462h = false;
                this.f25243a.q.f28026b = this.f25243a.f25236f;
                this.f25243a.q.f28025a = this.f25243a.f25237g;
                this.f25243a.q.f28027c = 1;
                w wVar = (w) customResponsedMessage.getData();
                if (wVar != null && wVar.l() == 0 && this.f25243a.f25238h != null) {
                    wVar.r(this.f25243a.f25238h.c());
                    wVar.u(this.f25243a.f25238h.i());
                }
                this.f25243a.f25238h = wVar;
                if (this.f25243a.o != null) {
                    s0 s0Var = this.f25243a.o;
                    b1 b1Var = this.f25243a.q;
                    d dVar = this.f25243a;
                    s0Var.a(3, 0, b1Var, dVar.A(dVar.f25238h, this.f25243a.f25239i, this.f25243a.f25240j, this.f25243a.k, this.f25243a.m, this.f25243a.l, this.f25243a.n));
                }
            }
        }
    }

    /* renamed from: c.a.r0.u0.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1179d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25244a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1179d(d dVar, int i2) {
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
            this.f25244a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                d dVar = this.f25244a;
                dVar.z(c.a.e.e.m.b.g(dVar.f25236f, 0L), this.f25244a.f25237g);
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
        this.u = new C1179d(this, 2001222);
    }

    public ArrayList<c.a.e.l.e.n> A(w wVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{wVar, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (wVar == null) {
                return null;
            }
            ArrayList<c.a.e.l.e.n> arrayList = new ArrayList<>();
            if (wVar.l() == 1) {
                h hVar = new h();
                hVar.i(wVar);
                hVar.g(this.f25236f);
                hVar.h(this.f25237g);
                arrayList.add(hVar);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) != null && list.get(i2).member_group_num != null && list.get(i2).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i2).member_group_list) > 0) {
                        j jVar = new j();
                        jVar.d(this.f25236f);
                        jVar.g(this.f25237g);
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
                c.a.r0.u0.c.b bVar = new c.a.r0.u0.c.b();
                bVar.f25232e = R.string.complaint_bar_lord;
                bVar.f25233f = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.f25236f;
                arrayList.add(bVar);
            }
            B(memberGodInfo, arrayList);
            c.a.e.l.e.n x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<c.a.e.l.e.n> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) || memberGodInfo == null || (list = memberGodInfo.forum_god_list) == null || list.size() <= 0 || arrayList == null) {
            return;
        }
        List<User> list2 = memberGodInfo.forum_god_list;
        if (memberGodInfo.forum_god_num.intValue() == 0 || list2.size() == 0) {
            return;
        }
        c.a.r0.u0.b.b bVar = new c.a.r0.u0.b.b();
        bVar.d(memberGodInfo);
        arrayList.add(bVar);
        boolean z = false;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            User user = list2.get(i2);
            if (user != null && user.god_data.type.intValue() == 2) {
                c.a.r0.u0.b.d dVar = new c.a.r0.u0.b.d();
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
            b1Var.f26459e = 0;
            b1Var.f26461g = false;
            b1Var.f26463i = false;
            b1Var.f26462h = false;
            b1Var.f28026b = this.f25236f;
            b1Var.f28025a = this.f25237g;
            b1Var.f28027c = 1;
            s0 s0Var = this.o;
            if (s0Var != null) {
                s0Var.a(3, 0, b1Var, A(this.f25238h, this.f25239i, this.f25240j, this.k, this.m, this.l, this.n));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.j3.d0.a.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            c.a.r0.j3.d0.a.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            c.a.r0.j3.d0.a.b(2003009, e.class);
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f25235e = bdUniqueId;
    }

    @Override // c.a.r0.w0.o0
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    @Override // c.a.r0.w0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            D();
            BdUniqueId bdUniqueId = this.f25235e;
            if (bdUniqueId != null) {
                this.s.setTag(bdUniqueId);
                this.r.setTag(this.f25235e);
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

    @Override // c.a.r0.w0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, y0Var) == null) && i2 == 3 && y0Var != null) {
            String str = y0Var.f28026b;
            this.f25236f = str;
            String str2 = y0Var.f28025a;
            this.f25237g = str2;
            if (this.p) {
                y(str2);
            } else if (y0Var.f28027c == -1) {
                z(c.a.e.e.m.b.g(str, 0L), y0Var.f28025a);
            } else {
                C();
            }
        }
    }

    @Override // c.a.r0.w0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s0Var) == null) {
            this.o = s0Var;
        }
    }

    public final c.a.r0.w0.n x() {
        InterceptResult invokeV;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.f25239i;
            if (list == null || list.size() <= 0) {
                return null;
            }
            c.a.r0.w0.n nVar = new c.a.r0.w0.n();
            int i2 = c.a.e.e.p.l.i(TbadkCoreApplication.getInst().getContext());
            int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100);
            int g4 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90);
            int g5 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);
            int size = this.f25239i.size();
            if (TbadkCoreApplication.isLogin()) {
                g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds300);
            } else {
                g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds200);
            }
            nVar.g(i2 - (((g3 + g4) + g2) + (g5 * size)));
            nVar.d(R.drawable.transparent_bg);
            return nVar;
        }
        return (c.a.r0.w0.n) invokeV.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.f25235e;
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
        BdUniqueId bdUniqueId = this.f25235e;
        if (bdUniqueId != null) {
            forumMemberRequestMessage.setTag(bdUniqueId);
        }
        forumMemberRequestMessage.setForumId(j2);
        forumMemberRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
    }
}
