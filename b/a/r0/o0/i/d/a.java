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
    public BdUniqueId f23207a;

    /* renamed from: b  reason: collision with root package name */
    public int f23208b;

    /* renamed from: c  reason: collision with root package name */
    public c f23209c;

    /* renamed from: d  reason: collision with root package name */
    public b f23210d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.e.c.g.a f23211e;

    /* renamed from: b.a.r0.o0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1130a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23212a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1130a(a aVar, int i2, int i3) {
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
            this.f23212a = aVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f23212a.f23207a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (this.f23212a.f23208b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f23199b))) {
                        if (this.f23212a.f23210d != null) {
                            this.f23212a.f23210d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        this.f23212a.f23209c.f23198a = cVar.f23198a;
                        this.f23212a.f23209c.f23199b.addAll(cVar.f23199b);
                        this.f23212a.f23209c.f23200c = cVar.f23200c;
                        this.f23212a.f23209c.f23201d = cVar.f23201d;
                        this.f23212a.f23209c.f23202e = cVar.f23202e;
                        this.f23212a.f23209c.f23203f = cVar.f23203f;
                        if (ListUtils.isEmpty(cVar.f23199b)) {
                            this.f23212a.f23209c.f23204g = false;
                        } else {
                            this.f23212a.f23209c.f23204g = cVar.f23204g;
                            a.c(this.f23212a);
                        }
                        if (this.f23212a.f23210d != null) {
                            this.f23212a.f23210d.a(cVar);
                        }
                    }
                } else if (this.f23212a.f23210d != null) {
                    this.f23212a.f23210d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
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
        this.f23208b = 1;
        C1130a c1130a = new C1130a(this, CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f23211e = c1130a;
        this.f23207a = bdUniqueId;
        c1130a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f23211e);
        m();
        l();
        this.f23209c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i2 = aVar.f23208b;
        aVar.f23208b = i2 + 1;
        return i2;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23208b : invokeV.intValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23209c : (c) invokeV.objValue;
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.forumId = j;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f23208b;
            hotUserRankReqMsg.setTag(this.f23207a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.category = str;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f23208b;
            hotUserRankReqMsg.setTag(this.f23207a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23209c.f23204g : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().removeMessage(this.f23207a);
            MessageManager.getInstance().unRegisterListener(this.f23207a);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, b.a.r0.m3.f0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.q0.y0.b bVar = new b.a.q0.y0.b(309652);
            bVar.setResponsedClass(HotUserRankSocketResMsg.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void n(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f23210d = bVar;
        }
    }
}
