package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b cSA = new a();
    private static final b cSB = new c();
    private static final boolean cSC;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void S(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void S(String str, String str2, String str3) {
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
        public void S(String str, String str2, String str3) {
            an anVar = new an("c10729");
            anVar.cp("obj_param1", str);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, str2);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void S(String str, String str2, String str3) {
        if (cSC) {
            cSA.S(str, str2, str3);
        }
        cSB.S(str, str2, str3);
    }

    public static void debug(String str) {
        if (cSC) {
            cSA.S(null, null, str);
        }
    }

    public static void T(String str, String str2, String str3) {
        debug(str3);
    }

    static {
        cSC = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
