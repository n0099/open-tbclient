package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.e41;
import com.baidu.tieba.y31;
import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class Column implements Serializable {
    public static final long serialVersionUID = 10929877886821294L;
    public final y31 field;
    public boolean isAssignedValue = false;

    public abstract void clear();

    public abstract String stringValue();

    public abstract int type();

    public Column(y31 y31Var) {
        this.field = y31Var;
    }

    public void copyTo(Column column) {
        e41.f(this, column);
    }
}
