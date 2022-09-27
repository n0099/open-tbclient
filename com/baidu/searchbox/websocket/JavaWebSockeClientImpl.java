package com.baidu.searchbox.websocket;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.iv9;
import com.baidu.tieba.lv9;
import com.baidu.tieba.ou9;
import com.baidu.tieba.pu9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.java_websocket.drafts.Draft;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/websocket/JavaWebSockeClientImpl;", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "", "code", "", "reason", "", "close", "(ILjava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "request", "Lcom/baidu/searchbox/websocket/IWebSocketListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "connect", "(Lcom/baidu/searchbox/websocket/WebSocketRequest;Lcom/baidu/searchbox/websocket/IWebSocketListener;)V", "Ljava/nio/ByteBuffer;", "data", "send", "(Ljava/nio/ByteBuffer;)V", "message", "(Ljava/lang/String;)V", "Lorg/java_websocket/client/WebSocketClient;", "webSocketClient", "Lorg/java_websocket/client/WebSocketClient;", "<init>", "()V", "websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class JavaWebSockeClientImpl implements IWebSocketClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ou9 webSocketClient;

    public JavaWebSockeClientImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void close(int i, String reason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, reason) == null) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            ou9 ou9Var = this.webSocketClient;
            if (ou9Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
            }
            ou9Var.close();
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void connect(final WebSocketRequest request, final IWebSocketListener listener) {
        List listOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, listener) == null) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(listener, "listener");
            final URI create = URI.create(request.getUrl());
            List emptyList = CollectionsKt__CollectionsKt.emptyList();
            List<String> protocols = request.getProtocols();
            if (protocols != null) {
                listOf = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(protocols, 10));
                for (String str : protocols) {
                    listOf.add(new lv9(str));
                }
            } else {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new lv9(""));
            }
            final pu9 pu9Var = new pu9(emptyList, listOf);
            final Map<String, String> headers = request.getHeaders();
            this.webSocketClient = new ou9(listener, request, create, pu9Var, headers) { // from class: com.baidu.searchbox.websocket.JavaWebSockeClientImpl$connect$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IWebSocketListener $listener;
                public final /* synthetic */ WebSocketRequest $request;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(create, pu9Var, headers);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {listener, request, create, pu9Var, headers};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((URI) objArr2[0], (Draft) objArr2[1], (Map) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$listener = listener;
                    this.$request = request;
                }

                @Override // com.baidu.tieba.ou9
                public void onClose(int i, String str2, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, Boolean.valueOf(z)}) == null) {
                        IWebSocketListener iWebSocketListener = this.$listener;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i);
                        if (str2 == null) {
                            str2 = "";
                        }
                        jSONObject.put("reason", str2);
                        Unit unit = Unit.INSTANCE;
                        iWebSocketListener.onClose(jSONObject);
                    }
                }

                @Override // com.baidu.tieba.ou9
                public void onError(Exception p0) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p0) == null) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        this.$listener.onError(p0, null);
                    }
                }

                @Override // com.baidu.tieba.ou9
                public void onMessage(String p0) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, p0) == null) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        this.$listener.onMessage(p0);
                    }
                }

                @Override // com.baidu.tieba.ou9
                public void onOpen(iv9 iv9Var) {
                    Iterator<String> g;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, iv9Var) == null) {
                        HashMap hashMap = new HashMap();
                        if (iv9Var != null && (g = iv9Var.g()) != null) {
                            while (g.hasNext()) {
                                String next = g.next();
                                hashMap.put(next, iv9Var.d(next));
                            }
                        }
                        this.$listener.onOpen(hashMap);
                    }
                }

                @Override // com.baidu.tieba.ou9
                public void onMessage(ByteBuffer bytes) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, bytes) == null) {
                        Intrinsics.checkNotNullParameter(bytes, "bytes");
                        this.$listener.onMessage(bytes);
                    }
                }
            };
            Integer connectionLostTimeout = request.getConnectionLostTimeout();
            if (connectionLostTimeout != null) {
                int intValue = connectionLostTimeout.intValue();
                ou9 ou9Var = this.webSocketClient;
                if (ou9Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
                }
                ou9Var.setConnectionLostTimeout(intValue);
            }
            ou9 ou9Var2 = this.webSocketClient;
            if (ou9Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
            }
            ou9Var2.connect();
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(String message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            Intrinsics.checkNotNullParameter(message, "message");
            ou9 ou9Var = this.webSocketClient;
            if (ou9Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
            }
            ou9Var.send(message);
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(ByteBuffer data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            ou9 ou9Var = this.webSocketClient;
            if (ou9Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
            }
            ou9Var.send(data);
        }
    }
}
