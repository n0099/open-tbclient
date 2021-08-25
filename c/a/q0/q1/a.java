package c.a.q0.q1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.likedForum.GetBottleForumListHttpResMessage;
import com.baidu.tieba.likedForum.GetBottleForumListReqMessage;
import com.baidu.tieba.likedForum.GetBottleForumListSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f23893a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f23894b;

    /* renamed from: c  reason: collision with root package name */
    public b f23895c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f23896d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.c.g.a f23897e;

    /* renamed from: c.a.q0.q1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1104a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23898a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1104a(a aVar, int i2, int i3) {
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
            this.f23898a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || this.f23898a.f23896d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (this.f23898a.f23895c != null) {
                            this.f23898a.f23895c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        this.f23898a.f23894b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        this.f23898a.f23894b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (this.f23898a.f23895c != null) {
                        this.f23898a.f23895c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), this.f23898a.f23894b);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, int i2, String str, List<ForumInfo> list);
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
        this.f23895c = null;
        C1104a c1104a = new C1104a(this, CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f23897e = c1104a;
        this.f23893a = bdUniqueId;
        c1104a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f23897e);
        this.f23897e.getHttpMessageListener().setSelfListener(true);
        this.f23897e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f23897e);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
            getBottleForumListReqMessage.setTag(this.f23893a);
            getBottleForumListReqMessage.setRequestId(this.f23896d);
            MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f23895c = bVar;
        }
    }
}
