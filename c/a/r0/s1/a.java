package c.a.r0.s1;

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
    public BdUniqueId f24658a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f24659b;

    /* renamed from: c  reason: collision with root package name */
    public b f24660c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f24661d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.c.g.a f24662e;

    /* renamed from: c.a.r0.s1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1142a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24663a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1142a(a aVar, int i2, int i3) {
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
            this.f24663a = aVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || this.f24663a.f24661d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (this.f24663a.f24660c != null) {
                            this.f24663a.f24660c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        this.f24663a.f24659b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        this.f24663a.f24659b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (this.f24663a.f24660c != null) {
                        this.f24663a.f24660c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), this.f24663a.f24659b);
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
        this.f24660c = null;
        C1142a c1142a = new C1142a(this, CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f24662e = c1142a;
        this.f24658a = bdUniqueId;
        c1142a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f24662e);
        this.f24662e.getHttpMessageListener().setSelfListener(true);
        this.f24662e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f24662e);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
            getBottleForumListReqMessage.setTag(this.f24658a);
            getBottleForumListReqMessage.setRequestId(this.f24661d);
            MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f24660c = bVar;
        }
    }
}
