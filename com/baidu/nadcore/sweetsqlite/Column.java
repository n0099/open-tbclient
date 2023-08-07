package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.a41;
import com.baidu.tieba.g41;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final a41 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(a41 a41Var) {
        this.field = a41Var;
    }

    public void copyTo(Column column) {
        g41.f(this, column);
    }
}
