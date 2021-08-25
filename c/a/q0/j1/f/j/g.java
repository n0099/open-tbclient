package c.a.q0.j1.f.j;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import c.a.q0.j1.l.c.a;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseSocketMajorHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f20728a;

    /* renamed from: b  reason: collision with root package name */
    public d f20729b;

    /* renamed from: c  reason: collision with root package name */
    public String f20730c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f20731d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f20732e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.c.g.a f20733f;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f20734a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
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
            this.f20734a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001147) {
                this.f20734a.g(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2012123) {
                c.a.e.e.m.e.a().removeCallbacks(this.f20734a.f20732e);
                c.a.e.e.m.e.a().postDelayed(this.f20734a.f20732e, 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f20735e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20735e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g gVar = this.f20735e;
                gVar.f(gVar.f20730c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f20736a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f20736a = gVar;
        }

        @Override // c.a.e.c.g.a
        @RequiresApi(api = 16)
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.q0.j1.i.a.b.a data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            LongSparseArray<c.a.q0.j1.i.a.b.b> longSparseArray = null;
            if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                data = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
            } else {
                data = responsedMessage instanceof ResponseSocketMajorHistoryMessage ? ((ResponseSocketMajorHistoryMessage) responsedMessage).getData() : null;
            }
            if (data == null) {
                return;
            }
            List<c.a.q0.j1.i.a.b.b> b2 = data.b();
            if (b2 != null && b2.size() > 0) {
                longSparseArray = new LongSparseArray<>(b2.size());
                for (c.a.q0.j1.i.a.b.b bVar : b2) {
                    longSparseArray.put(bVar.b(), bVar);
                }
            }
            if (this.f20736a.f20729b == null || longSparseArray == null) {
                return;
            }
            this.f20736a.f20729b.onReadCountLoad(longSparseArray);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(List<c.a.q0.j1.l.c.b> list);

        void onReadCountLoad(LongSparseArray<c.a.q0.j1.i.a.b.b> longSparseArray);
    }

    public g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20731d = new a(this, 0);
        this.f20732e = new b(this);
        this.f20733f = new c(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669);
        this.f20728a = tbPageContext;
        tbPageContext.registerListener(2001147, this.f20731d);
        tbPageContext.registerListener(2012123, this.f20731d);
        tbPageContext.registerListener(this.f20733f);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f20732e);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f20730c = str;
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.f53041c = 150;
            aVar.f53042d = str;
            this.f20728a.sendMessage(new LoadOfficialHistoryMessage(aVar));
        }
    }

    public final void g(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() == null) {
                return;
            }
            List<ChatMessage> list = loadHistoryResponsedMessage.getData().f53044b;
            ArrayList arrayList = new ArrayList();
            for (ChatMessage chatMessage : list) {
                List<a.C0970a> b2 = c.a.q0.j1.l.c.a.b(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                if (b2 != null && b2.size() > 0 && (chatMessage instanceof OfficialChatMessage)) {
                    int i2 = 0;
                    while (i2 < b2.size()) {
                        a.C0970a c0970a = b2.get(i2);
                        c.a.q0.j1.l.c.b a2 = c.a.q0.j1.l.c.b.a(chatMessage, c0970a);
                        if (a2 != null && a2.e() != null && !StringUtils.isNull(a2.e().f20908a)) {
                            a2.j(i2 == 0 && !StringUtils.isNull(c0970a.f20910c));
                            arrayList.add(a2);
                        }
                        i2++;
                    }
                }
            }
            h(arrayList);
            d dVar = this.f20729b;
            if (dVar != null) {
                dVar.a(arrayList);
            }
        }
    }

    public final void h(List<c.a.q0.j1.l.c.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (c.a.q0.j1.l.c.b bVar : list) {
            if (bVar.g()) {
                arrayList.add(Long.valueOf(bVar.e().f20915h));
            }
        }
        BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
        broadcastMajorHistoryRequestMessage.queryType = 2;
        broadcastMajorHistoryRequestMessage.bcastIds = arrayList;
        this.f20728a.sendMessage(broadcastMajorHistoryRequestMessage);
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f20729b = dVar;
        }
    }
}
