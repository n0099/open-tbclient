package com.baidu.arface.a;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;
/* loaded from: classes3.dex */
public class a {
    public static String B(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!obj.getClass().isArray()) {
            throw new InvalidParameterException("Not a primitive array: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = 0;
        while (i < length) {
            sb.append(Array.get(obj, i)).append(',').append(' ');
            i++;
        }
        if (i > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(']');
        return sb.toString();
    }
}
