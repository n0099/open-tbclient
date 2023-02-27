package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.e31;
import com.baidu.tieba.k31;
import java.io.Serializable;
/* loaded from: classes2.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final e31 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(e31 e31Var) {
        this.field = e31Var;
    }

    public void copyTo(Column column) {
        k31.f(this, column);
    }
}
