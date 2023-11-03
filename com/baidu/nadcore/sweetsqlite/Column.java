package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.kz0;
import com.baidu.tieba.qz0;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final kz0 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(kz0 kz0Var) {
        this.field = kz0Var;
    }

    public void copyTo(Column column) {
        qz0.c(this, column);
    }
}
