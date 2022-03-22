package com.baidu.searchbox.websocket;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.ReturnKeyType;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketTask;", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "", "code", "", "reason", "", IntentConfig.CLOSE, "(ILjava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "request", "Lcom/baidu/searchbox/websocket/IWebSocketListener;", "listener", "connect", "(Lcom/baidu/searchbox/websocket/WebSocketRequest;Lcom/baidu/searchbox/websocket/IWebSocketListener;)V", "Ljava/nio/ByteBuffer;", "data", ReturnKeyType.SEND, "(Ljava/nio/ByteBuffer;)V", "message", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "toJSON", "()Lorg/json/JSONObject;", "taskId", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "webSocketClient", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "<init>", "(Lcom/baidu/searchbox/websocket/IWebSocketClient;)V", "websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class WebSocketTask implements IWebSocketClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String taskId;
    public final IWebSocketClient webSocketClient;

    public WebSocketTask(IWebSocketClient webSocketClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webSocketClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(webSocketClient, "webSocketClient");
        this.webSocketClient = webSocketClient;
        this.taskId = "WebSocketTask-" + System.currentTimeMillis();
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void close(int i, String reason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, reason) == null) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.webSocketClient.close(i, reason);
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void connect(WebSocketRequest request, final IWebSocketListener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, listener) == null) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.webSocketClient.connect(request, new IWebSocketListener(this, listener) { // from class: com.baidu.searchbox.websocket.WebSocketTask$connect$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ IWebSocketListener $$delegate_0;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IWebSocketListener $listener;
                public final /* synthetic */ WebSocketTask this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, listener};
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
                    this.$listener = listener;
                    this.$$delegate_0 = listener;
                }

                @Override // com.baidu.searchbox.websocket.IWebSocketListener
                public void onClose(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        IWebSocketListener iWebSocketListener = this.$listener;
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        iWebSocketListener.onClose(jSONObject.put("taskID", this.this$0.getTaskId()));
                    }
                }

                @Override // com.baidu.searchbox.websocket.IWebSocketListener
                public void onError(Throwable t, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, jSONObject) == null) {
                        Intrinsics.checkNotNullParameter(t, "t");
                        IWebSocketListener iWebSocketListener = this.$listener;
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        iWebSocketListener.onError(t, jSONObject.put("taskID", this.this$0.getTaskId()));
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
        }
    }

    public final String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.taskId : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(String message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.webSocketClient.send(message);
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(ByteBuffer data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.webSocketClient.send(data);
        }
    }

    public final JSONObject toJSON() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.taskId);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
