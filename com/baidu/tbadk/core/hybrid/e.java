package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b acq = new a();
    private static final b acr = new c();
    private static final boolean acs;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void j(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void j(String str, String str2, String str3) {
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
        public void j(String str, String str2, String str3) {
            ak akVar = new ak("c10729");
            akVar.ac("obj_param1", str);
            akVar.ac("obj_param2", str2);
            akVar.ac("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(akVar);
            }
        }
    }

    public static void j(String str, String str2, String str3) {
        if (acs) {
            acq.j(str, str2, str3);
        }
        acr.j(str, str2, str3);
    }

    public static void cO(String str) {
        if (acs) {
            acq.j(null, null, str);
        }
    }

    public static void k(String str, String str2, String str3) {
        cO(str3);
    }

    static {
        acs = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
