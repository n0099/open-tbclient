package com.baidu.swan.apps.al;

import java.util.Locale;
/* loaded from: classes8.dex */
public final class c<ValueT> {
    private a<ValueT> dLT;
    public final String id;
    private ValueT mValue;

    /* loaded from: classes8.dex */
    public interface a<ValueT> {
        ValueT aLD() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.al.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.aMQ().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, aMP());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.dLT = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.dLT);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return ab(aVar.aLD());
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
        e.aMQ().b(this);
        return true;
    }

    public CharSequence aMP() {
        return this.mValue == null ? "" : this.mValue.toString();
    }
}
