package com.alibaba.fastjson.asm;

import android.support.media.ExifInterface;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class TypeCollector {
    private static final Map<String, String> primitives = new HashMap<String, String>() { // from class: com.alibaba.fastjson.asm.TypeCollector.1
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
    protected MethodCollector collector = null;
    private final String methodName;
    private final Class<?>[] parameterTypes;

    public TypeCollector(String str, Class<?>[] clsArr) {
        this.methodName = str;
        this.parameterTypes = clsArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
            MethodCollector methodCollector = new MethodCollector(Modifier.isStatic(i) ? 0 : 1, i2 + argumentTypes.length);
            this.collector = methodCollector;
            return methodCollector;
        }
        return null;
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
                className = str2 + "L" + className + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
            }
        }
        return className.equals(str);
    }

    public String[] getParameterNamesForMethod() {
        return (this.collector == null || !this.collector.debugInfoPresent) ? new String[0] : this.collector.getResult().split(",");
    }
}
