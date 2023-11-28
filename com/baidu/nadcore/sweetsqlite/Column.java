package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.lz0;
import com.baidu.tieba.rz0;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final lz0 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(lz0 lz0Var) {
        this.field = lz0Var;
    }

    public void copyTo(Column column) {
        rz0.c(this, column);
    }
}
