package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b dwg = new a();
    private static final b dwh = new c();
    private static final boolean dwi;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void T(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void T(String str, String str2, String str3) {
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
        public void T(String str, String str2, String str3) {
            an anVar = new an("c10729");
            anVar.cI("obj_param1", str);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, str2);
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void T(String str, String str2, String str3) {
        if (dwi) {
            dwg.T(str, str2, str3);
        }
        dwh.T(str, str2, str3);
    }

    public static void debug(String str) {
        if (dwi) {
            dwg.T(null, null, str);
        }
    }

    public static void U(String str, String str2, String str3) {
        debug(str3);
    }

    static {
        dwi = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
