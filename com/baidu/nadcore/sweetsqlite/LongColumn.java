package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.ty0;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class LongColumn extends Column implements Serializable {
    public static final long serialVersionUID = 6569722519308260828L;
    public long value;

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public int type() {
        return 3;
    }

    public LongColumn(ty0 ty0Var) {
        super(ty0Var);
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
