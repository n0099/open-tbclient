package com.baidu.swan.apps.al;

import java.util.Locale;
/* loaded from: classes9.dex */
public final class c<ValueT> {
    private a<ValueT> dNX;
    public final String id;
    private ValueT mValue;

    /* loaded from: classes9.dex */
    public interface a<ValueT> {
        ValueT aLW() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.al.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.aNj().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, aNi());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.dNX = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.dNX);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return ab(aVar.aLW());
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
        e.aNj().b(this);
        return true;
    }

    public CharSequence aNi() {
        return this.mValue == null ? "" : this.mValue.toString();
    }
}
