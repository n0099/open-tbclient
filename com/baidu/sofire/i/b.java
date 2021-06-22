package com.baidu.sofire.i;

import android.hardware.Camera;
import com.baidu.sofire.utility.c;
/* loaded from: classes2.dex */
public final class b {
    public static void a(Camera camera) {
        if (camera != null) {
            try {
                camera.release();
            } catch (Throwable unused) {
                c.a();
            }
        }
    }
}
