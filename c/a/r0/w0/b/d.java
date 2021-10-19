package c.a.r0.w0.b;

import c.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.message.SearchPostForumHttpResponseMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumRequestMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26486a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f26487b;

    /* renamed from: c  reason: collision with root package name */
    public b f26488c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.c.g.a f26489d;

    /* loaded from: classes4.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f26490a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f26490a = dVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage == null || responsedMessage.hasError() || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.f26490a.f26487b) {
                    if (this.f26490a.f26488c != null) {
                        this.f26490a.f26488c.a(false, null);
                        return;
                    }
                    return;
                }
                c.a.r0.w0.c.c searchData = responsedMessage instanceof SearchPostForumHttpResponseMessage ? ((SearchPostForumHttpResponseMessage) responsedMessage).getSearchData() : null;
                if (responsedMessage instanceof SearchPostForumSocketResponseMessage) {
                    searchData = ((SearchPostForumSocketResponseMessage) responsedMessage).getSearchData();
                }
                if (this.f26490a.f26488c != null) {
                    this.f26490a.f26488c.a(searchData != null, searchData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, c.a.r0.w0.c.c cVar);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.CMD_SEARCH_POST_FORUM, 309466);
        this.f26489d = aVar;
        this.f26486a = tbPageContext;
        this.f26487b = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f26489d);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.f26487b);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (!l.D()) {
            this.f26486a.showToast(R.string.neterror);
            return;
        }
        c();
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.f26487b);
        SearchPostForumRequestMessage searchPostForumRequestMessage = new SearchPostForumRequestMessage();
        searchPostForumRequestMessage.setTag(this.f26487b);
        searchPostForumRequestMessage.set_word(str);
        MessageManager.getInstance().sendMessage(searchPostForumRequestMessage);
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f26488c = bVar;
        }
    }
}
