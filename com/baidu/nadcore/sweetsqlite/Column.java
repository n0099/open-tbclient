package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.d51;
import com.baidu.tieba.x41;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final x41 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(x41 x41Var) {
        this.field = x41Var;
    }

    public void copyTo(Column column) {
        d51.f(this, column);
    }
}
