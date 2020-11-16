package com.baidu.swan.apps.u.c.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.ap.aq;
import com.baidu.swan.apps.ap.e.d;
import com.baidu.swan.apps.u.c.a.c;
import kotlin.TypeCastException;
/* loaded from: classes7.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private final aq cLz;
    private Bundle cXo;

    /* loaded from: classes7.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: ayv */
        public a axR() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.cLz = new aq();
        this.cXo = bundle;
    }

    public SelfT D(Bundle bundle) {
        H(bundle);
        return (SelfT) axR();
    }

    public Bundle toBundle() {
        return ayr() ? new Bundle(ays()) : new Bundle();
    }

    private boolean ayr() {
        return this.cXo != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle ays() {
        if (!ayr()) {
            this.cXo = new Bundle();
        }
        return this.cXo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq ayt() {
        return this.cLz;
    }

    public SelfT ayu() {
        if (ayr()) {
            this.cXo.clear();
        }
        return (SelfT) axR();
    }

    public boolean containsKey(String str) {
        return ayr() && this.cXo.containsKey(str);
    }

    public SelfT pw(String str) {
        if (ayr()) {
            this.cXo.remove(str);
        }
        return (SelfT) axR();
    }

    public SelfT Z(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.cWG.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) axR();
    }

    public SelfT R(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.cWJ.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) axR();
    }

    public SelfT p(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.cWK.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) axR();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.cWL.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) axR();
    }

    public SelfT bU(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.cWN.b(this, str, str2);
        return (SelfT) axR();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.cXb.b((c) this, str, (String) strArr);
        return (SelfT) axR();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.cWG.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.cWJ.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.cWJ.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.cWK.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.cWK.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.cWL.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.cWL.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cWN.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.cWN.a(this, str, str2);
    }

    public SelfT H(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            ays().putAll(bundle);
        }
        return (SelfT) axR();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.cXg.b((c) this, str, (String) parcelable);
        return (SelfT) axR();
    }

    public SelfT d(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.cXf.b((c) this, str, (String) bundle);
        return (SelfT) axR();
    }

    @Nullable
    public Bundle px(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.cXf.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T py(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.cXg.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return ayr() ? this.cXo.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
