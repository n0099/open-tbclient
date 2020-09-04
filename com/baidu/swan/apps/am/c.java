package com.baidu.swan.apps.am;

import java.util.Locale;
/* loaded from: classes8.dex */
public final class c<ValueT> {
    private a<ValueT> daf;
    public final String id;
    private ValueT mValue;

    /* loaded from: classes8.dex */
    public interface a<ValueT> {
        ValueT aCU() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.am.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.aEg().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, aEf());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.daf = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.daf);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return W(aVar.aCU());
            } catch (IllegalStateException e) {
                com.baidu.swan.apps.console.c.w("Tracer", "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.am.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean W(ValueT valuet) {
        this.mValue = valuet;
        e.aEg().b(this);
        return true;
    }

    public CharSequence aEf() {
        return this.mValue == null ? "" : this.mValue.toString();
    }
}
