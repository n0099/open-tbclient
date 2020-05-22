package com.baidu.swan.apps.v.b.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.aq.e.d;
import com.baidu.swan.apps.v.b.a.c;
import kotlin.TypeCastException;
/* loaded from: classes11.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private Bundle chV;

    /* loaded from: classes11.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.d
        /* renamed from: ahj */
        public a agG() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.chV = bundle;
    }

    public SelfT E(Bundle bundle) {
        I(bundle);
        return (SelfT) agG();
    }

    public Bundle toBundle() {
        return ahg() ? new Bundle(ahh()) : new Bundle();
    }

    private boolean ahg() {
        return this.chV != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle ahh() {
        if (!ahg()) {
            this.chV = new Bundle();
        }
        return this.chV;
    }

    public SelfT ahi() {
        if (ahg()) {
            this.chV.clear();
        }
        return (SelfT) agG();
    }

    public boolean containsKey(String str) {
        return ahg() && this.chV.containsKey(str);
    }

    public SelfT lh(String str) {
        if (ahg()) {
            this.chV.remove(str);
        }
        return (SelfT) agG();
    }

    public SelfT N(@Nullable String str, boolean z) {
        com.baidu.swan.apps.v.b.a.a.chp.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) agG();
    }

    public SelfT M(@Nullable String str, int i) {
        com.baidu.swan.apps.v.b.a.a.chs.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) agG();
    }

    public SelfT j(@Nullable String str, long j) {
        com.baidu.swan.apps.v.b.a.a.cht.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) agG();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.v.b.a.a.chu.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) agG();
    }

    public SelfT bs(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.v.b.a.a.chw.b(this, str, str2);
        return (SelfT) agG();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.v.b.a.a.chK.b((c) this, str, (String) strArr);
        return (SelfT) agG();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.v.b.a.a.chp.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.v.b.a.a.chs.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.v.b.a.a.chs.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.v.b.a.a.cht.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.v.b.a.a.cht.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.v.b.a.a.chu.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.v.b.a.a.chu.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.v.b.a.a.chw.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.v.b.a.a.chw.a(this, str, str2);
    }

    public SelfT I(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            ahh().putAll(bundle);
        }
        return (SelfT) agG();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.v.b.a.a.chP.b((c) this, str, (String) parcelable);
        return (SelfT) agG();
    }

    public SelfT e(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.v.b.a.a.chO.b((c) this, str, (String) bundle);
        return (SelfT) agG();
    }

    @Nullable
    public Bundle li(@Nullable String str) {
        return com.baidu.swan.apps.v.b.a.a.chO.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T lj(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.v.b.a.a.chP.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return ahg() ? this.chV.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
