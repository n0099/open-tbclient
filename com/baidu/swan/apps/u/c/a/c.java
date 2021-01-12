package com.baidu.swan.apps.u.c.a;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.ao.aq;
import com.baidu.swan.apps.ao.e.d;
import com.baidu.swan.apps.u.c.a.c;
import kotlin.TypeCastException;
/* loaded from: classes8.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private final aq cSD;
    private Bundle der;

    /* loaded from: classes8.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.d
        /* renamed from: azc */
        public a ayy() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cSD = new aq();
        this.der = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) ayy();
    }

    public Bundle toBundle() {
        return ayY() ? new Bundle(ayZ()) : new Bundle();
    }

    private boolean ayY() {
        return this.der != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle ayZ() {
        if (!ayY()) {
            this.der = new Bundle();
        }
        return this.der;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq aza() {
        return this.cSD;
    }

    public SelfT azb() {
        if (ayY()) {
            this.der.clear();
        }
        return (SelfT) ayy();
    }

    public boolean containsKey(String str) {
        return ayY() && this.der.containsKey(str);
    }

    public SelfT oL(String str) {
        if (ayY()) {
            this.der.remove(str);
        }
        return (SelfT) ayy();
    }

    public SelfT aa(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.ddJ.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) ayy();
    }

    public SelfT U(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.ddM.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) ayy();
    }

    public SelfT p(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.ddN.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) ayy();
    }

    public SelfT e(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.ddO.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) ayy();
    }

    public SelfT bZ(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.ddQ.b(this, str, str2);
        return (SelfT) ayy();
    }

    public SelfT e(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.dee.b((c) this, str, (String) strArr);
        return (SelfT) ayy();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.ddJ.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.ddM.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.ddM.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.ddN.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.ddN.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.ddO.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.ddO.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.ddQ.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.ddQ.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            ayZ().putAll(bundle);
        }
        return (SelfT) ayy();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.dej.b((c) this, str, (String) parcelable);
        return (SelfT) ayy();
    }

    public SelfT e(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.dei.b((c) this, str, (String) bundle);
        return (SelfT) ayy();
    }

    @Nullable
    public Bundle oM(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.dei.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T oN(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.dej.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return ayY() ? this.der.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
