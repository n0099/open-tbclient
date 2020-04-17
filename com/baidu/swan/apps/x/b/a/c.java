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
    private Bundle bXp;

    /* loaded from: classes11.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: aea */
        public a adx() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.bXp = bundle;
    }

    public SelfT B(Bundle bundle) {
        F(bundle);
        return (SelfT) adx();
    }

    public Bundle toBundle() {
        return adX() ? new Bundle(adY()) : new Bundle();
    }

    private boolean adX() {
        return this.bXp != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle adY() {
        if (!adX()) {
            this.bXp = new Bundle();
        }
        return this.bXp;
    }

    public SelfT adZ() {
        if (adX()) {
            this.bXp.clear();
        }
        return (SelfT) adx();
    }

    public boolean containsKey(String str) {
        return adX() && this.bXp.containsKey(str);
    }

    public SelfT jV(String str) {
        if (adX()) {
            this.bXp.remove(str);
        }
        return (SelfT) adx();
    }

    public SelfT B(@Nullable String str, boolean z) {
        com.baidu.swan.apps.x.b.a.a.bWJ.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) adx();
    }

    public SelfT I(@Nullable String str, int i) {
        com.baidu.swan.apps.x.b.a.a.bWM.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) adx();
    }

    public SelfT k(@Nullable String str, long j) {
        com.baidu.swan.apps.x.b.a.a.bWN.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) adx();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.x.b.a.a.bWO.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) adx();
    }

    public SelfT bb(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.x.b.a.a.bWQ.b(this, str, str2);
        return (SelfT) adx();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.x.b.a.a.bXe.b((c) this, str, (String) strArr);
        return (SelfT) adx();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.x.b.a.a.bWJ.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.x.b.a.a.bWM.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.x.b.a.a.bWM.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.x.b.a.a.bWN.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.x.b.a.a.bWN.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.x.b.a.a.bWO.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.x.b.a.a.bWO.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.bWQ.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.x.b.a.a.bWQ.a(this, str, str2);
    }

    public SelfT F(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            adY().putAll(bundle);
        }
        return (SelfT) adx();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.x.b.a.a.bXj.b((c) this, str, (String) parcelable);
        return (SelfT) adx();
    }

    public SelfT c(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.x.b.a.a.bXi.b((c) this, str, (String) bundle);
        return (SelfT) adx();
    }

    @Nullable
    public Bundle jW(@Nullable String str) {
        return com.baidu.swan.apps.x.b.a.a.bXi.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T jX(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.x.b.a.a.bXj.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return adX() ? this.bXp.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
