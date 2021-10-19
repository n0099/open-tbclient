package c.a.r0.o0.i.d;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.o0.i.c.c;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f22837a;

    /* renamed from: b  reason: collision with root package name */
    public int f22838b;

    /* renamed from: c  reason: collision with root package name */
    public c f22839c;

    /* renamed from: d  reason: collision with root package name */
    public b f22840d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.c.g.a f22841e;

    /* renamed from: c.a.r0.o0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1065a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22842a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1065a(a aVar, int i2, int i3) {
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
            this.f22842a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f22842a.f22837a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (this.f22842a.f22838b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f22829b))) {
                        if (this.f22842a.f22840d != null) {
                            this.f22842a.f22840d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        this.f22842a.f22839c.f22828a = cVar.f22828a;
                        this.f22842a.f22839c.f22829b.addAll(cVar.f22829b);
                        this.f22842a.f22839c.f22830c = cVar.f22830c;
                        this.f22842a.f22839c.f22831d = cVar.f22831d;
                        this.f22842a.f22839c.f22832e = cVar.f22832e;
                        this.f22842a.f22839c.f22833f = cVar.f22833f;
                        if (ListUtils.isEmpty(cVar.f22829b)) {
                            this.f22842a.f22839c.f22834g = false;
                        } else {
                            this.f22842a.f22839c.f22834g = cVar.f22834g;
                            a.c(this.f22842a);
                        }
                        if (this.f22842a.f22840d != null) {
                            this.f22842a.f22840d.a(cVar);
                        }
                    }
                } else if (this.f22842a.f22840d != null) {
                    this.f22842a.f22840d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f22838b = 1;
        C1065a c1065a = new C1065a(this, CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f22841e = c1065a;
        this.f22837a = bdUniqueId;
        c1065a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f22841e);
        m();
        l();
        this.f22839c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i2 = aVar.f22838b;
        aVar.f22838b = i2 + 1;
        return i2;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22838b : invokeV.intValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22839c : (c) invokeV.objValue;
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.forumId = j2;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f22838b;
            hotUserRankReqMsg.setTag(this.f22837a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.category = str;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f22838b;
            hotUserRankReqMsg.setTag(this.f22837a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22839c.f22834g : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().removeMessage(this.f22837a);
            MessageManager.getInstance().unRegisterListener(this.f22837a);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, c.a.r0.k3.e0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.z0.b bVar = new c.a.q0.z0.b(309652);
            bVar.setResponsedClass(HotUserRankSocketResMsg.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void n(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f22840d = bVar;
        }
    }
}
