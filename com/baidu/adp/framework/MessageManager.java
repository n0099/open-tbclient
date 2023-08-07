package com.baidu.adp.framework;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.cmdRouter.CmdRouter;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.adp.framework.cmdRouter.MultiValueMap;
import com.baidu.adp.framework.controller.MessageRule;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.listener.SocketMessageListener;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.NetLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tieba.cb;
import com.baidu.tieba.db;
import com.baidu.tieba.eb;
import com.baidu.tieba.fb;
import com.baidu.tieba.gb;
import com.baidu.tieba.ha;
import com.baidu.tieba.ia;
import com.baidu.tieba.ja;
import com.baidu.tieba.jf;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.q9;
import com.baidu.tieba.u9;
import com.baidu.tieba.v9;
import com.baidu.tieba.wa;
import com.baidu.tieba.xa;
import com.baidu.tieba.za;
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
/* loaded from: classes.dex */
public class MessageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MODULE_NAME = "msgmgr";
    public static MessageManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public za mController;
    public db mCustomManager;
    public eb mHttpManager;
    public int mHttpMsgCWSendFailedCnt;
    public gb mSocketManager;
    public int mSocketMsgCWSendFailedCnt;
    public Handler mUIHandler;

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

    /* renamed from: com.baidu.adp.framework.MessageManager$16  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass16 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$adp$framework$FrameHelper$TYPE;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1530377287, "Lcom/baidu/adp/framework/MessageManager$16;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1530377287, "Lcom/baidu/adp/framework/MessageManager$16;");
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

    public MessageManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mHttpManager = new eb(this);
        this.mSocketManager = new gb(this);
        this.mCustomManager = new db(this);
        this.mController = new za();
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterListenerInternal(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, bdUniqueId) == null) {
            this.mHttpManager.t(bdUniqueId);
            this.mSocketManager.t(bdUniqueId);
            this.mCustomManager.t(bdUniqueId);
        }
    }

    public void abortResponsedMessage(ResponsedMessage<?> responsedMessage) {
        fb<?, ?, ?, ?> manager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && (manager = getManager(responsedMessage.getCmd())) != null) {
            manager.a();
        }
    }

    public void addMessageRule(MessageRule<?, ?> messageRule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageRule) == null) {
            if (BdUtilHelper.isMainThread()) {
                this.mController.b(messageRule);
            } else {
                this.mUIHandler.post(new Runnable(this, messageRule) { // from class: com.baidu.adp.framework.MessageManager.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ MessageRule val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, messageRule};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = messageRule;
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

    public void addRemovedMessageRule(wa waVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, waVar) == null) {
            if (BdUtilHelper.isMainThread()) {
                this.mController.a(waVar);
            } else {
                this.mUIHandler.post(new Runnable(this, waVar) { // from class: com.baidu.adp.framework.MessageManager.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ wa val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, waVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = waVar;
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

    public void addResponsedMessageRule(xa<?> xaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xaVar) == null) {
            if (BdUtilHelper.isMainThread()) {
                this.mController.c(xaVar);
            } else {
                this.mUIHandler.post(new Runnable(this, xaVar) { // from class: com.baidu.adp.framework.MessageManager.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ xa val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, xaVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = xaVar;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bdUniqueId)) == null) {
            return this.mCustomManager.x(bdUniqueId);
        }
        return (LinkedList) invokeL.objValue;
    }

    public void registerListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, messageListener) != null) || messageListener == null) {
            return;
        }
        if (BdUtilHelper.isMainThread()) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.registerListenerInternal(this.val$listener);
                }
            });
        }
    }

    public void registerListenerFromBackground(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, messageListener) != null) || messageListener == null) {
            return;
        }
        if (BdUtilHelper.isMainThread()) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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

    public void registerStickyMode(int i) {
        fb<?, ?, ?, ?> manager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (manager = getManager(i)) != null) {
            manager.o(i);
        }
    }

    public void removeCustomMessage(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.mCustomManager.z(bdUniqueId);
            this.mController.n(bdUniqueId);
        }
    }

    public void removeHttpMessage(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            this.mHttpManager.y(bdUniqueId);
            this.mController.n(bdUniqueId);
        }
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
            removeSocketMessage(bdUniqueId);
            removeCustomMessage(bdUniqueId);
            removeHttpMessage(bdUniqueId);
        }
    }

    public void removeMessageRule(MessageRule<?, ?> messageRule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, messageRule) == null) {
            if (BdUtilHelper.isMainThread()) {
                this.mController.d(messageRule);
            } else {
                this.mUIHandler.post(new Runnable(this, messageRule) { // from class: com.baidu.adp.framework.MessageManager.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MessageManager this$0;
                    public final /* synthetic */ MessageRule val$rule;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, messageRule};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rule = messageRule;
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

    public void removeSocketMessage(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdUniqueId) == null) {
            this.mSocketManager.z(bdUniqueId);
            this.mController.n(bdUniqueId);
        }
    }

    public void sendMessageFromBackground(Message<?> message) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, message) != null) || message == null) {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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

    public void setNotFindTaskListener(cb<Message<?>> cbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, cbVar) == null) {
            fb.q(cbVar);
        }
    }

    public void unRegisterListener(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i) == null) && BdUtilHelper.isMainThread()) {
            this.mCustomManager.s(i);
        }
    }

    public void unRegisterStickyMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            BdUtilHelper.checkMainThread();
            fb<?, ?, ?, ?> manager = getManager(i);
            if (manager != null) {
                manager.v(i);
            }
        }
    }

    public void unRegisterTask(int i) {
        fb<?, ?, ?, ?> manager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048617, this, i) == null) && (manager = getManager(i)) != null) {
            manager.w(i);
        }
    }

    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: java.util.LinkedList<?>, java.util.LinkedList<? extends com.baidu.adp.framework.message.Message> */
    public LinkedList<? extends Message> findMessage(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, bdUniqueId)) == null) {
            fb<?, ?, ?, ?> manager = getManager(i);
            if (manager != null) {
                return manager.e(i, bdUniqueId);
            }
            BdLog.e("cmd invalid");
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048589, this, i, messageListener) != null) || messageListener == null) {
            return;
        }
        if (BdUtilHelper.isMainThread()) {
            registerListenerInternal(i, messageListener);
        } else {
            this.mUIHandler.post(new Runnable(this, i, messageListener) { // from class: com.baidu.adp.framework.MessageManager.7
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
                        Object[] objArr = {this, Integer.valueOf(i), messageListener};
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
                    this.val$cmd = i;
                    this.val$listener = messageListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.registerListenerInternal(this.val$cmd, this.val$listener);
                }
            });
        }
    }

    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i, bdUniqueId) == null) {
            fb<?, ?, ?, ?> manager = getManager(i);
            if (manager != null) {
                manager.h(i, bdUniqueId);
                this.mController.m(i, bdUniqueId);
                return;
            }
            BdLog.e("cmd invalid");
        }
    }

    public <T> CustomResponsedMessage<T> runTask(int i, Class<T> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, cls)) == null) {
            return runTask(i, cls, null);
        }
        return (CustomResponsedMessage) invokeIL.objValue;
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

    public ArrayList<HttpMessageTask> findHttpTasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mHttpManager.i();
        }
        return (ArrayList) invokeV.objValue;
    }

    public za getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mController;
        }
        return (za) invokeV.objValue;
    }

    public ha getSocketClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mSocketManager.x();
        }
        return (ha) invokeV.objValue;
    }

    private fb<?, ?, ?, ?> getManager(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            FrameHelper.TYPE e = FrameHelper.e(i);
            if (e == FrameHelper.TYPE.HTTP) {
                return this.mHttpManager;
            }
            if (e == FrameHelper.TYPE.SOCKET) {
                return this.mSocketManager;
            }
            if (e == FrameHelper.TYPE.CUSTOM) {
                return this.mCustomManager;
            }
            BdLog.e("cmd invalid");
            return null;
        }
        return (fb) invokeI.objValue;
    }

    public boolean hasListener(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            FrameHelper.TYPE e = FrameHelper.e(i);
            if (e == null) {
                return false;
            }
            int i2 = AnonymousClass16.$SwitchMap$com$baidu$adp$framework$FrameHelper$TYPE[e.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return this.mCustomManager.j(i);
                }
                return this.mSocketManager.j(i);
            }
            return this.mHttpManager.j(i);
        }
        return invokeI.booleanValue;
    }

    public void registerListener(NetMessageListener netMessageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, netMessageListener) != null) || netMessageListener == null) {
            return;
        }
        if (BdUtilHelper.isMainThread()) {
            this.mHttpManager.n(0, netMessageListener.getHttpMessageListener());
            this.mSocketManager.n(0, netMessageListener.getSocketMessageListener());
            return;
        }
        this.mUIHandler.post(new Runnable(this, netMessageListener) { // from class: com.baidu.adp.framework.MessageManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MessageManager this$0;
            public final /* synthetic */ NetMessageListener val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, netMessageListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$listener = netMessageListener;
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

    public void registerTask(MessageTask messageTask) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, messageTask) != null) || messageTask == null) {
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

    public void unRegisterListener(NetMessageListener netMessageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, netMessageListener) != null) || netMessageListener == null) {
            return;
        }
        if (BdUtilHelper.isMainThread()) {
            this.mHttpManager.u(netMessageListener.getHttpMessageListener());
            this.mSocketManager.u(netMessageListener.getSocketMessageListener());
            return;
        }
        this.mUIHandler.post(new Runnable(this, netMessageListener) { // from class: com.baidu.adp.framework.MessageManager.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MessageManager this$0;
            public final /* synthetic */ NetMessageListener val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, netMessageListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$listener = netMessageListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mHttpManager.u(this.val$listener.getHttpMessageListener());
                    this.this$0.mSocketManager.u(this.val$listener.getSocketMessageListener());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerListenerInternal(int i, MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(65548, this, i, messageListener) != null) || messageListener == null) {
            return;
        }
        FrameHelper.TYPE e = FrameHelper.e(i);
        if (e == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
            this.mHttpManager.n(i, (HttpMessageListener) messageListener);
        } else if (e == FrameHelper.TYPE.SOCKET && (messageListener instanceof SocketMessageListener)) {
            this.mSocketManager.n(i, (SocketMessageListener) messageListener);
        } else if (e == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
            this.mCustomManager.n(i, (CustomMessageListener) messageListener);
        } else {
            BdLog.e("listener invalid" + v9.a().b(i) + "|" + v9.a().b(messageListener.getCmd()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerListenerInternal(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65549, this, messageListener) != null) || messageListener == null) {
            return;
        }
        FrameHelper.TYPE e = FrameHelper.e(messageListener.getCmd());
        if (e == FrameHelper.TYPE.HTTP && (messageListener instanceof HttpMessageListener)) {
            this.mHttpManager.n(0, (HttpMessageListener) messageListener);
        } else if (e == FrameHelper.TYPE.SOCKET && (messageListener instanceof SocketMessageListener)) {
            this.mSocketManager.n(0, (SocketMessageListener) messageListener);
        } else if (e == FrameHelper.TYPE.CUSTOM && (messageListener instanceof CustomMessageListener)) {
            this.mCustomManager.n(0, (CustomMessageListener) messageListener);
        } else {
            BdLog.e("listener invalid" + v9.a().b(messageListener.getCmd()));
        }
    }

    public MessageTask findTask(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            FrameHelper.TYPE e = FrameHelper.e(i);
            if (FrameHelper.TYPE.HTTP == e) {
                return this.mHttpManager.g(i);
            }
            if (FrameHelper.TYPE.SOCKET == e) {
                return this.mSocketManager.g(i);
            }
            if (FrameHelper.TYPE.CUSTOM == e) {
                try {
                    MultiValueMap<String, String> multiValueMap = CmdRouter.cmdMaps;
                    List<String> values = multiValueMap.getValues(i + "");
                    if (values != null && values.size() > 0) {
                        for (String str : values) {
                            Class.forName(str);
                        }
                        MultiValueMap<String, String> multiValueMap2 = CmdRouter.cmdMaps;
                        multiValueMap2.remove(i + "");
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
                return this.mCustomManager.g(i);
            }
            return null;
        }
        return (MessageTask) invokeI.objValue;
    }

    public boolean sendMessage(NetMessage netMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, netMessage)) == null) {
            if (netMessage == null) {
                return false;
            }
            boolean netABTest = ((jf) ServiceManager.getService(jf.a)).netABTest();
            if (netMessage.getNetType() == NetMessage.NetType.SOCKET) {
                return sendMessage(netMessage.getSocketMessage());
            }
            if (netMessage.getNetType() != NetMessage.NetType.HTTP && !netABTest) {
                boolean u = getSocketClient().u();
                if (!u) {
                    netMessage.setSocketErrNo(1);
                }
                if (u && sendMessage(netMessage.getSocketMessage())) {
                    ja.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, Logger.SOCKET_TYPE);
                    return true;
                }
                ja.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "https");
                return sendMessage(netMessage.getHttpMessage());
            }
            return sendMessage(netMessage.getHttpMessage());
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterListenerInternal(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65551, this, messageListener) != null) || messageListener == null) {
            return;
        }
        int cmd = messageListener.getCmd();
        if (cmd != 0) {
            fb<?, ?, ?, ?> manager = getManager(cmd);
            if (manager != null) {
                manager.u(messageListener);
                return;
            }
            return;
        }
        this.mHttpManager.u(messageListener);
        this.mSocketManager.u(messageListener);
        this.mCustomManager.u(messageListener);
    }

    public void unRegisterListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bdUniqueId) == null) {
            if (BdUtilHelper.isMainThread()) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.unRegisterListenerInternal(this.val$tag);
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchResponsedMessage(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, responsedMessage) == null) {
            if (responsedMessage == null) {
                BdLog.e("responsedMessage is null!!!");
            } else if (!BdUtilHelper.isMainThread()) {
                this.mUIHandler.post(new Runnable(this, responsedMessage) { // from class: com.baidu.adp.framework.MessageManager.14
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                FrameHelper.TYPE e = FrameHelper.e(cmd);
                boolean z = false;
                if (e == FrameHelper.TYPE.HTTP && (responsedMessage instanceof HttpResponsedMessage)) {
                    q9.h("Response_Http", responsedMessage);
                    if (responsedMessage.getmOrginalMessage() != null) {
                        String valueOf = String.valueOf(((HttpResponsedMessage) responsedMessage).getHeader("tracecode"));
                        NetLog.getInstance().i("Response_Http", "分发请求结果：ErrorString : " + responsedMessage.getErrorString() + " Error : " + responsedMessage.getError() + " ClientLogId : " + responsedMessage.getmOrginalMessage().getClientLogID() + " tracecode:" + valueOf);
                    }
                    if (responsedMessage.getError() != 0) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            this.mHttpMsgCWSendFailedCnt++;
                        }
                    } else {
                        this.mHttpMsgCWSendFailedCnt = 0;
                    }
                    this.mHttpManager.d(this.mController.h((HttpResponsedMessage) responsedMessage));
                } else if (e == FrameHelper.TYPE.SOCKET && (responsedMessage instanceof SocketResponsedMessage)) {
                    q9.h("Response_Socket", responsedMessage);
                    if (responsedMessage.getmOrginalMessage() != null) {
                        NetLog.getInstance().i("Response_Socket", " ErrorString : " + responsedMessage.getErrorString() + " Error : " + responsedMessage.getError() + " logId : " + responsedMessage.getmOrginalMessage().getClientLogID());
                    }
                    if (BdBaseApplication.getInst().isDebugMode() && u9.a) {
                        Toast.makeText(BdBaseApplication.getInst().getContext(), "CMD: " + responsedMessage.getCmd(), 1).show();
                    }
                    if (responsedMessage.getError() != 0) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            this.mSocketMsgCWSendFailedCnt++;
                        }
                    } else {
                        this.mSocketMsgCWSendFailedCnt = 0;
                    }
                    Message<?> orginalMessage = responsedMessage.getOrginalMessage();
                    if (orginalMessage != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof NetMessage)) {
                        NetMessage netMessage = (NetMessage) orginalMessage.getExtra();
                        if (netMessage.getHttpMessage() != null && netMessage.getNetType() == NetMessage.NetType.AUTO) {
                            NetMessage.a switchToHttpStrategy = netMessage.getSwitchToHttpStrategy();
                            if (switchToHttpStrategy != null) {
                                z = switchToHttpStrategy.checkToSwitchHttp((SocketResponsedMessage) responsedMessage);
                            }
                            if (z || responsedMessage.getError() == ia.m) {
                                int i = 5;
                                if (responsedMessage.getError() == ia.m) {
                                    netMessage.setSocketCostTime(System.currentTimeMillis() - orginalMessage.getStartTime());
                                } else if (responsedMessage.getError() == 110004) {
                                    i = 8;
                                } else if (responsedMessage.getError() == 110005) {
                                    i = 9;
                                }
                                netMessage.setSocketErrNo(i);
                                if (netMessage.getSocketMessage() != null) {
                                    netMessage.getHttpMessage().setSquencedId(netMessage.getSocketMessage().getSquencedId());
                                }
                                HttpMessage httpMessage = netMessage.getHttpMessage();
                                if (httpMessage != null && i == 9) {
                                    httpMessage.addHeader("Retry-Count", "1");
                                }
                                if (sendMessage(httpMessage)) {
                                    this.mCustomManager.d(new CustomResponsedMessage(2000999, Integer.valueOf(responsedMessage.getCmd())));
                                    return;
                                }
                            }
                        }
                    }
                    this.mSocketManager.d(this.mController.l((SocketResponsedMessage) responsedMessage));
                } else if (e == FrameHelper.TYPE.CUSTOM && (responsedMessage instanceof CustomResponsedMessage)) {
                    CustomResponsedMessage<?> f = this.mController.f((CustomResponsedMessage) responsedMessage);
                    if (CmdRouter.cmdMaps.containsKey(cmd + "")) {
                        try {
                            if (cmd == 2002001) {
                                List<String> values = CmdRouter.cmdMaps.getValues(f.getCmd() + "");
                                String cls = f.getData().getClass().toString();
                                String substring = cls.substring(cls.lastIndexOf(".") + 1);
                                for (String str : values) {
                                    if (CmdRouter.configMaps.getValues(str).get(0).contains(substring)) {
                                        Class.forName(str);
                                        CmdRouter.configMaps.getValues(str).get(0).remove(substring);
                                    }
                                }
                            } else {
                                boolean z2 = false;
                                for (String str2 : CmdRouter.cmdMaps.getValues(cmd + "")) {
                                    try {
                                        System.currentTimeMillis();
                                        if (MultiDexHelper.task != null && MultiDexHelper.task.loadingClass(str2)) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        Class.forName(str2);
                                    } catch (Throwable th) {
                                        th = th;
                                        z = z2;
                                        BdLog.e(th);
                                        if (!z) {
                                        }
                                    }
                                }
                                CmdRouter.cmdMaps.remove(cmd + "");
                                z = z2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (!z) {
                        this.mUIHandler.postDelayed(new Runnable(this, f) { // from class: com.baidu.adp.framework.MessageManager.15
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MessageManager this$0;
                            public final /* synthetic */ ResponsedMessage val$finalResponsedMessage;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, f};
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
                                this.val$finalResponsedMessage = f;
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
                        this.mCustomManager.d(f);
                    }
                } else {
                    BdLog.e("responsedMessage invalid:CMD=" + v9.a().b(cmd) + " Class=" + responsedMessage.getClass().getName());
                }
            }
        }
    }

    public void registerListener(int i, NetMessageListener netMessageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048590, this, i, netMessageListener) != null) || netMessageListener == null) {
            return;
        }
        if (BdUtilHelper.isMainThread()) {
            this.mHttpManager.n(i, netMessageListener.getHttpMessageListener());
            this.mSocketManager.n(i, netMessageListener.getSocketMessageListener());
            return;
        }
        this.mUIHandler.post(new Runnable(this, i, netMessageListener) { // from class: com.baidu.adp.framework.MessageManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MessageManager this$0;
            public final /* synthetic */ int val$cmd;
            public final /* synthetic */ NetMessageListener val$listener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i), netMessageListener};
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
                this.val$cmd = i;
                this.val$listener = netMessageListener;
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

    public <T> CustomResponsedMessage<T> runTask(int i, Class<T> cls, Object obj) {
        InterceptResult invokeILL;
        CustomMessage<?> customMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048603, this, i, cls, obj)) == null) {
            if (obj != null) {
                customMessage = new CustomMessage<>(i);
                customMessage.setData(obj);
            } else {
                customMessage = null;
            }
            MultiValueMap<String, String> multiValueMap = CmdRouter.cmdMaps;
            if (multiValueMap.containsKey(i + "")) {
                try {
                    if (i == 2002001) {
                        MultiValueMap<String, String> multiValueMap2 = CmdRouter.cmdMaps;
                        List<String> values = multiValueMap2.getValues(i + "");
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
                        for (String str2 : multiValueMap3.getValues(i + "")) {
                            System.currentTimeMillis();
                            Class.forName(str2);
                        }
                        MultiValueMap<String, String> multiValueMap4 = CmdRouter.cmdMaps;
                        multiValueMap4.remove(i + "");
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
            db dbVar = this.mCustomManager;
            return dbVar.A(customMessage, dbVar.g(i), cls);
        }
        return (CustomResponsedMessage) invokeILL.objValue;
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessage<?> customMessage, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, customMessage, cls)) == null) {
            if (customMessage == null) {
                return null;
            }
            db dbVar = this.mCustomManager;
            return dbVar.A(customMessage, dbVar.g(customMessage.getCmd()), cls);
        }
        return (CustomResponsedMessage) invokeLL.objValue;
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessageTask customMessageTask, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, customMessageTask, cls)) == null) {
            return this.mCustomManager.A(null, customMessageTask, cls);
        }
        return (CustomResponsedMessage) invokeLL.objValue;
    }

    public boolean sendMessage(Message<?> message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, message)) == null) {
            if (message == null) {
                return false;
            }
            message.setStartTime(System.currentTimeMillis());
            if (message instanceof HttpMessage) {
                q9.h("Request_Http", message);
                return this.mHttpManager.c((HttpMessage) message, null);
            } else if (message instanceof SocketMessage) {
                q9.h("Request_Socket", message);
                TbLog netLog = NetLog.getInstance();
                netLog.i("Request_Http", "触发请求： ClientLogId : " + message.getClientLogID());
                return this.mSocketManager.c((SocketMessage) message, null);
            } else if (message instanceof CustomMessage) {
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
            } else {
                BdLog.e("message invalid" + v9.a().b(message.getCmd()));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean sendMessage(Message<?> message, MessageTask messageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, message, messageTask)) == null) {
            if (message == null) {
                return false;
            }
            if ((message instanceof HttpMessage) && (messageTask instanceof HttpMessageTask)) {
                q9.h("Request_Http", message);
                TbLog netLog = NetLog.getInstance();
                netLog.i("Request_Http", " ClientLogId : " + message.getClientLogID());
                return this.mHttpManager.c((HttpMessage) message, (HttpMessageTask) messageTask);
            } else if ((message instanceof SocketMessage) && (messageTask instanceof SocketMessageTask)) {
                q9.h("Request_Socket", message);
                TbLog netLog2 = NetLog.getInstance();
                netLog2.i("Request_Http", " ClientLogId : " + message.getClientLogID());
                return this.mSocketManager.c((SocketMessage) message, (SocketMessageTask) messageTask);
            } else if ((message instanceof CustomMessage) && (messageTask instanceof CustomMessageTask)) {
                return this.mCustomManager.c((CustomMessage) message, (CustomMessageTask) messageTask);
            } else {
                BdLog.e("message and task invalid:" + v9.a().b(message.getCmd()));
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean sendMessage(NetMessage netMessage, SocketMessageTask socketMessageTask, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048609, this, netMessage, socketMessageTask, httpMessageTask)) == null) {
            if (netMessage == null) {
                return false;
            }
            if (netMessage.getNetType() == NetMessage.NetType.SOCKET) {
                return sendMessage(netMessage.getSocketMessage(), socketMessageTask);
            }
            if (netMessage.getNetType() == NetMessage.NetType.HTTP) {
                return sendMessage(netMessage.getHttpMessage(), httpMessageTask);
            }
            boolean u = getSocketClient().u();
            if (!u) {
                netMessage.setSocketErrNo(1);
            }
            if (u && sendMessage(netMessage.getSocketMessage(), socketMessageTask)) {
                ja.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, Logger.SOCKET_TYPE);
                return true;
            }
            ja.c(MODULE_NAME, netMessage.getSocketMessage(), 0, "sendMessage", 0, "https");
            return sendMessage(netMessage.getHttpMessage(), httpMessageTask);
        }
        return invokeLLL.booleanValue;
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, messageListener) != null) || messageListener == null) {
            return;
        }
        if (BdUtilHelper.isMainThread()) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.unRegisterListenerInternal(this.val$listener);
                }
            });
        }
    }
}
