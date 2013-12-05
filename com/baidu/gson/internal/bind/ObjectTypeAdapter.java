package com.baidu.gson.internal.bind;

import com.baidu.gson.Gson;
import com.baidu.gson.TypeAdapter;
import com.baidu.gson.TypeAdapterFactory;
import com.baidu.gson.internal.LinkedTreeMap;
import com.baidu.gson.reflect.TypeToken;
import com.baidu.gson.stream.JsonReader;
import com.baidu.gson.stream.JsonToken;
import com.baidu.gson.stream.JsonWriter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$gson$stream$JsonToken;
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.baidu.gson.internal.bind.ObjectTypeAdapter.1
        @Override // com.baidu.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson, null);
            }
            return null;
        }
    };
    private final Gson gson;

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$gson$stream$JsonToken() {
        int[] iArr = $SWITCH_TABLE$com$baidu$gson$stream$JsonToken;
        if (iArr == null) {
            iArr = new int[JsonToken.valuesCustom().length];
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[JsonToken.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[JsonToken.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[JsonToken.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[JsonToken.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            $SWITCH_TABLE$com$baidu$gson$stream$JsonToken = iArr;
        }
        return iArr;
    }

    private ObjectTypeAdapter(Gson gson) {
        this.gson = gson;
    }

    /* synthetic */ ObjectTypeAdapter(Gson gson, ObjectTypeAdapter objectTypeAdapter) {
        this(gson);
    }

    @Override // com.baidu.gson.TypeAdapter
    public Object read(JsonReader jsonReader) {
        switch ($SWITCH_TABLE$com$baidu$gson$stream$JsonToken()[jsonReader.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(read(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case 2:
            case 4:
            case 5:
            default:
                throw new IllegalStateException();
            case 3:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    linkedTreeMap.put(jsonReader.nextName(), read(jsonReader));
                }
                jsonReader.endObject();
                return linkedTreeMap;
            case 6:
                return jsonReader.nextString();
            case 7:
                return Double.valueOf(jsonReader.nextDouble());
            case 8:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 9:
                jsonReader.nextNull();
                return null;
        }
    }

    @Override // com.baidu.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter adapter = this.gson.getAdapter(obj.getClass());
        if (adapter instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        adapter.write(jsonWriter, obj);
    }
}
