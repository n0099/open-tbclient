package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b bOa = new a();
    private static final b bOb = new c();
    private static final boolean bOc;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void D(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void D(String str, String str2, String str3) {
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
        public void D(String str, String str2, String str3) {
            am amVar = new am("c10729");
            amVar.bT("obj_param1", str);
            amVar.bT("obj_param2", str2);
            amVar.bT("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(amVar);
            }
        }
    }

    public static void D(String str, String str2, String str3) {
        if (bOc) {
            bOa.D(str, str2, str3);
        }
        bOb.D(str, str2, str3);
    }

    public static void mI(String str) {
        if (bOc) {
            bOa.D(null, null, str);
        }
    }

    public static void E(String str, String str2, String str3) {
        mI(str3);
    }

    static {
        bOc = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
