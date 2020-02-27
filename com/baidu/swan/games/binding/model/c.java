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
    private Map<String, Object> clT;
    private Map<String, Integer> clU;

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
            cVar.amU().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    cVar.amT().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                    break;
                case 2:
                    cVar.amT().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                    break;
                case 3:
                    cVar.amT().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                    break;
                case 5:
                    cVar.amT().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                    break;
                case 6:
                    cVar.amT().put(propertyName, new d(i, jsObject));
                    z = true;
                    break;
                case 7:
                    cVar.amT().put(propertyName, jsObject.toString(i));
                    break;
                case 8:
                    cVar.amT().put(propertyName, jsObject.toJsFunction(i));
                    break;
                case 9:
                    cVar.amT().put(propertyName, c(jsObject.toJsObject(i)));
                    break;
                case 10:
                    cVar.amT().put(propertyName, jsObject.toJsArrayBuffer(i));
                    break;
            }
        }
        if (!z) {
            jsObject.release();
        }
        return cVar;
    }

    private Map<String, Object> amT() {
        if (this.clT == null) {
            this.clT = new TreeMap();
        }
        return this.clT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> amU() {
        if (this.clU == null) {
            this.clU = new TreeMap();
        }
        return this.clU;
    }

    public Set<String> keySet() {
        return amT().keySet();
    }

    public int oy(String str) {
        Integer num = amU().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public boolean oz(String str) {
        return amU().containsKey(str);
    }

    public int length() {
        return amT().size();
    }

    public void put(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            amT().put(str, obj);
        }
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(amT().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(amT().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(amT().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public long optLong(String str, long j) {
        Long l = a.toLong(amT().get(str));
        return l != null ? l.longValue() : j;
    }

    public double getDouble(String str) throws JSTypeMismatchException {
        Double d = a.toDouble(amT().get(str));
        if (d == null) {
            throw a.a(this, str, 5);
        }
        return d.doubleValue();
    }

    public double optDouble(String str, double d) {
        Double d2 = a.toDouble(amT().get(str));
        return d2 != null ? d2.doubleValue() : d;
    }

    public String[] oA(String str) throws JSTypeMismatchException {
        d T = a.T(amT().get(str));
        if (T == null) {
            throw a.a(this, str, 6);
        }
        return T.clV.toStringArray(T.index);
    }

    public String[] oB(String str) {
        return e(str, null);
    }

    public String[] e(String str, String[] strArr) {
        d T = a.T(amT().get(str));
        return T != null ? T.clV.toStringArray(T.index) : strArr;
    }

    public JsObject[] oC(String str) throws JSTypeMismatchException {
        d T = a.T(amT().get(str));
        if (T == null) {
            throw a.a(this, str, 6);
        }
        return T.clV.toObjectArray(T.index);
    }

    public JsObject[] oD(String str) {
        return a(str, (JsObject[]) null);
    }

    public JsObject[] a(String str, JsObject[] jsObjectArr) {
        d T = a.T(amT().get(str));
        return T != null ? T.clV.toObjectArray(T.index) : jsObjectArr;
    }

    public double[] oE(String str) {
        return a(str, (double[]) null);
    }

    public double[] a(String str, double[] dArr) {
        d T = a.T(amT().get(str));
        return T != null ? T.clV.toDoubleArray(T.index) : dArr;
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(amT().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(amT().get(str));
        return aVar != null ? aVar : str2;
    }

    public String toString(String str) {
        return String.valueOf(amT().get(str));
    }

    public JsFunction oF(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction U = a.U(amT().get(str));
        return U != null ? U : jsFunction;
    }

    public c oG(String str) {
        return a(str, (c) null);
    }

    public c a(String str, c cVar) {
        c W = a.W(amT().get(str));
        return W != null ? W : cVar;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer V = a.V(amT().get(str));
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
            if (cVar.amU().containsKey(str)) {
                i2 = ((Integer) cVar.amU().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return amT().toString();
    }
}
