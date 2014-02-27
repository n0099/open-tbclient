package com.baidu.gson;

import com.baidu.gson.internal.C$Gson$Preconditions;
import com.baidu.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
/* loaded from: classes.dex */
public final class JsonPrimitive extends JsonElement {
    private static final Class<?>[] PRIMITIVE_TYPES = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public JsonPrimitive(Boolean bool) {
        setValue(bool);
    }

    public JsonPrimitive(Number number) {
        setValue(number);
    }

    public JsonPrimitive(String str) {
        setValue(str);
    }

    public JsonPrimitive(Character ch) {
        setValue(ch);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonPrimitive(Object obj) {
        setValue(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.gson.JsonElement
    public final JsonPrimitive deepCopy() {
        return this;
    }

    final void setValue(Object obj) {
        if (obj instanceof Character) {
            this.value = String.valueOf(((Character) obj).charValue());
            return;
        }
        C$Gson$Preconditions.checkArgument((obj instanceof Number) || isPrimitiveOrString(obj));
        this.value = obj;
    }

    public final boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    @Override // com.baidu.gson.JsonElement
    final Boolean getAsBooleanWrapper() {
        return (Boolean) this.value;
    }

    @Override // com.baidu.gson.JsonElement
    public final boolean getAsBoolean() {
        return isBoolean() ? getAsBooleanWrapper().booleanValue() : Boolean.parseBoolean(getAsString());
    }

    public final boolean isNumber() {
        return this.value instanceof Number;
    }

    @Override // com.baidu.gson.JsonElement
    public final Number getAsNumber() {
        return this.value instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) this.value;
    }

    public final boolean isString() {
        return this.value instanceof String;
    }

    @Override // com.baidu.gson.JsonElement
    public final String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return getAsBooleanWrapper().toString();
        }
        return (String) this.value;
    }

    @Override // com.baidu.gson.JsonElement
    public final double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override // com.baidu.gson.JsonElement
    public final BigDecimal getAsBigDecimal() {
        return this.value instanceof BigDecimal ? (BigDecimal) this.value : new BigDecimal(this.value.toString());
    }

    @Override // com.baidu.gson.JsonElement
    public final BigInteger getAsBigInteger() {
        return this.value instanceof BigInteger ? (BigInteger) this.value : new BigInteger(this.value.toString());
    }

    @Override // com.baidu.gson.JsonElement
    public final float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    @Override // com.baidu.gson.JsonElement
    public final long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    @Override // com.baidu.gson.JsonElement
    public final short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    @Override // com.baidu.gson.JsonElement
    public final int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override // com.baidu.gson.JsonElement
    public final byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    @Override // com.baidu.gson.JsonElement
    public final char getAsCharacter() {
        return getAsString().charAt(0);
    }

    private static boolean isPrimitiveOrString(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : PRIMITIVE_TYPES) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            long longValue = getAsNumber().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (this.value instanceof Number) {
            long doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        } else {
            return this.value.hashCode();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.value == null) {
            return jsonPrimitive.value == null;
        } else if (isIntegral(this) && isIntegral(jsonPrimitive)) {
            return getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue();
        } else if ((this.value instanceof Number) && (jsonPrimitive.value instanceof Number)) {
            double doubleValue = getAsNumber().doubleValue();
            double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (doubleValue != doubleValue2) {
                return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
            }
            return true;
        } else {
            return this.value.equals(jsonPrimitive.value);
        }
    }

    private static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        if (jsonPrimitive.value instanceof Number) {
            Number number = (Number) jsonPrimitive.value;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }
}
