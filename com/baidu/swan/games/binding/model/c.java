package com.baidu.swan.games.binding.model;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class c {
    private Map<String, Object> beT;
    private Map<String, Integer> beU;

    public static c c(JsObject jsObject) {
        if (jsObject == null) {
            Log.e("JSObjectMap", "parseFromJSObject object is null.");
            return null;
        }
        c cVar = new c();
        for (int i = 0; i < jsObject.length(); i++) {
            int propertyType = jsObject.getPropertyType(i);
            String propertyName = jsObject.getPropertyName(i);
            cVar.getTypeMap().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    cVar.Qq().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                    break;
                case 2:
                    cVar.Qq().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                    break;
                case 3:
                    cVar.Qq().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                    break;
                case 5:
                    cVar.Qq().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                    break;
                case 6:
                    cVar.Qq().put(propertyName, new d(i, jsObject));
                    break;
                case 7:
                    cVar.Qq().put(propertyName, jsObject.toString(i));
                    break;
                case 8:
                    cVar.Qq().put(propertyName, jsObject.toJsFunction(i));
                    break;
                case 9:
                    cVar.Qq().put(propertyName, jsObject.toJsObject(i));
                    break;
                case 10:
                    cVar.Qq().put(propertyName, jsObject.toJsArrayBuffer(i));
                    break;
            }
        }
        return cVar;
    }

    private Map<String, Object> Qq() {
        if (this.beT == null) {
            this.beT = new TreeMap();
        }
        return this.beT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> getTypeMap() {
        if (this.beU == null) {
            this.beU = new TreeMap();
        }
        return this.beU;
    }

    public int iN(String str) {
        Integer num = getTypeMap().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public int length() {
        return Qq().size();
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(Qq().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(Qq().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(Qq().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public long optLong(String str, long j) {
        Long l = a.toLong(Qq().get(str));
        return l != null ? l.longValue() : j;
    }

    public double getDouble(String str) throws JSTypeMismatchException {
        Double d = a.toDouble(Qq().get(str));
        if (d == null) {
            throw a.a(this, str, 5);
        }
        return d.doubleValue();
    }

    public String[] getStringArray(String str) throws JSTypeMismatchException {
        d M = a.M(Qq().get(str));
        if (M == null) {
            throw a.a(this, str, 6);
        }
        return M.beV.toStringArray(M.index);
    }

    public String[] iO(String str) {
        return f(str, null);
    }

    public String[] f(String str, String[] strArr) {
        d M = a.M(Qq().get(str));
        return M != null ? M.beV.toStringArray(M.index) : strArr;
    }

    public JsObject[] iP(String str) throws JSTypeMismatchException {
        d M = a.M(Qq().get(str));
        if (M == null) {
            throw a.a(this, str, 6);
        }
        return M.beV.toObjectArray(M.index);
    }

    public double[] iQ(String str) {
        return a(str, (double[]) null);
    }

    public double[] a(String str, double[] dArr) {
        d M = a.M(Qq().get(str));
        return M != null ? M.beV.toDoubleArray(M.index) : dArr;
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(Qq().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(Qq().get(str));
        return aVar != null ? aVar : str2;
    }

    public JsFunction iR(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction N = a.N(Qq().get(str));
        return N != null ? N : jsFunction;
    }

    public JsObject iS(String str) {
        return a(str, (JsObject) null);
    }

    public JsObject a(String str, JsObject jsObject) {
        JsObject O = a.O(Qq().get(str));
        return O != null ? O : jsObject;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer P = a.P(Qq().get(str));
        return P != null ? P : jsArrayBuffer;
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

        static d M(Object obj) {
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

        static JsFunction N(Object obj) {
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
            return null;
        }

        static JsObject O(Object obj) {
            if (obj instanceof JsObject) {
                return (JsObject) obj;
            }
            return null;
        }

        static JsArrayBuffer P(Object obj) {
            if (obj instanceof JsArrayBuffer) {
                return (JsArrayBuffer) obj;
            }
            return null;
        }

        static JSTypeMismatchException a(c cVar, String str, int i) {
            int i2;
            if (cVar.getTypeMap().containsKey(str)) {
                i2 = ((Integer) cVar.getTypeMap().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return Qq().toString();
    }
}
