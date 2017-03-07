package com.baidu.tbadk.core.d;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b abM = new a(null);
    private static final b abN = new c(null);
    private static final boolean abO;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void o(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.d.e.b
        public void o(String str, String str2, String str3) {
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

        /* synthetic */ c(c cVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.d.e.b
        public void o(String str, String str2, String str3) {
            as asVar = new as("c10729");
            asVar.Z("obj_param1", str);
            asVar.Z("obj_param2", str2);
            asVar.Z("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(asVar);
            }
        }
    }

    public static void o(String str, String str2, String str3) {
        if (abO) {
            abM.o(str, str2, str3);
        }
        abN.o(str, str2, str3);
    }

    public static void cA(String str) {
        if (abO) {
            abM.o(null, null, str);
        }
    }

    public static void p(String str, String str2, String str3) {
        cA(str3);
    }

    static {
        abO = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
