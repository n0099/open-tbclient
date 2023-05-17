package com.baidu.swan.apps.console.v8inspector.websocket;

import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import java.io.IOException;
/* loaded from: classes4.dex */
public class WebSocketException extends IOException {
    public final WebSocketFrame.CloseCode mCode;
    public final String mReason;

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
