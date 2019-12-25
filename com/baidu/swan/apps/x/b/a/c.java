package com.baidu.swan.apps.x.b.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.as.d.d;
import com.baidu.swan.apps.x.b.a.c;
import kotlin.TypeCastException;
/* loaded from: classes9.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private Bundle btY;

    /* loaded from: classes9.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: Tv */
        public a SS() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.btY = bundle;
    }

    public SelfT B(Bundle bundle) {
        F(bundle);
        return (SelfT) SS();
    }

    public Bundle toBundle() {
        return Ts() ? new Bundle(Tt()) : new Bundle();
    }

    private boolean Ts() {
        return this.btY != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle Tt() {
        if (!Ts()) {
            this.btY = new Bundle();
        }
        return this.btY;
    }

    public SelfT Tu() {
        if (Ts()) {
            this.btY.clear();
        }
        return (SelfT) SS();
    }

    public boolean containsKey(String str) {
        return Ts() && this.btY.containsKey(str);
    }

    public SelfT ir(String str) {
        if (Ts()) {
            this.btY.remove(str);
        }
        return (SelfT) SS();
    }

    public SelfT w(@Nullable String str, boolean z) {
        com.baidu.swan.apps.x.b.a.a.bts.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) SS();
    }

    public SelfT C(@Nullable String str, int i) {
        com.baidu.swan.apps.x.b.a.a.btv.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) SS();
    }

    public SelfT j(@Nullable String str, long j) {
        com.baidu.swan.apps.x.b.a.a.btw.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) SS();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.x.b.a.a.btx.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) SS();
    }

    public SelfT aH(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.x.b.a.a.btz.b(this, str, str2);
        return (SelfT) SS();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.x.b.a.a.btN.b((c) this, str, (String) strArr);
        return (SelfT) SS();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.x.b.a.a.bts.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.x.b.a.a.btv.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.x.b.a.a.btv.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.x.b.a.a.btw.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.x.b.a.a.btw.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.x.b.a.a.btx.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.x.b.a.a.btx.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.btz.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.x.b.a.a.btz.a(this, str, str2);
    }

    public SelfT F(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            Tt().putAll(bundle);
        }
        return (SelfT) SS();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.x.b.a.a.btS.b((c) this, str, (String) parcelable);
        return (SelfT) SS();
    }

    public SelfT c(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.x.b.a.a.btR.b((c) this, str, (String) bundle);
        return (SelfT) SS();
    }

    @Nullable
    public Bundle is(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.btR.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T it(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.x.b.a.a.btS.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return Ts() ? this.btY.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
