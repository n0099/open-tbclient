package com.baidu.tbadk.core.c;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b XO = new a(null);
    private static final b XP = new c(null);
    private static final boolean XQ;

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

        @Override // com.baidu.tbadk.core.c.e.b
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

        @Override // com.baidu.tbadk.core.c.e.b
        public void p(String str, String str2, String str3) {
            av avVar = new av("c10729");
            avVar.ab("obj_param1", str);
            avVar.ab("obj_param2", str2);
            avVar.ab("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(avVar);
            }
        }
    }

    public static void p(String str, String str2, String str3) {
        if (XQ) {
            XO.p(str, str2, str3);
        }
        XP.p(str, str2, str3);
    }

    public static void cI(String str) {
        if (XQ) {
            XO.p(null, null, str);
        }
    }

    public static void q(String str, String str2, String str3) {
        cI(str3);
    }

    static {
        XQ = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
