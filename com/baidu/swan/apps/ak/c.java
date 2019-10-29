package com.baidu.swan.apps.ak;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class c<ValueT> {
    private ValueT bY;
    private a<ValueT> bsT;
    public final String id;

    /* loaded from: classes2.dex */
    public interface a<ValueT> {
        ValueT SQ() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.ak.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.TT().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, TS());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.bsT = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.bsT);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return I(aVar.SQ());
            } catch (IllegalStateException e) {
                com.baidu.swan.apps.console.c.w("Tracer", "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.ak.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean I(ValueT valuet) {
        this.bY = valuet;
        e.TT().b(this);
        return true;
    }

    public CharSequence TS() {
        return this.bY == null ? "" : this.bY.toString();
    }
}
