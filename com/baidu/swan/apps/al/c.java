package com.baidu.swan.apps.al;

import java.util.Locale;
/* loaded from: classes8.dex */
public final class c<ValueT> {
    private a<ValueT> dPy;
    public final String id;
    private ValueT mValue;

    /* loaded from: classes8.dex */
    public interface a<ValueT> {
        ValueT aLZ() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.al.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.aNm().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, aNl());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.dPy = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.dPy);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return ad(aVar.aLZ());
            } catch (IllegalStateException e) {
                com.baidu.swan.apps.console.c.w("Tracer", "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.al.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ad(ValueT valuet) {
        this.mValue = valuet;
        e.aNm().b(this);
        return true;
    }

    public CharSequence aNl() {
        return this.mValue == null ? "" : this.mValue.toString();
    }
}
