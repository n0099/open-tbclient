package com.baidu.swan.games.binding.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, Object> eeF;
    private Map<String, Integer> eeG;

    public static c e(JsObject jsObject) {
        boolean z = false;
        if (jsObject == null) {
            if (DEBUG) {
                Log.e("JSObjectMap", "parseFromJSObject object is null.");
            }
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            boolean z2 = z;
            if (i < jsObject.length()) {
                int propertyType = jsObject.getPropertyType(i);
                String propertyName = jsObject.getPropertyName(i);
                cVar.aVz().put(propertyName, Integer.valueOf(propertyType));
                switch (propertyType) {
                    case 1:
                        cVar.aVy().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                        break;
                    case 2:
                        cVar.aVy().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                        break;
                    case 3:
                        cVar.aVy().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                        break;
                    case 5:
                        cVar.aVy().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                        break;
                    case 6:
                        cVar.aVy().put(propertyName, new d(i, jsObject));
                        z2 = true;
                        break;
                    case 7:
                        cVar.aVy().put(propertyName, jsObject.toString(i));
                        break;
                    case 8:
                        cVar.aVy().put(propertyName, jsObject.toJsFunction(i));
                        break;
                    case 9:
                        cVar.aVy().put(propertyName, e(jsObject.toJsObject(i)));
                        break;
                    case 10:
                        cVar.aVy().put(propertyName, jsObject.toJsArrayBuffer(i));
                        break;
                }
                z = z2;
                i++;
            } else {
                if (!z2) {
                    jsObject.release();
                }
                return cVar;
            }
        }
    }

    private Map<String, Object> aVy() {
        if (this.eeF == null) {
            this.eeF = new TreeMap();
        }
        return this.eeF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> aVz() {
        if (this.eeG == null) {
            this.eeG = new TreeMap();
        }
        return this.eeG;
    }

    public Set<String> keySet() {
        return aVy().keySet();
    }

    public int wg(String str) {
        Integer num = aVz().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public boolean wh(String str) {
        return aVz().containsKey(str);
    }

    public int length() {
        return aVy().size();
    }

    public void put(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            aVy().put(str, obj);
        }
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(aVy().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(aVy().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(aVy().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public long optLong(String str, long j) {
        Long l = a.toLong(aVy().get(str));
        return l != null ? l.longValue() : j;
    }

    public double getDouble(String str) throws JSTypeMismatchException {
        Double d = a.toDouble(aVy().get(str));
        if (d == null) {
            throw a.a(this, str, 5);
        }
        return d.doubleValue();
    }

    public double optDouble(String str, double d) {
        Double d2 = a.toDouble(aVy().get(str));
        return d2 != null ? d2.doubleValue() : d;
    }

    public String[] wi(String str) throws JSTypeMismatchException {
        d ae = a.ae(aVy().get(str));
        if (ae == null) {
            throw a.a(this, str, 6);
        }
        return ae.eeH.toStringArray(ae.index);
    }

    public String[] wj(String str) {
        return g(str, null);
    }

    public String[] g(String str, String[] strArr) {
        d ae = a.ae(aVy().get(str));
        return ae != null ? ae.eeH.toStringArray(ae.index) : strArr;
    }

    public JsObject[] wk(String str) throws JSTypeMismatchException {
        d ae = a.ae(aVy().get(str));
        if (ae == null) {
            throw a.a(this, str, 6);
        }
        return ae.eeH.toObjectArray(ae.index);
    }

    public JsObject[] wl(String str) {
        return a(str, (JsObject[]) null);
    }

    public JsObject[] a(String str, JsObject[] jsObjectArr) {
        d ae = a.ae(aVy().get(str));
        return ae != null ? ae.eeH.toObjectArray(ae.index) : jsObjectArr;
    }

    public double[] wm(String str) {
        return a(str, (double[]) null);
    }

    public double[] a(String str, double[] dArr) {
        d ae = a.ae(aVy().get(str));
        return ae != null ? ae.eeH.toDoubleArray(ae.index) : dArr;
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(aVy().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(aVy().get(str));
        return aVar != null ? aVar : str2;
    }

    public String toString(String str) {
        return String.valueOf(aVy().get(str));
    }

    public JsFunction wn(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction af = a.af(aVy().get(str));
        return af != null ? af : jsFunction;
    }

    public c wo(String str) {
        return a(str, (c) null);
    }

    public c a(String str, c cVar) {
        c ah = a.ah(aVy().get(str));
        return ah != null ? ah : cVar;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer ag = a.ag(aVy().get(str));
        return ag != null ? ag : jsArrayBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
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

        static d ae(Object obj) {
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

        static JsFunction af(Object obj) {
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
            return null;
        }

        static JsArrayBuffer ag(Object obj) {
            if (obj instanceof JsArrayBuffer) {
                return (JsArrayBuffer) obj;
            }
            return null;
        }

        static c ah(Object obj) {
            if (obj instanceof c) {
                return (c) obj;
            }
            return null;
        }

        static JSTypeMismatchException a(c cVar, String str, int i) {
            int i2;
            if (cVar.aVz().containsKey(str)) {
                i2 = ((Integer) cVar.aVz().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return aVy().toString();
    }
}
