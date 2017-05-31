package com.baidu.tbadk.core.d;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b abx = new a(null);
    private static final b aby = new c(null);
    private static final boolean abz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void j(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.d.e.b
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

        /* synthetic */ c(c cVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.d.e.b
        public void j(String str, String str2, String str3) {
            as asVar = new as("c10729");
            asVar.Z("obj_param1", str);
            asVar.Z("obj_param2", str2);
            asVar.Z("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(asVar);
            }
        }
    }

    public static void j(String str, String str2, String str3) {
        if (abz) {
            abx.j(str, str2, str3);
        }
        aby.j(str, str2, str3);
    }

    public static void cE(String str) {
        if (abz) {
            abx.j(null, null, str);
        }
    }

    public static void k(String str, String str2, String str3) {
        cE(str3);
    }

    static {
        abz = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
