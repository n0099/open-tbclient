package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.e21;
import com.baidu.tieba.y11;
import java.io.Serializable;
/* loaded from: classes2.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final y11 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(y11 y11Var) {
        this.field = y11Var;
    }

    public void copyTo(Column column) {
        e21.f(this, column);
    }
}
