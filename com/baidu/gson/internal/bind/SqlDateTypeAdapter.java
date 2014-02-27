package com.baidu.gson.internal.bind;

import com.baidu.gson.Gson;
import com.baidu.gson.JsonSyntaxException;
import com.baidu.gson.TypeAdapter;
import com.baidu.gson.TypeAdapterFactory;
import com.baidu.gson.reflect.TypeToken;
import com.baidu.gson.stream.JsonReader;
import com.baidu.gson.stream.JsonToken;
import com.baidu.gson.stream.JsonWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: classes.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() { // from class: com.baidu.gson.internal.bind.SqlDateTypeAdapter.1
        @Override // com.baidu.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.gson.TypeAdapter
    public final synchronized Date read(JsonReader jsonReader) {
        Date date;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.format.parse(jsonReader.nextString()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.gson.TypeAdapter
    public final synchronized void write(JsonWriter jsonWriter, Date date) {
        jsonWriter.value(date == null ? null : this.format.format((java.util.Date) date));
    }
}
