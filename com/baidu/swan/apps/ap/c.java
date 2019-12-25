package com.baidu.swan.apps.ap;

import java.util.Locale;
/* loaded from: classes9.dex */
public final class c<ValueT> {
    private ValueT bA;
    private a<ValueT> bTs;
    public final String id;

    /* loaded from: classes9.dex */
    public interface a<ValueT> {
        ValueT acA() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.ap.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.adF().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, adE());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.bTs = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.bTs);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return M(aVar.acA());
            } catch (IllegalStateException e) {
                com.baidu.swan.apps.console.c.w("Tracer", "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.ap.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean M(ValueT valuet) {
        this.bA = valuet;
        e.adF().b(this);
        return true;
    }

    public CharSequence adE() {
        return this.bA == null ? "" : this.bA.toString();
    }
}
