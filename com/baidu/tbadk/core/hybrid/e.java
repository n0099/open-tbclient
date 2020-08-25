package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e {
    private static final b eha = new a();
    private static final b ehb = new c();
    private static final boolean ehc;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void Z(String str, String str2, String str3);
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
        if (ehc) {
            eha.Z(str, str2, str3);
        }
        ehb.Z(str, str2, str3);
    }

    public static void debug(String str) {
        if (ehc) {
            eha.Z(null, null, str);
        }
    }

    public static void aa(String str, String str2, String str3) {
        debug(str3);
    }

    static {
        ehc = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
