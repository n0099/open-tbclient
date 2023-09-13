package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.h41;
import com.baidu.tieba.n41;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final h41 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(h41 h41Var) {
        this.field = h41Var;
    }

    public void copyTo(Column column) {
        n41.f(this, column);
    }
}
