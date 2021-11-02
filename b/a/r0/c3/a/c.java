package b.a.r0.c3.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumHttpResMsg;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumReqMsg;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f15184a;

    /* renamed from: b  reason: collision with root package name */
    public int f15185b;

    /* renamed from: c  reason: collision with root package name */
    public d f15186c;

    /* renamed from: d  reason: collision with root package name */
    public b f15187d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.e.c.g.a f15188e;

    /* loaded from: classes4.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f15189a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f15189a = cVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d pageData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f15189a.f15184a) {
                if (responsedMessage instanceof ForbiddenForumHttpResMsg) {
                    pageData = ((ForbiddenForumHttpResMsg) responsedMessage).getPageData();
                } else {
                    pageData = responsedMessage instanceof ForbiddenForumSocketResMsg ? ((ForbiddenForumSocketResMsg) responsedMessage).getPageData() : null;
                }
                if (responsedMessage.getError() == 0) {
                    if (this.f15189a.f15185b == 1 && (pageData == null || ListUtils.isEmpty(pageData.f15190a))) {
                        if (this.f15189a.f15187d != null) {
                            this.f15189a.f15187d.a(null);
                        }
                    } else if (pageData != null) {
                        this.f15189a.f15186c.f15190a.addAll(pageData.f15190a);
                        if (ListUtils.isEmpty(pageData.f15190a)) {
                            this.f15189a.f15186c.f15191b = false;
                        } else {
                            this.f15189a.f15186c.f15191b = pageData.f15191b;
                            c.c(this.f15189a);
                        }
                        if (this.f15189a.f15187d != null) {
                            this.f15189a.f15187d.a(pageData);
                        }
                    }
                } else if (this.f15189a.f15187d != null) {
                    this.f15189a.f15187d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d dVar);

        void onError(int i2, String str);
    }

    public c(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15185b = 1;
        a aVar = new a(this, CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, 309692);
        this.f15188e = aVar;
        this.f15184a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f15188e);
        i();
        h();
        this.f15186c = new d();
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.f15185b;
        cVar.f15185b = i2 + 1;
        return i2;
    }

    public void f(String str) {
        d dVar;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (dVar = this.f15186c) == null || ListUtils.isEmpty(dVar.f15190a)) {
            return;
        }
        for (b.a.r0.c3.a.b bVar : this.f15186c.f15190a) {
            if (bVar != null && (str2 = bVar.f15183c) != null && str2.equals(str)) {
                this.f15186c.f15190a.remove(bVar);
                return;
            }
        }
    }

    public d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15186c : (d) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, b.a.r0.l3.f0.a.a(TbConfig.URL_GET_FORBIDDEN_FORUM, 309692));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(ForbiddenForumHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.q0.z0.b bVar = new b.a.q0.z0.b(309692);
            bVar.setResponsedClass(ForbiddenForumSocketResMsg.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ForbiddenForumReqMsg forbiddenForumReqMsg = new ForbiddenForumReqMsg();
            forbiddenForumReqMsg.pageSize = 20;
            forbiddenForumReqMsg.pageNum = this.f15185b;
            forbiddenForumReqMsg.setTag(this.f15184a);
            MessageManager.getInstance().sendMessage(forbiddenForumReqMsg);
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f15187d = bVar;
        }
    }
}
