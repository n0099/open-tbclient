package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.g41;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class BooleanColumn extends Column implements Serializable {
    public static final long serialVersionUID = 466868693299856341L;
    public boolean value;

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public int type() {
        return 1;
    }

    public BooleanColumn(g41 g41Var) {
        super(g41Var);
    }

    public BooleanColumn setDefaultValue(boolean z) {
        this.value = z;
        return this;
    }

    public void setValue(boolean z) {
        this.isAssignedValue = true;
        this.value = z;
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public void clear() {
        this.value = false;
        this.isAssignedValue = false;
    }

    public boolean getValue() {
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
