package com.alibaba.fastjson.asm;
/* loaded from: classes.dex */
public final class Item {
    public int hashCode;
    public int index;
    public int intVal;
    public long longVal;
    public Item next;
    public String strVal1;
    public String strVal2;
    public String strVal3;
    public int type;

    public Item() {
    }

    public boolean isEqualTo(Item item) {
        int i2 = this.type;
        if (i2 != 1) {
            if (i2 != 15) {
                if (i2 == 12) {
                    return item.strVal1.equals(this.strVal1) && item.strVal2.equals(this.strVal2);
                } else if (i2 != 13) {
                    switch (i2) {
                        case 3:
                        case 4:
                            return item.intVal == this.intVal;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            return item.strVal1.equals(this.strVal1) && item.strVal2.equals(this.strVal2) && item.strVal3.equals(this.strVal3);
                    }
                }
            }
            return item.longVal == this.longVal;
        }
        return item.strVal1.equals(this.strVal1);
    }

    public void set(int i2, String str, String str2, String str3) {
        this.type = i2;
        this.strVal1 = str;
        this.strVal2 = str2;
        this.strVal3 = str3;
        if (i2 != 1 && i2 != 7 && i2 != 8) {
            if (i2 == 12) {
                this.hashCode = (i2 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (i2 != 13) {
                this.hashCode = (i2 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                return;
            }
        }
        this.hashCode = (i2 + str.hashCode()) & Integer.MAX_VALUE;
    }

    public Item(int i2, Item item) {
        this.index = i2;
        this.type = item.type;
        this.intVal = item.intVal;
        this.longVal = item.longVal;
        this.strVal1 = item.strVal1;
        this.strVal2 = item.strVal2;
        this.strVal3 = item.strVal3;
        this.hashCode = item.hashCode;
    }

    public void set(int i2) {
        this.type = 3;
        this.intVal = i2;
        this.hashCode = Integer.MAX_VALUE & (3 + i2);
    }
}
