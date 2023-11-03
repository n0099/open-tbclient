package com.baidu.swan.pms;

import com.baidu.tieba.pd4;
/* loaded from: classes4.dex */
public class PMSConstants {

    /* loaded from: classes4.dex */
    public static final class a {
        public static int a() {
            return 1;
        }
    }

    public static boolean a(pd4 pd4Var) {
        if (pd4Var != null && pd4Var.x()) {
            return true;
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public enum CloudSwitch {
        NO_DISPLAY(0),
        DISPLAY(1);
        
        public int value;

        CloudSwitch(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum CustomerService {
        NO_CUSTOMER_SERVICE(0),
        CUSTOMER_SERVICE(1);
        
        public int type;

        CustomerService(int i) {
            this.type = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum PayProtected {
        NO_PAY_PROTECTED(0),
        PAY_PROTECTED(1);
        
        public int type;

        PayProtected(int i) {
            this.type = i;
        }
    }
}
