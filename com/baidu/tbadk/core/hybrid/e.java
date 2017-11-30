package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b adk = new a();
    private static final b adl = new c();
    private static final boolean adm;

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
        if (adm) {
            adk.j(str, str2, str3);
        }
        adl.j(str, str2, str3);
    }

    public static void cV(String str) {
        if (adm) {
            adk.j(null, null, str);
        }
    }

    public static void k(String str, String str2, String str3) {
        cV(str3);
    }

    static {
        adm = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
