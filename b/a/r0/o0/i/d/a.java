package b.a.r0.o0.i.d;

import androidx.core.view.InputDeviceCompat;
import b.a.r0.o0.i.c.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.model.HotUserRankHttpResMsg;
import com.baidu.tieba.enterForum.hotuserrank.model.HotUserRankReqMsg;
import com.baidu.tieba.enterForum.hotuserrank.model.HotUserRankSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f21708a;

    /* renamed from: b  reason: collision with root package name */
    public int f21709b;

    /* renamed from: c  reason: collision with root package name */
    public c f21710c;

    /* renamed from: d  reason: collision with root package name */
    public b f21711d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.e.c.g.a f21712e;

    /* renamed from: b.a.r0.o0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1062a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21713a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1062a(a aVar, int i2, int i3) {
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
            this.f21713a = aVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f21713a.f21708a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (this.f21713a.f21709b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f21700b))) {
                        if (this.f21713a.f21711d != null) {
                            this.f21713a.f21711d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        this.f21713a.f21710c.f21699a = cVar.f21699a;
                        this.f21713a.f21710c.f21700b.addAll(cVar.f21700b);
                        this.f21713a.f21710c.f21701c = cVar.f21701c;
                        this.f21713a.f21710c.f21702d = cVar.f21702d;
                        this.f21713a.f21710c.f21703e = cVar.f21703e;
                        this.f21713a.f21710c.f21704f = cVar.f21704f;
                        if (ListUtils.isEmpty(cVar.f21700b)) {
                            this.f21713a.f21710c.f21705g = false;
                        } else {
                            this.f21713a.f21710c.f21705g = cVar.f21705g;
                            a.c(this.f21713a);
                        }
                        if (this.f21713a.f21711d != null) {
                            this.f21713a.f21711d.a(cVar);
                        }
                    }
                } else if (this.f21713a.f21711d != null) {
                    this.f21713a.f21711d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(c cVar);

        void onError(int i2, String str);
    }

    public a(BdUniqueId bdUniqueId) {
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
        this.f21709b = 1;
        C1062a c1062a = new C1062a(this, CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f21712e = c1062a;
        this.f21708a = bdUniqueId;
        c1062a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f21712e);
        m();
        l();
        this.f21710c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i2 = aVar.f21709b;
        aVar.f21709b = i2 + 1;
        return i2;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21709b : invokeV.intValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21710c : (c) invokeV.objValue;
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.forumId = j;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f21709b;
            hotUserRankReqMsg.setTag(this.f21708a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.category = str;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f21709b;
            hotUserRankReqMsg.setTag(this.f21708a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21710c.f21705g : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().removeMessage(this.f21708a);
            MessageManager.getInstance().unRegisterListener(this.f21708a);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, b.a.r0.l3.f0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.q0.z0.b bVar = new b.a.q0.z0.b(309652);
            bVar.setResponsedClass(HotUserRankSocketResMsg.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void n(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f21711d = bVar;
        }
    }
}
