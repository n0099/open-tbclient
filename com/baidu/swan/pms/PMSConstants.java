package com.baidu.swan.pms;
/* loaded from: classes15.dex */
public class PMSConstants {

    /* loaded from: classes15.dex */
    public static final class a {
        public static String aw(int i, String str) {
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
                case 1006:
                case 1007:
                case 1008:
                case 1009:
                case 1016:
                case 1017:
                case 1018:
                case 1019:
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
                case 1015:
                    return "the host app is not support this app";
                case 1020:
                    return str;
            }
        }
    }

    /* loaded from: classes15.dex */
    public enum PayProtected {
        NO_PAY_PROTECTED(0),
        PAY_PROTECTED(1);
        
        public int type;

        PayProtected(int i) {
            this.type = i;
        }
    }

    /* loaded from: classes15.dex */
    public enum CustomerService {
        NO_CUSTOMER_SERVICE(0),
        CUSTOMER_SERVICE(1);
        
        public int type;

        CustomerService(int i) {
            this.type = i;
        }
    }

    /* loaded from: classes15.dex */
    public enum CloudSwitch {
        NO_DISPLAY(0),
        DISPLAY(1);
        
        public int value;

        CloudSwitch(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes15.dex */
    public static final class b {
        public static int getVersion() {
            return 1;
        }
    }
}
