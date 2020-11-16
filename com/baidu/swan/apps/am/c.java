package com.baidu.swan.apps.am;

import java.util.Locale;
/* loaded from: classes7.dex */
public final class c<ValueT> {
    private a<ValueT> dBc;
    public final String id;
    private ValueT mValue;

    /* loaded from: classes7.dex */
    public interface a<ValueT> {
        ValueT aJZ() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.am.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.aLl().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, aLk());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.dBc = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.dBc);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return aa(aVar.aJZ());
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
        this.mValue = valuet;
        e.aLl().b(this);
        return true;
    }

    public CharSequence aLk() {
        return this.mValue == null ? "" : this.mValue.toString();
    }
}
