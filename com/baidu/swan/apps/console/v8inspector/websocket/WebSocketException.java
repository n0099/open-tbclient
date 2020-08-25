package com.baidu.swan.apps.console.v8inspector.websocket;

import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import java.io.IOException;
/* loaded from: classes8.dex */
public class WebSocketException extends IOException {
    private final WebSocketFrame.CloseCode mCode;
    private final String mReason;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketException(WebSocketFrame.CloseCode closeCode, String str) {
        super(closeCode + ": " + str);
        this.mCode = closeCode;
        this.mReason = str;
    }

    public WebSocketFrame.CloseCode getCode() {
        return this.mCode;
    }

    public String getReason() {
        return this.mReason;
    }
}
