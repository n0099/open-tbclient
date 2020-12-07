package com.baidu.swan.apps.am;

import java.util.Locale;
/* loaded from: classes25.dex */
public final class c<ValueT> {
    private a<ValueT> dIa;
    public final String id;
    private ValueT zJ;

    /* loaded from: classes25.dex */
    public interface a<ValueT> {
        ValueT aNg() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.am.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.aOs().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, aOr());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.dIa = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.dIa);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return aa(aVar.aNg());
            } catch (IllegalStateException e) {
                com.baidu.swan.apps.console.c.w("Tracer", "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.am.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aa(ValueT valuet) {
        this.zJ = valuet;
        e.aOs().b(this);
        return true;
    }

    public CharSequence aOr() {
        return this.zJ == null ? "" : this.zJ.toString();
    }
}
