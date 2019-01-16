package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b ayC = new a();
    private static final b ayD = new c();
    private static final boolean ayE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void o(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void o(String str, String str2, String str3) {
            if (str2 != null) {
                str3 = "code:" + str2 + " message:" + str3;
            }
            Log.e("BridgeLogger", str3);
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements b {
        private c() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void o(String str, String str2, String str3) {
            am amVar = new am("c10729");
            amVar.aB("obj_param1", str);
            amVar.aB("obj_param2", str2);
            amVar.aB("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(amVar);
            }
        }
    }

    public static void o(String str, String str2, String str3) {
        if (ayE) {
            ayC.o(str, str2, str3);
        }
        ayD.o(str, str2, str3);
    }

    public static void eN(String str) {
        if (ayE) {
            ayC.o(null, null, str);
        }
    }

    public static void p(String str, String str2, String str3) {
        eN(str3);
    }

    static {
        ayE = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
