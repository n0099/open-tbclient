package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b bPa = new a();
    private static final b bPb = new c();
    private static final boolean bPc;

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
            an anVar = new an("c10729");
            anVar.bT("obj_param1", str);
            anVar.bT("obj_param2", str2);
            anVar.bT("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void D(String str, String str2, String str3) {
        if (bPc) {
            bPa.D(str, str2, str3);
        }
        bPb.D(str, str2, str3);
    }

    public static void mT(String str) {
        if (bPc) {
            bPa.D(null, null, str);
        }
    }

    public static void E(String str, String str2, String str3) {
        mT(str3);
    }

    static {
        bPc = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
