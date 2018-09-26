package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b aoU = new a();
    private static final b aoV = new c();
    private static final boolean aoW;

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
            am amVar = new am("c10729");
            amVar.al("obj_param1", str);
            amVar.al("obj_param2", str2);
            amVar.al("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(amVar);
            }
        }
    }

    public static void l(String str, String str2, String str3) {
        if (aoW) {
            aoU.l(str, str2, str3);
        }
        aoV.l(str, str2, str3);
    }

    public static void dW(String str) {
        if (aoW) {
            aoU.l(null, null, str);
        }
    }

    public static void m(String str, String str2, String str3) {
        dW(str3);
    }

    static {
        aoW = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
