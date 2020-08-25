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
    private final aq ckx;
    private Bundle cwz;

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
        this.ckx = new aq();
        this.cwz = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) aqJ();
    }

    public Bundle toBundle() {
        return arj() ? new Bundle(ark()) : new Bundle();
    }

    private boolean arj() {
        return this.cwz != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle ark() {
        if (!arj()) {
            this.cwz = new Bundle();
        }
        return this.cwz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq arl() {
        return this.ckx;
    }

    public SelfT arm() {
        if (arj()) {
            this.cwz.clear();
        }
        return (SelfT) aqJ();
    }

    public boolean containsKey(String str) {
        return arj() && this.cwz.containsKey(str);
    }

    public SelfT nN(String str) {
        if (arj()) {
            this.cwz.remove(str);
        }
        return (SelfT) aqJ();
    }

    public SelfT T(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.cvR.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) aqJ();
    }

    public SelfT O(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.cvU.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) aqJ();
    }

    public SelfT n(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.cvV.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) aqJ();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.cvW.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) aqJ();
    }

    public SelfT bJ(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.cvY.b(this, str, str2);
        return (SelfT) aqJ();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.cwm.b((c) this, str, (String) strArr);
        return (SelfT) aqJ();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.cvR.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.cvU.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.cvU.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.cvV.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.cvV.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.cvW.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.cvW.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cvY.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.cvY.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            ark().putAll(bundle);
        }
        return (SelfT) aqJ();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.cwr.b((c) this, str, (String) parcelable);
        return (SelfT) aqJ();
    }

    public SelfT d(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.cwq.b((c) this, str, (String) bundle);
        return (SelfT) aqJ();
    }

    @Nullable
    public Bundle nO(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cwq.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T nP(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.cwr.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return arj() ? this.cwz.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
