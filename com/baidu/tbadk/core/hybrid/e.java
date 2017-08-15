package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b adv = new a();
    private static final b adw = new c();
    private static final boolean adx;

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
            aj ajVar = new aj("c10729");
            ajVar.aa("obj_param1", str);
            ajVar.aa("obj_param2", str2);
            ajVar.aa("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(ajVar);
            }
        }
    }

    public static void j(String str, String str2, String str3) {
        if (adx) {
            adv.j(str, str2, str3);
        }
        adw.j(str, str2, str3);
    }

    public static void cW(String str) {
        if (adx) {
            adv.j(null, null, str);
        }
    }

    public static void k(String str, String str2, String str3) {
        cW(str3);
    }

    static {
        adx = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
