package com.baidu.tbadk.core.c;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d {
    private static final b To = new a(null);
    private static final b Tp = new c(null);
    private static final boolean Tq;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void m(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    private static final class a implements b {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // com.baidu.tbadk.core.c.d.b
        public void m(String str, String str2, String str3) {
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
        public void m(String str, String str2, String str3) {
            aw awVar = new aw("c10729");
            awVar.ac("obj_param1", str);
            awVar.ac("obj_param2", str2);
            awVar.ac("obj_param3", str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(awVar);
            }
        }
    }

    public static void m(String str, String str2, String str3) {
        if (Tq) {
            To.m(str, str2, str3);
        }
        Tp.m(str, str2, str3);
    }

    public static void cD(String str) {
        if (Tq) {
            To.m(null, null, str);
        }
    }

    public static void n(String str, String str2, String str3) {
        cD(str3);
    }

    static {
        Tq = BdBaseApplication.getInst() == null ? true : BdBaseApplication.getInst().isDebugMode();
    }
}
