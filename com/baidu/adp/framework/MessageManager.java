package com.baidu.adp.framework;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import b.a.e.c.e.c.h;
import b.a.e.c.f.e;
import b.a.e.c.f.f;
import b.a.e.c.f.g;
import b.a.e.c.f.i;
import b.a.e.c.h.a;
import b.a.e.c.h.b;
import b.a.e.c.h.c;
import b.a.e.c.h.d;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.cmdRouter.CmdRouter;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.adp.framework.cmdRouter.MultiValueMap;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class MessageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MODULE_NAME = "msgmgr";
    public static MessageManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public i mController;
    public a mCustomManager;
    public b mHttpManager;
    public int mHttpMsgCWSendFailedCnt;
    public d mSocketManager;
    public int mSocketMsgCWSendFailedCnt;
    public Handler mUIHandler;

    /* renamed from: com.baidu.adp.framework.MessageManager$18  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass18 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$adp$framework$FrameHelper$TYPE;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1530377225, "Lcom/baidu/adp/framework/MessageManager$18;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1530377225, "Lcom/baidu/adp/framework/MessageManager$18;");
                    return;
                }
            }
            int[] iArr = new int[FrameHelper.TYPE.values().length];
            $SwitchMap$com$baidu$adp$framework$FrameHelper$TYPE = iArr;
            try {
                iArr[FrameHelper.TYPE.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$adp$framework$FrameHelper$TYPE[FrameHelper.TYPE.SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$adp$framework$FrameHelper$TYPE[FrameHelper.TYPE.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1766607348, "Lcom/baidu/adp/framework/MessageManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1766607348, "Lcom/baidu/adp/framework/MessageManager;");
        }
    }

    public MessageManager() {
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
        this.mHttpManager = null;
        this.mSocketManager = null;
        this.mCustomManager = null;
        this.mController = null;
        this.mUIHandler = null;
        this.mSocketMsgCWSendFailedCnt = 0;
        this.mHttpMsgCWSendFailedCnt = 0;
        this.mHttpManager = new b(this);
        this.mSocketManager = new d(this);
        this.mCustomManager = new a(this);
        this.mController = new i();
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public static MessageManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (sInstance == null) {
                synchronized (MessageManager.class) {
                    if (sInstance == null) {
                        sInstance = new MessageManager();
                    }
                }
            }
            return sInstance;
        }
        return (MessageManager) invokeV.objValue;
    }

    private c<?, ?, ?, ?> getManager(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) {
            FrameHelper.TYPE e2 = FrameHelper.e(i2);
            if (e2 == FrameHelper.TYPE.HTTP) {
                return this.mHttpManager;
            }
            if (e2 == FrameHelper.TYPE.SOCKET) {
                return this.mSocketManager;
            }
            if (e2 == FrameHelper.TYPE.CUSTOM) {
                return this.mCustomManager;
            }
            BdLog.e("cmd invalid");
            return null;
        }
        return (c) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerListenerInternal(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, messageListener) == null) || messageListener == null) {
            return;
        }
        FrameHelper.TYPE e2 = FrameHelper.e(messageListener.getCmd());
        if (e2 == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
            this.mHttpManager.n(0, (HttpMessageListener) messageListener);
        } else if (e2 == FrameHelper.TYPE.SOCKET && (messageListener instanceof b.a.e.c.g.c)) {
            this.mSocketManager.n(0, (b.a.e.c.g.c) messageListener);
        } else if (e2 == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
            this.mCustomManager.n(0, (CustomMessageListener) messageListener);
        } else {
            BdLog.e("listener invalid" + b.a.e.c.a.a().b(messageListener.getCmd()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterListenerInternal(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, messageListener) == null) || messageListener == null) {
            return;
        }
        int cmd = messageListener.getCmd();
        if (cmd != 0) {
            c<?, ?, ?, ?> manager = getManager(cmd);
            if (manager != null) {
                manager.t(messageListener);
                return;
            }
            return;
        }
        this.mHttpManager.t(messageListener);
        this.mSocketManager.t(messageListener);
        this.mCustomManager.t(messageListener);
    }

    public void abortResponsedMessage(ResponsedMessage<?> responsedMessage) {
        c<?, ?, ?, ?> manager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || (manager = getManager(responsedMessage.getCmd())) == null) {
            return;
        }
        manager.a();
    }

    public void addMessageRule(f<?, ?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            if (l.C()) {
                this.mController.b(fVar);
            } else {
                this.mUIHandler.post(new Runnable(this, fVar) { // from class: com.baidu.adp.framework.MessageManager.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ f val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = fVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mController.b(this.val$rule);
                        }
                    }
                });
            }
        }
    }

    public void addRemovedMessageRule(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            if (l.C()) {
                this.mController.a(eVar);
            } else {
                this.mUIHandler.post(new Runnable(this, eVar) { // from class: com.baidu.adp.framework.MessageManager.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ e val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, eVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = eVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mController.a(this.val$rule);
                        }
                    }
                });
            }
        }
    }

    public void addResponsedMessageRule(g<?> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            if (l.C()) {
                this.mController.c(gVar);
            } else {
                this.mUIHandler.post(new Runnable(this, gVar) { // from class: com.baidu.adp.framework.MessageManager.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ g val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, gVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = gVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mController.c(this.val$rule);
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0294  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchResponsedMessage(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, responsedMessage) == null) {
            if (responsedMessage == null) {
                BdLog.e("responsedMessage is null!!!");
            } else if (!l.C()) {
                this.mUIHandler.post(new Runnable(this, responsedMessage) { // from class: com.baidu.adp.framework.MessageManager.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ ResponsedMessage val$responsedMessage2UI;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, responsedMessage};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$responsedMessage2UI = responsedMessage;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.dispatchResponsedMessage(this.val$responsedMessage2UI);
                        }
                    }
                });
            } else {
                int cmd = responsedMessage.getCmd();
                FrameHelper.TYPE e2 = FrameHelper.e(cmd);
                if (e2 == FrameHelper.TYPE.HTTP && (responsedMessage instanceof HttpResponsedMessage)) {
                    b.a.e.b.a.a.h("Response_Http", responsedMessage);
                    if (responsedMessage.getError() != 0) {
                        if (j.z()) {
                            this.mHttpMsgCWSendFailedCnt++;
                            if (this.mHttpMsgCWSendFailedCnt >= b.a.e.f.n.m.a.o().q("alert_http", 3)) {
                                BdStatisticsManager.getInstance().alert("alert_http", "errCode=" + responsedMessage.getError() + responsedMessage.getErrorString());
                            }
                        }
                    } else {
                        this.mHttpMsgCWSendFailedCnt = 0;
                    }
                    this.mHttpManager.d(this.mController.j((HttpResponsedMessage) responsedMessage));
                } else if (e2 == FrameHelper.TYPE.SOCKET && (responsedMessage instanceof SocketResponsedMessage)) {
                    b.a.e.b.a.a.h("Response_Socket", responsedMessage);
                    if (responsedMessage.getError() != 0) {
                        if (j.z()) {
                            this.mSocketMsgCWSendFailedCnt++;
                            if (this.mSocketMsgCWSendFailedCnt >= b.a.e.f.n.m.a.o().q("alert_im", 3)) {
                                BdStatisticsManager.getInstance().alert("alert_im", "errCode=" + responsedMessage.getError() + responsedMessage.getErrorString());
                            }
                        }
                    } else {
                        this.mSocketMsgCWSendFailedCnt = 0;
                    }
                    Message<?> orginalMessage = responsedMessage.getOrginalMessage();
                    if (orginalMessage != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof NetMessage)) {
                        NetMessage netMessage = (NetMessage) orginalMessage.getExtra();
                        if (netMessage.getHttpMessage() != null && netMessage.getNetType() == NetMessage.NetType.AUTO) {
                            NetMessage.a switchToHttpStrategy = netMessage.getSwitchToHttpStrategy();
                            if ((switchToHttpStrategy != null ? switchToHttpStrategy.checkToSwitchHttp((SocketResponsedMessage) responsedMessage) : false) || responsedMessage.getError() == h.m) {
                                int i2 = 5;
                                if (responsedMessage.getError() == h.m) {
                                    netMessage.setSocketCostTime(System.currentTimeMillis() - orginalMessage.getStartTime());
                                } else if (responsedMessage.getError() == 110004) {
                                    i2 = 8;
                                } else if (responsedMessage.getError() == 110005) {
                                    i2 = 9;
                                }
                                netMessage.setSocketErrNo(i2);
                                if (netMessage.getSocketMessage() != null) {
                                    netMessage.getHttpMessage().setSquencedId(netMessage.getSocketMessage().getSquencedId());
                                }
                                HttpMessage httpMessage = netMessage.getHttpMessage();
                                if (httpMessage != null && i2 == 9) {
                                    httpMessage.addHeader("Retry-Count", "1");
                                }
                                if (sendMessage(httpMessage)) {
                                    this.mCustomManager.d(new CustomResponsedMessage(2000999, Integer.valueOf(responsedMessage.getCmd())));
                                    return;
                                }
                            }
                        }
                    }
                    this.mSocketManager.d(this.mController.n((SocketResponsedMessage) responsedMessage));
                } else if (e2 == FrameHelper.TYPE.CUSTOM && (responsedMessage instanceof CustomResponsedMessage)) {
                    CustomResponsedMessage<?> h2 = this.mController.h((CustomResponsedMessage) responsedMessage);
                    if (CmdRouter.cmdMaps.containsKey(cmd + "")) {
                        try {
                            if (cmd == 2002001) {
                                List<String> values = CmdRouter.cmdMaps.getValues(h2.getCmd() + "");
                                String cls = h2.getData().getClass().toString();
                                String substring = cls.substring(cls.lastIndexOf(".") + 1);
                                for (String str : values) {
                                    if (CmdRouter.configMaps.getValues(str).get(0).contains(substring)) {
                                        Class.forName(str);
                                        CmdRouter.configMaps.getValues(str).get(0).remove(substring);
                                    }
                                }
                            } else {
                                boolean z = false;
                                for (String str2 : CmdRouter.cmdMaps.getValues(cmd + "")) {
                                    try {
                                        System.currentTimeMillis();
                                        z = MultiDexHelper.task != null && MultiDexHelper.task.loadingClass(str2);
                                        Class.forName(str2);
                                    } catch (Throwable th) {
                                        th = th;
                                        r6 = z;
                                        BdLog.e(th);
                                        if (!r6) {
                                        }
                                    }
                                }
                                CmdRouter.cmdMaps.remove(cmd + "");
                                r6 = z;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (!r6) {
                        this.mUIHandler.postDelayed(new Runnable(this, h2) { // from class: com.baidu.adp.framework.MessageManager.17
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MessageManager this$0;
                            public final /* synthetic */ ResponsedMessage val$finalResponsedMessage;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, h2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$finalResponsedMessage = h2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.this$0.mCustomManager.d((CustomResponsedMessage) this.val$finalResponsedMessage);
                                }
                            }
                        }, 1L);
                    } else {
                        this.mCustomManager.d(h2);
                    }
                } else {
                    BdLog.e("responsedMessage invalid:CMD=" + b.a.e.c.a.a().b(cmd) + " Class=" + responsedMessage.getClass().getName());
                }
            }
        }
    }

    @Deprecated
    public void dispatchResponsedMessageToUI(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, responsedMessage) == null) {
            dispatchResponsedMessage(responsedMessage);
        }
    }

    public LinkedList<CustomMessage<?>> findCustomMessage(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bdUniqueId)) == null) ? this.mCustomManager.w(bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    public ArrayList<CustomMessageTask> findCustomTasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCustomManager.i() : (ArrayList) invokeV.objValue;
    }

    public LinkedList<HttpMessage> findHttpMessage(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId)) == null) ? this.mHttpManager.w(bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    public ArrayList<HttpMessageTask> findHttpTasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mHttpManager.i() : (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: java.util.LinkedList<?>, java.util.LinkedList<? extends com.baidu.adp.framework.message.Message> */
    public LinkedList<? extends Message> findMessage(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, bdUniqueId)) == null) {
            c<?, ?, ?, ?> manager = getManager(i2);
            if (manager != null) {
                return manager.e(i2, bdUniqueId);
            }
            BdLog.e("cmd invalid");
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public LinkedList<SocketMessage> findSocketMessage(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdUniqueId)) == null) ? this.mSocketManager.w(bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    public ArrayList<SocketMessageTask> findSocketTasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mSocketManager.i() : (ArrayList) invokeV.objValue;
    }

    public MessageTask findTask(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            FrameHelper.TYPE e2 = FrameHelper.e(i2);
            if (FrameHelper.TYPE.HTTP == e2) {
                return this.mHttpManager.g(i2);
            }
            if (FrameHelper.TYPE.SOCKET == e2) {
                return this.mSocketManager.g(i2);
            }
            if (FrameHelper.TYPE.CUSTOM == e2) {
                try {
                    MultiValueMap<String, String> multiValueMap = CmdRouter.cmdMaps;
                    List<String> values = multiValueMap.getValues(i2 + "");
                    if (values != null && values.size() > 0) {
                        for (String str : values) {
                            Class.forName(str);
                        }
                        MultiValueMap<String, String> multiValueMap2 = CmdRouter.cmdMaps;
                        multiValueMap2.remove(i2 + "");
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
                return this.mCustomManager.g(i2);
            }
            return null;
        }
        return (MessageTask) invokeI.objValue;
    }

    public i getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mController : (i) invokeV.objValue;
    }

    public b.a.e.c.e.c.g getSocketClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mSocketManager.x() : (b.a.e.c.e.c.g) invokeV.objValue;
    }

    public boolean hasListener(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            FrameHelper.TYPE e2 = FrameHelper.e(i2);
            if (e2 == null) {
                return false;
            }
            int i3 = AnonymousClass18.$SwitchMap$com$baidu$adp$framework$FrameHelper$TYPE[e2.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return false;
                    }
                    return this.mCustomManager.j(i2);
                }
                return this.mSocketManager.j(i2);
            }
            return this.mHttpManager.j(i2);
        }
        return invokeI.booleanValue;
    }

    public void registerListener(b.a.e.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) || aVar == null) {
            return;
        }
        if (l.C()) {
            this.mHttpManager.n(0, aVar.getHttpMessageListener());
            this.mSocketManager.n(0, aVar.getSocketMessageListener());
            return;
        }
        this.mUIHandler.post(new Runnable(this, aVar) { // from class: com.baidu.adp.framework.MessageManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MessageManager this$0;
            public final /* synthetic */ b.a.e.c.g.a val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$listener = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mHttpManager.n(0, this.val$listener.getHttpMessageListener());
                    this.this$0.mSocketManager.n(0, this.val$listener.getSocketMessageListener());
                }
            }
        });
    }

    public void registerListenerFromBackground(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, messageListener) == null) || messageListener == null) {
            return;
        }
        if (l.C()) {
            registerListener(messageListener);
        } else {
            this.mUIHandler.post(new Runnable(this, messageListener) { // from class: com.baidu.adp.framework.MessageManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MessageManager this$0;
                public final /* synthetic */ MessageListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, messageListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = messageListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.registerListener(this.val$listener);
                    }
                }
            });
        }
    }

    public void registerStickyMode(int i2) {
        c<?, ?, ?, ?> manager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (manager = getManager(i2)) == null) {
            return;
        }
        manager.o(i2);
    }

    public void registerTask(MessageTask messageTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, messageTask) == null) || messageTask == null) {
            return;
        }
        if (messageTask instanceof HttpMessageTask) {
            this.mHttpManager.p((HttpMessageTask) messageTask);
        } else if (messageTask instanceof SocketMessageTask) {
            this.mSocketManager.p((SocketMessageTask) messageTask);
        } else if (messageTask instanceof CustomMessageTask) {
            this.mCustomManager.p((CustomMessageTask) messageTask);
        } else {
            BdLog.e("task invalid");
        }
    }

    public void removeCustomMessage(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.mCustomManager.y(bdUniqueId);
            this.mController.p(bdUniqueId);
        }
    }

    public void removeHttpMessage(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdUniqueId) == null) {
            this.mHttpManager.y(bdUniqueId);
            this.mController.p(bdUniqueId);
        }
    }

    public void removeMessage(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048602, this, i2, bdUniqueId) == null) {
            c<?, ?, ?, ?> manager = getManager(i2);
            if (manager != null) {
                manager.h(i2, bdUniqueId);
                this.mController.o(i2, bdUniqueId);
                return;
            }
            BdLog.e("cmd invalid");
        }
    }

    public void removeMessageRule(f<?, ?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fVar) == null) {
            if (l.C()) {
                this.mController.e(fVar);
            } else {
                this.mUIHandler.post(new Runnable(this, fVar) { // from class: com.baidu.adp.framework.MessageManager.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ f val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = fVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mController.e(this.val$rule);
                        }
                    }
                });
            }
        }
    }

    public void removeRemovedMessageRule(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, eVar) == null) {
            if (l.C()) {
                this.mController.d(eVar);
            } else {
                this.mUIHandler.post(new Runnable(this, eVar) { // from class: com.baidu.adp.framework.MessageManager.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ e val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, eVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = eVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mController.d(this.val$rule);
                        }
                    }
                });
            }
        }
    }

    public void removeResponsedMessageRule(g<?> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, gVar) == null) {
            if (l.C()) {
                this.mController.f(gVar);
            } else {
                this.mUIHandler.post(new Runnable(this, gVar) { // from class: com.baidu.adp.framework.MessageManager.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ g val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, gVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = gVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mController.f(this.val$rule);
                        }
                    }
                });
            }
        }
    }

    public void removeSocketMessage(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            this.mSocketManager.z(bdUniqueId);
            this.mController.p(bdUniqueId);
        }
    }

    public <T> CustomResponsedMessage<T> runTask(int i2, Class<T> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i2, cls)) == null) ? runTask(i2, cls, null) : (CustomResponsedMessage) invokeIL.objValue;
    }

    public boolean sendMessage(Message<?> message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, message)) == null) {
            if (message == null) {
                return false;
            }
            message.setStartTime(System.currentTimeMillis());
            if (message instanceof HttpMessage) {
                b.a.e.b.a.a.h("Request_Http", message);
                return this.mHttpManager.c((HttpMessage) message, null);
            } else if (message instanceof SocketMessage) {
                b.a.e.b.a.a.h("Request_Socket", message);
                return this.mSocketManager.c((SocketMessage) message, null);
            } else if (!(message instanceof CustomMessage)) {
                BdLog.e("message invalid" + b.a.e.c.a.a().b(message.getCmd()));
                return false;
            } else {
                MultiValueMap<String, String> multiValueMap = CmdRouter.cmdMaps;
                if (multiValueMap.containsKey(message.getCmd() + "")) {
                    try {
                        MultiValueMap<String, String> multiValueMap2 = CmdRouter.cmdMaps;
                        List<String> values = multiValueMap2.getValues(message.getCmd() + "");
                        if (message.getCmd() == 2002001 && ((CustomMessage) message).getData() != null) {
                            String cls = ((CustomMessage) message).getData().getClass().toString();
                            String substring = cls.substring(cls.lastIndexOf(".") + 1);
                            for (String str : values) {
                                if (CmdRouter.configMaps.getValues(str).get(0).contains(substring)) {
                                    Class.forName(str);
                                    CmdRouter.configMaps.getValues(str).get(0).remove(substring);
                                }
                            }
                        } else {
                            for (String str2 : values) {
                                Class.forName(str2);
                            }
                            MultiValueMap<String, String> multiValueMap3 = CmdRouter.cmdMaps;
                            multiValueMap3.remove(message.getCmd() + "");
                        }
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                }
                return this.mCustomManager.c((CustomMessage) message, null);
            }
        }
        return invokeL.booleanValue;
    }

    public void sendMessageFromBackground(Message<?> message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, message) == null) || message == null) {
            return;
        }
        this.mUIHandler.post(new Runnable(this, message) { // from class: com.baidu.adp.framework.MessageManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MessageManager this$0;
            public final /* synthetic */ Message val$message;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, message};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$message = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.sendMessage(this.val$message);
                }
            }
        });
    }

    public void setNotFindTaskListener(b.a.e.c.g.b<Message<?>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bVar) == null) {
            c.q(bVar);
        }
    }

    public void unRegisterListener(b.a.e.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, aVar) == null) || aVar == null) {
            return;
        }
        if (l.C()) {
            this.mHttpManager.t(aVar.getHttpMessageListener());
            this.mSocketManager.t(aVar.getSocketMessageListener());
            return;
        }
        this.mUIHandler.post(new Runnable(this, aVar) { // from class: com.baidu.adp.framework.MessageManager.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MessageManager this$0;
            public final /* synthetic */ b.a.e.c.g.a val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$listener = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mHttpManager.t(this.val$listener.getHttpMessageListener());
                    this.this$0.mSocketManager.t(this.val$listener.getSocketMessageListener());
                }
            }
        });
    }

    public void unRegisterStickyMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            l.d();
            c<?, ?, ?, ?> manager = getManager(i2);
            if (manager != null) {
                manager.u(i2);
            }
        }
    }

    public void unRegisterTask(int i2) {
        c<?, ?, ?, ?> manager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048622, this, i2) == null) || (manager = getManager(i2)) == null) {
            return;
        }
        manager.v(i2);
    }

    public <T> CustomResponsedMessage<T> runTask(int i2, Class<T> cls, Object obj) {
        InterceptResult invokeILL;
        CustomMessage<?> customMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048609, this, i2, cls, obj)) == null) {
            if (obj != null) {
                customMessage = new CustomMessage<>(i2);
                customMessage.setData(obj);
            } else {
                customMessage = null;
            }
            MultiValueMap<String, String> multiValueMap = CmdRouter.cmdMaps;
            if (multiValueMap.containsKey(i2 + "")) {
                try {
                    if (i2 == 2002001) {
                        MultiValueMap<String, String> multiValueMap2 = CmdRouter.cmdMaps;
                        List<String> values = multiValueMap2.getValues(i2 + "");
                        String cls2 = customMessage.getData().getClass().toString();
                        String substring = cls2.substring(cls2.lastIndexOf(".") + 1);
                        for (String str : values) {
                            if (CmdRouter.configMaps.getValues(str).get(0).contains(substring)) {
                                Class.forName(str);
                                CmdRouter.configMaps.getValues(str).get(0).remove(substring);
                            }
                        }
                    } else {
                        MultiValueMap<String, String> multiValueMap3 = CmdRouter.cmdMaps;
                        for (String str2 : multiValueMap3.getValues(i2 + "")) {
                            System.currentTimeMillis();
                            Class.forName(str2);
                        }
                        MultiValueMap<String, String> multiValueMap4 = CmdRouter.cmdMaps;
                        multiValueMap4.remove(i2 + "");
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
            a aVar = this.mCustomManager;
            return aVar.z(customMessage, aVar.g(i2), cls);
        }
        return (CustomResponsedMessage) invokeILL.objValue;
    }

    public void registerListener(int i2, b.a.e.c.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048593, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (l.C()) {
            this.mHttpManager.n(i2, aVar.getHttpMessageListener());
            this.mSocketManager.n(i2, aVar.getSocketMessageListener());
            return;
        }
        this.mUIHandler.post(new Runnable(this, i2, aVar) { // from class: com.baidu.adp.framework.MessageManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MessageManager this$0;
            public final /* synthetic */ int val$cmd;
            public final /* synthetic */ b.a.e.c.g.a val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$cmd = i2;
                this.val$listener = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mHttpManager.n(this.val$cmd, this.val$listener.getHttpMessageListener());
                    this.this$0.mSocketManager.n(this.val$cmd, this.val$listener.getSocketMessageListener());
                }
            }
        });
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bdUniqueId) == null) {
            removeSocketMessage(bdUniqueId);
            removeCustomMessage(bdUniqueId);
            removeHttpMessage(bdUniqueId);
        }
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, messageListener) == null) || messageListener == null) {
            return;
        }
        if (l.C()) {
            unRegisterListenerInternal(messageListener);
        } else {
            this.mUIHandler.post(new Runnable(this, messageListener) { // from class: com.baidu.adp.framework.MessageManager.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MessageManager this$0;
                public final /* synthetic */ MessageListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, messageListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = messageListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.unRegisterListenerInternal(this.val$listener);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterListenerInternal(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, bdUniqueId) == null) {
            this.mHttpManager.s(bdUniqueId);
            this.mSocketManager.s(bdUniqueId);
            this.mCustomManager.s(bdUniqueId);
        }
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bdUniqueId) == null) {
            if (l.C()) {
                unRegisterListenerInternal(bdUniqueId);
            } else {
                this.mUIHandler.post(new Runnable(this, bdUniqueId) { // from class: com.baidu.adp.framework.MessageManager.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ BdUniqueId val$tag;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bdUniqueId};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$tag = bdUniqueId;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.unRegisterListenerInternal(this.val$tag);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerListenerInternal(int i2, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65548, this, i2, messageListener) == null) || messageListener == null) {
            return;
        }
        FrameHelper.TYPE e2 = FrameHelper.e(i2);
        if (e2 == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
            this.mHttpManager.n(i2, (HttpMessageListener) messageListener);
        } else if (e2 == FrameHelper.TYPE.SOCKET && (messageListener instanceof b.a.e.c.g.c)) {
            this.mSocketManager.n(i2, (b.a.e.c.g.c) messageListener);
        } else if (e2 == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
            this.mCustomManager.n(i2, (CustomMessageListener) messageListener);
        } else {
            BdLog.e("listener invalid" + b.a.e.c.a.a().b(i2) + "|" + b.a.e.c.a.a().b(messageListener.getCmd()));
        }
    }

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, messageListener) == null) || messageListener == null) {
            return;
        }
        if (l.C()) {
            registerListenerInternal(messageListener);
        } else {
            this.mUIHandler.post(new Runnable(this, messageListener) { // from class: com.baidu.adp.framework.MessageManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MessageManager this$0;
                public final /* synthetic */ MessageListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, messageListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = messageListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.registerListenerInternal(this.val$listener);
                    }
                }
            });
        }
    }

    public void registerListener(int i2, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048594, this, i2, messageListener) == null) || messageListener == null) {
            return;
        }
        if (l.C()) {
            registerListenerInternal(i2, messageListener);
        } else {
            this.mUIHandler.post(new Runnable(this, i2, messageListener) { // from class: com.baidu.adp.framework.MessageManager.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MessageManager this$0;
                public final /* synthetic */ int val$cmd;
                public final /* synthetic */ MessageListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), messageListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$cmd = i2;
                    this.val$listener = messageListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.registerListenerInternal(this.val$cmd, this.val$listener);
                    }
                }
            });
        }
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessageTask customMessageTask, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, customMessageTask, cls)) == null) ? this.mCustomManager.z(null, customMessageTask, cls) : (CustomResponsedMessage) invokeLL.objValue;
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessage<?> customMessage, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, customMessage, cls)) == null) {
            if (customMessage == null) {
                return null;
            }
            a aVar = this.mCustomManager;
            return aVar.z(customMessage, aVar.g(customMessage.getCmd()), cls);
        }
        return (CustomResponsedMessage) invokeLL.objValue;
    }

    public boolean sendMessage(NetMessage netMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, netMessage)) == null) {
            if (netMessage == null) {
                return false;
            }
            if (netMessage.getNetType() == NetMessage.NetType.SOCKET) {
                return sendMessage(netMessage.getSocketMessage());
            }
            if (netMessage.getNetType() == NetMessage.NetType.HTTP) {
                return sendMessage(netMessage.getHttpMessage());
            }
            boolean v = getSocketClient().v();
            if (!v) {
                netMessage.setSocketErrNo(1);
            }
            if (v && sendMessage(netMessage.getSocketMessage())) {
                b.a.e.c.e.c.i.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "socket");
                return true;
            }
            b.a.e.c.e.c.i.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "https");
            return sendMessage(netMessage.getHttpMessage());
        }
        return invokeL.booleanValue;
    }

    public boolean sendMessage(NetMessage netMessage, SocketMessageTask socketMessageTask, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048615, this, netMessage, socketMessageTask, httpMessageTask)) == null) {
            if (netMessage == null) {
                return false;
            }
            if (netMessage.getNetType() == NetMessage.NetType.SOCKET) {
                return sendMessage(netMessage.getSocketMessage(), socketMessageTask);
            }
            if (netMessage.getNetType() == NetMessage.NetType.HTTP) {
                return sendMessage(netMessage.getHttpMessage(), httpMessageTask);
            }
            boolean v = getSocketClient().v();
            if (!v) {
                netMessage.setSocketErrNo(1);
            }
            if (v && sendMessage(netMessage.getSocketMessage(), socketMessageTask)) {
                b.a.e.c.e.c.i.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "socket");
                return true;
            }
            b.a.e.c.e.c.i.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "https");
            return sendMessage(netMessage.getHttpMessage(), httpMessageTask);
        }
        return invokeLLL.booleanValue;
    }

    public boolean sendMessage(Message<?> message, MessageTask messageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, message, messageTask)) == null) {
            if (message == null) {
                return false;
            }
            if ((message instanceof HttpMessage) && (messageTask instanceof HttpMessageTask)) {
                b.a.e.b.a.a.h("Request_Http", message);
                return this.mHttpManager.c((HttpMessage) message, (HttpMessageTask) messageTask);
            } else if ((message instanceof SocketMessage) && (messageTask instanceof SocketMessageTask)) {
                b.a.e.b.a.a.h("Request_Socket", message);
                return this.mSocketManager.c((SocketMessage) message, (SocketMessageTask) messageTask);
            } else if ((message instanceof CustomMessage) && (messageTask instanceof CustomMessageTask)) {
                return this.mCustomManager.c((CustomMessage) message, (CustomMessageTask) messageTask);
            } else {
                BdLog.e("message and task invalid:" + b.a.e.c.a.a().b(message.getCmd()));
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
