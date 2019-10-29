package com.baidu.swan.games.binding.model;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class c {
    private Map<String, Object> byX;
    private Map<String, Integer> byY;

    public static c c(JsObject jsObject) {
        if (jsObject == null) {
            Log.e("JSObjectMap", "parseFromJSObject object is null.");
            return null;
        }
        c cVar = new c();
        for (int i = 0; i < jsObject.length(); i++) {
            int propertyType = jsObject.getPropertyType(i);
            String propertyName = jsObject.getPropertyName(i);
            cVar.We().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    cVar.Wd().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                    break;
                case 2:
                    cVar.Wd().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                    break;
                case 3:
                    cVar.Wd().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                    break;
                case 5:
                    cVar.Wd().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                    break;
                case 6:
                    cVar.Wd().put(propertyName, new d(i, jsObject));
                    break;
                case 7:
                    cVar.Wd().put(propertyName, jsObject.toString(i));
                    break;
                case 8:
                    cVar.Wd().put(propertyName, jsObject.toJsFunction(i));
                    break;
                case 9:
                    cVar.Wd().put(propertyName, jsObject.toJsObject(i));
                    break;
                case 10:
                    cVar.Wd().put(propertyName, jsObject.toJsArrayBuffer(i));
                    break;
            }
        }
        return cVar;
    }

    private Map<String, Object> Wd() {
        if (this.byX == null) {
            this.byX = new TreeMap();
        }
        return this.byX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> We() {
        if (this.byY == null) {
            this.byY = new TreeMap();
        }
        return this.byY;
    }

    public int jy(String str) {
        Integer num = We().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public int length() {
        return Wd().size();
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(Wd().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(Wd().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(Wd().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public long optLong(String str, long j) {
        Long l = a.toLong(Wd().get(str));
        return l != null ? l.longValue() : j;
    }

    public double getDouble(String str) throws JSTypeMismatchException {
        Double d = a.toDouble(Wd().get(str));
        if (d == null) {
            throw a.a(this, str, 5);
        }
        return d.doubleValue();
    }

    public String[] jz(String str) throws JSTypeMismatchException {
        d K = a.K(Wd().get(str));
        if (K == null) {
            throw a.a(this, str, 6);
        }
        return K.byZ.toStringArray(K.index);
    }

    public String[] jA(String str) {
        return f(str, null);
    }

    public String[] f(String str, String[] strArr) {
        d K = a.K(Wd().get(str));
        return K != null ? K.byZ.toStringArray(K.index) : strArr;
    }

    public JsObject[] jB(String str) throws JSTypeMismatchException {
        d K = a.K(Wd().get(str));
        if (K == null) {
            throw a.a(this, str, 6);
        }
        return K.byZ.toObjectArray(K.index);
    }

    public double[] jC(String str) {
        return a(str, (double[]) null);
    }

    public double[] a(String str, double[] dArr) {
        d K = a.K(Wd().get(str));
        return K != null ? K.byZ.toDoubleArray(K.index) : dArr;
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(Wd().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(Wd().get(str));
        return aVar != null ? aVar : str2;
    }

    public JsFunction jD(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction L = a.L(Wd().get(str));
        return L != null ? L : jsFunction;
    }

    public JsObject jE(String str) {
        return a(str, (JsObject) null);
    }

    public JsObject a(String str, JsObject jsObject) {
        JsObject M = a.M(Wd().get(str));
        return M != null ? M : jsObject;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer N = a.N(Wd().get(str));
        return N != null ? N : jsArrayBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        static Boolean toBoolean(Object obj) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            return null;
        }

        static Double toDouble(Object obj) {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            return null;
        }

        static Integer toInteger(Object obj) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            if (obj instanceof Number) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            return null;
        }

        static Long toLong(Object obj) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
            if (obj instanceof Number) {
                return Long.valueOf(((Number) obj).longValue());
            }
            return null;
        }

        static d K(Object obj) {
            if (obj instanceof d) {
                return (d) obj;
            }
            return null;
        }

        static String toString(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        static JsFunction L(Object obj) {
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
            return null;
        }

        static JsObject M(Object obj) {
            if (obj instanceof JsObject) {
                return (JsObject) obj;
            }
            return null;
        }

        static JsArrayBuffer N(Object obj) {
            if (obj instanceof JsArrayBuffer) {
                return (JsArrayBuffer) obj;
            }
            return null;
        }

        static JSTypeMismatchException a(c cVar, String str, int i) {
            int i2;
            if (cVar.We().containsKey(str)) {
                i2 = ((Integer) cVar.We().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return Wd().toString();
    }
}
