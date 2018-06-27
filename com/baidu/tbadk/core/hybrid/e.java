package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b amO = new a();
    private static final b amP = new c();
    private static final boolean amQ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void k(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void k(String str, String str2, String str3) {
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
        public void k(String str, String str2, String str3) {
            an anVar = new an("c10729");
            anVar.ah("obj_param1", str);
            anVar.ah("obj_param2", str2);
            anVar.ah("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void k(String str, String str2, String str3) {
        if (amQ) {
            amO.k(str, str2, str3);
        }
        amP.k(str, str2, str3);
    }

    public static void dH(String str) {
        if (amQ) {
            amO.k(null, null, str);
        }
    }

    public static void l(String str, String str2, String str3) {
        dH(str3);
    }

    static {
        amQ = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
