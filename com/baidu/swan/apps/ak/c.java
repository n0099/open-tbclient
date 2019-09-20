package com.baidu.swan.apps.ak;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class c<ValueT> {
    private a<ValueT> aZU;
    public final String id;
    private ValueT jp;

    /* loaded from: classes2.dex */
    public interface a<ValueT> {
        ValueT Oa() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.ak.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.Pd().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, Pc());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.aZU = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.aZU);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return K(aVar.Oa());
            } catch (IllegalStateException e) {
                com.baidu.swan.apps.console.c.w("Tracer", "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.ak.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean K(ValueT valuet) {
        this.jp = valuet;
        e.Pd().b(this);
        return true;
    }

    public CharSequence Pc() {
        return this.jp == null ? "" : this.jp.toString();
    }
}
