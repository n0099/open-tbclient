package com.baidu.swan.apps.an;

import java.util.Locale;
/* loaded from: classes11.dex */
public final class c<ValueT> {
    private a<ValueT> cIW;
    public final String id;
    private ValueT mValue;

    /* loaded from: classes11.dex */
    public interface a<ValueT> {
        ValueT arD() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.an.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.asQ().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, asP());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.cIW = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.cIW);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return T(aVar.arD());
            } catch (IllegalStateException e) {
                com.baidu.swan.apps.console.c.w("Tracer", "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.an.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean T(ValueT valuet) {
        this.mValue = valuet;
        e.asQ().b(this);
        return true;
    }

    public CharSequence asP() {
        return this.mValue == null ? "" : this.mValue.toString();
    }
}
