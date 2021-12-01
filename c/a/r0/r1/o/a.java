package c.a.r0.r1.o;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.r1.h.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import protobuf.NewpushGroupRepair;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static a f23076h;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f23077b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Long, GroupMsgData> f23078c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<Long, NewpushGroupRepair> f23079d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f23080e;

    /* renamed from: f  reason: collision with root package name */
    public Vector<Long> f23081f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f23082g;

    /* renamed from: c.a.r0.r1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class HandlerC1330a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1330a(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(this.a.f23082g);
                        return;
                    case 10003:
                        if (message.getData() == null || !message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                            return;
                        }
                        this.a.f23081f.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f23083e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f23084f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f23085g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f23086h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f23087i;

        public b(a aVar, long j2, long j3, int i2, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23087i = aVar;
            this.f23083e = j2;
            this.f23084f = j3;
            this.f23085g = i2;
            this.f23086h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupMsgData groupMsgData = (GroupMsgData) this.f23087i.f23078c.get(Long.valueOf(this.f23083e));
                if (groupMsgData == null) {
                    this.f23087i.q(this.f23083e);
                    return;
                }
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                long j2 = -1;
                if (listMessage != null && listMessage.size() > 0) {
                    for (int i2 = 0; i2 < listMessage.size(); i2++) {
                        if (j2 < listMessage.get(i2).getSid()) {
                            j2 = listMessage.get(i2).getSid();
                        }
                    }
                    listMessage.clear();
                }
                long j3 = j2;
                this.f23087i.q(this.f23083e);
                if (j3 > this.f23084f) {
                    this.f23087i.f23079d.put(Long.valueOf(this.f23083e), MessageUtils.makeNewpushGroupRepair(this.f23083e, this.f23085g, this.f23084f, j3, this.f23086h));
                    c.a.r0.r1.m.b.l().s(this.f23083e, 1L, 0L, true);
                    this.f23087i.f23081f.add(Long.valueOf(this.f23083e));
                    this.f23087i.o(this.f23083e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1659832193, "Lc/a/r0/r1/o/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1659832193, "Lc/a/r0/r1/o/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f23077b = null;
        this.f23078c = null;
        this.f23079d = null;
        this.f23080e = null;
        this.f23081f = null;
        this.f23082g = new c(this, 2005016);
        this.a = new HandlerC1330a(this, Looper.getMainLooper());
        this.f23077b = new Handler(Looper.myLooper());
        this.f23078c = new ConcurrentHashMap<>();
        this.f23079d = new ConcurrentHashMap<>();
        this.f23080e = new ConcurrentHashMap<>();
        this.f23081f = new Vector<>();
        this.a.sendEmptyMessage(10002);
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f23076h == null) {
                synchronized (a.class) {
                    if (f23076h == null) {
                        f23076h = new a();
                    }
                }
            }
            return f23076h;
        }
        return (a) invokeV.objValue;
    }

    public final void g(long j2, long j3, int i2, long j4) {
        GroupMsgData groupMsgData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4)}) == null) || (groupMsgData = this.f23078c.get(Long.valueOf(j3))) == null) {
            return;
        }
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() != 0) {
            if (this.f23080e.containsKey(Long.valueOf(j3))) {
                return;
            }
            p(j2, j3, i2, j4);
            return;
        }
        q(j3);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.f23077b;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            ConcurrentHashMap<Long, Runnable> concurrentHashMap = this.f23080e;
            if (concurrentHashMap != null) {
                for (Map.Entry<Long, Runnable> entry : concurrentHashMap.entrySet()) {
                    q(entry.getKey().longValue());
                }
                this.f23080e.clear();
            }
            ConcurrentHashMap<Long, GroupMsgData> concurrentHashMap2 = this.f23078c;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.clear();
            }
            Vector<Long> vector = this.f23081f;
            if (vector != null) {
                vector.clear();
            }
        }
    }

    public NewpushGroupRepair j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            if (this.f23079d.containsKey(Long.valueOf(j2))) {
                return this.f23079d.remove(Long.valueOf(j2));
            }
            return null;
        }
        return (NewpushGroupRepair) invokeJ.objValue;
    }

    public final List<ChatMessage> k(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
            GroupMsgData groupMsgData = this.f23078c.get(Long.valueOf(j2));
            LinkedList linkedList = null;
            if (groupMsgData == null) {
                return null;
            }
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage != null && listMessage.size() != 0) {
                linkedList = new LinkedList();
                Iterator<ChatMessage> it = listMessage.iterator();
                long sid = listMessage.get(0).getSid() - 1;
                while (it.hasNext()) {
                    ChatMessage next = it.next();
                    sid++;
                    if (next.getSid() != sid) {
                        break;
                    }
                    it.remove();
                    linkedList.add(next);
                }
            }
            return linkedList;
        }
        return (List) invokeJ.objValue;
    }

    public final boolean l(ChatMessage chatMessage, GroupMsgData groupMsgData) {
        InterceptResult invokeLL;
        LinkedList<ChatMessage> listMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, chatMessage, groupMsgData)) == null) {
            int i2 = 0;
            if (chatMessage == null || groupMsgData == null || (listMessage = groupMsgData.getListMessage()) == null) {
                return false;
            }
            if (listMessage.contains(chatMessage)) {
                return true;
            }
            int size = listMessage.size();
            while (i2 < size) {
                ChatMessage chatMessage2 = listMessage.get(i2);
                if (chatMessage2 != null) {
                    if (chatMessage.getSid() == chatMessage2.getSid()) {
                        return true;
                    }
                    if (chatMessage.getSid() < chatMessage2.getSid()) {
                        break;
                    }
                }
                i2++;
            }
            listMessage.add(i2, chatMessage);
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, groupMsgData, z) == null) || groupMsgData == null || groupMsgData.getGroupInfo() == null || (listMessage = groupMsgData.getListMessage()) == null || listMessage.size() == 0) {
            return;
        }
        long groupId = groupMsgData.getGroupInfo().getGroupId();
        ImMessageCenterPojo g2 = j.f().g(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
        if (!(g2 != null)) {
            if (this.f23081f.contains(Long.valueOf(groupId))) {
                return;
            }
            n(groupMsgData, listMessage, groupId);
            return;
        }
        long sid = g2.getSid();
        long c2 = c.a.r0.r1.w.b.c(g2.getPulled_msgId());
        GroupMsgData groupMsgData2 = this.f23078c.get(Long.valueOf(groupId));
        if (groupMsgData2 == null) {
            groupMsgData2 = new GroupMsgData(groupMsgData.getCmd());
            this.f23078c.put(Long.valueOf(groupId), groupMsgData2);
        }
        Iterator<ChatMessage> it = listMessage.iterator();
        while (it.hasNext()) {
            ChatMessage next = it.next();
            if (next.getSid() > sid) {
                l(next, groupMsgData2);
            }
        }
        listMessage.clear();
        List<ChatMessage> k2 = k(groupId);
        if (k2 != null && k2.size() > 0) {
            if (!z && sid > 0 && k2.get(0).getSid() != 1 + sid) {
                groupMsgData2.getListMessage().addAll(k2);
            } else {
                listMessage.addAll(k2);
                long sid2 = listMessage.get(listMessage.size() - 1).getSid();
                j3 = listMessage.get(listMessage.size() - 1).getMsgId();
                j2 = sid2;
                if (z) {
                    this.f23081f.remove(Long.valueOf(groupId));
                }
                if (this.f23081f.contains(Long.valueOf(groupId))) {
                    g(j2, groupId, groupMsgData.getGroupInfo().getUserType(), j3);
                    return;
                }
                return;
            }
        }
        j2 = sid;
        j3 = c2;
        if (z) {
        }
        if (this.f23081f.contains(Long.valueOf(groupId))) {
        }
    }

    public final void n(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{groupMsgData, linkedList, Long.valueOf(j2)}) == null) || groupMsgData == null || linkedList == null || linkedList.size() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j2);
        bundle.putLong("lastMid", linkedList.get(0).getMsgId());
        if (linkedList.get(0).getSid() > 0) {
            this.f23079d.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(groupMsgData));
        }
        bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
        Message message = new Message();
        message.what = 10001;
        message.setData(bundle);
        this.a.sendMessage(message);
        linkedList.clear();
        this.f23081f.add(Long.valueOf(j2));
        o(j2);
    }

    public final void o(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            Message message = new Message();
            message.what = 10003;
            Bundle bundle = new Bundle();
            bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j2);
            message.setData(bundle);
            this.a.sendMessageDelayed(message, 3000L);
        }
    }

    public final void p(long j2, long j3, int i2, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4)}) == null) {
            b bVar = new b(this, j3, j2, i2, j4);
            this.f23077b.postDelayed(bVar, c.a.r0.r1.o.b.a().b().b());
            this.f23080e.put(Long.valueOf(j3), bVar);
        }
    }

    public final void q(long j2) {
        Runnable remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) || (remove = this.f23080e.remove(Long.valueOf(j2))) == null) {
            return;
        }
        this.f23077b.removeCallbacks(remove);
    }
}
