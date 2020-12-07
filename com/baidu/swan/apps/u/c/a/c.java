package com.baidu.swan.apps.u.c.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.ap.aq;
import com.baidu.swan.apps.ap.e.d;
import com.baidu.swan.apps.u.c.a.c;
import kotlin.TypeCastException;
/* loaded from: classes25.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private final aq cSs;
    private Bundle dem;

    /* loaded from: classes25.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: aBE */
        public a aBa() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cSs = new aq();
        this.dem = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) aBa();
    }

    public Bundle toBundle() {
        return aBA() ? new Bundle(aBB()) : new Bundle();
    }

    private boolean aBA() {
        return this.dem != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle aBB() {
        if (!aBA()) {
            this.dem = new Bundle();
        }
        return this.dem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq aBC() {
        return this.cSs;
    }

    public SelfT aBD() {
        if (aBA()) {
            this.dem.clear();
        }
        return (SelfT) aBa();
    }

    public boolean containsKey(String str) {
        return aBA() && this.dem.containsKey(str);
    }

    public SelfT qd(String str) {
        if (aBA()) {
            this.dem.remove(str);
        }
        return (SelfT) aBa();
    }

    public SelfT aa(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.ddE.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) aBa();
    }

    public SelfT S(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.ddH.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) aBa();
    }

    public SelfT p(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.ddI.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) aBa();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.ddJ.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) aBa();
    }

    public SelfT cb(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.ddL.b(this, str, str2);
        return (SelfT) aBa();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.ddZ.b((c) this, str, (String) strArr);
        return (SelfT) aBa();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.ddE.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.ddH.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.ddH.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.ddI.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.ddI.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.ddJ.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.ddJ.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.ddL.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.ddL.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            aBB().putAll(bundle);
        }
        return (SelfT) aBa();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.dee.b((c) this, str, (String) parcelable);
        return (SelfT) aBa();
    }

    public SelfT d(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.ded.b((c) this, str, (String) bundle);
        return (SelfT) aBa();
    }

    @Nullable
    public Bundle qe(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.ded.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T qf(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.dee.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return aBA() ? this.dem.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
