package com.baidu.swan.apps.x.b.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.as.d.d;
import com.baidu.swan.apps.x.b.a.c;
import kotlin.TypeCastException;
/* loaded from: classes11.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private Bundle byW;

    /* loaded from: classes11.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: Wg */
        public a VD() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.byW = bundle;
    }

    public SelfT B(Bundle bundle) {
        F(bundle);
        return (SelfT) VD();
    }

    public Bundle toBundle() {
        return Wd() ? new Bundle(We()) : new Bundle();
    }

    private boolean Wd() {
        return this.byW != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle We() {
        if (!Wd()) {
            this.byW = new Bundle();
        }
        return this.byW;
    }

    public SelfT Wf() {
        if (Wd()) {
            this.byW.clear();
        }
        return (SelfT) VD();
    }

    public boolean containsKey(String str) {
        return Wd() && this.byW.containsKey(str);
    }

    public SelfT iJ(String str) {
        if (Wd()) {
            this.byW.remove(str);
        }
        return (SelfT) VD();
    }

    public SelfT w(@Nullable String str, boolean z) {
        com.baidu.swan.apps.x.b.a.a.byq.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) VD();
    }

    public SelfT A(@Nullable String str, int i) {
        com.baidu.swan.apps.x.b.a.a.byt.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) VD();
    }

    public SelfT j(@Nullable String str, long j) {
        com.baidu.swan.apps.x.b.a.a.byu.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) VD();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.x.b.a.a.byv.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) VD();
    }

    public SelfT aS(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.x.b.a.a.byx.b(this, str, str2);
        return (SelfT) VD();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.x.b.a.a.byL.b((c) this, str, (String) strArr);
        return (SelfT) VD();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.x.b.a.a.byq.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.x.b.a.a.byt.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.x.b.a.a.byt.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.x.b.a.a.byu.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.x.b.a.a.byu.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.x.b.a.a.byv.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.x.b.a.a.byv.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.byx.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.x.b.a.a.byx.a(this, str, str2);
    }

    public SelfT F(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            We().putAll(bundle);
        }
        return (SelfT) VD();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.x.b.a.a.byQ.b((c) this, str, (String) parcelable);
        return (SelfT) VD();
    }

    public SelfT c(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.x.b.a.a.byP.b((c) this, str, (String) bundle);
        return (SelfT) VD();
    }

    @Nullable
    public Bundle iK(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.byP.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T iL(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.x.b.a.a.byQ.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return Wd() ? this.byW.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
