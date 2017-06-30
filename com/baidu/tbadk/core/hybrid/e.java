package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final boolean abA;
    private static final b aby = new a(null);
    private static final b abz = new c(null);

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

        /* synthetic */ c(c cVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void j(String str, String str2, String str3) {
            au auVar = new au("c10729");
            auVar.Z("obj_param1", str);
            auVar.Z("obj_param2", str2);
            auVar.Z("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(auVar);
            }
        }
    }

    public static void j(String str, String str2, String str3) {
        if (abA) {
            aby.j(str, str2, str3);
        }
        abz.j(str, str2, str3);
    }

    public static void cL(String str) {
        if (abA) {
            aby.j(null, null, str);
        }
    }

    public static void k(String str, String str2, String str3) {
        cL(str3);
    }

    static {
        abA = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
