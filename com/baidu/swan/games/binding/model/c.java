package com.baidu.swan.games.binding.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, Object> cVW;
    private Map<String, Integer> cVX;

    public static c e(JsObject jsObject) {
        if (jsObject == null) {
            if (DEBUG) {
                Log.e("JSObjectMap", "parseFromJSObject object is null.");
            }
            return null;
        }
        c cVar = new c();
        boolean z = false;
        for (int i = 0; i < jsObject.length(); i++) {
            int propertyType = jsObject.getPropertyType(i);
            String propertyName = jsObject.getPropertyName(i);
            cVar.azb().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    cVar.aza().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                    break;
                case 2:
                    cVar.aza().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                    break;
                case 3:
                    cVar.aza().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                    break;
                case 5:
                    cVar.aza().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                    break;
                case 6:
                    cVar.aza().put(propertyName, new d(i, jsObject));
                    z = true;
                    break;
                case 7:
                    cVar.aza().put(propertyName, jsObject.toString(i));
                    break;
                case 8:
                    cVar.aza().put(propertyName, jsObject.toJsFunction(i));
                    break;
                case 9:
                    cVar.aza().put(propertyName, e(jsObject.toJsObject(i)));
                    break;
                case 10:
                    cVar.aza().put(propertyName, jsObject.toJsArrayBuffer(i));
                    break;
            }
        }
        if (!z) {
            jsObject.release();
        }
        return cVar;
    }

    private Map<String, Object> aza() {
        if (this.cVW == null) {
            this.cVW = new TreeMap();
        }
        return this.cVW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> azb() {
        if (this.cVX == null) {
            this.cVX = new TreeMap();
        }
        return this.cVX;
    }

    public Set<String> keySet() {
        return aza().keySet();
    }

    public int rm(String str) {
        Integer num = azb().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public boolean rn(String str) {
        return azb().containsKey(str);
    }

    public int length() {
        return aza().size();
    }

    public void put(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            aza().put(str, obj);
        }
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(aza().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(aza().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(aza().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public long optLong(String str, long j) {
        Long l = a.toLong(aza().get(str));
        return l != null ? l.longValue() : j;
    }

    public double getDouble(String str) throws JSTypeMismatchException {
        Double d = a.toDouble(aza().get(str));
        if (d == null) {
            throw a.a(this, str, 5);
        }
        return d.doubleValue();
    }

    public double optDouble(String str, double d) {
        Double d2 = a.toDouble(aza().get(str));
        return d2 != null ? d2.doubleValue() : d;
    }

    public String[] ro(String str) throws JSTypeMismatchException {
        d Z = a.Z(aza().get(str));
        if (Z == null) {
            throw a.a(this, str, 6);
        }
        return Z.cVY.toStringArray(Z.index);
    }

    public String[] rp(String str) {
        return f(str, null);
    }

    public String[] f(String str, String[] strArr) {
        d Z = a.Z(aza().get(str));
        return Z != null ? Z.cVY.toStringArray(Z.index) : strArr;
    }

    public JsObject[] rq(String str) throws JSTypeMismatchException {
        d Z = a.Z(aza().get(str));
        if (Z == null) {
            throw a.a(this, str, 6);
        }
        return Z.cVY.toObjectArray(Z.index);
    }

    public JsObject[] rr(String str) {
        return a(str, (JsObject[]) null);
    }

    public JsObject[] a(String str, JsObject[] jsObjectArr) {
        d Z = a.Z(aza().get(str));
        return Z != null ? Z.cVY.toObjectArray(Z.index) : jsObjectArr;
    }

    public double[] rs(String str) {
        return a(str, (double[]) null);
    }

    public double[] a(String str, double[] dArr) {
        d Z = a.Z(aza().get(str));
        return Z != null ? Z.cVY.toDoubleArray(Z.index) : dArr;
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(aza().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(aza().get(str));
        return aVar != null ? aVar : str2;
    }

    public String toString(String str) {
        return String.valueOf(aza().get(str));
    }

    public JsFunction rt(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction aa = a.aa(aza().get(str));
        return aa != null ? aa : jsFunction;
    }

    public c ru(String str) {
        return a(str, (c) null);
    }

    public c a(String str, c cVar) {
        c ac = a.ac(aza().get(str));
        return ac != null ? ac : cVar;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer ab = a.ab(aza().get(str));
        return ab != null ? ab : jsArrayBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
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

        static d Z(Object obj) {
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

        static JsFunction aa(Object obj) {
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
            return null;
        }

        static JsArrayBuffer ab(Object obj) {
            if (obj instanceof JsArrayBuffer) {
                return (JsArrayBuffer) obj;
            }
            return null;
        }

        static c ac(Object obj) {
            if (obj instanceof c) {
                return (c) obj;
            }
            return null;
        }

        static JSTypeMismatchException a(c cVar, String str, int i) {
            int i2;
            if (cVar.azb().containsKey(str)) {
                i2 = ((Integer) cVar.azb().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return aza().toString();
    }
}
