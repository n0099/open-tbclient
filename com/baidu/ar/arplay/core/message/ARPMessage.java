package com.baidu.ar.arplay.core.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ARPMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_MESSAGE_ID = -1;
    public static final int MSG_MESSAGE_FROM_ENGINE = 1;
    public static ARPMessage mARPMessage;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public boolean mIsInitNative;
    public List<ArCallback> mMsgHandlers;
    public HandlerThread mThread;

    /* loaded from: classes3.dex */
    public static class ArCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MessageHandler mHandler;
        public int mMessageId;
        public int mMessageType;

        public ArCallback(int i, int i2, MessageHandler messageHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), messageHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMessageType = i;
            this.mMessageId = i2;
            this.mHandler = messageHandler;
        }
    }

    /* loaded from: classes3.dex */
    public static class ArMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, Object> mData;
        public int mMessageID;
        public int mMessageType;
        public int mResMessageID;

        public ArMessage(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), hashMap, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMessageType = i;
            this.mMessageID = i2;
            this.mData = hashMap;
            this.mResMessageID = i3;
        }
    }

    /* loaded from: classes3.dex */
    public interface MessageHandler {
        void handleMessage(int i, int i2, HashMap<String, Object> hashMap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(739831189, "Lcom/baidu/ar/arplay/core/message/ARPMessage;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(739831189, "Lcom/baidu/ar/arplay/core/message/ARPMessage;");
        }
    }

    public ARPMessage() {
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
        this.mIsInitNative = false;
        HandlerThread handlerThread = new HandlerThread("msg_callback_thread");
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), new Handler.Callback(this) { // from class: com.baidu.ar.arplay.core.message.ARPMessage.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ARPMessage this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    if (message.what != 1) {
                        return false;
                    }
                    this.this$0.processIncomingMessage((ArMessage) message.obj);
                    return false;
                }
                return invokeL.booleanValue;
            }
        });
        this.mMsgHandlers = new LinkedList();
    }

    public static ARPMessage getInstance() {
        InterceptResult invokeV;
        ARPMessage aRPMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ARPMessage aRPMessage2 = mARPMessage;
            if (aRPMessage2 == null) {
                synchronized (ARPMessage.class) {
                    if (mARPMessage == null) {
                        mARPMessage = new ARPMessage();
                    }
                    aRPMessage = mARPMessage;
                }
                return aRPMessage;
            }
            return aRPMessage2;
        }
        return (ARPMessage) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(ArMessage arMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, arMessage) == null) {
            for (ArCallback arCallback : this.mMsgHandlers) {
                int i = arCallback.mMessageType;
                if (i == 0 || arMessage.mMessageType == i) {
                    int i2 = arCallback.mMessageId;
                    if (-1 == i2 || arMessage.mResMessageID == i2) {
                        arCallback.mHandler.handleMessage(arMessage.mMessageType, arMessage.mMessageID, arMessage.mData);
                    }
                }
            }
        }
    }

    public static void receiveMsgFromEngine(Object obj, int i, int i2, HashMap<String, Object> hashMap, int i3) {
        ARPMessage aRPMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), hashMap, Integer.valueOf(i3)}) == null) || (aRPMessage = (ARPMessage) ((WeakReference) obj).get()) == null) {
            return;
        }
        aRPMessage.receiveMsgFromEngine(i, i2, hashMap, i3);
    }

    private void sendMessageImpl(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), hashMap, Integer.valueOf(i3)}) == null) && ARPEngine.getInstance().isEngineCanAccess()) {
            if (-1 == i2) {
                i2 = getMessageID();
            }
            sendMessageToEngine(i, i2, hashMap, i3);
        }
    }

    private void sendMessageImpl(int i, HashMap<String, Object> hashMap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i), hashMap, Integer.valueOf(i2)}) == null) {
            sendMessageImpl(i, -1, hashMap, i2);
        }
    }

    public native int getMessageID();

    public native void nativeFinalize();

    public native void nativeSetup(Object obj);

    public void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), hashMap, Integer.valueOf(i3)}) == null) {
            Log.d("ARPMessage", "receiveMsgFromEngine :" + i);
            this.mHandler.obtainMessage(1, new ArMessage(i, i2, hashMap, i3)).sendToTarget();
        }
    }

    public synchronized void registerMessageHandler(int i, MessageHandler messageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, messageHandler) == null) {
            synchronized (this) {
                this.mHandler.post(new Runnable(this, i, messageHandler) { // from class: com.baidu.ar.arplay.core.message.ARPMessage.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ARPMessage this$0;
                    public final /* synthetic */ MessageHandler val$aMessageHandler;
                    public final /* synthetic */ int val$aMessageType;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), messageHandler};
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
                        this.val$aMessageType = i;
                        this.val$aMessageHandler = messageHandler;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mMsgHandlers.add(new ArCallback(this.val$aMessageType, -1, this.val$aMessageHandler));
                        }
                    }
                });
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mHandler.removeCallbacks(null);
            this.mHandler.post(new Runnable(this) { // from class: com.baidu.ar.arplay.core.message.ARPMessage.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ARPMessage this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mMsgHandlers == null) {
                        return;
                    }
                    this.this$0.mMsgHandlers.clear();
                }
            });
            nativeFinalize();
            this.mIsInitNative = false;
        }
    }

    public synchronized void removeMessageHandeler(MessageHandler messageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, messageHandler) == null) {
            synchronized (this) {
                this.mHandler.post(new Runnable(this, messageHandler) { // from class: com.baidu.ar.arplay.core.message.ARPMessage.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ARPMessage this$0;
                    public final /* synthetic */ MessageHandler val$aMessageHandler;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, messageHandler};
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
                        this.val$aMessageHandler = messageHandler;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mMsgHandlers == null) {
                            return;
                        }
                        Iterator it = this.this$0.mMsgHandlers.iterator();
                        while (it.hasNext()) {
                            if (((ArCallback) it.next()).mHandler == this.val$aMessageHandler) {
                                it.remove();
                            }
                        }
                    }
                });
            }
        }
    }

    public void sendLuaScriptToEngine(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("script", str);
        sendMessage(2001, hashMap);
    }

    public void sendMessage(int i, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, hashMap) == null) {
            sendMessageImpl(i, hashMap, -1);
        }
    }

    public native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    public void sendResponseMessage(int i, HashMap<String, Object> hashMap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), hashMap, Integer.valueOf(i2)}) == null) {
            sendMessageImpl(i, hashMap, i2);
        }
    }

    public void setModelVirtualColor(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(ARPMessageType.ARPMessageParamKeys.MODEL_COLOR_KEY, Integer.valueOf(i));
            if (!z) {
                hashMap.put(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, 1);
            }
            sendMessage(2002, hashMap);
        }
    }

    public void setUp() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.mIsInitNative) {
            return;
        }
        nativeSetup(new WeakReference(this));
        this.mIsInitNative = true;
    }
}
