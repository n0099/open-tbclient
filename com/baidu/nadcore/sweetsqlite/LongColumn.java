package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.v11;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class LongColumn extends Column implements Serializable {
    public static final long serialVersionUID = 6569722519308260828L;
    public long value;

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public int type() {
        return 3;
    }

    public LongColumn(v11 v11Var) {
        super(v11Var);
    }

    public LongColumn setDefaultValue(long j) {
        this.value = j;
        return this;
    }

    public void setValue(long j) {
        this.isAssignedValue = true;
        this.value = j;
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public void clear() {
        this.value = 0L;
        this.isAssignedValue = false;
    }

    public long getValue() {
        return this.value;
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public String stringValue() {
        return String.valueOf(this.value);
    }

    public String toString() {
        return this.field.b + ":" + this.value + ":" + this.field.b + ":" + this.field.d;
    }
}
