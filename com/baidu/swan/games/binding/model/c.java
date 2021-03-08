package com.baidu.swan.games.binding.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, Object> egg;
    private Map<String, Integer> egh;

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
                cVar.aVC().put(propertyName, Integer.valueOf(propertyType));
                switch (propertyType) {
                    case 1:
                        cVar.aVB().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i)));
                        break;
                    case 2:
                        cVar.aVB().put(propertyName, Integer.valueOf(jsObject.toInteger(i)));
                        break;
                    case 3:
                        cVar.aVB().put(propertyName, Long.valueOf(jsObject.toLong(i)));
                        break;
                    case 5:
                        cVar.aVB().put(propertyName, Double.valueOf(jsObject.toDouble(i)));
                        break;
                    case 6:
                        cVar.aVB().put(propertyName, new d(i, jsObject));
                        z2 = true;
                        break;
                    case 7:
                        cVar.aVB().put(propertyName, jsObject.toString(i));
                        break;
                    case 8:
                        cVar.aVB().put(propertyName, jsObject.toJsFunction(i));
                        break;
                    case 9:
                        cVar.aVB().put(propertyName, e(jsObject.toJsObject(i)));
                        break;
                    case 10:
                        cVar.aVB().put(propertyName, jsObject.toJsArrayBuffer(i));
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

    private Map<String, Object> aVB() {
        if (this.egg == null) {
            this.egg = new TreeMap();
        }
        return this.egg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Integer> aVC() {
        if (this.egh == null) {
            this.egh = new TreeMap();
        }
        return this.egh;
    }

    public Set<String> keySet() {
        return aVB().keySet();
    }

    public int wn(String str) {
        Integer num = aVC().get(str);
        if (num == null) {
            num = 12;
        }
        return num.intValue();
    }

    public boolean wo(String str) {
        return aVC().containsKey(str);
    }

    public int length() {
        return aVB().size();
    }

    public void put(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            aVB().put(str, obj);
        }
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = a.toBoolean(aVB().get(str));
        return bool != null ? bool.booleanValue() : z;
    }

    public int getInt(String str) throws JSTypeMismatchException {
        Integer integer = a.toInteger(aVB().get(str));
        if (integer == null) {
            throw a.a(this, str, 2);
        }
        return integer.intValue();
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = a.toInteger(aVB().get(str));
        return integer != null ? integer.intValue() : i;
    }

    public long optLong(String str, long j) {
        Long l = a.toLong(aVB().get(str));
        return l != null ? l.longValue() : j;
    }

    public double getDouble(String str) throws JSTypeMismatchException {
        Double d = a.toDouble(aVB().get(str));
        if (d == null) {
            throw a.a(this, str, 5);
        }
        return d.doubleValue();
    }

    public double optDouble(String str, double d) {
        Double d2 = a.toDouble(aVB().get(str));
        return d2 != null ? d2.doubleValue() : d;
    }

    public String[] wp(String str) throws JSTypeMismatchException {
        d ag = a.ag(aVB().get(str));
        if (ag == null) {
            throw a.a(this, str, 6);
        }
        return ag.egi.toStringArray(ag.index);
    }

    public String[] wq(String str) {
        return g(str, null);
    }

    public String[] g(String str, String[] strArr) {
        d ag = a.ag(aVB().get(str));
        return ag != null ? ag.egi.toStringArray(ag.index) : strArr;
    }

    public JsObject[] wr(String str) throws JSTypeMismatchException {
        d ag = a.ag(aVB().get(str));
        if (ag == null) {
            throw a.a(this, str, 6);
        }
        return ag.egi.toObjectArray(ag.index);
    }

    public JsObject[] ws(String str) {
        return a(str, (JsObject[]) null);
    }

    public JsObject[] a(String str, JsObject[] jsObjectArr) {
        d ag = a.ag(aVB().get(str));
        return ag != null ? ag.egi.toObjectArray(ag.index) : jsObjectArr;
    }

    public double[] wt(String str) {
        return a(str, (double[]) null);
    }

    public double[] a(String str, double[] dArr) {
        d ag = a.ag(aVB().get(str));
        return ag != null ? ag.egi.toDoubleArray(ag.index) : dArr;
    }

    public String getString(String str) throws JSTypeMismatchException {
        String aVar = a.toString(aVB().get(str));
        if (aVar == null) {
            throw a.a(this, str, 7);
        }
        return aVar;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String aVar = a.toString(aVB().get(str));
        return aVar != null ? aVar : str2;
    }

    public String toString(String str) {
        return String.valueOf(aVB().get(str));
    }

    public JsFunction wu(String str) {
        return a(str, (JsFunction) null);
    }

    public JsFunction a(String str, JsFunction jsFunction) {
        JsFunction ah = a.ah(aVB().get(str));
        return ah != null ? ah : jsFunction;
    }

    public c wv(String str) {
        return a(str, (c) null);
    }

    public c a(String str, c cVar) {
        c aj = a.aj(aVB().get(str));
        return aj != null ? aj : cVar;
    }

    public JsArrayBuffer a(String str, JsArrayBuffer jsArrayBuffer) {
        JsArrayBuffer ai = a.ai(aVB().get(str));
        return ai != null ? ai : jsArrayBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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

        static d ag(Object obj) {
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

        static JsFunction ah(Object obj) {
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
            return null;
        }

        static JsArrayBuffer ai(Object obj) {
            if (obj instanceof JsArrayBuffer) {
                return (JsArrayBuffer) obj;
            }
            return null;
        }

        static c aj(Object obj) {
            if (obj instanceof c) {
                return (c) obj;
            }
            return null;
        }

        static JSTypeMismatchException a(c cVar, String str, int i) {
            int i2;
            if (cVar.aVC().containsKey(str)) {
                i2 = ((Integer) cVar.aVC().get(str)).intValue();
            } else {
                i2 = 12;
            }
            return new JSTypeMismatchException(str, i2, i, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i), JsObject.typeToString(i2)));
        }
    }

    public String toString() {
        return aVB().toString();
    }
}
