package com.baidu.adp.a.a;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.baidu.adp.lib.util.BdLog;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static int vy = 0;

    private static String a(String str, Object obj, List list) {
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            Class<?> cls = obj.getClass();
            if (str == null || str.equals("")) {
                stringBuffer.append(gf() + cls.getSimpleName() + " = {\n");
            } else {
                stringBuffer.append(str + " = {\n");
            }
            while (cls != null && f(cls)) {
                if (!cls.getSimpleName().equals("Object")) {
                    vy++;
                    a(cls.getDeclaredFields(), obj, stringBuffer, list);
                    vy--;
                }
                cls = cls.getSuperclass();
            }
            stringBuffer.append(gf() + "}\n");
        } catch (IllegalAccessException e) {
            stringBuffer.append(e.toString());
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"DefaultLocale"})
    private static boolean f(Class<?> cls) {
        for (String str : new String[]{PushConstants.INTENT_ACTIVITY_NAME, "content", "listener", "view", "drawable"}) {
            if (cls.getSimpleName().toLowerCase().endsWith(str)) {
                return false;
            }
        }
        return true;
    }

    private static void a(Field[] fieldArr, Object obj, StringBuffer stringBuffer, List list) throws IllegalAccessException {
        for (int i = 0; i < fieldArr.length; i++) {
            fieldArr[i].setAccessible(true);
            if (!Modifier.isStatic(fieldArr[i].getModifiers())) {
                stringBuffer.append(c(gf() + fieldArr[i].getName(), fieldArr[i].get(obj), list));
            }
        }
    }

    private static String gf() {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < vy; i++) {
            stringBuffer.append("    ");
        }
        return stringBuffer.toString();
    }

    public static boolean n(Object obj) {
        return obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Hashtable) || (obj instanceof HashMap) || (obj instanceof SparseArray) || (obj instanceof HashSet) || (obj instanceof List) || (obj instanceof AbstractMap);
    }

    public static boolean o(Object obj) {
        Class<?> cls;
        return (obj == null || (obj instanceof Boolean) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof String) || (cls = obj.getClass()) == Boolean.TYPE || cls == Boolean.class || cls == Short.TYPE || cls == Short.class || cls == Byte.TYPE || cls == Byte.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Character.TYPE || cls == Character.class || cls == Double.TYPE || cls == Double.class || cls == String.class) ? false : true;
    }

    private static String b(String str, Object obj, List list) {
        Iterator it;
        int i;
        int i2 = 0;
        StringBuffer stringBuffer = new StringBuffer("");
        if (obj == null) {
            stringBuffer.append(str + "[] = null\n");
            return stringBuffer.toString();
        }
        if (obj.getClass().isArray()) {
            if (Array.getLength(obj) > 0) {
                if (!o(Array.get(obj, 0))) {
                    stringBuffer.append(str + " = [");
                    for (int i3 = 0; i3 < Array.getLength(obj) - 1; i3++) {
                        stringBuffer.append(p(Array.get(obj, i3)) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    stringBuffer.append(Array.get(obj, Array.getLength(obj) - 1) + "]\n");
                } else {
                    while (i2 < Array.getLength(obj)) {
                        stringBuffer.append(c(str + "[" + i2 + "]", Array.get(obj, i2), list));
                        i2++;
                    }
                }
            } else {
                stringBuffer.append(str + "[] = empty\n");
            }
        } else {
            boolean z = obj instanceof Collection;
            boolean z2 = obj instanceof HashSet;
            boolean z3 = obj instanceof SparseArray;
            if ((obj instanceof AbstractMap) || (obj instanceof HashMap) || (obj instanceof Hashtable)) {
                Set keySet = ((Map) obj).keySet();
                int size = keySet.size();
                if (size > 0) {
                    for (Object obj2 : keySet) {
                        Object obj3 = ((Map) obj).get(obj2);
                        Object p = p(obj2);
                        Object p2 = p(obj3);
                        if (!o(p2) && !o(p)) {
                            if (i2 == 0) {
                                stringBuffer.append(str + " = [");
                            } else if (i2 == size - 1) {
                                stringBuffer.append(p + " = " + p2 + "]\n");
                            } else {
                                stringBuffer.append(p + " = " + p2 + ", ");
                            }
                        } else {
                            stringBuffer.append(c(str + "[" + p + "]", p2, list));
                        }
                        i2++;
                    }
                } else {
                    stringBuffer.append(str + "[] = empty\n");
                }
            } else if (z || z2) {
                if (z) {
                    it = ((Collection) obj).iterator();
                    i = ((Collection) obj).size();
                } else if (!z2) {
                    it = null;
                    i = 0;
                } else {
                    it = ((HashSet) obj).iterator();
                    i = ((HashSet) obj).size();
                }
                if (i > 0) {
                    while (it.hasNext()) {
                        Object p3 = p(it.next());
                        if (!o(p3)) {
                            if (i2 == 0) {
                                stringBuffer.append(str + " = [");
                            } else if (i2 == i - 1) {
                                stringBuffer.append(p3 + "]\n");
                            } else {
                                stringBuffer.append(p3 + ", ");
                            }
                        } else {
                            stringBuffer.append(c(str + "[" + i2 + "]", p3, list));
                        }
                        i2++;
                    }
                } else {
                    stringBuffer.append(str + "[] = empty\n");
                }
            } else if (z3) {
                int size2 = ((SparseArray) obj).size();
                if (size2 > 0) {
                    while (i2 < size2) {
                        Integer valueOf = Integer.valueOf(((SparseArray) obj).keyAt(i2));
                        Object valueAt = ((SparseArray) obj).valueAt(i2);
                        Object p4 = p(valueOf);
                        Object p5 = p(valueAt);
                        if (!o(p5) && !o(p4)) {
                            if (i2 == 0) {
                                stringBuffer.append(str + " = [");
                            } else if (i2 == size2 - 1) {
                                stringBuffer.append(p4 + " = " + p5 + "]\n");
                            } else {
                                stringBuffer.append(p4 + " = " + p5 + ", ");
                            }
                        } else {
                            stringBuffer.append(c(str + "[" + p4 + "]", p5, list));
                        }
                        i2++;
                    }
                } else {
                    stringBuffer.append(str + "[] = empty\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    private static Object p(Object obj) {
        if (obj != null && obj.getClass() == String.class) {
            return "\"" + obj + "\"";
        }
        return obj;
    }

    private static String c(String str, Object obj, List list) {
        if (obj == null) {
            return str + " = null\n";
        }
        if (n(obj)) {
            return b(str, obj, list);
        }
        if (o(obj)) {
            if (!list.contains(obj)) {
                list.add(obj);
                return a(str, obj, list);
            }
            return str + " = <already visited>\n";
        }
        return str + " = " + p(obj) + "\n";
    }

    private static String b(String str, Object obj) {
        if (obj == null) {
            return str + ": null\n";
        }
        if (n(obj)) {
            return b(str, obj, new ArrayList());
        }
        if (o(obj)) {
            return a(str, obj, new ArrayList());
        }
        return str + " = " + obj.toString() + "\n\r";
    }

    public static void c(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (d.vJ) {
            stringBuffer.append("Message_Type: " + str + "\n");
            stringBuffer.append(b("", obj));
            stringBuffer.append("----------------------------------------------------------\n");
            String[] split = stringBuffer.toString().split("\n");
            for (String str2 : split) {
                BdLog.i(str2);
            }
        }
    }
}
