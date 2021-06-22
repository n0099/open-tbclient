package com.baidu.sofire.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sofire.utility.u;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class c implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f10335a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10336b;

    /* renamed from: c  reason: collision with root package name */
    public int f10337c;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences.Editor f10338d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10339e;

    /* renamed from: f  reason: collision with root package name */
    public String f10340f;

    /* renamed from: g  reason: collision with root package name */
    public String f10341g;

    public c(Context context, SharedPreferences sharedPreferences, String str, int i2) {
        this(context, sharedPreferences, str, false, i2, null);
    }

    private Bundle a(String str, String str2, String str3) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, str);
            bundle.putString("pref_name", this.f10340f);
            bundle.putString("key", str2);
            bundle.putString("defult_value", str3);
            if (this.f10339e) {
                if (TextUtils.isEmpty(this.f10341g)) {
                    return u.a(this.f10336b, "CallPreferences", bundle);
                }
                return u.b(this.f10336b, "CallPreferences", bundle, this.f10341g);
            }
            return u.a(this.f10336b, "CallPreferences", bundle);
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        throw new RuntimeException("This preference not allow to call contains.");
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        SharedPreferences.Editor editor = this.f10338d;
        if (editor != null) {
            return editor;
        }
        SharedPreferences sharedPreferences = this.f10335a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit();
        }
        return null;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        throw new RuntimeException("This preference not allow to call getAll.");
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (this.f10337c == 1 && (!this.f10339e || TextUtils.isEmpty(this.f10341g))) {
            return this.f10335a == null ? z : this.f10335a.getBoolean(str, z);
        }
        Bundle a2 = a("getBoolean", str, String.valueOf(z));
        if (a2 != null) {
            return a2.getBoolean("result", z);
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f2) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (this.f10337c == 1 && (!this.f10339e || TextUtils.isEmpty(this.f10341g))) {
            return this.f10335a == null ? f2 : this.f10335a.getFloat(str, f2);
        }
        Bundle a2 = a("getFloat", str, String.valueOf(f2));
        if (a2 != null) {
            return a2.getFloat("result", f2);
        }
        return f2;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i2) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (this.f10337c == 1 && (!this.f10339e || TextUtils.isEmpty(this.f10341g))) {
            return this.f10335a == null ? i2 : this.f10335a.getInt(str, i2);
        }
        Bundle a2 = a("getInt", str, String.valueOf(i2));
        if (a2 != null) {
            return a2.getInt("result", i2);
        }
        return i2;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (this.f10337c == 1 && (!this.f10339e || TextUtils.isEmpty(this.f10341g))) {
            return this.f10335a == null ? j : this.f10335a.getLong(str, j);
        }
        Bundle a2 = a("getLong", str, String.valueOf(j));
        if (a2 != null) {
            return a2.getLong("result", j);
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (this.f10337c == 1 && (!this.f10339e || TextUtils.isEmpty(this.f10341g))) {
            return this.f10335a == null ? str2 : this.f10335a.getString(str, str2);
        }
        Bundle a2 = a("getString", str, str2);
        if (a2 != null) {
            return a2.getString("result", str2);
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("This preference not allow to call getStringSet.");
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            if (this.f10335a != null) {
                this.f10335a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            if (this.f10335a != null) {
                this.f10335a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i2, String str2) {
        this.f10336b = context;
        this.f10337c = i2;
        this.f10335a = sharedPreferences;
        this.f10338d = new b(context, sharedPreferences != null ? sharedPreferences.edit() : null, str, z, this.f10337c);
        this.f10339e = z;
        this.f10340f = str;
        this.f10341g = str2;
    }
}
