package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.b21;
import com.baidu.tieba.v11;
import java.io.Serializable;
/* loaded from: classes2.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final v11 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(v11 v11Var) {
        this.field = v11Var;
    }

    public void copyTo(Column column) {
        b21.f(this, column);
    }
}
