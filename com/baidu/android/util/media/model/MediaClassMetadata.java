package com.baidu.android.util.media.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes18.dex */
public class MediaClassMetadata {
    public Map<String, Field> fieldDatas;
    public String select;
    public String[] selectArgs;
    public String sort;

    public String[] getProjection() {
        if (this.fieldDatas == null) {
            return null;
        }
        return (String[]) this.fieldDatas.keySet().toArray(new String[0]);
    }

    public String toString() {
        return "MediaClassMetadata{select='" + this.select + "', selectArgs=" + Arrays.toString(this.selectArgs) + ", sort='" + this.sort + "', fieldDatas=" + this.fieldDatas + '}';
    }
}
