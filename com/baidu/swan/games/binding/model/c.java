package com.baidu.swan.games.binding.model;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class c {
    private Map<String, Object> bfG;
    private Map<String, Integer> bfH;

    public static c c(JsObject jsObject) {
        if (jsObject == null) {
            Log.e("JSObjectMap", "parseFromJSObject object is null.");
            return null;
        }
        c cVar = new c();
        for (int i = 0; i < jsObject.length(); i++) {
            int propertyType = jsObject.getPropertyType(i);
            String propertyName = jsObject.getPropertyName(i);
            cVar.Rj().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    cVar.Ri().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                    break;
                case 2:
                    cVar.Ri().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                    break;
                case 3:
                    cVar.Ri().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                    break;
                case 5:
                    cVar.Ri().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                    break;
                case 6:
                    cVar.Ri().put(propertyName, new d(i, jsObject));
                    break;
                case 7:
                    cVar.Ri().put(propertyName, jsObject.toString(i));
                    break;
                case 8:
                    cVar.Ri().put(propertyName, jsObject.toJsFunction(i));
                    break;
                case 9:
                    cVar.Ri().put(propertyName, jsObject.toJsObject(i));
                    break;
                case 10:
                    cVar.Ri().put(propertyName, jsObject.toJsArrayBuffer(i));
                    break;
            }
        }
        return cVar;
    }

    private Map<String, Object> Ri() {
        if (this.bfG == null) {
            this.bfG = new TreeMap();
        }
        return this.bfG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> Rj() {
        if (this.bfH == null) {
            this.bfH = new TreeMap();
        }
        return this.bfH;
    }

    public int iT(String str) {
        Integer num = Rj().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public int length() {
        return Ri().size();
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(Ri().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(Ri().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(Ri().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public long optLong(String str, long j) {
        Long l = a.toLong(Ri().get(str));
        return l != null ? l.longValue() : j;
    }

    public double getDouble(String str) throws JSTypeMismatchException {
        Double d = a.toDouble(Ri().get(str));
        if (d == null) {
            throw a.a(this, str, 5);
        }
        return d.doubleValue();
    }

    public String[] iU(String str) throws JSTypeMismatchException {
        d M = a.M(Ri().get(str));
        if (M == null) {
            throw a.a(this, str, 6);
        }
        return M.bfI.toStringArray(M.index);
    }

    public String[] iV(String str) {
        return g(str, null);
    }

    public String[] g(String str, String[] strArr) {
        d M = a.M(Ri().get(str));
        return M != null ? M.bfI.toStringArray(M.index) : strArr;
    }

    public JsObject[] iW(String str) throws JSTypeMismatchException {
        d M = a.M(Ri().get(str));
        if (M == null) {
            throw a.a(this, str, 6);
        }
        return M.bfI.toObjectArray(M.index);
    }

    public double[] iX(String str) {
        return a(str, (double[]) null);
    }

    public double[] a(String str, double[] dArr) {
        d M = a.M(Ri().get(str));
        return M != null ? M.bfI.toDoubleArray(M.index) : dArr;
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(Ri().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(Ri().get(str));
        return aVar != null ? aVar : str2;
    }

    public JsFunction iY(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction N = a.N(Ri().get(str));
        return N != null ? N : jsFunction;
    }

    public JsObject iZ(String str) {
        return a(str, (JsObject) null);
    }

    public JsObject a(String str, JsObject jsObject) {
        JsObject O = a.O(Ri().get(str));
        return O != null ? O : jsObject;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer P = a.P(Ri().get(str));
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
            if (cVar.Rj().containsKey(str)) {
                i2 = ((Integer) cVar.Rj().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return Ri().toString();
    }
}
