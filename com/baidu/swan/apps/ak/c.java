package com.baidu.swan.apps.ak;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class c<ValueT> {
    private a<ValueT> bsc;
    private ValueT bw;
    public final String id;

    /* loaded from: classes2.dex */
    public interface a<ValueT> {
        ValueT SS() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.ak.e */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.id = str;
        e.TR().a(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, TQ());
    }

    public c<ValueT> a(a<ValueT> aVar) {
        this.bsc = aVar;
        update();
        return this;
    }

    public boolean update() {
        return b(this.bsc);
    }

    public boolean b(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return I(aVar.SS());
            } catch (IllegalStateException e) {
                com.baidu.swan.apps.console.c.w("Tracer", "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.ak.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean I(ValueT valuet) {
        this.bw = valuet;
        e.TR().b(this);
        return true;
    }

    public CharSequence TQ() {
        return this.bw == null ? "" : this.bw.toString();
    }
}
