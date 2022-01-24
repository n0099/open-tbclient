package c.a.t0.t1.o;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.t1.h.j;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static a f22466h;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f22467b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Long, GroupMsgData> f22468c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<Long, NewpushGroupRepair> f22469d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f22470e;

    /* renamed from: f  reason: collision with root package name */
    public Vector<Long> f22471f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f22472g;

    /* renamed from: c.a.t0.t1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC1384a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1384a(a aVar, Looper looper) {
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
                        MessageManager.getInstance().registerListener(this.a.f22472g);
                        return;
                    case 10003:
                        if (message.getData() == null || !message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                            return;
                        }
                        this.a.f22471f.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22474f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f22475g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f22476h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f22477i;

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
            this.f22477i = aVar;
            this.f22473e = j2;
            this.f22474f = j3;
            this.f22475g = i2;
            this.f22476h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupMsgData groupMsgData = (GroupMsgData) this.f22477i.f22468c.get(Long.valueOf(this.f22473e));
                if (groupMsgData == null) {
                    this.f22477i.q(this.f22473e);
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
                this.f22477i.q(this.f22473e);
                if (j3 > this.f22474f) {
                    this.f22477i.f22469d.put(Long.valueOf(this.f22473e), MessageUtils.makeNewpushGroupRepair(this.f22473e, this.f22475g, this.f22474f, j3, this.f22476h));
                    c.a.t0.t1.m.b.l().s(this.f22473e, 1L, 0L, true);
                    this.f22477i.f22471f.add(Long.valueOf(this.f22473e));
                    this.f22477i.o(this.f22473e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-277851841, "Lc/a/t0/t1/o/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-277851841, "Lc/a/t0/t1/o/a;");
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
        this.f22467b = null;
        this.f22468c = null;
        this.f22469d = null;
        this.f22470e = null;
        this.f22471f = null;
        this.f22472g = new c(this, 2005016);
        this.a = new HandlerC1384a(this, Looper.getMainLooper());
        this.f22467b = new Handler(Looper.myLooper());
        this.f22468c = new ConcurrentHashMap<>();
        this.f22469d = new ConcurrentHashMap<>();
        this.f22470e = new ConcurrentHashMap<>();
        this.f22471f = new Vector<>();
        this.a.sendEmptyMessage(10002);
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f22466h == null) {
                synchronized (a.class) {
                    if (f22466h == null) {
                        f22466h = new a();
                    }
                }
            }
            return f22466h;
        }
        return (a) invokeV.objValue;
    }

    public final void g(long j2, long j3, int i2, long j4) {
        GroupMsgData groupMsgData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4)}) == null) || (groupMsgData = this.f22468c.get(Long.valueOf(j3))) == null) {
            return;
        }
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() != 0) {
            if (this.f22470e.containsKey(Long.valueOf(j3))) {
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
            Handler handler2 = this.f22467b;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            ConcurrentHashMap<Long, Runnable> concurrentHashMap = this.f22470e;
            if (concurrentHashMap != null) {
                for (Map.Entry<Long, Runnable> entry : concurrentHashMap.entrySet()) {
                    q(entry.getKey().longValue());
                }
                this.f22470e.clear();
            }
            ConcurrentHashMap<Long, GroupMsgData> concurrentHashMap2 = this.f22468c;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.clear();
            }
            Vector<Long> vector = this.f22471f;
            if (vector != null) {
                vector.clear();
            }
        }
    }

    public NewpushGroupRepair j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            if (this.f22469d.containsKey(Long.valueOf(j2))) {
                return this.f22469d.remove(Long.valueOf(j2));
            }
            return null;
        }
        return (NewpushGroupRepair) invokeJ.objValue;
    }

    public final List<ChatMessage> k(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
            GroupMsgData groupMsgData = this.f22468c.get(Long.valueOf(j2));
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
            if (this.f22471f.contains(Long.valueOf(groupId))) {
                return;
            }
            n(groupMsgData, listMessage, groupId);
            return;
        }
        long sid = g2.getSid();
        long c2 = c.a.t0.t1.w.b.c(g2.getPulled_msgId());
        GroupMsgData groupMsgData2 = this.f22468c.get(Long.valueOf(groupId));
        if (groupMsgData2 == null) {
            groupMsgData2 = new GroupMsgData(groupMsgData.getCmd());
            this.f22468c.put(Long.valueOf(groupId), groupMsgData2);
        }
        Iterator<ChatMessage> it = listMessage.iterator();
        while (it.hasNext()) {
            ChatMessage next = it.next();
            if (next.getSid() > sid) {
                l(next, groupMsgData2);
            }
        }
        listMessage.clear();
        List<ChatMessage> k = k(groupId);
        if (k != null && k.size() > 0) {
            if (!z && sid > 0 && k.get(0).getSid() != 1 + sid) {
                groupMsgData2.getListMessage().addAll(k);
            } else {
                listMessage.addAll(k);
                long sid2 = listMessage.get(listMessage.size() - 1).getSid();
                j3 = listMessage.get(listMessage.size() - 1).getMsgId();
                j2 = sid2;
                if (z) {
                    this.f22471f.remove(Long.valueOf(groupId));
                }
                if (this.f22471f.contains(Long.valueOf(groupId))) {
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
        if (this.f22471f.contains(Long.valueOf(groupId))) {
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
            this.f22469d.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(groupMsgData));
        }
        bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
        Message message = new Message();
        message.what = 10001;
        message.setData(bundle);
        this.a.sendMessage(message);
        linkedList.clear();
        this.f22471f.add(Long.valueOf(j2));
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
            this.f22467b.postDelayed(bVar, c.a.t0.t1.o.b.a().b().b());
            this.f22470e.put(Long.valueOf(j3), bVar);
        }
    }

    public final void q(long j2) {
        Runnable remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) || (remove = this.f22470e.remove(Long.valueOf(j2))) == null) {
            return;
        }
        this.f22467b.removeCallbacks(remove);
    }
}
