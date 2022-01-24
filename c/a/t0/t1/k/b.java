package c.a.t0.t1.k;

import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.t1.k.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f22422h;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.t0.t1.k.a f22423b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.t0.t1.k.a f22424c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.t0.t1.k.a f22425d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessage<String> f22426e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f22427f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f22428g;

    /* loaded from: classes8.dex */
    public class a implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public a(b bVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* renamed from: c.a.t0.t1.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1380b implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public C1380b(b bVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0) {
                        this.a.add(next);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public c(b bVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && next.getIsFriend() == 1 && next.getIs_hidden() == 0) {
                        this.a.add(next);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public d(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterPojo;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                        if (this.a.getLast_content_time() < next.getLast_content_time()) {
                            this.a.setLast_content(next.getLast_content());
                            this.a.setLast_content_time(next.getLast_content_time());
                            this.a.setLast_rid(next.getLast_rid());
                            this.a.setLast_user_name(next.getLast_user_name());
                            this.a.setSend_status(next.getSend_status());
                        }
                        ImMessageCenterPojo imMessageCenterPojo = this.a;
                        imMessageCenterPojo.setUnread_count(imMessageCenterPojo.getUnread_count() + next.getUnread_count());
                        this.a.setIs_hidden(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterPojo f22429e;

        public e(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22429e = imMessageCenterPojo;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                c.a.t0.t1.h.j.f().j(this.f22429e);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public f(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterPojo;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                        if (this.a.getLast_content_time() < next.getLast_content_time()) {
                            this.a.setLast_content(next.getLast_content());
                            this.a.setLast_content_time(next.getLast_content_time());
                            this.a.setLast_rid(next.getLast_rid());
                            this.a.setLast_user_name(next.getLast_user_name());
                        }
                        this.a.setIs_hidden(0);
                        ImMessageCenterPojo imMessageCenterPojo = this.a;
                        imMessageCenterPojo.setUnread_count(imMessageCenterPojo.getUnread_count() + next.getUnread_count());
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                imMessageCenterPojo.setCustomGroupType(-8);
                imMessageCenterPojo.setIs_hidden(1);
                c.a.t0.t1.h.j.f().j(imMessageCenterPojo);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LongSparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f22430b;

        public h(b bVar, LongSparseArray longSparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, longSparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22430b = bVar;
            this.a = longSparseArray;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    if (this.f22430b.A(next)) {
                        this.a.put(c.a.d.f.m.b.g(next.getGid(), 0L), Long.valueOf(c.a.t0.t1.w.b.c(next.getPulled_msgId())));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewpushRepair.Builder f22431b;

        public i(b bVar, List list, NewpushRepair.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.f22431b = builder;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    long g2 = c.a.d.f.m.b.g(next.getGid(), 0L);
                    long sid = next.getSid();
                    if (sid > 0) {
                        this.a.add(MessageUtils.makeNewpushGroupRepair(g2, next.getUserType(), sid, 0L, c.a.t0.t1.w.b.c(next.getPulled_msgId())));
                    }
                }
                if (this.a.size() <= 10) {
                    this.f22431b.groups = this.a;
                    return;
                }
                this.f22431b.followType = "0";
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                String data = customMessage.getData();
                c.a.t0.t1.h.n.a();
                LinkedList<ImMessageCenterPojo> d2 = c.a.t0.t1.h.j.f().d();
                long c2 = c.a.t0.t1.f.l.g.b().c(11L);
                long c3 = c.a.t0.t1.f.l.g.b().c(12L);
                if (d2 == null) {
                    d2 = new LinkedList<>();
                }
                if (c2 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    d2.add(imMessageCenterPojo);
                    imMessageCenterPojo.setCustomGroupType(7);
                    imMessageCenterPojo.setGid(String.valueOf(11));
                    imMessageCenterPojo.setPulled_msgId(c.a.t0.t1.w.b.a(c2));
                    imMessageCenterPojo.setIs_hidden(1);
                }
                if (c3 != -1) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    d2.add(imMessageCenterPojo2);
                    imMessageCenterPojo2.setCustomGroupType(8);
                    imMessageCenterPojo2.setGid(String.valueOf(12));
                    imMessageCenterPojo2.setPulled_msgId(c.a.t0.t1.w.b.a(c3));
                    imMessageCenterPojo2.setIs_hidden(1);
                }
                return new MemoryGetFromDBMessage(d2, data);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(b bVar, int i2) {
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                c.a.t0.t1.o.c.e().b();
                MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
                String uid = memoryGetFromDBMessage.getUid();
                if (!TextUtils.isEmpty(uid) && uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                    try {
                        for (ImMessageCenterPojo imMessageCenterPojo : memoryGetFromDBMessage.getData()) {
                            if (!this.a.A(imMessageCenterPojo) || imMessageCenterPojo.getPulled_msgId() > 0) {
                                if (imMessageCenterPojo.getCustomGroupType() == -9 && imMessageCenterPojo.getPushIds() != null && imMessageCenterPojo.getPushIds().length() > 0) {
                                    c.a.t0.t1.o.c.e().j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getPushIds());
                                }
                                this.a.F(imMessageCenterPojo);
                            }
                        }
                        this.a.v(false);
                        this.a.q(false);
                        this.a.y();
                        this.a.x();
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                    this.a.a.set(true);
                    this.a.M();
                    return;
                }
                List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
                if (data != null) {
                    for (ImMessageCenterPojo imMessageCenterPojo2 : data) {
                        if (imMessageCenterPojo2 != null && c.a.t0.t1.k.c.b(imMessageCenterPojo2.getCustomGroupType()) && imMessageCenterPojo2.getPulled_msgId() > 0) {
                            this.a.F(imMessageCenterPojo2);
                        }
                    }
                }
                this.a.a.set(true);
                this.a.M();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setIs_hidden(1);
                    next.setLast_content("");
                    next.setLast_content_time(0L);
                    next.setLast_user_name("");
                    next.setUnread_count(0);
                    next.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setIs_hidden(1);
                    next.setLast_content("");
                    next.setLast_content_time(0L);
                    next.setLast_user_name("");
                    next.setUnread_count(0);
                    next.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    next.setIs_hidden(1);
                    next.setLast_content("");
                    next.setLast_content_time(0L);
                    next.setLast_user_name("");
                    next.setUnread_count(0);
                    next.setSend_status(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public o(b bVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public p(b bVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public q(b bVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements a.InterfaceC1379a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public r(b bVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // c.a.t0.t1.k.a.InterfaceC1379a
        public void a(Iterator<ImMessageCenterPojo> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        this.f22423b = new c.a.t0.t1.k.a();
        this.f22424c = new c.a.t0.t1.k.a();
        this.f22425d = new c.a.t0.t1.k.a();
        this.f22428g = new k(this, 2016008);
        MessageManager.getInstance().registerListener(this.f22428g);
        this.f22426e = new CustomMessage<>(2016008, TbadkCoreApplication.getCurrentAccount());
        BdUniqueId gen = BdUniqueId.gen();
        this.f22427f = gen;
        this.f22426e.setTag(gen);
    }

    public static b o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f22422h == null) {
                synchronized (b.class) {
                    if (f22422h == null) {
                        f22422h = new b();
                    }
                }
            }
            return f22422h;
        }
        return (b) invokeV.objValue;
    }

    public final boolean A(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
                return TbadkCoreApplication.getInst().getCustomizedFilter().b(imMessageCenterPojo.getCustomGroupType());
            }
            return c.a.t0.t1.k.c.a(imMessageCenterPojo.getCustomGroupType());
        }
        return invokeL.booleanValue;
    }

    public void B(String str, int i2, boolean z) {
        ImMessageCenterPojo C;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (C = C(str, i2, z)) == null) {
            return;
        }
        D(C, false);
    }

    public ImMessageCenterPojo C(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ImMessageCenterPojo i3 = i(str, i2);
            if (i3 != null) {
                if (z) {
                    i3.setIs_hidden(0);
                } else {
                    i3.setIs_hidden(1);
                }
            }
            return i3;
        }
        return (ImMessageCenterPojo) invokeCommon.objValue;
    }

    public final void D(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, imMessageCenterPojo, z) == null) && this.a.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                P(imMessageCenterPojo, z, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                O(imMessageCenterPojo, z, 1);
            } else {
                L(imMessageCenterPojo, z, 1);
            }
        }
    }

    public final void E(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, imMessageCenterPojo) == null) && this.a.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                L(imMessageCenterPojo, false, 2);
                L(v(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                L(imMessageCenterPojo, false, 2);
                L(q(false), false, 1);
            } else {
                L(imMessageCenterPojo, false, 2);
            }
        }
    }

    public final void F(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, imMessageCenterPojo) == null) || imMessageCenterPojo == null) {
            return;
        }
        n(imMessageCenterPojo.getCustomGroupType()).a(imMessageCenterPojo);
    }

    public void G(String str, int i2) {
        ImMessageCenterPojo i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) || (i3 = i(str, i2)) == null) {
            return;
        }
        H(str, i2);
        E(i3);
    }

    public void H(String str, int i2) {
        c.a.t0.t1.k.a n2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) && this.a.get() && (n2 = n(i2)) != null) {
            n2.e(str);
        }
    }

    public void I(List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : list) {
            if (imMessageCenterPojo != null) {
                this.f22423b.e(imMessageCenterPojo.getGid());
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a.get()) {
            this.f22423b.d(new l(this));
            this.f22424c.d(new m(this));
            this.f22425d.d(new n(this));
            K();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016001));
        }
    }

    public void L(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i2));
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            L(q(false), false, 1);
        }
    }

    public final void O(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            L(imMessageCenterPojo, z, i2);
            L(q(z), z, i2);
        }
    }

    public final void P(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{imMessageCenterPojo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            L(imMessageCenterPojo, z, i2);
            L(v(z), z, i2);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            L(v(false), false, 1);
        }
    }

    public void R(String str, String str2) {
        ImMessageCenterPojo i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) || (i2 = i(str, 1)) == null) {
            return;
        }
        i2.setGroup_head(str2);
        D(i2, false);
    }

    public void S(String str, String str2) {
        ImMessageCenterPojo i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) || (i2 = i(str, 1)) == null) {
            return;
        }
        i2.setGroup_name(str2);
        D(i2, false);
    }

    public void T(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, imMessageCenterPojo) == null) && this.a.get()) {
            ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (i2 == null) {
                F(imMessageCenterPojo);
                D(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= i2.getLast_rid()) {
                H(i2.getGid(), i2.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(i2.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(i2.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(i2.getNameShow());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                    imMessageCenterPojo.setBjhAvatar(i2.getBjhAvatar());
                }
                F(imMessageCenterPojo);
                D(imMessageCenterPojo, true);
            } else {
                i2.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    public void U(ImMessageCenterPojo imMessageCenterPojo, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048596, this, imMessageCenterPojo, i2) == null) && this.a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo i3 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (i3 == null) {
                imMessageCenterPojo.setUnread_count(i2);
                F(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                D(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > i3.getLast_rid()) {
                i3.setLast_rid(imMessageCenterPojo.getLast_rid());
                i3.setLast_content(imMessageCenterPojo.getLast_content());
                i3.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                i3.setUnread_count(i3.getUnread_count() + i2);
                i3.setIs_hidden(0);
                i3.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                i3.setGroup_name(imMessageCenterPojo.getGroup_name());
                i3.setNameShow(imMessageCenterPojo.getNameShow());
                i3.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                D(i3, true);
            }
        }
    }

    public void V(int i2, long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str}) == null) && this.a.get()) {
            ImMessageCenterPojo i3 = i(str, i2);
            if (i3 == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i2);
                imMessageCenterPojo.setPulled_msgId(j2);
                imMessageCenterPojo.setGid(str);
                F(imMessageCenterPojo);
            } else if (i3.getPulled_msgId() < j2) {
                i3.setPulled_msgId(j2);
            }
        }
    }

    public void W(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, imMessageCenterPojo) == null) || !this.a.get() || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            return;
        }
        ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
        if (i2 == null) {
            F(imMessageCenterPojo);
        } else if (i2.getPulled_msgId() > 0 || imMessageCenterPojo.getPulled_msgId() <= 0) {
        } else {
            i2.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
        }
    }

    public void X(int i2, ChatMessage chatMessage, String str, int i3) {
        int userType;
        ImMessageCenterPojo i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), chatMessage, str, Integer.valueOf(i3)}) == null) && this.a.get()) {
            UserData userData = null;
            if ((i2 == 2 || i2 == 4) && chatMessage != null) {
                if (String.valueOf(chatMessage.getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                    userData = chatMessage.getToUserInfo();
                } else {
                    userData = chatMessage.getUserInfo();
                }
                if (userData != null) {
                    str = userData.getUserId();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ImMessageCenterPojo i5 = i(str, i2);
            if (i5 == null) {
                i5 = new ImMessageCenterPojo();
                i5.setCustomGroupType(i2);
                i5.setGid(str);
                F(i5);
            }
            if (i2 == 2 || i2 == 4) {
                if (userData != null) {
                    if (!TextUtils.isEmpty(userData.getPortrait())) {
                        i5.setGroup_head(userData.getPortrait());
                    }
                    if (!TextUtils.isEmpty(userData.getUserName())) {
                        i5.setGroup_name(userData.getUserName());
                    }
                    if (!TextUtils.isEmpty(userData.getName_show())) {
                        i5.setNameShow(userData.getName_show());
                    }
                    if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                        i5.setBjhAvatar(userData.getImBjhAvatar());
                    }
                }
                if (chatMessage != null) {
                    if (c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                        userType = chatMessage.getUserInfo().getUserType();
                    } else {
                        userType = chatMessage.getToUserInfo().getUserType();
                    }
                    i5.setUserType(userType);
                }
            }
            if (i3 == 1) {
                i5.setLast_content("");
                i5.setLast_rid(0L);
                i5.setSend_status(0);
                i5.setUnread_count(0);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (chatMessage != null && i5.getLast_rid() <= chatMessage.getRecordId()) {
                        i5.setLast_content_time(chatMessage.getTime() * 1000);
                        i5.setLast_content(c.a.t0.t1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent()));
                        i5.setLast_user_name(chatMessage.getUserInfo().getName_show());
                        i5.setLast_rid(chatMessage.getRecordId());
                        i5.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                        i5.setIsFriend(chatMessage.getIsFriend());
                        i5.setFollowStatus(chatMessage.getFollowStatus());
                        if (chatMessage.getLocalData() != null) {
                            i5.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                        }
                    }
                    i5.setIs_hidden(0);
                    if (i2 == 4 && (i4 = i(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                        i4.setIs_hidden(0);
                    }
                }
            } else if (chatMessage != null) {
                i5.setLast_content_time(chatMessage.getTime() * 1000);
                i5.setLast_content(c.a.t0.t1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent()));
                i5.setLast_user_name(chatMessage.getUserInfo().getName_show());
                i5.setLast_rid(chatMessage.getRecordId());
                i5.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                i5.setIsFriend(chatMessage.getIsFriend());
                i5.setFollowStatus(chatMessage.getFollowStatus());
                if (chatMessage.getLocalData() != null) {
                    i5.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                }
            } else {
                i5.setLast_content("");
                i5.setLast_rid(0L);
                i5.setSend_status(0);
                i5.setUnread_count(0);
            }
            BdLog.i("send message status " + i5.getSend_status());
            D(i5, false);
        }
    }

    public void Y(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, imMessageCenterPojo) == null) && this.a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (i2 == null) {
                F(imMessageCenterPojo);
                return;
            }
            i2.setGroup_head(imMessageCenterPojo.getGroup_head());
            i2.setGroup_name(imMessageCenterPojo.getGroup_name());
            i2.setNameShow(imMessageCenterPojo.getNameShow());
            i2.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
        }
    }

    public void Z(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, imMessageCenterPojo) == null) {
            D(a0(imMessageCenterPojo), false);
        }
    }

    public ImMessageCenterPojo a0(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, imMessageCenterPojo)) == null) {
            if (this.a.get() && imMessageCenterPojo != null) {
                ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
                if (i2 == null) {
                    F(imMessageCenterPojo);
                } else {
                    H(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
                    imMessageCenterPojo.setPulled_msgId(i2.getPulled_msgId());
                    F(imMessageCenterPojo);
                }
                return imMessageCenterPojo;
            }
            return null;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f22423b.b();
            this.f22424c.b();
            this.f22425d.b();
            K();
        }
    }

    public void h(String str, int i2) {
        ImMessageCenterPojo i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048604, this, str, i2) == null) || (i3 = i(str, i2)) == null) {
            return;
        }
        i3.setUnread_count(0);
        D(i3, false);
    }

    public ImMessageCenterPojo i(String str, int i2) {
        InterceptResult invokeLI;
        c.a.t0.t1.k.a n2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, str, i2)) == null) {
            if (this.a.get() && (n2 = n(i2)) != null) {
                return n2.c(str);
            }
            return null;
        }
        return (ImMessageCenterPojo) invokeLI.objValue;
    }

    public List<ImMessageCenterPojo> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.f22423b.d(new r(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.f22423b.d(new o(this, linkedList));
            this.f22424c.d(new p(this, linkedList));
            this.f22425d.d(new q(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.f22425d.d(new a(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<ImMessageCenterPojo> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.f22424c.d(new C1380b(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final c.a.t0.t1.k.a n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            if (i2 == 2) {
                return this.f22424c;
            }
            if (i2 == 4) {
                return this.f22425d;
            }
            return this.f22423b;
        }
        return (c.a.t0.t1.k.a) invokeI.objValue;
    }

    public long p(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048611, this, str, i2)) == null) {
            ImMessageCenterPojo i3 = i(str, i2);
            if (i3 != null) {
                return i3.getPulled_msgId();
            }
            return 0L;
        }
        return invokeLI.longValue;
    }

    public final ImMessageCenterPojo q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            c.a.t0.t1.k.a n2 = n(-8);
            ImMessageCenterPojo c2 = n2 != null ? n2.c(TbEnum.CustomGroupId.OFFICIAL_MERGE) : null;
            if (c2 == null) {
                c2 = new ImMessageCenterPojo();
                c2.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                c2.setCustomGroupType(-8);
                F(c2);
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setIs_hidden(1);
            this.f22425d.d(new f(this, imMessageCenterPojo));
            c2.setUserType(imMessageCenterPojo.getUserType());
            c2.setLast_content(imMessageCenterPojo.getLast_content());
            c2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
            c2.setLast_rid(imMessageCenterPojo.getLast_rid());
            c2.setLast_user_name(imMessageCenterPojo.getLast_user_name());
            if (imMessageCenterPojo.getIs_hidden() == 1) {
                c2.setUnread_count(0);
                if (c2.getIs_hidden() != 1) {
                    c2.setIs_hidden(1);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new g(this));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            } else if (z) {
                if (ChatStatusManager.getInst().getIsOpen(4)) {
                    c2.setUnread_count(0);
                } else {
                    c2.setIs_hidden(imMessageCenterPojo.getIs_hidden());
                    c2.setUnread_count(imMessageCenterPojo.getUnread_count());
                }
            } else if (c2.getUnread_count() > 0) {
                c2.setUnread_count(imMessageCenterPojo.getUnread_count());
            }
            return c2;
        }
        return (ImMessageCenterPojo) invokeZ.objValue;
    }

    public LongSparseArray<Long> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
            if (this.a.get()) {
                this.f22423b.d(new h(this, longSparseArray));
            }
            return longSparseArray;
        }
        return (LongSparseArray) invokeV.objValue;
    }

    public NewpushRepair s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            NewpushRepair.Builder builder = new NewpushRepair.Builder();
            ArrayList arrayList = new ArrayList();
            if (this.a.get()) {
                this.f22425d.d(new i(this, arrayList, builder));
            }
            return builder.build(false);
        }
        return (NewpushRepair) invokeV.objValue;
    }

    public long t(String str, int i2) {
        InterceptResult invokeLI;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, str, i2)) == null) {
            ImMessageCenterPojo i3 = i(str, i2);
            if (i3 != null) {
                j2 = i3.getLast_rid() > i3.getPulled_msgId() ? i3.getLast_rid() : i3.getPulled_msgId();
            } else {
                j2 = 0;
            }
            return j2 + 1;
        }
        return invokeLI.longValue;
    }

    public List<ImMessageCenterPojo> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            LinkedList linkedList = new LinkedList();
            this.f22424c.d(new c(this, linkedList));
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final ImMessageCenterPojo v(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
            c.a.t0.t1.k.a n2 = n(-7);
            ImMessageCenterPojo c2 = n2 != null ? n2.c(TbEnum.CustomGroupId.STRANGE_MERGE) : null;
            if (c2 == null) {
                c2 = new ImMessageCenterPojo();
                c2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                c2.setCustomGroupType(-7);
                F(c2);
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setIs_hidden(1);
            this.f22424c.d(new d(this, imMessageCenterPojo));
            c2.setLast_content(imMessageCenterPojo.getLast_content());
            c2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
            c2.setLast_rid(imMessageCenterPojo.getLast_rid());
            c2.setLast_user_name(imMessageCenterPojo.getLast_user_name());
            c2.setSend_status(imMessageCenterPojo.getSend_status());
            if (imMessageCenterPojo.getIs_hidden() == 1) {
                c2.setUnread_count(0);
                if (c2.getIs_hidden() != 1) {
                    c2.setIs_hidden(1);
                    ImMessageCenterPojo i2 = i(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                    if (i2 != null) {
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new e(this, i2));
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                    }
                }
            } else {
                if (z) {
                    if (ChatStatusManager.getInst().getIsOpen(5)) {
                        c2.setUnread_count(0);
                    } else {
                        c2.setUnread_count(imMessageCenterPojo.getUnread_count());
                    }
                } else if (c2.getUnread_count() > 0) {
                    c2.setUnread_count(imMessageCenterPojo.getUnread_count());
                }
                c2.setIs_hidden(imMessageCenterPojo.getIs_hidden());
            }
            return c2;
        }
        return (ImMessageCenterPojo) invokeZ.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.a.set(false);
            g();
            MessageManager.getInstance().removeMessage(2016008, this.f22427f);
            this.f22426e.setData(TbadkCoreApplication.getCurrentAccount());
            CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new j(this));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(this.f22426e, customMessageTask);
        }
    }

    public final void x() {
        c.a.t0.t1.k.a n2;
        ImMessageCenterPojo c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (n2 = n(-3)) == null || (c2 = n2.c(TbEnum.CustomGroupId.GROUP_UPDATE)) == null) {
            return;
        }
        String last_content = c2.getLast_content();
        if (TextUtils.isEmpty(last_content)) {
            return;
        }
        try {
            c2.setLast_content(new JSONObject(last_content).optString(TbEnum.SystemMessage.KEY_USER_MSG));
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public final void y() {
        c.a.t0.t1.k.a n2;
        ImMessageCenterPojo c2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (n2 = n(-4)) == null || (c2 = n2.c(TbEnum.CustomGroupId.GROUP_VALIDATION)) == null) {
            return;
        }
        String last_content = c2.getLast_content();
        if (TextUtils.isEmpty(last_content)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(last_content);
            JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            String str3 = "";
            if (true != jSONObject.isNull("notice_id")) {
                str3 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                str = optString;
                str2 = optString2;
            } else if (optJSONObject != null) {
                str3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                str = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                str2 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
            } else {
                str2 = "";
                str = str2;
            }
            ImMessageCenterPojo c3 = this.f22423b.c(str3);
            if (c3 != null) {
                str2 = c3.getGroup_name();
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            c2.setLast_content(str + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + str2);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.a.get() : invokeV.booleanValue;
    }
}
