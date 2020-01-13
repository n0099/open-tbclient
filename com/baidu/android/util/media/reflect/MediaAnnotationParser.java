package com.baidu.android.util.media.reflect;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.media.LogUtil;
import com.baidu.android.util.media.annotations.ColumnName;
import com.baidu.android.util.media.annotations.MediaQueryParam;
import com.baidu.android.util.media.model.MediaClassMetadata;
import com.baidu.android.util.media.model.MediaInfo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class MediaAnnotationParser {
    public MediaClassMetadata getMetaData(Class<? extends MediaInfo> cls) {
        if (cls == null) {
            LogUtil.e("tClass", cls);
            return null;
        }
        MediaClassMetadata mediaClassMetadata = new MediaClassMetadata();
        MediaQueryParam mediaQueryParam = (MediaQueryParam) cls.getAnnotation(MediaQueryParam.class);
        if (mediaQueryParam != null) {
            mediaClassMetadata.select = appendStr(mediaQueryParam.select());
            mediaClassMetadata.selectArgs = mediaQueryParam.selectArgs();
            mediaClassMetadata.sort = appendStr(mediaQueryParam.sortBy(), mediaQueryParam.sortType());
        }
        mediaClassMetadata.fieldDatas = collectFieldData(cls);
        return mediaClassMetadata;
    }

    private String appendStr(String... strArr) {
        if (strArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    private Map<String, Field> collectFieldData(Class<? extends MediaInfo> cls) {
        HashMap hashMap = new HashMap();
        hashMap.put(IMConstants.MSG_ROW_ID, null);
        if (cls == null) {
            LogUtil.e("collectFieldData tclass", cls);
            return hashMap;
        }
        Field[] fields = cls.getFields();
        if (fields == null || fields.length <= 0) {
            LogUtil.e("no field find, please check your info class");
            return hashMap;
        }
        for (Field field : fields) {
            ColumnName columnName = (ColumnName) field.getAnnotation(ColumnName.class);
            if (columnName != null) {
                hashMap.put(columnName.value(), field);
            }
        }
        return hashMap;
    }
}
