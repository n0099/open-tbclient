package com.baidu.searchbox.websocket;

import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.h;
import org.json.JSONObject;
@h
/* loaded from: classes12.dex */
public interface IWebSocketListener {
    void onClose(JSONObject jSONObject);

    void onError(Throwable th, JSONObject jSONObject);

    void onMessage(String str);

    void onMessage(ByteBuffer byteBuffer);

    void onOpen(Map<String, String> map);
}
