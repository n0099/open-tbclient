package com.baidu.tbadk.core.hybrid;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {
    private static final b ePZ = new a();
    private static final b eQa = new c();
    private static final boolean eQb;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void aj(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        @Override // com.baidu.tbadk.core.hybrid.e.b
        public void aj(String str, String str2, String str3) {
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
        public void aj(String str, String str2, String str3) {
            ar arVar = new ar("c10729");
            arVar.dY("obj_param1", str);
            arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, str2);
            arVar.dY(TiebaInitialize.Params.OBJ_PARAM3, str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(arVar);
            }
        }
    }

    public static void aj(String str, String str2, String str3) {
        if (eQb) {
            ePZ.aj(str, str2, str3);
        }
        eQa.aj(str, str2, str3);
    }

    public static void debug(String str) {
        if (eQb) {
            ePZ.aj(null, null, str);
        }
    }

    public static void ak(String str, String str2, String str3) {
        debug(str3);
    }

    static {
        eQb = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }
}
