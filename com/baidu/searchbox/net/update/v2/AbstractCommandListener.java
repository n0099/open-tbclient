package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.searchbox.net.update.CommandPostData;
import com.google.gson.TypeAdapter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.json.JSONException;
/* loaded from: classes13.dex */
public abstract class AbstractCommandListener<T> {
    public abstract void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException;

    public abstract boolean executeCommand(Context context, String str, String str2, ActionData<T> actionData);

    public abstract String getLocalVersion(Context context, String str, String str2);

    public TypeAdapter<T> getTypeAdapter() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Type getDataType() {
        for (Class<? super Object> cls = getClass(); cls != null; cls = cls.getSuperclass()) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ActionData<T> createDataObject() {
        return new ActionData<>();
    }
}
