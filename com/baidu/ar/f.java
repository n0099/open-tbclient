package com.baidu.ar;

import com.baidu.slamlibrary.ARAlgoJniClient;
import java.io.File;
/* loaded from: classes3.dex */
public final class f {
    public static int a() {
        return ARAlgoJniClient.arRelease();
    }

    public static int a(byte[] bArr, int i, int i2, int i3, int i4, String str, int[] iArr) {
        if (new File(str).exists()) {
            return ARAlgoJniClient.arInit(bArr, i, i2, i3, i4, str, iArr);
        }
        return -1;
    }

    public static int a(byte[] bArr, int i, int i2, float[] fArr, int i3) {
        return ARAlgoJniClient.arTracking(bArr, i, i2, fArr, i3);
    }

    public static int a(float[] fArr, int i, float[] fArr2) {
        return ARAlgoJniClient.arCameraIntrinsics(fArr, i, fArr2);
    }

    public static void a(int i) {
        ARAlgoJniClient.arSetMatchTrackMode(i);
    }
}
