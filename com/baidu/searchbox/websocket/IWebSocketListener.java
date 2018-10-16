package com.baidu.searchbox.websocket;

import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IWebSocketListener {
    void onClose(JSONObject jSONObject);

    void onError(Throwable th, JSONObject jSONObject);

    void onMessage(String str);

    void onMessage(ByteBuffer byteBuffer);

    void onOpen(Map<String, String> map);
}
