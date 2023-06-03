package com.baidu.searchbox.player.utils;

import android.os.Build;
import android.os.Process;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"is64BitABIs", "", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "DeviceUtil")
/* loaded from: classes4.dex */
public final class DeviceUtil {
    public static final boolean is64BitABIs() {
        String property;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i < 21 || (property = System.getProperty("os.arch")) == null || !StringsKt__StringsKt.contains$default((CharSequence) property, (CharSequence) "64", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }
}
