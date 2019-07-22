package com.baidu.swan.pms;

import android.support.v4.view.PointerIconCompat;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static final class a {
        public static String fG(int i) {
            switch (i) {
                case 1001:
                    return "system error";
                case 1002:
                    return "the request is prohibited";
                case 1003:
                    return "invalid common params";
                case 1004:
                    return "invalid query params";
                case 1005:
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                default:
                    return "";
                case 1010:
                    return "the current package is the latest";
                case 1011:
                    return "the app is not exist";
                case 1012:
                    return "the package is not exist";
                case 1013:
                    return "please upgrade SDK version";
                case 1014:
                    return "the framework is not available";
                case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /* 1015 */:
                    return "the host app is not support this app";
            }
        }
    }
}
