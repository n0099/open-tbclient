package c.a.q0.t0.a;

import c.a.q0.t0.c.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumMember.bawu.BawuTeamHttpResponseMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoReadCacheRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamReadCacheResponseMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BawuRoleDes;
import tbclient.BawuRoleInfoPub;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BawuTeam f24505a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24506b;

    /* renamed from: c  reason: collision with root package name */
    public ManagerApplyInfo f24507c;

    /* renamed from: d  reason: collision with root package name */
    public c f24508d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.c.g.a f24509e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f24510f;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f24511a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f24511a = eVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BawuTeamHttpResponseMessage;
            if (z || (responsedMessage instanceof BawuTeamSocketResponseMessage)) {
                if (z) {
                    BawuTeamHttpResponseMessage bawuTeamHttpResponseMessage = (BawuTeamHttpResponseMessage) responsedMessage;
                    this.f24511a.f24505a = bawuTeamHttpResponseMessage.getBawuTeamInfo();
                    this.f24511a.f24506b = bawuTeamHttpResponseMessage.isPrivateForum() != 0;
                    this.f24511a.f24507c = bawuTeamHttpResponseMessage.getManagerApplyInfo();
                } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                    BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                    this.f24511a.f24505a = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                    this.f24511a.f24506b = bawuTeamSocketResponseMessage.isPrivateForum() != 0;
                    this.f24511a.f24507c = bawuTeamSocketResponseMessage.getManagerApplyInfo();
                }
                l lVar = new l();
                if (this.f24511a.f24507c != null) {
                    lVar.l(this.f24511a.f24507c.manager_left_num.intValue());
                    lVar.k(this.f24511a.f24507c.manager_apply_url);
                    lVar.h(this.f24511a.f24507c.assist_left_num.intValue());
                    lVar.g(this.f24511a.f24507c.assist_apply_url);
                }
                if (this.f24511a.f24508d != null) {
                    c cVar = this.f24511a.f24508d;
                    e eVar = this.f24511a;
                    cVar.a(eVar.j(eVar.f24505a), lVar, true, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f24512a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f24512a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
                this.f24512a.f24505a = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
                this.f24512a.f24506b = bawuTeamReadCacheResponseMessage.isPrivateForum() != 0;
                this.f24512a.f24507c = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
                l lVar = new l();
                if (this.f24512a.f24507c != null) {
                    lVar.l(this.f24512a.f24507c.manager_left_num.intValue());
                    lVar.k(this.f24512a.f24507c.manager_apply_url);
                    lVar.h(this.f24512a.f24507c.assist_left_num.intValue());
                    lVar.g(this.f24512a.f24507c.assist_apply_url);
                }
                if (this.f24512a.f24508d != null) {
                    c cVar = this.f24512a.f24508d;
                    e eVar = this.f24512a;
                    cVar.a(eVar.j(eVar.f24505a), lVar, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(ArrayList<i> arrayList, l lVar, boolean z, int i2, String str);
    }

    public e() {
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
        this.f24508d = null;
        this.f24509e = new a(this, CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);
        this.f24510f = new b(this, 2003005);
        MessageManager.getInstance().registerListener(this.f24510f);
        MessageManager.getInstance().registerListener(this.f24509e);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f24509e);
            MessageManager.getInstance().unRegisterListener(this.f24510f);
        }
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
            bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j2);
            MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
        }
    }

    public void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
            bawuTeamRequestMessage.setForumId(j2);
            MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
        }
    }

    public ArrayList<i> j(BawuTeam bawuTeam) {
        InterceptResult invokeL;
        List<BawuRoleDes> list;
        List<BawuRoleInfoPub> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bawuTeam)) == null) {
            ArrayList<i> arrayList = new ArrayList<>();
            if (bawuTeam == null || (list = bawuTeam.bawu_team_list) == null) {
                return null;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                BawuRoleDes bawuRoleDes = bawuTeam.bawu_team_list.get(i2);
                if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && (list2 = bawuRoleDes.role_info) != null && list2.size() > 0) {
                    c.a.q0.t0.a.c cVar = new c.a.q0.t0.a.c();
                    cVar.c(bawuRoleDes.role_name + "(" + bawuRoleDes.role_info.size() + SmallTailInfo.EMOTION_SUFFIX);
                    arrayList.add(cVar);
                    int size2 = bawuRoleDes.role_info.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        c.a.q0.t0.a.b bVar = new c.a.q0.t0.a.b();
                        bVar.i(bawuRoleDes.role_name);
                        ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                        arrayList2.add(bawuRoleDes.role_info.get(i3));
                        int i4 = i3 + 1;
                        if (i4 < size2) {
                            arrayList2.add(bawuRoleDes.role_info.get(i4));
                        }
                        i3 += 2;
                        if (i3 >= size2) {
                            if (this.f24506b) {
                                bVar.f(false);
                            } else {
                                bVar.f(true);
                            }
                            bVar.g(true);
                        } else {
                            bVar.g(false);
                        }
                        bVar.h(arrayList2);
                        arrayList.add(bVar);
                    }
                    if (i2 <= size - 2) {
                        arrayList.add(new c.a.q0.t0.a.a());
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void k(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f24508d = cVar;
        }
    }
}
