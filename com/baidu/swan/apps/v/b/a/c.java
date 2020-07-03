package com.baidu.swan.apps.v.b.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.aq.e.d;
import com.baidu.swan.apps.v.b.a.c;
import kotlin.TypeCastException;
/* loaded from: classes11.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private Bundle cmK;

    /* loaded from: classes11.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.d
        /* renamed from: aip */
        public a ahM() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cmK = bundle;
    }

    public SelfT E(Bundle bundle) {
        I(bundle);
        return (SelfT) ahM();
    }

    public Bundle toBundle() {
        return aim() ? new Bundle(ain()) : new Bundle();
    }

    private boolean aim() {
        return this.cmK != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle ain() {
        if (!aim()) {
            this.cmK = new Bundle();
        }
        return this.cmK;
    }

    public SelfT aio() {
        if (aim()) {
            this.cmK.clear();
        }
        return (SelfT) ahM();
    }

    public boolean containsKey(String str) {
        return aim() && this.cmK.containsKey(str);
    }

    public SelfT lp(String str) {
        if (aim()) {
            this.cmK.remove(str);
        }
        return (SelfT) ahM();
    }

    public SelfT P(@Nullable String str, boolean z) {
        com.baidu.swan.apps.v.b.a.a.cme.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) ahM();
    }

    public SelfT M(@Nullable String str, int i) {
        com.baidu.swan.apps.v.b.a.a.cmh.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) ahM();
    }

    public SelfT j(@Nullable String str, long j) {
        com.baidu.swan.apps.v.b.a.a.cmi.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) ahM();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.v.b.a.a.cmj.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) ahM();
    }

    public SelfT bu(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.v.b.a.a.cml.b(this, str, str2);
        return (SelfT) ahM();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.v.b.a.a.cmz.b((c) this, str, (String) strArr);
        return (SelfT) ahM();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.v.b.a.a.cme.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.v.b.a.a.cmh.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.v.b.a.a.cmh.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.v.b.a.a.cmi.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.v.b.a.a.cmi.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.v.b.a.a.cmj.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.v.b.a.a.cmj.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.v.b.a.a.cml.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.v.b.a.a.cml.a(this, str, str2);
    }

    public SelfT I(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            ain().putAll(bundle);
        }
        return (SelfT) ahM();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.v.b.a.a.cmE.b((c) this, str, (String) parcelable);
        return (SelfT) ahM();
    }

    public SelfT e(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.v.b.a.a.cmD.b((c) this, str, (String) bundle);
        return (SelfT) ahM();
    }

    @Nullable
    public Bundle lq(@Nullable String str) {
        return com.baidu.swan.apps.v.b.a.a.cmD.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T lr(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.v.b.a.a.cmE.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return aim() ? this.cmK.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
