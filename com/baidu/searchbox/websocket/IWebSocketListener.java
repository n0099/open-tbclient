package com.baidu.searchbox.websocket;

import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\r\u0010\u0011J#\u0010\u0014\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/websocket/IWebSocketListener;", "Lkotlin/Any;", "Lorg/json/JSONObject;", "params", "", "onClose", "(Lorg/json/JSONObject;)V", "", "t", "onError", "(Ljava/lang/Throwable;Lorg/json/JSONObject;)V", "Ljava/nio/ByteBuffer;", "data", "onMessage", "(Ljava/nio/ByteBuffer;)V", "", "message", "(Ljava/lang/String;)V", "", "headers", "onOpen", "(Ljava/util/Map;)V", "websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IWebSocketListener {
    void onClose(JSONObject jSONObject);

    void onError(Throwable th, JSONObject jSONObject);

    void onMessage(String str);

    void onMessage(ByteBuffer byteBuffer);

    void onOpen(Map<String, String> map);
}
