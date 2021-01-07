package com.baidu.swan.apps.al;

import java.util.Locale;
/* loaded from: classes9.dex */
public final class c<ValueT> {
    private a<ValueT> dQF;
    public final String id;
    private ValueT mValue;

    /* loaded from: classes9.dex */
    public interface a<ValueT> {
        ValueT aPx() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.al.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.aQK().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, aQJ());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.dQF = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.dQF);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return ab(aVar.aPx());
            } catch (IllegalStateException e) {
                com.baidu.swan.apps.console.c.w("Tracer", "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.al.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ab(ValueT valuet) {
        this.mValue = valuet;
        e.aQK().b(this);
        return true;
    }

    public CharSequence aQJ() {
        return this.mValue == null ? "" : this.mValue.toString();
    }
}
