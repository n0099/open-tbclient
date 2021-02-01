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
    private final aq cUQ;
    private Bundle dgD;

    /* loaded from: classes9.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.d
        /* renamed from: azA */
        public a ayW() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cUQ = new aq();
        this.dgD = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) ayW();
    }

    public Bundle toBundle() {
        return azw() ? new Bundle(azx()) : new Bundle();
    }

    private boolean azw() {
        return this.dgD != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle azx() {
        if (!azw()) {
            this.dgD = new Bundle();
        }
        return this.dgD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq azy() {
        return this.cUQ;
    }

    public SelfT azz() {
        if (azw()) {
            this.dgD.clear();
        }
        return (SelfT) ayW();
    }

    public boolean containsKey(String str) {
        return azw() && this.dgD.containsKey(str);
    }

    public SelfT pd(String str) {
        if (azw()) {
            this.dgD.remove(str);
        }
        return (SelfT) ayW();
    }

    public SelfT Z(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.dfV.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) ayW();
    }

    public SelfT W(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.dfY.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) ayW();
    }

    public SelfT o(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.dfZ.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) ayW();
    }

    public SelfT e(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.dga.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) ayW();
    }

    public SelfT bT(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.dgc.b(this, str, str2);
        return (SelfT) ayW();
    }

    public SelfT e(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.dgq.b((c) this, str, (String) strArr);
        return (SelfT) ayW();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.dfV.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.dfY.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.dfY.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.dfZ.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.dfZ.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.dga.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.dga.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.dgc.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.dgc.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            azx().putAll(bundle);
        }
        return (SelfT) ayW();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.dgv.b((c) this, str, (String) parcelable);
        return (SelfT) ayW();
    }

    public SelfT e(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.dgu.b((c) this, str, (String) bundle);
        return (SelfT) ayW();
    }

    @Nullable
    public Bundle pe(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.dgu.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T pf(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.dgv.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return azw() ? this.dgD.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
