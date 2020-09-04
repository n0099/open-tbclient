package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b ehe = new a();
    private static final b ehf = new c();
    private static final boolean ehg;

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
            aq aqVar = new aq("c10729");
            aqVar.dD("obj_param1", str);
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, str2);
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM3, str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void Z(String str, String str2, String str3) {
        if (ehg) {
            ehe.Z(str, str2, str3);
        }
        ehf.Z(str, str2, str3);
    }

    public static void debug(String str) {
        if (ehg) {
            ehe.Z(null, null, str);
        }
    }

    public static void aa(String str, String str2, String str3) {
        debug(str3);
    }

    static {
        ehg = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
