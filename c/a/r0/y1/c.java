package c.a.r0.y1;

import c.a.r0.o2.e.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personExtra.RecommendGodHttpResponseMessage;
import com.baidu.tieba.personExtra.RecommendGodReqMsg;
import com.baidu.tieba.personExtra.RecommendGodSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f29277a;

    /* renamed from: b  reason: collision with root package name */
    public q f29278b;

    /* renamed from: c  reason: collision with root package name */
    public b f29279c;

    /* renamed from: d  reason: collision with root package name */
    public int f29280d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29281e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.c.g.a f29282f;

    /* loaded from: classes4.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f29283a;

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
            this.f29283a = cVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f29283a.f29278b = null;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f29283a.f29277a) {
                    if (responsedMessage instanceof RecommendGodSocketResponseMessage) {
                        this.f29283a.f29278b = ((RecommendGodSocketResponseMessage) responsedMessage).recommendGodData;
                    } else if (responsedMessage instanceof RecommendGodHttpResponseMessage) {
                        this.f29283a.f29278b = ((RecommendGodHttpResponseMessage) responsedMessage).recommendGodData;
                    }
                    if (this.f29283a.f29278b != null) {
                        c cVar = this.f29283a;
                        cVar.f29280d = cVar.f29278b.f23240a;
                    }
                    int error = responsedMessage.getError();
                    if (error != 0 || this.f29283a.f29278b == null) {
                        error = 1;
                    } else if (ListUtils.isEmpty(this.f29283a.f29278b.f23241b)) {
                        error = this.f29283a.f29281e ? 3 : 2;
                    }
                    if (this.f29283a.f29279c != null) {
                        this.f29283a.f29279c.a(this.f29283a.f29278b, error);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(q qVar, int i2);
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
        this.f29280d = 0;
        a aVar = new a(this, CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, 309684);
        this.f29282f = aVar;
        this.f29277a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f29282f);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().removeMessage(this.f29277a);
            MessageManager.getInstance().unRegisterListener(this.f29277a);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            RecommendGodReqMsg recommendGodReqMsg = new RecommendGodReqMsg();
            recommendGodReqMsg.portrait = str;
            if (this.f29280d == 0) {
                this.f29281e = false;
            } else {
                this.f29281e = true;
            }
            recommendGodReqMsg.pageNum = this.f29280d + 1;
            recommendGodReqMsg.setTag(this.f29277a);
            MessageManager.getInstance().sendMessage(recommendGodReqMsg);
        }
    }

    public void i(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.f29280d = i2;
            h(str);
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f29279c = bVar;
        }
    }
}
