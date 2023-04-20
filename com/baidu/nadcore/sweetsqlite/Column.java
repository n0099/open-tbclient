package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.c21;
import com.baidu.tieba.w11;
import java.io.Serializable;
/* loaded from: classes2.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final w11 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(w11 w11Var) {
        this.field = w11Var;
    }

    public void copyTo(Column column) {
        c21.f(this, column);
    }
}
