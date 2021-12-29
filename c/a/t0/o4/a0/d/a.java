package c.a.t0.o4.a0.d;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f21513b;

    /* renamed from: c  reason: collision with root package name */
    public String f21514c;

    /* renamed from: d  reason: collision with root package name */
    public b f21515d;

    /* renamed from: e  reason: collision with root package name */
    public String f21516e;

    /* renamed from: f  reason: collision with root package name */
    public String f21517f;

    /* renamed from: g  reason: collision with root package name */
    public int f21518g;

    /* renamed from: h  reason: collision with root package name */
    public String f21519h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f21520i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.d.c.g.a f21521j;

    /* renamed from: c.a.t0.o4.a0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1300a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1300a(a aVar, int i2, int i3) {
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
            this.a = aVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || this.a.f21520i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (this.a.f21515d != null) {
                            this.a.f21515d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        this.a.f21513b = getRepostForumHttpResMessage.getForumList();
                        this.a.f21514c = getRepostForumHttpResMessage.getRecommendExtension();
                        this.a.f21518g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        this.a.f21513b = getRepostForumSocketResMessage.getForumList();
                        this.a.f21514c = getRepostForumSocketResMessage.getRecommendExtension();
                        this.a.f21518g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (this.a.f21515d != null) {
                        this.a.f21515d.a(this.a.f21513b, this.a.f21518g);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        C1300a c1300a = new C1300a(this, CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.f21521j = c1300a;
        this.a = bdUniqueId;
        c1300a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f21521j);
        this.f21521j.getHttpMessageListener().setSelfListener(true);
        this.f21521j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
            getRepostForumReqMessage.setThreadTitle(this.f21516e);
            getRepostForumReqMessage.setThreadContent(this.f21517f);
            getRepostForumReqMessage.setForumId(this.f21519h);
            getRepostForumReqMessage.setTag(this.a);
            getRepostForumReqMessage.setRequestId(this.f21520i);
            MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f21515d = bVar;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f21520i = bdUniqueId;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f21517f = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f21516e = str;
        }
    }
}
