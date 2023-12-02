package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.nz0;
import com.baidu.tieba.tz0;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final nz0 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(nz0 nz0Var) {
        this.field = nz0Var;
    }

    public void copyTo(Column column) {
        tz0.c(this, column);
    }
}
