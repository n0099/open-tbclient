package com.baidu.adp.framework.client.socket.link;

import com.baidu.adp.lib.webSocket.k;
import java.util.Map;
/* loaded from: classes.dex */
public interface a {
    void a(com.baidu.adp.lib.webSocket.c cVar);

    void a(k.a aVar);

    boolean onClose(int i, String str);

    void onConnected(Map<String, String> map);

    void onTextMessage(String str);
}
