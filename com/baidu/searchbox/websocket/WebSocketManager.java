package com.baidu.searchbox.websocket;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.tachikoma.core.component.input.ReturnKeyType;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0018R2\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u0019j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r`\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketManager;", "", RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID, "", "code", "reason", "", IntentConfig.CLOSE, "(Ljava/lang/String;ILjava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "request", "Lcom/baidu/searchbox/websocket/IWebSocketListener;", "listener", "Lcom/baidu/searchbox/websocket/WebSocketTask;", "connect", "(Lcom/baidu/searchbox/websocket/WebSocketRequest;Lcom/baidu/searchbox/websocket/IWebSocketListener;)Lcom/baidu/searchbox/websocket/WebSocketTask;", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "createWebSocketClientImpl", "()Lcom/baidu/searchbox/websocket/IWebSocketClient;", "Ljava/nio/ByteBuffer;", "data", ReturnKeyType.SEND, "(Ljava/lang/String;Ljava/nio/ByteBuffer;)V", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mTasks", "Ljava/util/HashMap;", "<init>", "()V", "websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class WebSocketManager {
    public static /* synthetic */ Interceptable $ic;
    public static final WebSocketManager INSTANCE;
    public static HashMap<String, WebSocketTask> mTasks;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-184716397, "Lcom/baidu/searchbox/websocket/WebSocketManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-184716397, "Lcom/baidu/searchbox/websocket/WebSocketManager;");
                return;
            }
        }
        INSTANCE = new WebSocketManager();
        mTasks = new HashMap<>();
    }

    public WebSocketManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private final IWebSocketClient createWebSocketClientImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new JavaWebSockeClientImpl() : (IWebSocketClient) invokeV.objValue;
    }

    public final void close(String taskId, int i2, String reason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, taskId, i2, reason) == null) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(reason, "reason");
            HashMap<String, WebSocketTask> hashMap = mTasks;
            if (hashMap.containsKey(taskId)) {
                WebSocketTask webSocketTask = hashMap.get(taskId);
                if (webSocketTask != null) {
                    webSocketTask.close(i2, reason);
                }
                hashMap.remove(taskId);
                return;
            }
            throw new IllegalStateException("The specified Task was not found, taskId = " + taskId);
        }
    }

    public final WebSocketTask connect(WebSocketRequest request, final IWebSocketListener listener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, listener)) == null) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(listener, "listener");
            final WebSocketTask webSocketTask = new WebSocketTask(createWebSocketClientImpl());
            webSocketTask.connect(request, new IWebSocketListener(listener, webSocketTask) { // from class: com.baidu.searchbox.websocket.WebSocketManager$connect$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ IWebSocketListener $$delegate_0;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IWebSocketListener $listener;
                public final /* synthetic */ WebSocketTask $task;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {listener, webSocketTask};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$listener = listener;
                    this.$task = webSocketTask;
                    this.$$delegate_0 = listener;
                }

                @Override // com.baidu.searchbox.websocket.IWebSocketListener
                public void onClose(JSONObject jSONObject) {
                    HashMap hashMap;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        this.$listener.onClose(jSONObject);
                        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                        hashMap = WebSocketManager.mTasks;
                        hashMap.remove(this.$task.getTaskId());
                    }
                }

                @Override // com.baidu.searchbox.websocket.IWebSocketListener
                public void onError(Throwable t, JSONObject jSONObject) {
                    HashMap hashMap;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, jSONObject) == null) {
                        Intrinsics.checkNotNullParameter(t, "t");
                        this.$listener.onError(t, jSONObject);
                        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                        hashMap = WebSocketManager.mTasks;
                        hashMap.remove(this.$task.getTaskId());
                    }
                }

                @Override // com.baidu.searchbox.websocket.IWebSocketListener
                public void onMessage(String message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                        Intrinsics.checkNotNullParameter(message, "message");
                        this.$$delegate_0.onMessage(message);
                    }
                }

                @Override // com.baidu.searchbox.websocket.IWebSocketListener
                public void onMessage(ByteBuffer data) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, data) == null) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        this.$$delegate_0.onMessage(data);
                    }
                }

                @Override // com.baidu.searchbox.websocket.IWebSocketListener
                public void onOpen(Map<String, String> headers) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, headers) == null) {
                        Intrinsics.checkNotNullParameter(headers, "headers");
                        this.$$delegate_0.onOpen(headers);
                    }
                }
            });
            mTasks.put(webSocketTask.getTaskId(), webSocketTask);
            return webSocketTask;
        }
        return (WebSocketTask) invokeLL.objValue;
    }

    public final void send(String taskId, String message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, taskId, message) == null) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(message, "message");
            WebSocketTask webSocketTask = mTasks.get(taskId);
            if (webSocketTask != null) {
                webSocketTask.send(message);
                return;
            }
            throw new IllegalStateException("The specified Task was not found, taskId = " + taskId);
        }
    }

    public final void send(String taskId, ByteBuffer data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, taskId, data) == null) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(data, "data");
            WebSocketTask webSocketTask = mTasks.get(taskId);
            if (webSocketTask != null) {
                webSocketTask.send(data);
                return;
            }
            throw new IllegalStateException("The specified Task was not found, taskId = " + taskId);
        }
    }
}
