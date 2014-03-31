package com.baidu.adp.lib.debug;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
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
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class a {
    static int a = 0;

    private static String a(String str, Object obj, List list) {
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            Class<?> cls = obj.getClass();
            if (str.equals("") || str == null) {
                stringBuffer.append(String.valueOf(a()) + cls.getSimpleName() + " = {\n");
            } else {
                stringBuffer.append(String.valueOf(str) + " = {\n");
            }
            while (cls != null && a(cls)) {
                if (!cls.getSimpleName().equals("Object")) {
                    a++;
                    a(cls.getDeclaredFields(), obj, stringBuffer, list);
                    a--;
                }
                cls = cls.getSuperclass();
            }
            stringBuffer.append(String.valueOf(a()) + "}\n");
        } catch (IllegalAccessException e) {
            stringBuffer.append(e.toString());
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"DefaultLocale"})
    private static boolean a(Class<?> cls) {
        for (String str : new String[]{"activity", "content", "listener", "view", "drawable"}) {
            if (cls.getSimpleName().toLowerCase().endsWith(str)) {
                return false;
            }
        }
        return true;
    }

    private static void a(Field[] fieldArr, Object obj, StringBuffer stringBuffer, List list) {
        for (int i = 0; i < fieldArr.length; i++) {
            fieldArr[i].setAccessible(true);
            if (!Modifier.isStatic(fieldArr[i].getModifiers())) {
                stringBuffer.append(c(String.valueOf(a()) + fieldArr[i].getName(), fieldArr[i].get(obj), list));
            }
        }
    }

    private static String a() {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < a; i++) {
            stringBuffer.append("    ");
        }
        return stringBuffer.toString();
    }

    private static boolean a(Object obj) {
        return obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Hashtable) || (obj instanceof HashMap) || (obj instanceof SparseArray) || (obj instanceof HashSet) || (obj instanceof List) || (obj instanceof AbstractMap);
    }

    private static boolean b(Object obj) {
        Class<?> cls;
        return (obj == null || (obj instanceof Boolean) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof String) || (cls = obj.getClass()) == Boolean.TYPE || cls == Boolean.class || cls == Short.TYPE || cls == Short.class || cls == Byte.TYPE || cls == Byte.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Character.TYPE || cls == Character.class || cls == Double.TYPE || cls == Double.class || cls == String.class) ? false : true;
    }

    private static String b(String str, Object obj, List list) {
        Iterator it;
        int i;
        int i2 = 0;
        StringBuffer stringBuffer = new StringBuffer("");
        if (obj.getClass().isArray()) {
            if (Array.getLength(obj) > 0) {
                if (b(Array.get(obj, 0))) {
                    while (i2 < Array.getLength(obj)) {
                        stringBuffer.append(c(String.valueOf(str) + "[" + i2 + "]", Array.get(obj, i2), list));
                        i2++;
                    }
                } else {
                    stringBuffer.append(String.valueOf(str) + " = [");
                    for (int i3 = 0; i3 < Array.getLength(obj) - 1; i3++) {
                        stringBuffer.append(c(Array.get(obj, i3)) + ",");
                    }
                    stringBuffer.append(Array.get(obj, Array.getLength(obj) - 1) + "]\n");
                }
            } else {
                stringBuffer.append(String.valueOf(str) + "[] = empty\n");
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
                        Object c = c(obj2);
                        Object c2 = c(obj3);
                        if (!b(c2) && !b(c)) {
                            if (i2 == 0) {
                                stringBuffer.append(String.valueOf(str) + " = [");
                            } else if (i2 == size - 1) {
                                stringBuffer.append(c + " = " + c2 + "]\n");
                            } else {
                                stringBuffer.append(c + " = " + c2 + ", ");
                            }
                        } else {
                            stringBuffer.append(c(String.valueOf(str) + "[" + c + "]", c2, list));
                        }
                        i2++;
                    }
                } else {
                    stringBuffer.append(String.valueOf(str) + "[] = empty\n");
                }
            } else if (z || z2) {
                if (obj != null) {
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
                            Object c3 = c(it.next());
                            if (!b(c3)) {
                                if (i2 == 0) {
                                    stringBuffer.append(String.valueOf(str) + " = [");
                                } else if (i2 == i - 1) {
                                    stringBuffer.append(c3 + "]\n");
                                } else {
                                    stringBuffer.append(c3 + ", ");
                                }
                            } else {
                                stringBuffer.append(c(String.valueOf(str) + "[" + i2 + "]", c3, list));
                            }
                            i2++;
                        }
                    } else {
                        stringBuffer.append(String.valueOf(str) + "[] = empty\n");
                    }
                } else {
                    stringBuffer.append(String.valueOf(str) + "[] = null\n");
                }
            } else if (z3) {
                int size2 = ((SparseArray) obj).size();
                if (size2 > 0) {
                    while (i2 < size2) {
                        Integer valueOf = Integer.valueOf(((SparseArray) obj).keyAt(i2));
                        Object valueAt = ((SparseArray) obj).valueAt(i2);
                        Object c4 = c(valueOf);
                        Object c5 = c(valueAt);
                        if (!b(c5) && !b(c4)) {
                            if (i2 == 0) {
                                stringBuffer.append(String.valueOf(str) + " = [");
                            } else if (i2 == size2 - 1) {
                                stringBuffer.append(c4 + " = " + c5 + "]\n");
                            } else {
                                stringBuffer.append(c4 + " = " + c5 + ", ");
                            }
                        } else {
                            stringBuffer.append(c(String.valueOf(str) + "[" + c4 + "]", c5, list));
                        }
                        i2++;
                    }
                } else {
                    stringBuffer.append(String.valueOf(str) + "[] = empty\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    private static Object c(Object obj) {
        if (obj != null && obj.getClass() == String.class) {
            return "\"" + obj + "\"";
        }
        return obj;
    }

    private static String c(String str, Object obj, List list) {
        if (obj == null) {
            return String.valueOf(str) + " = null\n";
        }
        if (a(obj)) {
            return b(str, obj, list);
        }
        if (b(obj)) {
            if (!list.contains(obj)) {
                list.add(obj);
                return a(str, obj, list);
            }
            return String.valueOf(str) + " = <already visited>\n";
        }
        return String.valueOf(str) + " = " + c(obj) + IOUtils.LINE_SEPARATOR_UNIX;
    }

    public static void a(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (c.e) {
            stringBuffer.append("Message_Type: " + str + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append(obj == null ? String.valueOf("") + ": null\n" : a(obj) ? b("", obj, new ArrayList()) : b(obj) ? a("", obj, new ArrayList()) : String.valueOf("") + " = " + obj.toString() + "\n\r");
            stringBuffer.append("----------------------------------------------------------\n");
            for (String str2 : stringBuffer.toString().split(IOUtils.LINE_SEPARATOR_UNIX)) {
                Log.i("CP", str2);
            }
        }
    }
}
