package com.baidu.swan.apps.ap;

import java.util.Locale;
/* loaded from: classes10.dex */
public final class c<ValueT> {
    private a<ValueT> bTE;
    public final String id;
    private ValueT mValue;

    /* loaded from: classes10.dex */
    public interface a<ValueT> {
        ValueT acX() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.ap.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.adY().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, adX());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.bTE = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.bTE);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return M(aVar.acX());
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
        this.mValue = valuet;
        e.adY().b(this);
        return true;
    }

    public CharSequence adX() {
        return this.mValue == null ? "" : this.mValue.toString();
    }
}
