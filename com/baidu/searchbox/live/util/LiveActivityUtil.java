package com.baidu.searchbox.live.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class LiveActivityUtil {
    public static final String TAG = "LiveActivityUtil";

    /* loaded from: classes2.dex */
    public interface OnTranslucentListener {
        void onTranslucent(boolean z);
    }

    public static void convertFromTranslucent(Activity activity, OnTranslucentListener onTranslucentListener) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        } catch (Throwable th) {
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(true);
            }
            th.printStackTrace();
        }
    }

    public static boolean startActivitySafely(Context context, Intent intent) {
        return startActivitySafely(context, intent, false);
    }

    public static void fixTarget26Crash(@Nullable Activity activity) {
        if (Build.VERSION.SDK_INT == 26 && activity != null) {
            convertFromTranslucent(activity, new OnTranslucentListener() { // from class: com.baidu.searchbox.live.util.LiveActivityUtil.1
                @Override // com.baidu.searchbox.live.util.LiveActivityUtil.OnTranslucentListener
                public void onTranslucent(boolean z) {
                }
            });
        }
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z) {
        return startActivitySafely(context, intent, z, true);
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z, boolean z2) {
        if (z || !(context instanceof Activity)) {
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            if (!z2) {
                return false;
            }
            Toast.makeText(context, (int) R.string.liveshow_activity_not_found, 0).show();
            return false;
        } catch (SecurityException unused2) {
            if (!z2) {
                return false;
            }
            Toast.makeText(context, (int) R.string.liveshow_activity_not_found, 0).show();
            return false;
        } catch (Exception unused3) {
            return false;
        }
    }
}
