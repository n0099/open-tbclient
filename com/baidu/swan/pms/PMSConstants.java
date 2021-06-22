package com.baidu.swan.pms;
/* loaded from: classes3.dex */
public class PMSConstants {

    /* loaded from: classes3.dex */
    public enum CloudSwitch {
        NO_DISPLAY(0),
        DISPLAY(1);
        
        public int value;

        CloudSwitch(int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes3.dex */
    public enum CustomerService {
        NO_CUSTOMER_SERVICE(0),
        CUSTOMER_SERVICE(1);
        
        public int type;

        CustomerService(int i2) {
            this.type = i2;
        }
    }

    /* loaded from: classes3.dex */
    public enum PayProtected {
        NO_PAY_PROTECTED(0),
        PAY_PROTECTED(1);
        
        public int type;

        PayProtected(int i2) {
            this.type = i2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public static String a(int i2, String str) {
            if (i2 != 1020) {
                switch (i2) {
                    case 1001:
                        return "system error";
                    case 1002:
                        return "the request is prohibited";
                    case 1003:
                        return "invalid common params";
                    case 1004:
                        return "invalid query params";
                    default:
                        switch (i2) {
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
                            default:
                                return "";
                        }
                }
            }
            return str;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static int a() {
            return 1;
        }
    }

    public static boolean a(d.a.m0.n.a aVar) {
        if (aVar == null || !aVar.f()) {
            if (aVar != null) {
                aVar.I("swan_bdtls_pms_encrypt", false);
                return false;
            }
            return false;
        }
        return true;
    }
}
