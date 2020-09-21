package com.baidu.live.adp.framework.client.socket.link;

import java.util.Map;
/* loaded from: classes4.dex */
public interface ConnStateCallback {
    boolean onClose(int i, String str);

    void onConnected(Map<String, String> map);

    void onTextMessage(String str);
}
