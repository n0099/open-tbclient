package c.a.r0.c3.a;

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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f16153a;

    /* renamed from: b  reason: collision with root package name */
    public int f16154b;

    /* renamed from: c  reason: collision with root package name */
    public d f16155c;

    /* renamed from: d  reason: collision with root package name */
    public b f16156d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.c.g.a f16157e;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f16158a;

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
            this.f16158a = cVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d pageData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f16158a.f16153a) {
                if (responsedMessage instanceof ForbiddenForumHttpResMsg) {
                    pageData = ((ForbiddenForumHttpResMsg) responsedMessage).getPageData();
                } else {
                    pageData = responsedMessage instanceof ForbiddenForumSocketResMsg ? ((ForbiddenForumSocketResMsg) responsedMessage).getPageData() : null;
                }
                if (responsedMessage.getError() == 0) {
                    if (this.f16158a.f16154b == 1 && (pageData == null || ListUtils.isEmpty(pageData.f16159a))) {
                        if (this.f16158a.f16156d != null) {
                            this.f16158a.f16156d.a(null);
                        }
                    } else if (pageData != null) {
                        this.f16158a.f16155c.f16159a.addAll(pageData.f16159a);
                        if (ListUtils.isEmpty(pageData.f16159a)) {
                            this.f16158a.f16155c.f16160b = false;
                        } else {
                            this.f16158a.f16155c.f16160b = pageData.f16160b;
                            c.c(this.f16158a);
                        }
                        if (this.f16158a.f16156d != null) {
                            this.f16158a.f16156d.a(pageData);
                        }
                    }
                } else if (this.f16158a.f16156d != null) {
                    this.f16158a.f16156d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f16154b = 1;
        a aVar = new a(this, CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, 309692);
        this.f16157e = aVar;
        this.f16153a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f16157e);
        i();
        h();
        this.f16155c = new d();
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.f16154b;
        cVar.f16154b = i2 + 1;
        return i2;
    }

    public void f(String str) {
        d dVar;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (dVar = this.f16155c) == null || ListUtils.isEmpty(dVar.f16159a)) {
            return;
        }
        for (c.a.r0.c3.a.b bVar : this.f16155c.f16159a) {
            if (bVar != null && (str2 = bVar.f16152c) != null && str2.equals(str)) {
                this.f16155c.f16159a.remove(bVar);
                return;
            }
        }
    }

    public d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16155c : (d) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, c.a.r0.k3.e0.a.a(TbConfig.URL_GET_FORBIDDEN_FORUM, 309692));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(ForbiddenForumHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.z0.b bVar = new c.a.q0.z0.b(309692);
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
            forbiddenForumReqMsg.pageNum = this.f16154b;
            forbiddenForumReqMsg.setTag(this.f16153a);
            MessageManager.getInstance().sendMessage(forbiddenForumReqMsg);
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f16156d = bVar;
        }
    }
}
