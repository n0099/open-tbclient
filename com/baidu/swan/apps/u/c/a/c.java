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
    private final aq cNj;
    private Bundle cYY;

    /* loaded from: classes10.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: azd */
        public a ayz() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cNj = new aq();
        this.cYY = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) ayz();
    }

    public Bundle toBundle() {
        return ayZ() ? new Bundle(aza()) : new Bundle();
    }

    private boolean ayZ() {
        return this.cYY != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle aza() {
        if (!ayZ()) {
            this.cYY = new Bundle();
        }
        return this.cYY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq azb() {
        return this.cNj;
    }

    public SelfT azc() {
        if (ayZ()) {
            this.cYY.clear();
        }
        return (SelfT) ayz();
    }

    public boolean containsKey(String str) {
        return ayZ() && this.cYY.containsKey(str);
    }

    public SelfT pC(String str) {
        if (ayZ()) {
            this.cYY.remove(str);
        }
        return (SelfT) ayz();
    }

    public SelfT Z(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.cYq.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) ayz();
    }

    public SelfT R(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.cYt.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) ayz();
    }

    public SelfT p(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.cYu.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) ayz();
    }

    public SelfT e(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.cYv.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) ayz();
    }

    public SelfT bV(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.cYx.b(this, str, str2);
        return (SelfT) ayz();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.cYL.b((c) this, str, (String) strArr);
        return (SelfT) ayz();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.cYq.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.cYt.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.cYt.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.cYu.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.cYu.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.cYv.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.cYv.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cYx.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.cYx.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            aza().putAll(bundle);
        }
        return (SelfT) ayz();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.cYQ.b((c) this, str, (String) parcelable);
        return (SelfT) ayz();
    }

    public SelfT d(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.cYP.b((c) this, str, (String) bundle);
        return (SelfT) ayz();
    }

    @Nullable
    public Bundle pD(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cYP.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T pE(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.cYQ.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return ayZ() ? this.cYY.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
