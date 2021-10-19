package c.a.r0.h1.g.f;

import c.a.e.e.p.j;
import c.a.e.l.e.n;
import c.a.r0.h1.g.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements c.a.r0.h1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f18323a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f18324b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e.c.g.a f18325c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18326d;

    /* renamed from: e  reason: collision with root package name */
    public b f18327e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, List<n>> f18328f;

    /* renamed from: c.a.r0.h1.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0890a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18329a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0890a(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f18329a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f18329a.f18326d = false;
                if (this.f18329a.f18327e == null) {
                    return;
                }
                if (!(responsedMessage instanceof c.a.r0.h1.g.e.a)) {
                    this.f18329a.f18327e.c(-1);
                } else if (responsedMessage.getOrginalMessage() == null || this.f18329a.f18324b != responsedMessage.getOrginalMessage().getTag()) {
                    this.f18329a.f18327e.c(-1);
                } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    this.f18329a.f18327e.c(responsedMessage.getError());
                } else {
                    c.a.r0.h1.g.e.a aVar = (c.a.r0.h1.g.e.a) responsedMessage;
                    if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                        this.f18329a.f18327e.c(-1);
                        return;
                    }
                    if (!StringUtils.isNull(this.f18329a.f18323a)) {
                        this.f18329a.f18328f.put(this.f18329a.f18323a, aVar.getDataList());
                    }
                    this.f18329a.f18327e.b(responsedMessage.getError(), aVar);
                }
            }
        }
    }

    public a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18324b = null;
        this.f18328f = new HashMap<>();
        this.f18327e = bVar;
        g();
    }

    @Override // c.a.r0.h1.g.a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            if (j.A() && bdUniqueId != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                if (this.f18326d) {
                    return false;
                }
                String str4 = this.f18323a;
                if (str4 != null && str4.equals(str) && this.f18328f.size() > 0) {
                    this.f18327e.setData(this.f18328f.get(str));
                    return true;
                }
                k(bdUniqueId);
                i(str);
                h(str2);
                j(str3);
                MoreTreasureTroveReqMsg moreTreasureTroveReqMsg = new MoreTreasureTroveReqMsg();
                moreTreasureTroveReqMsg.setTag(bdUniqueId);
                moreTreasureTroveReqMsg.setTabCode(str);
                moreTreasureTroveReqMsg.setLfUser(str2);
                moreTreasureTroveReqMsg.setTaskId(str3);
                boolean sendMessage = MessageManager.getInstance().sendMessage(moreTreasureTroveReqMsg);
                this.f18326d = sendMessage;
                return sendMessage;
            }
            b bVar = this.f18327e;
            if (bVar != null) {
                bVar.c(-1);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18325c = new C0890a(this, CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
            MessageManager.getInstance().registerListener(this.f18325c);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f18323a = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.f18324b = bdUniqueId;
        }
    }
}
