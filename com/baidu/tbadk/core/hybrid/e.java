package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final boolean bGB;
    private static final b bGz = new a();
    private static final b bGA = new c();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void B(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void B(String str, String str2, String str3) {
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
        public void B(String str, String str2, String str3) {
            am amVar = new am("c10729");
            amVar.bJ("obj_param1", str);
            amVar.bJ("obj_param2", str2);
            amVar.bJ("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(amVar);
            }
        }
    }

    public static void B(String str, String str2, String str3) {
        if (bGB) {
            bGz.B(str, str2, str3);
        }
        bGA.B(str, str2, str3);
    }

    public static void lC(String str) {
        if (bGB) {
            bGz.B(null, null, str);
        }
    }

    public static void C(String str, String str2, String str3) {
        lC(str3);
    }

    static {
        bGB = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
