package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.o21;
import com.baidu.tieba.u21;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final o21 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(o21 o21Var) {
        this.field = o21Var;
    }

    public void copyTo(Column column) {
        u21.f(this, column);
    }
}
