package b.a.r0.l1.p;

import android.text.TextUtils;
import b.a.e.c.g.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.RequestGetGroupInfoMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static b f21843d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f21844a;

    /* renamed from: b  reason: collision with root package name */
    public c f21845b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f21846c;

    /* loaded from: classes5.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21847a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
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
            this.f21847a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 202006 && (socketResponsedMessage instanceof PushNotifyMessage)) {
                this.f21847a.e((PushNotifyMessage) socketResponsedMessage);
            }
        }
    }

    /* renamed from: b.a.r0.l1.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1077b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1077b(b bVar, int i2) {
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016014 || (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) == null) {
                return;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestGetGroupInfoMessage(Long.valueOf(b.a.e.f.m.b.g(imMessageCenterPojo.getGid(), 0L))));
            }
            b.a.r0.l1.m.b.l().s(b.a.e.f.m.b.g(imMessageCenterPojo.getGid(), 0L), b.a.r0.l1.w.b.c(imMessageCenterPojo.getPulled_msgId()), 0L, true);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2110668760, "Lb/a/r0/l1/p/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2110668760, "Lb/a/r0/l1/p/b;");
        }
    }

    public b() {
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
        new ArrayList();
        this.f21845b = new a(this, 202006);
        this.f21846c = new C1077b(this, 0);
    }

    public static synchronized b b() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (b.class) {
                if (f21843d == null) {
                    f21843d = new b();
                }
                bVar = f21843d;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21844a : (String) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f();
        }
    }

    public final void e(PushNotifyMessage pushNotifyMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pushNotifyMessage) == null) || pushNotifyMessage == null) {
            return;
        }
        if (pushNotifyMessage.getType() == 3) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.getInst())));
        } else if (pushNotifyMessage.getType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
        } else if (b.a.r0.l1.k.b.o().z()) {
            String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
            b.a.q0.s.a0.a.a("im", -1L, 202006, "notify", 0, null, "comment", "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
            if (TextUtils.isEmpty(valueOf)) {
                return;
            }
            BdLog.e("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
            if (pushNotifyMessage.getGroupType() == 0) {
                b.a.r0.l1.m.b.l().r(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                return;
            }
            int a2 = b.a.r0.l1.m.a.a(pushNotifyMessage.getGroupType());
            if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(a2)) {
                if (b.a.r0.l1.k.b.o().i(String.valueOf(pushNotifyMessage.getGroupId()), a2) != null) {
                    b.a.r0.l1.m.b.l().r(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                } else {
                    h(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), a2);
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.f21845b);
            MessageManager.getInstance().registerListener(2016014, this.f21846c);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f21844a = str;
        }
    }

    public final void h(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) || j2 <= 0) {
            return;
        }
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setCustomGroupType(i2);
        imMessageCenterPojo.setGid(String.valueOf(j));
        imMessageCenterPojo.setPulled_msgId(b.a.r0.l1.w.b.a(j2 - 1));
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
    }
}
