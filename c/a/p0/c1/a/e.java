package c.a.p0.c1.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.c1.c.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeam a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13381b;

    /* renamed from: c  reason: collision with root package name */
    public ManagerApplyInfo f13382c;

    /* renamed from: d  reason: collision with root package name */
    public c f13383d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.c.g.a f13384e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f13385f;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = eVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BawuTeamHttpResponseMessage;
            if (z || (responsedMessage instanceof BawuTeamSocketResponseMessage)) {
                if (z) {
                    BawuTeamHttpResponseMessage bawuTeamHttpResponseMessage = (BawuTeamHttpResponseMessage) responsedMessage;
                    this.a.a = bawuTeamHttpResponseMessage.getBawuTeamInfo();
                    this.a.f13381b = bawuTeamHttpResponseMessage.isPrivateForum() != 0;
                    this.a.f13382c = bawuTeamHttpResponseMessage.getManagerApplyInfo();
                } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                    BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                    this.a.a = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                    this.a.f13381b = bawuTeamSocketResponseMessage.isPrivateForum() != 0;
                    this.a.f13382c = bawuTeamSocketResponseMessage.getManagerApplyInfo();
                }
                l lVar = new l();
                if (this.a.f13382c != null) {
                    lVar.k(this.a.f13382c.manager_left_num.intValue());
                    lVar.j(this.a.f13382c.manager_apply_url);
                    e eVar = this.a;
                    lVar.g(eVar.i(eVar.f13382c, this.a.a));
                    lVar.f(this.a.f13382c.assist_apply_url);
                }
                if (this.a.f13383d != null) {
                    c cVar = this.a.f13383d;
                    e eVar2 = this.a;
                    cVar.a(eVar2.n(eVar2.a), lVar, true, responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i)};
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
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
                this.a.a = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
                this.a.f13381b = bawuTeamReadCacheResponseMessage.isPrivateForum() != 0;
                this.a.f13382c = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
                l lVar = new l();
                if (this.a.f13382c != null) {
                    lVar.k(this.a.f13382c.manager_left_num.intValue());
                    lVar.j(this.a.f13382c.manager_apply_url);
                    e eVar = this.a;
                    lVar.g(eVar.i(eVar.f13382c, this.a.a));
                    lVar.f(this.a.f13382c.assist_apply_url);
                }
                if (this.a.f13383d != null) {
                    c cVar = this.a.f13383d;
                    e eVar2 = this.a;
                    cVar.a(eVar2.n(eVar2.a), lVar, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(ArrayList<i> arrayList, l lVar, boolean z, int i, String str);
    }

    public e() {
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
        this.f13383d = null;
        this.f13384e = new a(this, CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);
        this.f13385f = new b(this, 2003005);
        MessageManager.getInstance().registerListener(this.f13385f);
        MessageManager.getInstance().registerListener(this.f13384e);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f13384e);
            MessageManager.getInstance().unRegisterListener(this.f13385f);
        }
    }

    public final int i(@NonNull ManagerApplyInfo managerApplyInfo, @Nullable BawuTeam bawuTeam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, managerApplyInfo, bawuTeam)) == null) {
            int intValue = managerApplyInfo.assist_left_num.intValue();
            if (k(bawuTeam) && UbsABTestHelper.isFrsModifyABTestA() && intValue == 0) {
                return 10;
            }
            return intValue;
        }
        return invokeLL.intValue;
    }

    public final int j(@NonNull BawuRoleDes bawuRoleDes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bawuRoleDes)) == null) {
            int size = bawuRoleDes.role_info.size();
            if (size == 1 && UbsABTestHelper.isFrsModifyABTestA() && BawuRoleInfoPub.DEFAULT_USER_ID.equals(bawuRoleDes.role_info.get(0).user_id)) {
                return 0;
            }
            return size;
        }
        return invokeL.intValue;
    }

    public final boolean k(@Nullable BawuTeam bawuTeam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bawuTeam)) == null) {
            if (bawuTeam == null) {
                return false;
            }
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02eb);
            for (BawuRoleDes bawuRoleDes : bawuTeam.bawu_team_list) {
                if (TextUtils.equals(bawuRoleDes.role_name, string)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
            bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j);
            MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
        }
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
            bawuTeamRequestMessage.setForumId(j);
            MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
        }
    }

    public ArrayList<i> n(BawuTeam bawuTeam) {
        InterceptResult invokeL;
        List<BawuRoleInfoPub> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bawuTeam)) == null) {
            ArrayList<i> arrayList = new ArrayList<>();
            if (bawuTeam == null || bawuTeam.bawu_team_list == null) {
                return null;
            }
            ArrayList<BawuRoleDes> p = p(bawuTeam);
            int size = p.size();
            for (int i = 0; i < size; i++) {
                BawuRoleDes bawuRoleDes = p.get(i);
                if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && (list = bawuRoleDes.role_info) != null && list.size() > 0) {
                    c.a.p0.c1.a.c cVar = new c.a.p0.c1.a.c();
                    cVar.c(bawuRoleDes.role_name + "(" + j(bawuRoleDes) + SmallTailInfo.EMOTION_SUFFIX);
                    arrayList.add(cVar);
                    int size2 = bawuRoleDes.role_info.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        c.a.p0.c1.a.b bVar = new c.a.p0.c1.a.b();
                        bVar.i(bawuRoleDes.role_name);
                        ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                        arrayList2.add(bawuRoleDes.role_info.get(i2));
                        int i3 = i2 + 1;
                        if (i3 < size2) {
                            arrayList2.add(bawuRoleDes.role_info.get(i3));
                        }
                        i2 += 2;
                        if (i2 >= size2) {
                            if (this.f13381b) {
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
                    if (i <= size - 2) {
                        arrayList.add(new c.a.p0.c1.a.a());
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.f13383d = cVar;
        }
    }

    @NonNull
    public final ArrayList<BawuRoleDes> p(@NonNull BawuTeam bawuTeam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bawuTeam)) == null) {
            ArrayList<BawuRoleDes> arrayList = new ArrayList<>(bawuTeam.bawu_team_list);
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02eb);
                if (k(bawuTeam)) {
                    BawuRoleInfoPub.Builder builder = new BawuRoleInfoPub.Builder();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(builder.build(true));
                    BawuRoleDes.Builder builder2 = new BawuRoleDes.Builder();
                    builder2.role_name = string;
                    builder2.role_info = arrayList2;
                    arrayList.add(builder2.build(true));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
