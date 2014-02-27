package com.baidu.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final List<JsonElement> elements = new ArrayList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.gson.JsonElement
    public final JsonArray deepCopy() {
        JsonArray jsonArray = new JsonArray();
        for (JsonElement jsonElement : this.elements) {
            jsonArray.add(jsonElement.deepCopy());
        }
        return jsonArray;
    }

    public final void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement);
    }

    public final void addAll(JsonArray jsonArray) {
        this.elements.addAll(jsonArray.elements);
    }

    public final int size() {
        return this.elements.size();
    }

    @Override // java.lang.Iterable
    public final Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public final JsonElement get(int i) {
        return this.elements.get(i);
    }

    @Override // com.baidu.gson.JsonElement
    public final Number getAsNumber() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsNumber();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final String getAsString() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsString();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final double getAsDouble() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final BigDecimal getAsBigDecimal() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigDecimal();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final BigInteger getAsBigInteger() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigInteger();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final float getAsFloat() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsFloat();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final long getAsLong() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final int getAsInt() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final byte getAsByte() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsByte();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final char getAsCharacter() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsCharacter();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final short getAsShort() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsShort();
        }
        throw new IllegalStateException();
    }

    @Override // com.baidu.gson.JsonElement
    public final boolean getAsBoolean() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).elements.equals(this.elements));
    }

    public final int hashCode() {
        return this.elements.hashCode();
    }
}
