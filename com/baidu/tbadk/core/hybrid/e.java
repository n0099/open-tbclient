package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b aRs = new a();
    private static final b aRt = new c();
    private static final boolean aRu;

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
            ak akVar = new ak("c10729");
            akVar.ab("obj_param1", str);
            akVar.ab("obj_param2", str2);
            akVar.ab("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(akVar);
            }
        }
    }

    public static void l(String str, String str2, String str3) {
        if (aRu) {
            aRs.l(str, str2, str3);
        }
        aRt.l(str, str2, str3);
    }

    public static void dc(String str) {
        if (aRu) {
            aRs.l(null, null, str);
        }
    }

    public static void m(String str, String str2, String str3) {
        dc(str3);
    }

    static {
        aRu = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
