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
    private Bundle cKJ;
    private final aq cyU;

    /* loaded from: classes10.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: auJ */
        public a auf() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cyU = new aq();
        this.cKJ = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) auf();
    }

    public Bundle toBundle() {
        return auF() ? new Bundle(auG()) : new Bundle();
    }

    private boolean auF() {
        return this.cKJ != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle auG() {
        if (!auF()) {
            this.cKJ = new Bundle();
        }
        return this.cKJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq auH() {
        return this.cyU;
    }

    public SelfT auI() {
        if (auF()) {
            this.cKJ.clear();
        }
        return (SelfT) auf();
    }

    public boolean containsKey(String str) {
        return auF() && this.cKJ.containsKey(str);
    }

    public SelfT oV(String str) {
        if (auF()) {
            this.cKJ.remove(str);
        }
        return (SelfT) auf();
    }

    public SelfT X(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.cKb.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) auf();
    }

    public SelfT P(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.cKe.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) auf();
    }

    public SelfT n(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.cKf.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) auf();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.cKg.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) auf();
    }

    public SelfT bO(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.cKi.b(this, str, str2);
        return (SelfT) auf();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.cKw.b((c) this, str, (String) strArr);
        return (SelfT) auf();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.cKb.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.cKe.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.cKe.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.cKf.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.cKf.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.cKg.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.cKg.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cKi.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.cKi.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            auG().putAll(bundle);
        }
        return (SelfT) auf();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.cKB.b((c) this, str, (String) parcelable);
        return (SelfT) auf();
    }

    public SelfT d(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.cKA.b((c) this, str, (String) bundle);
        return (SelfT) auf();
    }

    @Nullable
    public Bundle oW(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cKA.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T oX(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.cKB.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return auF() ? this.cKJ.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
