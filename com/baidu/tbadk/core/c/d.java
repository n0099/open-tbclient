package com.baidu.tbadk.core.c;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d {
    private static final b TF = new a(null);
    private static final b TG = new c(null);
    private static final boolean TH;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void q(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.c.d.b
        public void q(String str, String str2, String str3) {
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

        @Override // com.baidu.tbadk.core.c.d.b
        public void q(String str, String str2, String str3) {
            ay ayVar = new ay("c10729");
            ayVar.ab("obj_param1", str);
            ayVar.ab("obj_param2", str2);
            ayVar.ab("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(ayVar);
            }
        }
    }

    public static void q(String str, String str2, String str3) {
        if (TH) {
            TF.q(str, str2, str3);
        }
        TG.q(str, str2, str3);
    }

    public static void cC(String str) {
        if (TH) {
            TF.q(null, null, str);
        }
    }

    public static void r(String str, String str2, String str3) {
        cC(str3);
    }

    static {
        TH = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
