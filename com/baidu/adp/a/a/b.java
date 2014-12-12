package com.baidu.adp.a.a;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
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
    static int ct = 0;

    private static String a(String str, Object obj, List list) {
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            Class<?> cls = obj.getClass();
            if (str.equals("") || str == null) {
                stringBuffer.append(String.valueOf(ao()) + cls.getSimpleName() + " = {\n");
            } else {
                stringBuffer.append(String.valueOf(str) + " = {\n");
            }
            while (cls != null && i(cls)) {
                if (!cls.getSimpleName().equals("Object")) {
                    ct++;
                    a(cls.getDeclaredFields(), obj, stringBuffer, list);
                    ct--;
                }
                cls = cls.getSuperclass();
            }
            stringBuffer.append(String.valueOf(ao()) + "}\n");
        } catch (IllegalAccessException e) {
            stringBuffer.append(e.toString());
        }
        return stringBuffer.toString();
    }

    private static boolean i(Class<?> cls) {
        for (String str : new String[]{"activity", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, "listener", "view", "drawable"}) {
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
                stringBuffer.append(c(String.valueOf(ao()) + fieldArr[i].getName(), fieldArr[i].get(obj), list));
            }
        }
    }

    private static String ao() {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < ct; i++) {
            stringBuffer.append("    ");
        }
        return stringBuffer.toString();
    }

    public static boolean d(Object obj) {
        return obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Hashtable) || (obj instanceof HashMap) || (obj instanceof SparseArray) || (obj instanceof HashSet) || (obj instanceof List) || (obj instanceof AbstractMap);
    }

    public static boolean e(Object obj) {
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
                if (e(Array.get(obj, 0))) {
                    while (i2 < Array.getLength(obj)) {
                        stringBuffer.append(c(String.valueOf(str) + "[" + i2 + "]", Array.get(obj, i2), list));
                        i2++;
                    }
                } else {
                    stringBuffer.append(String.valueOf(str) + " = [");
                    for (int i3 = 0; i3 < Array.getLength(obj) - 1; i3++) {
                        stringBuffer.append(f(Array.get(obj, i3)) + ",");
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
                        Object f = f(obj2);
                        Object f2 = f(obj3);
                        if (!e(f2) && !e(f)) {
                            if (i2 == 0) {
                                stringBuffer.append(String.valueOf(str) + " = [");
                            } else if (i2 == size - 1) {
                                stringBuffer.append(f + " = " + f2 + "]\n");
                            } else {
                                stringBuffer.append(f + " = " + f2 + ", ");
                            }
                        } else {
                            stringBuffer.append(c(String.valueOf(str) + "[" + f + "]", f2, list));
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
                            Object f3 = f(it.next());
                            if (!e(f3)) {
                                if (i2 == 0) {
                                    stringBuffer.append(String.valueOf(str) + " = [");
                                } else if (i2 == i - 1) {
                                    stringBuffer.append(f3 + "]\n");
                                } else {
                                    stringBuffer.append(f3 + ", ");
                                }
                            } else {
                                stringBuffer.append(c(String.valueOf(str) + "[" + i2 + "]", f3, list));
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
                        Object f4 = f(valueOf);
                        Object f5 = f(valueAt);
                        if (!e(f5) && !e(f4)) {
                            if (i2 == 0) {
                                stringBuffer.append(String.valueOf(str) + " = [");
                            } else if (i2 == size2 - 1) {
                                stringBuffer.append(f4 + " = " + f5 + "]\n");
                            } else {
                                stringBuffer.append(f4 + " = " + f5 + ", ");
                            }
                        } else {
                            stringBuffer.append(c(String.valueOf(str) + "[" + f4 + "]", f5, list));
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

    private static Object f(Object obj) {
        if (obj != null && obj.getClass() == String.class) {
            return "\"" + obj + "\"";
        }
        return obj;
    }

    private static String c(String str, Object obj, List list) {
        if (obj == null) {
            return String.valueOf(str) + " = null\n";
        }
        if (d(obj)) {
            return b(str, obj, list);
        }
        if (e(obj)) {
            if (!list.contains(obj)) {
                list.add(obj);
                return a(str, obj, list);
            }
            return String.valueOf(str) + " = <already visited>\n";
        }
        return String.valueOf(str) + " = " + f(obj) + "\n";
    }

    private static String c(String str, Object obj) {
        if (obj == null) {
            return String.valueOf(str) + ": null\n";
        }
        if (d(obj)) {
            return b(str, obj, new ArrayList());
        }
        if (e(obj)) {
            return a(str, obj, new ArrayList());
        }
        return String.valueOf(str) + " = " + obj.toString() + "\n\r";
    }

    public static void d(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (d.cF) {
            stringBuffer.append("Message_Type: " + str + "\n");
            stringBuffer.append(c("", obj));
            stringBuffer.append("----------------------------------------------------------\n");
            String[] split = stringBuffer.toString().split("\n");
            for (String str2 : split) {
                Log.i("CP", str2);
            }
        }
    }
}
