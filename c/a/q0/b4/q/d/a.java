package c.a.q0.b4.q.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.write.transmit.model.GetRepostForumHttpResMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumReqMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f16312a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f16313b;

    /* renamed from: c  reason: collision with root package name */
    public String f16314c;

    /* renamed from: d  reason: collision with root package name */
    public b f16315d;

    /* renamed from: e  reason: collision with root package name */
    public String f16316e;

    /* renamed from: f  reason: collision with root package name */
    public String f16317f;

    /* renamed from: g  reason: collision with root package name */
    public int f16318g;

    /* renamed from: h  reason: collision with root package name */
    public String f16319h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f16320i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.c.g.a f16321j;

    /* renamed from: c.a.q0.b4.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0776a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16322a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0776a(a aVar, int i2, int i3) {
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
            this.f16322a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || this.f16322a.f16320i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (this.f16322a.f16315d != null) {
                            this.f16322a.f16315d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        this.f16322a.f16313b = getRepostForumHttpResMessage.getForumList();
                        this.f16322a.f16314c = getRepostForumHttpResMessage.getRecommendExtension();
                        this.f16322a.f16318g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        this.f16322a.f16313b = getRepostForumSocketResMessage.getForumList();
                        this.f16322a.f16314c = getRepostForumSocketResMessage.getRecommendExtension();
                        this.f16322a.f16318g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (this.f16322a.f16315d != null) {
                        this.f16322a.f16315d.a(this.f16322a.f16313b, this.f16322a.f16318g);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(List<SimpleForum> list, int i2);

        void onError();
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
        C0776a c0776a = new C0776a(this, CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.f16321j = c0776a;
        this.f16312a = bdUniqueId;
        c0776a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f16321j);
        this.f16321j.getHttpMessageListener().setSelfListener(true);
        this.f16321j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
            getRepostForumReqMessage.setThreadTitle(this.f16316e);
            getRepostForumReqMessage.setThreadContent(this.f16317f);
            getRepostForumReqMessage.setForumId(this.f16319h);
            getRepostForumReqMessage.setTag(this.f16312a);
            getRepostForumReqMessage.setRequestId(this.f16320i);
            MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f16315d = bVar;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f16320i = bdUniqueId;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f16317f = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f16316e = str;
        }
    }
}
