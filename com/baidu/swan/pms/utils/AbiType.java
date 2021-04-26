package com.baidu.swan.pms.utils;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.l.f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum ARMEABI_V7A uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class AbiType {
    public static final /* synthetic */ AbiType[] $VALUES;
    public static final AbiType ARM64_V8A;
    public static final AbiType ARMEABI;
    public static final AbiType ARMEABI_V7A;
    public static final boolean DEBUG;
    public static final String TAG = "AbiType";
    public static final AbiType X86;
    public static final AbiType X86_64;
    public static AbiType sCurrent;
    public static Map<String, AbiType> sIndex;
    public final List<AbiType> compatible;
    public final String id;

    static {
        AbiType abiType = new AbiType("ARMEABI", 0, "armeabi", new AbiType[0]);
        ARMEABI = abiType;
        AbiType abiType2 = new AbiType("ARMEABI_V7A", 1, "armeabi-v7a", abiType);
        ARMEABI_V7A = abiType2;
        ARM64_V8A = new AbiType("ARM64_V8A", 2, "arm64-v8a", abiType2, ARMEABI);
        AbiType abiType3 = new AbiType("X86", 3, "x86", ARMEABI_V7A, ARMEABI);
        X86 = abiType3;
        AbiType abiType4 = new AbiType("X86_64", 4, "x86_64", abiType3, ARMEABI_V7A, ARMEABI);
        X86_64 = abiType4;
        $VALUES = new AbiType[]{ARMEABI, ARMEABI_V7A, ARM64_V8A, X86, abiType4};
        DEBUG = f.f47117a;
        sIndex = new HashMap();
    }

    public AbiType(String str, int i2, String str2, AbiType... abiTypeArr) {
        ArrayList arrayList = new ArrayList();
        this.compatible = arrayList;
        this.id = str2;
        arrayList.add(this);
        this.compatible.addAll(Arrays.asList(abiTypeArr));
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

    public static AbiType findById(String str) {
        return findById(str, null);
    }

    public static String getRuntimeAbiTypeStr() {
        if (Build.VERSION.SDK_INT < 21) {
            return Build.CPU_ABI;
        }
        ApplicationInfo applicationInfo = AppRuntime.getAppContext().getApplicationInfo();
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            return (String) declaredField.get(applicationInfo);
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    public static AbiType valueOf(String str) {
        return (AbiType) Enum.valueOf(AbiType.class, str);
    }

    public static AbiType[] values() {
        return (AbiType[]) $VALUES.clone();
    }

    public boolean compat(String str) {
        return compat(findById(str));
    }

    public boolean compatBy(String str) {
        AbiType findById = findById(str);
        return findById != null && compatBy(findById);
    }

    public List<AbiType> getCompatible() {
        return new ArrayList(this.compatible);
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

    public boolean compat(AbiType abiType) {
        return this.compatible.contains(abiType);
    }

    public boolean compatBy(AbiType abiType) {
        return abiType.compat(this);
    }
}
