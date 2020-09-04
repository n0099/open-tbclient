package com.baidu.swan.apps.u.c.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.ap.aq;
import com.baidu.swan.apps.ap.e.d;
import com.baidu.swan.apps.u.c.a.c;
import kotlin.TypeCastException;
/* loaded from: classes8.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private final aq ckB;
    private Bundle cwD;

    /* loaded from: classes8.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: arn */
        public a aqJ() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.ckB = new aq();
        this.cwD = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) aqJ();
    }

    public Bundle toBundle() {
        return arj() ? new Bundle(ark()) : new Bundle();
    }

    private boolean arj() {
        return this.cwD != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle ark() {
        if (!arj()) {
            this.cwD = new Bundle();
        }
        return this.cwD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq arl() {
        return this.ckB;
    }

    public SelfT arm() {
        if (arj()) {
            this.cwD.clear();
        }
        return (SelfT) aqJ();
    }

    public boolean containsKey(String str) {
        return arj() && this.cwD.containsKey(str);
    }

    public SelfT nO(String str) {
        if (arj()) {
            this.cwD.remove(str);
        }
        return (SelfT) aqJ();
    }

    public SelfT T(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.cvV.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) aqJ();
    }

    public SelfT O(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.cvY.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) aqJ();
    }

    public SelfT n(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.cvZ.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) aqJ();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.cwa.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) aqJ();
    }

    public SelfT bJ(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.cwc.b(this, str, str2);
        return (SelfT) aqJ();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.cwq.b((c) this, str, (String) strArr);
        return (SelfT) aqJ();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.cvV.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.cvY.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.cvY.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.cvZ.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.cvZ.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.cwa.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.cwa.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cwc.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.cwc.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            ark().putAll(bundle);
        }
        return (SelfT) aqJ();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.cwv.b((c) this, str, (String) parcelable);
        return (SelfT) aqJ();
    }

    public SelfT d(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.cwu.b((c) this, str, (String) bundle);
        return (SelfT) aqJ();
    }

    @Nullable
    public Bundle nP(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cwu.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T nQ(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.cwv.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return arj() ? this.cwD.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
