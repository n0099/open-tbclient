package com.baidu.tbadk.core.d;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final boolean WA;
    private static final b Wy = new a(null);
    private static final b Wz = new c(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void p(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.d.e.b
        public void p(String str, String str2, String str3) {
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
        public void p(String str, String str2, String str3) {
            ar arVar = new ar("c10729");
            arVar.ab("obj_param1", str);
            arVar.ab("obj_param2", str2);
            arVar.ab("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(arVar);
            }
        }
    }

    public static void p(String str, String str2, String str3) {
        if (WA) {
            Wy.p(str, str2, str3);
        }
        Wz.p(str, str2, str3);
    }

    public static void cH(String str) {
        if (WA) {
            Wy.p(null, null, str);
        }
    }

    public static void q(String str, String str2, String str3) {
        cH(str3);
    }

    static {
        WA = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
