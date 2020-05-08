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
    private Bundle bXv;

    /* loaded from: classes11.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: adZ */
        public a adw() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.bXv = bundle;
    }

    public SelfT B(Bundle bundle) {
        F(bundle);
        return (SelfT) adw();
    }

    public Bundle toBundle() {
        return adW() ? new Bundle(adX()) : new Bundle();
    }

    private boolean adW() {
        return this.bXv != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle adX() {
        if (!adW()) {
            this.bXv = new Bundle();
        }
        return this.bXv;
    }

    public SelfT adY() {
        if (adW()) {
            this.bXv.clear();
        }
        return (SelfT) adw();
    }

    public boolean containsKey(String str) {
        return adW() && this.bXv.containsKey(str);
    }

    public SelfT jV(String str) {
        if (adW()) {
            this.bXv.remove(str);
        }
        return (SelfT) adw();
    }

    public SelfT B(@Nullable String str, boolean z) {
        com.baidu.swan.apps.x.b.a.a.bWP.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) adw();
    }

    public SelfT I(@Nullable String str, int i) {
        com.baidu.swan.apps.x.b.a.a.bWS.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) adw();
    }

    public SelfT k(@Nullable String str, long j) {
        com.baidu.swan.apps.x.b.a.a.bWT.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) adw();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.x.b.a.a.bWU.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) adw();
    }

    public SelfT bb(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.x.b.a.a.bWW.b(this, str, str2);
        return (SelfT) adw();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.x.b.a.a.bXk.b((c) this, str, (String) strArr);
        return (SelfT) adw();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.x.b.a.a.bWP.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.x.b.a.a.bWS.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.x.b.a.a.bWS.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.x.b.a.a.bWT.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.x.b.a.a.bWT.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.x.b.a.a.bWU.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.x.b.a.a.bWU.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.bWW.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.x.b.a.a.bWW.a(this, str, str2);
    }

    public SelfT F(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            adX().putAll(bundle);
        }
        return (SelfT) adw();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.x.b.a.a.bXp.b((c) this, str, (String) parcelable);
        return (SelfT) adw();
    }

    public SelfT c(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.x.b.a.a.bXo.b((c) this, str, (String) bundle);
        return (SelfT) adw();
    }

    @Nullable
    public Bundle jW(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.bXo.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T jX(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.x.b.a.a.bXp.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return adW() ? this.bXv.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
