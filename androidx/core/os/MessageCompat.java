package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class MessageCompat {
    public static boolean sTryIsAsynchronous = true;
    public static boolean sTrySetAsynchronous = true;

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22) {
            return message.isAsynchronous();
        }
        if (sTryIsAsynchronous && i2 >= 16) {
            try {
                return message.isAsynchronous();
            } catch (NoSuchMethodError unused) {
                sTryIsAsynchronous = false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22) {
            message.setAsynchronous(z);
        } else if (!sTrySetAsynchronous || i2 < 16) {
        } else {
            try {
                message.setAsynchronous(z);
            } catch (NoSuchMethodError unused) {
                sTrySetAsynchronous = false;
            }
        }
    }
}
