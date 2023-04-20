package com.baidu.nadcore.sweetsqlite;

import com.baidu.tieba.w11;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class StringColumn extends Column implements Serializable {
    public static final long serialVersionUID = -1864671329325341265L;
    public String value;

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public int type() {
        return 4;
    }

    public StringColumn(w11 w11Var) {
        super(w11Var);
        this.value = "";
    }

    public StringColumn setDefaultValue(String str) {
        if (str == null) {
            str = "";
        }
        this.value = str;
        return this;
    }

    public void setValue(String str) {
        boolean z;
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        this.isAssignedValue = z;
        if (str == null) {
            str = "";
        }
        this.value = str;
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public void clear() {
        this.value = "";
        this.isAssignedValue = false;
    }

    public String getValue() {
        return this.value;
    }

    @Override // com.baidu.nadcore.sweetsqlite.Column
    public String stringValue() {
        if (this.isAssignedValue) {
            return this.value;
        }
        return "";
    }

    public String toString() {
        return this.field.b + ":" + this.value + ":" + this.field.b + ":" + this.field.d;
    }
}
