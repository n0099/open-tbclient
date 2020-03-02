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
    private Map<String, Object> clU;
    private Map<String, Integer> clV;

    public static c c(JsObject jsObject) {
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
            cVar.amW().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    cVar.amV().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                    break;
                case 2:
                    cVar.amV().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                    break;
                case 3:
                    cVar.amV().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                    break;
                case 5:
                    cVar.amV().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                    break;
                case 6:
                    cVar.amV().put(propertyName, new d(i, jsObject));
                    z = true;
                    break;
                case 7:
                    cVar.amV().put(propertyName, jsObject.toString(i));
                    break;
                case 8:
                    cVar.amV().put(propertyName, jsObject.toJsFunction(i));
                    break;
                case 9:
                    cVar.amV().put(propertyName, c(jsObject.toJsObject(i)));
                    break;
                case 10:
                    cVar.amV().put(propertyName, jsObject.toJsArrayBuffer(i));
                    break;
            }
        }
        if (!z) {
            jsObject.release();
        }
        return cVar;
    }

    private Map<String, Object> amV() {
        if (this.clU == null) {
            this.clU = new TreeMap();
        }
        return this.clU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> amW() {
        if (this.clV == null) {
            this.clV = new TreeMap();
        }
        return this.clV;
    }

    public Set<String> keySet() {
        return amV().keySet();
    }

    public int oy(String str) {
        Integer num = amW().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public boolean oz(String str) {
        return amW().containsKey(str);
    }

    public int length() {
        return amV().size();
    }

    public void put(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            amV().put(str, obj);
        }
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(amV().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(amV().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(amV().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public long optLong(String str, long j) {
        Long l = a.toLong(amV().get(str));
        return l != null ? l.longValue() : j;
    }

    public double getDouble(String str) throws JSTypeMismatchException {
        Double d = a.toDouble(amV().get(str));
        if (d == null) {
            throw a.a(this, str, 5);
        }
        return d.doubleValue();
    }

    public double optDouble(String str, double d) {
        Double d2 = a.toDouble(amV().get(str));
        return d2 != null ? d2.doubleValue() : d;
    }

    public String[] oA(String str) throws JSTypeMismatchException {
        d T = a.T(amV().get(str));
        if (T == null) {
            throw a.a(this, str, 6);
        }
        return T.clW.toStringArray(T.index);
    }

    public String[] oB(String str) {
        return e(str, null);
    }

    public String[] e(String str, String[] strArr) {
        d T = a.T(amV().get(str));
        return T != null ? T.clW.toStringArray(T.index) : strArr;
    }

    public JsObject[] oC(String str) throws JSTypeMismatchException {
        d T = a.T(amV().get(str));
        if (T == null) {
            throw a.a(this, str, 6);
        }
        return T.clW.toObjectArray(T.index);
    }

    public JsObject[] oD(String str) {
        return a(str, (JsObject[]) null);
    }

    public JsObject[] a(String str, JsObject[] jsObjectArr) {
        d T = a.T(amV().get(str));
        return T != null ? T.clW.toObjectArray(T.index) : jsObjectArr;
    }

    public double[] oE(String str) {
        return a(str, (double[]) null);
    }

    public double[] a(String str, double[] dArr) {
        d T = a.T(amV().get(str));
        return T != null ? T.clW.toDoubleArray(T.index) : dArr;
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(amV().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(amV().get(str));
        return aVar != null ? aVar : str2;
    }

    public String toString(String str) {
        return String.valueOf(amV().get(str));
    }

    public JsFunction oF(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction U = a.U(amV().get(str));
        return U != null ? U : jsFunction;
    }

    public c oG(String str) {
        return a(str, (c) null);
    }

    public c a(String str, c cVar) {
        c W = a.W(amV().get(str));
        return W != null ? W : cVar;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer V = a.V(amV().get(str));
        return V != null ? V : jsArrayBuffer;
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

        static d T(Object obj) {
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

        static JsFunction U(Object obj) {
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
            return null;
        }

        static JsArrayBuffer V(Object obj) {
            if (obj instanceof JsArrayBuffer) {
                return (JsArrayBuffer) obj;
            }
            return null;
        }

        static c W(Object obj) {
            if (obj instanceof c) {
                return (c) obj;
            }
            return null;
        }

        static JSTypeMismatchException a(c cVar, String str, int i) {
            int i2;
            if (cVar.amW().containsKey(str)) {
                i2 = ((Integer) cVar.amW().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return amV().toString();
    }
}
