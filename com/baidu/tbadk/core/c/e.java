package com.baidu.tbadk.core.c;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b Xd = new a(null);
    private static final b Xe = new c(null);
    private static final boolean Xf;

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
            ay ayVar = new ay("c10729");
            ayVar.ab("obj_param1", str);
            ayVar.ab("obj_param2", str2);
            ayVar.ab("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(ayVar);
            }
        }
    }

    public static void p(String str, String str2, String str3) {
        if (Xf) {
            Xd.p(str, str2, str3);
        }
        Xe.p(str, str2, str3);
    }

    public static void cE(String str) {
        if (Xf) {
            Xd.p(null, null, str);
        }
    }

    public static void q(String str, String str2, String str3) {
        cE(str3);
    }

    static {
        Xf = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
