package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.a21;
import com.baidu.tieba.u11;
import java.io.Serializable;
/* loaded from: classes2.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final u11 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(u11 u11Var) {
        this.field = u11Var;
    }

    public void copyTo(Column column) {
        a21.f(this, column);
    }
}
