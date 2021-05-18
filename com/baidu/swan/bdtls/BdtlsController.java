package com.baidu.swan.bdtls;

import androidx.annotation.Keep;
/* loaded from: classes3.dex */
public class BdtlsController {

    /* loaded from: classes3.dex */
    public interface a {
        void loadLibrary(String str);
    }

    public static void a(a aVar) {
        if (aVar != null) {
            aVar.loadLibrary("bdtls");
        } else {
            System.loadLibrary("bdtls");
        }
    }

    @Keep
    public static native void handleConfsk(byte[] bArr);
}
