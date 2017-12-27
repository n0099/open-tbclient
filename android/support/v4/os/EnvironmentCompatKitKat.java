package android.support.v4.os;

import android.os.Environment;
import java.io.File;
/* loaded from: classes2.dex */
class EnvironmentCompatKitKat {
    public static String getStorageState(File file) {
        return Environment.getStorageState(file);
    }
}
