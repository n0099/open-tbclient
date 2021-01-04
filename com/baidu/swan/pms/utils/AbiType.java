package com.baidu.swan.pms.utils;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public enum AbiType {
    ARMEABI("armeabi", new AbiType[0]),
    ARMEABI_V7A("armeabi-v7a", ARMEABI),
    ARM64_V8A("arm64-v8a", ARMEABI_V7A, ARMEABI),
    X86("x86", ARMEABI_V7A, ARMEABI),
    X86_64("x86_64", X86, ARMEABI_V7A, ARMEABI);
    
    private static final String TAG = "AbiType";
    private static AbiType sCurrent;
    private final List<AbiType> compatible = new ArrayList();
    public final String id;
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private static Map<String, AbiType> sIndex = new HashMap();

    AbiType(String str, AbiType... abiTypeArr) {
        this.id = str;
        this.compatible.add(this);
        this.compatible.addAll(Arrays.asList(abiTypeArr));
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (AbiType abiType : this.compatible) {
            if (!z) {
                sb.append(" ,");
            }
            sb.append(abiType.id);
            z = false;
        }
        return String.format("%s[%s]", super.toString(), this.id, sb);
    }

    boolean compat(String str) {
        return compat(findById(str));
    }

    public boolean compat(AbiType abiType) {
        return this.compatible.contains(abiType);
    }

    boolean compatBy(String str) {
        AbiType findById = findById(str);
        return findById != null && compatBy(findById);
    }

    public boolean compatBy(AbiType abiType) {
        return abiType.compat(this);
    }

    public List<AbiType> getCompatible() {
        return new ArrayList(this.compatible);
    }

    public static AbiType findById(String str) {
        return findById(str, null);
    }

    public static AbiType findById(String str, @Nullable AbiType abiType) {
        AbiType[] values;
        if (sIndex.isEmpty()) {
            for (AbiType abiType2 : values()) {
                if (abiType2 != null && !TextUtils.isEmpty(abiType2.id)) {
                    sIndex.put(abiType2.id, abiType2);
                }
            }
        }
        AbiType abiType3 = sIndex.get(str);
        return abiType3 == null ? abiType : abiType3;
    }

    @NonNull
    public static AbiType currentAbi() {
        if (sCurrent == null) {
            sCurrent = findById(getRuntimeAbiTypeStr(), ARMEABI);
        }
        if (DEBUG) {
            Log.i(TAG, "ABI_CURRENT=" + sCurrent);
        }
        return sCurrent;
    }

    private static String getRuntimeAbiTypeStr() {
        if (Build.VERSION.SDK_INT < 21) {
            return Build.CPU_ABI;
        }
        ApplicationInfo applicationInfo = AppRuntime.getAppContext().getApplicationInfo();
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            return (String) declaredField.get(applicationInfo);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return null;
        }
    }
}
