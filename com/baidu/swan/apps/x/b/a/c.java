package com.baidu.swan.apps.x.b.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.as.d.d;
import com.baidu.swan.apps.x.b.a.c;
import kotlin.TypeCastException;
/* loaded from: classes10.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private Bundle buN;

    /* loaded from: classes10.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: TS */
        public a Tp() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.buN = bundle;
    }

    public SelfT B(Bundle bundle) {
        F(bundle);
        return (SelfT) Tp();
    }

    public Bundle toBundle() {
        return TP() ? new Bundle(TQ()) : new Bundle();
    }

    private boolean TP() {
        return this.buN != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle TQ() {
        if (!TP()) {
            this.buN = new Bundle();
        }
        return this.buN;
    }

    public SelfT TR() {
        if (TP()) {
            this.buN.clear();
        }
        return (SelfT) Tp();
    }

    public boolean containsKey(String str) {
        return TP() && this.buN.containsKey(str);
    }

    public SelfT iu(String str) {
        if (TP()) {
            this.buN.remove(str);
        }
        return (SelfT) Tp();
    }

    public SelfT w(@Nullable String str, boolean z) {
        com.baidu.swan.apps.x.b.a.a.buh.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) Tp();
    }

    public SelfT C(@Nullable String str, int i) {
        com.baidu.swan.apps.x.b.a.a.buk.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) Tp();
    }

    public SelfT j(@Nullable String str, long j) {
        com.baidu.swan.apps.x.b.a.a.bul.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) Tp();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.x.b.a.a.bum.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) Tp();
    }

    public SelfT aI(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.x.b.a.a.buo.b(this, str, str2);
        return (SelfT) Tp();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.x.b.a.a.buC.b((c) this, str, (String) strArr);
        return (SelfT) Tp();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.x.b.a.a.buh.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.x.b.a.a.buk.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.x.b.a.a.buk.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.x.b.a.a.bul.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.x.b.a.a.bul.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.x.b.a.a.bum.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.x.b.a.a.bum.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.buo.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.x.b.a.a.buo.a(this, str, str2);
    }

    public SelfT F(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            TQ().putAll(bundle);
        }
        return (SelfT) Tp();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.x.b.a.a.buH.b((c) this, str, (String) parcelable);
        return (SelfT) Tp();
    }

    public SelfT c(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.x.b.a.a.buG.b((c) this, str, (String) bundle);
        return (SelfT) Tp();
    }

    @Nullable
    public Bundle iv(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.buG.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T iw(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.x.b.a.a.buH.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return TP() ? this.buN.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
