package com.baidu.swan.apps.u.c.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.ap.aq;
import com.baidu.swan.apps.ap.e.d;
import com.baidu.swan.apps.u.c.a.c;
import kotlin.TypeCastException;
/* loaded from: classes10.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private final aq cHq;
    private Bundle cTf;

    /* loaded from: classes10.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: awD */
        public a avZ() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cHq = new aq();
        this.cTf = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) avZ();
    }

    public Bundle toBundle() {
        return awz() ? new Bundle(awA()) : new Bundle();
    }

    private boolean awz() {
        return this.cTf != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle awA() {
        if (!awz()) {
            this.cTf = new Bundle();
        }
        return this.cTf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq awB() {
        return this.cHq;
    }

    public SelfT awC() {
        if (awz()) {
            this.cTf.clear();
        }
        return (SelfT) avZ();
    }

    public boolean containsKey(String str) {
        return awz() && this.cTf.containsKey(str);
    }

    public SelfT po(String str) {
        if (awz()) {
            this.cTf.remove(str);
        }
        return (SelfT) avZ();
    }

    public SelfT Z(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.cSx.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) avZ();
    }

    public SelfT P(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.cSA.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) avZ();
    }

    public SelfT p(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.cSB.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) avZ();
    }

    public SelfT e(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.cSC.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) avZ();
    }

    public SelfT bV(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.cSE.b(this, str, str2);
        return (SelfT) avZ();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.cSS.b((c) this, str, (String) strArr);
        return (SelfT) avZ();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.cSx.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.cSA.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.cSA.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.cSB.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.cSB.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.cSC.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.cSC.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cSE.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.cSE.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            awA().putAll(bundle);
        }
        return (SelfT) avZ();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.cSX.b((c) this, str, (String) parcelable);
        return (SelfT) avZ();
    }

    public SelfT d(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.cSW.b((c) this, str, (String) bundle);
        return (SelfT) avZ();
    }

    @Nullable
    public Bundle pp(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cSW.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T pq(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.cSX.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return awz() ? this.cTf.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
