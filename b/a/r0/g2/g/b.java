package b.a.r0.g2.g;

import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.r0.g2.c.f;
import b.a.r0.g2.c.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.InterestCommitHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumReqMsg;
import com.baidu.tieba.newinterest.data.InterestedForumSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f16793a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f16794b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f16795c;

    /* renamed from: d  reason: collision with root package name */
    public d f16796d;

    /* renamed from: e  reason: collision with root package name */
    public c f16797e;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a.r0.g2.c.b> f16798f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16799g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.c.g.a f16800h;

    /* renamed from: i  reason: collision with root package name */
    public HttpMessageListener f16801i;

    /* loaded from: classes4.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16802a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f16802a = bVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f16802a.f16799g = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f16802a.f16794b) {
                    b.a.r0.g2.c.c cVar = null;
                    if (responsedMessage instanceof InterestedForumHttpResMsg) {
                        cVar = ((InterestedForumHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof InterestedForumSocketResMsg) {
                        cVar = ((InterestedForumSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() != 0) {
                        if (this.f16802a.f16796d != null) {
                            this.f16802a.f16796d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                        }
                    } else if (cVar == null || ListUtils.isEmpty(cVar.f16774a)) {
                        if (this.f16802a.f16796d != null) {
                            this.f16802a.f16796d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar == null || this.f16802a.f16796d == null) {
                    } else {
                        b.c(this.f16802a);
                        this.f16802a.f16796d.c(cVar);
                    }
                }
            }
        }
    }

    /* renamed from: b.a.r0.g2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0868b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16803a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0868b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16803a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            if ((httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == this.f16803a.f16794b) && (httpResponsedMessage instanceof InterestCommitHttpResMsg)) {
                InterestCommitHttpResMsg interestCommitHttpResMsg = (InterestCommitHttpResMsg) httpResponsedMessage;
                if (interestCommitHttpResMsg.hasError() || interestCommitHttpResMsg.getErrno() != 0) {
                    if (this.f16803a.f16796d != null) {
                        this.f16803a.f16796d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (this.f16803a.f16797e != null) {
                    this.f16803a.f16797e.b();
                }
                b.a.q0.s.e0.b.j().w("key_select_interest_flag", System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void b();
    }

    /* loaded from: classes4.dex */
    public interface d {
        void c(b.a.r0.g2.c.c cVar);

        void onError(int i2, String str);
    }

    public b(BdUniqueId bdUniqueId) {
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
        this.f16795c = new Gson();
        this.f16799g = false;
        this.f16800h = new a(this, CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);
        this.f16801i = new C0868b(this, CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        this.f16794b = bdUniqueId;
        this.f16800h.setTag(bdUniqueId);
        this.f16801i.setTag(this.f16794b);
        MessageManager.getInstance().registerListener(this.f16800h);
        MessageManager.getInstance().registerListener(this.f16801i);
        o();
        n();
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f16793a;
        bVar.f16793a = i2 + 1;
        return i2;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT, TbConfig.SERVER_ADDRESS + TbConfig.GUIDE_INTEREST_COMMIT_URL);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(InterestCommitHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void e() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            try {
                str = URLEncoder.encode(h(), "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                str = null;
            }
            httpMessage.addParam("interestList", str);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(this.f16794b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void f(List<b.a.r0.g2.c.a> list) throws UnsupportedEncodingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            String encode = URLEncoder.encode(j(list), "utf-8");
            if (b.a.q0.b.d.o() && !TbadkCoreApplication.isLogin()) {
                b.a.q0.s.e0.b.j().x("user_interest_info", encode);
            }
            httpMessage.addParam("interestList", encode);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(this.f16794b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void g(List<n> list) throws UnsupportedEncodingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            String encode = URLEncoder.encode(k(list), "utf-8");
            if (b.a.q0.b.d.o() && !TbadkCoreApplication.isLogin()) {
                b.a.q0.s.e0.b.j().x("user_interest_info", encode);
            }
            httpMessage.addParam("interestList", encode);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(this.f16794b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap hashMap = new HashMap();
            if (!ListUtils.isEmpty(this.f16798f)) {
                for (b.a.r0.g2.c.b bVar : this.f16798f) {
                    if (bVar != null) {
                        hashMap.put(bVar.f(), new HashMap());
                    }
                }
            }
            return this.f16795c.toJson(hashMap);
        }
        return (String) invokeV.objValue;
    }

    public final List<Integer> i(List<b.a.r0.g2.c.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (b.a.r0.g2.c.b bVar : list) {
                    arrayList.add(Integer.valueOf(bVar.e()));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final String j(List<b.a.r0.g2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            HashMap hashMap = new HashMap();
            for (b.a.r0.g2.c.a aVar : list) {
                HashMap hashMap2 = new HashMap();
                for (g gVar : aVar.f16762a) {
                    if (gVar.f16788b) {
                        RecommendForumInfo recommendForumInfo = gVar.f16787a;
                        hashMap2.put(recommendForumInfo.forum_id, recommendForumInfo.forum_name);
                    }
                }
                hashMap.put(aVar.f16764c, hashMap2);
            }
            if (!ListUtils.isEmpty(this.f16798f)) {
                for (b.a.r0.g2.c.b bVar : this.f16798f) {
                    if (bVar != null && !hashMap.containsKey(bVar.f())) {
                        hashMap.put(bVar.f(), new HashMap());
                    }
                }
            }
            return this.f16795c.toJson(hashMap);
        }
        return (String) invokeL.objValue;
    }

    public final String k(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = null;
            String str = "";
            for (n nVar : list) {
                if (nVar instanceof f) {
                    if (!StringUtils.isNull(str)) {
                        hashMap.put(str, hashMap2);
                    }
                    hashMap2 = new HashMap();
                    str = ((f) nVar).d();
                } else if (nVar instanceof b.a.r0.g2.c.d) {
                    b.a.r0.g2.c.d dVar = (b.a.r0.g2.c.d) nVar;
                    if (dVar.l() && hashMap2 != null) {
                        hashMap2.put(Long.valueOf(dVar.e()), dVar.g());
                    }
                }
            }
            if (!StringUtils.isNull(str)) {
                hashMap.put(str, hashMap2);
            }
            if (!ListUtils.isEmpty(this.f16798f)) {
                for (b.a.r0.g2.c.b bVar : this.f16798f) {
                    if (bVar != null && !hashMap.containsKey(bVar.f())) {
                        hashMap.put(bVar.f(), new HashMap());
                    }
                }
            }
            return this.f16795c.toJson(hashMap);
        }
        return (String) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            InterestedForumReqMsg interestedForumReqMsg = new InterestedForumReqMsg();
            List<b.a.r0.g2.c.b> list = this.f16798f;
            if (list == null) {
                interestedForumReqMsg.classidList = i(null);
            } else {
                interestedForumReqMsg.classidList = i(list.subList((this.f16793a - 1) * 3, Math.min(list.size(), this.f16793a * 3)));
            }
            interestedForumReqMsg.setTag(this.f16794b);
            this.f16799g = true;
            MessageManager.getInstance().sendMessage(interestedForumReqMsg);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.f16793a - 1) * 3 < this.f16798f.size() : invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, b.a.r0.l3.f0.a.a(TbConfig.GUIDE_INTERESTED_FORUM_URL, 309654));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(InterestedForumHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b.a.q0.z0.b bVar = new b.a.q0.z0.b(309654);
            bVar.setResponsedClass(InterestedForumSocketResMsg.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void q(List<b.a.r0.g2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f16798f = list;
            this.f16793a = 1;
        }
    }

    public void r(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f16797e = cVar;
        }
    }

    public void s(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f16796d = dVar;
        }
    }
}
