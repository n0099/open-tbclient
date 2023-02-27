package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.e31;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class IntegerColumn extends Column implements Serializable {
    public static final long serialVersionUID = 6464317274646219935L;
    public int value;

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public int type() {
        return 2;
    }

    public IntegerColumn(e31 e31Var) {
        super(e31Var);
    }

    public IntegerColumn setDefaultValue(int i) {
        this.value = i;
        return this;
    }

    public IntegerColumn setValue(int i) {
        this.isAssignedValue = true;
        this.value = i;
        return this;
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public void clear() {
        this.value = 0;
        this.isAssignedValue = false;
    }

    public int getValue() {
        return this.value;
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public String stringValue() {
        return String.valueOf(this.value);
    }

    public String toString() {
        return this.field.b + ":" + this.value + ":" + this.field.c + ":" + this.field.d;
    }
}
