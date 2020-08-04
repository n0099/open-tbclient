package com.baidu.swan.apps.u.c.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.aq.ar;
import com.baidu.swan.apps.aq.e.d;
import com.baidu.swan.apps.u.c.a.c;
import kotlin.TypeCastException;
/* loaded from: classes7.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {
    private final ar ceh;
    private Bundle coR;

    /* loaded from: classes7.dex */
    public static final class a extends c<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.d
        /* renamed from: ajG */
        public a ajc() {
            return this;
        }
    }

    public c() {
        this(null);
    }

    public c(Bundle bundle) {
        this.ceh = new ar();
        this.coR = bundle;
    }

    public SelfT F(Bundle bundle) {
        J(bundle);
        return (SelfT) ajc();
    }

    public Bundle toBundle() {
        return ajC() ? new Bundle(ajD()) : new Bundle();
    }

    private boolean ajC() {
        return this.coR != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle ajD() {
        if (!ajC()) {
            this.coR = new Bundle();
        }
        return this.coR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar ajE() {
        return this.ceh;
    }

    public SelfT ajF() {
        if (ajC()) {
            this.coR.clear();
        }
        return (SelfT) ajc();
    }

    public boolean containsKey(String str) {
        return ajC() && this.coR.containsKey(str);
    }

    public SelfT lQ(String str) {
        if (ajC()) {
            this.coR.remove(str);
        }
        return (SelfT) ajc();
    }

    public SelfT O(@Nullable String str, boolean z) {
        com.baidu.swan.apps.u.c.a.a.coj.b((c) this, str, (String) Boolean.valueOf(z));
        return (SelfT) ajc();
    }

    public SelfT M(@Nullable String str, int i) {
        com.baidu.swan.apps.u.c.a.a.f972com.b((c) this, str, (String) Integer.valueOf(i));
        return (SelfT) ajc();
    }

    public SelfT k(@Nullable String str, long j) {
        com.baidu.swan.apps.u.c.a.a.con.b((c) this, str, (String) Long.valueOf(j));
        return (SelfT) ajc();
    }

    public SelfT d(@Nullable String str, float f) {
        com.baidu.swan.apps.u.c.a.a.coo.b((c) this, str, (String) Float.valueOf(f));
        return (SelfT) ajc();
    }

    public SelfT bw(@Nullable String str, @Nullable String str2) {
        com.baidu.swan.apps.u.c.a.a.coq.b(this, str, str2);
        return (SelfT) ajc();
    }

    public SelfT d(@Nullable String str, @Nullable String[] strArr) {
        com.baidu.swan.apps.u.c.a.a.coE.b((c) this, str, (String) strArr);
        return (SelfT) ajc();
    }

    public boolean getBoolean(String str, boolean z) {
        return com.baidu.swan.apps.u.c.a.a.coj.a((c) this, str, (String) Boolean.valueOf(z)).booleanValue();
    }

    public int getInt(String str) {
        return com.baidu.swan.apps.u.c.a.a.f972com.a(this, str).intValue();
    }

    public int getInt(String str, int i) {
        return com.baidu.swan.apps.u.c.a.a.f972com.a((c) this, str, (String) Integer.valueOf(i)).intValue();
    }

    public long getLong(String str) {
        return com.baidu.swan.apps.u.c.a.a.con.a(this, str).longValue();
    }

    public long getLong(String str, long j) {
        return com.baidu.swan.apps.u.c.a.a.con.a((c) this, str, (String) Long.valueOf(j)).longValue();
    }

    public float getFloat(String str) {
        return com.baidu.swan.apps.u.c.a.a.coo.a(this, str).floatValue();
    }

    public float getFloat(String str, float f) {
        return com.baidu.swan.apps.u.c.a.a.coo.a((c) this, str, (String) Float.valueOf(f)).floatValue();
    }

    @Nullable
    public String getString(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.coq.a(this, str);
    }

    public String getString(@Nullable String str, String str2) {
        return com.baidu.swan.apps.u.c.a.a.coq.a(this, str, str2);
    }

    public SelfT J(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            ajD().putAll(bundle);
        }
        return (SelfT) ajc();
    }

    public SelfT a(@Nullable String str, @Nullable Parcelable parcelable) {
        com.baidu.swan.apps.u.c.a.a.coJ.b((c) this, str, (String) parcelable);
        return (SelfT) ajc();
    }

    public SelfT e(@Nullable String str, @Nullable Bundle bundle) {
        com.baidu.swan.apps.u.c.a.a.coI.b((c) this, str, (String) bundle);
        return (SelfT) ajc();
    }

    @Nullable
    public Bundle lR(@Nullable String str) {
        return com.baidu.swan.apps.u.c.a.a.coI.a(this, str);
    }

    @Nullable
    public <T extends Parcelable> T lS(@Nullable String str) {
        try {
            return (T) com.baidu.swan.apps.u.c.a.a.coJ.a(this, str);
        } catch (TypeCastException e) {
            return null;
        }
    }

    public synchronized String toString() {
        return ajC() ? this.coR.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }
}
