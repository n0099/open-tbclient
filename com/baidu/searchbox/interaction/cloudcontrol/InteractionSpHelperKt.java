package com.baidu.searchbox.interaction.cloudcontrol;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.sapi2.stat.ShareLoginStat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a!\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u0002H\u0003¢\u0006\u0002\u0010\u0006\u001a)\u0010\u0007\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u0002H\u0003¢\u0006\u0002\u0010\n\u001a!\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u0002H\u0003¢\u0006\u0002\u0010\u000e\u001a+\u0010\u000f\u001a\u00020\f\"\u0004\b\u0000\u0010\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u0002H\u0003H\u0002¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"PREF_NAME", "", "getDebugSwitcherValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getSpSwitcherValue", ShareLoginStat.GetShareListStat.VALUE_FROM_SP, "Lcom/baidu/android/util/sp/SharedPrefsWrapper;", "(Lcom/baidu/android/util/sp/SharedPrefsWrapper;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putDebugSwitcherValue", "", "debugValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "putSpSwitcherValue", "(Lcom/baidu/android/util/sp/SharedPrefsWrapper;Ljava/lang/String;Ljava/lang/Object;)V", "lib-interaction-cloudcontrol_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InteractionSpHelperKt {
    public static final String PREF_NAME = "com.baidu.searchbox.interaction.interaction_sp";

    public static final <T> T getDebugSwitcherValue(String key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) getSpSwitcherValue(InteractionSpHelperByDebug.INSTANCE, key, t);
    }

    public static final <T> void putDebugSwitcherValue(String key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        putSpSwitcherValue(InteractionSpHelperByDebug.INSTANCE, key, t);
    }

    public static final <T> T getSpSwitcherValue(SharedPrefsWrapper sp, String key, T t) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        Intrinsics.checkNotNullParameter(key, "key");
        if (t instanceof Integer) {
            return (T) Integer.valueOf(sp.getInt(key, ((Number) t).intValue()));
        }
        if (t instanceof Long) {
            return (T) Long.valueOf(sp.getLong(key, ((Number) t).longValue()));
        }
        if (t instanceof Float) {
            return (T) Float.valueOf(sp.getFloat(key, ((Number) t).floatValue()));
        }
        if (t instanceof Boolean) {
            return (T) Boolean.valueOf(sp.getBoolean(key, ((Boolean) t).booleanValue()));
        }
        if (t instanceof String) {
            return (T) sp.getString(key, (String) t);
        }
        return t;
    }

    public static final <T> void putSpSwitcherValue(SharedPrefsWrapper sharedPrefsWrapper, String str, T t) {
        try {
            if (t instanceof Integer) {
                sharedPrefsWrapper.putInt(str, ((Number) t).intValue());
            } else if (t instanceof Long) {
                sharedPrefsWrapper.putLong(str, ((Number) t).longValue());
            } else if (t instanceof Float) {
                sharedPrefsWrapper.putFloat(str, ((Number) t).floatValue());
            } else if (t instanceof Boolean) {
                sharedPrefsWrapper.putBoolean(str, ((Boolean) t).booleanValue());
            } else if (t instanceof String) {
                sharedPrefsWrapper.putString(str, (String) t);
            }
        } catch (Exception unused) {
        }
    }
}
