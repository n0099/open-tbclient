package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.d41;
import com.baidu.tieba.x31;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final x31 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(x31 x31Var) {
        this.field = x31Var;
    }

    public void copyTo(Column column) {
        d41.f(this, column);
    }
}
