package com.baidu.sofire.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sofire.utility.u;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import java.util.Set;
/* loaded from: classes2.dex */
public final class b implements SharedPreferences.Editor {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences.Editor f10329a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10330b;

    /* renamed from: c  reason: collision with root package name */
    public int f10331c;

    /* renamed from: d  reason: collision with root package name */
    public String f10332d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10333e;

    /* renamed from: f  reason: collision with root package name */
    public String f10334f;

    public b(Context context, SharedPreferences.Editor editor, String str, boolean z, int i2) {
        this(context, editor, str, z, i2, (byte) 0);
    }

    private Bundle a(Bundle bundle) {
        try {
            bundle.putString("pref_name", this.f10332d);
            if (this.f10333e) {
                if (TextUtils.isEmpty(this.f10334f)) {
                    return u.a(this.f10330b, "CallPreferences", bundle);
                }
                return u.b(this.f10330b, "CallPreferences", bundle, this.f10334f);
            }
            return u.a(this.f10330b, "CallPreferences", bundle);
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return null;
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        SharedPreferences.Editor editor;
        if (this.f10331c == 1) {
            if ((!this.f10333e || TextUtils.isEmpty(this.f10334f)) && (editor = this.f10329a) != null) {
                editor.apply();
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        throw new RuntimeException("This editor not allow to call clear.");
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        SharedPreferences.Editor editor;
        if (this.f10331c != 1 || ((this.f10333e && !TextUtils.isEmpty(this.f10334f)) || (editor = this.f10329a) == null)) {
            return true;
        }
        return editor.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        try {
            if (this.f10331c == 1 && (!this.f10333e || TextUtils.isEmpty(this.f10334f))) {
                if (this.f10329a != null && this.f10329a != null) {
                    this.f10329a.putBoolean(str, z);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putBoolean");
                bundle.putString("key", str);
                bundle.putBoolean("value", z);
                a(bundle);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f2) {
        try {
            if (this.f10331c == 1 && (!this.f10333e || TextUtils.isEmpty(this.f10334f))) {
                if (this.f10329a != null && this.f10329a != null) {
                    this.f10329a.putFloat(str, f2);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putFloat");
                bundle.putString("key", str);
                bundle.putFloat("value", f2);
                a(bundle);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i2) {
        try {
            if (this.f10331c == 1 && (!this.f10333e || TextUtils.isEmpty(this.f10334f))) {
                if (this.f10329a != null && this.f10329a != null) {
                    this.f10329a.putInt(str, i2);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putInt");
                bundle.putString("key", str);
                bundle.putInt("value", i2);
                a(bundle);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j) {
        try {
            if (this.f10331c == 1 && (!this.f10333e || TextUtils.isEmpty(this.f10334f))) {
                if (this.f10329a != null && this.f10329a != null) {
                    this.f10329a.putLong(str, j);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putLong");
                bundle.putString("key", str);
                bundle.putLong("value", j);
                a(bundle);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        try {
            if (this.f10331c == 1 && (!this.f10333e || TextUtils.isEmpty(this.f10334f))) {
                if (this.f10329a != null && this.f10329a != null) {
                    this.f10329a.putString(str, str2);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "putString");
                bundle.putString("key", str);
                bundle.putString("value", str2);
                a(bundle);
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        throw new RuntimeException("This editor not allow to call putStringSet.");
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        throw new RuntimeException("This editor not allow to call remove.");
    }

    public b(Context context, SharedPreferences.Editor editor, String str, boolean z, int i2, byte b2) {
        this.f10330b = context;
        this.f10329a = editor;
        this.f10331c = i2;
        this.f10332d = str;
        this.f10333e = z;
        this.f10334f = null;
    }
}
