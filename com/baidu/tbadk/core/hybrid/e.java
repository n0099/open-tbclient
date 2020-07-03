package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b dRc = new a();
    private static final b dRd = new c();
    private static final boolean dRe;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void Z(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void Z(String str, String str2, String str3) {
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
        public void Z(String str, String str2, String str3) {
            ao aoVar = new ao("c10729");
            aoVar.dk("obj_param1", str);
            aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, str2);
            aoVar.dk(TiebaInitialize.Params.OBJ_PARAM3, str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(aoVar);
            }
        }
    }

    public static void Z(String str, String str2, String str3) {
        if (dRe) {
            dRc.Z(str, str2, str3);
        }
        dRd.Z(str, str2, str3);
    }

    public static void debug(String str) {
        if (dRe) {
            dRc.Z(null, null, str);
        }
    }

    public static void aa(String str, String str2, String str3) {
        debug(str3);
    }

    static {
        dRe = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
