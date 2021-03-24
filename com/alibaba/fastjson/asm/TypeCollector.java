package com.alibaba.fastjson.asm;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TypeCollector {
    public static final Map<String, String> primitives = new HashMap<String, String>() { // from class: com.alibaba.fastjson.asm.TypeCollector.1
        {
            put("int", "I");
            put("boolean", "Z");
            put("byte", "B");
            put("char", "C");
            put("short", ExifInterface.LATITUDE_SOUTH);
            put("float", "F");
            put("long", "J");
            put("double", "D");
        }
    };
    public MethodCollector collector = null;
    public final String methodName;
    public final Class<?>[] parameterTypes;

    public TypeCollector(String str, Class<?>[] clsArr) {
        this.methodName = str;
        this.parameterTypes = clsArr;
    }

    private boolean correctTypeName(Type type, String str) {
        String className = type.getClassName();
        String str2 = "";
        while (className.endsWith("[]")) {
            str2 = str2 + "[";
            className = className.substring(0, className.length() - 2);
        }
        if (!str2.equals("")) {
            if (primitives.containsKey(className)) {
                className = str2 + primitives.get(className);
            } else {
                className = str2 + "L" + className + ";";
            }
        }
        return className.equals(str);
    }

    public String[] getParameterNamesForMethod() {
        MethodCollector methodCollector = this.collector;
        return (methodCollector == null || !methodCollector.debugInfoPresent) ? new String[0] : methodCollector.getResult().split(",");
    }

    public MethodCollector visitMethod(int i, String str, String str2) {
        if (this.collector == null && str.equals(this.methodName)) {
            Type[] argumentTypes = Type.getArgumentTypes(str2);
            int i2 = 0;
            for (Type type : argumentTypes) {
                String className = type.getClassName();
                if (className.equals("long") || className.equals("double")) {
                    i2++;
                }
            }
            if (argumentTypes.length != this.parameterTypes.length) {
                return null;
            }
            for (int i3 = 0; i3 < argumentTypes.length; i3++) {
                if (!correctTypeName(argumentTypes[i3], this.parameterTypes[i3].getName())) {
                    return null;
                }
            }
            MethodCollector methodCollector = new MethodCollector(!Modifier.isStatic(i) ? 1 : 0, argumentTypes.length + i2);
            this.collector = methodCollector;
            return methodCollector;
        }
        return null;
    }
}
