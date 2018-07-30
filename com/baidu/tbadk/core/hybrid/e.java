package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b amo = new a();
    private static final b amp = new c();
    private static final boolean amq;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void l(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void l(String str, String str2, String str3) {
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
        public void l(String str, String str2, String str3) {
            an anVar = new an("c10729");
            anVar.af("obj_param1", str);
            anVar.af("obj_param2", str2);
            anVar.af("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void l(String str, String str2, String str3) {
        if (amq) {
            amo.l(str, str2, str3);
        }
        amp.l(str, str2, str3);
    }

    public static void dE(String str) {
        if (amq) {
            amo.l(null, null, str);
        }
    }

    public static void m(String str, String str2, String str3) {
        dE(str3);
    }

    static {
        amq = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
