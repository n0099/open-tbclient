package com.baidu.swan.apps.u.c.a;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.ao.aq;
import com.baidu.swan.apps.ao.e.d;
import com.baidu.swan.apps.u.c.a.c;
import kotlin.TypeCastException;
/* loaded from: classes9.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private final aq cXp;
    private Bundle djh;

    /* loaded from: classes9.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.d
        /* renamed from: aCV */
        public a aCr() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cXp = new aq();
        this.djh = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) aCr();
    }

    public Bundle toBundle() {
        return aCR() ? new Bundle(aCS()) : new Bundle();
    }

    private boolean aCR() {
        return this.djh != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle aCS() {
        if (!aCR()) {
            this.djh = new Bundle();
        }
        return this.djh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq aCT() {
        return this.cXp;
    }

    public SelfT aCU() {
        if (aCR()) {
            this.djh.clear();
        }
        return (SelfT) aCr();
    }

    public boolean containsKey(String str) {
        return aCR() && this.djh.containsKey(str);
    }

    public SelfT pW(String str) {
        if (aCR()) {
            this.djh.remove(str);
        }
        return (SelfT) aCr();
    }

    public SelfT aa(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.diz.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) aCr();
    }

    public SelfT U(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.diC.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) aCr();
    }

    public SelfT p(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.diD.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) aCr();
    }

    public SelfT e(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.diE.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) aCr();
    }

    public SelfT ca(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.diG.b(this, str, str2);
        return (SelfT) aCr();
    }

    public SelfT e(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.diU.b((c) this, str, (String) strArr);
        return (SelfT) aCr();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.diz.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.diC.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.diC.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.diD.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.diD.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.diE.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.diE.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.diG.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.diG.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            aCS().putAll(bundle);
        }
        return (SelfT) aCr();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.diZ.b((c) this, str, (String) parcelable);
        return (SelfT) aCr();
    }

    public SelfT d(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.diY.b((c) this, str, (String) bundle);
        return (SelfT) aCr();
    }

    @Nullable
    public Bundle pX(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.diY.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T pY(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.diZ.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return aCR() ? this.djh.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
