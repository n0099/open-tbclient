package c.a.s0.o2.g;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.s0.o2.c.f;
import c.a.s0.o2.c.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f21367b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f21368c;

    /* renamed from: d  reason: collision with root package name */
    public d f21369d;

    /* renamed from: e  reason: collision with root package name */
    public c f21370e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.s0.o2.c.b> f21371f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21372g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.c.g.a f21373h;

    /* renamed from: i  reason: collision with root package name */
    public HttpMessageListener f21374i;

    /* loaded from: classes8.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f21372g = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.a.f21367b) {
                    c.a.s0.o2.c.c cVar = null;
                    if (responsedMessage instanceof InterestedForumHttpResMsg) {
                        cVar = ((InterestedForumHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof InterestedForumSocketResMsg) {
                        cVar = ((InterestedForumSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() != 0) {
                        if (this.a.f21369d != null) {
                            this.a.f21369d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                        }
                    } else if (cVar == null || ListUtils.isEmpty(cVar.a)) {
                        if (this.a.f21369d != null) {
                            this.a.f21369d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar == null || this.a.f21369d == null) {
                    } else {
                        b.c(this.a);
                        this.a.f21369d.c(cVar);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.s0.o2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1286b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1286b(b bVar, int i2) {
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            if ((httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == this.a.f21367b) && (httpResponsedMessage instanceof InterestCommitHttpResMsg)) {
                InterestCommitHttpResMsg interestCommitHttpResMsg = (InterestCommitHttpResMsg) httpResponsedMessage;
                if (interestCommitHttpResMsg.hasError() || interestCommitHttpResMsg.getErrno() != 0) {
                    if (this.a.f21369d != null) {
                        this.a.f21369d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (this.a.f21370e != null) {
                    this.a.f21370e.b();
                }
                c.a.r0.s.g0.b.j().w("key_select_interest_flag", System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void b();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void c(c.a.s0.o2.c.c cVar);

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
        this.f21368c = new Gson();
        this.f21372g = false;
        this.f21373h = new a(this, CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);
        this.f21374i = new C1286b(this, CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        this.f21367b = bdUniqueId;
        this.f21373h.setTag(bdUniqueId);
        this.f21374i.setTag(this.f21367b);
        MessageManager.getInstance().registerListener(this.f21373h);
        MessageManager.getInstance().registerListener(this.f21374i);
        o();
        n();
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.a;
        bVar.a = i2 + 1;
        return i2;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
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
            httpMessage.setTag(this.f21367b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void f(List<c.a.s0.o2.c.a> list) throws UnsupportedEncodingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            String encode = URLEncoder.encode(j(list), "utf-8");
            if (c.a.r0.b.d.p() && !TbadkCoreApplication.isLogin()) {
                c.a.r0.s.g0.b.j().x("user_interest_info", encode);
            }
            httpMessage.addParam("interestList", encode);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(this.f21367b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void g(List<n> list) throws UnsupportedEncodingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            String encode = URLEncoder.encode(k(list), "utf-8");
            if (c.a.r0.b.d.p() && !TbadkCoreApplication.isLogin()) {
                c.a.r0.s.g0.b.j().x("user_interest_info", encode);
            }
            httpMessage.addParam("interestList", encode);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(this.f21367b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap hashMap = new HashMap();
            if (!ListUtils.isEmpty(this.f21371f)) {
                for (c.a.s0.o2.c.b bVar : this.f21371f) {
                    if (bVar != null) {
                        hashMap.put(bVar.f(), new HashMap());
                    }
                }
            }
            return this.f21368c.toJson(hashMap);
        }
        return (String) invokeV.objValue;
    }

    public final List<Integer> i(List<c.a.s0.o2.c.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (c.a.s0.o2.c.b bVar : list) {
                    arrayList.add(Integer.valueOf(bVar.e()));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final String j(List<c.a.s0.o2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            HashMap hashMap = new HashMap();
            for (c.a.s0.o2.c.a aVar : list) {
                HashMap hashMap2 = new HashMap();
                for (g gVar : aVar.a) {
                    if (gVar.f21365b) {
                        RecommendForumInfo recommendForumInfo = gVar.a;
                        hashMap2.put(recommendForumInfo.forum_id, recommendForumInfo.forum_name);
                    }
                }
                hashMap.put(aVar.f21342c, hashMap2);
            }
            if (!ListUtils.isEmpty(this.f21371f)) {
                for (c.a.s0.o2.c.b bVar : this.f21371f) {
                    if (bVar != null && !hashMap.containsKey(bVar.f())) {
                        hashMap.put(bVar.f(), new HashMap());
                    }
                }
            }
            return this.f21368c.toJson(hashMap);
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
                } else if (nVar instanceof c.a.s0.o2.c.d) {
                    c.a.s0.o2.c.d dVar = (c.a.s0.o2.c.d) nVar;
                    if (dVar.l() && hashMap2 != null) {
                        hashMap2.put(Long.valueOf(dVar.e()), dVar.g());
                    }
                }
            }
            if (!StringUtils.isNull(str)) {
                hashMap.put(str, hashMap2);
            }
            if (!ListUtils.isEmpty(this.f21371f)) {
                for (c.a.s0.o2.c.b bVar : this.f21371f) {
                    if (bVar != null && !hashMap.containsKey(bVar.f())) {
                        hashMap.put(bVar.f(), new HashMap());
                    }
                }
            }
            return this.f21368c.toJson(hashMap);
        }
        return (String) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            InterestedForumReqMsg interestedForumReqMsg = new InterestedForumReqMsg();
            List<c.a.s0.o2.c.b> list = this.f21371f;
            if (list == null) {
                interestedForumReqMsg.classidList = i(null);
            } else {
                interestedForumReqMsg.classidList = i(list.subList((this.a - 1) * 3, Math.min(list.size(), this.a * 3)));
            }
            interestedForumReqMsg.setTag(this.f21367b);
            this.f21372g = true;
            MessageManager.getInstance().sendMessage(interestedForumReqMsg);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.a - 1) * 3 < this.f21371f.size() : invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, c.a.s0.v3.f0.a.a(TbConfig.GUIDE_INTERESTED_FORUM_URL, 309654));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(InterestedForumHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.r0.z0.b bVar = new c.a.r0.z0.b(309654);
            bVar.setResponsedClass(InterestedForumSocketResMsg.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void q(List<c.a.s0.o2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f21371f = list;
            this.a = 1;
        }
    }

    public void r(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f21370e = cVar;
        }
    }

    public void s(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f21369d = dVar;
        }
    }
}
