package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b aem = new a();
    private static final b aen = new c();
    private static final boolean aeo;

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
            al alVar = new al("c10729");
            alVar.ac("obj_param1", str);
            alVar.ac("obj_param2", str2);
            alVar.ac("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(alVar);
            }
        }
    }

    public static void k(String str, String str2, String str3) {
        if (aeo) {
            aem.k(str, str2, str3);
        }
        aen.k(str, str2, str3);
    }

    public static void df(String str) {
        if (aeo) {
            aem.k(null, null, str);
        }
    }

    public static void l(String str, String str2, String str3) {
        df(str3);
    }

    static {
        aeo = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
