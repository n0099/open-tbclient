package com.baidu.gson.internal;

import java.math.BigDecimal;
/* loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {
    private final String value;

    public LazilyParsedNumber(String str) {
        this.value = str;
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            return Integer.parseInt(this.value);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.value);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.value).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.value);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.value).longValue();
        }
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public final String toString() {
        return this.value;
    }

    private Object writeReplace() {
        return new BigDecimal(this.value);
    }
}
