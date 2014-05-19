package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class WebSocketStateHelper {
    private static WebSocketStateInfo a = WebSocketStateInfo.ONLINE;

    /* loaded from: classes.dex */
    public enum WebSocketStateInfo {
        UNAVAIL,
        ONLINE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static WebSocketStateInfo[] valuesCustom() {
            WebSocketStateInfo[] valuesCustom = values();
            int length = valuesCustom.length;
            WebSocketStateInfo[] webSocketStateInfoArr = new WebSocketStateInfo[length];
            System.arraycopy(valuesCustom, 0, webSocketStateInfoArr, 0, length);
            return webSocketStateInfoArr;
        }
    }

    public static boolean a() {
        return a == WebSocketStateInfo.ONLINE;
    }

    public static void a(WebSocketStateInfo webSocketStateInfo) {
        a = webSocketStateInfo;
    }
}
