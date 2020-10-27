package com.baidu.swan.games.binding.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, Object> dNg;
    private Map<String, Integer> dNh;

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
            cVar.aRP().put(propertyName, Integer.valueOf(propertyType));
            switch (propertyType) {
                case 1:
                    cVar.aRO().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                    break;
                case 2:
                    cVar.aRO().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                    break;
                case 3:
                    cVar.aRO().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                    break;
                case 5:
                    cVar.aRO().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                    break;
                case 6:
                    cVar.aRO().put(propertyName, new d(i, jsObject));
                    z = true;
                    break;
                case 7:
                    cVar.aRO().put(propertyName, jsObject.toString(i));
                    break;
                case 8:
                    cVar.aRO().put(propertyName, jsObject.toJsFunction(i));
                    break;
                case 9:
                    cVar.aRO().put(propertyName, e(jsObject.toJsObject(i)));
                    break;
                case 10:
                    cVar.aRO().put(propertyName, jsObject.toJsArrayBuffer(i));
                    break;
            }
        }
        if (!z) {
            jsObject.release();
        }
        return cVar;
    }

    private Map<String, Object> aRO() {
        if (this.dNg == null) {
            this.dNg = new TreeMap();
        }
        return this.dNg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> aRP() {
        if (this.dNh == null) {
            this.dNh = new TreeMap();
        }
        return this.dNh;
    }

    public Set<String> keySet() {
        return aRO().keySet();
    }

    public int wj(String str) {
        Integer num = aRP().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public boolean wk(String str) {
        return aRP().containsKey(str);
    }

    public int length() {
        return aRO().size();
    }

    public void put(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            aRO().put(str, obj);
        }
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(aRO().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(aRO().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(aRO().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public long optLong(String str, long j) {
        Long l = a.toLong(aRO().get(str));
        return l != null ? l.longValue() : j;
    }

    public double getDouble(String str) throws JSTypeMismatchException {
        Double d = a.toDouble(aRO().get(str));
        if (d == null) {
            throw a.a(this, str, 5);
        }
        return d.doubleValue();
    }

    public double optDouble(String str, double d) {
        Double d2 = a.toDouble(aRO().get(str));
        return d2 != null ? d2.doubleValue() : d;
    }

    public String[] wl(String str) throws JSTypeMismatchException {
        d ad = a.ad(aRO().get(str));
        if (ad == null) {
            throw a.a(this, str, 6);
        }
        return ad.dNi.toStringArray(ad.index);
    }

    public String[] wm(String str) {
        return f(str, null);
    }

    public String[] f(String str, String[] strArr) {
        d ad = a.ad(aRO().get(str));
        return ad != null ? ad.dNi.toStringArray(ad.index) : strArr;
    }

    public JsObject[] wn(String str) throws JSTypeMismatchException {
        d ad = a.ad(aRO().get(str));
        if (ad == null) {
            throw a.a(this, str, 6);
        }
        return ad.dNi.toObjectArray(ad.index);
    }

    public JsObject[] wo(String str) {
        return a(str, (JsObject[]) null);
    }

    public JsObject[] a(String str, JsObject[] jsObjectArr) {
        d ad = a.ad(aRO().get(str));
        return ad != null ? ad.dNi.toObjectArray(ad.index) : jsObjectArr;
    }

    public double[] wp(String str) {
        return a(str, (double[]) null);
    }

    public double[] a(String str, double[] dArr) {
        d ad = a.ad(aRO().get(str));
        return ad != null ? ad.dNi.toDoubleArray(ad.index) : dArr;
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(aRO().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(aRO().get(str));
        return aVar != null ? aVar : str2;
    }

    public String toString(String str) {
        return String.valueOf(aRO().get(str));
    }

    public JsFunction wq(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction ae = a.ae(aRO().get(str));
        return ae != null ? ae : jsFunction;
    }

    public c wr(String str) {
        return a(str, (c) null);
    }

    public c a(String str, c cVar) {
        c ag = a.ag(aRO().get(str));
        return ag != null ? ag : cVar;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer af = a.af(aRO().get(str));
        return af != null ? af : jsArrayBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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

        static d ad(Object obj) {
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

        static JsFunction ae(Object obj) {
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
            return null;
        }

        static JsArrayBuffer af(Object obj) {
            if (obj instanceof JsArrayBuffer) {
                return (JsArrayBuffer) obj;
            }
            return null;
        }

        static c ag(Object obj) {
            if (obj instanceof c) {
                return (c) obj;
            }
            return null;
        }

        static JSTypeMismatchException a(c cVar, String str, int i) {
            int i2;
            if (cVar.aRP().containsKey(str)) {
                i2 = ((Integer) cVar.aRP().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return aRO().toString();
    }
}
