package c.a.q0.a.d0;

import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.q0.a.i;
import c.a.q0.a.o;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskHTTPResMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Queue<c> f12568e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f12569f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.n.b<c.a.q0.a.c> f12570g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.a.d0.b f12571h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12572i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f12573j;
    public c.a.e.c.g.a k;
    public CustomMessageListener l;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12574a;

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
            this.f12574a = dVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: c.a.q0.a.d0.d$f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.q0.a.d0.a data;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f12574a.f12572i = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.f12574a.r(responsedMessage);
                    return;
                }
                e eVar = null;
                eVar = null;
                if (responsedMessage instanceof CompleteTaskHTTPResMsg) {
                    data = ((CompleteTaskHTTPResMsg) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof CompleteTaskSocketResMsg ? ((CompleteTaskSocketResMsg) responsedMessage).getData() : null;
                }
                if (data == null) {
                    return;
                }
                if (this.f12574a.f12571h == null) {
                    this.f12574a.f12571h = new c.a.q0.a.d0.b();
                }
                this.f12574a.f12571h.d(data);
                this.f12574a.f12571h.e();
                Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    c.a.q0.a.c cVar = fVar.f12581a;
                    if (data != null && data.x == 1) {
                        cVar.z = true;
                    }
                    this.f12574a.t(cVar);
                    eVar = fVar;
                } else if (obj instanceof e) {
                    e eVar2 = (e) obj;
                    this.f12574a.s(eVar2.f12579a);
                    eVar = eVar2;
                } else if (obj instanceof g) {
                    o.b().g();
                }
                if (eVar != null) {
                    this.f12574a.f12568e.remove(eVar);
                }
                this.f12574a.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12575a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f12575a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof C0642d)) {
                C0642d c0642d = (C0642d) customResponsedMessage.getData();
                this.f12575a.k(c0642d.f12576a);
                this.f12575a.l(c0642d.f12577b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* renamed from: c.a.q0.a.d0.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0642d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<i> f12576a;

        /* renamed from: b  reason: collision with root package name */
        public List<c.a.q0.a.c> f12577b;

        /* renamed from: c  reason: collision with root package name */
        public List<c.a.q0.a.c> f12578c;

        public C0642d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(c.a.q0.a.c cVar) {
            List<c.a.q0.a.c> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || (list = this.f12577b) == null) {
                return;
            }
            list.add(cVar);
        }

        public void b(i iVar) {
            List<i> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar) == null) || (list = this.f12576a) == null) {
                return;
            }
            list.add(iVar);
        }

        public void c(c.a.q0.a.c cVar) {
            List<c.a.q0.a.c> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || (list = this.f12578c) == null) {
                return;
            }
            list.add(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f12579a;

        /* renamed from: b  reason: collision with root package name */
        public String f12580b;

        public e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12579a = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.q0.a.c f12581a;

        public f(c.a.q0.a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12581a = cVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public d(BdUniqueId bdUniqueId) {
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
        this.f12568e = new LinkedList();
        this.f12572i = false;
        this.f12573j = new Handler(this);
        this.k = new a(this, CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
        this.l = new b(this, 2921379);
        this.f12569f = bdUniqueId;
        p();
        q();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (message.what != 1) {
                return false;
            }
            x();
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k(List<i> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        LinkedList<c.a.q0.a.c> linkedList = new LinkedList();
        for (i iVar : list) {
            if (iVar != null && iVar.c() != null) {
                c.a.q0.a.c c2 = iVar.c();
                if (c2.M()) {
                    c2.e0(c2.F());
                    o(c2);
                } else if (c2.d() != 0 && c2.q() != 0) {
                    linkedList.add(c2);
                }
            }
        }
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (c.a.q0.a.c cVar : linkedList) {
            if (cVar != null) {
                HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(cVar.d()));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    hashMap.put(Integer.valueOf(cVar.d()), hashSet);
                }
                hashSet.add(Integer.valueOf(cVar.q()));
            }
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            Iterator it = ((HashSet) entry.getValue()).iterator();
            while (it.hasNext()) {
                sb.append(it.next() + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            try {
                jSONObject.put(String.valueOf(entry.getKey()), sb);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        for (c.a.q0.a.c cVar2 : linkedList) {
            if (cVar2 != null) {
                c.a.q0.a.d0.c.a(jSONObject2, cVar2.d(), cVar2.q(), cVar2.E());
            }
        }
        e eVar = new e(jSONObject.toString());
        eVar.f12580b = jSONObject2.toString();
        this.f12568e.add(eVar);
        u();
    }

    public final void l(List<c.a.q0.a.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (c.a.q0.a.c cVar : list) {
            if (cVar.M()) {
                cVar.e0(cVar.F());
                o(cVar);
            } else {
                this.f12568e.add(new f(cVar));
            }
        }
        u();
    }

    public void m() {
        c.a.q0.a.d0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f12571h) == null) {
            return;
        }
        bVar.a();
    }

    public BdUniqueId n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12569f : (BdUniqueId) invokeV.objValue;
    }

    public final void o(c.a.q0.a.c cVar) {
        c.a.q0.n.b<c.a.q0.a.c> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || (bVar = this.f12570g) == null) {
            return;
        }
        bVar.a(cVar);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.r0.k3.e0.a.h(309627, CompleteTaskSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, c.a.r0.k3.e0.a.a(TbConfig.COMPLETE_TASK_URL, 309627));
            tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k.setTag(n());
            this.l.setTag(n());
            MessageManager.getInstance().registerListener(this.k);
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: c.a.q0.a.d0.d$f */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        e eVar = null;
        Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
        if (obj instanceof f) {
            f fVar = (f) obj;
            o(fVar.f12581a);
            eVar = fVar;
        } else if (obj instanceof e) {
            eVar = (e) obj;
        }
        if (eVar != null) {
            this.f12568e.remove(eVar);
        }
        u();
    }

    public final void s(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || str == null) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject == null) {
            return;
        }
        LinkedList<c.a.q0.a.c> linkedList = new LinkedList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                String string = jSONObject.getString(next);
                if (string != null && (split = string.split(",")) != null) {
                    for (String str2 : split) {
                        c.a.q0.a.c cVar = new c.a.q0.a.c();
                        cVar.S(c.a.e.e.m.b.e(next, 0));
                        cVar.b0(c.a.e.e.m.b.e(str2, 0));
                        if (cVar.d() != 0 && cVar.q() != 0) {
                            linkedList.add(cVar);
                        }
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        for (c.a.q0.a.c cVar2 : linkedList) {
            o(cVar2);
        }
    }

    public final void t(c.a.q0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || cVar == null) {
            return;
        }
        o(cVar);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f12573j.sendMessage(obtain);
        }
    }

    public void v(String str, int i2, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048588, this, str, i2, str2, obj) == null) && j.z()) {
            this.f12572i = true;
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(i2);
            completeTaskReqMsg.setTag(this.f12569f);
            completeTaskReqMsg.completeId = str;
            completeTaskReqMsg.setToken(str2);
            completeTaskReqMsg.extra = obj;
            completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    public void w(c.a.q0.n.b<c.a.q0.a.c> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.f12570g = bVar;
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        c peek;
        e eVar;
        String str;
        c.a.q0.a.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048590, this)) != null) {
            return invokeV.booleanValue;
        }
        try {
            if (this.f12572i || (peek = this.f12568e.peek()) == null) {
                return false;
            }
            if (peek instanceof f) {
                f fVar = (f) peek;
                if (fVar == null || (cVar = fVar.f12581a) == null) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(String.valueOf(cVar.d()), String.valueOf(cVar.q()));
                v(jSONObject.toString(), 1, cVar.E(), fVar);
                return true;
            } else if (!(peek instanceof e) || (eVar = (e) peek) == null || (str = eVar.f12579a) == null) {
                return false;
            } else {
                v(str, 1, eVar.f12580b, eVar);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
