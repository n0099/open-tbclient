package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.d41;
import com.baidu.tieba.j41;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final d41 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(d41 d41Var) {
        this.field = d41Var;
    }

    public void copyTo(Column column) {
        j41.f(this, column);
    }
}
