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
    private Bundle bzj;

    /* loaded from: classes11.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: Wl */
        public a VI() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.bzj = bundle;
    }

    public SelfT B(Bundle bundle) {
        F(bundle);
        return (SelfT) VI();
    }

    public Bundle toBundle() {
        return Wi() ? new Bundle(Wj()) : new Bundle();
    }

    private boolean Wi() {
        return this.bzj != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle Wj() {
        if (!Wi()) {
            this.bzj = new Bundle();
        }
        return this.bzj;
    }

    public SelfT Wk() {
        if (Wi()) {
            this.bzj.clear();
        }
        return (SelfT) VI();
    }

    public boolean containsKey(String str) {
        return Wi() && this.bzj.containsKey(str);
    }

    public SelfT iI(String str) {
        if (Wi()) {
            this.bzj.remove(str);
        }
        return (SelfT) VI();
    }

    public SelfT w(@Nullable String str, boolean z) {
        com.baidu.swan.apps.x.b.a.a.byD.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) VI();
    }

    public SelfT A(@Nullable String str, int i) {
        com.baidu.swan.apps.x.b.a.a.byG.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) VI();
    }

    public SelfT j(@Nullable String str, long j) {
        com.baidu.swan.apps.x.b.a.a.byH.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) VI();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.x.b.a.a.byI.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) VI();
    }

    public SelfT aR(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.x.b.a.a.byK.b(this, str, str2);
        return (SelfT) VI();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.x.b.a.a.byY.b((c) this, str, (String) strArr);
        return (SelfT) VI();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.x.b.a.a.byD.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.x.b.a.a.byG.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.x.b.a.a.byG.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.x.b.a.a.byH.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.x.b.a.a.byH.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.x.b.a.a.byI.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.x.b.a.a.byI.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.byK.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.x.b.a.a.byK.a(this, str, str2);
    }

    public SelfT F(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            Wj().putAll(bundle);
        }
        return (SelfT) VI();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.x.b.a.a.bzd.b((c) this, str, (String) parcelable);
        return (SelfT) VI();
    }

    public SelfT c(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.x.b.a.a.bzc.b((c) this, str, (String) bundle);
        return (SelfT) VI();
    }

    @Nullable
    public Bundle iJ(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.bzc.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T iK(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.x.b.a.a.bzd.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return Wi() ? this.bzj.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
