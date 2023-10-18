package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.ty0;
import com.baidu.tieba.zy0;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final ty0 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(ty0 ty0Var) {
        this.field = ty0Var;
    }

    public void copyTo(Column column) {
        zy0.c(this, column);
    }
}
