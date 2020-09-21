package com.baidu.swan.apps.u.c.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.ap.aq;
import com.baidu.swan.apps.ap.e.d;
import com.baidu.swan.apps.u.c.a.c;
import kotlin.TypeCastException;
/* loaded from: classes3.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private final aq cmD;
    private Bundle cyE;

    /* loaded from: classes3.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: arX */
        public a art() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cmD = new aq();
        this.cyE = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) art();
    }

    public Bundle toBundle() {
        return arT() ? new Bundle(arU()) : new Bundle();
    }

    private boolean arT() {
        return this.cyE != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle arU() {
        if (!arT()) {
            this.cyE = new Bundle();
        }
        return this.cyE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq arV() {
        return this.cmD;
    }

    public SelfT arW() {
        if (arT()) {
            this.cyE.clear();
        }
        return (SelfT) art();
    }

    public boolean containsKey(String str) {
        return arT() && this.cyE.containsKey(str);
    }

    public SelfT oi(String str) {
        if (arT()) {
            this.cyE.remove(str);
        }
        return (SelfT) art();
    }

    public SelfT T(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.cxW.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) art();
    }

    public SelfT O(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.cxZ.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) art();
    }

    public SelfT n(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.cya.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) art();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.cyb.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) art();
    }

    public SelfT bJ(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.cyd.b(this, str, str2);
        return (SelfT) art();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.cyr.b((c) this, str, (String) strArr);
        return (SelfT) art();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.cxW.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.cxZ.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.cxZ.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.cya.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.cya.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.cyb.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.cyb.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cyd.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.cyd.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            arU().putAll(bundle);
        }
        return (SelfT) art();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.cyw.b((c) this, str, (String) parcelable);
        return (SelfT) art();
    }

    public SelfT d(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.cyv.b((c) this, str, (String) bundle);
        return (SelfT) art();
    }

    @Nullable
    public Bundle oj(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cyv.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T ok(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.cyw.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return arT() ? this.cyE.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
