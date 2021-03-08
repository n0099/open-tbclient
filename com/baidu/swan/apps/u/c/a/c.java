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
    private final aq cWq;
    private Bundle dif;

    /* loaded from: classes8.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.d
        /* renamed from: azD */
        public a ayZ() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cWq = new aq();
        this.dif = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) ayZ();
    }

    public Bundle toBundle() {
        return azz() ? new Bundle(azA()) : new Bundle();
    }

    private boolean azz() {
        return this.dif != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle azA() {
        if (!azz()) {
            this.dif = new Bundle();
        }
        return this.dif;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq azB() {
        return this.cWq;
    }

    public SelfT azC() {
        if (azz()) {
            this.dif.clear();
        }
        return (SelfT) ayZ();
    }

    public boolean containsKey(String str) {
        return azz() && this.dif.containsKey(str);
    }

    public SelfT pk(String str) {
        if (azz()) {
            this.dif.remove(str);
        }
        return (SelfT) ayZ();
    }

    public SelfT Z(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.dhw.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) ayZ();
    }

    public SelfT X(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.dhz.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) ayZ();
    }

    public SelfT o(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.dhA.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) ayZ();
    }

    public SelfT e(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.dhB.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) ayZ();
    }

    public SelfT bT(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.dhD.b(this, str, str2);
        return (SelfT) ayZ();
    }

    public SelfT e(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.dhR.b((c) this, str, (String) strArr);
        return (SelfT) ayZ();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.dhw.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.dhz.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.dhz.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.dhA.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.dhA.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.dhB.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.dhB.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.dhD.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.dhD.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            azA().putAll(bundle);
        }
        return (SelfT) ayZ();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.dhW.b((c) this, str, (String) parcelable);
        return (SelfT) ayZ();
    }

    public SelfT e(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.dhV.b((c) this, str, (String) bundle);
        return (SelfT) ayZ();
    }

    @Nullable
    public Bundle pl(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.dhV.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T pm(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.dhW.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return azz() ? this.dif.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
