package com.baidu.platform.comjni.map.favorite;

import android.os.Bundle;
import com.baidu.platform.comjni.JNIBaseApi;
/* loaded from: classes15.dex */
public class NAFavorite extends JNIBaseApi {

    /* renamed from: a  reason: collision with root package name */
    private long f4757a = 0;

    private native boolean nativeAdd(long j, String str, String str2);

    private native boolean nativeClear(long j);

    private native boolean nativeCloseCache(long j);

    private native long nativeCreate();

    private native boolean nativeDelete(long j);

    private native int nativeGetAll(long j, Bundle bundle);

    private native int nativeGetLength(long j);

    private native int nativeGetRelations(long j, String str, Bundle bundle, int i);

    private native String nativeGetValue(long j, String str);

    private native boolean nativeIsExist(long j, String str);

    private native boolean nativeLoad(long j, String str, String str2, String str3, int i, int i2, int i3);

    private native int nativeRelease(long j);

    private native boolean nativeRemove(long j, String str);

    private native boolean nativeResumeCache(long j);

    private native boolean nativeSaveCache(long j);

    private native boolean nativeSetType(long j, int i);

    private native boolean nativeUpdate(long j, String str, String str2);

    public int a(Bundle bundle) {
        try {
            return nativeGetAll(this.f4757a, bundle);
        } catch (Throwable th) {
            return 0;
        }
    }

    public long a() {
        this.f4757a = nativeCreate();
        return this.f4757a;
    }

    public boolean a(int i) {
        return nativeSetType(this.f4757a, i);
    }

    public boolean a(String str) {
        return nativeRemove(this.f4757a, str);
    }

    public boolean a(String str, String str2) {
        return nativeAdd(this.f4757a, str, str2);
    }

    public boolean a(String str, String str2, String str3, int i, int i2, int i3) {
        return nativeLoad(this.f4757a, str, str2, str3, i, i2, i3);
    }

    public int b() {
        return nativeRelease(this.f4757a);
    }

    public String b(String str) {
        try {
            return nativeGetValue(this.f4757a, str);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean b(String str, String str2) {
        return nativeUpdate(this.f4757a, str, str2);
    }

    public boolean c() {
        return nativeClear(this.f4757a);
    }

    public boolean c(String str) {
        try {
            return nativeIsExist(this.f4757a, str);
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean d() {
        return nativeSaveCache(this.f4757a);
    }
}
