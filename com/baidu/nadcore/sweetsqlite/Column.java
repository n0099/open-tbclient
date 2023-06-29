package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.b41;
import com.baidu.tieba.h41;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final b41 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(b41 b41Var) {
        this.field = b41Var;
    }

    public void copyTo(Column column) {
        h41.f(this, column);
    }
}
